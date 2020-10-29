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
 * Product specification reference: A ProductSpecification is a detailed
 * description of a tangible or intangible object made available externally in
 * the form of a ProductOffering to customers or other parties playing a party
 * role.
 */
@ApiModel(description = "Product specification reference: A ProductSpecification is a detailed description of a tangible or intangible object made available externally in the form of a ProductOffering to customers or other parties playing a party role.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Entity(name = "ProductSpecificationRef")
public class ProductSpecificationRef extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("targetProductSchema")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(referencedColumnName = "uuid")
	private TargetProductSchema targetProductSchema = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	/**
	 * Unique identifier of a related entity.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "Unique identifier of a related entity.")
	@NotNull

	public String getId() {
		return id;
  }

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	public ProductSpecificationRef schemaLocation(String schemaLocation) {
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

	public ProductSpecificationRef type(String type) {
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

	public ProductSpecificationRef referredType(String referredType) {
		this.referredType = referredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
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
		ProductSpecificationRef productSpecificationRef = (ProductSpecificationRef) o;
		return Objects.equals(this.id, productSpecificationRef.id)
				&& Objects.equals(this.href, productSpecificationRef.href)
				&& Objects.equals(this.name, productSpecificationRef.name)
				&& Objects.equals(this.version, productSpecificationRef.version)
				&& Objects.equals(this.targetProductSchema, productSpecificationRef.targetProductSchema)
				&& Objects.equals(this.baseType, productSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, productSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, productSpecificationRef.type)
				&& Objects.equals(this.referredType, productSpecificationRef.referredType);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, name, version, targetProductSchema, baseType, schemaLocation, type, referredType);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    targetProductSchema: ").append(toIndentedString(targetProductSchema)).append("\n");
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
