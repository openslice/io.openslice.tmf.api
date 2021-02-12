/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.pm632.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Keeps track of other names, for example the old name of an organization.
 */
@ApiModel(description = "Keeps track of other names, for example the old name of an organization.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class OtherNameOrganization extends BaseRootNamedEntity  {

  @JsonProperty("nameType")
  private String nameType = null;

  @JsonProperty("tradingName")
  private String tradingName = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  /**
   * Co. , Inc. , Ltd. , Pty Ltd. , Plc; , Gmbh
   * @return nameType
  **/
  @ApiModelProperty(value = "Co. , Inc. , Ltd. , Pty Ltd. , Plc; , Gmbh")


  public String getNameType() {
    return nameType;
  }

  public void setNameType(String nameType) {
    this.nameType = nameType;
  }

  public OtherNameOrganization tradingName(String tradingName) {
    this.tradingName = tradingName;
    return this;
  }

  /**
   * The name that the organization trades under
   * @return tradingName
  **/
  @ApiModelProperty(value = "The name that the organization trades under")


  public String getTradingName() {
    return tradingName;
  }

  public void setTradingName(String tradingName) {
    this.tradingName = tradingName;
  }

  public OtherNameOrganization validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")

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
    OtherNameOrganization otherNameOrganization = (OtherNameOrganization) o;
    return Objects.equals(this.name, otherNameOrganization.name) &&
        Objects.equals(this.nameType, otherNameOrganization.nameType) &&
        Objects.equals(this.tradingName, otherNameOrganization.tradingName) &&
        Objects.equals(this.validFor, otherNameOrganization.validFor) &&
        Objects.equals(this.baseType, otherNameOrganization.baseType) &&
        Objects.equals(this.schemaLocation, otherNameOrganization.schemaLocation) &&
        Objects.equals(this.type, otherNameOrganization.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, nameType, tradingName, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtherNameOrganization {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nameType: ").append(toIndentedString(nameType)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
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

