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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Indicates the contact medium that could be used to contact the party.
 */
@Schema(description = "Indicates the contact medium that could be used to contact the party.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")
@Entity(name = "ContactMedium")
public class ContactMedium extends BaseRootEntity {
	@JsonProperty("mediumType")
	private String mediumType = null;

	@JsonProperty("preferred")
	private Boolean preferred = null;

	@JsonProperty("characteristic")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( referencedColumnName = "uuid")
	private MediumCharacteristic characteristic = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public ContactMedium mediumType(String mediumType) {
		this.mediumType = mediumType;
		return this;
	}

	/**
	 * Type of the contact medium, such as: email address, telephone number, postal
	 * address
	 * 
	 * @return mediumType
	 **/
	@Schema(description = "Type of the contact medium, such as: email address, telephone number, postal address")
	@NotNull

	public String getMediumType() {
		return mediumType;
	}

	public void setMediumType(String mediumType) {
		this.mediumType = mediumType;
	}

	public ContactMedium preferred(Boolean preferred) {
		this.preferred = preferred;
		return this;
	}

	/**
	 * If true, indicates that is the preferred contact medium
	 * 
	 * @return preferred
	 **/
	@Schema(description = "If true, indicates that is the preferred contact medium")

	public Boolean isPreferred() {
		return preferred;
	}

	public void setPreferred(Boolean preferred) {
		this.preferred = preferred;
	}

	public ContactMedium characteristic(MediumCharacteristic characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	/**
	 * Any additional characteristic(s) of this contact medium
	 * 
	 * @return characteristic
	 **/
	@Schema(description = "Any additional characteristic(s) of this contact medium")
	@NotNull

	@Valid

	public MediumCharacteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(MediumCharacteristic characteristic) {
		this.characteristic = characteristic;
	}

	public ContactMedium validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The time period that the contact medium is valid for
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The time period that the contact medium is valid for")

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
		ContactMedium contactMedium = (ContactMedium) o;
		return Objects.equals(this.mediumType, contactMedium.mediumType)
				&& Objects.equals(this.preferred, contactMedium.preferred)
				&& Objects.equals(this.characteristic, contactMedium.characteristic)
				&& Objects.equals(this.validFor, contactMedium.validFor)
				&& Objects.equals(this.baseType, contactMedium.baseType)
				&& Objects.equals(this.schemaLocation, contactMedium.schemaLocation)
				&& Objects.equals(this.type, contactMedium.type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ContactMedium {\n");

		sb.append("    mediumType: ").append(toIndentedString(mediumType)).append("\n");
		sb.append("    preferred: ").append(toIndentedString(preferred)).append("\n");
		sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
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

	public void updateWith(ContactMedium cmUpd) {
		this.mediumType  = cmUpd.getMediumType();
		this.preferred =  cmUpd.isPreferred();
		this.validFor = cmUpd.getValidFor();
		if ( cmUpd.getCharacteristic() !=null) {
			this.characteristic = new MediumCharacteristic( cmUpd.getCharacteristic()  );			
		}
		
	}
}
