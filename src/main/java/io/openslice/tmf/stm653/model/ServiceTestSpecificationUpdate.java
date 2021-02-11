package io.openslice.tmf.stm653.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The service test specification describes the service test in terms of
 * parameters to be configured and measures to be taken. Skipped properties:
 * id,href,validFor
 */
@ApiModel(description = "The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href,validFor")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestSpecificationUpdate {
	@JsonProperty("description")
	protected String description = null;

	@JsonProperty("isBundle")
	protected Boolean isBundle = null;

	protected OffsetDateTime lastUpdate = null;

	@JsonProperty("lifecycleStatus")
	protected String lifecycleStatus = null;

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("version")
	protected String version = null;

	@JsonProperty("attachment")
	@Valid
	protected List<AttachmentRefOrValue> attachment = null;

	@JsonProperty("constraint")
	@Valid
	protected List<ConstraintRef> constraint = null;

	@JsonProperty("entitySpecRelationship")
	@Valid
	protected List<EntitySpecificationRelationship> entitySpecRelationship = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("relatedServiceSpecification")
	@Valid
	protected List<ServiceSpecificationRef> relatedServiceSpecification = null;

	@JsonProperty("serviceTestSpecRelationship")
	@Valid
	protected List<ServiceTestSpecRelationship> serviceTestSpecRelationship = null;

	@JsonProperty("specCharacteristic")
	@Valid
	protected List<CharacteristicSpecification> specCharacteristic = null;

	@JsonProperty("targetEntitySchema")
	protected TargetEntitySchema targetEntitySchema = null;

	@JsonProperty("testMeasureDefinition")
	@Valid
	protected List<TestMeasureDefinition> testMeasureDefinition = null;

	@JsonProperty("@baseType")
	protected String _atBaseType = null;

	@JsonProperty("@schemaLocation")
	protected String _atSchemaLocation = null;

	@JsonProperty("@type")
	protected String _atType = null;

	public ServiceTestSpecificationUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of a service test specification.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Description of a service test specification.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceTestSpecificationUpdate isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * isBundle determines whether an EntitySpecification represents a single
	 * EntitySpecification (false), or a bundle of EntitySpecifications (true).
	 * 
	 * @return isBundle
	 **/
	@ApiModelProperty(value = "isBundle determines whether an EntitySpecification represents a single EntitySpecification (false), or a bundle of EntitySpecifications (true).")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	public ServiceTestSpecificationUpdate lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	/**
	 * Date and time of the last update of this REST resource
	 * 
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

	@JsonProperty("lastUpdate")
	public String getLastUpdateStr() {
		if (this.lastUpdate != null) {
			return this.lastUpdate.toString();
		} else {
			return null;
		}
	}

	public ServiceTestSpecificationUpdate lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status of this catalog item
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status of this catalog item")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public ServiceTestSpecificationUpdate name(String name) {
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

	public ServiceTestSpecificationUpdate version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Entity specification version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Entity specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServiceTestSpecificationUpdate attachment(List<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ServiceTestSpecificationUpdate addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new ArrayList<>();
		}
		this.attachment.add(attachmentItem);
		return this;
	}

	/**
	 * Attachments that may be of relevance to this specification, such as picture,
	 * document, media
	 * 
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

	public ServiceTestSpecificationUpdate constraint(List<ConstraintRef> constraint) {
		this.constraint = constraint;
		return this;
	}

	public ServiceTestSpecificationUpdate addConstraintItem(ConstraintRef constraintItem) {
		if (this.constraint == null) {
			this.constraint = new ArrayList<>();
		}
		this.constraint.add(constraintItem);
		return this;
	}

	/**
	 * This is a list of constraint references applied to this specification
	 * 
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

	public ServiceTestSpecificationUpdate entitySpecRelationship(
			List<EntitySpecificationRelationship> entitySpecRelationship) {
		this.entitySpecRelationship = entitySpecRelationship;
		return this;
	}

	public ServiceTestSpecificationUpdate addEntitySpecRelationshipItem(
			EntitySpecificationRelationship entitySpecRelationshipItem) {
		if (this.entitySpecRelationship == null) {
			this.entitySpecRelationship = new ArrayList<>();
		}
		this.entitySpecRelationship.add(entitySpecRelationshipItem);
		return this;
	}

	/**
	 * Relationship to another entity specification, might be dependency,
	 * substitution, etc.
	 * 
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

	public ServiceTestSpecificationUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceTestSpecificationUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Parties who manage or otherwise have an interest in this entity specification
	 * 
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

	public ServiceTestSpecificationUpdate relatedServiceSpecification(
			List<ServiceSpecificationRef> relatedServiceSpecification) {
		this.relatedServiceSpecification = relatedServiceSpecification;
		return this;
	}

	public ServiceTestSpecificationUpdate addRelatedServiceSpecificationItem(
			ServiceSpecificationRef relatedServiceSpecificationItem) {
		if (this.relatedServiceSpecification == null) {
			this.relatedServiceSpecification = new ArrayList<>();
		}
		this.relatedServiceSpecification.add(relatedServiceSpecificationItem);
		return this;
	}

	/**
	 * The related service specification may relate to more than one service
	 * specification.
	 * 
	 * @return relatedServiceSpecification
	 **/
	@ApiModelProperty(value = "The related service specification may relate to more than one service specification.")
	@Valid
	public List<ServiceSpecificationRef> getRelatedServiceSpecification() {
		return relatedServiceSpecification;
	}

	public void setRelatedServiceSpecification(List<ServiceSpecificationRef> relatedServiceSpecification) {
		this.relatedServiceSpecification = relatedServiceSpecification;
	}

	public ServiceTestSpecificationUpdate serviceTestSpecRelationship(
			List<ServiceTestSpecRelationship> serviceTestSpecRelationship) {
		this.serviceTestSpecRelationship = serviceTestSpecRelationship;
		return this;
	}

	public ServiceTestSpecificationUpdate addServiceTestSpecRelationshipItem(
			ServiceTestSpecRelationship serviceTestSpecRelationshipItem) {
		if (this.serviceTestSpecRelationship == null) {
			this.serviceTestSpecRelationship = new ArrayList<>();
		}
		this.serviceTestSpecRelationship.add(serviceTestSpecRelationshipItem);
		return this;
	}

	/**
	 * A list of service test specifications related to this specification e.g.
	 * dependency, substitution
	 * 
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

	public ServiceTestSpecificationUpdate specCharacteristic(List<CharacteristicSpecification> specCharacteristic) {
		this.specCharacteristic = specCharacteristic;
		return this;
	}

	public ServiceTestSpecificationUpdate addSpecCharacteristicItem(
			CharacteristicSpecification specCharacteristicItem) {
		if (this.specCharacteristic == null) {
			this.specCharacteristic = new ArrayList<>();
		}
		this.specCharacteristic.add(specCharacteristicItem);
		return this;
	}

	/**
	 * List of characteristics that the entity can take
	 * 
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

	public ServiceTestSpecificationUpdate targetEntitySchema(TargetEntitySchema targetEntitySchema) {
		this.targetEntitySchema = targetEntitySchema;
		return this;
	}

	/**
	 * Get targetEntitySchema
	 * 
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

	public ServiceTestSpecificationUpdate testMeasureDefinition(List<TestMeasureDefinition> testMeasureDefinition) {
		this.testMeasureDefinition = testMeasureDefinition;
		return this;
	}

	public ServiceTestSpecificationUpdate addTestMeasureDefinitionItem(
			TestMeasureDefinition testMeasureDefinitionItem) {
		if (this.testMeasureDefinition == null) {
			this.testMeasureDefinition = new ArrayList<>();
		}
		this.testMeasureDefinition.add(testMeasureDefinitionItem);
		return this;
	}

	/**
	 * A list of definitions for the measurements for the test defined by this
	 * specification
	 * 
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

	public ServiceTestSpecificationUpdate _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return _atBaseType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return _atBaseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
	}

	public ServiceTestSpecificationUpdate _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return _atSchemaLocation
	 **/
	@ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public ServiceTestSpecificationUpdate _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class Extensible name
	 * 
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
		ServiceTestSpecificationUpdate serviceTestSpecificationUpdate = (ServiceTestSpecificationUpdate) o;
		return Objects.equals(this.description, serviceTestSpecificationUpdate.description)
				&& Objects.equals(this.isBundle, serviceTestSpecificationUpdate.isBundle)
				&& Objects.equals(this.lastUpdate, serviceTestSpecificationUpdate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceTestSpecificationUpdate.lifecycleStatus)
				&& Objects.equals(this.name, serviceTestSpecificationUpdate.name)
				&& Objects.equals(this.version, serviceTestSpecificationUpdate.version)
				&& Objects.equals(this.attachment, serviceTestSpecificationUpdate.attachment)
				&& Objects.equals(this.constraint, serviceTestSpecificationUpdate.constraint)
				&& Objects.equals(this.entitySpecRelationship, serviceTestSpecificationUpdate.entitySpecRelationship)
				&& Objects.equals(this.relatedParty, serviceTestSpecificationUpdate.relatedParty)
				&& Objects.equals(this.relatedServiceSpecification,
						serviceTestSpecificationUpdate.relatedServiceSpecification)
				&& Objects.equals(this.serviceTestSpecRelationship,
						serviceTestSpecificationUpdate.serviceTestSpecRelationship)
				&& Objects.equals(this.specCharacteristic, serviceTestSpecificationUpdate.specCharacteristic)
				&& Objects.equals(this.targetEntitySchema, serviceTestSpecificationUpdate.targetEntitySchema)
				&& Objects.equals(this.testMeasureDefinition, serviceTestSpecificationUpdate.testMeasureDefinition)
				&& Objects.equals(this._atBaseType, serviceTestSpecificationUpdate._atBaseType)
				&& Objects.equals(this._atSchemaLocation, serviceTestSpecificationUpdate._atSchemaLocation)
				&& Objects.equals(this._atType, serviceTestSpecificationUpdate._atType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint,
				entitySpecRelationship, relatedParty, relatedServiceSpecification, serviceTestSpecRelationship,
				specCharacteristic, targetEntitySchema, testMeasureDefinition, _atBaseType, _atSchemaLocation, _atType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceTestSpecificationUpdate {\n");

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
		sb.append("    relatedServiceSpecification: ").append(toIndentedString(relatedServiceSpecification))
				.append("\n");
		sb.append("    serviceTestSpecRelationship: ").append(toIndentedString(serviceTestSpecRelationship))
				.append("\n");
		sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
		sb.append("    targetEntitySchema: ").append(toIndentedString(targetEntitySchema)).append("\n");
		sb.append("    testMeasureDefinition: ").append(toIndentedString(testMeasureDefinition)).append("\n");
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