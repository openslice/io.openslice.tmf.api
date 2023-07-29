/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.common.model;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The notification data structure
 * 
 * @author ctranoris
 *
 */
@Schema(description = "The notification data structure")
@Validated

public class Notification {
	@JsonProperty("eventId")
	protected String eventId = UUID.randomUUID().toString();

	protected OffsetDateTime eventTime =  OffsetDateTime.now(ZoneOffset.UTC);

	@JsonProperty("eventType")
	protected String eventType = null;

	@JsonProperty("fieldPath")
	protected String fieldPath = null;

	@JsonProperty("resourcePath")
	protected String resourcePath = null;

	
	
	public Notification() {
		super();
	}


	public Notification eventId() {
		return this;
	}
	
	
	public Notification eventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	/**
	 * The identifier of the notification
	 * 
	 * @return eventId
	 **/
	@Schema(description = "The identifier of the notification")

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Notification eventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
		return this;
	}

	/**
	 * Time of the event occurrence
	 * 
	 * @return eventTime
	 **/
	@Schema(description = "Time of the event occurrence")

	@Valid

	@JsonProperty("eventTime")
	public String getEventTimeString() {
		return eventTime.toString();
	}
	
	public OffsetDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
	}
	
	public void setEventTime(String eventTime) {
		if ( eventTime!= null ) {
			this.eventTime = OffsetDateTime.parse( eventTime );			
		}
	}

	public Notification eventType(String eventType) {
		this.eventType = eventType;
		return this;
	}

	/**
	 * The type of the notification
	 * 
	 * @return eventType
	 **/
	@Schema(description = "The type of the notification")

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Notification fieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
		return this;
	}

	/**
	 * The path identifying the object field concerned by this notification
	 * 
	 * @return fieldPath
	 **/
	@Schema(description = "The path identifying the object field concerned by this notification")

	public String getFieldPath() {
		return fieldPath;
	}

	public void setFieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
	}

	public Notification resourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
		return this;
	}

	/**
	 * The path identifying the resource object concerned by this notification
	 * 
	 * @return resourcePath
	 **/
	@Schema(description = "The path identifying the resource object concerned by this notification")

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Notification serviceOrderCreateNotification = (Notification) o;
		return Objects.equals(this.eventId, serviceOrderCreateNotification.eventId)
				&& Objects.equals(this.eventTime, serviceOrderCreateNotification.eventTime)
				&& Objects.equals(this.eventType, serviceOrderCreateNotification.eventType)
				&& Objects.equals(this.fieldPath, serviceOrderCreateNotification.fieldPath)
				&& Objects.equals(this.resourcePath, serviceOrderCreateNotification.resourcePath);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceOrderCreateNotification {\n");

		sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
		sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
		sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
		sb.append("    fieldPath: ").append(toIndentedString(fieldPath)).append("\n");
		sb.append("    resourcePath: ").append(toIndentedString(resourcePath)).append("\n");
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
