package io.openslice.tmf.ri639.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ResourceStatusType enumerations
 */
public enum ResourceStatusType {
  STANDBY("standby"),
    ALARM("alarm"),
    AVAILABLE("available"),
    RESERVED("reserved"),
    UNKNOWN("unknown"),
    SUSPENDED("suspended");

  private String value;

  ResourceStatusType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ResourceStatusType fromValue(String text) {
    for (ResourceStatusType b : ResourceStatusType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
