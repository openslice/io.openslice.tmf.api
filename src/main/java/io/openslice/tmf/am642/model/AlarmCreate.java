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
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This resource represents an alarm supporting the information model defined in
 * ITU-T X.733. Skipped properties: id,href
 */
@Schema(description = "This resource represents an alarm supporting the information model defined in ITU-T X.733. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class AlarmCreate extends AlarmUpdate {

	private OffsetDateTime alarmRaisedTime = null;

	@JsonProperty("sourceSystemId")
	private String sourceSystemId = null;

	/**
	 * Indicates the time (as a date + time) at which the alarm occurred at its
	 * source.
	 * 
	 * @return alarmRaisedTime
	 **/
	@Schema(description = "Indicates the time (as a date + time) at which the alarm occurred at its source.")
	@NotNull

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
	
	public void setAlarmRaisedTime(String aalarmRaisedTime) {
		if (aalarmRaisedTime != null) {
			this.alarmRaisedTime = OffsetDateTime.parse(aalarmRaisedTime);
		}

	}

	public AlarmCreate sourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
		return this;
	}

	/**
	 * Source system identity.
	 * 
	 * @return sourceSystemId
	 **/
	@Schema(description = "Source system identity.")
	@NotNull

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AlarmCreate alarmCreate = (AlarmCreate) o;
		return Objects.equals(this.ackState, alarmCreate.ackState)
				&& Objects.equals(this.ackSystemId, alarmCreate.ackSystemId)
				&& Objects.equals(this.ackUserId, alarmCreate.ackUserId)
				&& Objects.equals(this.alarmChangedTime, alarmCreate.alarmChangedTime)
				&& Objects.equals(this.alarmClearedTime, alarmCreate.alarmClearedTime)
				&& Objects.equals(this.alarmDetails, alarmCreate.alarmDetails)
				&& Objects.equals(this.alarmEscalation, alarmCreate.alarmEscalation)
				&& Objects.equals(this.alarmRaisedTime, alarmCreate.alarmRaisedTime)
				&& Objects.equals(this.alarmReportingTime, alarmCreate.alarmReportingTime)
				&& Objects.equals(this.alarmType, alarmCreate.alarmType)
				&& Objects.equals(this.alarmedObjectType, alarmCreate.alarmedObjectType)
				&& Objects.equals(this.clearSystemId, alarmCreate.clearSystemId)
				&& Objects.equals(this.clearUserId, alarmCreate.clearUserId)
				&& Objects.equals(this.externalAlarmId, alarmCreate.externalAlarmId)
				&& Objects.equals(this.isRootCause, alarmCreate.isRootCause)
				&& Objects.equals(this.perceivedSeverity, alarmCreate.perceivedSeverity)
				&& Objects.equals(this.plannedOutageIndicator, alarmCreate.plannedOutageIndicator)
				&& Objects.equals(this.probableCause, alarmCreate.probableCause)
				&& Objects.equals(this.proposedRepairedActions, alarmCreate.proposedRepairedActions)
				&& Objects.equals(this.reportingSystemId, alarmCreate.reportingSystemId)
				&& Objects.equals(this.serviceAffecting, alarmCreate.serviceAffecting)
				&& Objects.equals(this.sourceSystemId, alarmCreate.sourceSystemId)
				&& Objects.equals(this.specificProblem, alarmCreate.specificProblem)
				&& Objects.equals(this.state, alarmCreate.state)
				&& Objects.equals(this.affectedService, alarmCreate.affectedService)
				&& Objects.equals(this.alarmedObject, alarmCreate.alarmedObject)
				&& Objects.equals(this.comment, alarmCreate.comment)
				&& Objects.equals(this.correlatedAlarm, alarmCreate.correlatedAlarm)
				&& Objects.equals(this.crossedThresholdInformation, alarmCreate.crossedThresholdInformation)
				&& Objects.equals(this.parentAlarm, alarmCreate.parentAlarm)
				&& Objects.equals(this.place, alarmCreate.place) && Objects.equals(this.baseType, alarmCreate.baseType)
				&& Objects.equals(this.schemaLocation, alarmCreate.schemaLocation)
				&& Objects.equals(this.type, alarmCreate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ackState, ackSystemId, ackUserId, alarmChangedTime, alarmClearedTime, alarmDetails,
				alarmEscalation, alarmRaisedTime, alarmReportingTime, alarmType, alarmedObjectType, clearSystemId,
				clearUserId, externalAlarmId, isRootCause, perceivedSeverity, plannedOutageIndicator, probableCause,
				proposedRepairedActions, reportingSystemId, serviceAffecting, sourceSystemId, specificProblem, state,
				affectedService, alarmedObject, comment, correlatedAlarm, crossedThresholdInformation, parentAlarm,
				place, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlarmCreate {\n");

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
