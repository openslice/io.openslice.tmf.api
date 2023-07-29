package io.openslice.tmf.rpm685.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * manages resource capacity with the resource state Skipped properties: id,href
 */
@Schema(description = "manages resource capacity with the resource state Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class ResourcePoolUpdate {
	@JsonProperty("@baseType")
	private String _atBaseType = null;

	@JsonProperty("@schemaLocation")
	private String _atSchemaLocation = null;

	@JsonProperty("@type")
	private String _atType = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("relatedParty")
	private String relatedParty = null;



	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("capacity")
	@Valid
	private Capacity capacity = null;

	public ResourcePoolUpdate _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * A string. Generic attribute indicating the base class type of the extension
	 * class of the current object. Useful only when the class type of the current
	 * object is unknown to the implementation.
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "A string. Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.")

	public String getAtBaseType() {
		return _atBaseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
	}

	public ResourcePoolUpdate _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A string. Generic attribute containing the link to the schema that defines
	 * the structure of the class type of the current object.
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A string. Generic attribute containing the link to the schema that defines the structure of the class type of the current object.")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public ResourcePoolUpdate _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * A string. Generic attribute containing the name of the resource class type.
	 * 
	 * @return _atType
	 **/
	@Schema(description = "A string. Generic attribute containing the name of the resource class type.")

	public String getAtType() {
		return _atType;
	}

	public void setAtType(String _atType) {
		this._atType = _atType;
	}

	public ResourcePoolUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A string. free-text description of the Resource Pool.
	 * 
	 * @return description
	 **/
	@Schema(description = "A string. free-text description of the Resource Pool.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourcePoolUpdate relatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	/**
	 * A related party defines party or party role linked to a specific entity, who
	 * uses the resource of Resource Pool.
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "A related party defines party or party role linked to a specific entity, who uses the resource of Resource Pool.")

	public String getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	public void setCapacity( Capacity capacity) {
		this.capacity = capacity;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourcePoolUpdate resourcePoolUpdate = (ResourcePoolUpdate) o;
		return Objects.equals(this._atBaseType, resourcePoolUpdate._atBaseType)
				&& Objects.equals(this._atSchemaLocation, resourcePoolUpdate._atSchemaLocation)
				&& Objects.equals(this._atType, resourcePoolUpdate._atType)
				&& Objects.equals(this.description, resourcePoolUpdate.description)
				&& Objects.equals(this.relatedParty, resourcePoolUpdate.relatedParty);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atBaseType, _atSchemaLocation, _atType, description, relatedParty);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourcePoolUpdate {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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
