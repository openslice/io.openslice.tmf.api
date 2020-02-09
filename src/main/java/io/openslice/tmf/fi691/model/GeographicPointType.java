/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.fi691.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeographicPointType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "GeographicPointType")
public class GeographicPointType   extends BaseRootNamedEntity {
  @JsonProperty("accuracy")
  private String accuracy = null;

  @JsonProperty("spatialRef")
  private String spatialRef = null;

  @JsonProperty("x")
  private String x = null;

  @JsonProperty("y")
  private String y = null;

  @JsonProperty("z")
  private String z = null;

  public GeographicPointType accuracy(String accuracy) {
    this.accuracy = accuracy;
    return this;
  }

  /**
   * Accuracy of the coordinate specified
   * @return accuracy
  **/
  @ApiModelProperty(required = true, value = "Accuracy of the coordinate specified")
  @NotNull


  public String getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(String accuracy) {
    this.accuracy = accuracy;
  }

  public GeographicPointType spatialRef(String spatialRef) {
    this.spatialRef = spatialRef;
    return this;
  }

  /**
   * Geocoding referential
   * @return spatialRef
  **/
  @ApiModelProperty(required = true, value = "Geocoding referential")
  @NotNull


  public String getSpatialRef() {
    return spatialRef;
  }

  public void setSpatialRef(String spatialRef) {
    this.spatialRef = spatialRef;
  }

  public GeographicPointType x(String x) {
    this.x = x;
    return this;
  }

  /**
   * . x coordinate (usually latitude)
   * @return x
  **/
  @ApiModelProperty(required = true, value = ". x coordinate (usually latitude)")
  @NotNull


  public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public GeographicPointType y(String y) {
    this.y = y;
    return this;
  }

  /**
   * y coordinate (usually longitude)
   * @return y
  **/
  @ApiModelProperty(required = true, value = "y coordinate (usually longitude)")
  @NotNull


  public String getY() {
    return y;
  }

  public void setY(String y) {
    this.y = y;
  }

  public GeographicPointType z(String z) {
    this.z = z;
    return this;
  }

  /**
   * z coordinate (usually elevation)
   * @return z
  **/
  @ApiModelProperty(value = "z coordinate (usually elevation)")


  public String getZ() {
    return z;
  }

  public void setZ(String z) {
    this.z = z;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeographicPointType geographicPointType = (GeographicPointType) o;
    return Objects.equals(this.accuracy, geographicPointType.accuracy) &&
        Objects.equals(this.spatialRef, geographicPointType.spatialRef) &&
        Objects.equals(this.x, geographicPointType.x) &&
        Objects.equals(this.y, geographicPointType.y) &&
        Objects.equals(this.z, geographicPointType.z);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accuracy, spatialRef, x, y, z);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeographicPointType {\n");
    
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    spatialRef: ").append(toIndentedString(spatialRef)).append("\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    z: ").append(toIndentedString(z)).append("\n");
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

