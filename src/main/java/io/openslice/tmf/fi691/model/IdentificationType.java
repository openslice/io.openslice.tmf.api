package io.openslice.tmf.fi691.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Somebody&#39;s national ID
 */
@ApiModel(description = "Somebody's national ID")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

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
  @ApiModelProperty(required = true, value = "Identification number of the document")
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
  @ApiModelProperty(required = true, value = "Country that issued the document")
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
  @ApiModelProperty(value = "Authority that issued the legal identification (e.g.: social security, town hall, ...)")


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
  @ApiModelProperty(value = "Date when identification was issued")

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

