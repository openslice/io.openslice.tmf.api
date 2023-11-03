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
package io.openslice.tmf.cm629.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.am651.model.AgreementRef;
import io.openslice.tmf.am666.model.AccountRef;
import io.openslice.tmf.am666.model.PaymentMethodRef;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.pm632.model.Characteristic;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Customer
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

@Entity(name = "Customer")
public class Customer extends BaseRootNamedEntity {

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("statusReason")
	private String statusReason = null;

	@JsonProperty("account")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AccountRef> account =  new HashSet<>();

	@JsonProperty("agreement")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AgreementRef> agreement = new HashSet<>();

	@JsonProperty("characteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Characteristic> characteristic = new HashSet<>();

	@JsonProperty("contactMedium")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ContactMedium> contactMedium = new HashSet<>();

	@JsonProperty("creditProfile")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<CreditProfile> creditProfile = new HashSet<>();

	@JsonProperty("engagedParty")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( referencedColumnName = "uuid")
	private RelatedParty engagedParty = null;

	@JsonProperty("paymentMethod")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<PaymentMethodRef> paymentMethod = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty =  new HashSet<>();

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	/**
	 * Unique identifier for Customers
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier for Customers")

	public String getId() {
		return uuid;
	}

	public Customer status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Used to track the lifecycle status of the customer.
	 * 
	 * @return status
	 **/
	@Schema(description = "Used to track the lifecycle status of the customer.")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer statusReason(String statusReason) {
		this.statusReason = statusReason;
		return this;
	}

	/**
	 * A string providing an explanation on the value of the status lifecycle. For
	 * instance if the status is Rejected, statusReason will provide the reason for
	 * rejection.
	 * 
	 * @return statusReason
	 **/
	@Schema(description = "A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.")

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public Customer account(Set<AccountRef> account) {
		this.account = account;
		return this;
	}

	public Customer addAccountItem(AccountRef accountItem) {
		if (this.account == null) {
			this.account = new HashSet<>();
		}
		this.account.add(accountItem);
		return this;
	}

	/**
	 * Get account
	 * 
	 * @return account
	 **/
	@Schema(description = "")

	@Valid

	public Set<AccountRef> getAccount() {
		return account;
	}

	public void setAccount(Set<AccountRef> account) {
		this.account = account;
	}

	public Customer agreement(Set<AgreementRef> agreement) {
		this.agreement = agreement;
		return this;
	}

	public Customer addAgreementItem(AgreementRef agreementItem) {
		if (this.agreement == null) {
			this.agreement = new HashSet<>();
		}
		this.agreement.add(agreementItem);
		return this;
	}

	/**
	 * Get agreement
	 * 
	 * @return agreement
	 **/
	@Schema(description = "")

	@Valid

	public Set<AgreementRef> getAgreement() {
		return agreement;
	}

	public void setAgreement(Set<AgreementRef> agreement) {
		this.agreement = agreement;
	}

	public Customer characteristic(Set<Characteristic> characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	public Customer addCharacteristicItem(Characteristic characteristicItem) {
		if (this.characteristic == null) {
			this.characteristic = new HashSet<>();
		}
		this.characteristic.add(characteristicItem);
		return this;
	}

	/**
	 * Describes the characteristic of a customer.
	 * 
	 * @return characteristic
	 **/
	@Schema(description = "Describes the characteristic of a customer.")

	@Valid

	public Set<Characteristic> getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Set<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}

	public Customer contactMedium(Set<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
		return this;
	}

	public Customer addContactMediumItem(ContactMedium contactMediumItem) {
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
	@Schema(description = "")

	@Valid

	public Set<ContactMedium> getContactMedium() {
		return contactMedium;
	}

	public void setContactMedium(Set<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
	}

	public Customer creditProfile(Set<CreditProfile> creditProfile) {
		this.creditProfile = creditProfile;
		return this;
	}

	public Customer addCreditProfileItem(CreditProfile creditProfileItem) {
		if (this.creditProfile == null) {
			this.creditProfile = new HashSet<>();
		}
		this.creditProfile.add(creditProfileItem);
		return this;
	}

	/**
	 * Get creditProfile
	 * 
	 * @return creditProfile
	 **/
	@Schema(description = "")

	@Valid

	public Set<CreditProfile> getCreditProfile() {
		return creditProfile;
	}

	public void setCreditProfile(Set<CreditProfile> creditProfile) {
		this.creditProfile = creditProfile;
	}

	public Customer engagedParty(RelatedParty engagedParty) {
		this.engagedParty = engagedParty;
		return this;
	}

	/**
	 * The party - an organization or an individual - that is engaged as a customer.
	 * 
	 * @return engagedParty
	 **/
	@Schema(description = "The party - an organization or an individual - that is engaged as a customer.")
	@NotNull

	@Valid

	public RelatedParty getEngagedParty() {
		return engagedParty;
	}

	public void setEngagedParty(RelatedParty engagedParty) {
		this.engagedParty = engagedParty;
	}

	public Customer paymentMethod(Set<PaymentMethodRef> paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	public Customer addPaymentMethodItem(PaymentMethodRef paymentMethodItem) {
		if (this.paymentMethod == null) {
			this.paymentMethod = new HashSet<>();
		}
		this.paymentMethod.add(paymentMethodItem);
		return this;
	}

	/**
	 * Get paymentMethod
	 * 
	 * @return paymentMethod
	 **/
	@Schema(description = "")

	@Valid

	public Set<PaymentMethodRef> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Set<PaymentMethodRef> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Customer relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public Customer addRelatedPartyItem(RelatedParty relatedPartyItem) {
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
	@Schema(description = "")

	@Valid

	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public Customer validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The time period that the Customer is valid for.
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The time period that the Customer is valid for.")

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
		Customer customer = (Customer) o;
		return Objects.equals(this.id, customer.id) && Objects.equals(this.href, customer.href)
				&& Objects.equals(this.name, customer.name) && Objects.equals(this.status, customer.status)
				&& Objects.equals(this.statusReason, customer.statusReason)
				&& Objects.equals(this.account, customer.account) && Objects.equals(this.agreement, customer.agreement)
				&& Objects.equals(this.characteristic, customer.characteristic)
				&& Objects.equals(this.contactMedium, customer.contactMedium)
				&& Objects.equals(this.creditProfile, customer.creditProfile)
				&& Objects.equals(this.engagedParty, customer.engagedParty)
				&& Objects.equals(this.paymentMethod, customer.paymentMethod)
				&& Objects.equals(this.relatedParty, customer.relatedParty)
				&& Objects.equals(this.validFor, customer.validFor) && Objects.equals(this.baseType, customer.baseType)
				&& Objects.equals(this.schemaLocation, customer.schemaLocation)
				&& Objects.equals(this.type, customer.type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
		sb.append("    account: ").append(toIndentedString(account)).append("\n");
		sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
		sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
		sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
		sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
		sb.append("    engagedParty: ").append(toIndentedString(engagedParty)).append("\n");
		sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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
