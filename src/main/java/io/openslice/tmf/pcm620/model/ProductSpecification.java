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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * Is a detailed description of a tangible or intangible object made available
 * externally in the form of a ProductOffering to customers or other parties
 * playing a party role.
 */
@Schema(description = "Is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity
public class ProductSpecification extends BaseEntity {

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("brand")
	private String brand = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

	@JsonProperty("productNumber")
	private String productNumber = null;

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AttachmentRefOrValue> attachment =  new HashSet<>();

	@JsonProperty("bundledProductSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<BundledProductSpecification> bundledProductSpecification =  new HashSet<>();

	@JsonProperty("productSpecCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationCharacteristic> productSpecCharacteristic =  new HashSet<>();

	@JsonProperty("productSpecificationRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationRelationship> productSpecificationRelationship =  new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty =  new HashSet<>();

	@JsonProperty("resourceSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceSpecificationRef> resourceSpecification =  new HashSet<>();

	@JsonProperty("serviceSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceSpecificationRef> serviceSpecification =  new HashSet<>();

	@JsonProperty("targetProductSchema")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(referencedColumnName = "uuid")
	private TargetProductSchema targetProductSchema = null;

	

	public ProductSpecification id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the product specification
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the product specification")

	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	

	/**
	 * The manufacturer or trademark of the specification
	 * 
	 * @return brand
	 **/
	@Schema(description = "The manufacturer or trademark of the specification")

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	

	public ProductSpecification isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * isBundle determines whether a productSpecification represents a single
	 * productSpecification (false), or a bundle of productSpecification (true).
	 * 
	 * @return isBundle
	 **/
	@Schema(description = "isBundle determines whether a productSpecification represents a single productSpecification (false), or a bundle of productSpecification (true).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}


	public ProductSpecification productNumber(String productNumber) {
		this.productNumber = productNumber;
		return this;
	}

	/**
	 * An identification number assigned to uniquely identity the specification
	 * 
	 * @return productNumber
	 **/
	@Schema(description = "An identification number assigned to uniquely identity the specification")

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}


	public ProductSpecification attachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ProductSpecification addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new HashSet<>();
		}
		this.attachment.add(attachmentItem);
		return this;
	}

	/**
	 * Complements the description of an element (for instance a product) through
	 * video, pictures...
	 * 
	 * @return attachment
	 **/
	@Schema(description = "Complements the description of an element (for instance a product) through video, pictures...")

	@Valid

	public Set<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public ProductSpecification bundledProductSpecification(
			Set<BundledProductSpecification> bundledProductSpecification) {
		this.bundledProductSpecification = bundledProductSpecification;
		return this;
	}

	public ProductSpecification addBundledProductSpecificationItem(
			BundledProductSpecification bundledProductSpecificationItem) {
		if (this.bundledProductSpecification == null) {
			this.bundledProductSpecification = new HashSet<>();
		}
		this.bundledProductSpecification.add(bundledProductSpecificationItem);
		return this;
	}

	/**
	 * A type of ProductSpecification that belongs to a grouping of
	 * ProductSpecifications made available to the market. It inherits of all
	 * attributes of ProductSpecification.
	 * 
	 * @return bundledProductSpecification
	 **/
	@Schema(description = "A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.")

	@Valid

	public Set<BundledProductSpecification> getBundledProductSpecification() {
		return bundledProductSpecification;
	}

	public void setBundledProductSpecification(Set<BundledProductSpecification> bundledProductSpecification) {
		this.bundledProductSpecification = bundledProductSpecification;
	}

	public ProductSpecification productSpecCharacteristic(
			Set<ProductSpecificationCharacteristic> productSpecCharacteristic) {
		this.productSpecCharacteristic = productSpecCharacteristic;
		return this;
	}

	public ProductSpecification addProductSpecCharacteristicItem(
			ProductSpecificationCharacteristic productSpecCharacteristicItem) {
		if (this.productSpecCharacteristic == null) {
			this.productSpecCharacteristic = new HashSet<>();
		}
		this.productSpecCharacteristic.add(productSpecCharacteristicItem);
		return this;
	}

	/**
	 * A characteristic quality or distinctive feature of a ProductSpecification.
	 * The characteristic can be take on a discrete value, such as color, can take
	 * on a range of values, (for example, sensitivity of 100-240 mV), or can be
	 * derived from a formula (for example, usage time (hrs) = 30 - talk time *3).
	 * Certain characteristics, such as color, may be configured during the ordering
	 * or some other process.
	 * 
	 * @return productSpecCharacteristic
	 **/
	@Schema(description = "A characteristic quality or distinctive feature of a ProductSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.")

	@Valid

	public Set<ProductSpecificationCharacteristic> getProductSpecCharacteristic() {
		return productSpecCharacteristic;
	}

	public void setProductSpecCharacteristic(Set<ProductSpecificationCharacteristic> productSpecCharacteristic) {
		this.productSpecCharacteristic = productSpecCharacteristic;
	}

	public ProductSpecification productSpecificationRelationship(
			Set<ProductSpecificationRelationship> productSpecificationRelationship) {
		this.productSpecificationRelationship = productSpecificationRelationship;
		return this;
	}

	public ProductSpecification addProductSpecificationRelationshipItem(
			ProductSpecificationRelationship productSpecificationRelationshipItem) {
		if (this.productSpecificationRelationship == null) {
			this.productSpecificationRelationship = new HashSet<>();
		}
		this.productSpecificationRelationship.add(productSpecificationRelationshipItem);
		return this;
	}

	/**
	 * A migration, substitution, dependency or exclusivity relationship
	 * between/among product specifications.
	 * 
	 * @return productSpecificationRelationship
	 **/
	@Schema(description = "A migration, substitution, dependency or exclusivity relationship between/among product specifications.")

	@Valid

	public Set<ProductSpecificationRelationship> getProductSpecificationRelationship() {
		return productSpecificationRelationship;
	}

	public void setProductSpecificationRelationship(
			Set<ProductSpecificationRelationship> productSpecificationRelationship) {
		this.productSpecificationRelationship = productSpecificationRelationship;
	}

	public ProductSpecification relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ProductSpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * A related party defines party or party role linked to a specific entity.
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "A related party defines party or party role linked to a specific entity.")

	@Valid

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ProductSpecification resourceSpecification(Set<ResourceSpecificationRef> resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
		return this;
	}

	public ProductSpecification addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
		if (this.resourceSpecification == null) {
			this.resourceSpecification = new HashSet<>();
		}
		this.resourceSpecification.add(resourceSpecificationItem);
		return this;
	}

	/**
	 * The ResourceSpecification is required to realize a ProductSpecification.
	 * 
	 * @return resourceSpecification
	 **/
	@Schema(description = "The ResourceSpecification is required to realize a ProductSpecification.")

	@Valid

	public Set<ResourceSpecificationRef> getResourceSpecification() {
		return resourceSpecification;
	}

	public void setResourceSpecification(Set<ResourceSpecificationRef> resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
	}

	public ProductSpecification serviceSpecification(Set<ServiceSpecificationRef> serviceSpecification) {
		this.serviceSpecification = serviceSpecification;
		return this;
	}

	public ProductSpecification addServiceSpecificationItem(ServiceSpecificationRef serviceSpecificationItem) {
		if (this.serviceSpecification == null) {
			this.serviceSpecification = new HashSet<>();
		}
		this.serviceSpecification.add(serviceSpecificationItem);
		return this;
	}

	/**
	 * ServiceSpecification(s) required to realize a ProductSpecification.
	 * 
	 * @return serviceSpecification
	 **/
	@Schema(description = "ServiceSpecification(s) required to realize a ProductSpecification.")

	@Valid

	public Set<ServiceSpecificationRef> getServiceSpecification() {
		return serviceSpecification;
	}

	public void setServiceSpecification(Set<ServiceSpecificationRef> serviceSpecification) {
		this.serviceSpecification = serviceSpecification;
	}

	public ProductSpecification targetProductSchema(TargetProductSchema targetProductSchema) {
		this.targetProductSchema = targetProductSchema;
		return this;
	}

	/**
	 * A target product schema reference. The reference object to the schema and
	 * type of target product which is described by product specification.
	 * 
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

	


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProductSpecification productSpecification = (ProductSpecification) o;
		return Objects.equals(this.id, productSpecification.id) && Objects.equals(this.href, productSpecification.href)
				&& Objects.equals(this.brand, productSpecification.brand)
				&& Objects.equals(this.description, productSpecification.description)
				&& Objects.equals(this.isBundle, productSpecification.isBundle)
				&& Objects.equals(this.lastUpdate, productSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, productSpecification.lifecycleStatus)
				&& Objects.equals(this.name, productSpecification.name)
				&& Objects.equals(this.productNumber, productSpecification.productNumber)
				&& Objects.equals(this.version, productSpecification.version)
				&& Objects.equals(this.attachment, productSpecification.attachment)
				&& Objects.equals(this.bundledProductSpecification, productSpecification.bundledProductSpecification)
				&& Objects.equals(this.productSpecCharacteristic, productSpecification.productSpecCharacteristic)
				&& Objects.equals(this.productSpecificationRelationship,
						productSpecification.productSpecificationRelationship)
				&& Objects.equals(this.relatedParty, productSpecification.relatedParty)
				&& Objects.equals(this.resourceSpecification, productSpecification.resourceSpecification)
				&& Objects.equals(this.serviceSpecification, productSpecification.serviceSpecification)
				&& Objects.equals(this.targetProductSchema, productSpecification.targetProductSchema)
				&& Objects.equals(this.validFor, productSpecification.validFor)
				&& Objects.equals(this.baseType, productSpecification.baseType)
				&& Objects.equals(this.schemaLocation, productSpecification.schemaLocation)
				&& Objects.equals(this.type, productSpecification.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, brand, description, isBundle, lastUpdate, lifecycleStatus, name, productNumber,
//				version, attachment, bundledProductSpecification, productSpecCharacteristic,
//				productSpecificationRelationship, relatedParty, resourceSpecification, serviceSpecification,
//				targetProductSchema, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    productNumber: ").append(toIndentedString(productNumber)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    bundledProductSpecification: ").append(toIndentedString(bundledProductSpecification))
				.append("\n");
		sb.append("    productSpecCharacteristic: ").append(toIndentedString(productSpecCharacteristic)).append("\n");
		sb.append("    productSpecificationRelationship: ").append(toIndentedString(productSpecificationRelationship))
				.append("\n");
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
