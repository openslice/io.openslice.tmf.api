package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.Alarm;
import io.openslice.tmf.am642.model.AlarmRefOrValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Task resource for clear alarms operation Skipped properties: id,href
 */
@ApiModel(description = "Task resource for clear alarms operation Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class ClearAlarmsCreate   {
  @JsonProperty("alarmClearedTime")
  private OffsetDateTime alarmClearedTime = null;

  @JsonProperty("clearSystemId")
  private String clearSystemId = null;

  @JsonProperty("clearUserId")
  private String clearUserId = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("alarmPattern")
  @Valid
  private List<Alarm> alarmPattern = new ArrayList<>();

  @JsonProperty("clearedAlarm")
  @Valid
  private List<AlarmRefOrValue> clearedAlarm = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ClearAlarmsCreate alarmClearedTime(OffsetDateTime alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
    return this;
  }

  /**
   * Time of the alarm clearing
   * @return alarmClearedTime
  **/
  @ApiModelProperty(required = true, value = "Time of the alarm clearing")
      @NotNull

    @Valid
    public OffsetDateTime getAlarmClearedTime() {
    return alarmClearedTime;
  }

  public void setAlarmClearedTime(OffsetDateTime alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
  }

  public ClearAlarmsCreate clearSystemId(String clearSystemId) {
    this.clearSystemId = clearSystemId;
    return this;
  }

  /**
   * Name of the clearing system
   * @return clearSystemId
  **/
  @ApiModelProperty(required = true, value = "Name of the clearing system")
      @NotNull

    public String getClearSystemId() {
    return clearSystemId;
  }

  public void setClearSystemId(String clearSystemId) {
    this.clearSystemId = clearSystemId;
  }

  public ClearAlarmsCreate clearUserId(String clearUserId) {
    this.clearUserId = clearUserId;
    return this;
  }

  /**
   * Name of the clearing user
   * @return clearUserId
  **/
  @ApiModelProperty(required = true, value = "Name of the clearing user")
      @NotNull

    public String getClearUserId() {
    return clearUserId;
  }

  public void setClearUserId(String clearUserId) {
    this.clearUserId = clearUserId;
  }

  public ClearAlarmsCreate state(String state) {
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

  public ClearAlarmsCreate alarmPattern(List<Alarm> alarmPattern) {
    this.alarmPattern = alarmPattern;
    return this;
  }

  public ClearAlarmsCreate addAlarmPatternItem(Alarm alarmPatternItem) {
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

  public ClearAlarmsCreate clearedAlarm(List<AlarmRefOrValue> clearedAlarm) {
    this.clearedAlarm = clearedAlarm;
    return this;
  }

  public ClearAlarmsCreate addClearedAlarmItem(AlarmRefOrValue clearedAlarmItem) {
    if (this.clearedAlarm == null) {
      this.clearedAlarm = new ArrayList<>();
    }
    this.clearedAlarm.add(clearedAlarmItem);
    return this;
  }

  /**
   * The successfully cleared alarms
   * @return clearedAlarm
  **/
  @ApiModelProperty(value = "The successfully cleared alarms")
      @Valid
    public List<AlarmRefOrValue> getClearedAlarm() {
    return clearedAlarm;
  }

  public void setClearedAlarm(List<AlarmRefOrValue> clearedAlarm) {
    this.clearedAlarm = clearedAlarm;
  }

  public ClearAlarmsCreate baseType(String baseType) {
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

  public ClearAlarmsCreate schemaLocation(String schemaLocation) {
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

  public ClearAlarmsCreate type(String type) {
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
    ClearAlarmsCreate clearAlarmsCreate = (ClearAlarmsCreate) o;
    return Objects.equals(this.alarmClearedTime, clearAlarmsCreate.alarmClearedTime) &&
        Objects.equals(this.clearSystemId, clearAlarmsCreate.clearSystemId) &&
        Objects.equals(this.clearUserId, clearAlarmsCreate.clearUserId) &&
        Objects.equals(this.state, clearAlarmsCreate.state) &&
        Objects.equals(this.alarmPattern, clearAlarmsCreate.alarmPattern) &&
        Objects.equals(this.clearedAlarm, clearAlarmsCreate.clearedAlarm) &&
        Objects.equals(this.baseType, clearAlarmsCreate.baseType) &&
        Objects.equals(this.schemaLocation, clearAlarmsCreate.schemaLocation) &&
        Objects.equals(this.type, clearAlarmsCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alarmClearedTime, clearSystemId, clearUserId, state, alarmPattern, clearedAlarm, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClearAlarmsCreate {\n");
    
    sb.append("    alarmClearedTime: ").append(toIndentedString(alarmClearedTime)).append("\n");
    sb.append("    clearSystemId: ").append(toIndentedString(clearSystemId)).append("\n");
    sb.append("    clearUserId: ").append(toIndentedString(clearUserId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    alarmPattern: ").append(toIndentedString(alarmPattern)).append("\n");
    sb.append("    clearedAlarm: ").append(toIndentedString(clearedAlarm)).append("\n");
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
