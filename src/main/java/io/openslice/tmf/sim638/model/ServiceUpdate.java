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
package io.openslice.tmf.sim638.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.Place;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceRelationship;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.common.model.service.ServiceStateType;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Service is a base class for defining the Service hierarchy. All Services are
 * characterized as either being possibly visible and usable by a Customer or
 * not. This gives rise to the two subclasses of Service: CustomerFacingService
 * and ResourceFacingService. Skipped properties: id,href,serviceRelationship
 */
@ApiModel(description = "Service is a base class for defining the Service hierarchy. All Services are characterized as either being possibly visible and usable by a Customer or not. This gives rise to the two subclasses of Service: CustomerFacingService and ResourceFacingService. Skipped properties: id,href,serviceRelationship")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")

public class ServiceUpdate {
	@JsonProperty("category")
	protected String category = null;

	@JsonProperty("description")
	protected String description = null;

	protected OffsetDateTime endDate = null;

	@JsonProperty("hasStarted")
	protected Boolean hasStarted = null;

	@JsonProperty("isServiceEnabled")
	protected Boolean isServiceEnabled = null;

	@JsonProperty("isStateful")
	protected Boolean isStateful = null;

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("serviceDate")
	protected String serviceDate = null;

	@JsonProperty("serviceType")
	protected String serviceType = null;

	protected OffsetDateTime startDate = null;

	@JsonProperty("startMode")
	protected String startMode = null;

	@JsonProperty("note")
	@Valid
	protected List<Note> note = null;

	@JsonProperty("place")
	@Valid
	protected List<Place> place = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("serviceCharacteristic")
	@Valid
	protected List<Characteristic> serviceCharacteristic = null;

	@JsonProperty("serviceOrder")
	@Valid
	protected List<ServiceOrderRef> serviceOrder = null;

	@JsonProperty("serviceSpecification")
	protected ServiceSpecificationRef serviceSpecificationRef = null;

	@JsonProperty("state")
	protected ServiceStateType state = null;

	@JsonProperty("supportingResource")
	@Valid
	protected List<ResourceRef> supportingResource = null;

	@JsonProperty("supportingService")
	@Valid
	protected List<ServiceRef> supportingService = null;
	

	@JsonProperty("serviceRelationship")
	@Valid
	protected List<ServiceRelationship> serviceRelationship = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@type")
	protected String type = null;

