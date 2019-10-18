package io.openslice.tmf.pcm620.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.pcm620.model.Quantity;
import io.openslice.tmf.pcm620.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An attachment by value or by reference. For AttachmentRefOrValue, the attribute type,schemaLocation and referredType are related to the contained entity and not to AttchmentRefOrValue itself
 */
@ApiModel(description = "An attachment by value or by reference. For AttachmentRefOrValue, the attribute type,schemaLocation and referredType are related to the contained entity and not to AttchmentRefOrValue itself")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class AttachmentRefOrValue   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("attachmentType")
  private String attachmentType = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("size")
  private Quantity size = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public AttachmentRefOrValue id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for this particular attachment
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for this particular attachment")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AttachmentRefOrValue href(String href) {
    this.href = href;
    return this;
  }

  /**
   * URI for this Attachment
   * @return href
  **/
  @ApiModelProperty(value = "URI for this Attachment")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AttachmentRefOrValue attachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
    return this;
  }

  /**
   * Attachment type such as video, picture
   * @return attachmentType
  **/
  @ApiModelProperty(value = "Attachment type such as video, picture")


  public String getAttachmentType() {
    return attachmentType;
  }

  public void setAttachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
  }

  public AttachmentRefOrValue content(String content) {
    this.content = content;
    return this;
  }

  /**
   * The actual contents of the attachment object, if embedded, encoded as base64
   * @return content
  **/
  @ApiModelProperty(value = "The actual contents of the attachment object, if embedded, encoded as base64")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public AttachmentRefOrValue description(String description) {
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

  public AttachmentRefOrValue mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * Attachment mime type such as extension file for video, picture and document
   * @return mimeType
  **/
  @ApiModelProperty(value = "Attachment mime type such as extension file for video, picture and document")


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public AttachmentRefOrValue name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the attachment
   * @return name
  **/
  @ApiModelProperty(value = "The name of the attachment")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AttachmentRefOrValue url(String url) {
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

  public AttachmentRefOrValue size(Quantity size) {
    this.size = size;
    return this;
  }

  /**
   * The size of the attachment.
   * @return size
  **/
  @ApiModelProperty(value = "The size of the attachment.")

  @Valid

  public Quantity getSize() {
    return size;
  }

  public void setSize(Quantity size) {
    this.size = size;
  }

  public AttachmentRefOrValue validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time for which the attachment is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time for which the attachment is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public AttachmentRefOrValue baseType(String baseType) {
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

  public AttachmentRefOrValue schemaLocation(String schemaLocation) {
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

  public AttachmentRefOrValue type(String type) {
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

  public AttachmentRefOrValue referredType(String referredType) {
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
    AttachmentRefOrValue attachmentRefOrValue = (AttachmentRefOrValue) o;
    return Objects.equals(this.id, attachmentRefOrValue.id) &&
        Objects.equals(this.href, attachmentRefOrValue.href) &&
        Objects.equals(this.attachmentType, attachmentRefOrValue.attachmentType) &&
        Objects.equals(this.content, attachmentRefOrValue.content) &&
        Objects.equals(this.description, attachmentRefOrValue.description) &&
        Objects.equals(this.mimeType, attachmentRefOrValue.mimeType) &&
        Objects.equals(this.name, attachmentRefOrValue.name) &&
        Objects.equals(this.url, attachmentRefOrValue.url) &&
        Objects.equals(this.size, attachmentRefOrValue.size) &&
        Objects.equals(this.validFor, attachmentRefOrValue.validFor) &&
        Objects.equals(this.baseType, attachmentRefOrValue.baseType) &&
        Objects.equals(this.schemaLocation, attachmentRefOrValue.schemaLocation) &&
        Objects.equals(this.type, attachmentRefOrValue.type) &&
        Objects.equals(this.referredType, attachmentRefOrValue.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, attachmentType, content, description, mimeType, name, url, size, validFor, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentRefOrValue {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    attachmentType: ").append(toIndentedString(attachmentType)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

