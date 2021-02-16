package io.openslice.tmf.am642.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.am642.model.UnGroupAlarms;
import io.openslice.tmf.am642.model.UnGroupAlarms;
import io.openslice.tmf.am642.model.UnGroupAlarmsCreate;
import io.openslice.tmf.am642.reposervices.UnGroupAlarmsRepoService;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Controller
@RequestMapping("/alarmManagement/v4/")
public class UnGroupAlarmsApiController implements UnGroupAlarmsApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private static final Logger log = LoggerFactory.getLogger(UnGroupAlarmsApiController.class);
    

	@Autowired
	UnGroupAlarmsRepoService UnGroupAlarmRepoService;
	
	
    @org.springframework.beans.factory.annotation.Autowired
    public UnGroupAlarmsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
	@Secured({ "ROLE_ADMIN" })
    public ResponseEntity<UnGroupAlarms> createUnGroupAlarms(@Valid UnGroupAlarmsCreate body) {
    	try {

			UnGroupAlarms c = UnGroupAlarmRepoService.addUnGroupAlarms(body);

			return new ResponseEntity<UnGroupAlarms>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<UnGroupAlarms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    @Override
	@Secured({ "ROLE_ADMIN" })
    public ResponseEntity<UnGroupAlarms> retrieveUnGroupAlarms(String id, @Valid String fields) {
    	try {

			return new ResponseEntity<UnGroupAlarms>(UnGroupAlarmRepoService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<UnGroupAlarms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    @Override
	@Secured({ "ROLE_ADMIN" })
    public ResponseEntity<List<UnGroupAlarms>> listUnGroupAlarms(@Valid String fields, @Valid Integer offset,
    		@Valid Integer limit, Map<String, String> allParams) {
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
				return new ResponseEntity<List<UnGroupAlarms>>(UnGroupAlarmRepoService.findAll(myfields, allParams),
						HttpStatus.OK);

			} else {

				return new ResponseEntity<List<UnGroupAlarms>>(UnGroupAlarmRepoService.findAll(fields, allParams),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<UnGroupAlarms>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
