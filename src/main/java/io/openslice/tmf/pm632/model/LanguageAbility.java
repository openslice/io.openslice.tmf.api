package io.openslice.tmf.pm632.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.pm632.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ability of an individual to understand or converse in a language.
 */
@ApiModel(description = "Ability of an individual to understand or converse in a language.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class LanguageAbility   {
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

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public LanguageAbility isFavouriteLanguage(Boolean isFavouriteLanguage) {
    this.isFavouriteLanguage = isFavouriteLanguage;
    return this;
  }

  /**
   * A “true” value specifies whether the language is considered by the individual as his favourite one
   * @return isFavouriteLanguage
  **/
  @ApiModelProperty(value = "A “true” value specifies whether the language is considered by the individual as his favourite one")


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
  @ApiModelProperty(value = "Language code (RFC 5646)")


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
  @ApiModelProperty(value = "Language name")


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
  @ApiModelProperty(value = "Listening proficiency evaluated for this language")


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
  @ApiModelProperty(value = "Reading proficiency evaluated for this language")


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
  @ApiModelProperty(value = "Speaking proficiency evaluated for this language")


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
  @ApiModelProperty(value = "Writing proficiency evaluated for this language")


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
  @ApiModelProperty(value = "")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public LanguageAbility baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public LanguageAbility schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public LanguageAbility type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


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

  @Override
  public int hashCode() {
    return Objects.hash(isFavouriteLanguage, languageCode, languageName, listeningProficiency, readingProficiency, speakingProficiency, writingProficiency, validFor, baseType, schemaLocation, type);
  }

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

