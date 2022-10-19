package io.openslice.tmf.rpm685.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * manages resource capacity with the resource state
 */
@ApiModel(description = "manages resource capacity with the resource state")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")

@Entity(name = "ResourcePool")
public class ResourcePool extends BaseEntity {


	@JsonProperty("id")
	protected String id = null;
	

	@JsonProperty("capacity")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resr_capacuuid", referencedColumnName = "uuid")
	private Capacity capacity = null;
	
	
	
	
//	@JsonProperty("resourceCollection")
//	@Valid
//	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH })
//	@JoinTable()
//	@JsonIgnore
//	private Set<ResourceCollectionRef> resourceCollection = new HashSet<>();

	

	/**
	 * Unique identifier of this REST resource
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of this REST resource")

	public String getId() {
		id = uuid;
		return uuid;
	}
	
	
	
	/**
	 * @return the capacity
	 */
	public Capacity getCapacity() {
		return capacity;
	}



	/**
	 * @param capacity the capacity to set
	 */
	public ResourcePool setCapacity( Capacity capacity) {
		this.capacity = capacity;
		return this;
	}





//	public ResourcePool resourceCollection(Set<ResourceCollectionRef> resourceCollection) {
//		this.resourceCollection = resourceCollection;
//		return this;
//	}
//
//	public ResourcePool addResourceCollectionItem(ResourceCollectionRef resourceCollectionItem) {
//		if (this.resourceCollection == null) {
//			this.resourceCollection = new HashSet<>();
//		}
//		this.resourceCollection.add(resourceCollectionItem);
//		return this;
//	}
//
//	/**
//	 * Get resourceCollection
//	 * 
//	 * @return resourceCollection
//	 **/
//	@ApiModelProperty(value = "")
//	@Valid
//	public Set<ResourceCollectionRef> getResourceCollection() {
//		return resourceCollection;
//	}
//
//	public void setResourceCollection(Set<ResourceCollectionRef> resourceCollection) {
//		this.resourceCollection = resourceCollection;
//	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourcePool resourcePool = (ResourcePool) o;
		return Objects.equals(this.description, resourcePool.description)
				&& Objects.equals(this.href, resourcePool.href); 
//				&& Objects.equals(this.resourceCollection, resourcePool.resourceCollection);
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseType, schemaLocation, type, description, href, id
//				, resourceCollection
				);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourcePool {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(  baseType )).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString( type)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
//		sb.append("    resourceCollection: ").append(toIndentedString(resourceCollection)).append("\n");
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
