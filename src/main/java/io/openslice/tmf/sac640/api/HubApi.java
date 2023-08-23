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
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.sac640.api;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.openslice.tmf.sac640.model.EventSubscription;
import io.openslice.tmf.sac640.model.EventSubscriptionInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
@Tag(name = "hub", description = "the hub API")
public interface HubApi {

    Logger log = LoggerFactory.getLogger(HubApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Register a listener", operationId = "registerListener", description = "Sets the communication endpoint address the service instance must use to deliver information about its health state, execution state, failures and metrics.", tags={ "events subscription", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Subscribed" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/hub",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> registerListener(@Parameter(description = "Data containing the callback endpoint to deliver the information" ,required=true )  @Valid @RequestBody EventSubscriptionInput body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default HubApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Unregister a listener", operationId = "unregisterListener", description = "Resets the communication endpoint address the service instance must use to deliver information about its health state, execution state, failures and metrics.", tags={ "events subscription", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Deleted"),
        @ApiResponse(responseCode = "400", description = "Bad request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method not allowed" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/hub/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> unregisterListener(@Parameter(description = "The id of the registered listener",required=true) @PathVariable("id") String id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default HubApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
