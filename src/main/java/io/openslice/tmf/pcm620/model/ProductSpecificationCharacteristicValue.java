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

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A ProductSpecificationCharacteristicValue object is used to define a set of
 * attributes, each of which can be assigned to a corresponding set of
 * attributes in a ProductSpecificationCharacteristic object. The values of the
 * attributes in the ProductSpecificationCharacteristicValue object describe the
 * values of the attributes that a corresponding
 * ProductSpecificationCharacteristic object can take on.
 */
@ApiModel(description = "A ProductSpecificationCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ProductSpecificationCharacteristic object. The values of the attributes in the ProductSpecificationCharacteristicValue object describe the values of the attributes that a corresponding ProductSpecificationCharacteristic object can take on.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProdSpecCharValue")
@Table(name = "ProdSpecCharValue")
public class ProductSpecificationCharacteristicValue extends BaseRootEntity {
	@JsonProperty("isDefault")
	private Boolean isDefault = null;

	@JsonProperty("rangeInterval")
	private String rangeInterval = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("unitOfMeasure")
	private String unitOfMeasure = null;

	@JsonProperty("valueFrom")
	private String valueFrom = null;

	@JsonProperty("valueTo")
	private String valueTo = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("value")
	private Any value = null;
	

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;
	
	
	
	public ProductSpecificationCharacteristicValue() {
		
	}

	public ProductSpecificationCharacteristicValue(ProductSpecificationCharacteristicValue r) {
		this();
		isDefault = r.isDefault;
		rangeInterval = r.rangeInterval;
		regex = r.regex;
		unitOfMeasure = r.unitOfMeasure;
		valueFrom = r.valueFrom;
		valueTo = r.valueTo;
		valueType = r.valueType;
		validFor = new TimePeriod( r.validFor );
		value = new Any( r.value ) ;
//		type = r.type;
		baseType = r.baseType;
	}

	public ProductSpecificationCharacteristicValue isDefault(Boolean isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	/**
	 * Indicates if the value is the default value for a characteristic
	 * 
	 * @return isDefault
	 **/
	@ApiModelProperty(value = "Indicates if the value is the default value for a characteristic")

	public Boolean isIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public ProductSpecificationCharacteristicValue rangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
		return this;
	}

	/**
	 * An indicator that specifies the inclusion or exclusion of the valueFrom and
	 * valueTo attributes. If applicable, possible values are \"open\", \"closed\",
	 * \"closedBottom\" and \"closedTop\".
	 * 
	 * @return rangeInterval
	 **/
	@ApiModelProperty(value = "An indicator that specifies the inclusion or exclusion of the valueFrom and valueTo attributes. If applicable, possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".")

	public String getRangeInterval() {
		return rangeInterval;
	}

	public void setRangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
	}

	public ProductSpecificationCharacteristicValue regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * Regular expression to define constraint on the allowed value
	 * 
	 * @return regex
	 **/
	@ApiModelProperty(value = "Regular expression to define constraint on the allowed value")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public ProductSpecificationCharacteristicValue unitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	/**
	 * A length, surface, volume, dry measure, liquid measure, money, weight, time,
	 * and the like. In general, a determinate quantity or magnitude of the kind
	 * designated, taken as a standard of comparison for others of the same kind, in
	 * assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.
	 * 
	 * @return unitOfMeasure
	 **/
	@ApiModelProperty(value = "A length, surface, volume, dry measure, liquid measure, money, weight, time, and the like. In general, a determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.")

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public ProductSpecificationCharacteristicValue valueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
		return this;
	}

	/**
	 * The low range value that a characteristic can take on
	 * 
	 * @return valueFrom
	 **/
	@ApiModelProperty(value = "The low range value that a characteristic can take on")

	public String getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
	}

	public ProductSpecificationCharacteristicValue valueTo(String valueTo) {
		this.valueTo = valueTo;
		return this;
	}
	

	/**
	 * The period for which the entity is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the entity is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}



	/**
	 * The upper range value that a characteristic can take on
	 * 
	 * @return valueTo
	 **/
	@ApiModelProperty(value = "The upper range value that a characteristic can take on")

	public String getValueTo() {
		return valueTo;
	}

	public void setValueTo(String valueTo) {
		this.valueTo = valueTo;
	}

	public ProductSpecificationCharacteristicValue valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric, text,
	 * and so forth
	 * 
	 * @return valueType
	 **/
	@ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text, and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}



	public ProductSpecificationCharacteristicValue value(Any value) {
		this.value = value;
		return this;
	}

	/**
	 * A discrete value that the characteristic can take on, or the actual value of
	 * the characteristic
	 * 
	 * @return value
	 **/
	@ApiModelProperty(value = "A discrete value that the characteristic can take on, or the actual value of the characteristic")

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
		ProductSpecificationCharacteristicValue productSpecificationCharacteristicValue = (ProductSpecificationCharacteristicValue) o;
		return Objects.equals(this.isDefault, productSpecificationCharacteristicValue.isDefault)
				&& Objects.equals(this.rangeInterval, productSpecificationCharacteristicValue.rangeInterval)
				&& Objects.equals(this.regex, productSpecificationCharacteristicValue.regex)
				&& Objects.equals(this.unitOfMeasure, productSpecificationCharacteristicValue.unitOfMeasure)
				&& Objects.equals(this.valueFrom, productSpecificationCharacteristicValue.valueFrom)
				&& Objects.equals(this.valueTo, productSpecificationCharacteristicValue.valueTo)
				&& Objects.equals(this.valueType, productSpecificationCharacteristicValue.valueType)
				&& Objects.equals(this.validFor, productSpecificationCharacteristicValue.validFor)
				&& Objects.equals(this.value, productSpecificationCharacteristicValue.value)
				&& Objects.equals(this.baseType, productSpecificationCharacteristicValue.baseType)
				&& Objects.equals(this.schemaLocation, productSpecificationCharacteristicValue.schemaLocation)
				&& Objects.equals(this.type, productSpecificationCharacteristicValue.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(isDefault, rangeInterval, regex, unitOfMeasure, valueFrom, valueTo, valueType, validFor,
//				value, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductSpecificationCharacteristicValue {\n");

		sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
		sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
		sb.append("    valueFrom: ").append(toIndentedString(valueFrom)).append("\n");
		sb.append("    valueTo: ").append(toIndentedString(valueTo)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
}
