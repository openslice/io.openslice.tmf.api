/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.pcm620.reposervices;

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
import io.openslice.tmf.pcm620.model.Category;
import io.openslice.tmf.pcm620.model.CategoryCreate;
import io.openslice.tmf.pcm620.model.CategoryRef;
import io.openslice.tmf.pcm620.model.CategoryUpdate;
import io.openslice.tmf.pcm620.model.ProductOffering;
import io.openslice.tmf.pcm620.model.ProductOfferingRef;
import io.openslice.tmf.pcm620.repo.ProductCatalogRepository;
import io.openslice.tmf.pcm620.repo.ProductCategoriesRepository;
import io.openslice.tmf.pcm620.repo.ProductOfferingRepository;

@Service
public class ProductCategoryRepoService {

	@Autowired
	ProductCategoriesRepository categsRepo;

	@Autowired
	ProductCatalogRepository catalogRepo;
	
	@Autowired
	ProductOfferingRepository prodsOfferingRepo;

	private SessionFactory sessionFactory;

	/**
	 * from
	 * https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
	 * 
	 * @param factory
	 */
	@Autowired
	public ProductCategoryRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	
	public Category addCategory(Category c) {

		return this.categsRepo.save( c );
	}

	public Category addCategory(@Valid CategoryCreate Category) {	
		
		
		Category sc = new Category() ;
		sc = updateCategoryDataFromAPICall(sc, Category);
		return this.categsRepo.save( sc );
		
	}

	public List<Category> findAll() {
		return (List<Category>) this.categsRepo.findByOrderByName();
	}

	public Category findByUuid(String id) {
		Optional<Category> optionalCat = this.categsRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}
	

	public Category findByIdEager(String id) {
//		Optional<Category> optionalCat = this.categsRepo.findByIdEager( id );
//		return optionalCat
//				.orElse(null);
		
		 Session session = sessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    Category dd = null;
		    try {
		        dd = (Category) session.get(Category.class, id);
		        Hibernate.initialize( dd.getCategoryObj()  );
		        Hibernate.initialize( dd.getProductOfferingRefs() );
		        for (ProductOfferingRef sc : dd.getProductOfferingRefs()) {
			        Hibernate.initialize(sc );
				}
		        
		        tx.commit();
		    } finally {
		        session.close();
		    }
		    return dd;
	}
	
	
	
	

