package io.openslice.tmf.scm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.scm634.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A migration, substitution, dependency or exclusivity relationship between/among resource specifications.
 */
@ApiModel(description = "A migration, substitution, dependency or exclusivity relationship between/among resource specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceSpecRelationship   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public ResourceSpecRelationship type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of relationship such as migration, substitution, dependency, exclusivity
   * @return type
  **/
  @ApiModelProperty(value = "Type of relationship such as migration, substitution, dependency, exclusivity")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecRelationship role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The association role for this resource specification
   * @return role
  **/
  @ApiModelProperty(value = "The association role for this resource specification")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ResourceSpecRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of target ResourceSpecification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of target ResourceSpecification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceSpecRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the target ResourceSpecification
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the target ResourceSpecification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name given to the target resource specification instance
   * @return name
  **/
  @ApiModelProperty(value = "The name given to the target resource specification instance")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the ResourceSpecRelationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the ResourceSpecRelationship is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceSpecRelationship resourceSpecRelationship = (ResourceSpecRelationship) o;
    return Objects.equals(this.type, resourceSpecRelationship.type) &&
        Objects.equals(this.role, resourceSpecRelationship.role) &&
        Objects.equals(this.id, resourceSpecRelationship.id) &&
        Objects.equals(this.href, resourceSpecRelationship.href) &&
        Objects.equals(this.name, resourceSpecRelationship.name) &&
        Objects.equals(this.validFor, resourceSpecRelationship.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, role, id, href, name, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecRelationship {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

