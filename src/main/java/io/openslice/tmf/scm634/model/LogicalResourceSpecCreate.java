package io.openslice.tmf.scm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.scm634.model.Attachment;
import io.openslice.tmf.scm634.model.Feature;
import io.openslice.tmf.scm634.model.RelatedPartyRef;
import io.openslice.tmf.scm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.scm634.model.ResourceSpecRelationship;
import io.openslice.tmf.scm634.model.TargetResourceSchemaRef;
import io.openslice.tmf.scm634.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is a base class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a LogicalResource. Skipped properties: id,href
 */
@ApiModel(description = "This is a base class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a LogicalResource. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class LogicalResourceSpecCreate   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  private String lifecycleStatus = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("targetResourceSchema")
  private TargetResourceSchemaRef targetResourceSchema = null;

  @JsonProperty("feature")
  @Valid
  private List<Feature> feature = null;

  @JsonProperty("attachment")
  @Valid
  private List<Attachment> attachment = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedPartyRef> relatedParty = null;

  @JsonProperty("resourceSpecCharacteristic")
  @Valid
  private List<ResourceSpecCharacteristic> resourceSpecCharacteristic = null;

  @JsonProperty("resourceSpecRelationship")
  @Valid
  private List<ResourceSpecRelationship> resourceSpecRelationship = null;

  public LogicalResourceSpecCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name given to this REST resource
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name given to this REST resource")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LogicalResourceSpecCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this REST resource
   * @return description
  **/
  @ApiModelProperty(value = "Description of this REST resource")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LogicalResourceSpecCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Class type of this REST resource
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

  public LogicalResourceSpecCreate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing this REST resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing this REST resource")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public LogicalResourceSpecCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The (immediate) base class type of this REST resource
   * @return baseType
  **/
  @ApiModelProperty(value = "The (immediate) base class type of this REST resource")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public LogicalResourceSpecCreate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Resource Specification version
   * @return version
  **/
  @ApiModelProperty(value = "Resource Specification version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public LogicalResourceSpecCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which this REST resource is valid
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

  public LogicalResourceSpecCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update of this REST resource
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

  public LogicalResourceSpecCreate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the resource specification
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status of the resource specification")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public LogicalResourceSpecCreate isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * A flag indicates that if this resource specification is a bundled specification (true) or single (false).
   * @return isBundle
  **/
  @ApiModelProperty(value = "A flag indicates that if this resource specification is a bundled specification (true) or single (false).")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public LogicalResourceSpecCreate category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.
   * @return category
  **/
  @ApiModelProperty(value = "Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public LogicalResourceSpecCreate targetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
    this.targetResourceSchema = targetResourceSchema;
    return this;
  }

  /**
   * Get targetResourceSchema
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

  public LogicalResourceSpecCreate feature(List<Feature> feature) {
    this.feature = feature;
    return this;
  }

  public LogicalResourceSpecCreate addFeatureItem(Feature featureItem) {
    if (this.feature == null) {
      this.feature = new ArrayList<>();
    }
    this.feature.add(featureItem);
    return this;
  }

  /**
   * Get feature
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

  public LogicalResourceSpecCreate attachment(List<Attachment> attachment) {
    this.attachment = attachment;
    return this;
  }

  public LogicalResourceSpecCreate addAttachmentItem(Attachment attachmentItem) {
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

  public List<Attachment> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<Attachment> attachment) {
    this.attachment = attachment;
  }

  public LogicalResourceSpecCreate relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public LogicalResourceSpecCreate addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
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

  public List<RelatedPartyRef> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public LogicalResourceSpecCreate resourceSpecCharacteristic(List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
    this.resourceSpecCharacteristic = resourceSpecCharacteristic;
    return this;
  }

  public LogicalResourceSpecCreate addResourceSpecCharacteristicItem(ResourceSpecCharacteristic resourceSpecCharacteristicItem) {
    if (this.resourceSpecCharacteristic == null) {
      this.resourceSpecCharacteristic = new ArrayList<>();
    }
    this.resourceSpecCharacteristic.add(resourceSpecCharacteristicItem);
    return this;
  }

  /**
   * Get resourceSpecCharacteristic
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

  public LogicalResourceSpecCreate resourceSpecRelationship(List<ResourceSpecRelationship> resourceSpecRelationship) {
    this.resourceSpecRelationship = resourceSpecRelationship;
    return this;
  }

  public LogicalResourceSpecCreate addResourceSpecRelationshipItem(ResourceSpecRelationship resourceSpecRelationshipItem) {
    if (this.resourceSpecRelationship == null) {
      this.resourceSpecRelationship = new ArrayList<>();
    }
    this.resourceSpecRelationship.add(resourceSpecRelationshipItem);
    return this;
  }

  /**
   * Get resourceSpecRelationship
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
    LogicalResourceSpecCreate logicalResourceSpecCreate = (LogicalResourceSpecCreate) o;
    return Objects.equals(this.name, logicalResourceSpecCreate.name) &&
        Objects.equals(this.description, logicalResourceSpecCreate.description) &&
        Objects.equals(this.type, logicalResourceSpecCreate.type) &&
        Objects.equals(this.schemaLocation, logicalResourceSpecCreate.schemaLocation) &&
        Objects.equals(this.baseType, logicalResourceSpecCreate.baseType) &&
        Objects.equals(this.version, logicalResourceSpecCreate.version) &&
        Objects.equals(this.validFor, logicalResourceSpecCreate.validFor) &&
        Objects.equals(this.lastUpdate, logicalResourceSpecCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, logicalResourceSpecCreate.lifecycleStatus) &&
        Objects.equals(this.isBundle, logicalResourceSpecCreate.isBundle) &&
        Objects.equals(this.category, logicalResourceSpecCreate.category) &&
        Objects.equals(this.targetResourceSchema, logicalResourceSpecCreate.targetResourceSchema) &&
        Objects.equals(this.feature, logicalResourceSpecCreate.feature) &&
        Objects.equals(this.attachment, logicalResourceSpecCreate.attachment) &&
        Objects.equals(this.relatedParty, logicalResourceSpecCreate.relatedParty) &&
        Objects.equals(this.resourceSpecCharacteristic, logicalResourceSpecCreate.resourceSpecCharacteristic) &&
        Objects.equals(this.resourceSpecRelationship, logicalResourceSpecCreate.resourceSpecRelationship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate, lifecycleStatus, isBundle, category, targetResourceSchema, feature, attachment, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogicalResourceSpecCreate {\n");
    
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

