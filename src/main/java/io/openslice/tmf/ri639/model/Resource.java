package io.openslice.tmf.ri639.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Resource is an abstract entity that describes the common set of attributes
 * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
 */
@Schema(description = "Resource is an abstract entity that describes the common set of attributes shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIResource")
public class Resource extends BaseRootNamedEntity {
	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("category")
	protected String category = null;


	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	protected String description = null;

	protected OffsetDateTime endOperatingDate = null;

	@JsonProperty("resourceVersion")
	protected String resourceVersion = null;

	protected OffsetDateTime startOperatingDate = null;

	@JsonProperty("activationFeature")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<Feature> activationFeature = new HashSet<>();

	@JsonProperty("administrativeState")
	protected ResourceAdministrativeStateType administrativeState = null;

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<AttachmentRefOrValue> attachment = new HashSet<>();

	@JsonProperty("note")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<Note> note = new HashSet<>();

	@JsonProperty("operationalState")
	protected ResourceOperationalStateType operationalState = null;

	@JsonProperty("place")
	@OneToOne(cascade = CascadeType.ALL)
	protected RelatedPlaceRefOrValue place = null;

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("resourceCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<Characteristic> resourceCharacteristic = new HashSet<>();

	@JsonProperty("resourceRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<ResourceRelationship> resourceRelationship = new HashSet<>();

	@JsonProperty("resourceSpecification")
	@OneToOne( cascade = {CascadeType.ALL} )
    @JoinColumn(name = "resSpecRef", referencedColumnName = "uuid")
	protected ResourceSpecificationRef resourceSpecification = null;

	@JsonProperty("resourceStatus")
	protected ResourceStatusType resourceStatus = ResourceStatusType.UNKNOWN;

	@JsonProperty("usageState")
	protected ResourceUsageStateType usageState = ResourceUsageStateType.IDLE;


	

	/**
	 * Identifier of an instance of the resource. Required to be unique within the
	 * resource type. Used in URIs as the identifier for specific instances of a
	 * type.
	 * 
	 * @return id
	 **/
	@Schema(description = "Identifier of an instance of the resource. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type.")
	@NotNull
	public String getId() {
		id = uuid;
		return uuid;
	}

	/**
	 * The URI for the object itself.
	 * 
	 * @return href
	 **/
	@Schema(description = "The URI for the object itself.")
	@NotNull

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Resource category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Category of the concrete resource. e.g Gold, Silver for MSISDN concrete
	 * resource
	 * 
	 * @return category
	 **/
	@Schema(description = "Category of the concrete resource. e.g Gold, Silver for MSISDN concrete resource")

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Resource description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * free-text description of the resource
	 * 
	 * @return description
	 **/
	@Schema(description = "free-text description of the resource")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	@JsonProperty("endOperatingDate")
	public String getEndOperatingDateStr() {
		if ( this.endOperatingDate != null ) {
			return this.endOperatingDate.toString();			
		} else {
			return null;
		}
	}
	
	public void setEndOperatingDate(String endDate) {
		if ( endDate!=null ) {
			this.endOperatingDate = OffsetDateTime.parse( endDate );			
		}
	}
	
	public Resource endOperatingDate(OffsetDateTime endOperatingDate) {
		this.endOperatingDate = endOperatingDate;
		return this;
	}

	/**
	 * A date time( DateTime). The date till the resource is operating
	 * 
	 * @return endOperatingDate
	 **/
	@Schema(description = "A date time( DateTime). The date till the resource is operating")

	@Valid
	public OffsetDateTime getEndOperatingDate() {
		return endOperatingDate;
	}

	public void setEndOperatingDate(OffsetDateTime endOperatingDate) {
		this.endOperatingDate = endOperatingDate;
	}

	public Resource name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A string used to give a name to the resource
	 * 
	 * @return name
	 **/
	@Schema(description = "A string used to give a name to the resource")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Resource resourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
		return this;
	}

	/**
	 * A field that identifies the specific version of an instance of a resource.
	 * 
	 * @return resourceVersion
	 **/
	@Schema(description = "A field that identifies the specific version of an instance of a resource.")

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	public Resource startOperatingDate(OffsetDateTime startOperatingDate) {
		this.startOperatingDate = startOperatingDate;
		return this;
	}

	/**
	 * A date time( DateTime). The date from which the resource is operating
	 * 
	 * @return startOperatingDate
	 **/
	@Schema(description = "A date time( DateTime). The date from which the resource is operating")


	@JsonProperty("startOperatingDate")
	public String getStartOperatingDateStr() {
		if ( this.startOperatingDate != null ) {
			return this.startOperatingDate.toString();			
		} else {
			return null;
		}
	}
	
	public void setStartOperatingDate(String startOperatingDate) {
		if ( startOperatingDate!=null ) {
			this.startOperatingDate = OffsetDateTime.parse( startOperatingDate );			
		}
	}
	
	@Valid
	public OffsetDateTime getStartOperatingDate() {
		return startOperatingDate;
	}

	public void setStartOperatingDate(OffsetDateTime startOperatingDate) {
		this.startOperatingDate = startOperatingDate;
	}

	public Resource activationFeature( Set<Feature> activationFeature) {
		this.activationFeature = activationFeature;
		return this;
	}

	public Resource addActivationFeatureItem(Feature activationFeatureItem) {
		if (this.activationFeature == null) {
			this.activationFeature = new HashSet<>();
		}
		this.activationFeature.add(activationFeatureItem);
		return this;
	}

	/**
	 * Configuration features
	 * 
	 * @return activationFeature
	 **/
	@Schema(description = "Configuration features")
	@Valid
	public Set<Feature> getActivationFeature() {
		return activationFeature;
	}

	public void setActivationFeature(Set<Feature> activationFeature) {
		this.activationFeature = activationFeature;
	}

	public Resource administrativeState(ResourceAdministrativeStateType administrativeState) {
		this.administrativeState = administrativeState;
		return this;
	}

	/**
	 * Get administrativeState
	 * 
	 * @return administrativeState
	 **/
	@Schema(description = "")

	@Valid
	public ResourceAdministrativeStateType getAdministrativeState() {
		return administrativeState;
	}

	public void setAdministrativeState(ResourceAdministrativeStateType administrativeState) {
		this.administrativeState = administrativeState;
	}

	public Resource attachment( Set <AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public Resource addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new HashSet<>();
		}
		this.attachment.add(attachmentItem);
		return this;
	}

