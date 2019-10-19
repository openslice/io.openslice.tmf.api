package io.openslice.tmf.pm632.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.pm632.model.Characteristic;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.Disability;
import io.openslice.tmf.pm632.model.ExternalReference;
import io.openslice.tmf.pm632.model.IndividualIdentification;
import io.openslice.tmf.pm632.model.IndividualStateType;
import io.openslice.tmf.pm632.model.LanguageAbility;
import io.openslice.tmf.pm632.model.OtherNameIndividual;
import io.openslice.tmf.pm632.model.PartyCreditProfile;
import io.openslice.tmf.pm632.model.RelatedParty;
import io.openslice.tmf.pm632.model.Skill;
import io.openslice.tmf.pm632.model.TaxExemptionCertificate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about. Skipped properties: id,href
 */
@ApiModel(description = "Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class IndividualUpdate   {
  @JsonProperty("aristocraticTitle")
  private String aristocraticTitle = null;

  @JsonProperty("birthDate")
  private OffsetDateTime birthDate = null;

  @JsonProperty("countryOfBirth")
  private String countryOfBirth = null;

  @JsonProperty("deathDate")
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
  private List<ContactMedium> contactMedium = null;

  @JsonProperty("creditRating")
  @Valid
  private List<PartyCreditProfile> creditRating = null;

  @JsonProperty("disability")
  @Valid
  private List<Disability> disability = null;

  @JsonProperty("externalReference")
  @Valid
  private List<ExternalReference> externalReference = null;

  @JsonProperty("individualIdentification")
  @Valid
  private List<IndividualIdentification> individualIdentification = null;

  @JsonProperty("languageAbility")
  @Valid
  private List<LanguageAbility> languageAbility = null;

  @JsonProperty("otherName")
  @Valid
  private List<OtherNameIndividual> otherName = null;

  @JsonProperty("partyCharacteristic")
  @Valid
  private List<Characteristic> partyCharacteristic = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("skill")
  @Valid
  private List<Skill> skill = null;

  @JsonProperty("status")
  private IndividualStateType status = null;

  @JsonProperty("taxExemptionCertificate")
  @Valid
  private List<TaxExemptionCertificate> taxExemptionCertificate = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public IndividualUpdate aristocraticTitle(String aristocraticTitle) {
    this.aristocraticTitle = aristocraticTitle;
    return this;
  }

  /**
   * e.g. Baron, Graf, Earl,…
   * @return aristocraticTitle
  **/
  @ApiModelProperty(value = "e.g. Baron, Graf, Earl,…")


  public String getAristocraticTitle() {
    return aristocraticTitle;
  }

  public void setAristocraticTitle(String aristocraticTitle) {
    this.aristocraticTitle = aristocraticTitle;
  }

  public IndividualUpdate birthDate(OffsetDateTime birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Birth date
   * @return birthDate
  **/
  @ApiModelProperty(value = "Birth date")

  @Valid

  public OffsetDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(OffsetDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public IndividualUpdate countryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
    return this;
  }

  /**
   * Country where the individual was born
   * @return countryOfBirth
  **/
  @ApiModelProperty(value = "Country where the individual was born")


  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public void setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
  }

  public IndividualUpdate deathDate(OffsetDateTime deathDate) {
    this.deathDate = deathDate;
    return this;
  }

  /**
   * Date of death
   * @return deathDate
  **/
  @ApiModelProperty(value = "Date of death")

  @Valid

  public OffsetDateTime getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(OffsetDateTime deathDate) {
    this.deathDate = deathDate;
  }

  public IndividualUpdate familyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  /**
   * Contains the non-chosen or inherited name. Also known as last name in the Western context
   * @return familyName
  **/
  @ApiModelProperty(value = "Contains the non-chosen or inherited name. Also known as last name in the Western context")


  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public IndividualUpdate familyNamePrefix(String familyNamePrefix) {
    this.familyNamePrefix = familyNamePrefix;
    return this;
  }

  /**
   * Family name prefix
   * @return familyNamePrefix
  **/
  @ApiModelProperty(value = "Family name prefix")


  public String getFamilyNamePrefix() {
    return familyNamePrefix;
  }

  public void setFamilyNamePrefix(String familyNamePrefix) {
    this.familyNamePrefix = familyNamePrefix;
  }

  public IndividualUpdate formattedName(String formattedName) {
    this.formattedName = formattedName;
    return this;
  }

  /**
   * A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)
   * @return formattedName
  **/
  @ApiModelProperty(value = "A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)")


  public String getFormattedName() {
    return formattedName;
  }

  public void setFormattedName(String formattedName) {
    this.formattedName = formattedName;
  }

  public IndividualUpdate fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name flatten (first, middle, and last names)
   * @return fullName
  **/
  @ApiModelProperty(value = "Full name flatten (first, middle, and last names)")


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public IndividualUpdate gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Gender
   * @return gender
  **/
  @ApiModelProperty(value = "Gender")


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public IndividualUpdate generation(String generation) {
    this.generation = generation;
    return this;
  }

  /**
   * e.g.. Sr, Jr, III (the third),…
   * @return generation
  **/
  @ApiModelProperty(value = "e.g.. Sr, Jr, III (the third),…")


  public String getGeneration() {
    return generation;
  }

  public void setGeneration(String generation) {
    this.generation = generation;
  }

  public IndividualUpdate givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * First name of the individual
   * @return givenName
  **/
  @ApiModelProperty(value = "First name of the individual")


  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public IndividualUpdate legalName(String legalName) {
    this.legalName = legalName;
    return this;
  }

  /**
   * Legal name or birth name (name one has for official purposes)
   * @return legalName
  **/
  @ApiModelProperty(value = "Legal name or birth name (name one has for official purposes)")


  public String getLegalName() {
    return legalName;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public IndividualUpdate location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Temporary current location od the individual (may be used if the individual has approved its sharing)
   * @return location
  **/
  @ApiModelProperty(value = "Temporary current location od the individual (may be used if the individual has approved its sharing)")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public IndividualUpdate maritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Marital status (married, divorced, widow ...)
   * @return maritalStatus
  **/
  @ApiModelProperty(value = "Marital status (married, divorced, widow ...)")


  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public IndividualUpdate middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middles name or initial
   * @return middleName
  **/
  @ApiModelProperty(value = "Middles name or initial")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public IndividualUpdate nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * Nationality
   * @return nationality
  **/
  @ApiModelProperty(value = "Nationality")


  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public IndividualUpdate placeOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
    return this;
  }

  /**
   * Reference to the place where the individual was born
   * @return placeOfBirth
  **/
  @ApiModelProperty(value = "Reference to the place where the individual was born")


  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public IndividualUpdate preferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
    return this;
  }

  /**
   * Contains the chosen name by which the individual prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname
   * @return preferredGivenName
  **/
  @ApiModelProperty(value = "Contains the chosen name by which the individual prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname")


  public String getPreferredGivenName() {
    return preferredGivenName;
  }

  public void setPreferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
  }

  public IndividualUpdate title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...
   * @return title
  **/
  @ApiModelProperty(value = "Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public IndividualUpdate contactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
    return this;
  }

  public IndividualUpdate addContactMediumItem(ContactMedium contactMediumItem) {
    if (this.contactMedium == null) {
      this.contactMedium = new ArrayList<>();
    }
    this.contactMedium.add(contactMediumItem);
    return this;
  }

  /**
   * Get contactMedium
   * @return contactMedium
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ContactMedium> getContactMedium() {
    return contactMedium;
  }

  public void setContactMedium(List<ContactMedium> contactMedium) {
    this.contactMedium = contactMedium;
  }

  public IndividualUpdate creditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
    return this;
  }

  public IndividualUpdate addCreditRatingItem(PartyCreditProfile creditRatingItem) {
    if (this.creditRating == null) {
      this.creditRating = new ArrayList<>();
    }
    this.creditRating.add(creditRatingItem);
    return this;
  }

  /**
   * Get creditRating
   * @return creditRating
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PartyCreditProfile> getCreditRating() {
    return creditRating;
  }

  public void setCreditRating(List<PartyCreditProfile> creditRating) {
    this.creditRating = creditRating;
  }

  public IndividualUpdate disability(List<Disability> disability) {
    this.disability = disability;
    return this;
  }

  public IndividualUpdate addDisabilityItem(Disability disabilityItem) {
    if (this.disability == null) {
      this.disability = new ArrayList<>();
    }
    this.disability.add(disabilityItem);
    return this;
  }

  /**
   * Get disability
   * @return disability
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Disability> getDisability() {
    return disability;
  }

  public void setDisability(List<Disability> disability) {
    this.disability = disability;
  }

  public IndividualUpdate externalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  public IndividualUpdate addExternalReferenceItem(ExternalReference externalReferenceItem) {
    if (this.externalReference == null) {
      this.externalReference = new ArrayList<>();
    }
    this.externalReference.add(externalReferenceItem);
    return this;
  }

  /**
   * Get externalReference
   * @return externalReference
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ExternalReference> getExternalReference() {
    return externalReference;
  }

  public void setExternalReference(List<ExternalReference> externalReference) {
    this.externalReference = externalReference;
  }

  public IndividualUpdate individualIdentification(List<IndividualIdentification> individualIdentification) {
    this.individualIdentification = individualIdentification;
    return this;
  }

  public IndividualUpdate addIndividualIdentificationItem(IndividualIdentification individualIdentificationItem) {
    if (this.individualIdentification == null) {
      this.individualIdentification = new ArrayList<>();
    }
    this.individualIdentification.add(individualIdentificationItem);
    return this;
  }

  /**
   * Get individualIdentification
   * @return individualIdentification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<IndividualIdentification> getIndividualIdentification() {
    return individualIdentification;
  }

  public void setIndividualIdentification(List<IndividualIdentification> individualIdentification) {
    this.individualIdentification = individualIdentification;
  }

  public IndividualUpdate languageAbility(List<LanguageAbility> languageAbility) {
    this.languageAbility = languageAbility;
    return this;
  }

  public IndividualUpdate addLanguageAbilityItem(LanguageAbility languageAbilityItem) {
    if (this.languageAbility == null) {
      this.languageAbility = new ArrayList<>();
    }
    this.languageAbility.add(languageAbilityItem);
    return this;
  }

  /**
   * Get languageAbility
   * @return languageAbility
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<LanguageAbility> getLanguageAbility() {
    return languageAbility;
  }

  public void setLanguageAbility(List<LanguageAbility> languageAbility) {
    this.languageAbility = languageAbility;
  }

  public IndividualUpdate otherName(List<OtherNameIndividual> otherName) {
    this.otherName = otherName;
    return this;
  }

  public IndividualUpdate addOtherNameItem(OtherNameIndividual otherNameItem) {
    if (this.otherName == null) {
      this.otherName = new ArrayList<>();
    }
    this.otherName.add(otherNameItem);
    return this;
  }

  /**
   * Get otherName
   * @return otherName
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OtherNameIndividual> getOtherName() {
    return otherName;
  }

  public void setOtherName(List<OtherNameIndividual> otherName) {
    this.otherName = otherName;
  }

  public IndividualUpdate partyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
    return this;
  }

  public IndividualUpdate addPartyCharacteristicItem(Characteristic partyCharacteristicItem) {
    if (this.partyCharacteristic == null) {
      this.partyCharacteristic = new ArrayList<>();
    }
    this.partyCharacteristic.add(partyCharacteristicItem);
    return this;
  }

  /**
   * Get partyCharacteristic
   * @return partyCharacteristic
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Characteristic> getPartyCharacteristic() {
    return partyCharacteristic;
  }

  public void setPartyCharacteristic(List<Characteristic> partyCharacteristic) {
    this.partyCharacteristic = partyCharacteristic;
  }

  public IndividualUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public IndividualUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public IndividualUpdate skill(List<Skill> skill) {
    this.skill = skill;
    return this;
  }

  public IndividualUpdate addSkillItem(Skill skillItem) {
    if (this.skill == null) {
      this.skill = new ArrayList<>();
    }
    this.skill.add(skillItem);
    return this;
  }

  /**
   * Get skill
   * @return skill
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Skill> getSkill() {
    return skill;
  }

  public void setSkill(List<Skill> skill) {
    this.skill = skill;
  }

  public IndividualUpdate status(IndividualStateType status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the individual
   * @return status
  **/
  @ApiModelProperty(value = "Status of the individual")

  @Valid

  public IndividualStateType getStatus() {
    return status;
  }

  public void setStatus(IndividualStateType status) {
    this.status = status;
  }

  public IndividualUpdate taxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
    return this;
  }

  public IndividualUpdate addTaxExemptionCertificateItem(TaxExemptionCertificate taxExemptionCertificateItem) {
    if (this.taxExemptionCertificate == null) {
      this.taxExemptionCertificate = new ArrayList<>();
    }
    this.taxExemptionCertificate.add(taxExemptionCertificateItem);
    return this;
  }

  /**
   * Get taxExemptionCertificate
   * @return taxExemptionCertificate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaxExemptionCertificate> getTaxExemptionCertificate() {
    return taxExemptionCertificate;
  }

  public void setTaxExemptionCertificate(List<TaxExemptionCertificate> taxExemptionCertificate) {
    this.taxExemptionCertificate = taxExemptionCertificate;
  }

  public IndividualUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public IndividualUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public IndividualUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


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
    IndividualUpdate individualUpdate = (IndividualUpdate) o;
    return Objects.equals(this.aristocraticTitle, individualUpdate.aristocraticTitle) &&
        Objects.equals(this.birthDate, individualUpdate.birthDate) &&
        Objects.equals(this.countryOfBirth, individualUpdate.countryOfBirth) &&
        Objects.equals(this.deathDate, individualUpdate.deathDate) &&
        Objects.equals(this.familyName, individualUpdate.familyName) &&
        Objects.equals(this.familyNamePrefix, individualUpdate.familyNamePrefix) &&
        Objects.equals(this.formattedName, individualUpdate.formattedName) &&
        Objects.equals(this.fullName, individualUpdate.fullName) &&
        Objects.equals(this.gender, individualUpdate.gender) &&
        Objects.equals(this.generation, individualUpdate.generation) &&
        Objects.equals(this.givenName, individualUpdate.givenName) &&
        Objects.equals(this.legalName, individualUpdate.legalName) &&
        Objects.equals(this.location, individualUpdate.location) &&
        Objects.equals(this.maritalStatus, individualUpdate.maritalStatus) &&
        Objects.equals(this.middleName, individualUpdate.middleName) &&
        Objects.equals(this.nationality, individualUpdate.nationality) &&
        Objects.equals(this.placeOfBirth, individualUpdate.placeOfBirth) &&
        Objects.equals(this.preferredGivenName, individualUpdate.preferredGivenName) &&
        Objects.equals(this.title, individualUpdate.title) &&
        Objects.equals(this.contactMedium, individualUpdate.contactMedium) &&
        Objects.equals(this.creditRating, individualUpdate.creditRating) &&
        Objects.equals(this.disability, individualUpdate.disability) &&
        Objects.equals(this.externalReference, individualUpdate.externalReference) &&
        Objects.equals(this.individualIdentification, individualUpdate.individualIdentification) &&
        Objects.equals(this.languageAbility, individualUpdate.languageAbility) &&
        Objects.equals(this.otherName, individualUpdate.otherName) &&
        Objects.equals(this.partyCharacteristic, individualUpdate.partyCharacteristic) &&
        Objects.equals(this.relatedParty, individualUpdate.relatedParty) &&
        Objects.equals(this.skill, individualUpdate.skill) &&
        Objects.equals(this.status, individualUpdate.status) &&
        Objects.equals(this.taxExemptionCertificate, individualUpdate.taxExemptionCertificate) &&
        Objects.equals(this.baseType, individualUpdate.baseType) &&
        Objects.equals(this.schemaLocation, individualUpdate.schemaLocation) &&
        Objects.equals(this.type, individualUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aristocraticTitle, birthDate, countryOfBirth, deathDate, familyName, familyNamePrefix, formattedName, fullName, gender, generation, givenName, legalName, location, maritalStatus, middleName, nationality, placeOfBirth, preferredGivenName, title, contactMedium, creditRating, disability, externalReference, individualIdentification, languageAbility, otherName, partyCharacteristic, relatedParty, skill, status, taxExemptionCertificate, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndividualUpdate {\n");
    
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

