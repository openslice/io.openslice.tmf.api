/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.am642.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Task resource for comment alarms operation Skipped properties: id,href
 */
@Schema(description = "Task resource for comment alarms operation Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class CommentAlarmsCreate   {
  @JsonProperty("state")
  private String state = null;

  @JsonProperty("alarmPattern")
  @Valid
  private List<Alarm> alarmPattern = new ArrayList<>();

  @JsonProperty("comment")
  private Comment comment = null;

  @JsonProperty("commentedAlarm")
  @Valid
  private List<AlarmRefOrValue> commentedAlarm = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public CommentAlarmsCreate state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Current state of the operation task
   * @return state
  **/
  @Schema(description = "Current state of the operation task")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CommentAlarmsCreate alarmPattern(List<Alarm> alarmPattern) {
    this.alarmPattern = alarmPattern;
    return this;
  }

  public CommentAlarmsCreate addAlarmPatternItem(Alarm alarmPatternItem) {
    this.alarmPattern.add(alarmPatternItem);
    return this;
  }

  /**
   * Alarm patterns to match target alarms. An alarm will match if all of the sttributes in any of the patterns compare equal to those attributes of the alarm.
   * @return alarmPattern
  **/
  @Schema(description = "Alarm patterns to match target alarms. An alarm will match if all of the sttributes in any of the patterns compare equal to those attributes of the alarm.")
      @NotNull
    @Valid
  @Size(min=1)   public List<Alarm> getAlarmPattern() {
    return alarmPattern;
  }

  public void setAlarmPattern(List<Alarm> alarmPattern) {
    this.alarmPattern = alarmPattern;
  }

  public CommentAlarmsCreate comment(Comment comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
  **/
  @Schema(description = "")
      @NotNull

    @Valid
    public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public CommentAlarmsCreate commentedAlarm(List<AlarmRefOrValue> commentedAlarm) {
    this.commentedAlarm = commentedAlarm;
    return this;
  }

  public CommentAlarmsCreate addCommentedAlarmItem(AlarmRefOrValue commentedAlarmItem) {
    if (this.commentedAlarm == null) {
      this.commentedAlarm = new ArrayList<>();
    }
    this.commentedAlarm.add(commentedAlarmItem);
    return this;
  }

  /**
   * The successfully commented alarms
   * @return commentedAlarm
  **/
  @Schema(description = "The successfully commented alarms")
      @Valid
    public List<AlarmRefOrValue> getCommentedAlarm() {
    return commentedAlarm;
  }

  public void setCommentedAlarm(List<AlarmRefOrValue> commentedAlarm) {
    this.commentedAlarm = commentedAlarm;
  }

  public CommentAlarmsCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public CommentAlarmsCreate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public CommentAlarmsCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String type) {
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
    CommentAlarmsCreate commentAlarmsCreate = (CommentAlarmsCreate) o;
    return Objects.equals(this.state, commentAlarmsCreate.state) &&
        Objects.equals(this.alarmPattern, commentAlarmsCreate.alarmPattern) &&
        Objects.equals(this.comment, commentAlarmsCreate.comment) &&
        Objects.equals(this.commentedAlarm, commentAlarmsCreate.commentedAlarm) &&
        Objects.equals(this.baseType, commentAlarmsCreate.baseType) &&
        Objects.equals(this.schemaLocation, commentAlarmsCreate.schemaLocation) &&
        Objects.equals(this.type, commentAlarmsCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, alarmPattern, comment, commentedAlarm, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentAlarmsCreate {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    alarmPattern: ").append(toIndentedString(alarmPattern)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    commentedAlarm: ").append(toIndentedString(commentedAlarm)).append("\n");
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
