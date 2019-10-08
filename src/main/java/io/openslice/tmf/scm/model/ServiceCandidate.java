package io.openslice.tmf.scm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceCandidate is an entity that makes a service specification available to
 * a catalog. A ServiceCandidate and its associated service specification may be
 * published - made visible - in any number of service catalogs, or in none. One
 * service specification can be composed of other service specifications.
 */
@ApiModel(description = "ServiceCandidate is an entity that makes a service specification available to a catalog. A ServiceCandidate and its associated service specification may be published - made visible - in any number of service catalogs, or in none. One service specification can be composed of other service specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Entity(name = "ServiceCandidate" )
@Table( name = "ServiceCandidate" )

public class ServiceCandidate extends BaseEntity {

	@ManyToMany( mappedBy ="serviceCandidateObj" )
	private Set<ServiceCategory> categoryObj = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_specid", referencedColumnName = "id")
	private ServiceSpecification serviceSpecificationObj = null;

	public ServiceCandidate() {
		super();
		this.type = "ServiceCandidate";
		this.baseType = "BaseEntity";
	}
	
	
	
	
	/**
	 * The service specification implied by this candidate
	 * 
	 * @return serviceSpecification
	 **/
	@ApiModelProperty(value = "The service specification implied by this candidate")

	@Transient
	@JsonProperty("serviceSpecification")
	@Valid
	public ServiceSpecificationRef getServiceSpecificationRef() {
		ServiceSpecificationRef sref = new ServiceSpecificationRef();

		sref.setId(  this.serviceSpecificationObj.getId());
		sref.setName(  this.serviceSpecificationObj.getName() );
		sref.setVersion( this.serviceSpecificationObj.getVersion());
		sref.setBaseType(ServiceSpecificationRef.class.getName());
		return sref;
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




	/**
	 * The service specification implied by this candidate
	 * 
	 * @return serviceSpecification
	 **/
	@ApiModelProperty(value = "The category specification implied by this candidate")

	@Transient
	@JsonProperty("category")
	@Valid
	public List<ServiceCategoryRef> getCategory() {

		List<ServiceCategoryRef> category = new ArrayList<>();

		for (ServiceCategory serviceCategory : categoryObj) {
			ServiceCategoryRef scr = new ServiceCategoryRef();
			scr.setId(serviceCategory.getId());
			scr.setName(serviceCategory.getName());
			scr.setBaseType(ServiceCategoryRef.class.getName());

		}

		return category;
	}



	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCandidate serviceCandidate = (ServiceCandidate) o;
		return Objects.equals(this.id, serviceCandidate.id) && Objects.equals(this.href, serviceCandidate.href)
				&& Objects.equals(this.description, serviceCandidate.description)
				&& Objects.equals(this.lastUpdate, serviceCandidate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCandidate.lifecycleStatus)
				&& Objects.equals(this.name, serviceCandidate.name)
				&& Objects.equals(this.version, serviceCandidate.version)
				&& Objects.equals(this.getCategory(), serviceCandidate.getCategory())
				&& Objects.equals(this.getServiceSpecificationRef() , serviceCandidate.getServiceSpecificationRef() )
				&& Objects.equals(this.validFor, serviceCandidate.validFor)
				&& Objects.equals(this.baseType, serviceCandidate.baseType)
				&& Objects.equals(this.schemaLocation, serviceCandidate.schemaLocation)
				&& Objects.equals(this.type, serviceCandidate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, description, lastUpdate, lifecycleStatus, name, version, getCategory(),
				getServiceSpecificationRef() , validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCandidate {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    category: ").append(toIndentedString(getCategory())).append("\n");
		sb.append("    serviceSpecification: ").append(toIndentedString(getServiceSpecificationRef() )).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

	/**
	 * @return the categoryObj
	 */
	public Set<ServiceCategory> getCategoryObj() {
		return categoryObj;
	}

	/**
	 * @param categoryObj the categoryObj to set
	 */
	public void setCategoryObj(Set<ServiceCategory> categoryObj) {
		this.categoryObj = categoryObj;
	}
}
