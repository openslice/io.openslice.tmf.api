package io.openslice.tmf.rpm685.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * the availabilityCheck task resource for resource pool management Skipped
 * properties: id,href
 */
@Schema(description = "the availabilityCheck task resource for resource pool management Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class AvailabilityCheckCreate {
	@JsonProperty("@type")
	private String _atType = null;

	@JsonProperty("@schemaLocation")
	private String _atSchemaLocation = null;

	@JsonProperty("@baseType")
	private String _atBaseType = null;

	@JsonProperty("resourceCapacityDemand")
	private ResourceCapacityDemand resourceCapacityDemand = null;

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

	public AvailabilityCheckCreate _atType(String _atType) {
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

	public AvailabilityCheckCreate _atSchemaLocation(String _atSchemaLocation) {
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

	public AvailabilityCheckCreate _atBaseType(String _atBaseType) {
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
		AvailabilityCheckCreate availabilityCheckCreate = (AvailabilityCheckCreate) o;
		return Objects.equals(this._atType, availabilityCheckCreate._atType)
				&& Objects.equals(this._atSchemaLocation, availabilityCheckCreate._atSchemaLocation)
				&& Objects.equals(this._atBaseType, availabilityCheckCreate._atBaseType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atType, _atSchemaLocation, _atBaseType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AvailabilityCheckCreate {\n");

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
