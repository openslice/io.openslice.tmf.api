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
 * This data structure is created as a generic one. This is similar to
 * {@link Notification} class. Seems that TMF new versions have deprecated
 * Notifications and use Event and EventPayload
 * 
 * @author ctranoris
 *
 */
@Schema(description = "The notification data structure")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class OpensliceEvent {
	
	@JsonProperty("id")
	protected String id = UUID.randomUUID().toString();;

	@JsonProperty("href")
	protected String href = null;

	@JsonProperty("eventId")
	protected String eventId = UUID.randomUUID().toString();;

	protected OffsetDateTime eventTime = OffsetDateTime.now(ZoneOffset.UTC);

	@JsonProperty("eventType")
	protected String eventType = null;

	@JsonProperty("correlationId")
	protected String correlationId = null;

	@JsonProperty("domain")
	protected String domain = null;

	@JsonProperty("title")
	protected String title = null;

	@JsonProperty("description")
	protected String description = null;

	@JsonProperty("priority")
	protected String priority = null;

	protected OffsetDateTime timeOcurred = null;

	public OpensliceEvent id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of the Process flow
	 * 
	 * @return id
	 **/
	@Schema(description = "Identifier of the Process flow")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OpensliceEvent href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the ProcessFlow
	 * 
	 * @return href
	 **/
	@Schema(description = "Reference of the ProcessFlow")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public OpensliceEvent eventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	/**
	 * The identifier of the notification.
	 * 
	 * @return eventId
	 **/
	@Schema(description = "The identifier of the notification.")

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public OpensliceEvent eventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
		return this;
	}

	/**
	 * Time of the event occurrence.
	 * 
	 * @return eventTime
	 **/
	@Schema(description = "Time of the event occurrence.")

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
		if ( eventTime != null) {
			this.eventTime = OffsetDateTime.parse( eventTime );
			
		}
	}

	public OpensliceEvent eventType(String eventType) {
		this.eventType = eventType;
		return this;
	}

	/**
	 * The type of the notification.
	 * 
	 * @return eventType
	 **/
	@Schema(description = "The type of the notification.")

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public OpensliceEvent correlationId(String correlationId) {
		this.correlationId = correlationId;
		return this;
	}

	/**
	 * The correlation id for this event.
	 * 
	 * @return correlationId
	 **/
	@Schema(description = "The correlation id for this event.")

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public OpensliceEvent domain(String domain) {
		this.domain = domain;
		return this;
	}

	/**
	 * The domain of the event.
	 * 
	 * @return domain
	 **/
	@Schema(description = "The domain of the event.")

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public OpensliceEvent title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * The title of the event.
	 * 
	 * @return title
	 **/
	@Schema(description = "The title of the event.")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public OpensliceEvent description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * An explnatory of the event.
	 * 
	 * @return description
	 **/
	@Schema(description = "An explnatory of the event.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OpensliceEvent priority(String priority) {
		this.priority = priority;
		return this;
	}

	/**
	 * A priority.
	 * 
	 * @return priority
	 **/
	@Schema(description = "A priority.")

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public OpensliceEvent timeOcurred(OffsetDateTime timeOcurred) {
		this.timeOcurred = timeOcurred;
		return this;
	}

	/**
	 * The time the event occured.
	 * 
	 * @return timeOcurred
	 **/
	@Schema(description = "The time the event occured.")

	@Valid
	

	@JsonProperty("timeOcurred")
	public String getTimeOcurredString() {
		return timeOcurred.toString();
	}
	
	public OffsetDateTime getTimeOcurred() {
		return timeOcurred;
	}

	public void setTimeOcurred(OffsetDateTime timeOcurred) {
		this.timeOcurred = timeOcurred;
	}
	
	
	public void setTimeOcurred(String timeOcurred) {
		if ( timeOcurred != null) {
			this.timeOcurred = OffsetDateTime.parse( timeOcurred );
			
		}
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OpensliceEvent alarmCreateEvent = (OpensliceEvent) o;
		return Objects.equals(this.id, alarmCreateEvent.id) && Objects.equals(this.href, alarmCreateEvent.href)
				&& Objects.equals(this.eventId, alarmCreateEvent.eventId)
				&& Objects.equals(this.eventTime, alarmCreateEvent.eventTime)
				&& Objects.equals(this.eventType, alarmCreateEvent.eventType)
				&& Objects.equals(this.correlationId, alarmCreateEvent.correlationId)
				&& Objects.equals(this.domain, alarmCreateEvent.domain)
				&& Objects.equals(this.title, alarmCreateEvent.title)
				&& Objects.equals(this.description, alarmCreateEvent.description)
				&& Objects.equals(this.priority, alarmCreateEvent.priority)
				&& Objects.equals(this.timeOcurred, alarmCreateEvent.timeOcurred);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, eventId, eventTime, eventType, correlationId, domain, title, description,
//				priority, timeOcurred, event);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlarmCreateEvent {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
		sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
		sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
		sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
		sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
		sb.append("    timeOcurred: ").append(toIndentedString(timeOcurred)).append("\n");
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
