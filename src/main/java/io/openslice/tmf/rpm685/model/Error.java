package io.openslice.tmf.rpm685.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Error
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class Error   {
  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("reason")
  private Integer reason = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("referenceError")
  private String referenceError = null;

  @JsonProperty("@type")
  private String _atType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Application related code.
   * @return code
  **/
  @Schema(description = "Application related code.")
      @NotNull

    public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Error reason(Integer reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Text that explains the reason for error.
   * @return reason
  **/
  @Schema(description = "Text that explains the reason for error.")
      @NotNull

    public Integer getReason() {
    return reason;
  }

  public void setReason(Integer reason) {
    this.reason = reason;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * (optional) Text that provide more details and corrective actions related to the error.
   * @return message
  **/
  @Schema(description = "(optional) Text that provide more details and corrective actions related to the error.")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * (optional) http error code extension like 400-2
   * @return status
  **/
  @Schema(description = "(optional) http error code extension like 400-2")
  
    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Error referenceError(String referenceError) {
    this.referenceError = referenceError;
    return this;
  }

  /**
   * (optional) A URL to online documentation that provides more information about the error.
   * @return referenceError
  **/
  @Schema(description = "(optional) A URL to online documentation that provides more information about the error.")
  
    public String getReferenceError() {
    return referenceError;
  }

  public void setReferenceError(String referenceError) {
    this.referenceError = referenceError;
  }

  public Error _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * (optional) The class type of a REST resource.
   * @return _atType
  **/
  @Schema(description = "(optional) The class type of a REST resource.")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }

  public Error _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * (optional) A link to the schema describing a REST resource.
   * @return _atSchemaLocation
  **/
  @Schema(description = "(optional) A link to the schema describing a REST resource.")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.reason, error.reason) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.referenceError, error.referenceError) &&
        Objects.equals(this._atType, error._atType) &&
        Objects.equals(this._atSchemaLocation, error._atSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, reason, message, status, referenceError, _atType, _atSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    referenceError: ").append(toIndentedString(referenceError)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
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
