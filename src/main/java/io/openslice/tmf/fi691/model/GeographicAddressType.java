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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * GeographicAddressType
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "GeographicAddressType")
public class GeographicAddressType extends BaseRootEntity {
	@JsonProperty("streetNr")
	private String streetNr = null;

	@JsonProperty("streetNrSuffix")
	private String streetNrSuffix = null;

	@JsonProperty("streetNrLast")
	private String streetNrLast = null;

	@JsonProperty("streetNrLastSuffix")
	private String streetNrLastSuffix = null;

	@JsonProperty("streetName")
	private String streetName = null;

	@JsonProperty("streetType")
	private String streetType = null;

	@JsonProperty("streetSuffix")
	private String streetSuffix = null;

	@JsonProperty("postcode")
	private String postcode = null;

	@JsonProperty("locality")
	private String locality = null;

	@JsonProperty("city")
	private String city = null;

	@JsonProperty("stateOrProvince")
	private String stateOrProvince = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("geographicLocation")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "uuid")
	private GeographicLocationRefOrValueType geographicLocation = null;

	@JsonProperty("geographicSubAddress")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "uuid")
	private GeographicSubAddressType geographicSubAddress = null;

	public GeographicAddressType streetNr(String streetNr) {
		this.streetNr = streetNr;
		return this;
	}

	/**
	 * Required if href not included. Number identifying a specific property on a
	 * public street. It may be combined with streetNrLast for ranged addresses
	 * 
	 * @return streetNr
	 **/
	@Schema(description = "Required if href not included. Number identifying a specific property on a public street. It may be combined with streetNrLast for ranged addresses")
	@NotNull

	public String getStreetNr() {
		return streetNr;
	}

	public void setStreetNr(String streetNr) {
		this.streetNr = streetNr;
	}

	public GeographicAddressType streetNrSuffix(String streetNrSuffix) {
		this.streetNrSuffix = streetNrSuffix;
		return this;
	}

	/**
	 * The street number suffix (or suffix of first number for aranged address)
	 * 
	 * @return streetNrSuffix
	 **/
	@Schema(description = "The street number suffix (or suffix of first number for  aranged address)")

	public String getStreetNrSuffix() {
		return streetNrSuffix;
	}

	public void setStreetNrSuffix(String streetNrSuffix) {
		this.streetNrSuffix = streetNrSuffix;
	}

	public GeographicAddressType streetNrLast(String streetNrLast) {
		this.streetNrLast = streetNrLast;
		return this;
	}

	/**
	 * Last number in a range of street numbers allocated to a property
	 * 
	 * @return streetNrLast
	 **/
	@Schema(description = "Last number in a range of street numbers allocated to a property")

	public String getStreetNrLast() {
		return streetNrLast;
	}

	public void setStreetNrLast(String streetNrLast) {
		this.streetNrLast = streetNrLast;
	}

	public GeographicAddressType streetNrLastSuffix(String streetNrLastSuffix) {
		this.streetNrLastSuffix = streetNrLastSuffix;
		return this;
	}

	/**
	 * Last street number suffix for a ranged address
	 * 
	 * @return streetNrLastSuffix
	 **/
	@Schema(description = "Last street number suffix for a ranged address")

	public String getStreetNrLastSuffix() {
		return streetNrLastSuffix;
	}

	public void setStreetNrLastSuffix(String streetNrLastSuffix) {
		this.streetNrLastSuffix = streetNrLastSuffix;
	}

	public GeographicAddressType streetName(String streetName) {
		this.streetName = streetName;
		return this;
	}

	/**
	 * Required if href not included. Name of the street or other street type
	 * 
	 * @return streetName
	 **/
	@Schema(description = "Required if href not included. Name of the street or other street type")
	@NotNull

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public GeographicAddressType streetType(String streetType) {
		this.streetType = streetType;
		return this;
	}

	/**
	 * Required if href not included. Alley, avenue, street, boulevard, brae,
	 * crescent, drive, highway, lane, terrace, parade, place, tarn, way, wharf
	 * 
	 * @return streetType
	 **/
	@Schema(description = "Required if href not included. Alley, avenue, street, boulevard, brae, crescent, drive, highway, lane, terrace, parade, place, tarn, way, wharf")
	@NotNull

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public GeographicAddressType streetSuffix(String streetSuffix) {
		this.streetSuffix = streetSuffix;
		return this;
	}

	/**
	 * A modifier denoting a relative direction (E, W, S, N)
	 * 
	 * @return streetSuffix
	 **/
	@Schema(description = "A modifier denoting a relative direction (E, W, S, N)")

	public String getStreetSuffix() {
		return streetSuffix;
	}

	public void setStreetSuffix(String streetSuffix) {
		this.streetSuffix = streetSuffix;
	}

	public GeographicAddressType postcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	/**
	 * Required if href not included. Descriptor for a postal delivery area (also
	 * known as zipcode)
	 * 
	 * @return postcode
	 **/
	@Schema(description = "Required if href not included. Descriptor for a postal delivery area (also known as zipcode)")
	@NotNull

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public GeographicAddressType locality(String locality) {
		this.locality = locality;
		return this;
	}

	/**
	 * Required if href not included. An area of defined or undefined boundaries
	 * within a local authority or other legislatively defined area, usually rural
	 * or semi-rural in nature, or a suburb, a bounded locality within a city, town
	 * or shire principally of urban character
	 * 
	 * @return locality
	 **/
	@Schema(description = "Required if href not included. An area of defined or undefined boundaries within a local authority or other legislatively defined area, usually rural or semi-rural in nature, or a suburb, a bounded locality within a city, town or shire principally of urban character ")
	@NotNull

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public GeographicAddressType city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * City that the address is in
	 * 
	 * @return city
	 **/
	@Schema(description = "City that the address is in")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public GeographicAddressType stateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
		return this;
	}

	/**
	 * Required if href not included. the State or Province that the address is in
	 * 
	 * @return stateOrProvince
	 **/
	@Schema(description = "Required if href not included. the State or Province that the address is in")
	@NotNull

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public GeographicAddressType country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Required if href not included. Country that the address is in
	 * 
	 * @return country
	 **/
	@Schema(description = "Required if href not included. Country that the address is in")
	@NotNull

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeographicAddressType geographicLocation(GeographicLocationRefOrValueType geographicLocation) {
		this.geographicLocation = geographicLocation;
		return this;
	}

	/**
	 * A geo location reference, allows describing through coordinate(s) a point, a
	 * line or a space
	 * 
	 * @return geographicLocation
	 **/
	@Schema(description = "A geo location reference, allows describing through coordinate(s) a point, a line or a space")

	@Valid

	public GeographicLocationRefOrValueType getGeographicLocation() {
		return geographicLocation;
	}

	public void setGeographicLocation(GeographicLocationRefOrValueType geographicLocation) {
		this.geographicLocation = geographicLocation;
	}

	public GeographicAddressType geographicSubAddress(GeographicSubAddressType geographicSubAddress) {
		this.geographicSubAddress = geographicSubAddress;
		return this;
	}

	/**
	 * A list of sub addresses. It is used for addressing within a property in an
	 * urban area (country properties are often defined differently). It may refer
	 * to a building, a building cluster, or a floor of a multistory building.
	 * 
	 * @return geographicSubAddress
	 **/
	@Schema(description = "A list of sub addresses. It is used for addressing within a property in an urban area (country properties are often defined differently). It may refer to a building, a building cluster, or a floor of a multistory building.")

	@Valid

	public GeographicSubAddressType getGeographicSubAddress() {
		return geographicSubAddress;
	}

	public void setGeographicSubAddress(GeographicSubAddressType geographicSubAddress) {
		this.geographicSubAddress = geographicSubAddress;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GeographicAddressType geographicAddressType = (GeographicAddressType) o;
		return Objects.equals(this.streetNr, geographicAddressType.streetNr)
				&& Objects.equals(this.streetNrSuffix, geographicAddressType.streetNrSuffix)
				&& Objects.equals(this.streetNrLast, geographicAddressType.streetNrLast)
				&& Objects.equals(this.streetNrLastSuffix, geographicAddressType.streetNrLastSuffix)
				&& Objects.equals(this.streetName, geographicAddressType.streetName)
				&& Objects.equals(this.streetType, geographicAddressType.streetType)
				&& Objects.equals(this.streetSuffix, geographicAddressType.streetSuffix)
				&& Objects.equals(this.postcode, geographicAddressType.postcode)
				&& Objects.equals(this.locality, geographicAddressType.locality)
				&& Objects.equals(this.city, geographicAddressType.city)
				&& Objects.equals(this.stateOrProvince, geographicAddressType.stateOrProvince)
				&& Objects.equals(this.country, geographicAddressType.country)
				&& Objects.equals(this.geographicLocation, geographicAddressType.geographicLocation)
				&& Objects.equals(this.geographicSubAddress, geographicAddressType.geographicSubAddress)
				&& Objects.equals(this.type, geographicAddressType.type)
				&& Objects.equals(this.schemaLocation, geographicAddressType.schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeographicAddressType {\n");

		sb.append("    streetNr: ").append(toIndentedString(streetNr)).append("\n");
		sb.append("    streetNrSuffix: ").append(toIndentedString(streetNrSuffix)).append("\n");
		sb.append("    streetNrLast: ").append(toIndentedString(streetNrLast)).append("\n");
		sb.append("    streetNrLastSuffix: ").append(toIndentedString(streetNrLastSuffix)).append("\n");
		sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
		sb.append("    streetType: ").append(toIndentedString(streetType)).append("\n");
		sb.append("    streetSuffix: ").append(toIndentedString(streetSuffix)).append("\n");
		sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
		sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    geographicLocation: ").append(toIndentedString(geographicLocation)).append("\n");
		sb.append("    geographicSubAddress: ").append(toIndentedString(geographicSubAddress)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
