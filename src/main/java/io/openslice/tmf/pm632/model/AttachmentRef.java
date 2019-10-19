package io.openslice.tmf.pm632.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Attachment reference. An attachment complements the description of an element (for instance a product) through video, pictures
 */
@ApiModel(description = "Attachment reference. An attachment complements the description of an element (for instance a product) through video, pictures")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class AttachmentRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public AttachmentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique-Identifier for this attachment
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique-Identifier for this attachment")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AttachmentRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * URL serving as reference for the attachment resource
   * @return href
  **/
  @ApiModelProperty(value = "URL serving as reference for the attachment resource")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AttachmentRef description(String description) {
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

  public AttachmentRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the related entity.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AttachmentRef url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Link to the attachment media/content
   * @return url
  **/
  @ApiModelProperty(value = "Link to the attachment media/content")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public AttachmentRef baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public AttachmentRef schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public AttachmentRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AttachmentRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return referredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentRef attachmentRef = (AttachmentRef) o;
    return Objects.equals(this.id, attachmentRef.id) &&
        Objects.equals(this.href, attachmentRef.href) &&
        Objects.equals(this.description, attachmentRef.description) &&
        Objects.equals(this.name, attachmentRef.name) &&
        Objects.equals(this.url, attachmentRef.url) &&
        Objects.equals(this.baseType, attachmentRef.baseType) &&
        Objects.equals(this.schemaLocation, attachmentRef.schemaLocation) &&
        Objects.equals(this.type, attachmentRef.type) &&
        Objects.equals(this.referredType, attachmentRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, name, url, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

