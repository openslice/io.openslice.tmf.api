package io.openslice.tmf.lcm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ctranoris
 * 
 * A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service
 *
 */
@ApiModel(description = "A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service.")
@Validated
@Data
@EqualsAndHashCode(callSuper=true)
public class LCMRuleSpecificationCreate extends LCMRuleSpecificationUpdate {

	
	
	
}
