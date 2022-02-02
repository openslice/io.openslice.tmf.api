/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.stm653.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.stm653.model.ServiceTestSpecification;
import io.openslice.tmf.stm653.model.ServiceTestSpecificationCreate;
import io.openslice.tmf.stm653.model.ServiceTestSpecificationUpdate;
import io.openslice.tmf.stm653.reposervices.ServiceTestSpecificationRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Controller
@RequestMapping("/serviceTestManagement/v4/")
public class ServiceTestSpecificationApiController implements ServiceTestSpecificationApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceTestSpecificationApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ServiceTestSpecificationRepoService serviceTestSpecificationRepoService;

	@Value("${spring.application.name}")
	private String compname;

	@Autowired
	private CentralLogger centralLogger;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceTestSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<ServiceTestSpecification> createServiceTestSpecification(
			@Valid ServiceTestSpecificationCreate serviceSpecification) {

		try {

			serviceSpecification.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
					SecurityContextHolder.getContext().getAuthentication().getName(),
					SecurityContextHolder.getContext().getAuthentication().getName(), UserPartRoleType.OWNER, "",
					serviceSpecification.getRelatedParty()));

			ServiceTestSpecification c = serviceTestSpecificationRepoService
					.addServiceTestSpecification(serviceSpecification);

			return new ResponseEntity<ServiceTestSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceTestSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<Void> deleteServiceTestSpecification(String id) {

		try {

			return new ResponseEntity<Void>(serviceTestSpecificationRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<ServiceTestSpecification>> listServiceTestSpecification(@Valid String fields,
			@Valid Integer offset, @Valid Integer limit,
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
				return new ResponseEntity<List<ServiceTestSpecification>>(
						serviceTestSpecificationRepoService.findAll(myfields, allParams), HttpStatus.OK);

			} else {

				return new ResponseEntity<List<ServiceTestSpecification>>(
						serviceTestSpecificationRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceTestSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<ServiceTestSpecification> patchServiceTestSpecification(
			@Valid ServiceTestSpecificationUpdate serviceSpecification, String id) {
		ServiceTestSpecification c = serviceTestSpecificationRepoService.updateServiceTestSpecification(id, serviceSpecification);

		return new ResponseEntity<ServiceTestSpecification>(c, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<ServiceTestSpecification> retrieveServiceTestSpecification(String id, @Valid String fields) {
		
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
			
			return new ResponseEntity<ServiceTestSpecification>( serviceTestSpecificationRepoService.findByUuid(id),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceTestSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<Attachment> addAttachmentToServiceTestSpecification(String specid,
			//@Valid @ModelAttribute("attachment") Attachment att,
			@RequestParam(name = "afile") @Valid MultipartFile file,
			HttpServletRequest request) {
		try {

			//log.info("addAttachmentToServiceSpecification attachment=" + att.toString());
			log.info("addAttachmentToServiceTestSpecification file=" + file);

			//Attachment att = objectMapper.readValue(attachment, Attachment.class);
			//log.info("addAttachmentToServiceSpecification att=" + att);

//			return new ResponseEntity<ServiceSpecification>( serviceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
			Attachment c = serviceTestSpecificationRepoService.addAttachmentToServiceTest(specid,  file, request.getRequestURI());

			return new ResponseEntity<Attachment>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Attachment>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<byte[]> getAttachment(String id, String attid) {
		try {
			Attachment att;
						
			att = serviceTestSpecificationRepoService.getAttachment( attid );
			
			if ( att == null ) {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);				
			}
			if ( att.getContent() == null ) {
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
			
			
			
			
		} catch (Exception e) {
			log.error("Couldn't serialize response ByteArrayResource", e);
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<byte[]> getAttachmentWithFilename(String id, String attid, String afilename) {

		return getAttachment(id, attid);
	}

}
