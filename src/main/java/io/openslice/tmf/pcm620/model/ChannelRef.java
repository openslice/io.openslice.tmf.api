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
package io.openslice.tmf.pcm620.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * The channel to which the resource reference to. e.g. channel for selling product offerings, channel for opening a trouble ticket etc..
 */
@Schema(description = "The channel to which the resource reference to. e.g. channel for selling product offerings, channel for opening a trouble ticket etc..")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ChannelRef")
public class ChannelRef extends BaseEntity {
  @JsonProperty("id")
  private String id = null;


  @JsonProperty("@referredType")
  private String referredType = null;


  /**
   * Unique identifier of a related entity.
   * @return id
  **/
  @Schema(description = "Unique identifier of a related entity.")
  @NotNull


  public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
  }


  public ChannelRef href(String href) {
    this.href = href;
    return this;
  }

  

  public ChannelRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return referredType
  **/
  @Schema(description = "The actual type of the target instance when needed for disambiguation.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelRef channelRef = (ChannelRef) o;
    return Objects.equals(this.id, channelRef.id) &&
        Objects.equals(this.href, channelRef.href) &&
        Objects.equals(this.name, channelRef.name) &&
        Objects.equals(this.baseType, channelRef.baseType) &&
        Objects.equals(this.schemaLocation, channelRef.schemaLocation) &&
        Objects.equals(this.type, channelRef.type) &&
        Objects.equals(this.referredType, channelRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

