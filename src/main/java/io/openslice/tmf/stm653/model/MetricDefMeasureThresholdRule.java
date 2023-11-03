/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.stm653.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * A MetricDefMeasureThresholdRule is a rule that defines the condition (raise
 * or clear) to achieve to apply consequences when a threshold is crossed or
 * ceased to be crossed. It also defines the severity of the raise or clear of
 * the threshold.
 */
@Schema(description = "A MetricDefMeasureThresholdRule is a rule that defines the condition (raise or clear) to achieve to apply  consequences when a threshold is crossed or ceased to be crossed. It also defines the severity of the  raise or clear of the threshold.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMMetrcDefMeasrThreshRule")
@Table(name = "STMMetrcDefMeasrThreshRule")
public class MetricDefMeasureThresholdRule extends BaseRootNamedEntity {
	@JsonProperty("conformanceComparatorLower")
	private String conformanceComparatorLower = null;

	@JsonProperty("conformanceComparatorUpper")
	private String conformanceComparatorUpper = null;

	@JsonProperty("conformanceTargetLower")
	private String conformanceTargetLower = null;

	@JsonProperty("conformanceTargetUpper")
	private String conformanceTargetUpper = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("numberOfAllowedCrossing")
	private Integer numberOfAllowedCrossing = null;

	@JsonProperty("thresholdRuleSeverity")
	private String thresholdRuleSeverity = null;

	@JsonProperty("consequence")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<MetricDefMeasureConsequence> consequence = new HashSet<>();

	@JsonProperty("tolerancePeriod")
	private Duration tolerancePeriod = null;

	public MetricDefMeasureThresholdRule conformanceComparatorLower(String conformanceComparatorLower) {
		this.conformanceComparatorLower = conformanceComparatorLower;
		return this;
	}

	/**
	 * An operator that when applied on a value specifies whether a threshold is
	 * crossed or ceased to be crossed. This operator is used to Service Test
	 * Management API REST Specification compare with the conformanceTargetLower.
	 * 
	 * @return conformanceComparatorLower
	 **/
	@Schema(description = "An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to Service Test Management API REST Specification compare with the conformanceTargetLower.")

	public String getConformanceComparatorLower() {
		return conformanceComparatorLower;
	}

	public void setConformanceComparatorLower(String conformanceComparatorLower) {
		this.conformanceComparatorLower = conformanceComparatorLower;
	}

	public MetricDefMeasureThresholdRule conformanceComparatorUpper(String conformanceComparatorUpper) {
		this.conformanceComparatorUpper = conformanceComparatorUpper;
		return this;
	}

	/**
	 * An operator that when applied on a value specifies whether a threshold is
	 * crossed or ceased to be crossed. This operator is used to compare with the
	 * conformanceTargetUpper.
	 * 
	 * @return conformanceComparatorUpper
	 **/
	@Schema(description = "An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to compare with the conformanceTargetUpper.")

	public String getConformanceComparatorUpper() {
		return conformanceComparatorUpper;
	}

	public void setConformanceComparatorUpper(String conformanceComparatorUpper) {
		this.conformanceComparatorUpper = conformanceComparatorUpper;
	}

	public MetricDefMeasureThresholdRule conformanceTargetLower(String conformanceTargetLower) {
		this.conformanceTargetLower = conformanceTargetLower;
		return this;
	}

	/**
	 * A value used to determine if the threshold is crossed or ceases to be
	 * crossed. It represents the lower limit. The value should be less than the
	 * conformanceTargetUpper. The conformance comparators should also be logically
	 * defined so as to not lead to a logically impossible condition.
	 * 
	 * @return conformanceTargetLower
	 **/
	@Schema(description = "A value used to determine if the threshold is crossed or ceases  to be crossed. It represents the lower limit. The value should be less than the conformanceTargetUpper. The conformance comparators should also be logically defined so as to not lead to a logically impossible condition.")

	public String getConformanceTargetLower() {
		return conformanceTargetLower;
	}

	public void setConformanceTargetLower(String conformanceTargetLower) {
		this.conformanceTargetLower = conformanceTargetLower;
	}

	public MetricDefMeasureThresholdRule conformanceTargetUpper(String conformanceTargetUpper) {
		this.conformanceTargetUpper = conformanceTargetUpper;
		return this;
	}

	/**
	 * A value used to determine if the threshold is crossed or ceases to be
	 * crossed. It represents the Upper limit. The value should be greater than the
	 * conformanceTargetLower. The conformance comparators should also be logically
	 * defined so as to not lead to a logically impossible condition.
	 * 
	 * @return conformanceTargetUpper
	 **/
	@Schema(description = "A value used to determine if the threshold is crossed or ceases  to be crossed. It represents the Upper limit. The value should be greater than the conformanceTargetLower. The conformance comparators should also be logically defined so as to not lead to a logically impossible condition.")

	public String getConformanceTargetUpper() {
		return conformanceTargetUpper;
	}

	public void setConformanceTargetUpper(String conformanceTargetUpper) {
		this.conformanceTargetUpper = conformanceTargetUpper;
	}

	public MetricDefMeasureThresholdRule description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description for the MetricDefMeasureThresholdRule .
	 * 
	 * @return description
	 **/
	@Schema(description = "Description for the MetricDefMeasureThresholdRule .")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MetricDefMeasureThresholdRule name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name for the MetricDefMeasureThresholdRule .
	 * 
	 * @return name
	 **/
	@Schema(description = "Name for the MetricDefMeasureThresholdRule .")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MetricDefMeasureThresholdRule numberOfAllowedCrossing(Integer numberOfAllowedCrossing) {
		this.numberOfAllowedCrossing = numberOfAllowedCrossing;
		return this;
	}

