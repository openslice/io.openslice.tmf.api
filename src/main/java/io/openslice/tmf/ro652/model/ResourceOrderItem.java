package io.openslice.tmf.ro652.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.ri639.model.ResourceRefOrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * An identified part of the order. A resource order is decomposed into one or more order items.
 */
@Schema(description = "An identified part of the order. A resource order is decomposed into one or more order items.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class ResourceOrderItem   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("action")
  private String action = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("state")
  private ResourceOrderStateType state = null;

  @JsonProperty("appointment")
  private AppointmentRef appointment = null;

  @JsonProperty("orderItemRelationship")
  @Valid
  private List<ResourceOrderItemRelationship> orderItemRelationship = null;

  @JsonProperty("resource")
  private ResourceRefOrValue resource = null;

  @JsonProperty("resourceSpecification")
  private ResourceSpecificationRef resourceSpecification = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public ResourceOrderItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)
   * @return id
  **/
  @Schema(description = "Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceOrderItem action(String action) {
    this.action = action;
    return this;
  }

  /**
   * Can be \"add\" / \"modify\" / \"no_change\"/ \"delete\"
   * @return action
  **/
  @Schema(description = "Can be \"add\" / \"modify\" / \"no_change\"/ \"delete\"")
  
    public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public ResourceOrderItem quantity(Integer quantity) {
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

  public ResourceOrderItem state(ResourceOrderStateType state) {
    this.state = state;
    return this;
  }

  /**
   * State of the order item : described in the state machine diagram
   * @return state
  **/
  @Schema(description = "State of the order item : described in the state machine diagram")
  
    public ResourceOrderStateType getState() {
    return state;
  }

  public void setState(ResourceOrderStateType state) {
    this.state = state;
  }

  public ResourceOrderItem appointment(AppointmentRef appointment) {
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

  public ResourceOrderItem orderItemRelationship(List<ResourceOrderItemRelationship> orderItemRelationship) {
    this.orderItemRelationship = orderItemRelationship;
    return this;
  }

  public ResourceOrderItem addOrderItemRelationshipItem(ResourceOrderItemRelationship orderItemRelationshipItem) {
    if (this.orderItemRelationship == null) {
      this.orderItemRelationship = new ArrayList<>();
    }
    this.orderItemRelationship.add(orderItemRelationshipItem);
    return this;
  }

  /**
   * Get orderItemRelationship
   * @return orderItemRelationship
  **/
  @Schema(description = "")
      @Valid
    public List<ResourceOrderItemRelationship> getOrderItemRelationship() {
    return orderItemRelationship;
  }

  public void setOrderItemRelationship(List<ResourceOrderItemRelationship> orderItemRelationship) {
    this.orderItemRelationship = orderItemRelationship;
  }

  public ResourceOrderItem resource( ResourceRefOrValue resource) {
    this.resource = resource;
    return this;
  }

  /**
   * Get resource
   * @return resource
  **/
  @Schema(description = "")
  
    @Valid
    public ResourceRefOrValue getResource() {
    return resource;
  }

  public void setResourceRefOrValue( ResourceRefOrValue resource) {
    this.resource = resource;
  }

  public ResourceOrderItem resourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  /**
   * Get resourceSpecification
   * @return resourceSpecification
  **/
  @Schema(description = "")
  
    @Valid
    public ResourceSpecificationRef getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ResourceOrderItem _atBaseType(String _atBaseType) {
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

  public ResourceOrderItem _atSchemaLocation(String _atSchemaLocation) {
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

  public ResourceOrderItem _atType(String _atType) {
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
    ResourceOrderItem resourceOrderItem = (ResourceOrderItem) o;
    return Objects.equals(this.id, resourceOrderItem.id) &&
        Objects.equals(this.action, resourceOrderItem.action) &&
        Objects.equals(this.quantity, resourceOrderItem.quantity) &&
        Objects.equals(this.state, resourceOrderItem.state) &&
        Objects.equals(this.appointment, resourceOrderItem.appointment) &&
        Objects.equals(this.orderItemRelationship, resourceOrderItem.orderItemRelationship) &&
        Objects.equals(this.resource, resourceOrderItem.resource) &&
        Objects.equals(this.resourceSpecification, resourceOrderItem.resourceSpecification) &&
        Objects.equals(this._atBaseType, resourceOrderItem._atBaseType) &&
        Objects.equals(this._atSchemaLocation, resourceOrderItem._atSchemaLocation) &&
        Objects.equals(this._atType, resourceOrderItem._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, action, quantity, state, appointment, orderItemRelationship, resource, resourceSpecification, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceOrderItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    appointment: ").append(toIndentedString(appointment)).append("\n");
    sb.append("    orderItemRelationship: ").append(toIndentedString(orderItemRelationship)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
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
