package io.openslice.tmf.pm632.model;

import java.util.ArrayList;
import io.openslice.tmf.common.model.TimePeriod;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Organization represents a group of people identified by shared interests or purpose. Examples include business, department and enterprise. Because of the complex nature of many businesses, both organizations and organization units are represented by the same data.
 */
@ApiModel(description = "Organization represents a group of people identified by shared interests or purpose. Examples include business, department and enterprise. Because of the complex nature of many businesses, both organizations and organization units are represented by the same data.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class Organization   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("isHeadOffice")
  private Boolean isHeadOffice = null;

  @JsonProperty("isLegalEntity")
  private Boolean isLegalEntity = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("nameType")
  private String nameType = null;

  @JsonProperty("organizationType")
  private String organizationType = null;

  @JsonProperty("tradingName")
  private String tradingName = null;

  @JsonProperty("contactMedium")
  @Valid
  private List<ContactMedium> contactMedium = null;

  @JsonProperty("creditRating")
  @Valid
  private List<PartyCreditProfile> creditRating = null;

  @JsonProperty("existsDuring")
  private TimePeriod existsDuring = null;

  @JsonProperty("externalReference")
  @Valid
  private List<ExternalReference> externalReference = null;

  @JsonProperty("organizationChildRelationship")
  @Valid
  private List<OrganizationChildRelationship> organizationChildRelationship = null;

  @JsonProperty("organizationIdentification")
  @Valid
  private List<OrganizationIdentification> organizationIdentification = null;

  @JsonProperty("organizationParentRelationship")
  private OrganizationParentRelationship organizationParentRelationship = null;

  @JsonProperty("otherName")
  @Valid
  private List<OtherNameOrganization> otherName = null;

  @JsonProperty("partyCharacteristic")
  @Valid
  private List<Characteristic> partyCharacteristic = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("status")
  private OrganizationStateType status = null;

  @JsonProperty("taxExemptionCertificate")
  @Valid
  private List<TaxExemptionCertificate> taxExemptionCertificate = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public Organization id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the organization
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the organization")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Organization href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access the organization
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink to access the organization")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Organization isHeadOffice(Boolean isHeadOffice) {
    this.isHeadOffice = isHeadOffice;
    return this;
  }

  /**
   * If value is true, the organization is the head office
   * @return isHeadOffice
  **/
  @ApiModelProperty(value = "If value is true, the organization is the head office")


  public Boolean isIsHeadOffice() {
    return isHeadOffice;
  }

  public void setIsHeadOffice(Boolean isHeadOffice) {
    this.isHeadOffice = isHeadOffice;
  }

  public Organization isLegalEntity(Boolean isLegalEntity) {
    this.isLegalEntity = isLegalEntity;
    return this;
  }

  /**
   * If value is true, the organization is a legal entity known by a national referential.
   * @return isLegalEntity
  **/
  @ApiModelProperty(value = "If value is true, the organization is a legal entity known by a national referential.")


  public Boolean isIsLegalEntity() {
    return isLegalEntity;
  }

  public void setIsLegalEntity(Boolean isLegalEntity) {
    this.isLegalEntity = isLegalEntity;
  }

  public Organization name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Organization name (department name for example)
   * @return name
  **/
  @ApiModelProperty(value = "Organization name (department name for example)")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Organization nameType(String nameType) {
    this.nameType = nameType;
    return this;
  }

  /**
   * Type of the name : Co, Inc, Ltd,…
   * @return nameType
  **/
  @ApiModelProperty(value = "Type of the name : Co, Inc, Ltd,…")


  public String getNameType() {
    return nameType;
  }

  public void setNameType(String nameType) {
    this.nameType = nameType;
  }

  public Organization organizationType(String organizationType) {
    this.organizationType = organizationType;
    return this;
  }

  /**
   * Type of Organization (company, department...)
   * @return organizationType
  **/
  @ApiModelProperty(value = "Type of Organization (company, department...)")


  public String getOrganizationType() {
    return organizationType;
  }

  public void setOrganizationType(String organizationType) {
    this.organizationType = organizationType;
  }

  public Organization tradingName(String tradingName) {
    this.tradingName = tradingName;
    return this;
  }

  /**
   * Name that the organization (unit) trades under
   * @return tradingName
  **/
  @ApiModelProperty(value = "Name that the organization (unit) trades under")


  public String getTradingName() {
    return tradingName;
  }

  public void setTradingName(String tradingName) {
    this.tradingName = tradingName;
  }

  public Organization contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public Organization addContactMediumItem(ContactMedium contactMediumItem) {
    if (this.contactMedium == null) {
      this.contactMedium = new ArrayList<>();
    }
    this.contactMedium.add(contactMediumItem);
    return this;
  }

  /**
   * Get contactMedium
   * @return contactMedium
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ContactMedium> getContactMedium() {
    return contactMedium;
  }

  public void setContactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
  }

  public Organization creditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
    return this;
  }

  public Organization addCreditRatingItem(PartyCreditProfile creditRatingItem) {
    if (this.creditRating == null) {
      this.creditRating = new ArrayList<>();
    }
    this.creditRating.add(creditRatingItem);
    return this;
  }

  /**
   * Get creditRating
   * @return creditRating
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PartyCreditProfile> getCreditRating() {
    return creditRating;
  }

  public void setCreditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
  }

  public Organization existsDuring(TimePeriod existsDuring) {
    this.existsDuring = existsDuring;
    return this;
  }

  /**
   * Get existsDuring
   * @return existsDuring
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TimePeriod getExistsDuring() {
    return existsDuring;
  }

  public void setExistsDuring(TimePeriod existsDuring) {
    this.existsDuring = existsDuring;
  }

  public Organization externalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  public Organization addExternalReferenceItem(ExternalReference externalReferenceItem) {
    if (this.externalReference == null) {
      this.externalReference = new ArrayList<>();
    }
    this.externalReference.add(externalReferenceItem);
    return this;
  }

  /**
   * Get externalReference
   * @return externalReference
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ExternalReference> getExternalReference() {
    return externalReference;
  }

  public void setExternalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
  }

  public Organization organizationChildRelationship(List<OrganizationChildRelationship> organizationChildRelationship) {
    this.organizationChildRelationship = organizationChildRelationship;
    return this;
  }

  public Organization addOrganizationChildRelationshipItem(OrganizationChildRelationship organizationChildRelationshipItem) {
    if (this.organizationChildRelationship == null) {
      this.organizationChildRelationship = new ArrayList<>();
    }
    this.organizationChildRelationship.add(organizationChildRelationshipItem);
    return this;
  }

  /**
   * Get organizationChildRelationship
   * @return organizationChildRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OrganizationChildRelationship> getOrganizationChildRelationship() {
    return organizationChildRelationship;
  }

  public void setOrganizationChildRelationship(List<OrganizationChildRelationship> organizationChildRelationship) {
    this.organizationChildRelationship = organizationChildRelationship;
  }

  public Organization organizationIdentification(List<OrganizationIdentification> organizationIdentification) {
    this.organizationIdentification = organizationIdentification;
    return this;
  }

  public Organization addOrganizationIdentificationItem(OrganizationIdentification organizationIdentificationItem) {
    if (this.organizationIdentification == null) {
      this.organizationIdentification = new ArrayList<>();
    }
    this.organizationIdentification.add(organizationIdentificationItem);
    return this;
  }

  /**
   * Get organizationIdentification
   * @return organizationIdentification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OrganizationIdentification> getOrganizationIdentification() {
    return organizationIdentification;
  }

  public void setOrganizationIdentification(List<OrganizationIdentification> organizationIdentification) {
    this.organizationIdentification = organizationIdentification;
  }

  public Organization organizationParentRelationship(OrganizationParentRelationship organizationParentRelationship) {
    this.organizationParentRelationship = organizationParentRelationship;
    return this;
  }

  /**
   * Get organizationParentRelationship
   * @return organizationParentRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OrganizationParentRelationship getOrganizationParentRelationship() {
    return organizationParentRelationship;
  }

  public void setOrganizationParentRelationship(OrganizationParentRelationship organizationParentRelationship) {
    this.organizationParentRelationship = organizationParentRelationship;
  }

  public Organization otherName(List<OtherNameOrganization> otherName) {
    this.otherName = otherName;
    return this;
  }

  public Organization addOtherNameItem(OtherNameOrganization otherNameItem) {
    if (this.otherName == null) {
      this.otherName = new ArrayList<>();
    }
    this.otherName.add(otherNameItem);
    return this;
  }

  /**
   * Get otherName
   * @return otherName
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OtherNameOrganization> getOtherName() {
    return otherName;
  }

  public void setOtherName(List<OtherNameOrganization> otherName) {
    this.otherName = otherName;
  }

  public Organization partyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
    return this;
  }

  public Organization addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
    if (this.partyCharacteristic == null) {
      this.partyCharacteristic = new ArrayList<>();
    }
    this.partyCharacteristic.add(partyCharacteristicItem);
    return this;
  }

  /**
   * Get partyCharacteristic
   * @return partyCharacteristic
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Characteristic> getPartyCharacteristic() {
    return partyCharacteristic;
  }

  public void setPartyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
  }

  public Organization relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public Organization addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public Organization status(OrganizationStateType status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the organization
   * @return status
  **/
  @ApiModelProperty(value = "Status of the organization")

  @Valid

  public OrganizationStateType getStatus() {
    return status;
  }

  public void setStatus(OrganizationStateType status) {
    this.status = status;
  }

  public Organization taxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
    return this;
  }

  public Organization addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
    if (this.taxExemptionCertificate == null) {
      this.taxExemptionCertificate = new ArrayList<>();
    }
    this.taxExemptionCertificate.add(taxExemptionCertificateItem);
    return this;
  }

  /**
   * Get taxExemptionCertificate
   * @return taxExemptionCertificate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaxExemptionCertificate> getTaxExemptionCertificate() {
    return taxExemptionCertificate;
  }

  public void setTaxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
  }

  public Organization baseType(String baseType) {
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

  public Organization schemaLocation(String schemaLocation) {
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

  public Organization type(String type) {
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
    Organization organization = (Organization) o;
    return Objects.equals(this.id, organization.id) &&
        Objects.equals(this.href, organization.href) &&
        Objects.equals(this.isHeadOffice, organization.isHeadOffice) &&
        Objects.equals(this.isLegalEntity, organization.isLegalEntity) &&
        Objects.equals(this.name, organization.name) &&
        Objects.equals(this.nameType, organization.nameType) &&
        Objects.equals(this.organizationType, organization.organizationType) &&
        Objects.equals(this.tradingName, organization.tradingName) &&
        Objects.equals(this.contactMedium, organization.contactMedium) &&
        Objects.equals(this.creditRating, organization.creditRating) &&
        Objects.equals(this.existsDuring, organization.existsDuring) &&
        Objects.equals(this.externalReference, organization.externalReference) &&
        Objects.equals(this.organizationChildRelationship, organization.organizationChildRelationship) &&
        Objects.equals(this.organizationIdentification, organization.organizationIdentification) &&
        Objects.equals(this.organizationParentRelationship, organization.organizationParentRelationship) &&
        Objects.equals(this.otherName, organization.otherName) &&
        Objects.equals(this.partyCharacteristic, organization.partyCharacteristic) &&
        Objects.equals(this.relatedParty, organization.relatedParty) &&
        Objects.equals(this.status, organization.status) &&
        Objects.equals(this.taxExemptionCertificate, organization.taxExemptionCertificate) &&
        Objects.equals(this.baseType, organization.baseType) &&
        Objects.equals(this.schemaLocation, organization.schemaLocation) &&
        Objects.equals(this.type, organization.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, isHeadOffice, isLegalEntity, name, nameType, organizationType, tradingName, contactMedium, creditRating, existsDuring, externalReference, organizationChildRelationship, organizationIdentification, organizationParentRelationship, otherName, partyCharacteristic, relatedParty, status, taxExemptionCertificate, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    isHeadOffice: ").append(toIndentedString(isHeadOffice)).append("\n");
    sb.append("    isLegalEntity: ").append(toIndentedString(isLegalEntity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nameType: ").append(toIndentedString(nameType)).append("\n");
    sb.append("    organizationType: ").append(toIndentedString(organizationType)).append("\n");
    sb.append("    tradingName: ").append(toIndentedString(tradingName)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
    sb.append("    creditRating: ").append(toIndentedString(creditRating)).append("\n");
    sb.append("    existsDuring: ").append(toIndentedString(existsDuring)).append("\n");
    sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
    sb.append("    organizationChildRelationship: ").append(toIndentedString(organizationChildRelationship)).append("\n");
    sb.append("    organizationIdentification: ").append(toIndentedString(organizationIdentification)).append("\n");
    sb.append("    organizationParentRelationship: ").append(toIndentedString(organizationParentRelationship)).append("\n");
    sb.append("    otherName: ").append(toIndentedString(otherName)).append("\n");
    sb.append("    partyCharacteristic: ").append(toIndentedString(partyCharacteristic)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    taxExemptionCertificate: ").append(toIndentedString(taxExemptionCertificate)).append("\n");
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

