package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Identifies the details of the threshold that has been crossed.
 */
@ApiModel(description = "Identifies the details of the threshold that has been crossed.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T12:06:56.372977300+02:00[Europe/Athens]")
public class CrossedThresholdInformation   {
  @JsonProperty("thresholdId")
  private String thresholdId = null;

  @JsonProperty("thresholdRef")
  private String thresholdRef = null;

  @JsonProperty("indicatorName")
  private String indicatorName = null;

  @JsonProperty("observedValue")
  private String observedValue = null;

  @JsonProperty("indicatorUnit")
  private String indicatorUnit = null;

  @JsonProperty("granularity")
  private String granularity = null;

  @JsonProperty("direction")
  private String direction = null;

  @JsonProperty("thresholdCrossingDescription")
  private String thresholdCrossingDescription = null;

  public CrossedThresholdInformation thresholdId(String thresholdId) {
    this.thresholdId = thresholdId;
    return this;
  }

  /**
   * Indicates the threshold id that caused the alarm.
   * @return thresholdId
  **/
  @ApiModelProperty(value = "Indicates the threshold id that caused the alarm.")
  
    public String getThresholdId() {
    return thresholdId;
  }

  public void setThresholdId(String thresholdId) {
    this.thresholdId = thresholdId;
  }

  public CrossedThresholdInformation thresholdRef(String thresholdRef) {
    this.thresholdRef = thresholdRef;
    return this;
  }

  /**
   * Get thresholdRef
   * @return thresholdRef
  **/
  @ApiModelProperty(value = "")
  
    public String getThresholdRef() {
    return thresholdRef;
  }

  public void setThresholdRef(String thresholdRef) {
    this.thresholdRef = thresholdRef;
  }

  public CrossedThresholdInformation indicatorName(String indicatorName) {
    this.indicatorName = indicatorName;
    return this;
  }

  /**
   * Indicates the name of indicator which crossed the threshold.
   * @return indicatorName
  **/
  @ApiModelProperty(value = "Indicates the name of indicator which crossed the threshold.")
  
    public String getIndicatorName() {
    return indicatorName;
  }

  public void setIndicatorName(String indicatorName) {
    this.indicatorName = indicatorName;
  }

  public CrossedThresholdInformation observedValue(String observedValue) {
    this.observedValue = observedValue;
    return this;
  }

  /**
   * Indicates the value of the indicator which crossed the threshold.
   * @return observedValue
  **/
  @ApiModelProperty(value = "Indicates the value of the indicator which crossed the threshold.")
  
    public String getObservedValue() {
    return observedValue;
  }

  public void setObservedValue(String observedValue) {
    this.observedValue = observedValue;
  }

  public CrossedThresholdInformation indicatorUnit(String indicatorUnit) {
    this.indicatorUnit = indicatorUnit;
    return this;
  }

  /**
   * Indicates the unit of the measurement of the indicator corresponding to the threshold that has been crossed.
   * @return indicatorUnit
  **/
  @ApiModelProperty(value = "Indicates the unit of the measurement of the indicator corresponding to the threshold that has been crossed.")
  
    public String getIndicatorUnit() {
    return indicatorUnit;
  }

  public void setIndicatorUnit(String indicatorUnit) {
    this.indicatorUnit = indicatorUnit;
  }

  public CrossedThresholdInformation granularity(String granularity) {
    this.granularity = granularity;
    return this;
  }

  /**
   * Indicates the granularity at which the indicator is evaluated for threshold crossing
   * @return granularity
  **/
  @ApiModelProperty(value = "Indicates the granularity at which the indicator is evaluated for threshold crossing")
  
    public String getGranularity() {
    return granularity;
  }

  public void setGranularity(String granularity) {
    this.granularity = granularity;
  }

  public CrossedThresholdInformation direction(String direction) {
    this.direction = direction;
    return this;
  }

  /**
   * Indicates the threshold crossing direction: up or down.
   * @return direction
  **/
  @ApiModelProperty(value = "Indicates the threshold crossing direction: up or down.")
  
    public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public CrossedThresholdInformation thresholdCrossingDescription(String thresholdCrossingDescription) {
    this.thresholdCrossingDescription = thresholdCrossingDescription;
    return this;
  }

  /**
   * Indicates further information on the threshold crossing alarm.
   * @return thresholdCrossingDescription
  **/
  @ApiModelProperty(value = "Indicates further information on the threshold crossing alarm.")
  
    public String getThresholdCrossingDescription() {
    return thresholdCrossingDescription;
  }

  public void setThresholdCrossingDescription(String thresholdCrossingDescription) {
    this.thresholdCrossingDescription = thresholdCrossingDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrossedThresholdInformation crossedThresholdInformation = (CrossedThresholdInformation) o;
    return Objects.equals(this.thresholdId, crossedThresholdInformation.thresholdId) &&
        Objects.equals(this.thresholdRef, crossedThresholdInformation.thresholdRef) &&
        Objects.equals(this.indicatorName, crossedThresholdInformation.indicatorName) &&
        Objects.equals(this.observedValue, crossedThresholdInformation.observedValue) &&
        Objects.equals(this.indicatorUnit, crossedThresholdInformation.indicatorUnit) &&
        Objects.equals(this.granularity, crossedThresholdInformation.granularity) &&
        Objects.equals(this.direction, crossedThresholdInformation.direction) &&
        Objects.equals(this.thresholdCrossingDescription, crossedThresholdInformation.thresholdCrossingDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(thresholdId, thresholdRef, indicatorName, observedValue, indicatorUnit, granularity, direction, thresholdCrossingDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrossedThresholdInformation {\n");
    
    sb.append("    thresholdId: ").append(toIndentedString(thresholdId)).append("\n");
    sb.append("    thresholdRef: ").append(toIndentedString(thresholdRef)).append("\n");
    sb.append("    indicatorName: ").append(toIndentedString(indicatorName)).append("\n");
    sb.append("    observedValue: ").append(toIndentedString(observedValue)).append("\n");
    sb.append("    indicatorUnit: ").append(toIndentedString(indicatorUnit)).append("\n");
    sb.append("    granularity: ").append(toIndentedString(granularity)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    thresholdCrossingDescription: ").append(toIndentedString(thresholdCrossingDescription)).append("\n");
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
