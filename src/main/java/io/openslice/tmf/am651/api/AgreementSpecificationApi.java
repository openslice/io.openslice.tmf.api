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
package io.openslice.tmf.am651.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.am651.model.AgreementSpecification;
import io.openslice.tmf.am651.model.AgreementSpecificationCreate;
import io.openslice.tmf.am651.model.AgreementSpecificationUpdate;
import io.openslice.tmf.am651.model.Error;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

@Api(value = "agreementSpecification", description = "the agreementSpecification API")
public interface AgreementSpecificationApi {

    Logger log = LoggerFactory.getLogger(AgreementSpecificationApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Creates a 'AgreementSpecification'", nickname = "createAgreementSpecification", notes = "", response = AgreementSpecification.class, tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = AgreementSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreementSpecification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<AgreementSpecification> createAgreementSpecification(@ApiParam(value = "The Agreement Specification to be created" ,required=true )  @Valid @RequestBody AgreementSpecificationCreate agreementSpecification) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"isBundle\" : true,  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"specCharacteristic\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  } ],  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"version\" : \"version\",  \"serviceCategory\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"specificationRelationship\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  } ],  \"attachment\" : [ {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  }, {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  } ],  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}", AgreementSpecification.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementSpecificationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Deletes a 'AgreementSpecification' by Id", nickname = "deleteAgreementSpecification", notes = "", tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreementSpecification/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteAgreementSpecification(@ApiParam(value = "Identifier of the Agreement Specification",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementSpecificationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "List or find 'AgreementSpecification' objects", nickname = "listAgreementSpecification", notes = "", response = AgreementSpecification.class, responseContainer = "List", tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = AgreementSpecification.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreementSpecification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<AgreementSpecification>> listAgreementSpecification(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"isBundle\" : true,  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"specCharacteristic\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  } ],  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"version\" : \"version\",  \"serviceCategory\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"specificationRelationship\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  } ],  \"attachment\" : [ {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  }, {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  } ],  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}, {  \"isBundle\" : true,  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"specCharacteristic\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  } ],  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"version\" : \"version\",  \"serviceCategory\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"specificationRelationship\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  } ],  \"attachment\" : [ {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  }, {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  } ],  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementSpecificationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates partially a 'AgreementSpecification' by Id", nickname = "patchAgreementSpecification", notes = "", response = AgreementSpecification.class, tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = AgreementSpecification.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreementSpecification/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<AgreementSpecification> patchAgreementSpecification(@ApiParam(value = "Identifier of the Agreement Specification",required=true) @PathVariable("id") String id,@ApiParam(value = "The Agreement Specification to be updated" ,required=true )  @Valid @RequestBody AgreementSpecificationUpdate agreementSpecification) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"isBundle\" : true,  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"specCharacteristic\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  } ],  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"version\" : \"version\",  \"serviceCategory\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"specificationRelationship\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  } ],  \"attachment\" : [ {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  }, {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  } ],  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}", AgreementSpecification.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementSpecificationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieves a 'AgreementSpecification' by Id", nickname = "retrieveAgreementSpecification", notes = "", response = AgreementSpecification.class, responseContainer = "List", tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = AgreementSpecification.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreementSpecification/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<AgreementSpecification>> retrieveAgreementSpecification(@ApiParam(value = "Identifier of the Agreement Specification",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"isBundle\" : true,  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"specCharacteristic\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  } ],  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"version\" : \"version\",  \"serviceCategory\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"specificationRelationship\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  } ],  \"attachment\" : [ {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  }, {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  } ],  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"}, {  \"isBundle\" : true,  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"specCharacteristic\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"specCharacteristicValue\" : [ {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    }, {      \"default\" : true,      \"valueTo\" : \"valueTo\",      \"unitOfMeasure\" : \"unitOfMeasure\",      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"valueType\" : \"valueType\",      \"value\" : \"value\",      \"valueFrom\" : \"valueFrom\"    } ],    \"@schemaLocation\" : \"@schemaLocation\",    \"configurable\" : true  } ],  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"version\" : \"version\",  \"serviceCategory\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"specificationRelationship\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  } ],  \"attachment\" : [ {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  }, {    \"@type\" : \"@type\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\",    \"url\" : \"url\"  } ],  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementSpecificationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
