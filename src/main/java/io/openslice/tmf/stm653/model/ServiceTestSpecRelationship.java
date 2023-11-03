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
package io.openslice.tmf.stm653.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * A substitution, dependency or exclusivity relationship between/among service specifications.
 */
@Schema(description = "A substitution, dependency or exclusivity relationship between/among service specifications.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMServiceTestSpecRelationship")
@Table(name = "STMServiceTestSpecRelationship")
public class ServiceTestSpecRelationship extends BaseEntity {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  @JsonProperty("role")
  private String role = null;



  @JsonProperty("@referredType")
  private String _atReferredType = null;

	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}

  public ServiceTestSpecRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference
   * @return href
  **/
  @Schema(description = "Hyperlink reference")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceTestSpecRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
  **/
  @Schema(description = "Name of the related entity.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceTestSpecRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as substitution, dependency, exclusivity
   * @return relationshipType
  **/
  @Schema(description = "Type of relationship such as substitution, dependency, exclusivity")
      @NotNull

    public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ServiceTestSpecRelationship role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The association role for this service test specification
   * @return role
  **/
  @Schema(description = "The association role for this service test specification")
  
    public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

 
  

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @Schema(description = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestSpecRelationship serviceTestSpecRelationship = (ServiceTestSpecRelationship) o;
    return Objects.equals(this.id, serviceTestSpecRelationship.id) &&
        Objects.equals(this.href, serviceTestSpecRelationship.href) &&
        Objects.equals(this.name, serviceTestSpecRelationship.name) &&
        Objects.equals(this.relationshipType, serviceTestSpecRelationship.relationshipType) &&
        Objects.equals(this.role, serviceTestSpecRelationship.role) &&
        Objects.equals(this.validFor, serviceTestSpecRelationship.validFor) &&
        Objects.equals(this.baseType, serviceTestSpecRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceTestSpecRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceTestSpecRelationship.type) &&
        Objects.equals(this._atReferredType, serviceTestSpecRelationship._atReferredType);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, name, relationshipType, role, validFor, baseType, schemaLocation, type, _atReferredType);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
