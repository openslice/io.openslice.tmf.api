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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * An identified part of the order. A product order is decomposed into one or more order items.
 */
@Schema(description = "An identified part of the order. A product order is decomposed into one or more order items.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class ProductOrderItem   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("action")
  private OrderItemActionType action = null;

  @JsonProperty("appointment")
  private AppointmentRef appointment = null;

  @JsonProperty("billingAccount")
  private BillingAccountRef billingAccount = null;

  @JsonProperty("itemPrice")
  @Valid
  private List<OrderPrice> itemPrice = null;

  @JsonProperty("itemTerm")
  @Valid
  private List<OrderTerm> itemTerm = null;

  @JsonProperty("itemTotalPrice")
  @Valid
  private List<OrderPrice> itemTotalPrice = null;

  @JsonProperty("payment")
  @Valid
  private List<PaymentRef> payment = null;

  @JsonProperty("product")
  private ProductRefOrValue product = null;

  @JsonProperty("productOffering")
  private ProductOfferingRef productOffering = null;

  @JsonProperty("productOfferingQualificationItem")
  private ProductOfferingQualificationItemRef productOfferingQualificationItem = null;

  @JsonProperty("productOrderItem")
  @Valid
  private List<ProductOrderItem> productOrderItem = null;

  @JsonProperty("productOrderItemRelationship")
  @Valid
  private List<OrderItemRelationship> productOrderItemRelationship = null;

  @JsonProperty("qualification")
  @Valid
  private List<ProductOfferingQualificationRef> qualification = null;

  @JsonProperty("quoteItem")
  private QuoteItemRef quoteItem = null;

  @JsonProperty("state")
  private ProductOrderItemStateType state = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ProductOrderItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)
   * @return id
  **/
  @Schema(description = "Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Quantity ordered
   * @return quantity
  **/
  @Schema(description = "Quantity ordered")
  
    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductOrderItem action(OrderItemActionType action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
  **/
  @Schema(description = "")
      @NotNull

    @Valid
    public OrderItemActionType getAction() {
    return action;
  }

  public void setAction(OrderItemActionType action) {
    this.action = action;
  }

  public ProductOrderItem appointment(AppointmentRef appointment) {
    this.appointment = appointment;
    return this;
  }

  /**
   * Get appointment
   * @return appointment
  **/
  @Schema(description = "")
  
    @Valid
    public AppointmentRef getAppointment() {
    return appointment;
  }

  public void setAppointment(AppointmentRef appointment) {
    this.appointment = appointment;
  }

  public ProductOrderItem billingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  /**
   * Get billingAccount
   * @return billingAccount
  **/
  @Schema(description = "")
  
    @Valid
    public BillingAccountRef getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
  }

  public ProductOrderItem itemPrice(List<OrderPrice> itemPrice) {
    this.itemPrice = itemPrice;
    return this;
  }

  public ProductOrderItem addItemPriceItem(OrderPrice itemPriceItem) {
    if (this.itemPrice == null) {
      this.itemPrice = new ArrayList<>();
    }
    this.itemPrice.add(itemPriceItem);
    return this;
  }

  /**
   * Get itemPrice
   * @return itemPrice
  **/
  @Schema(description = "")
      @Valid
    public List<OrderPrice> getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(List<OrderPrice> itemPrice) {
    this.itemPrice = itemPrice;
  }

  public ProductOrderItem itemTerm(List<OrderTerm> itemTerm) {
    this.itemTerm = itemTerm;
    return this;
  }

  public ProductOrderItem addItemTermItem(OrderTerm itemTermItem) {
    if (this.itemTerm == null) {
      this.itemTerm = new ArrayList<>();
    }
    this.itemTerm.add(itemTermItem);
    return this;
  }

  /**
   * Get itemTerm
   * @return itemTerm
  **/
  @Schema(description = "")
      @Valid
    public List<OrderTerm> getItemTerm() {
    return itemTerm;
  }

  public void setItemTerm(List<OrderTerm> itemTerm) {
    this.itemTerm = itemTerm;
  }

  public ProductOrderItem itemTotalPrice(List<OrderPrice> itemTotalPrice) {
    this.itemTotalPrice = itemTotalPrice;
    return this;
  }

  public ProductOrderItem addItemTotalPriceItem(OrderPrice itemTotalPriceItem) {
    if (this.itemTotalPrice == null) {
      this.itemTotalPrice = new ArrayList<>();
    }
    this.itemTotalPrice.add(itemTotalPriceItem);
    return this;
  }

  /**
   * Get itemTotalPrice
   * @return itemTotalPrice
  **/
  @Schema(description = "")
      @Valid
    public List<OrderPrice> getItemTotalPrice() {
    return itemTotalPrice;
  }

  public void setItemTotalPrice(List<OrderPrice> itemTotalPrice) {
    this.itemTotalPrice = itemTotalPrice;
  }

  public ProductOrderItem payment(List<PaymentRef> payment) {
    this.payment = payment;
    return this;
  }

  public ProductOrderItem addPaymentItem(PaymentRef paymentItem) {
    if (this.payment == null) {
      this.payment = new ArrayList<>();
    }
    this.payment.add(paymentItem);
    return this;
  }

  /**
   * Get payment
   * @return payment
  **/
  @Schema(description = "")
      @Valid
    public List<PaymentRef> getPayment() {
    return payment;
  }

  public void setPayment(List<PaymentRef> payment) {
    this.payment = payment;
  }

  public ProductOrderItem product(ProductRefOrValue product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
  **/
  @Schema(description = "")
  
    @Valid
    public ProductRefOrValue getProduct() {
    return product;
  }

  public void setProduct(ProductRefOrValue product) {
    this.product = product;
  }

  public ProductOrderItem productOffering(ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  /**
   * Get productOffering
   * @return productOffering
  **/
  @Schema(description = "")
  
    @Valid
    public ProductOfferingRef getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
  }

  public ProductOrderItem productOfferingQualificationItem(ProductOfferingQualificationItemRef productOfferingQualificationItem) {
    this.productOfferingQualificationItem = productOfferingQualificationItem;
    return this;
  }

  /**
   * Get productOfferingQualificationItem
   * @return productOfferingQualificationItem
  **/
  @Schema(description = "")
  
    @Valid
    public ProductOfferingQualificationItemRef getProductOfferingQualificationItem() {
    return productOfferingQualificationItem;
  }

  public void setProductOfferingQualificationItem(ProductOfferingQualificationItemRef productOfferingQualificationItem) {
    this.productOfferingQualificationItem = productOfferingQualificationItem;
  }

  public ProductOrderItem productOrderItem(List<ProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
    return this;
  }

  public ProductOrderItem addProductOrderItemItem(ProductOrderItem productOrderItemItem) {
    if (this.productOrderItem == null) {
      this.productOrderItem = new ArrayList<>();
    }
    this.productOrderItem.add(productOrderItemItem);
    return this;
  }

  /**
   * Get productOrderItem
   * @return productOrderItem
  **/
  @Schema(description = "")
      @Valid
    public List<ProductOrderItem> getProductOrderItem() {
    return productOrderItem;
  }

  public void setProductOrderItem(List<ProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
  }

  public ProductOrderItem productOrderItemRelationship(List<OrderItemRelationship> productOrderItemRelationship) {
    this.productOrderItemRelationship = productOrderItemRelationship;
    return this;
  }

  public ProductOrderItem addProductOrderItemRelationshipItem(OrderItemRelationship productOrderItemRelationshipItem) {
    if (this.productOrderItemRelationship == null) {
      this.productOrderItemRelationship = new ArrayList<>();
    }
    this.productOrderItemRelationship.add(productOrderItemRelationshipItem);
    return this;
  }

  /**
   * Get productOrderItemRelationship
   * @return productOrderItemRelationship
  **/
  @Schema(description = "")
      @Valid
    public List<OrderItemRelationship> getProductOrderItemRelationship() {
    return productOrderItemRelationship;
  }

  public void setProductOrderItemRelationship(List<OrderItemRelationship> productOrderItemRelationship) {
    this.productOrderItemRelationship = productOrderItemRelationship;
  }

  public ProductOrderItem qualification(List<ProductOfferingQualificationRef> qualification) {
    this.qualification = qualification;
    return this;
  }

  public ProductOrderItem addQualificationItem(ProductOfferingQualificationRef qualificationItem) {
    if (this.qualification == null) {
      this.qualification = new ArrayList<>();
    }
    this.qualification.add(qualificationItem);
    return this;
  }

  /**
   * Get qualification
   * @return qualification
  **/
  @Schema(description = "")
      @Valid
    public List<ProductOfferingQualificationRef> getQualification() {
    return qualification;
  }

  public void setQualification(List<ProductOfferingQualificationRef> qualification) {
    this.qualification = qualification;
  }

  public ProductOrderItem quoteItem(QuoteItemRef quoteItem) {
    this.quoteItem = quoteItem;
    return this;
  }

  /**
   * Get quoteItem
   * @return quoteItem
  **/
  @Schema(description = "")
  
    @Valid
    public QuoteItemRef getQuoteItem() {
    return quoteItem;
  }

  public void setQuoteItem(QuoteItemRef quoteItem) {
    this.quoteItem = quoteItem;
  }

  public ProductOrderItem state(ProductOrderItemStateType state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @Schema(description = "")
  
    @Valid
    public ProductOrderItemStateType getState() {
    return state;
  }

  public void setState(ProductOrderItemStateType state) {
    this.state = state;
  }

  public ProductOrderItem baseType(String baseType) {
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

  public ProductOrderItem schemaLocation(String schemaLocation) {
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

  public ProductOrderItem type(String type) {
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
    ProductOrderItem productOrderItem = (ProductOrderItem) o;
    return Objects.equals(this.id, productOrderItem.id) &&
        Objects.equals(this.quantity, productOrderItem.quantity) &&
        Objects.equals(this.action, productOrderItem.action) &&
        Objects.equals(this.appointment, productOrderItem.appointment) &&
        Objects.equals(this.billingAccount, productOrderItem.billingAccount) &&
        Objects.equals(this.itemPrice, productOrderItem.itemPrice) &&
        Objects.equals(this.itemTerm, productOrderItem.itemTerm) &&
        Objects.equals(this.itemTotalPrice, productOrderItem.itemTotalPrice) &&
        Objects.equals(this.payment, productOrderItem.payment) &&
        Objects.equals(this.product, productOrderItem.product) &&
        Objects.equals(this.productOffering, productOrderItem.productOffering) &&
        Objects.equals(this.productOfferingQualificationItem, productOrderItem.productOfferingQualificationItem) &&
        Objects.equals(this.productOrderItem, productOrderItem.productOrderItem) &&
        Objects.equals(this.productOrderItemRelationship, productOrderItem.productOrderItemRelationship) &&
        Objects.equals(this.qualification, productOrderItem.qualification) &&
        Objects.equals(this.quoteItem, productOrderItem.quoteItem) &&
        Objects.equals(this.state, productOrderItem.state) &&
        Objects.equals(this.baseType, productOrderItem.baseType) &&
        Objects.equals(this.schemaLocation, productOrderItem.schemaLocation) &&
        Objects.equals(this.type, productOrderItem.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, action, appointment, billingAccount, itemPrice, itemTerm, itemTotalPrice, payment, product, productOffering, productOfferingQualificationItem, productOrderItem, productOrderItemRelationship, qualification, quoteItem, state, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOrderItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    appointment: ").append(toIndentedString(appointment)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    itemPrice: ").append(toIndentedString(itemPrice)).append("\n");
    sb.append("    itemTerm: ").append(toIndentedString(itemTerm)).append("\n");
    sb.append("    itemTotalPrice: ").append(toIndentedString(itemTotalPrice)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    productOfferingQualificationItem: ").append(toIndentedString(productOfferingQualificationItem)).append("\n");
    sb.append("    productOrderItem: ").append(toIndentedString(productOrderItem)).append("\n");
    sb.append("    productOrderItemRelationship: ").append(toIndentedString(productOrderItemRelationship)).append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("    quoteItem: ").append(toIndentedString(quoteItem)).append("\n");
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
