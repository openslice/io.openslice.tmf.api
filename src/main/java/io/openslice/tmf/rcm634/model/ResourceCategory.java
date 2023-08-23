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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;


/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories.
 */
@Schema(description = "The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "ResourceCategory")
public class ResourceCategory extends BaseEntity {

	@JsonProperty("id")
	protected String id = null;


	@JsonProperty("parentId")
	private String parentId = null;

	@JsonProperty("isRoot")
	private Boolean isRoot = null;

	@OneToMany( cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable()	
	@JsonIgnore
	private Set<ResourceCategory> categoryObj = new HashSet<>();
	
	

	@ManyToMany( cascade = {  CascadeType.MERGE, CascadeType.REMOVE } )
	@JoinTable()	
	@JsonIgnore
	private Set<ResourceCandidate> resourceCandidateObj = new HashSet<>();

	/**
	 * Unique identifier of the category
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the category")

	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}

	


	public ResourceCategory parentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	/**
	 * Unique identifier of the parent category
	 * 
	 * @return parentId
	 **/
	@Schema(description = "Unique identifier of the parent category")

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public ResourceCategory isRoot(Boolean isRoot) {
		this.isRoot = isRoot;
		return this;
	}

	/**
	 * If true, this Boolean indicates that the category is a root of categories
	 * 
	 * @return isRoot
	 **/
	@Schema(description = "If true, this Boolean indicates that the category is a root of categories")

	public Boolean isIsRoot() {
		return isRoot;
	}

	public void setIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}


	

	/**
	 * List of child categories in the tree for in this category
	 * 
	 * @return category
	 **/
	@Schema(description = "List of child categories in the tree for in this category")
	@Transient
	@JsonProperty("category")
	@Valid
	public List<ResourceCategoryRef> getCategoryRefs() {

		List<ResourceCategoryRef> category = new ArrayList<>();
		
		for (ResourceCategory resourceCategory : categoryObj) {
			ResourceCategoryRef scr = new ResourceCategoryRef();
			scr.setId( resourceCategory.getId());
			scr.setName( resourceCategory.getName());
			scr.setBaseType( ResourceCategoryRef.class.getName() );
			category.add(scr);
			
		}
		
		return category;
	}
	
	/**
	 * @param categoryObj the categoryObj to set
	 */
	@JsonProperty("category")
	public void setCategoryObj(List<ResourceCategoryRef> alist) {
		this.categoryObj.clear();
		for (ResourceCategoryRef resCategoryRef : alist) {
			ResourceCategory sc = new ResourceCategory();
			sc.setUuid( resCategoryRef.getId());
			sc.setName(resCategoryRef.getName());
			sc.setBaseType(resCategoryRef.getBaseType());
			this.categoryObj.add(sc);
		}
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

	

	/**
	 * List of resource candidates associated with this category
	 * 
	 * @return resourceCandidate
	 **/
	@Schema(description = "List of resource candidates associated with this category")

	@Valid
	@JsonProperty("resourceCandidate")
	public List<ResourceCandidateRef> getResourceCandidateRefs() {
		
		List<ResourceCandidateRef> scref = new ArrayList<>();
		
		for (ResourceCandidate sc : resourceCandidateObj) {
			ResourceCandidateRef scr = new ResourceCandidateRef();
			scr.setId( sc.getId());
			scr.setName( sc.getName());
			scr.setVersion( sc.getVersion());
			scr.setBaseType( ResourceCategoryRef.class.getName() );
			scref.add(scr);
		}
		
		return scref;
	}

	

	/**
	 * @return the resourceCandidateObj
	 */
	public Set<ResourceCandidate> getResourceCandidateObj() {
		return resourceCandidateObj;
	}




	/**
	 * @param resourceCandidateObj the resourceCandidateObj to set
	 */
	public void setResourceCandidateObj(Set<ResourceCandidate> resourceCandidateObj) {
		this.resourceCandidateObj = resourceCandidateObj;
	}

	

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceCategory resourceCategory = (ResourceCategory) o;
		return Objects.equals(this.id, resourceCategory.id) && Objects.equals(this.href, resourceCategory.href)
				&& Objects.equals(this.name, resourceCategory.name)
				&& Objects.equals(this.description, resourceCategory.description)
				&& Objects.equals(this.type, resourceCategory.type)
				&& Objects.equals(this.baseType, resourceCategory.baseType)
				&& Objects.equals(this.version, resourceCategory.version)
				&& Objects.equals(this.validFor, resourceCategory.validFor)
				&& Objects.equals(this.lifecycleStatus, resourceCategory.lifecycleStatus)
				&& Objects.equals(this.lastUpdate, resourceCategory.lastUpdate)
				&& Objects.equals(this.parentId, resourceCategory.parentId)
				&& Objects.equals(this.isRoot, resourceCategory.isRoot)
				&& Objects.equals(this.getCategoryRefs(), resourceCategory.getCategoryRefs())
				&& Objects.equals(this.getResourceCandidateRefs(), resourceCategory.getResourceCandidateRefs());
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, id, href, name, description, type,  baseType, version, validFor,
//				lifecycleStatus, lastUpdate, parentId, isRoot, getCategoryRefs(), getResourceCandidateRefs());
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceCategory {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
		sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
		sb.append("    category: ").append(toIndentedString(getCategoryRefs())).append("\n");
		sb.append("    resourceCandidate: ").append(toIndentedString(getResourceCandidateRefs())).append("\n");
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
