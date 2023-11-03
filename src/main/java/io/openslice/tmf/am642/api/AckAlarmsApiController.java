/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.am642.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.am642.model.AckAlarms;
import io.openslice.tmf.am642.model.AckAlarmsCreate;
import io.openslice.tmf.am642.reposervices.AckAlarmsRepoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Controller
@RequestMapping("/alarmManagement/v4/")
public class AckAlarmsApiController implements AckAlarmsApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private static final Logger log = LoggerFactory.getLogger(AckAlarmsApiController.class);

    @org.springframework.beans.factory.annotation.Autowired
    public AckAlarmsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    

	@Autowired
    AckAlarmsRepoService ackAlarmRepoService;

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
    public ResponseEntity<AckAlarms> createAckAlarms(@Valid AckAlarmsCreate body) {
    	try {

    		AckAlarms c = ackAlarmRepoService.addAckAlarm( body );

			return new ResponseEntity<AckAlarms>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<AckAlarms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
    @Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    public ResponseEntity<List<AckAlarms>> listAckAlarms(@Valid String fields, @Valid Integer offset,
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
				return new ResponseEntity<List<AckAlarms>>(						
						ackAlarmRepoService.findAll( myfields, allParams), HttpStatus.OK);
				
				
			} else {

				
				return new ResponseEntity<List<AckAlarms>>(
						ackAlarmRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<AckAlarms>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @Override
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    public ResponseEntity<AckAlarms> retrieveAckAlarms(String id, @Valid String fields) {
    	try {

			return new ResponseEntity<AckAlarms>( ackAlarmRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<AckAlarms>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
