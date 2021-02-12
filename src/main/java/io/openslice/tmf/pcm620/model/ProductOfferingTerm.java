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

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.Quantity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A condition under which a ProductOffering is made available to Customers. For instance, a productOffering can be offered with multiple commitment periods.
 */
@ApiModel(description = "A condition under which a ProductOffering is made available to Customers. For instance, a productOffering can be offered with multiple commitment periods.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProductOfferingTerm")
public class ProductOfferingTerm   extends BaseEntity {
 

  @JsonProperty("duration")
  private Quantity duration = null;


  public ProductOfferingTerm description(String description) {
    this.description = description;
    return this;
  }

 

  public ProductOfferingTerm duration(Quantity duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duration of the productOfferingTerm
   * @return duration
  **/
  @ApiModelProperty(value = "Duration of the productOfferingTerm")

  @Valid

  public Quantity getDuration() {
    return duration;
  }

  public void setDuration(Quantity duration) {
    this.duration = duration;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingTerm productOfferingTerm = (ProductOfferingTerm) o;
    return Objects.equals(this.description, productOfferingTerm.description) &&
        Objects.equals(this.name, productOfferingTerm.name) &&
        Objects.equals(this.duration, productOfferingTerm.duration) &&
        Objects.equals(this.validFor, productOfferingTerm.validFor) &&
        Objects.equals(this.baseType, productOfferingTerm.baseType) &&
        Objects.equals(this.schemaLocation, productOfferingTerm.schemaLocation) &&
        Objects.equals(this.type, productOfferingTerm.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(description, name, duration, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingTerm {\n");
    
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