	public ServiceUpdate category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Is it a customer facing or resource facing service
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "Is it a customer facing or resource facing service")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ServiceUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Free-text description of the service
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Free-text description of the service")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceUpdate endDate(OffsetDateTime endDate) {
		this.endDate = endDate;
		return this;
	}

	@JsonProperty("endDate")
	public String getEndDateStr() {
		if (this.endDate != null) {
			return this.endDate.toString();
		} else {
			return null;
		}
	}

	/**
	 * Date when the service ends
	 * 
	 * @return endDate
	 **/
	@ApiModelProperty(value = "Date when the service ends")

	@Valid

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(String anendDate) {
		if (anendDate != null) {
			this.endDate = OffsetDateTime.parse(anendDate);

		}

	}

	public ServiceUpdate hasStarted(Boolean hasStarted) {
		this.hasStarted = hasStarted;
		return this;
	}

	/**
	 * If TRUE, this Service has already been started
	 * 
	 * @return hasStarted
	 **/
	@ApiModelProperty(value = "If TRUE, this Service has already been started")

	public Boolean isHasStarted() {
		return hasStarted;
	}

	public void setHasStarted(Boolean hasStarted) {
		this.hasStarted = hasStarted;
	}

	public ServiceUpdate isServiceEnabled(Boolean isServiceEnabled) {
		this.isServiceEnabled = isServiceEnabled;
		return this;
	}

	/**
	 * If FALSE, this particular Service has NOT been enabled for use
	 * 
	 * @return isServiceEnabled
	 **/
	@ApiModelProperty(value = "If FALSE, this particular Service has NOT been enabled for use")

	public Boolean isIsServiceEnabled() {
		return isServiceEnabled;
	}

	public void setIsServiceEnabled(Boolean isServiceEnabled) {
		this.isServiceEnabled = isServiceEnabled;
	}

	public ServiceUpdate isStateful(Boolean isStateful) {
		this.isStateful = isStateful;
		return this;
	}

	/**
	 * If TRUE, this Service can be changed without affecting any other services
	 * 
	 * @return isStateful
	 **/
	@ApiModelProperty(value = "If TRUE, this Service can be changed without affecting any other services")

	public Boolean isIsStateful() {
		return isStateful;
	}

	public void setIsStateful(Boolean isStateful) {
		this.isStateful = isStateful;
	}

	public ServiceUpdate name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the service
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the service")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ServiceUpdate serviceDate(String serviceDate) {
		this.serviceDate = serviceDate;
		return this;
	}

	/**
	 * Date when the service was created (whatever its status).
	 * 
	 * @return serviceDate
	 **/
	@ApiModelProperty(value = "Date when the service was created (whatever its status).")

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public ServiceUpdate serviceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	/**
	 * Business type of the service
	 * 
	 * @return serviceType
	 **/
	@ApiModelProperty(value = "Business type of the service")

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public ServiceUpdate startDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}

	/**
	 * Date when the service starts
	 * 
	 * @return startDate
	 **/
	@ApiModelProperty(value = "Date when the service starts")

	@Valid

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public String getStartDateStr() {
		if (this.startDate != null) {
			return this.startDate.toString();
		} else {
			return null;
		}
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(String astartDate) {
		if (astartDate != null) {
			this.startDate = OffsetDateTime.parse(astartDate);

		}

	}

	public ServiceUpdate startMode(String startMode) {
		this.startMode = startMode;
		return this;
	}

	/**
	 * This attribute is an enumerated integer that indicates how the Service is
	 * started, such as: 0: Unknown; 1: Automatically by the managed environment; 2:
	 * Automatically by the owning device; 3: Manually by the Provider of the
	 * Service; 4: Manually by a Customer of the Provider; 5: Any of the above
	 * 
	 * @return startMode
	 **/
	@ApiModelProperty(value = "This attribute is an enumerated integer that indicates how the Service is started, such as: 0: Unknown; 1: Automatically by the managed environment; 2: Automatically by the owning device; 3: Manually by the Provider of the Service; 4: Manually by a Customer of the Provider; 5: Any of the above")

	public String getStartMode() {
		return startMode;
	}

	public void setStartMode(String startMode) {
		this.startMode = startMode;
	}

	public ServiceUpdate note(List<Note> note) {
		this.note = note;
		return this;
	}

	public ServiceUpdate addNoteItem(Note noteItem) {
		if (this.note == null) {
			this.note = new ArrayList<>();
		}
		this.note.add(noteItem);
		return this;
	}

	/**
	 * A list of notes made on this service
	 * 
	 * @return note
	 **/
	@ApiModelProperty(value = "A list of notes made on this service")

	@Valid

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	public ServiceUpdate place(List<Place> place) {
		this.place = place;
		return this;
	}

	public ServiceUpdate addPlaceItem(Place placeItem) {
		if (this.place == null) {
			this.place = new ArrayList<>();
		}
		this.place.add(placeItem);
		return this;
	}

	/**
	 * A list of places related to this service, e.g. where the service is
	 * installed, a delivery address for equipment, etc.
	 * 
	 * @return place
	 **/
	@ApiModelProperty(value = "A list of places related to this service, e.g. where the service is installed, a delivery address for equipment, etc.")

	@Valid

	public List<Place> getPlace() {
		return place;
	}

	public void setPlace(List<Place> place) {
		this.place = place;
	}

	public ServiceUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * A list of related party references (RelatedParty [1..*]). A related party
	 * defines party or party role linked to a specific entity.
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "A list of related party references (RelatedParty [1..*]). A related party defines party or party role linked to a specific entity.")

	@Valid

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceUpdate serviceCharacteristic(List<Characteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
		return this;
	}

	public ServiceUpdate addServiceCharacteristicItem(Characteristic serviceCharacteristicItem) {
		if (this.serviceCharacteristic == null) {
			this.serviceCharacteristic = new ArrayList<>();
		}
		this.serviceCharacteristic.add(serviceCharacteristicItem);
		return this;
	}

	/**
	 * A list of characteristics that characterize this service
	 * (ServiceCharacteristic [*])
	 * 
	 * @return serviceCharacteristic
	 **/
	@ApiModelProperty(value = "A list of characteristics that characterize this service (ServiceCharacteristic [*]) ")

	@Valid

	public List<Characteristic> getServiceCharacteristic() {
		return serviceCharacteristic;
	}

	public void setServiceCharacteristic(List<Characteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
	}

	public ServiceUpdate serviceOrder(List<ServiceOrderRef> serviceOrder) {
		this.serviceOrder = serviceOrder;
		return this;
	}

	public ServiceUpdate addServiceOrderItem(ServiceOrderRef serviceOrderItem) {
		if (this.serviceOrder == null) {
			this.serviceOrder = new ArrayList<>();
		}
		this.serviceOrder.add(serviceOrderItem);
		return this;
	}

	/**
	 * A list of service orders related to this service
	 * 
	 * @return serviceOrder
	 **/
	@ApiModelProperty(value = "A list of service orders related to this service")

	@Valid

	public List<ServiceOrderRef> getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(List<ServiceOrderRef> serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public ServiceUpdate serviceSpecificationRef(ServiceSpecificationRef serviceSpecification) {
		this.serviceSpecificationRef = serviceSpecification;
		return this;
	}

	/**
	 * The specification from which this service was instantiated
	 * 
	 * @return serviceSpecification
	 **/
	@ApiModelProperty(value = "The specification from which this service was instantiated")

	@Valid

	public ServiceSpecificationRef getServiceSpecificationRef() {
		return serviceSpecificationRef;
	}

	public void setServiceSpecificationRef(ServiceSpecificationRef serviceSpecification) {
		this.serviceSpecificationRef = serviceSpecification;
	}

	public ServiceUpdate state(ServiceStateType state) {
		this.state = state;
		return this;
	}

	/**
	 * The life cycle state of the service, such as: feasibilityChecked, designed,
	 * reserved, active, inactive, terminated
	 * 
	 * @return state
	 **/
	@ApiModelProperty(value = "The life cycle state of the service, such as: feasibilityChecked, designed, reserved, active, inactive, terminated")

	@Valid

	public ServiceStateType getState() {
		return state;
	}

	public void setState(ServiceStateType state) {
		this.state = state;
	}

	public ServiceUpdate supportingResource(List<ResourceRef> supportingResource) {
		this.supportingResource = supportingResource;
		return this;
	}

	public ServiceUpdate addSupportingResourceItem(ResourceRef supportingResourceItem) {
		if (this.supportingResource == null) {
			this.supportingResource = new ArrayList<>();
		}
		this.supportingResource.add(supportingResourceItem);
		return this;
	}

	/**
	 * A list of supporting resources (SupportingResource [*]).Note: only Service of
	 * type RFS can be associated with Resources.
	 * 
	 * @return supportingResource
	 **/
	@ApiModelProperty(value = "A list of supporting resources (SupportingResource [*]).Note: only Service of type RFS can be associated with Resources.")

	@Valid

	public List<ResourceRef> getSupportingResource() {
		return supportingResource;
	}

	public void setSupportingResource(List<ResourceRef> supportingResource) {
		this.supportingResource = supportingResource;
	}

	public ServiceUpdate supportingService(List<ServiceRef> supportingService) {
		this.supportingService = supportingService;
		return this;
	}

	public ServiceUpdate addSupportingServiceItem(ServiceRef supportingServiceItem) {
		if (this.supportingService == null) {
			this.supportingService = new ArrayList<>();
		}
		this.supportingService.add(supportingServiceItem);
		return this;
	}

	/**
	 * A list of supporting services (SupportingService [*]). A collection of
	 * services that support this service (bundling, link CFS to RFS).
	 * 
	 * @return supportingService
	 **/
	@ApiModelProperty(value = "A list of supporting services (SupportingService [*]). A collection of services that support this service (bundling, link CFS to RFS).")

	@Valid

	public List<ServiceRef> getSupportingService() {
		return supportingService;
	}

	public void setSupportingService(List<ServiceRef> supportingService) {
		this.supportingService = supportingService;
	}

	public ServiceUpdate baseType(String baseType) {
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

	public ServiceUpdate schemaLocation(String schemaLocation) {
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

	public ServiceUpdate type(String type) {
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



	public ServiceRelationship addServiceRelationshipItem(ServiceRelationship serviceRelationshipItem) {
		if (this.serviceRelationship == null) {
			this.serviceRelationship = new ArrayList<>();
		}
		this.serviceRelationship.add(serviceRelationshipItem);
		return serviceRelationshipItem;
	}

	/**
	 * A list of service relationships (ServiceRelationship [*]). Describes links
	 * with other service(s) in the inventory (useful for describing relies-on,
	 * relies-from between CFS for example).
	 * 
	 * @return serviceRelationship
	 **/
	@ApiModelProperty(value = "A list of service relationships (ServiceRelationship [*]). Describes links with other service(s) in the inventory (useful for describing relies-on, relies-from between CFS for example).")

	@Valid

	public List<ServiceRelationship> getServiceRelationship() {
		return serviceRelationship;
	}

	public void setServiceRelationship(List<ServiceRelationship> serviceRelationship) {
		this.serviceRelationship = serviceRelationship;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceUpdate serviceUpdate = (ServiceUpdate) o;
		return Objects.equals(this.category, serviceUpdate.category)
				&& Objects.equals(this.description, serviceUpdate.description)
				&& Objects.equals(this.endDate, serviceUpdate.endDate)
				&& Objects.equals(this.hasStarted, serviceUpdate.hasStarted)
				&& Objects.equals(this.isServiceEnabled, serviceUpdate.isServiceEnabled)
				&& Objects.equals(this.isStateful, serviceUpdate.isStateful)
				&& Objects.equals(this.name, serviceUpdate.name)
				&& Objects.equals(this.serviceDate, serviceUpdate.serviceDate)
				&& Objects.equals(this.serviceType, serviceUpdate.serviceType)
				&& Objects.equals(this.startDate, serviceUpdate.startDate)
				&& Objects.equals(this.startMode, serviceUpdate.startMode)
				&& Objects.equals(this.note, serviceUpdate.note) && Objects.equals(this.place, serviceUpdate.place)
				&& Objects.equals(this.relatedParty, serviceUpdate.relatedParty)
				&& Objects.equals(this.serviceCharacteristic, serviceUpdate.serviceCharacteristic)
				&& Objects.equals(this.serviceOrder, serviceUpdate.serviceOrder)
				&& Objects.equals(this.serviceSpecificationRef, serviceUpdate.serviceSpecificationRef)
				&& Objects.equals(this.state, serviceUpdate.state)
				&& Objects.equals(this.supportingResource, serviceUpdate.supportingResource)
				&& Objects.equals(this.supportingService, serviceUpdate.supportingService)
				&& Objects.equals(this.baseType, serviceUpdate.baseType)
				&& Objects.equals(this.schemaLocation, serviceUpdate.schemaLocation)
				&& Objects.equals(this.type, serviceUpdate.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(category, description, endDate, hasStarted, isServiceEnabled, isStateful, name, serviceDate, serviceType, startDate, startMode, note, place, relatedParty, serviceCharacteristic, serviceOrder, serviceSpecification, state, supportingResource, supportingService, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceUpdate {\n");

		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
		sb.append("    hasStarted: ").append(toIndentedString(hasStarted)).append("\n");
		sb.append("    isServiceEnabled: ").append(toIndentedString(isServiceEnabled)).append("\n");
		sb.append("    isStateful: ").append(toIndentedString(isStateful)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    serviceDate: ").append(toIndentedString(serviceDate)).append("\n");
		sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    startMode: ").append(toIndentedString(startMode)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    serviceCharacteristic: ").append(toIndentedString(serviceCharacteristic)).append("\n");
		sb.append("    serviceOrder: ").append(toIndentedString(serviceOrder)).append("\n");
		sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecificationRef)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    supportingResource: ").append(toIndentedString(supportingResource)).append("\n");
		sb.append("    supportingService: ").append(toIndentedString(supportingService)).append("\n");
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