	/**
	 * The number of allowed crossing occurrences in reference to the
	 * tolerancePeriod without a consequence being initiated.
	 * 
	 * @return numberOfAllowedCrossing
	 **/
	@Schema(description = "The number of allowed crossing occurrences in reference to the  tolerancePeriod without a consequence being initiated.")

	public Integer getNumberOfAllowedCrossing() {
		return numberOfAllowedCrossing;
	}

	public void setNumberOfAllowedCrossing(Integer numberOfAllowedCrossing) {
		this.numberOfAllowedCrossing = numberOfAllowedCrossing;
	}

	public MetricDefMeasureThresholdRule thresholdRuleSeverity(String thresholdRuleSeverity) {
		this.thresholdRuleSeverity = thresholdRuleSeverity;
		return this;
	}

	/**
	 * A threshold can be generated in different severity levels. A crossing for
	 * each level may require a different condition and possibly trigger a different
	 * consequence.
	 * 
	 * @return thresholdRuleSeverity
	 **/
	@Schema(description = "A threshold can be generated in different severity levels. A  crossing for each level may require a different condition and possibly trigger a different consequence.")

	public String getThresholdRuleSeverity() {
		return thresholdRuleSeverity;
	}

	public void setThresholdRuleSeverity(String thresholdRuleSeverity) {
		this.thresholdRuleSeverity = thresholdRuleSeverity;
	}

	public MetricDefMeasureThresholdRule consequence(Set<MetricDefMeasureConsequence> consequence) {
		this.consequence = consequence;
		return this;
	}

	public MetricDefMeasureThresholdRule addConsequenceItem(MetricDefMeasureConsequence consequenceItem) {
		if (this.consequence == null) {
			this.consequence = new HashSet<>();
		}
		this.consequence.add(consequenceItem);
		return this;
	}

	/**
	 * A list of consequences (actions, notifications) that will arise if the
	 * threshold is crossed
	 * 
	 * @return consequence
	 **/
	@Schema(description = "A list of consequences (actions, notifications) that will arise if the threshold is crossed")
	@Valid
	public Set<MetricDefMeasureConsequence> getConsequence() {
		return consequence;
	}

	public void setConsequence(Set<MetricDefMeasureConsequence> consequence) {
		this.consequence = consequence;
	}

	public MetricDefMeasureThresholdRule tolerancePeriod(Duration tolerancePeriod) {
		this.tolerancePeriod = tolerancePeriod;
		return this;
	}

	/**
	 * Get tolerancePeriod
	 * 
	 * @return tolerancePeriod
	 **/
	@Schema(description = "")

	@Valid
	public Duration getTolerancePeriod() {
		return tolerancePeriod;
	}

	public void setTolerancePeriod(Duration tolerancePeriod) {
		this.tolerancePeriod = tolerancePeriod;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MetricDefMeasureThresholdRule metricDefMeasureThresholdRule = (MetricDefMeasureThresholdRule) o;
		return Objects.equals(this.conformanceComparatorLower, metricDefMeasureThresholdRule.conformanceComparatorLower)
				&& Objects.equals(this.conformanceComparatorUpper,
						metricDefMeasureThresholdRule.conformanceComparatorUpper)
				&& Objects.equals(this.conformanceTargetLower, metricDefMeasureThresholdRule.conformanceTargetLower)
				&& Objects.equals(this.conformanceTargetUpper, metricDefMeasureThresholdRule.conformanceTargetUpper)
				&& Objects.equals(this.description, metricDefMeasureThresholdRule.description)
				&& Objects.equals(this.name, metricDefMeasureThresholdRule.name)
				&& Objects.equals(this.numberOfAllowedCrossing, metricDefMeasureThresholdRule.numberOfAllowedCrossing)
				&& Objects.equals(this.thresholdRuleSeverity, metricDefMeasureThresholdRule.thresholdRuleSeverity)
				&& Objects.equals(this.consequence, metricDefMeasureThresholdRule.consequence)
				&& Objects.equals(this.tolerancePeriod, metricDefMeasureThresholdRule.tolerancePeriod)
				&& Objects.equals(this.baseType, metricDefMeasureThresholdRule.baseType)
				&& Objects.equals(this.schemaLocation, metricDefMeasureThresholdRule.schemaLocation)
				&& Objects.equals(this.type, metricDefMeasureThresholdRule.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(conformanceComparatorLower, conformanceComparatorUpper, conformanceTargetLower, conformanceTargetUpper, description, name, numberOfAllowedCrossing, thresholdRuleSeverity, consequence, tolerancePeriod, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MetricDefMeasureThresholdRule {\n");

		sb.append("    conformanceComparatorLower: ").append(toIndentedString(conformanceComparatorLower)).append("\n");
		sb.append("    conformanceComparatorUpper: ").append(toIndentedString(conformanceComparatorUpper)).append("\n");
		sb.append("    conformanceTargetLower: ").append(toIndentedString(conformanceTargetLower)).append("\n");
		sb.append("    conformanceTargetUpper: ").append(toIndentedString(conformanceTargetUpper)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    numberOfAllowedCrossing: ").append(toIndentedString(numberOfAllowedCrossing)).append("\n");
		sb.append("    thresholdRuleSeverity: ").append(toIndentedString(thresholdRuleSeverity)).append("\n");
		sb.append("    consequence: ").append(toIndentedString(consequence)).append("\n");
		sb.append("    tolerancePeriod: ").append(toIndentedString(tolerancePeriod)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
