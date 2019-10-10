package io.openslice.tmf.scm.sc.reposervices;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
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
	
	public ServiceSpecification updateServiceSpecDataFromAPIcall( ServiceSpecification serviceSpec, ServiceSpecificationUpdate serviceServiceSpecification )
	{
		
		serviceSpec.setName(serviceServiceSpecification.getName());

		serviceSpec.setDescription( serviceServiceSpecification.getDescription() );
		serviceSpec.isBundle( serviceServiceSpecification.isIsBundle() );		
		
		serviceSpec.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		
		
		if ( serviceServiceSpecification.getLifecycleStatus() == null ) {
			serviceSpec.setLifecycleStatusEnum( ELifecycle.IN_STUDY );
		} else {
			serviceSpec.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceServiceSpecification.getLifecycleStatus() ) );
		}
		if ( serviceServiceSpecification.getVersion() == null ) {
			serviceSpec.setVersion( "1.0.0" );
			
		}else {
			serviceSpec.setVersion( serviceServiceSpecification.getVersion());			
		}
		

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

	private ServiceSpecification createGSTExample(ServiceSpecification serviceSpecificationObj) {
		/**
		 * Create the sample spec
		 */
		/**
		 * Coverage
		 */
		ServiceSpecCharacteristic specchar = new ServiceSpecCharacteristic();
		specchar.setConfigurable(true);
		specchar.setName("Coverage");
		specchar.setDescription(
				"This attribute specifies the coverage area of the network slice - the area where the terminals can access a particular network slice");
		specchar.isUnique(true);
		specchar.maxCardinality(1);
		specchar.minCardinality(1);
		specchar.valueType(EValueType.ENUM.getValue());

		ServiceSpecCharacteristicValue speccharvalue = new ServiceSpecCharacteristicValue();
		speccharvalue.isDefault(true);
		speccharvalue.setValue(new Any("1", "Global"));
		speccharvalue.setValueType(EValueType.SMALLINT.getValue());
		specchar.addServiceSpecCharacteristicValueItem(speccharvalue);
		speccharvalue = new ServiceSpecCharacteristicValue();
		speccharvalue.isDefault(true);
		speccharvalue.setValue(new Any("2", "National"));
		speccharvalue.setValueType(EValueType.SMALLINT.getValue());
		specchar.addServiceSpecCharacteristicValueItem(speccharvalue);
		speccharvalue = new ServiceSpecCharacteristicValue();
		speccharvalue.isDefault(true);
		speccharvalue.setValue(new Any("3", "Regional"));
		speccharvalue.setValueType(EValueType.SMALLINT.getValue());
		specchar.addServiceSpecCharacteristicValueItem(speccharvalue);
		speccharvalue = new ServiceSpecCharacteristicValue();
		speccharvalue.isDefault(true);
		speccharvalue.setValue(new Any("4", "Local (outdoor)"));
		speccharvalue.setValueType(EValueType.SMALLINT.getValue());
		specchar.addServiceSpecCharacteristicValueItem(speccharvalue);
		speccharvalue = new ServiceSpecCharacteristicValue();
		speccharvalue.isDefault(true);
		speccharvalue.setValue(new Any("5", "Local (indoor)"));
		speccharvalue.setValueType(EValueType.SMALLINT.getValue());
		specchar.addServiceSpecCharacteristicValueItem(speccharvalue);

		serviceSpecificationObj.addServiceSpecCharacteristicItem(specchar);

		/**
		 * Delay tolerance
		 */
		specchar = new ServiceSpecCharacteristic();
		specchar.setConfigurable(true);
		specchar.setName("Delay tolerance");
		specchar.setDescription(
				"Provide the NSC with service delivery flexibility, especially for the vertical services that are " + 
				"not chasing a high system performance. For instance, the service will be delivered once the " + 
				"mobile system has sufficient resources or during the off-peak hours. For this type of traffic, it is not too critical how long it takes to deliver the amount of data, e.g. within hours, days, " + 
				"weeks, etc.");
		specchar.isUnique(true);
		specchar.maxCardinality(1);
		specchar.minCardinality(1);
		specchar.valueType(EValueType.BINARY.getValue());

		serviceSpecificationObj.addServiceSpecCharacteristicItem(specchar);

		return serviceSpecificationObj;
	}

}
