/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.pcm620.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role. Skipped properties: id,href,lastUpdate
 */
@Schema(description = "Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role. Skipped properties: id,href,lastUpdate")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

public class ProductSpecificationUpdate   {
  @JsonProperty("brand")
  protected String brand = null;

  @JsonProperty("description")
  protected String description = null;

  @JsonProperty("isBundle")
  protected Boolean isBundle = null;

  @JsonProperty("lifecycleStatus")
  protected String lifecycleStatus = null;

  @JsonProperty("name")
  protected String name = null;

  @JsonProperty("productNumber")
  protected String productNumber = null;

  @JsonProperty("version")
  protected String version = null;

  @JsonProperty("attachment")
  @Valid
  protected List<AttachmentRefOrValue> attachment = null;

  @JsonProperty("bundledProductSpecification")
  @Valid
  protected List<BundledProductSpecification> bundledProductSpecification = null;

  @JsonProperty("productSpecCharacteristic")
  @Valid
  protected List<ProductSpecificationCharacteristic> productSpecCharacteristic = null;

  @JsonProperty("productSpecificationRelationship")
  @Valid
  protected List<ProductSpecificationRelationship> productSpecificationRelationship = null;

  @JsonProperty("relatedParty")
  @Valid
  protected List<RelatedParty> relatedParty = null;

  @JsonProperty("resourceSpecification")
  @Valid
  protected List<ResourceSpecificationRef> resourceSpecification = null;

  @JsonProperty("serviceSpecification")
  @Valid
  protected List<ServiceSpecificationRef> serviceSpecification = null;

  @JsonProperty("targetProductSchema")
  protected TargetProductSchema targetProductSchema = null;

  @JsonProperty("validFor")
  protected TimePeriod validFor = null;

  @JsonProperty("@baseType")
  protected String baseType = null;

  @JsonProperty("@schemaLocation")
  protected String schemaLocation = null;

  @JsonProperty("@type")
  protected String type = null;

  public ProductSpecificationUpdate brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * The manufacturer or trademark of the specification
   * @return brand
  **/
  @Schema(description = "The manufacturer or trademark of the specification")


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public ProductSpecificationUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the product specification is
   * @return description
  **/
  @Schema(description = "A narrative that explains in detail what the product specification is")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductSpecificationUpdate isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * isBundle determines whether a productSpecification represents a single productSpecification (false), or a bundle of productSpecification (true).
   * @return isBundle
  **/
  @Schema(description = "isBundle determines whether a productSpecification represents a single productSpecification (false), or a bundle of productSpecification (true).")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductSpecificationUpdate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status
   * @return lifecycleStatus
  **/
  @Schema(description = "Used to indicate the current lifecycle status")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ProductSpecificationUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product specification
   * @return name
  **/
  @Schema(description = "Name of the product specification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductSpecificationUpdate productNumber(String productNumber) {
    this.productNumber = productNumber;
    return this;
  }

  /**
   * An identification number assigned to uniquely identity the specification
   * @return productNumber
  **/
  @Schema(description = "An identification number assigned to uniquely identity the specification")


  public String getProductNumber() {
    return productNumber;
  }

  public void setProductNumber(String productNumber) {
    this.productNumber = productNumber;
  }

  public ProductSpecificationUpdate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Product specification version
   * @return version
  **/
  @Schema(description = "Product specification version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ProductSpecificationUpdate attachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ProductSpecificationUpdate addAttachmentItem(AttachmentRefOrValue attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Complements the description of an element (for instance a product) through video, pictures...
   * @return attachment
  **/
  @Schema(description = "Complements the description of an element (for instance a product) through video, pictures...")

  @Valid

  public List<AttachmentRefOrValue> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
  }

  public ProductSpecificationUpdate bundledProductSpecification(List<BundledProductSpecification> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
    return this;
  }

  public ProductSpecificationUpdate addBundledProductSpecificationItem(BundledProductSpecification bundledProductSpecificationItem) {
    if (this.bundledProductSpecification == null) {
      this.bundledProductSpecification = new ArrayList<>();
    }
    this.bundledProductSpecification.add(bundledProductSpecificationItem);
    return this;
  }

  /**
   * A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.
   * @return bundledProductSpecification
  **/
  @Schema(description = "A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.")

  @Valid

  public List<BundledProductSpecification> getBundledProductSpecification() {
    return bundledProductSpecification;
  }

  public void setBundledProductSpecification(List<BundledProductSpecification> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
  }

  public ProductSpecificationUpdate productSpecCharacteristic(List<ProductSpecificationCharacteristic> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
    return this;
  }

  public ProductSpecificationUpdate addProductSpecCharacteristicItem(ProductSpecificationCharacteristic productSpecCharacteristicItem) {
    if (this.productSpecCharacteristic == null) {
      this.productSpecCharacteristic = new ArrayList<>();
    }
    this.productSpecCharacteristic.add(productSpecCharacteristicItem);
    return this;
  }

  /**
   * A characteristic quality or distinctive feature of a ProductSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.
   * @return productSpecCharacteristic
  **/
  @Schema(description = "A characteristic quality or distinctive feature of a ProductSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.")

  @Valid

  public List<ProductSpecificationCharacteristic> getProductSpecCharacteristic() {
    return productSpecCharacteristic;
  }

  public void setProductSpecCharacteristic(List<ProductSpecificationCharacteristic> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
  }

  public ProductSpecificationUpdate productSpecificationRelationship(List<ProductSpecificationRelationship> productSpecificationRelationship) {
    this.productSpecificationRelationship = productSpecificationRelationship;
    return this;
  }

