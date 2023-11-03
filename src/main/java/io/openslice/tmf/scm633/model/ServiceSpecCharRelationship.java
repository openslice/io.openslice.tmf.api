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

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among serviceSpecCharacteristics.
 */
@Schema(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among serviceSpecCharacteristics.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Entity(name = "ServiceSpecCharRelationship")
public class ServiceSpecCharRelationship {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;
	
	
	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;
	
	@JsonProperty("@baseType")
	protected String baseType = "BaseEntity";


	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;
	

	@JsonProperty("@type")
	protected String type = null;
	
	@JsonProperty("role")
	private String role = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	
	public ServiceSpecCharRelationship() {
	}

	public ServiceSpecCharRelationship(ServiceSpecCharRelationship src ){
		name = src.name;
		relationshipType = src.relationshipType;
		role = src.role;
		validFor = new TimePeriod( src.validFor );
		id = src.id;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the baseType
	 */
	public String getBaseType() {
		return baseType;
	}

	/**
	 * @param baseType the baseType to set
	 */
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	/**
	 * @return the schemaLocation
	 */
	public String getSchemaLocation() {
		return schemaLocation;
	}

	/**
	 * @param schemaLocation the schemaLocation to set
	 */
	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ServiceSpecCharRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of relationship such as aggregation, migration, substitution,
	 * dependency, exclusivity
	 * 
	 * @return relationshipType
	 **/
	@Schema(description = "Type of relationship such as aggregation, migration, substitution, dependency, exclusivity")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ServiceSpecCharRelationship role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * The association role for this service specification
	 * 
	 * @return role
	 **/
	@Schema(description = "The association role for this service specification")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ServiceSpecCharRelationship validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the serviceSpecCharRelationship is valid
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The period for which the serviceSpecCharRelationship is valid")

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
		ServiceSpecCharRelationship serviceSpecCharRelationship = (ServiceSpecCharRelationship) o;
		return Objects.equals(this.id, serviceSpecCharRelationship.id)
				&& Objects.equals(this.name, serviceSpecCharRelationship.name)
				&& Objects.equals(this.relationshipType, serviceSpecCharRelationship.relationshipType)
				&& Objects.equals(this.role, serviceSpecCharRelationship.role)
				&& Objects.equals(this.validFor, serviceSpecCharRelationship.validFor)
				&& Objects.equals(this.baseType, serviceSpecCharRelationship.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecCharRelationship.schemaLocation)
				&& Objects.equals(this.type, serviceSpecCharRelationship.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name, relationshipType, role, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecCharRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
}
