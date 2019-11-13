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
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.scm633.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.openslice.tmf.scm633.model.Error;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Api(value = "serviceSpecification", description = "the serviceSpecification API")
public interface ServiceSpecificationApi {

    @ApiOperation(value = "Creates a ServiceSpecification", nickname = "createServiceSpecification", notes = "This operation creates a ServiceSpecification entity.", response = ServiceSpecification.class, tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = ServiceSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    ResponseEntity<ServiceSpecification> createServiceSpecification(@ApiParam(value = "The ServiceSpecification to be created" ,required=true )  @Valid @RequestBody ServiceSpecificationCreate serviceSpecification);


    @ApiOperation(value = "Deletes a ServiceSpecification", nickname = "deleteServiceSpecification", notes = "This operation deletes a ServiceSpecification entity.", tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteServiceSpecification(@ApiParam(value = "Identifier of the ServiceSpecification",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "List or find ServiceSpecification objects", nickname = "listServiceSpecification", notes = "This operation list or find ServiceSpecification entities", response = ServiceSpecification.class, responseContainer = "List", tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceSpecification.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ServiceSpecification>> listServiceSpecification(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
    		@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
    		@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
    		@RequestParam Map<String,String> allParams);


    @ApiOperation(value = "Updates partially a ServiceSpecification", nickname = "patchServiceSpecification", notes = "This operation updates partially a ServiceSpecification entity.", response = ServiceSpecification.class, tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = ServiceSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    ResponseEntity<ServiceSpecification> patchServiceSpecification(@ApiParam(value = "Identifier of the ServiceSpecification",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceSpecification to be updated" ,required=true )  @Valid @RequestBody ServiceSpecificationUpdate serviceSpecification);


    @ApiOperation(value = "Retrieves a ServiceSpecification by ID", nickname = "retrieveServiceSpecification", notes = "This operation retrieves a ServiceSpecification entity. Attribute selection is enabled for all first level attributes.", response = ServiceSpecification.class, tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<ServiceSpecification> retrieveServiceSpecification(@ApiParam(value = "Identifier of the ServiceSpecification",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);

    @ApiOperation(value = "Clones a ServiceSpecification", nickname = "patchServiceSpecification", notes = "This operation clones a ServiceSpecification entity. The response is the cloned spec", response = ServiceSpecification.class, tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Cloned", response = ServiceSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification/{id}/clone",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    ResponseEntity<ServiceSpecification> cloneServiceSpecification(@ApiParam(value = "Identifier of the ServiceSpecification to clone",required=true) @PathVariable("id") String id );
    
    
    @ApiOperation(value = "Adds an attachment to a ServiceSpecification", nickname = "addAttachmentToServiceSpecification", notes = "This operation adds an attachment to a ServiceSpecification and updates partially a ServiceSpecification entity", response = ServiceSpecification.class, tags={ "serviceSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceSpecification/{id}/attachment",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<ServiceSpecification> addAttachmentToServiceSpecification(
    		@ApiParam(value = "Identifier of the ServiceSpecification",required=true) @PathVariable("id") String id, 
    		@ApiParam(value = "The Attachment object to be added" ,required=false )  @Valid @ModelAttribute("attachment") String attachment, 
    		@ApiParam(value = "The Attachment file to be added" ,required=false, name = "afile" )  @Valid MultipartFile file);

    
}
