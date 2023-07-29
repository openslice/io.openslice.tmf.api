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
import jakarta.validation.constraints.NotNull;

/**
 * A number or text that can be assigned to a FeatureSpecificationCharacteristic.
 */
@Schema(description = "A number or text that can be assigned to a FeatureSpecificationCharacteristic.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "RCMFeatureSpecCharVal")
public class FeatureSpecificationCharacteristicValue  extends BaseRootEntity {
	
  @JsonProperty("isDefault")
  private Boolean isDefault = null;

  @JsonProperty("rangeInterval")
  private String rangeInterval = null;

  @JsonProperty("regex")
  private String regex = null;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure = null;

  @JsonProperty("valueFrom")
  private Integer valueFrom = null;

  @JsonProperty("valueTo")
  private Integer valueTo = null;

  @JsonProperty("valueType")
  private String valueType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("value")
  private Any value = null;


  public FeatureSpecificationCharacteristicValue isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  /**
   * True if the value is the default value for a characteristic.
   * @return isDefault
  **/
  @Schema(description = "True if the value is the default value for a characteristic.")
  
    public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public FeatureSpecificationCharacteristicValue rangeInterval(String rangeInterval) {
    this.rangeInterval = rangeInterval;
    return this;
  }

  /**
   * Specifies the inclusion or exclusion of the valueFrom and valueTo attributes.
   * @return rangeInterval
  **/
  @Schema(description = "Specifies the inclusion or exclusion of the valueFrom and valueTo attributes.")
  
    public String getRangeInterval() {
    return rangeInterval;
  }

  public void setRangeInterval(String rangeInterval) {
    this.rangeInterval = rangeInterval;
  }

  public FeatureSpecificationCharacteristicValue regex(String regex) {
    this.regex = regex;
    return this;
  }

  /**
   * A regular expression constraint for given value.
   * @return regex
  **/
  @Schema(description = "A regular expression constraint for given value.")
  
    public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public FeatureSpecificationCharacteristicValue unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * A determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values.
   * @return unitOfMeasure
  **/
  @Schema(description = "A determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values.")
  
    public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public FeatureSpecificationCharacteristicValue valueFrom(Integer valueFrom) {
    this.valueFrom = valueFrom;
    return this;
  }

  /**
   * The low range value that a characteristic can take on.
   * @return valueFrom
  **/
  @Schema(description = "The low range value that a characteristic can take on.")
  
    public Integer getValueFrom() {
    return valueFrom;
  }

  public void setValueFrom(Integer valueFrom) {
    this.valueFrom = valueFrom;
  }

  public FeatureSpecificationCharacteristicValue valueTo(Integer valueTo) {
    this.valueTo = valueTo;
    return this;
  }

  /**
   * The upper range value that a characteristic can take on.
   * @return valueTo
  **/
  @Schema(description = "The upper range value that a characteristic can take on.")
  
    public Integer getValueTo() {
    return valueTo;
  }

  public void setValueTo(Integer valueTo) {
    this.valueTo = valueTo;
  }

  public FeatureSpecificationCharacteristicValue valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic value can take on.
   * @return valueType
  **/
  @Schema(description = "A kind of value that the characteristic value can take on.")
      @NotNull

    public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public FeatureSpecificationCharacteristicValue validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
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

  public FeatureSpecificationCharacteristicValue value(Any value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @Schema(description = "")
  
    @Valid
    public Any getValue() {
    return value;
  }

  public void setValue(Any value) {
    this.value = value;
  }

  public FeatureSpecificationCharacteristicValue _atBaseType(String _atBaseType) {
    this.baseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this.baseType = _atBaseType;
  }

  public FeatureSpecificationCharacteristicValue _atSchemaLocation(String _atSchemaLocation) {
    this.schemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this.schemaLocation = _atSchemaLocation;
  }

  public FeatureSpecificationCharacteristicValue _atType(String _atType) {
    this.type = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String _atType) {
    this.type = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeatureSpecificationCharacteristicValue featureSpecificationCharacteristicValue = (FeatureSpecificationCharacteristicValue) o;
    return Objects.equals(this.isDefault, featureSpecificationCharacteristicValue.isDefault) &&
        Objects.equals(this.rangeInterval, featureSpecificationCharacteristicValue.rangeInterval) &&
        Objects.equals(this.regex, featureSpecificationCharacteristicValue.regex) &&
        Objects.equals(this.unitOfMeasure, featureSpecificationCharacteristicValue.unitOfMeasure) &&
        Objects.equals(this.valueFrom, featureSpecificationCharacteristicValue.valueFrom) &&
        Objects.equals(this.valueTo, featureSpecificationCharacteristicValue.valueTo) &&
        Objects.equals(this.valueType, featureSpecificationCharacteristicValue.valueType) &&
        Objects.equals(this.validFor, featureSpecificationCharacteristicValue.validFor) &&
        Objects.equals(this.value, featureSpecificationCharacteristicValue.value) &&
        Objects.equals(this.baseType, featureSpecificationCharacteristicValue.baseType) &&
        Objects.equals(this.schemaLocation, featureSpecificationCharacteristicValue.schemaLocation) &&
        Objects.equals(this.type, featureSpecificationCharacteristicValue.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isDefault, rangeInterval, regex, unitOfMeasure, valueFrom, valueTo, valueType, validFor, value, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeatureSpecificationCharacteristicValue {\n");
    
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
    sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    valueFrom: ").append(toIndentedString(valueFrom)).append("\n");
    sb.append("    valueTo: ").append(toIndentedString(valueTo)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
