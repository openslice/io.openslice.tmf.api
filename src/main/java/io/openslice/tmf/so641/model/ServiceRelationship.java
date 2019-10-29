package io.openslice.tmf.so641.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Describes links with services of the same category (useful for bundled
 * services)
 */
@ApiModel(description = "Describes links with services of the same category (useful for bundled services)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Entity(name = "ServiceRestrictionServiceRelationshipEntity")
public class ServiceRelationship extends BaseRootEntity {

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_serviceref_uuid", referencedColumnName = "uuid")
	@JsonProperty("service")
	private ServiceRef service = null;

	public ServiceRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * The type of relationship (e.g. depends on, enables)
	 * 
	 * @return relationshipType
	 **/
	@ApiModelProperty(required = true, value = "The type of relationship (e.g. depends on, enables)")
	@NotNull

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ServiceRelationship service(ServiceRef service) {
		this.service = service;
		return this;
	}

	/**
	 * The service being referred to
	 * 
	 * @return service
	 **/
	@ApiModelProperty(required = true, value = "The service being referred to")
	@NotNull

	@Valid

	public ServiceRef getService() {
		return service;
	}

	public void setService(ServiceRef service) {
		this.service = service;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceRelationship serviceRelationship = (ServiceRelationship) o;
		return Objects.equals(this.relationshipType, serviceRelationship.relationshipType)
				&& Objects.equals(this.service, serviceRelationship.service)
				&& Objects.equals(this.baseType, serviceRelationship.baseType)
				&& Objects.equals(this.schemaLocation, serviceRelationship.schemaLocation)
				&& Objects.equals(this.type, serviceRelationship.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(relationshipType, service, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceRelationship {\n");

		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    service: ").append(toIndentedString(service)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
