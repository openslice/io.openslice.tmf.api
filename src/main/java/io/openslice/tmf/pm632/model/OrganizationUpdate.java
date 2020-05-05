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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Organization represents a group of people identified by shared interests or purpose. Examples include business, department and enterprise. Because of the complex nature of many businesses, both organizations and organization units are represented by the same data. Skipped properties: id,href
 */
@ApiModel(description = "Organization represents a group of people identified by shared interests or purpose. Examples include business, department and enterprise. Because of the complex nature of many businesses, both organizations and organization units are represented by the same data. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class OrganizationUpdate   {
  @JsonProperty("isHeadOffice")
  protected Boolean isHeadOffice = null;

  @JsonProperty("isLegalEntity")
  protected Boolean isLegalEntity = null;

  @JsonProperty("name")
  protected String name = null;

  @JsonProperty("nameType")
  protected String nameType = null;

  @JsonProperty("organizationType")
  protected String organizationType = null;

  @JsonProperty("tradingName")
  protected String tradingName = null;

  @JsonProperty("contactMedium")
  @Valid
  protected List<ContactMedium> contactMedium = null;

  @JsonProperty("creditRating")
  @Valid
  protected List<PartyCreditProfile> creditRating = null;

  @JsonProperty("existsDuring")
  protected TimePeriod existsDuring = null;

  @JsonProperty("externalReference")
  @Valid
  protected List<ExternalReference> externalReference = null;

  @JsonProperty("organizationChildRelationship")
  @Valid
  protected List<OrganizationChildRelationship> organizationChildRelationship = null;

  @JsonProperty("organizationIdentification")
  @Valid
  protected List<OrganizationIdentification> organizationIdentification = null;

  @JsonProperty("organizationParentRelationship")
  protected OrganizationParentRelationship organizationParentRelationship = null;

  @JsonProperty("otherName")
  @Valid
  protected List<OtherNameOrganization> otherName = null;

  @JsonProperty("partyCharacteristic")
  @Valid
  protected List<Characteristic> partyCharacteristic = null;

  @JsonProperty("relatedParty")
  @Valid
  protected List<RelatedParty> relatedParty = null;

  @JsonProperty("status")
  protected OrganizationStateType status = null;

  @JsonProperty("taxExemptionCertificate")
  @Valid
  protected List<TaxExemptionCertificate> taxExemptionCertificate = null;

  @JsonProperty("@baseType")
  protected String baseType = null;

  @JsonProperty("@schemaLocation")
  protected String schemaLocation = null;

  @JsonProperty("@type")
  protected String type = null;

  public OrganizationUpdate isHeadOffice(Boolean isHeadOffice) {
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

  public OrganizationUpdate isLegalEntity(Boolean isLegalEntity) {
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

  public OrganizationUpdate name(String name) {
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

  public OrganizationUpdate nameType(String nameType) {
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

  public OrganizationUpdate organizationType(String organizationType) {
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

  public OrganizationUpdate tradingName(String tradingName) {
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

  public OrganizationUpdate contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public OrganizationUpdate addContactMediumItem(ContactMedium contactMediumItem) {
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

  public OrganizationUpdate creditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
    return this;
  }

  public OrganizationUpdate addCreditRatingItem(PartyCreditProfile creditRatingItem) {
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

  public OrganizationUpdate existsDuring(TimePeriod existsDuring) {
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

  public OrganizationUpdate externalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  public OrganizationUpdate addExternalReferenceItem(ExternalReference externalReferenceItem) {
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

  public OrganizationUpdate organizationChildRelationship(List<OrganizationChildRelationship> organizationChildRelationship) {
    this.organizationChildRelationship = organizationChildRelationship;
    return this;
  }

  public OrganizationUpdate addOrganizationChildRelationshipItem(OrganizationChildRelationship organizationChildRelationshipItem) {
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

  public OrganizationUpdate organizationIdentification(List<OrganizationIdentification> organizationIdentification) {
    this.organizationIdentification = organizationIdentification;
    return this;
  }

  public OrganizationUpdate addOrganizationIdentificationItem(OrganizationIdentification organizationIdentificationItem) {
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

  public OrganizationUpdate organizationParentRelationship(OrganizationParentRelationship organizationParentRelationship) {
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

  public OrganizationUpdate otherName(List<OtherNameOrganization> otherName) {
    this.otherName = otherName;
    return this;
  }

  public OrganizationUpdate addOtherNameItem(OtherNameOrganization otherNameItem) {
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

  public OrganizationUpdate partyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
    return this;
  }

  public OrganizationUpdate addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
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

  public OrganizationUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public OrganizationUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public OrganizationUpdate status(OrganizationStateType status) {
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

  public OrganizationUpdate taxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
    return this;
  }

  public OrganizationUpdate addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
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

  public OrganizationUpdate baseType(String baseType) {
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

  public OrganizationUpdate schemaLocation(String schemaLocation) {
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

  public OrganizationUpdate type(String type) {
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
    OrganizationUpdate organizationUpdate = (OrganizationUpdate) o;
    return Objects.equals(this.isHeadOffice, organizationUpdate.isHeadOffice) &&
        Objects.equals(this.isLegalEntity, organizationUpdate.isLegalEntity) &&
        Objects.equals(this.name, organizationUpdate.name) &&
        Objects.equals(this.nameType, organizationUpdate.nameType) &&
        Objects.equals(this.organizationType, organizationUpdate.organizationType) &&
        Objects.equals(this.tradingName, organizationUpdate.tradingName) &&
        Objects.equals(this.contactMedium, organizationUpdate.contactMedium) &&
        Objects.equals(this.creditRating, organizationUpdate.creditRating) &&
        Objects.equals(this.existsDuring, organizationUpdate.existsDuring) &&
        Objects.equals(this.externalReference, organizationUpdate.externalReference) &&
        Objects.equals(this.organizationChildRelationship, organizationUpdate.organizationChildRelationship) &&
        Objects.equals(this.organizationIdentification, organizationUpdate.organizationIdentification) &&
        Objects.equals(this.organizationParentRelationship, organizationUpdate.organizationParentRelationship) &&
        Objects.equals(this.otherName, organizationUpdate.otherName) &&
        Objects.equals(this.partyCharacteristic, organizationUpdate.partyCharacteristic) &&
        Objects.equals(this.relatedParty, organizationUpdate.relatedParty) &&
        Objects.equals(this.status, organizationUpdate.status) &&
        Objects.equals(this.taxExemptionCertificate, organizationUpdate.taxExemptionCertificate) &&
        Objects.equals(this.baseType, organizationUpdate.baseType) &&
        Objects.equals(this.schemaLocation, organizationUpdate.schemaLocation) &&
        Objects.equals(this.type, organizationUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isHeadOffice, isLegalEntity, name, nameType, organizationType, tradingName, contactMedium, creditRating, existsDuring, externalReference, organizationChildRelationship, organizationIdentification, organizationParentRelationship, otherName, partyCharacteristic, relatedParty, status, taxExemptionCertificate, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationUpdate {\n");
    
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
  
  public Characteristic findCharacteristic(String aName) {
	  	if ( partyCharacteristic!= null ) {
			for ( Characteristic c : partyCharacteristic) {
				if ( c.getName().equals(aName) ) {
					return c;
				}
			}	  		
	  	}
	  
		return null;
	}
}

