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
package io.openslice.tmf.pcm620.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A characteristic quality or distinctive feature of a ProductSpecification.
 * The characteristic can be take on a discrete value, such as color, can take
 * on a range of values, (for example, sensitivity of 100-240 mV), or can be
 * derived from a formula (for example, usage time (hrs) &#x3D; 30 - talk time
 * *3). Certain characteristics, such as color, may be configured during the
 * ordering or some other process.
 */
@ApiModel(description = "A characteristic quality or distinctive feature of a ProductSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity
public class ProductSpecificationCharacteristic extends BaseEntity {
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


	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("productSpecCharRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationCharacteristicRelationship> productSpecCharRelationship = new HashSet<>();

	@JsonProperty("productSpecCharacteristicValue")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue = new HashSet<>();


	public ProductSpecificationCharacteristic configurable(Boolean configurable) {
		this.configurable = configurable;
		return this;
	}

	/**
	 * If true, the Boolean indicates that the ProductSpecificationCharacteristic is
	 * configurable
	 * 
	 * @return configurable
	 **/
	@ApiModelProperty(value = "If true, the Boolean indicates that the ProductSpecificationCharacteristic is configurable")

	public Boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	

	public ProductSpecificationCharacteristic extensible(Boolean extensible) {
		this.extensible = extensible;
		return this;
	}

	/**
	 * An indicator that specifies that the values for the characteristic can be
	 * extended by adding new values when instantiating a characteristic for a
	 * product
	 * 
	 * @return extensible
	 **/
	@ApiModelProperty(value = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a product")

	public Boolean isExtensible() {
		return extensible;
	}

	public void setExtensible(Boolean extensible) {
		this.extensible = extensible;
	}

	public ProductSpecificationCharacteristic isUnique(Boolean isUnique) {
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

	public ProductSpecificationCharacteristic maxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
		return this;
	}

	/**
	 * The maximum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where five is
	 * the value for the maxCardinality
	 * 
	 * @return maxCardinality
	 **/
	@ApiModelProperty(value = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality")

	public Integer getMaxCardinality() {
		return maxCardinality;
	}

	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}

	public ProductSpecificationCharacteristic minCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
		return this;
	}

	/**
	 * The minimum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where zero is
	 * the value for the minCardinality
	 * 
	 * @return minCardinality
	 **/
	@ApiModelProperty(value = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality")

	public Integer getMinCardinality() {
		return minCardinality;
	}

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}

	public ProductSpecificationCharacteristic regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * A rule or principle represented in regular expression used to derive the
	 * value of a characteristic value
	 * 
	 * @return regex
	 **/
	@ApiModelProperty(value = "A rule or principle represented in regular expression used to derive the value of a characteristic value")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public ProductSpecificationCharacteristic valueType(String valueType) {
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

	public ProductSpecificationCharacteristic productSpecCharRelationship(
			Set<ProductSpecificationCharacteristicRelationship> productSpecCharRelationship) {
		this.productSpecCharRelationship = productSpecCharRelationship;
		return this;
	}

	public ProductSpecificationCharacteristic addProductSpecCharRelationshipItem(
			ProductSpecificationCharacteristicRelationship productSpecCharRelationshipItem) {
		if (this.productSpecCharRelationship == null) {
			this.productSpecCharRelationship = new HashSet<>();
		}
		this.productSpecCharRelationship.add(productSpecCharRelationshipItem);
		return this;
	}

	/**
	 * An aggregation, migration, substitution, dependency or exclusivity
	 * relationship between/among Specification Characteristics.
	 * 
	 * @return productSpecCharRelationship
	 **/
	@ApiModelProperty(value = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.")

	@Valid

	public Set<ProductSpecificationCharacteristicRelationship> getProductSpecCharRelationship() {
		return productSpecCharRelationship;
	}

	public void setProductSpecCharRelationship(
			Set<ProductSpecificationCharacteristicRelationship> productSpecCharRelationship) {
		this.productSpecCharRelationship = productSpecCharRelationship;
	}

	public ProductSpecificationCharacteristic productSpecCharacteristicValue(
			Set<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue) {
		this.productSpecCharacteristicValue = productSpecCharacteristicValue;
		return this;
	}

	public ProductSpecificationCharacteristic addProductSpecCharacteristicValueItem(
			ProductSpecificationCharacteristicValue productSpecCharacteristicValueItem) {
		if (this.productSpecCharacteristicValue == null) {
			this.productSpecCharacteristicValue = new HashSet<>();
		}
		this.productSpecCharacteristicValue.add(productSpecCharacteristicValueItem);
		return this;
	}

	/**
	 * A ProductSpecificationCharacteristicValue object is used to define a set of
	 * attributes, each of which can be assigned to a corresponding set of
	 * attributes in a ProductSpecificationCharacteristic object. The values of the
	 * attributes in the ProductSpecificationCharacteristicValue object describe the
	 * values of the attributes that a corresponding
	 * ProductSpecificationCharacteristic object can take on.
	 * 
	 * @return productSpecCharacteristicValue
	 **/
	@ApiModelProperty(value = "A ProductSpecificationCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ProductSpecificationCharacteristic object. The values of the attributes in the ProductSpecificationCharacteristicValue object describe the values of the attributes that a corresponding ProductSpecificationCharacteristic object can take on.")

	@Valid

	public Set<ProductSpecificationCharacteristicValue> getProductSpecCharacteristicValue() {
		return productSpecCharacteristicValue;
	}

	public void setProductSpecCharacteristicValue(
			Set<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue) {
		this.productSpecCharacteristicValue = productSpecCharacteristicValue;
	}

	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProductSpecificationCharacteristic productSpecificationCharacteristic = (ProductSpecificationCharacteristic) o;
		return Objects.equals(this.configurable, productSpecificationCharacteristic.configurable)
				&& Objects.equals(this.description, productSpecificationCharacteristic.description)
				&& Objects.equals(this.extensible, productSpecificationCharacteristic.extensible)
				&& Objects.equals(this.isUnique, productSpecificationCharacteristic.isUnique)
				&& Objects.equals(this.maxCardinality, productSpecificationCharacteristic.maxCardinality)
				&& Objects.equals(this.minCardinality, productSpecificationCharacteristic.minCardinality)
				&& Objects.equals(this.name, productSpecificationCharacteristic.name)
				&& Objects.equals(this.regex, productSpecificationCharacteristic.regex)
				&& Objects.equals(this.valueType, productSpecificationCharacteristic.valueType)
				&& Objects.equals(this.productSpecCharRelationship,
						productSpecificationCharacteristic.productSpecCharRelationship)
				&& Objects.equals(this.productSpecCharacteristicValue,
						productSpecificationCharacteristic.productSpecCharacteristicValue)
				&& Objects.equals(this.validFor, productSpecificationCharacteristic.validFor)
				&& Objects.equals(this.baseType, productSpecificationCharacteristic.baseType)
				&& Objects.equals(this.schemaLocation, productSpecificationCharacteristic.schemaLocation)
				&& Objects.equals(this.type, productSpecificationCharacteristic.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(configurable, description, extensible, isUnique, maxCardinality, minCardinality, name,
//				regex, valueType, productSpecCharRelationship, productSpecCharacteristicValue, validFor, baseType,
//				schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductSpecificationCharacteristic {\n");

		sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
		sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    productSpecCharRelationship: ").append(toIndentedString(productSpecCharRelationship))
				.append("\n");
		sb.append("    productSpecCharacteristicValue: ").append(toIndentedString(productSpecCharacteristicValue))
				.append("\n");
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
