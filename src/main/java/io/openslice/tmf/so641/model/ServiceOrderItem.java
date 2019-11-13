/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.so641.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceOrderItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "ServiceOrderItem")
public class ServiceOrderItem extends BaseRootEntity {

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("action")
	private ServiceOrderActionType action = ServiceOrderActionType.ADD;


	@JsonProperty("orderItemRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceOrderItemRelationship> orderItemRelationship = new HashSet<>();


	@JsonProperty("state")
	private ServiceOrderStateType state = ServiceOrderStateType.INITIAL;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_restrictuuid", referencedColumnName = "uuid")
	@JsonProperty("service")
	private ServiceRestriction service = null;

	/**
	 * not managed for now
	 */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_refid", referencedColumnName = "uuid")
	@JsonProperty("appointment")
	private AppointmentRef appointment = null;
	
	

	/**
	 * Identifier of the individual line item
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "Identifier of the individual line item")
	public String getId() {
		return uuid;
	}

	

	public ServiceOrderItem action(ServiceOrderActionType action) {
		this.action = action;
		return this;
	}

	/**
	 * The action to be carried out on the Service. Can be: add, modify, delete,
	 * noChange
	 * 
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
	 * 
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

	public ServiceOrderItem orderItemRelationship(Set<ServiceOrderItemRelationship> orderItemRelationship) {
		this.orderItemRelationship = orderItemRelationship;
		return this;
	}

	public ServiceOrderItem addOrderItemRelationshipItem(ServiceOrderItemRelationship orderItemRelationshipItem) {
		if (this.orderItemRelationship == null) {
			this.orderItemRelationship = new HashSet<>();
		}
		this.orderItemRelationship.add(orderItemRelationshipItem);
		return this;
	}

	/**
	 * A list of order items related to this order item
	 * 
	 * @return orderItemRelationship
	 **/
	@ApiModelProperty(value = "A list of order items related to this order item")

	@Valid

	public Set<ServiceOrderItemRelationship> getOrderItemRelationship() {
		return orderItemRelationship;
	}

	public void setOrderItemRelationship(Set<ServiceOrderItemRelationship> orderItemRelationship) {
		this.orderItemRelationship = orderItemRelationship;
	}

	public ServiceOrderItem service(ServiceRestriction service) {
		this.service = service;
		return this;
	}

	/**
	 * The Service to be acted on by the order item
	 * 
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
	 * State of the order item: described in the state machine diagram. This is the
	 * requested state.
	 * 
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


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceOrderItem serviceOrderItem = (ServiceOrderItem) o;
		return Objects.equals(this.getId(), serviceOrderItem.getId()) && Objects.equals(this.action, serviceOrderItem.action)
				&& Objects.equals(this.appointment, serviceOrderItem.appointment)
				&& Objects.equals(this.orderItemRelationship, serviceOrderItem.orderItemRelationship)
				&& Objects.equals(this.service, serviceOrderItem.service)
				&& Objects.equals(this.state, serviceOrderItem.state)
				&& Objects.equals(this.baseType, serviceOrderItem.baseType)
				&& Objects.equals(this.schemaLocation, serviceOrderItem.schemaLocation)
				&& Objects.equals(this.type, serviceOrderItem.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, getId(), action, appointment, orderItemRelationship, service, state, baseType, schemaLocation,
//				type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceOrderItem {\n");

		sb.append("    id: ").append(toIndentedString(getId())).append("\n");
		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
