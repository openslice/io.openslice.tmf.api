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
package io.openslice.tmf.pm632.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Organization represents a group of people identified by shared interests or purpose. Examples include business, department and enterprise. Because of the complex nature of many businesses, both organizations and organization units are represented by the same data. Skipped properties: id,href
 */
@ApiModel(description = "Organization represents a group of people identified by shared interests or purpose. Examples include business, department and enterprise. Because of the complex nature of many businesses, both organizations and organization units are represented by the same data. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class OrganizationCreate  extends OrganizationUpdate {
 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationCreate organizationCreate = (OrganizationCreate) o;
    return Objects.equals(this.isHeadOffice, organizationCreate.isHeadOffice) &&
        Objects.equals(this.isLegalEntity, organizationCreate.isLegalEntity) &&
        Objects.equals(this.name, organizationCreate.name) &&
        Objects.equals(this.nameType, organizationCreate.nameType) &&
        Objects.equals(this.organizationType, organizationCreate.organizationType) &&
        Objects.equals(this.tradingName, organizationCreate.tradingName) &&
        Objects.equals(this.contactMedium, organizationCreate.contactMedium) &&
        Objects.equals(this.creditRating, organizationCreate.creditRating) &&
        Objects.equals(this.existsDuring, organizationCreate.existsDuring) &&
        Objects.equals(this.externalReference, organizationCreate.externalReference) &&
        Objects.equals(this.organizationChildRelationship, organizationCreate.organizationChildRelationship) &&
        Objects.equals(this.organizationIdentification, organizationCreate.organizationIdentification) &&
        Objects.equals(this.organizationParentRelationship, organizationCreate.organizationParentRelationship) &&
        Objects.equals(this.otherName, organizationCreate.otherName) &&
        Objects.equals(this.partyCharacteristic, organizationCreate.partyCharacteristic) &&
        Objects.equals(this.relatedParty, organizationCreate.relatedParty) &&
        Objects.equals(this.status, organizationCreate.status) &&
        Objects.equals(this.taxExemptionCertificate, organizationCreate.taxExemptionCertificate) &&
        Objects.equals(this.baseType, organizationCreate.baseType) &&
        Objects.equals(this.schemaLocation, organizationCreate.schemaLocation) &&
        Objects.equals(this.type, organizationCreate.type);
  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(isHeadOffice, isLegalEntity, name, nameType, organizationType, tradingName, contactMedium, creditRating, existsDuring, externalReference, organizationChildRelationship, organizationIdentification, organizationParentRelationship, otherName, partyCharacteristic, relatedParty, status, taxExemptionCertificate, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationCreate {\n");
    
    sb.append("    isHeadOffice: ").append(toIndentedString(isHeadOffice)).append("\n");
    sb.append("    isLegalEntity: ").append(toIndentedString(isLegalEntity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nameType: ").append(toIndentedString(nameType)).append("\n");
    sb.append("    organizationType: ").append(toIndentedString(organizationType)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
    sb.append("    creditRating: ").append(toIndentedString(creditRating)).append("\n");
    sb.append("    existsDuring: ").append(toIndentedString(existsDuring)).append("\n");
    sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
    sb.append("    organizationChildRelationship: ").append(toIndentedString(organizationChildRelationship)).append("\n");
    sb.append("    organizationIdentification: ").append(toIndentedString(organizationIdentification)).append("\n");
    sb.append("    organizationParentRelationship: ").append(toIndentedString(organizationParentRelationship)).append("\n");
    sb.append("    otherName: ").append(toIndentedString(otherName)).append("\n");
    sb.append("    partyCharacteristic: ").append(toIndentedString(partyCharacteristic)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    taxExemptionCertificate: ").append(toIndentedString(taxExemptionCertificate)).append("\n");
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

