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
package io.openslice.tmf.am666.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)
 */
@Schema(description = "Describes the contact medium characteristics that could be used to contact a party (an individual or an organization)")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class MediumCharacteristic   {
  @JsonProperty("city")
  private String city = null;

  @JsonProperty("contactType")
  private String contactType = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("faxNumber")
  private String faxNumber = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("postCode")
  private String postCode = null;

  @JsonProperty("socialNetworkId")
  private String socialNetworkId = null;

  @JsonProperty("stateOrProvince")
  private String stateOrProvince = null;

  @JsonProperty("street1")
  private String street1 = null;

  @JsonProperty("street2")
  private String street2 = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public MediumCharacteristic city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The city
   * @return city
  **/
  @Schema(description = "The city")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public MediumCharacteristic contactType(String contactType) {
    this.contactType = contactType;
    return this;
  }

  /**
   * The type of contact, for example: phone number such as mobile, fixed home, fixed office. postal address such as shipping instalation…
   * @return contactType
  **/
  @Schema(description = "The type of contact, for example: phone number such as mobile, fixed home, fixed office. postal address such as shipping instalation…")


  public String getContactType() {
    return contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public MediumCharacteristic country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The country
   * @return country
  **/
  @Schema(description = "The country")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public MediumCharacteristic emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Full email address in standard format
   * @return emailAddress
  **/
  @Schema(description = "Full email address in standard format")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public MediumCharacteristic faxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
    return this;
  }

  /**
   * The fax number of the contact
   * @return faxNumber
  **/
  @Schema(description = "The fax number of the contact")


  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public MediumCharacteristic phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * The primary phone number of the contact
   * @return phoneNumber
  **/
  @Schema(description = "The primary phone number of the contact")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public MediumCharacteristic postCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

  /**
   * Postcode
   * @return postCode
  **/
  @Schema(description = "Postcode")


  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public MediumCharacteristic socialNetworkId(String socialNetworkId) {
    this.socialNetworkId = socialNetworkId;
    return this;
  }

  /**
   * Identifier as a member of a social network
   * @return socialNetworkId
  **/
  @Schema(description = "Identifier as a member of a social network")


  public String getSocialNetworkId() {
    return socialNetworkId;
  }

  public void setSocialNetworkId(String socialNetworkId) {
    this.socialNetworkId = socialNetworkId;
  }

  public MediumCharacteristic stateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
    return this;
  }

  /**
   * State or province
   * @return stateOrProvince
  **/
  @Schema(description = "State or province")


  public String getStateOrProvince() {
    return stateOrProvince;
  }

  public void setStateOrProvince(String stateOrProvince) {
    this.stateOrProvince = stateOrProvince;
  }

  public MediumCharacteristic street1(String street1) {
    this.street1 = street1;
    return this;
  }

  /**
   * Describes the street
   * @return street1
  **/
  @Schema(description = "Describes the street")


  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public MediumCharacteristic street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * Complementary street description
   * @return street2
  **/
  @Schema(description = "Complementary street description")


  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public MediumCharacteristic baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @Schema(description = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public MediumCharacteristic schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public MediumCharacteristic type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
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
    MediumCharacteristic mediumCharacteristic = (MediumCharacteristic) o;
    return Objects.equals(this.city, mediumCharacteristic.city) &&
        Objects.equals(this.contactType, mediumCharacteristic.contactType) &&
        Objects.equals(this.country, mediumCharacteristic.country) &&
        Objects.equals(this.emailAddress, mediumCharacteristic.emailAddress) &&
        Objects.equals(this.faxNumber, mediumCharacteristic.faxNumber) &&
        Objects.equals(this.phoneNumber, mediumCharacteristic.phoneNumber) &&
        Objects.equals(this.postCode, mediumCharacteristic.postCode) &&
        Objects.equals(this.socialNetworkId, mediumCharacteristic.socialNetworkId) &&
        Objects.equals(this.stateOrProvince, mediumCharacteristic.stateOrProvince) &&
        Objects.equals(this.street1, mediumCharacteristic.street1) &&
        Objects.equals(this.street2, mediumCharacteristic.street2) &&
        Objects.equals(this.baseType, mediumCharacteristic.baseType) &&
        Objects.equals(this.schemaLocation, mediumCharacteristic.schemaLocation) &&
        Objects.equals(this.type, mediumCharacteristic.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, contactType, country, emailAddress, faxNumber, phoneNumber, postCode, socialNetworkId, stateOrProvince, street1, street2, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediumCharacteristic {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    contactType: ").append(toIndentedString(contactType)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    socialNetworkId: ").append(toIndentedString(socialNetworkId)).append("\n");
    sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
    sb.append("    street1: ").append(toIndentedString(street1)).append("\n");
    sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
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

