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
package io.openslice.tmf.scm633.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.sd.model.ServiceDescriptor;
import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller
@RequestMapping("/serviceCatalogManagement/v4/")
@Api(value = "serviceSpecification", description = "the serviceSpecification API")
public class ServiceSpecificationApiController implements ServiceSpecificationApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceSpecificationApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ServiceSpecificationRepoService serviceSpecificationRepoService;


	@Value("${spring.application.name}")
	private String compname;

	@Autowired
	private CentralLogger centralLogger;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Secured({ "ROLE_ADMIN" })
	public ResponseEntity<ServiceSpecification> createServiceSpecification(
			@ApiParam(value = "The ServiceSpecification to be created", required = true) @Valid @RequestBody ServiceSpecificationCreate serviceSpecification) {
		try {

			serviceSpecification.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
					SecurityContextHolder.getContext().getAuthentication().getName(),
					SecurityContextHolder.getContext().getAuthentication().getName(),
					UserPartRoleType.OWNER,
					"",
					serviceSpecification.getRelatedParty()));

			ServiceSpecification c = serviceSpecificationRepoService.addServiceSpecification(serviceSpecification);

			return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	public ResponseEntity<Void> deleteServiceSpecification(
			@ApiParam(value = "Identifier of the ServiceSpecification", required = true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>(serviceSpecificationRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	public ResponseEntity<List<ServiceSpecification>> listServiceSpecification(
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
			@ApiParam(hidden = true) @Valid @RequestParam Map<String, String> allParams) {

		try {
			if (allParams != null) {
				allParams.remove("fields");
				allParams.remove("offset");
				allParams.remove("limit");
			} else {
				allParams = new HashMap<>();
			}
			if ((fields == null) && (allParams.size() == 0)) {

				String myfields = "lastUpdate,lifecycleStatus";
				return new ResponseEntity<List<ServiceSpecification>>(						
						serviceSpecificationRepoService.findAll( myfields, allParams), HttpStatus.OK);
//				return new ResponseEntity<List<ServiceSpecification>>(serviceSpecificationRepoService.findAll(),
//						HttpStatus.OK);
				
				
			} else {

				
				return new ResponseEntity<List<ServiceSpecification>>(
						serviceSpecificationRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	public ResponseEntity<ServiceSpecification> patchServiceSpecification(
			@ApiParam(value = "Identifier of the ServiceSpecification", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The ServiceSpecification to be updated", required = true) @Valid @RequestBody ServiceSpecificationUpdate serviceSpecification) {

		ServiceSpecification c = serviceSpecificationRepoService.updateServiceSpecification(id, serviceSpecification);

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

	public ResponseEntity<ServiceSpecification> retrieveServiceSpecification(
			@ApiParam(value = "Identifier of the ServiceSpecification", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		try {

			Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

			if ( attr!=null) {
				SecurityContextHolder.setContext( (SecurityContext) attr );  
			}
			if ( SecurityContextHolder.getContext().getAuthentication() != null ) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				centralLogger.log( CLevel.INFO, "User " + authentication.getName() + " retrieve spec id: "+ id , compname );
			} else {
				centralLogger.log( CLevel.INFO, "Anonymous retrieve spec id: "+ id, compname );				
			}	
			
			return new ResponseEntity<ServiceSpecification>(serviceSpecificationRepoService.findByUuid(id),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	public ResponseEntity<ServiceSpecification> cloneServiceSpecification(
			@ApiParam(value = "Identifier of the ServiceSpecification to clone", required = true) @PathVariable("id") String id) {

		ServiceSpecification c = serviceSpecificationRepoService.cloneServiceSpecification(id);

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<Attachment> addAttachmentToServiceSpecification(String specid,
			//@Valid @ModelAttribute("attachment") Attachment att,
			@RequestParam(name = "afile") @Valid MultipartFile file,
			HttpServletRequest request) {
		try {

			//log.info("addAttachmentToServiceSpecification attachment=" + att.toString());
			log.info("addAttachmentToServiceSpecification file=" + file);

			//Attachment att = objectMapper.readValue(attachment, Attachment.class);
			//log.info("addAttachmentToServiceSpecification att=" + att);

//			return new ResponseEntity<ServiceSpecification>( serviceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
			Attachment c = serviceSpecificationRepoService.addAttachmentToService(specid,  file, request.getRequestURI());

			return new ResponseEntity<Attachment>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Attachment>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@Override
	@ResponseBody
	public  ResponseEntity<byte[]> getAttachment(String id, String attid) {
		try {
			Attachment att;
			if ( attid.equals("logo")) {
				att = serviceSpecificationRepoService.getAttachmentLogo( id, attid );
			} else {			
				att = serviceSpecificationRepoService.getAttachment( attid );
			}
			
			if ( att == null ) {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);				
			}
			
			File file = new File( att.getContent() );
			Path path = Paths.get(file.getAbsolutePath());
			//ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
			HttpHeaders headers = new HttpHeaders();
			InputStream in = new FileInputStream( file );
			
			byte[] media = IOUtils.toByteArray(in);
		    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		    headers.setContentType( MediaType. parseMediaType( att.getMimeType()) );
		    
		    if ( att.getMimeType().contains("zip") || att.getMimeType().contains("gz")) {		    
		    	headers.add( "Content-Disposition", "attachment; filename=" + file.getName());//remove this returns directly the object
		    }
		    
		    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		    return responseEntity;
			
			
//			return ResponseEntity.ok()
//					.header("Content-Disposition", "attachment; filename=" + file.getName())
//		            .contentLength(file.length())
//		            .contentType(  MediaType. parseMediaType( att.getMimeType()) )//MediaType.parseMediaType("application/gzip"))
//		            .body(resource);
			
			
		} catch (Exception e) {
			log.error("Couldn't serialize response ByteArrayResource", e);
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@Override
	@ResponseBody
	public ResponseEntity<byte[]> getAttachmentWithFilename(String id, String attid, String afilename) {
		
		return getAttachment(id, attid);
	}
	
	

	@Override
	public ResponseEntity<ServiceDescriptor> retrieveServiceSpecificationDescriptor(String id) {
		try {
			ServiceSpecification spec = serviceSpecificationRepoService.findByUuid(id);
			if (spec != null) {
				return new ResponseEntity<ServiceDescriptor>(spec.getServiceDescriptor(), HttpStatus.OK);
			} else {

				return new ResponseEntity<ServiceDescriptor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceDescriptor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<ServiceSpecification> cloneGSTServiceSpecification(String serviceName) {
		ServiceSpecification c = serviceSpecificationRepoService.cloneGSTServiceSpecification( serviceName );

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ServiceSpecification> cloneVINNIServiceSpecification(String serviceName, Boolean addServiceTopology,
			Boolean addServiceRequirements, Boolean addServiceExposureLevel1, Boolean addServiceExposureLevel2,
			Boolean addServiceExposureLevel3, Boolean addServiceExposureLevel4, Boolean addServiceMonitoring,
			Boolean addServiceTesting, Boolean addServiceVNF, Boolean addServiceNSD) {

		ServiceSpecification c = serviceSpecificationRepoService.cloneVINNIServiceSpecification(serviceName,
				addServiceTopology,
				addServiceRequirements, addServiceExposureLevel1, addServiceExposureLevel2, addServiceExposureLevel3,
				addServiceExposureLevel4, addServiceMonitoring, addServiceTesting, addServiceVNF, addServiceNSD);

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<ServiceSpecification> specFromNSDID(String id) {
		ServiceSpecification c = serviceSpecificationRepoService.specFromNSDID(id);

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}



}
