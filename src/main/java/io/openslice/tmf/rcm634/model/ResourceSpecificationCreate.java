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
package io.openslice.tmf.rcm634.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Resources are physical or non-physical components (or some combination of
 * these) within an enterprise&#39;s infrastructure or inventory. They are
 * typically consumed or used by services (for example a physical port assigned
 * to a service) or contribute to the realization of a Product (for example, a
 * SIM card). They can be drawn from the Application, Computing and Network
 * domains, and include, for example, Network Elements, software, IT systems,
 * content and information, and technology components. A ResourceSpecification
 * is an abstract base class for representing a generic means for implementing a
 * particular type of Resource. In essence, a ResourceSpecification defines the
 * common attributes and relationships of a set of related Resources, while
 * Resource defines a specific instance that is based on a particular
 * ResourceSpecification. Skipped properties: id,href
 */
@ApiModel(description = "Resources are physical or non-physical components (or some combination of these) within an enterprise's infrastructure or inventory. They are typically consumed or used by services (for example a physical port assigned to a service) or contribute to the realization of a Product (for example, a SIM card). They can be drawn from the Application, Computing and Network domains, and include, for example, Network Elements, software, IT systems, content and information, and technology components. A ResourceSpecification is an abstract base class for representing a generic means for implementing a particular type of Resource. In essence, a ResourceSpecification defines the common attributes and relationships of a set of related Resources, while Resource defines a specific instance that is based on a particular ResourceSpecification. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceSpecificationCreate extends ResourceSpecificationUpdate {

	@JsonProperty("lastUpdate")
	private OffsetDateTime lastUpdate = null;

	@JsonProperty("@type")
	private String type = null;

	public ResourceSpecificationCreate name(String name) {
		this.name = name;
		return this;
	}

	public ResourceSpecificationCreate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Class type of this REST resource
	 * 
	 * @return type
	 **/
	@ApiModelProperty(required = true, value = "Class type of this REST resource")
	@NotNull

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ResourceSpecificationCreate lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	/**
	 * Date and time of the last update of this REST resource
	 * 
	 * @return lastUpdate
	 **/
	@ApiModelProperty(value = "Date and time of the last update of this REST resource")

	@Valid

	public OffsetDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceSpecificationCreate resourceSpecificationCreate = (ResourceSpecificationCreate) o;
		return Objects.equals(this.name, resourceSpecificationCreate.name)
				&& Objects.equals(this.description, resourceSpecificationCreate.description)
				&& Objects.equals(this.type, resourceSpecificationCreate.type)
				&& Objects.equals(this.schemaLocation, resourceSpecificationCreate.schemaLocation)
				&& Objects.equals(this.baseType, resourceSpecificationCreate.baseType)
				&& Objects.equals(this.version, resourceSpecificationCreate.version)
				&& Objects.equals(this.validFor, resourceSpecificationCreate.validFor)
				&& Objects.equals(this.lastUpdate, resourceSpecificationCreate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceSpecificationCreate.lifecycleStatus)
				&& Objects.equals(this.isBundle, resourceSpecificationCreate.isBundle)
				&& Objects.equals(this.category, resourceSpecificationCreate.category)
				&& Objects.equals(this.targetResourceSchema, resourceSpecificationCreate.targetResourceSchema)
				&& Objects.equals(this.feature, resourceSpecificationCreate.feature)
				&& Objects.equals(this.attachment, resourceSpecificationCreate.attachment)
				&& Objects.equals(this.relatedParty, resourceSpecificationCreate.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic,
						resourceSpecificationCreate.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, resourceSpecificationCreate.resourceSpecRelationship);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate,
				lifecycleStatus, isBundle, category, targetResourceSchema, feature, attachment, relatedParty,
				resourceSpecCharacteristic, resourceSpecRelationship);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecificationCreate {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
		sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
		sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
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
