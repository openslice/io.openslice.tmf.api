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
 * Complements the description of an element (for instance a product) through video, pictures...
 */
@ApiModel(description = "Complements the description of an element (for instance a product) through video, pictures...")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class Attachment   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("url")
  private String url = null;

  public Attachment description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative text describing the content of the attachment
   * @return description
  **/
  @ApiModelProperty(value = "A narrative text describing the content of the attachment")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Attachment href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the attachment
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the attachment")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Attachment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the attachment
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the attachment")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Attachment type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Attachment type such as video, picture
   * @return type
  **/
  @ApiModelProperty(value = "Attachment type such as video, picture")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Attachment url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Uniform Resource Locator, is a web page address (a subset of URI)
   * @return url
  **/
  @ApiModelProperty(value = "Uniform Resource Locator, is a web page address (a subset of URI)")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.description, attachment.description) &&
        Objects.equals(this.href, attachment.href) &&
        Objects.equals(this.id, attachment.id) &&
        Objects.equals(this.type, attachment.type) &&
        Objects.equals(this.url, attachment.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, type, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

