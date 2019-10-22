package io.openslice.tmf.scm633.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceCandidate is an entity that makes a service specification available to a catalog. A ServiceCandidate and its associated service specification may be published - made visible - in any number of service catalogs, or in none. One service specification can be composed of other service specifications. Skipped properties: id,href
 */
@ApiModel(description = "ServiceCandidate is an entity that makes a service specification available to a catalog. A ServiceCandidate and its associated service specification may be published - made visible - in any number of service catalogs, or in none. One service specification can be composed of other service specifications. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCandidateCreate extends ServiceCandidateUpdate  {
  
  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  
  /**
   * Date and time of the last update of this REST resource
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update of this REST resource")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCandidateCreate serviceCandidateCreate = (ServiceCandidateCreate) o;
    return Objects.equals(this.description, serviceCandidateCreate.description) &&
        Objects.equals(this.lastUpdate, serviceCandidateCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceCandidateCreate.lifecycleStatus) &&
        Objects.equals(this.name, serviceCandidateCreate.name) &&
        Objects.equals(this.version, serviceCandidateCreate.version) &&
        Objects.equals(this.category, serviceCandidateCreate.category) &&
        Objects.equals(this.serviceSpecification, serviceCandidateCreate.serviceSpecification) &&
        Objects.equals(this.validFor, serviceCandidateCreate.validFor) &&
        Objects.equals(this.baseType, serviceCandidateCreate.baseType) &&
        Objects.equals(this.schemaLocation, serviceCandidateCreate.schemaLocation) &&
        Objects.equals(this.type, serviceCandidateCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, lastUpdate, lifecycleStatus, name, version, category, serviceSpecification, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCandidateCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

