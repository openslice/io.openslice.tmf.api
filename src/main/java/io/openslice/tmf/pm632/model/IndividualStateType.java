package io.openslice.tmf.pm632.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

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

