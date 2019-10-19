package io.openslice.tmf.am651.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A business participant that is responsible for approving the agreement.
 */
@ApiModel(description = "A business participant that is responsible for approving the agreement.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

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
  @ApiModelProperty(value = "The date associated with the authorization state.")

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
  @ApiModelProperty(value = "Indication that represents whether the signature is a physical paper signature or a digital signature.")


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
  @ApiModelProperty(value = "Current status of the authorization, for example in process, approved, rejected.")


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
  @ApiModelProperty(value = "The class type of the actual resource (for type extension).")


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

