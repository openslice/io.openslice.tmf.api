package io.openslice.tmf.pm632.model;

import java.util.Objects;
import io.openslice.tmf.common.model.TimePeriod;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Indicates the contact medium that could be used to contact the party.
 */
@ApiModel(description = "Indicates the contact medium that could be used to contact the party.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class ContactMedium   {
  @JsonProperty("mediumType")
  private String mediumType = null;

  @JsonProperty("preferred")
  private Boolean preferred = null;

  @JsonProperty("characteristic")
  private MediumCharacteristic characteristic = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ContactMedium mediumType(String mediumType) {
    this.mediumType = mediumType;
    return this;
  }

  /**
   * Type of the contact medium, such as: email address, telephone number, postal address
   * @return mediumType
  **/
  @ApiModelProperty(value = "Type of the contact medium, such as: email address, telephone number, postal address")


  public String getMediumType() {
    return mediumType;
  }

  public void setMediumType(String mediumType) {
    this.mediumType = mediumType;
  }

  public ContactMedium preferred(Boolean preferred) {
    this.preferred = preferred;
    return this;
  }

  /**
   * If true, indicates that is the preferred contact medium
   * @return preferred
  **/
  @ApiModelProperty(value = "If true, indicates that is the preferred contact medium")


  public Boolean isPreferred() {
    return preferred;
  }

  public void setPreferred(Boolean preferred) {
    this.preferred = preferred;
  }

  public ContactMedium characteristic(MediumCharacteristic characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  /**
   * Any additional characteristic(s) of this contact medium
   * @return characteristic
  **/
  @ApiModelProperty(value = "Any additional characteristic(s) of this contact medium")

  @Valid

  public MediumCharacteristic getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(MediumCharacteristic characteristic) {
    this.characteristic = characteristic;
  }

  public ContactMedium validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The time period that the contact medium is valid for
   * @return validFor
  **/
  @ApiModelProperty(value = "The time period that the contact medium is valid for")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ContactMedium baseType(String baseType) {
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

  public ContactMedium schemaLocation(String schemaLocation) {
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

  public ContactMedium type(String type) {
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
    ContactMedium contactMedium = (ContactMedium) o;
    return Objects.equals(this.mediumType, contactMedium.mediumType) &&
        Objects.equals(this.preferred, contactMedium.preferred) &&
        Objects.equals(this.characteristic, contactMedium.characteristic) &&
        Objects.equals(this.validFor, contactMedium.validFor) &&
        Objects.equals(this.baseType, contactMedium.baseType) &&
        Objects.equals(this.schemaLocation, contactMedium.schemaLocation) &&
        Objects.equals(this.type, contactMedium.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediumType, preferred, characteristic, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMedium {\n");
    
    sb.append("    mediumType: ").append(toIndentedString(mediumType)).append("\n");
    sb.append("    preferred: ").append(toIndentedString(preferred)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
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

