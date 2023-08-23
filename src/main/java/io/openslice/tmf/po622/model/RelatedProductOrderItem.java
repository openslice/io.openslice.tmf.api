/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.po622.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * RelatedProductOrderItem (ProductOrder item) .The product order item which triggered product creation/change/termination.
 */
@Schema(description = "RelatedProductOrderItem (ProductOrder item) .The product order item which triggered product creation/change/termination.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class RelatedProductOrderItem   {
  @JsonProperty("orderItemAction")
  private String orderItemAction = null;

  @JsonProperty("orderItemId")
  private String orderItemId = null;

  @JsonProperty("productOrderHref")
  private String productOrderHref = null;

  @JsonProperty("productOrderId")
  private String productOrderId = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public RelatedProductOrderItem orderItemAction(String orderItemAction) {
    this.orderItemAction = orderItemAction;
    return this;
  }

  /**
   * Action of the order item for this product
   * @return orderItemAction
  **/
  @Schema(description = "Action of the order item for this product")
  
    public String getOrderItemAction() {
    return orderItemAction;
  }

  public void setOrderItemAction(String orderItemAction) {
    this.orderItemAction = orderItemAction;
  }

  public RelatedProductOrderItem orderItemId(String orderItemId) {
    this.orderItemId = orderItemId;
    return this;
  }

  /**
   * Identifier of the order item where the product was managed
   * @return orderItemId
  **/
  @Schema(description = "Identifier of the order item where the product was managed")
      @NotNull

    public String getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(String orderItemId) {
    this.orderItemId = orderItemId;
  }

  public RelatedProductOrderItem productOrderHref(String productOrderHref) {
    this.productOrderHref = productOrderHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return productOrderHref
  **/
  @Schema(description = "Reference of the related entity.")
  
    public String getProductOrderHref() {
    return productOrderHref;
  }

  public void setProductOrderHref(String productOrderHref) {
    this.productOrderHref = productOrderHref;
  }

  public RelatedProductOrderItem productOrderId(String productOrderId) {
    this.productOrderId = productOrderId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return productOrderId
  **/
  @Schema(description = "Unique identifier of a related entity.")
      @NotNull

    public String getProductOrderId() {
    return productOrderId;
  }

  public void setProductOrderId(String productOrderId) {
    this.productOrderId = productOrderId;
  }

  public RelatedProductOrderItem role(String role) {
    this.role = role;
    return this;
  }

  /**
   * role of the product order item for this product
   * @return role
  **/
  @Schema(description = "role of the product order item for this product")
  
    public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public RelatedProductOrderItem baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public RelatedProductOrderItem schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public RelatedProductOrderItem type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String type) {
    this.type = type;
  }

  public RelatedProductOrderItem _atReferredType(String _atReferredType) {
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
    RelatedProductOrderItem relatedProductOrderItem = (RelatedProductOrderItem) o;
    return Objects.equals(this.orderItemAction, relatedProductOrderItem.orderItemAction) &&
        Objects.equals(this.orderItemId, relatedProductOrderItem.orderItemId) &&
        Objects.equals(this.productOrderHref, relatedProductOrderItem.productOrderHref) &&
        Objects.equals(this.productOrderId, relatedProductOrderItem.productOrderId) &&
        Objects.equals(this.role, relatedProductOrderItem.role) &&
        Objects.equals(this.baseType, relatedProductOrderItem.baseType) &&
        Objects.equals(this.schemaLocation, relatedProductOrderItem.schemaLocation) &&
        Objects.equals(this.type, relatedProductOrderItem.type) &&
        Objects.equals(this._atReferredType, relatedProductOrderItem._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderItemAction, orderItemId, productOrderHref, productOrderId, role, baseType, schemaLocation, type, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedProductOrderItem {\n");
    
    sb.append("    orderItemAction: ").append(toIndentedString(orderItemAction)).append("\n");
    sb.append("    orderItemId: ").append(toIndentedString(orderItemId)).append("\n");
    sb.append("    productOrderHref: ").append(toIndentedString(productOrderHref)).append("\n");
    sb.append("    productOrderId: ").append(toIndentedString(productOrderId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
