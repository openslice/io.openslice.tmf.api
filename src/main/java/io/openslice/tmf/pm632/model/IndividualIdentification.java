package io.openslice.tmf.pm632.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.pm632.model.AttachmentRefOrValue;
import io.openslice.tmf.pm632.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents our registration of information used as proof of identity by an individual (passport, national identity card, drivers license, social security number, birth certificate)
 */
@ApiModel(description = "Represents our registration of information used as proof of identity by an individual (passport, national identity card, drivers license, social security number, birth certificate)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class IndividualIdentification   {
  @JsonProperty("identificationId")
  private String identificationId = null;

  @JsonProperty("identificationType")
  private String identificationType = null;

  @JsonProperty("issuingAuthority")
  private String issuingAuthority = null;

  @JsonProperty("issuingDate")
  private OffsetDateTime issuingDate = null;

  @JsonProperty("attachment")
  private AttachmentRefOrValue attachment = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public IndividualIdentification identificationId(String identificationId) {
    this.identificationId = identificationId;
    return this;
  }

  /**
   * Identifier
   * @return identificationId
  **/
  @ApiModelProperty(value = "Identifier")


  public String getIdentificationId() {
    return identificationId;
  }

  public void setIdentificationId(String identificationId) {
    this.identificationId = identificationId;
  }

  public IndividualIdentification identificationType(String identificationType) {
    this.identificationType = identificationType;
    return this;
  }

  /**
   * Identification type (passport, national identity card, drivers license, social security number, birth certificate)
   * @return identificationType
  **/
  @ApiModelProperty(value = "Identification type (passport, national identity card, drivers license, social security number, birth certificate)")


  public String getIdentificationType() {
    return identificationType;
  }

  public void setIdentificationType(String identificationType) {
    this.identificationType = identificationType;
  }

  public IndividualIdentification issuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  /**
   * Authority which has issued the identifier, such as: social security, town hall
   * @return issuingAuthority
  **/
  @ApiModelProperty(value = "Authority which has issued the identifier, such as: social security, town hall")


  public String getIssuingAuthority() {
    return issuingAuthority;
  }

  public void setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
  }

  public IndividualIdentification issuingDate(OffsetDateTime issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  /**
   * Date at which the identifier was issued
   * @return issuingDate
  **/
  @ApiModelProperty(value = "Date at which the identifier was issued")

  @Valid

  public OffsetDateTime getIssuingDate() {
    return issuingDate;
  }

  public void setIssuingDate(OffsetDateTime issuingDate) {
    this.issuingDate = issuingDate;
  }

  public IndividualIdentification attachment(AttachmentRefOrValue attachment) {
    this.attachment = attachment;
    return this;
  }

  /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AttachmentRefOrValue getAttachment() {
    return attachment;
  }

  public void setAttachment(AttachmentRefOrValue attachment) {
    this.attachment = attachment;
  }

  public IndividualIdentification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the identification information is valid.
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the identification information is valid.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public IndividualIdentification baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public IndividualIdentification schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public IndividualIdentification type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


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
    IndividualIdentification individualIdentification = (IndividualIdentification) o;
    return Objects.equals(this.identificationId, individualIdentification.identificationId) &&
        Objects.equals(this.identificationType, individualIdentification.identificationType) &&
        Objects.equals(this.issuingAuthority, individualIdentification.issuingAuthority) &&
        Objects.equals(this.issuingDate, individualIdentification.issuingDate) &&
        Objects.equals(this.attachment, individualIdentification.attachment) &&
        Objects.equals(this.validFor, individualIdentification.validFor) &&
        Objects.equals(this.baseType, individualIdentification.baseType) &&
        Objects.equals(this.schemaLocation, individualIdentification.schemaLocation) &&
        Objects.equals(this.type, individualIdentification.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identificationId, identificationType, issuingAuthority, issuingDate, attachment, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndividualIdentification {\n");
    
    sb.append("    identificationId: ").append(toIndentedString(identificationId)).append("\n");
    sb.append("    identificationType: ").append(toIndentedString(identificationType)).append("\n");
    sb.append("    issuingAuthority: ").append(toIndentedString(issuingAuthority)).append("\n");
    sb.append("    issuingDate: ").append(toIndentedString(issuingDate)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
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

