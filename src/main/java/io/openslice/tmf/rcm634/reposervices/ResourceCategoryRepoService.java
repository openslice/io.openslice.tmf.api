/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.rcm634.reposervices;

import java.time.OffsetDateTime;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntPredicate;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceCategoryUpdate;
import io.openslice.tmf.rcm634.repo.ResourceCatalogRepository;
import io.openslice.tmf.rcm634.repo.ResourceCategoriesRepository;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;

@Service
public class ResourceCategoryRepoService {


	@Autowired
	ResourceCategoriesRepository categsRepo;
	


	@Autowired
	ResourceCatalogRepository catalogRepo;
	

	private SessionFactory  sessionFactory;
	
	/**
	 * from https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
	 * @param factory
	 */
	@Autowired
	public ResourceCategoryRepoService(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	        throw new NullPointerException("factory is not a hibernate factory");
	      }
	      this.sessionFactory = factory.unwrap(SessionFactory.class);
	    }

	
	public ResourceCategory addCategory(ResourceCategory c) {

		return this.categsRepo.save( c );
	}

	public ResourceCategory addCategory(@Valid ResourceCategoryCreate resCategory) {	
		
		
		ResourceCategory sc = new ResourceCategory() ;
		sc = updateCategoryDataFromAPICall(sc, resCategory);
		return this.categsRepo.save( sc );
		
	}

	public List<ResourceCategory> findAll() {
		return (List<ResourceCategory>) this.categsRepo.findAll();
	}

	public ResourceCategory findByUuid(String id) {
		Optional<ResourceCategory> optionalCat = this.categsRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}
	

	public ResourceCategory findByIdEager(String id) {
//		Optional<ResourceCategory> optionalCat = this.categsRepo.findByIdEager( id );
//		return optionalCat
//				.orElse(null);
		
		 Session session = sessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    ResourceCategory dd = null;
		    try {
		        dd = (ResourceCategory) session.get(ResourceCategory.class, id);
		        Hibernate.initialize( dd.getCategoryObj()  );
		        Hibernate.initialize( dd.getResourceCandidateObj() );
		        for (ResourceCandidate rc : dd.getResourceCandidateObj()) {
			        Hibernate.initialize(rc );
			        Hibernate.initialize(rc.getCategoryObj() );
					
				}
		        
		        tx.commit();
		    } finally {
		        session.close();
		    }
		    return dd;
	}
	
	
	
	

	public boolean deleteById(String id) {
		Optional<ResourceCategory> optionalCat = this.categsRepo.findByUuid( id );
		
		if ( optionalCat.get().getCategoryObj().size()>0 ) {
			return false; //has children
		}
		
		if ( optionalCat.get().getParentId() != null ) {
			ResourceCategory parentCat = (this.categsRepo.findByUuid( optionalCat.get().getParentId() )).get();
			
			//remove from parent category
			for (ResourceCategory ss : parentCat.getCategoryObj()) {
				if  ( ss.getId()  == optionalCat.get().getId() ) {
					 parentCat.getCategoryObj().remove(ss);
					 break;
				}
			}			
			parentCat = this.categsRepo.save(parentCat);
		}
		
		
		this.categsRepo.delete( optionalCat.get());
		return true;
		
	}

	public ResourceCategory updateCategory(String id, @Valid ResourceCategoryUpdate serviceCategory) {
		Optional<ResourceCategory> optionalCat = this.categsRepo.findByUuid( id );
		if ( optionalCat == null ) {
			return null;
		}
		
		ResourceCategory sc = optionalCat.get();
		sc = updateCategoryDataFromAPICall(sc, serviceCategory);
		return this.categsRepo.save( sc );
	}
	
	public ResourceCategory updateCategoryDataFromAPICall( ResourceCategory sc, ResourceCategoryUpdate resCatUpd )
	{		
		if (resCatUpd.getName()!=null){
			sc.setName( resCatUpd.getName()  );			
		}
		if ( resCatUpd.getDescription() != null){
			sc.setDescription( resCatUpd.getDescription());			
		}
		
		if ( resCatUpd.isIsRoot() != null ){
			sc.setIsRoot( resCatUpd.isIsRoot());			
		}
		if ( resCatUpd.getLifecycleStatus() != null ) {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( resCatUpd.getLifecycleStatus() ) );
		}
		

		if ( resCatUpd.getVersion() != null ) {
			sc.setVersion( resCatUpd.getVersion() );		
		}
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		if ( resCatUpd.getValidFor() != null ) {
			tp.setStartDateTime( resCatUpd.getValidFor().getStartDateTime() );
			tp.setEndDateTime( resCatUpd.getValidFor().getEndDateTime() );
			sc.setValidFor( tp );
		} 
		
		if ( resCatUpd.getCategory() !=null ) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ResourceCategoryRef ref : resCatUpd.getCategory() ) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ResourceCategory originalSCat : sc.getCategoryObj()) {
					if ( originalSCat.getId().equals( ref.getId())) {
						idexists = true;
						idAddedUpdated.put( originalSCat.getId(), true);
						break;
					}					
				}
				if (!idexists) {
					Optional<ResourceCategory> catToAdd = this.categsRepo.findByUuid( ref.getId() );
					if ( catToAdd.isPresent() ) {
						ResourceCategory scatadd = catToAdd.get();
						sc.getCategoryObj().add( scatadd );
						idAddedUpdated.put( ref.getId(), true);		
						
						scatadd.setParentId( sc.getUuid());
						scatadd = this.categsRepo.save( scatadd );
					}
				}
			}
			List<ResourceCategory> toRemove = new ArrayList<>();
			for (ResourceCategory ss : sc.getCategoryObj()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ResourceCategory ar : toRemove) {
				sc.getCategoryObj().remove(ar);
			}
		}
		
		
		
		return sc;
	}


	public ResourceCategory findByName(String aName) {
		Optional<ResourceCategory> optionalCat = this.categsRepo.findByName( aName );
		return optionalCat
				.orElse(null);
	}


}
