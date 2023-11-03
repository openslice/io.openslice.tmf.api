package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Resource graph specification reference.
 */
@Schema(description = "Resource graph specification reference.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "ResourceGraphSpecRef")
public class ResourceGraphSpecificationRef extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("href")
	private String href = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	public ResourceGraphSpecificationRef id(String id) {
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

	public ResourceGraphSpecificationRef href(String href) {
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

	public ResourceGraphSpecificationRef name(String name) {
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

	public ResourceGraphSpecificationRef _atReferredType(String _atReferredType) {
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
		ResourceGraphSpecificationRef resourceGraphSpecificationRef = (ResourceGraphSpecificationRef) o;
		return Objects.equals(this.id, resourceGraphSpecificationRef.id)
				&& Objects.equals(this.href, resourceGraphSpecificationRef.href)
				&& Objects.equals(this.name, resourceGraphSpecificationRef.name)
				&& Objects.equals(this.baseType, resourceGraphSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, resourceGraphSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, resourceGraphSpecificationRef.type)
				&& Objects.equals(this._atReferredType, resourceGraphSpecificationRef._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, baseType, schemaLocation, type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceGraphSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
