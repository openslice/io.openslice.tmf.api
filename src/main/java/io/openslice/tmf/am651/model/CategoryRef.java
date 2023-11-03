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
package io.openslice.tmf.am651.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The category for grouping recommendations
 */
@Schema(description = "The category for grouping recommendations")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class CategoryRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public CategoryRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hypertext Reference of the category
   * @return href
  **/
  @Schema(description = "Hypertext Reference of the category")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CategoryRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of category
   * @return id
  **/
  @Schema(description = "Unique identifier of category")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CategoryRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the category.
   * @return name
  **/
  @Schema(description = "Name of the category.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryRef referredType(String referredType) {
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
    CategoryRef categoryRef = (CategoryRef) o;
    return Objects.equals(this.href, categoryRef.href) &&
        Objects.equals(this.id, categoryRef.id) &&
        Objects.equals(this.name, categoryRef.name) &&
        Objects.equals(this.referredType, categoryRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

