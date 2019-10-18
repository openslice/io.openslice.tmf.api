package io.openslice.tmf.scm633.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceCandidate reference. ServiceCandidate is an entity that makes a
 * ServiceSpecification available to a catalog.
 */
@ApiModel(description = "ServiceCandidate reference. ServiceCandidate is an entity that makes a ServiceSpecification available to a catalog.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCandidateRef extends BaseRootEntity {

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

	public ServiceCandidateRef() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ServiceCandidateRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Version of the service candidate
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Version of the service candidate")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServiceCandidateRef referredType(String referredType) {
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
		ServiceCandidateRef serviceCandidateRef = (ServiceCandidateRef) o;
		return Objects.equals(this.id, serviceCandidateRef.id) && Objects.equals(this.href, serviceCandidateRef.href)
				&& Objects.equals(this.name, serviceCandidateRef.name)
				&& Objects.equals(this.version, serviceCandidateRef.version)
				&& Objects.equals(this.baseType, serviceCandidateRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceCandidateRef.schemaLocation)
				&& Objects.equals(this.type, serviceCandidateRef.type)
				&& Objects.equals(this.referredType, serviceCandidateRef.referredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, name, version, baseType, schemaLocation, type, referredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCandidateRef {\n");

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
