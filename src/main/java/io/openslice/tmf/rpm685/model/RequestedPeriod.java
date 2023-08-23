package io.openslice.tmf.rpm685.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The period of time for which user requested to use the resources. The user can request on the start date without the end date.
 */
@Schema(description = "The period of time for which user requested to use the resources. The user can request on the start date without the end date.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class RequestedPeriod   {
  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  @JsonProperty("daysOfWeek")
  private String daysOfWeek = null;

  @JsonProperty("fromToDateTime")
  private OffsetDateTime fromToDateTime = null;

  @JsonProperty("rangeInterval")
  private String rangeInterval = null;

  @JsonProperty("validFor")
  private String validFor = null;

  public RequestedPeriod _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * A string. Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.
   * @return _atBaseType
  **/
  @Schema(description = "A string. Generic attribute indicating the base class type of the extension class of the current object. Useful only when the class type of the current  object is unknown to the implementation.")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public RequestedPeriod _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A string. Generic attribute containing the link to the schema that defines the structure of the class type of the current object.
   * @return _atSchemaLocation
  **/
  @Schema(description = "A string. Generic attribute containing the link to the schema that defines the structure of the class type of the current object.")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public RequestedPeriod _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * A string. Generic attribute containing the name of the resource class type.
   * @return _atType
  **/
  @Schema(description = "A string. Generic attribute containing the name of the resource class type.")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }

  public RequestedPeriod daysOfWeek(String daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
    return this;
  }

  /**
   * A day or days representing when the schedule is applicable. For example 2, 3 represent Monday and Tuesday.
   * @return daysOfWeek
  **/
  @Schema(description = "A day or days representing when the schedule is applicable. For example 2, 3 represent Monday and Tuesday.")
  
    public String getDaysOfWeek() {
    return daysOfWeek;
  }

  public void setDaysOfWeek(String daysOfWeek) {
    this.daysOfWeek = daysOfWeek;
  }

  public RequestedPeriod fromToDateTime(OffsetDateTime fromToDateTime) {
    this.fromToDateTime = fromToDateTime;
    return this;
  }

  /**
   * The period of time for which the schedule is applicable.  Instance values are mutually exclusive with daysOfWeek values.
   * @return fromToDateTime
  **/
  @Schema(description = "The period of time for which the schedule is applicable.  Instance values are mutually exclusive with daysOfWeek values.")
  
    @Valid
    public OffsetDateTime getFromToDateTime() {
    return fromToDateTime;
  }

  public void setFromToDateTime(OffsetDateTime fromToDateTime) {
    this.fromToDateTime = fromToDateTime;
  }

  public RequestedPeriod rangeInterval(String rangeInterval) {
    this.rangeInterval = rangeInterval;
    return this;
  }

  /**
   * An indicator that specifies the inclusion or exclusion of the from and to DateTime attributes.  Possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".
   * @return rangeInterval
  **/
  @Schema(description = "An indicator that specifies the inclusion or exclusion of the from and to DateTime attributes.  Possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".")
  
    public String getRangeInterval() {
    return rangeInterval;
  }

  public void setRangeInterval(String rangeInterval) {
    this.rangeInterval = rangeInterval;
  }

  public RequestedPeriod validFor(String validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time during which the schedule is considered of interest to the business.
   * @return validFor
  **/
  @Schema(description = "The period of time during which the schedule is considered of interest to the business.")
  
    public String getValidFor() {
    return validFor;
  }

  public void setValidFor(String validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestedPeriod requestedPeriod = (RequestedPeriod) o;
    return Objects.equals(this._atBaseType, requestedPeriod._atBaseType) &&
        Objects.equals(this._atSchemaLocation, requestedPeriod._atSchemaLocation) &&
        Objects.equals(this._atType, requestedPeriod._atType) &&
        Objects.equals(this.daysOfWeek, requestedPeriod.daysOfWeek) &&
        Objects.equals(this.fromToDateTime, requestedPeriod.fromToDateTime) &&
        Objects.equals(this.rangeInterval, requestedPeriod.rangeInterval) &&
        Objects.equals(this.validFor, requestedPeriod.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_atBaseType, _atSchemaLocation, _atType, daysOfWeek, fromToDateTime, rangeInterval, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestedPeriod {\n");
    
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
    sb.append("    daysOfWeek: ").append(toIndentedString(daysOfWeek)).append("\n");
    sb.append("    fromToDateTime: ").append(toIndentedString(fromToDateTime)).append("\n");
    sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
