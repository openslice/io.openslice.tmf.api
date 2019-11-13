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

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * applicable feature(s) for this resource specification.
 */
@ApiModel(description = "applicable feature(s) for this resource specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Entity(name = "Feature")
public class Feature extends BaseRootNamedEntity  {
  @JsonProperty("id")
  private String id = null;


  @JsonProperty("version")
  private String version = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("isEnabled")
  private Boolean isEnabled = null;

  public Feature id(String id) {
    this.id = id;
    return this;
  }

  /**
   * reference id to the feature. It is optional if the feature is not defined as a stand-alone object.
   * @return id
  **/
  @ApiModelProperty(value = "reference id to the feature. It is optional if the feature is not defined as a stand-alone object.")


  public String getId() {
    return uuid;
  }

  public Feature href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to the target feature. It is optional if the feature is not defined as a separate REST resource.
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to the target feature. It is optional if the feature is not defined as a separate REST resource.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Feature version(String version) {
    this.version = version;
    return this;
  }

  /**
   * feature version
   * @return version
  **/
  @ApiModelProperty(value = "feature version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Feature name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Unique name given to the feature. it is Required if the feature is not introduced as a separate REST resource
   * @return name
  **/
  @ApiModelProperty(value = "Unique name given to the feature. it is Required if the feature is not introduced as a separate REST resource")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Feature type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The optional (class) type of the feature
   * @return type
  **/
  @ApiModelProperty(value = "The optional (class) type of the feature")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Feature isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * A flag indicating if the feature is bundle (true) or not (false).
   * @return isBundle
  **/
  @ApiModelProperty(value = "A flag indicating if the feature is bundle (true) or not (false).")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public Feature validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which this relationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which this relationship is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Feature isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }

  /**
   * A flag indicating if the feature is enabled (true) or not (false).
   * @return isEnabled
  **/
  @ApiModelProperty(value = "A flag indicating if the feature is enabled (true) or not (false).")


  public Boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feature feature = (Feature) o;
    return Objects.equals(this.id, feature.id) &&
            Objects.equals(this.href, feature.href) &&
            Objects.equals(this.uuid, feature.uuid) &&
        Objects.equals(this.version, feature.version) &&
        Objects.equals(this.name, feature.name) &&
        Objects.equals(this.type, feature.type) &&
        Objects.equals(this.isBundle, feature.isBundle) &&
        Objects.equals(this.validFor, feature.validFor) &&
        Objects.equals(this.isEnabled, feature.isEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, id, href, version, name, type, isBundle, validFor, isEnabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
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

