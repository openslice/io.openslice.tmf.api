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
package io.openslice.tmf.scm633.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The notification data structure
 */
@Schema(description = "The notification data structure")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceSpecificationCreateNotification   {
  @JsonProperty("eventId")
  private String eventId = null;

  @JsonProperty("eventTime")
  private OffsetDateTime eventTime = null;

  @JsonProperty("eventType")
  private String eventType = null;

  @JsonProperty("fieldPath")
  private String fieldPath = null;

  @JsonProperty("resourcePath")
  private String resourcePath = null;

  @JsonProperty("event")
  private ServiceSpecificationCreateEvent event = null;

  public ServiceSpecificationCreateNotification eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The identifier of the notification
   * @return eventId
  **/
  @Schema(description = "The identifier of the notification")


  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public ServiceSpecificationCreateNotification eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Time of the event occurrence
   * @return eventTime
  **/
  @Schema(description = "Time of the event occurrence")

  @Valid

  public OffsetDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public ServiceSpecificationCreateNotification eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The type of the notification
   * @return eventType
  **/
  @Schema(description = "The type of the notification")


  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public ServiceSpecificationCreateNotification fieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
    return this;
  }

  /**
   * The path identifying the object field concerned by this notification
   * @return fieldPath
  **/
  @Schema(description = "The path identifying the object field concerned by this notification")


  public String getFieldPath() {
    return fieldPath;
  }

  public void setFieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
  }

  public ServiceSpecificationCreateNotification resourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
    return this;
  }

  /**
   * The path identifying the resource object concerned by this notification
   * @return resourcePath
  **/
  @Schema(description = "The path identifying the resource object concerned by this notification")


  public String getResourcePath() {
    return resourcePath;
  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }

  public ServiceSpecificationCreateNotification event(ServiceSpecificationCreateEvent event) {
    this.event = event;
    return this;
  }

  /**
   * The event linked to the involved resource object
   * @return event
  **/
  @Schema(description = "The event linked to the involved resource object")

  @Valid

  public ServiceSpecificationCreateEvent getEvent() {
    return event;
  }

  public void setEvent(ServiceSpecificationCreateEvent event) {
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
    ServiceSpecificationCreateNotification serviceSpecificationCreateNotification = (ServiceSpecificationCreateNotification) o;
    return Objects.equals(this.eventId, serviceSpecificationCreateNotification.eventId) &&
        Objects.equals(this.eventTime, serviceSpecificationCreateNotification.eventTime) &&
        Objects.equals(this.eventType, serviceSpecificationCreateNotification.eventType) &&
        Objects.equals(this.fieldPath, serviceSpecificationCreateNotification.fieldPath) &&
        Objects.equals(this.resourcePath, serviceSpecificationCreateNotification.resourcePath) &&
        Objects.equals(this.event, serviceSpecificationCreateNotification.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventId, eventTime, eventType, fieldPath, resourcePath, event);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationCreateNotification {\n");
    
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    fieldPath: ").append(toIndentedString(fieldPath)).append("\n");
    sb.append("    resourcePath: ").append(toIndentedString(resourcePath)).append("\n");
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

