package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.AttachmentRefOrValue;
import io.openslice.tmf.stm653.model.CharacteristicSpecification;
import io.openslice.tmf.stm653.model.ConstraintRef;
import io.openslice.tmf.stm653.model.EntitySpecificationRelationship;
import io.openslice.tmf.stm653.model.RelatedParty;
import io.openslice.tmf.stm653.model.ServiceSpecificationRef;
import io.openslice.tmf.stm653.model.ServiceTestSpecRelationship;
import io.openslice.tmf.stm653.model.TargetEntitySchema;
import io.openslice.tmf.stm653.model.TestMeasureDefinition;
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
 * The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href
 */
@ApiModel(description = "The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestSpecificationCreate   {
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

  @JsonProperty("relatedServiceSpecification")
  @Valid
  private List<ServiceSpecificationRef> relatedServiceSpecification = new ArrayList<>();

  @JsonProperty("serviceTestSpecRelationship")
  @Valid
  private List<ServiceTestSpecRelationship> serviceTestSpecRelationship = null;

  @JsonProperty("specCharacteristic")
  @Valid
  private List<CharacteristicSpecification> specCharacteristic = null;

  @JsonProperty("targetEntitySchema")
  private TargetEntitySchema targetEntitySchema = null;

  @JsonProperty("testMeasureDefinition")
  @Valid
  private List<TestMeasureDefinition> testMeasureDefinition = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public ServiceTestSpecificationCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of a service test specification.
   * @return description
  **/
  @ApiModelProperty(value = "Description of a service test specification.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceTestSpecificationCreate isBundle(Boolean isBundle) {
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

  public ServiceTestSpecificationCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public ServiceTestSpecificationCreate lifecycleStatus(String lifecycleStatus) {
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

  public ServiceTestSpecificationCreate name(String name) {
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

  public ServiceTestSpecificationCreate version(String version) {
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

  public ServiceTestSpecificationCreate attachment(List<AttachmentRefOrValue> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ServiceTestSpecificationCreate addAttachmentItem(AttachmentRefOrValue attachmentItem) {
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

  public ServiceTestSpecificationCreate constraint(List<ConstraintRef> constraint) {
    this.constraint = constraint;
    return this;
  }

  public ServiceTestSpecificationCreate addConstraintItem(ConstraintRef constraintItem) {
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

  public ServiceTestSpecificationCreate entitySpecRelationship(List<EntitySpecificationRelationship> entitySpecRelationship) {
    this.entitySpecRelationship = entitySpecRelationship;
    return this;
  }

  public ServiceTestSpecificationCreate addEntitySpecRelationshipItem(EntitySpecificationRelationship entitySpecRelationshipItem) {
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

  public ServiceTestSpecificationCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ServiceTestSpecificationCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public ServiceTestSpecificationCreate relatedServiceSpecification(List<ServiceSpecificationRef> relatedServiceSpecification) {
    this.relatedServiceSpecification = relatedServiceSpecification;
    return this;
  }

  public ServiceTestSpecificationCreate addRelatedServiceSpecificationItem(ServiceSpecificationRef relatedServiceSpecificationItem) {
    this.relatedServiceSpecification.add(relatedServiceSpecificationItem);
    return this;
  }

  /**
   * The related service specification may relate to more than one service specification.
   * @return relatedServiceSpecification
  **/
  @ApiModelProperty(required = true, value = "The related service specification may relate to more than one service specification.")
      @NotNull
    @Valid
  @Size(min=1)   public List<ServiceSpecificationRef> getRelatedServiceSpecification() {
    return relatedServiceSpecification;
  }

  public void setRelatedServiceSpecification(List<ServiceSpecificationRef> relatedServiceSpecification) {
    this.relatedServiceSpecification = relatedServiceSpecification;
  }

  public ServiceTestSpecificationCreate serviceTestSpecRelationship(List<ServiceTestSpecRelationship> serviceTestSpecRelationship) {
    this.serviceTestSpecRelationship = serviceTestSpecRelationship;
    return this;
  }

  public ServiceTestSpecificationCreate addServiceTestSpecRelationshipItem(ServiceTestSpecRelationship serviceTestSpecRelationshipItem) {
    if (this.serviceTestSpecRelationship == null) {
      this.serviceTestSpecRelationship = new ArrayList<>();
    }
    this.serviceTestSpecRelationship.add(serviceTestSpecRelationshipItem);
    return this;
  }

  /**
   * A list of service test specifications related to this specification e.g. dependency, substitution
   * @return serviceTestSpecRelationship
  **/
  @ApiModelProperty(value = "A list of service test specifications related to this specification e.g. dependency, substitution")
      @Valid
    public List<ServiceTestSpecRelationship> getServiceTestSpecRelationship() {
    return serviceTestSpecRelationship;
  }

  public void setServiceTestSpecRelationship(List<ServiceTestSpecRelationship> serviceTestSpecRelationship) {
    this.serviceTestSpecRelationship = serviceTestSpecRelationship;
  }

  public ServiceTestSpecificationCreate specCharacteristic(List<CharacteristicSpecification> specCharacteristic) {
    this.specCharacteristic = specCharacteristic;
    return this;
  }

  public ServiceTestSpecificationCreate addSpecCharacteristicItem(CharacteristicSpecification specCharacteristicItem) {
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

  public ServiceTestSpecificationCreate targetEntitySchema(TargetEntitySchema targetEntitySchema) {
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

  public ServiceTestSpecificationCreate testMeasureDefinition(List<TestMeasureDefinition> testMeasureDefinition) {
    this.testMeasureDefinition = testMeasureDefinition;
    return this;
  }

  public ServiceTestSpecificationCreate addTestMeasureDefinitionItem(TestMeasureDefinition testMeasureDefinitionItem) {
    if (this.testMeasureDefinition == null) {
      this.testMeasureDefinition = new ArrayList<>();
    }
    this.testMeasureDefinition.add(testMeasureDefinitionItem);
    return this;
  }

  /**
   * A list of definitions for the measurements for the test defined by this specification
   * @return testMeasureDefinition
  **/
  @ApiModelProperty(value = "A list of definitions for the measurements for the test defined by this specification")
      @Valid
    public List<TestMeasureDefinition> getTestMeasureDefinition() {
    return testMeasureDefinition;
  }

  public void setTestMeasureDefinition(List<TestMeasureDefinition> testMeasureDefinition) {
    this.testMeasureDefinition = testMeasureDefinition;
  }

  public ServiceTestSpecificationCreate validFor(TimePeriod validFor) {
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

  public ServiceTestSpecificationCreate _atBaseType(String _atBaseType) {
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

  public ServiceTestSpecificationCreate _atSchemaLocation(String _atSchemaLocation) {
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

  public ServiceTestSpecificationCreate _atType(String _atType) {
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
    ServiceTestSpecificationCreate serviceTestSpecificationCreate = (ServiceTestSpecificationCreate) o;
    return Objects.equals(this.description, serviceTestSpecificationCreate.description) &&
        Objects.equals(this.isBundle, serviceTestSpecificationCreate.isBundle) &&
        Objects.equals(this.lastUpdate, serviceTestSpecificationCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceTestSpecificationCreate.lifecycleStatus) &&
        Objects.equals(this.name, serviceTestSpecificationCreate.name) &&
        Objects.equals(this.version, serviceTestSpecificationCreate.version) &&
        Objects.equals(this.attachment, serviceTestSpecificationCreate.attachment) &&
        Objects.equals(this.constraint, serviceTestSpecificationCreate.constraint) &&
        Objects.equals(this.entitySpecRelationship, serviceTestSpecificationCreate.entitySpecRelationship) &&
        Objects.equals(this.relatedParty, serviceTestSpecificationCreate.relatedParty) &&
        Objects.equals(this.relatedServiceSpecification, serviceTestSpecificationCreate.relatedServiceSpecification) &&
        Objects.equals(this.serviceTestSpecRelationship, serviceTestSpecificationCreate.serviceTestSpecRelationship) &&
        Objects.equals(this.specCharacteristic, serviceTestSpecificationCreate.specCharacteristic) &&
        Objects.equals(this.targetEntitySchema, serviceTestSpecificationCreate.targetEntitySchema) &&
        Objects.equals(this.testMeasureDefinition, serviceTestSpecificationCreate.testMeasureDefinition) &&
        Objects.equals(this.validFor, serviceTestSpecificationCreate.validFor) &&
        Objects.equals(this._atBaseType, serviceTestSpecificationCreate._atBaseType) &&
        Objects.equals(this._atSchemaLocation, serviceTestSpecificationCreate._atSchemaLocation) &&
        Objects.equals(this._atType, serviceTestSpecificationCreate._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint, entitySpecRelationship, relatedParty, relatedServiceSpecification, serviceTestSpecRelationship, specCharacteristic, targetEntitySchema, testMeasureDefinition, validFor, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecificationCreate {\n");
    
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
    sb.append("    relatedServiceSpecification: ").append(toIndentedString(relatedServiceSpecification)).append("\n");
    sb.append("    serviceTestSpecRelationship: ").append(toIndentedString(serviceTestSpecRelationship)).append("\n");
    sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
    sb.append("    targetEntitySchema: ").append(toIndentedString(targetEntitySchema)).append("\n");
    sb.append("    testMeasureDefinition: ").append(toIndentedString(testMeasureDefinition)).append("\n");
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
