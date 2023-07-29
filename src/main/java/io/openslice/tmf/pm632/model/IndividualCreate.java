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

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about. Skipped properties: id,href
 */
@Schema(description = "Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class IndividualCreate  extends  IndividualUpdate {
  


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualCreate individualCreate = (IndividualCreate) o;
    return Objects.equals(this.aristocraticTitle, individualCreate.aristocraticTitle) &&
        Objects.equals(this.birthDate, individualCreate.birthDate) &&
        Objects.equals(this.countryOfBirth, individualCreate.countryOfBirth) &&
        Objects.equals(this.deathDate, individualCreate.deathDate) &&
        Objects.equals(this.familyName, individualCreate.familyName) &&
        Objects.equals(this.familyNamePrefix, individualCreate.familyNamePrefix) &&
        Objects.equals(this.formattedName, individualCreate.formattedName) &&
        Objects.equals(this.fullName, individualCreate.fullName) &&
        Objects.equals(this.gender, individualCreate.gender) &&
        Objects.equals(this.generation, individualCreate.generation) &&
        Objects.equals(this.givenName, individualCreate.givenName) &&
        Objects.equals(this.legalName, individualCreate.legalName) &&
        Objects.equals(this.location, individualCreate.location) &&
        Objects.equals(this.maritalStatus, individualCreate.maritalStatus) &&
        Objects.equals(this.middleName, individualCreate.middleName) &&
        Objects.equals(this.nationality, individualCreate.nationality) &&
        Objects.equals(this.placeOfBirth, individualCreate.placeOfBirth) &&
        Objects.equals(this.preferredGivenName, individualCreate.preferredGivenName) &&
        Objects.equals(this.title, individualCreate.title) &&
        Objects.equals(this.contactMedium, individualCreate.contactMedium) &&
        Objects.equals(this.creditRating, individualCreate.creditRating) &&
        Objects.equals(this.disability, individualCreate.disability) &&
        Objects.equals(this.externalReference, individualCreate.externalReference) &&
        Objects.equals(this.individualIdentification, individualCreate.individualIdentification) &&
        Objects.equals(this.languageAbility, individualCreate.languageAbility) &&
        Objects.equals(this.otherName, individualCreate.otherName) &&
        Objects.equals(this.partyCharacteristic, individualCreate.partyCharacteristic) &&
        Objects.equals(this.relatedParty, individualCreate.relatedParty) &&
        Objects.equals(this.skill, individualCreate.skill) &&
        Objects.equals(this.status, individualCreate.status) &&
        Objects.equals(this.taxExemptionCertificate, individualCreate.taxExemptionCertificate) &&
        Objects.equals(this.baseType, individualCreate.baseType) &&
        Objects.equals(this.schemaLocation, individualCreate.schemaLocation) &&
        Objects.equals(this.type, individualCreate.type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndividualCreate {\n");
    
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

