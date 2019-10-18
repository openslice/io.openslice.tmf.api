package io.openslice.tmf.so641.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.so641.model.AppointmentRef;
import io.openslice.tmf.so641.model.ServiceOrderActionType;
import io.openslice.tmf.so641.model.ServiceOrderItemRelationship;
import io.openslice.tmf.so641.model.ServiceOrderStateType;
import io.openslice.tmf.so641.model.ServiceRestriction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServiceOrderItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class ServiceOrderItem   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("action")
  private ServiceOrderActionType action = null;

  @JsonProperty("appointment")
  private AppointmentRef appointment = null;

  @JsonProperty("orderItemRelationship")
  @Valid
  private List<ServiceOrderItemRelationship> orderItemRelationship = null;

  @JsonProperty("service")
  private ServiceRestriction service = null;

  @JsonProperty("state")
  private ServiceOrderStateType state = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ServiceOrderItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the individual line item
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Identifier of the individual line item")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceOrderItem action(ServiceOrderActionType action) {
    this.action = action;
    return this;
  }

  /**
   * The action to be carried out on the Service. Can be: add, modify, delete, noChange
   * @return action
  **/
  @ApiModelProperty(required = true, value = "The action to be carried out on the Service. Can be: add, modify, delete, noChange")
  @NotNull

  @Valid

  public ServiceOrderActionType getAction() {
    return action;
  }

  public void setAction(ServiceOrderActionType action) {
    this.action = action;
  }

  public ServiceOrderItem appointment(AppointmentRef appointment) {
    this.appointment = appointment;
    return this;
  }

  /**
   * An appointment that was set up with a related party for this order item
   * @return appointment
  **/
  @ApiModelProperty(value = "An appointment that was set up with a related party for this order item")

  @Valid

  public AppointmentRef getAppointment() {
    return appointment;
  }

  public void setAppointment(AppointmentRef appointment) {
    this.appointment = appointment;
  }

  public ServiceOrderItem orderItemRelationship(List<ServiceOrderItemRelationship> orderItemRelationship) {
    this.orderItemRelationship = orderItemRelationship;
    return this;
  }

  public ServiceOrderItem addOrderItemRelationshipItem(ServiceOrderItemRelationship orderItemRelationshipItem) {
    if (this.orderItemRelationship == null) {
      this.orderItemRelationship = new ArrayList<>();
    }
    this.orderItemRelationship.add(orderItemRelationshipItem);
    return this;
  }

  /**
   * A list of order items related to this order item
   * @return orderItemRelationship
  **/
  @ApiModelProperty(value = "A list of order items related to this order item")

  @Valid

  public List<ServiceOrderItemRelationship> getOrderItemRelationship() {
    return orderItemRelationship;
  }

  public void setOrderItemRelationship(List<ServiceOrderItemRelationship> orderItemRelationship) {
    this.orderItemRelationship = orderItemRelationship;
  }

  public ServiceOrderItem service(ServiceRestriction service) {
    this.service = service;
    return this;
  }

  /**
   * The Service to be acted on by the order item
   * @return service
  **/
  @ApiModelProperty(required = true, value = "The Service to be acted on by the order item")
  @NotNull

  @Valid

  public ServiceRestriction getService() {
    return service;
  }

  public void setService(ServiceRestriction service) {
    this.service = service;
  }

  public ServiceOrderItem state(ServiceOrderStateType state) {
    this.state = state;
    return this;
  }

  /**
   * State of the order item: described in the state machine diagram. This is the requested state.
   * @return state
  **/
  @ApiModelProperty(value = "State of the order item: described in the state machine diagram. This is the requested state.")

  @Valid

  public ServiceOrderStateType getState() {
    return state;
  }

  public void setState(ServiceOrderStateType state) {
    this.state = state;
  }

  public ServiceOrderItem baseType(String baseType) {
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

  public ServiceOrderItem schemaLocation(String schemaLocation) {
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

  public ServiceOrderItem type(String type) {
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
    ServiceOrderItem serviceOrderItem = (ServiceOrderItem) o;
    return Objects.equals(this.id, serviceOrderItem.id) &&
        Objects.equals(this.action, serviceOrderItem.action) &&
        Objects.equals(this.appointment, serviceOrderItem.appointment) &&
        Objects.equals(this.orderItemRelationship, serviceOrderItem.orderItemRelationship) &&
        Objects.equals(this.service, serviceOrderItem.service) &&
        Objects.equals(this.state, serviceOrderItem.state) &&
        Objects.equals(this.baseType, serviceOrderItem.baseType) &&
        Objects.equals(this.schemaLocation, serviceOrderItem.schemaLocation) &&
        Objects.equals(this.type, serviceOrderItem.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, action, appointment, orderItemRelationship, service, state, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    appointment: ").append(toIndentedString(appointment)).append("\n");
    sb.append("    orderItemRelationship: ").append(toIndentedString(orderItemRelationship)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
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

