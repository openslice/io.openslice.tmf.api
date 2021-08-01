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

import io.openslice.tmf.am651.model.Agreement;
import io.openslice.tmf.am651.model.AgreementCreate;
import io.openslice.tmf.am651.model.AgreementUpdate;
import io.openslice.tmf.am651.model.Error;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

@Api(value = "agreement", description = "the agreement API")
public interface AgreementApi {

    Logger log = LoggerFactory.getLogger(AgreementApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Creates a 'Agreement'", nickname = "createAgreement", notes = "", response = Agreement.class, tags={ "agreement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Agreement.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreement",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Agreement> createAgreement(@ApiParam(value = "The Agreement to be created" ,required=true )  @Valid @RequestBody AgreementCreate agreement) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"agreementPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"associatedAgreement\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"documentNumber\" : 0,  \"agreementSpecification\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"type\" : \"type\",  \"version\" : \"version\",  \"initialDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"engagedPartyRole\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  } ],  \"characteristic\" : [ {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  \"agreementAuthorization\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  } ],  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"completionDate\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"statementOfIntent\" : \"statementOfIntent\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"agreementItem\" : [ {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  }, {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  } ],  \"status\" : \"status\"}", Agreement.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Deletes a 'Agreement' by Id", nickname = "deleteAgreement", notes = "", tags={ "agreement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted", response = Object.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreement/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteAgreement(@ApiParam(value = "Identifier of the Agreement",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "List or find 'Agreement' objects", nickname = "listAgreement", notes = "", response = Agreement.class, responseContainer = "List", tags={ "agreement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = Agreement.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreement",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<Agreement>> listAgreement(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"agreementPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"associatedAgreement\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"documentNumber\" : 0,  \"agreementSpecification\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"type\" : \"type\",  \"version\" : \"version\",  \"initialDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"engagedPartyRole\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  } ],  \"characteristic\" : [ {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  \"agreementAuthorization\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  } ],  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"completionDate\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"statementOfIntent\" : \"statementOfIntent\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"agreementItem\" : [ {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  }, {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  } ],  \"status\" : \"status\"}, {  \"agreementPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"associatedAgreement\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"documentNumber\" : 0,  \"agreementSpecification\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"type\" : \"type\",  \"version\" : \"version\",  \"initialDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"engagedPartyRole\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  } ],  \"characteristic\" : [ {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  \"agreementAuthorization\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  } ],  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"completionDate\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"statementOfIntent\" : \"statementOfIntent\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"agreementItem\" : [ {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  }, {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  } ],  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates partially a 'Agreement' by Id", nickname = "patchAgreement", notes = "", response = Agreement.class, tags={ "agreement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = Agreement.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreement/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<Agreement> patchAgreement(@ApiParam(value = "Identifier of the Agreement",required=true) @PathVariable("id") String id,@ApiParam(value = "The Agreement to be updated" ,required=true )  @Valid @RequestBody AgreementUpdate agreement) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"agreementPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"associatedAgreement\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"documentNumber\" : 0,  \"agreementSpecification\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"type\" : \"type\",  \"version\" : \"version\",  \"initialDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"engagedPartyRole\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  } ],  \"characteristic\" : [ {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  \"agreementAuthorization\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  } ],  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"completionDate\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"statementOfIntent\" : \"statementOfIntent\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"agreementItem\" : [ {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  }, {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  } ],  \"status\" : \"status\"}", Agreement.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieves a 'Agreement' by Id", nickname = "retrieveAgreement", notes = "", response = Agreement.class, responseContainer = "List", tags={ "agreement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = Agreement.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/agreement/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<Agreement>> retrieveAgreement(@ApiParam(value = "Identifier of the Agreement",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"agreementPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"associatedAgreement\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"documentNumber\" : 0,  \"agreementSpecification\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"type\" : \"type\",  \"version\" : \"version\",  \"initialDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"engagedPartyRole\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  } ],  \"characteristic\" : [ {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  \"agreementAuthorization\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  } ],  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"completionDate\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"statementOfIntent\" : \"statementOfIntent\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"agreementItem\" : [ {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  }, {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  } ],  \"status\" : \"status\"}, {  \"agreementPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"associatedAgreement\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"documentNumber\" : 0,  \"agreementSpecification\" : {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"type\" : \"type\",  \"version\" : \"version\",  \"initialDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"engagedPartyRole\" : [ {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  }, {    \"@referredType\" : \"@referredType\",    \"name\" : \"name\",    \"partyName\" : \"partyName\",    \"href\" : \"href\",    \"id\" : \"id\",    \"partyId\" : \"partyId\"  } ],  \"characteristic\" : [ {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  \"agreementAuthorization\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"@type\" : \"@type\",    \"signatureRepresentation\" : \"signatureRepresentation\",    \"state\" : \"state\"  } ],  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"completionDate\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"statementOfIntent\" : \"statementOfIntent\",  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"agreementItem\" : [ {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  }, {    \"termOrCondition\" : [ {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    }, {      \"validFor\" : {        \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",        \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"      },      \"@type\" : \"@type\",      \"description\" : \"description\",      \"id\" : \"id\"    } ],    \"productOffering\" : [ {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    }, {      \"@referredType\" : \"@referredType\",      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    } ],    \"@type\" : \"@type\"  } ],  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AgreementApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
