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

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among resource specifications.
 */
@Schema(description = "A migration, substitution, dependency or exclusivity relationship between/among resource specifications.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")

@Entity(name = "ResourceSpecRelationship")
public class ResourceSpecificationRelationship {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("href")
	private String href = null;

	@JsonProperty("defaultQuantity")
	private Integer defaultQuantity = null;

	@JsonProperty("maximumQuantity")
	private Integer maximumQuantity = null;

	@JsonProperty("minimumQuantity")
	private Integer minimumQuantity = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("role")
	private String role = null;


	@JsonProperty("resourceSpecCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	protected Set<ResourceSpecificationCharacteristic> characteristic =  new HashSet<>();

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("@baseType")
	private String _atBaseType = null;

	@JsonProperty("@schemaLocation")
	private String _atSchemaLocation = null;

	@JsonProperty("@type")
	private String _atType = null;


	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public ResourceSpecificationRelationship id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of target ResourceSpecification
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of target ResourceSpecification")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourceSpecificationRelationship href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the target ResourceSpecification
	 * 
	 * @return href
	 **/
	@Schema(description = "Reference of the target ResourceSpecification")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ResourceSpecificationRelationship defaultQuantity(Integer defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
		return this;
	}

	/**
	 * The default number of the related resource that should be instantiated, for
	 * example a rack would typically have 4 cards, although it could support more.
	 * 
	 * @return defaultQuantity
	 **/
	@Schema(description = "The default number of the related resource that should be instantiated, for example a rack would typically have 4 cards, although it could support more.")

	public Integer getDefaultQuantity() {
		return defaultQuantity;
	}

	public void setDefaultQuantity(Integer defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}

	public ResourceSpecificationRelationship maximumQuantity(Integer maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
		return this;
	}

	/**
	 * The maximum number of the related resource that should be instantiated, for
	 * example a rack supports a maximum of 16 cards
	 * 
	 * @return maximumQuantity
	 **/
	@Schema(description = "The maximum number of the related resource that should be instantiated, for example a rack supports a maximum of 16 cards")

	public Integer getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(Integer maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public ResourceSpecificationRelationship minimumQuantity(Integer minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
		return this;
	}

	/**
	 * The minimum number of the related resource that should be instantiated, for
	 * example a rack must have at least 1 card
	 * 
	 * @return minimumQuantity
	 **/
	@Schema(description = "The minimum number of the related resource that should be instantiated, for example a rack must have at least 1 card")

	public Integer getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(Integer minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public ResourceSpecificationRelationship name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name given to the target resource specification instance
	 * 
	 * @return name
	 **/
	@Schema(description = "The name given to the target resource specification instance")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceSpecificationRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of relationship such as migration, substitution, dependency, exclusivity
	 * 
	 * @return relationshipType
	 **/
	@Schema(description = "Type of relationship such as migration, substitution, dependency, exclusivity")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ResourceSpecificationRelationship role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * The association role for this resource specification
	 * 
	 * @return role
	 **/
	@Schema(description = "The association role for this resource specification")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ResourceSpecificationRelationship characteristic(Set<ResourceSpecificationCharacteristic> characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	public ResourceSpecificationRelationship addCharacteristicItem(
			ResourceSpecificationCharacteristic characteristicItem) {
		if (this.characteristic == null) {
			this.characteristic = new HashSet<>();
		}
		this.characteristic.add(characteristicItem);
		return this;
	}

	/**
	 * A characteristic that refines the relationship. For example, consider the
	 * relationship between a slot and a card. For a half-height card it is
	 * important to know the position at which the card is inserted, so a
	 * characteristic Position might be defined on the relationship to allow
	 * capturing of this in the inventory
	 * 
	 * @return characteristic
	 **/
	@Schema(description = "A characteristic that refines the relationship. For example, consider the relationship between a slot and a card. For a half-height card it is important to know the position at which the card is inserted, so a characteristic Position might be defined on the relationship to allow capturing of this in the inventory")
	@Valid
	public Set<ResourceSpecificationCharacteristic> getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Set<ResourceSpecificationCharacteristic> characteristic) {
		this.characteristic = characteristic;
	}

	public ResourceSpecificationRelationship validFor(TimePeriod validFor) {
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

	public ResourceSpecificationRelationship _atBaseType(String _atBaseType) {
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

	public ResourceSpecificationRelationship _atSchemaLocation(String _atSchemaLocation) {
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

	public ResourceSpecificationRelationship _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return _atType
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class entity name")

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
		ResourceSpecificationRelationship resourceSpecificationRelationship = (ResourceSpecificationRelationship) o;
		return Objects.equals(this.id, resourceSpecificationRelationship.id)
				&& Objects.equals(this.href, resourceSpecificationRelationship.href)
				&& Objects.equals(this.defaultQuantity, resourceSpecificationRelationship.defaultQuantity)
				&& Objects.equals(this.maximumQuantity, resourceSpecificationRelationship.maximumQuantity)
				&& Objects.equals(this.minimumQuantity, resourceSpecificationRelationship.minimumQuantity)
				&& Objects.equals(this.name, resourceSpecificationRelationship.name)
				&& Objects.equals(this.relationshipType, resourceSpecificationRelationship.relationshipType)
				&& Objects.equals(this.role, resourceSpecificationRelationship.role)
				&& Objects.equals(this.characteristic, resourceSpecificationRelationship.characteristic)
				&& Objects.equals(this.validFor, resourceSpecificationRelationship.validFor)
				&& Objects.equals(this._atBaseType, resourceSpecificationRelationship._atBaseType)
				&& Objects.equals(this._atSchemaLocation, resourceSpecificationRelationship._atSchemaLocation)
				&& Objects.equals(this._atType, resourceSpecificationRelationship._atType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, defaultQuantity, maximumQuantity, minimumQuantity, name, relationshipType, role,
				characteristic, validFor, _atBaseType, _atSchemaLocation, _atType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecificationRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
		sb.append("    maximumQuantity: ").append(toIndentedString(maximumQuantity)).append("\n");
		sb.append("    minimumQuantity: ").append(toIndentedString(minimumQuantity)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
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
