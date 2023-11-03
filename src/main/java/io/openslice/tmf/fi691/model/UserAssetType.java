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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * UserAssetType
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "UserAssetType")
public class UserAssetType extends BaseRootEntity {
	/**
	 * Type of managed entity (e.g.: product, resource, service, customer, account)
	 */
	public enum EntityTypeEnum {
		CUSTOMER("customer"),

		ACCOUNT("account"),

		PRODUCT("product"),

		SERVICE("service"),

		RESOURCE("resource");

		private String value;

		EntityTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static EntityTypeEnum fromValue(String text) {
			for (EntityTypeEnum b : EntityTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("entityType")
	private EntityTypeEnum entityType = null;

	/**
	 * Second level to define the type of managed element for
	 * product/service/resource managed entities (e.g.: mobile line subscription,
	 * video platform license, mobile equipment, etc). Allows identifying the
	 * specific asset within the server referenced. Supported values are
	 * implementation and application specific. Other values can be added if those
	 * listed are not enough
	 */
	public enum AssetTypeEnum {
		MOBILE("mobile"),

		LANDLINE("landline"),

		IPTV("iptv"),

		BROADBAND("broadband"),

		EMAIL("email"),

		INVOICING("invoicing");

		private String value;

		AssetTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static AssetTypeEnum fromValue(String text) {
			for (AssetTypeEnum b : AssetTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("assetType")
	private AssetTypeEnum assetType = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("role")
	private String role = null;

	@JsonProperty("entitlement")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<EntitlementType> entitlement = new HashSet<>();

	public UserAssetType entityType(EntityTypeEnum entityType) {
		this.entityType = entityType;
		return this;
	}

	/**
	 * Type of managed entity (e.g.: product, resource, service, customer, account)
	 * 
	 * @return entityType
	 **/
	@Schema(description = "Type of managed entity (e.g.: product, resource, service, customer, account)")
	@NotNull

	public EntityTypeEnum getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityTypeEnum entityType) {
		this.entityType = entityType;
	}

	public UserAssetType assetType(AssetTypeEnum assetType) {
		this.assetType = assetType;
		return this;
	}

	/**
	 * Second level to define the type of managed element for
	 * product/service/resource managed entities (e.g.: mobile line subscription,
	 * video platform license, mobile equipment, etc). Allows identifying the
	 * specific asset within the server referenced. Supported values are
	 * implementation and application specific. Other values can be added if those
	 * listed are not enough
	 * 
	 * @return assetType
	 **/
	@Schema(description = "Second level to define the type of managed element for product/service/resource managed entities (e.g.: mobile line subscription, video platform license, mobile equipment, etc). Allows identifying the specific asset within the server referenced. Supported values are implementation and application specific. Other values can be added if those listed are not enough")

	public AssetTypeEnum getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetTypeEnum assetType) {
		this.assetType = assetType;
	}

	public UserAssetType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of referenced entity within the entity/asset pair
	 * (customerId, accountId, mobile line number, ...)
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of referenced entity within the entity/asset pair (customerId, accountId, mobile line number, ...)")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserAssetType role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * Represents the part played by an individual in relation to being granted a
	 * set of entitlements for manageable assets (e.g.: owner, user, viewer, ...)
	 * 
	 * @return role
	 **/
	@Schema(description = "Represents the part played by an individual in relation to being granted a set of entitlements for manageable assets (e.g.: owner, user, viewer, ...)")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserAssetType entitlement(Set<EntitlementType> entitlement) {
		this.entitlement = entitlement;
		return this;
	}

	public UserAssetType addEntitlementItem(EntitlementType entitlementItem) {
		if (this.entitlement == null) {
			this.entitlement = new HashSet<>();
		}
		this.entitlement.add(entitlementItem);
		return this;
	}

	/**
	 * information about individual entitlements to define access levels to operate
	 * over different functions that can be defined in an asset
	 * 
	 * @return entitlement
	 **/
	@Schema(description = "information about individual entitlements to define access levels to operate over different functions that can be defined in an asset")

	@Valid

	public Set<EntitlementType> getEntitlement() {
		return entitlement;
	}

	public void setEntitlement(Set<EntitlementType> entitlement) {
		this.entitlement = entitlement;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserAssetType userAssetType = (UserAssetType) o;
		return Objects.equals(this.entityType, userAssetType.entityType)
				&& Objects.equals(this.assetType, userAssetType.assetType) && Objects.equals(this.id, userAssetType.id)
				&& Objects.equals(this.role, userAssetType.role)
				&& Objects.equals(this.entitlement, userAssetType.entitlement);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UserAssetType {\n");

		sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
		sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    entitlement: ").append(toIndentedString(entitlement)).append("\n");
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
