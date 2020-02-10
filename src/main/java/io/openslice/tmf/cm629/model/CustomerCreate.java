/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.cm629.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.am651.model.AgreementRef;
import io.openslice.tmf.am666.model.AccountRef;
import io.openslice.tmf.am666.model.PaymentMethodRef;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  Skipped properties: id,href
 */
@ApiModel(description = " Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

public class CustomerCreate extends CustomerUpdate  {
 

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerCreate customerCreate = (CustomerCreate) o;
    return Objects.equals(this.name, customerCreate.name) &&
        Objects.equals(this.status, customerCreate.status) &&
        Objects.equals(this.statusReason, customerCreate.statusReason) &&
        Objects.equals(this.account, customerCreate.account) &&
        Objects.equals(this.agreement, customerCreate.agreement) &&
        Objects.equals(this.characteristic, customerCreate.characteristic) &&
        Objects.equals(this.contactMedium, customerCreate.contactMedium) &&
        Objects.equals(this.creditProfile, customerCreate.creditProfile) &&
        Objects.equals(this.engagedParty, customerCreate.engagedParty) &&
        Objects.equals(this.paymentMethod, customerCreate.paymentMethod) &&
        Objects.equals(this.relatedParty, customerCreate.relatedParty) &&
        Objects.equals(this.validFor, customerCreate.validFor) &&
        Objects.equals(this.baseType, customerCreate.baseType) &&
        Objects.equals(this.schemaLocation, customerCreate.schemaLocation) &&
        Objects.equals(this.type, customerCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status, statusReason, account, agreement, characteristic, contactMedium, creditProfile, engagedParty, paymentMethod, relatedParty, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
    sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
    sb.append("    engagedParty: ").append(toIndentedString(engagedParty)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

