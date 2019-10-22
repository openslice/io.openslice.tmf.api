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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (resource) category resource is used to group resource candidates in
 * logical containers. Categories can contain other categories.
 */
@ApiModel(description = "The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Entity(name = "ResourceCategory")
public class ResourceCategory extends BaseEntity {

	@JsonProperty("id")
	private String id = null;


	@JsonProperty("parentId")
	private String parentId = null;

	@JsonProperty("isRoot")
	private Boolean isRoot = null;

	@ManyToMany(  cascade = {  CascadeType.ALL } )
	@JoinTable()	
	@JsonIgnore
	private Set<ResourceCategory> categoryObj = new HashSet<>();
	
	

	@ManyToMany(cascade = {  CascadeType.ALL } )
	@JoinTable()	
	@JsonIgnore
	private Set<ResourceCandidate> resourceCandidateObj = new HashSet<>();

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
	@ApiModelProperty(value = "Unique identifier of the parent category")

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
	@ApiModelProperty(value = "If true, this Boolean indicates that the category is a root of categories")

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
	@ApiModelProperty(value = "List of child categories in the tree for in this category")
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
	@ApiModelProperty(value = "List of resource candidates associated with this category")

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

	@Override
	public int hashCode() {
		return Objects.hash(uuid, id, href, name, description, type,  baseType, version, validFor,
				lifecycleStatus, lastUpdate, parentId, isRoot, getCategoryRefs(), getResourceCandidateRefs());
	}

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
