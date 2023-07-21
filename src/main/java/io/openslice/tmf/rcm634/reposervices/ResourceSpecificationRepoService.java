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
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.common.model.AttachmentRef;
import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.pcm620.reposervices.AttachmentRepoService;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCandidateUpdate;
import io.openslice.tmf.rcm634.model.ResourceFunctionSpecification;
import io.openslice.tmf.rcm634.model.ResourceFunctionSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.repo.ResourceSpecificationRepository;
import io.openslice.tmf.scm633.model.ServiceCandidate;
import io.openslice.tmf.scm633.model.ServiceCandidateCreate;
import io.openslice.tmf.scm633.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.reposervices.CandidateRepoService;
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
	

	@Autowired
	ResourceCandidateRepoService resCandidateRepoService;
	
	private static final String METADATADIR = System.getProperty("user.home") + File.separator + ".attachments"
			+ File.separator + "metadata" + File.separator;

	public ResourceSpecification addResourceSpec(ResourceSpecification reSpec) {
		return this.resourceSpecificationRepo.save(reSpec);		
	}
	
	
	/**
	 * @param id
	 * @param forceId
	 * @param serviceServiceSpecificationCreate
	 * @return
	 */
	public ResourceSpecification updateOrAddResourceSpecification(String id,
			@Valid ResourceSpecificationCreate resourceSpecificationCreate) {
		
		ResourceSpecification rSpec = updateResourceSpecification(id, resourceSpecificationCreate );
		if ( rSpec == null ) {			
			rSpec = addResourceSpecification( resourceSpecificationCreate );
		}
		
		return rSpec;
	}
	
	public ResourceSpecification addResourceSpecification(@Valid ResourceSpecificationCreate resourceSpecification) {

		ResourceSpecification reSpec ;
		if (resourceSpecification.getType() !=null && (  resourceSpecification.getType().equals( "PhysicalResourceSpecification" )  || 
				 resourceSpecification.getType().equals( "PhysicalResourceSpecificationCreate" )  )) {
			reSpec = new PhysicalResourceSpecification(); 
		}else {
			reSpec = new LogicalResourceSpecification();			
		}
		
		return addResourceSpecificationGeneric(reSpec, resourceSpecification);
	}
	
	public LogicalResourceSpecification addLogicalResourceSpecification(@Valid ResourceSpecificationCreate logicalResourceSpec) {
		LogicalResourceSpecification reSpec = new LogicalResourceSpecification();

		return (LogicalResourceSpecification) addResourceSpecificationGeneric(reSpec, logicalResourceSpec);
	}
	
	
	public LogicalResourceSpecification addResourceFunctionSpecification(@Valid ResourceFunctionSpecificationCreate serviceSpecification) {
		ResourceFunctionSpecification reSpec = new ResourceFunctionSpecification();
		
		return (ResourceFunctionSpecification) addResourceSpecificationGeneric(reSpec, serviceSpecification);
	}
	
	
	
	public PhysicalResourceSpecification addPhysicalResourceSpecification(@Valid PhysicalResourceSpecificationCreate pResourceSpec) {
		PhysicalResourceSpecification reSpec = new PhysicalResourceSpecification();

		return (PhysicalResourceSpecification) addResourceSpecificationGeneric(reSpec, pResourceSpec);
	}
	
	private ResourceSpecification addResourceSpecificationGeneric(ResourceSpecification reSpec, @Valid ResourceSpecificationUpdate  resourceSpecification) {

		reSpec = this.updateResourceSpecDataFromAPIcall(reSpec, resourceSpecification);
		reSpec = this.resourceSpecificationRepo.save(reSpec);
		reSpec.fixResourceCharRelationhsipIDs();
		
		/*
		 * automatically create resource candidate
		 */
		
		ResourceCandidateCreate rCandidate = new ResourceCandidateCreate();		
		ResourceSpecificationRef rSpecRef = new ResourceSpecificationRef();
		rCandidate.setResourceSpecification(rSpecRef );
		rSpecRef.setId( reSpec.getId() );
		ResourceCandidate resCand =  resCandidateRepoService.addResourceCandidate(rCandidate);
		reSpec.setResourceCandidateObjId( resCand.getUuid() );
		
		return this.resourceSpecificationRepo.save(reSpec);
	}
	
	public List<ResourceSpecification> findAll() {
		return (List<ResourceSpecification>) this.resourceSpecificationRepo.findAll();
	}
	
	public List<LogicalResourceSpecification> findAllLogical() {
		return (List<LogicalResourceSpecification>) this.resourceSpecificationRepo.findAllLogical();
	}
	
	public List<PhysicalResourceSpecification> findAllPhysical() {
		return (List<PhysicalResourceSpecification>) this.resourceSpecificationRepo.findAllPhysical();
	}

	public ResourceSpecification findByUuid(String id) {
		Optional<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteByUuid(String id) {
		Optional<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByUuid(id);
		ResourceSpecification s = optionalCat.get();
		if (s == null) {
			return null;
		}

		this.resCandidateRepoService.deleteById( s.getResourceCandidateObjId() );
		
		this.resourceSpecificationRepo.delete( s );
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
		resourceSpec = this.resourceSpecificationRepo.save( resourceSpec );
		
		
		//save the equivalent candidate
		ResourceCandidate resCandidateObj = resCandidateRepoService.findById( resourceSpec.getResourceCandidateObjId() );
		if ( resCandidateObj!=null) {
			ResourceCandidateUpdate resCandidateUpd = new ResourceCandidateUpdate();
			resCandidateUpd.setName( resourceSpec.getName() );		
			resCandidateUpd.setDescription( resourceSpec.getDescription() );		
			resCandidateUpd.setLifecycleStatus( resourceSpec.getLifecycleStatus() );	
			resCandidateUpd.setVersion( resourceSpec.getVersion() );				
			resCandidateRepoService.updateCandidate( resCandidateObj.getId(), resCandidateUpd);
		} else {
			ResourceCandidateCreate rCandidate = new ResourceCandidateCreate();
			ResourceSpecificationRef rSpecRef = new ResourceSpecificationRef();
			rCandidate.setResourceSpecification(rSpecRef);
			rSpecRef.setId( resourceSpec.getId());
			resCandidateObj = resCandidateRepoService.addResourceCandidate(rCandidate);
			resourceSpec.setResourceCandidateObjId(resCandidateObj.getUuid());
		}
		
		
		return this.resourceSpecificationRepo.save( resourceSpec );
		
	}
	
	public LogicalResourceSpecification updateLogicalResourceSpecSpecification(String id,
			@Valid ResourceSpecificationUpdate logicalResourceSpec) {
		return (LogicalResourceSpecification) this.updateResourceSpecification(id, logicalResourceSpec);
	}
	
	public PhysicalResourceSpecification updatePhysicalResourceSpecSpecification(String id,
			@Valid ResourceSpecificationUpdate physicalResourceSpec) {
		return (PhysicalResourceSpecification) this.updateResourceSpecification(id, physicalResourceSpec);
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
		if ( resSpecUpd.getCategory()!= null ) {
			resourceSpec.setCategory( resSpecUpd.getCategory() );			
		}
		
		resourceSpec.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		
		if (resourceSpec instanceof PhysicalResourceSpecification){
			((PhysicalResourceSpecification) resourceSpec)
				.model(( (PhysicalResourceSpecificationUpdate) resSpecUpd ).getModel() )
				.part( ( (PhysicalResourceSpecificationUpdate) resSpecUpd ).getPart())
				.sku( ( (PhysicalResourceSpecificationUpdate) resSpecUpd ).getSku())
				.vendor(( (PhysicalResourceSpecificationUpdate) resSpecUpd ).getVendor() );
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
			
			for (AttachmentRefOrValue ar : resSpecUpd.getAttachment()) {
				//find attachmet by id and reload it here.
				//we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRefOrValue orinalAtt : resourceSpec.getAttachment()) {
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
			
			List<AttachmentRefOrValue> toRemove = new ArrayList<>();
			for (AttachmentRefOrValue ss : resourceSpec.getAttachment()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (AttachmentRefOrValue ar : toRemove) {
				resourceSpec.getAttachment().remove(ar);
			}
			

					
		}
		
		
		
		/**
		 * Update ResourceSpecificationCharacteristic list
		 * We need to compare by name, since IDs will not exist
		 */
		if (resSpecUpd.getResourceSpecificationCharacteristic() != null ){
			//reattach attachments fromDB
			
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ResourceSpecificationCharacteristic charUpd : resSpecUpd.getResourceSpecificationCharacteristic()) {			
				
				boolean nameExists = false;
				for (ResourceSpecificationCharacteristic originalSpecChar : resourceSpec.getResourceSpecCharacteristic()) {
					if ( originalSpecChar.getName()!=null && charUpd.getName()!=null && originalSpecChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put( originalSpecChar.getName(), true);
						originalSpecChar.updateWith( charUpd );
						break;
					}	
				}
				
				if (!nameExists) {
					resourceSpec.getResourceSpecCharacteristic().add( new ResourceSpecificationCharacteristic( charUpd ));
					if ( charUpd.getName() == null ) {
						charUpd.setName( UUID.randomUUID().toString() );
					}
					idAddedUpdated.put( charUpd.getName(), true);
				}
				
			}
			
			List<ResourceSpecificationCharacteristic> toRemove = new ArrayList<>();
			for (ResourceSpecificationCharacteristic ss : resourceSpec.getResourceSpecCharacteristic()) {
				if ( idAddedUpdated.get( ss.getName() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ResourceSpecificationCharacteristic pecCharacteristic : toRemove) {
				resourceSpec.getResourceSpecCharacteristic().remove(pecCharacteristic);
			}

			
		}
				

		/**
		 * Update ResourceSpecRelationship list
		 */
		
		if (resSpecUpd.getResourceSpecificationRelationship() != null ){
			resourceSpec.getResourceSpecRelationship().clear();
			resourceSpec.getResourceSpecRelationship().addAll( resSpecUpd.getResourceSpecificationRelationship() );
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
		
		ResourceSpecificationCreate spec = new ResourceSpecificationCreate();
		spec.setName("Example Logical Resource");
		spec.setVersion("1.0.0");		

		return this.addLogicalResourceSpecification(spec);
	}

	/**
	 * @param id
	 * @param attachment
	 * @param afile
	 * @return
	 */
	public ResourceSpecification addAttachmentToResourceSpec(String id, 
			@Valid MultipartFile afile,
			String urlpath) {
		Optional<ResourceSpecification> s = this.resourceSpecificationRepo.findByUuid(id);
		if ( s.get() == null ) {
			return null;
		}
		
				
		
		ResourceSpecification spec = s.get();
		Attachment att = new Attachment();
		att = this.attachmentRepoService.addAttachment(att);
		att.setMimeType(afile.getContentType());
		
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
				urlpath = urlpath.replace("tmf-api/", "");
				
//				if ( spec instanceof LogicalResourceSpecification ) {
//					att.setUrl(  urlpath + "/logicalResourceSpec/" + spec.getId() + "/attachment/" + att.getId() + "/"+ aFileNamePosted);					
//				}if ( spec instanceof PhysicalResourceSpecification ) {
//					att.setUrl(  urlpath + "/physicalResourceSpec/" + spec.getId() + "/attachment/" + att.getId() + "/"+ aFileNamePosted);					
//				}else {
//					 att.setUrl(  urlpath + "/resourceSpecification/" + spec.getId() + "/attachment/" + att.getId() + "/"+ aFileNamePosted);					
//				}

						att.setUrl( urlpath + "/" + att.getId() + "/"
								+ aFileNamePosted);
				
				
				att = this.attachmentRepoService.updateAttachment( att );
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
		
		
		AttachmentRefOrValue attref = new AttachmentRefOrValue();
		attref.setId(att.getId());
		attref.setDescription(att.getDescription());
		attref.setUrl(att.getUrl());
		attref.setName(att.getName());
		
		spec.addAttachmentItem(attref);
		this.resourceSpecificationRepo.save(spec);
		return spec;
	}

	public Attachment getAttachmentLogo(String id, String attid) {
		ResourceSpecification spec = this.findByUuid( id ); 
		for (AttachmentRefOrValue att : spec.getAttachment()) {
			if ( att.getName().contains("logo")) {
				return this.attachmentRepoService.findByUuid( att.getId() );
			}				
		}
		
		return null;
	}

	public Attachment getAttachment(String attid) {
		return this.attachmentRepoService.findByUuid( attid );
	}

	
	private PhysicalResourceSpecificationCreate readFromLocalPhysicalResourceSpec(String rname) {
		PhysicalResourceSpecificationCreate rc;
		try {
			
			rc = objectMapper.readValue(new ClassPathResource( "/resourceSpecifications/"+rname ).getInputStream(), PhysicalResourceSpecificationCreate.class);
			
			return rc;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private ResourceSpecificationCreate readFromLocalLogicalResourceSpec(String rname) {
		ResourceSpecificationCreate rc;
		try {
			
			rc = objectMapper.readValue(new ClassPathResource( "/resourceSpecifications/"+rname ).getInputStream(), ResourceSpecificationCreate.class);
			
			return rc;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	

	public ResourceSpecification clonePhysicalResourceSpec() {
		return this.clonePhysicalResourceSpec(null);
	} 


	public ResourceSpecification clonePhysicalResourceSpec(String specName) {

		ResourceSpecification resourceSpecificationObj = clonePhysicalResourceSpec( specName , "testResourceSpec.json" );
		return resourceSpecificationObj;
	}
	
	public ResourceSpecification clonePhysicalResourceSpec(String specName, String fileName) {

		PhysicalResourceSpecificationCreate resourceSpecificationObj = readFromLocalPhysicalResourceSpec( fileName );
		resourceSpecificationObj.setName(specName);
		ResourceSpecification rSpec = this.addPhysicalResourceSpecification(resourceSpecificationObj);
		return rSpec;
	}
	
	public ResourceSpecification cloneLogicalResourceSpec() {
		return this.cloneLogicalResourceSpec(null);
	} 


	public ResourceSpecification cloneLogicalResourceSpec(String specName) {
		ResourceSpecification resourceSpecificationObj = cloneLogicalResourceSpec(specName, "testResourceSpec.json");
		return resourceSpecificationObj;
	}
	
	public ResourceSpecification cloneLogicalResourceSpec(String specName, String fileName) {

		ResourceSpecificationCreate resourceSpecificationObj = readFromLocalLogicalResourceSpec( fileName );
		resourceSpecificationObj.setName(specName);
		ResourceSpecification rSpec = this.addLogicalResourceSpecification(resourceSpecificationObj);
		return rSpec;
	}

	public ResourceSpecification findByNameAndVersion(String aname, String aversion) {

		List<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByNameAndVersion(aname,
				aversion);
		if ( ( optionalCat !=null) && ( optionalCat.size()>0) ) {
			return optionalCat.get(0);
		} else {
			return null;
		}
	}

	public ResourceSpecification findByName(String aname) {
		List<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByName(aname);
		if ( ( optionalCat !=null) && ( optionalCat.size()>0) ) {
			return optionalCat.get(0);
		} else {
			return null;
		}
	}
	

	
}
