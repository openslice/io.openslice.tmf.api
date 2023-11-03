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
package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href
 */
@Schema(description = "This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class PhysicalResourceSpecificationCreate  extends PhysicalResourceSpecificationUpdate {
 
  @JsonProperty("@type")
  private String type = "PhysicalResourceSpecification";

  public PhysicalResourceSpecificationCreate name(String name) {
    this.name = name;
    return this;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalResourceSpecificationCreate physicalResourceSpecCreate = (PhysicalResourceSpecificationCreate) o;
    return Objects.equals(this.name, physicalResourceSpecCreate.name) &&
        Objects.equals(this.description, physicalResourceSpecCreate.description) &&
        Objects.equals(this.type, physicalResourceSpecCreate.type) &&
        Objects.equals(this.schemaLocation, physicalResourceSpecCreate.schemaLocation) &&
        Objects.equals(this.baseType, physicalResourceSpecCreate.baseType) &&
        Objects.equals(this.version, physicalResourceSpecCreate.version) &&
        Objects.equals(this.validFor, physicalResourceSpecCreate.validFor) &&
        Objects.equals(this.lifecycleStatus, physicalResourceSpecCreate.lifecycleStatus) &&
        Objects.equals(this.isBundle, physicalResourceSpecCreate.isBundle) &&
        Objects.equals(this.category, physicalResourceSpecCreate.category) &&
        Objects.equals(this.model, physicalResourceSpecCreate.model) &&
        Objects.equals(this.part, physicalResourceSpecCreate.part) &&
        Objects.equals(this.sku, physicalResourceSpecCreate.sku) &&
        Objects.equals(this.vendor, physicalResourceSpecCreate.vendor) &&
        Objects.equals(this.targetResourceSchema, physicalResourceSpecCreate.targetResourceSchema) &&
        Objects.equals(this.featureSpecification, physicalResourceSpecCreate.featureSpecification) &&
        Objects.equals(this.attachment, physicalResourceSpecCreate.attachment) &&
        Objects.equals(this.relatedParty, physicalResourceSpecCreate.relatedParty) &&
        Objects.equals(this.resourceSpecificationCharacteristic, physicalResourceSpecCreate.resourceSpecificationCharacteristic) &&
        Objects.equals(this.resourceSpecificationRelationship, physicalResourceSpecCreate.resourceSpecificationRelationship);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(name, description, type, _atSchemaLocation, _atBaseType, version, validFor, lastUpdate, lifecycleStatus, isBundle, category, model, part, sku, vendor, place, targetResourceSchema, feature, attachment, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalResourceSpecCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    part: ").append(toIndentedString(part)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
    sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
    sb.append("    featureSpecification: ").append(toIndentedString(featureSpecification)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecificationCharacteristic: ").append(toIndentedString(resourceSpecificationCharacteristic)).append("\n");
    sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecificationRelationship)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}

