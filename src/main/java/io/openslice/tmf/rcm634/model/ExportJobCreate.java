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

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a task used to export resources to a file Skipped properties: id,href
 */
@Schema(description = "Represents a task used to export resources to a file Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
public class ExportJobCreate   {
  @JsonProperty("completionDate")
  private OffsetDateTime completionDate = null;

  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("errorLog")
  private String errorLog = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("query")
  private String query = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("status")
  private JobStateType status = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public ExportJobCreate completionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
    return this;
  }

  /**
   * Data at which the job was completed
   * @return completionDate
  **/
  @Schema(description = "Data at which the job was completed")
  
    @Valid
    public OffsetDateTime getCompletionDate() {
    return completionDate;
  }

  public void setCompletionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
  }

  public ExportJobCreate contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * The format of the exported data
   * @return contentType
  **/
  @Schema(description = "The format of the exported data")
  
    public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ExportJobCreate creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Date at which the job was created
   * @return creationDate
  **/
  @Schema(description = "Date at which the job was created")
  
    @Valid
    public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public ExportJobCreate errorLog(String errorLog) {
    this.errorLog = errorLog;
    return this;
  }

  /**
   * Reason for failure
   * @return errorLog
  **/
  @Schema(description = "Reason for failure")
  
    public String getErrorLog() {
    return errorLog;
  }

  public void setErrorLog(String errorLog) {
    this.errorLog = errorLog;
  }

  public ExportJobCreate path(String path) {
    this.path = path;
    return this;
  }

  /**
   * URL of the root resource acting as the source for streaming content to the file specified by the export job
   * @return path
  **/
  @Schema(description = "URL of the root resource acting as the source for streaming content to the file specified by the export job")
  
    public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ExportJobCreate query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Used to scope the exported data
   * @return query
  **/
  @Schema(description = "Used to scope the exported data")
  
    public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public ExportJobCreate url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL of the file containing the data to be exported
   * @return url
  **/
  @Schema(description = "URL of the file containing the data to be exported")
      @NotNull

    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ExportJobCreate status(JobStateType status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  
    @Valid
    public JobStateType getStatus() {
    return status;
  }

  public void setStatus(JobStateType status) {
    this.status = status;
  }

  public ExportJobCreate _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public ExportJobCreate _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public ExportJobCreate _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExportJobCreate exportJobCreate = (ExportJobCreate) o;
    return Objects.equals(this.completionDate, exportJobCreate.completionDate) &&
        Objects.equals(this.contentType, exportJobCreate.contentType) &&
        Objects.equals(this.creationDate, exportJobCreate.creationDate) &&
        Objects.equals(this.errorLog, exportJobCreate.errorLog) &&
        Objects.equals(this.path, exportJobCreate.path) &&
        Objects.equals(this.query, exportJobCreate.query) &&
        Objects.equals(this.url, exportJobCreate.url) &&
        Objects.equals(this.status, exportJobCreate.status) &&
        Objects.equals(this._atBaseType, exportJobCreate._atBaseType) &&
        Objects.equals(this._atSchemaLocation, exportJobCreate._atSchemaLocation) &&
        Objects.equals(this._atType, exportJobCreate._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completionDate, contentType, creationDate, errorLog, path, query, url, status, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExportJobCreate {\n");
    
    sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    errorLog: ").append(toIndentedString(errorLog)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
