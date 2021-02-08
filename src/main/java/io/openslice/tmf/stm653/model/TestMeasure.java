package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.Characteristic;
import io.openslice.tmf.stm653.model.MeasureThresholdRuleViolation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A TestMeasure specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status
 */
@ApiModel(description = "A TestMeasure specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class TestMeasure   {
  @JsonProperty("accuracy")
  private Float accuracy = null;

  @JsonProperty("captureDateTime")
  private OffsetDateTime captureDateTime = null;

  @JsonProperty("captureMethod")
  private String captureMethod = null;

  @JsonProperty("metricDescription")
  private String metricDescription = null;

  @JsonProperty("metricHref")
  private String metricHref = null;

  @JsonProperty("metricName")
  private String metricName = null;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure = null;

  @JsonProperty("ruleViolation")
  @Valid
  private List<MeasureThresholdRuleViolation> ruleViolation = null;

  @JsonProperty("value")
  private Characteristic value = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public TestMeasure accuracy(Float accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /**
   * The number of digits of accuracy captured for associated Metrics
   * @return accuracy
  **/
  @ApiModelProperty(value = "The number of digits of accuracy captured for associated Metrics")
  
    public Float getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(Float accuracy) {
    this.accuracy = accuracy;
  }

  public TestMeasure captureDateTime(OffsetDateTime captureDateTime) {
    this.captureDateTime = captureDateTime;
    return this;
  }

  /**
   * The date and time that the metric was captured
   * @return captureDateTime
  **/
  @ApiModelProperty(value = "The date and time that the metric was captured")
  
    @Valid
    public OffsetDateTime getCaptureDateTime() {
    return captureDateTime;
  }

  public void setCaptureDateTime(OffsetDateTime captureDateTime) {
    this.captureDateTime = captureDateTime;
  }

  public TestMeasure captureMethod(String captureMethod) {
    this.captureMethod = captureMethod;
    return this;
  }

  /**
   * The method used to capture the Metrics (This may be replaced by a set of entities similar to the Performance Monitoring Ref)
   * @return captureMethod
  **/
  @ApiModelProperty(value = "The method used to capture the Metrics (This may be replaced by a set of entities similar to the Performance Monitoring Ref)")
  
    public String getCaptureMethod() {
    return captureMethod;
  }

  public void setCaptureMethod(String captureMethod) {
    this.captureMethod = captureMethod;
  }

  public TestMeasure metricDescription(String metricDescription) {
    this.metricDescription = metricDescription;
    return this;
  }

  /**
   * Brief description of the metric
   * @return metricDescription
  **/
  @ApiModelProperty(value = "Brief description of the metric")
  
    public String getMetricDescription() {
    return metricDescription;
  }

  public void setMetricDescription(String metricDescription) {
    this.metricDescription = metricDescription;
  }

  public TestMeasure metricHref(String metricHref) {
    this.metricHref = metricHref;
    return this;
  }

  /**
   * Hyperlink to access a metric for detail information
   * @return metricHref
  **/
  @ApiModelProperty(value = "Hyperlink to access a metric for detail information")
  
    public String getMetricHref() {
    return metricHref;
  }

  public void setMetricHref(String metricHref) {
    this.metricHref = metricHref;
  }

  public TestMeasure metricName(String metricName) {
    this.metricName = metricName;
    return this;
  }

  /**
   * The name of the metric
   * @return metricName
  **/
  @ApiModelProperty(value = "The name of the metric")
  
    public String getMetricName() {
    return metricName;
  }

  public void setMetricName(String metricName) {
    this.metricName = metricName;
  }

  public TestMeasure unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * The unit of measure for the metric values, such as meters, cubic yards, kilograms [ISO 1000].
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "The unit of measure for the metric values, such as meters, cubic yards, kilograms [ISO 1000].")
  
    public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public TestMeasure ruleViolation(List<MeasureThresholdRuleViolation> ruleViolation) {
    this.ruleViolation = ruleViolation;
    return this;
  }

  public TestMeasure addRuleViolationItem(MeasureThresholdRuleViolation ruleViolationItem) {
    if (this.ruleViolation == null) {
      this.ruleViolation = new ArrayList<>();
    }
    this.ruleViolation.add(ruleViolationItem);
    return this;
  }

  /**
   * A list of rules that were violated in this test measure
   * @return ruleViolation
  **/
  @ApiModelProperty(value = "A list of rules that were violated in this test measure")
      @Valid
    public List<MeasureThresholdRuleViolation> getRuleViolation() {
    return ruleViolation;
  }

  public void setRuleViolation(List<MeasureThresholdRuleViolation> ruleViolation) {
    this.ruleViolation = ruleViolation;
  }

  public TestMeasure value(Characteristic value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Characteristic getValue() {
    return value;
  }

  public void setValue(Characteristic value) {
    this.value = value;
  }

  public TestMeasure _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public TestMeasure _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public TestMeasure _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestMeasure testMeasure = (TestMeasure) o;
    return Objects.equals(this.accuracy, testMeasure.accuracy) &&
        Objects.equals(this.captureDateTime, testMeasure.captureDateTime) &&
        Objects.equals(this.captureMethod, testMeasure.captureMethod) &&
        Objects.equals(this.metricDescription, testMeasure.metricDescription) &&
        Objects.equals(this.metricHref, testMeasure.metricHref) &&
        Objects.equals(this.metricName, testMeasure.metricName) &&
        Objects.equals(this.unitOfMeasure, testMeasure.unitOfMeasure) &&
        Objects.equals(this.ruleViolation, testMeasure.ruleViolation) &&
        Objects.equals(this.value, testMeasure.value) &&
        Objects.equals(this._atBaseType, testMeasure._atBaseType) &&
        Objects.equals(this._atSchemaLocation, testMeasure._atSchemaLocation) &&
        Objects.equals(this._atType, testMeasure._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accuracy, captureDateTime, captureMethod, metricDescription, metricHref, metricName, unitOfMeasure, ruleViolation, value, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestMeasure {\n");
    
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    captureDateTime: ").append(toIndentedString(captureDateTime)).append("\n");
    sb.append("    captureMethod: ").append(toIndentedString(captureMethod)).append("\n");
    sb.append("    metricDescription: ").append(toIndentedString(metricDescription)).append("\n");
    sb.append("    metricHref: ").append(toIndentedString(metricHref)).append("\n");
    sb.append("    metricName: ").append(toIndentedString(metricName)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    ruleViolation: ").append(toIndentedString(ruleViolation)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
