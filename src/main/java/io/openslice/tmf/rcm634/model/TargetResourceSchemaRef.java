package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import javax.persistence.Embeddable;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The reference object to the schema and type of target resource which is described by resource specification
 */
@ApiModel(description = "The reference object to the schema and type of target resource which is described by resource specification")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Embeddable
public class TargetResourceSchemaRef   extends BaseRootEntity  {

  public TargetResourceSchemaRef type(String type) {
    this.type = type;
    return this;
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

