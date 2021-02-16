package io.openslice.tmf.po622.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Request for cancellation an existing product order Skipped properties: id,href,state,effectiveCancellationDate
 */
@ApiModel(description = "Request for cancellation an existing product order Skipped properties: id,href,state,effectiveCancellationDate")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class CancelProductOrderCreate   {
  @JsonProperty("cancellationReason")
  private String cancellationReason = null;

  @JsonProperty("requestedCancellationDate")
  private OffsetDateTime requestedCancellationDate = null;

  @JsonProperty("productOrder")
  private ProductOrderRef productOrder = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public CancelProductOrderCreate cancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
    return this;
  }

  /**
   * Reason why the order is cancelled.
   * @return cancellationReason
  **/
  @ApiModelProperty(value = "Reason why the order is cancelled.")
  
    public String getCancellationReason() {
    return cancellationReason;
  }

  public void setCancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public CancelProductOrderCreate requestedCancellationDate(OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
    return this;
  }

  /**
   * Date when the submitter wants the order to be cancelled
   * @return requestedCancellationDate
  **/
  @ApiModelProperty(value = "Date when the submitter wants the order to be cancelled")
  
    @Valid
    public OffsetDateTime getRequestedCancellationDate() {
    return requestedCancellationDate;
  }

  public void setRequestedCancellationDate(OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
  }

  public CancelProductOrderCreate productOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
    return this;
  }

  /**
   * Get productOrder
   * @return productOrder
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public ProductOrderRef getProductOrder() {
    return productOrder;
  }

  public void setProductOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
  }

  public CancelProductOrderCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public CancelProductOrderCreate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public CancelProductOrderCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String type) {
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
    CancelProductOrderCreate cancelProductOrderCreate = (CancelProductOrderCreate) o;
    return Objects.equals(this.cancellationReason, cancelProductOrderCreate.cancellationReason) &&
        Objects.equals(this.requestedCancellationDate, cancelProductOrderCreate.requestedCancellationDate) &&
        Objects.equals(this.productOrder, cancelProductOrderCreate.productOrder) &&
        Objects.equals(this.baseType, cancelProductOrderCreate.baseType) &&
        Objects.equals(this.schemaLocation, cancelProductOrderCreate.schemaLocation) &&
        Objects.equals(this.type, cancelProductOrderCreate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancellationReason, requestedCancellationDate, productOrder, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelProductOrderCreate {\n");
    
    sb.append("    cancellationReason: ").append(toIndentedString(cancellationReason)).append("\n");
    sb.append("    requestedCancellationDate: ").append(toIndentedString(requestedCancellationDate)).append("\n");
    sb.append("    productOrder: ").append(toIndentedString(productOrder)).append("\n");
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
