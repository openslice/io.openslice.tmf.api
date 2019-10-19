package io.openslice.tmf.prm669.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.prm669.model.AccountRef;
import io.openslice.tmf.prm669.model.AgreementRef;
import io.openslice.tmf.prm669.model.Characteristic;
import io.openslice.tmf.prm669.model.ContactMedium;
import io.openslice.tmf.prm669.model.CreditProfile;
import io.openslice.tmf.prm669.model.PaymentMethodRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.prm669.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The part played by a party in a given context.
 */
@ApiModel(description = "The part played by a party in a given context.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:20:50.154+03:00")

public class PartyRole   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

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

  public PartyRole id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for PartyRoles
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for PartyRoles")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PartyRole href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Url used to reference the party role.
   * @return href
  **/
  @ApiModelProperty(value = "Url used to reference the party role.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PartyRole name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.
   * @return name
  **/
  @ApiModelProperty(value = "A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PartyRole status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Used to track the lifecycle status of the party role.
   * @return status
  **/
  @ApiModelProperty(value = "Used to track the lifecycle status of the party role.")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PartyRole statusReason(String statusReason) {
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

  public PartyRole account(List<AccountRef> account) {
    this.account = account;
    return this;
  }

  public PartyRole addAccountItem(AccountRef accountItem) {
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

  public PartyRole agreement(List<AgreementRef> agreement) {
    this.agreement = agreement;
    return this;
  }

  public PartyRole addAgreementItem(AgreementRef agreementItem) {
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

  public PartyRole characteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public PartyRole addCharacteristicItem(Characteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * Describes the characteristic of a party role.
   * @return characteristic
  **/
  @ApiModelProperty(value = "Describes the characteristic of a party role.")

  @Valid

  public List<Characteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
  }

  public PartyRole contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public PartyRole addContactMediumItem(ContactMedium contactMediumItem) {
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

  public PartyRole creditProfile(List<CreditProfile> creditProfile) {
    this.creditProfile = creditProfile;
    return this;
  }

  public PartyRole addCreditProfileItem(CreditProfile creditProfileItem) {
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

  public PartyRole engagedParty(RelatedParty engagedParty) {
    this.engagedParty = engagedParty;
    return this;
  }

  /**
   * Get engagedParty
   * @return engagedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RelatedParty getEngagedParty() {
    return engagedParty;
  }

  public void setEngagedParty(RelatedParty engagedParty) {
    this.engagedParty = engagedParty;
  }

  public PartyRole paymentMethod(List<PaymentMethodRef> paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  public PartyRole addPaymentMethodItem(PaymentMethodRef paymentMethodItem) {
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

  public PartyRole relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public PartyRole addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public PartyRole validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The time period that the PartyRole is valid for.
   * @return validFor
  **/
  @ApiModelProperty(value = "The time period that the PartyRole is valid for.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public PartyRole baseType(String baseType) {
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

  public PartyRole schemaLocation(String schemaLocation) {
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

  public PartyRole type(String type) {
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
    PartyRole partyRole = (PartyRole) o;
    return Objects.equals(this.id, partyRole.id) &&
        Objects.equals(this.href, partyRole.href) &&
        Objects.equals(this.name, partyRole.name) &&
        Objects.equals(this.status, partyRole.status) &&
        Objects.equals(this.statusReason, partyRole.statusReason) &&
        Objects.equals(this.account, partyRole.account) &&
        Objects.equals(this.agreement, partyRole.agreement) &&
        Objects.equals(this.characteristic, partyRole.characteristic) &&
        Objects.equals(this.contactMedium, partyRole.contactMedium) &&
        Objects.equals(this.creditProfile, partyRole.creditProfile) &&
        Objects.equals(this.engagedParty, partyRole.engagedParty) &&
        Objects.equals(this.paymentMethod, partyRole.paymentMethod) &&
        Objects.equals(this.relatedParty, partyRole.relatedParty) &&
        Objects.equals(this.validFor, partyRole.validFor) &&
        Objects.equals(this.baseType, partyRole.baseType) &&
        Objects.equals(this.schemaLocation, partyRole.schemaLocation) &&
        Objects.equals(this.type, partyRole.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, status, statusReason, account, agreement, characteristic, contactMedium, creditProfile, engagedParty, paymentMethod, relatedParty, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyRole {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

