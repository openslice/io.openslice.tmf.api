/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.rcm634.api;

import java.io.IOException;
import java.time.OffsetDateTime;
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

import io.openslice.tmf.rcm634.model.Error;
import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalogUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Api(value = "resourceCatalog", description = "the resourceCatalog API")
public interface ResourceCatalogApi {

    Logger log = LoggerFactory.getLogger(ResourceCatalogApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Creates a 'ResourceCatalog'", nickname = "createResourceCatalog", notes = "", response = ResourceCatalog.class, tags={ "resourceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = ResourceCatalog.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCatalog",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ResourceCatalog> createResourceCatalog(@ApiParam(value = "The Resource Catalog to be created" ,required=true )  @Valid @RequestBody ResourceCatalogCreate resourceCatalog) {
 
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Deletes a 'ResourceCatalog' by Id", nickname = "deleteResourceCatalog", notes = "", tags={ "resourceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCatalog/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteResourceCatalog(@ApiParam(value = "Identifier of the Resource Catalog",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "List or find 'ResourceCatalog' objects", nickname = "listResourceCatalog", notes = "", response = ResourceCatalog.class, responseContainer = "List", tags={ "resourceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = ResourceCatalog.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCatalog",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<ResourceCatalog>> listResourceCatalog(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "For filtering: Name of the catalog") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "For filtering: Indicates the (class) type of catalog. For resource catalogs, this will be 'ResourceCatalog'.") @Valid @RequestParam(value = "@type", required = false) String type,@ApiParam(value = "For filtering: This field provides a link to the schema describing this REST resource") @Valid @RequestParam(value = "@schemaLocation", required = false) String schemaLocation,@ApiParam(value = "For filtering: Indicates<b> </b>the base (class) type of this REST resource") @Valid @RequestParam(value = "@baseType", required = false) String baseType,@ApiParam(value = "For filtering: Catalog version") @Valid @RequestParam(value = "version", required = false) String version,@ApiParam(value = "For filtering: An instant of time, starting at the TimePeriod") @Valid @RequestParam(value = "validFor.startDateTime", required = false) OffsetDateTime validForStartDateTime,@ApiParam(value = "For filtering: An instant of time, ending at the TimePeriod.") @Valid @RequestParam(value = "validFor.endDateTime", required = false) OffsetDateTime validForEndDateTime,@ApiParam(value = "For filtering: Date and time of the last update") @Valid @RequestParam(value = "lastUpdate", required = false) OffsetDateTime lastUpdate,@ApiParam(value = "For filtering: Used to indicate the current lifecycle status") @Valid @RequestParam(value = "lifecycleStatus", required = false) String lifecycleStatus,@ApiParam(value = "For filtering: Role of the related party.") @Valid @RequestParam(value = "relatedParty.role", required = false) String relatedPartyRole,@ApiParam(value = "For filtering: Name of the related party") @Valid @RequestParam(value = "relatedParty.name", required = false) String relatedPartyName,@ApiParam(value = "For filtering: Category version") @Valid @RequestParam(value = "category.version", required = false) String categoryVersion,@ApiParam(value = "For filtering: Name of the category") @Valid @RequestParam(value = "category.name", required = false) String categoryName,@ApiParam(value = "For filtering: the class type of the category") @Valid @RequestParam(value = "category.@type", required = false) String categoryType) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : [ {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  }, {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  } ]}, {  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : [ {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  }, {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates partially a 'ResourceCatalog' by Id", nickname = "patchResourceCatalog", notes = "", response = ResourceCatalog.class, tags={ "resourceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Updated", response = ResourceCatalog.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCatalog/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<ResourceCatalog> patchResourceCatalog(@ApiParam(value = "Identifier of the Resource Catalog",required=true) @PathVariable("id") String id,@ApiParam(value = "The Resource Catalog to be updated" ,required=true )  @Valid @RequestBody ResourceCatalogUpdate resourceCatalog) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : [ {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  }, {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  } ]}", ResourceCatalog.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Retrieves a 'ResourceCatalog' by Id", nickname = "retrieveResourceCatalog", notes = "", response = ResourceCatalog.class, responseContainer = "List", tags={ "resourceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = ResourceCatalog.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/resourceCatalog/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<List<ResourceCatalog>> retrieveResourceCatalog(@ApiParam(value = "Identifier of the Resource Catalog",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : [ {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  }, {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  } ]}, {  \"lifecycleStatus\" : \"lifecycleStatus\",  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"description\" : \"description\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"version\" : \"version\",  \"@baseType\" : \"@baseType\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : [ {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  }, {    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\",    \"version\" : \"version\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResourceCatalogApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}