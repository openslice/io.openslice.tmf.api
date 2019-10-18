package io.openslice.tmf.pcm620.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Constraint reference. The Constraint resource represents a policy/rule applied to an entity or entity spec.
 */
@ApiModel(description = "Constraint reference. The Constraint resource represents a policy/rule applied to an entity or entity spec.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class ConstraintRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public ConstraintRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * reference id to the target constraint
   * @return id
  **/
  @ApiModelProperty(required = true, value = "reference id to the target constraint")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ConstraintRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to the target constraint
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to the target constraint")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ConstraintRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name given to the constraint
   * @return name
  **/
  @ApiModelProperty(value = "Name given to the constraint")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ConstraintRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * constraint version
   * @return version
  **/
  @ApiModelProperty(value = "constraint version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ConstraintRef baseType(String baseType) {
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

  public ConstraintRef schemaLocation(String schemaLocation) {
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

  public ConstraintRef type(String type) {
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

  public ConstraintRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The (class) type of the referred constraint
   * @return referredType
  **/
  @ApiModelProperty(value = "The (class) type of the referred constraint")


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
    ConstraintRef constraintRef = (ConstraintRef) o;
    return Objects.equals(this.id, constraintRef.id) &&
        Objects.equals(this.href, constraintRef.href) &&
        Objects.equals(this.name, constraintRef.name) &&
        Objects.equals(this.version, constraintRef.version) &&
        Objects.equals(this.baseType, constraintRef.baseType) &&
        Objects.equals(this.schemaLocation, constraintRef.schemaLocation) &&
        Objects.equals(this.type, constraintRef.type) &&
        Objects.equals(this.referredType, constraintRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, version, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstraintRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

