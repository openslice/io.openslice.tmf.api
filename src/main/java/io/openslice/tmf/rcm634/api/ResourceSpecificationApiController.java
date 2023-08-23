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
package io.openslice.tmf.rcm634.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceFunctionSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Controller
@RequestMapping("/resourceCatalogManagement/v4/")
public class ResourceSpecificationApiController implements ResourceSpecificationApi {

	private static final Logger log = LoggerFactory.getLogger(ResourceSpecificationApiController.class);

	private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

//    private PolymorphicTypeValidator getPTV() {
//        return BasicPolymorphicTypeValidator.builder().allowIfBaseType(ResourceSpecification.class)
//                .build();
//    }

    
    @org.springframework.beans.factory.annotation.Autowired
    public ResourceSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
       // objectMapper.activateDefaultTyping(getPTV(), ObjectMapper.DefaultTyping.EVERYTHING);
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable( objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    

	@Autowired
	ResourceSpecificationRepoService resourceSpecificationRepoService;
	

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<ResourceSpecification> createResourceSpecification(JsonNode jsonNode) {
		try {
			
			log.info( jsonNode.asText() );
			
			JsonNode an = jsonNode.path("@type"); 
			
			if ( an != null ) {

				log.info( an.asText() );
				if ( an.asText().equals("PhysicalResourceSpecification")) {
					@Valid
					PhysicalResourceSpecificationCreate serviceSpecification = objectMapper.treeToValue( jsonNode, PhysicalResourceSpecificationCreate.class);
					ResourceSpecification c = resourceSpecificationRepoService.addPhysicalResourceSpecification(serviceSpecification );
					return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
					
				} else if ( an.asText().equals("ResourceFunctionSpecification")) {
					@Valid
					ResourceFunctionSpecificationCreate serviceSpecification = objectMapper.treeToValue( jsonNode, ResourceFunctionSpecificationCreate.class);
					ResourceSpecification c = resourceSpecificationRepoService.addResourceFunctionSpecification(serviceSpecification );
					return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
					
				} 
					
					
					
			}

			ResourceSpecificationCreate serviceSpecification = objectMapper.treeToValue( jsonNode, ResourceSpecificationCreate.class);
			ResourceSpecification c = resourceSpecificationRepoService.addLogicalResourceSpecification(serviceSpecification);
			return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<Void> deleteResourceSpecification(
			@Parameter(description = "Identifier of the ResourceSpecification", required = true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>(resourceSpecificationRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<ResourceSpecification>> listResourceSpecification(
			@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		try {
			return new ResponseEntity<List<ResourceSpecification>>(resourceSpecificationRepoService.findAll(),
					HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourceSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<ResourceSpecification> patchResourceSpecification(@Valid ResourceSpecificationUpdate serviceSpecification,
			String id) {

		ResourceSpecification c = resourceSpecificationRepoService.updateResourceSpecification(id, serviceSpecification);

		return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
	}

	

	@Override
	public ResponseEntity<ResourceSpecification> retrieveResourceSpecification(
			@Parameter(description = "Identifier of the ResourceSpecification", required = true) @PathVariable("id") String id,
			@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		try {

			return new ResponseEntity<ResourceSpecification>( resourceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<ResourceSpecification>  addAttachmentToLogicalResourceSpec(
			String id, 
    		//@Parameter(description = "The Attachment object to be added" ,required=false )  @Valid @ModelAttribute("attachment") String attachment, 
    		@Parameter(description = "The Attachment file to be added" ,required=false, name = "afile" )  @Valid MultipartFile afile,
			HttpServletRequest request){

		try {

			//log.info("addAttachmentToLogicalResourceSpec attachment=" + attachment);
			log.info("addAttachmentToLogicalResourceSpec file=" + afile);
			
			//Attachment att = objectMapper.readValue(attachment, Attachment.class);
			
			ResourceSpecification c = (ResourceSpecification) resourceSpecificationRepoService.addAttachmentToResourceSpec( id, afile, request.getRequestURI() );

			return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@Override
	public ResponseEntity<byte[]> getAttachment(String id, String attid) {
		try {
			Attachment att;
			if ( attid.equals("logo")) {
				att = resourceSpecificationRepoService.getAttachmentLogo( id, attid );
			} else {			
				att = resourceSpecificationRepoService.getAttachment( attid );
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
	public ResponseEntity<byte[]> getAttachmentWithFilename(String id, String attid, String afilename) {
		return getAttachment(id, attid);
	}
	
}
