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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

/**
 * A number or text that can be assigned to a ResourceSpecCharacteristic.
 */
@Schema(description = "A number or text that can be assigned to a ResourceSpecCharacteristic.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Entity(name = "ResourceSpecCharacteristicValue")
public class ResourceSpecificationCharacteristicValue  extends BaseRootEntity {
	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("isDefault")
	private Boolean isDefault = null;

	@JsonProperty("value")
	private Any value = null;

	@JsonProperty("unitOfMeasure")
	private String unitOfMeasure = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("valueFrom")
	private Integer valueFrom = null;

	@JsonProperty("valueTo")
	private Integer valueTo = null;

	@JsonProperty("rangeInterval")
	private String rangeInterval = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	public ResourceSpecificationCharacteristicValue() {
	}

	public ResourceSpecificationCharacteristicValue(ResourceSpecificationCharacteristicValue r) {
		this();
		isDefault = r.isDefault;
		rangeInterval = r.rangeInterval;
		regex = r.regex;
		unitOfMeasure = r.unitOfMeasure;
		valueFrom = r.valueFrom;
		valueTo = r.valueTo;
		valueType = r.valueType;
		validFor = new TimePeriod( r.validFor );
		if (r.value !=null ) {
			value = new Any( r.value.getValue(), r.value.getAlias()) ;
		}
//		type = r.type;
		baseType = r.baseType;
		
	}

	
	public ResourceSpecificationCharacteristicValue valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic value can take on, such as numeric,
	 * text and so forth
	 * 
	 * @return valueType
	 **/
	@Schema(description = "A kind of value that the characteristic value can take on, such as numeric, text and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public ResourceSpecificationCharacteristicValue isDefault(Boolean isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	/**
	 * If true, the Boolean Indicates if the value is the default value for a
	 * characteristic
	 * 
	 * @return isDefault
	 **/
	@Schema(description = "If true, the Boolean Indicates if the value is the default value for a characteristic")

	public Boolean isIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public ResourceSpecificationCharacteristicValue value(Any value) {
		this.value = value;
		return this;
	}

	/**
	 * The value that the characteristic can take on. If the value is a complex
	 * type, the definition of the type should be found by the link as defined
	 * in @schemaLocation
	 * 
	 * @return value
	 **/
	@Schema(description = "The value that the characteristic can take on. If the value is a complex type, the definition of the type should be found by the link as defined in @schemaLocation")

	public Any getValue() {
		return value;
	}

	public void setValue(Any value) {
		this.value = value;
	}

	public ResourceSpecificationCharacteristicValue unitOfMeasure(String unitOfMeasure) {
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
	@Schema(description = "A length, surface, volume, dry measure, liquid measure, money, weight, time, and the like. In general, a determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.")

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public ResourceSpecificationCharacteristicValue validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period of time for which a value is applicable.
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The period of time for which a value is applicable.")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ResourceSpecificationCharacteristicValue valueFrom(Integer valueFrom) {
		this.valueFrom = valueFrom;
		return this;
	}

	/**
	 * The low range value that a characteristic can take on
	 * 
	 * @return valueFrom
	 **/
	@Schema(description = "The low range value that a characteristic can take on")

	public Integer getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(Integer valueFrom) {
		this.valueFrom = valueFrom;
	}

	public ResourceSpecificationCharacteristicValue valueTo(Integer valueTo) {
		this.valueTo = valueTo;
		return this;
	}

	/**
	 * The upper range value that a characteristic can take on
	 * 
	 * @return valueTo
	 **/
	@Schema(description = "The upper range value that a characteristic can take on")

	public Integer getValueTo() {
		return valueTo;
	}

	public void setValueTo(Integer valueTo) {
		this.valueTo = valueTo;
	}

	public ResourceSpecificationCharacteristicValue rangeInterval(String rangeInterval) {
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
	@Schema(description = "An indicator that specifies the inclusion or exclusion of the valueFrom and valueTo attributes. If applicable, possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".")

	public String getRangeInterval() {
		return rangeInterval;
	}

	public void setRangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
	}

	public ResourceSpecificationCharacteristicValue regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * A regular expression constraint for given value
	 * 
	 * @return regex
	 **/
	@Schema(description = "A regular expression constraint for given value")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public ResourceSpecificationCharacteristicValue type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * The class type of a complex value type
	 * 
	 * @return type
	 **/
	@Schema(description = "The class type of a complex value type")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ResourceSpecificationCharacteristicValue schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * This (optional) field provides a link to the schema describing the value type
	 * 
	 * @return schemaLocation
	 **/
	@Schema(description = "This (optional) field provides a link to the schema describing the value type")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceSpecificationCharacteristicValue resourceSpecCharacteristicValue = (ResourceSpecificationCharacteristicValue) o;
		return Objects.equals(this.valueType, resourceSpecCharacteristicValue.valueType)
				&& Objects.equals(this.isDefault, resourceSpecCharacteristicValue.isDefault)
				&& Objects.equals(this.value, resourceSpecCharacteristicValue.value)
				&& Objects.equals(this.unitOfMeasure, resourceSpecCharacteristicValue.unitOfMeasure)
				&& Objects.equals(this.validFor, resourceSpecCharacteristicValue.validFor)
				&& Objects.equals(this.valueFrom, resourceSpecCharacteristicValue.valueFrom)
				&& Objects.equals(this.valueTo, resourceSpecCharacteristicValue.valueTo)
				&& Objects.equals(this.rangeInterval, resourceSpecCharacteristicValue.rangeInterval)
				&& Objects.equals(this.regex, resourceSpecCharacteristicValue.regex)
				&& Objects.equals(this.type, resourceSpecCharacteristicValue.type)
				&& Objects.equals(this.schemaLocation, resourceSpecCharacteristicValue.schemaLocation);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid,valueType, isDefault, value, unitOfMeasure, validFor, valueFrom, valueTo, rangeInterval,
//				regex, type, schemaLocation);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecCharacteristicValue {\n");

		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    valueFrom: ").append(toIndentedString(valueFrom)).append("\n");
		sb.append("    valueTo: ").append(toIndentedString(valueTo)).append("\n");
		sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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
