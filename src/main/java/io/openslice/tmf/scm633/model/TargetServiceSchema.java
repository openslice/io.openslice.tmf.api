package io.openslice.tmf.scm633.model;

import java.util.Objects;

import javax.persistence.Embeddable;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;

/**
 * The reference object to the schema and type of target service which is described by service specification
 */
@ApiModel(description = "The reference object to the schema and type of target service which is described by service specification")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Embeddable
public class TargetServiceSchema extends BaseRootEntity  {
 


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TargetServiceSchema targetServiceSchema = (TargetServiceSchema) o;
    return Objects.equals(this.baseType, targetServiceSchema.baseType) &&
        Objects.equals(this.schemaLocation, targetServiceSchema.schemaLocation) &&
        Objects.equals(this.type, targetServiceSchema.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TargetServiceSchema {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

