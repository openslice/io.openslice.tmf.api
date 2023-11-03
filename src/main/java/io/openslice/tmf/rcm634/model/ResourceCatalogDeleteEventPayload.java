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
package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The event data structure
 */
@Schema(description = "The event data structure")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
public class ResourceCatalogDeleteEventPayload   {
  @JsonProperty("resourceCatalog")
  private ResourceCatalog resourceCatalog = null;

  public ResourceCatalogDeleteEventPayload resourceCatalog(ResourceCatalog resourceCatalog) {
    this.resourceCatalog = resourceCatalog;
    return this;
  }

  /**
   * Get resourceCatalog
   * @return resourceCatalog
  **/
  @Schema(description = "")
  
    @Valid
    public ResourceCatalog getResourceCatalog() {
    return resourceCatalog;
  }

  public void setResourceCatalog(ResourceCatalog resourceCatalog) {
    this.resourceCatalog = resourceCatalog;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceCatalogDeleteEventPayload resourceCatalogDeleteEventPayload = (ResourceCatalogDeleteEventPayload) o;
    return Objects.equals(this.resourceCatalog, resourceCatalogDeleteEventPayload.resourceCatalog);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceCatalog);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCatalogDeleteEventPayload {\n");
    
    sb.append("    resourceCatalog: ").append(toIndentedString(resourceCatalog)).append("\n");
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
