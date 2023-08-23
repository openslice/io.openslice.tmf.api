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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

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
 * A use of the ProductSpecificationCharacteristicValue by a ProductOffering to
 * which additional properties (attributes) apply or override the properties of
 * similar properties contained in ProductSpecificationCharacteristicValue. It
 * should be noted that characteristics which their value(s) addressed by this
 * object must exist in corresponding product specification. The available
 * characteristic values for a ProductSpecificationCharacteristic in a Product
 * specification can be modified at the ProductOffering level. For example, a
 * characteristic &#39;Color&#39; might have values White, Blue, Green, and Red.
 * But, the list of values can be restricted to e.g. White and Blue in an
 * associated product offering. It should be noted that the list of values in
 * &#39;ProductSpecificationCharacteristicValueUse&#39; is a strict subset of
 * the list of values as defined in the corresponding product specification
 * characteristics.
 */
@Schema(description = "A use of the ProductSpecificationCharacteristicValue by a ProductOffering to which additional properties (attributes) apply or override the properties of similar properties contained in ProductSpecificationCharacteristicValue. It should be noted that characteristics which their value(s) addressed by this object must exist in corresponding product specification. The available characteristic values for a ProductSpecificationCharacteristic in a Product specification can be modified at the ProductOffering level. For example, a characteristic 'Color' might have values White, Blue, Green, and Red. But, the list of values can be restricted to e.g. White and Blue in an associated product offering. It should be noted that the list of values in 'ProductSpecificationCharacteristicValueUse' is a strict subset of the list of values as defined in the corresponding product specification characteristics.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProdSpecCharValueUse")
@Table(name = "ProdSpecCharValueUse")
public class ProductSpecificationCharacteristicValueUse extends BaseEntity {

	@JsonProperty("maxCardinality")
	private Integer maxCardinality = null;

	@JsonProperty("minCardinality")
	private Integer minCardinality = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("productSpecCharacteristicValue")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue = new HashSet<>();

	@JsonProperty("productSpecification")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(referencedColumnName = "uuid")
	private ProductSpecificationRef productSpecification = null;

	public ProductSpecificationCharacteristicValueUse() {
		super();
		this.baseType = "BaseEntity";
		this.type = this.getClass().getName();
	}
	
	public ProductSpecificationCharacteristicValueUse(ProductSpecificationCharacteristicValueUse src) {
		this();
		this.name = src.getName();
		this.description = src.getDescription();
		this.maxCardinality = src.getMaxCardinality();
		this.minCardinality = src.getMinCardinality();		
		this.valueType =src.valueType;
		this.updateProductSpecCharacteristicValues(src.getProductSpecCharacteristicValue() );
	}

