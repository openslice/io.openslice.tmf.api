package io.openslice.tmf.scm633.model;

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
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServiceSpecification is a class that offers characteristics to describe a
 * type of service. Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics.
 */
@ApiModel(description = "ServiceSpecification is a class that offers characteristics to describe a type of service. Functionally, it acts as a template by which Services may be instantiated. By sharing the same  specification, these services would therefore share the same set of characteristics.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Entity(name = "ServiceSpecification")
public class ServiceSpecification extends BaseEntity {

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AttachmentRef> attachment = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("resourceSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceSpecificationRef> resourceSpecification = new HashSet<>();

	@JsonProperty("serviceLevelSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceLevelSpecificationRef> serviceLevelSpecification = new HashSet<>();

	@JsonProperty("serviceSpecCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceSpecCharacteristic> serviceSpecCharacteristic = new HashSet<>();

	@JsonProperty("serviceSpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceSpecRelationship> serviceSpecRelationship = new HashSet<>();

	@JsonProperty("targetServiceSchema")
	private TargetServiceSchema targetServiceSchema = null;

	@JsonProperty("id")
	protected String id = null;

	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}

	public ServiceSpecification() {
		super();
		this.baseType = "BaseEntity";
		this.type = "CustomerFacingServiceSpecification";
	}

	public ServiceSpecification(ServiceSpecification src) {
		this();
		name = src.name;
		description = src.description;
		isBundle = src.isBundle;
		lastUpdate = src.lastUpdate;
		lifecycleStatus = src.lifecycleStatus;
		version = src.version;
		validFor = new TimePeriod(src.validFor);

		for (AttachmentRef attachmentRef : src.attachment) {
			this.addAttachmentItem( new AttachmentRef( attachmentRef ));
		}
		for (RelatedParty r : src.relatedParty) {
			this.addRelatedPartyItem( new RelatedParty( r) );
		}
		for (ResourceSpecificationRef r : src.resourceSpecification) {
			this.addResourceSpecificationItem( new ResourceSpecificationRef(r) );
		}
		for (ServiceLevelSpecificationRef r : src.serviceLevelSpecification) {
			this.addServiceLevelSpecificationItem( new ServiceLevelSpecificationRef(r) );
		}
		for (ServiceSpecCharacteristic r : src.serviceSpecCharacteristic) {			
			this.addServiceSpecCharacteristicItem( new ServiceSpecCharacteristic(r) );
		}
		for (ServiceSpecRelationship r : src.serviceSpecRelationship) {
			this.addServiceSpecRelationshipItem( new ServiceSpecRelationship(r));
		}

	}

	public ServiceSpecification isBundle(Boolean isBundle) {
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

	public ServiceSpecification attachment(Set<AttachmentRef> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ServiceSpecification addAttachmentItem(AttachmentRef attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new HashSet<AttachmentRef>();
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

	public Set<AttachmentRef> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRef> attachment) {
		this.attachment = attachment;
	}

	public ServiceSpecification relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceSpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<RelatedParty>();
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

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceSpecification resourceSpecification(Set<ResourceSpecificationRef> resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
		return this;
	}

	public ServiceSpecification addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
		if (this.resourceSpecification == null) {
			this.resourceSpecification = new HashSet<ResourceSpecificationRef>();
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

	public Set<ResourceSpecificationRef> getResourceSpecification() {
		return resourceSpecification;
	}

	public void setResourceSpecification(Set<ResourceSpecificationRef> resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
	}

	public ServiceSpecification serviceLevelSpecification(Set<ServiceLevelSpecificationRef> serviceLevelSpecification) {
		this.serviceLevelSpecification = serviceLevelSpecification;
		return this;
	}

	public ServiceSpecification addServiceLevelSpecificationItem(
			ServiceLevelSpecificationRef serviceLevelSpecificationItem) {
		if (this.serviceLevelSpecification == null) {
			this.serviceLevelSpecification = new HashSet<ServiceLevelSpecificationRef>();
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

	public Set<ServiceLevelSpecificationRef> getServiceLevelSpecification() {
		return serviceLevelSpecification;
	}

	public void setServiceLevelSpecification(Set<ServiceLevelSpecificationRef> serviceLevelSpecification) {
		this.serviceLevelSpecification = serviceLevelSpecification;
	}

	public ServiceSpecification serviceSpecCharacteristic(Set<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
		this.serviceSpecCharacteristic = serviceSpecCharacteristic;
		return this;
	}

	public ServiceSpecification addServiceSpecCharacteristicItem(
			ServiceSpecCharacteristic serviceSpecCharacteristicItem) {
		if (this.serviceSpecCharacteristic == null) {
			this.serviceSpecCharacteristic = new HashSet<ServiceSpecCharacteristic>();
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

	public Set<ServiceSpecCharacteristic> getServiceSpecCharacteristic() {
		return serviceSpecCharacteristic;
	}

	public void setServiceSpecCharacteristic(Set<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
		this.serviceSpecCharacteristic = serviceSpecCharacteristic;
	}

	public ServiceSpecification serviceSpecRelationship(Set<ServiceSpecRelationship> serviceSpecRelationship) {
		this.serviceSpecRelationship = serviceSpecRelationship;
		return this;
	}

	public ServiceSpecification addServiceSpecRelationshipItem(ServiceSpecRelationship serviceSpecRelationshipItem) {
		if (this.serviceSpecRelationship == null) {
			this.serviceSpecRelationship = new HashSet<ServiceSpecRelationship>();
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

	public Set<ServiceSpecRelationship> getServiceSpecRelationship() {
		return serviceSpecRelationship;
	}

	public void setServiceSpecRelationship(Set<ServiceSpecRelationship> serviceSpecRelationship) {
		this.serviceSpecRelationship = serviceSpecRelationship;
	}

	public ServiceSpecification targetServiceSchema(TargetServiceSchema targetServiceSchema) {
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

	



	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceSpecification serviceSpecification = (ServiceSpecification) o;
		return Objects.equals(this.id, serviceSpecification.id) && Objects.equals(this.uuid, serviceSpecification.uuid)
				&& Objects.equals(this.href, serviceSpecification.href)
				&& Objects.equals(this.description, serviceSpecification.description)
				&& Objects.equals(this.isBundle, serviceSpecification.isBundle)
				&& Objects.equals(this.lastUpdate, serviceSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceSpecification.lifecycleStatus)
				&& Objects.equals(this.name, serviceSpecification.name)
				&& Objects.equals(this.version, serviceSpecification.version)
				&& Objects.equals(this.attachment, serviceSpecification.attachment)
				&& Objects.equals(this.relatedParty, serviceSpecification.relatedParty)
				&& Objects.equals(this.resourceSpecification, serviceSpecification.resourceSpecification)
				&& Objects.equals(this.serviceLevelSpecification, serviceSpecification.serviceLevelSpecification)
				&& Objects.equals(this.serviceSpecCharacteristic, serviceSpecification.serviceSpecCharacteristic)
				&& Objects.equals(this.serviceSpecRelationship, serviceSpecification.serviceSpecRelationship)
				&& Objects.equals(this.targetServiceSchema, serviceSpecification.targetServiceSchema)
				&& Objects.equals(this.validFor, serviceSpecification.validFor)
				&& Objects.equals(this.baseType, serviceSpecification.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecification.schemaLocation)
				&& Objects.equals(this.type, serviceSpecification.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, id, href, description, isBundle, lastUpdate, lifecycleStatus, name, version,
//				attachment, relatedParty, resourceSpecification, serviceLevelSpecification, serviceSpecCharacteristic,
//				serviceSpecRelationship, targetServiceSchema, validFor, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecification {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
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

	public ServiceSpecCharacteristic findSpecCharacteristicByName(String an) {
		for (ServiceSpecCharacteristic ssci : this.getServiceSpecCharacteristic()) {
			if (ssci.getName().equals(an)) {
				return ssci;
			}
		}
		return null;
	}

	/**
	 * we fix here the ids of the ServiceSpecCharRelationships. remind also that we
	 * have a role="tag"
	 */
	public void fixSpecCharRelationhsipIDs() {
		for (ServiceSpecCharacteristic schar : serviceSpecCharacteristic) {
			for (ServiceSpecCharRelationship charRel : schar.getServiceSpecCharRelationship()) {
				if (charRel.getId() == null) {
					// search other specCharacteristics inside the serviceSpec to get the id (if
					// they have same name). Then ID will be the same as the id of the
					// serviceSpecCharacteristic
					for (ServiceSpecCharacteristic searchChar : serviceSpecCharacteristic) {
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
}
