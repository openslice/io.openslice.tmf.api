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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * The service test specification used by the service test.
 */
@Schema(description = "The service test specification used by the service test.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")

@Entity(name = "STMServiceTestSpecificationRef")
@Table(name = "STMServiceTestSpecificationRef")
public class ServiceTestSpecificationRef extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public ServiceTestSpecificationRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink to access a service test specification.
	 * 
	 * @return href
	 **/
	@Schema(description = "Hyperlink to access a service test specification.")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ServiceTestSpecificationRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Version of a service test specification
	 * 
	 * @return version
	 **/
	@Schema(description = "Version of a service test specification ")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	

	public ServiceTestSpecificationRef _atReferredType(String _atReferredType) {
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
		ServiceTestSpecificationRef serviceTestSpecificationRef = (ServiceTestSpecificationRef) o;
		return Objects.equals(this.id, serviceTestSpecificationRef.id)
				&& Objects.equals(this.href, serviceTestSpecificationRef.href)
				&& Objects.equals(this.version, serviceTestSpecificationRef.version)
				&& Objects.equals(this.baseType, serviceTestSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceTestSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, serviceTestSpecificationRef.type)
				&& Objects.equals(this._atReferredType, serviceTestSpecificationRef._atReferredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, version, baseType, schemaLocation, type, _atReferredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceTestSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
