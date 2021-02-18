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
public class ServiceTestSpecificationCreateEventPayload   {
  @JsonProperty("serviceTestSpecification")
  private ServiceTestSpecification serviceTestSpecification = null;

  public ServiceTestSpecificationCreateEventPayload serviceTestSpecification(ServiceTestSpecification serviceTestSpecification) {
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
    ServiceTestSpecificationCreateEventPayload serviceTestSpecificationCreateEventPayload = (ServiceTestSpecificationCreateEventPayload) o;
    return Objects.equals(this.serviceTestSpecification, serviceTestSpecificationCreateEventPayload.serviceTestSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceTestSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecificationCreateEventPayload {\n");
    
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
