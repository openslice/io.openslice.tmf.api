package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.AttachmentRefOrValue;
import io.openslice.tmf.stm653.model.CharacteristicSpecification;
import io.openslice.tmf.stm653.model.ConstraintRef;
import io.openslice.tmf.stm653.model.EntitySpecificationRelationship;
import io.openslice.tmf.stm653.model.RelatedParty;
import io.openslice.tmf.stm653.model.TargetEntitySchema;
import io.openslice.tmf.stm653.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EntitySpecification is a class that offers characteristics to describe a type of entity. Entities are generic constructs that may be used to describe bespoke business entities that are not effectively covered by the existing SID model. Functionally, the entity specification acts as a template by which entities may be instantiated and described. By sharing the same specification, these entities would therefore share the same set of characteristics. Note: The ‘configurable’ attribute on the specCharacteristics determines if an entity instantiated from the entity specification can override the value of the attribute. When set to false, the entity instance may not define a value that differs from the value in the specification.
 */
@ApiModel(description = "EntitySpecification is a class that offers characteristics to describe a type of entity. Entities are generic constructs that may be used to describe bespoke business entities that are not effectively covered by the existing SID model. Functionally, the entity specification acts as a template by which entities may be instantiated and described. By sharing the same specification, these entities would therefore share the same set of characteristics. Note: The ‘configurable’ attribute on the specCharacteristics determines if an entity instantiated from the entity specification can override the value of the attribute. When set to false, the entity instance may not define a value that differs from the value in the specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class EntitySpecification   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  private String lifecycleStatus = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("attachment")
  @Valid
  private List<AttachmentRefOrValue> attachment = null;

  @JsonProperty("constraint")
  @Valid
  private List<ConstraintRef> constraint = null;

  @JsonProperty("entitySpecRelationship")
  @Valid
  private List<EntitySpecificationRelationship> entitySpecRelationship = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("specCharacteristic")
  @Valid
  private List<CharacteristicSpecification> specCharacteristic = null;

  @JsonProperty("targetEntitySchema")
  private TargetEntitySchema targetEntitySchema = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public EntitySpecification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * unique identifier
   * @return id
  **/
  @ApiModelProperty(value = "unique identifier")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EntitySpecification href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public EntitySpecification description(String description) {
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

  public EntitySpecification isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * isBundle determines whether an EntitySpecification represents a single EntitySpecification (false), or a bundle of EntitySpecifications (true).
   * @return isBundle
  **/
  @ApiModelProperty(value = "isBundle determines whether an EntitySpecification represents a single EntitySpecification (false), or a bundle of EntitySpecifications (true).")
  
    public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public EntitySpecification lastUpdate(OffsetDateTime lastUpdate) {
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

  public EntitySpecification lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of this catalog item
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status of this catalog item")
  
    public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public EntitySpecification name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name given to this REST resource
   * @return name
  **/
  @ApiModelProperty(value = "Name given to this REST resource")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EntitySpecification version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Entity specification version
   * @return version
  **/
  @ApiModelProperty(value = "Entity specification version")
  
    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public EntitySpecification attachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
    return this;
  }

  public EntitySpecification addAttachmentItem(AttachmentRefOrValue attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Attachments that may be of relevance to this specification, such as picture, document, media
   * @return attachment
  **/
  @ApiModelProperty(value = "Attachments that may be of relevance to this specification, such as picture, document, media")
      @Valid
    public List<AttachmentRefOrValue> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
  }

  public EntitySpecification constraint(List<ConstraintRef> constraint) {
    this.constraint = constraint;
    return this;
  }

  public EntitySpecification addConstraintItem(ConstraintRef constraintItem) {
    if (this.constraint == null) {
      this.constraint = new ArrayList<>();
    }
    this.constraint.add(constraintItem);
    return this;
  }

  /**
   * This is a list of constraint references applied to this specification
   * @return constraint
  **/
  @ApiModelProperty(value = "This is a list of constraint references applied to this specification")
      @Valid
    public List<ConstraintRef> getConstraint() {
    return constraint;
  }

  public void setConstraint(List<ConstraintRef> constraint) {
    this.constraint = constraint;
  }

  public EntitySpecification entitySpecRelationship(List<EntitySpecificationRelationship> entitySpecRelationship) {
    this.entitySpecRelationship = entitySpecRelationship;
    return this;
  }

  public EntitySpecification addEntitySpecRelationshipItem(EntitySpecificationRelationship entitySpecRelationshipItem) {
    if (this.entitySpecRelationship == null) {
      this.entitySpecRelationship = new ArrayList<>();
    }
    this.entitySpecRelationship.add(entitySpecRelationshipItem);
    return this;
  }

  /**
   * Relationship to another entity specification, might be dependency, substitution, etc.
   * @return entitySpecRelationship
  **/
  @ApiModelProperty(value = "Relationship to another entity specification, might be dependency, substitution, etc.")
      @Valid
    public List<EntitySpecificationRelationship> getEntitySpecRelationship() {
    return entitySpecRelationship;
  }

  public void setEntitySpecRelationship(List<EntitySpecificationRelationship> entitySpecRelationship) {
    this.entitySpecRelationship = entitySpecRelationship;
  }

  public EntitySpecification relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public EntitySpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Parties who manage or otherwise have an interest in this entity specification
   * @return relatedParty
  **/
  @ApiModelProperty(value = "Parties who manage or otherwise have an interest in this entity specification")
      @Valid
    public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public EntitySpecification specCharacteristic(List<CharacteristicSpecification> specCharacteristic) {
    this.specCharacteristic = specCharacteristic;
    return this;
  }

  public EntitySpecification addSpecCharacteristicItem(CharacteristicSpecification specCharacteristicItem) {
    if (this.specCharacteristic == null) {
      this.specCharacteristic = new ArrayList<>();
    }
    this.specCharacteristic.add(specCharacteristicItem);
    return this;
  }

  /**
   * List of characteristics that the entity can take
   * @return specCharacteristic
  **/
  @ApiModelProperty(value = "List of characteristics that the entity can take")
      @Valid
    public List<CharacteristicSpecification> getSpecCharacteristic() {
    return specCharacteristic;
  }

  public void setSpecCharacteristic(List<CharacteristicSpecification> specCharacteristic) {
    this.specCharacteristic = specCharacteristic;
  }

  public EntitySpecification targetEntitySchema(TargetEntitySchema targetEntitySchema) {
    this.targetEntitySchema = targetEntitySchema;
    return this;
  }

  /**
   * Get targetEntitySchema
   * @return targetEntitySchema
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TargetEntitySchema getTargetEntitySchema() {
    return targetEntitySchema;
  }

  public void setTargetEntitySchema(TargetEntitySchema targetEntitySchema) {
    this.targetEntitySchema = targetEntitySchema;
  }

  public EntitySpecification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public EntitySpecification _atBaseType(String _atBaseType) {
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

  public EntitySpecification _atSchemaLocation(String _atSchemaLocation) {
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

  public EntitySpecification _atType(String _atType) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntitySpecification entitySpecification = (EntitySpecification) o;
    return Objects.equals(this.id, entitySpecification.id) &&
        Objects.equals(this.href, entitySpecification.href) &&
        Objects.equals(this.description, entitySpecification.description) &&
        Objects.equals(this.isBundle, entitySpecification.isBundle) &&
        Objects.equals(this.lastUpdate, entitySpecification.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, entitySpecification.lifecycleStatus) &&
        Objects.equals(this.name, entitySpecification.name) &&
        Objects.equals(this.version, entitySpecification.version) &&
        Objects.equals(this.attachment, entitySpecification.attachment) &&
        Objects.equals(this.constraint, entitySpecification.constraint) &&
        Objects.equals(this.entitySpecRelationship, entitySpecification.entitySpecRelationship) &&
        Objects.equals(this.relatedParty, entitySpecification.relatedParty) &&
        Objects.equals(this.specCharacteristic, entitySpecification.specCharacteristic) &&
        Objects.equals(this.targetEntitySchema, entitySpecification.targetEntitySchema) &&
        Objects.equals(this.validFor, entitySpecification.validFor) &&
        Objects.equals(this._atBaseType, entitySpecification._atBaseType) &&
        Objects.equals(this._atSchemaLocation, entitySpecification._atSchemaLocation) &&
        Objects.equals(this._atType, entitySpecification._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint, entitySpecRelationship, relatedParty, specCharacteristic, targetEntitySchema, validFor, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntitySpecification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
    sb.append("    entitySpecRelationship: ").append(toIndentedString(entitySpecRelationship)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
    sb.append("    targetEntitySchema: ").append(toIndentedString(targetEntitySchema)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
