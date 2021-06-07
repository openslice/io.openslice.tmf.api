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
package io.openslice.tmf.rcm634.api;

import io.openslice.tmf.rcm634.model.Error;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryUpdate;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Api(value = "resourceCategory", description = "the resourceCategory API")
public interface ResourceCategoryApi {

    Logger log = LoggerFactory.getLogger(ResourceCategoryApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Creates a ResourceCategory", nickname = "createResourceCategory", notes = "This operation creates a ResourceCategory entity.", response = ResourceCategory.class, tags={ "resourceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = ResourceCategory.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCategory",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<ResourceCategory> createResourceCategory(@ApiParam(value = "The ResourceCategory to be created" ,required=true )  @Valid @RequestBody ResourceCategoryCreate body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"isRoot\" : true,\r\n  \"lifecycleStatus\" : \"lifecycleStatus\",\r\n  \"validFor\" : {\r\n    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"\r\n  },\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"relatedParty\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  } ],\r\n  \"version\" : \"version\",\r\n  \"resourceCandidate\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"parentId\" : \"parentId\",\r\n  \"@baseType\" : \"@baseType\",\r\n  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"name\" : \"name\",\r\n  \"id\" : \"id\",\r\n  \"href\" : \"href\",\r\n  \"category\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n}", ResourceCategory.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCategoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Deletes a ResourceCategory", nickname = "deleteResourceCategory", notes = "This operation deletes a ResourceCategory entity.", tags={ "resourceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCategory/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteResourceCategory(@ApiParam(value = "Identifier of the ResourceCategory",required=true) @PathVariable("id") String id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCategoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "List or find ResourceCategory objects", nickname = "listResourceCategory", notes = "This operation list or find ResourceCategory entities", response = ResourceCategory.class, responseContainer = "List", tags={ "resourceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ResourceCategory.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCategory",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ResourceCategory>> listResourceCategory(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields
,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\r\n  \"isRoot\" : true,\r\n  \"lifecycleStatus\" : \"lifecycleStatus\",\r\n  \"validFor\" : {\r\n    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"\r\n  },\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"relatedParty\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  } ],\r\n  \"version\" : \"version\",\r\n  \"resourceCandidate\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"parentId\" : \"parentId\",\r\n  \"@baseType\" : \"@baseType\",\r\n  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"name\" : \"name\",\r\n  \"id\" : \"id\",\r\n  \"href\" : \"href\",\r\n  \"category\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n}, {\r\n  \"isRoot\" : true,\r\n  \"lifecycleStatus\" : \"lifecycleStatus\",\r\n  \"validFor\" : {\r\n    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"\r\n  },\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"relatedParty\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  } ],\r\n  \"version\" : \"version\",\r\n  \"resourceCandidate\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"parentId\" : \"parentId\",\r\n  \"@baseType\" : \"@baseType\",\r\n  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"name\" : \"name\",\r\n  \"id\" : \"id\",\r\n  \"href\" : \"href\",\r\n  \"category\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCategoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates partially a ResourceCategory", nickname = "patchResourceCategory", notes = "This operation updates partially a ResourceCategory entity.", response = ResourceCategory.class, tags={ "resourceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = ResourceCategory.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCategory/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    default ResponseEntity<ResourceCategory> patchResourceCategory(@ApiParam(value = "The ResourceCategory to be updated" ,required=true )  @Valid @RequestBody ResourceCategoryUpdate body
,@ApiParam(value = "Identifier of the ResourceCategory",required=true) @PathVariable("id") String id
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"isRoot\" : true,\r\n  \"lifecycleStatus\" : \"lifecycleStatus\",\r\n  \"validFor\" : {\r\n    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"\r\n  },\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"relatedParty\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  } ],\r\n  \"version\" : \"version\",\r\n  \"resourceCandidate\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"parentId\" : \"parentId\",\r\n  \"@baseType\" : \"@baseType\",\r\n  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"name\" : \"name\",\r\n  \"id\" : \"id\",\r\n  \"href\" : \"href\",\r\n  \"category\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n}", ResourceCategory.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCategoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieves a ResourceCategory by ID", nickname = "retrieveResourceCategory", notes = "This operation retrieves a ResourceCategory entity. Attribute selection is enabled for all first level attributes.", response = ResourceCategory.class, tags={ "resourceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ResourceCategory.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCategory/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<ResourceCategory> retrieveResourceCategory(@ApiParam(value = "Identifier of the ResourceCategory",required=true) @PathVariable("id") String id
,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"isRoot\" : true,\r\n  \"lifecycleStatus\" : \"lifecycleStatus\",\r\n  \"validFor\" : {\r\n    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\r\n    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"\r\n  },\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"relatedParty\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"role\" : \"role\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n  } ],\r\n  \"version\" : \"version\",\r\n  \"resourceCandidate\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"parentId\" : \"parentId\",\r\n  \"@baseType\" : \"@baseType\",\r\n  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",\r\n  \"name\" : \"name\",\r\n  \"id\" : \"id\",\r\n  \"href\" : \"href\",\r\n  \"category\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"@baseType\" : \"@baseType\",\r\n    \"@type\" : \"@type\",\r\n    \"name\" : \"name\",\r\n    \"id\" : \"id\",\r\n    \"href\" : \"href\",\r\n    \"@schemaLocation\" : \"http://example.com/aeiou\",\r\n    \"version\" : \"version\"\r\n  } ],\r\n  \"@schemaLocation\" : \"http://example.com/aeiou\"\r\n}", ResourceCategory.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCategoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
