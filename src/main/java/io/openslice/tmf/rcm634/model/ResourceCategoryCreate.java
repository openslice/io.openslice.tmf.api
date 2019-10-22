package io.openslice.tmf.rcm634.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href
 */
@ApiModel(description = "The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceCategoryCreate  extends ResourceCategoryUpdate {
  
  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;


  public ResourceCategoryCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the category
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

  public ResourceCategoryCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the category
   * @return description
  **/
  @ApiModelProperty(value = "Description of the category")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceCategoryCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The (class) type of this category
   * @return type
  **/
  @ApiModelProperty(value = "The (class) type of this category")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceCategoryCreate schemalLocation(String schemalLocation) {
    this.schemalLocation = schemalLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing this REST resource
   * @return schemalLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing this REST resource")


  public String getSchemalLocation() {
    return schemalLocation;
  }

  public void setSchemalLocation(String schemalLocation) {
    this.schemalLocation = schemalLocation;
  }

  public ResourceCategoryCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Immediate base class type of this category
   * @return baseType
  **/
  @ApiModelProperty(value = "Immediate base class type of this category")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceCategoryCreate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Category version
   * @return version
  **/
  @ApiModelProperty(value = "Category version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ResourceCategoryCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the category is valid
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

  public ResourceCategoryCreate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ResourceCategoryCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
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

  public ResourceCategoryCreate parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * Unique identifier of the parent category
   * @return parentId
  **/
  @ApiModelProperty(value = "Unique identifier of the parent category")


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public ResourceCategoryCreate isRoot(Boolean isRoot) {
    this.isRoot = isRoot;
    return this;
  }

  /**
   * If true, this Boolean indicates that the category is a root of categories
   * @return isRoot
  **/
  @ApiModelProperty(value = "If true, this Boolean indicates that the category is a root of categories")


  public Boolean isIsRoot() {
    return isRoot;
  }

  public void setIsRoot(Boolean isRoot) {
    this.isRoot = isRoot;
  }

  public ResourceCategoryCreate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCategoryCreate addCategoryItem(ResourceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ResourceCategoryRef> category) {
    this.category = category;
  }

  public ResourceCategoryCreate resourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
    return this;
  }

  public ResourceCategoryCreate addResourceCandidateItem(ResourceCandidateRef resourceCandidateItem) {
    if (this.resourceCandidate == null) {
      this.resourceCandidate = new ArrayList<>();
    }
    this.resourceCandidate.add(resourceCandidateItem);
    return this;
  }

  /**
   * Get resourceCandidate
   * @return resourceCandidate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceCandidateRef> getResourceCandidate() {
    return resourceCandidate;
  }

  public void setResourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceCategoryCreate resourceCategoryCreate = (ResourceCategoryCreate) o;
    return Objects.equals(this.name, resourceCategoryCreate.name) &&
        Objects.equals(this.description, resourceCategoryCreate.description) &&
        Objects.equals(this.type, resourceCategoryCreate.type) &&
        Objects.equals(this.schemalLocation, resourceCategoryCreate.schemalLocation) &&
        Objects.equals(this.baseType, resourceCategoryCreate.baseType) &&
        Objects.equals(this.version, resourceCategoryCreate.version) &&
        Objects.equals(this.validFor, resourceCategoryCreate.validFor) &&
        Objects.equals(this.lifecycleStatus, resourceCategoryCreate.lifecycleStatus) &&
        Objects.equals(this.lastUpdate, resourceCategoryCreate.lastUpdate) &&
        Objects.equals(this.parentId, resourceCategoryCreate.parentId) &&
        Objects.equals(this.isRoot, resourceCategoryCreate.isRoot) &&
        Objects.equals(this.category, resourceCategoryCreate.category) &&
        Objects.equals(this.resourceCandidate, resourceCategoryCreate.resourceCandidate) &&
        Objects.equals(this.relatedParty, resourceCategoryCreate.relatedParty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemalLocation, baseType, version, validFor, lifecycleStatus, lastUpdate, parentId, isRoot, category, resourceCandidate, relatedParty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategoryCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemalLocation: ").append(toIndentedString(schemalLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    resourceCandidate: ").append(toIndentedString(resourceCandidate)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

