package io.openslice.tmf.ri639.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * ResourceAdministrativeStateType enumerations
 */
public enum ResourceAdministrativeStateType {
  LOCKED("locked"),
    UNLOCKED("unlocked"),
    SHUTDOWN("shutdown");

  private String value;

  ResourceAdministrativeStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ResourceAdministrativeStateType fromValue(String text) {
    for (ResourceAdministrativeStateType b : ResourceAdministrativeStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