	/**
	 * Get attachment
	 * 
	 * @return attachment
	 **/
	@Schema(description = "")
	@Valid
	public Set<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public Resource note(Set<Note> note) {
		this.note = note;
		return this;
	}

	public Resource addNoteItem(Note noteItem) {
		if (this.note == null) {
			this.note = new HashSet<>();
		}
		this.note.add(noteItem);
		return this;
	}

	/**
	 * Get note
	 * 
	 * @return note
	 **/
	@Schema(description = "")
	@Valid
	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	public Resource operationalState(ResourceOperationalStateType operationalState) {
		this.operationalState = operationalState;
		return this;
	}

	/**
	 * Get operationalState
	 * 
	 * @return operationalState
	 **/
	@Schema(description = "")

	@Valid
	public ResourceOperationalStateType getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(ResourceOperationalStateType operationalState) {
		this.operationalState = operationalState;
	}

	public Resource place(RelatedPlaceRefOrValue place) {
		this.place = place;
		return this;
	}

	/**
	 * Get place
	 * 
	 * @return place
	 **/
	@Schema(description = "")

	@Valid
	public RelatedPlaceRefOrValue getPlace() {
		return place;
	}

	public void setPlace(RelatedPlaceRefOrValue place) {
		this.place = place;
	}

	public Resource relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public Resource addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Get relatedParty
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "")
	@Valid
	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public Resource resourceCharacteristic(Set<Characteristic> resourceCharacteristic) {
		this.resourceCharacteristic = resourceCharacteristic;
		return this;
	}

	public Resource addResourceCharacteristicItem(Characteristic resourceCharacteristicItem) {
		if (this.resourceCharacteristic == null) {
			this.resourceCharacteristic = new HashSet<>();
		}
		this.resourceCharacteristic.add(resourceCharacteristicItem);
		return this;
	}

	/**
	 * Get resourceCharacteristic
	 * 
	 * @return resourceCharacteristic
	 **/
	@Schema(description = "")
	@Valid
	public Set<Characteristic> getResourceCharacteristic() {
		return resourceCharacteristic;
	}

	public void setResourceCharacteristic(Set<Characteristic> resourceCharacteristic) {
		this.resourceCharacteristic = resourceCharacteristic;
	}

	public Resource resourceRelationship(Set<ResourceRelationship> resourceRelationship) {
		this.resourceRelationship = resourceRelationship;
		return this;
	}

	public Resource addResourceRelationshipItem(ResourceRelationship resourceRelationshipItem) {
		if (this.resourceRelationship == null) {
			this.resourceRelationship = new HashSet<>();
		}
		this.resourceRelationship.add(resourceRelationshipItem);
		return this;
	}

	/**
	 * Get resourceRelationship
	 * 
	 * @return resourceRelationship
	 **/
	@Schema(description = "")
	@Valid
	public Set<ResourceRelationship> getResourceRelationship() {
		return resourceRelationship;
	}

	public void setResourceRelationship(Set<ResourceRelationship> resourceRelationship) {
		this.resourceRelationship = resourceRelationship;
	}

	public Resource resourceSpecification(ResourceSpecificationRef resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
		return this;
	}

	/**
	 * Get resourceSpecification
	 * 
	 * @return resourceSpecification
	 **/
	@Schema(description = "")

	@Valid
	public ResourceSpecificationRef getResourceSpecification() {
		return resourceSpecification;
	}

	public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
		this.resourceSpecification = resourceSpecification;
	}

	public Resource resourceStatus(ResourceStatusType resourceStatus) {
		this.resourceStatus = resourceStatus;
		return this;
	}

	/**
	 * Get resourceStatus
	 * 
	 * @return resourceStatus
	 **/
	@Schema(description = "")

	@Valid
	public ResourceStatusType getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(ResourceStatusType resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public Resource usageState(ResourceUsageStateType usageState) {
		this.usageState = usageState;
		return this;
	}

	/**
	 * Get usageState
	 * 
	 * @return usageState
	 **/
	@Schema(description = "")

	@Valid
	public ResourceUsageStateType getUsageState() {
		return usageState;
	}

	public void setUsageState(ResourceUsageStateType usageState) {
		this.usageState = usageState;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Resource resource = (Resource) o;
		return Objects.equals(this.id, resource.id) && Objects.equals(this.href, resource.href)
				&& Objects.equals(this.category, resource.category)
				&& Objects.equals(this.description, resource.description)
				&& Objects.equals(this.endOperatingDate, resource.endOperatingDate)
				&& Objects.equals(this.name, resource.name)
				&& Objects.equals(this.resourceVersion, resource.resourceVersion)
				&& Objects.equals(this.startOperatingDate, resource.startOperatingDate)
				&& Objects.equals(this.activationFeature, resource.activationFeature)
				&& Objects.equals(this.administrativeState, resource.administrativeState)
				&& Objects.equals(this.attachment, resource.attachment) && Objects.equals(this.note, resource.note)
				&& Objects.equals(this.operationalState, resource.operationalState)
				&& Objects.equals(this.place, resource.place)
				&& Objects.equals(this.relatedParty, resource.relatedParty)
				&& Objects.equals(this.resourceCharacteristic, resource.resourceCharacteristic)
				&& Objects.equals(this.resourceRelationship, resource.resourceRelationship)
				&& Objects.equals(this.resourceSpecification, resource.resourceSpecification)
				&& Objects.equals(this.resourceStatus, resource.resourceStatus)
				&& Objects.equals(this.usageState, resource.usageState)
				&& Objects.equals(this.baseType, resource.baseType)
				&& Objects.equals(this.schemaLocation, resource.schemaLocation)
				&& Objects.equals(this.type, resource.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, category, description, endOperatingDate, name, resourceVersion,
				startOperatingDate, activationFeature, administrativeState, attachment, note, operationalState, place,
				relatedParty, resourceCharacteristic, resourceRelationship, resourceSpecification, resourceStatus,
				usageState, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Resource {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    endOperatingDate: ").append(toIndentedString(endOperatingDate)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    resourceVersion: ").append(toIndentedString(resourceVersion)).append("\n");
		sb.append("    startOperatingDate: ").append(toIndentedString(startOperatingDate)).append("\n");
		sb.append("    activationFeature: ").append(toIndentedString(activationFeature)).append("\n");
		sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceCharacteristic: ").append(toIndentedString(resourceCharacteristic)).append("\n");
		sb.append("    resourceRelationship: ").append(toIndentedString(resourceRelationship)).append("\n");
		sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
		sb.append("    resourceStatus: ").append(toIndentedString(resourceStatus)).append("\n");
		sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
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
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public Characteristic getResourceCharacteristicByName(String aName) {
		for (Characteristic c : this.resourceCharacteristic) {
			if ( c.getName().equals( aName )) {
				return c;
			}
		}
		return null;
	}
}
