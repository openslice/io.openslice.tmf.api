package io.openslice.tmf.stm653.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among entity specifications.
 */
@ApiModel(description = "A migration, substitution, dependency or exclusivity relationship between/among entity specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMEntitySpecRel")
@Table(name = "STMEntitySpecRel")
public class EntitySpecificationRelationship extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("role")
	private String role = null;

	@JsonProperty("associationSpec")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private AssociationSpecificationRef associationSpec = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	public EntitySpecificationRelationship id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "unique identifier")
	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public EntitySpecificationRelationship href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Hyperlink reference")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public EntitySpecificationRelationship name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the related entity.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the related entity.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EntitySpecificationRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of relationship such as migration, substitution, dependency, exclusivity
	 * 
	 * @return relationshipType
	 **/
	@ApiModelProperty(required = true, value = "Type of relationship such as migration, substitution, dependency, exclusivity")
	@NotNull

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public EntitySpecificationRelationship role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * The association role for this entity specification
	 * 
	 * @return role
	 **/
	@ApiModelProperty(value = "The association role for this entity specification")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public EntitySpecificationRelationship associationSpec(AssociationSpecificationRef associationSpec) {
		this.associationSpec = associationSpec;
		return this;
	}

	/**
	 * Get associationSpec
	 * 
	 * @return associationSpec
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public AssociationSpecificationRef getAssociationSpec() {
		return associationSpec;
	}

	public void setAssociationSpec(AssociationSpecificationRef associationSpec) {
		this.associationSpec = associationSpec;
	}


	

	public EntitySpecificationRelationship _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
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
		EntitySpecificationRelationship entitySpecificationRelationship = (EntitySpecificationRelationship) o;
		return Objects.equals(this.id, entitySpecificationRelationship.id)
				&& Objects.equals(this.href, entitySpecificationRelationship.href)
				&& Objects.equals(this.name, entitySpecificationRelationship.name)
				&& Objects.equals(this.relationshipType, entitySpecificationRelationship.relationshipType)
				&& Objects.equals(this.role, entitySpecificationRelationship.role)
				&& Objects.equals(this.associationSpec, entitySpecificationRelationship.associationSpec)
				&& Objects.equals(this.validFor, entitySpecificationRelationship.validFor)
				&& Objects.equals(this.baseType, entitySpecificationRelationship.baseType)
				&& Objects.equals(this.schemaLocation, entitySpecificationRelationship.schemaLocation)
				&& Objects.equals(this.type, entitySpecificationRelationship.type)
				&& Objects.equals(this._atReferredType, entitySpecificationRelationship._atReferredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, name, relationshipType, role, associationSpec, validFor, _atBaseType,
//				_atSchemaLocation, _atType, _atReferredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EntitySpecificationRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    associationSpec: ").append(toIndentedString(associationSpec)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
