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

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A set of numbers that specifies the lower and upper limits for a
 * ProductOffering that can be procured as part of the related
 * BundledProductOffering. Values can range from 0 to unbounded
 */
@ApiModel(description = "A set of numbers that specifies the lower and upper limits for a ProductOffering that can be procured as part of the related BundledProductOffering. Values can range from 0 to unbounded")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "BundledProductOfferingOption")
public class BundledProductOfferingOption extends BaseRootEntity {
	@JsonProperty("numberRelOfferDefault")
	private Integer numberRelOfferDefault = null;

	@JsonProperty("numberRelOfferLowerLimit")
	private Integer numberRelOfferLowerLimit = null;

	@JsonProperty("numberRelOfferUpperLimit")
	private Integer numberRelOfferUpperLimit = null;

	public BundledProductOfferingOption numberRelOfferDefault(Integer numberRelOfferDefault) {
		this.numberRelOfferDefault = numberRelOfferDefault;
		return this;
	}

	/**
	 * Default number of produc offereings that should be procured as part of the
	 * related BundledProductOffering
	 * 
	 * @return numberRelOfferDefault
	 **/
	@ApiModelProperty(value = "Default number of produc offereings that should be procured as part of the related BundledProductOffering")

	public Integer getNumberRelOfferDefault() {
		return numberRelOfferDefault;
	}

	public void setNumberRelOfferDefault(Integer numberRelOfferDefault) {
		this.numberRelOfferDefault = numberRelOfferDefault;
	}

	public BundledProductOfferingOption numberRelOfferLowerLimit(Integer numberRelOfferLowerLimit) {
		this.numberRelOfferLowerLimit = numberRelOfferLowerLimit;
		return this;
	}

	/**
	 * lower limit for a product offering that can be procured as part of the
	 * related BundledProductOffering
	 * 
	 * @return numberRelOfferLowerLimit
	 **/
	@ApiModelProperty(value = "lower limit for a product offering that can be procured as part of the related BundledProductOffering")

	public Integer getNumberRelOfferLowerLimit() {
		return numberRelOfferLowerLimit;
	}

	public void setNumberRelOfferLowerLimit(Integer numberRelOfferLowerLimit) {
		this.numberRelOfferLowerLimit = numberRelOfferLowerLimit;
	}

	public BundledProductOfferingOption numberRelOfferUpperLimit(Integer numberRelOfferUpperLimit) {
		this.numberRelOfferUpperLimit = numberRelOfferUpperLimit;
		return this;
	}

	/**
	 * upper limit for a product offering that can be procured as part of the
	 * related BundledProductOffering
	 * 
	 * @return numberRelOfferUpperLimit
	 **/
	@ApiModelProperty(value = "upper limit for a product offering that can be procured as part of the related BundledProductOffering")

	public Integer getNumberRelOfferUpperLimit() {
		return numberRelOfferUpperLimit;
	}

	public void setNumberRelOfferUpperLimit(Integer numberRelOfferUpperLimit) {
		this.numberRelOfferUpperLimit = numberRelOfferUpperLimit;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BundledProductOfferingOption bundledProductOfferingOption = (BundledProductOfferingOption) o;
		return Objects.equals(this.numberRelOfferDefault, bundledProductOfferingOption.numberRelOfferDefault)
				&& Objects.equals(this.numberRelOfferLowerLimit, bundledProductOfferingOption.numberRelOfferLowerLimit)
				&& Objects.equals(this.numberRelOfferUpperLimit, bundledProductOfferingOption.numberRelOfferUpperLimit)
				&& Objects.equals(this.baseType, bundledProductOfferingOption.baseType)
				&& Objects.equals(this.schemaLocation, bundledProductOfferingOption.schemaLocation)
				&& Objects.equals(this.type, bundledProductOfferingOption.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(numberRelOfferDefault, numberRelOfferLowerLimit, numberRelOfferUpperLimit, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BundledProductOfferingOption {\n");

		sb.append("    numberRelOfferDefault: ").append(toIndentedString(numberRelOfferDefault)).append("\n");
		sb.append("    numberRelOfferLowerLimit: ").append(toIndentedString(numberRelOfferLowerLimit)).append("\n");
		sb.append("    numberRelOfferUpperLimit: ").append(toIndentedString(numberRelOfferUpperLimit)).append("\n");
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
