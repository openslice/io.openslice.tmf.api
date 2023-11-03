package io.openslice.tmf.ro652.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Request for cancellation an existing resource order Skipped properties: id,href,state,effectiveCancellationDate
 */
@Schema(description = "Request for cancellation an existing resource order Skipped properties: id,href,state,effectiveCancellationDate")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class CancelResourceOrderCreate   {
  @JsonProperty("cancellationReason")
  private String cancellationReason = null;

  @JsonProperty("requestedCancellationDate")
  private OffsetDateTime requestedCancellationDate = null;

  @JsonProperty("resourceOrder")
  private ResourceOrderRef resourceOrder = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public CancelResourceOrderCreate cancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
    return this;
  }

  /**
   * Reason why the order is cancelled.
   * @return cancellationReason
  **/
  @Schema(description = "Reason why the order is cancelled.")
  
    public String getCancellationReason() {
    return cancellationReason;
  }

  public void setCancellationReason(String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public CancelResourceOrderCreate requestedCancellationDate(OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
    return this;
  }

  /**
   * Date when the submitter wants the order to be cancelled
   * @return requestedCancellationDate
  **/
  @Schema(description = "Date when the submitter wants the order to be cancelled")
  
    @Valid
    public OffsetDateTime getRequestedCancellationDate() {
    return requestedCancellationDate;
  }

  public void setRequestedCancellationDate(OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
  }

  public CancelResourceOrderCreate resourceOrder(ResourceOrderRef resourceOrder) {
    this.resourceOrder = resourceOrder;
    return this;
  }

  /**
   * Get resourceOrder
   * @return resourceOrder
  **/
  @Schema(description = "")
      @NotNull

    @Valid
    public ResourceOrderRef getResourceOrder() {
    return resourceOrder;
  }

  public void setResourceOrder(ResourceOrderRef resourceOrder) {
    this.resourceOrder = resourceOrder;
  }

  public CancelResourceOrderCreate _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public CancelResourceOrderCreate _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public CancelResourceOrderCreate _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")
  
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
    CancelResourceOrderCreate cancelResourceOrderCreate = (CancelResourceOrderCreate) o;
    return Objects.equals(this.cancellationReason, cancelResourceOrderCreate.cancellationReason) &&
        Objects.equals(this.requestedCancellationDate, cancelResourceOrderCreate.requestedCancellationDate) &&
        Objects.equals(this.resourceOrder, cancelResourceOrderCreate.resourceOrder) &&
        Objects.equals(this._atBaseType, cancelResourceOrderCreate._atBaseType) &&
        Objects.equals(this._atSchemaLocation, cancelResourceOrderCreate._atSchemaLocation) &&
        Objects.equals(this._atType, cancelResourceOrderCreate._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancellationReason, requestedCancellationDate, resourceOrder, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelResourceOrderCreate {\n");
    
    sb.append("    cancellationReason: ").append(toIndentedString(cancellationReason)).append("\n");
    sb.append("    requestedCancellationDate: ").append(toIndentedString(requestedCancellationDate)).append("\n");
    sb.append("    resourceOrder: ").append(toIndentedString(resourceOrder)).append("\n");
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
