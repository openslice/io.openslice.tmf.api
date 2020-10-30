package io.openslice.tmf.po622.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * action to be performed on the product
 */
public enum OrderItemActionType {
  ADD("add"),
    MODIFY("modify"),
    DELETE("delete"),
    NOCHANGE("noChange");

  private String value;

  OrderItemActionType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OrderItemActionType fromValue(String text) {
    for (OrderItemActionType b : OrderItemActionType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
