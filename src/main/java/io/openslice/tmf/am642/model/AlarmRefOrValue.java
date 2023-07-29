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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * An alarm defined by reference or value. The polymorphic
 * attributes @type, @schemaLocation &amp; @referredType are related to the
 * alarm entity and not the RelatedAlarmRefOrValue class itself
 */
@Schema(description = "An alarm defined by reference or value. The polymorphic attributes @type, @schemaLocation & @referredType are related to the alarm entity and not the RelatedAlarmRefOrValue class itself")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMAlarmRefOrVal")
@Table(name = "AMAlarmRefOrVal")
public class AlarmRefOrValue extends BaseRootNamedEntity {
	
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("ackState")
	private String ackState = null;

	@JsonProperty("ackSystemId")
	private String ackSystemId = null;

	@JsonProperty("ackUserId")
	private String ackUserId = null;

	private OffsetDateTime alarmChangedTime = null;

	private OffsetDateTime alarmClearedTime = null;

	@JsonProperty("alarmDetails")
	private String alarmDetails = null;

	@JsonProperty("alarmEscalation")
	private Boolean alarmEscalation = null;

	private OffsetDateTime alarmRaisedTime = null;

	private OffsetDateTime alarmReportingTime = null;

	@JsonProperty("alarmType")
	private String alarmType = null;

	@JsonProperty("alarmedObjectType")
	private String alarmedObjectType = null;

	@JsonProperty("clearSystemId")
	private String clearSystemId = null;

	@JsonProperty("clearUserId")
	private String clearUserId = null;

	@JsonProperty("externalAlarmId")
	private String externalAlarmId = null;

	@JsonProperty("isRootCause")
	private Boolean isRootCause = null;

	@JsonProperty("perceivedSeverity")
	private String perceivedSeverity = null;

	@JsonProperty("plannedOutageIndicator")
	private String plannedOutageIndicator = null;

	@JsonProperty("probableCause")
	private String probableCause = null;

	@JsonProperty("proposedRepairedActions")
	private String proposedRepairedActions = null;

	@JsonProperty("reportingSystemId")
	private String reportingSystemId = null;

	@JsonProperty("serviceAffecting")
	private Boolean serviceAffecting = null;

	@JsonProperty("sourceSystemId")
	private String sourceSystemId = null;

	@JsonProperty("specificProblem")
	private String specificProblem = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("affectedService")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AffectedService> affectedService = new HashSet<>();

	@JsonProperty("alarmedObject")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private AlarmedObject alarmedObject = null;

