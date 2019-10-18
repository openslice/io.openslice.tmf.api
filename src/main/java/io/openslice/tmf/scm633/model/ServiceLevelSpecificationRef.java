package io.openslice.tmf.scm633.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of
 * Service Level Objectives. In addition, certain consequences are associated
 * with not meeting the Service Level Objectives. Service Level Agreements are
 * expressed in terms of Service Level Specifications.
 */
@ApiModel(description = "A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceLevelSpecificationRef")
public class ServiceLevelSpecificationRef extends BaseRootEntity {

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

	public ServiceLevelSpecificationRef id(String id) {
		this.id = id;
		return this;
	}

	public ServiceLevelSpecificationRef() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ServiceLevelSpecificationRef(ServiceLevelSpecificationRef r) {
		this();
		name = r.name;
		id = r.id;
	}

	public ServiceLevelSpecificationRef referredType(String referredType) {
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
		ServiceLevelSpecificationRef serviceLevelSpecificationRef = (ServiceLevelSpecificationRef) o;
		return Objects.equals(this.id, serviceLevelSpecificationRef.id)
				&& Objects.equals(this.href, serviceLevelSpecificationRef.href)
				&& Objects.equals(this.name, serviceLevelSpecificationRef.name)
				&& Objects.equals(this.baseType, serviceLevelSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceLevelSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, serviceLevelSpecificationRef.type)
				&& Objects.equals(this.referredType, serviceLevelSpecificationRef.referredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, baseType, schemaLocation, type, referredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceLevelSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
