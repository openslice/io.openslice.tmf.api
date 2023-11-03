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
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Describes a given characteristic of an object or entity through a name/value
 * pair.
 */
@Schema(description = "Describes a given characteristic of an object or entity through a name/value pair.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMCharacteristic")
@Table(name = "STMCharacteristic")
public class Characteristic extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("characteristicRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CharacteristicRelationship> characteristicRelationship = null;

	@JsonProperty("value")
	private Any value = null;

	public Characteristic() {
	}
	
	
	public Characteristic(Characteristic src) {
		name = src.name;
		valueType = src.valueType;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
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

	public Characteristic characteristicRelationship(Set<CharacteristicRelationship> characteristicRelationship) {
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

	public void setCharacteristicRelationship(Set<CharacteristicRelationship> characteristicRelationship) {
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

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, name, valueType, characteristicRelationship, value, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Characteristic {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    characteristicRelationship: ").append(toIndentedString(characteristicRelationship)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

//	public void updateWith(Characteristic src) {
//		this.name = src.getName();
//		this.valueType = src.valueType;
//
//		this.updateServiceCharacteristicRel(src.getCharacteristicRelationship() );
//
//	}
//
//	private void updateServiceCharacteristicRel(@Valid Set<CharacteristicRelationship> srcSet) {
//		
//		if ( srcSet == null ) {
//			return;
//		}
//		Map< String, Boolean> idAddedUpdated = new HashMap<>();
//		/**
//		 * update, add the incomings
//		 */
//		for (CharacteristicRelationship r : srcSet) {
//
//			boolean valueExists = false;
//			for (CharacteristicRelationship thisCharVal : this.characteristicRelationship ) {
//				if ( (thisCharVal.getId() !=null) && (thisCharVal.getId().equals(r.getId() ) )) {
//					valueExists = true;
//					idAddedUpdated.put( thisCharVal.getId() , true);
//					break;
//				}
//			}
//			
//			if (!valueExists) {
//				this.characteristicRelationship.add( new CharacteristicRelationship( r ));
//				idAddedUpdated.put( r.getId(), true);
//			}
//			
//		}
//		
//		/**
//		 * remove those that don't exist anymore
//		 */
//		
//		List<CharacteristicRelationship> toRemove = new ArrayList<>();
//		for (CharacteristicRelationship ss : this.characteristicRelationship) {
//			if ( idAddedUpdated.get( ss.getId() ) == null ) {
//				toRemove.add(ss);
//			}
//		}
//		
//		for (CharacteristicRelationship r : toRemove) {
//			this.characteristicRelationship.remove(r);
//		}
//		
//	}
}
