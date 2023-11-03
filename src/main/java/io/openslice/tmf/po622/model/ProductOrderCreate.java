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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A Product Order is a type of order which  can  be used to place an order between a customer and a service provider or between a service provider and a partner and vice versa, Skipped properties: id,href,completionDate,orderDate,state,expectedCompletionDate,productOrderItem.state
 */
@Schema(description = "A Product Order is a type of order which  can  be used to place an order between a customer and a service provider or between a service provider and a partner and vice versa, Skipped properties: id,href,completionDate,orderDate,state,expectedCompletionDate,productOrderItem.state")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class ProductOrderCreate   {
  @JsonProperty("cancellationDate")
  private OffsetDateTime cancellationDate = null;

  @JsonProperty("cancellationReason")
  private String cancellationReason = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("externalId")
  private String externalId = null;

  @JsonProperty("notificationContact")
  private String notificationContact = null;

  @JsonProperty("priority")
  private String priority = null;

  @JsonProperty("requestedCompletionDate")
  private OffsetDateTime requestedCompletionDate = null;

  @JsonProperty("requestedStartDate")
  private OffsetDateTime requestedStartDate = null;

  @JsonProperty("agreement")
  @Valid
  private List<AgreementRef> agreement = null;

  @JsonProperty("billingAccount")
  private BillingAccountRef billingAccount = null;

  @JsonProperty("channel")
  @Valid
  private List<RelatedChannel> channel = null;

  @JsonProperty("note")
  @Valid
  private List<Note> note = null;

  @JsonProperty("orderTotalPrice")
  @Valid
  private List<OrderPrice> orderTotalPrice = null;

  @JsonProperty("payment")
  @Valid
  private List<PaymentRef> payment = null;

  @JsonProperty("productOfferingQualification")
  @Valid
  private List<ProductOfferingQualificationRef> productOfferingQualification = null;

  @JsonProperty("productOrderItem")
  @Valid
  private List<ProductOrderItem> productOrderItem = new ArrayList<>();

  @JsonProperty("quote")
  @Valid
  private List<QuoteRef> quote = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ProductOrderCreate cancellationDate(OffsetDateTime cancellationDate) {
    this.cancellationDate = cancellationDate;
    return this;
  }

  /**
   * Date when the order is cancelled. This is used when order is cancelled. 
   * @return cancellationDate
  **/
  @Schema(description = "Date when the order is cancelled. This is used when order is cancelled. ")
  
    @Valid
    public OffsetDateTime getCancellationDate() {
    return cancellationDate;
  }

  public void setCancellationDate(OffsetDateTime cancellationDate) {
    this.cancellationDate = cancellationDate;
  }

  public ProductOrderCreate cancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
    return this;
  }

  /**
   * Reason why the order is cancelled. This is used when order is cancelled. 
   * @return cancellationReason
  **/
  @Schema(description = "Reason why the order is cancelled. This is used when order is cancelled. ")
  
    public String getCancellationReason() {
    return cancellationReason;
  }

  public void setCancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public ProductOrderCreate category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Used to categorize the order from a business perspective that can be useful for the OM system (e.g. \"enterprise\", \"residential\", ...)
   * @return category
  **/
  @Schema(description = "Used to categorize the order from a business perspective that can be useful for the OM system (e.g. \"enterprise\", \"residential\", ...)")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ProductOrderCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the product order
   * @return description
  **/
  @Schema(description = "Description of the product order")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductOrderCreate externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * ID given by the consumer and only understandable by him (to facilitate his searches afterwards)
   * @return externalId
  **/
  @Schema(description = "ID given by the consumer and only understandable by him (to facilitate his searches afterwards)")
  
    public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public ProductOrderCreate notificationContact(String notificationContact) {
    this.notificationContact = notificationContact;
    return this;
  }

  /**
   * Contact attached to the order to send back information regarding this order
   * @return notificationContact
  **/
  @Schema(description = "Contact attached to the order to send back information regarding this order")
  
    public String getNotificationContact() {
    return notificationContact;
  }

  public void setNotificationContact(String notificationContact) {
    this.notificationContact = notificationContact;
  }

  public ProductOrderCreate priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)
   * @return priority
  **/
  @Schema(description = "A way that can be used by consumers to prioritize orders in OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)")
  
    public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public ProductOrderCreate requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
    this.requestedCompletionDate = requestedCompletionDate;
    return this;
  }

  /**
   * Requested delivery date from the requestor perspective
   * @return requestedCompletionDate
  **/
  @Schema(description = "Requested delivery date from the requestor perspective")
  
    @Valid
    public OffsetDateTime getRequestedCompletionDate() {
    return requestedCompletionDate;
  }

  public void setRequestedCompletionDate(OffsetDateTime requestedCompletionDate) {
    this.requestedCompletionDate = requestedCompletionDate;
  }

  public ProductOrderCreate requestedStartDate(OffsetDateTime requestedStartDate) {
    this.requestedStartDate = requestedStartDate;
    return this;
  }

  /**
   * Order fulfillment start date wished by the requestor. This is used when, for any reason, requestor cannot allow seller to begin to operationally begin the fulfillment before a date. 
   * @return requestedStartDate
  **/
  @Schema(description = "Order fulfillment start date wished by the requestor. This is used when, for any reason, requestor cannot allow seller to begin to operationally begin the fulfillment before a date. ")
  
    @Valid
    public OffsetDateTime getRequestedStartDate() {
    return requestedStartDate;
  }

  public void setRequestedStartDate(OffsetDateTime requestedStartDate) {
    this.requestedStartDate = requestedStartDate;
  }

  public ProductOrderCreate agreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
    return this;
  }

  public ProductOrderCreate addAgreementItem(AgreementRef agreementItem) {
    if (this.agreement == null) {
      this.agreement = new ArrayList<>();
    }
    this.agreement.add(agreementItem);
    return this;
  }

  /**
   * A reference to an agreement defined in the context of the product order
   * @return agreement
  **/
  @Schema(description = "A reference to an agreement defined in the context of the product order")
      @Valid
    public List<AgreementRef> getAgreement() {
    return agreement;
  }

  public void setAgreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
  }

  public ProductOrderCreate billingAccount(BillingAccountRef billingAccount) {
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

  public ProductOrderCreate channel(List<RelatedChannel> channel) {
    this.channel = channel;
    return this;
  }

  public ProductOrderCreate addChannelItem(RelatedChannel channelItem) {
    if (this.channel == null) {
      this.channel = new ArrayList<>();
    }
    this.channel.add(channelItem);
    return this;
  }

  /**
   * Get channel
   * @return channel
  **/
  @Schema(description = "")
      @Valid
    public List<RelatedChannel> getChannel() {
    return channel;
  }

  public void setChannel(List<RelatedChannel> channel) {
    this.channel = channel;
  }

  public ProductOrderCreate note(List<Note> note) {
    this.note = note;
    return this;
  }

  public ProductOrderCreate addNoteItem(Note noteItem) {
    if (this.note == null) {
      this.note = new ArrayList<>();
    }
    this.note.add(noteItem);
    return this;
  }

  /**
   * Get note
   * @return note
  **/
  @Schema(description = "")
      @Valid
    public List<Note> getNote() {
    return note;
  }

  public void setNote(List<Note> note) {
    this.note = note;
  }

  public ProductOrderCreate orderTotalPrice(List<OrderPrice> orderTotalPrice) {
    this.orderTotalPrice = orderTotalPrice;
    return this;
  }

  public ProductOrderCreate addOrderTotalPriceItem(OrderPrice orderTotalPriceItem) {
    if (this.orderTotalPrice == null) {
      this.orderTotalPrice = new ArrayList<>();
    }
    this.orderTotalPrice.add(orderTotalPriceItem);
    return this;
  }

  /**
   * Get orderTotalPrice
   * @return orderTotalPrice
  **/
  @Schema(description = "")
      @Valid
    public List<OrderPrice> getOrderTotalPrice() {
    return orderTotalPrice;
  }

  public void setOrderTotalPrice(List<OrderPrice> orderTotalPrice) {
    this.orderTotalPrice = orderTotalPrice;
  }

  public ProductOrderCreate payment(List<PaymentRef> payment) {
    this.payment = payment;
    return this;
  }

  public ProductOrderCreate addPaymentItem(PaymentRef paymentItem) {
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

  public ProductOrderCreate productOfferingQualification(List<ProductOfferingQualificationRef> productOfferingQualification) {
    this.productOfferingQualification = productOfferingQualification;
    return this;
  }

  public ProductOrderCreate addProductOfferingQualificationItem(ProductOfferingQualificationRef productOfferingQualificationItem) {
    if (this.productOfferingQualification == null) {
      this.productOfferingQualification = new ArrayList<>();
    }
    this.productOfferingQualification.add(productOfferingQualificationItem);
    return this;
  }

  /**
   * Get productOfferingQualification
   * @return productOfferingQualification
  **/
  @Schema(description = "")
      @Valid
    public List<ProductOfferingQualificationRef> getProductOfferingQualification() {
    return productOfferingQualification;
  }

  public void setProductOfferingQualification(List<ProductOfferingQualificationRef> productOfferingQualification) {
    this.productOfferingQualification = productOfferingQualification;
  }

  public ProductOrderCreate productOrderItem(List<ProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
    return this;
  }

  public ProductOrderCreate addProductOrderItemItem(ProductOrderItem productOrderItemItem) {
    this.productOrderItem.add(productOrderItemItem);
    return this;
  }

  /**
   * Get productOrderItem
   * @return productOrderItem
  **/
  @Schema(description = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<ProductOrderItem> getProductOrderItem() {
    return productOrderItem;
  }

  public void setProductOrderItem(List<ProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
  }

  public ProductOrderCreate quote(List<QuoteRef> quote) {
    this.quote = quote;
    return this;
  }

  public ProductOrderCreate addQuoteItem(QuoteRef quoteItem) {
    if (this.quote == null) {
      this.quote = new ArrayList<>();
    }
    this.quote.add(quoteItem);
    return this;
  }

  /**
   * Get quote
   * @return quote
  **/
  @Schema(description = "")
      @Valid
    public List<QuoteRef> getQuote() {
    return quote;
  }

  public void setQuote(List<QuoteRef> quote) {
    this.quote = quote;
  }

  public ProductOrderCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductOrderCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @Schema(description = "")
      @Valid
    public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ProductOrderCreate baseType(String baseType) {
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

  public ProductOrderCreate schemaLocation(String schemaLocation) {
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

  public ProductOrderCreate type(String type) {
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
    ProductOrderCreate productOrderCreate = (ProductOrderCreate) o;
    return Objects.equals(this.cancellationDate, productOrderCreate.cancellationDate) &&
        Objects.equals(this.cancellationReason, productOrderCreate.cancellationReason) &&
        Objects.equals(this.category, productOrderCreate.category) &&
        Objects.equals(this.description, productOrderCreate.description) &&
        Objects.equals(this.externalId, productOrderCreate.externalId) &&
        Objects.equals(this.notificationContact, productOrderCreate.notificationContact) &&
        Objects.equals(this.priority, productOrderCreate.priority) &&
        Objects.equals(this.requestedCompletionDate, productOrderCreate.requestedCompletionDate) &&
        Objects.equals(this.requestedStartDate, productOrderCreate.requestedStartDate) &&
        Objects.equals(this.agreement, productOrderCreate.agreement) &&
        Objects.equals(this.billingAccount, productOrderCreate.billingAccount) &&
        Objects.equals(this.channel, productOrderCreate.channel) &&
        Objects.equals(this.note, productOrderCreate.note) &&
        Objects.equals(this.orderTotalPrice, productOrderCreate.orderTotalPrice) &&
        Objects.equals(this.payment, productOrderCreate.payment) &&
        Objects.equals(this.productOfferingQualification, productOrderCreate.productOfferingQualification) &&
        Objects.equals(this.productOrderItem, productOrderCreate.productOrderItem) &&
        Objects.equals(this.quote, productOrderCreate.quote) &&
        Objects.equals(this.relatedParty, productOrderCreate.relatedParty) &&
        Objects.equals(this.baseType, productOrderCreate.baseType) &&
        Objects.equals(this.schemaLocation, productOrderCreate.schemaLocation) &&
        Objects.equals(this.type, productOrderCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancellationDate, cancellationReason, category, description, externalId, notificationContact, priority, requestedCompletionDate, requestedStartDate, agreement, billingAccount, channel, note, orderTotalPrice, payment, productOfferingQualification, productOrderItem, quote, relatedParty, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOrderCreate {\n");
    
    sb.append("    cancellationDate: ").append(toIndentedString(cancellationDate)).append("\n");
    sb.append("    cancellationReason: ").append(toIndentedString(cancellationReason)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    notificationContact: ").append(toIndentedString(notificationContact)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    requestedCompletionDate: ").append(toIndentedString(requestedCompletionDate)).append("\n");
    sb.append("    requestedStartDate: ").append(toIndentedString(requestedStartDate)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    orderTotalPrice: ").append(toIndentedString(orderTotalPrice)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    productOfferingQualification: ").append(toIndentedString(productOfferingQualification)).append("\n");
    sb.append("    productOrderItem: ").append(toIndentedString(productOrderItem)).append("\n");
    sb.append("    quote: ").append(toIndentedString(quote)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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
