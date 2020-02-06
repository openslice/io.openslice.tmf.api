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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.sd.model.ServiceDescriptor;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.pcm620.model.Attachment;
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

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	// @Secured({ "ROLE_USER" })
	public ResponseEntity<ServiceSpecification> createServiceSpecification(
			@ApiParam(value = "The ServiceSpecification to be created", required = true) @Valid @RequestBody ServiceSpecificationCreate serviceSpecification) {
		try {

			serviceSpecification.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
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
				return new ResponseEntity<List<ServiceSpecification>>(serviceSpecificationRepoService.findAll(),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<List<ServiceSpecification>>(
						serviceSpecificationRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

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
				CentralLogger.log( CLevel.INFO, "User " + authentication.getName() + " retrieve spec id: "+ id , compname );
			} else {
				CentralLogger.log( CLevel.INFO, "Anonymous retrieve spec id: "+ id, compname );				
			}	
			
			return new ResponseEntity<ServiceSpecification>(serviceSpecificationRepoService.findByUuid(id),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<ServiceSpecification> cloneServiceSpecification(
			@ApiParam(value = "Identifier of the ServiceSpecification to clone", required = true) @PathVariable("id") String id) {

		ServiceSpecification c = serviceSpecificationRepoService.cloneServiceSpecification(id);

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ServiceSpecification> addAttachmentToServiceSpecification(String id,
			@Valid @ModelAttribute("attachment") String attachment,
			@RequestParam(name = "afile") @Valid MultipartFile file) {
		try {

			log.info("addAttachmentToServiceSpecification attachment=" + attachment);
			log.info("addAttachmentToServiceSpecification file=" + file);

			Attachment att = objectMapper.readValue(attachment, Attachment.class);
			log.info("addAttachmentToServiceSpecification att=" + att);

//			return new ResponseEntity<ServiceSpecification>( serviceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
			ServiceSpecification c = serviceSpecificationRepoService.addAttachmentToService(id, att, file);

			return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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

	@Override
	public ResponseEntity<ServiceSpecification> specFromNSDID(String id) {
		ServiceSpecification c = serviceSpecificationRepoService.specFromNSDID(id);

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

}
