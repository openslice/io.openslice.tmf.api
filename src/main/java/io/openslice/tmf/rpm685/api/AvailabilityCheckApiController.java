package io.openslice.tmf.rpm685.api;

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

import io.openslice.tmf.rpm685.model.AvailabilityCheck;
import io.openslice.tmf.rpm685.model.AvailabilityCheckCreate;
import io.openslice.tmf.rpm685.reposervices.ResourcePoolRepoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Controller("AvailabilityCheckApiController685")
@RequestMapping("/resourcePoolManagement/v1/")
public class AvailabilityCheckApiController implements AvailabilityCheckApi {

	private static final Logger log = LoggerFactory.getLogger(AvailabilityCheckApiController.class);


	@Autowired
	ResourcePoolRepoService resourcePoolRepoService;
	
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AvailabilityCheckApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<AvailabilityCheck> createAvailabilityCheck(@Valid AvailabilityCheckCreate body) {
    	try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				

				AvailabilityCheck c = resourcePoolRepoService.availabilityCheck( body );

				return new ResponseEntity<AvailabilityCheck>(c, HttpStatus.OK);
			} else {

				return new ResponseEntity<AvailabilityCheck>(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<AvailabilityCheck>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
