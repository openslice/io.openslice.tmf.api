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
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Description of a productTerm linked to this product. This represent a commitment with a duration
 */
@Schema(description = "Description of a productTerm linked to this product. This represent a commitment with a duration")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class ProductTerm   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("duration")
  private Quantity duration = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ProductTerm description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the productTerm
   * @return description
  **/
  @Schema(description = "Description of the productTerm")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductTerm name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the productTerm
   * @return name
  **/
  @Schema(description = "Name of the productTerm")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductTerm duration(Quantity duration) {
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

  public ProductTerm validFor(TimePeriod validFor) {
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

  public ProductTerm baseType(String baseType) {
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

  public ProductTerm schemaLocation(String schemaLocation) {
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

  public ProductTerm type(String type) {
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
    ProductTerm productTerm = (ProductTerm) o;
    return Objects.equals(this.description, productTerm.description) &&
        Objects.equals(this.name, productTerm.name) &&
        Objects.equals(this.duration, productTerm.duration) &&
        Objects.equals(this.validFor, productTerm.validFor) &&
        Objects.equals(this.baseType, productTerm.baseType) &&
        Objects.equals(this.schemaLocation, productTerm.schemaLocation) &&
        Objects.equals(this.type, productTerm.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, duration, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductTerm {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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
