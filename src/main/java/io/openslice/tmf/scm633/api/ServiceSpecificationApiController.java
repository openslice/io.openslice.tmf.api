package io.openslice.tmf.scm633.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller
@RequestMapping("/serviceCatalogManagement/v4/")
public class ServiceSpecificationApiController implements ServiceSpecificationApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceSpecificationApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ServiceSpecificationRepoService serviceSpecificationRepoService;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ServiceSpecification> createServiceSpecification(
			@ApiParam(value = "The ServiceSpecification to be created", required = true) @Valid @RequestBody ServiceSpecificationCreate serviceSpecification) {
		try {

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
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		try {
			return new ResponseEntity<List<ServiceSpecification>>(serviceSpecificationRepoService.findAll(),
					HttpStatus.OK);

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

			return new ResponseEntity<ServiceSpecification>( serviceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<ServiceSpecification> cloneServiceSpecification(
			@ApiParam(value = "Identifier of the ServiceSpecification to clone", required = true) @PathVariable("id") String id) {

		ServiceSpecification c = serviceSpecificationRepoService.cloneServiceSpecification( id );

		return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ServiceSpecification> addAttachmentToServiceSpecification(
			String id,
			@Valid  @ModelAttribute("attachment") String attachment, 
			@RequestParam(name = "afile" ) @Valid MultipartFile file) {
		try {

			log.info("addAttachmentToServiceSpecification attachment=" + attachment);
			log.info("addAttachmentToServiceSpecification file=" + file);
			
			Attachment att = objectMapper.readValue(attachment, Attachment.class);
			log.info("addAttachmentToServiceSpecification att=" + att);
			
//			return new ResponseEntity<ServiceSpecification>( serviceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
			ServiceSpecification c = serviceSpecificationRepoService.addAttachmentToService( id, att, file );

			return new ResponseEntity<ServiceSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}