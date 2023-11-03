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
package io.openslice.tmf.am651.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * A business participant that is responsible for approving the agreement.
 */
@Schema(description = "A business participant that is responsible for approving the agreement.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementAuthorization   {
  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("signatureRepresentation")
  private String signatureRepresentation = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("@type")
  private String type = null;

  public AgreementAuthorization date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * The date associated with the authorization state.
   * @return date
  **/
  @Schema(description = "The date associated with the authorization state.")

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public AgreementAuthorization signatureRepresentation(String signatureRepresentation) {
    this.signatureRepresentation = signatureRepresentation;
    return this;
  }

  /**
   * Indication that represents whether the signature is a physical paper signature or a digital signature.
   * @return signatureRepresentation
  **/
  @Schema(description = "Indication that represents whether the signature is a physical paper signature or a digital signature.")


  public String getSignatureRepresentation() {
    return signatureRepresentation;
  }

  public void setSignatureRepresentation(String signatureRepresentation) {
    this.signatureRepresentation = signatureRepresentation;
  }

  public AgreementAuthorization state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Current status of the authorization, for example in process, approved, rejected.
   * @return state
  **/
  @Schema(description = "Current status of the authorization, for example in process, approved, rejected.")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AgreementAuthorization type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @Schema(description = "The class type of the actual resource (for type extension).")


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
    AgreementAuthorization agreementAuthorization = (AgreementAuthorization) o;
    return Objects.equals(this.date, agreementAuthorization.date) &&
        Objects.equals(this.signatureRepresentation, agreementAuthorization.signatureRepresentation) &&
        Objects.equals(this.state, agreementAuthorization.state) &&
        Objects.equals(this.type, agreementAuthorization.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, signatureRepresentation, state, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementAuthorization {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    signatureRepresentation: ").append(toIndentedString(signatureRepresentation)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

