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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A type of ProductOffering that belongs to a grouping of ProductOfferings made
 * available to the market. It inherits of all attributes of ProductOffering.
 */
@ApiModel(description = "A type of ProductOffering that belongs to a grouping of ProductOfferings made available to the market. It inherits of all attributes of ProductOffering.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")
@Entity(name = "BundledProductOffering")
public class BundledProductOffering extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("bundledProductOfferingOption")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(referencedColumnName = "uuid")
	private BundledProductOfferingOption bundledProductOfferingOption = null;

	/**
	 * Unique identifier of a related entity.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "Unique identifier of a related entity.")
	@NotNull

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Unique reference of the BundledProductOffering
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Unique reference of the BundledProductOffering")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public BundledProductOffering lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public BundledProductOffering name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the BundledProductOffering
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the BundledProductOffering")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BundledProductOffering bundledProductOfferingOption(
			BundledProductOfferingOption bundledProductOfferingOption) {
		this.bundledProductOfferingOption = bundledProductOfferingOption;
		return this;
	}

	/**
	 * A set of numbers that specifies the lower and upper limits for a
	 * ProductOffering that can be procured as part of the related
	 * BundledProductOffering. Values can range from 0 to unbounded.
	 * 
	 * @return bundledProductOfferingOption
	 **/
	@ApiModelProperty(value = "A set of numbers that specifies the lower and upper limits for a ProductOffering that can be procured as part of the related BundledProductOffering. Values can range from 0 to unbounded.")

	@Valid

	public BundledProductOfferingOption getBundledProductOfferingOption() {
		return bundledProductOfferingOption;
	}

	public void setBundledProductOfferingOption(BundledProductOfferingOption bundledProductOfferingOption) {
		this.bundledProductOfferingOption = bundledProductOfferingOption;
	}

	public BundledProductOffering baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the super-class")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public BundledProductOffering schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public BundledProductOffering type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")

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
		BundledProductOffering bundledProductOffering = (BundledProductOffering) o;
		return Objects.equals(this.id, bundledProductOffering.id)
				&& Objects.equals(this.href, bundledProductOffering.href)
				&& Objects.equals(this.lifecycleStatus, bundledProductOffering.lifecycleStatus)
				&& Objects.equals(this.name, bundledProductOffering.name)
				&& Objects.equals(this.bundledProductOfferingOption,
						bundledProductOffering.bundledProductOfferingOption)
				&& Objects.equals(this.baseType, bundledProductOffering.baseType)
				&& Objects.equals(this.schemaLocation, bundledProductOffering.schemaLocation)
				&& Objects.equals(this.type, bundledProductOffering.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, lifecycleStatus, name, bundledProductOfferingOption, baseType, schemaLocation,
//				type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BundledProductOffering {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    bundledProductOfferingOption: ").append(toIndentedString(bundledProductOfferingOption))
				.append("\n");
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
