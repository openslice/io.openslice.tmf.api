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
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role. Skipped properties: id,href
 */
@ApiModel(description = "Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class ProductSpecificationCreate extends ProductSpecificationUpdate  {
 
  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;


  public ProductSpecificationCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

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
    ProductSpecificationCreate productSpecificationCreate = (ProductSpecificationCreate) o;
    return Objects.equals(this.brand, productSpecificationCreate.brand) &&
        Objects.equals(this.description, productSpecificationCreate.description) &&
        Objects.equals(this.isBundle, productSpecificationCreate.isBundle) &&
        Objects.equals(this.lastUpdate, productSpecificationCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, productSpecificationCreate.lifecycleStatus) &&
        Objects.equals(this.name, productSpecificationCreate.name) &&
        Objects.equals(this.productNumber, productSpecificationCreate.productNumber) &&
        Objects.equals(this.version, productSpecificationCreate.version) &&
        Objects.equals(this.attachment, productSpecificationCreate.attachment) &&
        Objects.equals(this.bundledProductSpecification, productSpecificationCreate.bundledProductSpecification) &&
        Objects.equals(this.productSpecCharacteristic, productSpecificationCreate.productSpecCharacteristic) &&
        Objects.equals(this.productSpecificationRelationship, productSpecificationCreate.productSpecificationRelationship) &&
        Objects.equals(this.relatedParty, productSpecificationCreate.relatedParty) &&
        Objects.equals(this.resourceSpecification, productSpecificationCreate.resourceSpecification) &&
        Objects.equals(this.serviceSpecification, productSpecificationCreate.serviceSpecification) &&
        Objects.equals(this.targetProductSchema, productSpecificationCreate.targetProductSchema) &&
        Objects.equals(this.validFor, productSpecificationCreate.validFor) &&
        Objects.equals(this.baseType, productSpecificationCreate.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationCreate.schemaLocation) &&
        Objects.equals(this.type, productSpecificationCreate.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(brand, description, isBundle, lastUpdate, lifecycleStatus, name, productNumber, version, attachment, bundledProductSpecification, productSpecCharacteristic, productSpecificationRelationship, relatedParty, resourceSpecification, serviceSpecification, targetProductSchema, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationCreate {\n");
    
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productNumber: ").append(toIndentedString(productNumber)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    bundledProductSpecification: ").append(toIndentedString(bundledProductSpecification)).append("\n");
    sb.append("    productSpecCharacteristic: ").append(toIndentedString(productSpecCharacteristic)).append("\n");
    sb.append("    productSpecificationRelationship: ").append(toIndentedString(productSpecificationRelationship)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
    sb.append("    targetProductSchema: ").append(toIndentedString(targetProductSchema)).append("\n");
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

