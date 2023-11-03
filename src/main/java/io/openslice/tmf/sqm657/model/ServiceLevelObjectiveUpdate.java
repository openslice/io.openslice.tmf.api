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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Service level objectives are defined in terms of parameters and metrics, thresholds, and tolerances  associated with the parameters. Skipped properties: id,href,id,href,validFor
 */
@Schema(description = "Service level objectives are defined in terms of parameters and metrics, thresholds, and tolerances  associated with the parameters. Skipped properties: id,href,id,href,validFor")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelObjectiveUpdate   {
  @JsonProperty("conformanceComparator")
  private String conformanceComparator = null;

  @JsonProperty("conformancePeriod")
  private TimePeriod conformancePeriod = null;

  @JsonProperty("conformanceTarget")
  private String conformanceTarget = null;

  @JsonProperty("graceTimes")
  private String graceTimes = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("thresholdTarget")
  private String thresholdTarget = null;

  @JsonProperty("tolerancePeriod")
  private TimePeriod tolerancePeriod = null;

  @JsonProperty("toleranceTarget")
  private String toleranceTarget = null;

  @JsonProperty("specParameter")
  private ServiceLevelSpecParameter specParameter = null;

  @JsonProperty("specConsequence")
  @Valid
  private List<ServiceLevelSpecConsequence> specConsequence = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public ServiceLevelObjectiveUpdate conformanceComparator(String conformanceComparator) {
    this.conformanceComparator = conformanceComparator;
    return this;
  }

  /**
   * An operator that specifies whether a Service Level Objective is  violated above or below the conformanceTarget.
   * @return conformanceComparator
  **/
  @Schema(description = "An operator that specifies whether a Service Level Objective is  violated above or below the conformanceTarget.")


  public String getConformanceComparator() {
    return conformanceComparator;
  }

  public void setConformanceComparator(String conformanceComparator) {
    this.conformanceComparator = conformanceComparator;
  }

  public ServiceLevelObjectiveUpdate conformancePeriod(TimePeriod conformancePeriod) {
    this.conformancePeriod = conformancePeriod;
    return this;
  }

  /**
   * An interval of time during which the Conformance Target must be measured.
   * @return conformancePeriod
  **/
  @Schema(description = "An interval of time during which the Conformance Target must be measured.")

  @Valid

  public TimePeriod getConformancePeriod() {
    return conformancePeriod;
  }

  public void setConformancePeriod(TimePeriod conformancePeriod) {
    this.conformancePeriod = conformancePeriod;
  }

  public ServiceLevelObjectiveUpdate conformanceTarget(String conformanceTarget) {
    this.conformanceTarget = conformanceTarget;
    return this;
  }

  /**
   * A value used to determine if Service Level Objective is met.  The data type should be adjusted case by case.
   * @return conformanceTarget
  **/
  @Schema(description = "A value used to determine if Service Level Objective is met.  The data type should be adjusted case by case.")


  public String getConformanceTarget() {
    return conformanceTarget;
  }

  public void setConformanceTarget(String conformanceTarget) {
    this.conformanceTarget = conformanceTarget;
  }

  public ServiceLevelObjectiveUpdate graceTimes(String graceTimes) {
    this.graceTimes = graceTimes;
    return this;
  }

  /**
   * The number of times an objective can remain un-updated without  a violation of a Service Level Agreement in reference to a measurement period and/or Service Level Agreement reporting period.
   * @return graceTimes
  **/
  @Schema(description = "The number of times an objective can remain un-updated without  a violation of a Service Level Agreement in reference to a measurement period and/or Service Level Agreement reporting period.")


  public String getGraceTimes() {
    return graceTimes;
  }

  public void setGraceTimes(String graceTimes) {
    this.graceTimes = graceTimes;
  }

  public ServiceLevelObjectiveUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the service level objectives.
   * @return name
  **/
  @Schema(description = "The name of the service level objectives.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceLevelObjectiveUpdate thresholdTarget(String thresholdTarget) {
    this.thresholdTarget = thresholdTarget;
    return this;
  }

  /**
   * A value that used to specify when a warning should be used  that indicates an objective is danger of not being met. Notice, the data type should be adjusted case by case.
   * @return thresholdTarget
  **/
  @Schema(description = "A value that used to specify when a warning should be used  that indicates an objective is danger of not being met. Notice, the data type should be adjusted case by case.")


  public String getThresholdTarget() {
    return thresholdTarget;
  }

  public void setThresholdTarget(String thresholdTarget) {
    this.thresholdTarget = thresholdTarget;
  }

  public ServiceLevelObjectiveUpdate tolerancePeriod(TimePeriod tolerancePeriod) {
    this.tolerancePeriod = tolerancePeriod;
    return this;
  }

  /**
   * Get tolerancePeriod
   * @return tolerancePeriod
  **/
  @Schema(description = "")

  @Valid

  public TimePeriod getTolerancePeriod() {
    return tolerancePeriod;
  }

  public void setTolerancePeriod(TimePeriod tolerancePeriod) {
    this.tolerancePeriod = tolerancePeriod;
  }

  public ServiceLevelObjectiveUpdate toleranceTarget(String toleranceTarget) {
    this.toleranceTarget = toleranceTarget;
    return this;
  }

  /**
   * A value that specifies the allowable variation of a conformance  Target. The data type should be adjusted case by case.
   * @return toleranceTarget
  **/
  @Schema(description = "A value that specifies the allowable variation of a conformance  Target. The data type should be adjusted case by case.")


  public String getToleranceTarget() {
    return toleranceTarget;
  }

  public void setToleranceTarget(String toleranceTarget) {
    this.toleranceTarget = toleranceTarget;
  }

  public ServiceLevelObjectiveUpdate specParameter(ServiceLevelSpecParameter specParameter) {
    this.specParameter = specParameter;
    return this;
  }

  /**
   * Get specParameter
   * @return specParameter
  **/
  @Schema(description = "")

  @Valid

  public ServiceLevelSpecParameter getSpecParameter() {
    return specParameter;
  }

  public void setSpecParameter(ServiceLevelSpecParameter specParameter) {
    this.specParameter = specParameter;
  }

  public ServiceLevelObjectiveUpdate specConsequence(List<ServiceLevelSpecConsequence> specConsequence) {
    this.specConsequence = specConsequence;
    return this;
  }

  public ServiceLevelObjectiveUpdate addSpecConsequenceItem(ServiceLevelSpecConsequence specConsequenceItem) {
    if (this.specConsequence == null) {
      this.specConsequence = new ArrayList<>();
    }
    this.specConsequence.add(specConsequenceItem);
    return this;
  }

  /**
   * Get specConsequence
   * @return specConsequence
  **/
  @Schema(description = "")

  @Valid

  public List<ServiceLevelSpecConsequence> getSpecConsequence() {
    return specConsequence;
  }

  public void setSpecConsequence(List<ServiceLevelSpecConsequence> specConsequence) {
    this.specConsequence = specConsequence;
  }

  public ServiceLevelObjectiveUpdate type(String type) {
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

  public ServiceLevelObjectiveUpdate schemaLocation(String schemaLocation) {
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

  public ServiceLevelObjectiveUpdate baseType(String baseType) {
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
    ServiceLevelObjectiveUpdate serviceLevelObjectiveUpdate = (ServiceLevelObjectiveUpdate) o;
    return Objects.equals(this.conformanceComparator, serviceLevelObjectiveUpdate.conformanceComparator) &&
        Objects.equals(this.conformancePeriod, serviceLevelObjectiveUpdate.conformancePeriod) &&
        Objects.equals(this.conformanceTarget, serviceLevelObjectiveUpdate.conformanceTarget) &&
        Objects.equals(this.graceTimes, serviceLevelObjectiveUpdate.graceTimes) &&
        Objects.equals(this.name, serviceLevelObjectiveUpdate.name) &&
        Objects.equals(this.thresholdTarget, serviceLevelObjectiveUpdate.thresholdTarget) &&
        Objects.equals(this.tolerancePeriod, serviceLevelObjectiveUpdate.tolerancePeriod) &&
        Objects.equals(this.toleranceTarget, serviceLevelObjectiveUpdate.toleranceTarget) &&
        Objects.equals(this.specParameter, serviceLevelObjectiveUpdate.specParameter) &&
        Objects.equals(this.specConsequence, serviceLevelObjectiveUpdate.specConsequence) &&
        Objects.equals(this.type, serviceLevelObjectiveUpdate.type) &&
        Objects.equals(this.schemaLocation, serviceLevelObjectiveUpdate.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelObjectiveUpdate.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conformanceComparator, conformancePeriod, conformanceTarget, graceTimes, name, thresholdTarget, tolerancePeriod, toleranceTarget, specParameter, specConsequence, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelObjectiveUpdate {\n");
    
    sb.append("    conformanceComparator: ").append(toIndentedString(conformanceComparator)).append("\n");
    sb.append("    conformancePeriod: ").append(toIndentedString(conformancePeriod)).append("\n");
    sb.append("    conformanceTarget: ").append(toIndentedString(conformanceTarget)).append("\n");
    sb.append("    graceTimes: ").append(toIndentedString(graceTimes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    thresholdTarget: ").append(toIndentedString(thresholdTarget)).append("\n");
    sb.append("    tolerancePeriod: ").append(toIndentedString(tolerancePeriod)).append("\n");
    sb.append("    toleranceTarget: ").append(toIndentedString(toleranceTarget)).append("\n");
    sb.append("    specParameter: ").append(toIndentedString(specParameter)).append("\n");
    sb.append("    specConsequence: ").append(toIndentedString(specConsequence)).append("\n");
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

