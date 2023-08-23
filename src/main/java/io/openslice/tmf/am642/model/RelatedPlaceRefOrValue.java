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
package io.openslice.tmf.am642.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * Related Entity reference. A related place defines a place described by
 * reference or by value linked to a specific entity. The polymorphic
 * attributes @type, @schemaLocation &amp; @referredType are related to the
 * place entity and not the RelatedPlaceRefOrValue class itself
 */
@Schema(description = "Related Entity reference. A related place defines a place described by reference or by value linked to a specific entity. The polymorphic attributes @type, @schemaLocation & @referredType are related to the place entity and not the RelatedPlaceRefOrValue class itself")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMRelPlaceRefOrVal")
@Table(name = "AMRelPlaceRefOrVal")
public class RelatedPlaceRefOrValue extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;


	@JsonProperty("role")
	private String role = null;


	@JsonProperty("@referredType")
	private String _atReferredType = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public RelatedPlaceRefOrValue href(String href) {
		this.href = href;
		return this;
	}

	

	public RelatedPlaceRefOrValue role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * Get role
	 * 
	 * @return role
	 **/
	@Schema(description = "")
	@NotNull

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public RelatedPlaceRefOrValue _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return _atReferredType
	 **/
	@Schema(description = "The actual type of the target instance when needed for disambiguation.")

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
		RelatedPlaceRefOrValue relatedPlaceRefOrValue = (RelatedPlaceRefOrValue) o;
		return Objects.equals(this.id, relatedPlaceRefOrValue.id)
				&& Objects.equals(this.href, relatedPlaceRefOrValue.href)
				&& Objects.equals(this.name, relatedPlaceRefOrValue.name)
				&& Objects.equals(this.role, relatedPlaceRefOrValue.role)
				&& Objects.equals(this.baseType, relatedPlaceRefOrValue.baseType)
				&& Objects.equals(this.schemaLocation, relatedPlaceRefOrValue.schemaLocation)
				&& Objects.equals(this.type, relatedPlaceRefOrValue.type)
				&& Objects.equals(this._atReferredType, relatedPlaceRefOrValue._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, role, baseType, schemaLocation, type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RelatedPlaceRefOrValue {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
