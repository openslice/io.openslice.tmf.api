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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href
 */
@ApiModel(description = "ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

public class ResourceCandidateUpdate {
	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("description")
	protected String description = null;

	@JsonProperty("@type")
	protected String type = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("version")
	protected String version = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;

	@JsonProperty("lastUpdate")
	protected OffsetDateTime lastUpdate = null;

	@JsonProperty("lifecycleStatus")
	protected String lifecycleStatus = null;

	@JsonProperty("category")
	@Valid
	protected List<ResourceCategoryRef> category = null;

	@JsonProperty("resourceSpecification")
	protected ResourceSpecificationRef resourceSpecification = null;

	public ResourceCandidateUpdate name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name given to this REST resource
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name given to this REST resource")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceCandidateUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of this REST resource
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Description of this REST resource")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceCandidateUpdate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Class type of this REST resource
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "Class type of this REST resource")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ResourceCandidateUpdate schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * This field provides a link to the schema describing this REST resource
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "This field provides a link to the schema describing this REST resource")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ResourceCandidateUpdate baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * The (immediate) base class type of this REST resource
	 * 
	 * @return baseType
	 **/
	@ApiModelProperty(value = "The (immediate) base class type of this REST resource")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public ResourceCandidateUpdate version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * the version of resource candidate
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "the version of resource candidate")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ResourceCandidateUpdate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which this REST resource is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which this REST resource is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ResourceCandidateUpdate lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	/**
	 * Date and time of the last update of this REST resource
	 * 
	 * @return lastUpdate
	 **/
	@ApiModelProperty(value = "Date and time of the last update of this REST resource")

	@Valid

	public OffsetDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public ResourceCandidateUpdate lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status of the resource candidate.
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status of the resource candidate.")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public ResourceCandidateUpdate category(List<ResourceCategoryRef> category) {
		this.category = category;
		return this;
	}

	public ResourceCandidateUpdate addCategoryItem(ResourceCategoryRef categoryItem) {
		if (this.category == null) {
			this.category = new ArrayList<ResourceCategoryRef>();
		}
		this.category.add(categoryItem);
		return this;
	}

	/**
	 * Get category
	 * 
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

	public ResourceCandidateUpdate resourceSpecification(ResourceSpecificationRef resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
		return this;
	}

	/**
	 * Get resourceSpecification
	 * 
	 * @return resourceSpecification
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public ResourceSpecificationRef getResourceSpecification() {
		return resourceSpecification;
	}

	public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceCandidateUpdate resourceCandidateUpdate = (ResourceCandidateUpdate) o;
		return Objects.equals(this.name, resourceCandidateUpdate.name)
				&& Objects.equals(this.description, resourceCandidateUpdate.description)
				&& Objects.equals(this.type, resourceCandidateUpdate.type)
				&& Objects.equals(this.schemaLocation, resourceCandidateUpdate.schemaLocation)
				&& Objects.equals(this.baseType, resourceCandidateUpdate.baseType)
				&& Objects.equals(this.version, resourceCandidateUpdate.version)
				&& Objects.equals(this.validFor, resourceCandidateUpdate.validFor)
				&& Objects.equals(this.lastUpdate, resourceCandidateUpdate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceCandidateUpdate.lifecycleStatus)
				&& Objects.equals(this.category, resourceCandidateUpdate.category)
				&& Objects.equals(this.resourceSpecification, resourceCandidateUpdate.resourceSpecification);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate,
				lifecycleStatus, category, resourceSpecification);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceCandidateUpdate {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
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
