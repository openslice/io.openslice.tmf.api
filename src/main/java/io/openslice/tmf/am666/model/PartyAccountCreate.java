package io.openslice.tmf.am666.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am666.model.AccountBalance;
import io.openslice.tmf.am666.model.AccountRelationship;
import io.openslice.tmf.am666.model.AccountTaxExemption;
import io.openslice.tmf.am666.model.BillStructure;
import io.openslice.tmf.am666.model.Contact;
import io.openslice.tmf.am666.model.FinancialAccountRef;
import io.openslice.tmf.am666.model.Money;
import io.openslice.tmf.am666.model.PaymentMethodRef;
import io.openslice.tmf.am666.model.PaymentPlan;
import io.openslice.tmf.am666.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Account used for billing or for settlement purposes concerning a given party (an organization or an individual). It is a specialization of entity Account. Skipped properties: id,href
 */
@ApiModel(description = "Account used for billing or for settlement purposes concerning a given party (an organization or an individual). It is a specialization of entity Account. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class PartyAccountCreate   {
  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastModified")
  private OffsetDateTime lastModified = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("paymentStatus")
  private String paymentStatus = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("accountBalance")
  @Valid
  private List<AccountBalance> accountBalance = null;

  @JsonProperty("accountRelationship")
  @Valid
  private List<AccountRelationship> accountRelationship = null;

  @JsonProperty("billStructure")
  private BillStructure billStructure = null;

  @JsonProperty("contact")
  @Valid
  private List<Contact> contact = null;

  @JsonProperty("creditLimit")
  private Money creditLimit = null;

  @JsonProperty("defaultPaymentMethod")
  private PaymentMethodRef defaultPaymentMethod = null;

  @JsonProperty("financialAccount")
  private FinancialAccountRef financialAccount = null;

  @JsonProperty("paymentPlan")
  @Valid
  private List<PaymentPlan> paymentPlan = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = new ArrayList<>();

  @JsonProperty("taxExemption")
  @Valid
  private List<AccountTaxExemption> taxExemption = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public PartyAccountCreate accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * A categorization of an account, such as individual, joint, and so forth, whose instances share some of the same characteristics. Note: for flexibility we use a String here but an implementation may use an enumeration with a limited list of valid values.
   * @return accountType
  **/
  @ApiModelProperty(value = "A categorization of an account, such as individual, joint, and so forth, whose instances share some of the same characteristics. Note: for flexibility we use a String here but an implementation may use an enumeration with a limited list of valid values.")


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public PartyAccountCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of the party account
   * @return description
  **/
  @ApiModelProperty(value = "Detailed description of the party account")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PartyAccountCreate lastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * Date of last modification of the account
   * @return lastModified
  **/
  @ApiModelProperty(value = "Date of last modification of the account")

  @Valid

  public OffsetDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(OffsetDateTime lastModified) {
    this.lastModified = lastModified;
  }

  public PartyAccountCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the account
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the account")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PartyAccountCreate paymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

  /**
   * The condition of the account, such as due, paid, in arrears.
   * @return paymentStatus
  **/
  @ApiModelProperty(value = "The condition of the account, such as due, paid, in arrears.")


  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public PartyAccountCreate state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   * @return state
  **/
  @ApiModelProperty(value = "Contains the lifecycle state such as: Active, Closed, Suspended and so on.")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public PartyAccountCreate accountBalance(List<AccountBalance> accountBalance) {
    this.accountBalance = accountBalance;
    return this;
  }

  public PartyAccountCreate addAccountBalanceItem(AccountBalance accountBalanceItem) {
    if (this.accountBalance == null) {
      this.accountBalance = new ArrayList<>();
    }
    this.accountBalance.add(accountBalanceItem);
    return this;
  }

  /**
   * Get accountBalance
   * @return accountBalance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountBalance> getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(List<AccountBalance> accountBalance) {
    this.accountBalance = accountBalance;
  }

  public PartyAccountCreate accountRelationship(List<AccountRelationship> accountRelationship) {
    this.accountRelationship = accountRelationship;
    return this;
  }

  public PartyAccountCreate addAccountRelationshipItem(AccountRelationship accountRelationshipItem) {
    if (this.accountRelationship == null) {
      this.accountRelationship = new ArrayList<>();
    }
    this.accountRelationship.add(accountRelationshipItem);
    return this;
  }

  /**
   * Get accountRelationship
   * @return accountRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountRelationship> getAccountRelationship() {
    return accountRelationship;
  }

  public void setAccountRelationship(List<AccountRelationship> accountRelationship) {
    this.accountRelationship = accountRelationship;
  }

  public PartyAccountCreate billStructure(BillStructure billStructure) {
    this.billStructure = billStructure;
    return this;
  }

  /**
   * Get billStructure
   * @return billStructure
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillStructure getBillStructure() {
    return billStructure;
  }

  public void setBillStructure(BillStructure billStructure) {
    this.billStructure = billStructure;
  }

  public PartyAccountCreate contact(List<Contact> contact) {
    this.contact = contact;
    return this;
  }

  public PartyAccountCreate addContactItem(Contact contactItem) {
    if (this.contact == null) {
      this.contact = new ArrayList<>();
    }
    this.contact.add(contactItem);
    return this;
  }

  /**
   * Get contact
   * @return contact
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Contact> getContact() {
    return contact;
  }

  public void setContact(List<Contact> contact) {
    this.contact = contact;
  }

  public PartyAccountCreate creditLimit(Money creditLimit) {
    this.creditLimit = creditLimit;
    return this;
  }

  /**
   * The maximum amount of money that may be charged on an account
   * @return creditLimit
  **/
  @ApiModelProperty(value = "The maximum amount of money that may be charged on an account")

  @Valid

  public Money getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(Money creditLimit) {
    this.creditLimit = creditLimit;
  }

  public PartyAccountCreate defaultPaymentMethod(PaymentMethodRef defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
    return this;
  }

  /**
   * Get defaultPaymentMethod
   * @return defaultPaymentMethod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PaymentMethodRef getDefaultPaymentMethod() {
    return defaultPaymentMethod;
  }

  public void setDefaultPaymentMethod(PaymentMethodRef defaultPaymentMethod) {
    this.defaultPaymentMethod = defaultPaymentMethod;
  }

  public PartyAccountCreate financialAccount(FinancialAccountRef financialAccount) {
    this.financialAccount = financialAccount;
    return this;
  }

  /**
   * Get financialAccount
   * @return financialAccount
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FinancialAccountRef getFinancialAccount() {
    return financialAccount;
  }

  public void setFinancialAccount(FinancialAccountRef financialAccount) {
    this.financialAccount = financialAccount;
  }

  public PartyAccountCreate paymentPlan(List<PaymentPlan> paymentPlan) {
    this.paymentPlan = paymentPlan;
    return this;
  }

  public PartyAccountCreate addPaymentPlanItem(PaymentPlan paymentPlanItem) {
    if (this.paymentPlan == null) {
      this.paymentPlan = new ArrayList<>();
    }
    this.paymentPlan.add(paymentPlanItem);
    return this;
  }

  /**
   * Get paymentPlan
   * @return paymentPlan
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PaymentPlan> getPaymentPlan() {
    return paymentPlan;
  }

  public void setPaymentPlan(List<PaymentPlan> paymentPlan) {
    this.paymentPlan = paymentPlan;
  }

  public PartyAccountCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public PartyAccountCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@Size(min=1) 
  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public PartyAccountCreate taxExemption(List<AccountTaxExemption> taxExemption) {
    this.taxExemption = taxExemption;
    return this;
  }

  public PartyAccountCreate addTaxExemptionItem(AccountTaxExemption taxExemptionItem) {
    if (this.taxExemption == null) {
      this.taxExemption = new ArrayList<>();
    }
    this.taxExemption.add(taxExemptionItem);
    return this;
  }

  /**
   * Get taxExemption
   * @return taxExemption
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountTaxExemption> getTaxExemption() {
    return taxExemption;
  }

  public void setTaxExemption(List<AccountTaxExemption> taxExemption) {
    this.taxExemption = taxExemption;
  }

  public PartyAccountCreate baseType(String baseType) {
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

  public PartyAccountCreate schemaLocation(String schemaLocation) {
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

  public PartyAccountCreate type(String type) {
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
    PartyAccountCreate partyAccountCreate = (PartyAccountCreate) o;
    return Objects.equals(this.accountType, partyAccountCreate.accountType) &&
        Objects.equals(this.description, partyAccountCreate.description) &&
        Objects.equals(this.lastModified, partyAccountCreate.lastModified) &&
        Objects.equals(this.name, partyAccountCreate.name) &&
        Objects.equals(this.paymentStatus, partyAccountCreate.paymentStatus) &&
        Objects.equals(this.state, partyAccountCreate.state) &&
        Objects.equals(this.accountBalance, partyAccountCreate.accountBalance) &&
        Objects.equals(this.accountRelationship, partyAccountCreate.accountRelationship) &&
        Objects.equals(this.billStructure, partyAccountCreate.billStructure) &&
        Objects.equals(this.contact, partyAccountCreate.contact) &&
        Objects.equals(this.creditLimit, partyAccountCreate.creditLimit) &&
        Objects.equals(this.defaultPaymentMethod, partyAccountCreate.defaultPaymentMethod) &&
        Objects.equals(this.financialAccount, partyAccountCreate.financialAccount) &&
        Objects.equals(this.paymentPlan, partyAccountCreate.paymentPlan) &&
        Objects.equals(this.relatedParty, partyAccountCreate.relatedParty) &&
        Objects.equals(this.taxExemption, partyAccountCreate.taxExemption) &&
        Objects.equals(this.baseType, partyAccountCreate.baseType) &&
        Objects.equals(this.schemaLocation, partyAccountCreate.schemaLocation) &&
        Objects.equals(this.type, partyAccountCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountType, description, lastModified, name, paymentStatus, state, accountBalance, accountRelationship, billStructure, contact, creditLimit, defaultPaymentMethod, financialAccount, paymentPlan, relatedParty, taxExemption, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyAccountCreate {\n");
    
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    accountRelationship: ").append(toIndentedString(accountRelationship)).append("\n");
    sb.append("    billStructure: ").append(toIndentedString(billStructure)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    creditLimit: ").append(toIndentedString(creditLimit)).append("\n");
    sb.append("    defaultPaymentMethod: ").append(toIndentedString(defaultPaymentMethod)).append("\n");
    sb.append("    financialAccount: ").append(toIndentedString(financialAccount)).append("\n");
    sb.append("    paymentPlan: ").append(toIndentedString(paymentPlan)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    taxExemption: ").append(toIndentedString(taxExemption)).append("\n");
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

