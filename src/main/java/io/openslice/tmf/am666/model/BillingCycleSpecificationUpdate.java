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
package io.openslice.tmf.am666.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A detailed description of when to initiate a billing cycle and the various sub steps of a billing cycle. Skipped properties: id,href
 */
@ApiModel(description = "A detailed description of when to initiate a billing cycle and the various sub steps of a billing cycle. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class BillingCycleSpecificationUpdate   {
  @JsonProperty("billingDateShift")
  private Integer billingDateShift = null;

  @JsonProperty("billingPeriod")
  private String billingPeriod = null;

  @JsonProperty("chargeDateOffset")
  private Integer chargeDateOffset = null;

  @JsonProperty("creditDateOffset")
  private Integer creditDateOffset = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("frequency")
  private String frequency = null;

  @JsonProperty("mailingDateOffset")
  private Integer mailingDateOffset = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("paymentDueDateOffset")
  private Integer paymentDueDateOffset = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public BillingCycleSpecificationUpdate billingDateShift(Integer billingDateShift) {
    this.billingDateShift = billingDateShift;
    return this;
  }

  /**
   * An offset of a billing/settlement date. The offset is expressed as number of days with regard to the start of the billing/settlement period.
   * @return billingDateShift
  **/
  @ApiModelProperty(value = "An offset of a billing/settlement date. The offset is expressed as number of days with regard to the start of the billing/settlement period.")


  public Integer getBillingDateShift() {
    return billingDateShift;
  }

  public void setBillingDateShift(Integer billingDateShift) {
    this.billingDateShift = billingDateShift;
  }

  public BillingCycleSpecificationUpdate billingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

  /**
   * A billing time period. It can be recurring, for example: week, month, quarter of year, year .
   * @return billingPeriod
  **/
  @ApiModelProperty(value = "A billing time period. It can be recurring, for example: week, month, quarter of year, year .")


  public String getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(String billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public BillingCycleSpecificationUpdate chargeDateOffset(Integer chargeDateOffset) {
    this.chargeDateOffset = chargeDateOffset;
    return this;
  }

  /**
   * An offset of a date through which charges previously received by the billing system will appear on the bill. The offset is expressed as number of days with regard to the start of the BillingPeriod.
   * @return chargeDateOffset
  **/
  @ApiModelProperty(value = "An offset of a date through which charges previously received by the billing system will appear on the bill. The offset is expressed as number of days with regard to the start of the BillingPeriod.")


  public Integer getChargeDateOffset() {
    return chargeDateOffset;
  }

  public void setChargeDateOffset(Integer chargeDateOffset) {
    this.chargeDateOffset = chargeDateOffset;
  }

  public BillingCycleSpecificationUpdate creditDateOffset(Integer creditDateOffset) {
    this.creditDateOffset = creditDateOffset;
    return this;
  }

  /**
   * An offset of a date through which credits previously received by the billing system will appear on the bill. The offset is expressed as number of days with regard to the start of the BillingPeriod.
   * @return creditDateOffset
  **/
  @ApiModelProperty(value = "An offset of a date through which credits previously received by the billing system will appear on the bill. The offset is expressed as number of days with regard to the start of the BillingPeriod.")


  public Integer getCreditDateOffset() {
    return creditDateOffset;
  }

  public void setCreditDateOffset(Integer creditDateOffset) {
    this.creditDateOffset = creditDateOffset;
  }

  public BillingCycleSpecificationUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explanation regarding this billing cycle specification
   * @return description
  **/
  @ApiModelProperty(value = "An explanation regarding this billing cycle specification")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BillingCycleSpecificationUpdate frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Frequency of the billing cycle (monthly for instance)
   * @return frequency
  **/
  @ApiModelProperty(value = "Frequency of the billing cycle (monthly for instance)")


  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public BillingCycleSpecificationUpdate mailingDateOffset(Integer mailingDateOffset) {
    this.mailingDateOffset = mailingDateOffset;
    return this;
  }

  /**
   * An offset of a customer bill mailing date. The offset is expressed as number of days with regard to the start of the BillingPeriod.
   * @return mailingDateOffset
  **/
  @ApiModelProperty(value = "An offset of a customer bill mailing date. The offset is expressed as number of days with regard to the start of the BillingPeriod.")


  public Integer getMailingDateOffset() {
    return mailingDateOffset;
  }

  public void setMailingDateOffset(Integer mailingDateOffset) {
    this.mailingDateOffset = mailingDateOffset;
  }

  public BillingCycleSpecificationUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A short descriptive name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A short descriptive name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BillingCycleSpecificationUpdate paymentDueDateOffset(Integer paymentDueDateOffset) {
    this.paymentDueDateOffset = paymentDueDateOffset;
    return this;
  }

  /**
   * An offset of a payment due date. The offset is expressed as number of days with regard to the start of the BillingPeriod.
   * @return paymentDueDateOffset
  **/
  @ApiModelProperty(value = "An offset of a payment due date. The offset is expressed as number of days with regard to the start of the BillingPeriod.")


  public Integer getPaymentDueDateOffset() {
    return paymentDueDateOffset;
  }

  public void setPaymentDueDateOffset(Integer paymentDueDateOffset) {
    this.paymentDueDateOffset = paymentDueDateOffset;
  }

  public BillingCycleSpecificationUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the billing specification cycle is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the billing specification cycle is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public BillingCycleSpecificationUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public BillingCycleSpecificationUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public BillingCycleSpecificationUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingCycleSpecificationUpdate billingCycleSpecificationUpdate = (BillingCycleSpecificationUpdate) o;
    return Objects.equals(this.billingDateShift, billingCycleSpecificationUpdate.billingDateShift) &&
        Objects.equals(this.billingPeriod, billingCycleSpecificationUpdate.billingPeriod) &&
        Objects.equals(this.chargeDateOffset, billingCycleSpecificationUpdate.chargeDateOffset) &&
        Objects.equals(this.creditDateOffset, billingCycleSpecificationUpdate.creditDateOffset) &&
        Objects.equals(this.description, billingCycleSpecificationUpdate.description) &&
        Objects.equals(this.frequency, billingCycleSpecificationUpdate.frequency) &&
        Objects.equals(this.mailingDateOffset, billingCycleSpecificationUpdate.mailingDateOffset) &&
        Objects.equals(this.name, billingCycleSpecificationUpdate.name) &&
        Objects.equals(this.paymentDueDateOffset, billingCycleSpecificationUpdate.paymentDueDateOffset) &&
        Objects.equals(this.validFor, billingCycleSpecificationUpdate.validFor) &&
        Objects.equals(this.baseType, billingCycleSpecificationUpdate.baseType) &&
        Objects.equals(this.schemaLocation, billingCycleSpecificationUpdate.schemaLocation) &&
        Objects.equals(this.type, billingCycleSpecificationUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingDateShift, billingPeriod, chargeDateOffset, creditDateOffset, description, frequency, mailingDateOffset, name, paymentDueDateOffset, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingCycleSpecificationUpdate {\n");
    
    sb.append("    billingDateShift: ").append(toIndentedString(billingDateShift)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    chargeDateOffset: ").append(toIndentedString(chargeDateOffset)).append("\n");
    sb.append("    creditDateOffset: ").append(toIndentedString(creditDateOffset)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    mailingDateOffset: ").append(toIndentedString(mailingDateOffset)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    paymentDueDateOffset: ").append(toIndentedString(paymentDueDateOffset)).append("\n");
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

