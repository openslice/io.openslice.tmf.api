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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Resources are physical or non-physical components (or some combination of
 * these) within an enterprise&#x27;s infrastructure or inventory. They are
 * typically consumed or used by services (for example a physical port assigned
 * to a service) or contribute to the realization of a Product (for example, a
 * SIM card). They can be drawn from the Application, Computing and Network
 * domains, and include, for example, Network Elements, software, IT systems,
 * content and information, and technology components. A ResourceSpecification
 * is an abstract base class for representing a generic means for implementing a
 * particular type of Resource. In essence, a ResourceSpecification defines the
 * common attributes and relationships of a set of related Resources, while
 * Resource defines a specific instance that is based on a particular
 * ResourceSpecification. Skipped properties: id,href,
 * 
 * add lastUpdate
 */
@Schema(description = "Resources are physical or non-physical components (or some combination of these) within an enterprise's infrastructure or inventory. They are typically consumed or used by services (for example a physical port assigned to a service) or contribute to the realization of a Product (for example, a SIM card). They can be drawn from the Application, Computing and Network domains, and include, for example, Network Elements, software, IT systems, content and information, and technology components. A ResourceSpecification is an abstract base class for representing a generic means for implementing a particular type of Resource. In essence, a ResourceSpecification defines the common attributes and relationships of a set of related Resources, while Resource defines a specific instance that is based on a particular ResourceSpecification. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
public class ResourceSpecificationUpdate {
	@JsonProperty("category")
	protected String category = null;

	@JsonProperty("description")
	protected String description = null;

	@JsonProperty("isBundle")
	protected Boolean isBundle = null;

	@JsonProperty("lifecycleStatus")
	protected String lifecycleStatus = null;

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("version")
	protected String version = null;

	@JsonProperty("attachment")
	@Valid
	protected List<AttachmentRefOrValue> attachment = null;

	@JsonProperty("featureSpecification")
	@Valid
	protected List<FeatureSpecification> featureSpecification = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("resourceSpecCharacteristic")
	@Valid
	protected List<ResourceSpecificationCharacteristic> resourceSpecificationCharacteristic = null;

	@JsonProperty("resourceSpecRelationship")
	@Valid
	protected List<ResourceSpecificationRelationship> resourceSpecificationRelationship = null;

	@JsonProperty("targetResourceSchema")
	protected TargetResourceSchema targetResourceSchema = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@type")
	protected String type = null;

	public ResourceSpecificationUpdate category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Category of the target resource like NetworkConnectivity, PhysicalLinks,
	 * Generic, L2Network and so on.
	 * 
	 * @return category
	 **/
	@Schema(description = "Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ResourceSpecificationUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of this REST resource
	 * 
	 * @return description
	 **/
	@Schema(description = "Description of this REST resource")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceSpecificationUpdate isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * A flag indicates that if this resource specification is a bundled
	 * specification (true) or single (false).
	 * 
	 * @return isBundle
	 **/
	@Schema(description = "A flag indicates that if this resource specification is a bundled specification (true) or single (false).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	
	public ResourceSpecificationUpdate lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status of the resource specification
	 * 
	 * @return lifecycleStatus
	 **/
	@Schema(description = "Used to indicate the current lifecycle status of the resource specification")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public ResourceSpecificationUpdate name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name given to this REST resource
	 * 
	 * @return name
	 **/
	@Schema(description = "Name given to this REST resource")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceSpecificationUpdate version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Resource Specification version
	 * 
	 * @return version
	 **/
	@Schema(description = "Resource Specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ResourceSpecificationUpdate attachment(List<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ResourceSpecificationUpdate addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new ArrayList<>();
		}
		this.attachment.add(attachmentItem);
		return this;
	}

	/**
	 * Complements the description of an element (for instance a resource) through
	 * video, pictures ...
	 * 
	 * @return attachment
	 **/
	@Schema(description = "Complements the description of an element (for instance a resource) through video, pictures ...")
	@Valid
	public List<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public ResourceSpecificationUpdate featureSpecification(List<FeatureSpecification> featureSpecification) {
		this.featureSpecification = featureSpecification;
		return this;
	}

	public ResourceSpecificationUpdate addFeatureSpecificationItem(FeatureSpecification featureSpecificationItem) {
		if (this.featureSpecification == null) {
			this.featureSpecification = new ArrayList<>();
		}
		this.featureSpecification.add(featureSpecificationItem);
		return this;
	}

	/**
	 * A list of Features for this specification.
	 * 
	 * @return featureSpecification
	 **/
	@Schema(description = "A list of Features for this specification.")
	@Valid
	public List<FeatureSpecification> getFeatureSpecification() {
		return featureSpecification;
	}

	public void setFeatureSpecification(List<FeatureSpecification> featureSpecification) {
		this.featureSpecification = featureSpecification;
	}

	public ResourceSpecificationUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ResourceSpecificationUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
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
	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ResourceSpecificationUpdate ResourceSpecificationCharacteristic(
			List<ResourceSpecificationCharacteristic> ResourceSpecificationCharacteristic) {
		this.resourceSpecificationCharacteristic = ResourceSpecificationCharacteristic;
		return this;
	}

	public ResourceSpecificationUpdate addResourceSpecificationCharacteristicItem(
			ResourceSpecificationCharacteristic ResourceSpecificationCharacteristicItem) {
		if (this.resourceSpecificationCharacteristic == null) {
			this.resourceSpecificationCharacteristic = new ArrayList<>();
		}
		this.resourceSpecificationCharacteristic.add(ResourceSpecificationCharacteristicItem);
		return this;
	}

	/**
	 * A characteristic quality or distinctive feature of a ResourceSpecification.
	 * The characteristic can be take on a discrete value, such as color, can take
	 * on a range of values, (for example, sensitivity of 100-240 mV), or can be
	 * derived from a formula (for example, usage time (hrs) = 30 - talk time *3).
	 * Certain characteristics, such as color, may be configured during the ordering
	 * or some other process.
	 * 
	 * @return ResourceSpecificationCharacteristic
	 **/
	@Schema(description = "A characteristic quality or distinctive feature of a ResourceSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.")
	@Valid
	public List<ResourceSpecificationCharacteristic> getResourceSpecificationCharacteristic() {
		return resourceSpecificationCharacteristic;
	}

	public void setResourceSpecificationCharacteristic(List<ResourceSpecificationCharacteristic> ResourceSpecificationCharacteristic) {
		this.resourceSpecificationCharacteristic = ResourceSpecificationCharacteristic;
	}

	public ResourceSpecificationUpdate resourceSpecificationRelationship(
			List<ResourceSpecificationRelationship> resourceSpecRelationship) {
		this.resourceSpecificationRelationship = resourceSpecRelationship;
		return this;
	}

	public ResourceSpecificationUpdate addResourceSpecificationRelationshipItem(
			ResourceSpecificationRelationship resourceSpecRelationshipItem) {
		if (this.resourceSpecificationRelationship == null) {
			this.resourceSpecificationRelationship = new ArrayList<>();
		}
		this.resourceSpecificationRelationship.add(resourceSpecRelationshipItem);
		return this;
	}

	/**
	 * A migration, substitution, dependency or exclusivity relationship
	 * between/among resource specifications.
	 * 
	 * @return resourceSpecRelationship
	 **/
	@Schema(description = "A migration, substitution, dependency or exclusivity relationship between/among resource specifications.")
	@Valid
	public List<ResourceSpecificationRelationship> getResourceSpecificationRelationship() {
		return resourceSpecificationRelationship;
	}

	public void setResourceSpecificationRelationship(List<ResourceSpecificationRelationship> resourceSpecRelationship) {
		this.resourceSpecificationRelationship = resourceSpecRelationship;
	}

	public ResourceSpecificationUpdate targetResourceSchema(TargetResourceSchema targetResourceSchema) {
		this.targetResourceSchema = targetResourceSchema;
		return this;
	}

	/**
	 * Get targetResourceSchema
	 * 
	 * @return targetResourceSchema
	 **/
	@Schema(description = "")

	@Valid
	public TargetResourceSchema getTargetResourceSchema() {
		return targetResourceSchema;
	}

	public void setTargetResourceSchema(TargetResourceSchema targetResourceSchema) {
		this.targetResourceSchema = targetResourceSchema;
	}

	public ResourceSpecificationUpdate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@Schema(description = "")

	@Valid
	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ResourceSpecificationUpdate baseType(String _atBaseType) {
		this.baseType = _atBaseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String _atBaseType) {
		this.baseType = _atBaseType;
	}

	public ResourceSpecificationUpdate schemaLocation(String _atSchemaLocation) {
		this.schemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String _atSchemaLocation) {
		this.schemaLocation = _atSchemaLocation;
	}

	public ResourceSpecificationUpdate type(String _atType) {
		this.type = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return _atType
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class entity name")

	public String getType() {
		return type;
	}

	public void setType(String _atType) {
		this.type = _atType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceSpecificationUpdate resourceSpecificationUpdate = (ResourceSpecificationUpdate) o;
		return Objects.equals(this.category, resourceSpecificationUpdate.category)
				&& Objects.equals(this.description, resourceSpecificationUpdate.description)
				&& Objects.equals(this.isBundle, resourceSpecificationUpdate.isBundle)
				&& Objects.equals(this.lifecycleStatus, resourceSpecificationUpdate.lifecycleStatus)
				&& Objects.equals(this.name, resourceSpecificationUpdate.name)
				&& Objects.equals(this.version, resourceSpecificationUpdate.version)
				&& Objects.equals(this.attachment, resourceSpecificationUpdate.attachment)
				&& Objects.equals(this.featureSpecification, resourceSpecificationUpdate.featureSpecification)
				&& Objects.equals(this.relatedParty, resourceSpecificationUpdate.relatedParty)
				&& Objects.equals(this.resourceSpecificationCharacteristic,
						resourceSpecificationUpdate.resourceSpecificationCharacteristic)
				&& Objects.equals(this.resourceSpecificationRelationship, resourceSpecificationUpdate.resourceSpecificationRelationship)
				&& Objects.equals(this.targetResourceSchema, resourceSpecificationUpdate.targetResourceSchema)
				&& Objects.equals(this.validFor, resourceSpecificationUpdate.validFor)
				&& Objects.equals(this.baseType, resourceSpecificationUpdate.baseType)
				&& Objects.equals(this.schemaLocation, resourceSpecificationUpdate.schemaLocation)
				&& Objects.equals(this.type, resourceSpecificationUpdate.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(category, description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment,
//				featureSpecification, relatedParty, resourceSpecificationCharacteristic, resourceSpecificationRelationship,
//				targetResourceSchema, validFor, _atBaseType, _atSchemaLocation, _atType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecificationUpdate {\n");

		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    featureSpecification: ").append(toIndentedString(featureSpecification)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    ResourceSpecificationCharacteristic: ").append(toIndentedString(resourceSpecificationCharacteristic)).append("\n");
		sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecificationRelationship)).append("\n");
		sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	protected String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
	

	public void addResourceSpecificationRelationshipWith(ResourceSpecification responsesSpec1) {

		ResourceSpecificationRelationship r1 = new ResourceSpecificationRelationship();
		r1.setId(responsesSpec1.getId());
		r1.setName(responsesSpec1.getName());
		r1.setRole("serviceSpecRelationship");
		r1.setRelationshipType("aggregation");
		this.addResourceSpecificationRelationshipItem(r1);
	}
}
