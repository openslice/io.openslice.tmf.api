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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * Individual represents a single human being (a man, woman or child). The
 * individual can be a customer, an employee or any other person that the
 * organization needs to store information about.
 */
@Schema(description = "Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")
@Entity
@Table(indexes = { @Index(name = "IX_FAMILYNAME", columnList = "familyName") })
public class Individual extends BaseRootEntity {


	@JsonProperty("id")
	private String id = null;
	
	@JsonProperty("aristocraticTitle")
	private String aristocraticTitle = null;

	private OffsetDateTime birthDate = null;

	@JsonProperty("countryOfBirth")
	private String countryOfBirth = null;

	private OffsetDateTime deathDate = null;

	@JsonProperty("familyName")
	private String familyName = null;

	@JsonProperty("familyNamePrefix")
	private String familyNamePrefix = null;

	@JsonProperty("formattedName")
	private String formattedName = null;

	@JsonProperty("fullName")
	private String fullName = null;

	@JsonProperty("gender")
	private String gender = null;

	@JsonProperty("generation")
	private String generation = null;

	@JsonProperty("givenName")
	private String givenName = null;

	@JsonProperty("legalName")
	private String legalName = null;

	@JsonProperty("location")
	private String location = null;

	@JsonProperty("maritalStatus")
	private String maritalStatus = null;

	@JsonProperty("middleName")
	private String middleName = null;

	@JsonProperty("nationality")
	private String nationality = null;

	@JsonProperty("placeOfBirth")
	private String placeOfBirth = null;

	@JsonProperty("preferredGivenName")
	private String preferredGivenName = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("contactMedium")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ContactMedium> contactMedium = new HashSet<>();

	@JsonProperty("creditRating")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<PartyCreditProfile> creditRating = new HashSet<>();

	@JsonProperty("disability")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Disability> disability = new HashSet<>();

	@JsonProperty("externalReference")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ExternalReference> externalReference = new HashSet<>();

