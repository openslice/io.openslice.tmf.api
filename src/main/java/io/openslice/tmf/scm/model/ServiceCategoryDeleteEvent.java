package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.ServiceCategory;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCategoryDeleteEvent   {
  @JsonProperty("serviceCategory")
  private ServiceCategory serviceCategory = null;

  public ServiceCategoryDeleteEvent serviceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return serviceCategory
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ServiceCategory getServiceCategory() {
    return serviceCategory;
  }

  public void setServiceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCategoryDeleteEvent serviceCategoryDeleteEvent = (ServiceCategoryDeleteEvent) o;
    return Objects.equals(this.serviceCategory, serviceCategoryDeleteEvent.serviceCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceCategory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCategoryDeleteEvent {\n");
    
    sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory)).append("\n");
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