	public ProductSpecificationCharacteristicValueUse maxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
		return this;
	}

	/**
	 * The maximum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where five is
	 * the value for the maxCardinality.
	 * 
	 * @return maxCardinality
	 **/
	@Schema(description = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.")

	public Integer getMaxCardinality() {
		return maxCardinality;
	}

	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}

	public ProductSpecificationCharacteristicValueUse minCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
		return this;
	}

	/**
	 * The minimum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where zero is
	 * the value for the minCardinality.
	 * 
	 * @return minCardinality
	 **/
	@Schema(description = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.")

	public Integer getMinCardinality() {
		return minCardinality;
	}

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}


	public ProductSpecificationCharacteristicValueUse valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric, text
	 * and so forth
	 * 
	 * @return valueType
	 **/
	@Schema(description = "A kind of value that the characteristic can take on, such as numeric, text and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public ProductSpecificationCharacteristicValueUse productSpecCharacteristicValue(
			Set<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue) {
		this.productSpecCharacteristicValue = productSpecCharacteristicValue;
		return this;
	}

	public ProductSpecificationCharacteristicValueUse addProductSpecCharacteristicValueItem(
			ProductSpecificationCharacteristicValue productSpecCharacteristicValueItem) {
		if (this.productSpecCharacteristicValue == null) {
			this.productSpecCharacteristicValue = new HashSet<>();
		}
		this.productSpecCharacteristicValue.add(productSpecCharacteristicValueItem);
		return this;
	}

	/**
	 * A number or text that can be assigned to a
	 * ProductSpecificationCharacteristic.
	 * 
	 * @return productSpecCharacteristicValue
	 **/
	@Schema(description = "A number or text that can be assigned to a ProductSpecificationCharacteristic.")

	@Valid

	public Set<ProductSpecificationCharacteristicValue> getProductSpecCharacteristicValue() {
		return productSpecCharacteristicValue;
	}

	public void setProductSpecCharacteristicValue(
			Set<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue) {
		this.productSpecCharacteristicValue = productSpecCharacteristicValue;
	}

	public ProductSpecificationCharacteristicValueUse productSpecification(
			ProductSpecificationRef productSpecification) {
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

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProductSpecificationCharacteristicValueUse productSpecificationCharacteristicValueUse = (ProductSpecificationCharacteristicValueUse) o;
		return Objects.equals(this.description, productSpecificationCharacteristicValueUse.description)
				&& Objects.equals(this.maxCardinality, productSpecificationCharacteristicValueUse.maxCardinality)
				&& Objects.equals(this.minCardinality, productSpecificationCharacteristicValueUse.minCardinality)
				&& Objects.equals(this.name, productSpecificationCharacteristicValueUse.name)
				&& Objects.equals(this.valueType, productSpecificationCharacteristicValueUse.valueType)
				&& Objects.equals(this.productSpecCharacteristicValue,
						productSpecificationCharacteristicValueUse.productSpecCharacteristicValue)
				&& Objects.equals(this.productSpecification,
						productSpecificationCharacteristicValueUse.productSpecification)
				&& Objects.equals(this.validFor, productSpecificationCharacteristicValueUse.validFor)
				&& Objects.equals(this.baseType, productSpecificationCharacteristicValueUse.baseType)
				&& Objects.equals(this.schemaLocation, productSpecificationCharacteristicValueUse.schemaLocation)
				&& Objects.equals(this.type, productSpecificationCharacteristicValueUse.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(description, maxCardinality, minCardinality, name, valueType, productSpecCharacteristicValue, productSpecification, validFor, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductSpecificationCharacteristicValueUse {\n");

		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    productSpecCharacteristicValue: ").append(toIndentedString(productSpecCharacteristicValue))
				.append("\n");
		sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
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

	public void updateWith(ProductSpecificationCharacteristicValueUse src) {
		this.name = src.getName();
		this.description = src.getDescription();
		this.maxCardinality = src.getMaxCardinality();
		this.minCardinality = src.getMinCardinality();		
		this.updateProductSpecCharacteristicValues(src.getProductSpecCharacteristicValue() );
		
	}

	private void updateProductSpecCharacteristicValues(
			@Valid Set<ProductSpecificationCharacteristicValue> srcSet) {
		Map<Integer, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ProductSpecificationCharacteristicValue r : srcSet) {

			boolean valueExists = false;
			for (ProductSpecificationCharacteristicValue thisCharVal : this.productSpecCharacteristicValue) {
				if ( thisCharVal.hashCode() == r.hashCode() ) {
					valueExists = true;
					idAddedUpdated.put(thisCharVal.hashCode(), true);
					break;
				}
			}
			
			if (!valueExists) {
				ProductSpecificationCharacteristicValue nr = new ProductSpecificationCharacteristicValue( r );
				this.addProductSpecCharacteristicValueItem( nr );
				idAddedUpdated.put( nr.hashCode(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<ProductSpecificationCharacteristicValue> toRemove = new ArrayList<>();
		for (ProductSpecificationCharacteristicValue ss : this.productSpecCharacteristicValue) {
			if ( idAddedUpdated.get( ss.hashCode() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (ProductSpecificationCharacteristicValue r : toRemove) {
			this.productSpecCharacteristicValue.remove(r);
		}
	}


}
