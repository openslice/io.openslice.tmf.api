/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.common.model.service;

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.scm633.model.TargetServiceSchema;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Service specification reference: ServiceSpecification(s) required to realize
 * a ProductSpecification.
 */
@ApiModel(description = "Service specification reference: ServiceSpecification(s) required to realize a ProductSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")
@Entity(name = "ServiceSpecificationRef")
@JsonIgnoreProperties( {"uuid"} )
public class ServiceSpecificationRef extends BaseRootNamedEntity {

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("targetServiceSchema")
	private TargetServiceSchema targetServiceSchema = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	@JsonProperty("id")
	protected String id = null;

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

	public ServiceSpecificationRef version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Service specification version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Service specification version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ServiceSpecificationRef targetServiceSchema(TargetServiceSchema targetServiceSchema) {
		this.targetServiceSchema = targetServiceSchema;
		return this;
	}

	/**
	 * A target service schema reference (TargetServiceSchemaRef). The reference
	 * object to the schema and type of target service which is described by service
	 * specification.
	 * 
	 * @return targetServiceSchema
	 **/
	@ApiModelProperty(value = "A target service schema reference (TargetServiceSchemaRef). The reference object to the schema and type of target service which is described by service specification.")

	@Valid

	public TargetServiceSchema getTargetServiceSchema() {
		return targetServiceSchema;
	}

	public void setTargetServiceSchema(TargetServiceSchema targetServiceSchema) {
		this.targetServiceSchema = targetServiceSchema;
	}

	public ServiceSpecificationRef referredType(String referredType) {
		this.referredType = referredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return referredType
	 **/
	@ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")

	public String getReferredType() {
		return referredType;
	}

	public void setReferredType(String referredType) {
		this.referredType = referredType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceSpecificationRef serviceSpecificationRef = (ServiceSpecificationRef) o;
		return Objects.equals(this.id, serviceSpecificationRef.id)
				&& Objects.equals(this.href, serviceSpecificationRef.href)
				&& Objects.equals(this.name, serviceSpecificationRef.name)
				&& Objects.equals(this.version, serviceSpecificationRef.version)
				&& Objects.equals(this.targetServiceSchema, serviceSpecificationRef.targetServiceSchema)
				&& Objects.equals(this.baseType, serviceSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, serviceSpecificationRef.type)
				&& Objects.equals(this.referredType, serviceSpecificationRef.referredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, name, version, targetServiceSchema, baseType, schemaLocation, type, referredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    targetServiceSchema: ").append(toIndentedString(targetServiceSchema)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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
