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

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

/**
 * An aggregation, migration, substitution, dependency or exclusivity relationship between/among FeatureSpecificationCharacteristics.
 */
@Schema(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among FeatureSpecificationCharacteristics.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "RCMFeatureSpecCharRel")
public class FeatureSpecificationCharacteristicRelationship   extends BaseRootNamedEntity {
  @JsonProperty("characteristicId")
  private String characteristicId = null;

  @JsonProperty("featureId")
  private String featureId = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("resourceSpecificationHref")
  private String resourceSpecificationHref = null;

  @JsonProperty("resourceSpecificationId")
  private String resourceSpecificationId = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public FeatureSpecificationCharacteristicRelationship characteristicId(String characteristicId) {
    this.characteristicId = characteristicId;
    return this;
  }

  /**
   * Unique identifier of the characteristic within the the target feature specification
   * @return characteristicId
  **/
  @Schema(description = "Unique identifier of the characteristic within the the target feature specification")
  
    public String getCharacteristicId() {
    return characteristicId;
  }

  public void setCharacteristicId(String characteristicId) {
    this.characteristicId = characteristicId;
  }

  public FeatureSpecificationCharacteristicRelationship featureId(String featureId) {
    this.featureId = featureId;
    return this;
  }

  /**
   * Unique identifier of the target feature specification within the resource specification.
   * @return featureId
  **/
  @Schema(description = "Unique identifier of the target feature specification within the resource specification.")
  
    public String getFeatureId() {
    return featureId;
  }

  public void setFeatureId(String featureId) {
    this.featureId = featureId;
  }

  public FeatureSpecificationCharacteristicRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the target characteristic
   * @return name
  **/
  @Schema(description = "Name of the target characteristic")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FeatureSpecificationCharacteristicRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as aggregation, migration, substitution, dependency, exclusivity
   * @return relationshipType
  **/
  @Schema(description = "Type of relationship such as aggregation, migration, substitution, dependency, exclusivity")
  
    public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public FeatureSpecificationCharacteristicRelationship resourceSpecificationHref(String resourceSpecificationHref) {
    this.resourceSpecificationHref = resourceSpecificationHref;
    return this;
  }

  /**
   * Hyperlink reference to the resource specification containing the target feature and feature characteristic
   * @return resourceSpecificationHref
  **/
  @Schema(description = "Hyperlink reference to the resource specification containing the target feature and feature characteristic")
  
    public String getResourceSpecificationHref() {
    return resourceSpecificationHref;
  }

  public void setResourceSpecificationHref(String resourceSpecificationHref) {
    this.resourceSpecificationHref = resourceSpecificationHref;
  }

  public FeatureSpecificationCharacteristicRelationship resourceSpecificationId(String resourceSpecificationId) {
    this.resourceSpecificationId = resourceSpecificationId;
    return this;
  }

  /**
   * Unique identifier of the resource specification containing the target feature and feature characteristic
   * @return resourceSpecificationId
  **/
  @Schema(description = "Unique identifier of the resource specification containing the target feature and feature characteristic")
  
    public String getResourceSpecificationId() {
    return resourceSpecificationId;
  }

  public void setResourceSpecificationId(String resourceSpecificationId) {
    this.resourceSpecificationId = resourceSpecificationId;
  }

  public FeatureSpecificationCharacteristicRelationship validFor(TimePeriod validFor) {
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



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeatureSpecificationCharacteristicRelationship featureSpecificationCharacteristicRelationship = (FeatureSpecificationCharacteristicRelationship) o;
    return Objects.equals(this.characteristicId, featureSpecificationCharacteristicRelationship.characteristicId) &&
        Objects.equals(this.featureId, featureSpecificationCharacteristicRelationship.featureId) &&
        Objects.equals(this.name, featureSpecificationCharacteristicRelationship.name) &&
        Objects.equals(this.relationshipType, featureSpecificationCharacteristicRelationship.relationshipType) &&
        Objects.equals(this.resourceSpecificationHref, featureSpecificationCharacteristicRelationship.resourceSpecificationHref) &&
        Objects.equals(this.resourceSpecificationId, featureSpecificationCharacteristicRelationship.resourceSpecificationId) &&
        Objects.equals(this.validFor, featureSpecificationCharacteristicRelationship.validFor) &&
        Objects.equals(this.baseType, featureSpecificationCharacteristicRelationship.baseType) &&
        Objects.equals(this.schemaLocation, featureSpecificationCharacteristicRelationship.schemaLocation) &&
        Objects.equals(this.type, featureSpecificationCharacteristicRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characteristicId, featureId, name, relationshipType, resourceSpecificationHref, resourceSpecificationId, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeatureSpecificationCharacteristicRelationship {\n");
    
    sb.append("    characteristicId: ").append(toIndentedString(characteristicId)).append("\n");
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
