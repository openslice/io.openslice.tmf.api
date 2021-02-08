package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.ServiceTest;
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
public class ServiceTestDeleteEventPayload   {
  @JsonProperty("serviceTest")
  private ServiceTest serviceTest = null;

  public ServiceTestDeleteEventPayload serviceTest(ServiceTest serviceTest) {
    this.serviceTest = serviceTest;
    return this;
  }

  /**
   * Get serviceTest
   * @return serviceTest
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ServiceTest getServiceTest() {
    return serviceTest;
  }

  public void setServiceTest(ServiceTest serviceTest) {
    this.serviceTest = serviceTest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestDeleteEventPayload serviceTestDeleteEventPayload = (ServiceTestDeleteEventPayload) o;
    return Objects.equals(this.serviceTest, serviceTestDeleteEventPayload.serviceTest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceTest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestDeleteEventPayload {\n");
    
    sb.append("    serviceTest: ").append(toIndentedString(serviceTest)).append("\n");
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
