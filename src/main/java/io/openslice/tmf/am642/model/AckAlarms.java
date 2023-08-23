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

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Task resource for the acknowledge alarms operation
 */
@Schema(description = "Task resource for the acknowledge alarms operation")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMAckAlarms")
@Table(name = "AMAckAlarms")
public class AckAlarms extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("href")
	private String href = null;

	@JsonProperty("ackSystemId")
	private String ackSystemId = null;

	private OffsetDateTime ackTime = null;

	@JsonProperty("ackUserId")
	private String ackUserId = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("ackedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> ackedAlarm =  new HashSet<>();

	@JsonProperty("alarmPattern")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Alarm> alarmPattern =  new HashSet<>();

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	

	public AckAlarms ackSystemId(String ackSystemId) {
		this.ackSystemId = ackSystemId;
		return this;
	}

	/**
	 * Name of the acknowledging system
	 * 
	 * @return ackSystemId
	 **/
	@Schema(description = "Name of the acknowledging system")

	public String getAckSystemId() {
		return ackSystemId;
	}

	public void setAckSystemId(String ackSystemId) {
		this.ackSystemId = ackSystemId;
	}

	public AckAlarms ackTime(OffsetDateTime ackTime) {
		this.ackTime = ackTime;
		return this;
	}

	/**
	 * Time of the acknowledgement
	 * 
	 * @return ackTime
	 **/
	@Schema(description = "Time of the acknowledgement")

	@Valid
	public OffsetDateTime getAckTime() {
		return ackTime;
	}

	public void setAckTime(OffsetDateTime ackTime) {
		this.ackTime = ackTime;
	}	
	

	@JsonProperty("ackTime")
	public String getAckTimeStr() {
		if (this.ackTime != null) {
			return this.ackTime.toString();
		} else {
			return null;
		}
	}

	public AckAlarms ackUserId(String ackUserId) {
		this.ackUserId = ackUserId;
		return this;
	}

	/**
	 * Name of the acknowledging user
	 * 
	 * @return ackUserId
	 **/
	@Schema(description = "Name of the acknowledging user")

	public String getAckUserId() {
		return ackUserId;
	}

	public void setAckUserId(String ackUserId) {
		this.ackUserId = ackUserId;
	}

	public AckAlarms state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * Current state of the operation task
	 * 
	 * @return state
	 **/
	@Schema(description = "Current state of the operation task")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AckAlarms ackedAlarm(Set<AlarmRefOrValue> ackedAlarm) {
		this.ackedAlarm = ackedAlarm;
		return this;
	}

	public AckAlarms addAckedAlarmItem(AlarmRefOrValue ackedAlarmItem) {
		if (this.ackedAlarm == null) {
			this.ackedAlarm = new HashSet<>();
		}
		this.ackedAlarm.add(ackedAlarmItem);
		return this;
	}

	/**
	 * The successfully acknowledged alarms
	 * 
	 * @return ackedAlarm
	 **/
	@Schema(description = "The successfully acknowledged alarms")
	@Valid
	public Set<AlarmRefOrValue> getAckedAlarm() {
		return ackedAlarm;
	}

	public void setAckedAlarm(Set<AlarmRefOrValue> ackedAlarm) {
		this.ackedAlarm = ackedAlarm;
	}

	public AckAlarms alarmPattern(Set<Alarm> alarmPattern) {
		this.alarmPattern = alarmPattern;
		return this;
	}

	public AckAlarms addAlarmPatternItem(Alarm alarmPatternItem) {
		if (this.alarmPattern == null) {
			this.alarmPattern = new HashSet<>();
		}
		this.alarmPattern.add(alarmPatternItem);
		return this;
	}

	/**
	 * Alarm patterns to match target alarms. An alarm will match if all of the
	 * sttributes in any of the patterns compare equal to those attributes of the
	 * alarm.
	 * 
	 * @return alarmPattern
	 **/
	@Schema(description = "Alarm patterns to match target alarms. An alarm will match if all of the sttributes in any of the patterns compare equal to those attributes of the alarm.")
	@Valid
	public Set<Alarm> getAlarmPattern() {
		return alarmPattern;
	}

	public void setAlarmPattern(Set<Alarm> alarmPattern) {
		this.alarmPattern = alarmPattern;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AckAlarms ackAlarms = (AckAlarms) o;
		return Objects.equals(this.id, ackAlarms.id) && Objects.equals(this.href, ackAlarms.href)
				&& Objects.equals(this.ackSystemId, ackAlarms.ackSystemId)
				&& Objects.equals(this.ackTime, ackAlarms.ackTime)
				&& Objects.equals(this.ackUserId, ackAlarms.ackUserId) && Objects.equals(this.state, ackAlarms.state)
				&& Objects.equals(this.ackedAlarm, ackAlarms.ackedAlarm)
				&& Objects.equals(this.alarmPattern, ackAlarms.alarmPattern)
				&& Objects.equals(this.baseType, ackAlarms.baseType)
				&& Objects.equals(this.schemaLocation, ackAlarms.schemaLocation)
				&& Objects.equals(this.type, ackAlarms.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, ackSystemId, ackTime, ackUserId, state, ackedAlarm, alarmPattern, baseType,
				schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AckAlarms {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
