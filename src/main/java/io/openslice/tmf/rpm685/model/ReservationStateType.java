package io.openslice.tmf.rpm685.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ResourceStatusType enumerations
 */
public enum ReservationStateType {
  	INPROGRESS("inprogress"),
    COMPLETED("completed"),
    REJECTED("rejected"),
    CANCELLED("cancelled");

  private String value;

  ReservationStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ReservationStateType fromValue(String text) {
    for (ReservationStateType b : ReservationStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
