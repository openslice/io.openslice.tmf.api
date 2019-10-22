package io.openslice.tmf.pcm620.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Describes a non-composite relationship between product offering prices. For example one price might be an discount alteration for another price.
 */
@ApiModel(description = "Describes a non-composite relationship between product offering prices. For example one price might be an discount alteration for another price.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class ProductOfferingPriceRelationship   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ProductOfferingPriceRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the associated product offering price
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the associated product offering price")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingPriceRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * hyperlink reference of the associated product offering price
   * @return href
  **/
  @ApiModelProperty(value = "hyperlink reference of the associated product offering price")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOfferingPriceRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the associated product offering price
   * @return name
  **/
  @ApiModelProperty(value = "Name of the associated product offering price")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductOfferingPriceRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * type of the relationship, for example override, discount, etc.
   * @return relationshipType
  **/
  @ApiModelProperty(value = "type of the relationship, for example override, discount, etc.")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ProductOfferingPriceRelationship baseType(String baseType) {
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

  public ProductOfferingPriceRelationship schemaLocation(String schemaLocation) {
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

  public ProductOfferingPriceRelationship type(String type) {
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
    ProductOfferingPriceRelationship productOfferingPriceRelationship = (ProductOfferingPriceRelationship) o;
    return Objects.equals(this.id, productOfferingPriceRelationship.id) &&
        Objects.equals(this.href, productOfferingPriceRelationship.href) &&
        Objects.equals(this.name, productOfferingPriceRelationship.name) &&
        Objects.equals(this.relationshipType, productOfferingPriceRelationship.relationshipType) &&
        Objects.equals(this.baseType, productOfferingPriceRelationship.baseType) &&
        Objects.equals(this.schemaLocation, productOfferingPriceRelationship.schemaLocation) &&
        Objects.equals(this.type, productOfferingPriceRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, relationshipType, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingPriceRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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

