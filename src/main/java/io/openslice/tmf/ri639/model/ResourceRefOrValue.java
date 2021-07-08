package io.openslice.tmf.ri639.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.ri639.model.AttachmentRefOrValue;
import io.openslice.tmf.ri639.model.Characteristic;
import io.openslice.tmf.ri639.model.Feature;
import io.openslice.tmf.ri639.model.Note;
import io.openslice.tmf.ri639.model.RelatedParty;
import io.openslice.tmf.ri639.model.RelatedPlaceRefOrValue;
import io.openslice.tmf.ri639.model.ResourceAdministrativeStateType;
import io.openslice.tmf.ri639.model.ResourceOperationalStateType;
import io.openslice.tmf.ri639.model.ResourceRelationship;
import io.openslice.tmf.ri639.model.ResourceSpecificationRef;
import io.openslice.tmf.ri639.model.ResourceStatusType;
import io.openslice.tmf.ri639.model.ResourceUsageStateType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Resource is an abstract entity that describes the common set of attributes shared by all concrete resources. The polymorphic attributes @type, @schemaLocation &amp; @referredType are related to the Resource entity and not the related ResourceRefOrValue class itself
 */
@ApiModel(description = "Resource is an abstract entity that describes the common set of attributes shared by all concrete resources. The polymorphic attributes @type, @schemaLocation & @referredType are related to the Resource entity and not the related ResourceRefOrValue class itself")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
public class ResourceRefOrValue   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("endOperatingDate")
  private OffsetDateTime endOperatingDate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("resourceVersion")
  private String resourceVersion = null;

  @JsonProperty("startOperatingDate")
  private OffsetDateTime startOperatingDate = null;

  @JsonProperty("activationFeature")
  @Valid
  private List<Feature> activationFeature = null;

  @JsonProperty("administrativeState")
  private ResourceAdministrativeStateType administrativeState = null;

  @JsonProperty("attachment")
  @Valid
  private List<AttachmentRefOrValue> attachment = null;

  @JsonProperty("note")
  @Valid
  private List<Note> note = null;

  @JsonProperty("operationalState")
  private ResourceOperationalStateType operationalState = null;

  @JsonProperty("place")
  private RelatedPlaceRefOrValue place = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("resourceCharacteristic")
  @Valid
  private List<Characteristic> resourceCharacteristic = null;

  @JsonProperty("resourceRelationship")
  @Valid
  private List<ResourceRelationship> resourceRelationship = null;

  @JsonProperty("resourceSpecification")
  private ResourceSpecificationRef resourceSpecification = null;

  @JsonProperty("resourceStatus")
  private ResourceStatusType resourceStatus = null;

  @JsonProperty("usageState")
  private ResourceUsageStateType usageState = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public ResourceRefOrValue id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of an instance of the resource. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Identifier of an instance of the resource. Required to be unique within the resource type.  Used in URIs as the identifier for specific instances of a type.")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceRefOrValue href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The URI for the object itself.
   * @return href
  **/
  @ApiModelProperty(required = true, value = "The URI for the object itself.")
      @NotNull

    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceRefOrValue category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the concrete resource. e.g Gold, Silver for MSISDN concrete resource
   * @return category
  **/
  @ApiModelProperty(value = "Category of the concrete resource. e.g Gold, Silver for MSISDN concrete resource")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ResourceRefOrValue description(String description) {
    this.description = description;
    return this;
  }

  /**
   * free-text description of the resource
   * @return description
  **/
  @ApiModelProperty(value = "free-text description of the resource")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceRefOrValue endOperatingDate(OffsetDateTime endOperatingDate) {
    this.endOperatingDate = endOperatingDate;
    return this;
  }

  /**
   * A date time( DateTime). The date till the resource is operating
   * @return endOperatingDate
  **/
  @ApiModelProperty(value = "A date time( DateTime). The date till the resource is operating")
  
    @Valid
    public OffsetDateTime getEndOperatingDate() {
    return endOperatingDate;
  }

  public void setEndOperatingDate(OffsetDateTime endOperatingDate) {
    this.endOperatingDate = endOperatingDate;
  }

  public ResourceRefOrValue name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A string used to give a name to the resource
   * @return name
  **/
  @ApiModelProperty(value = "A string used to give a name to the resource")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceRefOrValue resourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
    return this;
  }

  /**
   * A field that identifies the specific version of an instance of a resource.
   * @return resourceVersion
  **/
  @ApiModelProperty(value = "A field that identifies the specific version of an instance of a resource.")
  
    public String getResourceVersion() {
    return resourceVersion;
  }

  public void setResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
  }

  public ResourceRefOrValue startOperatingDate(OffsetDateTime startOperatingDate) {
    this.startOperatingDate = startOperatingDate;
    return this;
  }

  /**
   * A date time( DateTime). The date from which the resource is operating
   * @return startOperatingDate
  **/
  @ApiModelProperty(value = "A date time( DateTime). The date from which the resource is operating")
  
    @Valid
    public OffsetDateTime getStartOperatingDate() {
    return startOperatingDate;
  }

  public void setStartOperatingDate(OffsetDateTime startOperatingDate) {
    this.startOperatingDate = startOperatingDate;
  }

  public ResourceRefOrValue activationFeature(List<Feature> activationFeature) {
    this.activationFeature = activationFeature;
    return this;
  }

  public ResourceRefOrValue addActivationFeatureItem(Feature activationFeatureItem) {
    if (this.activationFeature == null) {
      this.activationFeature = new ArrayList<>();
    }
    this.activationFeature.add(activationFeatureItem);
    return this;
  }

  /**
   * Configuration features
   * @return activationFeature
  **/
  @ApiModelProperty(value = "Configuration features")
      @Valid
    public List<Feature> getActivationFeature() {
    return activationFeature;
  }

  public void setActivationFeature(List<Feature> activationFeature) {
    this.activationFeature = activationFeature;
  }

  public ResourceRefOrValue administrativeState(ResourceAdministrativeStateType administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

  /**
   * Get administrativeState
   * @return administrativeState
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ResourceAdministrativeStateType getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(ResourceAdministrativeStateType administrativeState) {
    this.administrativeState = administrativeState;
  }

  public ResourceRefOrValue attachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ResourceRefOrValue addAttachmentItem(AttachmentRefOrValue attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AttachmentRefOrValue> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
  }

  public ResourceRefOrValue note(List<Note> note) {
    this.note = note;
    return this;
  }

  public ResourceRefOrValue addNoteItem(Note noteItem) {
    if (this.note == null) {
      this.note = new ArrayList<>();
    }
    this.note.add(noteItem);
    return this;
  }

  /**
   * Get note
   * @return note
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Note> getNote() {
    return note;
  }

  public void setNote(List<Note> note) {
    this.note = note;
  }

  public ResourceRefOrValue operationalState(ResourceOperationalStateType operationalState) {
    this.operationalState = operationalState;
    return this;
  }

  /**
   * Get operationalState
   * @return operationalState
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ResourceOperationalStateType getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(ResourceOperationalStateType operationalState) {
    this.operationalState = operationalState;
  }

  public ResourceRefOrValue place(RelatedPlaceRefOrValue place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public RelatedPlaceRefOrValue getPlace() {
    return place;
  }

  public void setPlace(RelatedPlaceRefOrValue place) {
    this.place = place;
  }

  public ResourceRefOrValue relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceRefOrValue addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
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

  public ResourceRefOrValue resourceCharacteristic(List<Characteristic> resourceCharacteristic) {
    this.resourceCharacteristic = resourceCharacteristic;
    return this;
  }

  public ResourceRefOrValue addResourceCharacteristicItem(Characteristic resourceCharacteristicItem) {
    if (this.resourceCharacteristic == null) {
      this.resourceCharacteristic = new ArrayList<>();
    }
    this.resourceCharacteristic.add(resourceCharacteristicItem);
    return this;
  }

  /**
   * Get resourceCharacteristic
   * @return resourceCharacteristic
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Characteristic> getResourceCharacteristic() {
    return resourceCharacteristic;
  }

  public void setResourceCharacteristic(List<Characteristic> resourceCharacteristic) {
    this.resourceCharacteristic = resourceCharacteristic;
  }

  public ResourceRefOrValue resourceRelationship(List<ResourceRelationship> resourceRelationship) {
    this.resourceRelationship = resourceRelationship;
    return this;
  }

  public ResourceRefOrValue addResourceRelationshipItem(ResourceRelationship resourceRelationshipItem) {
    if (this.resourceRelationship == null) {
      this.resourceRelationship = new ArrayList<>();
    }
    this.resourceRelationship.add(resourceRelationshipItem);
    return this;
  }

  /**
   * Get resourceRelationship
   * @return resourceRelationship
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<ResourceRelationship> getResourceRelationship() {
    return resourceRelationship;
  }

  public void setResourceRelationship(List<ResourceRelationship> resourceRelationship) {
    this.resourceRelationship = resourceRelationship;
  }

  public ResourceRefOrValue resourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  /**
   * Get resourceSpecification
   * @return resourceSpecification
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ResourceSpecificationRef getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ResourceRefOrValue resourceStatus(ResourceStatusType resourceStatus) {
    this.resourceStatus = resourceStatus;
    return this;
  }

  /**
   * Get resourceStatus
   * @return resourceStatus
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ResourceStatusType getResourceStatus() {
    return resourceStatus;
  }

  public void setResourceStatus(ResourceStatusType resourceStatus) {
    this.resourceStatus = resourceStatus;
  }

  public ResourceRefOrValue usageState(ResourceUsageStateType usageState) {
    this.usageState = usageState;
    return this;
  }

  /**
   * Get usageState
   * @return usageState
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ResourceUsageStateType getUsageState() {
    return usageState;
  }

  public void setUsageState(ResourceUsageStateType usageState) {
    this.usageState = usageState;
  }

  public ResourceRefOrValue _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public ResourceRefOrValue _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public ResourceRefOrValue _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }

  public ResourceRefOrValue _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceRefOrValue resourceRefOrValue = (ResourceRefOrValue) o;
    return Objects.equals(this.id, resourceRefOrValue.id) &&
        Objects.equals(this.href, resourceRefOrValue.href) &&
        Objects.equals(this.category, resourceRefOrValue.category) &&
        Objects.equals(this.description, resourceRefOrValue.description) &&
        Objects.equals(this.endOperatingDate, resourceRefOrValue.endOperatingDate) &&
        Objects.equals(this.name, resourceRefOrValue.name) &&
        Objects.equals(this.resourceVersion, resourceRefOrValue.resourceVersion) &&
        Objects.equals(this.startOperatingDate, resourceRefOrValue.startOperatingDate) &&
        Objects.equals(this.activationFeature, resourceRefOrValue.activationFeature) &&
        Objects.equals(this.administrativeState, resourceRefOrValue.administrativeState) &&
        Objects.equals(this.attachment, resourceRefOrValue.attachment) &&
        Objects.equals(this.note, resourceRefOrValue.note) &&
        Objects.equals(this.operationalState, resourceRefOrValue.operationalState) &&
        Objects.equals(this.place, resourceRefOrValue.place) &&
        Objects.equals(this.relatedParty, resourceRefOrValue.relatedParty) &&
        Objects.equals(this.resourceCharacteristic, resourceRefOrValue.resourceCharacteristic) &&
        Objects.equals(this.resourceRelationship, resourceRefOrValue.resourceRelationship) &&
        Objects.equals(this.resourceSpecification, resourceRefOrValue.resourceSpecification) &&
        Objects.equals(this.resourceStatus, resourceRefOrValue.resourceStatus) &&
        Objects.equals(this.usageState, resourceRefOrValue.usageState) &&
        Objects.equals(this._atBaseType, resourceRefOrValue._atBaseType) &&
        Objects.equals(this._atSchemaLocation, resourceRefOrValue._atSchemaLocation) &&
        Objects.equals(this._atType, resourceRefOrValue._atType) &&
        Objects.equals(this._atReferredType, resourceRefOrValue._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, category, description, endOperatingDate, name, resourceVersion, startOperatingDate, activationFeature, administrativeState, attachment, note, operationalState, place, relatedParty, resourceCharacteristic, resourceRelationship, resourceSpecification, resourceStatus, usageState, _atBaseType, _atSchemaLocation, _atType, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceRefOrValue {\n");
    
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
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
