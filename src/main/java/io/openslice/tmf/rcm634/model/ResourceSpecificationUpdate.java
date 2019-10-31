package io.openslice.tmf.rcm634.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
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
 * ResourceSpecification. Skipped properties: id,href,id,href,lastUpdate,@type
 */
@ApiModel(description = "Resources are physical or non-physical components (or some combination of these) within an enterprise's infrastructure or inventory. They are typically consumed or used by services (for example a physical port assigned to a service) or contribute to the realization of a Product (for example, a SIM card). They can be drawn from the Application, Computing and Network domains, and include, for example, Network Elements, software, IT systems, content and information, and technology components. A ResourceSpecification is an abstract base class for representing a generic means for implementing a particular type of Resource. In essence, a ResourceSpecification defines the common attributes and relationships of a set of related Resources, while Resource defines a specific instance that is based on a particular ResourceSpecification. Skipped properties: id,href,id,href,lastUpdate,@type")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceSpecificationUpdate {
	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("description")
	protected String description = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("version")
	protected String version = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;

	@JsonProperty("lifecycleStatus")
	protected String lifecycleStatus = null;

	@JsonProperty("isBundle")
	protected Boolean isBundle = null;

	@JsonProperty("category")
	protected String category = null;

	@JsonProperty("targetResourceSchema")
	protected TargetResourceSchemaRef targetResourceSchema = null;

	@JsonProperty("feature")
	@Valid
	protected List<Feature> feature = null;

	@JsonProperty("attachment")
	@Valid
	protected List<AttachmentRef> attachment = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("resourceSpecCharacteristic")
	@Valid
	protected List<ResourceSpecCharacteristic> resourceSpecCharacteristic = null;

	@JsonProperty("resourceSpecRelationship")
	@Valid
	protected List<ResourceSpecRelationship> resourceSpecRelationship = null;

	public ResourceSpecificationUpdate name(String name) {
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

	public ResourceSpecificationUpdate description(String description) {
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

	public ResourceSpecificationUpdate schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * This field provides a link to the schema describing this REST resource
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "This field provides a link to the schema describing this REST resource")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ResourceSpecificationUpdate baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * The (immediate) base class type of this REST resource
	 * 
	 * @return baseType
	 **/
	@ApiModelProperty(value = "The (immediate) base class type of this REST resource")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
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
	@ApiModelProperty(value = "Resource Specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ResourceSpecificationUpdate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which this REST resource is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which this REST resource is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
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
	@ApiModelProperty(value = "Used to indicate the current lifecycle status of the resource specification")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
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
	@ApiModelProperty(value = "A flag indicates that if this resource specification is a bundled specification (true) or single (false).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

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
	@ApiModelProperty(value = "Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ResourceSpecificationUpdate targetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
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

	public TargetResourceSchemaRef getTargetResourceSchema() {
		return targetResourceSchema;
	}

	public void setTargetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
		this.targetResourceSchema = targetResourceSchema;
	}

	public ResourceSpecificationUpdate feature(List<Feature> feature) {
		this.feature = feature;
		return this;
	}

	public ResourceSpecificationUpdate addFeatureItem(Feature featureItem) {
		if (this.feature == null) {
			this.feature = new ArrayList<>();
		}
		this.feature.add(featureItem);
		return this;
	}

	/**
	 * Get feature
	 * 
	 * @return feature
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}

	public ResourceSpecificationUpdate attachment(List<AttachmentRef> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ResourceSpecificationUpdate addAttachmentItem(AttachmentRef attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new ArrayList<AttachmentRef>();
		}
		this.attachment.add(attachmentItem);
		return this;
	}

	/**
	 * Get attachment
	 * 
	 * @return attachment
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<AttachmentRef> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentRef> attachment) {
		this.attachment = attachment;
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
	 * Get relatedParty
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ResourceSpecificationUpdate resourceSpecCharacteristic(
			List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
		this.resourceSpecCharacteristic = resourceSpecCharacteristic;
		return this;
	}

	public ResourceSpecificationUpdate addResourceSpecCharacteristicItem(
			ResourceSpecCharacteristic resourceSpecCharacteristicItem) {
		if (this.resourceSpecCharacteristic == null) {
			this.resourceSpecCharacteristic = new ArrayList<>();
		}
		this.resourceSpecCharacteristic.add(resourceSpecCharacteristicItem);
		return this;
	}

	/**
	 * Get resourceSpecCharacteristic
	 * 
	 * @return resourceSpecCharacteristic
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<ResourceSpecCharacteristic> getResourceSpecCharacteristic() {
		return resourceSpecCharacteristic;
	}

	public void setResourceSpecCharacteristic(List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
		this.resourceSpecCharacteristic = resourceSpecCharacteristic;
	}

	public ResourceSpecificationUpdate resourceSpecRelationship(
			List<ResourceSpecRelationship> resourceSpecRelationship) {
		this.resourceSpecRelationship = resourceSpecRelationship;
		return this;
	}

	public ResourceSpecificationUpdate addResourceSpecRelationshipItem(
			ResourceSpecRelationship resourceSpecRelationshipItem) {
		if (this.resourceSpecRelationship == null) {
			this.resourceSpecRelationship = new ArrayList<>();
		}
		this.resourceSpecRelationship.add(resourceSpecRelationshipItem);
		return this;
	}

	/**
	 * Get resourceSpecRelationship
	 * 
	 * @return resourceSpecRelationship
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<ResourceSpecRelationship> getResourceSpecRelationship() {
		return resourceSpecRelationship;
	}

	public void setResourceSpecRelationship(List<ResourceSpecRelationship> resourceSpecRelationship) {
		this.resourceSpecRelationship = resourceSpecRelationship;
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
		return Objects.equals(this.name, resourceSpecificationUpdate.name)
				&& Objects.equals(this.description, resourceSpecificationUpdate.description)
				&& Objects.equals(this.schemaLocation, resourceSpecificationUpdate.schemaLocation)
				&& Objects.equals(this.baseType, resourceSpecificationUpdate.baseType)
				&& Objects.equals(this.version, resourceSpecificationUpdate.version)
				&& Objects.equals(this.validFor, resourceSpecificationUpdate.validFor)
				&& Objects.equals(this.lifecycleStatus, resourceSpecificationUpdate.lifecycleStatus)
				&& Objects.equals(this.isBundle, resourceSpecificationUpdate.isBundle)
				&& Objects.equals(this.category, resourceSpecificationUpdate.category)
				&& Objects.equals(this.targetResourceSchema, resourceSpecificationUpdate.targetResourceSchema)
				&& Objects.equals(this.feature, resourceSpecificationUpdate.feature)
				&& Objects.equals(this.attachment, resourceSpecificationUpdate.attachment)
				&& Objects.equals(this.relatedParty, resourceSpecificationUpdate.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic,
						resourceSpecificationUpdate.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, resourceSpecificationUpdate.resourceSpecRelationship);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, schemaLocation, baseType, version, validFor, lifecycleStatus, isBundle,
				category, targetResourceSchema, feature, attachment, relatedParty, resourceSpecCharacteristic,
				resourceSpecRelationship);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecificationUpdate {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

	public void addResourceSpecRelationshipWith(ResourceSpecification responsesSpec1) {

		ResourceSpecRelationship r1 = new ResourceSpecRelationship();
		r1.setId(responsesSpec1.getId());
		r1.setName(responsesSpec1.getName());
		r1.setRole("serviceSpecRelationship");
		r1.setRelationshipType("aggregation");
		this.addResourceSpecRelationshipItem(r1);
	}
}