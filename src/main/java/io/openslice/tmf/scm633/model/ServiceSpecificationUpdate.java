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
package io.openslice.tmf.scm633.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.AttachmentRef;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceSpecification is a class that offers characteristics to describe a
 * type of service. Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics. Skipped properties:
 * id,href,lastUpdate
 */
@ApiModel(description = "ServiceSpecification is a class that offers characteristics to describe a type of service. Functionally, it acts as a template by which Services may be instantiated. By sharing the same  specification, these services would therefore share the same set of characteristics. Skipped properties: id,href,lastUpdate")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceSpecificationUpdate {
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
	protected List<AttachmentRef> attachment = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("resourceSpecification")
	@Valid
	protected List<ResourceSpecificationRef> resourceSpecification = null;

	@JsonProperty("serviceLevelSpecification")
	@Valid
	protected List<ServiceLevelSpecificationRef> serviceLevelSpecification = null;

	@JsonProperty("serviceSpecCharacteristic")
	@Valid
	protected List<ServiceSpecCharacteristic> serviceSpecCharacteristic = null;

	@JsonProperty("serviceSpecRelationship")
	@Valid
	protected List<ServiceSpecRelationship> serviceSpecRelationship = null;

	@JsonProperty("targetServiceSchema")
	protected TargetServiceSchema targetServiceSchema = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@type")
	protected String type = null;

	public ServiceSpecificationUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative that explains in detail what the service specification is
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A narrative that explains in detail what the service specification is")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceSpecificationUpdate isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * isBundle determines whether a ServiceSpecification represents a single
	 * ServiceSpecification (false), or a bundle of ServiceSpecification (true).
	 * 
	 * @return isBundle
	 **/
	@ApiModelProperty(value = "isBundle determines whether a ServiceSpecification represents a single ServiceSpecification (false), or a bundle of ServiceSpecification (true).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	public ServiceSpecificationUpdate lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status of the service specification
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status of the service specification")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public ServiceSpecificationUpdate name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the service specification
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the service specification")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ServiceSpecificationUpdate version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Service specification version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Service specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServiceSpecificationUpdate attachment(List<AttachmentRef> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ServiceSpecificationUpdate addAttachmentItem(AttachmentRef attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new ArrayList<AttachmentRef>();
		}
		this.attachment.add(attachmentItem);
		return this;
	}

	/**
	 * A list of attachments (Attachment [*]). Complements the description of the
	 * specification through video, pictures...
	 * 
	 * @return attachment
	 **/
	@ApiModelProperty(value = "A list of attachments (Attachment [*]). Complements the description of the specification through video, pictures...")

	@Valid

	public List<AttachmentRef> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentRef> attachment) {
		this.attachment = attachment;
	}

	public ServiceSpecificationUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceSpecificationUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<RelatedParty>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * A list of related party references (RelatedParty [*]). A related party
	 * defines party or party role linked to a specific entity.
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "A list of related party references (RelatedParty [*]). A related party defines party or party role linked to a specific entity.")

	@Valid

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceSpecificationUpdate resourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
		return this;
	}

	public ServiceSpecificationUpdate addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
		if (this.resourceSpecification == null) {
			this.resourceSpecification = new ArrayList<ResourceSpecificationRef>();
		}
		this.resourceSpecification.add(resourceSpecificationItem);
		return this;
	}

	/**
	 * A list of resource specification references (ResourceSpecificationRef [*]).
	 * The ResourceSpecification is required for a service specification with type
	 * ResourceFacingServiceSpecification (RFSS).
	 * 
	 * @return resourceSpecification
	 **/
	@ApiModelProperty(value = "A list of resource specification references (ResourceSpecificationRef [*]). The ResourceSpecification is required for a service specification with type ResourceFacingServiceSpecification (RFSS).")

	@Valid

	public List<ResourceSpecificationRef> getResourceSpecification() {
		return resourceSpecification;
	}

	public void setResourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
	}

	public ServiceSpecificationUpdate serviceLevelSpecification(
			List<ServiceLevelSpecificationRef> serviceLevelSpecification) {
		this.serviceLevelSpecification = serviceLevelSpecification;
		return this;
	}

	public ServiceSpecificationUpdate addServiceLevelSpecificationItem(
			ServiceLevelSpecificationRef serviceLevelSpecificationItem) {
		if (this.serviceLevelSpecification == null) {
			this.serviceLevelSpecification = new ArrayList<ServiceLevelSpecificationRef>();
		}
		this.serviceLevelSpecification.add(serviceLevelSpecificationItem);
		return this;
	}

	/**
	 * A list of service level specifications related to this service specification,
	 * and which will need to be satisifiable for corresponding service instances;
	 * e.g. Gold, Platinum
	 * 
	 * @return serviceLevelSpecification
	 **/
	@ApiModelProperty(value = "A list of service level specifications related to this service specification, and which will need to be satisifiable for corresponding service instances; e.g. Gold, Platinum")

	@Valid

	public List<ServiceLevelSpecificationRef> getServiceLevelSpecification() {
		return serviceLevelSpecification;
	}

	public void setServiceLevelSpecification(List<ServiceLevelSpecificationRef> serviceLevelSpecification) {
		this.serviceLevelSpecification = serviceLevelSpecification;
	}

	public ServiceSpecificationUpdate serviceSpecCharacteristic(
			List<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
		this.serviceSpecCharacteristic = serviceSpecCharacteristic;
		return this;
	}

	public ServiceSpecificationUpdate addServiceSpecCharacteristicItem(
			ServiceSpecCharacteristic serviceSpecCharacteristicItem) {
		if (this.serviceSpecCharacteristic == null) {
			this.serviceSpecCharacteristic = new ArrayList<ServiceSpecCharacteristic>();
		}
		this.serviceSpecCharacteristic.add(serviceSpecCharacteristicItem);
		return this;
	}

	/**
	 * A list of service spec characteristics (ServiceSpecCharacteristic [*]). This
	 * class represents the key features of this service specification.
	 * 
	 * @return serviceSpecCharacteristic
	 **/
	@ApiModelProperty(value = "A list of service spec characteristics (ServiceSpecCharacteristic [*]). This class represents the key features of this service specification.")

	@Valid

	public List<ServiceSpecCharacteristic> getServiceSpecCharacteristic() {
		return serviceSpecCharacteristic;
	}

	public void setServiceSpecCharacteristic(List<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
		this.serviceSpecCharacteristic = serviceSpecCharacteristic;
	}

	public ServiceSpecificationUpdate serviceSpecRelationship(List<ServiceSpecRelationship> serviceSpecRelationship) {
		this.serviceSpecRelationship = serviceSpecRelationship;
		return this;
	}

	public ServiceSpecificationUpdate addServiceSpecRelationshipItem(
			ServiceSpecRelationship serviceSpecRelationshipItem) {
		if (this.serviceSpecRelationship == null) {
			this.serviceSpecRelationship = new ArrayList<ServiceSpecRelationship>();
		}
		this.serviceSpecRelationship.add(serviceSpecRelationshipItem);
		return this;
	}

	/**
	 * A list of service specifications related to this specification, e.g.
	 * migration, substitution, dependency or exclusivity relationship
	 * 
	 * @return serviceSpecRelationship
	 **/
	@ApiModelProperty(value = "A list of service specifications related to this specification, e.g. migration, substitution, dependency or exclusivity relationship")

	@Valid

	public List<ServiceSpecRelationship> getServiceSpecRelationship() {
		return serviceSpecRelationship;
	}

	public void setServiceSpecRelationship(List<ServiceSpecRelationship> serviceSpecRelationship) {
		this.serviceSpecRelationship = serviceSpecRelationship;
	}

	public ServiceSpecificationUpdate targetServiceSchema(TargetServiceSchema targetServiceSchema) {
		this.targetServiceSchema = targetServiceSchema;
		return this;
	}

	/**
	 * A target service schema reference (TargetServiceSchemaRef). The reference
	 * object to the schema and type of target service which is described by service
	 * specification.
	 * 
	 * @return targetServiceSchema
	 **/
	@ApiModelProperty(value = "A target service schema reference (TargetServiceSchemaRef). The reference object to the schema and type of target service which is described by service specification.")

	@Valid

	public TargetServiceSchema getTargetServiceSchema() {
		return targetServiceSchema;
	}

	public void setTargetServiceSchema(TargetServiceSchema targetServiceSchema) {
		this.targetServiceSchema = targetServiceSchema;
	}

	public ServiceSpecificationUpdate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the service specification is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the service specification is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ServiceSpecificationUpdate baseType(String baseType) {
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

	public ServiceSpecificationUpdate schemaLocation(String schemaLocation) {
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

	public ServiceSpecificationUpdate type(String type) {
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
		ServiceSpecificationUpdate serviceSpecificationUpdate = (ServiceSpecificationUpdate) o;
		return Objects.equals(this.description, serviceSpecificationUpdate.description)
				&& Objects.equals(this.isBundle, serviceSpecificationUpdate.isBundle)
				&& Objects.equals(this.lifecycleStatus, serviceSpecificationUpdate.lifecycleStatus)
				&& Objects.equals(this.name, serviceSpecificationUpdate.name)
				&& Objects.equals(this.version, serviceSpecificationUpdate.version)
				&& Objects.equals(this.attachment, serviceSpecificationUpdate.attachment)
				&& Objects.equals(this.relatedParty, serviceSpecificationUpdate.relatedParty)
				&& Objects.equals(this.resourceSpecification, serviceSpecificationUpdate.resourceSpecification)
				&& Objects.equals(this.serviceLevelSpecification, serviceSpecificationUpdate.serviceLevelSpecification)
				&& Objects.equals(this.serviceSpecCharacteristic, serviceSpecificationUpdate.serviceSpecCharacteristic)
				&& Objects.equals(this.serviceSpecRelationship, serviceSpecificationUpdate.serviceSpecRelationship)
				&& Objects.equals(this.targetServiceSchema, serviceSpecificationUpdate.targetServiceSchema)
				&& Objects.equals(this.validFor, serviceSpecificationUpdate.validFor)
				&& Objects.equals(this.baseType, serviceSpecificationUpdate.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecificationUpdate.schemaLocation)
				&& Objects.equals(this.type, serviceSpecificationUpdate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, isBundle, lifecycleStatus, name, version, attachment, relatedParty,
				resourceSpecification, serviceLevelSpecification, serviceSpecCharacteristic, serviceSpecRelationship,
				targetServiceSchema, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecificationUpdate {\n");

		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
		sb.append("    serviceLevelSpecification: ").append(toIndentedString(serviceLevelSpecification)).append("\n");
		sb.append("    serviceSpecCharacteristic: ").append(toIndentedString(serviceSpecCharacteristic)).append("\n");
		sb.append("    serviceSpecRelationship: ").append(toIndentedString(serviceSpecRelationship)).append("\n");
		sb.append("    targetServiceSchema: ").append(toIndentedString(targetServiceSchema)).append("\n");
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
	

	public void addServiceSpecRelationshipWith(ServiceSpecification responsesSpec1) {

		ServiceSpecRelationship r1 = new ServiceSpecRelationship();
		r1.setId(responsesSpec1.getId());
		r1.setName(responsesSpec1.getName());
		r1.setRole("serviceSpecRelationship");
		r1.setRelationshipType("aggregation");
		this.addServiceSpecRelationshipItem(r1);
	}
}
