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
package io.openslice.tmf.am642.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Identifies the details of the threshold that has been crossed.
 */
@Schema(description = "Identifies the details of the threshold that has been crossed.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMCrossedThreshInfo")
@Table(name = "AMCrossedThreshInfo")
public class CrossedThresholdInformation extends BaseRootEntity {
	@JsonProperty("direction")
	private String direction = null;

	@JsonProperty("granularity")
	private String granularity = null;

	@JsonProperty("indicatorName")
	private String indicatorName = null;

	@JsonProperty("indicatorUnit")
	private String indicatorUnit = null;

	@JsonProperty("observedValue")
	private String observedValue = null;

	@JsonProperty("thresholdCrossingDescription")
	private String thresholdCrossingDescription = null;

	@JsonProperty("threshold")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private ThresholdRef threshold = null;

	public CrossedThresholdInformation direction(String direction) {
		this.direction = direction;
		return this;
	}

	/**
	 * Indicates the threshold crossing direction: up or down.
	 * 
	 * @return direction
	 **/
	@Schema(description = "Indicates the threshold crossing direction: up or down.")

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public CrossedThresholdInformation granularity(String granularity) {
		this.granularity = granularity;
		return this;
	}

	/**
	 * Indicates the granularity at which the indicator is evaluated for threshold
	 * crossing
	 * 
	 * @return granularity
	 **/
	@Schema(description = "Indicates the granularity at which the indicator is evaluated for threshold crossing")

	public String getGranularity() {
		return granularity;
	}

	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	public CrossedThresholdInformation indicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
		return this;
	}

	/**
	 * Indicates the name of indicator which crossed the threshold.
	 * 
	 * @return indicatorName
	 **/
	@Schema(description = "Indicates the name of indicator which crossed the threshold.")

	public String getIndicatorName() {
		return indicatorName;
	}

	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}

	public CrossedThresholdInformation indicatorUnit(String indicatorUnit) {
		this.indicatorUnit = indicatorUnit;
		return this;
	}

	/**
	 * Indicates the unit of the measurement of the indicator corresponding to the
	 * threshold that has been crossed.
	 * 
	 * @return indicatorUnit
	 **/
	@Schema(description = "Indicates the unit of the measurement of the indicator corresponding to the threshold that has been crossed.")

	public String getIndicatorUnit() {
		return indicatorUnit;
	}

	public void setIndicatorUnit(String indicatorUnit) {
		this.indicatorUnit = indicatorUnit;
	}

	public CrossedThresholdInformation observedValue(String observedValue) {
		this.observedValue = observedValue;
		return this;
	}

	/**
	 * Indicates the value of the indicator which crossed the threshold.
	 * 
	 * @return observedValue
	 **/
	@Schema(description = "Indicates the value of the indicator which crossed the threshold.")

	public String getObservedValue() {
		return observedValue;
	}

	public void setObservedValue(String observedValue) {
		this.observedValue = observedValue;
	}

	public CrossedThresholdInformation thresholdCrossingDescription(String thresholdCrossingDescription) {
		this.thresholdCrossingDescription = thresholdCrossingDescription;
		return this;
	}

	/**
	 * Indicates further information on the threshold crossing alarm.
	 * 
	 * @return thresholdCrossingDescription
	 **/
	@Schema(description = "Indicates further information on the threshold crossing alarm.")

	public String getThresholdCrossingDescription() {
		return thresholdCrossingDescription;
	}

	public void setThresholdCrossingDescription(String thresholdCrossingDescription) {
		this.thresholdCrossingDescription = thresholdCrossingDescription;
	}

	public CrossedThresholdInformation threshold(ThresholdRef threshold) {
		this.threshold = threshold;
		return this;
	}

	/**
	 * Get threshold
	 * 
	 * @return threshold
	 **/
	@Schema(description = "")

	@Valid
	public ThresholdRef getThreshold() {
		return threshold;
	}

	public void setThreshold(ThresholdRef threshold) {
		this.threshold = threshold;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return type
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class entity name")

	public String getAtType() {
		return type;
	}

	public void setAtType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossedThresholdInformation crossedThresholdInformation = (CrossedThresholdInformation) o;
		return Objects.equals(this.direction, crossedThresholdInformation.direction)
				&& Objects.equals(this.granularity, crossedThresholdInformation.granularity)
				&& Objects.equals(this.indicatorName, crossedThresholdInformation.indicatorName)
				&& Objects.equals(this.indicatorUnit, crossedThresholdInformation.indicatorUnit)
				&& Objects.equals(this.observedValue, crossedThresholdInformation.observedValue)
				&& Objects.equals(this.thresholdCrossingDescription,
						crossedThresholdInformation.thresholdCrossingDescription)
				&& Objects.equals(this.threshold, crossedThresholdInformation.threshold)
				&& Objects.equals(this.baseType, crossedThresholdInformation.baseType)
				&& Objects.equals(this.schemaLocation, crossedThresholdInformation.schemaLocation)
				&& Objects.equals(this.type, crossedThresholdInformation.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(direction, granularity, indicatorName, indicatorUnit, observedValue, thresholdCrossingDescription, threshold, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossedThresholdInformation {\n");

		sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
		sb.append("    granularity: ").append(toIndentedString(granularity)).append("\n");
		sb.append("    indicatorName: ").append(toIndentedString(indicatorName)).append("\n");
		sb.append("    indicatorUnit: ").append(toIndentedString(indicatorUnit)).append("\n");
		sb.append("    observedValue: ").append(toIndentedString(observedValue)).append("\n");
		sb.append("    thresholdCrossingDescription: ").append(toIndentedString(thresholdCrossingDescription))
				.append("\n");
		sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
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
