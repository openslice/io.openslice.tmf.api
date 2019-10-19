package io.openslice.tmf.am666.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am666.model.AccountBalance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountReceivable reference. An account of money owed by a party to another entity in exchange for goods or services that have been delivered or used. An account receivable aggregates the amounts of one or more party accounts (billing or settlement) owned by a given party.
 */
@ApiModel(description = "AccountReceivable reference. An account of money owed by a party to another entity in exchange for goods or services that have been delivered or used. An account receivable aggregates the amounts of one or more party accounts (billing or settlement) owned by a given party.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class FinancialAccountRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("accountBalance")
  private AccountBalance accountBalance = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public FinancialAccountRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the account
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the account")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FinancialAccountRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the account
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the account")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public FinancialAccountRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the account
   * @return name
  **/
  @ApiModelProperty(value = "Name of the account")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FinancialAccountRef accountBalance(AccountBalance accountBalance) {
    this.accountBalance = accountBalance;
    return this;
  }

  /**
   * Get accountBalance
   * @return accountBalance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccountBalance getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(AccountBalance accountBalance) {
    this.accountBalance = accountBalance;
  }

  public FinancialAccountRef baseType(String baseType) {
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

  public FinancialAccountRef schemaLocation(String schemaLocation) {
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

  public FinancialAccountRef type(String type) {
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

  public FinancialAccountRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return referredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialAccountRef financialAccountRef = (FinancialAccountRef) o;
    return Objects.equals(this.id, financialAccountRef.id) &&
        Objects.equals(this.href, financialAccountRef.href) &&
        Objects.equals(this.name, financialAccountRef.name) &&
        Objects.equals(this.accountBalance, financialAccountRef.accountBalance) &&
        Objects.equals(this.baseType, financialAccountRef.baseType) &&
        Objects.equals(this.schemaLocation, financialAccountRef.schemaLocation) &&
        Objects.equals(this.type, financialAccountRef.type) &&
        Objects.equals(this.referredType, financialAccountRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, accountBalance, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialAccountRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

