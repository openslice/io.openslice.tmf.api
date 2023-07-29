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

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * Constraint reference. The Constraint resource represents a policy/rule applied to an entity or entity spec.
 */
@Schema(description = "Constraint reference. The Constraint resource represents a policy/rule applied to an entity or entity spec.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMConstraintRef")
@Table(name = "STMConstraintRef")
public class ConstraintRef  extends BaseRootNamedEntity  {
  @JsonProperty("id")
  private String id = null;

  

  @JsonProperty("@referredType")
  private String _atReferredType = null;



  @JsonProperty("version")
  private String version = null;



/**
   * reference id to the target constraint
   * @return id
  **/
  @Schema(description = "reference id to the target constraint")
      @NotNull
  	/**
  	 * @return the id
  	 */
  	public String getId() {
  		if ( uuid != null ) {
  			id = uuid;			
  		} 
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
  @Schema(description = "Hyperlink reference to the target constraint")
  
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
  @Schema(description = "Name given to the constraint")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  

  public ConstraintRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The (class) type of the referred constraint
   * @return _atReferredType
  **/
  @Schema(description = "The (class) type of the referred constraint")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }

  /**
 * @return the version
 */
public String getVersion() {
	return version;
}

/**
 * @param version the version to set
 */
public void setVersion(String version) {
	this.version = version;
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
        Objects.equals(this._atReferredType, constraintRef._atReferredType);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, name, version, baseType, schemaLocation, type, _atReferredType);
//  }

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
