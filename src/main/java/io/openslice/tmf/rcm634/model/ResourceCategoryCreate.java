/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.rcm634.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href
 */
@ApiModel(description = "The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

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

