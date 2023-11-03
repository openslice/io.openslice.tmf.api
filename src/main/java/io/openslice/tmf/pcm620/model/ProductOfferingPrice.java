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

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.Quantity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Is based on both the basic cost to develop and produce products and the
 * enterprises policy on revenue targets. This price may be further revised
 * through discounting (productOfferPriceAlteration). The price, applied for a
 * productOffering may also be influenced by the productOfferingTerm, the
 * customer selected, eg: a productOffering can be offered with multiple terms,
 * like commitment periods for the contract. The price may be influenced by this
 * productOfferingTerm. A productOffering may be cheaper with a 24 month
 * commitment than with a 12 month commitment.
 */
@Schema(description = "Is based on both the basic cost to develop and produce products and the enterprises policy on revenue targets. This price may be further revised through discounting (productOfferPriceAlteration). The price, applied for a productOffering may also be influenced by the productOfferingTerm, the customer selected, eg: a productOffering can be offered with multiple terms, like commitment periods for the contract. The price may be influenced by this productOfferingTerm. A productOffering may be cheaper with a 24 month commitment than with a 12 month commitment.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProductOfferingPrice")
@Table(name = "ProductOfferingPrice")
public class ProductOfferingPrice extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

	@JsonProperty("percentage")
	private Float percentage = null;

	@JsonProperty("priceType")
	private String priceType = null;

	@JsonProperty("recurringChargePeriodLength")
	private Integer recurringChargePeriodLength = null;

	@JsonProperty("recurringChargePeriodType")
	private String recurringChargePeriodType = null;

	@JsonProperty("bundledPopRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<BundledProductOfferingPriceRelationship> bundledPopRelationship = new HashSet<>();

	@JsonProperty("constraint")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ConstraintRef> constraint = new HashSet<>();

	@JsonProperty("place")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<PlaceRef> place = new HashSet<>();

	@JsonProperty("popRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductOfferingPriceRelationship> popRelationship = new HashSet<>();

	@JsonProperty("price")
	private Money price = null;

	@JsonProperty("pricingLogicAlgorithm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<PricingLogicAlgorithm> pricingLogicAlgorithm = new HashSet<>();

	@JsonProperty("prodSpecCharValueUse")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse = new HashSet<>();

	@JsonProperty("productOfferingTerm")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductOfferingTerm> productOfferingTerm = new HashSet<>();

	@JsonProperty("tax")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<TaxItem> tax = new HashSet<>();

	@JsonProperty("unitOfMeasure")
	private Quantity unitOfMeasure = null;

	public ProductOfferingPrice id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique id of this resource
	 * 
	 * @return id
	 **/
	@Schema(description = "unique id of this resource")

	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public ProductOfferingPrice href(String href) {
		this.href = href;
		return this;
	}

	public ProductOfferingPrice isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * A flag indicating if this ProductOfferingPrice is composite (bundle) or not
	 * 
	 * @return isBundle
	 **/
	@Schema(description = "A flag indicating if this ProductOfferingPrice is composite (bundle) or not")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	public ProductOfferingPrice percentage(Float percentage) {
		this.percentage = percentage;
		return this;
	}

	/**
	 * Percentage to apply for ProductOfferPriceAlteration (Discount)
	 * 
	 * @return percentage
	 **/
	@Schema(description = "Percentage to apply for ProductOfferPriceAlteration (Discount)")

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public ProductOfferingPrice priceType(String priceType) {
		this.priceType = priceType;
		return this;
	}

	/**
	 * A category that describes the price, such as recurring, discount, allowance,
	 * penalty, and so forth.
	 * 
	 * @return priceType
	 **/
	@Schema(description = "A category that describes the price, such as recurring, discount, allowance, penalty, and so forth.")

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public ProductOfferingPrice recurringChargePeriodLength(Integer recurringChargePeriodLength) {
		this.recurringChargePeriodLength = recurringChargePeriodLength;
		return this;
	}

	/**
	 * the period of the recurring charge: 1, 2, ... .It sets to zero if it is not
	 * applicable
	 * 
	 * @return recurringChargePeriodLength
	 **/
	@Schema(description = "the period of the recurring charge:  1, 2, ... .It sets to zero if it is not applicable")

	public Integer getRecurringChargePeriodLength() {
		return recurringChargePeriodLength;
	}

	public void setRecurringChargePeriodLength(Integer recurringChargePeriodLength) {
		this.recurringChargePeriodLength = recurringChargePeriodLength;
	}

	public ProductOfferingPrice recurringChargePeriodType(String recurringChargePeriodType) {
		this.recurringChargePeriodType = recurringChargePeriodType;
		return this;
	}

	/**
	 * The period to repeat the application of the price Could be month, week...
	 * 
	 * @return recurringChargePeriodType
	 **/
	@Schema(description = "The period to repeat the application of the price Could be month, week...")

	public String getRecurringChargePeriodType() {
		return recurringChargePeriodType;
	}

	public void setRecurringChargePeriodType(String recurringChargePeriodType) {
		this.recurringChargePeriodType = recurringChargePeriodType;
	}

	public ProductOfferingPrice bundledPopRelationship(
			Set<BundledProductOfferingPriceRelationship> bundledPopRelationship) {
		this.bundledPopRelationship = bundledPopRelationship;
		return this;
	}

	public ProductOfferingPrice addBundledPopRelationshipItem(
			BundledProductOfferingPriceRelationship bundledPopRelationshipItem) {
		if (this.bundledPopRelationship == null) {
			this.bundledPopRelationship = new HashSet<>();
		}
		this.bundledPopRelationship.add(bundledPopRelationshipItem);
		return this;
	}

	/**
	 * this object represents a bundle relationship from a bundle product offering
	 * price (parent) to a simple product offering price (child). A simple product
	 * offering price may participate in more than one bundle relationship.
	 * 
	 * @return bundledPopRelationship
	 **/
	@Schema(description = "this object represents a bundle relationship from a bundle product offering price (parent) to a simple product offering price (child). A simple product offering price may participate in more than one bundle relationship.")

	@Valid

	public Set<BundledProductOfferingPriceRelationship> getBundledPopRelationship() {
		return bundledPopRelationship;
	}

	public void setBundledPopRelationship(Set<BundledProductOfferingPriceRelationship> bundledPopRelationship) {
		this.bundledPopRelationship = bundledPopRelationship;
	}

	public ProductOfferingPrice constraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
		return this;
	}

	public ProductOfferingPrice addConstraintItem(ConstraintRef constraintItem) {
		if (this.constraint == null) {
			this.constraint = new HashSet<>();
		}
		this.constraint.add(constraintItem);
		return this;
	}

	/**
	 * The Constraint resource represents a policy/rule applied to
	 * ProductOfferingPrice.
	 * 
	 * @return constraint
	 **/
	@Schema(description = "The Constraint resource represents a policy/rule applied to ProductOfferingPrice.")

	@Valid

	public Set<ConstraintRef> getConstraint() {
		return constraint;
	}

	public void setConstraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
	}

	public ProductOfferingPrice place(Set<PlaceRef> place) {
		this.place = place;
		return this;
	}

	public ProductOfferingPrice addPlaceItem(PlaceRef placeItem) {
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

	public ProductOfferingPrice popRelationship(Set<ProductOfferingPriceRelationship> popRelationship) {
		this.popRelationship = popRelationship;
		return this;
	}

	public ProductOfferingPrice addPopRelationshipItem(ProductOfferingPriceRelationship popRelationshipItem) {
		if (this.popRelationship == null) {
			this.popRelationship = new HashSet<>();
		}
		this.popRelationship.add(popRelationshipItem);
		return this;
	}

	/**
	 * Product Offering Prices related to this Product Offering Price, for example a
	 * price alteration such as allowance or discount
	 * 
	 * @return popRelationship
	 **/
	@Schema(description = "Product Offering Prices related to this Product Offering Price, for example a price alteration such as allowance or discount")

	@Valid

	public Set<ProductOfferingPriceRelationship> getPopRelationship() {
		return popRelationship;
	}

	public void setPopRelationship(Set<ProductOfferingPriceRelationship> popRelationship) {
		this.popRelationship = popRelationship;
	}

	public ProductOfferingPrice price(Money price) {
		this.price = price;
		return this;
	}

	/**
	 * The amount of money that characterizes the price.
	 * 
	 * @return price
	 **/
	@Schema(description = "The amount of money that characterizes the price.")

	@Valid

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public ProductOfferingPrice pricingLogicAlgorithm(Set<PricingLogicAlgorithm> pricingLogicAlgorithm) {
		this.pricingLogicAlgorithm = pricingLogicAlgorithm;
		return this;
	}

	public ProductOfferingPrice addPricingLogicAlgorithmItem(PricingLogicAlgorithm pricingLogicAlgorithmItem) {
		if (this.pricingLogicAlgorithm == null) {
			this.pricingLogicAlgorithm = new HashSet<>();
		}
		this.pricingLogicAlgorithm.add(pricingLogicAlgorithmItem);
		return this;
	}

	/**
	 * The PricingLogicAlgorithm entity represents an instantiation of an interface
	 * specification to external rating function (without a modeled behavior in
	 * SID). Some of the parameters of the interface definition may be already set
	 * (such as price per unit) and some may be gathered during the rating process
	 * from the event (such as call duration) or from ProductCharacteristicValues
	 * (such as assigned bandwidth).
	 * 
	 * @return pricingLogicAlgorithm
	 **/
	@Schema(description = "The PricingLogicAlgorithm entity represents an instantiation of an interface specification to external rating function (without a modeled behavior in SID). Some of the parameters of the interface definition may be already set (such as price per unit) and some may be gathered during the rating process from the event (such as call duration) or from ProductCharacteristicValues (such as assigned bandwidth).")

	@Valid

	public Set<PricingLogicAlgorithm> getPricingLogicAlgorithm() {
		return pricingLogicAlgorithm;
	}

	public void setPricingLogicAlgorithm(Set<PricingLogicAlgorithm> pricingLogicAlgorithm) {
		this.pricingLogicAlgorithm = pricingLogicAlgorithm;
	}

	public ProductOfferingPrice prodSpecCharValueUse(
			Set<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse) {
		this.prodSpecCharValueUse = prodSpecCharValueUse;
		return this;
	}

	public ProductOfferingPrice addProdSpecCharValueUseItem(
			ProductSpecificationCharacteristicValueUse prodSpecCharValueUseItem) {
		if (this.prodSpecCharValueUse == null) {
			this.prodSpecCharValueUse = new HashSet<>();
		}
		this.prodSpecCharValueUse.add(prodSpecCharValueUseItem);
		return this;
	}

	/**
	 * A use of the ProductSpecificationCharacteristicValue by a
	 * ProductOfferingPrice to which additional properties (attributes) apply or
	 * override the properties of similar properties contained in
	 * ProductSpecificationCharacteristicValue. It should be noted that
	 * characteristics which their value(s) addressed by this object must exist in
	 * corresponding product specification. The available characteristic values for
	 * a ProductSpecificationCharacteristic in a Product specification can be
	 * modified at the ProductOffering and ProcuctOfferingPrice level. The list of
	 * values in ProductSpecificationCharacteristicValueUse is a strict subset of
	 * the list of values as defined in the corresponding product specification
	 * characteristics.
	 * 
	 * @return prodSpecCharValueUse
	 **/
	@Schema(description = "A use of the ProductSpecificationCharacteristicValue by a ProductOfferingPrice to which additional properties (attributes) apply or override the properties of similar properties contained in ProductSpecificationCharacteristicValue. It should be noted that characteristics which their value(s) addressed by this object must exist in corresponding product specification. The available characteristic values for a ProductSpecificationCharacteristic in a Product specification can be modified at the ProductOffering and ProcuctOfferingPrice level. The list of values in ProductSpecificationCharacteristicValueUse is a strict subset of the list of values as defined in the corresponding product specification characteristics.")

	@Valid

	public Set<ProductSpecificationCharacteristicValueUse> getProdSpecCharValueUse() {
		return prodSpecCharValueUse;
	}

	public void setProdSpecCharValueUse(Set<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse) {
		this.prodSpecCharValueUse = prodSpecCharValueUse;
	}

	public ProductOfferingPrice productOfferingTerm(Set<ProductOfferingTerm> productOfferingTerm) {
		this.productOfferingTerm = productOfferingTerm;
		return this;
	}

	public ProductOfferingPrice addProductOfferingTermItem(ProductOfferingTerm productOfferingTermItem) {
		if (this.productOfferingTerm == null) {
			this.productOfferingTerm = new HashSet<>();
		}
		this.productOfferingTerm.add(productOfferingTermItem);
		return this;
	}

	/**
	 * A list of conditions under which a ProductOfferingPrice is made available to
	 * Customers. For instance, a Product Offering Price can be offered with
	 * multiple commitment periods.
	 * 
	 * @return productOfferingTerm
	 **/
	@Schema(description = "A list of conditions under which a ProductOfferingPrice is made available to Customers. For instance, a Product Offering Price can be offered with multiple commitment periods.")

	@Valid

	public Set<ProductOfferingTerm> getProductOfferingTerm() {
		return productOfferingTerm;
	}

	public void setProductOfferingTerm(Set<ProductOfferingTerm> productOfferingTerm) {
		this.productOfferingTerm = productOfferingTerm;
	}

	public ProductOfferingPrice tax(Set<TaxItem> tax) {
		this.tax = tax;
		return this;
	}

	public ProductOfferingPrice addTaxItem(TaxItem taxItem) {
		if (this.tax == null) {
			this.tax = new HashSet<>();
		}
		this.tax.add(taxItem);
		return this;
	}

	/**
	 * An amount of money levied on the price of a Product by a legislative body.
	 * 
	 * @return tax
	 **/
	@Schema(description = "An amount of money levied on the price of a Product by a legislative body.")

	@Valid

	public Set<TaxItem> getTax() {
		return tax;
	}

	public void setTax(Set<TaxItem> tax) {
		this.tax = tax;
	}

	public ProductOfferingPrice unitOfMeasure(Quantity unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	/**
	 * A number and unit representing how many (for instance 1 dozen) of an
	 * ProductOffering is available at the offered price. Its meaning depends on the
	 * priceType. It could be a price, a rate, or a discount.
	 * 
	 * @return unitOfMeasure
	 **/
	@Schema(description = "A number and unit representing how many (for instance 1 dozen) of an ProductOffering is available at the offered price. Its meaning depends on the priceType. It could be a price, a rate, or a discount.")

	@Valid

	public Quantity getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(Quantity unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProductOfferingPrice productOfferingPrice = (ProductOfferingPrice) o;
		return Objects.equals(this.id, productOfferingPrice.id) && Objects.equals(this.href, productOfferingPrice.href)
				&& Objects.equals(this.description, productOfferingPrice.description)
				&& Objects.equals(this.isBundle, productOfferingPrice.isBundle)
				&& Objects.equals(this.lastUpdate, productOfferingPrice.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, productOfferingPrice.lifecycleStatus)
				&& Objects.equals(this.name, productOfferingPrice.name)
				&& Objects.equals(this.percentage, productOfferingPrice.percentage)
				&& Objects.equals(this.priceType, productOfferingPrice.priceType)
				&& Objects.equals(this.recurringChargePeriodLength, productOfferingPrice.recurringChargePeriodLength)
				&& Objects.equals(this.recurringChargePeriodType, productOfferingPrice.recurringChargePeriodType)
				&& Objects.equals(this.version, productOfferingPrice.version)
				&& Objects.equals(this.bundledPopRelationship, productOfferingPrice.bundledPopRelationship)
				&& Objects.equals(this.constraint, productOfferingPrice.constraint)
				&& Objects.equals(this.place, productOfferingPrice.place)
				&& Objects.equals(this.popRelationship, productOfferingPrice.popRelationship)
				&& Objects.equals(this.price, productOfferingPrice.price)
				&& Objects.equals(this.pricingLogicAlgorithm, productOfferingPrice.pricingLogicAlgorithm)
				&& Objects.equals(this.prodSpecCharValueUse, productOfferingPrice.prodSpecCharValueUse)
				&& Objects.equals(this.productOfferingTerm, productOfferingPrice.productOfferingTerm)
				&& Objects.equals(this.tax, productOfferingPrice.tax)
				&& Objects.equals(this.unitOfMeasure, productOfferingPrice.unitOfMeasure)
				&& Objects.equals(this.validFor, productOfferingPrice.validFor)
				&& Objects.equals(this.baseType, productOfferingPrice.baseType)
				&& Objects.equals(this.schemaLocation, productOfferingPrice.schemaLocation)
				&& Objects.equals(this.type, productOfferingPrice.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, description, isBundle, lastUpdate, lifecycleStatus, name, percentage, priceType,
//				recurringChargePeriodLength, recurringChargePeriodType, version, bundledPopRelationship, constraint,
//				place, popRelationship, price, pricingLogicAlgorithm, prodSpecCharValueUse, productOfferingTerm, tax,
//				unitOfMeasure, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductOfferingPrice {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
		sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
		sb.append("    recurringChargePeriodLength: ").append(toIndentedString(recurringChargePeriodLength))
				.append("\n");
		sb.append("    recurringChargePeriodType: ").append(toIndentedString(recurringChargePeriodType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    bundledPopRelationship: ").append(toIndentedString(bundledPopRelationship)).append("\n");
		sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    popRelationship: ").append(toIndentedString(popRelationship)).append("\n");
		sb.append("    price: ").append(toIndentedString(price)).append("\n");
		sb.append("    pricingLogicAlgorithm: ").append(toIndentedString(pricingLogicAlgorithm)).append("\n");
		sb.append("    prodSpecCharValueUse: ").append(toIndentedString(prodSpecCharValueUse)).append("\n");
		sb.append("    productOfferingTerm: ").append(toIndentedString(productOfferingTerm)).append("\n");
		sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
		sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
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
