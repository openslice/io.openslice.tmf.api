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
package io.openslice.tmf.pm632.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Child references of an organization in a structure of organizations.
 */
@ApiModel(description = "Child references of an organization in a structure of organizations.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class OrganizationChildRelationship extends BaseRootEntity {
	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("organization")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_refid", referencedColumnName = "uuid")
	private OrganizationRef organization = null;

	public OrganizationChildRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of the relationship. Could be juridical, hierarchical, geographical,
	 * functional for example.
	 * 
	 * @return relationshipType
	 **/
	@ApiModelProperty(value = "Type of the relationship. Could be juridical, hierarchical, geographical, functional for example.")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public OrganizationChildRelationship organization(OrganizationRef organization) {
		this.organization = organization;
		return this;
	}

	/**
	 * Get organization
	 * 
	 * @return organization
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OrganizationRef getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationRef organization) {
		this.organization = organization;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrganizationChildRelationship organizationChildRelationship = (OrganizationChildRelationship) o;
		return Objects.equals(this.relationshipType, organizationChildRelationship.relationshipType)
				&& Objects.equals(this.organization, organizationChildRelationship.organization)
				&& Objects.equals(this.baseType, organizationChildRelationship.baseType)
				&& Objects.equals(this.schemaLocation, organizationChildRelationship.schemaLocation)
				&& Objects.equals(this.type, organizationChildRelationship.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(relationshipType, organization, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class OrganizationChildRelationship {\n");

		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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
