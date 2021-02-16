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

import io.openslice.tmf.am642.model.ClearAlarms;
import io.openslice.tmf.am642.model.ClearAlarms;
import io.openslice.tmf.am642.model.ClearAlarmsCreate;
import io.openslice.tmf.am642.reposervices.ClearAlarmsRepoService;
import io.openslice.tmf.am642.reposervices.ClearAlarmsRepoService;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Controller
@RequestMapping("/alarmManagement/v4/")
public class ClearAlarmsApiController implements ClearAlarmsApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private static final Logger log = LoggerFactory.getLogger(ClearAlarmsApiController.class);

	@Autowired
	ClearAlarmsRepoService clearAlarmRepoService;
	
	
    @org.springframework.beans.factory.annotation.Autowired
    public ClearAlarmsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<ClearAlarms> createClearAlarms(@Valid ClearAlarmsCreate body) {
    	try {

    		ClearAlarms c = clearAlarmRepoService.addClearAlarm( body );

			return new ResponseEntity<ClearAlarms>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ClearAlarms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    @Override
	@Secured({ "ROLE_ADMIN" })
    public ResponseEntity<List<ClearAlarms>> listClearAlarms(@Valid String fields, @Valid Integer offset,
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
				return new ResponseEntity<List<ClearAlarms>>(						
						clearAlarmRepoService.findAll( myfields, allParams), HttpStatus.OK);
				
				
			} else {

				
				return new ResponseEntity<List<ClearAlarms>>(
						clearAlarmRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ClearAlarms>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @Override
	@Secured({ "ROLE_ADMIN" })
    public ResponseEntity<ClearAlarms> retrieveClearAlarms(String id, @Valid String fields) {
    	try {

			return new ResponseEntity<ClearAlarms>( clearAlarmRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ClearAlarms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    

}
