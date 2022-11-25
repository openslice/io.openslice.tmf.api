/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.rpm685.api;

import java.io.IOException;
import java.security.Principal;
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

import io.openslice.tmf.rpm685.model.Error;
import io.openslice.tmf.rpm685.model.ResourcePool;
import io.openslice.tmf.rpm685.model.ResourcePoolCreate;
import io.openslice.tmf.rpm685.model.ResourcePoolUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Api(value = "resourcePool", description = "the resourcePool API")
public interface ResourcePoolApi {

	Logger log = LoggerFactory.getLogger(ResourcePoolApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "Creates a 'ResourcePool'", nickname = "createResourcePool", notes = "", response = ResourcePool.class, tags = {
			"resourcePool", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = ResourcePool.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/resourcePool", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<ResourcePool> createResourcePool(
			Principal principal,
			@ApiParam(value = "The Resource Pool to be created", required = true) @Valid @RequestBody ResourcePoolCreate body) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"{\r\n  \"@baseType\" : \"@baseType\",\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"href\" : \"href\",\r\n  \"id\" : \"id\",\r\n  \"@schemaLocation\" : \"@schemaLocation\",\r\n  \"relatedParty\" : \"relatedParty\",\r\n  \"resourceCollection\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"name\" : \"name\",\r\n    \"href\" : \"href\",\r\n    \"objectId\" : \"objectId\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"name\" : \"name\",\r\n    \"href\" : \"href\",\r\n    \"objectId\" : \"objectId\"\r\n  } ]\r\n}",
							ResourcePool.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default ResourcePoolApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "Deletes a 'ResourcePool' by Id", nickname = "deleteResourcePool", notes = "", tags = {
			"resourcePool", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Deleted"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/resourcePool/{id}", produces = { "application/json" }, method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteResourcePool(
			Principal principal,
			@ApiParam(value = "Identifier of the Resource Pool", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default ResourcePoolApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "Updates partially a 'ResourcePool' by Id", nickname = "patchResourcePool", notes = "", response = ResourcePool.class, tags = {
			"resourcePool", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated", response = ResourcePool.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/resourcePool/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PATCH)
	default ResponseEntity<ResourcePool> patchResourcePool(
			Principal principal,
			@ApiParam(value = "The Resource Pool to be updated", required = true) @Valid @RequestBody ResourcePoolUpdate body,
			@ApiParam(value = "Identifier of the Resource Pool", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"{\r\n  \"@baseType\" : \"@baseType\",\r\n  \"@type\" : \"@type\",\r\n  \"description\" : \"description\",\r\n  \"href\" : \"href\",\r\n  \"id\" : \"id\",\r\n  \"@schemaLocation\" : \"@schemaLocation\",\r\n  \"relatedParty\" : \"relatedParty\",\r\n  \"resourceCollection\" : [ {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"name\" : \"name\",\r\n    \"href\" : \"href\",\r\n    \"objectId\" : \"objectId\"\r\n  }, {\r\n    \"@referredType\" : \"@referredType\",\r\n    \"name\" : \"name\",\r\n    \"href\" : \"href\",\r\n    \"objectId\" : \"objectId\"\r\n  } ]\r\n}",
							ResourcePool.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default ResourcePoolApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "List or find ResourcePool objects", nickname = "listResourcePool", notes = "This operation list or find ResourcePool entities", response = ResourcePool.class, responseContainer = "List", tags = {
			"resourcePool", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResourcePool.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/resourcePool", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	default ResponseEntity<List<ResourcePool>> listResourcePool(Principal principal,
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "Retrieves a ResourcePool by ID", nickname = "retrieveResourcePool", notes = "This operation retrieves a ResourcePool entity. Attribute selection is enabled for all first level attributes.", response = ResourcePool.class, tags = {
			"resourcePool", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResourcePool.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/resourcePool/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	default ResponseEntity<ResourcePool> retrieveResourcePool(Principal principal,
			@ApiParam(value = "Identifier of the ResourcePool", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}