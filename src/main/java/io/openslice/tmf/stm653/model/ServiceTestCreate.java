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

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A service test is an entity that exists for a controlled test invocation on a service. The service  test is executed according to a schedule and contains service test configuration parameters that are to be  applied at execution time, and service test measures that result. Skipped properties: id,href
 */
@Schema(description = "A service test is an entity that exists for a controlled test invocation on a service. The service  test is executed according to a schedule and contains service test configuration parameters that are to be  applied at execution time, and service test measures that result. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestCreate  extends ServiceTestUpdate {
  


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestCreate serviceTestCreate = (ServiceTestCreate) o;
    return Objects.equals(this.description, serviceTestCreate.description) &&
        Objects.equals(this.endDateTime, serviceTestCreate.endDateTime) &&
        Objects.equals(this.mode, serviceTestCreate.mode) &&
        Objects.equals(this.name, serviceTestCreate.name) &&
        Objects.equals(this.startDateTime, serviceTestCreate.startDateTime) &&
        Objects.equals(this.state, serviceTestCreate.state) &&
        Objects.equals(this.characteristic, serviceTestCreate.characteristic) &&
        Objects.equals(this.relatedParty, serviceTestCreate.relatedParty) &&
        Objects.equals(this.relatedService, serviceTestCreate.relatedService) &&
        Objects.equals(this.testMeasure, serviceTestCreate.testMeasure) &&
        Objects.equals(this.testSpecification, serviceTestCreate.testSpecification) &&
        Objects.equals(this.validFor, serviceTestCreate.validFor) &&
        Objects.equals(this.baseType, serviceTestCreate.baseType) &&
        Objects.equals(this.schemaLocation, serviceTestCreate.schemaLocation) &&
        Objects.equals(this.type, serviceTestCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, endDateTime, mode, name, startDateTime, state, characteristic, relatedParty, relatedService, testMeasure, testSpecification, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    relatedService: ").append(toIndentedString(relatedService)).append("\n");
    sb.append("    testMeasure: ").append(toIndentedString(testMeasure)).append("\n");
    sb.append("    testSpecification: ").append(toIndentedString(testSpecification)).append("\n");
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
