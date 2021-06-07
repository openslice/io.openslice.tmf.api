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
package io.openslice.tmf.rcm634.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines the characteristic features of a resource specification.
 * Every ResourceSpecification has a variety of important attributes, methods,
 * constraints, and relationships, which distinguish a resource specification
 * from other resource specifications.
 */
@ApiModel(description = "This class defines the characteristic features of a resource specification. Every ResourceSpecification has a variety of important attributes, methods, constraints, and relationships, which distinguish a resource specification from other resource specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "ResourceSpecCharacteristic")
public class ResourceSpecificationCharacteristic  extends BaseRootNamedEntity {


	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("configurable")
	private Boolean configurable = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	@JsonProperty("@valueSchemaLocation")
	private String valueSchemaLocation = null;

	@JsonProperty("minCardinality")
	private Integer minCardinality = null;

	@JsonProperty("maxCardinality")
	private Integer maxCardinality = null;

	@JsonProperty("isUnique")
	private Boolean isUnique = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("extensible")
	private Boolean extensible = null;

	@JsonProperty("resourceSpecCharRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceSpecCharRelationship> resourceSpecCharRelationship = new HashSet<>();;

	@JsonProperty("resourceSpecCharacteristicValue")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceSpecificationCharacteristicValue> ResourceSpecificationCharacteristicValue = new HashSet<>();;

	public ResourceSpecificationCharacteristic() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ResourceSpecificationCharacteristic(ResourceSpecificationCharacteristic src) {
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
		
		for (ResourceSpecCharRelationship r : src.resourceSpecCharRelationship) {
			this.addResourceSpecCharRelationshipItem( new ResourceSpecCharRelationship( r ));
		}
		
		for (ResourceSpecificationCharacteristicValue r : src.ResourceSpecificationCharacteristicValue) {
			this.addResourceSpecificationCharacteristicValueItem( new ResourceSpecificationCharacteristicValue(r) );
		}

	}

	public ResourceSpecificationCharacteristic name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A word, term, or phrase by which this characteristic specification is known
	 * and distinguished from other characteristic specifications.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceSpecificationCharacteristic description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative that explains the CharacteristicSpecification.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A narrative that explains the CharacteristicSpecification.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceSpecificationCharacteristic valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric, text
	 * and so forth
	 * 
	 * @return valueType
	 **/
	@ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public ResourceSpecificationCharacteristic configurable(Boolean configurable) {
		this.configurable = configurable;
		return this;
	}

	/**
	 * If true, the Boolean indicates that the ResourceSpecificationCharacteristic is
	 * configurable
	 * 
	 * @return configurable
	 **/
	@ApiModelProperty(value = "If true, the Boolean indicates that the ResourceSpecificationCharacteristic is configurable")

	public Boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	public ResourceSpecificationCharacteristic validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period of time for which a characteristic is applicable.
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period of time for which a characteristic is applicable.")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ResourceSpecificationCharacteristic type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * (Class) type of the ResourceSpecificationCharacteristic
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "(Class) type of the ResourceSpecificationCharacteristic")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ResourceSpecificationCharacteristic schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A link to the schema describing this characteristic specification
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "A link to the schema describing this characteristic specification")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ResourceSpecificationCharacteristic valueSchemaLocation(String valueSchemaLocation) {
		this.valueSchemaLocation = valueSchemaLocation;
		return this;
	}

	/**
	 * This (optional) field provides a link to the schema describing the value type
	 * 
	 * @return valueSchemaLocation
	 **/
	@ApiModelProperty(value = "This (optional) field provides a link to the schema describing the value type")

	public String getValueSchemaLocation() {
		return valueSchemaLocation;
	}

	public void setValueSchemaLocation(String valueSchemaLocation) {
		this.valueSchemaLocation = valueSchemaLocation;
	}

	public ResourceSpecificationCharacteristic minCardinality(Integer minCardinality) {
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
	@ApiModelProperty(value = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.")

	public Integer getMinCardinality() {
		return minCardinality;
	}

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}

	public ResourceSpecificationCharacteristic maxCardinality(Integer maxCardinality) {
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
	@ApiModelProperty(value = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.")

	public Integer getMaxCardinality() {
		return maxCardinality;
	}

	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}

	public ResourceSpecificationCharacteristic isUnique(Boolean isUnique) {
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
	@ApiModelProperty(value = "An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"")

	public Boolean isIsUnique() {
		return isUnique;
	}

	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	public ResourceSpecificationCharacteristic regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * A rule or principle represented in regular expression used to derive the
	 * value of a characteristic value.
	 * 
	 * @return regex
	 **/
	@ApiModelProperty(value = "A rule or principle represented in regular expression used to derive the value of a characteristic value.")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public ResourceSpecificationCharacteristic extensible(Boolean extensible) {
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
	@ApiModelProperty(value = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.")

	public Boolean isExtensible() {
		return extensible;
	}

	public void setExtensible(Boolean extensible) {
		this.extensible = extensible;
	}

	public ResourceSpecificationCharacteristic resourceSpecCharRelationship(
			Set<ResourceSpecCharRelationship> resourceSpecCharRelationship) {
		this.resourceSpecCharRelationship = resourceSpecCharRelationship;
		return this;
	}

	public ResourceSpecificationCharacteristic addResourceSpecCharRelationshipItem(
			ResourceSpecCharRelationship resourceSpecCharRelationshipItem) {
		if (this.resourceSpecCharRelationship == null) {
			this.resourceSpecCharRelationship = new HashSet<>();
		}
		this.resourceSpecCharRelationship.add(resourceSpecCharRelationshipItem);
		return this;
	}

	/**
	 * Get resourceSpecCharRelationship
	 * 
	 * @return resourceSpecCharRelationship
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<ResourceSpecCharRelationship> getResourceSpecCharRelationship() {
		return resourceSpecCharRelationship;
	}

	public void setResourceSpecCharRelationship(Set<ResourceSpecCharRelationship> resourceSpecCharRelationship) {
		this.resourceSpecCharRelationship = resourceSpecCharRelationship;
	}

	public ResourceSpecificationCharacteristic ResourceSpecificationCharacteristicValue(
			Set<ResourceSpecificationCharacteristicValue> ResourceSpecificationCharacteristicValue) {
		this.ResourceSpecificationCharacteristicValue = ResourceSpecificationCharacteristicValue;
		return this;
	}

	public ResourceSpecificationCharacteristic addResourceSpecificationCharacteristicValueItem(
			ResourceSpecificationCharacteristicValue ResourceSpecificationCharacteristicValueItem) {
		if (this.ResourceSpecificationCharacteristicValue == null) {
			this.ResourceSpecificationCharacteristicValue = new HashSet<>();
		}
		this.ResourceSpecificationCharacteristicValue.add(ResourceSpecificationCharacteristicValueItem);
		return this;
	}

	/**
	 * Get ResourceSpecificationCharacteristicValue
	 * 
	 * @return ResourceSpecificationCharacteristicValue
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<ResourceSpecificationCharacteristicValue> getResourceSpecificationCharacteristicValue() {
		return ResourceSpecificationCharacteristicValue;
	}

	public void setResourceSpecificationCharacteristicValue(
			Set<ResourceSpecificationCharacteristicValue> ResourceSpecificationCharacteristicValue) {
		this.ResourceSpecificationCharacteristicValue = ResourceSpecificationCharacteristicValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceSpecificationCharacteristic ResourceSpecificationCharacteristic = (ResourceSpecificationCharacteristic) o;
		return Objects.equals(this.name, ResourceSpecificationCharacteristic.name)
				&& Objects.equals(this.description, ResourceSpecificationCharacteristic.description)
				&& Objects.equals(this.valueType, ResourceSpecificationCharacteristic.valueType)
				&& Objects.equals(this.configurable, ResourceSpecificationCharacteristic.configurable)
				&& Objects.equals(this.validFor, ResourceSpecificationCharacteristic.validFor)
				&& Objects.equals(this.type, ResourceSpecificationCharacteristic.type)
				&& Objects.equals(this.schemaLocation, ResourceSpecificationCharacteristic.schemaLocation)
				&& Objects.equals(this.valueSchemaLocation, ResourceSpecificationCharacteristic.valueSchemaLocation)
				&& Objects.equals(this.minCardinality, ResourceSpecificationCharacteristic.minCardinality)
				&& Objects.equals(this.maxCardinality, ResourceSpecificationCharacteristic.maxCardinality)
				&& Objects.equals(this.isUnique, ResourceSpecificationCharacteristic.isUnique)
				&& Objects.equals(this.regex, ResourceSpecificationCharacteristic.regex)
				&& Objects.equals(this.extensible, ResourceSpecificationCharacteristic.extensible)
				&& Objects.equals(this.resourceSpecCharRelationship,
						ResourceSpecificationCharacteristic.resourceSpecCharRelationship)
				&& Objects.equals(this.ResourceSpecificationCharacteristicValue,
						ResourceSpecificationCharacteristic.ResourceSpecificationCharacteristicValue);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, name, description, valueType, configurable, validFor, type, schemaLocation,
//				valueSchemaLocation, minCardinality, maxCardinality, isUnique, regex, extensible,
//				resourceSpecCharRelationship, ResourceSpecificationCharacteristicValue);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecificationCharacteristic {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    valueSchemaLocation: ").append(toIndentedString(valueSchemaLocation)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
		sb.append("    resourceSpecCharRelationship: ").append(toIndentedString(resourceSpecCharRelationship))
				.append("\n");
		sb.append("    ResourceSpecificationCharacteristicValue: ").append(toIndentedString(ResourceSpecificationCharacteristicValue))
				.append("\n");
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

	public void updateWith(ResourceSpecificationCharacteristic src) {
		this.name = src.getName();
		this.description = src.getDescription();
		this.maxCardinality = src.getMaxCardinality();
		this.minCardinality = src.getMinCardinality();
		this.regex = src.getRegex();
		this.isUnique = src.isUnique;
		this.configurable = src.isConfigurable();
		this.extensible = src.isExtensible();

		this.updateResourceSpecificationCharacteristicValues(src.getResourceSpecificationCharacteristicValue());
		this.updateResourceSpecCharRelationships(src.getResourceSpecCharRelationship());

	}

	private void updateResourceSpecificationCharacteristicValues(@Valid Set<ResourceSpecificationCharacteristicValue> srcSet) {

		Map<Integer, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ResourceSpecificationCharacteristicValue r : srcSet) {

			boolean valueExists = false;
			for (ResourceSpecificationCharacteristicValue thisCharVal : this.ResourceSpecificationCharacteristicValue) {
				if (thisCharVal.hashCode() == r.hashCode()) {
					valueExists = true;
					idAddedUpdated.put(thisCharVal.hashCode(), true);
					break;
				}
			}

			if (!valueExists) {
				ResourceSpecificationCharacteristicValue nr = new ResourceSpecificationCharacteristicValue(r);
				this.addResourceSpecificationCharacteristicValueItem(nr);
				idAddedUpdated.put(nr.hashCode(), true);
			}

		}

		/**
		 * remove those that don't exist anymore
		 */

		List<ResourceSpecificationCharacteristicValue> toRemove = new ArrayList<>();
		for (ResourceSpecificationCharacteristicValue ss : this.ResourceSpecificationCharacteristicValue) {
			if (idAddedUpdated.get(ss.hashCode()) == null) {
				toRemove.add(ss);
			}
		}

		for (ResourceSpecificationCharacteristicValue r : toRemove) {
			this.ResourceSpecificationCharacteristicValue.remove(r);
		}

	}

	private void updateResourceSpecCharRelationships(@Valid Set<ResourceSpecCharRelationship> srcSet) {

		Map<String, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ResourceSpecCharRelationship r : srcSet) {

			boolean valueExists = false;
			for (ResourceSpecCharRelationship thisCharVal : this.resourceSpecCharRelationship) {
				if ((thisCharVal.getId() != null) && (thisCharVal.getId().equals(r.getId()))) {
					valueExists = true;
					idAddedUpdated.put(thisCharVal.getId(), true);
					break;
				}
			}

			if (!valueExists) {
				this.resourceSpecCharRelationship.add(new ResourceSpecCharRelationship(r));
				idAddedUpdated.put(r.getId(), true);
			}

		}

		/**
		 * remove those that don't exist anymore
		 */

		List<ResourceSpecCharRelationship> toRemove = new ArrayList<>();
		for (ResourceSpecCharRelationship ss : this.resourceSpecCharRelationship) {
			if (idAddedUpdated.get(ss.getId()) == null) {
				toRemove.add(ss);
			}
		}

		for (ResourceSpecCharRelationship r : toRemove) {
			this.resourceSpecCharRelationship.remove(r);
		}

	}
}
