package io.openslice.tmf.pcm620.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class ProductSpecificationCreateEventPayload   {
  @JsonProperty("productSpecification")
  private ProductSpecification productSpecification = null;

  public ProductSpecificationCreateEventPayload productSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return productSpecification
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ProductSpecification getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecificationCreateEventPayload productSpecificationCreateEventPayload = (ProductSpecificationCreateEventPayload) o;
    return Objects.equals(this.productSpecification, productSpecificationCreateEventPayload.productSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationCreateEventPayload {\n");
    
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
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

