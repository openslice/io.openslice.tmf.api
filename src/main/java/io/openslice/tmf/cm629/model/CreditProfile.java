package io.openslice.tmf.cm629.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Credit profile for the party (containing credit scoring, ...). By default only the current credit profile  is retrieved. It can be used as a list to give the party credit profiles history, the first one in the list will be the current one.
 */
@ApiModel(description = "Credit profile for the party (containing credit scoring, ...). By default only the current credit profile  is retrieved. It can be used as a list to give the party credit profiles history, the first one in the list will be the current one.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

@Entity(name = "CreditProfile")
public class CreditProfile   extends BaseRootEntity{
  @JsonProperty("creditProfileDate")
  private OffsetDateTime creditProfileDate = null;

  @JsonProperty("creditRiskRating")
  private Integer creditRiskRating = null;

  @JsonProperty("creditScore")
  private Integer creditScore = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  public CreditProfile creditProfileDate(OffsetDateTime creditProfileDate) {
    this.creditProfileDate = creditProfileDate;
    return this;
  }

  /**
   * The date the profile was established
   * @return creditProfileDate
  **/
  @ApiModelProperty(required = true, value = "The date the profile was established")
  @NotNull

  @Valid

  public OffsetDateTime getCreditProfileDate() {
    return creditProfileDate;
  }

  public void setCreditProfileDate(OffsetDateTime creditProfileDate) {
    this.creditProfileDate = creditProfileDate;
  }

  public CreditProfile creditRiskRating(Integer creditRiskRating) {
    this.creditRiskRating = creditRiskRating;
    return this;
  }

  /**
   * This is an integer whose value is used to rate the risk
   * @return creditRiskRating
  **/
  @ApiModelProperty(value = "This is an integer whose value is used to rate the risk")


  public Integer getCreditRiskRating() {
    return creditRiskRating;
  }

  public void setCreditRiskRating(Integer creditRiskRating) {
    this.creditRiskRating = creditRiskRating;
  }

  public CreditProfile creditScore(Integer creditScore) {
    this.creditScore = creditScore;
    return this;
  }

  /**
   * A measure of a person or organizations creditworthiness calculated on the basis of a combination of factors such as their income and credit history
   * @return creditScore
  **/
  @ApiModelProperty(value = "A measure of a person or organizations creditworthiness calculated on the basis of a combination of factors such as their income and credit history")


  public Integer getCreditScore() {
    return creditScore;
  }

  public void setCreditScore(Integer creditScore) {
    this.creditScore = creditScore;
  }

  public CreditProfile validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the profile is valid
   * @return validFor
  **/
  @ApiModelProperty(required = true, value = "The period for which the profile is valid")
  @NotNull

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
    CreditProfile creditProfile = (CreditProfile) o;
    return Objects.equals(this.creditProfileDate, creditProfile.creditProfileDate) &&
        Objects.equals(this.creditRiskRating, creditProfile.creditRiskRating) &&
        Objects.equals(this.creditScore, creditProfile.creditScore) &&
        Objects.equals(this.validFor, creditProfile.validFor) &&
        Objects.equals(this.baseType, creditProfile.baseType) &&
        Objects.equals(this.schemaLocation, creditProfile.schemaLocation) &&
        Objects.equals(this.type, creditProfile.type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditProfile {\n");
    
    sb.append("    creditProfileDate: ").append(toIndentedString(creditProfileDate)).append("\n");
    sb.append("    creditRiskRating: ").append(toIndentedString(creditRiskRating)).append("\n");
    sb.append("    creditScore: ").append(toIndentedString(creditScore)).append("\n");
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
