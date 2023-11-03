package io.openslice.tmf.lcm.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.lcm.model.LCMRuleSpecification;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationCreate;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationUpdate;
import io.openslice.tmf.lcm.reposervices.LCMRuleSpecificationRepoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/lcmrulesmanagement/v1/")
public class LCMRuleSpecificationApiController  implements LCMRuleSpecificationApi {

	private static final Logger log = LoggerFactory.getLogger(LCMRuleSpecificationApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired	
	LCMRuleSpecificationRepoService lcmRuleSpecificationRepoService;
	
	@Value("${spring.application.name}")
	private String compname;

	@org.springframework.beans.factory.annotation.Autowired
	public LCMRuleSpecificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	
	
	@Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<LCMRuleSpecification> createLCMRuleSpecification(@Valid LCMRuleSpecificationCreate body) {
		try {

    		LCMRuleSpecification c = lcmRuleSpecificationRepoService.addLCMRuleSpecification( body );

			return new ResponseEntity<LCMRuleSpecification>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<LCMRuleSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<Void> deleteLCMRuleSpecification(String id) {
		try {

			return new ResponseEntity<Void>( lcmRuleSpecificationRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<LCMRuleSpecification> retrieveLCMRuleSpecification(String id, @Valid String fields) {
		try {

			return new ResponseEntity<LCMRuleSpecification>( lcmRuleSpecificationRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<LCMRuleSpecification>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


	
	@Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<LCMRuleSpecification> patchLCMRuleSpecification(@Valid LCMRuleSpecificationUpdate body, String id) {
		LCMRuleSpecification c = lcmRuleSpecificationRepoService.updateLCMRuleSpecification( id, body );

		return new ResponseEntity<LCMRuleSpecification>(c, HttpStatus.OK);
	}
	
	
	@Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<List<LCMRuleSpecification>> listLCMRuleSpecification(@Valid String fields,
			@Valid Integer offset, @Valid Integer limit, @Valid Map<String, String> allParams) {
		try {
			if (allParams != null) {
				allParams.remove("fields");
				allParams.remove("offset");
				allParams.remove("limit");
			} else {
				allParams = new HashMap<>();
			}
			if ((fields == null) && (allParams.size() == 0)) {

				String myfields = null;
				return new ResponseEntity<List<LCMRuleSpecification>>(						
						lcmRuleSpecificationRepoService.findAll( myfields, allParams), HttpStatus.OK);
				
				
			} else {

				
				return new ResponseEntity<List<LCMRuleSpecification>>(
						lcmRuleSpecificationRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<LCMRuleSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<List<LCMRuleSpecification>> listLCMRuleSpecificationBySpecID(String id, @Valid String fields,
			@Valid Integer offset, @Valid Integer limit, @Valid Map<String, String> allParams) {
		try {
			
				
				return new ResponseEntity<List<LCMRuleSpecification>>(
						lcmRuleSpecificationRepoService.findByServiceSpecificationRefId(id) , HttpStatus.OK);
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<LCMRuleSpecification>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
