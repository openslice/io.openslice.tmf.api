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

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * provides references to the corresponding market segment as target of product offerings. A market segment is grouping of Parties, GeographicAreas, SalesChannels, and so forth.
 */
@ApiModel(description = "provides references to the corresponding market segment as target of product offerings. A market segment is grouping of Parties, GeographicAreas, SalesChannels, and so forth.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")
@Entity(name = "MarketSegmentRef")
public class MarketSegmentRef  extends BaseRootNamedEntity {
  @JsonProperty("id")
  private String id = null;


  @JsonProperty("@referredType")
  private String referredType = null;

  public MarketSegmentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the market segment
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the market segment")
  @NotNull


  public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
  }



  public MarketSegmentRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * (Class) type of the referred market segment
   * @return referredType
  **/
  @ApiModelProperty(value = "(Class) type of the referred market segment")


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
    MarketSegmentRef marketSegmentRef = (MarketSegmentRef) o;
    return Objects.equals(this.id, marketSegmentRef.id) &&
        Objects.equals(this.href, marketSegmentRef.href) &&
        Objects.equals(this.name, marketSegmentRef.name) &&
        Objects.equals(this.baseType, marketSegmentRef.baseType) &&
        Objects.equals(this.schemaLocation, marketSegmentRef.schemaLocation) &&
        Objects.equals(this.type, marketSegmentRef.type) &&
        Objects.equals(this.referredType, marketSegmentRef.referredType);
  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, name, baseType, schemaLocation, type, referredType);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarketSegmentRef {\n");
    
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

