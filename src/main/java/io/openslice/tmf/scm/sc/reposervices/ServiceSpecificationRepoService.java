package io.openslice.tmf.scm.sc.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.scm.model.AttachmentRef;
import io.openslice.tmf.scm.model.ELifecycle;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;
import io.openslice.tmf.scm.sc.repo.ServiceSpecificationRepository;

@Service
public class ServiceSpecificationRepoService {


	@Autowired
	ServiceSpecificationRepository serviceSpecificationRepo;

	
	public ServiceSpecification addCategory(ServiceSpecification c) {

		return this.serviceSpecificationRepo.save( c );
	}

	public ServiceSpecification addServiceSpecification(@Valid ServiceSpecificationCreate serviceServiceSpecification) {	
		ServiceSpecification serviceSpec = new ServiceSpecification();
		
		serviceSpec.setName(serviceServiceSpecification.getName());

		serviceSpec.setDescription( serviceServiceSpecification.getDescription() );
		serviceSpec.isBundle( serviceServiceSpecification.isIsBundle() );		
		
		serviceSpec.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		
		
		if ( serviceServiceSpecification.getLifecycleStatus() == null ) {
			serviceSpec.setLifecycleStatusEnum( ELifecycle.IN_STUDY );
		} else {
			serviceSpec.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceServiceSpecification.getLifecycleStatus() ) );
		}
		serviceSpec.setVersion( serviceServiceSpecification.getVersion());
		

		if (serviceServiceSpecification.getAttachment() != null ){
			serviceSpec.getAttachment().addAll( serviceServiceSpecification.getAttachment() );			
		}
		if (serviceServiceSpecification.getRelatedParty() != null ){
			serviceSpec.getRelatedParty().addAll( serviceServiceSpecification.getRelatedParty() );
		}
		if (serviceServiceSpecification.getResourceSpecification() != null ){
			serviceSpec.getResourceSpecification().addAll( serviceServiceSpecification.getResourceSpecification() );
		}
		if (serviceServiceSpecification.getServiceLevelSpecification() != null ){
			serviceSpec.getServiceLevelSpecification().addAll( serviceServiceSpecification.getServiceLevelSpecification() );
		}
		if (serviceServiceSpecification.getServiceSpecCharacteristic() != null ){
			serviceSpec.getServiceSpecCharacteristic().addAll( serviceServiceSpecification.getServiceSpecCharacteristic() );
		}
		if (serviceServiceSpecification.getServiceSpecRelationship() != null ){
			serviceSpec.getServiceSpecRelationship().addAll( serviceServiceSpecification.getServiceSpecRelationship() );
		}
		

		TimePeriod tp = new TimePeriod();
		if ( serviceServiceSpecification.getValidFor() == null ){
			tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
			tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );			
		} else{

			tp.setStartDateTime( serviceServiceSpecification.getValidFor().getStartDateTime() );
			tp.setEndDateTime( serviceServiceSpecification.getValidFor().getEndDateTime() );
		}
		serviceSpec.setValidFor( tp );
		
		return this.serviceSpecificationRepo.save( serviceSpec );
	}

	public List<ServiceSpecification> findAll() {
		return (List<ServiceSpecification>) this.serviceSpecificationRepo.findAll();
	}

	public ServiceSpecification findById(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findById( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findById( id );
		this.serviceSpecificationRepo.delete( optionalCat.get());
		return null;
		
	}
	
	@PostConstruct
	public void initRepo() {
		if ( this.findAll().size() == 0 ) {
			
			
			
		}
	}

}
