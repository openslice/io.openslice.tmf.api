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

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * UserInfoType
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "UserInfoType")
public class UserInfoType extends BaseRootNamedEntity {
	@JsonProperty("sub")
	private String sub = null;

	@JsonProperty("given_name")
	private String givenName = null;

	@JsonProperty("family_name")
	private String familyName = null;

	@JsonProperty("middle_name")
	private String middleName = null;

	@JsonProperty("nickname")
	private String nickname = null;

	@JsonProperty("preferred_username")
	private String preferredUsername = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("phone_number")
	private String phoneNumber = null;

	@JsonProperty("gender")
	private String gender = null;

	@JsonProperty("birthdate")
	private String birthdate = null;

	@JsonProperty("locale")
	private String locale = null;

	@JsonProperty("zoneinfo")
	private String zoneinfo = null;

	@JsonProperty("profile")
	private String profile = null;

	@JsonProperty("picture")
	private String picture = null;

	@JsonProperty("website")
	private String website = null;

	@JsonProperty("address")

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "uuid")
	private GeographicAddressType address = null;

	@JsonProperty("legalId")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<IdentificationType> legalId = new HashSet<>();

	@JsonProperty("userAssets")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<UserAssetType> userAssets =  new HashSet<>();

	public UserInfoType sub(String sub) {
		this.sub = sub;
		return this;
	}

	/**
	 * Subject - Unique Identifier for the End-User
	 * 
	 * @return sub
	 **/
	@Schema(description = "Subject - Unique Identifier for the End-User")
	@NotNull

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public UserInfoType givenName(String givenName) {
		this.givenName = givenName;
		return this;
	}

	/**
	 * Given name(s) or first name(s) of the End-User. Note that in some cultures,
	 * people can have multiple given names; all can be present, with the names
	 * being separated by space characters
	 * 
	 * @return givenName
	 **/
	@Schema(description = "Given name(s) or first name(s) of the End-User. Note that in some cultures, people can have multiple given names; all can be present, with the names being separated by space characters")

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public UserInfoType familyName(String familyName) {
		this.familyName = familyName;
		return this;
	}

	/**
	 * Surname(s) or last name(s) of the End-User. Note that in some cultures,
	 * people can have multiple family names or no family name; all can be present,
	 * with the names being separated by space characters
	 * 
	 * @return familyName
	 **/
	@Schema(description = "Surname(s) or last name(s) of the End-User. Note that in some cultures, people can have multiple family names or no family name; all can be present, with the names being separated by space characters")

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public UserInfoType middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	/**
	 * Middle name(s) of the End-User. Note that in some cultures, people can have
	 * multiple middle names; all can be present, with the names being separated by
	 * space characters. Also note that in some cultures, middle names are not used
	 * 
	 * @return middleName
	 **/
	@Schema(description = "Middle name(s) of the End-User. Note that in some cultures, people can have multiple middle names; all can be present, with the names being separated by space characters. Also note that in some cultures, middle names are not used")

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public UserInfoType nickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	/**
	 * Casual name of the End-User that may or may not be the same as the
	 * given_name. For instance, a nickname value of Mike might be returned
	 * alongside a given_name value of Michael
	 * 
	 * @return nickname
	 **/
	@Schema(description = "Casual name of the End-User that may or may not be the same as the given_name. For instance, a nickname value of Mike might be returned alongside a given_name value of Michael")

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public UserInfoType preferredUsername(String preferredUsername) {
		this.preferredUsername = preferredUsername;
		return this;
	}

	/**
	 * Shorthand name by which the End-User wishes to be referred to at the RP, such
	 * as janedoe or j.doe. This value MAY be any valid JSON string including
	 * special characters such as @, /, or whitespace
	 * 
	 * @return preferredUsername
	 **/
	@Schema(description = "Shorthand name by which the End-User wishes to be referred to at the RP, such as janedoe or j.doe. This value MAY be any valid JSON string including special characters such as @, /, or whitespace")

	public String getPreferredUsername() {
		return preferredUsername;
	}

	public void setPreferredUsername(String preferredUsername) {
		this.preferredUsername = preferredUsername;
	}

	public UserInfoType email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * End-User's preferred e-mail address. Its value MUST conform to the [RFC5322]
	 * addr-spec syntax
	 * 
	 * @return email
	 **/
	@Schema(description = "End-User's preferred e-mail address. Its value MUST conform to the [RFC5322] addr-spec syntax")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserInfoType phoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	/**
	 * End-User's preferred telephone number. [E.164] is RECOMMENDED as the format
	 * of this Claim, for example, +1 (425) 555-1212 or +56 82) 687 2400. If the
	 * phone number contains an extension, it is RECOMMENDED that the extension be
	 * represented using the [RFC3966] extension syntax, for example, +1 (604)
	 * 555-1234;ext=5678
	 * 
	 * @return phoneNumber
	 **/
	@Schema(description = "End-User's preferred telephone number. [E.164] is RECOMMENDED as the format of this Claim, for example, +1 (425) 555-1212 or +56 82) 687 2400. If the phone number contains an extension, it is RECOMMENDED that the extension be represented using the [RFC3966] extension syntax, for example, +1 (604) 555-1234;ext=5678")

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserInfoType gender(String gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * End-User's gender. Values defined by this specification are female and male.
	 * Other values MAY be used when neither of the defined values are applicable
	 * 
	 * @return gender
	 **/
	@Schema(description = "End-User's gender. Values defined by this specification are female and male. Other values MAY be used when neither of the defined values are applicable")

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserInfoType birthdate(String birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	/**
	 * End-User's birthday, represented as an [ISO8601-2004] YYYY-MM-DD format. The
	 * year MAY be 0000, indicating that it is omitted. To represent only the year,
	 * YYYY format is allowed. Note that depending on the underlying platform's date
	 * related function, providing just year can result in varying month and day, so
	 * the implementers need to take this factor into account to correctly process
	 * the dates
	 * 
	 * @return birthdate
	 **/
	@Schema(description = "End-User's birthday, represented as an [ISO8601-2004] YYYY-MM-DD format. The year MAY be 0000, indicating that it is omitted. To represent only the year, YYYY format is allowed. Note that depending on the underlying platform's date related function, providing just year can result in varying month and day, so the implementers need to take this factor into account to correctly process the dates")

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public UserInfoType locale(String locale) {
		this.locale = locale;
		return this;
	}

	/**
	 * End-User's locale, represented as a [RFC5646] language tag. This is typically
	 * an [ISO639-1] language code in lowercase and an [ISO3166-1] country code in
	 * uppercase, separated by a dash. For example, en-US or fr-CA. As a
	 * compatibility note, some implementations have used an underscore as the
	 * separator rather than a dash, for example, en_US
	 * 
	 * @return locale
	 **/
	@Schema(description = "End-User's locale, represented as a [RFC5646] language tag. This is typically an [ISO639-1] language code in lowercase and an [ISO3166-1] country code in uppercase, separated by a dash. For example, en-US or fr-CA. As a compatibility note, some implementations have used an underscore as the separator rather than a dash, for example, en_US")

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public UserInfoType zoneinfo(String zoneinfo) {
		this.zoneinfo = zoneinfo;
		return this;
	}

	/**
	 * String from zoneinfo time zone database representing the End-User's time
	 * zone. For example, Europe/Paris or America/Los_Angeles
	 * 
	 * @return zoneinfo
	 **/
	@Schema(description = "String from zoneinfo time zone database representing the End-User's time zone. For example, Europe/Paris or America/Los_Angeles")

	public String getZoneinfo() {
		return zoneinfo;
	}

	public void setZoneinfo(String zoneinfo) {
		this.zoneinfo = zoneinfo;
	}

	public UserInfoType profile(String profile) {
		this.profile = profile;
		return this;
	}

	/**
	 * URL of the End-User's profile page. The contents of this Web page SHOULD be
	 * about the End-User
	 * 
	 * @return profile
	 **/
	@Schema(description = "URL of the End-User's profile page. The contents of this Web page SHOULD be about the End-User")

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public UserInfoType picture(String picture) {
		this.picture = picture;
		return this;
	}

	/**
	 * URL of the End-User's profile picture. This URL MUST refer to an image file
	 * (for example, a PNG, JPEG, or GIF image file), rather than to a Web page
	 * containing an image. Note that this URL SHOULD specifically reference a
	 * profile photo of the End-User suitable for displaying when describing the
	 * End-User, rather than an arbitrary photo taken by the End-User
	 * 
	 * @return picture
	 **/
	@Schema(description = "URL of the End-User's profile picture. This URL MUST refer to an image file (for example, a PNG, JPEG, or GIF image file), rather than to a Web page containing an image. Note that this URL SHOULD specifically reference a profile photo of the End-User suitable for displaying when describing the End-User, rather than an arbitrary photo taken by the End-User")

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public UserInfoType website(String website) {
		this.website = website;
		return this;
	}

	/**
	 * URL of the End-User's Web page or blog. This Web page SHOULD contain
	 * information published by the End-User or an organization that the End-User is
	 * affiliated with
	 * 
	 * @return website
	 **/
	@Schema(description = "URL of the End-User's Web page or blog. This Web page SHOULD contain information published by the End-User or an organization that the End-User is affiliated with")

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public UserInfoType address(GeographicAddressType address) {
		this.address = address;
		return this;
	}

	/**
	 * Structure including the End-User's preferred postal address
	 * 
	 * @return address
	 **/
	@Schema(description = "Structure including the End-User's preferred postal address")

	@Valid

	public GeographicAddressType getAddress() {
		return address;
	}

	public void setAddress(GeographicAddressType address) {
		this.address = address;
	}

	public UserInfoType legalId(Set<IdentificationType> legalId) {
		this.legalId = legalId;
		return this;
	}

	public UserInfoType addLegalIdItem(IdentificationType legalIdItem) {
		if (this.legalId == null) {
			this.legalId = new HashSet<>();
		}
		this.legalId.add(legalIdItem);
		return this;
	}

	/**
	 * Identification documentation of the contact
	 * 
	 * @return legalId
	 **/
	@Schema(description = "Identification documentation of the contact")

	@Valid

	public Set<IdentificationType> getLegalId() {
		return legalId;
	}

	public void setLegalId(Set<IdentificationType> legalId) {
		this.legalId = legalId;
	}

	public UserInfoType userAssets(Set<UserAssetType> userAssets) {
		this.userAssets = userAssets;
		return this;
	}

	public UserInfoType addUserAssetsItem(UserAssetType userAssetsItem) {
		if (this.userAssets == null) {
			this.userAssets = new HashSet<>();
		}
		this.userAssets.add(userAssetsItem);
		return this;
	}

	/**
	 * List of additional profile information
	 * 
	 * @return userAssets
	 **/
	@Schema(description = "List of additional profile information")

	@Valid

	public Set<UserAssetType> getUserAssets() {
		return userAssets;
	}

	public void setUserAssets(Set<UserAssetType> userAssets) {
		this.userAssets = userAssets;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserInfoType userInfoType = (UserInfoType) o;
		return Objects.equals(this.sub, userInfoType.sub) && Objects.equals(this.name, userInfoType.name)
				&& Objects.equals(this.givenName, userInfoType.givenName)
				&& Objects.equals(this.familyName, userInfoType.familyName)
				&& Objects.equals(this.middleName, userInfoType.middleName)
				&& Objects.equals(this.nickname, userInfoType.nickname)
				&& Objects.equals(this.preferredUsername, userInfoType.preferredUsername)
				&& Objects.equals(this.email, userInfoType.email)
				&& Objects.equals(this.phoneNumber, userInfoType.phoneNumber)
				&& Objects.equals(this.gender, userInfoType.gender)
				&& Objects.equals(this.birthdate, userInfoType.birthdate)
				&& Objects.equals(this.locale, userInfoType.locale)
				&& Objects.equals(this.zoneinfo, userInfoType.zoneinfo)
				&& Objects.equals(this.profile, userInfoType.profile)
				&& Objects.equals(this.picture, userInfoType.picture)
				&& Objects.equals(this.website, userInfoType.website)
				&& Objects.equals(this.address, userInfoType.address)
				&& Objects.equals(this.legalId, userInfoType.legalId)
				&& Objects.equals(this.userAssets, userInfoType.userAssets)
				&& Objects.equals(this.type, userInfoType.type) && Objects.equals(this.baseType, userInfoType.baseType)
				&& Objects.equals(this.schemaLocation, userInfoType.schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UserInfoType {\n");

		sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
		sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
		sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
		sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
		sb.append("    preferredUsername: ").append(toIndentedString(preferredUsername)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
		sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
		sb.append("    zoneinfo: ").append(toIndentedString(zoneinfo)).append("\n");
		sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
		sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
		sb.append("    website: ").append(toIndentedString(website)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    legalId: ").append(toIndentedString(legalId)).append("\n");
		sb.append("    userAssets: ").append(toIndentedString(userAssets)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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
