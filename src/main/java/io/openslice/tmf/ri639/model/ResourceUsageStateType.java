package io.openslice.tmf.ri639.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * ResourceUsageStateType enumerations
 */
public enum ResourceUsageStateType {
  IDLE("idle"),
    ACTIVE("active"),
    BUSY("busy");

  private String value;

  ResourceUsageStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ResourceUsageStateType fromValue(String text) {
    for (ResourceUsageStateType b : ResourceUsageStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
