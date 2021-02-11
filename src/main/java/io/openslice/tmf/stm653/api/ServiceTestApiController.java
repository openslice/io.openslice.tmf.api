package io.openslice.tmf.stm653.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.stm653.model.ServiceTest;
import io.openslice.tmf.stm653.model.ServiceTestCreate;
import io.openslice.tmf.stm653.model.ServiceTestSpecification;
import io.openslice.tmf.stm653.model.ServiceTestUpdate;
import io.openslice.tmf.stm653.reposervices.ServiceTestRepoService;
import io.openslice.tmf.stm653.reposervices.ServiceTestSpecificationRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import io.swagger.annotations.ApiParam;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Controller
@RequestMapping("/serviceTestManagement/v4/")
public class ServiceTestApiController implements ServiceTestApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    

	private static final Logger log = LoggerFactory.getLogger(ServiceTestApiController.class);


	@Autowired
	ServiceTestRepoService serviceTestRepoService;
	

	@Value("${spring.application.name}")
	private String compname;
	
    @org.springframework.beans.factory.annotation.Autowired
    public ServiceTestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<ServiceTest> createServiceTest(@Valid ServiceTestCreate serviceTest) {
    	try {

    		serviceTest.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
					SecurityContextHolder.getContext().getAuthentication().getName(),
					SecurityContextHolder.getContext().getAuthentication().getName(), UserPartRoleType.OWNER, "",
					serviceTest.getRelatedParty()));

    		ServiceTest c = serviceTestRepoService
					.addServiceTest(serviceTest);

			return new ResponseEntity<ServiceTest>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceTest>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @Override
    public ResponseEntity<Void> deleteServiceTest(String id) {
    	try {

			return new ResponseEntity<Void>(serviceTestRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @Override
    public ResponseEntity<List<ServiceTest>> listServiceTest(@Valid String fields, @Valid Integer offset,
    		@Valid Integer limit,
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
				return new ResponseEntity<List<ServiceTest>>(
						serviceTestRepoService.findAll(myfields, allParams), HttpStatus.OK);

			} else {

				return new ResponseEntity<List<ServiceTest>>(
						serviceTestRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceTest>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@Secured({ "ROLE_ADMIN" })
    @Override
    public ResponseEntity<ServiceTest> patchServiceTest(@Valid ServiceTestUpdate serviceSpecification, String id) {
		
		ServiceTest c = serviceTestRepoService.updateServiceTest(id, serviceSpecification);

		return new ResponseEntity<ServiceTest>(c, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<ServiceTest> retrieveServiceTest(String id, @Valid String fields) {
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
			
			return new ResponseEntity<ServiceTest>( serviceTestRepoService.findByUuid(id),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceTest>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
