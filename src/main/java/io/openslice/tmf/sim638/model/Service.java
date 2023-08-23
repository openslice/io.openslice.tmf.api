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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.Place;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceRelationship;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.common.model.service.ServiceStateType;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * Service is a base class for defining the Service hierarchy. All Services are
 * characterized as either being possibly visible and usable by a Customer or
 * not. This gives rise to the two subclasses of Service: CustomerFacingService
 * and ResourceFacingService.
 */
@Schema(description = "Service is a base class for defining the Service hierarchy. All Services are characterized as either being possibly visible and usable by a Customer or not. This gives rise to the two subclasses of Service: CustomerFacingService and ResourceFacingService.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")

@Entity
public class Service extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("category")
	private String category = null;

	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String descriptionL = null;

	private OffsetDateTime endDate = null;

	@JsonProperty("hasStarted")
	private Boolean hasStarted = null;

	@JsonProperty("isServiceEnabled")
	private Boolean isServiceEnabled = null;

	@JsonProperty("isStateful")
	private Boolean isStateful = null;

	@JsonProperty("serviceDate")
	private String serviceDate = null;

	@JsonProperty("serviceType")
	private String serviceType = null;

	private OffsetDateTime startDate = null;

	@JsonProperty("startMode")
	private String startMode = null;

	@JsonProperty("note")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Note> note = new HashSet<>();

	@JsonProperty("place")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Place> place = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("serviceCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Characteristic> serviceCharacteristic = new HashSet<>();

	@JsonProperty("serviceOrder")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceOrderRef> serviceOrder = new HashSet<>();

	@JsonProperty("serviceRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceRelationship> serviceRelationship = new HashSet<>();

	@JsonProperty("serviceSpecification")
	@OneToOne(cascade = CascadeType.ALL)
	private ServiceSpecificationRef serviceSpecificationRef = null;

	@JsonProperty("state")
	private ServiceStateType state = ServiceStateType.FEASIBILITYCHECKED;

	@JsonProperty("supportingResource")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceRef> supportingResource = new HashSet<>();

	@JsonProperty("supportingService")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceRef> supportingService = new HashSet<>();
	
	
	
	

	public Service() {
		super();
		this.baseType = "BaseRootNamedEntity";
		this.type = "CustomerFacingServiceSpecification"; // by default is a CFS... if we attach a resource then it is a RFS
	}

	
	/**
	 * Unique identifier of the service
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the service")

	public String getId() {
		id = uuid;
		return uuid;
	}

	/**
	 * Is it a customer facing or resource facing service
	 * 
	 * @return category
	 **/
	@Schema(description = "Is it a customer facing or resource facing service")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Service description(String description) {
		this.descriptionL = description;
		return this;
	}

	/**
	 * Free-text description of the service
	 * 
	 * @return description
	 **/
	@Schema(description = "Free-text description of the service")

	public String getDescription() {
		return descriptionL;
	}

	public void setDescription(String description) {
		this.descriptionL = description;
	}

	public Service endDate(OffsetDateTime endDate) {
		this.endDate = endDate;
		return this;
	}

	/**
	 * Date when the service ends
	 * 
	 * @return endDate
	 **/
	@Schema(description = "Date when the service ends")

	@Valid

	public OffsetDateTime getEndDate() {
		return endDate;
	}
	

	@JsonProperty("endDate")
	public String getEndDateStr() {
		if ( this.endDate != null ) {
			return this.endDate.toString();			
		} else {
			return null;
		}
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(String endDate) {
		if ( endDate!=null ) {
			this.endDate = OffsetDateTime.parse( endDate );			
		}
	}
	
	public Service hasStarted(Boolean hasStarted) {
		this.hasStarted = hasStarted;
		return this;
	}

	/**
	 * If TRUE, this Service has already been started
	 * 
	 * @return hasStarted
	 **/
	@Schema(description = "If TRUE, this Service has already been started")

	public Boolean isHasStarted() {
		return hasStarted;
	}

	public void setHasStarted(Boolean hasStarted) {
		this.hasStarted = hasStarted;
	}

	public Service isServiceEnabled(Boolean isServiceEnabled) {
		this.isServiceEnabled = isServiceEnabled;
		return this;
	}

	/**
	 * If FALSE, this particular Service has NOT been enabled for use
	 * 
	 * @return isServiceEnabled
	 **/
	@Schema(description = "If FALSE, this particular Service has NOT been enabled for use")

	public Boolean isIsServiceEnabled() {
		return isServiceEnabled;
	}

	public void setIsServiceEnabled(Boolean isServiceEnabled) {
		this.isServiceEnabled = isServiceEnabled;
	}

	public Service isStateful(Boolean isStateful) {
		this.isStateful = isStateful;
		return this;
	}

	/**
	 * If TRUE, this Service can be changed without affecting any other services
	 * 
	 * @return isStateful
	 **/
	@Schema(description = "If TRUE, this Service can be changed without affecting any other services")

	public Boolean isIsStateful() {
		return isStateful;
	}

	public void setIsStateful(Boolean isStateful) {
		this.isStateful = isStateful;
	}

	public Service serviceDate(String serviceDate) {
		this.serviceDate = serviceDate;
		return this;
	}

	/**
	 * Date when the service was created (whatever its status).
	 * 
	 * @return serviceDate
	 **/
	@Schema(description = "Date when the service was created (whatever its status).")

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Service serviceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	/**
	 * Business type of the service
	 * 
	 * @return serviceType
	 **/
	@Schema(description = "Business type of the service")

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Service startDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}

	/**
	 * Date when the service starts
	 * 
	 * @return startDate
	 **/
	@Schema(description = "Date when the service starts")

	@Valid

	public OffsetDateTime getStartDate() {
		return startDate;
	}
	

	@JsonProperty("startDate")
	public String getStartDateStr() {
		if ( this.startDate != null ) {
			return this.startDate.toString();			
		} else {
			return null;
		}
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}
	
	public void setStartDate(String startDate) {
		if ( startDate!=null ) {
			this.startDate = OffsetDateTime.parse( startDate );
		}
	}

	public Service startMode(String startMode) {
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
	@Schema(description = "This attribute is an enumerated integer that indicates how the Service is started, such as: 0: Unknown; 1: Automatically by the managed environment; 2: Automatically by the owning device; 3: Manually by the Provider of the Service; 4: Manually by a Customer of the Provider; 5: Any of the above")

	public String getStartMode() {
		return startMode;
	}

	public void setStartMode(String startMode) {
		this.startMode = startMode;
	}

	public Service note(Set<Note> note) {
		this.note = note;
		return this;
	}

	public Service addNoteItem(Note noteItem) {
		if (this.note == null) {
			this.note =  new HashSet<>();
		}
		this.note.add(noteItem);
		return this;
	}

	/**
	 * A list of notes made on this service
	 * 
	 * @return note
	 **/
	@Schema(description = "A list of notes made on this service")

	@Valid

	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	public Service place(Set<Place> place) {
		this.place = place;
		return this;
	}

	public Service addPlaceItem(Place placeItem) {
		if (this.place == null) {
			this.place =  new HashSet<>();
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
	@Schema(description = "A list of places related to this service, e.g. where the service is installed, a delivery address for equipment, etc.")

	@Valid

	public Set<Place> getPlace() {
		return place;
	}

	public void setPlace(Set<Place> place) {
		this.place = place;
	}

	public Service relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public Service addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty =  new HashSet<>();
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
	@Schema(description = "A list of related party references (RelatedParty [1..*]). A related party defines party or party role linked to a specific entity.")

	@Valid

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public Service serviceCharacteristic( Set<Characteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
		return this;
	}

	public Service addServiceCharacteristicItem(Characteristic serviceCharacteristicItem) {
		if (this.serviceCharacteristic == null) {
			this.serviceCharacteristic =  new HashSet<>();
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
	@Schema(description = "A list of characteristics that characterize this service (ServiceCharacteristic [*]) ")

	@Valid

	public Set<Characteristic> getServiceCharacteristic() {
		return serviceCharacteristic;
	}

	public void setServiceCharacteristic(Set<Characteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
	}

	public Service serviceOrder( Set<ServiceOrderRef> serviceOrder) {
		this.serviceOrder = serviceOrder;
		return this;
	}

	public Service addServiceOrderItem(ServiceOrderRef serviceOrderItem) {
		if (this.serviceOrder == null) {
			this.serviceOrder =  new HashSet<>();
		}
		this.serviceOrder.add(serviceOrderItem);
		return this;
	}

	/**
	 * A list of service orders related to this service
	 * 
	 * @return serviceOrder
	 **/
	@Schema(description = "A list of service orders related to this service")

	@Valid

	public Set<ServiceOrderRef> getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder( Set<ServiceOrderRef> serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public Service serviceRelationship( Set<ServiceRelationship> serviceRelationship) {
		this.serviceRelationship = serviceRelationship;
		return this;
	}

	public Service addServiceRelationshipItem(ServiceRelationship serviceRelationshipItem) {
		if (this.serviceRelationship == null) {
			this.serviceRelationship = new HashSet<>();
		}
		this.serviceRelationship.add(serviceRelationshipItem);
		return this;
	}

	/**
	 * A list of service relationships (ServiceRelationship [*]). Describes links
	 * with other service(s) in the inventory (useful for describing relies-on,
	 * relies-from between CFS for example).
	 * 
	 * @return serviceRelationship
	 **/
	@Schema(description = "A list of service relationships (ServiceRelationship [*]). Describes links with other service(s) in the inventory (useful for describing relies-on, relies-from between CFS for example).")

	@Valid

	public Set<ServiceRelationship> getServiceRelationship() {
		return serviceRelationship;
	}

	public void setServiceRelationship( Set<ServiceRelationship> serviceRelationship) {
		this.serviceRelationship = serviceRelationship;
	}

	public Service serviceSpecificationRef(ServiceSpecificationRef serviceSpecification) {
		this.serviceSpecificationRef = serviceSpecification;
		return this;
	}

	/**
	 * The specification from which this service was instantiated
	 * 
	 * @return serviceSpecification
	 **/
	@Schema(description = "The specification from which this service was instantiated")

	@Valid

	public ServiceSpecificationRef getServiceSpecificationRef() {
		return serviceSpecificationRef;
	}

	public void setServiceSpecificationRef(ServiceSpecificationRef serviceSpecification) {
		this.serviceSpecificationRef = serviceSpecification;
	}

	public Service state(ServiceStateType state) {
		this.state = state;
		return this;
	}

	/**
	 * The life cycle state of the service, such as: feasibilityChecked, designed,
	 * reserved, active, inactive, terminated
	 * 
	 * @return state
	 **/
	@Schema(description = "The life cycle state of the service, such as: feasibilityChecked, designed, reserved, active, inactive, terminated")

	@Valid

	public ServiceStateType getState() {
		return state;
	}

	public void setState(ServiceStateType state) {
		this.state = state;
	}

	public Service supportingResource( Set<ResourceRef> supportingResource) {
		this.supportingResource = supportingResource;
		return this;
	}

	public Service addSupportingResourceItem(ResourceRef supportingResourceItem) {
		if (this.supportingResource == null) {
			this.supportingResource =  new HashSet<>();
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
	@Schema(description = "A list of supporting resources (SupportingResource [*]).Note: only Service of type RFS can be associated with Resources.")

	@Valid

	public Set<ResourceRef> getSupportingResource() {
		return supportingResource;
	}

	public void setSupportingResource( Set<ResourceRef> supportingResource) {
		this.supportingResource = supportingResource;
	}

	public Service supportingService( Set<ServiceRef> supportingService) {
		this.supportingService = supportingService;
		return this;
	}

	public Service addSupportingServiceItem(ServiceRef supportingServiceItem) {
		if (this.supportingService == null) {
			this.supportingService =  new HashSet<>();
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
	@Schema(description = "A list of supporting services (SupportingService [*]). A collection of services that support this service (bundling, link CFS to RFS).")

	@Valid

	public Set<ServiceRef> getSupportingService() {
		return supportingService;
	}

	public void setSupportingService( Set<ServiceRef> supportingService) {
		this.supportingService = supportingService;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Service service = (Service) o;
		return Objects.equals(this.id, service.id) && Objects.equals(this.href, service.href)
				&& Objects.equals(this.category, service.category)
				&& Objects.equals(this.descriptionL, service.descriptionL)
				&& Objects.equals(this.endDate, service.endDate) && Objects.equals(this.hasStarted, service.hasStarted)
				&& Objects.equals(this.isServiceEnabled, service.isServiceEnabled)
				&& Objects.equals(this.isStateful, service.isStateful) && Objects.equals(this.name, service.name)
				&& Objects.equals(this.serviceDate, service.serviceDate)
				&& Objects.equals(this.serviceType, service.serviceType)
				&& Objects.equals(this.startDate, service.startDate)
				&& Objects.equals(this.startMode, service.startMode) && Objects.equals(this.note, service.note)
				&& Objects.equals(this.place, service.place) && Objects.equals(this.relatedParty, service.relatedParty)
				&& Objects.equals(this.serviceCharacteristic, service.serviceCharacteristic)
				&& Objects.equals(this.serviceOrder, service.serviceOrder)
				&& Objects.equals(this.serviceRelationship, service.serviceRelationship)
				&& Objects.equals(this.serviceSpecificationRef, service.serviceSpecificationRef)
				&& Objects.equals(this.state, service.state)
				&& Objects.equals(this.supportingResource, service.supportingResource)
				&& Objects.equals(this.supportingService, service.supportingService)
				&& Objects.equals(this.baseType, service.baseType)
				&& Objects.equals(this.schemaLocation, service.schemaLocation)
				&& Objects.equals(this.type, service.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, category, description, endDate, hasStarted, isServiceEnabled, isStateful, name,
//				serviceDate, serviceType, startDate, startMode, note, place, relatedParty, serviceCharacteristic,
//				serviceOrder, serviceRelationship, serviceSpecification, state, supportingResource, supportingService,
//				baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Service {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(descriptionL)).append("\n");
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
		sb.append("    serviceRelationship: ").append(toIndentedString(serviceRelationship)).append("\n");
		sb.append("    serviceSpecificationRef: ").append(toIndentedString(serviceSpecificationRef)).append("\n");
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


	public Characteristic getServiceCharacteristicByName(String name) {
		for (Characteristic c : this.serviceCharacteristic) {
			if ( c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}
