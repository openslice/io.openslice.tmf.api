package io.openslice.tmf.am666.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am666.model.Money;
import io.openslice.tmf.am666.model.PaymentMethodRef;
import io.openslice.tmf.am666.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Defines a plan for payment (when a party wants to spread his payments)
 */
@ApiModel(description = "Defines a plan for payment (when a party wants to spread his payments)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class PaymentPlan   {
  @JsonProperty("numberOfPayments")
  private Integer numberOfPayments = null;

  @JsonProperty("paymentFrequency")
  private String paymentFrequency = null;

  @JsonProperty("planType")
  private String planType = null;

  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("paymentMethod")
  private PaymentMethodRef paymentMethod = null;

  @JsonProperty("totalAmount")
  private Money totalAmount = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public PaymentPlan numberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
    return this;
  }

  /**
   * Number of payments used to spread the global payment
   * @return numberOfPayments
  **/
  @ApiModelProperty(value = "Number of payments used to spread the global payment")


  public Integer getNumberOfPayments() {
    return numberOfPayments;
  }

  public void setNumberOfPayments(Integer numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  public PaymentPlan paymentFrequency(String paymentFrequency) {
    this.paymentFrequency = paymentFrequency;
    return this;
  }

  /**
   * Frequency of the payments, such as monthly and bimonthly
   * @return paymentFrequency
  **/
  @ApiModelProperty(value = "Frequency of the payments, such as monthly and bimonthly")


  public String getPaymentFrequency() {
    return paymentFrequency;
  }

  public void setPaymentFrequency(String paymentFrequency) {
    this.paymentFrequency = paymentFrequency;
  }

  public PaymentPlan planType(String planType) {
    this.planType = planType;
    return this;
  }

  /**
   * Type of payment plan
   * @return planType
  **/
  @ApiModelProperty(value = "Type of payment plan")


  public String getPlanType() {
    return planType;
  }

  public void setPlanType(String planType) {
    this.planType = planType;
  }

  public PaymentPlan priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority of the payment plan
   * @return priority
  **/
  @ApiModelProperty(value = "Priority of the payment plan")


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PaymentPlan status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the payment plan (effective, ineffective)
   * @return status
  **/
  @ApiModelProperty(value = "Status of the payment plan (effective, ineffective)")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PaymentPlan paymentMethod(PaymentMethodRef paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PaymentMethodRef getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethodRef paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public PaymentPlan totalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Amount paid
   * @return totalAmount
  **/
  @ApiModelProperty(value = "Amount paid")

  @Valid

  public Money getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Money totalAmount) {
    this.totalAmount = totalAmount;
  }

  public PaymentPlan validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Validity period of the payment plan
   * @return validFor
  **/
  @ApiModelProperty(value = "Validity period of the payment plan")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public PaymentPlan baseType(String baseType) {
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

  public PaymentPlan schemaLocation(String schemaLocation) {
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

  public PaymentPlan type(String type) {
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
    PaymentPlan paymentPlan = (PaymentPlan) o;
    return Objects.equals(this.numberOfPayments, paymentPlan.numberOfPayments) &&
        Objects.equals(this.paymentFrequency, paymentPlan.paymentFrequency) &&
        Objects.equals(this.planType, paymentPlan.planType) &&
        Objects.equals(this.priority, paymentPlan.priority) &&
        Objects.equals(this.status, paymentPlan.status) &&
        Objects.equals(this.paymentMethod, paymentPlan.paymentMethod) &&
        Objects.equals(this.totalAmount, paymentPlan.totalAmount) &&
        Objects.equals(this.validFor, paymentPlan.validFor) &&
        Objects.equals(this.baseType, paymentPlan.baseType) &&
        Objects.equals(this.schemaLocation, paymentPlan.schemaLocation) &&
        Objects.equals(this.type, paymentPlan.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfPayments, paymentFrequency, planType, priority, status, paymentMethod, totalAmount, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentPlan {\n");
    
    sb.append("    numberOfPayments: ").append(toIndentedString(numberOfPayments)).append("\n");
    sb.append("    paymentFrequency: ").append(toIndentedString(paymentFrequency)).append("\n");
    sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
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

