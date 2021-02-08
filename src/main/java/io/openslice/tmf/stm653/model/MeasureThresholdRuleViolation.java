package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.AppliedConsequence;
import io.openslice.tmf.stm653.model.Duration;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A measureThresholdRuleViolation is a violation of a rule that defines the in the  MericDefMeasureThresholdRule.
 */
@ApiModel(description = "A measureThresholdRuleViolation is a violation of a rule that defines the in the  MericDefMeasureThresholdRule.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class MeasureThresholdRuleViolation   {
  @JsonProperty("conformanceComparatorLower")
  private String conformanceComparatorLower = null;

  @JsonProperty("conformanceComparatorUpper")
  private String conformanceComparatorUpper = null;

  @JsonProperty("conformanceTargetExact")
  private String conformanceTargetExact = null;

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

  @JsonProperty("appliedConsequence")
  @Valid
  private List<AppliedConsequence> appliedConsequence = null;

  @JsonProperty("tolerancePeriod")
  private Duration tolerancePeriod = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public MeasureThresholdRuleViolation conformanceComparatorLower(String conformanceComparatorLower) {
    this.conformanceComparatorLower = conformanceComparatorLower;
    return this;
  }

  /**
   * An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to compare with the conformanceTargetLower.
   * @return conformanceComparatorLower
  **/
  @ApiModelProperty(value = "An operator that when applied on a value specifies whether a  threshold is crossed or ceased to be crossed. This operator is used to compare with the conformanceTargetLower.")
  
    public String getConformanceComparatorLower() {
    return conformanceComparatorLower;
  }

  public void setConformanceComparatorLower(String conformanceComparatorLower) {
    this.conformanceComparatorLower = conformanceComparatorLower;
  }

  public MeasureThresholdRuleViolation conformanceComparatorUpper(String conformanceComparatorUpper) {
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

  public MeasureThresholdRuleViolation conformanceTargetExact(String conformanceTargetExact) {
    this.conformanceTargetExact = conformanceTargetExact;
    return this;
  }

  /**
   * to cater for values that are not numerical test metrics (e.g. a DSL line can be Synchronised or Unsynchronised. If the latter, the test should result in a rule violation).The allowed value can contain a REGEX string.
   * @return conformanceTargetExact
  **/
  @ApiModelProperty(value = "to cater for values that are not numerical test metrics (e.g. a DSL line can be Synchronised or Unsynchronised. If the latter, the test should result in a rule violation).The allowed value can contain a REGEX string.")
  
    public String getConformanceTargetExact() {
    return conformanceTargetExact;
  }

  public void setConformanceTargetExact(String conformanceTargetExact) {
    this.conformanceTargetExact = conformanceTargetExact;
  }

  public MeasureThresholdRuleViolation conformanceTargetLower(String conformanceTargetLower) {
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

  public MeasureThresholdRuleViolation conformanceTargetUpper(String conformanceTargetUpper) {
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

  public MeasureThresholdRuleViolation description(String description) {
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

  public MeasureThresholdRuleViolation name(String name) {
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

  public MeasureThresholdRuleViolation numberOfAllowedCrossing(Integer numberOfAllowedCrossing) {
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

  public MeasureThresholdRuleViolation thresholdRuleSeverity(String thresholdRuleSeverity) {
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

  public MeasureThresholdRuleViolation appliedConsequence(List<AppliedConsequence> appliedConsequence) {
    this.appliedConsequence = appliedConsequence;
    return this;
  }

  public MeasureThresholdRuleViolation addAppliedConsequenceItem(AppliedConsequence appliedConsequenceItem) {
    if (this.appliedConsequence == null) {
      this.appliedConsequence = new ArrayList<>();
    }
    this.appliedConsequence.add(appliedConsequenceItem);
    return this;
  }

  /**
   * An Applied Consequence defines the action (prescribed action or notification) to take when a MeasureThresholdRuleViolation occurs.
   * @return appliedConsequence
  **/
  @ApiModelProperty(value = "An Applied Consequence defines the action (prescribed action or notification) to take when a MeasureThresholdRuleViolation occurs.")
      @Valid
    public List<AppliedConsequence> getAppliedConsequence() {
    return appliedConsequence;
  }

  public void setAppliedConsequence(List<AppliedConsequence> appliedConsequence) {
    this.appliedConsequence = appliedConsequence;
  }

  public MeasureThresholdRuleViolation tolerancePeriod(Duration tolerancePeriod) {
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

  public MeasureThresholdRuleViolation _atBaseType(String _atBaseType) {
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

  public MeasureThresholdRuleViolation _atSchemaLocation(String _atSchemaLocation) {
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

  public MeasureThresholdRuleViolation _atType(String _atType) {
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
    MeasureThresholdRuleViolation measureThresholdRuleViolation = (MeasureThresholdRuleViolation) o;
    return Objects.equals(this.conformanceComparatorLower, measureThresholdRuleViolation.conformanceComparatorLower) &&
        Objects.equals(this.conformanceComparatorUpper, measureThresholdRuleViolation.conformanceComparatorUpper) &&
        Objects.equals(this.conformanceTargetExact, measureThresholdRuleViolation.conformanceTargetExact) &&
        Objects.equals(this.conformanceTargetLower, measureThresholdRuleViolation.conformanceTargetLower) &&
        Objects.equals(this.conformanceTargetUpper, measureThresholdRuleViolation.conformanceTargetUpper) &&
        Objects.equals(this.description, measureThresholdRuleViolation.description) &&
        Objects.equals(this.name, measureThresholdRuleViolation.name) &&
        Objects.equals(this.numberOfAllowedCrossing, measureThresholdRuleViolation.numberOfAllowedCrossing) &&
        Objects.equals(this.thresholdRuleSeverity, measureThresholdRuleViolation.thresholdRuleSeverity) &&
        Objects.equals(this.appliedConsequence, measureThresholdRuleViolation.appliedConsequence) &&
        Objects.equals(this.tolerancePeriod, measureThresholdRuleViolation.tolerancePeriod) &&
        Objects.equals(this._atBaseType, measureThresholdRuleViolation._atBaseType) &&
        Objects.equals(this._atSchemaLocation, measureThresholdRuleViolation._atSchemaLocation) &&
        Objects.equals(this._atType, measureThresholdRuleViolation._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conformanceComparatorLower, conformanceComparatorUpper, conformanceTargetExact, conformanceTargetLower, conformanceTargetUpper, description, name, numberOfAllowedCrossing, thresholdRuleSeverity, appliedConsequence, tolerancePeriod, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeasureThresholdRuleViolation {\n");
    
    sb.append("    conformanceComparatorLower: ").append(toIndentedString(conformanceComparatorLower)).append("\n");
    sb.append("    conformanceComparatorUpper: ").append(toIndentedString(conformanceComparatorUpper)).append("\n");
    sb.append("    conformanceTargetExact: ").append(toIndentedString(conformanceTargetExact)).append("\n");
    sb.append("    conformanceTargetLower: ").append(toIndentedString(conformanceTargetLower)).append("\n");
    sb.append("    conformanceTargetUpper: ").append(toIndentedString(conformanceTargetUpper)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfAllowedCrossing: ").append(toIndentedString(numberOfAllowedCrossing)).append("\n");
    sb.append("    thresholdRuleSeverity: ").append(toIndentedString(thresholdRuleSeverity)).append("\n");
    sb.append("    appliedConsequence: ").append(toIndentedString(appliedConsequence)).append("\n");
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
