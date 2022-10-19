package io.openslice.tmf.rpm685.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the extract task resource for resource pool management
 */
@ApiModel(description = "the extract task resource for resource pool management")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class Extract {
	@JsonProperty("href")
	private String href = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("@type")
	private String _atType = null;

	@JsonProperty("@schemaLocation")
	private String _atSchemaLocation = null;

	@JsonProperty("@baseType")
	private String _atBaseType = null;
	
	@JsonProperty("capacity")
	private Capacity capacity = null;

	@JsonProperty("resourcePool")
	private ResourcePoolRef resourcePool = null;

	
	
	
	/**
	 * @return the capacity
	 */
	public Capacity getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity( Capacity capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the resourcePool
	 */
	public ResourcePoolRef getResourcePool() {
		return resourcePool;
	}

	/**
	 * @param resourcePool the resourcePool to set
	 */
	public void setResourcePool(ResourcePoolRef resourcePool) {
		this.resourcePool = resourcePool;
	}

	public Extract href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * A string. Hyperlink to access the availableCheck task for resource pool
	 * Management
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "A string. Hyperlink to access the availableCheck task for resource pool Management")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Extract id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A string. Identifier of an instance of the extract task for resource pool
	 * Management
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "A string. Identifier of an instance of the extract task for resource pool Management")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Extract _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * The class type of the actual resource (for type extension).
	 * 
	 * @return _atType
	 **/
	@ApiModelProperty(value = "The class type of the actual resource (for type extension).")

	public String getAtType() {
		return _atType;
	}

	public void setAtType(String _atType) {
		this._atType = _atType;
	}

	public Extract _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A link to the schema describing a resource (for type extension).
	 * 
	 * @return _atSchemaLocation
	 **/
	@ApiModelProperty(value = "A link to the schema describing a resource (for type extension).")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public Extract _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * The base type for use in polymorphic collections
	 * 
	 * @return _atBaseType
	 **/
	@ApiModelProperty(value = "The base type for use in polymorphic collections")

	public String getAtBaseType() {
		return _atBaseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Extract extract = (Extract) o;
		return Objects.equals(this.href, extract.href) && Objects.equals(this.id, extract.id)
				&& Objects.equals(this._atType, extract._atType)
				&& Objects.equals(this._atSchemaLocation, extract._atSchemaLocation)
				&& Objects.equals(this._atBaseType, extract._atBaseType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(href, id, _atType, _atSchemaLocation, _atBaseType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Extract {\n");

		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
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
