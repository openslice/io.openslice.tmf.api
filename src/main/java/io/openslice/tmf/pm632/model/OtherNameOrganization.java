package io.openslice.tmf.pm632.model;

import java.util.Objects;
import io.openslice.tmf.common.model.TimePeriod;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Keeps track of other names, for example the old name of an organization.
 */
@ApiModel(description = "Keeps track of other names, for example the old name of an organization.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class OtherNameOrganization   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("nameType")
  private String nameType = null;

  @JsonProperty("tradingName")
  private String tradingName = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public OtherNameOrganization name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Organization name (department name for example)
   * @return name
  **/
  @ApiModelProperty(value = "Organization name (department name for example)")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OtherNameOrganization nameType(String nameType) {
    this.nameType = nameType;
    return this;
  }

  /**
   * Co. , Inc. , Ltd. , Pty Ltd. , Plc; , Gmbh
   * @return nameType
  **/
  @ApiModelProperty(value = "Co. , Inc. , Ltd. , Pty Ltd. , Plc; , Gmbh")


  public String getNameType() {
    return nameType;
  }

  public void setNameType(String nameType) {
    this.nameType = nameType;
  }

  public OtherNameOrganization tradingName(String tradingName) {
    this.tradingName = tradingName;
    return this;
  }

  /**
   * The name that the organization trades under
   * @return tradingName
  **/
  @ApiModelProperty(value = "The name that the organization trades under")


  public String getTradingName() {
    return tradingName;
  }

  public void setTradingName(String tradingName) {
    this.tradingName = tradingName;
  }

  public OtherNameOrganization validFor(TimePeriod validFor) {
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

  public OtherNameOrganization baseType(String baseType) {
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

  public OtherNameOrganization schemaLocation(String schemaLocation) {
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

  public OtherNameOrganization type(String type) {
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
    OtherNameOrganization otherNameOrganization = (OtherNameOrganization) o;
    return Objects.equals(this.name, otherNameOrganization.name) &&
        Objects.equals(this.nameType, otherNameOrganization.nameType) &&
        Objects.equals(this.tradingName, otherNameOrganization.tradingName) &&
        Objects.equals(this.validFor, otherNameOrganization.validFor) &&
        Objects.equals(this.baseType, otherNameOrganization.baseType) &&
        Objects.equals(this.schemaLocation, otherNameOrganization.schemaLocation) &&
        Objects.equals(this.type, otherNameOrganization.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, nameType, tradingName, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtherNameOrganization {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nameType: ").append(toIndentedString(nameType)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
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

