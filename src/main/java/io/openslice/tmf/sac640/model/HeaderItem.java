package io.openslice.tmf.sac640.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An item typically included in a request or response
 */
@ApiModel(description = "An item typically included in a request or response")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
public class HeaderItem   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public HeaderItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the header item, e.g. locale
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the header item, e.g. locale")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HeaderItem value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The value of the header item, e.g. en-us
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The value of the header item, e.g. en-us")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public HeaderItem _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public HeaderItem _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public HeaderItem _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HeaderItem headerItem = (HeaderItem) o;
    return Objects.equals(this.name, headerItem.name) &&
        Objects.equals(this.value, headerItem.value) &&
        Objects.equals(this._atBaseType, headerItem._atBaseType) &&
        Objects.equals(this._atSchemaLocation, headerItem._atSchemaLocation) &&
        Objects.equals(this._atType, headerItem._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HeaderItem {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
