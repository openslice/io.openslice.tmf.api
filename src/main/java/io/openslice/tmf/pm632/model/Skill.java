package io.openslice.tmf.pm632.model;

import java.util.Objects;
import io.openslice.tmf.common.model.TimePeriod;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Skills evaluated for an individual with a level and possibly with a limited validity when an obsolescence is defined (Ex: the first-aid certificate first level is limited to one year and an update training is required each year to keep the level).
 */
@ApiModel(description = "Skills evaluated for an individual with a level and possibly with a limited validity when an obsolescence is defined (Ex: the first-aid certificate first level is limited to one year and an update training is required each year to keep the level).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class Skill   {
  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("evaluatedLevel")
  private String evaluatedLevel = null;

  @JsonProperty("skillCode")
  private String skillCode = null;

  @JsonProperty("skillName")
  private String skillName = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Skill comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * A free text comment linked to the evaluation done
   * @return comment
  **/
  @ApiModelProperty(value = "A free text comment linked to the evaluation done")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Skill evaluatedLevel(String evaluatedLevel) {
    this.evaluatedLevel = evaluatedLevel;
    return this;
  }

  /**
   * Level of expertise in a skill evaluated for an individual
   * @return evaluatedLevel
  **/
  @ApiModelProperty(value = "Level of expertise in a skill evaluated for an individual")


  public String getEvaluatedLevel() {
    return evaluatedLevel;
  }

  public void setEvaluatedLevel(String evaluatedLevel) {
    this.evaluatedLevel = evaluatedLevel;
  }

  public Skill skillCode(String skillCode) {
    this.skillCode = skillCode;
    return this;
  }

  /**
   * Code of the skill
   * @return skillCode
  **/
  @ApiModelProperty(value = "Code of the skill")


  public String getSkillCode() {
    return skillCode;
  }

  public void setSkillCode(String skillCode) {
    this.skillCode = skillCode;
  }

  public Skill skillName(String skillName) {
    this.skillName = skillName;
    return this;
  }

  /**
   * Name of the skill such as Java language,…
   * @return skillName
  **/
  @ApiModelProperty(value = "Name of the skill such as Java language,…")


  public String getSkillName() {
    return skillName;
  }

  public void setSkillName(String skillName) {
    this.skillName = skillName;
  }

  public Skill validFor(TimePeriod validFor) {
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

  public Skill baseType(String baseType) {
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

  public Skill schemaLocation(String schemaLocation) {
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

  public Skill type(String type) {
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
    Skill skill = (Skill) o;
    return Objects.equals(this.comment, skill.comment) &&
        Objects.equals(this.evaluatedLevel, skill.evaluatedLevel) &&
        Objects.equals(this.skillCode, skill.skillCode) &&
        Objects.equals(this.skillName, skill.skillName) &&
        Objects.equals(this.validFor, skill.validFor) &&
        Objects.equals(this.baseType, skill.baseType) &&
        Objects.equals(this.schemaLocation, skill.schemaLocation) &&
        Objects.equals(this.type, skill.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, evaluatedLevel, skillCode, skillName, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Skill {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    evaluatedLevel: ").append(toIndentedString(evaluatedLevel)).append("\n");
    sb.append("    skillCode: ").append(toIndentedString(skillCode)).append("\n");
    sb.append("    skillName: ").append(toIndentedString(skillName)).append("\n");
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

