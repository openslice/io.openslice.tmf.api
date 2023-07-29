package io.openslice.tmf.lcm.api;

import java.util.List;
import java.util.Map;
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

import io.openslice.tmf.lcm.model.LCMRuleSpecification;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationCreate;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@Tag(name = "lcmRuleSpecification")
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

	@Operation(summary = "Creates a LCM RuleSpecification", operationId = "createLCMRuleSpecification", description = "This operation creates a LCM RuleSpecification entity." , tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Created" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ),
			@ApiResponse(responseCode = "403", description = "Forbidden" ),
			@ApiResponse(responseCode = "405", description = "Method Not allowed" ),
			@ApiResponse(responseCode = "409", description = "Conflict" ),
			@ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
	@RequestMapping(value = "/lcmRuleSpecification", produces = { "application/json;charset=utf-8" }, consumes = {
			"application/json;charset=utf-8" }, method = RequestMethod.POST)
	default ResponseEntity<LCMRuleSpecification> createLCMRuleSpecification(
			@Parameter(description = "The RuleSpecification to be created", required = true) @Valid @RequestBody LCMRuleSpecificationCreate body) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Operation(summary = "Deletes a LCM RuleSpecification", operationId = "deleteLCMRuleSpecification", description = "This operation deletes a LCM RuleSpecification entity.", tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Deleted" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ),
			@ApiResponse(responseCode = "403", description = "Forbidden" ),
			@ApiResponse(responseCode = "404", description = "Not Found" ),
			@ApiResponse(responseCode = "405", description = "Method Not allowed" ),
			@ApiResponse(responseCode = "409", description = "Conflict" ),
			@ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
	@RequestMapping(value = "/lcmRuleSpecification/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.DELETE)
	default ResponseEntity<Void> deleteLCMRuleSpecification(
			@Parameter(description = "Identifier of the RuleSpecification", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default LCM RuleSpecificationApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Operation(summary = "List or find LCM RuleSpecification objects", operationId = "listLCMRuleSpecification", description = "This operation list or find LCM RuleSpecification entities" , tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200", description = "Success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ),
			@ApiResponse(responseCode = "403", description = "Forbidden" ),
			@ApiResponse(responseCode = "404", description = "Not Found" ),
			@ApiResponse(responseCode = "405", description = "Method Not allowed" ),
			@ApiResponse(responseCode = "409", description = "Conflict" ),
			@ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
	@RequestMapping(value = "/lcmRuleSpecification", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	ResponseEntity<List<LCMRuleSpecification>> listLCMRuleSpecification(
			@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
			@Parameter(hidden = true) @Valid @RequestParam Map<String, String> allParams);

	
	@Operation(summary = "List or find LCM RuleSpecification objects by Service Specification ID", operationId = "listLCMRuleSpecificationsByServiceSpecID", description = "This operation list or find LCM RuleSpecification entities by SpecID" , tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = {
			@ApiResponse(responseCode ="200", description = "Success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ),
			@ApiResponse(responseCode = "403", description = "Forbidden" ),
			@ApiResponse(responseCode = "404", description = "Not Found" ),
			@ApiResponse(responseCode = "405", description = "Method Not allowed" ),
			@ApiResponse(responseCode = "409", description = "Conflict" ),
			@ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
	@RequestMapping(value = "/lcmRuleSpecification/serviceSpec/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	ResponseEntity<List<LCMRuleSpecification>> listLCMRuleSpecificationBySpecID(
			@Parameter(description = "Identifier of the ServiceSpecification Id", required = true) @PathVariable("id") String id,
			@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
			@Parameter(hidden = true) @Valid @RequestParam Map<String, String> allParams);

	
	
	@Operation(summary = "Updates partially a LCM RuleSpecification", operationId = "patchLCMRuleSpecification", description = "This operation updates partially a LCM RuleSpecification entity." , tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(responseCode ="200", description = "Updated" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ),
			@ApiResponse(responseCode = "403", description = "Forbidden" ),
			@ApiResponse(responseCode = "404", description = "Not Found" ),
			@ApiResponse(responseCode = "405", description = "Method Not allowed" ),
			@ApiResponse(responseCode = "409", description = "Conflict" ),
			@ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
	@RequestMapping(value = "/lcmRuleSpecification/{id}", produces = {
			"application/json;charset=utf-8" }, consumes = {
					"application/json;charset=utf-8" }, method = RequestMethod.PATCH)
	default ResponseEntity<LCMRuleSpecification> patchLCMRuleSpecification(
			@Parameter(description = "The LCM RuleSpecification to be updated", required = true) @Valid @RequestBody LCMRuleSpecificationUpdate body,
			@Parameter(description = "Identifier of the LCM RuleSpecification", required = true) @PathVariable("id") String id) {

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Operation(summary = "Retrieves a LCM RuleSpecification by ID", operationId = "retrieveLCMRuleSpecification", description = "This operation retrieves a LCM RuleSpecification entity. Attribute selection is enabled for all first level attributes." , tags = {
			"lcmRuleSpecification", })
	@ApiResponses(value = { @ApiResponse(responseCode ="200", description = "Success" ),
			@ApiResponse(responseCode = "400", description = "Bad Request" ),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ),
			@ApiResponse(responseCode = "403", description = "Forbidden" ),
			@ApiResponse(responseCode = "404", description = "Not Found" ),
			@ApiResponse(responseCode = "405", description = "Method Not allowed" ),
			@ApiResponse(responseCode = "409", description = "Conflict" ),
			@ApiResponse(responseCode = "500", description = "Internal Server Error" ) })
	@RequestMapping(value = "/lcmRuleSpecification/{id}", produces = {
			"application/json;charset=utf-8" }, method = RequestMethod.GET)
	default ResponseEntity<LCMRuleSpecification> retrieveLCMRuleSpecification(
			@Parameter(description = "Identifier of the LCM RuleSpecification", required = true) @PathVariable("id") String id,
			@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
		
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}

