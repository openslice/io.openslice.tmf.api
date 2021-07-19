package io.openslice.tmf.ri639.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The notification data structure
 */
@ApiModel(description = "The notification data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
public class ResourceCreateEvent {
	@JsonProperty("event")
	private ResourceCreateEventPayload event = null;

	@JsonProperty("eventId")
	private String eventId = null;

	@JsonProperty("eventTime")
	private OffsetDateTime eventTime = null;

	@JsonProperty("eventType")
	private String eventType = null;

	@JsonProperty("correlationId")
	private String correlationId = null;

	@JsonProperty("domain")
	private String domain = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("priority")
	private String priority = null;

	@JsonProperty("timeOcurred")
	private OffsetDateTime timeOcurred = null;

	public ResourceCreateEvent event(ResourceCreateEventPayload event) {
		this.event = event;
		return this;
	}

	/**
	 * Get event
	 * 
	 * @return event
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ResourceCreateEventPayload getEvent() {
		if ( event == null ) {
			this.event = new ResourceCreateEventPayload();
		}
		return event;
	}

	public void setEvent(ResourceCreateEventPayload event) {
		this.event = event;
	}

	public ResourceCreateEvent eventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	/**
	 * The identifier of the notification.
	 * 
	 * @return eventId
	 **/
	@ApiModelProperty(value = "The identifier of the notification.")

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public ResourceCreateEvent eventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
		return this;
	}

	/**
	 * Time of the event occurrence.
	 * 
	 * @return eventTime
	 **/
	@ApiModelProperty(value = "Time of the event occurrence.")

	@Valid
	public OffsetDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(OffsetDateTime eventTime) {
		this.eventTime = eventTime;
	}

	public ResourceCreateEvent eventType(String eventType) {
		this.eventType = eventType;
		return this;
	}

	/**
	 * The type of the notification.
	 * 
	 * @return eventType
	 **/
	@ApiModelProperty(value = "The type of the notification.")

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public ResourceCreateEvent correlationId(String correlationId) {
		this.correlationId = correlationId;
		return this;
	}

	/**
	 * The correlation id for this event.
	 * 
	 * @return correlationId
	 **/
	@ApiModelProperty(value = "The correlation id for this event.")

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public ResourceCreateEvent domain(String domain) {
		this.domain = domain;
		return this;
	}

	/**
	 * The domain of the event.
	 * 
	 * @return domain
	 **/
	@ApiModelProperty(value = "The domain of the event.")

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public ResourceCreateEvent title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * The title of the event.
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "The title of the event.")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ResourceCreateEvent description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * An explnatory of the event.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "An explnatory of the event.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceCreateEvent priority(String priority) {
		this.priority = priority;
		return this;
	}

	/**
	 * A priority.
	 * 
	 * @return priority
	 **/
	@ApiModelProperty(value = "A priority.")

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public ResourceCreateEvent timeOcurred(OffsetDateTime timeOcurred) {
		this.timeOcurred = timeOcurred;
		return this;
	}

	/**
	 * The time the event occured.
	 * 
	 * @return timeOcurred
	 **/
	@ApiModelProperty(value = "The time the event occured.")

	@Valid
	public OffsetDateTime getTimeOcurred() {
		return timeOcurred;
	}

	public void setTimeOcurred(OffsetDateTime timeOcurred) {
		this.timeOcurred = timeOcurred;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceCreateEvent resourceCreateEvent = (ResourceCreateEvent) o;
		return Objects.equals(this.event, resourceCreateEvent.event)
				&& Objects.equals(this.eventId, resourceCreateEvent.eventId)
				&& Objects.equals(this.eventTime, resourceCreateEvent.eventTime)
				&& Objects.equals(this.eventType, resourceCreateEvent.eventType)
				&& Objects.equals(this.correlationId, resourceCreateEvent.correlationId)
				&& Objects.equals(this.domain, resourceCreateEvent.domain)
				&& Objects.equals(this.title, resourceCreateEvent.title)
				&& Objects.equals(this.description, resourceCreateEvent.description)
				&& Objects.equals(this.priority, resourceCreateEvent.priority)
				&& Objects.equals(this.timeOcurred, resourceCreateEvent.timeOcurred);
	}

	@Override
	public int hashCode() {
		return Objects.hash(event, eventId, eventTime, eventType, correlationId, domain, title, description, priority,
				timeOcurred);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceCreateEvent {\n");

		sb.append("    event: ").append(toIndentedString(event)).append("\n");
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
