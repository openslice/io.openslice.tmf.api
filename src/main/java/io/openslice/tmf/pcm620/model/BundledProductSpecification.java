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

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A type of ProductSpecification that belongs to a grouping of
 * ProductSpecifications made available to the market. It inherits of all
 * attributes of ProductSpecification.
 */
@ApiModel(description = "A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity
public class BundledProductSpecification extends BaseEntity {
	@JsonProperty("id")
	private String id = null;


	@JsonProperty("lifecycleStatus")
	private String lifecycleStatus = null;

	public BundledProductSpecification() {
		super();
	}


	public BundledProductSpecification(BundledProductSpecification bundledProdSpec) {
		this();
		this.name = bundledProdSpec.getName();
		this.lifecycleStatus = bundledProdSpec.getLifecycleStatus();
	}

	public BundledProductSpecification id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the product specification
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the product specification")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BundledProductSpecification href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the product specification
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Reference of the product specification")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public BundledProductSpecification lifecycleStatus(String lifecycleStatus) {
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

	public BundledProductSpecification name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the product specification
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the product specification")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BundledProductSpecification baseType(String baseType) {
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

	public BundledProductSpecification schemaLocation(String schemaLocation) {
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

	public BundledProductSpecification type(String type) {
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
		BundledProductSpecification bundledProductSpecification = (BundledProductSpecification) o;
		return Objects.equals(this.id, bundledProductSpecification.id)
				&& Objects.equals(this.href, bundledProductSpecification.href)
				&& Objects.equals(this.lifecycleStatus, bundledProductSpecification.lifecycleStatus)
				&& Objects.equals(this.name, bundledProductSpecification.name)
				&& Objects.equals(this.baseType, bundledProductSpecification.baseType)
				&& Objects.equals(this.schemaLocation, bundledProductSpecification.schemaLocation)
				&& Objects.equals(this.type, bundledProductSpecification.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, lifecycleStatus, name, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BundledProductSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

	public void updateWith(BundledProductSpecification src) {
		this.name = src.getName();
		this.lifecycleStatus = src.getLifecycleStatus();

	}
}
