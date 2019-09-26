package io.openslice.tmf.scm.sc.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.model.Error;
import io.openslice.tmf.scm.model.ServiceCandidate;
import io.openslice.tmf.scm.model.ServiceCandidateCreate;
import io.openslice.tmf.scm.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.sc.reposervices.CandidateRepoService;
import io.openslice.tmf.scm.sc.reposervices.CatalogRepoService;
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
public class ServiceCandidateApiController implements ServiceCandidateApi {

    private static final Logger log = LoggerFactory.getLogger(ServiceCandidateApiController.class);

    private final HttpServletRequest request;
    
	@Autowired
	CandidateRepoService candidateRepoService;


    @org.springframework.beans.factory.annotation.Autowired
    public ServiceCandidateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<ServiceCandidate> createServiceCandidate(@ApiParam(value = "The ServiceCandidate to be created" ,required=true )  @Valid @RequestBody ServiceCandidateCreate serviceCandidate) {
    	try {

    		ServiceCandidate c = candidateRepoService.addCatalog( serviceCandidate );

			return new ResponseEntity<ServiceCandidate>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<Void> deleteServiceCandidate(@ApiParam(value = "Identifier of the ServiceCandidate",required=true) @PathVariable("id") String id) {
    	try {

			return new ResponseEntity<Void>( candidateRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<List<ServiceCandidate>> listServiceCandidate(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
    	  String accept = request.getHeader("Accept");
          try {
  			return new ResponseEntity<List<ServiceCandidate>>( candidateRepoService.findAll() , HttpStatus.OK);
  			
  		} catch (Exception e) {
  			log.error("Couldn't serialize response for content type application/json", e);
  			return new ResponseEntity<List<ServiceCandidate>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
    }

    public ResponseEntity<ServiceCandidate> patchServiceCandidate(@ApiParam(value = "Identifier of the ServiceCandidate",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceCandidate to be updated" ,required=true )  @Valid @RequestBody ServiceCandidateUpdate serviceCandidate) {
        

        return new ResponseEntity<ServiceCandidate>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceCandidate> retrieveServiceCandidate(@ApiParam(value = "Identifier of the ServiceCandidate",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	try {

			return new ResponseEntity<ServiceCandidate>( candidateRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
