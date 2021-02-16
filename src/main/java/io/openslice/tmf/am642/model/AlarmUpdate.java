package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.AffectedService;
import io.openslice.tmf.am642.model.AlarmRef;
import io.openslice.tmf.am642.model.AlarmedObject;
import io.openslice.tmf.am642.model.Comment;
import io.openslice.tmf.am642.model.CrossedThresholdInformation;
import io.openslice.tmf.am642.model.RelatedPlaceRefOrValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This resource represents an alarm supporting the information model defined in ITU-T X.733. Skipped properties: id,href,alarmRaisedTime,sourceSystemId
 */
@ApiModel(description = "This resource represents an alarm supporting the information model defined in ITU-T X.733. Skipped properties: id,href,alarmRaisedTime,sourceSystemId")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class AlarmUpdate   {
  @JsonProperty("ackState")
  protected String ackState = null;

  @JsonProperty("ackSystemId")
  protected String ackSystemId = null;

  @JsonProperty("ackUserId")
  protected String ackUserId = null;

  @JsonProperty("alarmChangedTime")
  protected OffsetDateTime alarmChangedTime = null;

  @JsonProperty("alarmClearedTime")
  protected OffsetDateTime alarmClearedTime = null;

  @JsonProperty("alarmDetails")
  protected String alarmDetails = null;

  @JsonProperty("alarmEscalation")
  protected Boolean alarmEscalation = null;

  @JsonProperty("alarmReportingTime")
  protected OffsetDateTime alarmReportingTime = null;

  @JsonProperty("alarmType")
  protected String alarmType = null;

  @JsonProperty("alarmedObjectType")
  protected String alarmedObjectType = null;

  @JsonProperty("clearSystemId")
  protected String clearSystemId = null;

  @JsonProperty("clearUserId")
  protected String clearUserId = null;

  @JsonProperty("externalAlarmId")
  protected String externalAlarmId = null;

  @JsonProperty("isRootCause")
  protected Boolean isRootCause = null;

  @JsonProperty("perceivedSeverity")
  protected String perceivedSeverity = null;

  @JsonProperty("plannedOutageIndicator")
  protected String plannedOutageIndicator = null;

  @JsonProperty("probableCause")
  protected String probableCause = null;

  @JsonProperty("proposedRepairedActions")
  protected String proposedRepairedActions = null;

  @JsonProperty("reportingSystemId")
  protected String reportingSystemId = null;

  @JsonProperty("serviceAffecting")
  protected Boolean serviceAffecting = null;

  @JsonProperty("specificProblem")
  protected String specificProblem = null;

  @JsonProperty("state")
  protected String state = null;

  @JsonProperty("affectedService")
  @Valid
  protected List<AffectedService> affectedService = null;

  @JsonProperty("alarmedObject")
  protected AlarmedObject alarmedObject = null;

  @JsonProperty("comment")
  @Valid
  protected List<Comment> comment = null;

  @JsonProperty("correlatedAlarm")
  @Valid
  protected List<AlarmRef> correlatedAlarm = null;

  @JsonProperty("crossedThresholdInformation")
  protected CrossedThresholdInformation crossedThresholdInformation = null;

  @JsonProperty("parentAlarm")
  @Valid
  protected List<AlarmRef> parentAlarm = null;

  @JsonProperty("place")
  @Valid
  protected List<RelatedPlaceRefOrValue> place = null;

  @JsonProperty("@baseType")
  protected String baseType = null;

  @JsonProperty("@schemaLocation")
  protected String schemaLocation = null;

  @JsonProperty("@type")
  protected String type = null;

  public AlarmUpdate ackState(String ackState) {
    this.ackState = ackState;
    return this;
  }

  /**
   * Provides the Acknowledgement State of the alarm
   * @return ackState
  **/
  @ApiModelProperty(value = "Provides the Acknowledgement State of the alarm")
  
    public String getAckState() {
    return ackState;
  }

  public void setAckState(String ackState) {
    this.ackState = ackState;
  }

  public AlarmUpdate ackSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
    return this;
  }

  /**
   * Provides the name of the system that last changed the ackState of an alarm, i.e. acknowledged or unacknowledged the alarm.
   * @return ackSystemId
  **/
  @ApiModelProperty(value = "Provides the name of the system that last changed the ackState of an alarm, i.e. acknowledged or unacknowledged the alarm.")
  
    public String getAckSystemId() {
    return ackSystemId;
  }

  public void setAckSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
  }

  public AlarmUpdate ackUserId(String ackUserId) {
    this.ackUserId = ackUserId;
    return this;
  }

  /**
   * Provides the id of the user who has last changed the ack state of the alarm, i.e. acknowledged or unacknowledged the alarm.
   * @return ackUserId
  **/
  @ApiModelProperty(value = "Provides the id of the user who has last changed the ack state of the alarm, i.e. acknowledged or unacknowledged the alarm.")
  
    public String getAckUserId() {
    return ackUserId;
  }

  public void setAckUserId(String ackUserId) {
    this.ackUserId = ackUserId;
  }

  public AlarmUpdate alarmChangedTime(OffsetDateTime alarmChangedTime) {
    this.alarmChangedTime = alarmChangedTime;
    return this;
  }

  /**
   * Indicates the last date and time when the alarm is changed on the alarm-owning system. Any change to the alarm whether coming from the alarmed resource, or triggered by a change from the client is changing this time.
   * @return alarmChangedTime
  **/
  @ApiModelProperty(value = "Indicates the last date and time when the alarm is changed on the alarm-owning system. Any change to the alarm whether coming from the alarmed resource, or triggered by a change from the client is changing this time.")
  
    @Valid
    public OffsetDateTime getAlarmChangedTime() {
    return alarmChangedTime;
  }

  public void setAlarmChangedTime(OffsetDateTime alarmChangedTime) {
    this.alarmChangedTime = alarmChangedTime;
  }

  public AlarmUpdate alarmClearedTime(OffsetDateTime alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
    return this;
  }

  /**
   * Indicates the time (as a date + time) at which the alarm is cleared at the source. 
   * @return alarmClearedTime
  **/
  @ApiModelProperty(value = "Indicates the time (as a date + time) at which the alarm is cleared at the source. ")
  
    @Valid
    public OffsetDateTime getAlarmClearedTime() {
    return alarmClearedTime;
  }

  public void setAlarmClearedTime(OffsetDateTime alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
  }

  public AlarmUpdate alarmDetails(String alarmDetails) {
    this.alarmDetails = alarmDetails;
    return this;
  }

  /**
   * Contains further information on the alarm.
   * @return alarmDetails
  **/
  @ApiModelProperty(value = "Contains further information on the alarm.")
  
    public String getAlarmDetails() {
    return alarmDetails;
  }

  public void setAlarmDetails(String alarmDetails) {
    this.alarmDetails = alarmDetails;
  }

  public AlarmUpdate alarmEscalation(Boolean alarmEscalation) {
    this.alarmEscalation = alarmEscalation;
    return this;
  }

  /**
   * Indicates if this alarm has been escalated or not. 
   * @return alarmEscalation
  **/
  @ApiModelProperty(value = "Indicates if this alarm has been escalated or not. ")
  
    public Boolean isAlarmEscalation() {
    return alarmEscalation;
  }

  public void setAlarmEscalation(Boolean alarmEscalation) {
    this.alarmEscalation = alarmEscalation;
  }

  public AlarmUpdate alarmReportingTime(OffsetDateTime alarmReportingTime) {
    this.alarmReportingTime = alarmReportingTime;
    return this;
  }

  /**
   * Indicates the time (as a date + time) at which the alarm was reported by the owning OSS. It might be different from the alarmRaisedTime. For instance, if the alarm list is maintained by an EMS, the alarmRaisedtime would be the time the alarm   was detected by the NE, while the alarmReportingTime would be the time this alarm was stored in the alarm list of the EMS.
   * @return alarmReportingTime
  **/
  @ApiModelProperty(value = "Indicates the time (as a date + time) at which the alarm was reported by the owning OSS. It might be different from the alarmRaisedTime. For instance, if the alarm list is maintained by an EMS, the alarmRaisedtime would be the time the alarm   was detected by the NE, while the alarmReportingTime would be the time this alarm was stored in the alarm list of the EMS.")
  
    @Valid
    public OffsetDateTime getAlarmReportingTime() {
    return alarmReportingTime;
  }

  public void setAlarmReportingTime(OffsetDateTime alarmReportingTime) {
    this.alarmReportingTime = alarmReportingTime;
  }

  public AlarmUpdate alarmType(String alarmType) {
    this.alarmType = alarmType;
    return this;
  }

  /**
   * Categorize the alarm. Should be one of the values defined in X.733 8.1.1 or 3GPP TS 32.111-2 Annex A:  Communications Alarm  Processing Error Alarm  Environmental Alarm  Quality of Service Alarm  Equipment Alarm  Integrity Violation  Operational Violation  Physical Violation  Security Service or Mechanism Violation  Time Domain Violation
   * @return alarmType
  **/
  @ApiModelProperty(value = "Categorize the alarm. Should be one of the values defined in X.733 8.1.1 or 3GPP TS 32.111-2 Annex A:  Communications Alarm  Processing Error Alarm  Environmental Alarm  Quality of Service Alarm  Equipment Alarm  Integrity Violation  Operational Violation  Physical Violation  Security Service or Mechanism Violation  Time Domain Violation")
  
    public String getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(String alarmType) {
    this.alarmType = alarmType;
  }

  public AlarmUpdate alarmedObjectType(String alarmedObjectType) {
    this.alarmedObjectType = alarmedObjectType;
    return this;
  }

  /**
   * The type (class) of the managed object associated with the event.
   * @return alarmedObjectType
  **/
  @ApiModelProperty(value = "The type (class) of the managed object associated with the event.")
  
    public String getAlarmedObjectType() {
    return alarmedObjectType;
  }

  public void setAlarmedObjectType(String alarmedObjectType) {
    this.alarmedObjectType = alarmedObjectType;
  }

  public AlarmUpdate clearSystemId(String clearSystemId) {
    this.clearSystemId = clearSystemId;
    return this;
  }

  /**
   * Provides the id of the system where the user who invoked the alarmCleared operation is located. 
   * @return clearSystemId
  **/
  @ApiModelProperty(value = "Provides the id of the system where the user who invoked the alarmCleared operation is located. ")
  
    public String getClearSystemId() {
    return clearSystemId;
  }

  public void setClearSystemId(String clearSystemId) {
    this.clearSystemId = clearSystemId;
  }

  public AlarmUpdate clearUserId(String clearUserId) {
    this.clearUserId = clearUserId;
    return this;
  }

  /**
   * Provides the id of the user who invoked the alarmCleared operation
   * @return clearUserId
  **/
  @ApiModelProperty(value = "Provides the id of the user who invoked the alarmCleared operation")
  
    public String getClearUserId() {
    return clearUserId;
  }

  public void setClearUserId(String clearUserId) {
    this.clearUserId = clearUserId;
  }

  public AlarmUpdate externalAlarmId(String externalAlarmId) {
    this.externalAlarmId = externalAlarmId;
    return this;
  }

  /**
   * An identifier of the alarm in the source system.
   * @return externalAlarmId
  **/
  @ApiModelProperty(value = "An identifier of the alarm in the source system.")
  
    public String getExternalAlarmId() {
    return externalAlarmId;
  }

  public void setExternalAlarmId(String externalAlarmId) {
    this.externalAlarmId = externalAlarmId;
  }

  public AlarmUpdate isRootCause(Boolean isRootCause) {
    this.isRootCause = isRootCause;
    return this;
  }

  /**
   * Indicates whether the alarm is a root cause alarm.. 
   * @return isRootCause
  **/
  @ApiModelProperty(value = "Indicates whether the alarm is a root cause alarm.. ")
  
    public Boolean isIsRootCause() {
    return isRootCause;
  }

  public void setIsRootCause(Boolean isRootCause) {
    this.isRootCause = isRootCause;
  }

  public AlarmUpdate perceivedSeverity(String perceivedSeverity) {
    this.perceivedSeverity = perceivedSeverity;
    return this;
  }

  /**
   * Lists the possible severities that can be allocated to an Alarm. The values are consistent with ITU-T Recommendation X.733. Once an alarm has been cleared, its perceived severity is set to 'cleared' and can no longer be set.
   * @return perceivedSeverity
  **/
  @ApiModelProperty(value = "Lists the possible severities that can be allocated to an Alarm. The values are consistent with ITU-T Recommendation X.733. Once an alarm has been cleared, its perceived severity is set to 'cleared' and can no longer be set.")
  
    public String getPerceivedSeverity() {
    return perceivedSeverity;
  }

  public void setPerceivedSeverity(String perceivedSeverity) {
    this.perceivedSeverity = perceivedSeverity;
  }

  public AlarmUpdate plannedOutageIndicator(String plannedOutageIndicator) {
    this.plannedOutageIndicator = plannedOutageIndicator;
    return this;
  }

  /**
   * Indicates that the Managed Object (related to this alarm) is in planned outage (in planned maintenance, or out-of-service). 
   * @return plannedOutageIndicator
  **/
  @ApiModelProperty(value = "Indicates that the Managed Object (related to this alarm) is in planned outage (in planned maintenance, or out-of-service). ")
  
    public String getPlannedOutageIndicator() {
    return plannedOutageIndicator;
  }

  public void setPlannedOutageIndicator(String plannedOutageIndicator) {
    this.plannedOutageIndicator = plannedOutageIndicator;
  }

  public AlarmUpdate probableCause(String probableCause) {
    this.probableCause = probableCause;
    return this;
  }

  /**
   * Provides the probable cause of the alarm. The values are consistent with ITU-T Recommendation X.733 or 3GPP TS 32.111-2 Annex B.
   * @return probableCause
  **/
  @ApiModelProperty(value = "Provides the probable cause of the alarm. The values are consistent with ITU-T Recommendation X.733 or 3GPP TS 32.111-2 Annex B.")
  
    public String getProbableCause() {
    return probableCause;
  }

  public void setProbableCause(String probableCause) {
    this.probableCause = probableCause;
  }

  public AlarmUpdate proposedRepairedActions(String proposedRepairedActions) {
    this.proposedRepairedActions = proposedRepairedActions;
    return this;
  }

  /**
   * Indicates proposed repair actions, if known to the system emitting the alarm.
   * @return proposedRepairedActions
  **/
  @ApiModelProperty(value = "Indicates proposed repair actions, if known to the system emitting the alarm.")
  
    public String getProposedRepairedActions() {
    return proposedRepairedActions;
  }

  public void setProposedRepairedActions(String proposedRepairedActions) {
    this.proposedRepairedActions = proposedRepairedActions;
  }

  public AlarmUpdate reportingSystemId(String reportingSystemId) {
    this.reportingSystemId = reportingSystemId;
    return this;
  }

  /**
   * Reporting system identity.
   * @return reportingSystemId
  **/
  @ApiModelProperty(value = "Reporting system identity.")
  
    public String getReportingSystemId() {
    return reportingSystemId;
  }

  public void setReportingSystemId(String reportingSystemId) {
    this.reportingSystemId = reportingSystemId;
  }

  public AlarmUpdate serviceAffecting(Boolean serviceAffecting) {
    this.serviceAffecting = serviceAffecting;
    return this;
  }

  /**
   * Indicates whether the alarm affects service or not.
   * @return serviceAffecting
  **/
  @ApiModelProperty(value = "Indicates whether the alarm affects service or not.")
  
    public Boolean isServiceAffecting() {
    return serviceAffecting;
  }

  public void setServiceAffecting(Boolean serviceAffecting) {
    this.serviceAffecting = serviceAffecting;
  }

  public AlarmUpdate specificProblem(String specificProblem) {
    this.specificProblem = specificProblem;
    return this;
  }

  /**
   * Provides more specific information about the alarm.
   * @return specificProblem
  **/
  @ApiModelProperty(value = "Provides more specific information about the alarm.")
  
    public String getSpecificProblem() {
    return specificProblem;
  }

  public void setSpecificProblem(String specificProblem) {
    this.specificProblem = specificProblem;
  }

  public AlarmUpdate state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Defines the alarm state during its life cycle
   * @return state
  **/
  @ApiModelProperty(value = "Defines the alarm state during its life cycle")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AlarmUpdate affectedService(List<AffectedService> affectedService) {
    this.affectedService = affectedService;
    return this;
  }

  public AlarmUpdate addAffectedServiceItem(AffectedService affectedServiceItem) {
    if (this.affectedService == null) {
      this.affectedService = new ArrayList<>();
    }
    this.affectedService.add(affectedServiceItem);
    return this;
  }

  /**
   * Get affectedService
   * @return affectedService
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AffectedService> getAffectedService() {
    return affectedService;
  }

  public void setAffectedService(List<AffectedService> affectedService) {
    this.affectedService = affectedService;
  }

  public AlarmUpdate alarmedObject(AlarmedObject alarmedObject) {
    this.alarmedObject = alarmedObject;
    return this;
  }

  /**
   * Get alarmedObject
   * @return alarmedObject
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public AlarmedObject getAlarmedObject() {
    return alarmedObject;
  }

  public void setAlarmedObject(AlarmedObject alarmedObject) {
    this.alarmedObject = alarmedObject;
  }

  public AlarmUpdate comment(List<Comment> comment) {
    this.comment = comment;
    return this;
  }

  public AlarmUpdate addCommentItem(Comment commentItem) {
    if (this.comment == null) {
      this.comment = new ArrayList<>();
    }
    this.comment.add(commentItem);
    return this;
  }

  /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Comment> getComment() {
    return comment;
  }

  public void setComment(List<Comment> comment) {
    this.comment = comment;
  }

  public AlarmUpdate correlatedAlarm(List<AlarmRef> correlatedAlarm) {
    this.correlatedAlarm = correlatedAlarm;
    return this;
  }

  public AlarmUpdate addCorrelatedAlarmItem(AlarmRef correlatedAlarmItem) {
    if (this.correlatedAlarm == null) {
      this.correlatedAlarm = new ArrayList<>();
    }
    this.correlatedAlarm.add(correlatedAlarmItem);
    return this;
  }

  /**
   * Get correlatedAlarm
   * @return correlatedAlarm
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AlarmRef> getCorrelatedAlarm() {
    return correlatedAlarm;
  }

  public void setCorrelatedAlarm(List<AlarmRef> correlatedAlarm) {
    this.correlatedAlarm = correlatedAlarm;
  }

  public AlarmUpdate crossedThresholdInformation(CrossedThresholdInformation crossedThresholdInformation) {
    this.crossedThresholdInformation = crossedThresholdInformation;
    return this;
  }

  /**
   * Get crossedThresholdInformation
   * @return crossedThresholdInformation
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CrossedThresholdInformation getCrossedThresholdInformation() {
    return crossedThresholdInformation;
  }

  public void setCrossedThresholdInformation(CrossedThresholdInformation crossedThresholdInformation) {
    this.crossedThresholdInformation = crossedThresholdInformation;
  }

  public AlarmUpdate parentAlarm(List<AlarmRef> parentAlarm) {
    this.parentAlarm = parentAlarm;
    return this;
  }

  public AlarmUpdate addParentAlarmItem(AlarmRef parentAlarmItem) {
    if (this.parentAlarm == null) {
      this.parentAlarm = new ArrayList<>();
    }
    this.parentAlarm.add(parentAlarmItem);
    return this;
  }

  /**
   * Get parentAlarm
   * @return parentAlarm
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AlarmRef> getParentAlarm() {
    return parentAlarm;
  }

  public void setParentAlarm(List<AlarmRef> parentAlarm) {
    this.parentAlarm = parentAlarm;
  }

  public AlarmUpdate place(List<RelatedPlaceRefOrValue> place) {
    this.place = place;
    return this;
  }

  public AlarmUpdate addPlaceItem(RelatedPlaceRefOrValue placeItem) {
    if (this.place == null) {
      this.place = new ArrayList<>();
    }
    this.place.add(placeItem);
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<RelatedPlaceRefOrValue> getPlace() {
    return place;
  }

  public void setPlace(List<RelatedPlaceRefOrValue> place) {
    this.place = place;
  }

  public AlarmUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The base type of this alarm.
   * @return baseType
  **/
  @ApiModelProperty(value = "The base type of this alarm.")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public AlarmUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A reference to the schema describing this alarm.
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A reference to the schema describing this alarm.")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public AlarmUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type for this alarm.
   * @return type
  **/
  @ApiModelProperty(value = "The type for this alarm.")
  
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
    AlarmUpdate alarmUpdate = (AlarmUpdate) o;
    return Objects.equals(this.ackState, alarmUpdate.ackState) &&
        Objects.equals(this.ackSystemId, alarmUpdate.ackSystemId) &&
        Objects.equals(this.ackUserId, alarmUpdate.ackUserId) &&
        Objects.equals(this.alarmChangedTime, alarmUpdate.alarmChangedTime) &&
        Objects.equals(this.alarmClearedTime, alarmUpdate.alarmClearedTime) &&
        Objects.equals(this.alarmDetails, alarmUpdate.alarmDetails) &&
        Objects.equals(this.alarmEscalation, alarmUpdate.alarmEscalation) &&
        Objects.equals(this.alarmReportingTime, alarmUpdate.alarmReportingTime) &&
        Objects.equals(this.alarmType, alarmUpdate.alarmType) &&
        Objects.equals(this.alarmedObjectType, alarmUpdate.alarmedObjectType) &&
        Objects.equals(this.clearSystemId, alarmUpdate.clearSystemId) &&
        Objects.equals(this.clearUserId, alarmUpdate.clearUserId) &&
        Objects.equals(this.externalAlarmId, alarmUpdate.externalAlarmId) &&
        Objects.equals(this.isRootCause, alarmUpdate.isRootCause) &&
        Objects.equals(this.perceivedSeverity, alarmUpdate.perceivedSeverity) &&
        Objects.equals(this.plannedOutageIndicator, alarmUpdate.plannedOutageIndicator) &&
        Objects.equals(this.probableCause, alarmUpdate.probableCause) &&
        Objects.equals(this.proposedRepairedActions, alarmUpdate.proposedRepairedActions) &&
        Objects.equals(this.reportingSystemId, alarmUpdate.reportingSystemId) &&
        Objects.equals(this.serviceAffecting, alarmUpdate.serviceAffecting) &&
        Objects.equals(this.specificProblem, alarmUpdate.specificProblem) &&
        Objects.equals(this.state, alarmUpdate.state) &&
        Objects.equals(this.affectedService, alarmUpdate.affectedService) &&
        Objects.equals(this.alarmedObject, alarmUpdate.alarmedObject) &&
        Objects.equals(this.comment, alarmUpdate.comment) &&
        Objects.equals(this.correlatedAlarm, alarmUpdate.correlatedAlarm) &&
        Objects.equals(this.crossedThresholdInformation, alarmUpdate.crossedThresholdInformation) &&
        Objects.equals(this.parentAlarm, alarmUpdate.parentAlarm) &&
        Objects.equals(this.place, alarmUpdate.place) &&
        Objects.equals(this.baseType, alarmUpdate.baseType) &&
        Objects.equals(this.schemaLocation, alarmUpdate.schemaLocation) &&
        Objects.equals(this.type, alarmUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ackState, ackSystemId, ackUserId, alarmChangedTime, alarmClearedTime, alarmDetails, alarmEscalation, alarmReportingTime, alarmType, alarmedObjectType, clearSystemId, clearUserId, externalAlarmId, isRootCause, perceivedSeverity, plannedOutageIndicator, probableCause, proposedRepairedActions, reportingSystemId, serviceAffecting, specificProblem, state, affectedService, alarmedObject, comment, correlatedAlarm, crossedThresholdInformation, parentAlarm, place, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlarmUpdate {\n");
    
    sb.append("    ackState: ").append(toIndentedString(ackState)).append("\n");
    sb.append("    ackSystemId: ").append(toIndentedString(ackSystemId)).append("\n");
    sb.append("    ackUserId: ").append(toIndentedString(ackUserId)).append("\n");
    sb.append("    alarmChangedTime: ").append(toIndentedString(alarmChangedTime)).append("\n");
    sb.append("    alarmClearedTime: ").append(toIndentedString(alarmClearedTime)).append("\n");
    sb.append("    alarmDetails: ").append(toIndentedString(alarmDetails)).append("\n");
    sb.append("    alarmEscalation: ").append(toIndentedString(alarmEscalation)).append("\n");
    sb.append("    alarmReportingTime: ").append(toIndentedString(alarmReportingTime)).append("\n");
    sb.append("    alarmType: ").append(toIndentedString(alarmType)).append("\n");
    sb.append("    alarmedObjectType: ").append(toIndentedString(alarmedObjectType)).append("\n");
    sb.append("    clearSystemId: ").append(toIndentedString(clearSystemId)).append("\n");
    sb.append("    clearUserId: ").append(toIndentedString(clearUserId)).append("\n");
    sb.append("    externalAlarmId: ").append(toIndentedString(externalAlarmId)).append("\n");
    sb.append("    isRootCause: ").append(toIndentedString(isRootCause)).append("\n");
    sb.append("    perceivedSeverity: ").append(toIndentedString(perceivedSeverity)).append("\n");
    sb.append("    plannedOutageIndicator: ").append(toIndentedString(plannedOutageIndicator)).append("\n");
    sb.append("    probableCause: ").append(toIndentedString(probableCause)).append("\n");
    sb.append("    proposedRepairedActions: ").append(toIndentedString(proposedRepairedActions)).append("\n");
    sb.append("    reportingSystemId: ").append(toIndentedString(reportingSystemId)).append("\n");
    sb.append("    serviceAffecting: ").append(toIndentedString(serviceAffecting)).append("\n");
    sb.append("    specificProblem: ").append(toIndentedString(specificProblem)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    affectedService: ").append(toIndentedString(affectedService)).append("\n");
    sb.append("    alarmedObject: ").append(toIndentedString(alarmedObject)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    correlatedAlarm: ").append(toIndentedString(correlatedAlarm)).append("\n");
    sb.append("    crossedThresholdInformation: ").append(toIndentedString(crossedThresholdInformation)).append("\n");
    sb.append("    parentAlarm: ").append(toIndentedString(parentAlarm)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
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
