package io.openslice.tmf.pcm620.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * provides references to the corresponding market segment as target of product offerings. A market segment is grouping of Parties, GeographicAreas, SalesChannels, and so forth.
 */
@ApiModel(description = "provides references to the corresponding market segment as target of product offerings. A market segment is grouping of Parties, GeographicAreas, SalesChannels, and so forth.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class MarketSegmentRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public MarketSegmentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the market segment
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the market segment")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MarketSegmentRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the market segment
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the market segment")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public MarketSegmentRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the market segment
   * @return name
  **/
  @ApiModelProperty(value = "Name of the market segment")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MarketSegmentRef baseType(String baseType) {
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

  public MarketSegmentRef schemaLocation(String schemaLocation) {
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

  public MarketSegmentRef type(String type) {
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

  public MarketSegmentRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * (Class) type of the referred market segment
   * @return referredType
  **/
  @ApiModelProperty(value = "(Class) type of the referred market segment")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarketSegmentRef marketSegmentRef = (MarketSegmentRef) o;
    return Objects.equals(this.id, marketSegmentRef.id) &&
        Objects.equals(this.href, marketSegmentRef.href) &&
        Objects.equals(this.name, marketSegmentRef.name) &&
        Objects.equals(this.baseType, marketSegmentRef.baseType) &&
        Objects.equals(this.schemaLocation, marketSegmentRef.schemaLocation) &&
        Objects.equals(this.type, marketSegmentRef.type) &&
        Objects.equals(this.referredType, marketSegmentRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarketSegmentRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

