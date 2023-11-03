package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Connection point specification reference. A connection point provides a
 * service access point (SAP) for input and/or output of the resource function.
 */
@Schema(description = "Connection point specification reference. A connection point provides a service access point (SAP) for input and/or output of the resource function.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "ConnectionPointSpecRef")
public class ConnectionPointSpecificationRef extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	public ConnectionPointSpecificationRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@Schema(description = "unique identifier")
	@NotNull

	public String getId() {
		id = uuid;
		return uuid;
	}

	public ConnectionPointSpecificationRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@Schema(description = "Hyperlink reference")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ConnectionPointSpecificationRef name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the related entity.
	 * 
	 * @return name
	 **/
	@Schema(description = "Name of the related entity.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConnectionPointSpecificationRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Connection point specification version
	 * 
	 * @return version
	 **/
	@Schema(description = "Connection point specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	public ConnectionPointSpecificationRef _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return _atReferredType
	 **/
	@Schema(description = "The actual type of the target instance when needed for disambiguation.")

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
		ConnectionPointSpecificationRef connectionPointSpecificationRef = (ConnectionPointSpecificationRef) o;
		return Objects.equals(this.id, connectionPointSpecificationRef.id)
				&& Objects.equals(this.href, connectionPointSpecificationRef.href)
				&& Objects.equals(this.name, connectionPointSpecificationRef.name)
				&& Objects.equals(this.version, connectionPointSpecificationRef.version)
				&& Objects.equals(this.baseType, connectionPointSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, connectionPointSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, connectionPointSpecificationRef.type)
				&& Objects.equals(this._atReferredType, connectionPointSpecificationRef._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, version, baseType, schemaLocation, type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ConnectionPointSpecificationRef {\n");

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
