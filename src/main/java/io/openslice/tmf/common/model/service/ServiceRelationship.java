/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.common.model.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Describes links with services of the same category (useful for bundled
 * services)
 */
@Schema(description = "Describes links with services of the same category (useful for bundled services)")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Entity(name = "ServiceRelationship")
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
	@Schema(description = "The type of relationship (e.g. depends on, enables)")
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
	@Schema(description = "The service being referred to")
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

//	@Override
//	public int hashCode() {
//		return Objects.hash(relationshipType, service, baseType, schemaLocation, type);
//	}

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
