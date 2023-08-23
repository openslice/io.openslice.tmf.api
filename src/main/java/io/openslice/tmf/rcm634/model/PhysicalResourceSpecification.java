/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

/**
 * This is a concrete class that is used to define the invariant characteristics
 * and behavior (attributes, methods, constraints, and relationships) of a
 * PhysicalResource.
 */
@Schema(description = "This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Entity(name = "PhysicalRspec")
public class PhysicalResourceSpecification extends ResourceSpecification {

	public PhysicalResourceSpecification() {
		super();
		this.baseType = "ResourceSpecification";
		this.type = "PhysicalResourceSpecification";

	}

	@JsonProperty("model")
	private String model = null;


	@JsonProperty("part")
	private String part = null;

	@JsonProperty("sku")
	private String sku = null;

	@JsonProperty("vendor")
	private String vendor = null;


	public PhysicalResourceSpecification model(String model) {
		this.model = model;
		return this;
	}

	/**
	 * This is a string that represents a manufacturer-allocated number used to
	 * identify the general type and/or category of the hardware item. This, in
	 * combination with the Part and the Vendor, identify different types of
	 * hardware items. The SerialNumber can then be used to differentiate between
	 * different instances of the same type of hardware item. This is an optional
	 * attribute.
	 * 
	 * @return model
	 **/
	@Schema(description = "This is a string that represents a manufacturer-allocated number used to identify the general type and/or category of the hardware item. This, in combination with the Part and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is an optional attribute.")

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	public PhysicalResourceSpecification part(String part) {
		this.part = part;
		return this;
	}

	/**
	 * This is a string that defines a manufacturer-allocated part number assigned
	 * by the organization that manufactures the hardware item. This, in combination
	 * with the Model and the Vendor, identify different types of hardware items.
	 * The SerialNumber can then be used to differentiate between different
	 * instances of the same type of hardware item. This is a REQUIRED attribute.
	 * 
	 * @return part
	 **/
	@Schema(description = "This is a string that defines a manufacturer-allocated part number assigned by the organization that manufactures the hardware item. This, in combination with the Model and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute.")

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public PhysicalResourceSpecification sku(String sku) {
		this.sku = sku;
		return this;
	}

	/**
	 * This is a string that defines the manufacturer-allocated Stock Keeping Unit
	 * (SKU) number of the hardware item. This is an optional attribute.
	 * 
	 * @return sku
	 **/
	@Schema(description = "This is a string that defines the manufacturer-allocated Stock Keeping Unit (SKU) number of the hardware item. This is an optional attribute.")

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public PhysicalResourceSpecification vendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	/**
	 * This is a string that defines the name of the manufacturer. This, in
	 * combination with the Model and the Part, identify different types of hardware
	 * items. The SerialNumber can then be used to differentiate between different
	 * instances of the same type of hardware item. This is a REQUIRED attribute for
	 * a physical resource.
	 * 
	 * @return vendor
	 **/
	@Schema(description = "This is a string that defines the name of the manufacturer. This, in combination with the Model and the Part, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute for a physical resource.")

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}




	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PhysicalResourceSpecification physicalResourceSpecification = (PhysicalResourceSpecification) o;
		return Objects.equals(this.uuid, physicalResourceSpecification.uuid)
				&& Objects.equals(this.href, physicalResourceSpecification.href)
				&& Objects.equals(this.category, physicalResourceSpecification.category)
				&& Objects.equals(this.description, physicalResourceSpecification.description)
				&& Objects.equals(this.isBundle, physicalResourceSpecification.isBundle)
				&& Objects.equals(this.lastUpdate, physicalResourceSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, physicalResourceSpecification.lifecycleStatus)
				&& Objects.equals(this.model, physicalResourceSpecification.model)
				&& Objects.equals(this.name, physicalResourceSpecification.name)
				&& Objects.equals(this.part, physicalResourceSpecification.part)
				&& Objects.equals(this.sku, physicalResourceSpecification.sku)
				&& Objects.equals(this.vendor, physicalResourceSpecification.vendor)
				&& Objects.equals(this.version, physicalResourceSpecification.version)
				&& Objects.equals(this.attachment, physicalResourceSpecification.attachment)
				&& Objects.equals(this.featureSpecification, physicalResourceSpecification.featureSpecification)
				&& Objects.equals(this.relatedParty, physicalResourceSpecification.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic,
						physicalResourceSpecification.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, physicalResourceSpecification.resourceSpecRelationship)
				&& Objects.equals(this.targetResourceSchema, physicalResourceSpecification.targetResourceSchema)
				&& Objects.equals(this.validFor, physicalResourceSpecification.validFor)
				&& Objects.equals(this.baseType, physicalResourceSpecification.baseType)
				&& Objects.equals(this.schemaLocation, physicalResourceSpecification.schemaLocation)
				&& Objects.equals(this.type, physicalResourceSpecification.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, category, description, isBundle, lastUpdate, lifecycleStatus, model, name, part,
//				sku, vendor, version, attachment, featureSpecification, relatedParty, resourceSpecCharacteristic,
//				resourceSpecRelationship, targetResourceSchema, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PhysicalResourceSpecification {\n");

		sb.append("    id: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    model: ").append(toIndentedString(model)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    part: ").append(toIndentedString(part)).append("\n");
		sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
		sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    featureSpecification: ").append(toIndentedString(featureSpecification)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
		sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
		sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
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
