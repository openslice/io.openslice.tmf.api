package io.openslice.tmf.ri639.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Constraint reference. The Constraint resource represents a policy/rule
 * applied to an entity or entity spec.
 */
@ApiModel(description = "Constraint reference. The Constraint resource represents a policy/rule applied to an entity or entity spec.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIConstraintRef")
public class ConstraintRef extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("version")
	private String version = null;


	@JsonProperty("@referredType")
	private String _atReferredType = null;

	public ConstraintRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "unique identifier")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ConstraintRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Hyperlink reference")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ConstraintRef name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the related entity.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the related entity.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConstraintRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * constraint version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "constraint version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ConstraintRef _atBaseType(String _atBaseType) {
		this.baseType = _atBaseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return _atBaseType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return baseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this.baseType = _atBaseType;
	}

	public ConstraintRef _atSchemaLocation(String _atSchemaLocation) {
		this.schemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return _atSchemaLocation
	 **/
	@ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return schemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this.schemaLocation = _atSchemaLocation;
	}

	public ConstraintRef _atType(String _atType) {
		this.type = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class Extensible name
	 * 
	 * @return _atType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")

	public String getAtType() {
		return type;
	}

	public void setAtType(String _atType) {
		this.type = _atType;
	}

	public ConstraintRef _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return _atReferredType
	 **/
	@ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")

	public String getAtReferredType() {
		return _atReferredType;
	}

	public void setAtReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConstraintRef constraintRef = (ConstraintRef) o;
		return Objects.equals(this.id, constraintRef.id) && Objects.equals(this.href, constraintRef.href)
				&& Objects.equals(this.name, constraintRef.name) && Objects.equals(this.version, constraintRef.version)
				&& Objects.equals(this.baseType, constraintRef.baseType)
				&& Objects.equals(this.schemaLocation, constraintRef.schemaLocation)
				&& Objects.equals(this.type, constraintRef.type)
				&& Objects.equals(this._atReferredType, constraintRef._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, version, baseType, schemaLocation, type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ConstraintRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
		sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
