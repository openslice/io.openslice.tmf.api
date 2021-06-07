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

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none.
 */
@ApiModel(description = "ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

public class ResourceCandidateRef  extends BaseRootNamedEntity {
	  @JsonProperty("id")
	  private String id = null;

	  @JsonProperty("href")
	  private String href = null;

	  @JsonProperty("version")
	  private String version = null;


	  public ResourceCandidateRef id(String id) {
	    this.id = id;
	    return this;
	  }

	  /**
	   * Unique identifier of the resource candidate
	   * @return id
	  **/
	  @ApiModelProperty(value = "Unique identifier of the resource candidate")


	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public ResourceCandidateRef href(String href) {
	    this.href = href;
	    return this;
	  }

	  /**
	   * Reference of the resource candidate
	   * @return href
	  **/
	  @ApiModelProperty(value = "Reference of the resource candidate")


	  public String getHref() {
	    return href;
	  }

	  public void setHref(String href) {
	    this.href = href;
	  }

	  public ResourceCandidateRef version(String version) {
	    this.version = version;
	    return this;
	  }

	  /**
	   * Version of the resource candidate
	   * @return version
	  **/
	  @ApiModelProperty(value = "Version of the resource candidate")


	  public String getVersion() {
	    return version;
	  }

	  public void setVersion(String version) {
	    this.version = version;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ResourceCandidateRef resourceCandidateRef = (ResourceCandidateRef) o;
	    return Objects.equals(this.id, resourceCandidateRef.id) &&
	        Objects.equals(this.href, resourceCandidateRef.href) &&
	        Objects.equals(this.version, resourceCandidateRef.version) &&
	        Objects.equals(this.name, resourceCandidateRef.name);
	  }
	//
	//  @Override
	//  public int hashCode() {
//	    return Objects.hash(uuid, id, href, version, name);
	//  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ResourceCandidateRef {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    href: ").append(toIndentedString(href)).append("\n");
	    sb.append("    version: ").append(toIndentedString(version)).append("\n");
	    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

