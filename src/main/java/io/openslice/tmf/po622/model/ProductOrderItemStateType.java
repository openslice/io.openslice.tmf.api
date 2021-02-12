package io.openslice.tmf.po622.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Possible values for the state of the product order item
 */
public enum ProductOrderItemStateType {
  ACKNOWLEDGED("acknowledged"),
    REJECTED("rejected"),
    PENDING("pending"),
    HELD("held"),
    INPROGRESS("inProgress"),
    CANCELLED("cancelled"),
    COMPLETED("completed"),
    FAILED("failed"),
    ASSESSINGCANCELLATION("assessingCancellation"),
    PENDINGCANCELLATION("pendingCancellation");

  private String value;

  ProductOrderItemStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ProductOrderItemStateType fromValue(String text) {
    for (ProductOrderItemStateType b : ProductOrderItemStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
