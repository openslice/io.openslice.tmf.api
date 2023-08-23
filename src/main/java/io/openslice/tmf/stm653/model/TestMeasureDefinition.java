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
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * A TestMeasureDefinition specifies a measure of a specific aspect of a
 * product, service, or resource test, such as lost packets or connectivity
 * status
 */
@Schema(description = "A TestMeasureDefinition specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMTestMeasureDefinition")
@Table(name = "STMTestMeasureDefinition")
public class TestMeasureDefinition extends BaseRootNamedEntity {
	@JsonProperty("captureFrequency")
	private String captureFrequency = null;

	@JsonProperty("captureMethod")
	private String captureMethod = null;

	@JsonProperty("metricDescription")
	private String metricDescription = null;

	@JsonProperty("metricHref")
	private String metricHref = null;

	@JsonProperty("metricName")
	private String metricName = null;

	@JsonProperty("unitOfMeasure")
	private String unitOfMeasure = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("capturePeriod")
	private Duration capturePeriod = null;

	@JsonProperty("thresholdRule")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<MetricDefMeasureThresholdRule> thresholdRule = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public TestMeasureDefinition captureFrequency(String captureFrequency) {
		this.captureFrequency = captureFrequency;
		return this;
	}

	/**
	 * The frequency of capture for the metric. Note: This may be replaced by a set
	 * of entities similar to the Performance Monitoring
	 * 
	 * @return captureFrequency
	 **/
	@Schema(description = "The frequency of capture for the metric. Note: This may be replaced by a set of entities similar to the Performance Monitoring")

	public String getCaptureFrequency() {
		return captureFrequency;
	}

	public void setCaptureFrequency(String captureFrequency) {
		this.captureFrequency = captureFrequency;
	}

	public TestMeasureDefinition captureMethod(String captureMethod) {
		this.captureMethod = captureMethod;
		return this;
	}

	/**
	 * The method used to capture the Metric. Note: This may be replaced by a set of
	 * entities similar to the Performance Monitoring
	 * 
	 * @return captureMethod
	 **/
	@Schema(description = "The method used to capture the Metric. Note: This may be replaced by a set of entities similar to the Performance Monitoring")

	public String getCaptureMethod() {
		return captureMethod;
	}

	public void setCaptureMethod(String captureMethod) {
		this.captureMethod = captureMethod;
	}

	public TestMeasureDefinition metricDescription(String metricDescription) {
		this.metricDescription = metricDescription;
		return this;
	}

	/**
	 * Brief description of the metric
	 * 
	 * @return metricDescription
	 **/
	@Schema(description = "Brief description of the metric")

	public String getMetricDescription() {
		return metricDescription;
	}

	public void setMetricDescription(String metricDescription) {
		this.metricDescription = metricDescription;
	}

	public TestMeasureDefinition metricHref(String metricHref) {
		this.metricHref = metricHref;
		return this;
	}

	/**
	 * Hyperlink to access a metric for detail information
	 * 
	 * @return metricHref
	 **/
	@Schema(description = "Hyperlink to access a metric for detail information")

	public String getMetricHref() {
		return metricHref;
	}

	public void setMetricHref(String metricHref) {
		this.metricHref = metricHref;
	}

	public TestMeasureDefinition metricName(String metricName) {
		this.metricName = metricName;
		return this;
	}

	/**
	 * The name of a metric that in the test measure
	 * 
	 * @return metricName
	 **/
	@Schema(description = "The name of a metric that in the test measure")

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public TestMeasureDefinition name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name of the TestMeasureDefinition
	 * 
	 * @return name
	 **/
	@Schema(description = "The name of the TestMeasureDefinition")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestMeasureDefinition unitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	/**
	 * Name of a service test specification
	 * 
	 * @return unitOfMeasure
	 **/
	@Schema(description = "Name of a service test specification")

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public TestMeasureDefinition valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the Metric value can take on, such as numeric, text, and
	 * so forth
	 * 
	 * @return valueType
	 **/
	@Schema(description = "A kind of value that the Metric value can take on, such as numeric, text, and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public TestMeasureDefinition capturePeriod(Duration capturePeriod) {
		this.capturePeriod = capturePeriod;
		return this;
	}

	/**
	 * Get capturePeriod
	 * 
	 * @return capturePeriod
	 **/
	@Schema(description = "")

	@Valid
	public Duration getCapturePeriod() {
		return capturePeriod;
	}

	public void setCapturePeriod(Duration capturePeriod) {
		this.capturePeriod = capturePeriod;
	}

	public TestMeasureDefinition thresholdRule(Set<MetricDefMeasureThresholdRule> thresholdRule) {
		this.thresholdRule = thresholdRule;
		return this;
	}

	public TestMeasureDefinition addThresholdRuleItem(MetricDefMeasureThresholdRule thresholdRuleItem) {
		if (this.thresholdRule == null) {
			this.thresholdRule = new HashSet<>();
		}
		this.thresholdRule.add(thresholdRuleItem);
		return this;
	}

	/**
	 * The rule(s) associated with the measure threshold
	 * 
	 * @return thresholdRule
	 **/
	@Schema(description = "The rule(s) associated with the measure threshold")
	@Valid
	public Set<MetricDefMeasureThresholdRule> getThresholdRule() {
		return thresholdRule;
	}

	public void setThresholdRule(Set<MetricDefMeasureThresholdRule> thresholdRule) {
		this.thresholdRule = thresholdRule;
	}

	public TestMeasureDefinition validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@Schema(description = "")

	@Valid
	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TestMeasureDefinition testMeasureDefinition = (TestMeasureDefinition) o;
		return Objects.equals(this.captureFrequency, testMeasureDefinition.captureFrequency)
				&& Objects.equals(this.captureMethod, testMeasureDefinition.captureMethod)
				&& Objects.equals(this.metricDescription, testMeasureDefinition.metricDescription)
				&& Objects.equals(this.metricHref, testMeasureDefinition.metricHref)
				&& Objects.equals(this.metricName, testMeasureDefinition.metricName)
				&& Objects.equals(this.name, testMeasureDefinition.name)
				&& Objects.equals(this.unitOfMeasure, testMeasureDefinition.unitOfMeasure)
				&& Objects.equals(this.valueType, testMeasureDefinition.valueType)
				&& Objects.equals(this.capturePeriod, testMeasureDefinition.capturePeriod)
				&& Objects.equals(this.thresholdRule, testMeasureDefinition.thresholdRule)
				&& Objects.equals(this.validFor, testMeasureDefinition.validFor)
				&& Objects.equals(this.baseType, testMeasureDefinition.baseType)
				&& Objects.equals(this.schemaLocation, testMeasureDefinition.schemaLocation)
				&& Objects.equals(this.type, testMeasureDefinition.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(captureFrequency, captureMethod, metricDescription, metricHref, metricName, name, unitOfMeasure, valueType, capturePeriod, thresholdRule, validFor, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TestMeasureDefinition {\n");

		sb.append("    captureFrequency: ").append(toIndentedString(captureFrequency)).append("\n");
		sb.append("    captureMethod: ").append(toIndentedString(captureMethod)).append("\n");
		sb.append("    metricDescription: ").append(toIndentedString(metricDescription)).append("\n");
		sb.append("    metricHref: ").append(toIndentedString(metricHref)).append("\n");
		sb.append("    metricName: ").append(toIndentedString(metricName)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    capturePeriod: ").append(toIndentedString(capturePeriod)).append("\n");
		sb.append("    thresholdRule: ").append(toIndentedString(thresholdRule)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
