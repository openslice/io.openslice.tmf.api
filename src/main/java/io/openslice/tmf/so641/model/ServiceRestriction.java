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
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * In the context of a service order, and depending of the action requested
 * (add/modify/delete/noChange) this data structure captures the configuration
 * to apply to an existing subscribed service or to a new one
 */
@ApiModel(description = "In the context of a service order, and depending of the action requested (add/modify/delete/noChange) this data structure captures the configuration to apply to an existing subscribed service or to a new one")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Entity(name = "ServiceRestriction")
public class ServiceRestriction extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("category")
	private String category = null;

	@JsonProperty("serviceType")
	private String serviceType = null;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_specid", referencedColumnName = "id")
	@JsonIgnore
	private ServiceSpecification serviceSpecificationObj = null;
	

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

	@JsonProperty("state")
	private ServiceStateType state = ServiceStateType.FEASIBILITYCHECKED;

	@JsonProperty("supportingResource")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceRef> supportingResource = new HashSet<>();


	@JsonProperty("serviceRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceRelationship> serviceRelationship = new HashSet<>();


	
	@JsonProperty("supportingService")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceRef> supportingService = new HashSet<>();

	/**
	 * Unique identifier of the service
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the service")

	public String getId() {
		return uuid;
	}

	public ServiceRestriction category(String category) {
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

	public ServiceRestriction serviceType(String serviceType) {
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

	public ServiceRestriction place(Set<Place> place) {
		this.place = place;
		return this;
	}

	public ServiceRestriction addPlaceItem(Place placeItem) {
		if (this.place == null) {
			this.place = new HashSet<>();
		}
		this.place.add(placeItem);
		return this;
	}

	/**
	 * A list of places (Place [*]). Used to define a place useful for the service
	 * (for example a delivery geographical place)
	 * 
	 * @return place
	 **/
	@ApiModelProperty(value = "A list of places (Place [*]). Used to define a place useful for the service (for example a delivery geographical place)")

	@Valid

	public Set<Place> getPlace() {
		return place;
	}

	public void setPlace(Set<Place> place) {
		this.place = place;
	}

	public ServiceRestriction relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceRestriction addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * A list of related party references (RelatedParty [*]). A related party
	 * defines party or party role linked to a specific entity
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "A list of related party references (RelatedParty [*]). A related party defines party or party role linked to a specific entity")

	@Valid

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceRestriction serviceCharacteristic(Set<Characteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
		return this;
	}

	public ServiceRestriction addServiceCharacteristicItem(Characteristic serviceCharacteristicItem) {
		if (this.serviceCharacteristic == null) {
			this.serviceCharacteristic = new HashSet<>();
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

	public Set<Characteristic> getServiceCharacteristic() {
		return serviceCharacteristic;
	}

	public void setServiceCharacteristic(Set<Characteristic> serviceCharacteristic) {
		this.serviceCharacteristic = serviceCharacteristic;
	}

	public ServiceRestriction serviceRelationship(Set<ServiceRelationship> serviceRelationship) {
		this.serviceRelationship = serviceRelationship;
		return this;
	}

	public ServiceRestriction addServiceRelationshipItem(ServiceRelationship serviceRelationshipItem) {
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
	@ApiModelProperty(value = "A list of service relationships (ServiceRelationship [*]). Describes links with other service(s) in the inventory (useful for describing relies-on, relies-from between CFS for example).")

	@Valid

	public Set<ServiceRelationship> getServiceRelationship() {
		return serviceRelationship;
	}

	public void setServiceRelationship(Set<ServiceRelationship> serviceRelationship) {
		this.serviceRelationship = serviceRelationship;
	}


	/**
	 * The specification from which this service was instantiated
	 * 
	 * @return serviceSpecification
	 **/
	@ApiModelProperty(value = "The specification from which this service was instantiated")

	@Valid
	@JsonProperty("serviceSpecification")
	public ServiceSpecificationRef getServiceSpecification() {
		if ( this.serviceSpecificationObj != null )
		{
			ServiceSpecificationRef sref = new ServiceSpecificationRef();
			
			sref.setId(  this.serviceSpecificationObj.getUuid());
			sref.setName(  this.serviceSpecificationObj.getName() );
			sref.setVersion( this.serviceSpecificationObj.getVersion());
			sref.setBaseType(ServiceSpecificationRef.class.getName());
			return sref;			
		}
		
		return null;
	}

	/**
	 * @return the serviceSpecificationObj
	 */
	public ServiceSpecification getServiceSpecificationObj() {
		return serviceSpecificationObj;
	}

	/**
	 * @param serviceSpecificationObj the serviceSpecificationObj to set
	 */
	public void setServiceSpecificationObj(ServiceSpecification serviceSpecificationObj) {
		this.serviceSpecificationObj = serviceSpecificationObj;
	}


	public ServiceRestriction state(ServiceStateType state) {
		this.state = state;
		return this;
	}

	/**
	 * The life cycle state of the service, such as: [feasibilityChecked],
	 * [designed]
	 * 
	 * @return state
	 **/
	@ApiModelProperty(value = "The life cycle state of the service, such as: [feasibilityChecked], [designed]")

	@Valid

	public ServiceStateType getState() {
		return state;
	}

	public void setState(ServiceStateType state) {
		this.state = state;
	}

	public ServiceRestriction supportingResource(Set<ResourceRef> supportingResource) {
		this.supportingResource = supportingResource;
		return this;
	}

	public ServiceRestriction addSupportingResourceItem(ResourceRef supportingResourceItem) {
		if (this.supportingResource == null) {
			this.supportingResource = new HashSet<>();
		}
		this.supportingResource.add(supportingResourceItem);
		return this;
	}

	/**
	 * A list of supporting resources (SupportingResource [*]).Note: only Service of
	 * type RFS can be associated with Resources
	 * 
	 * @return supportingResource
	 **/
	@ApiModelProperty(value = "A list of supporting resources (SupportingResource [*]).Note: only Service of type RFS can be associated with Resources")

	@Valid

	public Set<ResourceRef> getSupportingResource() {
		return supportingResource;
	}

	public void setSupportingResource(Set<ResourceRef> supportingResource) {
		this.supportingResource = supportingResource;
	}

	public ServiceRestriction supportingService(Set<ServiceRef> supportingService) {
		this.supportingService = supportingService;
		return this;
	}

	public ServiceRestriction addSupportingServiceItem(ServiceRef supportingServiceItem) {
		if (this.supportingService == null) {
			this.supportingService = new HashSet<>();
		}
		this.supportingService.add(supportingServiceItem);
		return this;
	}

	/**
	 * A list of supporting services (SupportingService [*]). A collection of
	 * services that support this service (bundling, link CFS to RFS)
	 * 
	 * @return supportingService
	 **/
	@ApiModelProperty(value = "A list of supporting services (SupportingService [*]). A collection of services that support this service (bundling, link CFS to RFS)")

	@Valid

	public Set<ServiceRef> getSupportingService() {
		return supportingService;
	}

	public void setSupportingService(Set<ServiceRef> supportingService) {
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
		ServiceRestriction serviceRestriction = (ServiceRestriction) o;
		return Objects.equals(this.id, serviceRestriction.id) && Objects.equals(this.href, serviceRestriction.href)
				&& Objects.equals(this.category, serviceRestriction.category)
				&& Objects.equals(this.name, serviceRestriction.name)
				&& Objects.equals(this.serviceType, serviceRestriction.serviceType)
				&& Objects.equals(this.place, serviceRestriction.place)
				&& Objects.equals(this.relatedParty, serviceRestriction.relatedParty)
				&& Objects.equals(this.serviceCharacteristic, serviceRestriction.serviceCharacteristic)
				&& Objects.equals(this.serviceRelationship, serviceRestriction.serviceRelationship)
				&& Objects.equals(this.getServiceSpecification(), serviceRestriction.getServiceSpecification())
				&& Objects.equals(this.state, serviceRestriction.state)
				&& Objects.equals(this.supportingResource, serviceRestriction.supportingResource)
				&& Objects.equals(this.supportingService, serviceRestriction.supportingService)
				&& Objects.equals(this.baseType, serviceRestriction.baseType)
				&& Objects.equals(this.schemaLocation, serviceRestriction.schemaLocation)
				&& Objects.equals(this.type, serviceRestriction.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, category, name, serviceType, place, relatedParty, serviceCharacteristic,
				serviceRelationship, getServiceSpecification(), state, supportingResource, supportingService, baseType,
				schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceRestriction {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    serviceCharacteristic: ").append(toIndentedString(serviceCharacteristic)).append("\n");
		sb.append("    serviceRelationship: ").append(toIndentedString(serviceRelationship)).append("\n");
		sb.append("    serviceSpecification: ").append(toIndentedString(getServiceSpecification())).append("\n");
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
