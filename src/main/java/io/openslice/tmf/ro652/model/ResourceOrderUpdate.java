package io.openslice.tmf.ro652.model;

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

/**
 * A Resource Order is a request to provision a set of Resources (logical and physical) triggered by the request to provision a Service through a Service Order Skipped properties: id,href,completionDate,orderDate
 */
@Schema(description = "A Resource Order is a request to provision a set of Resources (logical and physical) triggered by the request to provision a Service through a Service Order Skipped properties: id,href,completionDate,orderDate")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class ResourceOrderUpdate   {
  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("expectedCompletionDate")
  private OffsetDateTime expectedCompletionDate = null;

  @JsonProperty("externalId")
  private String externalId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("orderType")
  private String orderType = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("requestedCompletionDate")
  private OffsetDateTime requestedCompletionDate = null;

  @JsonProperty("requestedStartDate")
  private OffsetDateTime requestedStartDate = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("externalReference")
  @Valid
  private List<ExternalId> externalReference = null;

  @JsonProperty("note")
  @Valid
  private List<Note> note = null;

  @JsonProperty("orderItem")
  @Valid
  private List<ResourceOrderItem> orderItem = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public ResourceOrderUpdate category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Used to categorize the order from a business perspective that can be useful for the OM system.
   * @return category
  **/
  @Schema(description = "Used to categorize the order from a business perspective that can be useful for the OM system.")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ResourceOrderUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * free-text description of the Resource Order
   * @return description
  **/
  @Schema(description = "free-text description of the Resource Order")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceOrderUpdate expectedCompletionDate(OffsetDateTime expectedCompletionDate) {
    this.expectedCompletionDate = expectedCompletionDate;
    return this;
  }

  /**
   * Date when the order was completed
   * @return expectedCompletionDate
  **/
  @Schema(description = "Date when the order was completed")
  
    @Valid
    public OffsetDateTime getExpectedCompletionDate() {
    return expectedCompletionDate;
  }

  public void setExpectedCompletionDate(OffsetDateTime expectedCompletionDate) {
    this.expectedCompletionDate = expectedCompletionDate;
  }

  public ResourceOrderUpdate externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * DEPRECATED: Use externalReference Instead. ID given by the consumer (to facilitate searches afterwards)
   * @return externalId
  **/
  @Schema(description = "DEPRECATED: Use externalReference Instead. ID given by the consumer (to facilitate searches afterwards)")
  
    public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public ResourceOrderUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A string used to give a name to the Resource Order
   * @return name
  **/
  @Schema(description = "A string used to give a name to the Resource Order")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceOrderUpdate orderType(String orderType) {
    this.orderType = orderType;
    return this;
  }

  /**
   * Name of the Resource Order type
   * @return orderType
  **/
  @Schema(description = "Name of the Resource Order type")
  
    public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public ResourceOrderUpdate priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)
   * @return priority
  **/
  @Schema(description = "A way that can be used by consumers to prioritize orders in OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)")
  
    public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public ResourceOrderUpdate requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
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

  public ResourceOrderUpdate requestedStartDate(OffsetDateTime requestedStartDate) {
    this.requestedStartDate = requestedStartDate;
    return this;
  }

  /**
   * Order start date wished by the requestor
   * @return requestedStartDate
  **/
  @Schema(description = "Order start date wished by the requestor")
  
    @Valid
    public OffsetDateTime getRequestedStartDate() {
    return requestedStartDate;
  }

  public void setRequestedStartDate(OffsetDateTime requestedStartDate) {
    this.requestedStartDate = requestedStartDate;
  }

  public ResourceOrderUpdate startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Date when the order was actually started
   * @return startDate
  **/
  @Schema(description = "Date when the order was actually started")
  
    @Valid
    public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public ResourceOrderUpdate state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The life cycle state of the resource.
   * @return state
  **/
  @Schema(description = "The life cycle state of the resource.")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ResourceOrderUpdate externalReference(List<ExternalId> externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  public ResourceOrderUpdate addExternalReferenceItem(ExternalId externalReferenceItem) {
    if (this.externalReference == null) {
      this.externalReference = new ArrayList<>();
    }
    this.externalReference.add(externalReferenceItem);
    return this;
  }

  /**
   * Get externalReference
   * @return externalReference
  **/
  @Schema(description = "")
      @Valid
    public List<ExternalId> getExternalReference() {
    return externalReference;
  }

  public void setExternalReference(List<ExternalId> externalReference) {
    this.externalReference = externalReference;
  }

  public ResourceOrderUpdate note(List<Note> note) {
    this.note = note;
    return this;
  }

  public ResourceOrderUpdate addNoteItem(Note noteItem) {
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

  public ResourceOrderUpdate orderItem(List<ResourceOrderItem> orderItem) {
    this.orderItem = orderItem;
    return this;
  }

  public ResourceOrderUpdate addOrderItemItem(ResourceOrderItem orderItemItem) {
    if (this.orderItem == null) {
      this.orderItem = new ArrayList<>();
    }
    this.orderItem.add(orderItemItem);
    return this;
  }

  /**
   * Get orderItem
   * @return orderItem
  **/
  @Schema(description = "")
      @Valid
    public List<ResourceOrderItem> getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(List<ResourceOrderItem> orderItem) {
    this.orderItem = orderItem;
  }

  public ResourceOrderUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceOrderUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public ResourceOrderUpdate _atBaseType(String _atBaseType) {
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

  public ResourceOrderUpdate _atSchemaLocation(String _atSchemaLocation) {
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

  public ResourceOrderUpdate _atType(String _atType) {
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
    ResourceOrderUpdate resourceOrderUpdate = (ResourceOrderUpdate) o;
    return Objects.equals(this.category, resourceOrderUpdate.category) &&
        Objects.equals(this.description, resourceOrderUpdate.description) &&
        Objects.equals(this.expectedCompletionDate, resourceOrderUpdate.expectedCompletionDate) &&
        Objects.equals(this.externalId, resourceOrderUpdate.externalId) &&
        Objects.equals(this.name, resourceOrderUpdate.name) &&
        Objects.equals(this.orderType, resourceOrderUpdate.orderType) &&
        Objects.equals(this.priority, resourceOrderUpdate.priority) &&
        Objects.equals(this.requestedCompletionDate, resourceOrderUpdate.requestedCompletionDate) &&
        Objects.equals(this.requestedStartDate, resourceOrderUpdate.requestedStartDate) &&
        Objects.equals(this.startDate, resourceOrderUpdate.startDate) &&
        Objects.equals(this.state, resourceOrderUpdate.state) &&
        Objects.equals(this.externalReference, resourceOrderUpdate.externalReference) &&
        Objects.equals(this.note, resourceOrderUpdate.note) &&
        Objects.equals(this.orderItem, resourceOrderUpdate.orderItem) &&
        Objects.equals(this.relatedParty, resourceOrderUpdate.relatedParty) &&
        Objects.equals(this._atBaseType, resourceOrderUpdate._atBaseType) &&
        Objects.equals(this._atSchemaLocation, resourceOrderUpdate._atSchemaLocation) &&
        Objects.equals(this._atType, resourceOrderUpdate._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, expectedCompletionDate, externalId, name, orderType, priority, requestedCompletionDate, requestedStartDate, startDate, state, externalReference, note, orderItem, relatedParty, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceOrderUpdate {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    expectedCompletionDate: ").append(toIndentedString(expectedCompletionDate)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orderType: ").append(toIndentedString(orderType)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    requestedCompletionDate: ").append(toIndentedString(requestedCompletionDate)).append("\n");
    sb.append("    requestedStartDate: ").append(toIndentedString(requestedStartDate)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    orderItem: ").append(toIndentedString(orderItem)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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
