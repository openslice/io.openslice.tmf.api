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
package io.openslice.tmf.po622.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * It&#x27;s a productOfferingQualification item that has been executed previously.
 */
@Schema(description = "It's a productOfferingQualification item that has been executed previously.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class ProductOfferingQualificationItemRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("productOfferingQualificationHref")
  private String productOfferingQualificationHref = null;

  @JsonProperty("productOfferingQualificationId")
  private String productOfferingQualificationId = null;

  @JsonProperty("productOfferingQualificationName")
  private String productOfferingQualificationName = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public ProductOfferingQualificationItemRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of an item of a product offering qualification
   * @return id
  **/
  @Schema(description = "Id of an item of a product offering qualification")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingQualificationItemRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return href
  **/
  @Schema(description = "Reference of the related entity.")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOfferingQualificationItemRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
  **/
  @Schema(description = "Name of the related entity.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductOfferingQualificationItemRef productOfferingQualificationHref(String productOfferingQualificationHref) {
    this.productOfferingQualificationHref = productOfferingQualificationHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return productOfferingQualificationHref
  **/
  @Schema(description = "Reference of the related entity.")
  
    public String getProductOfferingQualificationHref() {
    return productOfferingQualificationHref;
  }

  public void setProductOfferingQualificationHref(String productOfferingQualificationHref) {
    this.productOfferingQualificationHref = productOfferingQualificationHref;
  }

  public ProductOfferingQualificationItemRef productOfferingQualificationId(String productOfferingQualificationId) {
    this.productOfferingQualificationId = productOfferingQualificationId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return productOfferingQualificationId
  **/
  @Schema(description = "Unique identifier of a related entity.")
      @NotNull

    public String getProductOfferingQualificationId() {
    return productOfferingQualificationId;
  }

  public void setProductOfferingQualificationId(String productOfferingQualificationId) {
    this.productOfferingQualificationId = productOfferingQualificationId;
  }

  public ProductOfferingQualificationItemRef productOfferingQualificationName(String productOfferingQualificationName) {
    this.productOfferingQualificationName = productOfferingQualificationName;
    return this;
  }

  /**
   * Name of the related entity.
   * @return productOfferingQualificationName
  **/
  @Schema(description = "Name of the related entity.")
  
    public String getProductOfferingQualificationName() {
    return productOfferingQualificationName;
  }

  public void setProductOfferingQualificationName(String productOfferingQualificationName) {
    this.productOfferingQualificationName = productOfferingQualificationName;
  }

  public ProductOfferingQualificationItemRef baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ProductOfferingQualificationItemRef schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ProductOfferingQualificationItemRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String type) {
    this.type = type;
  }

  public ProductOfferingQualificationItemRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @Schema(description = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingQualificationItemRef productOfferingQualificationItemRef = (ProductOfferingQualificationItemRef) o;
    return Objects.equals(this.id, productOfferingQualificationItemRef.id) &&
        Objects.equals(this.href, productOfferingQualificationItemRef.href) &&
        Objects.equals(this.name, productOfferingQualificationItemRef.name) &&
        Objects.equals(this.productOfferingQualificationHref, productOfferingQualificationItemRef.productOfferingQualificationHref) &&
        Objects.equals(this.productOfferingQualificationId, productOfferingQualificationItemRef.productOfferingQualificationId) &&
        Objects.equals(this.productOfferingQualificationName, productOfferingQualificationItemRef.productOfferingQualificationName) &&
        Objects.equals(this.baseType, productOfferingQualificationItemRef.baseType) &&
        Objects.equals(this.schemaLocation, productOfferingQualificationItemRef.schemaLocation) &&
        Objects.equals(this.type, productOfferingQualificationItemRef.type) &&
        Objects.equals(this._atReferredType, productOfferingQualificationItemRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, productOfferingQualificationHref, productOfferingQualificationId, productOfferingQualificationName, baseType, schemaLocation, type, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingQualificationItemRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productOfferingQualificationHref: ").append(toIndentedString(productOfferingQualificationHref)).append("\n");
    sb.append("    productOfferingQualificationId: ").append(toIndentedString(productOfferingQualificationId)).append("\n");
    sb.append("    productOfferingQualificationName: ").append(toIndentedString(productOfferingQualificationName)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
