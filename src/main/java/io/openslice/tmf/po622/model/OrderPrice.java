package io.openslice.tmf.po622.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An amount, usually of money, that represents the actual price paid by the Customer for this item or this order
 */
@ApiModel(description = "An amount, usually of money, that represents the actual price paid by the Customer for this item or this order")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class OrderPrice   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("priceType")
  private String priceType = null;

  @JsonProperty("recurringChargePeriod")
  private String recurringChargePeriod = null;

  @JsonProperty("unitOfMeasure")
  private String unitOfMeasure = null;

  @JsonProperty("billingAccount")
  private BillingAccountRef billingAccount = null;

  @JsonProperty("price")
  private Price price = null;

  @JsonProperty("priceAlteration")
  @Valid
  private List<PriceAlteration> priceAlteration = null;

  @JsonProperty("productOfferingPrice")
  private ProductOfferingPriceRef productOfferingPrice = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public OrderPrice description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail the semantics of this order item price.
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail the semantics of this order item price.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrderPrice name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A short descriptive name such as \"Subscription price\".
   * @return name
  **/
  @ApiModelProperty(value = "A short descriptive name such as \"Subscription price\".")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrderPrice priceType(String priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * A category that describes the price, such as recurring, discount, allowance, penalty, and so forth
   * @return priceType
  **/
  @ApiModelProperty(value = "A category that describes the price, such as recurring, discount, allowance, penalty, and so forth")
  
    public String getPriceType() {
    return priceType;
  }

  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  public OrderPrice recurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

  /**
   * Could be month, week...
   * @return recurringChargePeriod
  **/
  @ApiModelProperty(value = "Could be month, week...")
  
    public String getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public OrderPrice unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Could be minutes, GB...
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "Could be minutes, GB...")
  
    public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public OrderPrice billingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  /**
   * Get billingAccount
   * @return billingAccount
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BillingAccountRef getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
  }

  public OrderPrice price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public OrderPrice priceAlteration(List<PriceAlteration> priceAlteration) {
    this.priceAlteration = priceAlteration;
    return this;
  }

  public OrderPrice addPriceAlterationItem(PriceAlteration priceAlterationItem) {
    if (this.priceAlteration == null) {
      this.priceAlteration = new ArrayList<>();
    }
    this.priceAlteration.add(priceAlterationItem);
    return this;
  }

  /**
   * a strucuture used to describe a price alteration
   * @return priceAlteration
  **/
  @ApiModelProperty(value = "a strucuture used to describe a price alteration")
      @Valid
    public List<PriceAlteration> getPriceAlteration() {
    return priceAlteration;
  }

  public void setPriceAlteration(List<PriceAlteration> priceAlteration) {
    this.priceAlteration = priceAlteration;
  }

  public OrderPrice productOfferingPrice(ProductOfferingPriceRef productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  /**
   * Get productOfferingPrice
   * @return productOfferingPrice
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ProductOfferingPriceRef getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(ProductOfferingPriceRef productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
  }

  public OrderPrice _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public OrderPrice _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public OrderPrice _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderPrice orderPrice = (OrderPrice) o;
    return Objects.equals(this.description, orderPrice.description) &&
        Objects.equals(this.name, orderPrice.name) &&
        Objects.equals(this.priceType, orderPrice.priceType) &&
        Objects.equals(this.recurringChargePeriod, orderPrice.recurringChargePeriod) &&
        Objects.equals(this.unitOfMeasure, orderPrice.unitOfMeasure) &&
        Objects.equals(this.billingAccount, orderPrice.billingAccount) &&
        Objects.equals(this.price, orderPrice.price) &&
        Objects.equals(this.priceAlteration, orderPrice.priceAlteration) &&
        Objects.equals(this.productOfferingPrice, orderPrice.productOfferingPrice) &&
        Objects.equals(this._atBaseType, orderPrice._atBaseType) &&
        Objects.equals(this._atSchemaLocation, orderPrice._atSchemaLocation) &&
        Objects.equals(this._atType, orderPrice._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, priceType, recurringChargePeriod, unitOfMeasure, billingAccount, price, priceAlteration, productOfferingPrice, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderPrice {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceAlteration: ").append(toIndentedString(priceAlteration)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
