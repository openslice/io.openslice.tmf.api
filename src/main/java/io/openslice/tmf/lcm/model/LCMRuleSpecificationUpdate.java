package io.openslice.tmf.lcm.model;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ctranoris
 * 
 *         A LCM RuleSpecification is an entity that describes a LCM rule to
 *         apply during the LCM of a service
 *
 */
@ApiModel(description = "A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service.")
@Validated
@Data
public class LCMRuleSpecificationUpdate {

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("description")
	protected String description = null;

	protected String lcmrulephase = ELCMRulePhase.PRE_PROVISION.getValue();

	private List<ServiceSpecificationRef> serviceSpecs = null;

	@JsonProperty("content")
	protected String content = null;

	@JsonProperty("code")
	protected String code = null;

	@JsonProperty("lifecycleStatus")
	protected String lifecycleStatus = null;

	@JsonProperty("version")
	protected String version = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@type")
	protected String type = null;
}
