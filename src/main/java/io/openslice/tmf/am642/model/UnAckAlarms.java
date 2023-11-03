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
 * Task resource for unacknowledge alarms operation
 */
@Schema(description = "Task resource for unacknowledge alarms operation")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMUnAckAlarms")
@Table(name = "AMUnAckAlarms")
public class UnAckAlarms extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("ackSystemId")
	private String ackSystemId = null;

	private OffsetDateTime ackTime = null;

	@JsonProperty("ackUserId")
	private String ackUserId = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("alarmPattern")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Alarm> alarmPattern = new HashSet<>();

	@JsonProperty("unAckedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> unAckedAlarm = new HashSet<>();

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public UnAckAlarms href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * A reference to the task
	 * 
	 * @return href
	 **/
	@Schema(description = "A reference to the task")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public UnAckAlarms ackSystemId(String ackSystemId) {
		this.ackSystemId = ackSystemId;
		return this;
	}

	/**
	 * Name of the unacknowledging system
	 * 
	 * @return ackSystemId
	 **/
	@Schema(description = "Name of the unacknowledging system")

	public String getAckSystemId() {
		return ackSystemId;
	}

	public void setAckSystemId(String ackSystemId) {
		this.ackSystemId = ackSystemId;
	}

	public UnAckAlarms ackTime(OffsetDateTime ackTime) {
		this.ackTime = ackTime;
		return this;
	}

	/**
	 * Time of the unacknowledgement
	 * 
	 * @return ackTime
	 **/
	@Schema(description = "Time of the unacknowledgement")

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

	public UnAckAlarms ackUserId(String ackUserId) {
		this.ackUserId = ackUserId;
		return this;
	}

	/**
	 * Name of the unacknowledging user
	 * 
	 * @return ackUserId
	 **/
	@Schema(description = "Name of the unacknowledging user")

	public String getAckUserId() {
		return ackUserId;
	}

	public void setAckUserId(String ackUserId) {
		this.ackUserId = ackUserId;
	}

	public UnAckAlarms state(String state) {
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

	public UnAckAlarms alarmPattern(Set<Alarm> alarmPattern) {
		this.alarmPattern = alarmPattern;
		return this;
	}

	public UnAckAlarms addAlarmPatternItem(Alarm alarmPatternItem) {
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

	public UnAckAlarms unAckedAlarm(Set<AlarmRefOrValue> unAckedAlarm) {
		this.unAckedAlarm = unAckedAlarm;
		return this;
	}

	public UnAckAlarms addUnAckedAlarmItem(AlarmRefOrValue unAckedAlarmItem) {
		if (this.unAckedAlarm == null) {
			this.unAckedAlarm = new HashSet<>();
		}
		this.unAckedAlarm.add(unAckedAlarmItem);
		return this;
	}

	/**
	 * The successfully unacknowledged alarms
	 * 
	 * @return unAckedAlarm
	 **/
	@Schema(description = "The successfully unacknowledged alarms")
	@Valid
	public Set<AlarmRefOrValue> getUnAckedAlarm() {
		return unAckedAlarm;
	}

	public void setUnAckedAlarm(Set<AlarmRefOrValue> unAckedAlarm) {
		this.unAckedAlarm = unAckedAlarm;
	}

	public UnAckAlarms baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return baseType;
	}

	public void setAtBaseType(String baseType) {
		this.baseType = baseType;
	}

	public UnAckAlarms schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return schemaLocation;
	}

	public void setAtSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public UnAckAlarms type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
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
		UnAckAlarms unAckAlarms = (UnAckAlarms) o;
		return Objects.equals(this.id, unAckAlarms.id) && Objects.equals(this.href, unAckAlarms.href)
				&& Objects.equals(this.ackSystemId, unAckAlarms.ackSystemId)
				&& Objects.equals(this.ackTime, unAckAlarms.ackTime)
				&& Objects.equals(this.ackUserId, unAckAlarms.ackUserId)
				&& Objects.equals(this.state, unAckAlarms.state)
				&& Objects.equals(this.alarmPattern, unAckAlarms.alarmPattern)
				&& Objects.equals(this.unAckedAlarm, unAckAlarms.unAckedAlarm)
				&& Objects.equals(this.baseType, unAckAlarms.baseType)
				&& Objects.equals(this.schemaLocation, unAckAlarms.schemaLocation)
				&& Objects.equals(this.type, unAckAlarms.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, ackSystemId, ackTime, ackUserId, state, alarmPattern, unAckedAlarm, baseType,
				schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UnAckAlarms {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
