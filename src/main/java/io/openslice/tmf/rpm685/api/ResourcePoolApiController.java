package io.openslice.tmf.rpm685.api;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.rpm685.model.ResourcePool;
import io.openslice.tmf.rpm685.model.ResourcePoolCreate;
import io.openslice.tmf.rpm685.model.ResourcePoolUpdate;
import io.openslice.tmf.rpm685.reposervices.ResourcePoolRepoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Controller("ResourcePoolApiController685")
@RequestMapping("/resourcePoolManagement/v1/")
public class ResourcePoolApiController implements ResourcePoolApi {

	private static final Logger log = LoggerFactory.getLogger(ResourcePoolApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	

	@Autowired
	ResourcePoolRepoService resourcePoolRepoService;

	@org.springframework.beans.factory.annotation.Autowired
	public ResourcePoolApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<ResourcePool> createResourcePool(Principal principal, @Valid ResourcePoolCreate body) {
		try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				

				ResourcePool c = resourcePoolRepoService.addResourcePool( body );

				return new ResponseEntity<ResourcePool>(c, HttpStatus.OK);
			} else {

				return new ResponseEntity<ResourcePool>(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourcePool>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<Void> deleteResourcePool(
			Principal principal,String id) {
		

		try {

			return new ResponseEntity<Void>( resourcePoolRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<ResourcePool> patchResourcePool(
			Principal principal,@Valid ResourcePoolUpdate body, String id) {
		
		ResourcePool c = resourcePoolRepoService.updateResourcePool(id, body );
		
		// TODO Auto-generated method stub
		return new ResponseEntity<ResourcePool>(c, HttpStatus.OK);
	}
	

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<ResourcePool> retrieveResourcePool(Principal principal, String id, @Valid String fields) {
		try {

			return new ResponseEntity<ResourcePool>( resourcePoolRepoService.findByUuid(id) , HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourcePool>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	@Override
	public ResponseEntity<List<ResourcePool>> listResourcePool(Principal principal, @Valid String fields,
			@Valid Integer offset, @Valid Integer limit) {
		try {
			return new ResponseEntity<List<ResourcePool>>(resourcePoolRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourcePool>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
