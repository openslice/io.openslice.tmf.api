package io.openslice.tmf.so641.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.so641.model.ServiceOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class ServiceOrderDeleteEvent   {
  @JsonProperty("serviceOrder")
  private ServiceOrder serviceOrder = null;

  public ServiceOrderDeleteEvent serviceOrder(ServiceOrder serviceOrder) {
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
    ServiceOrderDeleteEvent serviceOrderDeleteEvent = (ServiceOrderDeleteEvent) o;
    return Objects.equals(this.serviceOrder, serviceOrderDeleteEvent.serviceOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderDeleteEvent {\n");
    
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

