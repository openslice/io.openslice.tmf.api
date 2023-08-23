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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Configuration feature characteristic specification.
 */
@Schema(description = "Configuration feature characteristic specification.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "RCMFeatureSpecChar")
public class FeatureSpecificationCharacteristic  extends BaseEntity {
	@JsonProperty("configurable")
	private Boolean configurable = null;

	@JsonProperty("extensible")
	private Boolean extensible = null;

	@JsonProperty("isUnique")
	private Boolean isUnique = null;

	@JsonProperty("maxCardinality")
	private Integer maxCardinality = null;

	@JsonProperty("minCardinality")
	private Integer minCardinality = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("featureSpecCharRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<FeatureSpecificationCharacteristicRelationship> featureSpecCharRelationship =new HashSet<>();

	@JsonProperty("featureSpecCharacteristicValue")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<FeatureSpecificationCharacteristicValue> featureSpecCharacteristicValue =new HashSet<>();


	public FeatureSpecificationCharacteristic configurable(Boolean configurable) {
		this.configurable = configurable;
		return this;
	}

	/**
	 * True is the feature is configurable.
	 * 
	 * @return configurable
	 **/
	@Schema(description = "True is the feature is configurable.")

	public Boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	public FeatureSpecificationCharacteristic extensible(Boolean extensible) {
		this.extensible = extensible;
		return this;
	}

	/**
	 * An indicator that specifies that the values for the characteristic can be
	 * extended by adding new values when instantiating a characteristic for a
	 * feature.
	 * 
	 * @return extensible
	 **/
	@Schema(description = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a feature.")

	public Boolean isExtensible() {
		return extensible;
	}

	public void setExtensible(Boolean extensible) {
		this.extensible = extensible;
	}

	public FeatureSpecificationCharacteristic isUnique(Boolean isUnique) {
		this.isUnique = isUnique;
		return this;
	}

	/**
	 * An indicator that specifies if a value is unique for the specification.
	 * 
	 * @return isUnique
	 **/
	@Schema(description = "An indicator that specifies if a value is unique for the specification.")

	public Boolean isIsUnique() {
		return isUnique;
	}

	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	public FeatureSpecificationCharacteristic maxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
		return this;
	}

	/**
	 * The maximum number of instances a CharacteristicValue can take on.
	 * 
	 * @return maxCardinality
	 **/
	@Schema(description = "The maximum number of instances a CharacteristicValue can take on.")

	public Integer getMaxCardinality() {
		return maxCardinality;
	}

	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}

	public FeatureSpecificationCharacteristic minCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
		return this;
	}

	/**
	 * The minimum number of instances a CharacteristicValue can take on.
	 * 
	 * @return minCardinality
	 **/
	@Schema(description = "The minimum number of instances a CharacteristicValue can take on.")

	public Integer getMinCardinality() {
		return minCardinality;
	}

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}

	public FeatureSpecificationCharacteristic name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * This is the name for the feature charateristic.
	 * 
	 * @return name
	 **/
	@Schema(description = "This is the name for the feature charateristic.")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FeatureSpecificationCharacteristic regex(String regex) {
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

	public FeatureSpecificationCharacteristic valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on.
	 * 
	 * @return valueType
	 **/
	@Schema(description = "A kind of value that the characteristic can take on.")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public FeatureSpecificationCharacteristic featureSpecCharRelationship(
			Set<FeatureSpecificationCharacteristicRelationship> featureSpecCharRelationship) {
		this.featureSpecCharRelationship = featureSpecCharRelationship;
		return this;
	}

	public FeatureSpecificationCharacteristic addFeatureSpecCharRelationshipItem(
			FeatureSpecificationCharacteristicRelationship featureSpecCharRelationshipItem) {
		if (this.featureSpecCharRelationship == null) {
			this.featureSpecCharRelationship = new HashSet<>();
		}
		this.featureSpecCharRelationship.add(featureSpecCharRelationshipItem);
		return this;
	}

	/**
	 * An aggregation, migration, substitution, dependency or exclusivity
	 * relationship between/among feature characteristics.
	 * 
	 * @return featureSpecCharRelationship
	 **/
	@Schema(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among feature characteristics.")
	@Valid
	public Set<FeatureSpecificationCharacteristicRelationship> getFeatureSpecCharRelationship() {
		return featureSpecCharRelationship;
	}

	public void setFeatureSpecCharRelationship(
			Set<FeatureSpecificationCharacteristicRelationship> featureSpecCharRelationship) {
		this.featureSpecCharRelationship = featureSpecCharRelationship;
	}

	public FeatureSpecificationCharacteristic featureSpecCharacteristicValue(
			Set<FeatureSpecificationCharacteristicValue> featureSpecCharacteristicValue) {
		this.featureSpecCharacteristicValue = featureSpecCharacteristicValue;
		return this;
	}

	public FeatureSpecificationCharacteristic addFeatureSpecCharacteristicValueItem(
			FeatureSpecificationCharacteristicValue featureSpecCharacteristicValueItem) {
		if (this.featureSpecCharacteristicValue == null) {
			this.featureSpecCharacteristicValue = new HashSet<>();
		}
		this.featureSpecCharacteristicValue.add(featureSpecCharacteristicValueItem);
		return this;
	}

	/**
	 * Used to define a set of attributes, each of which can be assigned to a
	 * corresponding set of attributes in a FeatureCharacteristic object.
	 * 
	 * @return featureSpecCharacteristicValue
	 **/
	@Schema(description = "Used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a FeatureCharacteristic object.")
	@Valid
	public Set<FeatureSpecificationCharacteristicValue> getFeatureSpecCharacteristicValue() {
		return featureSpecCharacteristicValue;
	}

	public void setFeatureSpecCharacteristicValue(
			Set<FeatureSpecificationCharacteristicValue> featureSpecCharacteristicValue) {
		this.featureSpecCharacteristicValue = featureSpecCharacteristicValue;
	}

	public FeatureSpecificationCharacteristic validFor(TimePeriod validFor) {
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

	

	public FeatureSpecificationCharacteristic _atValueSchemaLocation(String _atValueSchemaLocation) {
		this.schemaLocation = _atValueSchemaLocation;
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
		return schemaLocation;
	}

	public void setAtValueSchemaLocation(String _atValueSchemaLocation) {
		this.schemaLocation = _atValueSchemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FeatureSpecificationCharacteristic featureSpecificationCharacteristic = (FeatureSpecificationCharacteristic) o;
		return Objects.equals(this.configurable, featureSpecificationCharacteristic.configurable)
				&& Objects.equals(this.extensible, featureSpecificationCharacteristic.extensible)
				&& Objects.equals(this.isUnique, featureSpecificationCharacteristic.isUnique)
				&& Objects.equals(this.maxCardinality, featureSpecificationCharacteristic.maxCardinality)
				&& Objects.equals(this.minCardinality, featureSpecificationCharacteristic.minCardinality)
				&& Objects.equals(this.name, featureSpecificationCharacteristic.name)
				&& Objects.equals(this.regex, featureSpecificationCharacteristic.regex)
				&& Objects.equals(this.valueType, featureSpecificationCharacteristic.valueType)
				&& Objects.equals(this.featureSpecCharRelationship,
						featureSpecificationCharacteristic.featureSpecCharRelationship)
				&& Objects.equals(this.featureSpecCharacteristicValue,
						featureSpecificationCharacteristic.featureSpecCharacteristicValue)
				&& Objects.equals(this.validFor, featureSpecificationCharacteristic.validFor)
				&& Objects.equals(this.baseType, featureSpecificationCharacteristic.baseType)
				&& Objects.equals(this.schemaLocation, featureSpecificationCharacteristic.schemaLocation)
				&& Objects.equals(this.type, featureSpecificationCharacteristic.type) && Objects
						.equals(this.schemaLocation, featureSpecificationCharacteristic.schemaLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(configurable, extensible, isUnique, maxCardinality, minCardinality, name, regex, valueType,
				featureSpecCharRelationship, featureSpecCharacteristicValue, validFor, baseType, schemaLocation,
				type, schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FeatureSpecificationCharacteristic {\n");

		sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
		sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
		sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    featureSpecCharRelationship: ").append(toIndentedString(featureSpecCharRelationship))
				.append("\n");
		sb.append("    featureSpecCharacteristicValue: ").append(toIndentedString(featureSpecCharacteristicValue))
				.append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
		sb.append("    _atValueSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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
