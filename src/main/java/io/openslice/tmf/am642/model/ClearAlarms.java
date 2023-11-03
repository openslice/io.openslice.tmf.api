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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Task resource for clear alarms operation
 */
@Schema(description = "Task resource for clear alarms operation")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")

@Entity(name = "AMClearAlarms")
@Table(name = "AMClearAlarms")
@ApiResponse
public class ClearAlarms extends BaseRootEntity {

	@JsonProperty("id")
	private String id = null;

	private OffsetDateTime alarmClearedTime = null;

	@JsonProperty("clearSystemId")
	private String clearSystemId = null;

	@JsonProperty("clearUserId")
	private String clearUserId = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("alarmPattern")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Alarm> alarmPattern =  new HashSet<>();

	@JsonProperty("clearedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> clearedAlarm =  new HashSet<>();

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public ClearAlarms alarmClearedTime(OffsetDateTime alarmClearedTime) {
		this.alarmClearedTime = alarmClearedTime;
		return this;
	}

	/**
	 * Time of the alarm clearing
	 * 
	 * @return alarmClearedTime
	 **/
	@Schema(description = "Time of the alarm clearing")

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
	
	
	

	public ClearAlarms clearSystemId(String clearSystemId) {
		this.clearSystemId = clearSystemId;
		return this;
	}

	/**
	 * Name of the clearing system
	 * 
	 * @return clearSystemId
	 **/
	@Schema(description = "Name of the clearing system")

	public String getClearSystemId() {
		return clearSystemId;
	}

	public void setClearSystemId(String clearSystemId) {
		this.clearSystemId = clearSystemId;
	}

	public ClearAlarms clearUserId(String clearUserId) {
		this.clearUserId = clearUserId;
		return this;
	}

	/**
	 * Name of the clearing user
	 * 
	 * @return clearUserId
	 **/
	@Schema(description = "Name of the clearing user")

	public String getClearUserId() {
		return clearUserId;
	}

	public void setClearUserId(String clearUserId) {
		this.clearUserId = clearUserId;
	}

	public ClearAlarms state(String state) {
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

	public ClearAlarms alarmPattern(Set<Alarm> alarmPattern) {
		this.alarmPattern = alarmPattern;
		return this;
	}

	public ClearAlarms addAlarmPatternItem(Alarm alarmPatternItem) {
		if (this.alarmPattern == null) {
			this.alarmPattern =  new HashSet<>();
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

	public ClearAlarms clearedAlarm(Set<AlarmRefOrValue> clearedAlarm) {
		this.clearedAlarm = clearedAlarm;
		return this;
	}

	public ClearAlarms addClearedAlarmItem(AlarmRefOrValue clearedAlarmItem) {
		if (this.clearedAlarm == null) {
			this.clearedAlarm =  new HashSet<>();
		}
		this.clearedAlarm.add(clearedAlarmItem);
		return this;
	}

	/**
	 * The successfully cleared alarms
	 * 
	 * @return clearedAlarm
	 **/
	@Schema(description = "The successfully cleared alarms")
	@Valid
	public Set<AlarmRefOrValue> getClearedAlarm() {
		return clearedAlarm;
	}

	public void setClearedAlarm(Set<AlarmRefOrValue> clearedAlarm) {
		this.clearedAlarm = clearedAlarm;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClearAlarms clearAlarms = (ClearAlarms) o;
		return Objects.equals(this.id, clearAlarms.id) && Objects.equals(this.href, clearAlarms.href)
				&& Objects.equals(this.alarmClearedTime, clearAlarms.alarmClearedTime)
				&& Objects.equals(this.clearSystemId, clearAlarms.clearSystemId)
				&& Objects.equals(this.clearUserId, clearAlarms.clearUserId)
				&& Objects.equals(this.state, clearAlarms.state)
				&& Objects.equals(this.alarmPattern, clearAlarms.alarmPattern)
				&& Objects.equals(this.clearedAlarm, clearAlarms.clearedAlarm)
				&& Objects.equals(this.baseType, clearAlarms.baseType)
				&& Objects.equals(this.schemaLocation, clearAlarms.schemaLocation)
				&& Objects.equals(this.type, clearAlarms.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, alarmClearedTime, clearSystemId, clearUserId, state, alarmPattern, clearedAlarm,
				baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ClearAlarms {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
