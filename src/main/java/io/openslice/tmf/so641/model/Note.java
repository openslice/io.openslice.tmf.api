package io.openslice.tmf.so641.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Extra information about a given entity
 */
@ApiModel(description = "Extra information about a given entity")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

public class Note   {
  @JsonProperty("author")
  private String author = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("system")
  private String system = null;

  @JsonProperty("text")
  private String text = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Note author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Author of the note
   * @return author
  **/
  @ApiModelProperty(value = "Author of the note")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Note date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the note
   * @return date
  **/
  @ApiModelProperty(value = "Date of the note")

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Note system(String system) {
    this.system = system;
    return this;
  }

  /**
   * Describes the system from which the action related to this note was done
   * @return system
  **/
  @ApiModelProperty(value = "Describes the system from which the action related to this note was done")


  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public Note text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Text of the note
   * @return text
  **/
  @ApiModelProperty(value = "Text of the note")


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Note baseType(String baseType) {
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

  public Note schemaLocation(String schemaLocation) {
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

  public Note type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Note note = (Note) o;
    return Objects.equals(this.author, note.author) &&
        Objects.equals(this.date, note.date) &&
        Objects.equals(this.system, note.system) &&
        Objects.equals(this.text, note.text) &&
        Objects.equals(this.baseType, note.baseType) &&
        Objects.equals(this.schemaLocation, note.schemaLocation) &&
        Objects.equals(this.type, note.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(author, date, system, text, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Note {\n");
    
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

