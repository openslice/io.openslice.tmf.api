package io.openslice.tmf.pm632.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * External reference of the individual or reference in other system
 */
@ApiModel(description = "External reference of the individual or reference in other system")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class ExternalReference   {
  @JsonProperty("externalReferenceType")
  private String externalReferenceType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ExternalReference externalReferenceType(String externalReferenceType) {
    this.externalReferenceType = externalReferenceType;
    return this;
  }

  /**
   * Type of the external reference
   * @return externalReferenceType
  **/
  @ApiModelProperty(value = "Type of the external reference")


  public String getExternalReferenceType() {
    return externalReferenceType;
  }

  public void setExternalReferenceType(String externalReferenceType) {
    this.externalReferenceType = externalReferenceType;
  }

  public ExternalReference name(String name) {
    this.name = name;
    return this;
  }

  /**
   * External reference name
   * @return name
  **/
  @ApiModelProperty(value = "External reference name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ExternalReference baseType(String baseType) {
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

  public ExternalReference schemaLocation(String schemaLocation) {
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

  public ExternalReference type(String type) {
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
    ExternalReference externalReference = (ExternalReference) o;
    return Objects.equals(this.externalReferenceType, externalReference.externalReferenceType) &&
        Objects.equals(this.name, externalReference.name) &&
        Objects.equals(this.baseType, externalReference.baseType) &&
        Objects.equals(this.schemaLocation, externalReference.schemaLocation) &&
        Objects.equals(this.type, externalReference.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalReferenceType, name, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalReference {\n");
    
    sb.append("    externalReferenceType: ").append(toIndentedString(externalReferenceType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

