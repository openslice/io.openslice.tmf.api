package io.openslice.tmf.pm632.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Valid values for the lifecycle state of the individual
 */
public enum IndividualStateType {
  
  INITIALIZED("initialized"),
  
  VALIDATED("validated"),
  
  DECEADED("deceaded");

  private String value;

  IndividualStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static IndividualStateType fromValue(String text) {
    for (IndividualStateType b : IndividualStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
