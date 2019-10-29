package io.openslice.tmf.so641.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Possible values for the state of the order
 */
public enum ServiceOrderStateType {
	
	INITIAL("initial"),

	ACKNOWLEDGED("acknowledged"),

	REJECTED("rejected"),

	PENDING("pending"),

	HELD("held"),

	INPROGRESS("inProgress"),

	CANCELLED("cancelled"),

	COMPLETED("completed"),

	FAILED("failed"),

	PARTIAL("partial");

	private String value;

	ServiceOrderStateType(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static ServiceOrderStateType fromValue(String text) {
		for (ServiceOrderStateType b : ServiceOrderStateType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
