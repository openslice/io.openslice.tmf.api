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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Monitoring of resources
 */
@Schema(description = "Monitoring of resources")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
public class Monitor   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("sourceHref")
  private String sourceHref = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("request")
  private Request request = null;

  @JsonProperty("response")
  private Response response = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Monitor id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of an instance of the monitor. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type
   * @return id
  **/
  @Schema(description = "Identifier of an instance of the monitor. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Monitor href(String href) {
    this.href = href;
    return this;
  }

  /**
   * reference to this monitor
   * @return href
  **/
  @Schema(description = "reference to this monitor")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Monitor sourceHref(String sourceHref) {
    this.sourceHref = sourceHref;
    return this;
  }

  /**
   * The monitored resource href
   * @return sourceHref
  **/
  @Schema(description = "The monitored resource href")
  
    public String getSourceHref() {
    return sourceHref;
  }

  public void setSourceHref(String sourceHref) {
    this.sourceHref = sourceHref;
  }

  public Monitor state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The Monitor state of the resource.  InProgress, InError, Completed
   * @return state
  **/
  @Schema(description = "The Monitor state of the resource.  InProgress, InError, Completed")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Monitor request(Request request) {
    this.request = request;
    return this;
  }

  /**
   * Get request
   * @return request
  **/
  @Schema(description = "")
  
    @Valid
    public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public Monitor response(Response response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
  **/
  @Schema(description = "")
  
    @Valid
    public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public Monitor baseType(String baseType) {
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

  public Monitor schemaLocation(String schemaLocation) {
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

  public Monitor type(String type) {
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
    Monitor monitor = (Monitor) o;
    return Objects.equals(this.id, monitor.id) &&
        Objects.equals(this.href, monitor.href) &&
        Objects.equals(this.sourceHref, monitor.sourceHref) &&
        Objects.equals(this.state, monitor.state) &&
        Objects.equals(this.request, monitor.request) &&
        Objects.equals(this.response, monitor.response) &&
        Objects.equals(this.baseType, monitor.baseType) &&
        Objects.equals(this.schemaLocation, monitor.schemaLocation) &&
        Objects.equals(this.type, monitor.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, sourceHref, state, request, response, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Monitor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    sourceHref: ").append(toIndentedString(sourceHref)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
