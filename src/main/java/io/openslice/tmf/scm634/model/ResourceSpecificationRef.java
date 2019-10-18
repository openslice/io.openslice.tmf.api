package io.openslice.tmf.scm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Resource Specification reference: The ResourceSpecification is required to realize a ProductSpecification.
 */
@ApiModel(description = "Resource Specification reference: The ResourceSpecification is required to realize a ProductSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceSpecificationRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  public ResourceSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the resource specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the resource specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceSpecificationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the resource specification
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the resource specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the requiredResourceSpecification
   * @return name
  **/
  @ApiModelProperty(value = "Name of the requiredResourceSpecification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecificationRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Resource specification version
   * @return version
  **/
  @ApiModelProperty(value = "Resource specification version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceSpecificationRef resourceSpecificationRef = (ResourceSpecificationRef) o;
    return Objects.equals(this.id, resourceSpecificationRef.id) &&
        Objects.equals(this.href, resourceSpecificationRef.href) &&
        Objects.equals(this.name, resourceSpecificationRef.name) &&
        Objects.equals(this.version, resourceSpecificationRef.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecificationRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

