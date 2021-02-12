package io.openslice.tmf.po622.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Possible values for the status of the product
 */
public enum ProductStatusType {
  CREATED("created"),
    PENDINGACTIVE("pendingActive"),
    CANCELLED("cancelled"),
    ACTIVE("active"),
    PENDINGTERMINATE("pendingTerminate"),
    TERMINATED("terminated"),
    SUSPENDED("suspended"),
    ABORTED_("aborted ");

  private String value;

  ProductStatusType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ProductStatusType fromValue(String text) {
    for (ProductStatusType b : ProductStatusType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
