package io.openslice.tmf.pm632.model;

import java.time.OffsetDateTime;
import io.openslice.tmf.common.model.TimePeriod;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents our registration of information used as proof of identity by an organization
 */
@ApiModel(description = "Represents our registration of information used as proof of identity by an organization")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class OrganizationIdentification   {
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

  public OrganizationIdentification identificationId(String identificationId) {
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

  public OrganizationIdentification identificationType(String identificationType) {
    this.identificationType = identificationType;
    return this;
  }

  /**
   * Type of identification information used to identify the company in a country or internationally
   * @return identificationType
  **/
  @ApiModelProperty(value = "Type of identification information used to identify the company in a country or internationally")


  public String getIdentificationType() {
    return identificationType;
  }

  public void setIdentificationType(String identificationType) {
    this.identificationType = identificationType;
  }

  public OrganizationIdentification issuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  /**
   * Authority which has issued the identifier (chamber of commerce...)
   * @return issuingAuthority
  **/
  @ApiModelProperty(value = "Authority which has issued the identifier (chamber of commerce...)")


  public String getIssuingAuthority() {
    return issuingAuthority;
  }

  public void setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
  }

  public OrganizationIdentification issuingDate(OffsetDateTime issuingDate) {
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

  public OrganizationIdentification attachment(AttachmentRefOrValue attachment) {
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

  public OrganizationIdentification validFor(TimePeriod validFor) {
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

  public OrganizationIdentification baseType(String baseType) {
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

  public OrganizationIdentification schemaLocation(String schemaLocation) {
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

  public OrganizationIdentification type(String type) {
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
    OrganizationIdentification organizationIdentification = (OrganizationIdentification) o;
    return Objects.equals(this.identificationId, organizationIdentification.identificationId) &&
        Objects.equals(this.identificationType, organizationIdentification.identificationType) &&
        Objects.equals(this.issuingAuthority, organizationIdentification.issuingAuthority) &&
        Objects.equals(this.issuingDate, organizationIdentification.issuingDate) &&
        Objects.equals(this.attachment, organizationIdentification.attachment) &&
        Objects.equals(this.validFor, organizationIdentification.validFor) &&
        Objects.equals(this.baseType, organizationIdentification.baseType) &&
        Objects.equals(this.schemaLocation, organizationIdentification.schemaLocation) &&
        Objects.equals(this.type, organizationIdentification.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identificationId, identificationType, issuingAuthority, issuingDate, attachment, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationIdentification {\n");
    
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

