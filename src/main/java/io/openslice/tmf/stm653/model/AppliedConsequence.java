package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An Applied Consequence defines the action (prescribed action or notification) to take when a  MeasureThresholdRuleViolation occurs.
 */
@ApiModel(description = "An Applied Consequence defines the action (prescribed action or notification) to take when a  MeasureThresholdRuleViolation occurs.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class AppliedConsequence   {
  @JsonProperty("appliedAction")
  private String appliedAction = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("repeatAction")
  private Boolean repeatAction = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public AppliedConsequence appliedAction(String appliedAction) {
    this.appliedAction = appliedAction;
    return this;
  }

  /**
   * The action for a violated threshold. This could be a hyperlink to  the action.
   * @return appliedAction
  **/
  @ApiModelProperty(value = "The action for a violated threshold. This could be a hyperlink to  the action.")
  
    public String getAppliedAction() {
    return appliedAction;
  }

  public void setAppliedAction(String appliedAction) {
    this.appliedAction = appliedAction;
  }

  public AppliedConsequence description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the consequence is.
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail what the consequence is.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AppliedConsequence name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which Consequence is known and  distinguished from other MetricDefMeasureConsequences.
   * @return name
  **/
  @ApiModelProperty(value = "A word, term, or phrase by which Consequence is known and  distinguished from other MetricDefMeasureConsequences.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AppliedConsequence repeatAction(Boolean repeatAction) {
    this.repeatAction = repeatAction;
    return this;
  }

  /**
   * An indicator used to specify that a consequence should cease  being applied if a value is in the same range as the previous value or continue being applied if a value is in the same range as the previous value.   If the repeatAction is True, if the consequence is always applied as soon as the MetricMeasure value is in the range of values and if the repeatAction is False, the consequence is applied only if the previous MetricMeasure value was not in the same range.
   * @return repeatAction
  **/
  @ApiModelProperty(value = "An indicator used to specify that a consequence should cease  being applied if a value is in the same range as the previous value or continue being applied if a value is in the same range as the previous value.   If the repeatAction is True, if the consequence is always applied as soon as the MetricMeasure value is in the range of values and if the repeatAction is False, the consequence is applied only if the previous MetricMeasure value was not in the same range.")
  
    public Boolean isRepeatAction() {
    return repeatAction;
  }

  public void setRepeatAction(Boolean repeatAction) {
    this.repeatAction = repeatAction;
  }

  public AppliedConsequence _atBaseType(String _atBaseType) {
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

  public AppliedConsequence _atSchemaLocation(String _atSchemaLocation) {
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

  public AppliedConsequence _atType(String _atType) {
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
    AppliedConsequence appliedConsequence = (AppliedConsequence) o;
    return Objects.equals(this.appliedAction, appliedConsequence.appliedAction) &&
        Objects.equals(this.description, appliedConsequence.description) &&
        Objects.equals(this.name, appliedConsequence.name) &&
        Objects.equals(this.repeatAction, appliedConsequence.repeatAction) &&
        Objects.equals(this._atBaseType, appliedConsequence._atBaseType) &&
        Objects.equals(this._atSchemaLocation, appliedConsequence._atSchemaLocation) &&
        Objects.equals(this._atType, appliedConsequence._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appliedAction, description, name, repeatAction, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppliedConsequence {\n");
    
    sb.append("    appliedAction: ").append(toIndentedString(appliedAction)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    repeatAction: ").append(toIndentedString(repeatAction)).append("\n");
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
