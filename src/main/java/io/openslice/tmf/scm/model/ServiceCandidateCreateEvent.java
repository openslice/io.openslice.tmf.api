package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.ServiceCandidate;
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

public class ServiceCandidateCreateEvent   {
  @JsonProperty("serviceCandidate")
  private ServiceCandidate serviceCandidate = null;

  public ServiceCandidateCreateEvent serviceCandidate(ServiceCandidate serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return serviceCandidate
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ServiceCandidate getServiceCandidate() {
    return serviceCandidate;
  }

  public void setServiceCandidate(ServiceCandidate serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCandidateCreateEvent serviceCandidateCreateEvent = (ServiceCandidateCreateEvent) o;
    return Objects.equals(this.serviceCandidate, serviceCandidateCreateEvent.serviceCandidate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceCandidate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCandidateCreateEvent {\n");
    
    sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
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

