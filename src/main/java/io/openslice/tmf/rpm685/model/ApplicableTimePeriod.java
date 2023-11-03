package io.openslice.tmf.rpm685.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

/**
 * The period of time for which Capacity or CapacityDemand applies.
 */
@Schema(description = "The period of time for which Capacity or CapacityDemand applies.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Entity(name = "ApplcbleTPer")
public class ApplicableTimePeriod extends BaseRootEntity {

	@JsonProperty("dayOfWeek")
	private String dayOfWeek = null;

	private OffsetDateTime fromDateTime = null;

	private OffsetDateTime endDateTime = null;

	@JsonProperty("rangeInterval")
	private String rangeInterval = null;

	public ApplicableTimePeriod dayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
		return this;
	}

	/**
	 * A day or days representing when the schedule is applicable. For example 2, 3
	 * represent Monday and Tuesday.
	 * 
	 * @return dayOfWeek
	 **/
	@Schema(description = "A day or days representing when the schedule is applicable. For example 2, 3 represent Monday and Tuesday.")

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public ApplicableTimePeriod fromDateTime(OffsetDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
		return this;
	}

	@JsonProperty("fromDateTime")
	public String getfromDateTimeString() {

		if (this.fromDateTime == null) {
			return null;
		}
		return this.fromDateTime.toString();
	}

	/**
	 * The period of time for which the schedule is applicable. Instance values are
	 * mutually exclusive with daysOfWeek values.
	 * 
	 * @return fromToDateTime
	 **/
	@Schema(description = "The period of time for which the schedule is applicable.  Instance values are mutually exclusive with daysOfWeek values.")

	@Valid
	public OffsetDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(OffsetDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	
	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = OffsetDateTime.parse( fromDateTime );
	}

	public ApplicableTimePeriod endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
	}

	@JsonProperty("endDateTime")
	public String getendDateTimeString() {

		if (this.endDateTime == null) {
			return null;
		}
		return this.endDateTime.toString();
	}

	/**
	 * The period of time for which the schedule is applicable. Instance values are
	 * mutually exclusive with daysOfWeek values.
	 * 
	 * @return fromToDateTime
	 **/
	@Schema(description = "The period of time for which the schedule is applicable.  Instance values are mutually exclusive with daysOfWeek values.")

	@Valid
	public OffsetDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = OffsetDateTime.parse( endDateTime );
	}

	public ApplicableTimePeriod rangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
		return this;
	}

	/**
	 * An indicator that specifies the inclusion or exclusion of the from and to
	 * DateTime attributes. Possible values are \"open\", \"closed\",
	 * \"closedBottom\" and \"closedTop\".
	 * 
	 * @return rangeInterval
	 **/
	@Schema(description = "An indicator that specifies the inclusion or exclusion of the from and to DateTime attributes.  Possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".")

	public String getRangeInterval() {
		return rangeInterval;
	}

	public void setRangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ApplicableTimePeriod applicableTimePeriod = (ApplicableTimePeriod) o;
		return Objects.equals(this.getBaseType(), applicableTimePeriod.getBaseType())
				&& Objects.equals(this.getSchemaLocation(), applicableTimePeriod.getSchemaLocation())
				&& Objects.equals(this.getType(), applicableTimePeriod.getType())
				&& Objects.equals(this.dayOfWeek, applicableTimePeriod.dayOfWeek)
				&& Objects.equals(this.fromDateTime, applicableTimePeriod.fromDateTime)
				&& Objects.equals(this.rangeInterval, applicableTimePeriod.rangeInterval);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBaseType(), getSchemaLocation(), getType(), dayOfWeek, fromDateTime, rangeInterval);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ApplicableTimePeriod {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(getBaseType())).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(getSchemaLocation())).append("\n");
		sb.append("    _atType: ").append(toIndentedString(getType())).append("\n");
		sb.append("    dayOfWeek: ").append(toIndentedString(dayOfWeek)).append("\n");
		sb.append("    fromToDateTime: ").append(toIndentedString( fromDateTime )).append("\n");
		sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
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
}
