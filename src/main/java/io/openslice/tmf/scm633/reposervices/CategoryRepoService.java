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
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.scm633.model.ServiceCandidate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm633.repo.CatalogRepository;
import io.openslice.tmf.scm633.repo.CategoriesRepository;

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
		sc.setName( serviceCatUpd.getName()  );
		sc.setDescription( serviceCatUpd.getDescription());
		sc.setIsRoot( serviceCatUpd.isIsRoot());
		if ( serviceCatUpd.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCatUpd.getLifecycleStatus() ) );
		}
		

		if ( serviceCatUpd.getVersion() == null ) {
			sc.setVersion( "1.0.0" );			
		} else {
			sc.setVersion( serviceCatUpd.getVersion() );		
		}
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		if ( serviceCatUpd.getValidFor() != null ) {
			tp.setStartDateTime( serviceCatUpd.getValidFor().getStartDateTime() );
			tp.setEndDateTime( serviceCatUpd.getValidFor().getEndDateTime() );
		} 
		sc.setValidFor( tp );
		
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
		
		
		
		return sc;
	}


	public ServiceCategory findByName(String aName) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findByName( aName );
		return optionalCat
				.orElse(null);
	}


}
