package io.openslice.tmf.ro652.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * ResourceOrderItemRelationship
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class ResourceOrderItemRelationship   {
  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("orderItem")
  private ResourceOrderItemRef orderItem = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public ResourceOrderItemRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of the order item relationship
   * @return relationshipType
  **/
  @Schema(description = "Type of the order item relationship")
  
    public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ResourceOrderItemRelationship orderItem(ResourceOrderItemRef orderItem) {
    this.orderItem = orderItem;
    return this;
  }

  /**
   * Get orderItem
   * @return orderItem
  **/
  @Schema(description = "")
  
    @Valid
    public ResourceOrderItemRef getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(ResourceOrderItemRef orderItem) {
    this.orderItem = orderItem;
  }

  public ResourceOrderItemRelationship _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public ResourceOrderItemRelationship _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public ResourceOrderItemRelationship _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
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
    ResourceOrderItemRelationship resourceOrderItemRelationship = (ResourceOrderItemRelationship) o;
    return Objects.equals(this.relationshipType, resourceOrderItemRelationship.relationshipType) &&
        Objects.equals(this.orderItem, resourceOrderItemRelationship.orderItem) &&
        Objects.equals(this._atBaseType, resourceOrderItemRelationship._atBaseType) &&
        Objects.equals(this._atSchemaLocation, resourceOrderItemRelationship._atSchemaLocation) &&
        Objects.equals(this._atType, resourceOrderItemRelationship._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relationshipType, orderItem, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceOrderItemRelationship {\n");
    
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    orderItem: ").append(toIndentedString(orderItem)).append("\n");
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
