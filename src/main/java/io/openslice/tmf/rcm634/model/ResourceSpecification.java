package io.openslice.tmf.rcm634.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
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
 * ResourceSpecification.
 */
@ApiModel(description = "Resources are physical or non-physical components (or some combination of these) within an enterprise's infrastructure or inventory. They are typically consumed or used by services (for example a physical port assigned to a service) or contribute to the realization of a Product (for example, a SIM card). They can be drawn from the Application, Computing and Network domains, and include, for example, Network Elements, software, IT systems, content and information, and technology components. A ResourceSpecification is an abstract base class for representing a generic means for implementing a particular type of Resource. In essence, a ResourceSpecification defines the common attributes and relationships of a set of related Resources, while Resource defines a specific instance that is based on a particular ResourceSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")
@Entity(name = "ResourceSpecification")
public class ResourceSpecification extends BaseEntity {
	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("isBundle")
	protected Boolean isBundle = null;

	@JsonProperty("category")
	protected String category = null;

	@JsonProperty("targetResourceSchema")
	protected TargetResourceSchemaRef targetResourceSchema = null;

	@JsonProperty("feature")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<Feature> feature = null;

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<AttachmentRef> attachment = new HashSet<>();


	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("resourceSpecCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<ResourceSpecCharacteristic> resourceSpecCharacteristic = null;

	@JsonProperty("resourceSpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<ResourceSpecRelationship> resourceSpecRelationship = null;

	public ResourceSpecification() {
		super();
		this.baseType = "BaseEntity";
		this.type = "ResourceSpecification";

	}

	public ResourceSpecification(ResourceSpecification src) {
		this();
		name = src.name;
		description = src.description;
		isBundle = src.isBundle;
		lastUpdate = src.lastUpdate;
		lifecycleStatus = src.lifecycleStatus;
		version = src.version;
		validFor = new TimePeriod(src.validFor);

		for (AttachmentRef attachmentRef : src.attachment) {
			this.addAttachmentItem(new AttachmentRef(attachmentRef));
		}
		for (RelatedParty r : src.relatedParty) {
			this.addRelatedPartyItem(r);
		}

		for (ResourceSpecCharacteristic r : src.resourceSpecCharacteristic) {
			this.addResourceSpecCharacteristicItem(new ResourceSpecCharacteristic(r));
		}
		for (ResourceSpecRelationship r : src.resourceSpecRelationship) {
			this.addResourceSpecRelationshipItem(new ResourceSpecRelationship(r));
		}

	}

	public ResourceSpecification id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of this REST resource
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of this REST resource")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ResourceSpecification targetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
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

	public ResourceSpecification feature(Set<Feature> feature) {
		this.feature = feature;
		return this;
	}

	public ResourceSpecification addFeatureItem(Feature featureItem) {
		if (this.feature == null) {
			this.feature = new HashSet<>();
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

	public Set<Feature> getFeature() {
		return feature;
	}

	public void setFeature(Set<Feature> feature) {
		this.feature = feature;
	}

	public ResourceSpecification  attachment(Set<AttachmentRef> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ResourceSpecification addAttachmentItem(AttachmentRef attachmentItem) {
		if (this.attachment == null) {
			this.attachment =  new HashSet<AttachmentRef>();
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

	public Set<AttachmentRef> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRef> attachment) {
		this.attachment = attachment;
	}

	public ResourceSpecification relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ResourceSpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<RelatedParty>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}


	public ResourceSpecification resourceSpecCharacteristic(
			Set<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
		this.resourceSpecCharacteristic = resourceSpecCharacteristic;
		return this;
	}

	public ResourceSpecification addResourceSpecCharacteristicItem(
			ResourceSpecCharacteristic resourceSpecCharacteristicItem) {
		if (this.resourceSpecCharacteristic == null) {
			this.resourceSpecCharacteristic = new HashSet<>();
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

	public Set<ResourceSpecCharacteristic> getResourceSpecCharacteristic() {
		return resourceSpecCharacteristic;
	}

	public void setResourceSpecCharacteristic(Set<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
		this.resourceSpecCharacteristic = resourceSpecCharacteristic;
	}

	public ResourceSpecification resourceSpecRelationship(Set<ResourceSpecRelationship> resourceSpecRelationship) {
		this.resourceSpecRelationship = resourceSpecRelationship;
		return this;
	}

	public ResourceSpecification addResourceSpecRelationshipItem(
			ResourceSpecRelationship resourceSpecRelationshipItem) {
		if (this.resourceSpecRelationship == null) {
			this.resourceSpecRelationship = new HashSet<>();
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

	public Set<ResourceSpecRelationship> getResourceSpecRelationship() {
		return resourceSpecRelationship;
	}

	public void setResourceSpecRelationship(Set<ResourceSpecRelationship> resourceSpecRelationship) {
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
		ResourceSpecification resourceSpecification = (ResourceSpecification) o;
		return Objects.equals(this.id, resourceSpecification.id)
				&& Objects.equals(this.href, resourceSpecification.href)
				&& Objects.equals(this.name, resourceSpecification.name)
				&& Objects.equals(this.description, resourceSpecification.description)
				&& Objects.equals(this.type, resourceSpecification.type)
				&& Objects.equals(this.schemaLocation, resourceSpecification.schemaLocation)
				&& Objects.equals(this.baseType, resourceSpecification.baseType)
				&& Objects.equals(this.version, resourceSpecification.version)
				&& Objects.equals(this.validFor, resourceSpecification.validFor)
				&& Objects.equals(this.lastUpdate, resourceSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceSpecification.lifecycleStatus)
				&& Objects.equals(this.isBundle, resourceSpecification.isBundle)
				&& Objects.equals(this.category, resourceSpecification.category)
				&& Objects.equals(this.targetResourceSchema, resourceSpecification.targetResourceSchema)
				&& Objects.equals(this.feature, resourceSpecification.feature)
				&& Objects.equals(this.attachment, resourceSpecification.attachment)
				&& Objects.equals(this.relatedParty, resourceSpecification.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic, resourceSpecification.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, resourceSpecification.resourceSpecRelationship);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, id, href, name, description, type, schemaLocation, baseType, version, validFor,
//				lastUpdate, lifecycleStatus, isBundle, category, targetResourceSchema, feature, attachment,
//				relatedParty, resourceSpecCharacteristic, resourceSpecRelationship);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

	public void fixResourceCharRelationhsipIDs() {
		for (ResourceSpecCharacteristic schar : resourceSpecCharacteristic) {
			for (ResourceSpecCharRelationship charRel : schar.getResourceSpecCharRelationship()) {
				if (charRel.getId() == null) {
					// search other specCharacteristics inside the resourceSpec to get the id (if
					// they have same name). Then ID will be the same as the id of the
					// resourceSpecCharacteristic
					for (ResourceSpecCharacteristic searchChar : resourceSpecCharacteristic) {
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

	public ResourceSpecCharacteristic findSpecCharacteristicByName(String string) {
		for (ResourceSpecCharacteristic ssci : this.getResourceSpecCharacteristic()) {
			if (ssci.getName().equals(name)) {
				return ssci;
			}
		}
		return null;
	}

	
}
