package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A period of time, either as a deadline (endDateTime only) a startDateTime
 * only, or both
 */
@ApiModel(description = "A period of time, either as a deadline (endDateTime only) a startDateTime only, or both")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Embeddable
public class TimePeriod {
	@JsonProperty("endDateTime")
	private OffsetDateTime endDateTime = null;

	@JsonProperty("startDateTime")
	private OffsetDateTime startDateTime = null;

	public TimePeriod endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
	}

	/**
	 * End of the time period, using IETC-RFC-3339 format
	 * 
	 * @return endDateTime
	 **/
	@ApiModelProperty(value = "End of the time period, using IETC-RFC-3339 format")

	@Valid

	public OffsetDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public TimePeriod startDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
		return this;
	}

	/**
	 * Start of the time period, using IETC-RFC-3339 format. If you define a start,
	 * you must also define an end
	 * 
	 * @return startDateTime
	 **/
	@ApiModelProperty(value = "Start of the time period, using IETC-RFC-3339 format. If you define a start, you must also define an end")

	@Valid

	public OffsetDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TimePeriod timePeriod = (TimePeriod) o;
		return Objects.equals(this.endDateTime, timePeriod.endDateTime)
				&& Objects.equals(this.startDateTime, timePeriod.startDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDateTime, startDateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TimePeriod {\n");

		sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
		sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public void copyFromObj(TimePeriod validFor) {
		if (validFor != null) {
			this.startDateTime = validFor.startDateTime;
			this.endDateTime = validFor.endDateTime;
		}

	}
}
