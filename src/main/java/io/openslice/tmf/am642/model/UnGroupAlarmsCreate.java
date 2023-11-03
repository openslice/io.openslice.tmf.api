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

import java.time.OffsetDateTime;
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
 * Task resource for ungroup alarms operation Skipped properties: id,href
 */
@Schema(description = "Task resource for ungroup alarms operation Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class UnGroupAlarmsCreate   {
  @JsonProperty("alarmChangedTime")
  private OffsetDateTime alarmChangedTime = null;

  @JsonProperty("sourceSystemId")
  private String sourceSystemId = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("correlatedAlarm")
  @Valid
  private List<AlarmRefOrValue> correlatedAlarm = new ArrayList<>();

  @JsonProperty("parentAlarm")
  private AlarmRefOrValue parentAlarm = null;

  @JsonProperty("unGroupedAlarm")
  @Valid
  private List<AlarmRefOrValue> unGroupedAlarm = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public UnGroupAlarmsCreate alarmChangedTime(OffsetDateTime alarmChangedTime) {
    this.alarmChangedTime = alarmChangedTime;
    return this;
  }

  /**
   * Time of the uncorrelation
   * @return alarmChangedTime
  **/
  @Schema(description = "Time of the uncorrelation")
      @NotNull

    @Valid
    public OffsetDateTime getAlarmChangedTime() {
    return alarmChangedTime;
  }

  public void setAlarmChangedTime(OffsetDateTime alarmChangedTime) {
    this.alarmChangedTime = alarmChangedTime;
  }

  public UnGroupAlarmsCreate sourceSystemId(String sourceSystemId) {
    this.sourceSystemId = sourceSystemId;
    return this;
  }

  /**
   * Source system identifier
   * @return sourceSystemId
  **/
  @Schema(description = "Source system identifier")
      @NotNull

    public String getSourceSystemId() {
    return sourceSystemId;
  }

  public void setSourceSystemId(String sourceSystemId) {
    this.sourceSystemId = sourceSystemId;
  }

  public UnGroupAlarmsCreate state(String state) {
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

  public UnGroupAlarmsCreate correlatedAlarm(List<AlarmRefOrValue> correlatedAlarm) {
    this.correlatedAlarm = correlatedAlarm;
    return this;
  }

  public UnGroupAlarmsCreate addCorrelatedAlarmItem(AlarmRefOrValue correlatedAlarmItem) {
    this.correlatedAlarm.add(correlatedAlarmItem);
    return this;
  }

  /**
   * Correlated alarms
   * @return correlatedAlarm
  **/
  @Schema(description = "Correlated alarms")
      @NotNull
    @Valid
  @Size(min=1)   public List<AlarmRefOrValue> getCorrelatedAlarm() {
    return correlatedAlarm;
  }

  public void setCorrelatedAlarm(List<AlarmRefOrValue> correlatedAlarm) {
    this.correlatedAlarm = correlatedAlarm;
  }

  public UnGroupAlarmsCreate parentAlarm(AlarmRefOrValue parentAlarm) {
    this.parentAlarm = parentAlarm;
    return this;
  }

  /**
   * Get parentAlarm
   * @return parentAlarm
  **/
  @Schema(description = "")
      @NotNull

    @Valid
    public AlarmRefOrValue getParentAlarm() {
    return parentAlarm;
  }

  public void setParentAlarm(AlarmRefOrValue parentAlarm) {
    this.parentAlarm = parentAlarm;
  }

  public UnGroupAlarmsCreate unGroupedAlarm(List<AlarmRefOrValue> unGroupedAlarm) {
    this.unGroupedAlarm = unGroupedAlarm;
    return this;
  }

  public UnGroupAlarmsCreate addUnGroupedAlarmItem(AlarmRefOrValue unGroupedAlarmItem) {
    if (this.unGroupedAlarm == null) {
      this.unGroupedAlarm = new ArrayList<>();
    }
    this.unGroupedAlarm.add(unGroupedAlarmItem);
    return this;
  }

  /**
   * The successfully uncorrelated alarms
   * @return unGroupedAlarm
  **/
  @Schema(description = "The successfully uncorrelated alarms")
      @Valid
    public List<AlarmRefOrValue> getUnGroupedAlarm() {
    return unGroupedAlarm;
  }

  public void setUnGroupedAlarm(List<AlarmRefOrValue> unGroupedAlarm) {
    this.unGroupedAlarm = unGroupedAlarm;
  }

  public UnGroupAlarmsCreate baseType(String baseType) {
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

  public UnGroupAlarmsCreate schemaLocation(String schemaLocation) {
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

  public UnGroupAlarmsCreate type(String type) {
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
    UnGroupAlarmsCreate unGroupAlarmsCreate = (UnGroupAlarmsCreate) o;
    return Objects.equals(this.alarmChangedTime, unGroupAlarmsCreate.alarmChangedTime) &&
        Objects.equals(this.sourceSystemId, unGroupAlarmsCreate.sourceSystemId) &&
        Objects.equals(this.state, unGroupAlarmsCreate.state) &&
        Objects.equals(this.correlatedAlarm, unGroupAlarmsCreate.correlatedAlarm) &&
        Objects.equals(this.parentAlarm, unGroupAlarmsCreate.parentAlarm) &&
        Objects.equals(this.unGroupedAlarm, unGroupAlarmsCreate.unGroupedAlarm) &&
        Objects.equals(this.baseType, unGroupAlarmsCreate.baseType) &&
        Objects.equals(this.schemaLocation, unGroupAlarmsCreate.schemaLocation) &&
        Objects.equals(this.type, unGroupAlarmsCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alarmChangedTime, sourceSystemId, state, correlatedAlarm, parentAlarm, unGroupedAlarm, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnGroupAlarmsCreate {\n");
    
    sb.append("    alarmChangedTime: ").append(toIndentedString(alarmChangedTime)).append("\n");
    sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    correlatedAlarm: ").append(toIndentedString(correlatedAlarm)).append("\n");
    sb.append("    parentAlarm: ").append(toIndentedString(parentAlarm)).append("\n");
    sb.append("    unGroupedAlarm: ").append(toIndentedString(unGroupedAlarm)).append("\n");
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
