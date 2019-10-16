package io.openslice.tmf.scm.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The root entity for service catalog management. A service catalog is a group
 * of service specifications made available through service candidates that an
 * organization provides to the consumers (internal consumers like its employees
 * or B2B customers or B2C customers). A service catalog typically includes
 * name, description and time period that is valid for. It will have a list of
 * ServiceCandidate catalog items. A ServiceCandidate is an entity that makes a
 * ServiceSpecification available to a catalog. A ServiceCandidate and its
 * associated ServiceSpecification may be \&quot;published\&quot; - made visible
 * -in any number of ServiceCatalogs, or in none.
 */
@ApiModel(description = "The root entity for service catalog management. A service catalog is a group of service specifications made available through service candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers).  A service catalog typically includes name, description and time period that is valid for. It will have a list of ServiceCandidate catalog items. A ServiceCandidate is an entity that makes a ServiceSpecification available to a catalog. A ServiceCandidate and its associated ServiceSpecification may be \"published\" - made visible -in any number of ServiceCatalogs, or in none.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceCatalog")
@Table( name = "ServiceCatalog" )
public class ServiceCatalog extends BaseEntity{

		
	
		
	@ManyToMany(cascade = {  CascadeType.ALL } )
	@JoinTable()	
	@JsonIgnore
	private Set<ServiceCategory> categoryObj = new HashSet<>();
	
	

	@Transient
	@JsonProperty("relatedParty")
	@Valid
	private List<RelatedParty> relatedParty = null;


	public ServiceCatalog() {
		super();
		this.type = "ServiceCatalog";
		this.baseType = "BaseEntity";
	}

	@JsonProperty("id")
	protected String id = null;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return uuid;
	}

//	/**
//	 * @param id the id to set
//	 */
//	public void setId(String id) {		
//		this.id = id;
//	}

	/**
	 * List of service categories associated with this catalog
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "List of service categories associated with this catalog")
	@Transient
	@JsonProperty("category")
	@Valid
	public List<ServiceCategoryRef> getCategoryRefs() {

		List<ServiceCategoryRef> category = new ArrayList<>();
		
		for (ServiceCategory serviceCategory : categoryObj) {
			ServiceCategoryRef scr = new ServiceCategoryRef();
			scr.setId( serviceCategory.getId());
			scr.setName( serviceCategory.getName());
			scr.setBaseType( ServiceCategoryRef.class.getName() );
			category.add(scr);
			
		}
		
		return category;
	}
	
	/**
	 * @param crefs
	 */
	public void  setCategoryRefs( List<ServiceCategoryRef> crefs){
		for (ServiceCategoryRef serviceCategoryRef : crefs) {
			ServiceCategory e = new ServiceCategory();
			e.setUuid( serviceCategoryRef.getId() );
			e.setName(serviceCategoryRef.getName());
			categoryObj.add(e );
		}
	}
	
	/**
	 * @return the categoryObj
	 */
	public Set<ServiceCategory> getCategoryObj() {
		return categoryObj;
	}

	/**
	 * @param categoryObj the categoryObj to set
	 */
	public void setCategoryObj(Set<ServiceCategory> categoryObj) {
		this.categoryObj = categoryObj;
	}
	

//	public void setCategory(List<ServiceCategoryRef> category) {
//		this.category = category;
//	}

	public ServiceCatalog relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceCatalog addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<RelatedParty>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * List of parties or party roles related to this category
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "List of parties or party roles related to this category")

	@Valid

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCatalog serviceCatalog = (ServiceCatalog) o;
		return Objects.equals(this.id, serviceCatalog.id) && Objects.equals(this.href, serviceCatalog.href)
				&& Objects.equals(this.description, serviceCatalog.description)
				&& Objects.equals(this.lastUpdate, serviceCatalog.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCatalog.lifecycleStatus)
				&& Objects.equals(this.name, serviceCatalog.name)
				&& Objects.equals(this.version, serviceCatalog.version)
				&& Objects.equals(this.getCategoryRefs(), serviceCatalog.getCategoryRefs())
				&& Objects.equals(this.relatedParty, serviceCatalog.relatedParty)
				&& Objects.equals(this.validFor, serviceCatalog.validFor)
				&& Objects.equals(this.baseType, serviceCatalog.baseType)
				&& Objects.equals(this.schemaLocation, serviceCatalog.schemaLocation)
				&& Objects.equals(this.type, serviceCatalog.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, description, lastUpdate, lifecycleStatus, name, version, this.getCategoryRefs(), relatedParty,
				validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCatalog {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

	

	public void addCategory(ServiceCategory servcat) {
		if (!categoryObj.contains(servcat) ) {
			categoryObj.add(servcat);
		}
		
	}
	
}
