package io.openslice.tmf.rcm634.reposervices;

import java.time.OffsetDateTime;

import java.time.ZoneOffset;
import java.util.List;
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
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryUpdate;
import io.openslice.tmf.rcm634.repo.ResourceCatalogRepository;
import io.openslice.tmf.rcm634.repo.ResourceCategoriesRepository;

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
		        
		        tx.commit();
		    } finally {
		        session.close();
		    }
		    return dd;
	}
	
	
	
	

	public Void deleteById(String id) {
		Optional<ResourceCategory> optionalCat = this.categsRepo.findByUuid( id );
		this.categsRepo.delete( optionalCat.get());
		return null;
		
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
	
	public ResourceCategory updateCategoryDataFromAPICall( ResourceCategory sc, ResourceCategoryUpdate serviceCategory )
	{		
		sc.setName( serviceCategory.getName()  );
		sc.setDescription( serviceCategory.getDescription());
		if ( serviceCategory.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCategory.getLifecycleStatus() ) );
		}
		

		if ( serviceCategory.getVersion() == null ) {
			sc.setVersion( "1.0.0" );			
		} else {
			sc.setVersion( serviceCategory.getVersion() );		
		}
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		if ( serviceCategory.getValidFor() != null ) {
			tp.setStartDateTime( serviceCategory.getValidFor().getStartDateTime() );
			tp.setEndDateTime( serviceCategory.getValidFor().getEndDateTime() );
		} 
		sc.setValidFor( tp );
		return sc;
	}


}
