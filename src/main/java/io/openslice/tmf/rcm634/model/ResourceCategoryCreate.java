package io.openslice.tmf.rcm634.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href
 */
@ApiModel(description = "The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceCategoryCreate  extends ResourceCategoryUpdate {
  
  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;


  public ResourceCategoryCreate name(String name) {
    this.name = name;
    return this;
  }


  public ResourceCategoryCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update")

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
    ResourceCategoryCreate resourceCategoryCreate = (ResourceCategoryCreate) o;
    return Objects.equals(this.name, resourceCategoryCreate.name) &&
        Objects.equals(this.description, resourceCategoryCreate.description) &&
        Objects.equals(this.type, resourceCategoryCreate.type) &&
        Objects.equals(this.schemalLocation, resourceCategoryCreate.schemalLocation) &&
        Objects.equals(this.baseType, resourceCategoryCreate.baseType) &&
        Objects.equals(this.version, resourceCategoryCreate.version) &&
        Objects.equals(this.validFor, resourceCategoryCreate.validFor) &&
        Objects.equals(this.lifecycleStatus, resourceCategoryCreate.lifecycleStatus) &&
        Objects.equals(this.lastUpdate, resourceCategoryCreate.lastUpdate) &&
        Objects.equals(this.parentId, resourceCategoryCreate.parentId) &&
        Objects.equals(this.isRoot, resourceCategoryCreate.isRoot) &&
        Objects.equals(this.category, resourceCategoryCreate.category) &&
        Objects.equals(this.resourceCandidate, resourceCategoryCreate.resourceCandidate) &&
        Objects.equals(this.relatedParty, resourceCategoryCreate.relatedParty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemalLocation, baseType, version, validFor, lifecycleStatus, lastUpdate, parentId, isRoot, category, resourceCandidate, relatedParty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategoryCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemalLocation: ").append(toIndentedString(schemalLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    resourceCandidate: ").append(toIndentedString(resourceCandidate)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

