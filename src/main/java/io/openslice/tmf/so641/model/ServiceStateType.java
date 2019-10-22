package io.openslice.tmf.so641.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Valid values for the lifecycle state of the service
 */
public enum ServiceStateType {
  
  FEASIBILITYCHECKED("feasibilityChecked"),
  
  DESIGNED("designed"),
  
  RESERVED("reserved"),
  
  INACTIVE("inactive"),
  
  ACTIVE("active"),
  
  TERMINATED("terminated");

  private String value;

  ServiceStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ServiceStateType fromValue(String text) {
    for (ServiceStateType b : ServiceStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

