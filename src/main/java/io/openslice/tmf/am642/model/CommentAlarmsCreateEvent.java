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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.CommentAlarmsCreateEventPayload;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The notification data structure
 */
@ApiModel(description = "The notification data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class CommentAlarmsCreateEvent   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

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

  @JsonProperty("event")
  private CommentAlarmsCreateEventPayload event = null;

  public CommentAlarmsCreateEvent id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the Process flow
   * @return id
  **/
  @ApiModelProperty(value = "Identifier of the Process flow")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CommentAlarmsCreateEvent href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the ProcessFlow
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the ProcessFlow")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CommentAlarmsCreateEvent eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The identifier of the notification.
   * @return eventId
  **/
  @ApiModelProperty(value = "The identifier of the notification.")
  
    public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public CommentAlarmsCreateEvent eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Time of the event occurrence.
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

  public CommentAlarmsCreateEvent eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The type of the notification.
   * @return eventType
  **/
  @ApiModelProperty(value = "The type of the notification.")
  
    public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public CommentAlarmsCreateEvent correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * The correlation id for this event.
   * @return correlationId
  **/
  @ApiModelProperty(value = "The correlation id for this event.")
  
    public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public CommentAlarmsCreateEvent domain(String domain) {
    this.domain = domain;
    return this;
  }

  /**
   * The domain of the event.
   * @return domain
  **/
  @ApiModelProperty(value = "The domain of the event.")
  
    public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public CommentAlarmsCreateEvent title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the event.
   * @return title
  **/
  @ApiModelProperty(value = "The title of the event.")
  
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CommentAlarmsCreateEvent description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explnatory of the event.
   * @return description
  **/
  @ApiModelProperty(value = "An explnatory of the event.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CommentAlarmsCreateEvent priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * A priority.
   * @return priority
  **/
  @ApiModelProperty(value = "A priority.")
  
    public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public CommentAlarmsCreateEvent timeOcurred(OffsetDateTime timeOcurred) {
    this.timeOcurred = timeOcurred;
    return this;
  }

  /**
   * The time the event occured.
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

  public CommentAlarmsCreateEvent event(CommentAlarmsCreateEventPayload event) {
    this.event = event;
    return this;
  }

  /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CommentAlarmsCreateEventPayload getEvent() {
    return event;
  }

  public void setEvent(CommentAlarmsCreateEventPayload event) {
    this.event = event;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentAlarmsCreateEvent commentAlarmsCreateEvent = (CommentAlarmsCreateEvent) o;
    return Objects.equals(this.id, commentAlarmsCreateEvent.id) &&
        Objects.equals(this.href, commentAlarmsCreateEvent.href) &&
        Objects.equals(this.eventId, commentAlarmsCreateEvent.eventId) &&
        Objects.equals(this.eventTime, commentAlarmsCreateEvent.eventTime) &&
        Objects.equals(this.eventType, commentAlarmsCreateEvent.eventType) &&
        Objects.equals(this.correlationId, commentAlarmsCreateEvent.correlationId) &&
        Objects.equals(this.domain, commentAlarmsCreateEvent.domain) &&
        Objects.equals(this.title, commentAlarmsCreateEvent.title) &&
        Objects.equals(this.description, commentAlarmsCreateEvent.description) &&
        Objects.equals(this.priority, commentAlarmsCreateEvent.priority) &&
        Objects.equals(this.timeOcurred, commentAlarmsCreateEvent.timeOcurred) &&
        Objects.equals(this.event, commentAlarmsCreateEvent.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, eventId, eventTime, eventType, correlationId, domain, title, description, priority, timeOcurred, event);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentAlarmsCreateEvent {\n");
    
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
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
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
