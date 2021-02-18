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
 * Task resource for unacknowledge alarms operation Skipped properties: id,href
 */
@ApiModel(description = "Task resource for unacknowledge alarms operation Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class UnAckAlarmsCreate   {
  @JsonProperty("ackSystemId")
  private String ackSystemId = null;

  @JsonProperty("ackTime")
  private OffsetDateTime ackTime = null;

  @JsonProperty("ackUserId")
  private String ackUserId = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("alarmPattern")
  @Valid
  private List<Alarm> alarmPattern = new ArrayList<>();

  @JsonProperty("unAckedAlarm")
  @Valid
  private List<AlarmRefOrValue> unAckedAlarm = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public UnAckAlarmsCreate ackSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
    return this;
  }

  /**
   * Name of the unacknowledging system
   * @return ackSystemId
  **/
  @ApiModelProperty(required = true, value = "Name of the unacknowledging system")
      @NotNull

    public String getAckSystemId() {
    return ackSystemId;
  }

  public void setAckSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
  }

  public UnAckAlarmsCreate ackTime(OffsetDateTime ackTime) {
    this.ackTime = ackTime;
    return this;
  }

  /**
   * Time of the unacknowledgement
   * @return ackTime
  **/
  @ApiModelProperty(value = "Time of the unacknowledgement")
  
    @Valid
    public OffsetDateTime getAckTime() {
    return ackTime;
  }

  public void setAckTime(OffsetDateTime ackTime) {
    this.ackTime = ackTime;
  }

  public UnAckAlarmsCreate ackUserId(String ackUserId) {
    this.ackUserId = ackUserId;
    return this;
  }

  /**
   * Name of the unacknowledging user
   * @return ackUserId
  **/
  @ApiModelProperty(required = true, value = "Name of the unacknowledging user")
      @NotNull

    public String getAckUserId() {
    return ackUserId;
  }

  public void setAckUserId(String ackUserId) {
    this.ackUserId = ackUserId;
  }

  public UnAckAlarmsCreate state(String state) {
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

  public UnAckAlarmsCreate alarmPattern(List<Alarm> alarmPattern) {
    this.alarmPattern = alarmPattern;
    return this;
  }

  public UnAckAlarmsCreate addAlarmPatternItem(Alarm alarmPatternItem) {
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

  public UnAckAlarmsCreate unAckedAlarm(List<AlarmRefOrValue> unAckedAlarm) {
    this.unAckedAlarm = unAckedAlarm;
    return this;
  }

  public UnAckAlarmsCreate addUnAckedAlarmItem(AlarmRefOrValue unAckedAlarmItem) {
    if (this.unAckedAlarm == null) {
      this.unAckedAlarm = new ArrayList<>();
    }
    this.unAckedAlarm.add(unAckedAlarmItem);
    return this;
  }

  /**
   * The successfully unacknowledged alarms
   * @return unAckedAlarm
  **/
  @ApiModelProperty(value = "The successfully unacknowledged alarms")
      @Valid
    public List<AlarmRefOrValue> getUnAckedAlarm() {
    return unAckedAlarm;
  }

  public void setUnAckedAlarm(List<AlarmRefOrValue> unAckedAlarm) {
    this.unAckedAlarm = unAckedAlarm;
  }

  public UnAckAlarmsCreate baseType(String baseType) {
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

  public UnAckAlarmsCreate schemaLocation(String schemaLocation) {
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

  public UnAckAlarmsCreate type(String type) {
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
    UnAckAlarmsCreate unAckAlarmsCreate = (UnAckAlarmsCreate) o;
    return Objects.equals(this.ackSystemId, unAckAlarmsCreate.ackSystemId) &&
        Objects.equals(this.ackTime, unAckAlarmsCreate.ackTime) &&
        Objects.equals(this.ackUserId, unAckAlarmsCreate.ackUserId) &&
        Objects.equals(this.state, unAckAlarmsCreate.state) &&
        Objects.equals(this.alarmPattern, unAckAlarmsCreate.alarmPattern) &&
        Objects.equals(this.unAckedAlarm, unAckAlarmsCreate.unAckedAlarm) &&
        Objects.equals(this.baseType, unAckAlarmsCreate.baseType) &&
        Objects.equals(this.schemaLocation, unAckAlarmsCreate.schemaLocation) &&
        Objects.equals(this.type, unAckAlarmsCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ackSystemId, ackTime, ackUserId, state, alarmPattern, unAckedAlarm, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnAckAlarmsCreate {\n");
    
    sb.append("    ackSystemId: ").append(toIndentedString(ackSystemId)).append("\n");
    sb.append("    ackTime: ").append(toIndentedString(ackTime)).append("\n");
    sb.append("    ackUserId: ").append(toIndentedString(ackUserId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    alarmPattern: ").append(toIndentedString(alarmPattern)).append("\n");
    sb.append("    unAckedAlarm: ").append(toIndentedString(unAckedAlarm)).append("\n");
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
