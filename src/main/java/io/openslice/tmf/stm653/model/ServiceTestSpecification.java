package io.openslice.tmf.stm653.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The service test specification describes the service test in terms of
 * parameters to be configured and measures to be taken.
 */
@ApiModel(description = "The service test specification describes the service test in terms of parameters to be configured and  measures to be taken.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMServiceTestSpec")
@Table(name = "STMServiceTestSpec")
public class ServiceTestSpecification extends BaseEntity {

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;


	@JsonProperty("version")
	private String version = null;

	@JsonProperty("attachment")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AttachmentRefOrValue> attachment = new HashSet<>();

	@JsonProperty("constraint")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ConstraintRef> constraint = new HashSet<>();

	@JsonProperty("entitySpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<EntitySpecificationRelationship> entitySpecRelationship = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("relatedServiceSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceSpecificationRef> relatedServiceSpecification = new HashSet<>();

	@JsonProperty("serviceTestSpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceTestSpecRelationship> serviceTestSpecRelationship = new HashSet<>();

	@JsonProperty("specCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CharacteristicSpecification> specCharacteristic = new HashSet<>();

	@JsonProperty("targetEntitySchema")
	private TargetEntitySchema targetEntitySchema = null;

	@JsonProperty("testMeasureDefinition")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<TestMeasureDefinition> testMeasureDefinition = new HashSet<>();

	
	/**
	 * @return the id
	 */
	public String getId() {
		if ( uuid != null ) {
			id = uuid;			
		} 
		return id;
	}

	

	public ServiceTestSpecification version(String version) {
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

	public ServiceTestSpecification attachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public ServiceTestSpecification addAttachmentItem(AttachmentRefOrValue attachmentItem) {
		if (this.attachment == null) {
			this.attachment = new HashSet<>();
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
	public Set<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public ServiceTestSpecification constraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
		return this;
	}

	public ServiceTestSpecification addConstraintItem(ConstraintRef constraintItem) {
		if (this.constraint == null) {
			this.constraint = new HashSet<>();
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
	public Set<ConstraintRef> getConstraint() {
		return constraint;
	}

	public void setConstraint( Set<ConstraintRef> constraint) {
		this.constraint = constraint;
	}

	public ServiceTestSpecification entitySpecRelationship(
			Set<EntitySpecificationRelationship> entitySpecRelationship) {
		this.entitySpecRelationship = entitySpecRelationship;
		return this;
	}

	public ServiceTestSpecification addEntitySpecRelationshipItem(
			EntitySpecificationRelationship entitySpecRelationshipItem) {
		if (this.entitySpecRelationship == null) {
			this.entitySpecRelationship = new HashSet<>();
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
	public Set<EntitySpecificationRelationship> getEntitySpecRelationship() {
		return entitySpecRelationship;
	}

	public void setEntitySpecRelationship( Set<EntitySpecificationRelationship> entitySpecRelationship) {
		this.entitySpecRelationship = entitySpecRelationship;
	}

	public ServiceTestSpecification relatedParty( Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceTestSpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
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
	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty( Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}
	
	
	public ServiceTestSpecification isBundle(Boolean isBundle) {
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

	public ServiceTestSpecification relatedServiceSpecification(
			Set<ServiceSpecificationRef> relatedServiceSpecification) {
		this.relatedServiceSpecification = relatedServiceSpecification;
		return this;
	}

	public ServiceTestSpecification addRelatedServiceSpecificationItem(
			ServiceSpecificationRef relatedServiceSpecificationItem) {
		if (this.relatedServiceSpecification == null) {
			this.relatedServiceSpecification = new HashSet<>();
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
	public Set<ServiceSpecificationRef> getRelatedServiceSpecification() {
		return relatedServiceSpecification;
	}

	public void setRelatedServiceSpecification( Set<ServiceSpecificationRef> relatedServiceSpecification) {
		this.relatedServiceSpecification = relatedServiceSpecification;
	}

	public ServiceTestSpecification serviceTestSpecRelationship(
			Set<ServiceTestSpecRelationship> serviceTestSpecRelationship) {
		this.serviceTestSpecRelationship = serviceTestSpecRelationship;
		return this;
	}

	public ServiceTestSpecification addServiceTestSpecRelationshipItem(
			ServiceTestSpecRelationship serviceTestSpecRelationshipItem) {
		if (this.serviceTestSpecRelationship == null) {
			this.serviceTestSpecRelationship = new HashSet<>();
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
	public Set<ServiceTestSpecRelationship> getServiceTestSpecRelationship() {
		return serviceTestSpecRelationship;
	}

	public void setServiceTestSpecRelationship( Set<ServiceTestSpecRelationship> serviceTestSpecRelationship) {
		this.serviceTestSpecRelationship = serviceTestSpecRelationship;
	}

	public ServiceTestSpecification specCharacteristic(Set<CharacteristicSpecification> specCharacteristic) {
		this.specCharacteristic = specCharacteristic;
		return this;
	}

	public ServiceTestSpecification addSpecCharacteristicItem(CharacteristicSpecification specCharacteristicItem) {
		if (this.specCharacteristic == null) {
			this.specCharacteristic = new HashSet<>();
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
	public Set<CharacteristicSpecification> getSpecCharacteristic() {
		return specCharacteristic;
	}

	public void setSpecCharacteristic(Set<CharacteristicSpecification> specCharacteristic) {
		this.specCharacteristic = specCharacteristic;
	}

	public ServiceTestSpecification targetEntitySchema(TargetEntitySchema targetEntitySchema) {
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

	public ServiceTestSpecification testMeasureDefinition(Set<TestMeasureDefinition> testMeasureDefinition) {
		this.testMeasureDefinition = testMeasureDefinition;
		return this;
	}

	public ServiceTestSpecification addTestMeasureDefinitionItem(TestMeasureDefinition testMeasureDefinitionItem) {
		if (this.testMeasureDefinition == null) {
			this.testMeasureDefinition = new HashSet<>();
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
	public Set<TestMeasureDefinition> getTestMeasureDefinition() {
		return testMeasureDefinition;
	}

	public void setTestMeasureDefinition( Set<TestMeasureDefinition> testMeasureDefinition) {
		this.testMeasureDefinition = testMeasureDefinition;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceTestSpecification serviceTestSpecification = (ServiceTestSpecification) o;
		return Objects.equals(this.id, serviceTestSpecification.id)
				&& Objects.equals(this.href, serviceTestSpecification.href)
				&& Objects.equals(this.description, serviceTestSpecification.description)
				&& Objects.equals(this.isBundle, serviceTestSpecification.isBundle)
				&& Objects.equals(this.lastUpdate, serviceTestSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceTestSpecification.lifecycleStatus)
				&& Objects.equals(this.name, serviceTestSpecification.name)
				&& Objects.equals(this.version, serviceTestSpecification.version)
				&& Objects.equals(this.attachment, serviceTestSpecification.attachment)
				&& Objects.equals(this.constraint, serviceTestSpecification.constraint)
				&& Objects.equals(this.entitySpecRelationship, serviceTestSpecification.entitySpecRelationship)
				&& Objects.equals(this.relatedParty, serviceTestSpecification.relatedParty)
				&& Objects.equals(this.relatedServiceSpecification,
						serviceTestSpecification.relatedServiceSpecification)
				&& Objects.equals(this.serviceTestSpecRelationship,
						serviceTestSpecification.serviceTestSpecRelationship)
				&& Objects.equals(this.specCharacteristic, serviceTestSpecification.specCharacteristic)
				&& Objects.equals(this.targetEntitySchema, serviceTestSpecification.targetEntitySchema)
				&& Objects.equals(this.testMeasureDefinition, serviceTestSpecification.testMeasureDefinition)
				&& Objects.equals(this.validFor, serviceTestSpecification.validFor)
				&& Objects.equals(this.baseType, serviceTestSpecification.baseType)
				&& Objects.equals(this.schemaLocation, serviceTestSpecification.schemaLocation)
				&& Objects.equals(this.type, serviceTestSpecification.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint, entitySpecRelationship, relatedParty, relatedServiceSpecification, serviceTestSpecRelationship, specCharacteristic, targetEntitySchema, testMeasureDefinition, validFor, _atBaseType, _atSchemaLocation, _atType);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceTestSpecification {\n");

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
		sb.append("    relatedServiceSpecification: ").append(toIndentedString(relatedServiceSpecification))
				.append("\n");
		sb.append("    serviceTestSpecRelationship: ").append(toIndentedString(serviceTestSpecRelationship))
				.append("\n");
		sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
		sb.append("    targetEntitySchema: ").append(toIndentedString(targetEntitySchema)).append("\n");
		sb.append("    testMeasureDefinition: ").append(toIndentedString(testMeasureDefinition)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
}
