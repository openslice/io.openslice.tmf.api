/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.stm653.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * EntitySpecification is a class that offers characteristics to describe a type
 * of entity. Entities are generic constructs that may be used to describe
 * bespoke business entities that are not effectively covered by the existing
 * SID model. Functionally, the entity specification acts as a template by which
 * entities may be instantiated and described. By sharing the same
 * specification, these entities would therefore share the same set of
 * characteristics. Note: The ‘configurable’ attribute on the
 * specCharacteristics determines if an entity instantiated from the entity
 * specification can override the value of the attribute. When set to false, the
 * entity instance may not define a value that differs from the value in the
 * specification.
 */
@Schema(description = "EntitySpecification is a class that offers characteristics to describe a type of entity. Entities are generic constructs that may be used to describe bespoke business entities that are not effectively covered by the existing SID model. Functionally, the entity specification acts as a template by which entities may be instantiated and described. By sharing the same specification, these entities would therefore share the same set of characteristics. Note: The ‘configurable’ attribute on the specCharacteristics determines if an entity instantiated from the entity specification can override the value of the attribute. When set to false, the entity instance may not define a value that differs from the value in the specification.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMEntitySpecification")
@Table(name = "STMEntitySpecification")
public class EntitySpecification extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

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

	@JsonProperty("specCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CharacteristicSpecification> specCharacteristic = new HashSet<>();

	@JsonProperty("targetEntitySchema")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private TargetEntitySchema targetEntitySchema = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public EntitySpecification href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@Schema(description = "Hyperlink reference")

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
	 * 
	 * @return description
	 **/
	@Schema(description = "Description of this REST resource")

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
	 * isBundle determines whether an EntitySpecification represents a single
	 * EntitySpecification (false), or a bundle of EntitySpecifications (true).
	 * 
	 * @return isBundle
	 **/
	@Schema(description = "isBundle determines whether an EntitySpecification represents a single EntitySpecification (false), or a bundle of EntitySpecifications (true).")

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
	 * 
	 * @return lastUpdate
	 **/
	@Schema(description = "Date and time of the last update of this REST resource")

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
	 * 
	 * @return lifecycleStatus
	 **/
	@Schema(description = "Used to indicate the current lifecycle status of this catalog item")

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
	 * 
	 * @return name
	 **/
	@Schema(description = "Name given to this REST resource")

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
	 * 
	 * @return version
	 **/
	@Schema(description = "Entity specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public EntitySpecification attachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
		return this;
	}

	public EntitySpecification addAttachmentItem(AttachmentRefOrValue attachmentItem) {
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
	@Schema(description = "Attachments that may be of relevance to this specification, such as picture, document, media")
	@Valid
	public Set<AttachmentRefOrValue> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<AttachmentRefOrValue> attachment) {
		this.attachment = attachment;
	}

	public EntitySpecification constraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
		return this;
	}

	public EntitySpecification addConstraintItem(ConstraintRef constraintItem) {
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
	@Schema(description = "This is a list of constraint references applied to this specification")
	@Valid
	public Set<ConstraintRef> getConstraint() {
		return constraint;
	}

	public void setConstraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
	}

	public EntitySpecification entitySpecRelationship(Set<EntitySpecificationRelationship> entitySpecRelationship) {
		this.entitySpecRelationship = entitySpecRelationship;
		return this;
	}

	public EntitySpecification addEntitySpecRelationshipItem(
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
	@Schema(description = "Relationship to another entity specification, might be dependency, substitution, etc.")
	@Valid
	public Set<EntitySpecificationRelationship> getEntitySpecRelationship() {
		return entitySpecRelationship;
	}

	public void setEntitySpecRelationship(Set<EntitySpecificationRelationship> entitySpecRelationship) {
		this.entitySpecRelationship = entitySpecRelationship;
	}

	public EntitySpecification relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public EntitySpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
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
	@Schema(description = "Parties who manage or otherwise have an interest in this entity specification")
	@Valid
	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public EntitySpecification specCharacteristic(Set<CharacteristicSpecification> specCharacteristic) {
		this.specCharacteristic = specCharacteristic;
		return this;
	}

	public EntitySpecification addSpecCharacteristicItem(CharacteristicSpecification specCharacteristicItem) {
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
	@Schema(description = "List of characteristics that the entity can take")
	@Valid
	public Set<CharacteristicSpecification> getSpecCharacteristic() {
		return specCharacteristic;
	}

	public void setSpecCharacteristic(Set<CharacteristicSpecification> specCharacteristic) {
		this.specCharacteristic = specCharacteristic;
	}

	public EntitySpecification targetEntitySchema(TargetEntitySchema targetEntitySchema) {
		this.targetEntitySchema = targetEntitySchema;
		return this;
	}

	/**
	 * Get targetEntitySchema
	 * 
	 * @return targetEntitySchema
	 **/
	@Schema(description = "")

	@Valid
	public TargetEntitySchema getTargetEntitySchema() {
		return targetEntitySchema;
	}

	public void setTargetEntitySchema(TargetEntitySchema targetEntitySchema) {
		this.targetEntitySchema = targetEntitySchema;
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
		return Objects.equals(this.id, entitySpecification.id) && Objects.equals(this.href, entitySpecification.href)
				&& Objects.equals(this.description, entitySpecification.description)
				&& Objects.equals(this.isBundle, entitySpecification.isBundle)
				&& Objects.equals(this.lastUpdate, entitySpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, entitySpecification.lifecycleStatus)
				&& Objects.equals(this.name, entitySpecification.name)
				&& Objects.equals(this.version, entitySpecification.version)
				&& Objects.equals(this.attachment, entitySpecification.attachment)
				&& Objects.equals(this.constraint, entitySpecification.constraint)
				&& Objects.equals(this.entitySpecRelationship, entitySpecification.entitySpecRelationship)
				&& Objects.equals(this.relatedParty, entitySpecification.relatedParty)
				&& Objects.equals(this.specCharacteristic, entitySpecification.specCharacteristic)
				&& Objects.equals(this.targetEntitySchema, entitySpecification.targetEntitySchema)
				&& Objects.equals(this.validFor, entitySpecification.validFor)
				&& Objects.equals(this.baseType, entitySpecification.baseType)
				&& Objects.equals(this.schemaLocation, entitySpecification.schemaLocation)
				&& Objects.equals(this.type, entitySpecification.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint, entitySpecRelationship, relatedParty, specCharacteristic, targetEntitySchema, validFor, _atBaseType, _atSchemaLocation, _atType);
//  }

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
