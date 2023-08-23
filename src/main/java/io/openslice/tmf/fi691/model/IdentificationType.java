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

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Somebody&#39;s national ID
 */
@Schema(description = "Somebody's national ID")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "IdentificationType")
public class IdentificationType  extends BaseRootEntity  {
 

  @JsonProperty("identificationId")
  private String identificationId = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("issuingAuthority")
  private String issuingAuthority = null;

  @JsonProperty("issuingDate")
  private OffsetDateTime issuingDate = null;


  public IdentificationType identificationId(String identificationId) {
    this.identificationId = identificationId;
    return this;
  }

  /**
   * Identification number of the document
   * @return identificationId
  **/
  @Schema(description = "Identification number of the document")
  @NotNull


  public String getIdentificationId() {
    return identificationId;
  }

  public void setIdentificationId(String identificationId) {
    this.identificationId = identificationId;
  }

  public IdentificationType country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country that issued the document
   * @return country
  **/
  @Schema(description = "Country that issued the document")
  @NotNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public IdentificationType issuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  /**
   * Authority that issued the legal identification (e.g.: social security, town hall, ...)
   * @return issuingAuthority
  **/
  @Schema(description = "Authority that issued the legal identification (e.g.: social security, town hall, ...)")


  public String getIssuingAuthority() {
    return issuingAuthority;
  }

  public void setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
  }

  public IdentificationType issuingDate(OffsetDateTime issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  /**
   * Date when identification was issued
   * @return issuingDate
  **/
  @Schema(description = "Date when identification was issued")

  @Valid

  public OffsetDateTime getIssuingDate() {
    return issuingDate;
  }

  public void setIssuingDate(OffsetDateTime issuingDate) {
    this.issuingDate = issuingDate;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentificationType identificationType = (IdentificationType) o;
    return Objects.equals(this.type, identificationType.type) &&
        Objects.equals(this.identificationId, identificationType.identificationId) &&
        Objects.equals(this.country, identificationType.country) &&
        Objects.equals(this.issuingAuthority, identificationType.issuingAuthority) &&
        Objects.equals(this.issuingDate, identificationType.issuingDate) &&
        Objects.equals(this.schemaLocation, identificationType.schemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentificationType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    identificationId: ").append(toIndentedString(identificationId)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    issuingAuthority: ").append(toIndentedString(issuingAuthority)).append("\n");
    sb.append("    issuingDate: ").append(toIndentedString(issuingDate)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

