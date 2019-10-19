package io.openslice.tmf.pm632.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Valid values for the lifecycle state of the organization
 */
public enum OrganizationStateType {
  
  INITIALIZED("initialized"),
  
  VALIDATED("validated"),
  
  CLOSED("closed");

  private String value;

  OrganizationStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OrganizationStateType fromValue(String text) {
    for (OrganizationStateType b : OrganizationStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

