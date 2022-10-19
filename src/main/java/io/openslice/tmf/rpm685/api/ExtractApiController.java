package io.openslice.tmf.rpm685.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.rpm685.model.Extract;
import io.openslice.tmf.rpm685.model.ExtractCreate;
import io.openslice.tmf.rpm685.model.Push;
import io.openslice.tmf.rpm685.model.ResourcePool;
import io.openslice.tmf.rpm685.reposervices.ResourcePoolRepoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Controller("ExtractApiController685")
@RequestMapping("/resourcePoolManagement/v1/")
public class ExtractApiController implements ExtractApi {

	private static final Logger log = LoggerFactory.getLogger( ExtractApiController.class );

	@Autowired
	ResourcePoolRepoService resourcePoolRepoService;
	
	
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExtractApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<ResourcePool> createExtract(@Valid ExtractCreate body) {
    	try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				

				ResourcePool c = resourcePoolRepoService.extract( body );
				if ( c != null ) {
					return new ResponseEntity<ResourcePool>(c, HttpStatus.OK);					
				} else {
					return new ResponseEntity<ResourcePool>(HttpStatus.NOT_FOUND);					
				}

			} else {

				return new ResponseEntity<ResourcePool>(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourcePool>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
}
