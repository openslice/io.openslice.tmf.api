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
package io.openslice.tmf.rcm634.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

/**
 * Specification for applicable configuration features for a resource
 * specification.
 */
@Schema(description = "Specification for applicable configuration features for a resource specification.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "RCMFeatureSpec")
public class FeatureSpecification extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

	@JsonProperty("isEnabled")
	private Boolean isEnabled = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("constraint")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ConstraintRef> constraint = new HashSet<>();

	@JsonProperty("featureSpecCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<FeatureSpecificationCharacteristic> featureSpecCharacteristic = new HashSet<>();

	@JsonProperty("featureSpecRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<FeatureSpecificationRelationship> featureSpecRelationship = new HashSet<>();

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public FeatureSpecification id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of the feature specification. Must be locally unique within the
	 * containing resource specification, thus allowing direct access to the feature
	 * spec.
	 * 
	 * @return id
	 **/
	@Schema(description = "Identifier of the feature specification. Must be locally unique within the containing resource specification, thus allowing direct access to the feature spec.")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FeatureSpecification isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * A flag indicating if this is a feature group (true) or not (false)
	 * 
	 * @return isBundle
	 **/
	@Schema(description = "A flag indicating if this is a feature group (true) or not (false)")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	public FeatureSpecification isEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
		return this;
	}

	/**
	 * A flag indicating if the feature is enabled (true) or not (false)
	 * 
	 * @return isEnabled
	 **/
	@Schema(description = "A flag indicating if the feature is enabled (true) or not (false)")

	public Boolean isIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public FeatureSpecification name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Unique name given to the feature specification
	 * 
	 * @return name
	 **/
	@Schema(description = "Unique name given to the feature specification")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FeatureSpecification version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Version of the feature specification
	 * 
	 * @return version
	 **/
	@Schema(description = "Version of the feature specification")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public FeatureSpecification constraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
		return this;
	}

	public FeatureSpecification addConstraintItem(ConstraintRef constraintItem) {
		if (this.constraint == null) {
			this.constraint = new HashSet<>();
		}
		this.constraint.add(constraintItem);
		return this;
	}

	/**
	 * This is a list of feature constraints
	 * 
	 * @return constraint
	 **/
	@Schema(description = "This is a list of feature constraints")
	@Valid
	public Set<ConstraintRef> getConstraint() {
		return constraint;
	}

	public void setConstraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
	}

	public FeatureSpecification featureSpecCharacteristic(
			Set<FeatureSpecificationCharacteristic> featureSpecCharacteristic) {
		this.featureSpecCharacteristic = featureSpecCharacteristic;
		return this;
	}

	public FeatureSpecification addFeatureSpecCharacteristicItem(
			FeatureSpecificationCharacteristic featureSpecCharacteristicItem) {
		if (this.featureSpecCharacteristic == null) {
			this.featureSpecCharacteristic = new HashSet<>();
		}
		this.featureSpecCharacteristic.add(featureSpecCharacteristicItem);
		return this;
	}

	/**
	 * This is a list of characteristics for a particular feature
	 * 
	 * @return featureSpecCharacteristic
	 **/
	@Schema(description = "This is a list of characteristics for a particular feature")
	@Valid
	public Set<FeatureSpecificationCharacteristic> getFeatureSpecCharacteristic() {
		return featureSpecCharacteristic;
	}

	public void setFeatureSpecCharacteristic(Set<FeatureSpecificationCharacteristic> featureSpecCharacteristic) {
		this.featureSpecCharacteristic = featureSpecCharacteristic;
	}

	public FeatureSpecification featureSpecRelationship(
			Set<FeatureSpecificationRelationship> featureSpecRelationship) {
		this.featureSpecRelationship = featureSpecRelationship;
		return this;
	}

	public FeatureSpecification addFeatureSpecRelationshipItem(
			FeatureSpecificationRelationship featureSpecRelationshipItem) {
		if (this.featureSpecRelationship == null) {
			this.featureSpecRelationship = new HashSet<>();
		}
		this.featureSpecRelationship.add(featureSpecRelationshipItem);
		return this;
	}

	/**
	 * A dependency, exclusivity or aggratation relationship between/among feature
	 * specifications.
	 * 
	 * @return featureSpecRelationship
	 **/
	@Schema(description = "A dependency, exclusivity or aggratation relationship between/among feature specifications.")
	@Valid
	public Set<FeatureSpecificationRelationship> getFeatureSpecRelationship() {
		return featureSpecRelationship;
	}

	public void setFeatureSpecRelationship(Set<FeatureSpecificationRelationship> featureSpecRelationship) {
		this.featureSpecRelationship = featureSpecRelationship;
	}

	public FeatureSpecification validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@Schema(description = "")

	@Valid
	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public FeatureSpecification baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return baseType;
	}

	public void setAtBaseType(String baseType) {
		this.baseType = baseType;
	}

	public FeatureSpecification schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return schemaLocation;
	}

	public void setAtSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public FeatureSpecification type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return type
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class entity name")

	public String getAtType() {
		return type;
	}

	public void setAtType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FeatureSpecification featureSpecification = (FeatureSpecification) o;
		return Objects.equals(this.id, featureSpecification.id)
				&& Objects.equals(this.isBundle, featureSpecification.isBundle)
				&& Objects.equals(this.isEnabled, featureSpecification.isEnabled)
				&& Objects.equals(this.name, featureSpecification.name)
				&& Objects.equals(this.version, featureSpecification.version)
				&& Objects.equals(this.constraint, featureSpecification.constraint)
				&& Objects.equals(this.featureSpecCharacteristic, featureSpecification.featureSpecCharacteristic)
				&& Objects.equals(this.featureSpecRelationship, featureSpecification.featureSpecRelationship)
				&& Objects.equals(this.validFor, featureSpecification.validFor)
				&& Objects.equals(this.baseType, featureSpecification.baseType)
				&& Objects.equals(this.schemaLocation, featureSpecification.schemaLocation)
				&& Objects.equals(this.type, featureSpecification.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isBundle, isEnabled, name, version, constraint, featureSpecCharacteristic,
				featureSpecRelationship, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FeatureSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
		sb.append("    featureSpecCharacteristic: ").append(toIndentedString(featureSpecCharacteristic)).append("\n");
		sb.append("    featureSpecRelationship: ").append(toIndentedString(featureSpecRelationship)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
