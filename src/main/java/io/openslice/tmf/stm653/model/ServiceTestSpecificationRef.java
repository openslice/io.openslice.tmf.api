package io.openslice.tmf.stm653.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The service test specification used by the service test.
 */
@ApiModel(description = "The service test specification used by the service test.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMServiceTestSpecificationRef")
@Table(name = "STMServiceTestSpecificationRef")
public class ServiceTestSpecificationRef extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public ServiceTestSpecificationRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink to access a service test specification.
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Hyperlink to access a service test specification.")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ServiceTestSpecificationRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Version of a service test specification
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Version of a service test specification ")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	

	public ServiceTestSpecificationRef _atReferredType(String _atReferredType) {
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
		ServiceTestSpecificationRef serviceTestSpecificationRef = (ServiceTestSpecificationRef) o;
		return Objects.equals(this.id, serviceTestSpecificationRef.id)
				&& Objects.equals(this.href, serviceTestSpecificationRef.href)
				&& Objects.equals(this.version, serviceTestSpecificationRef.version)
				&& Objects.equals(this.baseType, serviceTestSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceTestSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, serviceTestSpecificationRef.type)
				&& Objects.equals(this._atReferredType, serviceTestSpecificationRef._atReferredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, version, _atBaseType, _atSchemaLocation, _atType, _atReferredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceTestSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
