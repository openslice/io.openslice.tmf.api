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
package io.openslice.tmf.pm632.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * External reference of the individual or reference in other system
 */
@ApiModel(description = "External reference of the individual or reference in other system")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class ExternalReference  extends BaseRootNamedEntity {
  @JsonProperty("externalReferenceType")
  private String externalReferenceType = null;


  public ExternalReference externalReferenceType(String externalReferenceType) {
    this.externalReferenceType = externalReferenceType;
    return this;
  }

  /**
   * Type of the external reference
   * @return externalReferenceType
  **/
  @ApiModelProperty(value = "Type of the external reference")


  public String getExternalReferenceType() {
    return externalReferenceType;
  }

  public void setExternalReferenceType(String externalReferenceType) {
    this.externalReferenceType = externalReferenceType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalReference externalReference = (ExternalReference) o;
    return Objects.equals(this.externalReferenceType, externalReference.externalReferenceType) &&
        Objects.equals(this.name, externalReference.name) &&
        Objects.equals(this.baseType, externalReference.baseType) &&
        Objects.equals(this.schemaLocation, externalReference.schemaLocation) &&
        Objects.equals(this.type, externalReference.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(externalReferenceType, name, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalReference {\n");
    
    sb.append("    externalReferenceType: ").append(toIndentedString(externalReferenceType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

