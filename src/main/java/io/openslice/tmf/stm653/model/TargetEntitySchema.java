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
 * The reference object to the schema and type of target entity which is described by a specification
 */
@ApiModel(description = "The reference object to the schema and type of target entity which is described by a specification")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class TargetEntitySchema   {
  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public TargetEntitySchema _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing the target entity
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(required = true, value = "This field provides a link to the schema describing the target entity")
      @NotNull

    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public TargetEntitySchema _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * Class type of the target entity
   * @return _atType
  **/
  @ApiModelProperty(required = true, value = "Class type of the target entity")
      @NotNull

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
    TargetEntitySchema targetEntitySchema = (TargetEntitySchema) o;
    return Objects.equals(this._atSchemaLocation, targetEntitySchema._atSchemaLocation) &&
        Objects.equals(this._atType, targetEntitySchema._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TargetEntitySchema {\n");
    
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
