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
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Skipped properties:
 * id,href,orderDate,completionDate,expectedCompletionDate,startDate,state
 */
@ApiModel(description = " Skipped properties: id,href,orderDate,completionDate,expectedCompletionDate,startDate,state")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class ServiceOrderCreate {
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

	private OffsetDateTime requestedCompletionDate = null;

	private OffsetDateTime requestedStartDate = null;

	@JsonProperty("note")
	@Valid
	private List<Note> note = null;

	@JsonProperty("orderItem")
	@Valid
	private List<ServiceOrderItem> orderItem = new ArrayList<>();

	@JsonProperty("orderRelationship")
	@Valid
	private List<ServiceOrderRelationship> orderRelationship = null;

	@JsonProperty("relatedParty")
	@Valid
	private List<RelatedParty> relatedParty = null;

	@JsonProperty("@baseType")
	private String baseType = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	@JsonProperty("@type")
	private String type = null;

	public ServiceOrderCreate category(String category) {
		this.category = category;
		return this;
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

	public ServiceOrderCreate description(String description) {
		this.description = description;
		return this;
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

	public ServiceOrderCreate externalId(String externalId) {
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

	public ServiceOrderCreate notificationContact(String notificationContact) {
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

	public ServiceOrderCreate priority(String priority) {
		this.priority = priority;
		return this;
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

	public ServiceOrderCreate requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
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
	public OffsetDateTime getRequestedCompletionDate() {
		return requestedCompletionDate;
	}


	@JsonProperty("requestedCompletionDate")
	public String getRequestedCompletionDateStr() {
		if ( requestedCompletionDate != null) {
			return requestedCompletionDate.toString();	
		} else {
			return null;
		}
	}
	
	
	public void setRequestedCompletionDate(OffsetDateTime requestedCompletionDate) {
		this.requestedCompletionDate = requestedCompletionDate;
	}


	
	public void setRequestedCompletionDate(String requestedCompletionDate) {

		if (requestedCompletionDate!=null) {
			this.requestedCompletionDate = OffsetDateTime.parse( requestedCompletionDate );
			
		}
	}
	
	public ServiceOrderCreate requestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
		return this;
	}

	/**
	 * Order start date wished by the requestor
	 * 
	 * @return requestedStartDate
	 **/
	@ApiModelProperty(value = "Order start date wished by the requestor")

	@Valid

	public OffsetDateTime getRequestedStartDate() {
		return requestedStartDate;
	}
	

	@JsonProperty("requestedStartDate")
	public String getRequestedStartDateStr() {

		if ( requestedStartDate != null) {
			return requestedStartDate.toString();	
		}
		
		return null;
	}
	

	public void setRequestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	public ServiceOrderCreate note(List<Note> note) {
		this.note = note;
		return this;
	}
	

	public void setRequestedStartDate(String requestedStartDate) {

		if (requestedStartDate!=null) {
			this.requestedStartDate = OffsetDateTime.parse( requestedStartDate );
			
		}
	}

	public ServiceOrderCreate addNoteItem(Note noteItem) {
		if (this.note == null) {
			this.note = new ArrayList<>();
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

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	public ServiceOrderCreate orderItem(List<ServiceOrderItem> orderItem) {
		this.orderItem = orderItem;
		return this;
	}

	public ServiceOrderCreate addOrderItemItem(ServiceOrderItem orderItemItem) {
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
	public List<ServiceOrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<ServiceOrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public ServiceOrderCreate orderRelationship(List<ServiceOrderRelationship> orderRelationship) {
		this.orderRelationship = orderRelationship;
		return this;
	}

	public ServiceOrderCreate addOrderRelationshipItem(ServiceOrderRelationship orderRelationshipItem) {
		if (this.orderRelationship == null) {
			this.orderRelationship = new ArrayList<>();
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

	public List<ServiceOrderRelationship> getOrderRelationship() {
		return orderRelationship;
	}

	public void setOrderRelationship(List<ServiceOrderRelationship> orderRelationship) {
		this.orderRelationship = orderRelationship;
	}

	public ServiceOrderCreate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceOrderCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
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

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceOrderCreate baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the super-class")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public ServiceOrderCreate schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ServiceOrderCreate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
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
		ServiceOrderCreate serviceOrderCreate = (ServiceOrderCreate) o;
		return Objects.equals(this.category, serviceOrderCreate.category)
				&& Objects.equals(this.description, serviceOrderCreate.description)
				&& Objects.equals(this.externalId, serviceOrderCreate.externalId)
				&& Objects.equals(this.notificationContact, serviceOrderCreate.notificationContact)
				&& Objects.equals(this.priority, serviceOrderCreate.priority)
				&& Objects.equals(this.requestedCompletionDate, serviceOrderCreate.requestedCompletionDate)
				&& Objects.equals(this.requestedStartDate, serviceOrderCreate.requestedStartDate)
				&& Objects.equals(this.note, serviceOrderCreate.note)
				&& Objects.equals(this.orderItem, serviceOrderCreate.orderItem)
				&& Objects.equals(this.orderRelationship, serviceOrderCreate.orderRelationship)
				&& Objects.equals(this.relatedParty, serviceOrderCreate.relatedParty)
				&& Objects.equals(this.baseType, serviceOrderCreate.baseType)
				&& Objects.equals(this.schemaLocation, serviceOrderCreate.schemaLocation)
				&& Objects.equals(this.type, serviceOrderCreate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, externalId, notificationContact, priority, requestedCompletionDate,
				requestedStartDate, note, orderItem, orderRelationship, relatedParty, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceOrderCreate {\n");

		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
		sb.append("    notificationContact: ").append(toIndentedString(notificationContact)).append("\n");
		sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
		sb.append("    requestedCompletionDate: ").append(toIndentedString(requestedCompletionDate)).append("\n");
		sb.append("    requestedStartDate: ").append(toIndentedString(requestedStartDate)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    orderItem: ").append(toIndentedString(orderItem)).append("\n");
		sb.append("    orderRelationship: ").append(toIndentedString(orderRelationship)).append("\n");
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
