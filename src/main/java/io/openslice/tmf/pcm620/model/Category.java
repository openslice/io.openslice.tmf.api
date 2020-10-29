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
package io.openslice.tmf.pcm620.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The category resource is used to group product offerings, service and
 * resource candidates in logical containers. Categories can contain other
 * categories and/or product offerings, resource or service candidates.
 */
@ApiModel(description = "The category resource is used to group product offerings, service and resource candidates in logical containers. Categories can contain other categories and/or product offerings, resource or service candidates.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProductCategory")
@Table(name = "ProductCategory")
public class Category extends BaseEntity {

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isRoot")
	private Boolean isRoot = null;

	@JsonProperty("parentId")
	private String parentId = null;

//	@JsonProperty("productOffering")
//	@Valid
//	private List<ProductOfferingRef> productOffering = null;


	@ManyToMany(cascade = {  CascadeType.MERGE, CascadeType.REMOVE } )
	@JoinTable()	
	@JsonIgnore
	private Set<ProductOffering> productOfferingObj = new HashSet<>();
	
	


	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinTable()	
	@JsonIgnore
	private Set<Category> subCategoryObj = new HashSet<>();
	
	
//	@JsonProperty("subCategory")
//	@Valid
//	private List<CategoryRef> subCategory = null;
	

	public Category id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the category
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the category")

	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}

	public Category isRoot(Boolean isRoot) {
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

	public Category parentId(String parentId) {
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

	

	/**
	 * A product offering represents entities that are orderable from the provider
	 * of the catalog, this resource includes pricing information.
	 * 
	 * @return productOffering
	 **/
	@ApiModelProperty(value = "A product offering represents entities that are orderable from the provider of the catalog, this resource includes pricing information.")

	@Valid
	@JsonProperty("productOffering")

	public List<ProductOfferingRef> getProductOfferingRefs() {
		
		List<ProductOfferingRef> scref = new ArrayList<>();
		
		for (ProductOffering sc : productOfferingObj) {
			ProductOfferingRef scr = new ProductOfferingRef();
			scr.setId( sc.getId());
			scr.setName( sc.getName());
			scr.setBaseType( ProductOfferingRef.class.getName() );
			scref.add(scr);
		}
		
		
		return scref;
	}

	


	/**
	 * List of child categories in the tree for in this category
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "List of child categories in the tree for in this category")
	@Transient
	@JsonProperty("subCategory")
	@Valid
	public List<CategoryRef> getCategoryRefs() {

		List<CategoryRef> category = new ArrayList<>();
		
		for (Category sCategory : subCategoryObj) {
			CategoryRef scr = new CategoryRef();
			scr.setId( sCategory.getId());
			scr.setName( sCategory.getName());
			scr.setBaseType( CategoryRef.class.getName() );
			category.add(scr);
			
		}
		
		return category;
	}
	
	
	/**
	 * @param categoryObj the categoryObj to set
	 */
	@JsonProperty("subCategory")
	public void setCategoryObj(List<CategoryRef> alist) {
		this.subCategoryObj.clear();
		for (CategoryRef categoryRef : alist) {
			Category sc = new Category();
			sc.setUuid( categoryRef.getId());
			sc.setName(categoryRef.getName());
			sc.setBaseType(categoryRef.getBaseType());
			this.subCategoryObj.add(sc);
		}
	}
	
	/**
	 * @return the categoryObj
	 */
	public Set<Category> getCategoryObj() {
		return subCategoryObj;
	}

	/**
	 * @param categoryObj the categoryObj to set
	 */
	public void setCategoryObj(Set< Category> categoryObj) {
		this.subCategoryObj = categoryObj;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Category category = (Category) o;
		return Objects.equals(this.id, category.id) && Objects.equals(this.href, category.href)
				&& Objects.equals(this.description, category.description)
				&& Objects.equals(this.isRoot, category.isRoot) && Objects.equals(this.lastUpdate, category.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, category.lifecycleStatus)
				&& Objects.equals(this.name, category.name) && Objects.equals(this.parentId, category.parentId)
				&& Objects.equals(this.version, category.version)
				&& Objects.equals(this.productOfferingObj , category.productOfferingObj)
				&& Objects.equals(this.subCategoryObj, category.subCategoryObj)
				&& Objects.equals(this.validFor, category.validFor) && Objects.equals(this.baseType, category.baseType)
				&& Objects.equals(this.schemaLocation, category.schemaLocation)
				&& Objects.equals(this.type, category.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, description, isRoot, lastUpdate, lifecycleStatus, name, parentId, version,
//				productOffering, subCategory, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Category {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    productOffering: ").append(toIndentedString(productOfferingObj)).append("\n");
		sb.append("    subCategory: ").append(toIndentedString(subCategoryObj)).append("\n");
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
