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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ResourceCandidate is an entity that makes a resource specification available
 * to a catalog. A ResourceCandidate and its associated resource specification
 * may be published - made visible - in any number of resource catalogs, or in
 * none.
 */
@ApiModel(description = "ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")
@Entity(name = "ResourceCandidate")
public class ResourceCandidate extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@ManyToMany(mappedBy = "resourceCandidateObj", cascade = {CascadeType.MERGE,  CascadeType.DETACH} )
	@JsonIgnore
	private Set<ResourceCategory> categoryObj = new HashSet<>();

	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "resource_specid", referencedColumnName = "uuid")
	@JsonIgnore
	private ResourceSpecification resourceSpecificationObj = null;

	public ResourceCandidate() {
		super();
		this.type = "ResourceCandidate";
		this.baseType = "BaseEntity";
	}
	

	
	/**
	 * The resource specification implied by this candidate
	 * 
	 * @return resourceSpecification
	 **/
	@ApiModelProperty(value = "The resource specification implied by this candidate")

	@Transient
	@JsonProperty("resourceSpecification")
	@Valid
	public ResourceSpecificationRef getResourceSpecificationRef() {
		if ( this.resourceSpecificationObj != null )
		{
			ResourceSpecificationRef sref = new ResourceSpecificationRef();
			
			sref.setId(  this.resourceSpecificationObj.getUuid());
			sref.setName(  this.resourceSpecificationObj.getName() );
			sref.setVersion( this.resourceSpecificationObj.getVersion());
			sref.setBaseType(ResourceSpecificationRef.class.getName());
			return sref;			
		}
		
		return null;
	}

	
	/**
	 * @return the resourceSpecificationObj
	 */
	public ResourceSpecification getResourceSpecificationObj() {
		return resourceSpecificationObj;
	}




	/**
	 * @param resourceSpecificationObj the resourceSpecificationObj to set
	 */
	public void setResourceSpecificationObj(ResourceSpecification resourceSpecificationObj) {
		this.resourceSpecificationObj = resourceSpecificationObj;
	}




	/**
	 * The resource specification implied by this candidate
	 * 
	 * @return resourceSpecification
	 **/
	@ApiModelProperty(value = "The category specification implied by this candidate")

	@Transient
	@JsonProperty("category")
	@Valid
	public List<ResourceCategoryRef> getCategory() {

		List<ResourceCategoryRef> category = new ArrayList<>();

		for (ResourceCategory resourceCategory : categoryObj) {
			ResourceCategoryRef scr = new ResourceCategoryRef();
			scr.setId(resourceCategory.getId());
			scr.setName(resourceCategory.getName());
			scr.setBaseType(ResourceCategoryRef.class.getName());
			category.add(scr);
		}

		return category;
	}


	/**
	 * Unique identifier of this REST resource
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of this REST resource")

	public String getId() {
		return uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceCandidate resourceCandidate = (ResourceCandidate) o;
		return Objects.equals(this.id, resourceCandidate.id) && Objects.equals(this.href, resourceCandidate.href)
				&& Objects.equals(this.name, resourceCandidate.name)
				&& Objects.equals(this.description, resourceCandidate.description)
				&& Objects.equals(this.type, resourceCandidate.type)
				&& Objects.equals(this.schemaLocation, resourceCandidate.schemaLocation)
				&& Objects.equals(this.baseType, resourceCandidate.baseType)
				&& Objects.equals(this.version, resourceCandidate.version)
				&& Objects.equals(this.validFor, resourceCandidate.validFor)
				&& Objects.equals(this.lastUpdate, resourceCandidate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceCandidate.lifecycleStatus)
				&& Objects.equals(this.getCategory(), resourceCandidate.getCategory())
				&& Objects.equals(this.getResourceSpecificationRef(), resourceCandidate.getResourceSpecificationRef());
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, id, href, name, description, type, schemaLocation, baseType, version, validFor, lastUpdate,
//				lifecycleStatus, getCategory(), getResourceSpecificationRef());
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceCandidate {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    category: ").append(toIndentedString(getCategory())).append("\n");
		sb.append("    resourceSpecification: ").append(toIndentedString(getResourceSpecificationRef())).append("\n");
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
	public Set<ResourceCategory> getCategoryObj() {
		return categoryObj;
	}

	/**
	 * @param categoryObj the categoryObj to set
	 */
	public void setCategoryObj(Set<ResourceCategory> categoryObj) {
		this.categoryObj = categoryObj;
	}
}
