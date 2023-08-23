/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.stm653.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * A service test is an entity that exists for a controlled test invocation on a
 * service. The service test is executed according to a schedule and contains
 * service test configuration parameters that are to be applied at execution
 * time, and service test measures that result.
 */
@Schema(description = "A service test is an entity that exists for a controlled test invocation on a service. The service  test is executed according to a schedule and contains service test configuration parameters that are to be  applied at execution time, and service test measures that result.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMServiceTest")
@Table(name = "STMServiceTest")
public class ServiceTest extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@Column( name = "st_end_date_time" )
	private OffsetDateTime endDateTime = null;

	@JsonProperty("mode")
	private String mode = null;

	@Column( name = "st_start_date_time" )
	private OffsetDateTime startDateTime = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("characteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Characteristic> characteristic = new HashSet<>();

	@JsonProperty("relatedParty")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<RelatedParty> relatedParty = new HashSet<>();

	@JsonProperty("relatedService")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private ServiceRef relatedService = null;

	@JsonProperty("testMeasure")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<TestMeasure> testMeasure = new HashSet<>();

	@JsonProperty("testSpecification")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private ServiceTestSpecificationRef testSpecification = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public ServiceTest href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@Schema(description = "Hyperlink reference")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ServiceTest description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of the service test
	 * 
	 * @return description
	 **/
	@Schema(description = "Description of the service test")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceTest endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
	}

	@JsonProperty("endDateTime")
	public String getEndDateStr() {
		if (this.endDateTime != null) {
			return this.endDateTime.toString();
		} else {
			return null;
		}
	}

	/**
	 * The end date and time of the service test
	 * 
	 * @return endDateTime
	 **/
	@Schema(description = "The end date and time of the service test")

	@Valid
	public OffsetDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public ServiceTest mode(String mode) {
		this.mode = mode;
		return this;
	}

	/**
	 * An indication of whether the service test is running in \"PROACTIVE\" or
	 * \"ONDEMAND\" mode
	 * 
	 * @return mode
	 **/
	@Schema(description = "An indication of whether the service test is running in  \"PROACTIVE\" or \"ONDEMAND\" mode")

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public ServiceTest name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The name of the service test
	 * 
	 * @return name
	 **/
	@Schema(description = "The name of the service test")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ServiceTest startDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
		return this;
	}

	/**
	 * The start date and time of the service test.
	 * 
	 * @return startDateTime
	 **/
	@Schema(description = "The start date and time of the service test.")

	@Valid
	public OffsetDateTime getStartDateTime() {
		return startDateTime;
	}

	@JsonProperty("startDateTime")
	public String getStartDateStr() {
		if (this.startDateTime != null) {
			return this.startDateTime.toString();
		} else {
			return null;
		}
	}

	public void setStartDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public ServiceTest state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * The actual state the service test is in
	 * 
	 * @return state
	 **/
	@Schema(description = "The actual state the service test is in")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ServiceTest characteristic(Set<Characteristic> characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	public ServiceTest addCharacteristicItem(Characteristic characteristicItem) {
		if (this.characteristic == null) {
			this.characteristic = new HashSet<>();
		}
		this.characteristic.add(characteristicItem);
		return this;
	}

	/**
	 * List of characteristics with values that define the test run
	 * 
	 * @return characteristic
	 **/
	@Schema(description = "List of characteristics with values that define the test run")
	@Valid
	public Set<Characteristic> getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Set<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}

	public ServiceTest relatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceTest addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new HashSet<>();
		}
		this.relatedParty.add(relatedPartyItem);
		return this;
	}

	/**
	 * Party related to the test
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "Party related to the test")
	@Valid
	public Set<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(Set<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceTest relatedService(ServiceRef relatedService) {
		this.relatedService = relatedService;
		return this;
	}

	/**
	 * Get relatedService
	 * 
	 * @return relatedService
	 **/
	@Schema(description = "")

	@Valid
	public ServiceRef getRelatedService() {
		return relatedService;
	}

	public void setRelatedService(ServiceRef relatedService) {
		this.relatedService = relatedService;
	}

	public ServiceTest testMeasure(Set<TestMeasure> testMeasure) {
		this.testMeasure = testMeasure;
		return this;
	}

	public ServiceTest addTestMeasureItem(TestMeasure testMeasureItem) {
		if (this.testMeasure == null) {
			this.testMeasure = new HashSet<>();
		}
		this.testMeasure.add(testMeasureItem);
		return this;
	}

	/**
	 * The results of the test in terms of the measured metrics
	 * 
	 * @return testMeasure
	 **/
	@Schema(description = "The results of the test in terms of the measured metrics")
	@Valid
	public Set<TestMeasure> getTestMeasure() {
		return testMeasure;
	}

	public void setTestMeasure(Set<TestMeasure> testMeasure) {
		this.testMeasure = testMeasure;
	}

	public ServiceTest testSpecification(ServiceTestSpecificationRef testSpecification) {
		this.testSpecification = testSpecification;
		return this;
	}

	/**
	 * Get testSpecification
	 * 
	 * @return testSpecification
	 **/
	@Schema(description = "")

	@Valid
	public ServiceTestSpecificationRef getTestSpecification() {
		return testSpecification;
	}

	public void setTestSpecification(ServiceTestSpecificationRef testSpecification) {
		this.testSpecification = testSpecification;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceTest serviceTest = (ServiceTest) o;
		return Objects.equals(this.id, serviceTest.id) && Objects.equals(this.href, serviceTest.href)
				&& Objects.equals(this.description, serviceTest.description)
				&& Objects.equals(this.endDateTime, serviceTest.endDateTime)
				&& Objects.equals(this.mode, serviceTest.mode) && Objects.equals(this.name, serviceTest.name)
				&& Objects.equals(this.startDateTime, serviceTest.startDateTime)
				&& Objects.equals(this.state, serviceTest.state)
				&& Objects.equals(this.characteristic, serviceTest.characteristic)
				&& Objects.equals(this.relatedParty, serviceTest.relatedParty)
				&& Objects.equals(this.relatedService, serviceTest.relatedService)
				&& Objects.equals(this.testMeasure, serviceTest.testMeasure)
				&& Objects.equals(this.testSpecification, serviceTest.testSpecification)
				&& Objects.equals(this.validFor, serviceTest.validFor)
				&& Objects.equals(this.baseType, serviceTest.baseType)
				&& Objects.equals(this.schemaLocation, serviceTest.schemaLocation)
				&& Objects.equals(this.type, serviceTest.type);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, description, endDateTime, mode, name, startDateTime, state, characteristic, relatedParty, relatedService, testMeasure, testSpecification, validFor, baseType, schemaLocation, type);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceTest {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
		sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    relatedService: ").append(toIndentedString(relatedService)).append("\n");
		sb.append("    testMeasure: ").append(toIndentedString(testMeasure)).append("\n");
		sb.append("    testSpecification: ").append(toIndentedString(testSpecification)).append("\n");
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

	public Characteristic getCharacteristicByName(@NotNull String name) {
		for (Characteristic c : this.characteristic) {
			if ( c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}