  public ProductSpecificationUpdate addProductSpecificationRelationshipItem(ProductSpecificationRelationship productSpecificationRelationshipItem) {
    if (this.productSpecificationRelationship == null) {
      this.productSpecificationRelationship = new ArrayList<>();
    }
    this.productSpecificationRelationship.add(productSpecificationRelationshipItem);
    return this;
  }

  /**
   * A migration, substitution, dependency or exclusivity relationship between/among product specifications.
   * @return productSpecificationRelationship
  **/
  @Schema(description = "A migration, substitution, dependency or exclusivity relationship between/among product specifications.")

  @Valid

  public List<ProductSpecificationRelationship> getProductSpecificationRelationship() {
    return productSpecificationRelationship;
  }

  public void setProductSpecificationRelationship(List<ProductSpecificationRelationship> productSpecificationRelationship) {
    this.productSpecificationRelationship = productSpecificationRelationship;
  }

  public ProductSpecificationUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductSpecificationUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * A related party defines party or party role linked to a specific entity.
   * @return relatedParty
  **/
  @Schema(description = "A related party defines party or party role linked to a specific entity.")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ProductSpecificationUpdate resourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  public ProductSpecificationUpdate addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
    if (this.resourceSpecification == null) {
      this.resourceSpecification = new ArrayList<>();
    }
    this.resourceSpecification.add(resourceSpecificationItem);
    return this;
  }

  /**
   * The ResourceSpecification is required to realize a ProductSpecification.
   * @return resourceSpecification
  **/
  @Schema(description = "The ResourceSpecification is required to realize a ProductSpecification.")

  @Valid

  public List<ResourceSpecificationRef> getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ProductSpecificationUpdate serviceSpecification(List<ServiceSpecificationRef> serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }

  public ProductSpecificationUpdate addServiceSpecificationItem(ServiceSpecificationRef serviceSpecificationItem) {
    if (this.serviceSpecification == null) {
      this.serviceSpecification = new ArrayList<>();
    }
    this.serviceSpecification.add(serviceSpecificationItem);
    return this;
  }

  /**
   * ServiceSpecification(s) required to realize a ProductSpecification.
   * @return serviceSpecification
  **/
  @Schema(description = "ServiceSpecification(s) required to realize a ProductSpecification.")

  @Valid

  public List<ServiceSpecificationRef> getServiceSpecification() {
    return serviceSpecification;
  }

  public void setServiceSpecification(List<ServiceSpecificationRef> serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
  }

  public ProductSpecificationUpdate targetProductSchema(TargetProductSchema targetProductSchema) {
    this.targetProductSchema = targetProductSchema;
    return this;
  }

  /**
   * A target product schema reference. The reference object to the schema and type of target product which is described by product specification.
   * @return targetProductSchema
  **/
  @Schema(description = "A target product schema reference. The reference object to the schema and type of target product which is described by product specification.")

  @Valid

  public TargetProductSchema getTargetProductSchema() {
    return targetProductSchema;
  }

  public void setTargetProductSchema(TargetProductSchema targetProductSchema) {
    this.targetProductSchema = targetProductSchema;
  }

  public ProductSpecificationUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the product specification is valid
   * @return validFor
  **/
  @Schema(description = "The period for which the product specification is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ProductSpecificationUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ProductSpecificationUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ProductSpecificationUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @Schema(description = "When sub-classing, this defines the sub-class entity name")


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
    ProductSpecificationUpdate productSpecificationUpdate = (ProductSpecificationUpdate) o;
    return Objects.equals(this.brand, productSpecificationUpdate.brand) &&
        Objects.equals(this.description, productSpecificationUpdate.description) &&
        Objects.equals(this.isBundle, productSpecificationUpdate.isBundle) &&
        Objects.equals(this.lifecycleStatus, productSpecificationUpdate.lifecycleStatus) &&
        Objects.equals(this.name, productSpecificationUpdate.name) &&
        Objects.equals(this.productNumber, productSpecificationUpdate.productNumber) &&
        Objects.equals(this.version, productSpecificationUpdate.version) &&
        Objects.equals(this.attachment, productSpecificationUpdate.attachment) &&
        Objects.equals(this.bundledProductSpecification, productSpecificationUpdate.bundledProductSpecification) &&
        Objects.equals(this.productSpecCharacteristic, productSpecificationUpdate.productSpecCharacteristic) &&
        Objects.equals(this.productSpecificationRelationship, productSpecificationUpdate.productSpecificationRelationship) &&
        Objects.equals(this.relatedParty, productSpecificationUpdate.relatedParty) &&
        Objects.equals(this.resourceSpecification, productSpecificationUpdate.resourceSpecification) &&
        Objects.equals(this.serviceSpecification, productSpecificationUpdate.serviceSpecification) &&
        Objects.equals(this.targetProductSchema, productSpecificationUpdate.targetProductSchema) &&
        Objects.equals(this.validFor, productSpecificationUpdate.validFor) &&
        Objects.equals(this.baseType, productSpecificationUpdate.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationUpdate.schemaLocation) &&
        Objects.equals(this.type, productSpecificationUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, description, isBundle, lifecycleStatus, name, productNumber, version, attachment, bundledProductSpecification, productSpecCharacteristic, productSpecificationRelationship, relatedParty, resourceSpecification, serviceSpecification, targetProductSchema, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationUpdate {\n");
    
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productNumber: ").append(toIndentedString(productNumber)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    bundledProductSpecification: ").append(toIndentedString(bundledProductSpecification)).append("\n");
    sb.append("    productSpecCharacteristic: ").append(toIndentedString(productSpecCharacteristic)).append("\n");
    sb.append("    productSpecificationRelationship: ").append(toIndentedString(productSpecificationRelationship)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
    sb.append("    targetProductSchema: ").append(toIndentedString(targetProductSchema)).append("\n");
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

