/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.stm653.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among Characteristic specifications. The specification
 * characteristic is embedded within the specification whose ID and href are in
 * this entity, and identified by its ID.
 */
@Schema(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among Characteristic specifications. The specification characteristic is embedded within the specification whose ID and href are in this entity, and identified by its ID.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMCharacSpecRel")
@Table(name = "STMCharacSpecRel")
public class CharacteristicSpecificationRelationship extends BaseRootNamedEntity {
	@JsonProperty("characteristicSpecificationId")
	private String characteristicSpecificationId = null;

	@JsonProperty("parentSpecificationHref")
	private String parentSpecificationHref = null;

	@JsonProperty("parentSpecificationId")
	private String parentSpecificationId = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public CharacteristicSpecificationRelationship() {
		
	}
	
	
	public CharacteristicSpecificationRelationship(CharacteristicSpecificationRelationship src) {
		name = src.name;
		relationshipType = src.relationshipType;
		validFor = new TimePeriod(src.validFor);
		characteristicSpecificationId = src.characteristicSpecificationId;
	}

	public CharacteristicSpecificationRelationship characteristicSpecificationId(String characteristicSpecificationId) {
		this.characteristicSpecificationId = characteristicSpecificationId;
		return this;
	}

	/**
	 * Unique identifier of the characteristic within the specification
	 * 
	 * @return characteristicSpecificationId
	 **/
	@Schema(description = "Unique identifier of the characteristic within the specification")

	public String getCharacteristicSpecificationId() {
		return characteristicSpecificationId;
	}

	public void setCharacteristicSpecificationId(String characteristicSpecificationId) {
		this.characteristicSpecificationId = characteristicSpecificationId;
	}

	public CharacteristicSpecificationRelationship parentSpecificationHref(String parentSpecificationHref) {
		this.parentSpecificationHref = parentSpecificationHref;
		return this;
	}

	/**
	 * Hyperlink reference to the parent specification containing the target
	 * characteristic
	 * 
	 * @return parentSpecificationHref
	 **/
	@Schema(description = "Hyperlink reference to the parent specification containing the target characteristic")

	public String getParentSpecificationHref() {
		return parentSpecificationHref;
	}

	public void setParentSpecificationHref(String parentSpecificationHref) {
		this.parentSpecificationHref = parentSpecificationHref;
	}

	public CharacteristicSpecificationRelationship parentSpecificationId(String parentSpecificationId) {
		this.parentSpecificationId = parentSpecificationId;
		return this;
	}

	/**
	 * Unique identifier of the parent specification containing the target
	 * characteristic
	 * 
	 * @return parentSpecificationId
	 **/
	@Schema(description = "Unique identifier of the parent specification containing the target characteristic")

	public String getParentSpecificationId() {
		return parentSpecificationId;
	}

	public void setParentSpecificationId(String parentSpecificationId) {
		this.parentSpecificationId = parentSpecificationId;
	}

	public CharacteristicSpecificationRelationship relationshipType(String relationshipType) {
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

	public CharacteristicSpecificationRelationship validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@Schema(description = "")

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
		CharacteristicSpecificationRelationship characteristicSpecificationRelationship = (CharacteristicSpecificationRelationship) o;
		return Objects.equals(this.characteristicSpecificationId,
				characteristicSpecificationRelationship.characteristicSpecificationId)
				&& Objects.equals(this.name, characteristicSpecificationRelationship.name)
				&& Objects.equals(this.parentSpecificationHref,
						characteristicSpecificationRelationship.parentSpecificationHref)
				&& Objects.equals(this.parentSpecificationId,
						characteristicSpecificationRelationship.parentSpecificationId)
				&& Objects.equals(this.relationshipType, characteristicSpecificationRelationship.relationshipType)
				&& Objects.equals(this.validFor, characteristicSpecificationRelationship.validFor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(characteristicSpecificationId, name, parentSpecificationHref, parentSpecificationId,
				relationshipType, validFor);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CharacteristicSpecificationRelationship {\n");

		sb.append("    characteristicSpecificationId: ").append(toIndentedString(characteristicSpecificationId))
				.append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parentSpecificationHref: ").append(toIndentedString(parentSpecificationHref)).append("\n");
		sb.append("    parentSpecificationId: ").append(toIndentedString(parentSpecificationId)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
