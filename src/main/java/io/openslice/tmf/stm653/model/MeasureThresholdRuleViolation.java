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
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * A measureThresholdRuleViolation is a violation of a rule that defines the in
 * the MericDefMeasureThresholdRule.
 */
@Schema(description = "A measureThresholdRuleViolation is a violation of a rule that defines the in the  MericDefMeasureThresholdRule.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMMeasureThresholdRuleViolation")
@Table(name = "STMMeasureThresholdRuleViolation")
public class MeasureThresholdRuleViolation extends BaseRootNamedEntity {

	@JsonProperty("conformanceComparatorLower")
	private String conformanceComparatorLower = null;

	@JsonProperty("conformanceComparatorUpper")
	private String conformanceComparatorUpper = null;

	@JsonProperty("conformanceTargetExact")
	private String conformanceTargetExact = null;

	@JsonProperty("conformanceTargetLower")
	private String conformanceTargetLower = null;

	@JsonProperty("conformanceTargetUpper")
	private String conformanceTargetUpper = null;

	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("numberOfAllowedCrossing")
	private Integer numberOfAllowedCrossing = null;

	@JsonProperty("thresholdRuleSeverity")
	private String thresholdRuleSeverity = null;

	@JsonProperty("appliedConsequence")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AppliedConsequence> appliedConsequence = new HashSet<>();

	@JsonProperty("tolerancePeriod")
	private Duration tolerancePeriod = null;

	public MeasureThresholdRuleViolation conformanceComparatorLower(String conformanceComparatorLower) {
		this.conformanceComparatorLower = conformanceComparatorLower;
		return this;
	}

	/**
	 * An operator that when applied on a value specifies whether a threshold is
	 * crossed or ceased to be crossed. This operator is used to compare with the
	 * conformanceTargetLower.
	 * 
	 * @return conformanceComparatorLower
	 **/
	@Schema(description = "An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to compare with the conformanceTargetLower.")

	public String getConformanceComparatorLower() {
		return conformanceComparatorLower;
	}

	public void setConformanceComparatorLower(String conformanceComparatorLower) {
		this.conformanceComparatorLower = conformanceComparatorLower;
	}

