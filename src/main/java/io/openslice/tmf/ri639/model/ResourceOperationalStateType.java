package io.openslice.tmf.ri639.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ResourceOperationalStateType enumerations
 */
public enum ResourceOperationalStateType {
  ENABLE("enable"),
    DISABLE("disable");

  private String value;

  ResourceOperationalStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ResourceOperationalStateType fromValue(String text) {
    for (ResourceOperationalStateType b : ResourceOperationalStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
