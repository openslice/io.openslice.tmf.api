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
package io.openslice.tmf.common.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 * 
 * basic root entity that defines common attributes of the model
 * 
 * @author ctranoris
 *
 */
@Entity( name = "BaseRootNamedEntity")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Table( indexes = {@Index(name = "IX_NAME", columnList = "name")} )
public class BaseRootNamedEntity  extends BaseRootEntity{

	
	@JsonProperty("name")
	protected String name = null;

	



	public BaseRootNamedEntity name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the entity
	 * 
	 * @return name
	 **/
	@Schema(description = "Name of the entity")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BaseRootNamedEntity Entity = (BaseRootNamedEntity) o;
		return Objects.equals(this.uuid, Entity.uuid) && Objects.equals(this.href, Entity.href)
				&& Objects.equals(this.name, Entity.name)
				&& Objects.equals(this.baseType, Entity.baseType)
				&& Objects.equals(this.schemaLocation, Entity.schemaLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, href, name,

				baseType, schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Entity {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	public void copyFromObj(BaseRootNamedEntity be) {
		this.uuid = be.uuid;
		this.name = be.name;
		this.href = be.href;
		this.baseType = be.baseType;
		this.schemaLocation = be.schemaLocation;
		this.type = be.type;
		
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
