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
package io.openslice.tmf.scm633.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import io.openslice.tmf.scm633.model.ServiceCandidate;
import io.openslice.tmf.scm633.model.ServiceCandidateRef;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm633.repo.CandidateRepository;
import io.openslice.tmf.scm633.repo.CatalogRepository;
import io.openslice.tmf.scm633.repo.CategoriesRepository;

@Service
public class CategoryRepoService {


	@Autowired
	CategoriesRepository categsRepo;
	

	@Autowired
	CandidateRepository candidateRepo;


	@Autowired
	CatalogRepository catalogRepo;
	

	private SessionFactory  sessionFactory;
	
	/**
	 * from https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
	 * @param factory
	 */
	@Autowired
	public CategoryRepoService(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	        throw new NullPointerException("factory is not a hibernate factory");
	      }
	      this.sessionFactory = factory.unwrap(SessionFactory.class);
	    }

	
	public ServiceCategory addCategory(ServiceCategory c) {

		return this.categsRepo.save( c );
	}

	public ServiceCategory addCategory(@Valid ServiceCategoryCreate serviceCategory) {	
		
		
		ServiceCategory sc = new ServiceCategory() ;
		sc = updateCategoryDataFromAPICall(sc, serviceCategory);
		return this.categsRepo.save( sc );
		
	}

	public List<ServiceCategory> findAll() {
		return (List<ServiceCategory>) this.categsRepo.findByOrderByName();
	}

	public ServiceCategory findByUuid(String id) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}
	

	public ServiceCategory findByIdEager(String id) {
//		Optional<ServiceCategory> optionalCat = this.categsRepo.findByIdEager( id );
//		return optionalCat
//				.orElse(null);
		
		 Session session = sessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    ServiceCategory dd = null;
		    try {
		        dd = (ServiceCategory) session.get(ServiceCategory.class, id);
		        Hibernate.initialize( dd.getCategoryObj()  );
		        Hibernate.initialize( dd.getServiceCandidateObj() );
		        for (ServiceCandidate sc : dd.getServiceCandidateObj()) {
			        Hibernate.initialize(sc );
			        Hibernate.initialize(sc.getCategoryObj() );
				}
		        
		        tx.commit();
		    } finally {
		        session.close();
		    }
		    return dd;
	}
	
	
	
	

	public boolean deleteById(String id) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findByUuid( id );
		if ( optionalCat.get().getCategoryObj().size()>0 ) {
			return false; //has children
		}
		
		
		if ( optionalCat.get().getParentId() != null ) {
			ServiceCategory parentCat = (this.categsRepo.findByUuid( optionalCat.get().getParentId() )).get();
			
			//remove from parent category
			for (ServiceCategory ss : parentCat.getCategoryObj()) {
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

	public ServiceCategory updateCategory(String id, @Valid ServiceCategoryUpdate serviceCategory) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findByUuid( id );
		if ( optionalCat == null ) {
			return null;
		}
		
		ServiceCategory sc = optionalCat.get();
		sc = updateCategoryDataFromAPICall(sc, serviceCategory);
		return this.categsRepo.save( sc );
	}
	
	public ServiceCategory updateCategoryDataFromAPICall( ServiceCategory sc, ServiceCategoryUpdate serviceCatUpd )
	{		
		if (serviceCatUpd.getName()!=null) {
			sc.setName( serviceCatUpd.getName()  );			
		}
		if (serviceCatUpd.getDescription()!=null) {
			sc.setDescription( serviceCatUpd.getDescription());			
		}
		if ( serviceCatUpd.isIsRoot() != null  ) {
			sc.setIsRoot( serviceCatUpd.isIsRoot());			
		}
		
		if ( serviceCatUpd.getLifecycleStatus() != null ) {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCatUpd.getLifecycleStatus() ) );
		}
		

		if ( serviceCatUpd.getVersion() != null ) {
			sc.setVersion( serviceCatUpd.getVersion() );		
		}
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		if ( serviceCatUpd.getValidFor() != null ) {
			tp.setStartDateTime( serviceCatUpd.getValidFor().getStartDateTime() );
			tp.setEndDateTime( serviceCatUpd.getValidFor().getEndDateTime() );
			sc.setValidFor( tp );
		} 
		
		if ( serviceCatUpd.getCategory() !=null ) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ServiceCategoryRef ref : serviceCatUpd.getCategory() ) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ServiceCategory originalSCat : sc.getCategoryObj()) {
					if ( originalSCat.getId().equals( ref.getId())) {
						idexists = true;
						idAddedUpdated.put( originalSCat.getId(), true);
						break;
					}					
				}
				if (!idexists) {
					Optional<ServiceCategory> catToAdd = this.categsRepo.findByUuid( ref.getId() );
					if ( catToAdd.isPresent() ) {
						ServiceCategory scatadd = catToAdd.get();
						sc.getCategoryObj().add( scatadd );
						idAddedUpdated.put( ref.getId(), true);		
						
						scatadd.setParentId( sc.getUuid());
						scatadd = this.categsRepo.save( scatadd );
					}
				}
			}
			List<ServiceCategory> toRemove = new ArrayList<>();
			for (ServiceCategory ss : sc.getCategoryObj()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ServiceCategory ar : toRemove) {
				sc.getCategoryObj().remove(ar);
			}
		}
		
		
		if ( serviceCatUpd.getServiceCandidate() !=null ) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ServiceCandidateRef ref : serviceCatUpd.getServiceCandidate() ) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ServiceCandidate originalSCat : sc.getServiceCandidateObj()) {
					if ( originalSCat.getId().equals( ref.getId())) {
						idexists = true;
						idAddedUpdated.put( originalSCat.getId(), true);
						break;
					}					
				}
				if (!idexists) {
					Optional<ServiceCandidate> catToAdd = this.candidateRepo.findByUuid( ref.getId() );
					if ( catToAdd.isPresent() ) {
						ServiceCandidate scatadd = catToAdd.get();
						sc.getServiceCandidateObj().add( scatadd );
						idAddedUpdated.put( ref.getId(), true);		
												
					}
				}
			}
			List<ServiceCandidate> toRemove = new ArrayList<>();
			for (ServiceCandidate ss : sc.getServiceCandidateObj()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ServiceCandidate ar : toRemove) {
				sc.getServiceCandidateObj().remove(ar);
			}
		}
		
		return sc;
	}


	public ServiceCategory findByName(String aName) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findByName( aName );
		return optionalCat
				.orElse(null);
	}


}
