package io.openslice.tmf.ro652.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Possible values for the state of a task
 */
public enum TaskStateType {
  ACKNOWLEDGED("acknowledged"),
    TERMINATEDWITHERROR("terminatedWithError"),
    INPROGRESS("inProgress"),
    DONE("done");

  private String value;

  TaskStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TaskStateType fromValue(String text) {
    for (TaskStateType b : TaskStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
