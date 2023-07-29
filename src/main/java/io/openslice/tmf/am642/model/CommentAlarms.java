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
 * Task resource for comment alarms operation
 */
@Schema(description = "Task resource for comment alarms operation")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMCommentAlarms")
@Table(name = "AMCommentAlarms")
public class CommentAlarms extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("alarmPattern")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Alarm> alarmPattern = new HashSet<>();

	@JsonProperty("comment")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Comment comment = null;

	@JsonProperty("commentedAlarm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AlarmRefOrValue> commentedAlarm = new HashSet<>();

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public CommentAlarms state(String state) {
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

	public CommentAlarms alarmPattern(Set<Alarm> alarmPattern) {
		this.alarmPattern = alarmPattern;
		return this;
	}

	public CommentAlarms addAlarmPatternItem(Alarm alarmPatternItem) {
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

	public CommentAlarms comment(Comment comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Get comment
	 * 
	 * @return comment
	 **/
	@Schema(description = "")

	@Valid
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public CommentAlarms commentedAlarm(Set<AlarmRefOrValue> commentedAlarm) {
		this.commentedAlarm = commentedAlarm;
		return this;
	}

	public CommentAlarms addCommentedAlarmItem(AlarmRefOrValue commentedAlarmItem) {
		if (this.commentedAlarm == null) {
			this.commentedAlarm = new HashSet<>();
		}
		this.commentedAlarm.add(commentedAlarmItem);
		return this;
	}

	/**
	 * The successfully commented alarms
	 * 
	 * @return commentedAlarm
	 **/
	@Schema(description = "The successfully commented alarms")
	@Valid
	public Set<AlarmRefOrValue> getCommentedAlarm() {
		return commentedAlarm;
	}

	public void setCommentedAlarm(Set<AlarmRefOrValue> commentedAlarm) {
		this.commentedAlarm = commentedAlarm;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CommentAlarms commentAlarms = (CommentAlarms) o;
		return Objects.equals(this.id, commentAlarms.id) && Objects.equals(this.href, commentAlarms.href)
				&& Objects.equals(this.state, commentAlarms.state)
				&& Objects.equals(this.alarmPattern, commentAlarms.alarmPattern)
				&& Objects.equals(this.comment, commentAlarms.comment)
				&& Objects.equals(this.commentedAlarm, commentAlarms.commentedAlarm)
				&& Objects.equals(this.baseType, commentAlarms.baseType)
				&& Objects.equals(this.schemaLocation, commentAlarms.schemaLocation)
				&& Objects.equals(this.type, commentAlarms.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, state, alarmPattern, comment, commentedAlarm, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CommentAlarms {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    alarmPattern: ").append(toIndentedString(alarmPattern)).append("\n");
		sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
		sb.append("    commentedAlarm: ").append(toIndentedString(commentedAlarm)).append("\n");
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
