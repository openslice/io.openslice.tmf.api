package io.openslice.tmf.scm620.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

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

