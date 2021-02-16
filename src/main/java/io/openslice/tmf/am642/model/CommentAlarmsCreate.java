package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.Alarm;
import io.openslice.tmf.am642.model.AlarmRefOrValue;
import io.openslice.tmf.am642.model.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Task resource for comment alarms operation Skipped properties: id,href
 */
@ApiModel(description = "Task resource for comment alarms operation Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
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
  @ApiModelProperty(value = "Current state of the operation task")
  
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
  @ApiModelProperty(required = true, value = "Alarm patterns to match target alarms. An alarm will match if all of the sttributes in any of the patterns compare equal to those attributes of the alarm.")
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
  @ApiModelProperty(required = true, value = "")
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
  @ApiModelProperty(value = "The successfully commented alarms")
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
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
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
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
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
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")
  
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
