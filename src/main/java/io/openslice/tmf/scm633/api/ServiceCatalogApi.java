/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.scm633.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.scm633.model.Error;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCatalogUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Api(value = "serviceCatalog", description = "the serviceCatalog API")
public interface ServiceCatalogApi {

    @ApiOperation(value = "Creates a ServiceCatalog", nickname = "createServiceCatalog", notes = "This operation creates a ServiceCatalog entity.", response = ServiceCatalog.class, tags={ "serviceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = ServiceCatalog.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCatalog",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    ResponseEntity<ServiceCatalog> createServiceCatalog(@ApiParam(value = "The ServiceCatalog to be created" ,required=true )  @Valid @RequestBody ServiceCatalogCreate serviceCatalog);


    @ApiOperation(value = "Deletes a ServiceCatalog", nickname = "deleteServiceCatalog", notes = "This operation deletes a ServiceCatalog entity.", tags={ "serviceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCatalog/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteServiceCatalog(@ApiParam(value = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "List or find ServiceCatalog objects", nickname = "listServiceCatalog", notes = "This operation list or find ServiceCatalog entities", response = ServiceCatalog.class, responseContainer = "List", tags={ "serviceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceCatalog.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCatalog",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ServiceCatalog>> listServiceCatalog(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);


    @ApiOperation(value = "Updates partially a ServiceCatalog", nickname = "patchServiceCatalog", notes = "This operation updates partially a ServiceCatalog entity.", response = ServiceCatalog.class, tags={ "serviceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = ServiceCatalog.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCatalog/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    ResponseEntity<ServiceCatalog> patchServiceCatalog(@ApiParam(value = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceCatalog to be updated" ,required=true )  @Valid @RequestBody ServiceCatalogUpdate serviceCatalog);


    @ApiOperation(value = "Retrieves a ServiceCatalog by ID", nickname = "retrieveServiceCatalog", notes = "This operation retrieves a ServiceCatalog entity. Attribute selection is enabled for all first level attributes.", response = ServiceCatalog.class, tags={ "serviceCatalog", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceCatalog.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCatalog/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<ServiceCatalog> retrieveServiceCatalog(@ApiParam(value = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);

}
