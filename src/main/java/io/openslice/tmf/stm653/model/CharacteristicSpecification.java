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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * This class defines a characteristic specification.
 */
@Schema(description = "This class defines a characteristic specification.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMCharactSpec")
@Table(name = "STMCharactSpec")
public class CharacteristicSpecification extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("configurable")
	private Boolean configurable = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("extensible")
	private Boolean extensible = null;

	@JsonProperty("isUnique")
	private Boolean isUnique = null;

	@JsonProperty("maxCardinality")
	private Integer maxCardinality = null;

	@JsonProperty("minCardinality")
	private Integer minCardinality = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("charSpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CharacteristicSpecificationRelationship> charSpecRelationship = new HashSet<>();

	@JsonProperty("characteristicValueSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CharacteristicValueSpecification> characteristicValueSpecification = new HashSet<>();

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("@valueSchemaLocation")
	private String _atValueSchemaLocation = null;

	public CharacteristicSpecification() {
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();		
	}
	
	
	public CharacteristicSpecification(CharacteristicSpecification src) {
		this();
		configurable = src.configurable;
		description = src.description;
		extensible = src.extensible;
		isUnique = src.isUnique;
		maxCardinality = src.maxCardinality;
		minCardinality = src.minCardinality;
		name = src.name;
		regex = src.regex;
		valueType = src.valueType;
		validFor = new TimePeriod( src.validFor ) ;
		
		for (CharacteristicSpecificationRelationship r : src.charSpecRelationship) {
			this.addServiceSpecCharRelationshipItem( new CharacteristicSpecificationRelationship( r ));
		}
		
		for (CharacteristicValueSpecification r : src.characteristicValueSpecification) {
			this.addServiceSpecCharacteristicValueItem( new CharacteristicValueSpecification(r) );
		}
	}
	

	private CharacteristicSpecification addServiceSpecCharRelationshipItem(
			CharacteristicSpecificationRelationship characteristicSpecificationRelationship) {
		
		if (this.charSpecRelationship == null) {
			this.charSpecRelationship = new HashSet<CharacteristicSpecificationRelationship>();
		}
		this.charSpecRelationship.add( characteristicSpecificationRelationship );
		return this;
		
	}


	/**
	 * Unique ID for the characteristic
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique ID for the characteristic")
	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}

	public CharacteristicSpecification configurable(Boolean configurable) {
		this.configurable = configurable;
		return this;
	}

	/**
	 * If true, the Boolean indicates that the target Characteristic is configurable
	 * 
	 * @return configurable
	 **/
	@Schema(description = "If true, the Boolean indicates that the target Characteristic is configurable")

	public Boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	public CharacteristicSpecification description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative that explains the CharacteristicSpecification.
	 * 
	 * @return description
	 **/
	@Schema(description = "A narrative that explains the CharacteristicSpecification.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CharacteristicSpecification extensible(Boolean extensible) {
		this.extensible = extensible;
		return this;
	}

	/**
	 * An indicator that specifies that the values for the characteristic can be
	 * extended by adding new values when instantiating a characteristic for a
	 * resource.
	 * 
	 * @return extensible
	 **/
	@Schema(description = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.")

	public Boolean isExtensible() {
		return extensible;
	}

	public void setExtensible(Boolean extensible) {
		this.extensible = extensible;
	}

	public CharacteristicSpecification isUnique(Boolean isUnique) {
		this.isUnique = isUnique;
		return this;
	}

	/**
	 * An indicator that specifies if a value is unique for the specification.
	 * Possible values are; \"unique while value is in effect\" and \"unique whether
	 * value is in effect or not\"
	 * 
	 * @return isUnique
	 **/
	@Schema(description = "An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"")

	public Boolean isIsUnique() {
		return isUnique;
	}

	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	public CharacteristicSpecification maxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
		return this;
	}

	/**
	 * The maximum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where five is
	 * the value for the maxCardinality.
	 * 
	 * @return maxCardinality
	 **/
	@Schema(description = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.")

	public Integer getMaxCardinality() {
		return maxCardinality;
	}

	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}

	public CharacteristicSpecification minCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
		return this;
	}

	/**
	 * The minimum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where zero is
	 * the value for the minCardinality.
	 * 
	 * @return minCardinality
	 **/
	@Schema(description = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.")

	public Integer getMinCardinality() {
		return minCardinality;
	}

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}

	public CharacteristicSpecification name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A word, term, or phrase by which this characteristic specification is known
	 * and distinguished from other characteristic specifications.
	 * 
	 * @return name
	 **/
	@Schema(description = "A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CharacteristicSpecification regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * A rule or principle represented in regular expression used to derive the
	 * value of a characteristic value.
	 * 
	 * @return regex
	 **/
	@Schema(description = "A rule or principle represented in regular expression used to derive the value of a characteristic value.")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public CharacteristicSpecification valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric, text
	 * and so forth
	 * 
	 * @return valueType
	 **/
	@Schema(description = "A kind of value that the characteristic can take on, such as numeric, text and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public CharacteristicSpecification charSpecRelationship(
			Set<CharacteristicSpecificationRelationship> charSpecRelationship) {
		this.charSpecRelationship = charSpecRelationship;
		return this;
	}

	public CharacteristicSpecification addCharSpecRelationshipItem(
			CharacteristicSpecificationRelationship charSpecRelationshipItem) {
		if (this.charSpecRelationship == null) {
			this.charSpecRelationship = new HashSet<>();
		}
		this.charSpecRelationship.add(charSpecRelationshipItem);
		return this;
	}

	/**
	 * An aggregation, migration, substitution, dependency or exclusivity
	 * relationship between/among Specification Characteristics.
	 * 
	 * @return charSpecRelationship
	 **/
	@Schema(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.")
	@Valid
	public Set<CharacteristicSpecificationRelationship> getCharSpecRelationship() {
		return charSpecRelationship;
	}

	public void setCharSpecRelationship(Set<CharacteristicSpecificationRelationship> charSpecRelationship) {
		this.charSpecRelationship = charSpecRelationship;
	}

	public CharacteristicSpecification characteristicValueSpecification(
			Set<CharacteristicValueSpecification> characteristicValueSpecification) {
		this.characteristicValueSpecification = characteristicValueSpecification;
		return this;
	}

	public CharacteristicSpecification addCharacteristicValueSpecificationItem(
			CharacteristicValueSpecification characteristicValueSpecificationItem) {
		if (this.characteristicValueSpecification == null) {
			this.characteristicValueSpecification = new HashSet<>();
		}
		this.characteristicValueSpecification.add(characteristicValueSpecificationItem);
		return this;
	}

	/**
	 * A CharacteristicValueSpecification object is used to define a set of
	 * attributes, each of which can be assigned to a corresponding set of
	 * attributes in a CharacteristicSpecification object. The values of the
	 * attributes in the CharacteristicValueSpecification object describe the values
	 * of the attributes that a corresponding Characteristic object can take on.
	 * 
	 * @return characteristicValueSpecification
	 **/
	@Schema(description = "A CharacteristicValueSpecification object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a CharacteristicSpecification object. The values of the attributes in the CharacteristicValueSpecification object describe the values of the attributes that a corresponding Characteristic object can take on.")
	@Valid
	public Set<CharacteristicValueSpecification> getCharacteristicValueSpecification() {
		return characteristicValueSpecification;
	}

	public void setCharacteristicValueSpecification(
			Set<CharacteristicValueSpecification> characteristicValueSpecification) {
		this.characteristicValueSpecification = characteristicValueSpecification;
	}

	public CharacteristicSpecification validFor(TimePeriod validFor) {
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

	public CharacteristicSpecification _atValueSchemaLocation(String _atValueSchemaLocation) {
		this._atValueSchemaLocation = _atValueSchemaLocation;
		return this;
	}

	/**
	 * This (optional) field provides a link to the schema describing the value
	 * type.
	 * 
	 * @return _atValueSchemaLocation
	 **/
	@Schema(description = "This (optional) field provides a link to the schema describing the value type.")

	public String getAtValueSchemaLocation() {
		return _atValueSchemaLocation;
	}

	public void setAtValueSchemaLocation(String _atValueSchemaLocation) {
		this._atValueSchemaLocation = _atValueSchemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CharacteristicSpecification characteristicSpecification = (CharacteristicSpecification) o;
		return Objects.equals(this.id, characteristicSpecification.id)
				&& Objects.equals(this.configurable, characteristicSpecification.configurable)
				&& Objects.equals(this.description, characteristicSpecification.description)
				&& Objects.equals(this.extensible, characteristicSpecification.extensible)
				&& Objects.equals(this.isUnique, characteristicSpecification.isUnique)
				&& Objects.equals(this.maxCardinality, characteristicSpecification.maxCardinality)
				&& Objects.equals(this.minCardinality, characteristicSpecification.minCardinality)
				&& Objects.equals(this.name, characteristicSpecification.name)
				&& Objects.equals(this.regex, characteristicSpecification.regex)
				&& Objects.equals(this.valueType, characteristicSpecification.valueType)
				&& Objects.equals(this.charSpecRelationship, characteristicSpecification.charSpecRelationship)
				&& Objects.equals(this.characteristicValueSpecification,
						characteristicSpecification.characteristicValueSpecification)
				&& Objects.equals(this.validFor, characteristicSpecification.validFor)
				&& Objects.equals(this.baseType, characteristicSpecification.baseType)
				&& Objects.equals(this.schemaLocation, characteristicSpecification.baseType)
				&& Objects.equals(this.type, characteristicSpecification.type)
				&& Objects.equals(this._atValueSchemaLocation, characteristicSpecification._atValueSchemaLocation);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, configurable, description, extensible, isUnique, maxCardinality, minCardinality, name, regex, valueType, charSpecRelationship, characteristicValueSpecification, validFor, baseType, schemaLocation, type, _atValueSchemaLocation);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CharacteristicSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
		sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    charSpecRelationship: ").append(toIndentedString(charSpecRelationship)).append("\n");
		sb.append("    characteristicValueSpecification: ").append(toIndentedString(characteristicValueSpecification))
				.append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    _atValueSchemaLocation: ").append(toIndentedString(_atValueSchemaLocation)).append("\n");
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

	public void updateWith(CharacteristicSpecification src) {
		this.name = src.getName();
		this.description = src.getDescription();
		this.maxCardinality = src.getMaxCardinality();
		this.minCardinality = src.getMinCardinality();
		this.regex = src.getRegex();
		this.isUnique = src.isUnique;
		this.configurable = src.isConfigurable();
		this.extensible = src.isExtensible();
		this.valueType = src.valueType;

		this.updateServiceSpecCharacteristicValues(src.getCharacteristicValueSpecification());
		this.updateServiceSpecCharRelationships(src.getCharSpecRelationship());

	}


	private void updateServiceSpecCharacteristicValues(
			@Valid Set<CharacteristicValueSpecification> srcSet) {
		

		Map<Integer, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (CharacteristicValueSpecification r : srcSet) {

			boolean valueExists = false;
			for (CharacteristicValueSpecification thisCharVal : this.characteristicValueSpecification ) {
				if ( thisCharVal.hashCode() == r.hashCode() ) {
					valueExists = true;
					idAddedUpdated.put(thisCharVal.hashCode(), true);
					break;
				}
			}
			
			if (!valueExists) {
				CharacteristicValueSpecification nr = new CharacteristicValueSpecification( r );
				this.addServiceSpecCharacteristicValueItem( nr );
				idAddedUpdated.put( nr.hashCode(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<CharacteristicValueSpecification> toRemove = new ArrayList<>();
		for (CharacteristicValueSpecification ss : this.characteristicValueSpecification) {
			if ( idAddedUpdated.get( ss.hashCode() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (CharacteristicValueSpecification r : toRemove) {
			this.characteristicValueSpecification.remove(r);
		}

	}

	private CharacteristicSpecification addServiceSpecCharacteristicValueItem(CharacteristicValueSpecification nr) {
		if (this.characteristicValueSpecification == null) {
			this.characteristicValueSpecification = new HashSet<CharacteristicValueSpecification>();
		}
		this.characteristicValueSpecification.add(nr);
		return this;
		
	}
	
	


	private void updateServiceSpecCharRelationships(
			@Valid Set<CharacteristicSpecificationRelationship> srcSet) {
		

		Map< String, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (CharacteristicSpecificationRelationship r : srcSet) {

			boolean valueExists = false;
			for (CharacteristicSpecificationRelationship thisCharVal : this.charSpecRelationship ) {
				if ( (thisCharVal.getCharacteristicSpecificationId()!=null) && (thisCharVal.getCharacteristicSpecificationId().equals(r.getCharacteristicSpecificationId() ) )) {
					valueExists = true;
					idAddedUpdated.put( thisCharVal.getCharacteristicSpecificationId() , true);
					break;
				}
			}
			
			if (!valueExists) {
				this.charSpecRelationship.add( new CharacteristicSpecificationRelationship( r ));
				idAddedUpdated.put( r.getCharacteristicSpecificationId(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<CharacteristicSpecificationRelationship> toRemove = new ArrayList<>();
		for (CharacteristicSpecificationRelationship ss : this.charSpecRelationship) {
			if ( idAddedUpdated.get( ss.getCharacteristicSpecificationId() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (CharacteristicSpecificationRelationship r : toRemove) {
			this.charSpecRelationship.remove(r);
		}
		
	}

}
