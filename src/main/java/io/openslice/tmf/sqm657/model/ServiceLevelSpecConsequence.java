package io.openslice.tmf.sqm657.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.sqm657.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Some consequences for the provider of the Service are resulted when the service level objective does not meet.
 */
@ApiModel(description = "Some consequences for the provider of the Service are resulted when the service level objective does not meet.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

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
  @ApiModelProperty(value = "Recommended remedy for a violated Service Level Objective.  This could be a hyperlink to the recommended action.")


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
  @ApiModelProperty(value = "A valid duration of a thing.")

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
  @ApiModelProperty(value = "The class type of the actual resource (for type extension).")


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
  @ApiModelProperty(value = "A link to the schema describing a resource (for type extension).")


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

