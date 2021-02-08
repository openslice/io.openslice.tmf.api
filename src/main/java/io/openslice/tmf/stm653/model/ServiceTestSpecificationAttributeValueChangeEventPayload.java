package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.ServiceTestSpecification;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestSpecificationAttributeValueChangeEventPayload   {
  @JsonProperty("serviceTestSpecification")
  private ServiceTestSpecification serviceTestSpecification = null;

  public ServiceTestSpecificationAttributeValueChangeEventPayload serviceTestSpecification(ServiceTestSpecification serviceTestSpecification) {
    this.serviceTestSpecification = serviceTestSpecification;
    return this;
  }

  /**
   * Get serviceTestSpecification
   * @return serviceTestSpecification
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ServiceTestSpecification getServiceTestSpecification() {
    return serviceTestSpecification;
  }

  public void setServiceTestSpecification(ServiceTestSpecification serviceTestSpecification) {
    this.serviceTestSpecification = serviceTestSpecification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestSpecificationAttributeValueChangeEventPayload serviceTestSpecificationAttributeValueChangeEventPayload = (ServiceTestSpecificationAttributeValueChangeEventPayload) o;
    return Objects.equals(this.serviceTestSpecification, serviceTestSpecificationAttributeValueChangeEventPayload.serviceTestSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceTestSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecificationAttributeValueChangeEventPayload {\n");
    
    sb.append("    serviceTestSpecification: ").append(toIndentedString(serviceTestSpecification)).append("\n");
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
