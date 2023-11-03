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
 * Task resource for ungroup alarms operation
 */
@Schema(description = "Task resource for ungroup alarms operation")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMUnGroupAlarms")
@Table(name = "AMUnGroupAlarms")
public class UnGroupAlarms extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("alarmChangedTime")
	private OffsetDateTime alarmChangedTime = null;

	@JsonProperty("sourceSystemId")
	private String sourceSystemId = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("correlatedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> correlatedAlarm = null;

	@JsonProperty("parentAlarm")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private AlarmRefOrValue parentAlarm = null;

	@JsonProperty("unGroupedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> unGroupedAlarm = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public UnGroupAlarms href(String href) {
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

	public UnGroupAlarms alarmChangedTime(OffsetDateTime alarmChangedTime) {
		this.alarmChangedTime = alarmChangedTime;
		return this;
	}

	/**
	 * Time of the uncorrelation
	 * 
	 * @return alarmChangedTime
	 **/
	@Schema(description = "Time of the uncorrelation")

	@Valid
	public OffsetDateTime getAlarmChangedTime() {
		return alarmChangedTime;
	}

	public void setAlarmChangedTime(OffsetDateTime alarmChangedTime) {
		this.alarmChangedTime = alarmChangedTime;
	}

	public UnGroupAlarms sourceSystemId(String sourceSystemId) {
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

	public UnGroupAlarms state(String state) {
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

	public UnGroupAlarms correlatedAlarm(Set<AlarmRefOrValue> correlatedAlarm) {
		this.correlatedAlarm = correlatedAlarm;
		return this;
	}

	public UnGroupAlarms addCorrelatedAlarmItem(AlarmRefOrValue correlatedAlarmItem) {
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

	public UnGroupAlarms parentAlarm(AlarmRefOrValue parentAlarm) {
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

	public UnGroupAlarms unGroupedAlarm(Set<AlarmRefOrValue> unGroupedAlarm) {
		this.unGroupedAlarm = unGroupedAlarm;
		return this;
	}

	public UnGroupAlarms addUnGroupedAlarmItem(AlarmRefOrValue unGroupedAlarmItem) {
		if (this.unGroupedAlarm == null) {
			this.unGroupedAlarm = new HashSet<>();
		}
		this.unGroupedAlarm.add(unGroupedAlarmItem);
		return this;
	}

	/**
	 * The successfully uncorrelated alarms
	 * 
	 * @return unGroupedAlarm
	 **/
	@Schema(description = "The successfully uncorrelated alarms")
	@Valid
	public Set<AlarmRefOrValue> getUnGroupedAlarm() {
		return unGroupedAlarm;
	}

	public void setUnGroupedAlarm(Set<AlarmRefOrValue> unGroupedAlarm) {
		this.unGroupedAlarm = unGroupedAlarm;
	}

	public UnGroupAlarms baseType(String baseType) {
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

	public UnGroupAlarms schemaLocation(String schemaLocation) {
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

	public UnGroupAlarms type(String type) {
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
		UnGroupAlarms unGroupAlarms = (UnGroupAlarms) o;
		return Objects.equals(this.id, unGroupAlarms.id) && Objects.equals(this.href, unGroupAlarms.href)
				&& Objects.equals(this.alarmChangedTime, unGroupAlarms.alarmChangedTime)
				&& Objects.equals(this.sourceSystemId, unGroupAlarms.sourceSystemId)
				&& Objects.equals(this.state, unGroupAlarms.state)
				&& Objects.equals(this.correlatedAlarm, unGroupAlarms.correlatedAlarm)
				&& Objects.equals(this.parentAlarm, unGroupAlarms.parentAlarm)
				&& Objects.equals(this.unGroupedAlarm, unGroupAlarms.unGroupedAlarm)
				&& Objects.equals(this.baseType, unGroupAlarms.baseType)
				&& Objects.equals(this.schemaLocation, unGroupAlarms.schemaLocation)
				&& Objects.equals(this.type, unGroupAlarms.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, alarmChangedTime, sourceSystemId, state, correlatedAlarm, parentAlarm,
				unGroupedAlarm, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UnGroupAlarms {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
