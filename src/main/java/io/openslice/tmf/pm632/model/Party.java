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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Generic Party structure used to define commonalities between sub concepts of
 * Individual and Organization.
 */
@ApiModel(description = "Generic Party structure used to define commonalities between sub concepts of Individual and Organization.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")
@Entity
public class Party extends BaseRootEntity {

	@JsonProperty("contactMedium")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ContactMedium> contactMedium = new HashSet<>();

	@JsonProperty("creditRating")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<PartyCreditProfile> creditRating = new HashSet<>();

	@JsonProperty("externalReference")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ExternalReference> externalReference = new HashSet<>();

	@JsonProperty("partyCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Characteristic> partyCharacteristic = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("taxExemptionCertificate")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<TaxExemptionCertificate> taxExemptionCertificate = new HashSet<>();

	/**
	 * Unique identifier of the organization
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the organization")

	@JsonProperty("id")
	public String getId() {
		return this.uuid;
	}

	public Party contactMedium(Set<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
		return this;
	}

	public Party addContactMediumItem(ContactMedium contactMediumItem) {
		if (this.contactMedium == null) {
			this.contactMedium = new HashSet<>();
		}
		this.contactMedium.add(contactMediumItem);
		return this;
	}

	/**
	 * Get contactMedium
	 * 
	 * @return contactMedium
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<ContactMedium> getContactMedium() {
		return contactMedium;
	}

	public void setContactMedium(Set<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
	}

	public Party creditRating(Set<PartyCreditProfile> creditRating) {
		this.creditRating = creditRating;
		return this;
	}

	public Party addCreditRatingItem(PartyCreditProfile creditRatingItem) {
		if (this.creditRating == null) {
			this.creditRating = new HashSet<>();
		}
		this.creditRating.add(creditRatingItem);
		return this;
	}

	/**
	 * Get creditRating
	 * 
	 * @return creditRating
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<PartyCreditProfile> getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Set<PartyCreditProfile> creditRating) {
		this.creditRating = creditRating;
	}

	public Party externalReference(Set<ExternalReference> externalReference) {
		this.externalReference = externalReference;
		return this;
	}

	public Party addExternalReferenceItem(ExternalReference externalReferenceItem) {
		if (this.externalReference == null) {
			this.externalReference = new HashSet<>();
		}
		this.externalReference.add(externalReferenceItem);
		return this;
	}

	/**
	 * Get externalReference
	 * 
	 * @return externalReference
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<ExternalReference> getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(Set<ExternalReference> externalReference) {
		this.externalReference = externalReference;
	}

	public Party partyCharacteristic(Set<Characteristic> partyCharacteristic) {
		this.partyCharacteristic = partyCharacteristic;
		return this;
	}

	public Party addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
		if (this.partyCharacteristic == null) {
			this.partyCharacteristic = new HashSet<>();
		}
		this.partyCharacteristic.add(partyCharacteristicItem);
		return this;
	}

	/**
	 * Get partyCharacteristic
	 * 
	 * @return partyCharacteristic
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<Characteristic> getPartyCharacteristic() {
		return partyCharacteristic;
	}

	public void setPartyCharacteristic(Set<Characteristic> partyCharacteristic) {
		this.partyCharacteristic = partyCharacteristic;
	}

	public Party relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public Party addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Get relatedParty
	 * 
	 * @return relatedParty
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public Party taxExemptionCertificate(Set<TaxExemptionCertificate> taxExemptionCertificate) {
		this.taxExemptionCertificate = taxExemptionCertificate;
		return this;
	}

	public Party addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
		if (this.taxExemptionCertificate == null) {
			this.taxExemptionCertificate = new HashSet<>();
		}
		this.taxExemptionCertificate.add(taxExemptionCertificateItem);
		return this;
	}

	/**
	 * Get taxExemptionCertificate
	 * 
	 * @return taxExemptionCertificate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<TaxExemptionCertificate> getTaxExemptionCertificate() {
		return taxExemptionCertificate;
	}

	public void setTaxExemptionCertificate(Set<TaxExemptionCertificate> taxExemptionCertificate) {
		this.taxExemptionCertificate = taxExemptionCertificate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Party party = (Party) o;
		return Objects.equals(this.uuid, party.uuid) && Objects.equals(this.href, party.href)
				&& Objects.equals(this.contactMedium, party.contactMedium)
				&& Objects.equals(this.creditRating, party.creditRating)
				&& Objects.equals(this.externalReference, party.externalReference)
				&& Objects.equals(this.partyCharacteristic, party.partyCharacteristic)
				&& Objects.equals(this.relatedParty, party.relatedParty)
				&& Objects.equals(this.taxExemptionCertificate, party.taxExemptionCertificate)
				&& Objects.equals(this.baseType, party.baseType)
				&& Objects.equals(this.schemaLocation, party.schemaLocation) && Objects.equals(this.type, party.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, contactMedium, creditRating, externalReference, partyCharacteristic, relatedParty, taxExemptionCertificate, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Party {\n");

		sb.append("    id: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
		sb.append("    creditRating: ").append(toIndentedString(creditRating)).append("\n");
		sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
		sb.append("    partyCharacteristic: ").append(toIndentedString(partyCharacteristic)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    taxExemptionCertificate: ").append(toIndentedString(taxExemptionCertificate)).append("\n");
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
