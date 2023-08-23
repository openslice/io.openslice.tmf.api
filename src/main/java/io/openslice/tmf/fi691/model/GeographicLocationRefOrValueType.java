/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.fi691.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * GeographicLocationRefOrValueType
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "GeographicLocationRefOrValueType")
public class GeographicLocationRefOrValueType extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("geographicPoint")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "uuid")
	private GeographicPointType geographicPoint = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	public GeographicLocationRefOrValueType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the location entity within the server
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the location entity within the server")

	public String getId() {
		return uuid;
	}

	public GeographicLocationRefOrValueType geographicPoint(GeographicPointType geographicPoint) {
		this.geographicPoint = geographicPoint;
		return this;
	}

	/**
	 * A list of geo points. A GeoPoint defines a geographic point through
	 * coordinates
	 * 
	 * @return geographicPoint
	 **/
	@Schema(description = "A list of geo points. A GeoPoint defines a geographic point through coordinates")

	@Valid

	public GeographicPointType getGeographicPoint() {
		return geographicPoint;
	}

	public void setGeographicPoint(GeographicPointType geographicPoint) {
		this.geographicPoint = geographicPoint;
	}

	public GeographicLocationRefOrValueType schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A Link to the schema describing this REST Resource
	 * 
	 * @return schemaLocation
	 **/
	@Schema(description = "A Link to the schema describing this REST Resource")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GeographicLocationRefOrValueType geographicLocationRefOrValueType = (GeographicLocationRefOrValueType) o;
		return Objects.equals(this.id, geographicLocationRefOrValueType.id)
				&& Objects.equals(this.href, geographicLocationRefOrValueType.href)
				&& Objects.equals(this.name, geographicLocationRefOrValueType.name)
				&& Objects.equals(this.type, geographicLocationRefOrValueType.type)
				&& Objects.equals(this.geographicPoint, geographicLocationRefOrValueType.geographicPoint)
				&& Objects.equals(this.type, geographicLocationRefOrValueType.type)
				&& Objects.equals(this.schemaLocation, geographicLocationRefOrValueType.schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeographicLocationRefOrValueType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    geographicPoint: ").append(toIndentedString(geographicPoint)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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
