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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.am651.model.AgreementRef;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents entities that are orderable from the provider of the catalog, this resource includes pricing information. Skipped properties: id,href
 */
@ApiModel(description = "Represents entities that are orderable from the provider of the catalog, this resource includes pricing information. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class ProductOfferingCreate extends ProductOfferingUpdate  {
  

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;




  /**
   * Date and time of the last update
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingCreate productOfferingCreate = (ProductOfferingCreate) o;
    return Objects.equals(this.description, productOfferingCreate.description) &&
        Objects.equals(this.isBundle, productOfferingCreate.isBundle) &&
        Objects.equals(this.isSellable, productOfferingCreate.isSellable) &&
        Objects.equals(this.lastUpdate, productOfferingCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, productOfferingCreate.lifecycleStatus) &&
        Objects.equals(this.name, productOfferingCreate.name) &&
        Objects.equals(this.statusReason, productOfferingCreate.statusReason) &&
        Objects.equals(this.version, productOfferingCreate.version) &&
        Objects.equals(this.agreement, productOfferingCreate.agreement) &&
        Objects.equals(this.attachment, productOfferingCreate.attachment) &&
        Objects.equals(this.bundledProductOffering, productOfferingCreate.bundledProductOffering) &&
        Objects.equals(this.category, productOfferingCreate.category) &&
        Objects.equals(this.channel, productOfferingCreate.channel) &&
        Objects.equals(this.marketSegment, productOfferingCreate.marketSegment) &&
        Objects.equals(this.place, productOfferingCreate.place) &&
        Objects.equals(this.prodSpecCharValueUse, productOfferingCreate.prodSpecCharValueUse) &&
        Objects.equals(this.productOfferingPrice, productOfferingCreate.productOfferingPrice) &&
        Objects.equals(this.productOfferingTerm, productOfferingCreate.productOfferingTerm) &&
        Objects.equals(this.productSpecification, productOfferingCreate.productSpecification) &&
        Objects.equals(this.resourceCandidate, productOfferingCreate.resourceCandidate) &&
        Objects.equals(this.serviceCandidate, productOfferingCreate.serviceCandidate) &&
        Objects.equals(this.serviceLevelAgreement, productOfferingCreate.serviceLevelAgreement) &&
        Objects.equals(this.validFor, productOfferingCreate.validFor) &&
        Objects.equals(this.baseType, productOfferingCreate.baseType) &&
        Objects.equals(this.schemaLocation, productOfferingCreate.schemaLocation) &&
        Objects.equals(this.type, productOfferingCreate.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(description, isBundle, isSellable, lastUpdate, lifecycleStatus, name, statusReason, version, agreement, attachment, bundledProductOffering, category, channel, marketSegment, place, prodSpecCharValueUse, productOfferingPrice, productOfferingTerm, productSpecification, resourceCandidate, serviceCandidate, serviceLevelAgreement, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    isSellable: ").append(toIndentedString(isSellable)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    bundledProductOffering: ").append(toIndentedString(bundledProductOffering)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    marketSegment: ").append(toIndentedString(marketSegment)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    prodSpecCharValueUse: ").append(toIndentedString(prodSpecCharValueUse)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
    sb.append("    productOfferingTerm: ").append(toIndentedString(productOfferingTerm)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    resourceCandidate: ").append(toIndentedString(resourceCandidate)).append("\n");
    sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
    sb.append("    serviceLevelAgreement: ").append(toIndentedString(serviceLevelAgreement)).append("\n");
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

