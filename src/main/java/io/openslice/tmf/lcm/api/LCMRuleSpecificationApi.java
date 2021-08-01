package io.openslice.tmf.lcm.api;

import java.util.List;
import java.util.Map;
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

import io.openslice.tmf.lcm.model.LCMRuleSpecification;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationCreate;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "lcmRuleSpecification")
public interface LCMRuleSpecificationApi {


	Logger log = LoggerFactory.getLogger(LCMRuleSpecificationApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "Creates a LCM RuleSpecification", nickname = "createLCMRuleSpecification", notes = "This operation creates a LCM RuleSpecification entity.", response = LCMRuleSpecification.class, tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = LCMRuleSpecification.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/lcmRuleSpecification", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.POST)
	default ResponseEntity<LCMRuleSpecification> createLCMRuleSpecification(
			@ApiParam(value = "The RuleSpecification to be created", required = true) @Valid @RequestBody LCMRuleSpecificationCreate body) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "Deletes a LCM RuleSpecification", nickname = "deleteLCMRuleSpecification", notes = "This operation deletes a LCM RuleSpecification entity.", tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Deleted", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/lcmRuleSpecification/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteLCMRuleSpecification(
			@ApiParam(value = "Identifier of the RuleSpecification", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default LCM RuleSpecificationApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "List or find LCM RuleSpecification objects", nickname = "listLCMRuleSpecification", notes = "This operation list or find LCM RuleSpecification entities", response = LCMRuleSpecification.class, responseContainer = "List", tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = LCMRuleSpecification.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/lcmRuleSpecification", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	ResponseEntity<List<LCMRuleSpecification>> listLCMRuleSpecification(
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
			@ApiParam(hidden = true) @Valid @RequestParam Map<String, String> allParams);

	
	@ApiOperation(value = "List or find LCM RuleSpecification objects by Service Specification ID", nickname = "listLCMRuleSpecificationsByServiceSpecID", notes = "This operation list or find LCM RuleSpecification entities by SpecID", response = LCMRuleSpecification.class, responseContainer = "List", tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = LCMRuleSpecification.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/lcmRuleSpecification/serviceSpec/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	ResponseEntity<List<LCMRuleSpecification>> listLCMRuleSpecificationBySpecID(
			@ApiParam(value = "Identifier of the ServiceSpecification Id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
			@ApiParam(hidden = true) @Valid @RequestParam Map<String, String> allParams);

	
	
	@ApiOperation(value = "Updates partially a LCM RuleSpecification", nickname = "patchLCMRuleSpecification", notes = "This operation updates partially a LCM RuleSpecification entity.", response = LCMRuleSpecification.class, tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated", response = LCMRuleSpecification.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/lcmRuleSpecification/{id}", produces = {
			"application/json;charset=utf-8" }, consumes = {
					"application/json;charset=utf-8" }, method = RequestMethod.PATCH)
	default ResponseEntity<LCMRuleSpecification> patchLCMRuleSpecification(
			@ApiParam(value = "The LCM RuleSpecification to be updated", required = true) @Valid @RequestBody LCMRuleSpecificationUpdate body,
			@ApiParam(value = "Identifier of the LCM RuleSpecification", required = true) @PathVariable("id") String id) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "Retrieves a LCM RuleSpecification by ID", nickname = "retrieveLCMRuleSpecification", notes = "This operation retrieves a LCM RuleSpecification entity. Attribute selection is enabled for all first level attributes.", response = LCMRuleSpecification.class, tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = LCMRuleSpecification.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/lcmRuleSpecification/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	default ResponseEntity<LCMRuleSpecification> retrieveLCMRuleSpecification(
			@ApiParam(value = "Identifier of the LCM RuleSpecification", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}

