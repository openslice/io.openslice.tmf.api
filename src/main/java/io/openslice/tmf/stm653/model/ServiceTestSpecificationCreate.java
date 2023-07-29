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
package io.openslice.tmf.stm653.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href
 */
@Schema(description = "The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestSpecificationCreate extends ServiceTestSpecificationUpdate  {
 

  @JsonProperty("validFor")
  private TimePeriod validFor = null;


  public ServiceTestSpecificationCreate validFor(TimePeriod validFor) {
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



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestSpecificationCreate serviceTestSpecificationCreate = (ServiceTestSpecificationCreate) o;
    return Objects.equals(this.description, serviceTestSpecificationCreate.description) &&
        Objects.equals(this.isBundle, serviceTestSpecificationCreate.isBundle) &&
        Objects.equals(this.lastUpdate, serviceTestSpecificationCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceTestSpecificationCreate.lifecycleStatus) &&
        Objects.equals(this.name, serviceTestSpecificationCreate.name) &&
        Objects.equals(this.version, serviceTestSpecificationCreate.version) &&
        Objects.equals(this.attachment, serviceTestSpecificationCreate.attachment) &&
        Objects.equals(this.constraint, serviceTestSpecificationCreate.constraint) &&
        Objects.equals(this.entitySpecRelationship, serviceTestSpecificationCreate.entitySpecRelationship) &&
        Objects.equals(this.relatedParty, serviceTestSpecificationCreate.relatedParty) &&
        Objects.equals(this.relatedServiceSpecification, serviceTestSpecificationCreate.relatedServiceSpecification) &&
        Objects.equals(this.serviceTestSpecRelationship, serviceTestSpecificationCreate.serviceTestSpecRelationship) &&
        Objects.equals(this.specCharacteristic, serviceTestSpecificationCreate.specCharacteristic) &&
        Objects.equals(this.targetEntitySchema, serviceTestSpecificationCreate.targetEntitySchema) &&
        Objects.equals(this.testMeasureDefinition, serviceTestSpecificationCreate.testMeasureDefinition) &&
        Objects.equals(this.validFor, serviceTestSpecificationCreate.validFor) &&
        Objects.equals(this.baseType, serviceTestSpecificationCreate.baseType) &&
        Objects.equals(this.schemaLocation, serviceTestSpecificationCreate.schemaLocation) &&
        Objects.equals(this.type, serviceTestSpecificationCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint, entitySpecRelationship, relatedParty, relatedServiceSpecification, serviceTestSpecRelationship, specCharacteristic, targetEntitySchema, testMeasureDefinition, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecificationCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
    sb.append("    entitySpecRelationship: ").append(toIndentedString(entitySpecRelationship)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    relatedServiceSpecification: ").append(toIndentedString(relatedServiceSpecification)).append("\n");
    sb.append("    serviceTestSpecRelationship: ").append(toIndentedString(serviceTestSpecRelationship)).append("\n");
    sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
    sb.append("    targetEntitySchema: ").append(toIndentedString(targetEntitySchema)).append("\n");
    sb.append("    testMeasureDefinition: ").append(toIndentedString(testMeasureDefinition)).append("\n");
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
