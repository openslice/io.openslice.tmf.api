package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The service test specification used by the service test.
 */
@ApiModel(description = "The service test specification used by the service test.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestSpecificationRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public ServiceTestSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of a service test specification.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Identifier of a service test specification.")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceTestSpecificationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access a service test specification.
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink to access a service test specification.")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceTestSpecificationRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Version of a service test specification 
   * @return version
  **/
  @ApiModelProperty(value = "Version of a service test specification ")
  
    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ServiceTestSpecificationRef _atBaseType(String _atBaseType) {
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

  public ServiceTestSpecificationRef _atSchemaLocation(String _atSchemaLocation) {
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

  public ServiceTestSpecificationRef _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }

  public ServiceTestSpecificationRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")
  
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
    ServiceTestSpecificationRef serviceTestSpecificationRef = (ServiceTestSpecificationRef) o;
    return Objects.equals(this.id, serviceTestSpecificationRef.id) &&
        Objects.equals(this.href, serviceTestSpecificationRef.href) &&
        Objects.equals(this.version, serviceTestSpecificationRef.version) &&
        Objects.equals(this._atBaseType, serviceTestSpecificationRef._atBaseType) &&
        Objects.equals(this._atSchemaLocation, serviceTestSpecificationRef._atSchemaLocation) &&
        Objects.equals(this._atType, serviceTestSpecificationRef._atType) &&
        Objects.equals(this._atReferredType, serviceTestSpecificationRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, version, _atBaseType, _atSchemaLocation, _atType, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecificationRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
