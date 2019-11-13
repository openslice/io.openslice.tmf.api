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
package io.openslice.tmf.am651.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A relationship between agreement specifications. Typical relationships are substitution and dependency.
 */
@ApiModel(description = "A relationship between agreement specifications. Typical relationships are substitution and dependency.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementSpecificationRelationship   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("type")
  private String typeAgreementSpecificationRelationship = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@type")
  private String type = null;

  public AgreementSpecificationRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of an agreement specification.
   * @return href
  **/
  @ApiModelProperty(value = "Reference of an agreement specification.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AgreementSpecificationRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the related agreement specification.
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the related agreement specification.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AgreementSpecificationRelationship typeAgreementSpecificationRelationship(String type) {
    this.typeAgreementSpecificationRelationship = type;
    return this;
  }

  /**
   * Type of relationship such as, substitution or dependency.
   * @return type
  **/
  @ApiModelProperty(value = "Type of relationship such as, substitution or dependency.")


  public String getTypeAgreementSpecificationRelationship() {
    return typeAgreementSpecificationRelationship;
  }

  public void setTypeAgreementSpecificationRelationship(String type) {
    this.typeAgreementSpecificationRelationship = type;
  }

  public AgreementSpecificationRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the relationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the relationship is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public AgreementSpecificationRelationship type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @ApiModelProperty(value = "The class type of the actual resource (for type extension).")


  public String getType() {
    return type;
  }

  public void setType(String type) {
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
    AgreementSpecificationRelationship agreementSpecificationRelationship = (AgreementSpecificationRelationship) o;
    return Objects.equals(this.href, agreementSpecificationRelationship.href) &&
        Objects.equals(this.id, agreementSpecificationRelationship.id) &&
        Objects.equals(this.type, agreementSpecificationRelationship.type) &&
        Objects.equals(this.validFor, agreementSpecificationRelationship.validFor) &&
        Objects.equals(this.type, agreementSpecificationRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, type, validFor, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementSpecificationRelationship {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

