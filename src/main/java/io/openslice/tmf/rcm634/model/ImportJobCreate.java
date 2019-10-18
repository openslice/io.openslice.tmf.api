package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents a task used to import resources from a file Skipped properties: id,href
 */
@ApiModel(description = "Represents a task used to import resources from a file Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ImportJobCreate   {
  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("completionDate")
  private OffsetDateTime completionDate = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("errorLog")
  private String errorLog = null;

  public ImportJobCreate contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Indicates the format of the imported data
   * @return contentType
  **/
  @ApiModelProperty(value = "Indicates the format of the imported data")


  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ImportJobCreate path(String path) {
    this.path = path;
    return this;
  }

  /**
   * URL of the root resource where the content of the file specified by the import job must be applied
   * @return path
  **/
  @ApiModelProperty(value = "URL of the root resource where the content of the file specified by the import job must be applied")


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ImportJobCreate status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the import job (not started, running, succeeded, failed)
   * @return status
  **/
  @ApiModelProperty(value = "Status of the import job (not started, running, succeeded, failed)")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ImportJobCreate url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL of the file containing the data to be imported
   * @return url
  **/
  @ApiModelProperty(required = true, value = "URL of the file containing the data to be imported")
  @NotNull


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ImportJobCreate completionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
    return this;
  }

  /**
   * Date at which the job was completed
   * @return completionDate
  **/
  @ApiModelProperty(value = "Date at which the job was completed")

  @Valid

  public OffsetDateTime getCompletionDate() {
    return completionDate;
  }

  public void setCompletionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
  }

  public ImportJobCreate creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Date at which the job was created
   * @return creationDate
  **/
  @ApiModelProperty(value = "Date at which the job was created")

  @Valid

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public ImportJobCreate errorLog(String errorLog) {
    this.errorLog = errorLog;
    return this;
  }

  /**
   * Reason for failure if status is failed
   * @return errorLog
  **/
  @ApiModelProperty(value = "Reason for failure if status is failed")


  public String getErrorLog() {
    return errorLog;
  }

  public void setErrorLog(String errorLog) {
    this.errorLog = errorLog;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportJobCreate importJobCreate = (ImportJobCreate) o;
    return Objects.equals(this.contentType, importJobCreate.contentType) &&
        Objects.equals(this.path, importJobCreate.path) &&
        Objects.equals(this.status, importJobCreate.status) &&
        Objects.equals(this.url, importJobCreate.url) &&
        Objects.equals(this.completionDate, importJobCreate.completionDate) &&
        Objects.equals(this.creationDate, importJobCreate.creationDate) &&
        Objects.equals(this.errorLog, importJobCreate.errorLog);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, path, status, url, completionDate, creationDate, errorLog);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportJobCreate {\n");
    
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    errorLog: ").append(toIndentedString(errorLog)).append("\n");
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

