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
package io.openslice.tmf.am666.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The structure of the bill for party accounts (billing or settlement).
 */
@ApiModel(description = "The structure of the bill for party accounts (billing or settlement).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class BillStructure   {
  @JsonProperty("cycleSpecification")
  private BillingCycleSpecificationRefOrValue cycleSpecification = null;

  @JsonProperty("format")
  private BillFormatRefOrValue format = null;

  @JsonProperty("presentationMedia")
  @Valid
  private List<BillPresentationMediaRefOrValue> presentationMedia = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public BillStructure cycleSpecification(BillingCycleSpecificationRefOrValue cycleSpecification) {
    this.cycleSpecification = cycleSpecification;
    return this;
  }

  /**
   * Get cycleSpecification
   * @return cycleSpecification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillingCycleSpecificationRefOrValue getCycleSpecification() {
    return cycleSpecification;
  }

  public void setCycleSpecification(BillingCycleSpecificationRefOrValue cycleSpecification) {
    this.cycleSpecification = cycleSpecification;
  }

  public BillStructure format(BillFormatRefOrValue format) {
    this.format = format;
    return this;
  }

  /**
   * Get format
   * @return format
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillFormatRefOrValue getFormat() {
    return format;
  }

  public void setFormat(BillFormatRefOrValue format) {
    this.format = format;
  }

  public BillStructure presentationMedia(List<BillPresentationMediaRefOrValue> presentationMedia) {
    this.presentationMedia = presentationMedia;
    return this;
  }

  public BillStructure addPresentationMediaItem(BillPresentationMediaRefOrValue presentationMediaItem) {
    if (this.presentationMedia == null) {
      this.presentationMedia = new ArrayList<>();
    }
    this.presentationMedia.add(presentationMediaItem);
    return this;
  }

  /**
   * Get presentationMedia
   * @return presentationMedia
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<BillPresentationMediaRefOrValue> getPresentationMedia() {
    return presentationMedia;
  }

  public void setPresentationMedia(List<BillPresentationMediaRefOrValue> presentationMedia) {
    this.presentationMedia = presentationMedia;
  }

  public BillStructure baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public BillStructure schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public BillStructure type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillStructure billStructure = (BillStructure) o;
    return Objects.equals(this.cycleSpecification, billStructure.cycleSpecification) &&
        Objects.equals(this.format, billStructure.format) &&
        Objects.equals(this.presentationMedia, billStructure.presentationMedia) &&
        Objects.equals(this.baseType, billStructure.baseType) &&
        Objects.equals(this.schemaLocation, billStructure.schemaLocation) &&
        Objects.equals(this.type, billStructure.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cycleSpecification, format, presentationMedia, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillStructure {\n");
    
    sb.append("    cycleSpecification: ").append(toIndentedString(cycleSpecification)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    presentationMedia: ").append(toIndentedString(presentationMedia)).append("\n");
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

