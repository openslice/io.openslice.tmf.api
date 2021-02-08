package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.Duration;
import io.openslice.tmf.stm653.model.MetricDefMeasureConsequence;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A MetricDefMeasureThresholdRule is a rule that defines the condition (raise or clear) to achieve to apply  consequences when a threshold is crossed or ceased to be crossed. It also defines the severity of the  raise or clear of the threshold.
 */
@ApiModel(description = "A MetricDefMeasureThresholdRule is a rule that defines the condition (raise or clear) to achieve to apply  consequences when a threshold is crossed or ceased to be crossed. It also defines the severity of the  raise or clear of the threshold.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class MetricDefMeasureThresholdRule   {
  @JsonProperty("conformanceComparatorLower")
  private String conformanceComparatorLower = null;

  @JsonProperty("conformanceComparatorUpper")
  private String conformanceComparatorUpper = null;

  @JsonProperty("conformanceTargetLower")
  private String conformanceTargetLower = null;

  @JsonProperty("conformanceTargetUpper")
  private String conformanceTargetUpper = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("numberOfAllowedCrossing")
  private Integer numberOfAllowedCrossing = null;

  @JsonProperty("thresholdRuleSeverity")
  private String thresholdRuleSeverity = null;

  @JsonProperty("consequence")
  @Valid
  private List<MetricDefMeasureConsequence> consequence = null;

  @JsonProperty("tolerancePeriod")
  private Duration tolerancePeriod = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public MetricDefMeasureThresholdRule conformanceComparatorLower(String conformanceComparatorLower) {
    this.conformanceComparatorLower = conformanceComparatorLower;
    return this;
  }

  /**
   * An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to Service Test Management API REST Specification compare with the conformanceTargetLower.
   * @return conformanceComparatorLower
  **/
  @ApiModelProperty(value = "An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to Service Test Management API REST Specification compare with the conformanceTargetLower.")
  
    public String getConformanceComparatorLower() {
    return conformanceComparatorLower;
  }

  public void setConformanceComparatorLower(String conformanceComparatorLower) {
    this.conformanceComparatorLower = conformanceComparatorLower;
  }

  public MetricDefMeasureThresholdRule conformanceComparatorUpper(String conformanceComparatorUpper) {
    this.conformanceComparatorUpper = conformanceComparatorUpper;
    return this;
  }

  /**
   * An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to compare with the conformanceTargetUpper.
   * @return conformanceComparatorUpper
  **/
  @ApiModelProperty(value = "An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to compare with the conformanceTargetUpper.")
  
    public String getConformanceComparatorUpper() {
    return conformanceComparatorUpper;
  }

  public void setConformanceComparatorUpper(String conformanceComparatorUpper) {
    this.conformanceComparatorUpper = conformanceComparatorUpper;
  }

  public MetricDefMeasureThresholdRule conformanceTargetLower(String conformanceTargetLower) {
    this.conformanceTargetLower = conformanceTargetLower;
    return this;
  }

  /**
   * A value used to determine if the threshold is crossed or ceases  to be crossed. It represents the lower limit. The value should be less than the conformanceTargetUpper. The conformance comparators should also be logically defined so as to not lead to a logically impossible condition.
   * @return conformanceTargetLower
  **/
  @ApiModelProperty(value = "A value used to determine if the threshold is crossed or ceases  to be crossed. It represents the lower limit. The value should be less than the conformanceTargetUpper. The conformance comparators should also be logically defined so as to not lead to a logically impossible condition.")
  
    public String getConformanceTargetLower() {
    return conformanceTargetLower;
  }

  public void setConformanceTargetLower(String conformanceTargetLower) {
    this.conformanceTargetLower = conformanceTargetLower;
  }

  public MetricDefMeasureThresholdRule conformanceTargetUpper(String conformanceTargetUpper) {
    this.conformanceTargetUpper = conformanceTargetUpper;
    return this;
  }

  /**
   * A value used to determine if the threshold is crossed or ceases  to be crossed. It represents the Upper limit. The value should be greater than the conformanceTargetLower. The conformance comparators should also be logically defined so as to not lead to a logically impossible condition.
   * @return conformanceTargetUpper
  **/
  @ApiModelProperty(value = "A value used to determine if the threshold is crossed or ceases  to be crossed. It represents the Upper limit. The value should be greater than the conformanceTargetLower. The conformance comparators should also be logically defined so as to not lead to a logically impossible condition.")
  
    public String getConformanceTargetUpper() {
    return conformanceTargetUpper;
  }

  public void setConformanceTargetUpper(String conformanceTargetUpper) {
    this.conformanceTargetUpper = conformanceTargetUpper;
  }

  public MetricDefMeasureThresholdRule description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description for the MetricDefMeasureThresholdRule .
   * @return description
  **/
  @ApiModelProperty(value = "Description for the MetricDefMeasureThresholdRule .")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MetricDefMeasureThresholdRule name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name for the MetricDefMeasureThresholdRule .
   * @return name
  **/
  @ApiModelProperty(value = "Name for the MetricDefMeasureThresholdRule .")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MetricDefMeasureThresholdRule numberOfAllowedCrossing(Integer numberOfAllowedCrossing) {
    this.numberOfAllowedCrossing = numberOfAllowedCrossing;
    return this;
  }

  /**
   * The number of allowed crossing occurrences in reference to the  tolerancePeriod without a consequence being initiated.
   * @return numberOfAllowedCrossing
  **/
  @ApiModelProperty(value = "The number of allowed crossing occurrences in reference to the  tolerancePeriod without a consequence being initiated.")
  
    public Integer getNumberOfAllowedCrossing() {
    return numberOfAllowedCrossing;
  }

  public void setNumberOfAllowedCrossing(Integer numberOfAllowedCrossing) {
    this.numberOfAllowedCrossing = numberOfAllowedCrossing;
  }

  public MetricDefMeasureThresholdRule thresholdRuleSeverity(String thresholdRuleSeverity) {
    this.thresholdRuleSeverity = thresholdRuleSeverity;
    return this;
  }

  /**
   * A threshold can be generated in different severity levels. A  crossing for each level may require a different condition and possibly trigger a different consequence.
   * @return thresholdRuleSeverity
  **/
  @ApiModelProperty(value = "A threshold can be generated in different severity levels. A  crossing for each level may require a different condition and possibly trigger a different consequence.")
  
    public String getThresholdRuleSeverity() {
    return thresholdRuleSeverity;
  }

  public void setThresholdRuleSeverity(String thresholdRuleSeverity) {
    this.thresholdRuleSeverity = thresholdRuleSeverity;
  }

  public MetricDefMeasureThresholdRule consequence(List<MetricDefMeasureConsequence> consequence) {
    this.consequence = consequence;
    return this;
  }

  public MetricDefMeasureThresholdRule addConsequenceItem(MetricDefMeasureConsequence consequenceItem) {
    if (this.consequence == null) {
      this.consequence = new ArrayList<>();
    }
    this.consequence.add(consequenceItem);
    return this;
  }

  /**
   * A list of consequences (actions, notifications) that will arise if the threshold is crossed
   * @return consequence
  **/
  @ApiModelProperty(value = "A list of consequences (actions, notifications) that will arise if the threshold is crossed")
      @Valid
    public List<MetricDefMeasureConsequence> getConsequence() {
    return consequence;
  }

  public void setConsequence(List<MetricDefMeasureConsequence> consequence) {
    this.consequence = consequence;
  }

  public MetricDefMeasureThresholdRule tolerancePeriod(Duration tolerancePeriod) {
    this.tolerancePeriod = tolerancePeriod;
    return this;
  }

  /**
   * Get tolerancePeriod
   * @return tolerancePeriod
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Duration getTolerancePeriod() {
    return tolerancePeriod;
  }

  public void setTolerancePeriod(Duration tolerancePeriod) {
    this.tolerancePeriod = tolerancePeriod;
  }

  public MetricDefMeasureThresholdRule _atBaseType(String _atBaseType) {
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

  public MetricDefMeasureThresholdRule _atSchemaLocation(String _atSchemaLocation) {
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

  public MetricDefMeasureThresholdRule _atType(String _atType) {
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
    MetricDefMeasureThresholdRule metricDefMeasureThresholdRule = (MetricDefMeasureThresholdRule) o;
    return Objects.equals(this.conformanceComparatorLower, metricDefMeasureThresholdRule.conformanceComparatorLower) &&
        Objects.equals(this.conformanceComparatorUpper, metricDefMeasureThresholdRule.conformanceComparatorUpper) &&
        Objects.equals(this.conformanceTargetLower, metricDefMeasureThresholdRule.conformanceTargetLower) &&
        Objects.equals(this.conformanceTargetUpper, metricDefMeasureThresholdRule.conformanceTargetUpper) &&
        Objects.equals(this.description, metricDefMeasureThresholdRule.description) &&
        Objects.equals(this.name, metricDefMeasureThresholdRule.name) &&
        Objects.equals(this.numberOfAllowedCrossing, metricDefMeasureThresholdRule.numberOfAllowedCrossing) &&
        Objects.equals(this.thresholdRuleSeverity, metricDefMeasureThresholdRule.thresholdRuleSeverity) &&
        Objects.equals(this.consequence, metricDefMeasureThresholdRule.consequence) &&
        Objects.equals(this.tolerancePeriod, metricDefMeasureThresholdRule.tolerancePeriod) &&
        Objects.equals(this._atBaseType, metricDefMeasureThresholdRule._atBaseType) &&
        Objects.equals(this._atSchemaLocation, metricDefMeasureThresholdRule._atSchemaLocation) &&
        Objects.equals(this._atType, metricDefMeasureThresholdRule._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conformanceComparatorLower, conformanceComparatorUpper, conformanceTargetLower, conformanceTargetUpper, description, name, numberOfAllowedCrossing, thresholdRuleSeverity, consequence, tolerancePeriod, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetricDefMeasureThresholdRule {\n");
    
    sb.append("    conformanceComparatorLower: ").append(toIndentedString(conformanceComparatorLower)).append("\n");
    sb.append("    conformanceComparatorUpper: ").append(toIndentedString(conformanceComparatorUpper)).append("\n");
    sb.append("    conformanceTargetLower: ").append(toIndentedString(conformanceTargetLower)).append("\n");
    sb.append("    conformanceTargetUpper: ").append(toIndentedString(conformanceTargetUpper)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfAllowedCrossing: ").append(toIndentedString(numberOfAllowedCrossing)).append("\n");
    sb.append("    thresholdRuleSeverity: ").append(toIndentedString(thresholdRuleSeverity)).append("\n");
    sb.append("    consequence: ").append(toIndentedString(consequence)).append("\n");
    sb.append("    tolerancePeriod: ").append(toIndentedString(tolerancePeriod)).append("\n");
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