	public boolean deleteById(String id) {
		Optional<Category> optionalCat = this.categsRepo.findByUuid( id );
		if ( optionalCat.get().getCategoryObj().size()>0 ) {
			return false; //has children
		}
		
		
		if ( optionalCat.get().getParentId() != null ) {
			Category parentCat = (this.categsRepo.findByUuid( optionalCat.get().getParentId() )).get();
			
			//remove from parent category
			for (Category ss : parentCat.getCategoryObj()) {
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

	public Category updateCategory(String id, @Valid CategoryUpdate Category) {
		Optional<Category> optionalCat = this.categsRepo.findByUuid( id );
		if ( optionalCat == null ) {
			return null;
		}
		
		Category sc = optionalCat.get();
		sc = updateCategoryDataFromAPICall(sc, Category);
		return this.categsRepo.save( sc );
	}
	
	public Category updateCategoryDataFromAPICall( Category acat, CategoryUpdate prodCatUpd )
	{		
		if (prodCatUpd.getName()!=null) {
			acat.setName( prodCatUpd.getName()  );			
		}
		if (prodCatUpd.getDescription()!=null) {
			acat.setDescription( prodCatUpd.getDescription());			
		}
		if ( prodCatUpd.isIsRoot() != null  ) {
			acat.setIsRoot( prodCatUpd.isIsRoot());			
		}
		
		if ( prodCatUpd.getLifecycleStatus() != null ) {
			acat.setLifecycleStatusEnum ( ELifecycle.getEnum( prodCatUpd.getLifecycleStatus() ) );
		}
		

		if ( prodCatUpd.getVersion() != null ) {
			acat.setVersion( prodCatUpd.getVersion() );		
		}
		acat.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		if ( prodCatUpd.getValidFor() != null ) {
			tp.setStartDateTime( prodCatUpd.getValidFor().getStartDateTime() );
			tp.setEndDateTime( prodCatUpd.getValidFor().getEndDateTime() );
			acat.setValidFor( tp );
		} 
		
		if ( prodCatUpd.getProductOffering() != null ) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			for (ProductOfferingRef por : prodCatUpd.getProductOffering()) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ProductOfferingRef originalProfOffRef : acat.getProductOfferingRefs()) {
					if ( originalProfOffRef.getId().equals( por.getId())) {
						idexists = true;
						idAddedUpdated.put( originalProfOffRef.getId(), true);
						break;
					}					
				}
				if (!idexists) {
					Optional<ProductOffering> profOffToAdd = this.prodsOfferingRepo.findByUuid( por.getId() );
					if ( profOffToAdd.isPresent() ) {
						ProductOffering poffget = profOffToAdd.get();
						
							
						acat.getProductOfferingObj().add(poffget);						
						idAddedUpdated.put( poffget.getId(), true);
						
						
						
					}
				}				
			}
			List<ProductOfferingRef> toRemove = new ArrayList<>();
			for (ProductOfferingRef ss : acat.getProductOfferingRefs()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ProductOfferingRef ar : toRemove) {
				acat.getProductOfferingRefs().remove(ar);
			}
			
		}
				
				
		if ( prodCatUpd.getSubCategory() !=null ) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (CategoryRef ref : prodCatUpd.getSubCategory() ) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (Category originalSCat : acat.getCategoryObj()) {
					if ( originalSCat.getId().equals( ref.getId())) {
						idexists = true;
						idAddedUpdated.put( originalSCat.getId(), true);
						break;
					}					
				}
				if (!idexists) {
					Optional<Category> catToAdd = this.categsRepo.findByUuid( ref.getId() );
					if ( catToAdd.isPresent() ) {
						Category scatadd = catToAdd.get();
						acat.getCategoryObj().add( scatadd );
						idAddedUpdated.put( ref.getId(), true);		
						
						scatadd.setParentId( acat.getUuid());
						scatadd = this.categsRepo.save( scatadd );
					}
				}
			}
			List<Category> toRemove = new ArrayList<>();
			for (Category ss : acat.getCategoryObj()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (Category ar : toRemove) {
				acat.getCategoryObj().remove(ar);
			}
		}
		
		
//		if ( prodCatUpd.getServiceCandidate() !=null ) {
//			//reattach fromDB
//			Map<String, Boolean> idAddedUpdated = new HashMap<>();
//			
//			for (ServiceCandidateRef ref : prodCatUpd.getServiceCandidate() ) {
//				//find  by id and reload it here.
//				boolean idexists = false;
//				for (ServiceCandidate originalSCat : acat.getServiceCandidateObj()) {
//					if ( originalSCat.getId().equals( ref.getId())) {
//						idexists = true;
//						idAddedUpdated.put( originalSCat.getId(), true);
//						break;
//					}					
//				}
//				if (!idexists) {
//					Optional<ServiceCandidate> catToAdd = this.candidateRepo.findByUuid( ref.getId() );
//					if ( catToAdd.isPresent() ) {
//						ServiceCandidate scatadd = catToAdd.get();
//						acat.getServiceCandidateObj().add( scatadd );
//						idAddedUpdated.put( ref.getId(), true);		
//												
//					}
//				}
//			}
//			List<ServiceCandidate> toRemove = new ArrayList<>();
//			for (ServiceCandidate ss : acat.getServiceCandidateObj()) {
//				if ( idAddedUpdated.get( ss.getId() ) == null ) {
//					toRemove.add(ss);
//				}
//			}
//			
//			for (ServiceCandidate ar : toRemove) {
//				acat.getServiceCandidateObj().remove(ar);
//			}
//		}
		
		return acat;
	}


	public Category findByName(String aName) {
		Optional<Category> optionalCat = this.categsRepo.findByName( aName );
		return optionalCat
				.orElse(null);
	}
}
