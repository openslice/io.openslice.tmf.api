package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The reference object to the schema and type of target resource which is described by resource specification
 */
@ApiModel(description = "The reference object to the schema and type of target resource which is described by resource specification")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class TargetResourceSchemaRef   {
  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public TargetResourceSchemaRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Class type of the target resource
   * @return type
  **/
  @ApiModelProperty(value = "Class type of the target resource")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public TargetResourceSchemaRef schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing the target resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing the target resource")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TargetResourceSchemaRef targetResourceSchemaRef = (TargetResourceSchemaRef) o;
    return Objects.equals(this.type, targetResourceSchemaRef.type) &&
        Objects.equals(this.schemaLocation, targetResourceSchemaRef.schemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, schemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TargetResourceSchemaRef {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