	@JsonProperty("individualIdentification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<IndividualIdentification> individualIdentification = new HashSet<>();

	@JsonProperty("languageAbility")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<LanguageAbility> languageAbility = new HashSet<>();

	@JsonProperty("otherName")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<OtherNameIndividual> otherName = new HashSet<>();

	@JsonProperty("partyCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Characteristic> partyCharacteristic = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("skill")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Skill> skill = new HashSet<>();

	@JsonProperty("status")
	private IndividualStateType status = null;

	@JsonProperty("taxExemptionCertificate")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<TaxExemptionCertificate> taxExemptionCertificate = new HashSet<>();

	@JsonProperty("@baseType")
	private String baseType = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	@JsonProperty("@type")
	private String type = null;


	/**
	 * Unique identifier of the organization
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier of the organization")
	
	public String getId() {
		return uuid;
	}


	public Individual aristocraticTitle(String aristocraticTitle) {
		this.aristocraticTitle = aristocraticTitle;
		return this;
	}

	/**
	 * e.g. Baron, Graf, Earl,…
	 * 
	 * @return aristocraticTitle
	 **/
	@Schema(description = "e.g. Baron, Graf, Earl,…")

	public String getAristocraticTitle() {
		return aristocraticTitle;
	}

	public void setAristocraticTitle(String aristocraticTitle) {
		this.aristocraticTitle = aristocraticTitle;
	}

	public Individual birthDate(OffsetDateTime birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	/**
	 * Birth date
	 * 
	 * @return birthDate
	 **/
	@Schema(description = "Birth date")

	@Valid

	@JsonProperty("birthDate")
	public String getBirthDateString() {

		if ( birthDate == null ) {
			return null;
		}
		return birthDate.toString();
	}

	public OffsetDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(OffsetDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public Individual countryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
		return this;
	}

	/**
	 * Country where the individual was born
	 * 
	 * @return countryOfBirth
	 **/
	@Schema(description = "Country where the individual was born")

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public Individual deathDate(OffsetDateTime deathDate) {
		this.deathDate = deathDate;
		return this;
	}

	/**
	 * Date of death
	 * 
	 * @return deathDate
	 **/
	@Schema(description = "Date of death")

	@Valid

	@JsonProperty("deathDate")
	public String getDeathDateStr() {

		if ( deathDate == null ) {
			return null;
		}
		return deathDate.toString();
	}

	public OffsetDateTime getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(OffsetDateTime deathDate) {
		this.deathDate = deathDate;
	}

	public Individual familyName(String familyName) {
		this.familyName = familyName;
		return this;
	}

	/**
	 * Contains the non-chosen or inherited name. Also known as last name in the
	 * Western context
	 * 
	 * @return familyName
	 **/
	@Schema(description = "Contains the non-chosen or inherited name. Also known as last name in the Western context")

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Individual familyNamePrefix(String familyNamePrefix) {
		this.familyNamePrefix = familyNamePrefix;
		return this;
	}

	/**
	 * Family name prefix
	 * 
	 * @return familyNamePrefix
	 **/
	@Schema(description = "Family name prefix")

	public String getFamilyNamePrefix() {
		return familyNamePrefix;
	}

	public void setFamilyNamePrefix(String familyNamePrefix) {
		this.familyNamePrefix = familyNamePrefix;
	}

	public Individual formattedName(String formattedName) {
		this.formattedName = formattedName;
		return this;
	}

	/**
	 * A fully formatted name in one string with all of its pieces in their proper
	 * place and all of the necessary punctuation. Useful for specific contexts
	 * (Chinese, Japanese, Korean,…)
	 * 
	 * @return formattedName
	 **/
	@Schema(description = "A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)")

	public String getFormattedName() {
		return formattedName;
	}

	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}

	public Individual fullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	/**
	 * Full name flatten (first, middle, and last names)
	 * 
	 * @return fullName
	 **/
	@Schema(description = "Full name flatten (first, middle, and last names)")

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Individual gender(String gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Gender
	 * 
	 * @return gender
	 **/
	@Schema(description = "Gender")

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Individual generation(String generation) {
		this.generation = generation;
		return this;
	}

	/**
	 * e.g.. Sr, Jr, III (the third),…
	 * 
	 * @return generation
	 **/
	@Schema(description = "e.g.. Sr, Jr, III (the third),…")

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public Individual givenName(String givenName) {
		this.givenName = givenName;
		return this;
	}

	/**
	 * First name of the individual
	 * 
	 * @return givenName
	 **/
	@Schema(description = "First name of the individual")

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public Individual legalName(String legalName) {
		this.legalName = legalName;
		return this;
	}

	/**
	 * Legal name or birth name (name one has for official purposes)
	 * 
	 * @return legalName
	 **/
	@Schema(description = "Legal name or birth name (name one has for official purposes)")

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public Individual location(String location) {
		this.location = location;
		return this;
	}

	/**
	 * Temporary current location od the individual (may be used if the individual
	 * has approved its sharing)
	 * 
	 * @return location
	 **/
	@Schema(description = "Temporary current location od the individual (may be used if the individual has approved its sharing)")

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Individual maritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
		return this;
	}

	/**
	 * Marital status (married, divorced, widow ...)
	 * 
	 * @return maritalStatus
	 **/
	@Schema(description = "Marital status (married, divorced, widow ...)")

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Individual middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	/**
	 * Middles name or initial
	 * 
	 * @return middleName
	 **/
	@Schema(description = "Middles name or initial")

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Individual nationality(String nationality) {
		this.nationality = nationality;
		return this;
	}

	/**
	 * Nationality
	 * 
	 * @return nationality
	 **/
	@Schema(description = "Nationality")

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Individual placeOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
		return this;
	}

	/**
	 * Reference to the place where the individual was born
	 * 
	 * @return placeOfBirth
	 **/
	@Schema(description = "Reference to the place where the individual was born")

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Individual preferredGivenName(String preferredGivenName) {
		this.preferredGivenName = preferredGivenName;
		return this;
	}

	/**
	 * Contains the chosen name by which the individual prefers to be addressed.
	 * Note: This name may be a name other than a given name, such as a nickname
	 * 
	 * @return preferredGivenName
	 **/
	@Schema(description = "Contains the chosen name by which the individual prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname")

	public String getPreferredGivenName() {
		return preferredGivenName;
	}

	public void setPreferredGivenName(String preferredGivenName) {
		this.preferredGivenName = preferredGivenName;
	}

	public Individual title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...
	 * 
	 * @return title
	 **/
	@Schema(description = "Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Individual contactMedium(Set<ContactMedium> contactMedium) {
		this.contactMedium = contactMedium;
		return this;
	}

	public Individual addContactMediumItem(ContactMedium contactMediumItem) {
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

	public Individual creditRating(Set<PartyCreditProfile> creditRating) {
		this.creditRating = creditRating;
		return this;
	}

	public Individual addCreditRatingItem(PartyCreditProfile creditRatingItem) {
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
	@Schema(description = "")

	@Valid

	public Set<PartyCreditProfile> getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Set<PartyCreditProfile> creditRating) {
		this.creditRating = creditRating;
	}

	public Individual disability(Set<Disability> disability) {
		this.disability = disability;
		return this;
	}

	public Individual addDisabilityItem(Disability disabilityItem) {
		if (this.disability == null) {
			this.disability = new HashSet<>();
		}
		this.disability.add(disabilityItem);
		return this;
	}

	/**
	 * Get disability
	 * 
	 * @return disability
	 **/
	@Schema(description = "")

	@Valid

	public Set<Disability> getDisability() {
		return disability;
	}

	public void setDisability(Set<Disability> disability) {
		this.disability = disability;
	}

	public Individual externalReference(Set<ExternalReference> externalReference) {
		this.externalReference = externalReference;
		return this;
	}

	public Individual addExternalReferenceItem(ExternalReference externalReferenceItem) {
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
	@Schema(description = "")

	@Valid

	public Set<ExternalReference> getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(Set<ExternalReference> externalReference) {
		this.externalReference = externalReference;
	}

	public Individual individualIdentification(Set<IndividualIdentification> individualIdentification) {
		this.individualIdentification = individualIdentification;
		return this;
	}

	public Individual addIndividualIdentificationItem(IndividualIdentification individualIdentificationItem) {
		if (this.individualIdentification == null) {
			this.individualIdentification = new HashSet<>();
		}
		this.individualIdentification.add(individualIdentificationItem);
		return this;
	}

	/**
	 * Get individualIdentification
	 * 
	 * @return individualIdentification
	 **/
	@Schema(description = "")

	@Valid

	public Set<IndividualIdentification> getIndividualIdentification() {
		return individualIdentification;
	}

	public void setIndividualIdentification(Set<IndividualIdentification> individualIdentification) {
		this.individualIdentification = individualIdentification;
	}

	public Individual languageAbility(Set<LanguageAbility> languageAbility) {
		this.languageAbility = languageAbility;
		return this;
	}

	public Individual addLanguageAbilityItem(LanguageAbility languageAbilityItem) {
		if (this.languageAbility == null) {
			this.languageAbility = new HashSet<>();
		}
		this.languageAbility.add(languageAbilityItem);
		return this;
	}

	/**
	 * Get languageAbility
	 * 
	 * @return languageAbility
	 **/
	@Schema(description = "")

	@Valid

	public Set<LanguageAbility> getLanguageAbility() {
		return languageAbility;
	}

	public void setLanguageAbility(Set<LanguageAbility> languageAbility) {
		this.languageAbility = languageAbility;
	}

	public Individual otherName(Set<OtherNameIndividual> otherName) {
		this.otherName = otherName;
		return this;
	}

	public Individual addOtherNameItem(OtherNameIndividual otherNameItem) {
		if (this.otherName == null) {
			this.otherName = new HashSet<>();
		}
		this.otherName.add(otherNameItem);
		return this;
	}

	/**
	 * Get otherName
	 * 
	 * @return otherName
	 **/
	@Schema(description = "")

	@Valid

	public Set<OtherNameIndividual> getOtherName() {
		return otherName;
	}

	public void setOtherName(Set<OtherNameIndividual> otherName) {
		this.otherName = otherName;
	}

	public Individual partyCharacteristic(Set<Characteristic> partyCharacteristic) {
		this.partyCharacteristic = partyCharacteristic;
		return this;
	}

	public Individual addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
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
	@Schema(description = "")

	@Valid

	public Set<Characteristic> getPartyCharacteristic() {
		return partyCharacteristic;
	}

	public void setPartyCharacteristic(Set<Characteristic> partyCharacteristic) {
		this.partyCharacteristic = partyCharacteristic;
	}

	public Individual relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public Individual addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

	public Individual skill(Set<Skill> skill) {
		this.skill = skill;
		return this;
	}

	public Individual addSkillItem(Skill skillItem) {
		if (this.skill == null) {
			this.skill = new HashSet<>();
		}
		this.skill.add(skillItem);
		return this;
	}

	/**
	 * Get skill
	 * 
	 * @return skill
	 **/
	@Schema(description = "")

	@Valid

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	public Individual status(IndividualStateType status) {
		this.status = status;
		return this;
	}

	/**
	 * Status of the individual
	 * 
	 * @return status
	 **/
	@Schema(description = "Status of the individual")

	@Valid

	public IndividualStateType getStatus() {
		return status;
	}

	public void setStatus(IndividualStateType status) {
		this.status = status;
	}

	public Individual taxExemptionCertificate(Set<TaxExemptionCertificate> taxExemptionCertificate) {
		this.taxExemptionCertificate = taxExemptionCertificate;
		return this;
	}

	public Individual addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
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
	@Schema(description = "")

	@Valid

	public Set<TaxExemptionCertificate> getTaxExemptionCertificate() {
		return taxExemptionCertificate;
	}

	public void setTaxExemptionCertificate(Set<TaxExemptionCertificate> taxExemptionCertificate) {
		this.taxExemptionCertificate = taxExemptionCertificate;
	}

	public Individual baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public Individual schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public Individual type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return type
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class entity name")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Individual individual = (Individual) o;
		return Objects.equals(this.uuid, individual.uuid) && Objects.equals(this.href, individual.href)
				&& Objects.equals(this.aristocraticTitle, individual.aristocraticTitle)
				&& Objects.equals(this.birthDate, individual.birthDate)
				&& Objects.equals(this.countryOfBirth, individual.countryOfBirth)
				&& Objects.equals(this.deathDate, individual.deathDate)
				&& Objects.equals(this.familyName, individual.familyName)
				&& Objects.equals(this.familyNamePrefix, individual.familyNamePrefix)
				&& Objects.equals(this.formattedName, individual.formattedName)
				&& Objects.equals(this.fullName, individual.fullName) && Objects.equals(this.gender, individual.gender)
				&& Objects.equals(this.generation, individual.generation)
				&& Objects.equals(this.givenName, individual.givenName)
				&& Objects.equals(this.legalName, individual.legalName)
				&& Objects.equals(this.location, individual.location)
				&& Objects.equals(this.maritalStatus, individual.maritalStatus)
				&& Objects.equals(this.middleName, individual.middleName)
				&& Objects.equals(this.nationality, individual.nationality)
				&& Objects.equals(this.placeOfBirth, individual.placeOfBirth)
				&& Objects.equals(this.preferredGivenName, individual.preferredGivenName)
				&& Objects.equals(this.title, individual.title)
				&& Objects.equals(this.contactMedium, individual.contactMedium)
				&& Objects.equals(this.creditRating, individual.creditRating)
				&& Objects.equals(this.disability, individual.disability)
				&& Objects.equals(this.externalReference, individual.externalReference)
				&& Objects.equals(this.individualIdentification, individual.individualIdentification)
				&& Objects.equals(this.languageAbility, individual.languageAbility)
				&& Objects.equals(this.otherName, individual.otherName)
				&& Objects.equals(this.partyCharacteristic, individual.partyCharacteristic)
				&& Objects.equals(this.relatedParty, individual.relatedParty)
				&& Objects.equals(this.skill, individual.skill) && Objects.equals(this.status, individual.status)
				&& Objects.equals(this.taxExemptionCertificate, individual.taxExemptionCertificate)
				&& Objects.equals(this.baseType, individual.baseType)
				&& Objects.equals(this.schemaLocation, individual.schemaLocation)
				&& Objects.equals(this.type, individual.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, aristocraticTitle, birthDate, countryOfBirth, deathDate, familyName,
//				familyNamePrefix, formattedName, fullName, gender, generation, givenName, legalName, location,
//				maritalStatus, middleName, nationality, placeOfBirth, preferredGivenName, title, contactMedium,
//				creditRating, disability, externalReference, individualIdentification, languageAbility, otherName,
//				partyCharacteristic, relatedParty, skill, status, taxExemptionCertificate, baseType, schemaLocation,
//				type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Individual {\n");

		sb.append("    id: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    aristocraticTitle: ").append(toIndentedString(aristocraticTitle)).append("\n");
		sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
		sb.append("    countryOfBirth: ").append(toIndentedString(countryOfBirth)).append("\n");
		sb.append("    deathDate: ").append(toIndentedString(deathDate)).append("\n");
		sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
		sb.append("    familyNamePrefix: ").append(toIndentedString(familyNamePrefix)).append("\n");
		sb.append("    formattedName: ").append(toIndentedString(formattedName)).append("\n");
		sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    generation: ").append(toIndentedString(generation)).append("\n");
		sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
		sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
		sb.append("    location: ").append(toIndentedString(location)).append("\n");
		sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
		sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
		sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
		sb.append("    placeOfBirth: ").append(toIndentedString(placeOfBirth)).append("\n");
		sb.append("    preferredGivenName: ").append(toIndentedString(preferredGivenName)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
		sb.append("    creditRating: ").append(toIndentedString(creditRating)).append("\n");
		sb.append("    disability: ").append(toIndentedString(disability)).append("\n");
		sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
		sb.append("    individualIdentification: ").append(toIndentedString(individualIdentification)).append("\n");
		sb.append("    languageAbility: ").append(toIndentedString(languageAbility)).append("\n");
		sb.append("    otherName: ").append(toIndentedString(otherName)).append("\n");
		sb.append("    partyCharacteristic: ").append(toIndentedString(partyCharacteristic)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    skill: ").append(toIndentedString(skill)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
