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
import io.openslice.tmf.scm.model.ServiceCandidate;
import io.openslice.tmf.scm.model.ServiceCandidateCreate;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceCatalogCreate;
import io.openslice.tmf.scm.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.ServiceSpecificationRef;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;

@Service
public class CatalogRepoService {


	@Autowired
	CatalogRepository catalogRepo;	
	

	@Autowired
	CategoryRepoService categRepoService;	

	@Autowired
	ServiceSpecificationRepoService specRepoService;

	@Autowired
	CandidateRepoService candidateRepoService;

	
	public ServiceCatalog addCatalog(ServiceCatalog c) {

		return this.catalogRepo.save( c );
	}

	public ServiceCatalog addCatalog(@Valid ServiceCatalogCreate serviceCat) {	
		
		ServiceCatalog sc = new ServiceCatalog() ;

		sc = updateCatalogDataFromAPICall( sc, serviceCat );
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
	
	public ServiceCatalog updateCatalog(String id,  ServiceCatalogUpdate serviceCatalog) {

		Optional<ServiceCatalog> optSC = catalogRepo.findById( id );		
		if ( optSC == null ) {
			return null;
		}
		ServiceCatalog sc = optSC.get();
		sc = updateCatalogDataFromAPICall( sc, serviceCatalog );
		return this.catalogRepo.save( sc );
	}
	
	
	public ServiceCatalog updateCatalogDataFromAPICall( ServiceCatalog sc, ServiceCatalogUpdate serviceCatalog)
	{
		sc.setName( serviceCatalog.getName()  );
		sc.setDescription( serviceCatalog.getDescription());
		if ( serviceCatalog.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCatalog.getLifecycleStatus() ) );
		}
		if ( serviceCatalog.getVersion() == null ) {
			sc.setVersion( "1.0.0" );			
		} else {
			sc.setVersion( serviceCatalog.getVersion() );			
		}
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		if ( serviceCatalog.getValidFor() != null ) {
			tp.setStartDateTime( serviceCatalog.getValidFor().getStartDateTime() );
			tp.setEndDateTime( serviceCatalog.getValidFor().getEndDateTime() );	
		} else {
			tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
			tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );			
		}
		sc.setValidFor( tp );
		
		sc.getCategoryObj().clear();
		
		//add any new category
		if ( serviceCatalog.getCategory() != null ) {
			for (ServiceCategoryRef scref : serviceCatalog.getCategory()) {
				ServiceCategory servcat = this.categRepoService.findById( scref.getId() );
				sc.addCategory( servcat );
			}			
		}
		
		return sc;
		
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
			
			scatalog.getCategoryObj().add( scategory  );
			this.catalogRepo.save(scatalog);
			
			
			ServiceSpecificationCreate spec = new ServiceSpecificationCreate();
			spec.setName("GST");
			sc.setDescription( "GST example" );
			ServiceSpecification serviceSpecificationObj = this.specRepoService.addServiceSpecification( spec );
			
			ServiceCandidateCreate scand = new ServiceCandidateCreate();
			scand.setName( spec.getName() );
			ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
			serviceSpecificationRef.setId( serviceSpecificationObj.getId() );
			serviceSpecificationRef.setName( serviceSpecificationObj.getName());
			scand.serviceSpecification(serviceSpecificationRef );

			ServiceCategoryRef categoryItem = new ServiceCategoryRef();
			categoryItem.setId( scategory.getId() );
			scand.addCategoryItem(categoryItem );
			
			this.candidateRepoService.addServiceCandidate( scand );
		}
	}

}
