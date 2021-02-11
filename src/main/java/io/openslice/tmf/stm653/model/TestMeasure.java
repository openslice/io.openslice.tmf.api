package io.openslice.tmf.stm653.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A TestMeasure specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status
 */
@ApiModel(description = "A TestMeasure specifies a measure of a specific aspect of a product, service, or resource test, such as lost packets or connectivity status")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMTestMeasure")
@Table(name = "STMTestMeasure")
public class TestMeasure  extends BaseRootEntity {
  @JsonProperty("accuracy")
  private Float accuracy = null;

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
  private Set<MeasureThresholdRuleViolation> ruleViolation = null;

  @JsonProperty("value")
  private Characteristic value = null;


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
  
  

  @JsonProperty("captureDateTime")
	public String getcaptureDateTimeStr() {
		if (this.captureDateTime != null) {
			return this.captureDateTime.toString();
		} else {
			return null;
		}
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

  public TestMeasure ruleViolation( Set<MeasureThresholdRuleViolation> ruleViolation) {
    this.ruleViolation = ruleViolation;
    return this;
  }

  public TestMeasure addRuleViolationItem(MeasureThresholdRuleViolation ruleViolationItem) {
    if (this.ruleViolation == null) {
      this.ruleViolation = new HashSet<>();
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
    public Set<MeasureThresholdRuleViolation> getRuleViolation() {
    return ruleViolation;
  }

  public void setRuleViolation( Set<MeasureThresholdRuleViolation> ruleViolation) {
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
        Objects.equals(this.baseType, testMeasure.baseType) &&
        Objects.equals(this.schemaLocation, testMeasure.schemaLocation) &&
        Objects.equals(this.type, testMeasure.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(accuracy, captureDateTime, captureMethod, metricDescription, metricHref, metricName, unitOfMeasure, ruleViolation, value, _atBaseType, _atSchemaLocation, _atType);
//  }

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
    sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
