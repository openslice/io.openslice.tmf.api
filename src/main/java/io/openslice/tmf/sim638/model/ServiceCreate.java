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
package io.openslice.tmf.sim638.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.Place;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceRelationship;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.common.model.service.ServiceStateType;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Service is a base class for defining the Service hierarchy. All Services are characterized as either being possibly visible and usable by a Customer or not. This gives rise to the two subclasses of Service: CustomerFacingService and ResourceFacingService. Skipped properties: id,href
 */
@ApiModel(description = "Service is a base class for defining the Service hierarchy. All Services are characterized as either being possibly visible and usable by a Customer or not. This gives rise to the two subclasses of Service: CustomerFacingService and ResourceFacingService. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")

public class ServiceCreate extends ServiceUpdate  {
 





  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCreate serviceCreate = (ServiceCreate) o;
    return Objects.equals(this.category, serviceCreate.category) &&
        Objects.equals(this.description, serviceCreate.description) &&
        Objects.equals(this.endDate, serviceCreate.endDate) &&
        Objects.equals(this.hasStarted, serviceCreate.hasStarted) &&
        Objects.equals(this.isServiceEnabled, serviceCreate.isServiceEnabled) &&
        Objects.equals(this.isStateful, serviceCreate.isStateful) &&
        Objects.equals(this.name, serviceCreate.name) &&
        Objects.equals(this.serviceDate, serviceCreate.serviceDate) &&
        Objects.equals(this.serviceType, serviceCreate.serviceType) &&
        Objects.equals(this.startDate, serviceCreate.startDate) &&
        Objects.equals(this.startMode, serviceCreate.startMode) &&
        Objects.equals(this.note, serviceCreate.note) &&
        Objects.equals(this.place, serviceCreate.place) &&
        Objects.equals(this.relatedParty, serviceCreate.relatedParty) &&
        Objects.equals(this.serviceCharacteristic, serviceCreate.serviceCharacteristic) &&
        Objects.equals(this.serviceOrder, serviceCreate.serviceOrder) &&
        Objects.equals(this.serviceRelationship, serviceCreate.serviceRelationship) &&
        Objects.equals(this.serviceSpecificationRef, serviceCreate.serviceSpecificationRef) &&
        Objects.equals(this.state, serviceCreate.state) &&
        Objects.equals(this.supportingResource, serviceCreate.supportingResource) &&
        Objects.equals(this.supportingService, serviceCreate.supportingService) &&
        Objects.equals(this.baseType, serviceCreate.baseType) &&
        Objects.equals(this.schemaLocation, serviceCreate.schemaLocation) &&
        Objects.equals(this.type, serviceCreate.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(category, description, endDate, hasStarted, isServiceEnabled, isStateful, name, serviceDate, serviceType, startDate, startMode, note, place, relatedParty, serviceCharacteristic, serviceOrder, serviceRelationship, serviceSpecification, state, supportingResource, supportingService, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCreate {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    hasStarted: ").append(toIndentedString(hasStarted)).append("\n");
    sb.append("    isServiceEnabled: ").append(toIndentedString(isServiceEnabled)).append("\n");
    sb.append("    isStateful: ").append(toIndentedString(isStateful)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceDate: ").append(toIndentedString(serviceDate)).append("\n");
    sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    startMode: ").append(toIndentedString(startMode)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    serviceCharacteristic: ").append(toIndentedString(serviceCharacteristic)).append("\n");
    sb.append("    serviceOrder: ").append(toIndentedString(serviceOrder)).append("\n");
    sb.append("    serviceRelationship: ").append(toIndentedString(serviceRelationship)).append("\n");
    sb.append("    serviceSpecificationRef: ").append(toIndentedString(serviceSpecificationRef)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    supportingResource: ").append(toIndentedString(supportingResource)).append("\n");
    sb.append("    supportingService: ").append(toIndentedString(supportingService)).append("\n");
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

