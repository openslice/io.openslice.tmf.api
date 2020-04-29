package io.openslice.tmf.sac640.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.sac640.model.HeaderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A response to a request
 */
@ApiModel(description = "A response to a request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
public class Response   {
  @JsonProperty("body")
  private String body = null;

  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("header")
  @Valid
  private List<HeaderItem> header = new ArrayList<>();

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public Response body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The body of the response. For example for an HTTP response might contain HTML for rendering.
   * @return body
  **/
  @ApiModelProperty(required = true, value = "The body of the response. For example for an HTTP response might contain HTML for rendering.")
      @NotNull

    public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Response statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * The status of the response. For example for an HTTP response would be codes such as 200, 400, etc.
   * @return statusCode
  **/
  @ApiModelProperty(value = "The status of the response. For example for an HTTP response would be codes such as 200, 400, etc.")
  
    public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public Response header(List<HeaderItem> header) {
    this.header = header;
    return this;
  }

  public Response addHeaderItem(HeaderItem headerItem) {
    this.header.add(headerItem);
    return this;
  }

  /**
   * Items included in the header of the response. For example for an HTTP response might contain negotiated locale.
   * @return header
  **/
  @ApiModelProperty(required = true, value = "Items included in the header of the response. For example for an HTTP response might contain negotiated locale.")
      @NotNull
    @Valid
  @Size(min=1)   public List<HeaderItem> getHeader() {
    return header;
  }

  public void setHeader(List<HeaderItem> header) {
    this.header = header;
  }

  public Response _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public Response _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public Response _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")
  
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
    Response response = (Response) o;
    return Objects.equals(this.body, response.body) &&
        Objects.equals(this.statusCode, response.statusCode) &&
        Objects.equals(this.header, response.header) &&
        Objects.equals(this._atBaseType, response._atBaseType) &&
        Objects.equals(this._atSchemaLocation, response._atSchemaLocation) &&
        Objects.equals(this._atType, response._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, statusCode, header, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
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
