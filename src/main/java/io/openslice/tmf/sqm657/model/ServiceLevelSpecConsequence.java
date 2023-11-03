/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.sqm657.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Some consequences for the provider of the Service are resulted when the service level objective does not meet.
 */
@Schema(description = "Some consequences for the provider of the Service are resulted when the service level objective does not meet.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelSpecConsequence   {
  @JsonProperty("prescribedAction")
  private String prescribedAction = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public ServiceLevelSpecConsequence prescribedAction(String prescribedAction) {
    this.prescribedAction = prescribedAction;
    return this;
  }

  /**
   * Recommended remedy for a violated Service Level Objective.  This could be a hyperlink to the recommended action.
   * @return prescribedAction
  **/
  @Schema(description = "Recommended remedy for a violated Service Level Objective.  This could be a hyperlink to the recommended action.")


  public String getPrescribedAction() {
    return prescribedAction;
  }

  public void setPrescribedAction(String prescribedAction) {
    this.prescribedAction = prescribedAction;
  }

  public ServiceLevelSpecConsequence validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * A valid duration of a thing.
   * @return validFor
  **/
  @Schema(description = "A valid duration of a thing.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceLevelSpecConsequence type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @Schema(description = "The class type of the actual resource (for type extension).")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ServiceLevelSpecConsequence schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A link to the schema describing a resource (for type extension).
   * @return schemaLocation
  **/
  @Schema(description = "A link to the schema describing a resource (for type extension).")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ServiceLevelSpecConsequence baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The base type for use in polymorphic collections
   * @return baseType
  **/
  @Schema(description = "The base type for use in polymorphic collections")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceLevelSpecConsequence serviceLevelSpecConsequence = (ServiceLevelSpecConsequence) o;
    return Objects.equals(this.prescribedAction, serviceLevelSpecConsequence.prescribedAction) &&
        Objects.equals(this.validFor, serviceLevelSpecConsequence.validFor) &&
        Objects.equals(this.type, serviceLevelSpecConsequence.type) &&
        Objects.equals(this.schemaLocation, serviceLevelSpecConsequence.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelSpecConsequence.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prescribedAction, validFor, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelSpecConsequence {\n");
    
    sb.append("    prescribedAction: ").append(toIndentedString(prescribedAction)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
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

