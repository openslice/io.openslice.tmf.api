/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.cm629.api;

import io.openslice.tmf.cm629.model.Customer;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.model.CustomerUpdate;
import io.openslice.tmf.cm629.model.Error;
import io.openslice.tmf.cm629.service.CustomerRepoService;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")


@Api(value = "customer", description = "the customer API")
public interface CustomerApi {

    Logger log = LoggerFactory.getLogger(CustomerApi.class);


	
    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Creates a Customer", nickname = "createCustomer", notes = "This operation creates a Customer entity.", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Customer.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/customer",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<Customer> createCustomer(@ApiParam(value = "The Customer to be created" ,required=true )  @Valid @RequestBody CustomerCreate customer) {
    	
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ApiOperation(value = "Deletes a Customer", nickname = "deleteCustomer", notes = "This operation deletes a Customer entity.", tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/customer/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteCustomer(@ApiParam(value = "Identifier of the Customer",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CustomerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "List or find Customer objects", nickname = "listCustomer", notes = "This operation list or find Customer entities", response = Customer.class, responseContainer = "List", tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Customer.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/customer",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Customer>> listCustomer(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"contactMedium\" : [ {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  }, {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"agreement\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"characteristic\" : [ {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  }, {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  } ],  \"statusReason\" : \"statusReason\",  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"account\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"engagedParty\" : {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  },  \"status\" : \"status\"}, {  \"contactMedium\" : [ {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  }, {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"agreement\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"characteristic\" : [ {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  }, {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  } ],  \"statusReason\" : \"statusReason\",  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"account\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"engagedParty\" : {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  },  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CustomerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates partially a Customer", nickname = "patchCustomer", notes = "This operation updates partially a Customer entity.", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = Customer.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/customer/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    default ResponseEntity<Customer> patchCustomer(@ApiParam(value = "Identifier of the Customer",required=true) @PathVariable("id") String id,@ApiParam(value = "The Customer to be updated" ,required=true )  @Valid @RequestBody CustomerUpdate customer) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"contactMedium\" : [ {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  }, {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"agreement\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"characteristic\" : [ {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  }, {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  } ],  \"statusReason\" : \"statusReason\",  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"account\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"engagedParty\" : {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  },  \"status\" : \"status\"}", Customer.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CustomerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieves a Customer by ID", nickname = "retrieveCustomer", notes = "This operation retrieves a Customer entity. Attribute selection is enabled for all first level attributes.", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Customer.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/customer/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    default ResponseEntity<Customer> retrieveCustomer(@ApiParam(value = "Identifier of the Customer",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"contactMedium\" : [ {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  }, {    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"mediumType\" : \"mediumType\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"city\" : \"city\",      \"@type\" : \"@type\",      \"contactType\" : \"contactType\",      \"socialNetworkId\" : \"socialNetworkId\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"@baseType\" : \"@baseType\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"@schemaLocation\" : \"http://example.com/aeiou\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"@baseType\" : \"@baseType\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"@type\" : \"@type\",    \"creditRiskRating\" : 0,    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"agreement\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"relatedParty\" : [ {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"characteristic\" : [ {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  }, {    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"valueType\" : \"valueType\",    \"name\" : \"name\",    \"@schemaLocation\" : \"http://example.com/aeiou\",    \"value\" : { }  } ],  \"statusReason\" : \"statusReason\",  \"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"http://example.com/aeiou\",  \"account\" : [ {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  }, {    \"@referredType\" : \"@referredType\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  } ],  \"engagedParty\" : {    \"@referredType\" : \"@referredType\",    \"role\" : \"role\",    \"@baseType\" : \"@baseType\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"@schemaLocation\" : \"http://example.com/aeiou\"  },  \"status\" : \"status\"}", Customer.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CustomerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
