package io.openslice.tmf.scm.sc.reposervices;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.model.Any;
import io.openslice.tmf.scm.model.AttachmentRef;
import io.openslice.tmf.scm.model.ELifecycle;
import io.openslice.tmf.scm.model.EValueType;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;
import io.openslice.tmf.scm.sc.repo.ServiceSpecificationRepository;

@Service
public class ServiceSpecificationRepoService {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceSpecificationRepository serviceSpecificationRepo;

	
	public ServiceSpecification addCategory(ServiceSpecification c) {

		return this.serviceSpecificationRepo.save( c );
	}

	public ServiceSpecification addServiceSpecification(@Valid ServiceSpecificationCreate serviceServiceSpecification) {	
		
		
		ServiceSpecification serviceSpec = new ServiceSpecification();		
		serviceSpec = this.updateServiceSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);
		
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
	

	public ServiceSpecification updateServiceSpecification(String id,
			@Valid ServiceSpecificationUpdate serviceServiceSpecification) {
		
		Optional<ServiceSpecification> s = this.serviceSpecificationRepo.findById(id);
		if ( s == null ) {
			return null;
		}
		ServiceSpecification serviceSpec = s.get();
		serviceSpec = this.updateServiceSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);
		
		return this.serviceSpecificationRepo.save( serviceSpec );
		
	}
	
	public ServiceSpecification updateServiceSpecDataFromAPIcall( ServiceSpecification serviceSpec, ServiceSpecificationUpdate serviceSpecUpd )
	{
		
		serviceSpec.setName(serviceSpecUpd.getName());

		serviceSpec.setDescription( serviceSpecUpd.getDescription() );
		serviceSpec.isBundle( serviceSpecUpd.isIsBundle() );		
		
		serviceSpec.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		
		
		if ( serviceSpecUpd.getLifecycleStatus() == null ) {
			serviceSpec.setLifecycleStatusEnum( ELifecycle.IN_STUDY );
		} else {
			serviceSpec.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceSpecUpd.getLifecycleStatus() ) );
		}
		if ( serviceSpecUpd.getVersion() == null ) {
			serviceSpec.setVersion( "1.0.0" );
			
		}else {
			serviceSpec.setVersion( serviceSpecUpd.getVersion());			
		}
		

		if (serviceSpecUpd.getAttachment() != null ){
			//reattach attachments fromDB
						
			for (AttachmentRef ar : serviceSpecUpd.getAttachment()) {
				//find attachmet by id and reload it here.
				//we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRef orinalAtt : serviceSpec.getAttachment()) {
					if ( orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						break;
					}	
				}
				
				if (!idexists) {
					serviceSpec.getAttachment().add(ar);
				}
				
			}
					
		}
//		if (serviceSpecUpd.getRelatedParty() != null ){
//			serviceSpec.getRelatedParty().addAll( serviceSpecUpd.getRelatedParty() );
//		}
//		if (serviceSpecUpd.getResourceSpecification() != null ){
//			serviceSpec.getResourceSpecification().addAll( serviceSpecUpd.getResourceSpecification() );
//		}
//		if (serviceSpecUpd.getServiceLevelSpecification() != null ){
//			serviceSpec.getServiceLevelSpecification().addAll( serviceSpecUpd.getServiceLevelSpecification() );
//		}
		if (serviceSpecUpd.getServiceSpecCharacteristic() != null ){
			//reattach attachments fromDB
			
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ServiceSpecCharacteristic charUpd : serviceSpecUpd.getServiceSpecCharacteristic()) {
				
				
				boolean idexists = false;
				for (ServiceSpecCharacteristic originalSpecChar : serviceSpec.getServiceSpecCharacteristic()) {
					if ( originalSpecChar.getId().equals(charUpd.getId())) {
						idexists = true;
						idAddedUpdated.put( originalSpecChar.getId(), true);
						originalSpecChar.updateWith( charUpd );
						break;
					}	
				}
				
				if (!idexists) {
					serviceSpec.getServiceSpecCharacteristic().add(charUpd);
					idAddedUpdated.put( charUpd.getId(), true);
				}
				
			}
			
			List<ServiceSpecCharacteristic> toRemove = new ArrayList<>();
			for (ServiceSpecCharacteristic ss : serviceSpec.getServiceSpecCharacteristic()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ServiceSpecCharacteristic serviceSpecCharacteristic : toRemove) {
				serviceSpec.getServiceSpecCharacteristic().remove(serviceSpecCharacteristic);
			}
		}
		if (serviceSpecUpd.getServiceSpecRelationship() != null ){
			serviceSpec.getServiceSpecRelationship().addAll( serviceSpecUpd.getServiceSpecRelationship() );
		}
		

		TimePeriod tp = new TimePeriod();
		if ( serviceSpecUpd.getValidFor() == null ){
			tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
			tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );			
		} else{

			tp.setStartDateTime( serviceSpecUpd.getValidFor().getStartDateTime() );
			tp.setEndDateTime( serviceSpecUpd.getValidFor().getEndDateTime() );
		}
		serviceSpec.setValidFor( tp );
		
		return serviceSpec;
	}
	

//	@PostConstruct
	public ServiceSpecification initRepo() {
//		ServiceSpecificationCreate spec = new ServiceSpecificationCreate();
//		spec.setName("GST");
//		spec.setDescription("GST example");
//		ServiceSpecification serviceSpecificationObj = this.addServiceSpecification(spec);
//
//		serviceSpecificationObj = createGSTExample(serviceSpecificationObj);

		ServiceSpecification serviceSpecificationObj = readFromLocalResource();
				
		
		return serviceSpecificationObj;

	}
	
	private ServiceSpecification readFromLocalResource() {
		
		ServiceSpecification sc;
		try {
			sc = objectMapper.readValue(
					new ClassPathResource("gst.json").getInputStream(), 
					ServiceSpecification.class);
			sc = this.serviceSpecificationRepo.save(sc);
			return sc;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	

}
