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
package io.openslice.tmf.cm629.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.am651.model.AgreementRef;
import io.openslice.tmf.am666.model.AccountRef;
import io.openslice.tmf.am666.model.PaymentMethodRef;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  Skipped properties: id,href
 */
@ApiModel(description = " Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

public class CustomerCreate   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("statusReason")
  private String statusReason = null;

  @JsonProperty("account")
  @Valid
  private List<AccountRef> account = null;

  @JsonProperty("agreement")
  @Valid
  private List<AgreementRef> agreement = null;

  @JsonProperty("characteristic")
  @Valid
  private List<Characteristic> characteristic = null;

  @JsonProperty("contactMedium")
  @Valid
  private List<ContactMedium> contactMedium = null;

  @JsonProperty("creditProfile")
  @Valid
  private List<CreditProfile> creditProfile = null;

  @JsonProperty("engagedParty")
  private RelatedParty engagedParty = null;

  @JsonProperty("paymentMethod")
  @Valid
  private List<PaymentMethodRef> paymentMethod = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public CustomerCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which the Customer is known and distinguished from other Customers.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A word, term, or phrase by which the Customer is known and distinguished from other Customers.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerCreate status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Used to track the lifecycle status of the customer.
   * @return status
  **/
  @ApiModelProperty(value = "Used to track the lifecycle status of the customer.")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CustomerCreate statusReason(String statusReason) {
    this.statusReason = statusReason;
    return this;
  }

  /**
   * A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.
   * @return statusReason
  **/
  @ApiModelProperty(value = "A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.")


  public String getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(String statusReason) {
    this.statusReason = statusReason;
  }

  public CustomerCreate account(List<AccountRef> account) {
    this.account = account;
    return this;
  }

  public CustomerCreate addAccountItem(AccountRef accountItem) {
    if (this.account == null) {
      this.account = new ArrayList<>();
    }
    this.account.add(accountItem);
    return this;
  }

  /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountRef> getAccount() {
    return account;
  }

  public void setAccount(List<AccountRef> account) {
    this.account = account;
  }

  public CustomerCreate agreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
    return this;
  }

  public CustomerCreate addAgreementItem(AgreementRef agreementItem) {
    if (this.agreement == null) {
      this.agreement = new ArrayList<>();
    }
    this.agreement.add(agreementItem);
    return this;
  }

  /**
   * Get agreement
   * @return agreement
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementRef> getAgreement() {
    return agreement;
  }

  public void setAgreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
  }

  public CustomerCreate characteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public CustomerCreate addCharacteristicItem(Characteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * Describes the characteristic of a customer.
   * @return characteristic
  **/
  @ApiModelProperty(value = "Describes the characteristic of a customer.")

  @Valid

  public List<Characteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
  }

  public CustomerCreate contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public CustomerCreate addContactMediumItem(ContactMedium contactMediumItem) {
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

  public CustomerCreate creditProfile(List<CreditProfile> creditProfile) {
    this.creditProfile = creditProfile;
    return this;
  }

  public CustomerCreate addCreditProfileItem(CreditProfile creditProfileItem) {
    if (this.creditProfile == null) {
      this.creditProfile = new ArrayList<>();
    }
    this.creditProfile.add(creditProfileItem);
    return this;
  }

  /**
   * Get creditProfile
   * @return creditProfile
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CreditProfile> getCreditProfile() {
    return creditProfile;
  }

  public void setCreditProfile(List<CreditProfile> creditProfile) {
    this.creditProfile = creditProfile;
  }

  public CustomerCreate engagedParty(RelatedParty engagedParty) {
    this.engagedParty = engagedParty;
    return this;
  }

  /**
   * The party - an organization or an individual - that is engaged as a customer.
   * @return engagedParty
  **/
  @ApiModelProperty(required = true, value = "The party - an organization or an individual - that is engaged as a customer.")
  @NotNull

  @Valid

  public RelatedParty getEngagedParty() {
    return engagedParty;
  }

  public void setEngagedParty(RelatedParty engagedParty) {
    this.engagedParty = engagedParty;
  }

  public CustomerCreate paymentMethod(List<PaymentMethodRef> paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  public CustomerCreate addPaymentMethodItem(PaymentMethodRef paymentMethodItem) {
    if (this.paymentMethod == null) {
      this.paymentMethod = new ArrayList<>();
    }
    this.paymentMethod.add(paymentMethodItem);
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PaymentMethodRef> getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(List<PaymentMethodRef> paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public CustomerCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public CustomerCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public CustomerCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The time period that the Customer is valid for.
   * @return validFor
  **/
  @ApiModelProperty(value = "The time period that the Customer is valid for.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public CustomerCreate baseType(String baseType) {
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

  public CustomerCreate schemaLocation(String schemaLocation) {
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

  public CustomerCreate type(String type) {
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
    CustomerCreate customerCreate = (CustomerCreate) o;
    return Objects.equals(this.name, customerCreate.name) &&
        Objects.equals(this.status, customerCreate.status) &&
        Objects.equals(this.statusReason, customerCreate.statusReason) &&
        Objects.equals(this.account, customerCreate.account) &&
        Objects.equals(this.agreement, customerCreate.agreement) &&
        Objects.equals(this.characteristic, customerCreate.characteristic) &&
        Objects.equals(this.contactMedium, customerCreate.contactMedium) &&
        Objects.equals(this.creditProfile, customerCreate.creditProfile) &&
        Objects.equals(this.engagedParty, customerCreate.engagedParty) &&
        Objects.equals(this.paymentMethod, customerCreate.paymentMethod) &&
        Objects.equals(this.relatedParty, customerCreate.relatedParty) &&
        Objects.equals(this.validFor, customerCreate.validFor) &&
        Objects.equals(this.baseType, customerCreate.baseType) &&
        Objects.equals(this.schemaLocation, customerCreate.schemaLocation) &&
        Objects.equals(this.type, customerCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status, statusReason, account, agreement, characteristic, contactMedium, creditProfile, engagedParty, paymentMethod, relatedParty, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
    sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
    sb.append("    engagedParty: ").append(toIndentedString(engagedParty)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

