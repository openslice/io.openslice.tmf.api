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

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Request for cancellation an existing product order
 */
@Schema(description = "Request for cancellation an existing product order")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class CancelProductOrder   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("cancellationReason")
  private String cancellationReason = null;

  @JsonProperty("effectiveCancellationDate")
  private OffsetDateTime effectiveCancellationDate = null;

  @JsonProperty("requestedCancellationDate")
  private OffsetDateTime requestedCancellationDate = null;

  @JsonProperty("productOrder")
  private ProductOrderRef productOrder = null;

  @JsonProperty("state")
  private TaskStateType state = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public CancelProductOrder id(String id) {
    this.id = id;
    return this;
  }

  /**
   * id of the cancellation request (this is not an order id)
   * @return id
  **/
  @Schema(description = "id of the cancellation request (this is not an order id)")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CancelProductOrder href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access the cancellation request
   * @return href
  **/
  @Schema(description = "Hyperlink to access the cancellation request")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CancelProductOrder cancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
    return this;
  }

  /**
   * Reason why the order is cancelled.
   * @return cancellationReason
  **/
  @Schema(description = "Reason why the order is cancelled.")
  
    public String getCancellationReason() {
    return cancellationReason;
  }

  public void setCancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public CancelProductOrder effectiveCancellationDate(OffsetDateTime effectiveCancellationDate) {
    this.effectiveCancellationDate = effectiveCancellationDate;
    return this;
  }

  /**
   * Date when the order is cancelled.
   * @return effectiveCancellationDate
  **/
  @Schema(description = "Date when the order is cancelled.")
  
    @Valid
    public OffsetDateTime getEffectiveCancellationDate() {
    return effectiveCancellationDate;
  }

  public void setEffectiveCancellationDate(OffsetDateTime effectiveCancellationDate) {
    this.effectiveCancellationDate = effectiveCancellationDate;
  }

  public CancelProductOrder requestedCancellationDate(OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
    return this;
  }

  /**
   * Date when the submitter wants the order to be cancelled
   * @return requestedCancellationDate
  **/
  @Schema(description = "Date when the submitter wants the order to be cancelled")
  
    @Valid
    public OffsetDateTime getRequestedCancellationDate() {
    return requestedCancellationDate;
  }

  public void setRequestedCancellationDate(OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
  }

  public CancelProductOrder productOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
    return this;
  }

  /**
   * Get productOrder
   * @return productOrder
  **/
  @Schema(description = "")
      @NotNull

    @Valid
    public ProductOrderRef getProductOrder() {
    return productOrder;
  }

  public void setProductOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
  }

  public CancelProductOrder state(TaskStateType state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @Schema(description = "")
  
    @Valid
    public TaskStateType getState() {
    return state;
  }

  public void setState(TaskStateType state) {
    this.state = state;
  }

  public CancelProductOrder baseType(String baseType) {
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

  public CancelProductOrder schemaLocation(String schemaLocation) {
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

  public CancelProductOrder type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelProductOrder cancelProductOrder = (CancelProductOrder) o;
    return Objects.equals(this.id, cancelProductOrder.id) &&
        Objects.equals(this.href, cancelProductOrder.href) &&
        Objects.equals(this.cancellationReason, cancelProductOrder.cancellationReason) &&
        Objects.equals(this.effectiveCancellationDate, cancelProductOrder.effectiveCancellationDate) &&
        Objects.equals(this.requestedCancellationDate, cancelProductOrder.requestedCancellationDate) &&
        Objects.equals(this.productOrder, cancelProductOrder.productOrder) &&
        Objects.equals(this.state, cancelProductOrder.state) &&
        Objects.equals(this.baseType, cancelProductOrder.baseType) &&
        Objects.equals(this.schemaLocation, cancelProductOrder.schemaLocation) &&
        Objects.equals(this.type, cancelProductOrder.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, cancellationReason, effectiveCancellationDate, requestedCancellationDate, productOrder, state, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelProductOrder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    cancellationReason: ").append(toIndentedString(cancellationReason)).append("\n");
    sb.append("    effectiveCancellationDate: ").append(toIndentedString(effectiveCancellationDate)).append("\n");
    sb.append("    requestedCancellationDate: ").append(toIndentedString(requestedCancellationDate)).append("\n");
    sb.append("    productOrder: ").append(toIndentedString(productOrder)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
