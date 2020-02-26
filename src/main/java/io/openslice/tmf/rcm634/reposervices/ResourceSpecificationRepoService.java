/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.rcm634.reposervices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.AttachmentRef;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.pcm620.reposervices.AttachmentRepoService;
import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecCreate;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecUpdate;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpec;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecCreate;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecUpdate;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.repo.ResourceSpecificationRepository;
import io.openslice.tmf.util.AttachmentUtil;

@Service
public class ResourceSpecificationRepoService {
	private static final transient Log logger = LogFactory.getLog(ResourceSpecificationRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ResourceSpecificationRepository resourceSpecificationRepo;
	
	@Autowired
	AttachmentRepoService attachmentRepoService;
	
	private static final String METADATADIR = System.getProperty("user.home") + File.separator + ".attachments"
			+ File.separator + "metadata" + File.separator;

	public ResourceSpecification addResourceSpec(ResourceSpecification reSpec) {
		return this.resourceSpecificationRepo.save(reSpec);		
	}
	
	public ResourceSpecification addResourceSpecification(@Valid ResourceSpecificationCreate resourceSpecification) {

		ResourceSpecification reSpec ;
		if ( resourceSpecification.getType().equals( "PhysicalResourceSpec" )  || 
				 resourceSpecification.getType().equals( "PhysicalResourceSpecCreate" )  ) {
			reSpec = new PhysicalResourceSpec(); 
		}else {
			reSpec = new LogicalResourceSpec();			
		}
		
		return addResourceSpecificationGeneric(reSpec, resourceSpecification);
	}
	
	public LogicalResourceSpec addLogicalResourceSpecification(@Valid LogicalResourceSpecCreate logicalResourceSpec) {
		LogicalResourceSpec reSpec = new LogicalResourceSpec();

		return (LogicalResourceSpec) addResourceSpecificationGeneric(reSpec, logicalResourceSpec);
	}
	
	public PhysicalResourceSpec addPhysicalResourceSpecification(@Valid PhysicalResourceSpecCreate logicalResourceSpec) {
		PhysicalResourceSpec reSpec = new PhysicalResourceSpec();

		return (PhysicalResourceSpec) addResourceSpecificationGeneric(reSpec, logicalResourceSpec);
	}
	
	private ResourceSpecification addResourceSpecificationGeneric(ResourceSpecification reSpec, @Valid ResourceSpecificationUpdate  resourceSpecification) {

		reSpec = this.updateResourceSpecDataFromAPIcall(reSpec, resourceSpecification);
		reSpec = this.resourceSpecificationRepo.save(reSpec);
		reSpec.fixResourceCharRelationhsipIDs();
		return this.resourceSpecificationRepo.save(reSpec);
	}
	
	public List<ResourceSpecification> findAll() {
		return (List<ResourceSpecification>) this.resourceSpecificationRepo.findAll();
	}
	
	public List<LogicalResourceSpec> findAllLogical() {
		return (List<LogicalResourceSpec>) this.resourceSpecificationRepo.findAllLogical();
	}
	
	public List<PhysicalResourceSpec> findAllPhysical() {
		return (List<PhysicalResourceSpec>) this.resourceSpecificationRepo.findAllPhysical();
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
	
	public LogicalResourceSpec updateLogicalResourceSpecSpecification(String id,
			@Valid LogicalResourceSpecUpdate logicalResourceSpec) {
		return (LogicalResourceSpec) this.updateResourceSpecification(id, logicalResourceSpec);
	}
	
	public PhysicalResourceSpec updatePhysicalResourceSpecSpecification(String id,
			@Valid PhysicalResourceSpecUpdate physicalResourceSpec) {
		return (PhysicalResourceSpec) this.updateResourceSpecification(id, physicalResourceSpec);
	}
	
	
	
	private ResourceSpecification updateResourceSpecDataFromAPIcall(
			ResourceSpecification resourceSpec, 
			ResourceSpecificationUpdate resSpecUpd )
	{
		if ( resSpecUpd.getName()!=null ) {
			resourceSpec.setName(resSpecUpd.getName());
		}

		if ( resSpecUpd.getDescription()!= null ) {
			resourceSpec.setDescription( resSpecUpd.getDescription() );			
		}
		if ( resSpecUpd.isIsBundle() != null ) {
			resourceSpec.setIsBundle( resSpecUpd.isIsBundle() );			
		}		
		
		resourceSpec.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		
		if (resourceSpec instanceof PhysicalResourceSpec){
			((PhysicalResourceSpec) resourceSpec).setModel(( (PhysicalResourceSpecUpdate) resSpecUpd ).getModel() );
			((PhysicalResourceSpec) resourceSpec).setPart(( (PhysicalResourceSpecUpdate) resSpecUpd ).getPart() );
			((PhysicalResourceSpec) resourceSpec).setSku(( (PhysicalResourceSpecUpdate) resSpecUpd ).getSku() );
			((PhysicalResourceSpec) resourceSpec).setVendor(( (PhysicalResourceSpecUpdate) resSpecUpd ).getVendor() );
			((PhysicalResourceSpec) resourceSpec).setPlace(( (PhysicalResourceSpecUpdate) resSpecUpd ).getPlace() );
		}
		
		
		if ( resSpecUpd.getLifecycleStatus() != null ) {
			resourceSpec.setLifecycleStatusEnum ( ELifecycle.getEnum( resSpecUpd.getLifecycleStatus() ) );
		}
		if ( resSpecUpd.getVersion() != null ) {
			resourceSpec.setVersion( resSpecUpd.getVersion());			
		}
		
		
		/**
		 * Update Attachment list
		 */
		if (resSpecUpd.getAttachment() != null ){
			//reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (AttachmentRef ar : resSpecUpd.getAttachment()) {
				//find attachmet by id and reload it here.
				//we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRef orinalAtt : resourceSpec.getAttachment()) {
					if ( orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put( orinalAtt.getId(), true);
						break;
					}	
				}
				
				if (!idexists) {
					resourceSpec.getAttachment().add(ar);
					idAddedUpdated.put( ar.getId(), true);
				}				
			}
			
			List<AttachmentRef> toRemove = new ArrayList<>();
			for (AttachmentRef ss : resourceSpec.getAttachment()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (AttachmentRef ar : toRemove) {
				resourceSpec.getAttachment().remove(ar);
			}
			

					
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
		ResourceSpecification spec = new LogicalResourceSpec();
		spec.setName("A Logical Resource");
		spec.setVersion("1.0.0");
		spec = this.resourceSpecificationRepo.save(spec);
		return spec;
	}

	/**
	 * @param id
	 * @param attachment
	 * @param afile
	 * @return
	 */
	public ResourceSpecification addAttachmentToResourceSpec(String id, @Valid Attachment attachment,
			@Valid MultipartFile afile) {
		Optional<ResourceSpecification> s = this.resourceSpecificationRepo.findByUuid(id);
		if ( s.get() == null ) {
			return null;
		}
		
				
		
		ResourceSpecification spec = s.get();
		Attachment att = this.attachmentRepoService.addAttachment(attachment);
		
		String tempDir = METADATADIR + spec.getId() + "/attachments/" + att.getId() + File.separator;
		
		
		try {
			Files.createDirectories(Paths.get(tempDir));
			String aFileNamePosted = afile.getOriginalFilename() ;// AttachmentUtil.getFileName(image.getHeaders());
			logger.info("aFileNamePosted = " + aFileNamePosted);
			// If there is an icon name
			if (!aFileNamePosted.equals("")) {
				// Save the icon File
				String targetfile = AttachmentUtil.saveFile(afile, tempDir + aFileNamePosted);
				logger.info("afile saved to = " + targetfile);
				att.setContent(targetfile);
				att.setMimeType( afile.getContentType() );
				att.setName(aFileNamePosted);				
				// Save the file destination
				
				if ( spec instanceof LogicalResourceSpec ) {
					att.setUrl(  "/logicalResourceSpec/" + spec.getId() + "/attachments/" + att.getId() + "/"+ aFileNamePosted);					
				}if ( spec instanceof PhysicalResourceSpec ) {
					att.setUrl(  "/physicalResourceSpec/" + spec.getId() + "/attachments/" + att.getId() + "/"+ aFileNamePosted);					
				}else {
					 att.setUrl(  "/resourceSpecification/" + spec.getId() + "/attachments/" + att.getId() + "/"+ aFileNamePosted);					
				}
				
				
				att = this.attachmentRepoService.updateAttachment(attachment);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
		
		
		AttachmentRef attref = new AttachmentRef();
		attref.setId(att.getId());
		attref.setDescription(att.getDescription());
		attref.setUrl(att.getUrl());
		attref.setName(att.getName());
		
		spec.addAttachmentItem(attref);
		this.resourceSpecificationRepo.save(spec);
		return spec;
	}

	

	

	

	

	

	
}