	@JsonProperty("comment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Comment> comment = new HashSet<>();

	@JsonProperty("correlatedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRef> correlatedAlarm = new HashSet<>();

	@JsonProperty("crossedThresholdInformation")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private CrossedThresholdInformation crossedThresholdInformation = null;

	@JsonProperty("parentAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRef> parentAlarm = new HashSet<>();

	@JsonProperty("place")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedPlaceRefOrValue> place = new HashSet<>();

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	public AlarmRefOrValue id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of the alarm, determined by the alarm owning system
	 * 
	 * @return id
	 **/
	@Schema(description = "Identifier of the alarm, determined by the alarm owning system")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlarmRefOrValue href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * A reference to the alarm.
	 * 
	 * @return href
	 **/
	@Schema(description = "A reference to the alarm.")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public AlarmRefOrValue ackState(String ackState) {
		this.ackState = ackState;
		return this;
	}

	/**
	 * Provides the Acknowledgement State of the alarm
	 * 
	 * @return ackState
	 **/
	@Schema(description = "Provides the Acknowledgement State of the alarm")

	public String getAckState() {
		return ackState;
	}

	public void setAckState(String ackState) {
		this.ackState = ackState;
	}

	public AlarmRefOrValue ackSystemId(String ackSystemId) {
		this.ackSystemId = ackSystemId;
		return this;
	}

	/**
	 * Provides the name of the system that last changed the ackState of an alarm,
	 * i.e. acknowledged or unacknowledged the alarm.
	 * 
	 * @return ackSystemId
	 **/
	@Schema(description = "Provides the name of the system that last changed the ackState of an alarm, i.e. acknowledged or unacknowledged the alarm.")

	public String getAckSystemId() {
		return ackSystemId;
	}

	public void setAckSystemId(String ackSystemId) {
		this.ackSystemId = ackSystemId;
	}

	public AlarmRefOrValue ackUserId(String ackUserId) {
		this.ackUserId = ackUserId;
		return this;
	}

	/**
	 * Provides the id of the user who has last changed the ack state of the alarm,
	 * i.e. acknowledged or unacknowledged the alarm.
	 * 
	 * @return ackUserId
	 **/
	@Schema(description = "Provides the id of the user who has last changed the ack state of the alarm, i.e. acknowledged or unacknowledged the alarm.")

	public String getAckUserId() {
		return ackUserId;
	}

	public void setAckUserId(String ackUserId) {
		this.ackUserId = ackUserId;
	}

	public AlarmRefOrValue alarmChangedTime(OffsetDateTime alarmChangedTime) {
		this.alarmChangedTime = alarmChangedTime;
		return this;
	}

	/**
	 * Indicates the last date and time when the alarm is changed on the
	 * alarm-owning system. Any change to the alarm whether coming from the alarmed
	 * resource, or triggered by a change from the client is changing this time.
	 * 
	 * @return alarmChangedTime
	 **/
	@Schema(description = "Indicates the last date and time when the alarm is changed on the alarm-owning system. Any change to the alarm whether coming from the alarmed resource, or triggered by a change from the client is changing this time.")

	@Valid
	public OffsetDateTime getAlarmChangedTime() {
		return alarmChangedTime;
	}

	public void setAlarmChangedTime(OffsetDateTime alarmChangedTime) {
		this.alarmChangedTime = alarmChangedTime;
	}

	@JsonProperty("alarmChangedTime")
	public String getAlarmChangedTimeStr() {
		if (this.alarmChangedTime != null) {
			return this.alarmChangedTime.toString();
		} else {
			return null;
		}
	}

	public AlarmRefOrValue alarmClearedTime(OffsetDateTime alarmClearedTime) {
		this.alarmClearedTime = alarmClearedTime;
		return this;
	}

	/**
	 * Indicates the time (as a date + time) at which the alarm is cleared at the
	 * source.
	 * 
	 * @return alarmClearedTime
	 **/
	@Schema(description = "Indicates the time (as a date + time) at which the alarm is cleared at the source. ")

	@Valid
	public OffsetDateTime getAlarmClearedTime() {
		return alarmClearedTime;
	}

	public void setAlarmClearedTime(OffsetDateTime alarmClearedTime) {
		this.alarmClearedTime = alarmClearedTime;
	}

	@JsonProperty("alarmClearedTime")
	public String getAlarmClearedTimeStr() {
		if (this.alarmClearedTime != null) {
			return this.alarmClearedTime.toString();
		} else {
			return null;
		}
	}

	public AlarmRefOrValue alarmDetails(String alarmDetails) {
		this.alarmDetails = alarmDetails;
		return this;
	}

	/**
	 * Contains further information on the alarm.
	 * 
	 * @return alarmDetails
	 **/
	@Schema(description = "Contains further information on the alarm.")

	public String getAlarmDetails() {
		return alarmDetails;
	}

	public void setAlarmDetails(String alarmDetails) {
		this.alarmDetails = alarmDetails;
	}

	public AlarmRefOrValue alarmEscalation(Boolean alarmEscalation) {
		this.alarmEscalation = alarmEscalation;
		return this;
	}

	/**
	 * Indicates if this alarm has been escalated or not.
	 * 
	 * @return alarmEscalation
	 **/
	@Schema(description = "Indicates if this alarm has been escalated or not. ")

	public Boolean isAlarmEscalation() {
		return alarmEscalation;
	}

	public void setAlarmEscalation(Boolean alarmEscalation) {
		this.alarmEscalation = alarmEscalation;
	}

	public AlarmRefOrValue alarmRaisedTime(OffsetDateTime alarmRaisedTime) {
		this.alarmRaisedTime = alarmRaisedTime;
		return this;
	}

	/**
	 * Indicates the time (as a date + time) at which the alarm occurred at its
	 * source.
	 * 
	 * @return alarmRaisedTime
	 **/
	@Schema(description = "Indicates the time (as a date + time) at which the alarm occurred at its source.")

	@Valid
	public OffsetDateTime getAlarmRaisedTime() {
		return alarmRaisedTime;
	}

	public void setAlarmRaisedTime(OffsetDateTime alarmRaisedTime) {
		this.alarmRaisedTime = alarmRaisedTime;
	}

	@JsonProperty("alarmRaisedTime")
	public String getAlarmRaisedTimeStr() {
		if (this.alarmRaisedTime != null) {
			return this.alarmRaisedTime.toString();
		} else {
			return null;
		}
	}

	public AlarmRefOrValue alarmReportingTime(OffsetDateTime alarmReportingTime) {
		this.alarmReportingTime = alarmReportingTime;
		return this;
	}

	/**
	 * Indicates the time (as a date + time) at which the alarm was reported by the
	 * owning OSS. It might be different from the alarmRaisedTime. For instance, if
	 * the alarm list is maintained by an EMS, the alarmRaisedtime would be the time
	 * the alarm was detected by the NE, while the alarmReportingTime would be the
	 * time this alarm was stored in the alarm list of the EMS.
	 * 
	 * @return alarmReportingTime
	 **/
	@Schema(description = "Indicates the time (as a date + time) at which the alarm was reported by the owning OSS. It might be different from the alarmRaisedTime. For instance, if the alarm list is maintained by an EMS, the alarmRaisedtime would be the time the alarm   was detected by the NE, while the alarmReportingTime would be the time this alarm was stored in the alarm list of the EMS.")

	@Valid
	public OffsetDateTime getAlarmReportingTime() {
		return alarmReportingTime;
	}

	public void setAlarmReportingTime(OffsetDateTime alarmReportingTime) {
		this.alarmReportingTime = alarmReportingTime;
	}

	@JsonProperty("alarmReportingTime")
	public String getAlarmReportingTimeStr() {
		if (this.alarmReportingTime != null) {
			return this.alarmReportingTime.toString();
		} else {
			return null;
		}
	}

	public AlarmRefOrValue alarmType(String alarmType) {
		this.alarmType = alarmType;
		return this;
	}

	/**
	 * Categorize the alarm. Should be one of the values defined in X.733 8.1.1 or
	 * 3GPP TS 32.111-2 Annex A: Communications Alarm Processing Error Alarm
	 * Environmental Alarm Quality of Service Alarm Equipment Alarm Integrity
	 * Violation Operational Violation Physical Violation Security Service or
	 * Mechanism Violation Time Domain Violation
	 * 
	 * @return alarmType
	 **/
	@Schema(description = "Categorize the alarm. Should be one of the values defined in X.733 8.1.1 or 3GPP TS 32.111-2 Annex A:  Communications Alarm  Processing Error Alarm  Environmental Alarm  Quality of Service Alarm  Equipment Alarm  Integrity Violation  Operational Violation  Physical Violation  Security Service or Mechanism Violation  Time Domain Violation")

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public AlarmRefOrValue alarmedObjectType(String alarmedObjectType) {
		this.alarmedObjectType = alarmedObjectType;
		return this;
	}

	/**
	 * The type (class) of the managed object associated with the event.
	 * 
	 * @return alarmedObjectType
	 **/
	@Schema(description = "The type (class) of the managed object associated with the event.")

	public String getAlarmedObjectType() {
		return alarmedObjectType;
	}

	public void setAlarmedObjectType(String alarmedObjectType) {
		this.alarmedObjectType = alarmedObjectType;
	}

	public AlarmRefOrValue clearSystemId(String clearSystemId) {
		this.clearSystemId = clearSystemId;
		return this;
	}

	/**
	 * Provides the id of the system where the user who invoked the alarmCleared
	 * operation is located.
	 * 
	 * @return clearSystemId
	 **/
	@Schema(description = "Provides the id of the system where the user who invoked the alarmCleared operation is located. ")

	public String getClearSystemId() {
		return clearSystemId;
	}

	public void setClearSystemId(String clearSystemId) {
		this.clearSystemId = clearSystemId;
	}

	public AlarmRefOrValue clearUserId(String clearUserId) {
		this.clearUserId = clearUserId;
		return this;
	}

	/**
	 * Provides the id of the user who invoked the alarmCleared operation
	 * 
	 * @return clearUserId
	 **/
	@Schema(description = "Provides the id of the user who invoked the alarmCleared operation")

	public String getClearUserId() {
		return clearUserId;
	}

	public void setClearUserId(String clearUserId) {
		this.clearUserId = clearUserId;
	}

	public AlarmRefOrValue externalAlarmId(String externalAlarmId) {
		this.externalAlarmId = externalAlarmId;
		return this;
	}

	/**
	 * An identifier of the alarm in the source system.
	 * 
	 * @return externalAlarmId
	 **/
	@Schema(description = "An identifier of the alarm in the source system.")

	public String getExternalAlarmId() {
		return externalAlarmId;
	}

	public void setExternalAlarmId(String externalAlarmId) {
		this.externalAlarmId = externalAlarmId;
	}

	public AlarmRefOrValue isRootCause(Boolean isRootCause) {
		this.isRootCause = isRootCause;
		return this;
	}

	/**
	 * Indicates whether the alarm is a root cause alarm..
	 * 
	 * @return isRootCause
	 **/
	@Schema(description = "Indicates whether the alarm is a root cause alarm.. ")

	public Boolean isIsRootCause() {
		return isRootCause;
	}

	public void setIsRootCause(Boolean isRootCause) {
		this.isRootCause = isRootCause;
	}

	public AlarmRefOrValue perceivedSeverity(String perceivedSeverity) {
		this.perceivedSeverity = perceivedSeverity;
		return this;
	}

	/**
	 * Lists the possible severities that can be allocated to an Alarm. The values
	 * are consistent with ITU-T Recommendation X.733. Once an alarm has been
	 * cleared, its perceived severity is set to 'cleared' and can no longer be set.
	 * 
	 * @return perceivedSeverity
	 **/
	@Schema(description = "Lists the possible severities that can be allocated to an Alarm. The values are consistent with ITU-T Recommendation X.733. Once an alarm has been cleared, its perceived severity is set to 'cleared' and can no longer be set.")

	public String getPerceivedSeverity() {
		return perceivedSeverity;
	}

	public void setPerceivedSeverity(String perceivedSeverity) {
		this.perceivedSeverity = perceivedSeverity;
	}

	public AlarmRefOrValue plannedOutageIndicator(String plannedOutageIndicator) {
		this.plannedOutageIndicator = plannedOutageIndicator;
		return this;
	}

	/**
	 * Indicates that the Managed Object (related to this alarm) is in planned
	 * outage (in planned maintenance, or out-of-service).
	 * 
	 * @return plannedOutageIndicator
	 **/
	@Schema(description = "Indicates that the Managed Object (related to this alarm) is in planned outage (in planned maintenance, or out-of-service). ")

	public String getPlannedOutageIndicator() {
		return plannedOutageIndicator;
	}

	public void setPlannedOutageIndicator(String plannedOutageIndicator) {
		this.plannedOutageIndicator = plannedOutageIndicator;
	}

	public AlarmRefOrValue probableCause(String probableCause) {
		this.probableCause = probableCause;
		return this;
	}

	/**
	 * Provides the probable cause of the alarm. The values are consistent with
	 * ITU-T Recommendation X.733 or 3GPP TS 32.111-2 Annex B.
	 * 
	 * @return probableCause
	 **/
	@Schema(description = "Provides the probable cause of the alarm. The values are consistent with ITU-T Recommendation X.733 or 3GPP TS 32.111-2 Annex B.")

	public String getProbableCause() {
		return probableCause;
	}

	public void setProbableCause(String probableCause) {
		this.probableCause = probableCause;
	}

	public AlarmRefOrValue proposedRepairedActions(String proposedRepairedActions) {
		this.proposedRepairedActions = proposedRepairedActions;
		return this;
	}

	/**
	 * Indicates proposed repair actions, if known to the system emitting the alarm.
	 * 
	 * @return proposedRepairedActions
	 **/
	@Schema(description = "Indicates proposed repair actions, if known to the system emitting the alarm.")

	public String getProposedRepairedActions() {
		return proposedRepairedActions;
	}

	public void setProposedRepairedActions(String proposedRepairedActions) {
		this.proposedRepairedActions = proposedRepairedActions;
	}

	public AlarmRefOrValue reportingSystemId(String reportingSystemId) {
		this.reportingSystemId = reportingSystemId;
		return this;
	}

	/**
	 * Reporting system identity.
	 * 
	 * @return reportingSystemId
	 **/
	@Schema(description = "Reporting system identity.")

	public String getReportingSystemId() {
		return reportingSystemId;
	}

	public void setReportingSystemId(String reportingSystemId) {
		this.reportingSystemId = reportingSystemId;
	}

	public AlarmRefOrValue serviceAffecting(Boolean serviceAffecting) {
		this.serviceAffecting = serviceAffecting;
		return this;
	}

	/**
	 * Indicates whether the alarm affects service or not.
	 * 
	 * @return serviceAffecting
	 **/
	@Schema(description = "Indicates whether the alarm affects service or not.")

	public Boolean isServiceAffecting() {
		return serviceAffecting;
	}

	public void setServiceAffecting(Boolean serviceAffecting) {
		this.serviceAffecting = serviceAffecting;
	}

	public AlarmRefOrValue sourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
		return this;
	}

	/**
	 * Source system identity.
	 * 
	 * @return sourceSystemId
	 **/
	@Schema(description = "Source system identity.")

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public AlarmRefOrValue specificProblem(String specificProblem) {
		this.specificProblem = specificProblem;
		return this;
	}

	/**
	 * Provides more specific information about the alarm.
	 * 
	 * @return specificProblem
	 **/
	@Schema(description = "Provides more specific information about the alarm.")

	public String getSpecificProblem() {
		return specificProblem;
	}

	public void setSpecificProblem(String specificProblem) {
		this.specificProblem = specificProblem;
	}

	public AlarmRefOrValue state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * Defines the alarm state during its life cycle
	 * 
	 * @return state
	 **/
	@Schema(description = "Defines the alarm state during its life cycle")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AlarmRefOrValue affectedService(Set<AffectedService> affectedService) {
		this.affectedService = affectedService;
		return this;
	}

	public AlarmRefOrValue addAffectedServiceItem(AffectedService affectedServiceItem) {
		if (this.affectedService == null) {
			this.affectedService = new HashSet<>();
		}
		this.affectedService.add(affectedServiceItem);
		return this;
	}

	/**
	 * Get affectedService
	 * 
	 * @return affectedService
	 **/
	@Schema(description = "")
	@Valid
	public Set<AffectedService> getAffectedService() {
		return affectedService;
	}

	public void setAffectedService(Set<AffectedService> affectedService) {
		this.affectedService = affectedService;
	}

	public AlarmRefOrValue alarmedObject(AlarmedObject alarmedObject) {
		this.alarmedObject = alarmedObject;
		return this;
	}

	/**
	 * Get alarmedObject
	 * 
	 * @return alarmedObject
	 **/
	@Schema(description = "")

	@Valid
	public AlarmedObject getAlarmedObject() {
		return alarmedObject;
	}

	public void setAlarmedObject(AlarmedObject alarmedObject) {
		this.alarmedObject = alarmedObject;
	}

	public AlarmRefOrValue comment(Set<Comment> comment) {
		this.comment = comment;
		return this;
	}

	public AlarmRefOrValue addCommentItem(Comment commentItem) {
		if (this.comment == null) {
			this.comment = new HashSet<>();
		}
		this.comment.add(commentItem);
		return this;
	}

	/**
	 * Get comment
	 * 
	 * @return comment
	 **/
	@Schema(description = "")
	@Valid
	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public AlarmRefOrValue correlatedAlarm(Set<AlarmRef> correlatedAlarm) {
		this.correlatedAlarm = correlatedAlarm;
		return this;
	}

	public AlarmRefOrValue addCorrelatedAlarmItem(AlarmRef correlatedAlarmItem) {
		if (this.correlatedAlarm == null) {
			this.correlatedAlarm = new HashSet<>();
		}
		this.correlatedAlarm.add(correlatedAlarmItem);
		return this;
	}

	/**
	 * Get correlatedAlarm
	 * 
	 * @return correlatedAlarm
	 **/
	@Schema(description = "")
	@Valid
	public Set<AlarmRef> getCorrelatedAlarm() {
		return correlatedAlarm;
	}

	public void setCorrelatedAlarm(Set<AlarmRef> correlatedAlarm) {
		this.correlatedAlarm = correlatedAlarm;
	}

	public AlarmRefOrValue crossedThresholdInformation(CrossedThresholdInformation crossedThresholdInformation) {
		this.crossedThresholdInformation = crossedThresholdInformation;
		return this;
	}

	/**
	 * Get crossedThresholdInformation
	 * 
	 * @return crossedThresholdInformation
	 **/
	@Schema(description = "")

	@Valid
	public CrossedThresholdInformation getCrossedThresholdInformation() {
		return crossedThresholdInformation;
	}

	public void setCrossedThresholdInformation(CrossedThresholdInformation crossedThresholdInformation) {
		this.crossedThresholdInformation = crossedThresholdInformation;
	}

	public AlarmRefOrValue parentAlarm(Set<AlarmRef> parentAlarm) {
		this.parentAlarm = parentAlarm;
		return this;
	}

	public AlarmRefOrValue addParentAlarmItem(AlarmRef parentAlarmItem) {
		if (this.parentAlarm == null) {
			this.parentAlarm = new HashSet<>();
		}
		this.parentAlarm.add(parentAlarmItem);
		return this;
	}

	/**
	 * Get parentAlarm
	 * 
	 * @return parentAlarm
	 **/
	@Schema(description = "")
	@Valid
	public Set<AlarmRef> getParentAlarm() {
		return parentAlarm;
	}

	public void setParentAlarm(Set<AlarmRef> parentAlarm) {
		this.parentAlarm = parentAlarm;
	}

	public AlarmRefOrValue place(Set<RelatedPlaceRefOrValue> place) {
		this.place = place;
		return this;
	}

	public AlarmRefOrValue addPlaceItem(RelatedPlaceRefOrValue placeItem) {
		if (this.place == null) {
			this.place = new HashSet<>();
		}
		this.place.add(placeItem);
		return this;
	}

	/**
	 * Get place
	 * 
	 * @return place
	 **/
	@Schema(description = "")
	@Valid
	public Set<RelatedPlaceRefOrValue> getPlace() {
		return place;
	}

	public void setPlace(Set<RelatedPlaceRefOrValue> place) {
		this.place = place;
	}

	public AlarmRefOrValue _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return _atReferredType
	 **/
	@Schema(description = "The actual type of the target instance when needed for disambiguation.")

	public String getAtReferredType() {
		return _atReferredType;
	}

	public void setAtReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AlarmRefOrValue alarmRefOrValue = (AlarmRefOrValue) o;
		return Objects.equals(this.id, alarmRefOrValue.id) && Objects.equals(this.href, alarmRefOrValue.href)
				&& Objects.equals(this.ackState, alarmRefOrValue.ackState)
				&& Objects.equals(this.ackSystemId, alarmRefOrValue.ackSystemId)
				&& Objects.equals(this.ackUserId, alarmRefOrValue.ackUserId)
				&& Objects.equals(this.alarmChangedTime, alarmRefOrValue.alarmChangedTime)
				&& Objects.equals(this.alarmClearedTime, alarmRefOrValue.alarmClearedTime)
				&& Objects.equals(this.alarmDetails, alarmRefOrValue.alarmDetails)
				&& Objects.equals(this.alarmEscalation, alarmRefOrValue.alarmEscalation)
				&& Objects.equals(this.alarmRaisedTime, alarmRefOrValue.alarmRaisedTime)
				&& Objects.equals(this.alarmReportingTime, alarmRefOrValue.alarmReportingTime)
				&& Objects.equals(this.alarmType, alarmRefOrValue.alarmType)
				&& Objects.equals(this.alarmedObjectType, alarmRefOrValue.alarmedObjectType)
				&& Objects.equals(this.clearSystemId, alarmRefOrValue.clearSystemId)
				&& Objects.equals(this.clearUserId, alarmRefOrValue.clearUserId)
				&& Objects.equals(this.externalAlarmId, alarmRefOrValue.externalAlarmId)
				&& Objects.equals(this.isRootCause, alarmRefOrValue.isRootCause)
				&& Objects.equals(this.name, alarmRefOrValue.name)
				&& Objects.equals(this.perceivedSeverity, alarmRefOrValue.perceivedSeverity)
				&& Objects.equals(this.plannedOutageIndicator, alarmRefOrValue.plannedOutageIndicator)
				&& Objects.equals(this.probableCause, alarmRefOrValue.probableCause)
				&& Objects.equals(this.proposedRepairedActions, alarmRefOrValue.proposedRepairedActions)
				&& Objects.equals(this.reportingSystemId, alarmRefOrValue.reportingSystemId)
				&& Objects.equals(this.serviceAffecting, alarmRefOrValue.serviceAffecting)
				&& Objects.equals(this.sourceSystemId, alarmRefOrValue.sourceSystemId)
				&& Objects.equals(this.specificProblem, alarmRefOrValue.specificProblem)
				&& Objects.equals(this.state, alarmRefOrValue.state)
				&& Objects.equals(this.affectedService, alarmRefOrValue.affectedService)
				&& Objects.equals(this.alarmedObject, alarmRefOrValue.alarmedObject)
				&& Objects.equals(this.comment, alarmRefOrValue.comment)
				&& Objects.equals(this.correlatedAlarm, alarmRefOrValue.correlatedAlarm)
				&& Objects.equals(this.crossedThresholdInformation, alarmRefOrValue.crossedThresholdInformation)
				&& Objects.equals(this.parentAlarm, alarmRefOrValue.parentAlarm)
				&& Objects.equals(this.place, alarmRefOrValue.place)
				&& Objects.equals(this.baseType, alarmRefOrValue.baseType)
				&& Objects.equals(this.schemaLocation, alarmRefOrValue.schemaLocation)
				&& Objects.equals(this.type, alarmRefOrValue.type)
				&& Objects.equals(this._atReferredType, alarmRefOrValue._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, ackState, ackSystemId, ackUserId, alarmChangedTime, alarmClearedTime,
				alarmDetails, alarmEscalation, alarmRaisedTime, alarmReportingTime, alarmType, alarmedObjectType,
				clearSystemId, clearUserId, externalAlarmId, isRootCause, name, perceivedSeverity,
				plannedOutageIndicator, probableCause, proposedRepairedActions, reportingSystemId, serviceAffecting,
				sourceSystemId, specificProblem, state, affectedService, alarmedObject, comment, correlatedAlarm,
				crossedThresholdInformation, parentAlarm, place, baseType, schemaLocation, type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlarmRefOrValue {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    ackState: ").append(toIndentedString(ackState)).append("\n");
		sb.append("    ackSystemId: ").append(toIndentedString(ackSystemId)).append("\n");
		sb.append("    ackUserId: ").append(toIndentedString(ackUserId)).append("\n");
		sb.append("    alarmChangedTime: ").append(toIndentedString(alarmChangedTime)).append("\n");
		sb.append("    alarmClearedTime: ").append(toIndentedString(alarmClearedTime)).append("\n");
		sb.append("    alarmDetails: ").append(toIndentedString(alarmDetails)).append("\n");
		sb.append("    alarmEscalation: ").append(toIndentedString(alarmEscalation)).append("\n");
		sb.append("    alarmRaisedTime: ").append(toIndentedString(alarmRaisedTime)).append("\n");
		sb.append("    alarmReportingTime: ").append(toIndentedString(alarmReportingTime)).append("\n");
		sb.append("    alarmType: ").append(toIndentedString(alarmType)).append("\n");
		sb.append("    alarmedObjectType: ").append(toIndentedString(alarmedObjectType)).append("\n");
		sb.append("    clearSystemId: ").append(toIndentedString(clearSystemId)).append("\n");
		sb.append("    clearUserId: ").append(toIndentedString(clearUserId)).append("\n");
		sb.append("    externalAlarmId: ").append(toIndentedString(externalAlarmId)).append("\n");
		sb.append("    isRootCause: ").append(toIndentedString(isRootCause)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    perceivedSeverity: ").append(toIndentedString(perceivedSeverity)).append("\n");
		sb.append("    plannedOutageIndicator: ").append(toIndentedString(plannedOutageIndicator)).append("\n");
		sb.append("    probableCause: ").append(toIndentedString(probableCause)).append("\n");
		sb.append("    proposedRepairedActions: ").append(toIndentedString(proposedRepairedActions)).append("\n");
		sb.append("    reportingSystemId: ").append(toIndentedString(reportingSystemId)).append("\n");
		sb.append("    serviceAffecting: ").append(toIndentedString(serviceAffecting)).append("\n");
		sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
		sb.append("    specificProblem: ").append(toIndentedString(specificProblem)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    affectedService: ").append(toIndentedString(affectedService)).append("\n");
		sb.append("    alarmedObject: ").append(toIndentedString(alarmedObject)).append("\n");
		sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
		sb.append("    correlatedAlarm: ").append(toIndentedString(correlatedAlarm)).append("\n");
		sb.append("    crossedThresholdInformation: ").append(toIndentedString(crossedThresholdInformation))
				.append("\n");
		sb.append("    parentAlarm: ").append(toIndentedString(parentAlarm)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
