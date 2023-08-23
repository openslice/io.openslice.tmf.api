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
package io.openslice.tmf.pm632.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * Represents our registration of information used as proof of identity by an
 * organization
 */
@Schema(description = "Represents our registration of information used as proof of identity by an organization")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class OrganizationIdentification extends BaseRootEntity {
	@JsonProperty("identificationId")
	private String identificationId = null;

	@JsonProperty("identificationType")
	private String identificationType = null;

	@JsonProperty("issuingAuthority")
	private String issuingAuthority = null;

	@JsonProperty("issuingDate")
	private OffsetDateTime issuingDate = null;

	@JsonProperty("attachment")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attachment_refid", referencedColumnName = "uuid")
	private AttachmentRefOrValue attachment = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public OrganizationIdentification identificationId(String identificationId) {
		this.identificationId = identificationId;
		return this;
	}

	/**
	 * Identifier
	 * 
	 * @return identificationId
	 **/
	@Schema(description = "Identifier")

	public String getIdentificationId() {
		return identificationId;
	}

	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}

	public OrganizationIdentification identificationType(String identificationType) {
		this.identificationType = identificationType;
		return this;
	}

	/**
	 * Type of identification information used to identify the company in a country
	 * or internationally
	 * 
	 * @return identificationType
	 **/
	@Schema(description = "Type of identification information used to identify the company in a country or internationally")

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public OrganizationIdentification issuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
		return this;
	}

	/**
	 * Authority which has issued the identifier (chamber of commerce...)
	 * 
	 * @return issuingAuthority
	 **/
	@Schema(description = "Authority which has issued the identifier (chamber of commerce...)")

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	public OrganizationIdentification issuingDate(OffsetDateTime issuingDate) {
		this.issuingDate = issuingDate;
		return this;
	}

	/**
	 * Date at which the identifier was issued
	 * 
	 * @return issuingDate
	 **/
	@Schema(description = "Date at which the identifier was issued")

	@Valid

	public OffsetDateTime getIssuingDate() {
		return issuingDate;
	}

	public void setIssuingDate(OffsetDateTime issuingDate) {
		this.issuingDate = issuingDate;
	}

	public OrganizationIdentification attachment(AttachmentRefOrValue attachment) {
		this.attachment = attachment;
		return this;
	}

	/**
	 * Get attachment
	 * 
	 * @return attachment
	 **/
	@Schema(description = "")

	@Valid

	public AttachmentRefOrValue getAttachment() {
		return attachment;
	}

	public void setAttachment(AttachmentRefOrValue attachment) {
		this.attachment = attachment;
	}

	public OrganizationIdentification validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the identification information is valid.
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The period for which the identification information is valid.")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrganizationIdentification organizationIdentification = (OrganizationIdentification) o;
		return Objects.equals(this.identificationId, organizationIdentification.identificationId)
				&& Objects.equals(this.identificationType, organizationIdentification.identificationType)
				&& Objects.equals(this.issuingAuthority, organizationIdentification.issuingAuthority)
				&& Objects.equals(this.issuingDate, organizationIdentification.issuingDate)
				&& Objects.equals(this.attachment, organizationIdentification.attachment)
				&& Objects.equals(this.validFor, organizationIdentification.validFor)
				&& Objects.equals(this.baseType, organizationIdentification.baseType)
				&& Objects.equals(this.schemaLocation, organizationIdentification.schemaLocation)
				&& Objects.equals(this.type, organizationIdentification.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(identificationId, identificationType, issuingAuthority, issuingDate, attachment, validFor, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class OrganizationIdentification {\n");

		sb.append("    identificationId: ").append(toIndentedString(identificationId)).append("\n");
		sb.append("    identificationType: ").append(toIndentedString(identificationType)).append("\n");
		sb.append("    issuingAuthority: ").append(toIndentedString(issuingAuthority)).append("\n");
		sb.append("    issuingDate: ").append(toIndentedString(issuingDate)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
