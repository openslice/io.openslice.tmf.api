package io.openslice.tmf.ri639.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

/**
 * Another Characteristic that is related to the current Characteristic;
 */
@Schema(description = "Another Characteristic that is related to the current Characteristic;")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RICharacteristicRel")
public class CharacteristicRelationship extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	public CharacteristicRelationship id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the characteristic
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the characteristic")
	public String getId() {
		id = uuid;
		return uuid;
	}

	
	public CharacteristicRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * The type of relationship
	 * 
	 * @return relationshipType
	 **/
	@Schema(description = "The type of relationship")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CharacteristicRelationship characteristicRelationship = (CharacteristicRelationship) o;
		return Objects.equals(this.id, characteristicRelationship.id)
				&& Objects.equals(this.href, characteristicRelationship.href)
				&& Objects.equals(this.relationshipType, characteristicRelationship.relationshipType)
				&& Objects.equals(this.baseType, characteristicRelationship.baseType)
				&& Objects.equals(this.schemaLocation, characteristicRelationship.schemaLocation)
				&& Objects.equals(this.type, characteristicRelationship.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, relationshipType, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CharacteristicRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
