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

import io.openslice.tmf.common.model.Quantity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Description of a productTerm linked to this orderItem. This represent a commitment with a duration
 */
@Schema(description = "Description of a productTerm linked to this orderItem. This represent a commitment with a duration")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class OrderTerm   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("duration")
  private Quantity duration = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public OrderTerm description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the productOrderTerm
   * @return description
  **/
  @Schema(description = "Description of the productOrderTerm")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrderTerm name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the productOrderTerm
   * @return name
  **/
  @Schema(description = "Name of the productOrderTerm")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrderTerm duration(Quantity duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
  **/
  @Schema(description = "")
  
    @Valid
    public Quantity getDuration() {
    return duration;
  }

  public void setDuration(Quantity duration) {
    this.duration = duration;
  }

  public OrderTerm baseType(String baseType) {
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

  public OrderTerm schemaLocation(String schemaLocation) {
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

  public OrderTerm type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderTerm orderTerm = (OrderTerm) o;
    return Objects.equals(this.description, orderTerm.description) &&
        Objects.equals(this.name, orderTerm.name) &&
        Objects.equals(this.duration, orderTerm.duration) &&
        Objects.equals(this.baseType, orderTerm.baseType) &&
        Objects.equals(this.schemaLocation, orderTerm.schemaLocation) &&
        Objects.equals(this.type, orderTerm.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, duration, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderTerm {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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
