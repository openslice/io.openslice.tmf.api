package io.openslice.tmf.so641.api;

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
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Controller
@RequestMapping("/serviceOrdering/v4/")
public class ServiceOrderApiController implements ServiceOrderApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceOrderApiController.class);

	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;

	public ResponseEntity<ServiceOrder> createServiceOrder(
			@ApiParam(value = "The ServiceOrder to be created", required = true) @Valid @RequestBody ServiceOrderCreate serviceOrder) {

		try {

			ServiceOrder c = serviceOrderRepoService.addServiceOrder( serviceOrder );

			return new ResponseEntity<ServiceOrder>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Void> deleteServiceOrder(
			@ApiParam(value = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ServiceOrder> patchServiceOrder(
			@ApiParam(value = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The ServiceOrder to be updated", required = true) @Valid @RequestBody ServiceOrderUpdate serviceOrder) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ServiceOrder> retrieveServiceOrder(
			@ApiParam(value = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
