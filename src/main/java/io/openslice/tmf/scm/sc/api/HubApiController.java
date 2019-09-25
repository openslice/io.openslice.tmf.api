package io.openslice.tmf.scm.sc.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.model.Error;
import io.openslice.tmf.scm.model.EventSubscription;
import io.openslice.tmf.scm.model.EventSubscriptionInput;
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
public class HubApiController implements HubApi {

    private static final Logger log = LoggerFactory.getLogger(HubApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public HubApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<EventSubscription> registerListener(@ApiParam(value = "Data containing the callback endpoint to deliver the information" ,required=true )  @Valid @RequestBody EventSubscriptionInput data) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EventSubscription>(objectMapper.readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EventSubscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EventSubscription>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> unregisterListener(@ApiParam(value = "The id of the registered listener",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
