package io.openslice.tmf.so641.model;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class ServiceOrderAttributeValueChangeEvent   {
  @JsonProperty("serviceOrder")
  private ServiceOrder serviceOrder = null;

  public ServiceOrderAttributeValueChangeEvent serviceOrder(ServiceOrder serviceOrder) {
    this.serviceOrder = serviceOrder;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return serviceOrder
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ServiceOrder getServiceOrder() {
    return serviceOrder;
  }

  public void setServiceOrder(ServiceOrder serviceOrder) {
    this.serviceOrder = serviceOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceOrderAttributeValueChangeEvent serviceOrderAttributeValueChangeEvent = (ServiceOrderAttributeValueChangeEvent) o;
    return Objects.equals(this.serviceOrder, serviceOrderAttributeValueChangeEvent.serviceOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderAttributeValueChangeEvent {\n");
    
    sb.append("    serviceOrder: ").append(toIndentedString(serviceOrder)).append("\n");
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

