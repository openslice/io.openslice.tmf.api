package io.openslice.tmf.scm633.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Resource Specification reference: The ResourceSpecification is required to
 * realize a ProductSpecification.
 */
@ApiModel(description = "Resource Specification reference: The ResourceSpecification is required to realize a ProductSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Entity(name = "ResourceSpecificationRef")
public class ResourceSpecificationRef extends BaseRootEntity {
	@JsonProperty("version")
	private String version = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	@JsonProperty("id")
	protected String id = null;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public ResourceSpecificationRef() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ResourceSpecificationRef(ResourceSpecificationRef r) {
		this();
		name = r.name;
		version = r.version;
		id = r.id;
		
	}

	public ResourceSpecificationRef id(String id) {
		this.id = id;
		return this;
	}

	public ResourceSpecificationRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Resource specification version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Resource specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the super-class")

	public ResourceSpecificationRef referredType(String referredType) {
		this.referredType = referredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return referredType
	 **/
	@ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")

	public String getReferredType() {
		return referredType;
	}

	public void setReferredType(String referredType) {
		this.referredType = referredType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceSpecificationRef resourceSpecificationRef = (ResourceSpecificationRef) o;
		return Objects.equals(this.id, resourceSpecificationRef.id)
				&& Objects.equals(this.href, resourceSpecificationRef.href)
				&& Objects.equals(this.name, resourceSpecificationRef.name)
				&& Objects.equals(this.version, resourceSpecificationRef.version)
				&& Objects.equals(this.baseType, resourceSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, resourceSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, resourceSpecificationRef.type)
				&& Objects.equals(this.referredType, resourceSpecificationRef.referredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, version, baseType, schemaLocation, type, referredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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
