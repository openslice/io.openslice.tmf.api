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
package io.openslice.tmf.po622.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Refers an appointment, such as a Customer presentation or internal meeting or site visit
 */
@Schema(description = "Refers an appointment, such as a Customer presentation or internal meeting or site visit")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class AppointmentRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public AppointmentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of the referred appointment
   * @return id
  **/
  @Schema(description = "The identifier of the referred appointment")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AppointmentRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The reference of the appointment
   * @return href
  **/
  @Schema(description = "The reference of the appointment")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AppointmentRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explanatory text regarding the appointment made with a party
   * @return description
  **/
  @Schema(description = "An explanatory text regarding the appointment made with a party")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AppointmentRef baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public AppointmentRef schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public AppointmentRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String type) {
    this.type = type;
  }

  public AppointmentRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation
   * @return _atReferredType
  **/
  @Schema(description = "The actual type of the target instance when needed for disambiguation")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppointmentRef appointmentRef = (AppointmentRef) o;
    return Objects.equals(this.id, appointmentRef.id) &&
        Objects.equals(this.href, appointmentRef.href) &&
        Objects.equals(this.description, appointmentRef.description) &&
        Objects.equals(this.baseType, appointmentRef.baseType) &&
        Objects.equals(this.schemaLocation, appointmentRef.schemaLocation) &&
        Objects.equals(this.type, appointmentRef.type) &&
        Objects.equals(this._atReferredType, appointmentRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, baseType, schemaLocation, type, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppointmentRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
