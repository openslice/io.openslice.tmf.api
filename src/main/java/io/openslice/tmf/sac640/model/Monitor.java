package io.openslice.tmf.sac640.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.sac640.model.Request;
import io.openslice.tmf.sac640.model.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Monitoring of resources
 */
@ApiModel(description = "Monitoring of resources")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
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
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public Monitor id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of an instance of the monitor. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type
   * @return id
  **/
  @ApiModelProperty(value = "Identifier of an instance of the monitor. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type")
  
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
  @ApiModelProperty(value = "reference to this monitor")
  
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
  @ApiModelProperty(value = "The monitored resource href")
  
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
  @ApiModelProperty(value = "The Monitor state of the resource.  InProgress, InError, Completed")
  
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
  @ApiModelProperty(value = "")
  
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
  @ApiModelProperty(value = "")
  
    @Valid
    public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public Monitor _atBaseType(String _atBaseType) {
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

  public Monitor _atSchemaLocation(String _atSchemaLocation) {
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

  public Monitor _atType(String _atType) {
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
    Monitor monitor = (Monitor) o;
    return Objects.equals(this.id, monitor.id) &&
        Objects.equals(this.href, monitor.href) &&
        Objects.equals(this.sourceHref, monitor.sourceHref) &&
        Objects.equals(this.state, monitor.state) &&
        Objects.equals(this.request, monitor.request) &&
        Objects.equals(this.response, monitor.response) &&
        Objects.equals(this._atBaseType, monitor._atBaseType) &&
        Objects.equals(this._atSchemaLocation, monitor._atSchemaLocation) &&
        Objects.equals(this._atType, monitor._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, sourceHref, state, request, response, _atBaseType, _atSchemaLocation, _atType);
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
