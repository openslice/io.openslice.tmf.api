package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An aggregation, migration, substitution, dependency or exclusivity relationship between/among serviceSpecCharacteristics.
 */
@ApiModel(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among serviceSpecCharacteristics.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceSpecCharRelationship   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ServiceSpecCharRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the target specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the target specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceSpecCharRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to the target specification
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to the target specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceSpecCharRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the target  characteristic
   * @return name
  **/
  @ApiModelProperty(value = "Name of the target  characteristic")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceSpecCharRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as aggregation, migration, substitution, dependency, exclusivity
   * @return relationshipType
  **/
  @ApiModelProperty(value = "Type of relationship such as aggregation, migration, substitution, dependency, exclusivity")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ServiceSpecCharRelationship role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The association role for this service specification
   * @return role
  **/
  @ApiModelProperty(value = "The association role for this service specification")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ServiceSpecCharRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the serviceSpecCharRelationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the serviceSpecCharRelationship is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceSpecCharRelationship baseType(String baseType) {
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

  public ServiceSpecCharRelationship schemaLocation(String schemaLocation) {
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

  public ServiceSpecCharRelationship type(String type) {
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
    ServiceSpecCharRelationship serviceSpecCharRelationship = (ServiceSpecCharRelationship) o;
    return Objects.equals(this.id, serviceSpecCharRelationship.id) &&
        Objects.equals(this.href, serviceSpecCharRelationship.href) &&
        Objects.equals(this.name, serviceSpecCharRelationship.name) &&
        Objects.equals(this.relationshipType, serviceSpecCharRelationship.relationshipType) &&
        Objects.equals(this.role, serviceSpecCharRelationship.role) &&
        Objects.equals(this.validFor, serviceSpecCharRelationship.validFor) &&
        Objects.equals(this.baseType, serviceSpecCharRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecCharRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceSpecCharRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, relationshipType, role, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecCharRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

