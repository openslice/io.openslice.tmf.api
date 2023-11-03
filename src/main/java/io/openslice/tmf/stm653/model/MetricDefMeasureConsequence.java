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
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * A MetricDefMeasureConsequence defines the action (prescribed action or notification) to take when a  MetricDefMeasureThresholdRule is crossed.
 */
@Schema(description = "A MetricDefMeasureConsequence defines the action (prescribed action or notification) to take when a  MetricDefMeasureThresholdRule is crossed.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMMetricDefMeasrConseq")
@Table(name = "STMMetricDefMeasrConseq")
public class MetricDefMeasureConsequence  extends BaseRootNamedEntity {
  @JsonProperty("description")
  private String description = null;


  @JsonProperty("prescribeAction")
  private String prescribeAction = null;

  @JsonProperty("repeatAction")
  private Boolean repeatAction = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;



  public MetricDefMeasureConsequence description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the consequence is.
   * @return description
  **/
  @Schema(description = "A narrative that explains in detail what the consequence is.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MetricDefMeasureConsequence name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which a  MetricDefMeasureConsequence is known and distinguished from other MetricDefMeasureConsequences.
   * @return name
  **/
  @Schema(description = "A word, term, or phrase by which a  MetricDefMeasureConsequence is known and distinguished from other MetricDefMeasureConsequences.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MetricDefMeasureConsequence prescribeAction(String prescribeAction) {
    this.prescribeAction = prescribeAction;
    return this;
  }

  /**
   * Recommended remedy for a violated threshold. This could be  the hyperlink to the action.
   * @return prescribeAction
  **/
  @Schema(description = "Recommended remedy for a violated threshold. This could be  the hyperlink to the action.")
  
    public String getPrescribeAction() {
    return prescribeAction;
  }

  public void setPrescribeAction(String prescribeAction) {
    this.prescribeAction = prescribeAction;
  }

  public MetricDefMeasureConsequence repeatAction(Boolean repeatAction) {
    this.repeatAction = repeatAction;
    return this;
  }

  /**
   * An indicator used to specify that a consequence should cease  being applied if a value is in the same range as the previous value or continue being applied if a value is in the same range as the previous value.  If the repeatAction is True, if the consequence is always applied as soon as the MetricMeasure value is in the range of values and if the repeatAction is False, the consequence is applied only if the previous MetricMeasure value was not in the same range.
   * @return repeatAction
  **/
  @Schema(description = "An indicator used to specify that a consequence should cease  being applied if a value is in the same range as the previous value or continue being applied if a value is in the same range as the previous value.  If the repeatAction is True, if the consequence is always applied as soon as the MetricMeasure value is in the range of values and if the repeatAction is False, the consequence is applied only if the previous MetricMeasure value was not in the same range.")
  
    public Boolean isRepeatAction() {
    return repeatAction;
  }

  public void setRepeatAction(Boolean repeatAction) {
    this.repeatAction = repeatAction;
  }

  public MetricDefMeasureConsequence validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
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
    MetricDefMeasureConsequence metricDefMeasureConsequence = (MetricDefMeasureConsequence) o;
    return Objects.equals(this.description, metricDefMeasureConsequence.description) &&
        Objects.equals(this.name, metricDefMeasureConsequence.name) &&
        Objects.equals(this.prescribeAction, metricDefMeasureConsequence.prescribeAction) &&
        Objects.equals(this.repeatAction, metricDefMeasureConsequence.repeatAction) &&
        Objects.equals(this.validFor, metricDefMeasureConsequence.validFor) &&
        Objects.equals(this.baseType, metricDefMeasureConsequence.baseType) &&
        Objects.equals(this.schemaLocation, metricDefMeasureConsequence.schemaLocation) &&
        Objects.equals(this.type, metricDefMeasureConsequence.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(description, name, prescribeAction, repeatAction, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetricDefMeasureConsequence {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    prescribeAction: ").append(toIndentedString(prescribeAction)).append("\n");
    sb.append("    repeatAction: ").append(toIndentedString(repeatAction)).append("\n");
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
