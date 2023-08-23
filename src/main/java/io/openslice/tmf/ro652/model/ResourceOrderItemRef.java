package io.openslice.tmf.ro652.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ResourceOrderItemRef
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class ResourceOrderItemRef   {
  @JsonProperty("itemId")
  private String itemId = null;

  @JsonProperty("resourceOrderHref")
  private String resourceOrderHref = null;

  @JsonProperty("resourceOrderId")
  private String resourceOrderId = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public ResourceOrderItemRef itemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Identifier of the line item
   * @return itemId
  **/
  @Schema(description = "Identifier of the line item")
  
    public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public ResourceOrderItemRef resourceOrderHref(String resourceOrderHref) {
    this.resourceOrderHref = resourceOrderHref;
    return this;
  }

  /**
   * Link to the order to which this item belongs to
   * @return resourceOrderHref
  **/
  @Schema(description = "Link to the order to which this item belongs to")
  
    public String getResourceOrderHref() {
    return resourceOrderHref;
  }

  public void setResourceOrderHref(String resourceOrderHref) {
    this.resourceOrderHref = resourceOrderHref;
  }

  public ResourceOrderItemRef resourceOrderId(String resourceOrderId) {
    this.resourceOrderId = resourceOrderId;
    return this;
  }

  /**
   * Identifier of the order that this item belongs to
   * @return resourceOrderId
  **/
  @Schema(description = "Identifier of the order that this item belongs to")
  
    public String getResourceOrderId() {
    return resourceOrderId;
  }

  public void setResourceOrderId(String resourceOrderId) {
    this.resourceOrderId = resourceOrderId;
  }

  public ResourceOrderItemRef _atBaseType(String _atBaseType) {
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

  public ResourceOrderItemRef _atSchemaLocation(String _atSchemaLocation) {
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

  public ResourceOrderItemRef _atType(String _atType) {
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

  public ResourceOrderItemRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @Schema(description = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceOrderItemRef resourceOrderItemRef = (ResourceOrderItemRef) o;
    return Objects.equals(this.itemId, resourceOrderItemRef.itemId) &&
        Objects.equals(this.resourceOrderHref, resourceOrderItemRef.resourceOrderHref) &&
        Objects.equals(this.resourceOrderId, resourceOrderItemRef.resourceOrderId) &&
        Objects.equals(this._atBaseType, resourceOrderItemRef._atBaseType) &&
        Objects.equals(this._atSchemaLocation, resourceOrderItemRef._atSchemaLocation) &&
        Objects.equals(this._atType, resourceOrderItemRef._atType) &&
        Objects.equals(this._atReferredType, resourceOrderItemRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, resourceOrderHref, resourceOrderId, _atBaseType, _atSchemaLocation, _atType, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceOrderItemRef {\n");
    
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    resourceOrderHref: ").append(toIndentedString(resourceOrderHref)).append("\n");
    sb.append("    resourceOrderId: ").append(toIndentedString(resourceOrderId)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
