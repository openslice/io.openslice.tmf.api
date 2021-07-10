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
 * Entity reference schema to be use for all entityRef class.
 */
@ApiModel(description = "Entity reference schema to be use for all entityRef class.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIEntityRef")
public class EntityRef extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;


	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "unique identifier")
	@NotNull
	public String getId() {
		id = uuid;
		return uuid;
	}

	public EntityRef href(String href) {
		this.href = href;
		return this;
	}


	public EntityRef _atReferredType(String _atReferredType) {
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
		EntityRef entityRef = (EntityRef) o;
		return Objects.equals(this.id, entityRef.id) && Objects.equals(this.href, entityRef.href)
				&& Objects.equals(this.name, entityRef.name) && Objects.equals(this.baseType, entityRef.baseType)
				&& Objects.equals(this.schemaLocation, entityRef.schemaLocation)
				&& Objects.equals(this.type, entityRef.type)
				&& Objects.equals(this._atReferredType, entityRef._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, baseType, schemaLocation, type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntityRef {\n");

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
