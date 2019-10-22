package io.openslice.tmf.rcm634.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.repo.ResourceSpecificationRepository;

@Service
public class ResourceSpecificationRepoService {
	private static final transient Log logger = LogFactory.getLog(ResourceSpecificationRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ResourceSpecificationRepository resourceSpecificationRepo;

	public ResourceSpecification addResourceSpecification(@Valid ResourceSpecificationCreate resourceSpecification) {

		ResourceSpecification reSpec = new ResourceSpecification();
		reSpec = this.updateResourceSpecDataFromAPIcall(reSpec, resourceSpecification);
		reSpec = this.resourceSpecificationRepo.save(reSpec);
		reSpec.fixResourceCharRelationhsipIDs();
		return this.resourceSpecificationRepo.save(reSpec);
	}
	
	public List<ResourceSpecification> findAll() {
		return (List<ResourceSpecification>) this.resourceSpecificationRepo.findAll();
	}

	public ResourceSpecification findByUuid(String id) {
		Optional<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteByUuid(String id) {
		Optional<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByUuid( id );
		this.resourceSpecificationRepo.delete( optionalCat.get());
		return null;		
	}
	

	public ResourceSpecification updateResourceSpecification(String id,
			@Valid ResourceSpecificationUpdate serviceResourceSpecification) {
		
		Optional<ResourceSpecification> s = this.resourceSpecificationRepo.findByUuid(id);
		if ( s.get() == null ) {
			return null;
		}
		ResourceSpecification resourceSpec = s.get();
		resourceSpec = this.updateResourceSpecDataFromAPIcall(resourceSpec, serviceResourceSpecification);

		resourceSpec = this.resourceSpecificationRepo.save( resourceSpec );
		resourceSpec.fixResourceCharRelationhsipIDs();
		return this.resourceSpecificationRepo.save( resourceSpec );
		
	}
	
	
	private ResourceSpecification updateResourceSpecDataFromAPIcall( ResourceSpecification resourceSpec, ResourceSpecificationUpdate resSpecUpd )
	{
		
		resourceSpec.setName(resSpecUpd.getName());

		resourceSpec.setDescription( resSpecUpd.getDescription() );
		resourceSpec.setIsBundle( resSpecUpd.isIsBundle() );		
		
		resourceSpec.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		
		
		if ( resSpecUpd.getLifecycleStatus() == null ) {
			resourceSpec.setLifecycleStatusEnum( ELifecycle.IN_STUDY );
		} else {
			resourceSpec.setLifecycleStatusEnum ( ELifecycle.getEnum( resSpecUpd.getLifecycleStatus() ) );
		}
		if ( resSpecUpd.getVersion() == null ) {
			resourceSpec.setVersion( "1.0.0" );
			
		}else {
			resourceSpec.setVersion( resSpecUpd.getVersion());			
		}
		
		
		
		
		
		/**
		 * Update ResourceSpecCharacteristic list
		 * We need to compare by name, since IDs will not exist
		 */
		if (resSpecUpd.getResourceSpecCharacteristic() != null ){
			//reattach attachments fromDB
			
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ResourceSpecCharacteristic charUpd : resSpecUpd.getResourceSpecCharacteristic()) {			
				
				boolean nameExists = false;
				for (ResourceSpecCharacteristic originalSpecChar : resourceSpec.getResourceSpecCharacteristic()) {
					if ( originalSpecChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put( originalSpecChar.getName(), true);
						originalSpecChar.updateWith( charUpd );
						break;
					}	
				}
				
				if (!nameExists) {
					resourceSpec.getResourceSpecCharacteristic().add( new ResourceSpecCharacteristic( charUpd ));
					idAddedUpdated.put( charUpd.getName(), true);
				}
				
			}
			
			List<ResourceSpecCharacteristic> toRemove = new ArrayList<>();
			for (ResourceSpecCharacteristic ss : resourceSpec.getResourceSpecCharacteristic()) {
				if ( idAddedUpdated.get( ss.getName() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ResourceSpecCharacteristic pecCharacteristic : toRemove) {
				resourceSpec.getResourceSpecCharacteristic().remove(pecCharacteristic);
			}

			
		}
				

		/**
		 * Update ResourceSpecRelationship list
		 */
		
		if (resSpecUpd.getResourceSpecRelationship() != null ){
			resourceSpec.getResourceSpecRelationship().clear();
			resourceSpec.getResourceSpecRelationship().addAll( resSpecUpd.getResourceSpecRelationship() );
		}
		
		/**
		 * Update RelatedParty list
		 */
		if (resSpecUpd.getRelatedParty() != null ){
			resourceSpec.getRelatedParty().clear();
			resourceSpec.getRelatedParty().addAll( resSpecUpd.getRelatedParty() );
		}
		
	
		

		TimePeriod tp = new TimePeriod();
		if ( resSpecUpd.getValidFor() != null ){
			tp.setStartDateTime( resSpecUpd.getValidFor().getStartDateTime() );
			tp.setEndDateTime( resSpecUpd.getValidFor().getEndDateTime() );
		}
		resourceSpec.setValidFor( tp );
		
		return resourceSpec;
	}

	public ResourceSpecification initRepo() {
		ResourceSpecification spec = new ResourceSpecification();
		spec.setName("A Resource");
		spec.setVersion("1.0.0");
		spec = this.resourceSpecificationRepo.save(spec);
		return spec;
	}

}
