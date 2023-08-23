package io.openslice.tmf.ro652.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * A Resource Order is a request to provision a set of Resources (logical and
 * physical) triggered by the request to provision a Service through a Service
 * Order
 */
@Schema(description = "A Resource Order is a request to provision a set of Resources (logical and physical) triggered by the request to provision a Service through a Service Order")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class ResourceOrder {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("href")
	private String href = null;

	@JsonProperty("category")
	private String category = null;

	private OffsetDateTime completionDate = null;

	private OffsetDateTime expectedCompletionDate = null;

	private OffsetDateTime requestedCompletionDate = null;

	private OffsetDateTime requestedStartDate = null;

	private OffsetDateTime startDate = null;


	@JsonProperty("description")
	private String description = null;


	@JsonProperty("externalId")
	private String externalId = null;

	@JsonProperty("name")
	private String name = null;

	private OffsetDateTime orderDate = null;

	@JsonProperty("orderType")
	private String orderType = null;

	@JsonProperty("priority")
	private Integer priority = null;


	@JsonProperty("state")
	private String state = null;

	@JsonProperty("externalReference")
	@Valid
	private Set<ExternalId> externalReference = new HashSet<>();

	@JsonProperty("note")
	@Valid
	private Set<Note> note = new HashSet<>();

	@JsonProperty("orderItem")
	@Valid
	private Set<ResourceOrderItem> orderItem = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("@baseType")
	private String _atBaseType = null;

	@JsonProperty("@schemaLocation")
	private String _atSchemaLocation = null;

	@JsonProperty("@type")
	private String _atType = null;

	public ResourceOrder id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of an instance of the Resource Order. Required to be unique within
	 * the resource type. Used in URIs as the identifier for specific instances of a
	 * type.
	 * 
	 * @return id
	 **/
	@Schema(description = "Identifier of an instance of the Resource Order. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type.")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourceOrder href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink to access the order
	 * 
	 * @return href
	 **/
	@Schema(description = "Hyperlink to access the order")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ResourceOrder category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Used to categorize the order from a business perspective that can be useful
	 * for the OM system.
	 * 
	 * @return category
	 **/
	@Schema(description = "Used to categorize the order from a business perspective that can be useful for the OM system.")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ResourceOrder completionDate(OffsetDateTime completionDate) {
		this.completionDate = completionDate;
		return this;
	}

	/**
	 * Effective delivery date amended by the provider
	 * 
	 * @return completionDate
	 **/
	@Schema(description = "Effective delivery date amended by the provider")

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

	
	public void setCompletionDate(String completionDate) {
		if (completionDate!=null) {
			this.completionDate = OffsetDateTime.parse( completionDate );			
		}
	}


	public ResourceOrder description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * free-text description of the Resource Order
	 * 
	 * @return description
	 **/
	@Schema(description = "free-text description of the Resource Order")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public ResourceOrder expectedCompletionDate(OffsetDateTime expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
		return this;
	}

	/**
	 * Expected delivery date amended by the provider
	 * 
	 * @return expectedCompletionDate
	 **/
	@Schema(description = "Expected delivery date amended by the provider")

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
	

	public ResourceOrder externalId(String externalId) {
		this.externalId = externalId;
		return this;
	}

	/**
	 * DEPRECATED: Use externalReference Instead. ID given by the consumer (to
	 * facilitate searches afterwards)
	 * 
	 * @return externalId
	 **/
	@Schema(description = "DEPRECATED: Use externalReference Instead. ID given by the consumer (to facilitate searches afterwards)")

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public ResourceOrder name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A string used to give a name to the Resource Order
	 * 
	 * @return name
	 **/
	@Schema(description = "A string used to give a name to the Resource Order")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public ResourceOrder orderDate(OffsetDateTime orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	/**
	 * Get orderDate
	 * 
	 * @return orderDate
	 **/
	@Schema(description = "")

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

	public void setOrderDate(String orderDate) {

		if (orderDate!=null) {
			this.orderDate = OffsetDateTime.parse( orderDate );
			
		}
	}

	public ResourceOrder orderType(String orderType) {
		this.orderType = orderType;
		return this;
	}

	/**
	 * Name of the Resource Order type
	 * 
	 * @return orderType
	 **/
	@Schema(description = "Name of the Resource Order type")

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public ResourceOrder priority(Integer priority) {
		this.priority = priority;
		return this;
	}

	/**
	 * A way that can be used by consumers to prioritize orders in OM system (from 0
	 * to 4 : 0 is the highest priority, and 4 the lowest)
	 * 
	 * @return priority
	 **/
	@Schema(description = "A way that can be used by consumers to prioritize orders in OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)")

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public ResourceOrder requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
		this.requestedCompletionDate = requestedCompletionDate;
		return this;
	}

	/**
	 * Requested delivery date from the requestor perspective
	 * 
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
	
	public void setRequestedCompletionDate(String requestedCompletionDate) {

		if (requestedCompletionDate!=null) {
			this.requestedCompletionDate = OffsetDateTime.parse( requestedCompletionDate );
			
		}
	}
	
	/**
	 * Requested delivery date from the requestors perspective
	 * 
	 * @return requestedCompletionDate
	 **/
	@Schema(description = "Requested delivery date from the requestors perspective")

	@Valid

	@JsonProperty("requestedCompletionDate")
	public String getRequestedCompletionDateString() {

		if ( this.requestedCompletionDate == null) {
			return null;
		}
		return this.requestedCompletionDate.toString();
	}

	/**
	 * Order start date wished by the requestor
	 * 
	 * @return requestedStartDate
	 **/
	@Schema(description = "Order start date wished by the requestor")

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

	public ResourceOrder requestedStartDate(OffsetDateTime requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
		return this;
	}
	
	public void setRequestedStartDate(String requestedStartDate) {

		if (requestedStartDate!=null) {
			this.requestedStartDate = OffsetDateTime.parse( requestedStartDate );
			
		}
	}

	public ResourceOrder startDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}
	/**
	 * Date when the order was started for processing
	 * 
	 * @return startDate
	 **/
	@Schema(description = "Date when the order was started for processing")

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
	
	public void setStartDate(String requestedStartDate) {
		if (requestedStartDate!=null) {
			this.startDate = OffsetDateTime.parse( requestedStartDate );			
		}
	}


	public ResourceOrder state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * The life cycle state of the resource.
	 * 
	 * @return state
	 **/
	@Schema(description = "The life cycle state of the resource.")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ResourceOrder externalReference(Set<ExternalId> externalReference) {
		this.externalReference = externalReference;
		return this;
	}

	public ResourceOrder addExternalReferenceItem(ExternalId externalReferenceItem) {
		 
		this.externalReference.add(externalReferenceItem);
		return this;
	}

	/**
	 * Get externalReference
	 * 
	 * @return externalReference
	 **/
	@Schema(description = "")
	@Valid
	public Set<ExternalId> getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(Set<ExternalId> externalReference) {
		this.externalReference = externalReference;
	}

	public ResourceOrder note(Set<Note> note) {
		this.note = note;
		return this;
	}

	public ResourceOrder addNoteItem(Note noteItem) {
		 
		this.note.add(noteItem);
		return this;
	}

	/**
	 * Get note
	 * 
	 * @return note
	 **/
	@Schema(description = "")
	@Valid
	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	public ResourceOrder orderItem(Set<ResourceOrderItem> orderItem) {
		this.orderItem = orderItem;
		return this;
	}

	public ResourceOrder addOrderItemItem(ResourceOrderItem orderItemItem) {

		this.orderItem.add(orderItemItem);
		return this;
	}

	/**
	 * Get orderItem
	 * 
	 * @return orderItem
	 **/
	@Schema(description = "")
	@Valid
	public Set<ResourceOrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<ResourceOrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public ResourceOrder relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ResourceOrder addRelatedPartyItem(RelatedParty relatedPartyItem) {
		
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Get relatedParty
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "")
	@Valid
	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ResourceOrder _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return _atBaseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
	}

	public ResourceOrder _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public ResourceOrder _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
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
		ResourceOrder resourceOrder = (ResourceOrder) o;
		return Objects.equals(this.id, resourceOrder.id) && Objects.equals(this.href, resourceOrder.href)
				&& Objects.equals(this.category, resourceOrder.category)
				&& Objects.equals(this.completionDate, resourceOrder.completionDate)
				&& Objects.equals(this.description, resourceOrder.description)
				&& Objects.equals(this.expectedCompletionDate, resourceOrder.expectedCompletionDate)
				&& Objects.equals(this.externalId, resourceOrder.externalId)
				&& Objects.equals(this.name, resourceOrder.name)
				&& Objects.equals(this.orderDate, resourceOrder.orderDate)
				&& Objects.equals(this.orderType, resourceOrder.orderType)
				&& Objects.equals(this.priority, resourceOrder.priority)
				&& Objects.equals(this.requestedCompletionDate, resourceOrder.requestedCompletionDate)
				&& Objects.equals(this.requestedStartDate, resourceOrder.requestedStartDate)
				&& Objects.equals(this.startDate, resourceOrder.startDate)
				&& Objects.equals(this.state, resourceOrder.state)
				&& Objects.equals(this.externalReference, resourceOrder.externalReference)
				&& Objects.equals(this.note, resourceOrder.note)
				&& Objects.equals(this.orderItem, resourceOrder.orderItem)
				&& Objects.equals(this.relatedParty, resourceOrder.relatedParty)
				&& Objects.equals(this._atBaseType, resourceOrder._atBaseType)
				&& Objects.equals(this._atSchemaLocation, resourceOrder._atSchemaLocation)
				&& Objects.equals(this._atType, resourceOrder._atType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, category, completionDate, description, expectedCompletionDate, externalId, name,
				orderDate, orderType, priority, requestedCompletionDate, requestedStartDate, startDate, state,
				externalReference, note, orderItem, relatedParty, _atBaseType, _atSchemaLocation, _atType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceOrder {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    expectedCompletionDate: ").append(toIndentedString(expectedCompletionDate)).append("\n");
		sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
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
