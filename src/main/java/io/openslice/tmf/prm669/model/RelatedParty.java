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
package io.openslice.tmf.prm669.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * RelatedParty reference. A related party defines party or party role linked to
 * a specific entity.
 * 
 * From https://engage.tmforum.org/communities/community-home/digestviewer/viewthread?MessageKey=0f5269cd-fe03-4efe-a8e5-064a12bae529&CommunityKey=d543b8ba-9d3a-4121-85ce-5b68e6c31ce5&tab=digestviewer#bm0f5269cd-fe03-4efe-a8e5-064a12bae529
 * 
 * Related Party is intended to provide a reference to either a Party (RelatedParty.role will be blank) or a PartyRole (RelatedParty.role will have the name of the role). Related Party is not in itself a managed entity.
 * If a Party plays multiple roles, there will be a PartyRole (or concrete subclass) for each such role. Suppose John Doe works for H.A.L computers as the communications expert, and H.A.L. uses NXT Communications for its business wireline services. John Doe also has personal cellphone service from NXT for himself and his daughter.
 * So:

    There will be an Individual (subclass of Party) with first name John, last name Doe
    There will be an Organization (subclass of Party) with name H.A.L.
    There will be a Customer (subclass of PartyRole) with name John Doe, and the engagedParty for this Customer will be the Individual John Doe
    There will be a Customer (subclass of PartyRole) with name H.A.L., and the engagedParty for this Customer will be the Organization H.A.L.
    There will be a PartyRole with name John Doe and role Contact, and the engagedParty for this PartyRole will be the Individual John Doe
    The Customer H.A.L. will have a RelatedParty that points to the John Doe PartyRole
    
    
 */
@ApiModel(description = "RelatedParty reference. A related party defines party or party role linked to a specific entity.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "RelatedParty")
public class RelatedParty extends BaseRootNamedEntity{
	@JsonProperty("role")
	private String role = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("extendedInfo")
	private String extendedInfo = null;
	
	
	
	public RelatedParty() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}
	
	public RelatedParty( RelatedParty rp) {
		this.name = rp.getName();
		this.role = rp.getRole();
		this.referredType = rp.getReferredType();
	}
	
	public RelatedParty id(String id) {
		this.id = id;
		return this;
	}
	
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

	
	public RelatedParty role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * Role of the related party.
	 * 
	 * @return role
	 **/
	@ApiModelProperty(value = "Role of the related party.")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public RelatedParty referredType(String referredType) {
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
	
	

	/**
	 * @return the extendedInfo
	 */
	public String getExtendedInfo() {
		return extendedInfo;
	}

	/**
	 * @param extendedInfo the extendedInfo to set
	 */
	public void setExtendedInfo(String extendedInfo) {
		this.extendedInfo = extendedInfo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RelatedParty relatedParty = (RelatedParty) o;
		return Objects.equals(this.id, relatedParty.id) && Objects.equals(this.href, relatedParty.href)
				&& Objects.equals(this.name, relatedParty.name) && Objects.equals(this.role, relatedParty.role)
				&& Objects.equals(this.baseType, relatedParty.baseType)
				&& Objects.equals(this.schemaLocation, relatedParty.schemaLocation)
				&& Objects.equals(this.type, relatedParty.type)
				&& Objects.equals(this.referredType, relatedParty.referredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, name, role, baseType, schemaLocation, type, referredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RelatedParty {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    extendedInfo: ").append(toIndentedString(extendedInfo)).append("\n");
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
