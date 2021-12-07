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

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
 * ResourceSpecification.
 */
@ApiModel(description = "Resources are physical or non-physical components (or some combination of these) within an enterprise's infrastructure or inventory. They are typically consumed or used by services (for example a physical port assigned to a service) or contribute to the realization of a Product (for example, a SIM card). They can be drawn from the Application, Computing and Network domains, and include, for example, Network Elements, software, IT systems, content and information, and technology components. A ResourceSpecification is an abstract base class for representing a generic means for implementing a particular type of Resource. In essence, a ResourceSpecification defines the common attributes and relationships of a set of related Resources, while Resource defines a specific instance that is based on a particular ResourceSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Entity(name = "ResSpec")
public abstract class ResourceSpecification extends BaseEntity {
	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("isBundle")
	protected Boolean isBundle = null;

	@JsonProperty("category")
	protected String category = null;

	@JsonProperty("targetResourceSchema")
	protected TargetResourceSchema targetResourceSchema = null;

	

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<AttachmentRefOrValue> attachment = new HashSet<>();

	@JsonProperty("featureSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<FeatureSpecification> featureSpecification = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("resourceSpecCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<ResourceSpecificationCharacteristic> resourceSpecCharacteristic =  new HashSet<>();

	@JsonProperty("resourceSpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<ResourceSpecificationRelationship> resourceSpecRelationship =  new HashSet<>();


	@JsonIgnore
	@Column( name = "candidate_specid" )
	private String resourceCandidateObjId;


	


	/**
	 * Unique identifier of this REST resource
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of this REST resource")

	public String getId() {
		id = uuid;
		return uuid;
	}


	public ResourceSpecification href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference to this REST resource
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Hyperlink reference to this REST resource")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ResourceSpecification category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Category of the target resource like NetworkConnectivity, PhysicalLinks,
	 * Generic, L2Network and so on.
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ResourceSpecification description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of this REST resource
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Description of this REST resource")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceSpecification isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * A flag indicates that if this resource specification is a bundled
	 * specification (true) or single (false).
	 * 
	 * @return isBundle
	 **/
	@ApiModelProperty(value = "A flag indicates that if this resource specification is a bundled specification (true) or single (false).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	

	public ResourceSpecification lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status of the resource specification
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status of the resource specification")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public ResourceSpecification name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name given to this REST resource
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name given to this REST resource")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceSpecification version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Resource Specification version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Resource Specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ResourceSpecification attachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ResourceSpecification addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new HashSet<>();
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
	@ApiModelProperty(value = "Complements the description of an element (for instance a resource) through video, pictures ...")
	@Valid
	public Set<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public ResourceSpecification featureSpecification(Set<FeatureSpecification> featureSpecification) {
		this.featureSpecification = featureSpecification;
		return this;
	}

	public ResourceSpecification addFeatureSpecificationItem(FeatureSpecification featureSpecificationItem) {
		if (this.featureSpecification == null) {
			this.featureSpecification = new HashSet<>();
		}
		this.featureSpecification.add(featureSpecificationItem);
		return this;
	}

	/**
	 * A list of Features for this specification.
	 * 
	 * @return featureSpecification
	 **/
	@ApiModelProperty(value = "A list of Features for this specification.")
	@Valid
	public Set<FeatureSpecification> getFeatureSpecification() {
		return featureSpecification;
	}

	public void setFeatureSpecification(Set<FeatureSpecification> featureSpecification) {
		this.featureSpecification = featureSpecification;
	}


	public ResourceSpecification resourceSpecCharacteristic(
			Set<ResourceSpecificationCharacteristic> resourceSpecCharacteristic) {
		this.resourceSpecCharacteristic = resourceSpecCharacteristic;
		return this;
	}

	public ResourceSpecification addResourceSpecCharacteristicItem(
			ResourceSpecificationCharacteristic resourceSpecCharacteristicItem) {
		if (this.resourceSpecCharacteristic == null) {
			this.resourceSpecCharacteristic = new HashSet<>();
		}
		this.resourceSpecCharacteristic.add(resourceSpecCharacteristicItem);
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
	 * @return resourceSpecCharacteristic
	 **/

	@ApiModelProperty(value = "A characteristic quality or distinctive feature of a ResourceSpecification.  The characteristic can be take on a discrete value, such as color, can take on a range of values, (for example, sensitivity of 100-240 mV), or can be derived from a formula (for example, usage time (hrs) = 30 - talk time *3). Certain characteristics, such as color, may be configured during the ordering or some other process.")
	@Valid
	public Set<ResourceSpecificationCharacteristic> getResourceSpecCharacteristic() {
		return resourceSpecCharacteristic;
	}

	public void setResourceSpecCharacteristic(Set<ResourceSpecificationCharacteristic> resourceSpecCharacteristic) {
		this.resourceSpecCharacteristic = resourceSpecCharacteristic;
	}

	public ResourceSpecification resourceSpecRelationship(
			Set<ResourceSpecificationRelationship> resourceSpecRelationship) {
		this.resourceSpecRelationship = resourceSpecRelationship;
		return this;
	}

	public ResourceSpecification addResourceSpecRelationshipItem(
			ResourceSpecificationRelationship resourceSpecRelationshipItem) {
		if (this.resourceSpecRelationship == null) {
			this.resourceSpecRelationship = new HashSet<>();
		}
		this.resourceSpecRelationship.add(resourceSpecRelationshipItem);
		return this;
	}
	
	

	/**
	 * @return the resourceCandidateObjId
	 */
	public String getResourceCandidateObjId() {
		return resourceCandidateObjId;
	}


	/**
	 * @param resourceCandidateObjId the resourceCandidateObjId to set
	 */
	public void setResourceCandidateObjId(String resourceCandidateObjId) {
		this.resourceCandidateObjId = resourceCandidateObjId;
	}
	
	

	/**
	 * A migration, substitution, dependency or exclusivity relationship
	 * between/among resource specifications.
	 * 
	 * @return resourceSpecRelationship
	 **/
	@ApiModelProperty(value = "A migration, substitution, dependency or exclusivity relationship between/among resource specifications.")
	@Valid
	public Set<ResourceSpecificationRelationship> getResourceSpecRelationship() {
		return resourceSpecRelationship;
	}

	public void setResourceSpecRelationship(Set<ResourceSpecificationRelationship> resourceSpecRelationship) {
		this.resourceSpecRelationship = resourceSpecRelationship;
	}

	public ResourceSpecification targetResourceSchema(TargetResourceSchema targetResourceSchema) {
		this.targetResourceSchema = targetResourceSchema;
		return this;
	}

	/**
	 * Get targetResourceSchema
	 * 
	 * @return targetResourceSchema
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public TargetResourceSchema getTargetResourceSchema() {
		return targetResourceSchema;
	}

	public void setTargetResourceSchema(TargetResourceSchema targetResourceSchema) {
		this.targetResourceSchema = targetResourceSchema;
	}


	public ResourceSpecification baseType(String baseType) {
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

	public ResourceSpecification schemaLocation(String schemaLocation) {
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

	public String getAtSchemaLocation() {
		return schemaLocation;
	}

	public void setAtSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ResourceSpecification type(String type) {
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
		ResourceSpecification resourceSpecification = (ResourceSpecification) o;
		return Objects.equals(this.id, resourceSpecification.id)
				&& Objects.equals(this.href, resourceSpecification.href)
				&& Objects.equals(this.category, resourceSpecification.category)
				&& Objects.equals(this.description, resourceSpecification.description)
				&& Objects.equals(this.isBundle, resourceSpecification.isBundle)
				&& Objects.equals(this.lastUpdate, resourceSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceSpecification.lifecycleStatus)
				&& Objects.equals(this.name, resourceSpecification.name)
				&& Objects.equals(this.version, resourceSpecification.version)
				&& Objects.equals(this.attachment, resourceSpecification.attachment)
				&& Objects.equals(this.featureSpecification, resourceSpecification.featureSpecification)
				&& Objects.equals(this.relatedParty, resourceSpecification.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic, resourceSpecification.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, resourceSpecification.resourceSpecRelationship)
				&& Objects.equals(this.targetResourceSchema, resourceSpecification.targetResourceSchema)
				&& Objects.equals(this.validFor, resourceSpecification.validFor)
				&& Objects.equals(this.baseType, resourceSpecification.baseType)
				&& Objects.equals(this.schemaLocation, resourceSpecification.schemaLocation)
				&& Objects.equals(this.type, resourceSpecification.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, category, description, isBundle, lastUpdate, lifecycleStatus, name, version,
				attachment, featureSpecification, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship,
				targetResourceSchema, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
	


	public void fixResourceCharRelationhsipIDs() {
		for (ResourceSpecificationCharacteristic schar : resourceSpecCharacteristic) {
			for (ResourceSpecCharRelationship charRel : schar.getResourceSpecCharRelationship()) {
				if (charRel.getId() == null) {
					// search other specCharacteristics inside the resourceSpec to get the id (if
					// they have same name). Then ID will be the same as the id of the
					// resourceSpecCharacteristic
					for (ResourceSpecificationCharacteristic searchChar : resourceSpecCharacteristic) {
						if (searchChar.getName().equals(charRel.getName())) {
							charRel.setId(searchChar.getUuid());
							break;
						}
					}

				}
				// if still is null se this id:
				if (charRel.getId() == null) {
					charRel.setId(this.getName() + "-" + charRel.getName());
				}
			}

		}

	}

	/**
	 * @return the relatedParty
	 */
	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	/**
	 * @param relatedParty the relatedParty to set
	 */
	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ResourceSpecificationCharacteristic findSpecCharacteristicByName(String a) {
		for (ResourceSpecificationCharacteristic ssci : this.getResourceSpecCharacteristic()) {
			if (ssci.getName().equals(a)) {
				return ssci;
			}
		}
		return null;
	}
}
