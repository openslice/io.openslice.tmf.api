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

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

/**
 * Ability of an individual to understand or converse in a language.
 */
@Schema(description = "Ability of an individual to understand or converse in a language.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")
@Entity
public class LanguageAbility  extends BaseRootEntity {
  @JsonProperty("isFavouriteLanguage")
  private Boolean isFavouriteLanguage = null;

  @JsonProperty("languageCode")
  private String languageCode = null;

  @JsonProperty("languageName")
  private String languageName = null;

  @JsonProperty("listeningProficiency")
  private String listeningProficiency = null;

  @JsonProperty("readingProficiency")
  private String readingProficiency = null;

  @JsonProperty("speakingProficiency")
  private String speakingProficiency = null;

  @JsonProperty("writingProficiency")
  private String writingProficiency = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;


  public LanguageAbility isFavouriteLanguage(Boolean isFavouriteLanguage) {
    this.isFavouriteLanguage = isFavouriteLanguage;
    return this;
  }

  /**
   * A “true” value specifies whether the language is considered by the individual as his favourite one
   * @return isFavouriteLanguage
  **/
  @Schema(description = "A “true” value specifies whether the language is considered by the individual as his favourite one")


  public Boolean isIsFavouriteLanguage() {
    return isFavouriteLanguage;
  }

  public void setIsFavouriteLanguage(Boolean isFavouriteLanguage) {
    this.isFavouriteLanguage = isFavouriteLanguage;
  }

  public LanguageAbility languageCode(String languageCode) {
    this.languageCode = languageCode;
    return this;
  }

  /**
   * Language code (RFC 5646)
   * @return languageCode
  **/
  @Schema(description = "Language code (RFC 5646)")


  public String getLanguageCode() {
    return languageCode;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  public LanguageAbility languageName(String languageName) {
    this.languageName = languageName;
    return this;
  }

  /**
   * Language name
   * @return languageName
  **/
  @Schema(description = "Language name")


  public String getLanguageName() {
    return languageName;
  }

  public void setLanguageName(String languageName) {
    this.languageName = languageName;
  }

  public LanguageAbility listeningProficiency(String listeningProficiency) {
    this.listeningProficiency = listeningProficiency;
    return this;
  }

  /**
   * Listening proficiency evaluated for this language
   * @return listeningProficiency
  **/
  @Schema(description = "Listening proficiency evaluated for this language")


  public String getListeningProficiency() {
    return listeningProficiency;
  }

  public void setListeningProficiency(String listeningProficiency) {
    this.listeningProficiency = listeningProficiency;
  }

  public LanguageAbility readingProficiency(String readingProficiency) {
    this.readingProficiency = readingProficiency;
    return this;
  }

  /**
   * Reading proficiency evaluated for this language
   * @return readingProficiency
  **/
  @Schema(description = "Reading proficiency evaluated for this language")


  public String getReadingProficiency() {
    return readingProficiency;
  }

  public void setReadingProficiency(String readingProficiency) {
    this.readingProficiency = readingProficiency;
  }

  public LanguageAbility speakingProficiency(String speakingProficiency) {
    this.speakingProficiency = speakingProficiency;
    return this;
  }

  /**
   * Speaking proficiency evaluated for this language
   * @return speakingProficiency
  **/
  @Schema(description = "Speaking proficiency evaluated for this language")


  public String getSpeakingProficiency() {
    return speakingProficiency;
  }

  public void setSpeakingProficiency(String speakingProficiency) {
    this.speakingProficiency = speakingProficiency;
  }

  public LanguageAbility writingProficiency(String writingProficiency) {
    this.writingProficiency = writingProficiency;
    return this;
  }

  /**
   * Writing proficiency evaluated for this language
   * @return writingProficiency
  **/
  @Schema(description = "Writing proficiency evaluated for this language")


  public String getWritingProficiency() {
    return writingProficiency;
  }

  public void setWritingProficiency(String writingProficiency) {
    this.writingProficiency = writingProficiency;
  }

  public LanguageAbility validFor(TimePeriod validFor) {
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

 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LanguageAbility languageAbility = (LanguageAbility) o;
    return Objects.equals(this.isFavouriteLanguage, languageAbility.isFavouriteLanguage) &&
        Objects.equals(this.languageCode, languageAbility.languageCode) &&
        Objects.equals(this.languageName, languageAbility.languageName) &&
        Objects.equals(this.listeningProficiency, languageAbility.listeningProficiency) &&
        Objects.equals(this.readingProficiency, languageAbility.readingProficiency) &&
        Objects.equals(this.speakingProficiency, languageAbility.speakingProficiency) &&
        Objects.equals(this.writingProficiency, languageAbility.writingProficiency) &&
        Objects.equals(this.validFor, languageAbility.validFor) &&
        Objects.equals(this.baseType, languageAbility.baseType) &&
        Objects.equals(this.schemaLocation, languageAbility.schemaLocation) &&
        Objects.equals(this.type, languageAbility.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(isFavouriteLanguage, languageCode, languageName, listeningProficiency, readingProficiency, speakingProficiency, writingProficiency, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LanguageAbility {\n");
    
    sb.append("    isFavouriteLanguage: ").append(toIndentedString(isFavouriteLanguage)).append("\n");
    sb.append("    languageCode: ").append(toIndentedString(languageCode)).append("\n");
    sb.append("    languageName: ").append(toIndentedString(languageName)).append("\n");
    sb.append("    listeningProficiency: ").append(toIndentedString(listeningProficiency)).append("\n");
    sb.append("    readingProficiency: ").append(toIndentedString(readingProficiency)).append("\n");
    sb.append("    speakingProficiency: ").append(toIndentedString(speakingProficiency)).append("\n");
    sb.append("    writingProficiency: ").append(toIndentedString(writingProficiency)).append("\n");
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

