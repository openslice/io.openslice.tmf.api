package io.openslice.tmf.ri639.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Describes a given characteristic of an object or entity through a name/value
 * pair.
 */
@Schema(description = "Describes a given characteristic of an object or entity through a name/value pair.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RICharacteristic")
public class Characteristic extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("characteristicRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CharacteristicRelationship> characteristicRelationship = new HashSet<>();

	@JsonProperty("value")
	private Any value = null;



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
	
	public Characteristic name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the characteristic
	 * 
	 * @return name
	 **/
	@Schema(description = "Name of the characteristic")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Characteristic valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * Data type of the value of the characteristic
	 * 
	 * @return valueType
	 **/
	@Schema(description = "Data type of the value of the characteristic")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public Characteristic characteristicRelationship( Set<CharacteristicRelationship> characteristicRelationship) {
		this.characteristicRelationship = characteristicRelationship;
		return this;
	}

	public Characteristic addCharacteristicRelationshipItem(CharacteristicRelationship characteristicRelationshipItem) {
		if (this.characteristicRelationship == null) {
			this.characteristicRelationship = new HashSet<>();
		}
		this.characteristicRelationship.add(characteristicRelationshipItem);
		return this;
	}

	/**
	 * Get characteristicRelationship
	 * 
	 * @return characteristicRelationship
	 **/
	@Schema(description = "")
	@Valid
	public Set<CharacteristicRelationship> getCharacteristicRelationship() {
		return characteristicRelationship;
	}

	public void setCharacteristicRelationship( Set<CharacteristicRelationship> characteristicRelationship) {
		this.characteristicRelationship = characteristicRelationship;
	}

	public Characteristic value(Any value) {
		this.value = value;
		return this;
	}

	/**
	 * Get value
	 * 
	 * @return value
	 **/
	@Schema(description = "")
	@NotNull

	@Valid
	public Any getValue() {
		return value;
	}

	public void setValue(Any value) {
		this.value = value;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Characteristic characteristic = (Characteristic) o;
		return Objects.equals(this.id, characteristic.id) && Objects.equals(this.name, characteristic.name)
				&& Objects.equals(this.valueType, characteristic.valueType)
				&& Objects.equals(this.characteristicRelationship, characteristic.characteristicRelationship)
				&& Objects.equals(this.value, characteristic.value)
				&& Objects.equals(this.baseType, characteristic.baseType)
				&& Objects.equals(this.schemaLocation, characteristic.schemaLocation)
				&& Objects.equals(this.type, characteristic.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, valueType, characteristicRelationship, value, baseType, schemaLocation,
				type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Characteristic {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    characteristicRelationship: ").append(toIndentedString(characteristicRelationship)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
