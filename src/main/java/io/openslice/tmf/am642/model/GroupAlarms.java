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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Task resource for group alarms operation
 */
@Schema(description = "Task resource for group alarms operation")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMGroupAlarms")
@Table(name = "AMGroupAlarms")
public class GroupAlarms  extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;


	private OffsetDateTime alarmChangedTime = null;

	@JsonProperty("sourceSystemId")
	private String sourceSystemId = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("correlatedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> correlatedAlarm  =  new HashSet<>();

	@JsonProperty("groupedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> groupedAlarm =   new HashSet<>();

	@JsonProperty("parentAlarm")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private AlarmRefOrValue parentAlarm = null;


	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}
	
	

	public GroupAlarms alarmChangedTime(OffsetDateTime alarmChangedTime) {
		this.alarmChangedTime = alarmChangedTime;
		return this;
	}

	/**
	 * Time of the correlation
	 * 
	 * @return alarmChangedTime
	 **/
	@Schema(description = "Time of the correlation")

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

	public GroupAlarms sourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
		return this;
	}

	/**
	 * Source system identifier
	 * 
	 * @return sourceSystemId
	 **/
	@Schema(description = "Source system identifier")

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public GroupAlarms state(String state) {
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

	public GroupAlarms correlatedAlarm(Set<AlarmRefOrValue> correlatedAlarm) {
		this.correlatedAlarm = correlatedAlarm;
		return this;
	}

	public GroupAlarms addCorrelatedAlarmItem(AlarmRefOrValue correlatedAlarmItem) {
		if (this.correlatedAlarm == null) {
			this.correlatedAlarm = new HashSet<>();
		}
		this.correlatedAlarm.add(correlatedAlarmItem);
		return this;
	}

	/**
	 * Correlated alarms
	 * 
	 * @return correlatedAlarm
	 **/
	@Schema(description = "Correlated alarms")
	@Valid
	public Set<AlarmRefOrValue> getCorrelatedAlarm() {
		return correlatedAlarm;
	}

	public void setCorrelatedAlarm(Set<AlarmRefOrValue> correlatedAlarm) {
		this.correlatedAlarm = correlatedAlarm;
	}

	public GroupAlarms groupedAlarm(Set<AlarmRefOrValue> groupedAlarm) {
		this.groupedAlarm = groupedAlarm;
		return this;
	}

	public GroupAlarms addGroupedAlarmItem(AlarmRefOrValue groupedAlarmItem) {
		if (this.groupedAlarm == null) {
			this.groupedAlarm = new HashSet<>();
		}
		this.groupedAlarm.add(groupedAlarmItem);
		return this;
	}

	/**
	 * The successfully correlated alarms
	 * 
	 * @return groupedAlarm
	 **/
	@Schema(description = "The successfully correlated alarms")
	@Valid
	public Set<AlarmRefOrValue> getGroupedAlarm() {
		return groupedAlarm;
	}

	public void setGroupedAlarm(Set<AlarmRefOrValue> groupedAlarm) {
		this.groupedAlarm = groupedAlarm;
	}

	public GroupAlarms parentAlarm(AlarmRefOrValue parentAlarm) {
		this.parentAlarm = parentAlarm;
		return this;
	}

	/**
	 * Get parentAlarm
	 * 
	 * @return parentAlarm
	 **/
	@Schema(description = "")

	@Valid
	public AlarmRefOrValue getParentAlarm() {
		return parentAlarm;
	}

	public void setParentAlarm(AlarmRefOrValue parentAlarm) {
		this.parentAlarm = parentAlarm;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GroupAlarms groupAlarms = (GroupAlarms) o;
		return Objects.equals(this.id, groupAlarms.id) && Objects.equals(this.href, groupAlarms.href)
				&& Objects.equals(this.alarmChangedTime, groupAlarms.alarmChangedTime)
				&& Objects.equals(this.sourceSystemId, groupAlarms.sourceSystemId)
				&& Objects.equals(this.state, groupAlarms.state)
				&& Objects.equals(this.correlatedAlarm, groupAlarms.correlatedAlarm)
				&& Objects.equals(this.groupedAlarm, groupAlarms.groupedAlarm)
				&& Objects.equals(this.parentAlarm, groupAlarms.parentAlarm)
				&& Objects.equals(this.baseType, groupAlarms.baseType)
				&& Objects.equals(this.schemaLocation, groupAlarms.schemaLocation)
				&& Objects.equals(this.type, groupAlarms.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, alarmChangedTime, sourceSystemId, state, correlatedAlarm, groupedAlarm,
				parentAlarm, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GroupAlarms {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    alarmChangedTime: ").append(toIndentedString(alarmChangedTime)).append("\n");
		sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    correlatedAlarm: ").append(toIndentedString(correlatedAlarm)).append("\n");
		sb.append("    groupedAlarm: ").append(toIndentedString(groupedAlarm)).append("\n");
		sb.append("    parentAlarm: ").append(toIndentedString(parentAlarm)).append("\n");
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
