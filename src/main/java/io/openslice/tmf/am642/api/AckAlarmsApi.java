/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.am642.api;

import io.openslice.tmf.am642.model.Alarm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T12:06:56.372977300+02:00[Europe/Athens]")
@Api(value = "ackAlarms", description = "the ackAlarms API")
public interface AckAlarmsApi {

    Logger log = LoggerFactory.getLogger(AckAlarmsApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "ackAlarms", nickname = "ackAlarms", notes = "", response = Alarm.class, tags={ "alarms", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Alarms", response = Alarm.class) })
    @RequestMapping(value = "/ackAlarms",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Alarm> ackAlarms(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Alarm body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"alarmedObjectType\" : \"alarmedObjectType\",\r\n  \"@type\" : \"@type\",\r\n  \"proposedRepairedActions\" : \"proposedRepairedActions\",\r\n  \"correlatedAlarm\" : [ {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  }, {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  } ],\r\n  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"alarmedObject\" : {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  },\r\n  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"@baseType\" : \"@baseType\",\r\n  \"perceivedSeverity\" : \"perceivedSeverity\",\r\n  \"affectedService\" : [ {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  }, {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  } ],\r\n  \"ackSystemId\" : \"ackSystemId\",\r\n  \"id\" : 0,\r\n  \"href\" : \"href\",\r\n  \"state\" : \"state\",\r\n  \"@schemaLocation\" : \"@schemaLocation\",\r\n  \"crossedThresholdInformation\" : {\r\n    \"indicatorName\" : \"indicatorName\",\r\n    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",\r\n    \"granularity\" : \"granularity\",\r\n    \"observedValue\" : \"observedValue\",\r\n    \"thresholdId\" : \"thresholdId\",\r\n    \"thresholdRef\" : \"thresholdRef\",\r\n    \"indicatorUnit\" : \"indicatorUnit\",\r\n    \"direction\" : \"direction\"\r\n  },\r\n  \"externalAlarmId\" : \"externalAlarmId\",\r\n  \"clearSystemId\" : \"clearSystemId\",\r\n  \"parentAlarm\" : [ {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  }, {\r\n    \"href\" : \"href\",\r\n    \"id\" : \"id\"\r\n  } ],\r\n  \"isRootCause\" : \"isRootCause\",\r\n  \"ackUserId\" : \"ackUserId\",\r\n  \"comments\" : [ {\r\n    \"systemId\" : \"systemId\",\r\n    \"comment\" : \"comment\",\r\n    \"time\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"userId\" : \"userId\"\r\n  }, {\r\n    \"systemId\" : \"systemId\",\r\n    \"comment\" : \"comment\",\r\n    \"time\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"userId\" : \"userId\"\r\n  } ],\r\n  \"sourceSystemId\" : \"sourceSystemId\",\r\n  \"clearUserId\" : \"clearUserId\",\r\n  \"serviceAffecting\" : \"serviceAffecting\",\r\n  \"alarmEscelation\" : \"alarmEscelation\",\r\n  \"ackState\" : \"ackState\",\r\n  \"alarmType\" : \"alarmType\",\r\n  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",\r\n  \"alarmDetails\" : \"alarmDetails\"\r\n}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AckAlarmsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
