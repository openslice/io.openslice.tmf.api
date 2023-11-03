package io.openslice.tmf.rpm685.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * the push task resource for resource pool management
 */
@Schema(description = "the push task resource for resource pool management")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class Push {
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

	public Push href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * A string. Hyperlink to access the push task for resource pool Management
	 * 
	 * @return href
	 **/
	@Schema(description = "A string. Hyperlink to access the push task for resource pool Management")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Push id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A string. Identifier of an instance of the push task resource
	 * 
	 * @return id
	 **/
	@Schema(description = "A string. Identifier of an instance of the push task resource")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Push _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * The class type of the actual resource (for type extension).
	 * 
	 * @return _atType
	 **/
	@Schema(description = "The class type of the actual resource (for type extension).")

	public String getAtType() {
		return _atType;
	}

	public void setAtType(String _atType) {
		this._atType = _atType;
	}

	public Push _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A link to the schema describing a resource (for type extension).
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A link to the schema describing a resource (for type extension).")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public Push _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * The base type for use in polymorphic collections
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "The base type for use in polymorphic collections")

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
		Push push = (Push) o;
		return Objects.equals(this.href, push.href) && Objects.equals(this.id, push.id)
				&& Objects.equals(this._atType, push._atType)
				&& Objects.equals(this._atSchemaLocation, push._atSchemaLocation)
				&& Objects.equals(this._atBaseType, push._atBaseType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(href, id, _atType, _atSchemaLocation, _atBaseType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Push {\n");

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
