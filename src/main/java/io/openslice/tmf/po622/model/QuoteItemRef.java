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
 * It&#x27;s a Quote item that has been executed previously.
 */
@Schema(description = "It's a Quote item that has been executed previously.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class QuoteItemRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("quoteHref")
  private String quoteHref = null;

  @JsonProperty("quoteId")
  private String quoteId = null;

  @JsonProperty("quoteName")
  private String quoteName = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public QuoteItemRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of an item of a quote
   * @return id
  **/
  @Schema(description = "Id of an item of a quote")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public QuoteItemRef href(String href) {
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

  public QuoteItemRef name(String name) {
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

  public QuoteItemRef quoteHref(String quoteHref) {
    this.quoteHref = quoteHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return quoteHref
  **/
  @Schema(description = "Reference of the related entity.")
  
    public String getQuoteHref() {
    return quoteHref;
  }

  public void setQuoteHref(String quoteHref) {
    this.quoteHref = quoteHref;
  }

  public QuoteItemRef quoteId(String quoteId) {
    this.quoteId = quoteId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return quoteId
  **/
  @Schema(description = "Unique identifier of a related entity.")
      @NotNull

    public String getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }

  public QuoteItemRef quoteName(String quoteName) {
    this.quoteName = quoteName;
    return this;
  }

  /**
   * Name of the related entity.
   * @return quoteName
  **/
  @Schema(description = "Name of the related entity.")
  
    public String getQuoteName() {
    return quoteName;
  }

  public void setQuoteName(String quoteName) {
    this.quoteName = quoteName;
  }

  public QuoteItemRef baseType(String baseType) {
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

  public QuoteItemRef schemaLocation(String schemaLocation) {
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

  public QuoteItemRef type(String type) {
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

  public QuoteItemRef _atReferredType(String _atReferredType) {
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
    QuoteItemRef quoteItemRef = (QuoteItemRef) o;
    return Objects.equals(this.id, quoteItemRef.id) &&
        Objects.equals(this.href, quoteItemRef.href) &&
        Objects.equals(this.name, quoteItemRef.name) &&
        Objects.equals(this.quoteHref, quoteItemRef.quoteHref) &&
        Objects.equals(this.quoteId, quoteItemRef.quoteId) &&
        Objects.equals(this.quoteName, quoteItemRef.quoteName) &&
        Objects.equals(this.baseType, quoteItemRef.baseType) &&
        Objects.equals(this.schemaLocation, quoteItemRef.schemaLocation) &&
        Objects.equals(this.type, quoteItemRef.type) &&
        Objects.equals(this._atReferredType, quoteItemRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, quoteHref, quoteId, quoteName, baseType, schemaLocation, type, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteItemRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quoteHref: ").append(toIndentedString(quoteHref)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
    sb.append("    quoteName: ").append(toIndentedString(quoteName)).append("\n");
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
