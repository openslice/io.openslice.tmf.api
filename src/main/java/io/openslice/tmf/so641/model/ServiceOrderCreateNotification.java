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
package io.openslice.tmf.so641.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.Notification;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The notification data structure
 */
@Schema(description = "The notification data structure")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class ServiceOrderCreateNotification extends Notification  {
  
  @JsonProperty("event")
  private ServiceOrderCreateEvent event = null;

  public ServiceOrderCreateNotification eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }



  public ServiceOrderCreateNotification event(ServiceOrderCreateEvent event) {
    this.event = event;
    return this;
  }

  /**
   * The event linked to the involved resource object
   * @return event
  **/
  @Schema(description = "The event linked to the involved resource object")

  @Valid

  public ServiceOrderCreateEvent getEvent() {
    return event;
  }

  public void setEvent(ServiceOrderCreateEvent event) {
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
    ServiceOrderCreateNotification serviceOrderCreateNotification = (ServiceOrderCreateNotification) o;
    return Objects.equals(this.eventId, serviceOrderCreateNotification.eventId) &&
        Objects.equals(this.eventTime, serviceOrderCreateNotification.eventTime) &&
        Objects.equals(this.eventType, serviceOrderCreateNotification.eventType) &&
        Objects.equals(this.fieldPath, serviceOrderCreateNotification.fieldPath) &&
        Objects.equals(this.resourcePath, serviceOrderCreateNotification.resourcePath) &&
        Objects.equals(this.event, serviceOrderCreateNotification.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventId, eventTime, eventType, fieldPath, resourcePath, event);
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

