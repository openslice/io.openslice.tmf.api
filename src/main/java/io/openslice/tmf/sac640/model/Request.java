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
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public Request body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The body of the request. For example for an HTTP request might contain content of a form .
   * @return body
  **/
  @ApiModelProperty(required = true, value = "The body of the request. For example for an HTTP request might contain content of a form .")
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
  @ApiModelProperty(value = "The protocol of the request, e.g. http")
  
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
  @ApiModelProperty(value = "The target of the request, e.g. a URL for an HTTP request")
  
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
  @ApiModelProperty(required = true, value = "Items included in the header of the request. For example for an HTTP request might contain requested locale, basic authentication.")
      @NotNull
    @Valid
  @Size(min=1)   public List<HeaderItem> getHeader() {
    return header;
  }

  public void setHeader(List<HeaderItem> header) {
    this.header = header;
  }

  public Request _atBaseType(String _atBaseType) {
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

  public Request _atSchemaLocation(String _atSchemaLocation) {
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

  public Request _atType(String _atType) {
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
    Request request = (Request) o;
    return Objects.equals(this.body, request.body) &&
        Objects.equals(this.method, request.method) &&
        Objects.equals(this.to, request.to) &&
        Objects.equals(this.header, request.header) &&
        Objects.equals(this._atBaseType, request._atBaseType) &&
        Objects.equals(this._atSchemaLocation, request._atSchemaLocation) &&
        Objects.equals(this._atType, request._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, method, to, header, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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
