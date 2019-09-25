/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.scm.sc.api;

import io.openslice.tmf.scm.model.Error;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryUpdate;
import io.swagger.annotations.*;
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

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Api(value = "serviceCategory", description = "the serviceCategory API")
public interface ServiceCategoryApi {

    @ApiOperation(value = "Creates a ServiceCategory", nickname = "createServiceCategory", notes = "This operation creates a ServiceCategory entity.", response = ServiceCategory.class, tags={ "serviceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = ServiceCategory.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCategory",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    ResponseEntity<?> createServiceCategory(@ApiParam(value = "The ServiceCategory to be created" ,required=true )  @Valid @RequestBody ServiceCategoryCreate serviceCategory);


    @ApiOperation(value = "Deletes a ServiceCategory", nickname = "deleteServiceCategory", notes = "This operation deletes a ServiceCategory entity.", tags={ "serviceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCategory/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteServiceCategory(@ApiParam(value = "Identifier of the ServiceCategory",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "List or find ServiceCategory objects", nickname = "listServiceCategory", notes = "This operation list or find ServiceCategory entities", response = ServiceCategory.class, responseContainer = "List", tags={ "serviceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCategory",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ServiceCategory>> listServiceCategory(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit);


    @ApiOperation(value = "Updates partially a ServiceCategory", nickname = "patchServiceCategory", notes = "This operation updates partially a ServiceCategory entity.", response = ServiceCategory.class, tags={ "serviceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated", response = ServiceCategory.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCategory/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    ResponseEntity<ServiceCategory> patchServiceCategory(@ApiParam(value = "Identifier of the ServiceCategory",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceCategory to be updated" ,required=true )  @Valid @RequestBody ServiceCategoryUpdate serviceCategory);


    @ApiOperation(value = "Retrieves a ServiceCategory by ID", nickname = "retrieveServiceCategory", notes = "This operation retrieves a ServiceCategory entity. Attribute selection is enabled for all first level attributes.", response = ServiceCategory.class, tags={ "serviceCategory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/serviceCategory/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<ServiceCategory> retrieveServiceCategory(@ApiParam(value = "Identifier of the ServiceCategory",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields);

}
