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
package io.openslice.tmf.scm633.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among service specifications.
 */
@ApiModel(description = "A migration, substitution, dependency or exclusivity relationship between/among service specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceSpecRelationship")
public class ServiceSpecRelationship extends BaseRootNamedEntity {
	

	
	
	@JsonProperty("id")
	protected String id = null;


	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("role")
	private String role = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public ServiceSpecRelationship() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ServiceSpecRelationship(ServiceSpecRelationship src) {
		this();
		name = src.name;
		relationshipType = src.relationshipType;
		role = src.role;
		validFor = new TimePeriod( src.validFor );
		
	}

	public ServiceSpecRelationship id(String id) {
		this.id = id;
		return this;
	}

	
	/**
	 * Unique identifier of the target serviceSpecification
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the target serviceSpecification")

	public ServiceSpecRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of relationship such as migration, substitution, dependency, exclusivity
	 * 
	 * @return relationshipType
	 **/
	@ApiModelProperty(value = "Type of relationship such as migration, substitution, dependency, exclusivity")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ServiceSpecRelationship role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * The association role for this service specification
	 * 
	 * @return role
	 **/
	@ApiModelProperty(value = "The association role for this service specification")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ServiceSpecRelationship validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the serviceSpecRelationship is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the serviceSpecRelationship is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceSpecRelationship serviceSpecRelationship = (ServiceSpecRelationship) o;
		return Objects.equals(this.id, serviceSpecRelationship.id)
				&& Objects.equals(this.name, serviceSpecRelationship.name)
				&& Objects.equals(this.relationshipType, serviceSpecRelationship.relationshipType)
				&& Objects.equals(this.role, serviceSpecRelationship.role)
				&& Objects.equals(this.validFor, serviceSpecRelationship.validFor)
				&& Objects.equals(this.baseType, serviceSpecRelationship.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecRelationship.schemaLocation)
				&& Objects.equals(this.type, serviceSpecRelationship.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,  name, relationshipType, role, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

	
	
}
