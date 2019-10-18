package io.openslice.tmf.scm633.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm633.model.Error;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller
@RequestMapping("/serviceCatalogManagement/v4/")
public class ServiceCategoryApiController implements ServiceCategoryApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceCategoryApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	CategoryRepoService categoryRepoService;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceCategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ServiceCategory> createServiceCategory(
			@ApiParam(value = "The ServiceCategory to be created", required = true) @Valid @RequestBody ServiceCategoryCreate serviceCategory) {

		try {

			ServiceCategory c = categoryRepoService.addCategory(serviceCategory);

			return new ResponseEntity<ServiceCategory>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<Void> deleteServiceCategory(
			@ApiParam(value = "Identifier of the ServiceCategory", required = true) @PathVariable("id") String id) {

		try {

			return new ResponseEntity<Void>(categoryRepoService.deleteById(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<ServiceCategory>> listServiceCategory(
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		try {
			return new ResponseEntity<List<ServiceCategory>>(categoryRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceCategory>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<ServiceCategory> patchServiceCategory(
			@ApiParam(value = "Identifier of the ServiceCategory", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The ServiceCategory to be updated", required = true) @Valid @RequestBody ServiceCategoryUpdate serviceCategory) {

		ServiceCategory c = categoryRepoService.updateCategory(id, serviceCategory);

		return new ResponseEntity<ServiceCategory>(c, HttpStatus.OK);
	}

	public ResponseEntity<ServiceCategory> retrieveServiceCategory(
			@ApiParam(value = "Identifier of the ServiceCategory", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {

		try {

			return new ResponseEntity<ServiceCategory>(categoryRepoService.findByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
