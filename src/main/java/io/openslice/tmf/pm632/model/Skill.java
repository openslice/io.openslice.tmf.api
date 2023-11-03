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
 * Skills evaluated for an individual with a level and possibly with a limited validity when an obsolescence is defined (Ex: the first-aid certificate first level is limited to one year and an update training is required each year to keep the level).
 */
@Schema(description = "Skills evaluated for an individual with a level and possibly with a limited validity when an obsolescence is defined (Ex: the first-aid certificate first level is limited to one year and an update training is required each year to keep the level).")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class Skill extends BaseRootEntity  {
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


  public Skill comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * A free text comment linked to the evaluation done
   * @return comment
  **/
  @Schema(description = "A free text comment linked to the evaluation done")


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
  @Schema(description = "Level of expertise in a skill evaluated for an individual")


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
  @Schema(description = "Code of the skill")


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
  @Schema(description = "Name of the skill such as Java language,…")


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

//  @Override
//  public int hashCode() {
//    return Objects.hash(comment, evaluatedLevel, skillCode, skillName, validFor, baseType, schemaLocation, type);
//  }

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

