package io.openslice.tmf.sqm657.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.sqm657.model.ServiceLevelSpecConsequence;
import io.openslice.tmf.sqm657.model.ServiceLevelSpecParameter;
import io.openslice.tmf.sqm657.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Service level objectives are defined in terms of parameters and metrics, thresholds, and tolerances  associated with the parameters.
 */
@ApiModel(description = "Service level objectives are defined in terms of parameters and metrics, thresholds, and tolerances  associated with the parameters.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelObjective   {
  @JsonProperty("conformanceComparator")
  private String conformanceComparator = null;

  @JsonProperty("conformancePeriod")
  private TimePeriod conformancePeriod = null;

  @JsonProperty("conformanceTarget")
  private String conformanceTarget = null;

  @JsonProperty("graceTimes")
  private String graceTimes = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("thresholdTarget")
  private String thresholdTarget = null;

  @JsonProperty("tolerancePeriod")
  private TimePeriod tolerancePeriod = null;

  @JsonProperty("toleranceTarget")
  private String toleranceTarget = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

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

  public ServiceLevelObjective conformanceComparator(String conformanceComparator) {
    this.conformanceComparator = conformanceComparator;
    return this;
  }

  /**
   * An operator that specifies whether a Service Level Objective is  violated above or below the conformanceTarget.
   * @return conformanceComparator
  **/
  @ApiModelProperty(value = "An operator that specifies whether a Service Level Objective is  violated above or below the conformanceTarget.")


  public String getConformanceComparator() {
    return conformanceComparator;
  }

  public void setConformanceComparator(String conformanceComparator) {
    this.conformanceComparator = conformanceComparator;
  }

  public ServiceLevelObjective conformancePeriod(TimePeriod conformancePeriod) {
    this.conformancePeriod = conformancePeriod;
    return this;
  }

  /**
   * An interval of time during which the Conformance Target must be measured.
   * @return conformancePeriod
  **/
  @ApiModelProperty(value = "An interval of time during which the Conformance Target must be measured.")

  @Valid

  public TimePeriod getConformancePeriod() {
    return conformancePeriod;
  }

  public void setConformancePeriod(TimePeriod conformancePeriod) {
    this.conformancePeriod = conformancePeriod;
  }

  public ServiceLevelObjective conformanceTarget(String conformanceTarget) {
    this.conformanceTarget = conformanceTarget;
    return this;
  }

  /**
   * A value used to determine if Service Level Objective is met.  The data type should be adjusted case by case.
   * @return conformanceTarget
  **/
  @ApiModelProperty(value = "A value used to determine if Service Level Objective is met.  The data type should be adjusted case by case.")


  public String getConformanceTarget() {
    return conformanceTarget;
  }

  public void setConformanceTarget(String conformanceTarget) {
    this.conformanceTarget = conformanceTarget;
  }

  public ServiceLevelObjective graceTimes(String graceTimes) {
    this.graceTimes = graceTimes;
    return this;
  }

  /**
   * The number of times an objective can remain un-updated without  a violation of a Service Level Agreement in reference to a measurement period and/or Service Level Agreement reporting period.
   * @return graceTimes
  **/
  @ApiModelProperty(value = "The number of times an objective can remain un-updated without  a violation of a Service Level Agreement in reference to a measurement period and/or Service Level Agreement reporting period.")


  public String getGraceTimes() {
    return graceTimes;
  }

  public void setGraceTimes(String graceTimes) {
    this.graceTimes = graceTimes;
  }

  public ServiceLevelObjective href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The hyperlink to access a service level objective.
   * @return href
  **/
  @ApiModelProperty(value = "The hyperlink to access a service level objective.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceLevelObjective id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of a service level objectives.
   * @return id
  **/
  @ApiModelProperty(value = "The identifier of a service level objectives.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceLevelObjective name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the service level objectives.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the service level objectives.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceLevelObjective thresholdTarget(String thresholdTarget) {
    this.thresholdTarget = thresholdTarget;
    return this;
  }

  /**
   * A value that used to specify when a warning should be used  that indicates an objective is danger of not being met. Notice, the data type should be adjusted case by case.
   * @return thresholdTarget
  **/
  @ApiModelProperty(value = "A value that used to specify when a warning should be used  that indicates an objective is danger of not being met. Notice, the data type should be adjusted case by case.")


  public String getThresholdTarget() {
    return thresholdTarget;
  }

  public void setThresholdTarget(String thresholdTarget) {
    this.thresholdTarget = thresholdTarget;
  }

  public ServiceLevelObjective tolerancePeriod(TimePeriod tolerancePeriod) {
    this.tolerancePeriod = tolerancePeriod;
    return this;
  }

  /**
   * Get tolerancePeriod
   * @return tolerancePeriod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TimePeriod getTolerancePeriod() {
    return tolerancePeriod;
  }

  public void setTolerancePeriod(TimePeriod tolerancePeriod) {
    this.tolerancePeriod = tolerancePeriod;
  }

  public ServiceLevelObjective toleranceTarget(String toleranceTarget) {
    this.toleranceTarget = toleranceTarget;
    return this;
  }

  /**
   * A value that specifies the allowable variation of a conformance  Target. The data type should be adjusted case by case.
   * @return toleranceTarget
  **/
  @ApiModelProperty(value = "A value that specifies the allowable variation of a conformance  Target. The data type should be adjusted case by case.")


  public String getToleranceTarget() {
    return toleranceTarget;
  }

  public void setToleranceTarget(String toleranceTarget) {
    this.toleranceTarget = toleranceTarget;
  }

  public ServiceLevelObjective validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * A valid duration of a thing.
   * @return validFor
  **/
  @ApiModelProperty(value = "A valid duration of a thing.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceLevelObjective specParameter(ServiceLevelSpecParameter specParameter) {
    this.specParameter = specParameter;
    return this;
  }

  /**
   * Get specParameter
   * @return specParameter
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ServiceLevelSpecParameter getSpecParameter() {
    return specParameter;
  }

  public void setSpecParameter(ServiceLevelSpecParameter specParameter) {
    this.specParameter = specParameter;
  }

  public ServiceLevelObjective specConsequence(List<ServiceLevelSpecConsequence> specConsequence) {
    this.specConsequence = specConsequence;
    return this;
  }

  public ServiceLevelObjective addSpecConsequenceItem(ServiceLevelSpecConsequence specConsequenceItem) {
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
  @ApiModelProperty(value = "")

  @Valid

  public List<ServiceLevelSpecConsequence> getSpecConsequence() {
    return specConsequence;
  }

  public void setSpecConsequence(List<ServiceLevelSpecConsequence> specConsequence) {
    this.specConsequence = specConsequence;
  }

  public ServiceLevelObjective type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @ApiModelProperty(value = "The class type of the actual resource (for type extension).")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ServiceLevelObjective schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A link to the schema describing a resource (for type extension).
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A link to the schema describing a resource (for type extension).")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ServiceLevelObjective baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The base type for use in polymorphic collections
   * @return baseType
  **/
  @ApiModelProperty(value = "The base type for use in polymorphic collections")


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
    ServiceLevelObjective serviceLevelObjective = (ServiceLevelObjective) o;
    return Objects.equals(this.conformanceComparator, serviceLevelObjective.conformanceComparator) &&
        Objects.equals(this.conformancePeriod, serviceLevelObjective.conformancePeriod) &&
        Objects.equals(this.conformanceTarget, serviceLevelObjective.conformanceTarget) &&
        Objects.equals(this.graceTimes, serviceLevelObjective.graceTimes) &&
        Objects.equals(this.href, serviceLevelObjective.href) &&
        Objects.equals(this.id, serviceLevelObjective.id) &&
        Objects.equals(this.name, serviceLevelObjective.name) &&
        Objects.equals(this.thresholdTarget, serviceLevelObjective.thresholdTarget) &&
        Objects.equals(this.tolerancePeriod, serviceLevelObjective.tolerancePeriod) &&
        Objects.equals(this.toleranceTarget, serviceLevelObjective.toleranceTarget) &&
        Objects.equals(this.validFor, serviceLevelObjective.validFor) &&
        Objects.equals(this.specParameter, serviceLevelObjective.specParameter) &&
        Objects.equals(this.specConsequence, serviceLevelObjective.specConsequence) &&
        Objects.equals(this.type, serviceLevelObjective.type) &&
        Objects.equals(this.schemaLocation, serviceLevelObjective.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelObjective.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conformanceComparator, conformancePeriod, conformanceTarget, graceTimes, href, id, name, thresholdTarget, tolerancePeriod, toleranceTarget, validFor, specParameter, specConsequence, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelObjective {\n");
    
    sb.append("    conformanceComparator: ").append(toIndentedString(conformanceComparator)).append("\n");
    sb.append("    conformancePeriod: ").append(toIndentedString(conformancePeriod)).append("\n");
    sb.append("    conformanceTarget: ").append(toIndentedString(conformanceTarget)).append("\n");
    sb.append("    graceTimes: ").append(toIndentedString(graceTimes)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    thresholdTarget: ").append(toIndentedString(thresholdTarget)).append("\n");
    sb.append("    tolerancePeriod: ").append(toIndentedString(tolerancePeriod)).append("\n");
    sb.append("    toleranceTarget: ").append(toIndentedString(toleranceTarget)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

