/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.po622.model;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class ProductOrderAttributeValueChangeEventPayload   {
  @JsonProperty("productOrder")
  private ProductOrder productOrder = null;

  public ProductOrderAttributeValueChangeEventPayload productOrder(ProductOrder productOrder) {
    this.productOrder = productOrder;
    return this;
  }

  /**
   * Get productOrder
   * @return productOrder
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ProductOrder getProductOrder() {
    return productOrder;
  }

  public void setProductOrder(ProductOrder productOrder) {
    this.productOrder = productOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOrderAttributeValueChangeEventPayload productOrderAttributeValueChangeEventPayload = (ProductOrderAttributeValueChangeEventPayload) o;
    return Objects.equals(this.productOrder, productOrderAttributeValueChangeEventPayload.productOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOrderAttributeValueChangeEventPayload {\n");
    
    sb.append("    productOrder: ").append(toIndentedString(productOrder)).append("\n");
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
