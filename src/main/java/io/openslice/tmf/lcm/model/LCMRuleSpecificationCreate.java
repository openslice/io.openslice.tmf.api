package io.openslice.tmf.lcm.model;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ctranoris
 * 
 * A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service
 *
 */
@Schema(description = "A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service.")
@Validated
@Data
@EqualsAndHashCode(callSuper=true)
public class LCMRuleSpecificationCreate extends LCMRuleSpecificationUpdate {

	
	
	
}
