package io.openslice.tmf.scm.sc.reposervices;

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

import io.openslice.tmf.scm.model.ELifecycle;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;

@Service
public class CategoryRepoService {


	@Autowired
	CategoriesRepository categsRepo;
	


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
		return (List<ServiceCategory>) this.categsRepo.findAll();
	}

	public ServiceCategory findById(String id) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findById( id );
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
		        
		        tx.commit();
		    } finally {
		        session.close();
		    }
		    return dd;
	}
	
	
	
	

	public Void deleteById(String id) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findById( id );
		this.categsRepo.delete( optionalCat.get());
		return null;
		
	}

	public ServiceCategory updateCategory(String id, @Valid ServiceCategoryUpdate serviceCategory) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findById( id );
		if ( optionalCat == null ) {
			return null;
		}
		
		ServiceCategory sc = optionalCat.get();
		sc = updateCategoryDataFromAPICall(sc, serviceCategory);
		return this.categsRepo.save( sc );
	}
	
	public ServiceCategory updateCategoryDataFromAPICall( ServiceCategory sc, ServiceCategoryUpdate serviceCategory )
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
		} else {
			tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
			tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );			
		}
		sc.setValidFor( tp );
		return sc;
	}


}
