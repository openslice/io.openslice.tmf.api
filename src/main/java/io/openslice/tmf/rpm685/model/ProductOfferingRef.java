package io.openslice.tmf.rpm685.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductOffering reference. A product offering represents entities that are orderable from the provider of the catalog, this resource includes pricing information.
 */
@ApiModel(description = "ProductOffering reference. A product offering represents entities that are orderable from the provider of the catalog, this resource includes pricing information.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class ProductOfferingRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

//  @JsonProperty("bundledProductOffering")
//  @Valid
//  private List<BundledProductOfferingRef> bundledProductOffering = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public ProductOfferingRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the product offering
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the product offering")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOfferingRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product offering
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the product offering")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product offering
   * @return name
  **/
  @ApiModelProperty(value = "Name of the product offering")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public ProductOfferingRef bundledProductOffering(List<BundledProductOfferingRef> bundledProductOffering) {
//    this.bundledProductOffering = bundledProductOffering;
//    return this;
//  }
//
//  public ProductOfferingRef addBundledProductOfferingItem(BundledProductOfferingRef bundledProductOfferingItem) {
//    if (this.bundledProductOffering == null) {
//      this.bundledProductOffering = new ArrayList<>();
//    }
//    this.bundledProductOffering.add(bundledProductOfferingItem);
//    return this;
//  }
//
//  /**
//   * Get bundledProductOffering
//   * @return bundledProductOffering
//  **/
//  @ApiModelProperty(value = "")
//      @Valid
//    public List<BundledProductOfferingRef> getBundledProductOffering() {
//    return bundledProductOffering;
//  }
//
//  public void setBundledProductOffering(List<BundledProductOfferingRef> bundledProductOffering) {
//    this.bundledProductOffering = bundledProductOffering;
//  }
//
//  public ProductOfferingRef _atReferredType(String _atReferredType) {
//    this._atReferredType = _atReferredType;
//    return this;
//  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingRef productOfferingRef = (ProductOfferingRef) o;
    return Objects.equals(this.href, productOfferingRef.href) &&
        Objects.equals(this.id, productOfferingRef.id) &&
        Objects.equals(this.name, productOfferingRef.name) &&
//        Objects.equals(this.bundledProductOffering, productOfferingRef.bundledProductOffering) &&
        Objects.equals(this._atReferredType, productOfferingRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name,  _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
//    sb.append("    bundledProductOffering: ").append(toIndentedString(bundledProductOffering)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