	public MeasureThresholdRuleViolation conformanceComparatorUpper(String conformanceComparatorUpper) {
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

	public MeasureThresholdRuleViolation conformanceTargetExact(String conformanceTargetExact) {
		this.conformanceTargetExact = conformanceTargetExact;
		return this;
	}

	/**
	 * to cater for values that are not numerical test metrics (e.g. a DSL line can
	 * be Synchronised or Unsynchronised. If the latter, the test should result in a
	 * rule violation).The allowed value can contain a REGEX string.
	 * 
	 * @return conformanceTargetExact
	 **/
	@Schema(description = "to cater for values that are not numerical test metrics (e.g. a DSL line can be Synchronised or Unsynchronised. If the latter, the test should result in a rule violation).The allowed value can contain a REGEX string.")

	public String getConformanceTargetExact() {
		return conformanceTargetExact;
	}

	public void setConformanceTargetExact(String conformanceTargetExact) {
		this.conformanceTargetExact = conformanceTargetExact;
	}

	public MeasureThresholdRuleViolation conformanceTargetLower(String conformanceTargetLower) {
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

	public MeasureThresholdRuleViolation conformanceTargetUpper(String conformanceTargetUpper) {
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

	public MeasureThresholdRuleViolation description(String description) {
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

	public MeasureThresholdRuleViolation name(String name) {
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

	public MeasureThresholdRuleViolation numberOfAllowedCrossing(Integer numberOfAllowedCrossing) {
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

	public MeasureThresholdRuleViolation thresholdRuleSeverity(String thresholdRuleSeverity) {
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

	public MeasureThresholdRuleViolation appliedConsequence( Set<AppliedConsequence> appliedConsequence) {
		this.appliedConsequence = appliedConsequence;
		return this;
	}

	public MeasureThresholdRuleViolation addAppliedConsequenceItem(AppliedConsequence appliedConsequenceItem) {
		if (this.appliedConsequence == null) {
			this.appliedConsequence = new HashSet<>();
		}
		this.appliedConsequence.add(appliedConsequenceItem);
		return this;
	}

	/**
	 * An Applied Consequence defines the action (prescribed action or notification)
	 * to take when a MeasureThresholdRuleViolation occurs.
	 * 
	 * @return appliedConsequence
	 **/
	@Schema(description = "An Applied Consequence defines the action (prescribed action or notification) to take when a MeasureThresholdRuleViolation occurs.")
	@Valid
	public Set<AppliedConsequence> getAppliedConsequence() {
		return appliedConsequence;
	}

	public void setAppliedConsequence(Set<AppliedConsequence> appliedConsequence) {
		this.appliedConsequence = appliedConsequence;
	}

	public MeasureThresholdRuleViolation tolerancePeriod(Duration tolerancePeriod) {
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
		MeasureThresholdRuleViolation measureThresholdRuleViolation = (MeasureThresholdRuleViolation) o;
		return Objects.equals(this.conformanceComparatorLower, measureThresholdRuleViolation.conformanceComparatorLower)
				&& Objects.equals(this.conformanceComparatorUpper,
						measureThresholdRuleViolation.conformanceComparatorUpper)
				&& Objects.equals(this.conformanceTargetExact, measureThresholdRuleViolation.conformanceTargetExact)
				&& Objects.equals(this.conformanceTargetLower, measureThresholdRuleViolation.conformanceTargetLower)
				&& Objects.equals(this.conformanceTargetUpper, measureThresholdRuleViolation.conformanceTargetUpper)
				&& Objects.equals(this.description, measureThresholdRuleViolation.description)
				&& Objects.equals(this.name, measureThresholdRuleViolation.name)
				&& Objects.equals(this.numberOfAllowedCrossing, measureThresholdRuleViolation.numberOfAllowedCrossing)
				&& Objects.equals(this.thresholdRuleSeverity, measureThresholdRuleViolation.thresholdRuleSeverity)
				&& Objects.equals(this.appliedConsequence, measureThresholdRuleViolation.appliedConsequence)
				&& Objects.equals(this.tolerancePeriod, measureThresholdRuleViolation.tolerancePeriod)
				&& Objects.equals(this.baseType, measureThresholdRuleViolation.baseType)
				&& Objects.equals(this.schemaLocation, measureThresholdRuleViolation.schemaLocation)
				&& Objects.equals(this.type, measureThresholdRuleViolation.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(conformanceComparatorLower, conformanceComparatorUpper, conformanceTargetExact,
//				conformanceTargetLower, conformanceTargetUpper, description, name, numberOfAllowedCrossing,
//				thresholdRuleSeverity, appliedConsequence, tolerancePeriod, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MeasureThresholdRuleViolation {\n");

		sb.append("    conformanceComparatorLower: ").append(toIndentedString(conformanceComparatorLower)).append("\n");
		sb.append("    conformanceComparatorUpper: ").append(toIndentedString(conformanceComparatorUpper)).append("\n");
		sb.append("    conformanceTargetExact: ").append(toIndentedString(conformanceTargetExact)).append("\n");
		sb.append("    conformanceTargetLower: ").append(toIndentedString(conformanceTargetLower)).append("\n");
		sb.append("    conformanceTargetUpper: ").append(toIndentedString(conformanceTargetUpper)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    numberOfAllowedCrossing: ").append(toIndentedString(numberOfAllowedCrossing)).append("\n");
		sb.append("    thresholdRuleSeverity: ").append(toIndentedString(thresholdRuleSeverity)).append("\n");
		sb.append("    appliedConsequence: ").append(toIndentedString(appliedConsequence)).append("\n");
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
