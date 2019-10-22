package io.openslice.tmf.pcm620.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Valid values for the state of a batch job (e.g. catalog import)
 */
public enum JobStateType {
  
  NOT_STARTED("Not Started"),
  
  RUNNING("Running"),
  
  SUCCEEDED("Succeeded"),
  
  FAILED("Failed");

  private String value;

  JobStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static JobStateType fromValue(String text) {
    for (JobStateType b : JobStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

