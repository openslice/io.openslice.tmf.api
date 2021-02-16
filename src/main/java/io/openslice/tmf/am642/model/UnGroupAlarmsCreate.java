package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Task resource for ungroup alarms operation Skipped properties: id,href
 */
@ApiModel(description = "Task resource for ungroup alarms operation Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
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
  @ApiModelProperty(required = true, value = "Time of the uncorrelation")
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
  @ApiModelProperty(required = true, value = "Source system identifier")
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
  @ApiModelProperty(value = "Current state of the operation task")
  
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
  @ApiModelProperty(required = true, value = "Correlated alarms")
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
  @ApiModelProperty(required = true, value = "")
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
  @ApiModelProperty(value = "The successfully uncorrelated alarms")
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
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
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
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
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
