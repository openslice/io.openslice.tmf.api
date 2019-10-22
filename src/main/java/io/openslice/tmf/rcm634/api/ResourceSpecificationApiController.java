package io.openslice.tmf.rcm634.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Controller
@RequestMapping("/resourceCatalogManagement/v2/")
public class ResourceSpecificationApiController implements ResourceSpecificationApi {

	private static final Logger log = LoggerFactory.getLogger(ResourceSpecificationApiController.class);


	@Autowired
	ResourceSpecificationRepoService resourceSpecificationRepoService;
	
	
	public ResponseEntity<ResourceSpecification> createResourceSpecification(
			@ApiParam(value = "The ResourceSpecification to be created", required = true) @Valid @RequestBody ResourceSpecificationCreate serviceSpecification) {
		try {

			ResourceSpecification c = resourceSpecificationRepoService.addResourceSpecification(serviceSpecification);

			return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<Void> deleteResourceSpecification(
			@ApiParam(value = "Identifier of the ResourceSpecification", required = true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>(resourceSpecificationRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<ResourceSpecification>> listResourceSpecification(
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		try {
			return new ResponseEntity<List<ResourceSpecification>>(resourceSpecificationRepoService.findAll(),
					HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourceSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<ResourceSpecification> patchResourceSpecification(
			@ApiParam(value = "Identifier of the ResourceSpecification", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The ResourceSpecification to be updated", required = true) @Valid @RequestBody ResourceSpecificationUpdate serviceSpecification) {

		ResourceSpecification c = resourceSpecificationRepoService.updateResourceSpecification(id, serviceSpecification);

		return new ResponseEntity<ResourceSpecification>(c, HttpStatus.OK);
	}

	public ResponseEntity<ResourceSpecification> retrieveResourceSpecification(
			@ApiParam(value = "Identifier of the ResourceSpecification", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		try {

			return new ResponseEntity<ResourceSpecification>( resourceSpecificationRepoService.findByUuid( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
