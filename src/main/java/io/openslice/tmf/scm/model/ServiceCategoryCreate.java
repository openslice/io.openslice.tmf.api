package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.ServiceCandidateRef;
import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories. Skipped
 * properties: id,href
 */
@ApiModel(description = "The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCategoryCreate {
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("isRoot")
	private Boolean isRoot = null;

	@JsonProperty("lastUpdate")
	private OffsetDateTime lastUpdate = null;

	@JsonProperty("lifecycleStatus")
	private String lifecycleStatus = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("parentId")
	private String parentId = null;

	@JsonProperty("catalogId")
	private String catalogId = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("category")
	@Valid
	private List<ServiceCategoryRef> category = null;

	@JsonProperty("serviceCandidate")
	@Valid
	private List<ServiceCandidateRef> serviceCandidate = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("@baseType")
	private String baseType = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	@JsonProperty("@type")
	private String type = null;

	public ServiceCategoryCreate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of the category
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Description of the category")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceCategoryCreate isRoot(Boolean isRoot) {
		this.isRoot = isRoot;
		return this;
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
		this.isRoot = isRoot;
	}

	public ServiceCategoryCreate lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	/**
	 * Date and time of the last update
	 * 
	 * @return lastUpdate
	 **/
	@ApiModelProperty(value = "Date and time of the last update")

	@Valid

	public OffsetDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public ServiceCategoryCreate lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public ServiceCategoryCreate name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the category
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "Name of the category")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ServiceCategoryCreate parentId(String parentId) {
		this.parentId = parentId;
		return this;
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

	public ServiceCategoryCreate version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * ServiceCategory version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "ServiceCategory version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServiceCategoryCreate category(List<ServiceCategoryRef> category) {
		this.category = category;
		return this;
	}

	public ServiceCategoryCreate addCategoryItem(ServiceCategoryRef categoryItem) {
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

	public ServiceCategoryCreate serviceCandidate(List<ServiceCandidateRef> serviceCandidate) {
		this.serviceCandidate = serviceCandidate;
		return this;
	}

	public ServiceCategoryCreate addServiceCandidateItem(ServiceCandidateRef serviceCandidateItem) {
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

	public ServiceCategoryCreate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the category is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the category is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ServiceCategoryCreate baseType(String baseType) {
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

	public ServiceCategoryCreate schemaLocation(String schemaLocation) {
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

	public ServiceCategoryCreate type(String type) {
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

	/**
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCategoryCreate serviceCategoryCreate = (ServiceCategoryCreate) o;
		return Objects.equals(this.description, serviceCategoryCreate.description)
				&& Objects.equals(this.isRoot, serviceCategoryCreate.isRoot)
				&& Objects.equals(this.lastUpdate, serviceCategoryCreate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCategoryCreate.lifecycleStatus)
				&& Objects.equals(this.name, serviceCategoryCreate.name)
				&& Objects.equals(this.parentId, serviceCategoryCreate.parentId)
				&& Objects.equals(this.version, serviceCategoryCreate.version)
				&& Objects.equals(this.category, serviceCategoryCreate.category)
				&& Objects.equals(this.serviceCandidate, serviceCategoryCreate.serviceCandidate)
				&& Objects.equals(this.validFor, serviceCategoryCreate.validFor)
				&& Objects.equals(this.baseType, serviceCategoryCreate.baseType)
				&& Objects.equals(this.schemaLocation, serviceCategoryCreate.schemaLocation)
				&& Objects.equals(this.type, serviceCategoryCreate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, isRoot, lastUpdate, lifecycleStatus, name, parentId, version, category,
				serviceCandidate, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCategoryCreate {\n");

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
