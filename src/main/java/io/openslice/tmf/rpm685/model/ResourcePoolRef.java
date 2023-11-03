package io.openslice.tmf.rpm685.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

/**
 * manages resource capacity with the resource state
 */
@Schema(description = "manages resource capacity with the resource state")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Entity(name = "ResourcePoolRef")
@JsonIgnoreProperties({ "uuid" })
public class ResourcePoolRef extends BaseRootEntity {
	@JsonProperty("@referredType")
	private String _atReferredType = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("resources")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceRef> resources = new HashSet<>();

	public ResourcePoolRef _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * A string. Indicates the type of the referred object. This attribute is to be
	 * used when the object is representing a reference to an existing object
	 * instead of the of the object itself.
	 * 
	 * @return _atReferredType
	 **/
	@Schema(description = "A string. Indicates the type of the referred object. This attribute is to be used when the object is representing a reference to an existing object instead of the of the object itself.")

	public String getAtReferredType() {
		return _atReferredType;
	}

	public void setAtReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
	}

	public ResourcePoolRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A string. Identifier of an instance of the Resource Pool.
	 * 
	 * @return id
	 **/
	@Schema(description = "A string. Identifier of an instance of the Resource Pool.")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourcePoolRef resources(Set<ResourceRef> resourceCollection) {
		this.resources = resourceCollection;
		return this;
	}

	public ResourcePoolRef addResourcesItem(ResourceRef resourceCollectionItem) {
		if (this.resources == null) {
			this.resources = new HashSet<>();
		}
		this.resources.add(resourceCollectionItem);
		return this;
	}

	/**
	 * Get resourceCollection
	 * 
	 * @return resourceCollection
	 **/
	@Schema(description = "")
	@Valid
	public Set<ResourceRef> getResources() {
		return resources;
	}

	public void setResources(Set<ResourceRef> resourceCollection) {
		this.resources = resourceCollection;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourcePoolRef resourcePoolRef = (ResourcePoolRef) o;
		return Objects.equals(this._atReferredType, resourcePoolRef._atReferredType)
				&& Objects.equals(this.href, resourcePoolRef.href) && Objects.equals(this.id, resourcePoolRef.id)
				&& Objects.equals(this.resources, resourcePoolRef.resources);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atReferredType, href, id, resources);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourcePoolRef {\n");

		sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    resourceCollection: ").append(toIndentedString(resources)).append("\n");
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
