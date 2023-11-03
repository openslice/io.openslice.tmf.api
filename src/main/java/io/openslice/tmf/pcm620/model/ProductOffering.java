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

import io.openslice.tmf.am651.model.AgreementRef;
import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Represents entities that are orderable from the provider of the catalog, this
 * resource includes pricing information.
 */
@Schema(description = "Represents entities that are orderable from the provider of the catalog, this resource includes pricing information.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProductOffering")
@Table(name = "ProductOffering")
public class ProductOffering extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

	@JsonProperty("isSellable")
	private Boolean isSellable = null;

	@JsonProperty("statusReason")
	private String statusReason = null;

	@JsonProperty("agreement")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AgreementRef> agreement =  new HashSet<>();

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AttachmentRefOrValue> attachment = new HashSet<>();

	@JsonProperty("bundledProductOffering")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<BundledProductOffering> bundledProductOffering = new HashSet<>();

	@JsonProperty("category")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CategoryRef> category = new HashSet<>();

	@JsonProperty("channel")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ChannelRef> channel = new HashSet<>();

	@JsonProperty("marketSegment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<MarketSegmentRef> marketSegment = new HashSet<>();

	@JsonProperty("place")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<PlaceRef> place = new HashSet<>();

	@JsonProperty("prodSpecCharValueUse")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse = new HashSet<>();

	@JsonProperty("productOfferingPrice")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductOfferingPriceRef> productOfferingPrice = new HashSet<>();

	@JsonProperty("productOfferingTerm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductOfferingTerm> productOfferingTerm = new HashSet<>();

	@JsonProperty("productSpecification")
	@OneToOne( cascade = {CascadeType.MERGE, CascadeType.DETACH} )
    @JoinColumn(referencedColumnName = "uuid")
	private ProductSpecificationRef productSpecification = null;

	@JsonProperty("resourceCandidate")
	@OneToOne( cascade = {CascadeType.MERGE, CascadeType.DETACH} )
    @JoinColumn(referencedColumnName = "uuid")
	private ResourceCandidateRef resourceCandidate = null;

	@JsonProperty("serviceCandidate")
	@OneToOne( cascade = {CascadeType.MERGE, CascadeType.DETACH} )
    @JoinColumn(referencedColumnName = "uuid")
	private ServiceCandidateRef serviceCandidate = null;

	@JsonProperty("serviceLevelAgreement")
	@OneToOne( cascade = {CascadeType.MERGE, CascadeType.DETACH} )
    @JoinColumn(referencedColumnName = "uuid")
	private SLARef serviceLevelAgreement = null;

	public ProductOffering id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the productOffering
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the productOffering")

	public String getId() {
		if ( uuid != null ) {
			id = uuid;			
		} 
		return id;
	}


	

	public ProductOffering isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * isBundle determines whether a productOffering represents a single
	 * productOffering (false), or a bundle of productOfferings (true).
	 * 
	 * @return isBundle
	 **/
	@Schema(description = "isBundle determines whether a productOffering represents a single productOffering (false), or a bundle of productOfferings (true).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	public ProductOffering isSellable(Boolean isSellable) {
		this.isSellable = isSellable;
		return this;
	}

	/**
	 * A flag indicating if this product offer can be sold stand-alone for sale or
	 * not. If this flag is false it indicates that the offer can only be sold
	 * within a bundle.
	 * 
	 * @return isSellable
	 **/
	@Schema(description = "A flag indicating if this product offer can be sold stand-alone for sale or not. If this flag is false it indicates that the offer can only be sold within a bundle.")

	public Boolean isIsSellable() {
		return isSellable;
	}

	public void setIsSellable(Boolean isSellable) {
		this.isSellable = isSellable;
	}





	/**
	 * A string providing a complementary information on the value of the lifecycle
	 * status attribute.
	 * 
	 * @return statusReason
	 **/
	@Schema(description = "A string providing a complementary information on the value of the lifecycle status attribute.")

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	

	public ProductOffering agreement(Set<AgreementRef> agreement) {
		this.agreement = agreement;
		return this;
	}

	public ProductOffering addAgreementItem(AgreementRef agreementItem) {
		if (this.agreement == null) {
			this.agreement = new HashSet<>();
		}
		this.agreement.add(agreementItem);
		return this;
	}

	/**
	 * An agreement represents a contract or arrangement, either written or verbal
	 * and sometimes enforceable by law, such as a service level agreement or a
	 * customer price agreement. An agreement involves a number of other business
	 * entities, such as products, services, and resources and/or their
	 * specifications.
	 * 
	 * @return agreement
	 **/
	@Schema(description = "An agreement represents a contract or arrangement, either written or verbal and sometimes enforceable by law, such as a service level agreement or a customer price agreement. An agreement involves a number of other business entities, such as products, services, and resources and/or their specifications.")

	@Valid

	public Set<AgreementRef> getAgreement() {
		return agreement;
	}

	public void setAgreement(Set<AgreementRef> agreement) {
		this.agreement = agreement;
	}

	public ProductOffering attachment( Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ProductOffering addAttachmentItem(AttachmentRefOrValue attachmentItem) {
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

	public ProductOffering bundledProductOffering(Set<BundledProductOffering> bundledProductOffering) {
		this.bundledProductOffering = bundledProductOffering;
		return this;
	}

	public ProductOffering addBundledProductOfferingItem(BundledProductOffering bundledProductOfferingItem) {
		if (this.bundledProductOffering == null) {
			this.bundledProductOffering = new HashSet<>();
		}
		this.bundledProductOffering.add(bundledProductOfferingItem);
		return this;
	}

	/**
	 * A type of ProductOffering that belongs to a grouping of ProductOfferings made
	 * available to the market. It inherits of all attributes of ProductOffering.
	 * 
	 * @return bundledProductOffering
	 **/
	@Schema(description = "A type of ProductOffering that belongs to a grouping of ProductOfferings made available to the market. It inherits of all attributes of ProductOffering.")

	@Valid

	public Set<BundledProductOffering> getBundledProductOffering() {
		return bundledProductOffering;
	}

	public void setBundledProductOffering(Set<BundledProductOffering> bundledProductOffering) {
		this.bundledProductOffering = bundledProductOffering;
	}

	public ProductOffering category(Set<CategoryRef> category) {
		this.category = category;
		return this;
	}

	public ProductOffering addCategoryItem(CategoryRef categoryItem) {
		if (this.category == null) {
			this.category = new HashSet<>();
		}
		this.category.add(categoryItem);
		return this;
	}

	/**
	 * The category resource is used to group product offerings, service and
	 * resource candidates in logical containers. Categories can contain other
	 * categories and/or product offerings, resource or service candidates.
	 * 
	 * @return category
	 **/
	@Schema(description = "The category resource is used to group product offerings, service and resource candidates in logical containers. Categories can contain other categories and/or product offerings, resource or service candidates.")

	@Valid

	public Set<CategoryRef> getCategory() {
		return category;
	}

	public void setCategory(Set<CategoryRef> category) {
		this.category = category;
	}

	public ProductOffering channel(Set<ChannelRef> channel) {
		this.channel = channel;
		return this;
	}

	public ProductOffering addChannelItem(ChannelRef channelItem) {
		if (this.channel == null) {
			this.channel = new HashSet<>();
		}
		this.channel.add(channelItem);
		return this;
	}

	/**
	 * The channel defines the channel for selling product offerings.
	 * 
	 * @return channel
	 **/
	@Schema(description = "The channel defines the channel for selling product offerings.")

	@Valid

	public Set<ChannelRef> getChannel() {
		return channel;
	}

	public void setChannel(Set<ChannelRef> channel) {
		this.channel = channel;
	}

	public ProductOffering marketSegment(Set<MarketSegmentRef> marketSegment) {
		this.marketSegment = marketSegment;
		return this;
	}

	public ProductOffering addMarketSegmentItem(MarketSegmentRef marketSegmentItem) {
		if (this.marketSegment == null) {
			this.marketSegment = new HashSet<>();
		}
		this.marketSegment.add(marketSegmentItem);
		return this;
	}

	/**
	 * provides references to the corresponding market segment as target of product
	 * offerings. A market segment is grouping of Parties, GeographicAreas,
	 * SalesChannels, and so forth.
	 * 
	 * @return marketSegment
	 **/
	@Schema(description = "provides references to the corresponding market segment as target of product offerings. A market segment is grouping of Parties, GeographicAreas, SalesChannels, and so forth.")

	@Valid

	public Set<MarketSegmentRef> getMarketSegment() {
		return marketSegment;
	}

	public void setMarketSegment(Set<MarketSegmentRef> marketSegment) {
		this.marketSegment = marketSegment;
	}

	public ProductOffering place(Set<PlaceRef> place) {
		this.place = place;
		return this;
	}

	public ProductOffering addPlaceItem(PlaceRef placeItem) {
		if (this.place == null) {
			this.place = new HashSet<>();
		}
		this.place.add(placeItem);
		return this;
	}

	/**
	 * Place defines the places where the products are sold or delivered.
	 * 
	 * @return place
	 **/
	@Schema(description = "Place defines the places where the products are sold or delivered.")

	@Valid

	public Set<PlaceRef> getPlace() {
		return place;
	}

	public void setPlace(Set<PlaceRef> place) {
		this.place = place;
	}

	public ProductOffering prodSpecCharValueUse( Set<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse) {
		this.prodSpecCharValueUse = prodSpecCharValueUse;
		return this;
	}

	public ProductOffering addProdSpecCharValueUseItem(
			ProductSpecificationCharacteristicValueUse prodSpecCharValueUseItem) {
		if (this.prodSpecCharValueUse == null) {
			this.prodSpecCharValueUse = new HashSet<>();
		}
		this.prodSpecCharValueUse.add(prodSpecCharValueUseItem);
		return this;
	}

	/**
	 * A use of the ProductSpecificationCharacteristicValue by a ProductOffering to
	 * which additional properties (attributes) apply or override the properties of
	 * similar properties contained in ProductSpecificationCharacteristicValue. It
	 * should be noted that characteristics which their value(s) addressed by this
	 * object must exist in corresponding product specification. The available
	 * characteristic values for a ProductSpecificationCharacteristic in a Product
	 * specification can be modified at the ProductOffering level. For example, a
	 * characteristic 'Color' might have values White, Blue, Green, and Red. But,
	 * the list of values can be restricted to e.g. White and Blue in an associated
	 * product offering. It should be noted that the list of values in
	 * 'ProductSpecificationCharacteristicValueUse' is a strict subset of the list
	 * of values as defined in the corresponding product specification
	 * characteristics.
	 * 
	 * @return prodSpecCharValueUse
	 **/
	@Schema(description = "A use of the ProductSpecificationCharacteristicValue by a ProductOffering to which additional properties (attributes) apply or override the properties of similar properties contained in ProductSpecificationCharacteristicValue. It should be noted that characteristics which their value(s) addressed by this object must exist in corresponding product specification. The available characteristic values for a ProductSpecificationCharacteristic in a Product specification can be modified at the ProductOffering level. For example, a characteristic 'Color' might have values White, Blue, Green, and Red. But, the list of values can be restricted to e.g. White and Blue in an associated product offering. It should be noted that the list of values in 'ProductSpecificationCharacteristicValueUse' is a strict subset of the list of values as defined in the corresponding product specification characteristics.")

	@Valid

	public Set<ProductSpecificationCharacteristicValueUse> getProdSpecCharValueUse() {
		return prodSpecCharValueUse;
	}

	public void setProdSpecCharValueUse(Set<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse) {
		this.prodSpecCharValueUse = prodSpecCharValueUse;
	}

	public ProductOffering productOfferingPrice(Set<ProductOfferingPriceRef> productOfferingPrice) {
		this.productOfferingPrice = productOfferingPrice;
		return this;
	}

	public ProductOffering addProductOfferingPriceItem(ProductOfferingPriceRef productOfferingPriceItem) {
		if (this.productOfferingPrice == null) {
			this.productOfferingPrice = new HashSet<>();
		}
		this.productOfferingPrice.add(productOfferingPriceItem);
		return this;
	}

	/**
	 * An amount, usually of money, that is asked for or allowed when a
	 * ProductOffering is bought, rented, or leased. The price is valid for a
	 * defined period of time and may not represent the actual price paid by a
	 * customer.
	 * 
	 * @return productOfferingPrice
	 **/
	@Schema(description = "An amount, usually of money, that is asked for or allowed when a ProductOffering is bought, rented, or leased. The price is valid for a defined period of time and may not represent the actual price paid by a customer.")

	@Valid

	public Set<ProductOfferingPriceRef> getProductOfferingPrice() {
		return productOfferingPrice;
	}

	public void setProductOfferingPrice(Set<ProductOfferingPriceRef> productOfferingPrice) {
		this.productOfferingPrice = productOfferingPrice;
	}

	public ProductOffering productOfferingTerm(Set<ProductOfferingTerm> productOfferingTerm) {
		this.productOfferingTerm = productOfferingTerm;
		return this;
	}

	public ProductOffering addProductOfferingTermItem(ProductOfferingTerm productOfferingTermItem) {
		if (this.productOfferingTerm == null) {
			this.productOfferingTerm = new HashSet<>();
		}
		this.productOfferingTerm.add(productOfferingTermItem);
		return this;
	}

	/**
	 * A condition under which a ProductOffering is made available to Customers. For
	 * instance, a productOffering can be offered with multiple commitment periods.
	 * 
	 * @return productOfferingTerm
	 **/
	@Schema(description = "A condition under which a ProductOffering is made available to Customers. For instance, a productOffering can be offered with multiple commitment periods.")

	@Valid

	public Set<ProductOfferingTerm> getProductOfferingTerm() {
		return productOfferingTerm;
	}

	public void setProductOfferingTerm(Set<ProductOfferingTerm> productOfferingTerm) {
		this.productOfferingTerm = productOfferingTerm;
	}

	public ProductOffering productSpecification(ProductSpecificationRef productSpecification) {
		this.productSpecification = productSpecification;
		return this;
	}

	/**
	 * A ProductSpecification is a detailed description of a tangible or intangible
	 * object made available externally in the form of a ProductOffering to
	 * customers or other parties playing a party role.
	 * 
	 * @return productSpecification
	 **/
	@Schema(description = "A ProductSpecification is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.")

	@Valid

	public ProductSpecificationRef getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(ProductSpecificationRef productSpecification) {
		this.productSpecification = productSpecification;
	}

	public ProductOffering resourceCandidate(ResourceCandidateRef resourceCandidate) {
		this.resourceCandidate = resourceCandidate;
		return this;
	}

	/**
	 * A resource candidate is an entity that makes a ResourceSpecification
	 * available to a catalog.
	 * 
	 * @return resourceCandidate
	 **/
	@Schema(description = "A resource candidate is an entity that makes a ResourceSpecification available to a catalog.")

	@Valid

	public ResourceCandidateRef getResourceCandidate() {
		return resourceCandidate;
	}

	public void setResourceCandidate(ResourceCandidateRef resourceCandidate) {
		this.resourceCandidate = resourceCandidate;
	}

	public ProductOffering serviceCandidate(ServiceCandidateRef serviceCandidate) {
		this.serviceCandidate = serviceCandidate;
		return this;
	}

	/**
	 * ServiceCandidate is an entity that makes a ServiceSpecification available to
	 * a catalog.
	 * 
	 * @return serviceCandidate
	 **/
	@Schema(description = "ServiceCandidate is an entity that makes a ServiceSpecification available to a catalog.")

	@Valid

	public ServiceCandidateRef getServiceCandidate() {
		return serviceCandidate;
	}

	public void setServiceCandidate(ServiceCandidateRef serviceCandidate) {
		this.serviceCandidate = serviceCandidate;
	}

	public ProductOffering serviceLevelAgreement(SLARef serviceLevelAgreement) {
		this.serviceLevelAgreement = serviceLevelAgreement;
		return this;
	}

	/**
	 * A service level agreement (SLA) is a type of agreement that represents a
	 * formal negotiated agreement between two parties designed to create a common
	 * understanding about products, services, priorities, responsibilities, and so
	 * forth. The SLA is a set of appropriate procedures and targets formally or
	 * informally agreed between parties in order to achieve and maintain specified
	 * Quality of Service.
	 * 
	 * @return serviceLevelAgreement
	 **/
	@Schema(description = "A service level agreement (SLA) is a type of agreement that represents a formal negotiated agreement between two parties designed to create a common understanding about products, services, priorities, responsibilities, and so forth. The SLA is a set of appropriate procedures and targets formally or informally agreed between parties in order to achieve and maintain specified Quality of Service.")

	@Valid

	public SLARef getServiceLevelAgreement() {
		return serviceLevelAgreement;
	}

	public void setServiceLevelAgreement(SLARef serviceLevelAgreement) {
		this.serviceLevelAgreement = serviceLevelAgreement;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProductOffering productOffering = (ProductOffering) o;
		return Objects.equals(this.id, productOffering.id) && Objects.equals(this.href, productOffering.href)
				&& Objects.equals(this.description, productOffering.description)
				&& Objects.equals(this.isBundle, productOffering.isBundle)
				&& Objects.equals(this.isSellable, productOffering.isSellable)
				&& Objects.equals(this.lastUpdate, productOffering.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, productOffering.lifecycleStatus)
				&& Objects.equals(this.name, productOffering.name)
				&& Objects.equals(this.statusReason, productOffering.statusReason)
				&& Objects.equals(this.version, productOffering.version)
				&& Objects.equals(this.agreement, productOffering.agreement)
				&& Objects.equals(this.attachment, productOffering.attachment)
				&& Objects.equals(this.bundledProductOffering, productOffering.bundledProductOffering)
				&& Objects.equals(this.category, productOffering.category)
				&& Objects.equals(this.channel, productOffering.channel)
				&& Objects.equals(this.marketSegment, productOffering.marketSegment)
				&& Objects.equals(this.place, productOffering.place)
				&& Objects.equals(this.prodSpecCharValueUse, productOffering.prodSpecCharValueUse)
				&& Objects.equals(this.productOfferingPrice, productOffering.productOfferingPrice)
				&& Objects.equals(this.productOfferingTerm, productOffering.productOfferingTerm)
				&& Objects.equals(this.productSpecification, productOffering.productSpecification)
				&& Objects.equals(this.resourceCandidate, productOffering.resourceCandidate)
				&& Objects.equals(this.serviceCandidate, productOffering.serviceCandidate)
				&& Objects.equals(this.serviceLevelAgreement, productOffering.serviceLevelAgreement)
				&& Objects.equals(this.validFor, productOffering.validFor)
				&& Objects.equals(this.baseType, productOffering.baseType)
				&& Objects.equals(this.schemaLocation, productOffering.schemaLocation)
				&& Objects.equals(this.type, productOffering.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, description, isBundle, isSellable, lastUpdate, lifecycleStatus, name, statusReason, version, agreement, attachment, bundledProductOffering, category, channel, marketSegment, place, prodSpecCharValueUse, productOfferingPrice, productOfferingTerm, productSpecification, resourceCandidate, serviceCandidate, serviceLevelAgreement, validFor, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductOffering {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    isSellable: ").append(toIndentedString(isSellable)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    bundledProductOffering: ").append(toIndentedString(bundledProductOffering)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
		sb.append("    marketSegment: ").append(toIndentedString(marketSegment)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    prodSpecCharValueUse: ").append(toIndentedString(prodSpecCharValueUse)).append("\n");
		sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
		sb.append("    productOfferingTerm: ").append(toIndentedString(productOfferingTerm)).append("\n");
		sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
		sb.append("    resourceCandidate: ").append(toIndentedString(resourceCandidate)).append("\n");
		sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
		sb.append("    serviceLevelAgreement: ").append(toIndentedString(serviceLevelAgreement)).append("\n");
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
