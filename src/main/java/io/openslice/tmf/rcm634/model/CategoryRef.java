package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Category reference. The category resource is used to group product offerings, service and resource candidates in logical containers. Categories can contain other categories and/or product offerings, resource or service candidates.
 */
@ApiModel(description = "Category reference. The category resource is used to group product offerings, service and resource candidates in logical containers. Categories can contain other categories and/or product offerings, resource or service candidates.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class CategoryRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("name")
  private String name = null;

  public CategoryRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique reference of the category
   * @return id
  **/
  @ApiModelProperty(value = "Unique reference of the category")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CategoryRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the category
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the category")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CategoryRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Category version
   * @return version
  **/
  @ApiModelProperty(value = "Category version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public CategoryRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the category
   * @return name
  **/
  @ApiModelProperty(value = "Name of the category")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRef categoryRef = (CategoryRef) o;
    return Objects.equals(this.id, categoryRef.id) &&
        Objects.equals(this.href, categoryRef.href) &&
        Objects.equals(this.version, categoryRef.version) &&
        Objects.equals(this.name, categoryRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, version, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

