package io.openslice.tmf.rpm685.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.service.ResourceRef;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * the availabilityCheck task resource for resource pool management
 */
@Schema(description = "the availabilityCheck task resource for resource pool management")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class AvailabilityCheck {
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

	@JsonProperty("resourceCapacityDemand")
	private ResourceCapacityDemand resourceCapacityDemand = null;

	@JsonProperty("availableResources")
	private List<ResourceRef> availableResources = null;

	
	
	
	/**
	 * @return the availableResources
	 */
	public List<ResourceRef> getAvailableResources() {
		return availableResources;
	}

	/**
	 * @param availableResources the availableResources to set
	 */
	public void setAvailableResources(List<ResourceRef> availableResources) {
		this.availableResources = availableResources;
	}

	/**
	 * @return the resourceCapacityDemand
	 */
	public ResourceCapacityDemand getResourceCapacityDemand() {
		return resourceCapacityDemand;
	}

	/**
	 * @param resourceCapacityDemand the resourceCapacityDemand to set
	 */
	public void setResourceCapacityDemand(ResourceCapacityDemand resourceCapacityDemand) {
		this.resourceCapacityDemand = resourceCapacityDemand;
	}

	public AvailabilityCheck href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * A string. Hyperlink to access the availabilityCheck task for resource pool
	 * Management
	 * 
	 * @return href
	 **/
	@Schema(description = "A string. Hyperlink to access the availabilityCheck task for resource pool Management")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public AvailabilityCheck id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A string. Identifier of an instance of the availabilityCheck task for
	 * resource pool Management
	 * 
	 * @return id
	 **/
	@Schema(description = "A string. Identifier of an instance of the availabilityCheck task for resource pool Management")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AvailabilityCheck _atType(String _atType) {
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

	public AvailabilityCheck _atSchemaLocation(String _atSchemaLocation) {
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

	public AvailabilityCheck _atBaseType(String _atBaseType) {
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
		AvailabilityCheck availabilityCheck = (AvailabilityCheck) o;
		return Objects.equals(this.href, availabilityCheck.href) && Objects.equals(this.id, availabilityCheck.id)
				&& Objects.equals(this._atType, availabilityCheck._atType)
				&& Objects.equals(this._atSchemaLocation, availabilityCheck._atSchemaLocation)
				&& Objects.equals(this._atBaseType, availabilityCheck._atBaseType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(href, id, _atType, _atSchemaLocation, _atBaseType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AvailabilityCheck {\n");

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
