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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * An Applied Consequence defines the action (prescribed action or notification)
 * to take when a MeasureThresholdRuleViolation occurs.
 */
@Schema(description = "An Applied Consequence defines the action (prescribed action or notification) to take when a  MeasureThresholdRuleViolation occurs.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMAppliedConsequence")
@Table(name = "STMAppliedConsequence")
public class AppliedConsequence extends BaseRootNamedEntity {
	@JsonProperty("appliedAction")
	private String appliedAction = null;

	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;


	@JsonProperty("repeatAction")
	private Boolean repeatAction = null;


	public AppliedConsequence appliedAction(String appliedAction) {
		this.appliedAction = appliedAction;
		return this;
	}

	/**
	 * The action for a violated threshold. This could be a hyperlink to the action.
	 * 
	 * @return appliedAction
	 **/
	@Schema(description = "The action for a violated threshold. This could be a hyperlink to  the action.")

	public String getAppliedAction() {
		return appliedAction;
	}

	public void setAppliedAction(String appliedAction) {
		this.appliedAction = appliedAction;
	}

	public AppliedConsequence description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative that explains in detail what the consequence is.
	 * 
	 * @return description
	 **/
	@Schema(description = "A narrative that explains in detail what the consequence is.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AppliedConsequence name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A word, term, or phrase by which Consequence is known and distinguished from
	 * other MetricDefMeasureConsequences.
	 * 
	 * @return name
	 **/
	@Schema(description = "A word, term, or phrase by which Consequence is known and  distinguished from other MetricDefMeasureConsequences.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppliedConsequence repeatAction(Boolean repeatAction) {
		this.repeatAction = repeatAction;
		return this;
	}

	/**
	 * An indicator used to specify that a consequence should cease being applied if
	 * a value is in the same range as the previous value or continue being applied
	 * if a value is in the same range as the previous value. If the repeatAction is
	 * True, if the consequence is always applied as soon as the MetricMeasure value
	 * is in the range of values and if the repeatAction is False, the consequence
	 * is applied only if the previous MetricMeasure value was not in the same
	 * range.
	 * 
	 * @return repeatAction
	 **/
	@Schema(description = "An indicator used to specify that a consequence should cease  being applied if a value is in the same range as the previous value or continue being applied if a value is in the same range as the previous value.   If the repeatAction is True, if the consequence is always applied as soon as the MetricMeasure value is in the range of values and if the repeatAction is False, the consequence is applied only if the previous MetricMeasure value was not in the same range.")

	public Boolean isRepeatAction() {
		return repeatAction;
	}

	public void setRepeatAction(Boolean repeatAction) {
		this.repeatAction = repeatAction;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AppliedConsequence appliedConsequence = (AppliedConsequence) o;
		return Objects.equals(this.appliedAction, appliedConsequence.appliedAction)
				&& Objects.equals(this.description, appliedConsequence.description)
				&& Objects.equals(this.name, appliedConsequence.name)
				&& Objects.equals(this.repeatAction, appliedConsequence.repeatAction)
				&& Objects.equals(this.baseType, appliedConsequence.baseType)
				&& Objects.equals(this.schemaLocation, appliedConsequence.schemaLocation)
				&& Objects.equals(this.type, appliedConsequence.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(appliedAction, description, name, repeatAction, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AppliedConsequence {\n");

		sb.append("    appliedAction: ").append(toIndentedString(appliedAction)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    repeatAction: ").append(toIndentedString(repeatAction)).append("\n");
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
