package io.openslice.tmf.scm.sc.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.model.Error;
import io.openslice.tmf.scm.model.ServiceCandidate;
import io.openslice.tmf.scm.model.ServiceCandidateCreate;
import io.openslice.tmf.scm.model.ServiceCandidateUpdate;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ServiceCandidateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ServiceCandidate> createServiceCandidate(@ApiParam(value = "The ServiceCandidate to be created" ,required=true )  @Valid @RequestBody ServiceCandidateCreate serviceCandidate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServiceCandidate>(objectMapper.readValue("{  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"serviceSpecification\" : {    \"targetServiceSchema\" : {      \"@baseType\" : \"@baseType\",      \"@type\" : \"@type\",      \"@schemaLocation\" : \"@schemaLocation\"    },    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"version\" : \"version\"  },  \"description\" : \"description\",  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"category\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"@schemaLocation\" : \"http://example.com/aeiou\"}", ServiceCandidate.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceCandidate>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteServiceCandidate(@ApiParam(value = "Identifier of the ServiceCandidate",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ServiceCandidate>> listServiceCandidate(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ServiceCandidate>>(objectMapper.readValue("[ {  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"serviceSpecification\" : {    \"targetServiceSchema\" : {      \"@baseType\" : \"@baseType\",      \"@type\" : \"@type\",      \"@schemaLocation\" : \"@schemaLocation\"    },    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"version\" : \"version\"  },  \"description\" : \"description\",  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"category\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"@schemaLocation\" : \"http://example.com/aeiou\"}, {  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"serviceSpecification\" : {    \"targetServiceSchema\" : {      \"@baseType\" : \"@baseType\",      \"@type\" : \"@type\",      \"@schemaLocation\" : \"@schemaLocation\"    },    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"version\" : \"version\"  },  \"description\" : \"description\",  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"category\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"@schemaLocation\" : \"http://example.com/aeiou\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ServiceCandidate>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ServiceCandidate>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceCandidate> patchServiceCandidate(@ApiParam(value = "Identifier of the ServiceCandidate",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceCandidate to be updated" ,required=true )  @Valid @RequestBody ServiceCandidateUpdate serviceCandidate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServiceCandidate>(objectMapper.readValue("{  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"serviceSpecification\" : {    \"targetServiceSchema\" : {      \"@baseType\" : \"@baseType\",      \"@type\" : \"@type\",      \"@schemaLocation\" : \"@schemaLocation\"    },    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"version\" : \"version\"  },  \"description\" : \"description\",  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"category\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"@schemaLocation\" : \"http://example.com/aeiou\"}", ServiceCandidate.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceCandidate>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceCandidate> retrieveServiceCandidate(@ApiParam(value = "Identifier of the ServiceCandidate",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServiceCandidate>(objectMapper.readValue("{  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"serviceSpecification\" : {    \"targetServiceSchema\" : {      \"@baseType\" : \"@baseType\",      \"@type\" : \"@type\",      \"@schemaLocation\" : \"@schemaLocation\"    },    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"version\" : \"version\"  },  \"description\" : \"description\",  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"category\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"@schemaLocation\" : \"http://example.com/aeiou\"}", ServiceCandidate.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceCandidate>(HttpStatus.NOT_IMPLEMENTED);
    }

}
