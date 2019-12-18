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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceOrder
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "ServiceOrder")
@JsonIgnoreProperties("orderRequester")
public class ServiceOrder extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("category")
	private String category = null;


	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;


	@JsonProperty("externalId")
	private String externalId = null;

	@JsonProperty("notificationContact")
	private String notificationContact = null;

	private OffsetDateTime orderDate = null;

	@JsonProperty("priority")
	private String priority = null;

	private OffsetDateTime completionDate = null;
	
	private OffsetDateTime expectedCompletionDate = null;
	
	private OffsetDateTime requestedCompletionDate = null;

	private OffsetDateTime requestedStartDate = null;

	private OffsetDateTime startDate = null;

	@JsonProperty("note")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Note> note =  new HashSet<>();

	@JsonProperty("orderItem")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceOrderItem> orderItem =  new HashSet<>();

	@JsonProperty("orderRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceOrderRelationship> orderRelationship =  new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty =  new HashSet<>();

	@JsonProperty("state")
	private ServiceOrderStateType state = ServiceOrderStateType.INITIAL;

	public ServiceOrder () {
		super();
		this.baseType = "BaseRootEntity";
		this.type = "ServiceOrder";
	}

	/**
	 * ID created on repository side
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "ID created on repository side")

	public String getId() {
		return uuid;
	}


	/**
	 * Used to categorize the order, useful for the OM system, such as: Broadband,
	 * TVOption
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "Used to categorize the order, useful for the OM system, such as: Broadband, TVOption")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ServiceOrder completionDate(OffsetDateTime completionDate) {
		this.completionDate = completionDate;
		return this;
	}

	/**
	 * Effective delivery date amended by the provider
	 * 
	 * @return completionDate
	 **/
	@ApiModelProperty(value = "Effective delivery date amended by the provider")

	@Valid
	@JsonProperty("completionDate")
	public String getCompletionDateString() {
		if ( this.completionDate == null) {
			return null;
		}
		return this.completionDate.toString();
	}
	
	public OffsetDateTime getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(OffsetDateTime completionDate) {
		this.completionDate = completionDate;
	}

	public ServiceOrder description(String description) {
		this.description = description;
		return this;
	}
	
	public void setCompletionDate(String completionDate) {
		if (completionDate!=null) {
			this.completionDate = OffsetDateTime.parse( completionDate );			
		}
	}


	/**
	 * A free-text description of the service order
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A free-text description of the service order")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceOrder expectedCompletionDate(OffsetDateTime expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
		return this;
	}

	/**
	 * Expected delivery date amended by the provider
	 * 
	 * @return expectedCompletionDate
	 **/
	@ApiModelProperty(value = "Expected delivery date amended by the provider")

	@Valid

	@JsonProperty("expectedCompletionDate")
	public String getExpectedCompletionDateString() {

		if ( this.expectedCompletionDate == null) {
			return null;
		}
		return this.expectedCompletionDate.toString();
	}
	
	public OffsetDateTime getExpectedCompletionDate() {
		return expectedCompletionDate;
	}

	public void setExpectedCompletionDate(OffsetDateTime expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}
	
	public void setExpectedCompletionDate(String expectedCompletionDate) {
		if (expectedCompletionDate!=null) {
			this.expectedCompletionDate = OffsetDateTime.parse( expectedCompletionDate );
			
		}
	}
	

	public ServiceOrder externalId(String externalId) {
		this.externalId = externalId;
		return this;
	}
	
	

	/**
	 * ID given by the consumer to facilitate searches
	 * 
	 * @return externalId
	 **/
	@ApiModelProperty(value = "ID given by the consumer to facilitate searches")

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public ServiceOrder notificationContact(String notificationContact) {
		this.notificationContact = notificationContact;
		return this;
	}

	/**
	 * Contact attached to the order to send back information regarding this order
	 * 
	 * @return notificationContact
	 **/
	@ApiModelProperty(value = "Contact attached to the order to send back information regarding this order")

	public String getNotificationContact() {
		return notificationContact;
	}

	public void setNotificationContact(String notificationContact) {
		this.notificationContact = notificationContact;
	}

	public ServiceOrder orderDate(OffsetDateTime orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	/**
	 * Get orderDate
	 * 
	 * @return orderDate
	 **/
	@ApiModelProperty(value = "")

	@Valid
	@JsonProperty("orderDate")
	public String getOrderDateString() {
		if ( this.orderDate == null) {
			return null;
		}
		return this.orderDate.toString();
	}
	
	public OffsetDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(OffsetDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public ServiceOrder priority(String priority) {
		this.priority = priority;
		return this;
	}
	
	public void setOrderDate(String orderDate) {

		if (orderDate!=null) {
			this.orderDate = OffsetDateTime.parse( orderDate );
			
		}
	}

	/**
	 * Can be used by consumers to prioritize orders in a Service Order Management
	 * system
	 * 
	 * @return priority
	 **/
	@ApiModelProperty(value = "Can be used by consumers to prioritize orders in a Service Order Management system")

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public ServiceOrder requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
		this.requestedCompletionDate = requestedCompletionDate;
		return this;
	}

	/**
	 * Requested delivery date from the requestors perspective
	 * 
	 * @return requestedCompletionDate
	 **/
	@ApiModelProperty(value = "Requested delivery date from the requestors perspective")

	@Valid

	@JsonProperty("requestedCompletionDate")
	public String getRequestedCompletionDateString() {

		if ( this.requestedCompletionDate == null) {
			return null;
		}
		return this.requestedCompletionDate.toString();
	}
	
	public OffsetDateTime getRequestedCompletionDate() {
		return requestedCompletionDate;
	}

	public void setRequestedCompletionDate(OffsetDateTime requestedCompletionDate) {
		this.requestedCompletionDate = requestedCompletionDate;
	}

	public ServiceOrder requestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
		return this;
	}
	
	public void setRequestedCompletionDate(String requestedCompletionDate) {

		if (requestedCompletionDate!=null) {
			this.requestedCompletionDate = OffsetDateTime.parse( requestedCompletionDate );
			
		}
	}

	/**
	 * Order start date wished by the requestor
	 * 
	 * @return requestedStartDate
	 **/
	@ApiModelProperty(value = "Order start date wished by the requestor")

	@Valid
	@JsonProperty("requestedStartDate")
	public String getRequestedStartDateString() {

		if ( this.requestedStartDate == null) {
			return null;
		}
		return this.requestedStartDate.toString();
	}
	
	public OffsetDateTime getRequestedStartDate() {
		return requestedStartDate;
	}

	public void setRequestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	public ServiceOrder startDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}
	
	public void setRequestedStartDate(String requestedStartDate) {

		if (requestedStartDate!=null) {
			this.requestedStartDate = OffsetDateTime.parse( requestedStartDate );
			
		}
	}

	/**
	 * Date when the order was started for processing
	 * 
	 * @return startDate
	 **/
	@ApiModelProperty(value = "Date when the order was started for processing")

	@Valid
	@JsonProperty("startDate")
	public String getStartDateString() {
		if ( this.startDate == null) {
			return null;
		}
		return this.startDate.toString();
	}
	
	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}
	
	public void setStartDate(String d) {
		if (startDate!=null) {
			this.startDate = OffsetDateTime.parse( d );			
		}
	}


	public ServiceOrder note(Set<Note> note) {
		this.note = note;
		return this;
	}

	public ServiceOrder addNoteItem(Note noteItem) {
		if (this.note == null) {
			this.note = new HashSet<>();
		}
		this.note.add(noteItem);
		return this;
	}

	/**
	 * Extra-information about the order; e.g. useful to add extra delivery
	 * information that could be useful for a human process
	 * 
	 * @return note
	 **/
	@ApiModelProperty(value = "Extra-information about the order; e.g. useful to add extra delivery information that could be useful for a human process")

	@Valid

	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	public ServiceOrder orderItem(Set<ServiceOrderItem> orderItem) {
		this.orderItem = orderItem;
		return this;
	}

	public ServiceOrder addOrderItemItem(ServiceOrderItem orderItemItem) {
		this.orderItem.add(orderItemItem);
		return this;
	}

	/**
	 * A list of service order items to be processed by this order
	 * 
	 * @return orderItem
	 **/
	@ApiModelProperty(required = true, value = "A list of service order items to be processed by this order")
	@NotNull

	@Valid
	@Size(min = 1)
	public Set<ServiceOrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<ServiceOrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public ServiceOrder orderRelationship(Set<ServiceOrderRelationship> orderRelationship) {
		this.orderRelationship = orderRelationship;
		return this;
	}

	public ServiceOrder addOrderRelationshipItem(ServiceOrderRelationship orderRelationshipItem) {
		if (this.orderRelationship == null) {
			this.orderRelationship = new HashSet<>();
		}
		this.orderRelationship.add(orderRelationshipItem);
		return this;
	}

	/**
	 * A list of service orders related to this order (e.g. prerequisite, dependent
	 * on)
	 * 
	 * @return orderRelationship
	 **/
	@ApiModelProperty(value = "A list of service orders related to this order (e.g. prerequisite, dependent on)")

	@Valid

	public Set<ServiceOrderRelationship> getOrderRelationship() {
		return orderRelationship;
	}

	public void setOrderRelationship(Set<ServiceOrderRelationship> orderRelationship) {
		this.orderRelationship = orderRelationship;
	}

	public ServiceOrder relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceOrder addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * A list of parties which are involved in this order and the role they are
	 * playing
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "A list of parties which are involved in this order and the role they are playing")

	@Valid

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceOrder state(ServiceOrderStateType state) {
		this.state = state;
		return this;
	}

	/**
	 * State of the order: described in the state-machine diagram
	 * 
	 * @return state
	 **/
	@ApiModelProperty(value = "State of the order: described in the state-machine diagram")

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
		ServiceOrder serviceOrder = (ServiceOrder) o;
		return Objects.equals(this.id, serviceOrder.id) && Objects.equals(this.href, serviceOrder.href)
				&& Objects.equals(this.category, serviceOrder.category)
				&& Objects.equals(this.completionDate, serviceOrder.completionDate)
				&& Objects.equals(this.description, serviceOrder.description)
				&& Objects.equals(this.expectedCompletionDate, serviceOrder.expectedCompletionDate)
				&& Objects.equals(this.externalId, serviceOrder.externalId)
				&& Objects.equals(this.notificationContact, serviceOrder.notificationContact)
				&& Objects.equals(this.orderDate, serviceOrder.orderDate)
				&& Objects.equals(this.priority, serviceOrder.priority)
				&& Objects.equals(this.requestedCompletionDate, serviceOrder.requestedCompletionDate)
				&& Objects.equals(this.requestedStartDate, serviceOrder.requestedStartDate)
				&& Objects.equals(this.startDate, serviceOrder.startDate)
				&& Objects.equals(this.note, serviceOrder.note)
				&& Objects.equals(this.orderItem, serviceOrder.orderItem)
				&& Objects.equals(this.orderRelationship, serviceOrder.orderRelationship)
				&& Objects.equals(this.relatedParty, serviceOrder.relatedParty)
				&& Objects.equals(this.state, serviceOrder.state)
				&& Objects.equals(this.baseType, serviceOrder.baseType)
				&& Objects.equals(this.schemaLocation, serviceOrder.schemaLocation)
				&& Objects.equals(this.type, serviceOrder.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, category, completionDate, description, expectedCompletionDate, externalId,
//				notificationContact, orderDate, priority, requestedCompletionDate, requestedStartDate, startDate, note,
//				orderItem, orderRelationship, relatedParty, state, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceOrder {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    expectedCompletionDate: ").append(toIndentedString(expectedCompletionDate)).append("\n");
		sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
		sb.append("    notificationContact: ").append(toIndentedString(notificationContact)).append("\n");
		sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
		sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
		sb.append("    requestedCompletionDate: ").append(toIndentedString(requestedCompletionDate)).append("\n");
		sb.append("    requestedStartDate: ").append(toIndentedString(requestedStartDate)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    orderItem: ").append(toIndentedString(orderItem)).append("\n");
		sb.append("    orderRelationship: ").append(toIndentedString(orderRelationship)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

	public ServiceOrderItem findOrderItemById(String id) {
		for (ServiceOrderItem oi : this.orderItem) {
			if ( oi.getId().equals(id)) {
				return oi;
			}			
		}
		return null;
	}
	
	/**
	 * @return the PartyRole that made the request
	 */
	public RelatedParty getOrderRequester() {
		for (RelatedParty rp : relatedParty) {
			if (rp.getRole().equals( UserPartRoleType.REQUESTER.toString() )) {
				return rp;
			}
		}
		return null;
	}
}
