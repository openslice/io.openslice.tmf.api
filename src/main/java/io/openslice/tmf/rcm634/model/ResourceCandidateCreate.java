package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href
 */
@ApiModel(description = "ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceCandidateCreate extends ResourceCandidateUpdate   {
  
  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  

  public ResourceCandidateCreate name(String name) {
    this.name = name;
    return this;
  }

 

  public ResourceCandidateCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

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
    ResourceCandidateCreate resourceCandidateCreate = (ResourceCandidateCreate) o;
    return Objects.equals(this.name, resourceCandidateCreate.name) &&
        Objects.equals(this.description, resourceCandidateCreate.description) &&
        Objects.equals(this.type, resourceCandidateCreate.type) &&
        Objects.equals(this.schemaLocation, resourceCandidateCreate.schemaLocation) &&
        Objects.equals(this.baseType, resourceCandidateCreate.baseType) &&
        Objects.equals(this.version, resourceCandidateCreate.version) &&
        Objects.equals(this.validFor, resourceCandidateCreate.validFor) &&
        Objects.equals(this.lastUpdate, resourceCandidateCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCandidateCreate.lifecycleStatus) &&
        Objects.equals(this.category, resourceCandidateCreate.category) &&
        Objects.equals(this.resourceSpecification, resourceCandidateCreate.resourceSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate, lifecycleStatus, category, resourceSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCandidateCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
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

