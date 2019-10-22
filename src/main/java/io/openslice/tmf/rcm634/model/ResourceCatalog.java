package io.openslice.tmf.rcm634.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.scm633.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The root entity for resource catalog management. A resource catalog is a
 * group of resource specifications made available through resource candidates
 * that an organization provides to the consumers (internal consumers like its
 * employees or B2B customers or B2C customers).
 */
@ApiModel(description = "The root entity for resource catalog management. A resource catalog is a group of resource specifications made available through resource candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Entity(name = "ResourceCatalog")
public class ResourceCatalog extends BaseEntity {

	@JsonProperty("id")
	protected String id = null;


	@Transient
	@JsonProperty("relatedParty")
	@Valid
	private List<RelatedParty> relatedParty = null;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable()
	@JsonIgnore
	private Set<ResourceCategory> categoryObj = new HashSet<>();

	public ResourceCatalog id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the Catalog
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the Catalog")

	/**
	 * @return the id
	 */
	public String getId() {
		return uuid;
	}

	public ResourceCatalog relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ResourceCatalog addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Get relatedParty
	 * 
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
	
	
	/**
	 * List of service categories associated with this catalog
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "List of service categories associated with this catalog")
	@Transient
	@JsonProperty("category")
	@Valid
	public List<ResourceCategoryRef> getCategoryRefs() {

		List<ResourceCategoryRef> category = new ArrayList<>();
		
		for (ResourceCategory serviceCategory : categoryObj) {
			ResourceCategoryRef scr = new ResourceCategoryRef();
			scr.setId( serviceCategory.getId());
			scr.setName( serviceCategory.getName());
			scr.setBaseType( ResourceCategoryRef.class.getName() );
			category.add(scr);
			
		}
		
		return category;
	}
	
	/**
	 * @param crefs
	 */
	public void  setCategoryRefs( List<ResourceCategoryRef> crefs){
		for (ResourceCategoryRef serviceCategoryRef : crefs) {
			ResourceCategory e = new ResourceCategory();
			e.setUuid( serviceCategoryRef.getId() );
			e.setName(serviceCategoryRef.getName());
			categoryObj.add(e );
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



	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceCatalog resourceCatalog = (ResourceCatalog) o;
		return Objects.equals(this.id, resourceCatalog.id) && Objects.equals(this.href, resourceCatalog.href)
				&& Objects.equals(this.name, resourceCatalog.name)
				&& Objects.equals(this.description, resourceCatalog.description)
				&& Objects.equals(this.type, resourceCatalog.type)
				&& Objects.equals(this.schemaLocation, resourceCatalog.schemaLocation)
				&& Objects.equals(this.baseType, resourceCatalog.baseType)
				&& Objects.equals(this.version, resourceCatalog.version)
				&& Objects.equals(this.validFor, resourceCatalog.validFor)
				&& Objects.equals(this.lastUpdate, resourceCatalog.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceCatalog.lifecycleStatus)
				&& Objects.equals(this.relatedParty, resourceCatalog.relatedParty)
				&& Objects.equals(this.getCategoryRefs(), resourceCatalog.getCategoryRefs());
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, id, href, name, description, type, schemaLocation, baseType, version, validFor,
				lastUpdate, lifecycleStatus, relatedParty, getCategoryRefs());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceCatalog {\n");

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
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    category: ").append(toIndentedString( getCategoryRefs() )).append("\n");
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

	public void addCategory(ResourceCategory cat) {
		if (!categoryObj.contains(cat) ) {
			categoryObj.add(cat);
		}
		
	}
}
