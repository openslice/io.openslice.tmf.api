package io.openslice.tmf.sim638.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Service Order reference. Useful to understand the which was the Service order through which the service was instantiated in the service inventory
 */
@ApiModel(description = "Service Order reference. Useful to understand the which was the Service order through which the service was instantiated in the service inventory")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")

public class ServiceOrderRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("serviceOrderItemId")
  private String serviceOrderItemId = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public ServiceOrderRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the Service Order
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the Service Order")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceOrderRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the Service Order
   * @return href
  **/
  @ApiModelProperty(required = true, value = "Reference of the Service Order")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceOrderRef serviceOrderItemId(String serviceOrderItemId) {
    this.serviceOrderItemId = serviceOrderItemId;
    return this;
  }

  /**
   * Unique identifier of the Service Order Item within a service order, not populated if this is a reference to a service order
   * @return serviceOrderItemId
  **/
  @ApiModelProperty(value = "Unique identifier of the Service Order Item within a service order, not populated if this is a reference to a service order")


  public String getServiceOrderItemId() {
    return serviceOrderItemId;
  }

  public void setServiceOrderItemId(String serviceOrderItemId) {
    this.serviceOrderItemId = serviceOrderItemId;
  }

  public ServiceOrderRef baseType(String baseType) {
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

  public ServiceOrderRef schemaLocation(String schemaLocation) {
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

  public ServiceOrderRef type(String type) {
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

  public ServiceOrderRef referredType(String referredType) {
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
    ServiceOrderRef serviceOrderRef = (ServiceOrderRef) o;
    return Objects.equals(this.id, serviceOrderRef.id) &&
        Objects.equals(this.href, serviceOrderRef.href) &&
        Objects.equals(this.serviceOrderItemId, serviceOrderRef.serviceOrderItemId) &&
        Objects.equals(this.baseType, serviceOrderRef.baseType) &&
        Objects.equals(this.schemaLocation, serviceOrderRef.schemaLocation) &&
        Objects.equals(this.type, serviceOrderRef.type) &&
        Objects.equals(this.referredType, serviceOrderRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, serviceOrderItemId, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    serviceOrderItemId: ").append(toIndentedString(serviceOrderItemId)).append("\n");
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

