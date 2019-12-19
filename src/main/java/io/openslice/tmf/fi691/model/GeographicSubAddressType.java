package io.openslice.tmf.fi691.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeographicSubAddressType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "GeographicSubAddressType")
public class GeographicSubAddressType extends BaseRootNamedEntity {
 

  @JsonProperty("subUnitType")
  private String subUnitType = null;

  @JsonProperty("subUnitNumber")
  private String subUnitNumber = null;

  @JsonProperty("levelType")
  private String levelType = null;

  @JsonProperty("levelNumber")
  private String levelNumber = null;

  @JsonProperty("buildingName")
  private String buildingName = null;

  @JsonProperty("privateStreetName")
  private String privateStreetName = null;

  @JsonProperty("privateStreetNumber")
  private String privateStreetNumber = null;



  public GeographicSubAddressType subUnitType(String subUnitType) {
    this.subUnitType = subUnitType;
    return this;
  }

  /**
   * the type of subunit (e.g.: BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF)
   * @return subUnitType
  **/
  @ApiModelProperty(value = "the type of subunit (e.g.: BERTH, FLAT, PIER, SUITE, SHOP, TOWER, UNIT, WHARF)")


  public String getSubUnitType() {
    return subUnitType;
  }

  public void setSubUnitType(String subUnitType) {
    this.subUnitType = subUnitType;
  }

  public GeographicSubAddressType subUnitNumber(String subUnitNumber) {
    this.subUnitNumber = subUnitNumber;
    return this;
  }

  /**
   * the discriminator used for the subunit often just a simple number (e.g.: 5 for FLAT 5), may also be a range
   * @return subUnitNumber
  **/
  @ApiModelProperty(value = "the discriminator used for the subunit often just a simple number (e.g.: 5 for FLAT 5), may also be a range")


  public String getSubUnitNumber() {
    return subUnitNumber;
  }

  public void setSubUnitNumber(String subUnitNumber) {
    this.subUnitNumber = subUnitNumber;
  }

  public GeographicSubAddressType levelType(String levelType) {
    this.levelType = levelType;
    return this;
  }

  /**
   * Describes level types within a building (e.g.: BASEMENT) 
   * @return levelType
  **/
  @ApiModelProperty(value = "Describes level types within a building (e.g.: BASEMENT) ")


  public String getLevelType() {
    return levelType;
  }

  public void setLevelType(String levelType) {
    this.levelType = levelType;
  }

  public GeographicSubAddressType levelNumber(String levelNumber) {
    this.levelNumber = levelNumber;
    return this;
  }

  /**
   * used where a level type may be repeated (e.g.: BASEMENT 1, BASEMENT 2)
   * @return levelNumber
  **/
  @ApiModelProperty(value = "used where a level type may be repeated (e.g.: BASEMENT 1, BASEMENT 2)")


  public String getLevelNumber() {
    return levelNumber;
  }

  public void setLevelNumber(String levelNumber) {
    this.levelNumber = levelNumber;
  }

  public GeographicSubAddressType buildingName(String buildingName) {
    this.buildingName = buildingName;
    return this;
  }

  /**
   * Allows for buildings that have well-known names
   * @return buildingName
  **/
  @ApiModelProperty(value = "Allows for buildings that have well-known names")


  public String getBuildingName() {
    return buildingName;
  }

  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public GeographicSubAddressType privateStreetName(String privateStreetName) {
    this.privateStreetName = privateStreetName;
    return this;
  }

  /**
   * private streets internal to a property (e.g. a university) may have internal names that are not recorded by the land title office
   * @return privateStreetName
  **/
  @ApiModelProperty(value = "private streets internal to a property (e.g. a university) may have internal names that are not recorded by the land title office")


  public String getPrivateStreetName() {
    return privateStreetName;
  }

  public void setPrivateStreetName(String privateStreetName) {
    this.privateStreetName = privateStreetName;
  }

  public GeographicSubAddressType privateStreetNumber(String privateStreetNumber) {
    this.privateStreetNumber = privateStreetNumber;
    return this;
  }

  /**
   * Private streets numbers internal to a private street
   * @return privateStreetNumber
  **/
  @ApiModelProperty(value = "Private streets numbers internal to a private street")


  public String getPrivateStreetNumber() {
    return privateStreetNumber;
  }

  public void setPrivateStreetNumber(String privateStreetNumber) {
    this.privateStreetNumber = privateStreetNumber;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeographicSubAddressType geographicSubAddressType = (GeographicSubAddressType) o;
    return Objects.equals(this.type, geographicSubAddressType.type) &&
        Objects.equals(this.name, geographicSubAddressType.name) &&
        Objects.equals(this.subUnitType, geographicSubAddressType.subUnitType) &&
        Objects.equals(this.subUnitNumber, geographicSubAddressType.subUnitNumber) &&
        Objects.equals(this.levelType, geographicSubAddressType.levelType) &&
        Objects.equals(this.levelNumber, geographicSubAddressType.levelNumber) &&
        Objects.equals(this.buildingName, geographicSubAddressType.buildingName) &&
        Objects.equals(this.privateStreetName, geographicSubAddressType.privateStreetName) &&
        Objects.equals(this.privateStreetNumber, geographicSubAddressType.privateStreetNumber) &&
        Objects.equals(this.type, geographicSubAddressType.type) &&
        Objects.equals(this.schemaLocation, geographicSubAddressType.schemaLocation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeographicSubAddressType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subUnitType: ").append(toIndentedString(subUnitType)).append("\n");
    sb.append("    subUnitNumber: ").append(toIndentedString(subUnitNumber)).append("\n");
    sb.append("    levelType: ").append(toIndentedString(levelType)).append("\n");
    sb.append("    levelNumber: ").append(toIndentedString(levelNumber)).append("\n");
    sb.append("    buildingName: ").append(toIndentedString(buildingName)).append("\n");
    sb.append("    privateStreetName: ").append(toIndentedString(privateStreetName)).append("\n");
    sb.append("    privateStreetNumber: ").append(toIndentedString(privateStreetNumber)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

