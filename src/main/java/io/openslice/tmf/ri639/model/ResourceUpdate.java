package io.openslice.tmf.ri639.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Resource is an abstract entity that describes the common set of attributes
 * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
 * Skipped properties: id,href
 */
@Schema(description = "Resource is an abstract entity that describes the common set of attributes shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
public class ResourceUpdate {
	@JsonProperty("category")
	protected String category = null;

	@JsonProperty("description")
	protected String description = null;

	protected OffsetDateTime endOperatingDate = null;

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("resourceVersion")
	protected String resourceVersion = null;

	protected OffsetDateTime startOperatingDate = null;

	@JsonProperty("activationFeature")
	@Valid
	protected List<Feature> activationFeature = null;

	@JsonProperty("administrativeState")
	protected ResourceAdministrativeStateType administrativeState = null;

	@JsonProperty("attachment")
	@Valid
	protected List<AttachmentRefOrValue> attachment = null;

	@JsonProperty("note")
	@Valid
	protected List<Note> note = null;

	@JsonProperty("operationalState")
	protected ResourceOperationalStateType operationalState = null;

	@JsonProperty("place")
	protected RelatedPlaceRefOrValue place = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("resourceCharacteristic")
	@Valid
	protected List<Characteristic> resourceCharacteristic = null;

	@JsonProperty("resourceRelationship")
	@Valid
	protected List<ResourceRelationship> resourceRelationship = null;

	@JsonProperty("resourceSpecification")
	protected ResourceSpecificationRef resourceSpecification = null;

	@JsonProperty("resourceStatus")
	protected ResourceStatusType resourceStatus = null;

	@JsonProperty("usageState")
	protected ResourceUsageStateType usageState = null;

	@JsonProperty("@baseType")
	protected String _atBaseType = null;

	@JsonProperty("@schemaLocation")
	protected String _atSchemaLocation = null;

	@JsonProperty("@type")
	protected String _atType = null;

	public ResourceUpdate category(String category) {
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

	public ResourceUpdate description(String description) {
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

	public ResourceUpdate endOperatingDate(OffsetDateTime endOperatingDate) {
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

	@JsonProperty("endOperatingDate")
	@Valid
	public String getEndOperatingDateStr() {

		if (this.endOperatingDate != null) {
			return this.endOperatingDate.toString();
		} else {
			return null;
		}
	}


	public void setEndOperatingDate(String endOperatingDate) {
		if (endOperatingDate != null) {
			this.endOperatingDate = OffsetDateTime.parse(endOperatingDate);

		}
	}
	

	public ResourceUpdate name(String name) {
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

	public ResourceUpdate resourceVersion(String resourceVersion) {
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

	public ResourceUpdate startOperatingDate(OffsetDateTime startOperatingDate) {
		this.startOperatingDate = startOperatingDate;
		return this;
	}

	/**
	 * A date time( DateTime). The date from which the resource is operating
	 * 
	 * @return startOperatingDate
	 **/
	@Schema(description = "A date time( DateTime). The date from which the resource is operating")

	@Valid
	public OffsetDateTime getStartOperatingDate() {
		return startOperatingDate;
	}
	

	@JsonProperty("startOperatingDate")
	public String getStartOperatingDateStr() {
		if (this.startOperatingDate != null) {
			return this.startOperatingDate.toString();
		} else {
			return null;
		}
	}

	

	public void setStartOperatingDate(OffsetDateTime startOperatingDate) {
		this.startOperatingDate = startOperatingDate;
	}
	

	public void setStartOperatingDate(String  startOperatingDate) {
		if (startOperatingDate != null) {
			this.startOperatingDate = OffsetDateTime.parse(startOperatingDate);

		}
	}

	public ResourceUpdate activationFeature(List<Feature> activationFeature) {
		this.activationFeature = activationFeature;
		return this;
	}

	public ResourceUpdate addActivationFeatureItem(Feature activationFeatureItem) {
		if (this.activationFeature == null) {
			this.activationFeature = new ArrayList<>();
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
	public List<Feature> getActivationFeature() {
		return activationFeature;
	}

	public void setActivationFeature(List<Feature> activationFeature) {
		this.activationFeature = activationFeature;
	}

	public ResourceUpdate administrativeState(ResourceAdministrativeStateType administrativeState) {
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

	public ResourceUpdate attachment(List<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ResourceUpdate addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new ArrayList<>();
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
	public List<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public ResourceUpdate note(List<Note> note) {
		this.note = note;
		return this;
	}

	public ResourceUpdate addNoteItem(Note noteItem) {
		if (this.note == null) {
			this.note = new ArrayList<>();
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
	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	public ResourceUpdate operationalState(ResourceOperationalStateType operationalState) {
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

	public ResourceUpdate place(RelatedPlaceRefOrValue place) {
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

	public ResourceUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ResourceUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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
	@Schema(description = "")
	@Valid
	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ResourceUpdate resourceCharacteristic(List<Characteristic> resourceCharacteristic) {
		this.resourceCharacteristic = resourceCharacteristic;
		return this;
	}

	public ResourceUpdate addResourceCharacteristicItem(Characteristic resourceCharacteristicItem) {
		if (this.resourceCharacteristic == null) {
			this.resourceCharacteristic = new ArrayList<>();
		}
		this.resourceCharacteristic.add(resourceCharacteristicItem);
		return this;
	}
	
	
	public ResourceUpdate addResourceCharacteristicItemShort(String aname,
			String aValue,
			String valueType) {

		Characteristic resCharacteristicItem =  new Characteristic();
		resCharacteristicItem.setName( aname );
					
		Any val = new Any();
		val.setValue( aValue );
		val.setAlias( null );
		
		resCharacteristicItem.setValue( val );
		
		this.addResourceCharacteristicItem( resCharacteristicItem );
		return this;
	}

	/**
	 * Get resourceCharacteristic
	 * 
	 * @return resourceCharacteristic
	 **/
	@Schema(description = "")
	@Valid
	public List<Characteristic> getResourceCharacteristic() {
		return resourceCharacteristic;
	}

	public void setResourceCharacteristic(List<Characteristic> resourceCharacteristic) {
		this.resourceCharacteristic = resourceCharacteristic;
	}

	public ResourceUpdate resourceRelationship(List<ResourceRelationship> resourceRelationship) {
		this.resourceRelationship = resourceRelationship;
		return this;
	}

	public ResourceUpdate addResourceRelationshipItem(ResourceRelationship resourceRelationshipItem) {
		if (this.resourceRelationship == null) {
			this.resourceRelationship = new ArrayList<>();
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
	public List<ResourceRelationship> getResourceRelationship() {
		return resourceRelationship;
	}

	public void setResourceRelationship(List<ResourceRelationship> resourceRelationship) {
		this.resourceRelationship = resourceRelationship;
	}

	public ResourceUpdate resourceSpecification(ResourceSpecificationRef resourceSpecification) {
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

	public ResourceUpdate resourceStatus(ResourceStatusType resourceStatus) {
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

	public ResourceUpdate usageState(ResourceUsageStateType usageState) {
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

	public ResourceUpdate _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return _atBaseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
	}

	public ResourceUpdate _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public ResourceUpdate _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class Extensible name
	 * 
	 * @return _atType
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class Extensible name")

	public String getAtType() {
		return _atType;
	}

	public void setAtType(String _atType) {
		this._atType = _atType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceUpdate resourceUpdate = (ResourceUpdate) o;
		return Objects.equals(this.category, resourceUpdate.category)
				&& Objects.equals(this.description, resourceUpdate.description)
				&& Objects.equals(this.endOperatingDate, resourceUpdate.endOperatingDate)
				&& Objects.equals(this.name, resourceUpdate.name)
				&& Objects.equals(this.resourceVersion, resourceUpdate.resourceVersion)
				&& Objects.equals(this.startOperatingDate, resourceUpdate.startOperatingDate)
				&& Objects.equals(this.activationFeature, resourceUpdate.activationFeature)
				&& Objects.equals(this.administrativeState, resourceUpdate.administrativeState)
				&& Objects.equals(this.attachment, resourceUpdate.attachment)
				&& Objects.equals(this.note, resourceUpdate.note)
				&& Objects.equals(this.operationalState, resourceUpdate.operationalState)
				&& Objects.equals(this.place, resourceUpdate.place)
				&& Objects.equals(this.relatedParty, resourceUpdate.relatedParty)
				&& Objects.equals(this.resourceCharacteristic, resourceUpdate.resourceCharacteristic)
				&& Objects.equals(this.resourceRelationship, resourceUpdate.resourceRelationship)
				&& Objects.equals(this.resourceSpecification, resourceUpdate.resourceSpecification)
				&& Objects.equals(this.resourceStatus, resourceUpdate.resourceStatus)
				&& Objects.equals(this.usageState, resourceUpdate.usageState)
				&& Objects.equals(this._atBaseType, resourceUpdate._atBaseType)
				&& Objects.equals(this._atSchemaLocation, resourceUpdate._atSchemaLocation)
				&& Objects.equals(this._atType, resourceUpdate._atType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, endOperatingDate, name, resourceVersion, startOperatingDate,
				activationFeature, administrativeState, attachment, note, operationalState, place, relatedParty,
				resourceCharacteristic, resourceRelationship, resourceSpecification, resourceStatus, usageState,
				_atBaseType, _atSchemaLocation, _atType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceUpdate {\n");

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
		sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
}
