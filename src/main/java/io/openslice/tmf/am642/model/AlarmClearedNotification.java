package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.Alarm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Notification after alarm is cleared
 */
@ApiModel(description = "Notification after alarm is cleared")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T12:06:56.372977300+02:00[Europe/Athens]")
public class AlarmClearedNotification   {
  @JsonProperty("eventType")
  private String eventType = null;

  @JsonProperty("eventTime")
  private OffsetDateTime eventTime = null;

  @JsonProperty("eventId")
  private Long eventId = null;

  @JsonProperty("event")
  private Alarm event = null;

  public AlarmClearedNotification eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   * @return eventType
  **/
  @ApiModelProperty(value = "")
  
    public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public AlarmClearedNotification eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Get eventTime
   * @return eventTime
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public AlarmClearedNotification eventId(Long eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * Get eventId
   * @return eventId
  **/
  @ApiModelProperty(value = "")
  
    public Long getEventId() {
    return eventId;
  }

  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  public AlarmClearedNotification event(Alarm event) {
    this.event = event;
    return this;
  }

  /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Alarm getEvent() {
    return event;
  }

  public void setEvent(Alarm event) {
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
    AlarmClearedNotification alarmClearedNotification = (AlarmClearedNotification) o;
    return Objects.equals(this.eventType, alarmClearedNotification.eventType) &&
        Objects.equals(this.eventTime, alarmClearedNotification.eventTime) &&
        Objects.equals(this.eventId, alarmClearedNotification.eventId) &&
        Objects.equals(this.event, alarmClearedNotification.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventType, eventTime, eventId, event);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlarmClearedNotification {\n");
    
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
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
