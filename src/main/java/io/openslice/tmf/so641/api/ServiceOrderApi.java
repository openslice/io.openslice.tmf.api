/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.so641.api;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.so641.model.Error;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Api(value = "serviceOrder", description = "the serviceOrder API")
public interface ServiceOrderApi {

    Logger log = LoggerFactory.getLogger(ServiceOrderApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Creates a ServiceOrder", nickname = "createServiceOrder", notes = "This operation creates a ServiceOrder entity.", response = ServiceOrder.class, tags={ "serviceOrder", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = ServiceOrder.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceOrder",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<ServiceOrder> createServiceOrder(
			Principal principal,
			@ApiParam(value = "The ServiceOrder to be created" ,required=true )  @Valid @RequestBody ServiceOrderCreate serviceOrder) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Deletes a ServiceOrder", nickname = "deleteServiceOrder", notes = "This operation deletes a ServiceOrder entity.", tags={ "serviceOrder", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted", response = Object.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceOrder/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteServiceOrder(
			Principal principal,
			@ApiParam(value = "Identifier of the ServiceOrder",required=true) @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "List or find ServiceOrder objects", nickname = "listServiceOrder", notes = "This operation list or find ServiceOrder entities", response = ServiceOrder.class, responseContainer = "List", tags={ "serviceOrder", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceOrder.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceOrder",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ServiceOrder>> listServiceOrder(
			Principal principal,			
    		@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
    		@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
    		@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
    		@ApiParam(value = "Requested starttime for start of resources to be provided in response") @Valid @RequestParam(value = "starttime", required = false)  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date starttime,
    		@ApiParam(value = "Requested endtime for start of resources to be provided in response") @Valid @RequestParam(value = "endtime", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date endtime    		
			) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates partially a ServiceOrder", nickname = "patchServiceOrder", notes = "This operation updates partially a ServiceOrder entity.", response = ServiceOrder.class, tags={ "serviceOrder", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = ServiceOrder.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceOrder/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    default ResponseEntity<ServiceOrder> patchServiceOrder(
			Principal principal,
			@ApiParam(value = "Identifier of the ServiceOrder",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceOrder to be updated" ,required=true )  @Valid @RequestBody ServiceOrderUpdate serviceOrder) {
    	return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieves a ServiceOrder by ID", nickname = "retrieveServiceOrder", notes = "This operation retrieves a ServiceOrder entity. Attribute selection is enabled for all first level attributes.", response = ServiceOrder.class, tags={ "serviceOrder", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceOrder.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceOrder/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ServiceOrder> retrieveServiceOrder(
			Principal principal,			
    		@ApiParam(value = "Identifier of the ServiceOrder",required=true) @PathVariable("id") String id,
    		@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
      
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
