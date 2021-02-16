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
 * Task resource for the acknowledge alarms operation Skipped properties: id,href
 */
@ApiModel(description = "Task resource for the acknowledge alarms operation Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class AckAlarmsCreate   {
  @JsonProperty("ackSystemId")
  private String ackSystemId = null;

  @JsonProperty("ackTime")
  private OffsetDateTime ackTime = null;

  @JsonProperty("ackUserId")
  private String ackUserId = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("ackedAlarm")
  @Valid
  private List<AlarmRefOrValue> ackedAlarm = null;

  @JsonProperty("alarmPattern")
  @Valid
  private List<Alarm> alarmPattern = new ArrayList<>();

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public AckAlarmsCreate ackSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
    return this;
  }

  /**
   * Name of the acknowledging system
   * @return ackSystemId
  **/
  @ApiModelProperty(required = true, value = "Name of the acknowledging system")
      @NotNull

    public String getAckSystemId() {
    return ackSystemId;
  }

  public void setAckSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
  }

  public AckAlarmsCreate ackTime(OffsetDateTime ackTime) {
    this.ackTime = ackTime;
    return this;
  }

  /**
   * Time of the acknowledgement
   * @return ackTime
  **/
  @ApiModelProperty(value = "Time of the acknowledgement")
  
    @Valid
    public OffsetDateTime getAckTime() {
    return ackTime;
  }

  public void setAckTime(OffsetDateTime ackTime) {
    this.ackTime = ackTime;
  }

  public AckAlarmsCreate ackUserId(String ackUserId) {
    this.ackUserId = ackUserId;
    return this;
  }

  /**
   * Name of the acknowledging user
   * @return ackUserId
  **/
  @ApiModelProperty(required = true, value = "Name of the acknowledging user")
      @NotNull

    public String getAckUserId() {
    return ackUserId;
  }

  public void setAckUserId(String ackUserId) {
    this.ackUserId = ackUserId;
  }

  public AckAlarmsCreate state(String state) {
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

  public AckAlarmsCreate ackedAlarm(List<AlarmRefOrValue> ackedAlarm) {
    this.ackedAlarm = ackedAlarm;
    return this;
  }

  public AckAlarmsCreate addAckedAlarmItem(AlarmRefOrValue ackedAlarmItem) {
    if (this.ackedAlarm == null) {
      this.ackedAlarm = new ArrayList<>();
    }
    this.ackedAlarm.add(ackedAlarmItem);
    return this;
  }

  /**
   * The successfully acknowledged alarms
   * @return ackedAlarm
  **/
  @ApiModelProperty(value = "The successfully acknowledged alarms")
      @Valid
    public List<AlarmRefOrValue> getAckedAlarm() {
    return ackedAlarm;
  }

  public void setAckedAlarm(List<AlarmRefOrValue> ackedAlarm) {
    this.ackedAlarm = ackedAlarm;
  }

  public AckAlarmsCreate alarmPattern(List<Alarm> alarmPattern) {
    this.alarmPattern = alarmPattern;
    return this;
  }

  public AckAlarmsCreate addAlarmPatternItem(Alarm alarmPatternItem) {
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

  public AckAlarmsCreate baseType(String baseType) {
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

  public AckAlarmsCreate schemaLocation(String schemaLocation) {
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

  public AckAlarmsCreate type(String type) {
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
    AckAlarmsCreate ackAlarmsCreate = (AckAlarmsCreate) o;
    return Objects.equals(this.ackSystemId, ackAlarmsCreate.ackSystemId) &&
        Objects.equals(this.ackTime, ackAlarmsCreate.ackTime) &&
        Objects.equals(this.ackUserId, ackAlarmsCreate.ackUserId) &&
        Objects.equals(this.state, ackAlarmsCreate.state) &&
        Objects.equals(this.ackedAlarm, ackAlarmsCreate.ackedAlarm) &&
        Objects.equals(this.alarmPattern, ackAlarmsCreate.alarmPattern) &&
        Objects.equals(this.baseType, ackAlarmsCreate.baseType) &&
        Objects.equals(this.schemaLocation, ackAlarmsCreate.schemaLocation) &&
        Objects.equals(this.type, ackAlarmsCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ackSystemId, ackTime, ackUserId, state, ackedAlarm, alarmPattern, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AckAlarmsCreate {\n");
    
    sb.append("    ackSystemId: ").append(toIndentedString(ackSystemId)).append("\n");
    sb.append("    ackTime: ").append(toIndentedString(ackTime)).append("\n");
    sb.append("    ackUserId: ").append(toIndentedString(ackUserId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    ackedAlarm: ").append(toIndentedString(ackedAlarm)).append("\n");
    sb.append("    alarmPattern: ").append(toIndentedString(alarmPattern)).append("\n");
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
