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
package io.openslice.tmf.sim638.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Service Order reference. Useful to understand the which was the Service order
 * through which the service was instantiated in the service inventory
 */
@Schema(description = "Service Order reference. Useful to understand the which was the Service order through which the service was instantiated in the service inventory")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")
@Entity(name = "ServiceOrderRef")
@JsonIgnoreProperties({ "uuid" })
public class ServiceOrderRef extends BaseRootEntity {
	
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("serviceOrderItemId")
	private String serviceOrderItemId = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	public ServiceOrderRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the Service Order
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the Service Order")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public ServiceOrderRef serviceOrderItemId(String serviceOrderItemId) {
		this.serviceOrderItemId = serviceOrderItemId;
		return this;
	}

	/**
	 * Unique identifier of the Service Order Item within a service order, not
	 * populated if this is a reference to a service order
	 * 
	 * @return serviceOrderItemId
	 **/
	@Schema(description = "Unique identifier of the Service Order Item within a service order, not populated if this is a reference to a service order")

	public String getServiceOrderItemId() {
		return serviceOrderItemId;
	}

	public void setServiceOrderItemId(String serviceOrderItemId) {
		this.serviceOrderItemId = serviceOrderItemId;
	}





	public ServiceOrderRef referredType(String referredType) {
		this.referredType = referredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return referredType
	 **/
	@Schema(description = "The actual type of the target instance when needed for disambiguation.")

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
		ServiceOrderRef serviceOrderRef = (ServiceOrderRef) o;
		return Objects.equals(this.id, serviceOrderRef.id) && Objects.equals(this.href, serviceOrderRef.href)
				&& Objects.equals(this.serviceOrderItemId, serviceOrderRef.serviceOrderItemId)
				&& Objects.equals(this.baseType, serviceOrderRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceOrderRef.schemaLocation)
				&& Objects.equals(this.type, serviceOrderRef.type)
				&& Objects.equals(this.referredType, serviceOrderRef.referredType);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, serviceOrderItemId, baseType, schemaLocation, type, referredType);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceOrderRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    serviceOrderItemId: ").append(toIndentedString(serviceOrderItemId)).append("\n");
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
