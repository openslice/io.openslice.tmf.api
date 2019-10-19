package io.openslice.tmf.pm632.model;

import java.util.Objects;
import io.openslice.tmf.common.model.TimePeriod;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Lack or inadequate strength or ability.
 */
@ApiModel(description = "Lack or inadequate strength or ability.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class Disability   {
  @JsonProperty("disabilityCode")
  private String disabilityCode = null;

  @JsonProperty("disabilityName")
  private String disabilityName = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Disability disabilityCode(String disabilityCode) {
    this.disabilityCode = disabilityCode;
    return this;
  }

  /**
   * Code of the disability
   * @return disabilityCode
  **/
  @ApiModelProperty(value = "Code of the disability")


  public String getDisabilityCode() {
    return disabilityCode;
  }

  public void setDisabilityCode(String disabilityCode) {
    this.disabilityCode = disabilityCode;
  }

  public Disability disabilityName(String disabilityName) {
    this.disabilityName = disabilityName;
    return this;
  }

  /**
   * Name of the disability
   * @return disabilityName
  **/
  @ApiModelProperty(value = "Name of the disability")


  public String getDisabilityName() {
    return disabilityName;
  }

  public void setDisabilityName(String disabilityName) {
    this.disabilityName = disabilityName;
  }

  public Disability validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Disability baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Disability schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Disability type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
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
    Disability disability = (Disability) o;
    return Objects.equals(this.disabilityCode, disability.disabilityCode) &&
        Objects.equals(this.disabilityName, disability.disabilityName) &&
        Objects.equals(this.validFor, disability.validFor) &&
        Objects.equals(this.baseType, disability.baseType) &&
        Objects.equals(this.schemaLocation, disability.schemaLocation) &&
        Objects.equals(this.type, disability.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disabilityCode, disabilityName, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Disability {\n");
    
    sb.append("    disabilityCode: ").append(toIndentedString(disabilityCode)).append("\n");
    sb.append("    disabilityName: ").append(toIndentedString(disabilityName)).append("\n");
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

