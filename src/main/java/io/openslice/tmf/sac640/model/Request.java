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
package io.openslice.tmf.sac640.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A response to a request
 */
@Schema(description = "A response to a request")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
public class Request   {
  @JsonProperty("body")
  private String body = null;

  @JsonProperty("method")
  private String method = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("header")
  @Valid
  private List<HeaderItem> header = new ArrayList<>();

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Request body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The body of the request. For example for an HTTP request might contain content of a form .
   * @return body
  **/
  @Schema(description = "The body of the request. For example for an HTTP request might contain content of a form .")
      @NotNull

    public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Request method(String method) {
    this.method = method;
    return this;
  }

  /**
   * The protocol of the request, e.g. http
   * @return method
  **/
  @Schema(description = "The protocol of the request, e.g. http")
  
    public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public Request to(String to) {
    this.to = to;
    return this;
  }

  /**
   * The target of the request, e.g. a URL for an HTTP request
   * @return to
  **/
  @Schema(description = "The target of the request, e.g. a URL for an HTTP request")
  
    public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Request header(List<HeaderItem> header) {
    this.header = header;
    return this;
  }

  public Request addHeaderItem(HeaderItem headerItem) {
    this.header.add(headerItem);
    return this;
  }

  /**
   * Items included in the header of the request. For example for an HTTP request might contain requested locale, basic authentication.
   * @return header
  **/
  @Schema(description = "Items included in the header of the request. For example for an HTTP request might contain requested locale, basic authentication.")
      @NotNull
    @Valid
  @Size(min=1)   public List<HeaderItem> getHeader() {
    return header;
  }

  public void setHeader(List<HeaderItem> header) {
    this.header = header;
  }

  public Request baseType(String baseType) {
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

  public Request schemaLocation(String schemaLocation) {
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

  public Request type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Request request = (Request) o;
    return Objects.equals(this.body, request.body) &&
        Objects.equals(this.method, request.method) &&
        Objects.equals(this.to, request.to) &&
        Objects.equals(this.header, request.header) &&
        Objects.equals(this.baseType, request.baseType) &&
        Objects.equals(this.schemaLocation, request.schemaLocation) &&
        Objects.equals(this.type, request.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, method, to, header, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
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
