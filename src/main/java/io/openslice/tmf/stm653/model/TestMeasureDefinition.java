package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.Duration;
import io.openslice.tmf.stm653.model.MetricDefMeasureThresholdRule;
import io.openslice.tmf.stm653.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A TestMeasureDefinition specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status
 */
@ApiModel(description = "A TestMeasureDefinition specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class TestMeasureDefinition   {
  @JsonProperty("captureFrequency")
  private String captureFrequency = null;

  @JsonProperty("captureMethod")
  private String captureMethod = null;

  @JsonProperty("metricDescription")
  private String metricDescription = null;

  @JsonProperty("metricHref")
  private String metricHref = null;

  @JsonProperty("metricName")
  private String metricName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure = null;

  @JsonProperty("valueType")
  private String valueType = null;

  @JsonProperty("capturePeriod")
  private Duration capturePeriod = null;

  @JsonProperty("thresholdRule")
  @Valid
  private List<MetricDefMeasureThresholdRule> thresholdRule = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public TestMeasureDefinition captureFrequency(String captureFrequency) {
    this.captureFrequency = captureFrequency;
    return this;
  }

  /**
   * The frequency of capture for the metric. Note: This may be replaced by a set of entities similar to the Performance Monitoring
   * @return captureFrequency
  **/
  @ApiModelProperty(value = "The frequency of capture for the metric. Note: This may be replaced by a set of entities similar to the Performance Monitoring")
  
    public String getCaptureFrequency() {
    return captureFrequency;
  }

  public void setCaptureFrequency(String captureFrequency) {
    this.captureFrequency = captureFrequency;
  }

  public TestMeasureDefinition captureMethod(String captureMethod) {
    this.captureMethod = captureMethod;
    return this;
  }

  /**
   * The method used to capture the Metric. Note: This may be replaced by a set of entities similar to the Performance Monitoring
   * @return captureMethod
  **/
  @ApiModelProperty(value = "The method used to capture the Metric. Note: This may be replaced by a set of entities similar to the Performance Monitoring")
  
    public String getCaptureMethod() {
    return captureMethod;
  }

  public void setCaptureMethod(String captureMethod) {
    this.captureMethod = captureMethod;
  }

  public TestMeasureDefinition metricDescription(String metricDescription) {
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

  public TestMeasureDefinition metricHref(String metricHref) {
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

  public TestMeasureDefinition metricName(String metricName) {
    this.metricName = metricName;
    return this;
  }

  /**
   * The name of a metric that in the test measure
   * @return metricName
  **/
  @ApiModelProperty(value = "The name of a metric that in the test measure")
  
    public String getMetricName() {
    return metricName;
  }

  public void setMetricName(String metricName) {
    this.metricName = metricName;
  }

  public TestMeasureDefinition name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the TestMeasureDefinition
   * @return name
  **/
  @ApiModelProperty(value = "The name of the TestMeasureDefinition")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestMeasureDefinition unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Name of a service test specification
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "Name of a service test specification")
  
    public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public TestMeasureDefinition valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the Metric value can take on, such as numeric, text, and so forth
   * @return valueType
  **/
  @ApiModelProperty(value = "A kind of value that the Metric value can take on, such as numeric, text, and so forth")
  
    public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public TestMeasureDefinition capturePeriod(Duration capturePeriod) {
    this.capturePeriod = capturePeriod;
    return this;
  }

  /**
   * Get capturePeriod
   * @return capturePeriod
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Duration getCapturePeriod() {
    return capturePeriod;
  }

  public void setCapturePeriod(Duration capturePeriod) {
    this.capturePeriod = capturePeriod;
  }

  public TestMeasureDefinition thresholdRule(List<MetricDefMeasureThresholdRule> thresholdRule) {
    this.thresholdRule = thresholdRule;
    return this;
  }

  public TestMeasureDefinition addThresholdRuleItem(MetricDefMeasureThresholdRule thresholdRuleItem) {
    if (this.thresholdRule == null) {
      this.thresholdRule = new ArrayList<>();
    }
    this.thresholdRule.add(thresholdRuleItem);
    return this;
  }

  /**
   * The rule(s) associated with the measure threshold
   * @return thresholdRule
  **/
  @ApiModelProperty(value = "The rule(s) associated with the measure threshold")
      @Valid
    public List<MetricDefMeasureThresholdRule> getThresholdRule() {
    return thresholdRule;
  }

  public void setThresholdRule(List<MetricDefMeasureThresholdRule> thresholdRule) {
    this.thresholdRule = thresholdRule;
  }

  public TestMeasureDefinition validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public TestMeasureDefinition _atBaseType(String _atBaseType) {
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

  public TestMeasureDefinition _atSchemaLocation(String _atSchemaLocation) {
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

  public TestMeasureDefinition _atType(String _atType) {
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
    TestMeasureDefinition testMeasureDefinition = (TestMeasureDefinition) o;
    return Objects.equals(this.captureFrequency, testMeasureDefinition.captureFrequency) &&
        Objects.equals(this.captureMethod, testMeasureDefinition.captureMethod) &&
        Objects.equals(this.metricDescription, testMeasureDefinition.metricDescription) &&
        Objects.equals(this.metricHref, testMeasureDefinition.metricHref) &&
        Objects.equals(this.metricName, testMeasureDefinition.metricName) &&
        Objects.equals(this.name, testMeasureDefinition.name) &&
        Objects.equals(this.unitOfMeasure, testMeasureDefinition.unitOfMeasure) &&
        Objects.equals(this.valueType, testMeasureDefinition.valueType) &&
        Objects.equals(this.capturePeriod, testMeasureDefinition.capturePeriod) &&
        Objects.equals(this.thresholdRule, testMeasureDefinition.thresholdRule) &&
        Objects.equals(this.validFor, testMeasureDefinition.validFor) &&
        Objects.equals(this._atBaseType, testMeasureDefinition._atBaseType) &&
        Objects.equals(this._atSchemaLocation, testMeasureDefinition._atSchemaLocation) &&
        Objects.equals(this._atType, testMeasureDefinition._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(captureFrequency, captureMethod, metricDescription, metricHref, metricName, name, unitOfMeasure, valueType, capturePeriod, thresholdRule, validFor, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestMeasureDefinition {\n");
    
    sb.append("    captureFrequency: ").append(toIndentedString(captureFrequency)).append("\n");
    sb.append("    captureMethod: ").append(toIndentedString(captureMethod)).append("\n");
    sb.append("    metricDescription: ").append(toIndentedString(metricDescription)).append("\n");
    sb.append("    metricHref: ").append(toIndentedString(metricHref)).append("\n");
    sb.append("    metricName: ").append(toIndentedString(metricName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    capturePeriod: ").append(toIndentedString(capturePeriod)).append("\n");
    sb.append("    thresholdRule: ").append(toIndentedString(thresholdRule)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
