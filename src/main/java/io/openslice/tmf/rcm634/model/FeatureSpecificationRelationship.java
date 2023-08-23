/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Configuration feature
 */
@Schema(description = "Configuration feature")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "RCMFeatureSpecRel")
public class FeatureSpecificationRelationship  extends BaseEntity {
  @JsonProperty("featureId")
  private String featureId = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("resourceSpecificationHref")
  private String resourceSpecificationHref = null;

  @JsonProperty("resourceSpecificationId")
  private String resourceSpecificationId = null;


  public FeatureSpecificationRelationship featureId(String featureId) {
    this.featureId = featureId;
    return this;
  }

  /**
   * Unique identifier of the target feature specification.
   * @return featureId
  **/
  @Schema(description = "Unique identifier of the target feature specification.")
  
    public String getFeatureId() {
    return featureId;
  }

  public void setFeatureId(String featureId) {
    this.featureId = featureId;
  }

  public FeatureSpecificationRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * This is the name of the target feature specification.
   * @return name
  **/
  @Schema(description = "This is the name of the target feature specification.")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FeatureSpecificationRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * This is the type of the feature specification relationship.
   * @return relationshipType
  **/
  @Schema(description = "This is the type of the feature specification relationship.")
      @NotNull

    public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public FeatureSpecificationRelationship resourceSpecificationHref(String resourceSpecificationHref) {
    this.resourceSpecificationHref = resourceSpecificationHref;
    return this;
  }

  /**
   * Hyperlink reference to the resource specification containing the target feature
   * @return resourceSpecificationHref
  **/
  @Schema(description = "Hyperlink reference to the resource specification containing the target feature")
  
    public String getResourceSpecificationHref() {
    return resourceSpecificationHref;
  }

  public void setResourceSpecificationHref(String resourceSpecificationHref) {
    this.resourceSpecificationHref = resourceSpecificationHref;
  }

  public FeatureSpecificationRelationship resourceSpecificationId(String resourceSpecificationId) {
    this.resourceSpecificationId = resourceSpecificationId;
    return this;
  }

  /**
   * Unique identifier of the resource specification containing the target feature
   * @return resourceSpecificationId
  **/
  @Schema(description = "Unique identifier of the resource specification containing the target feature")
  
    public String getResourceSpecificationId() {
    return resourceSpecificationId;
  }

  public void setResourceSpecificationId(String resourceSpecificationId) {
    this.resourceSpecificationId = resourceSpecificationId;
  }

  public FeatureSpecificationRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @Schema(description = "")
  
    @Valid
    public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public FeatureSpecificationRelationship _atBaseType(String _atBaseType) {
    this.baseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this.baseType = _atBaseType;
  }

  public FeatureSpecificationRelationship _atSchemaLocation(String _atSchemaLocation) {
    this.schemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this.schemaLocation = _atSchemaLocation;
  }

  public FeatureSpecificationRelationship _atType(String _atType) {
    this.type = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String _atType) {
    this.type = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeatureSpecificationRelationship featureSpecificationRelationship = (FeatureSpecificationRelationship) o;
    return Objects.equals(this.featureId, featureSpecificationRelationship.featureId) &&
        Objects.equals(this.name, featureSpecificationRelationship.name) &&
        Objects.equals(this.relationshipType, featureSpecificationRelationship.relationshipType) &&
        Objects.equals(this.resourceSpecificationHref, featureSpecificationRelationship.resourceSpecificationHref) &&
        Objects.equals(this.resourceSpecificationId, featureSpecificationRelationship.resourceSpecificationId) &&
        Objects.equals(this.validFor, featureSpecificationRelationship.validFor) &&
        Objects.equals(this.baseType, featureSpecificationRelationship.baseType) &&
        Objects.equals(this.schemaLocation, featureSpecificationRelationship.schemaLocation) &&
        Objects.equals(this.type, featureSpecificationRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureId, name, relationshipType, resourceSpecificationHref, resourceSpecificationId, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeatureSpecificationRelationship {\n");
    
    sb.append("    featureId: ").append(toIndentedString(featureId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    resourceSpecificationHref: ").append(toIndentedString(resourceSpecificationHref)).append("\n");
    sb.append("    resourceSpecificationId: ").append(toIndentedString(resourceSpecificationId)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
