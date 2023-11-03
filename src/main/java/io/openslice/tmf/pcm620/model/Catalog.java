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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;

/**
 * A collection of Product Offerings, intended for a specific
 * DistributionChannel, enhanced with additional information such as SLA
 * parameters, invoicing and shipping details
 */
@Schema(description = "A collection of Product Offerings, intended for a specific DistributionChannel, enhanced with additional information such as SLA parameters, invoicing and shipping details")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProductCatalog")
@Table(name = "ProductCatalog")
public class Catalog  extends BaseEntity {

	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("catalogType")
	private String catalogType = null;



	
	@ManyToMany(cascade = {  CascadeType.DETACH } )
	@JoinTable()	
	@JsonIgnore
	private Set<Category> categoryObj = new HashSet<>();
	

	@Transient
	@JsonProperty("relatedParty")
	@Valid
	private List<RelatedParty> relatedParty = null;

	public Catalog id(String id) {
		this.id = id;
		return this;
	}
	
	/**
	 * List of service categories associated with this catalog
	 * 
	 * @return category
	 **/
	@Schema(description = "List of  categories associated with this catalog")
	@Transient
	@JsonProperty("category")
	@Valid
	public List<CategoryRef> getCategoryRefs() {

		List<CategoryRef> category = new ArrayList<>();
		
		for (Category Category : categoryObj) {
			CategoryRef scr = new CategoryRef();
			scr.setId( Category.getId());
			scr.setName( Category.getName());
			scr.setBaseType( CategoryRef.class.getName() );
			category.add(scr);
			
		}
		
		return category;
	}
	
	/**
	 * @param crefs
	 */
	public void  setCategoryRefs( List<CategoryRef> crefs){
		for (CategoryRef CategoryRef : crefs) {
			Category e = new Category();
			e.setUuid( CategoryRef.getId() );
			e.setName(CategoryRef.getName());
			categoryObj.add(e );
		}
	}
	
	/**
	 * @return the categoryObj
	 */
	public Set<Category> getCategoryObj() {
		return categoryObj;
	}

	/**
	 * @param categoryObj the categoryObj to set
	 */
	public void setCategoryObj(Set<Category> categoryObj) {
		this.categoryObj = categoryObj;
	}

	/**
	 * Unique identifier of the Catalog
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the Catalog")

	public String getId() {
		return uuid;
	}


	public Catalog catalogType(String catalogType) {
		this.catalogType = catalogType;
		return this;
	}

	/**
	 * Indicates if the catalog is a product, service or resource catalog
	 * 
	 * @return catalogType
	 **/
	@Schema(description = "Indicates if the catalog is a product, service or resource catalog")

	public String getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}

	



	public Catalog relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public Catalog addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * List of parties involved in this catalog
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "List of parties involved in this catalog")

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
		Catalog catalog = (Catalog) o;
		return Objects.equals(this.id, catalog.id) && Objects.equals(this.href, catalog.href)
				&& Objects.equals(this.catalogType, catalog.catalogType)
				&& Objects.equals(this.description, catalog.description)
				&& Objects.equals(this.lastUpdate, catalog.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, catalog.lifecycleStatus)
				&& Objects.equals(this.name, catalog.name) && Objects.equals(this.version, catalog.version)
				&& Objects.equals(this.getCategoryRefs(), catalog.getCategoryRefs())
				&& Objects.equals(this.relatedParty, catalog.relatedParty)
				&& Objects.equals(this.validFor, catalog.validFor) && Objects.equals(this.baseType, catalog.baseType)
				&& Objects.equals(this.schemaLocation, catalog.schemaLocation)
				&& Objects.equals(this.type, catalog.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, catalogType, description, lastUpdate, lifecycleStatus, name, version, category,
//				relatedParty, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Catalog {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    catalogType: ").append(toIndentedString(catalogType)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    category: ").append(toIndentedString(this.getCategoryRefs())).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

	public void addCategory(Category servcat) {
		if (!categoryObj.contains(servcat) ) {
			categoryObj.add(servcat);
		}
		
		
	}
}
