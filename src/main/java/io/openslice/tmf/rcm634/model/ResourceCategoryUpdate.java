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
package io.openslice.tmf.rcm634.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href,id,href
 */
@ApiModel(description = "The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href,id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceCategoryUpdate   {
  @JsonProperty("name")
protected String name = null;

  @JsonProperty("description")
  protected String description = null;

  @JsonProperty("@type")
  protected String type = null;

  @JsonProperty("@schemalLocation")
  protected String schemalLocation = null;

  @JsonProperty("@baseType")
  protected String baseType = null;

  @JsonProperty("version")
  protected String version = null;

  @JsonProperty("validFor")
  protected TimePeriod validFor = null;

  @JsonProperty("lifecycleStatus")
  protected String lifecycleStatus = null;


  @JsonProperty("parentId")
  protected String parentId = null;

  @JsonProperty("isRoot")
  protected Boolean isRoot = null;

  @JsonProperty("category")
  @Valid
  protected List<ResourceCategoryRef> category = null;

  @JsonProperty("resourceCandidate")
  @Valid
  protected List<ResourceCandidateRef> resourceCandidate = null;

  @JsonProperty("relatedParty")
  @Valid
  protected List<RelatedParty> relatedParty = null;

  public ResourceCategoryUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the category
   * @return name
  **/
  @ApiModelProperty(value = "Name of the category")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceCategoryUpdate description(String description) {
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

  public ResourceCategoryUpdate type(String type) {
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

  public ResourceCategoryUpdate schemalLocation(String schemalLocation) {
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

  public ResourceCategoryUpdate baseType(String baseType) {
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

  public ResourceCategoryUpdate version(String version) {
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

  public ResourceCategoryUpdate validFor(TimePeriod validFor) {
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

  public ResourceCategoryUpdate lifecycleStatus(String lifecycleStatus) {
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


  public ResourceCategoryUpdate parentId(String parentId) {
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

  public ResourceCategoryUpdate isRoot(Boolean isRoot) {
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

  public ResourceCategoryUpdate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCategoryUpdate addCategoryItem(ResourceCategoryRef categoryItem) {
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

  public ResourceCategoryUpdate resourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
    return this;
  }

  public ResourceCategoryUpdate addResourceCandidateItem(ResourceCandidateRef resourceCandidateItem) {
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

  public ResourceCategoryUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceCategoryUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceCategoryUpdate resourceCategoryUpdate = (ResourceCategoryUpdate) o;
    return Objects.equals(this.name, resourceCategoryUpdate.name) &&
        Objects.equals(this.description, resourceCategoryUpdate.description) &&
        Objects.equals(this.type, resourceCategoryUpdate.type) &&
        Objects.equals(this.schemalLocation, resourceCategoryUpdate.schemalLocation) &&
        Objects.equals(this.baseType, resourceCategoryUpdate.baseType) &&
        Objects.equals(this.version, resourceCategoryUpdate.version) &&
        Objects.equals(this.validFor, resourceCategoryUpdate.validFor) &&
        Objects.equals(this.lifecycleStatus, resourceCategoryUpdate.lifecycleStatus) &&
        Objects.equals(this.parentId, resourceCategoryUpdate.parentId) &&
        Objects.equals(this.isRoot, resourceCategoryUpdate.isRoot) &&
        Objects.equals(this.category, resourceCategoryUpdate.category) &&
        Objects.equals(this.resourceCandidate, resourceCategoryUpdate.resourceCandidate) &&
        Objects.equals(this.relatedParty, resourceCategoryUpdate.relatedParty);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(name, description, type, schemalLocation, baseType, version, validFor, lifecycleStatus, lastUpdate, parentId, isRoot, category, resourceCandidate, relatedParty);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategoryUpdate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemalLocation: ").append(toIndentedString(schemalLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
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

