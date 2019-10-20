package io.openslice.tmf.scm633.reposervices;

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
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.pcm620.reposervices.AttachmentRepoService;
import io.openslice.tmf.scm633.model.AttachmentRef;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm633.repo.ServiceSpecificationRepository;
import io.openslice.tmf.util.AttachmentUtil;

@Service
public class ServiceSpecificationRepoService {
	

	private static final transient Log logger = LogFactory.getLog( ServiceSpecificationRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceSpecificationRepository serviceSpecificationRepo;

	@Autowired
	AttachmentRepoService attachmentRepoService;
	
	private static final String METADATADIR = System.getProperty("user.home") + File.separator + ".attachments"
			+ File.separator + "metadata" + File.separator;
	
	public ServiceSpecification addCategory(ServiceSpecification c) {

		return this.serviceSpecificationRepo.save( c );
	}

	public ServiceSpecification addServiceSpecification(@Valid ServiceSpecificationCreate serviceServiceSpecification) {	
		
		
		ServiceSpecification serviceSpec = new ServiceSpecification();		
		serviceSpec = this.updateServiceSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);
		serviceSpec = this.serviceSpecificationRepo.save( serviceSpec );
		serviceSpec.fixSpecCharRelationhsipIDs();
		return this.serviceSpecificationRepo.save( serviceSpec );
	}

	public List<ServiceSpecification> findAll() {
		return (List<ServiceSpecification>) this.serviceSpecificationRepo.findAll();
	}

	public ServiceSpecification findByUuid(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteByUuid(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findByUuid( id );
		this.serviceSpecificationRepo.delete( optionalCat.get());
		return null;		
	}
	

	public ServiceSpecification updateServiceSpecification(String id,
			@Valid ServiceSpecificationUpdate serviceServiceSpecification) {
		
		Optional<ServiceSpecification> s = this.serviceSpecificationRepo.findByUuid(id);
		if ( s.get() == null ) {
			return null;
		}
		ServiceSpecification serviceSpec = s.get();
		serviceSpec = this.updateServiceSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);

		serviceSpec = this.serviceSpecificationRepo.save( serviceSpec );
		serviceSpec.fixSpecCharRelationhsipIDs();
		return this.serviceSpecificationRepo.save( serviceSpec );
		
	}
	
	private ServiceSpecification updateServiceSpecDataFromAPIcall( ServiceSpecification serviceSpec, ServiceSpecificationUpdate serviceSpecUpd )
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
		
		/**
		 * Update Attachment list
		 */
		if (serviceSpecUpd.getAttachment() != null ){
			//reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (AttachmentRef ar : serviceSpecUpd.getAttachment()) {
				//find attachmet by id and reload it here.
				//we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRef orinalAtt : serviceSpec.getAttachment()) {
					if ( orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put( orinalAtt.getId(), true);
						break;
					}	
				}
				
				if (!idexists) {
					serviceSpec.getAttachment().add(ar);
					idAddedUpdated.put( ar.getId(), true);
				}				
			}
			
			List<AttachmentRef> toRemove = new ArrayList<>();
			for (AttachmentRef ss : serviceSpec.getAttachment()) {
				if ( idAddedUpdated.get( ss.getId() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (AttachmentRef ar : toRemove) {
				serviceSpec.getAttachment().remove(ar);
			}
			

					
		}
		
		
		
		/**
		 * Update ServiceSpecCharacteristic list
		 * We need to compare by name, since IDs will not exist
		 */
		if (serviceSpecUpd.getServiceSpecCharacteristic() != null ){
			//reattach attachments fromDB
			
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ServiceSpecCharacteristic charUpd : serviceSpecUpd.getServiceSpecCharacteristic()) {			
				
				boolean nameExists = false;
				for (ServiceSpecCharacteristic originalSpecChar : serviceSpec.getServiceSpecCharacteristic()) {
					if ( originalSpecChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put( originalSpecChar.getName(), true);
						originalSpecChar.updateWith( charUpd );
						break;
					}	
				}
				
				if (!nameExists) {
					serviceSpec.getServiceSpecCharacteristic().add( new ServiceSpecCharacteristic( charUpd ));
					idAddedUpdated.put( charUpd.getName(), true);
				}
				
			}
			
			List<ServiceSpecCharacteristic> toRemove = new ArrayList<>();
			for (ServiceSpecCharacteristic ss : serviceSpec.getServiceSpecCharacteristic()) {
				if ( idAddedUpdated.get( ss.getName() ) == null ) {
					toRemove.add(ss);
				}
			}
			
			for (ServiceSpecCharacteristic serviceSpecCharacteristic : toRemove) {
				serviceSpec.getServiceSpecCharacteristic().remove(serviceSpecCharacteristic);
			}

			
		}
				

		/**
		 * Update ServiceSpecRelationship list
		 */
		
		if (serviceSpecUpd.getServiceSpecRelationship() != null ){
			serviceSpec.getServiceSpecRelationship().clear();
			serviceSpec.getServiceSpecRelationship().addAll( serviceSpecUpd.getServiceSpecRelationship() );
		}
		
		/**
		 * Update RelatedParty list
		 */
		if (serviceSpecUpd.getRelatedParty() != null ){
			serviceSpec.getRelatedParty().clear();
			serviceSpec.getRelatedParty().addAll( serviceSpecUpd.getRelatedParty() );
		}
		
		/**
		 * Update ResourceSpecification list
		 */
		if (serviceSpecUpd.getResourceSpecification() != null ){
			serviceSpec.getResourceSpecification().clear();
			serviceSpec.getResourceSpecification().addAll( serviceSpecUpd.getResourceSpecification() );
		}
		
		/**
		 * Update ServiceLevelSpecification list
		 */
		if (serviceSpecUpd.getServiceLevelSpecification() != null ){
			serviceSpec.getServiceLevelSpecification().clear();
			serviceSpec.getServiceLevelSpecification().addAll( serviceSpecUpd.getServiceLevelSpecification() );
		}
		

		TimePeriod tp = new TimePeriod();
		if ( serviceSpecUpd.getValidFor() != null ){
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

	public ServiceSpecification cloneServiceSpecification(String uuid) {
		ServiceSpecification source = this.findByUuid(uuid);
		ServiceSpecification dest = new ServiceSpecification( source );
		
		dest.setName( "Copy of " + dest.getName() );
		dest.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		dest.setLifecycleStatusEnum( ELifecycle.IN_STUDY );

		
		dest = this.serviceSpecificationRepo.save(dest); //save to get uuids
		dest.fixSpecCharRelationhsipIDs(); //fix charRels. this is specific to our solution on cloning
		dest = this.serviceSpecificationRepo.save(dest); //and resave
		
		return dest; 
	}

	public ServiceSpecification addAttachmentToService(String id, @Valid Attachment attachment,
			@Valid MultipartFile afile) {
		Optional<ServiceSpecification> s = this.serviceSpecificationRepo.findByUuid(id);
		if ( s.get() == null ) {
			return null;
		}
		
				
		
		ServiceSpecification spec = s.get();
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
				// Save the icon file destination
				att.setUrl(  "/serviceSpecification/" + spec.getId() + "/attachments/" + att.getId() + "/"+ aFileNamePosted);
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
		this.serviceSpecificationRepo.save(spec);
		return spec;
	}
	
	

}
