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

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Identifies the managed object instance associated with the alarm.
 */
@Schema(description = "Identifies the managed object instance associated with the alarm.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
@Entity(name = "AMAlarmedObject")
@Table(name = "AMAlarmedObject")
public class AlarmedObject extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AlarmedObject alarmedObject = (AlarmedObject) o;
		return Objects.equals(this.id, alarmedObject.id) && Objects.equals(this.href, alarmedObject.href)
				&& Objects.equals(this.baseType, alarmedObject.baseType)
				&& Objects.equals(this.schemaLocation, alarmedObject.schemaLocation)
				&& Objects.equals(this.type, alarmedObject.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlarmedObject {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
