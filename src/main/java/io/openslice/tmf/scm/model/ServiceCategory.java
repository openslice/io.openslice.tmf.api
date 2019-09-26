package io.openslice.tmf.scm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories.
 */
@ApiModel(description = "The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceCategory")
@Table( name = "ServiceCategory" )
public class ServiceCategory extends BaseEntity {


	@JsonProperty("isRoot")
	private Boolean isRoot = null;


	@JsonProperty("parentId")
	private String parentId = null;


	@Transient
	@JsonProperty("category")
	@Valid
	private List<ServiceCategoryRef> category = null;


	@Transient
	@JsonProperty("serviceCandidate")
	@Valid
	private List<ServiceCandidateRef> serviceCandidate = null;


	public ServiceCategory() {
		super();
		this.baseType = "BaseEntity";
		this.type = "ServiceCategory";
	}

	


	/**
	 * If true, this Boolean indicates that the category is a root of categories
	 * 
	 * @return isRoot
	 **/
	@ApiModelProperty(value = "If true, this Boolean indicates that the category is a root of categories")

	public Boolean isIsRoot() {
		return isRoot;
	}

	public void setIsRoot(Boolean isRoot) {
		if ( isRoot == null ) {
			this.isRoot = true;
		} else {
			this.isRoot = isRoot;
		}
	}



	/**
	 * Unique identifier of the parent category
	 * 
	 * @return parentId
	 **/
	@ApiModelProperty(value = "Unique identifier of the parent category")

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}



	public ServiceCategory category(List<ServiceCategoryRef> category) {
		this.category = category;
		return this;
	}

	public ServiceCategory addCategoryItem(ServiceCategoryRef categoryItem) {
		if (this.category == null) {
			this.category = new ArrayList<ServiceCategoryRef>();
		}
		this.category.add(categoryItem);
		return this;
	}

	/**
	 * List of child categories in the tree for in this category
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "List of child categories in the tree for in this category")

	@Valid

	public List<ServiceCategoryRef> getCategory() {
		return category;
	}

	public void setCategory(List<ServiceCategoryRef> category) {
		this.category = category;
	}

	public ServiceCategory serviceCandidate(List<ServiceCandidateRef> serviceCandidate) {
		this.serviceCandidate = serviceCandidate;
		return this;
	}

	public ServiceCategory addServiceCandidateItem(ServiceCandidateRef serviceCandidateItem) {
		if (this.serviceCandidate == null) {
			this.serviceCandidate = new ArrayList<ServiceCandidateRef>();
		}
		this.serviceCandidate.add(serviceCandidateItem);
		return this;
	}

	/**
	 * List of service candidates associated with this category
	 * 
	 * @return serviceCandidate
	 **/
	@ApiModelProperty(value = "List of service candidates associated with this category")

	@Valid

	public List<ServiceCandidateRef> getServiceCandidate() {
		return serviceCandidate;
	}

	public void setServiceCandidate(List<ServiceCandidateRef> serviceCandidate) {
		this.serviceCandidate = serviceCandidate;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCategory serviceCategory = (ServiceCategory) o;
		return Objects.equals(this.id, serviceCategory.id) && Objects.equals(this.href, serviceCategory.href)
				&& Objects.equals(this.description, serviceCategory.description)
				&& Objects.equals(this.isRoot, serviceCategory.isRoot)
				&& Objects.equals(this.lastUpdate, serviceCategory.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCategory.lifecycleStatus)
				&& Objects.equals(this.name, serviceCategory.name)
				&& Objects.equals(this.parentId, serviceCategory.parentId)
				&& Objects.equals(this.version, serviceCategory.version)
				&& Objects.equals(this.category, serviceCategory.category)
				&& Objects.equals(this.serviceCandidate, serviceCategory.serviceCandidate)
				&& Objects.equals(this.validFor, serviceCategory.validFor)
				&& Objects.equals(this.baseType, serviceCategory.baseType)
				&& Objects.equals(this.schemaLocation, serviceCategory.schemaLocation)
				&& Objects.equals(this.type, serviceCategory.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, description, isRoot, lastUpdate, lifecycleStatus, name, parentId, version,
				category, serviceCandidate, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCategory {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
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
}
