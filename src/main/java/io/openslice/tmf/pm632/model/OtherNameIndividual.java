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
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Keeps track of other names, for example the old name of a woman before marriage or an artist name.
 */
@ApiModel(description = "Keeps track of other names, for example the old name of a woman before marriage or an artist name.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class OtherNameIndividual extends BaseRootEntity   {
  @JsonProperty("aristocraticTitle")
  private String aristocraticTitle = null;

  @JsonProperty("familyName")
  private String familyName = null;

  @JsonProperty("familyNamePrefix")
  private String familyNamePrefix = null;

  @JsonProperty("formattedName")
  private String formattedName = null;

  @JsonProperty("fullName")
  private String fullName = null;

  @JsonProperty("generation")
  private String generation = null;

  @JsonProperty("givenName")
  private String givenName = null;

  @JsonProperty("legalName")
  private String legalName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("preferredGivenName")
  private String preferredGivenName = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;


  public OtherNameIndividual aristocraticTitle(String aristocraticTitle) {
    this.aristocraticTitle = aristocraticTitle;
    return this;
  }

  /**
   * e.g. Baron, Graf, Earl,…
   * @return aristocraticTitle
  **/
  @ApiModelProperty(value = "e.g. Baron, Graf, Earl,…")


  public String getAristocraticTitle() {
    return aristocraticTitle;
  }

  public void setAristocraticTitle(String aristocraticTitle) {
    this.aristocraticTitle = aristocraticTitle;
  }

  public OtherNameIndividual familyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  /**
   * Contains the non-chosen or inherited name. Also known as last name in the Western context
   * @return familyName
  **/
  @ApiModelProperty(value = "Contains the non-chosen or inherited name. Also known as last name in the Western context")


  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public OtherNameIndividual familyNamePrefix(String familyNamePrefix) {
    this.familyNamePrefix = familyNamePrefix;
    return this;
  }

  /**
   * Family name prefix
   * @return familyNamePrefix
  **/
  @ApiModelProperty(value = "Family name prefix")


  public String getFamilyNamePrefix() {
    return familyNamePrefix;
  }

  public void setFamilyNamePrefix(String familyNamePrefix) {
    this.familyNamePrefix = familyNamePrefix;
  }

  public OtherNameIndividual formattedName(String formattedName) {
    this.formattedName = formattedName;
    return this;
  }

  /**
   * . A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)
   * @return formattedName
  **/
  @ApiModelProperty(value = ". A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)")


  public String getFormattedName() {
    return formattedName;
  }

  public void setFormattedName(String formattedName) {
    this.formattedName = formattedName;
  }

  public OtherNameIndividual fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name flatten (first, middle, and last names)
   * @return fullName
  **/
  @ApiModelProperty(value = "Full name flatten (first, middle, and last names)")


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public OtherNameIndividual generation(String generation) {
    this.generation = generation;
    return this;
  }

  /**
   * e.g. Sr, Jr…
   * @return generation
  **/
  @ApiModelProperty(value = "e.g. Sr, Jr…")


  public String getGeneration() {
    return generation;
  }

  public void setGeneration(String generation) {
    this.generation = generation;
  }

  public OtherNameIndividual givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * First name
   * @return givenName
  **/
  @ApiModelProperty(value = "First name")


  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public OtherNameIndividual legalName(String legalName) {
    this.legalName = legalName;
    return this;
  }

  /**
   * Legal name or birth name (name one has for official purposes)
   * @return legalName
  **/
  @ApiModelProperty(value = "Legal name or birth name (name one has for official purposes)")


  public String getLegalName() {
    return legalName;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public OtherNameIndividual middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middle name or initial
   * @return middleName
  **/
  @ApiModelProperty(value = "Middle name or initial")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public OtherNameIndividual preferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
    return this;
  }

  /**
   * Contains the chosen name by which the person prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname
   * @return preferredGivenName
  **/
  @ApiModelProperty(value = "Contains the chosen name by which the person prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname")


  public String getPreferredGivenName() {
    return preferredGivenName;
  }

  public void setPreferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
  }

  public OtherNameIndividual title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Use for titles (aristrocatic, social, ...): Pr, Dr, Sir,....
   * @return title
  **/
  @ApiModelProperty(value = "Use for titles (aristrocatic, social, ...): Pr, Dr, Sir,....")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public OtherNameIndividual validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtherNameIndividual otherNameIndividual = (OtherNameIndividual) o;
    return Objects.equals(this.aristocraticTitle, otherNameIndividual.aristocraticTitle) &&
        Objects.equals(this.familyName, otherNameIndividual.familyName) &&
        Objects.equals(this.familyNamePrefix, otherNameIndividual.familyNamePrefix) &&
        Objects.equals(this.formattedName, otherNameIndividual.formattedName) &&
        Objects.equals(this.fullName, otherNameIndividual.fullName) &&
        Objects.equals(this.generation, otherNameIndividual.generation) &&
        Objects.equals(this.givenName, otherNameIndividual.givenName) &&
        Objects.equals(this.legalName, otherNameIndividual.legalName) &&
        Objects.equals(this.middleName, otherNameIndividual.middleName) &&
        Objects.equals(this.preferredGivenName, otherNameIndividual.preferredGivenName) &&
        Objects.equals(this.title, otherNameIndividual.title) &&
        Objects.equals(this.validFor, otherNameIndividual.validFor) &&
        Objects.equals(this.baseType, otherNameIndividual.baseType) &&
        Objects.equals(this.schemaLocation, otherNameIndividual.schemaLocation) &&
        Objects.equals(this.type, otherNameIndividual.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(aristocraticTitle, familyName, familyNamePrefix, formattedName, fullName, generation, givenName, legalName, middleName, preferredGivenName, title, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtherNameIndividual {\n");
    
    sb.append("    aristocraticTitle: ").append(toIndentedString(aristocraticTitle)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    familyNamePrefix: ").append(toIndentedString(familyNamePrefix)).append("\n");
    sb.append("    formattedName: ").append(toIndentedString(formattedName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    generation: ").append(toIndentedString(generation)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    preferredGivenName: ").append(toIndentedString(preferredGivenName)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

