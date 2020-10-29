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

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A migration, substitution, dependency or exclusivity relationship between/among product specifications.
 */
@ApiModel(description = "A migration, substitution, dependency or exclusivity relationship between/among product specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity
public class ProductSpecificationRelationship  extends BaseRootEntity {
  @JsonProperty("id")
  private String id = null;

  
  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;


  public ProductSpecificationRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the productSpecification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the productSpecification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  

  public ProductSpecificationRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as migration, substitution, dependency, exclusivity
   * @return relationshipType
  **/
  @ApiModelProperty(value = "Type of relationship such as migration, substitution, dependency, exclusivity")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ProductSpecificationRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the productSpecificationRelationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the productSpecificationRelationship is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ProductSpecificationRelationship baseType(String baseType) {
    this.baseType = baseType;
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
    ProductSpecificationRelationship productSpecificationRelationship = (ProductSpecificationRelationship) o;
    return Objects.equals(this.id, productSpecificationRelationship.id) &&
        Objects.equals(this.href, productSpecificationRelationship.href) &&
        Objects.equals(this.relationshipType, productSpecificationRelationship.relationshipType) &&
        Objects.equals(this.validFor, productSpecificationRelationship.validFor) &&
        Objects.equals(this.baseType, productSpecificationRelationship.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationRelationship.schemaLocation) &&
        Objects.equals(this.type, productSpecificationRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, relationshipType, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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

