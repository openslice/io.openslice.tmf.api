package io.openslice.tmf.so641.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Skipped properties:
 * id,href,externalId,priority,state,orderDate,completionDate,orderItem
 */
@ApiModel(description = " Skipped properties: id,href,externalId,priority,state,orderDate,completionDate,orderItem")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class ServiceOrderUpdate {
	@JsonProperty("category")
	private String category = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("notificationContact")
	private String notificationContact = null;

	private OffsetDateTime expectedCompletionDate = null;

	private OffsetDateTime requestedCompletionDate = null;

	private OffsetDateTime requestedStartDate = null;

	private OffsetDateTime startDate = null;

	@JsonProperty("note")
	@Valid
	private List<Note> note = null;

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

	public ServiceOrderUpdate category(String category) {
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

	public ServiceOrderUpdate description(String description) {
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

	public ServiceOrderUpdate expectedCompletionDate(OffsetDateTime expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
		return this;
	}

	@JsonProperty("expectedCompletionDate")
	public String getExpectedCompletionDateStr() {
		return expectedCompletionDate.toString();
	}

	/**
	 * Expected delivery date amended by the provider
	 * 
	 * @return expectedCompletionDate
	 **/
	@ApiModelProperty(value = "Expected delivery date amended by the provider")

	@Valid

	public OffsetDateTime getExpectedCompletionDate() {
		return expectedCompletionDate;
	}

	public void setExpectedCompletionDate(OffsetDateTime expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}

	public void setExpectedCompletionDate(String expectedCompletionDate) {

		if (expectedCompletionDate != null) {
			this.expectedCompletionDate = OffsetDateTime.parse(expectedCompletionDate);

		}
	}

	public ServiceOrderUpdate notificationContact(String notificationContact) {
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

	public ServiceOrderUpdate requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
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
		if (requestedCompletionDate != null) {
			return requestedCompletionDate.toString();
		}

		return null;
	}

	public void setRequestedCompletionDate(OffsetDateTime requestedCompletionDate) {
		this.requestedCompletionDate = requestedCompletionDate;
	}

	public ServiceOrderUpdate requestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
		return this;
	}

	public void setRequestedCompletionDate(String requestedCompletionDate) {

		if (requestedCompletionDate != null) {
			this.requestedCompletionDate = OffsetDateTime.parse(requestedCompletionDate);

		}
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

		if (requestedStartDate != null) {
			return requestedStartDate.toString();
		}

		return null;
	}

	public void setRequestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	public void setRequestedStartDate(String requestedStartDate) {

		if (requestedStartDate != null) {
			this.requestedStartDate = OffsetDateTime.parse(requestedStartDate);

		}
	}

	public ServiceOrderUpdate startDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}

	/**
	 * Date when the order was started for processing
	 * 
	 * @return startDate
	 **/
	@ApiModelProperty(value = "Date when the order was started for processing")

	@Valid

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public String getStartDateStr() {

		if (startDate != null) {
			return startDate.toString();
		}
		
		return null;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(String startDate) {
		if (startDate != null) {
			this.startDate = OffsetDateTime.parse(startDate);

		}
	}

	public ServiceOrderUpdate note(List<Note> note) {
		this.note = note;
		return this;
	}

	public ServiceOrderUpdate addNoteItem(Note noteItem) {
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

	public ServiceOrderUpdate orderRelationship(List<ServiceOrderRelationship> orderRelationship) {
		this.orderRelationship = orderRelationship;
		return this;
	}

	public ServiceOrderUpdate addOrderRelationshipItem(ServiceOrderRelationship orderRelationshipItem) {
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

	public ServiceOrderUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceOrderUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

	public ServiceOrderUpdate baseType(String baseType) {
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

	public ServiceOrderUpdate schemaLocation(String schemaLocation) {
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

	public ServiceOrderUpdate type(String type) {
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
		ServiceOrderUpdate serviceOrderUpdate = (ServiceOrderUpdate) o;
		return Objects.equals(this.category, serviceOrderUpdate.category)
				&& Objects.equals(this.description, serviceOrderUpdate.description)
				&& Objects.equals(this.expectedCompletionDate, serviceOrderUpdate.expectedCompletionDate)
				&& Objects.equals(this.notificationContact, serviceOrderUpdate.notificationContact)
				&& Objects.equals(this.requestedCompletionDate, serviceOrderUpdate.requestedCompletionDate)
				&& Objects.equals(this.requestedStartDate, serviceOrderUpdate.requestedStartDate)
				&& Objects.equals(this.startDate, serviceOrderUpdate.startDate)
				&& Objects.equals(this.note, serviceOrderUpdate.note)
				&& Objects.equals(this.orderRelationship, serviceOrderUpdate.orderRelationship)
				&& Objects.equals(this.relatedParty, serviceOrderUpdate.relatedParty)
				&& Objects.equals(this.baseType, serviceOrderUpdate.baseType)
				&& Objects.equals(this.schemaLocation, serviceOrderUpdate.schemaLocation)
				&& Objects.equals(this.type, serviceOrderUpdate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, expectedCompletionDate, notificationContact, requestedCompletionDate,
				requestedStartDate, startDate, note, orderRelationship, relatedParty, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceOrderUpdate {\n");

		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    expectedCompletionDate: ").append(toIndentedString(expectedCompletionDate)).append("\n");
		sb.append("    notificationContact: ").append(toIndentedString(notificationContact)).append("\n");
		sb.append("    requestedCompletionDate: ").append(toIndentedString(requestedCompletionDate)).append("\n");
		sb.append("    requestedStartDate: ").append(toIndentedString(requestedStartDate)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
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
