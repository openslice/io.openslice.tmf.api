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
package io.openslice.tmf.am651.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A characteristic quality or distinctive feature of an agreement.
 */
@ApiModel(description = "A characteristic quality or distinctive feature of an agreement.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementSpecCharacteristic   {
  @JsonProperty("configurable")
  private Boolean configurable = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("valueType")
  private String valueType = null;

  @JsonProperty("specCharacteristicValue")
  @Valid
  private List<AgreementSpecCharacteristicValue> specCharacteristicValue = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public AgreementSpecCharacteristic configurable(Boolean configurable) {
    this.configurable = configurable;
    return this;
  }

  /**
   * If true, the Boolean indicates that the characteristic is configurable
   * @return configurable
  **/
  @ApiModelProperty(value = "If true, the Boolean indicates that the characteristic is configurable")


  public Boolean isConfigurable() {
    return configurable;
  }

  public void setConfigurable(Boolean configurable) {
    this.configurable = configurable;
  }

  public AgreementSpecCharacteristic description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the characteristic is
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail what the characteristic is")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AgreementSpecCharacteristic name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the characteristic being specified.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the characteristic being specified.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AgreementSpecCharacteristic validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the specification characteristic is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the specification characteristic is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public AgreementSpecCharacteristic valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic can take on, such as numeric, text and so forth
   * @return valueType
  **/
  @ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text and so forth")


  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public AgreementSpecCharacteristic specCharacteristicValue(List<AgreementSpecCharacteristicValue> specCharacteristicValue) {
    this.specCharacteristicValue = specCharacteristicValue;
    return this;
  }

  public AgreementSpecCharacteristic addSpecCharacteristicValueItem(AgreementSpecCharacteristicValue specCharacteristicValueItem) {
    if (this.specCharacteristicValue == null) {
      this.specCharacteristicValue = new ArrayList<>();
    }
    this.specCharacteristicValue.add(specCharacteristicValueItem);
    return this;
  }

  /**
   * Get specCharacteristicValue
   * @return specCharacteristicValue
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementSpecCharacteristicValue> getSpecCharacteristicValue() {
    return specCharacteristicValue;
  }

  public void setSpecCharacteristicValue(List<AgreementSpecCharacteristicValue> specCharacteristicValue) {
    this.specCharacteristicValue = specCharacteristicValue;
  }

  public AgreementSpecCharacteristic type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @ApiModelProperty(value = "The class type of the actual resource (for type extension).")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AgreementSpecCharacteristic schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A link to the schema describing a resource (for type extension).
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A link to the schema describing a resource (for type extension).")


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
    AgreementSpecCharacteristic agreementSpecCharacteristic = (AgreementSpecCharacteristic) o;
    return Objects.equals(this.configurable, agreementSpecCharacteristic.configurable) &&
        Objects.equals(this.description, agreementSpecCharacteristic.description) &&
        Objects.equals(this.name, agreementSpecCharacteristic.name) &&
        Objects.equals(this.validFor, agreementSpecCharacteristic.validFor) &&
        Objects.equals(this.valueType, agreementSpecCharacteristic.valueType) &&
        Objects.equals(this.specCharacteristicValue, agreementSpecCharacteristic.specCharacteristicValue) &&
        Objects.equals(this.type, agreementSpecCharacteristic.type) &&
        Objects.equals(this.schemaLocation, agreementSpecCharacteristic.schemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configurable, description, name, validFor, valueType, specCharacteristicValue, type, schemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementSpecCharacteristic {\n");
    
    sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    specCharacteristicValue: ").append(toIndentedString(specCharacteristicValue)).append("\n");
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

