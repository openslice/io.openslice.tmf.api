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

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Indicates the comments entered on the alarm.
 */
@Schema(description = "Indicates the comments entered on the alarm.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMcomment")
@Table(name = "AMcomment")
public class Comment extends BaseRootEntity {
	@JsonProperty("comment")
	@Lob
	@Column(name = "LCOMMENT", columnDefinition = "LONGTEXT")
	private String comment = null;

	@JsonProperty("systemId")
	private String systemId = null;

	private OffsetDateTime time = null;

	@JsonProperty("userId")
	private String userId = null;

	public Comment comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Indicates the text of the comment.
	 * 
	 * @return comment
	 **/
	@Schema(description = "Indicates the text of the comment.")

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Comment systemId(String systemId) {
		this.systemId = systemId;
		return this;
	}

	/**
	 * Indicates the system identifier on which the client set the comment.
	 * 
	 * @return systemId
	 **/
	@Schema(description = "Indicates the system identifier on which the client set the comment.")

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public Comment time(OffsetDateTime time) {
		this.time = time;
		return this;
	}

	/**
	 * Indicates the time commenting the alarm
	 * 
	 * @return time
	 **/
	@Schema(description = "Indicates the time commenting the alarm")

	@Valid
	public OffsetDateTime getTime() {
		return time;
	}

	public void setTime(OffsetDateTime time) {
		this.time = time;
	}

	@JsonProperty("time")
	public String getTimeStr() {
		if (this.time != null) {
			return this.time.toString();
		} else {
			return null;
		}
	}
	

	public void setTime(String time) {
		if ( time != null) {
			this.time = OffsetDateTime.parse( time );
			
		}
	}

	public Comment userId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * Indicates the user commenting the alarm.
	 * 
	 * @return userId
	 **/
	@Schema(description = "Indicates the user commenting the alarm.")

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Comment comment = (Comment) o;
		return Objects.equals(this.comment, comment.comment) && Objects.equals(this.systemId, comment.systemId)
				&& Objects.equals(this.time, comment.time) && Objects.equals(this.userId, comment.userId)
				&& Objects.equals(this.baseType, comment.baseType)
				&& Objects.equals(this.schemaLocation, comment.schemaLocation)
				&& Objects.equals(this.type, comment.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(comment, systemId, time, userId, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Comment {\n");

		sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
		sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
		sb.append("    time: ").append(toIndentedString(time)).append("\n");
		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
