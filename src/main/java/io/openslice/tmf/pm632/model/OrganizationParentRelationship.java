package io.openslice.tmf.pm632.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.pm632.model.OrganizationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Parent references of an organization in a structure of organizations.
 */
@ApiModel(description = "Parent references of an organization in a structure of organizations.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class OrganizationParentRelationship   {
  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("organization")
  private OrganizationRef organization = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public OrganizationParentRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of the relationship. Could be juridical, hierarchical, geographical, functional for example.
   * @return relationshipType
  **/
  @ApiModelProperty(value = "Type of the relationship. Could be juridical, hierarchical, geographical, functional for example.")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public OrganizationParentRelationship organization(OrganizationRef organization) {
    this.organization = organization;
    return this;
  }

  /**
   * Get organization
   * @return organization
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OrganizationRef getOrganization() {
    return organization;
  }

  public void setOrganization(OrganizationRef organization) {
    this.organization = organization;
  }

  public OrganizationParentRelationship baseType(String baseType) {
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

  public OrganizationParentRelationship schemaLocation(String schemaLocation) {
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

  public OrganizationParentRelationship type(String type) {
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
    OrganizationParentRelationship organizationParentRelationship = (OrganizationParentRelationship) o;
    return Objects.equals(this.relationshipType, organizationParentRelationship.relationshipType) &&
        Objects.equals(this.organization, organizationParentRelationship.organization) &&
        Objects.equals(this.baseType, organizationParentRelationship.baseType) &&
        Objects.equals(this.schemaLocation, organizationParentRelationship.schemaLocation) &&
        Objects.equals(this.type, organizationParentRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relationshipType, organization, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationParentRelationship {\n");
    
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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

