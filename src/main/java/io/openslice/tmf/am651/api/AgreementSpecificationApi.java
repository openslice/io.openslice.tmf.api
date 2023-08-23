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

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.am651.model.AgreementSpecification;
import io.openslice.tmf.am651.model.AgreementSpecificationCreate;
import io.openslice.tmf.am651.model.AgreementSpecificationUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

@Tag(name = "agreementSpecification", description = "the agreementSpecification API")
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

    @Operation(summary = "Creates a 'AgreementSpecification'", operationId = "createAgreementSpecification", description = "", tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Created" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/agreementSpecification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<AgreementSpecification> createAgreementSpecification(@Parameter(description = "The Agreement Specification to be created" ,required=true )  @Valid @RequestBody AgreementSpecificationCreate agreementSpecification) {
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


    @Operation(summary = "Deletes a 'AgreementSpecification' by Id", operationId = "deleteAgreementSpecification", description = "", tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Deleted" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/agreementSpecification/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteAgreementSpecification(@Parameter(description = "Identifier of the Agreement Specification",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementSpecificationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "List or find 'AgreementSpecification' objects", operationId = "listAgreementSpecification", description = "" , tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode ="200", description = "Ok" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/agreementSpecification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<AgreementSpecification>> listAgreementSpecification(@Parameter(description = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
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


    @Operation(summary = "Updates partially a 'AgreementSpecification' by Id", operationId = "patchAgreementSpecification", description = "", tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode ="200", description = "Updated" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/agreementSpecification/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<AgreementSpecification> patchAgreementSpecification(@Parameter(description = "Identifier of the Agreement Specification",required=true) @PathVariable("id") String id,@Parameter(description = "The Agreement Specification to be updated" ,required=true )  @Valid @RequestBody AgreementSpecificationUpdate agreementSpecification) {
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


    @Operation(summary = "Retrieves a 'AgreementSpecification' by Id", operationId = "retrieveAgreementSpecification", description = "" , tags={ "agreementSpecification", })
    @ApiResponses(value = { 
        @ApiResponse(responseCode ="200", description = "Ok" ),
        @ApiResponse(responseCode = "400", description = "Bad Request" ),
        @ApiResponse(responseCode = "401", description = "Unauthorized" ),
        @ApiResponse(responseCode = "403", description = "Forbidden" ),
        @ApiResponse(responseCode = "404", description = "Not Found" ),
        @ApiResponse(responseCode = "405", description = "Method Not allowed" ),
        @ApiResponse(responseCode = "409", description = "Conflict" ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
    @RequestMapping(value = "/agreementSpecification/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<AgreementSpecification>> retrieveAgreementSpecification(@Parameter(description = "Identifier of the Agreement Specification",required=true) @PathVariable("id") String id) {
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
