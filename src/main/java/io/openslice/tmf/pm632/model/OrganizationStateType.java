package io.openslice.tmf.pm632.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

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

