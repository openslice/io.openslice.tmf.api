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
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An aggregation, migration, substitution, dependency or exclusivity relationship between/among productSpecificationCharacteristics.
 */
@ApiModel(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among productSpecificationCharacteristics.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")


@Entity(name = "ProdSpecCharRelationship")
@Table(name = "ProdSpecCharRelationship")
public class ProductSpecificationCharacteristicRelationship   extends BaseEntity {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("charSpecSeq")
  private Integer charSpecSeq = null;


  @JsonProperty("relationshipType")
  private String relationshipType = null;


  public ProductSpecificationCharacteristicRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * the identifier of the associated product specification
   * @return id
  **/
  @ApiModelProperty(value = "the identifier of the associated product specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public ProductSpecificationCharacteristicRelationship charSpecSeq(Integer charSpecSeq) {
    this.charSpecSeq = charSpecSeq;
    return this;
  }

  /**
   * The order in which a CharacteristicSpecification appears within another CharacteristicSpecification that defines a grouping of CharacteristicSpecifications.  For example, a grouping may represent the name of an individual. The given name is first, the middle name is second, and the last name is third.
   * @return charSpecSeq
  **/
  @ApiModelProperty(value = "The order in which a CharacteristicSpecification appears within another CharacteristicSpecification that defines a grouping of CharacteristicSpecifications.  For example, a grouping may represent the name of an individual. The given name is first, the middle name is second, and the last name is third.")


  public Integer getCharSpecSeq() {
    return charSpecSeq;
  }

  public void setCharSpecSeq(Integer charSpecSeq) {
    this.charSpecSeq = charSpecSeq;
  }


  public ProductSpecificationCharacteristicRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as aggregation, migration, substitution, dependency, exclusivity
   * @return relationshipType
  **/
  @ApiModelProperty(value = "Type of relationship such as aggregation, migration, substitution, dependency, exclusivity")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecificationCharacteristicRelationship productSpecificationCharacteristicRelationship = (ProductSpecificationCharacteristicRelationship) o;
    return Objects.equals(this.id, productSpecificationCharacteristicRelationship.id) &&
        Objects.equals(this.href, productSpecificationCharacteristicRelationship.href) &&
        Objects.equals(this.charSpecSeq, productSpecificationCharacteristicRelationship.charSpecSeq) &&
        Objects.equals(this.name, productSpecificationCharacteristicRelationship.name) &&
        Objects.equals(this.relationshipType, productSpecificationCharacteristicRelationship.relationshipType) &&
        Objects.equals(this.validFor, productSpecificationCharacteristicRelationship.validFor) &&
        Objects.equals(this.baseType, productSpecificationCharacteristicRelationship.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationCharacteristicRelationship.schemaLocation) &&
        Objects.equals(this.type, productSpecificationCharacteristicRelationship.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, charSpecSeq, name, relationshipType, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationCharacteristicRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    charSpecSeq: ").append(toIndentedString(charSpecSeq)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

