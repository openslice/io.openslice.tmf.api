package io.openslice.tmf.scm.sc.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.scm.model.ELifecycle;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceCatalogCreate;
import io.openslice.tmf.scm.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;

@Service
public class CatalogRepoService {


	@Autowired
	CatalogRepository catalogRepo;	
	

	@Autowired
	CategoryRepoService categRepoService;	

	
	public ServiceCatalog addCatalog(ServiceCatalog c) {

		return this.catalogRepo.save( c );
	}

	public ServiceCatalog addCatalog(@Valid ServiceCatalogCreate serviceCat) {	
		
		ServiceCatalog sc = new ServiceCatalog() ;
		sc.setName( serviceCat.getName() );
		sc.setDescription( serviceCat.getDescription() );
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		if ( serviceCat.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCat.getLifecycleStatus() ) );
		}
		sc.setVersion( serviceCat.getVersion());
		TimePeriod tp = new TimePeriod();
		tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
		tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );
		sc.setValidFor( tp );
		
		
		return this.catalogRepo.save( sc );
	}

	public List<ServiceCatalog> findAll() {
		return (List<ServiceCatalog>) this.catalogRepo.findAll();
	}

	public ServiceCatalog findById(String id) {
		Optional<ServiceCatalog> optionalCat = this.catalogRepo.findById( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceCatalog> optionalCat = this.catalogRepo.findById( id );
		this.catalogRepo.delete( optionalCat.get());
		return null;
		
	}
	
	@PostConstruct
	public void initRepo() {
		if ( this.findAll().size() == 0 ) {
			ServiceCatalogCreate sc = new ServiceCatalogCreate() ;
			sc.setName( "Catalog" );
			sc.setDescription( "Primary Catalog" );
			sc.setVersion( "1.0" );		
			ServiceCatalog scatalog = this.addCatalog(sc);
			
			ServiceCategoryCreate scatCreate = new ServiceCategoryCreate();
			scatCreate.setName("Generic Services");
			scatCreate.setDescription("Generic Services of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot( true );
			ServiceCategory scategory = this.categRepoService.addCategory(scatCreate);
			
			
			
			ServiceCategoryRef scatRef = new ServiceCategoryRef();
			scatRef.setId( scategory.getId() );
			scatRef.setName( scategory.getName() );
			scatalog.getCategory().add( scatRef  );
			this.catalogRepo.save(scatalog);
			
			
		}
	}

	public ServiceCatalog updateCatalog(String id,  ServiceCatalogUpdate serviceCatalog) {

		Optional<ServiceCatalog> optSC = catalogRepo.findById( id );		
		if ( optSC == null ) {
			return null;
		}
		ServiceCatalog sc = optSC.get();
		sc.setName( serviceCatalog.getName()  );
		sc.setLifecycleStatus( serviceCatalog.getLifecycleStatus() );
		sc.setVersion( serviceCatalog.getVersion() );
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		tp.setStartDateTime( serviceCatalog.getValidFor().getStartDateTime() );
		tp.setEndDateTime( serviceCatalog.getValidFor().getEndDateTime() );
		sc.setValidFor( tp );
				
		for (ServiceCategoryRef scref : serviceCatalog.getCategory()) {
			if (!sc.containsCategory( scref)){
				sc.getCategory().add( scref );				
			}
		}
		
		return this.catalogRepo.save( sc );
	}

}
