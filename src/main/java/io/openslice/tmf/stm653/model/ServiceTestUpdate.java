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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * A service test is an entity that exists for a controlled test invocation on a
 * service. The service test is executed according to a schedule and contains
 * service test configuration parameters that are to be applied at execution
 * time, and service test measures that result. Skipped properties: id,href
 */
@Schema(description = "A service test is an entity that exists for a controlled test invocation on a service. The service  test is executed according to a schedule and contains service test configuration parameters that are to be  applied at execution time, and service test measures that result. Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestUpdate {
	@JsonProperty("description")
	protected String description = null;

	protected OffsetDateTime endDateTime = null;

	@JsonProperty("mode")
	protected String mode = null;

	@JsonProperty("name")
	protected String name = null;

	protected OffsetDateTime startDateTime = null;

	@JsonProperty("state")
	protected String state = null;

	@JsonProperty("characteristic")
	@Valid
	protected List<Characteristic> characteristic = null;

	@JsonProperty("relatedParty")
	@Valid
	protected List<RelatedParty> relatedParty = null;

	@JsonProperty("relatedService")
	protected ServiceRef relatedService = null;

	@JsonProperty("testMeasure")
	@Valid
	protected List<TestMeasure> testMeasure = null;

	@JsonProperty("testSpecification")
	protected ServiceTestSpecificationRef testSpecification = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;

	@JsonProperty("@baseType")
	protected String baseType = null;

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;

	@JsonProperty("@type")
	protected String type = null;

	public ServiceTestUpdate description(String description) {
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

	public ServiceTestUpdate endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
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

	@JsonProperty("endDateTime")
	public String getEndDateStr() {
		if (this.endDateTime != null) {
			return this.endDateTime.toString();
		} else {
			return null;
		}
	}

	public ServiceTestUpdate mode(String mode) {
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

	public ServiceTestUpdate name(String name) {
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

	public ServiceTestUpdate startDateTime(OffsetDateTime startDateTime) {
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

	public void setStartDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	

	@JsonProperty("startDateTime")
	public String getStartDateTimeStr() {
		if (this.startDateTime != null) {
			return this.startDateTime.toString();
		} else {
			return null;
		}
	}


	public ServiceTestUpdate state(String state) {
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

	public ServiceTestUpdate characteristic(List<Characteristic> characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	public ServiceTestUpdate addCharacteristicItem(Characteristic characteristicItem) {
		if (this.characteristic == null) {
			this.characteristic = new ArrayList<>();
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
	public List<Characteristic> getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(List<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}

	public ServiceTestUpdate relatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	public ServiceTestUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
		if (this.relatedParty == null) {
			this.relatedParty = new ArrayList<>();
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
	public List<RelatedParty> getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(List<RelatedParty> relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ServiceTestUpdate relatedService(ServiceRef relatedService) {
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

	public ServiceTestUpdate testMeasure(List<TestMeasure> testMeasure) {
		this.testMeasure = testMeasure;
		return this;
	}

	public ServiceTestUpdate addTestMeasureItem(TestMeasure testMeasureItem) {
		if (this.testMeasure == null) {
			this.testMeasure = new ArrayList<>();
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
	public List<TestMeasure> getTestMeasure() {
		return testMeasure;
	}

	public void setTestMeasure(List<TestMeasure> testMeasure) {
		this.testMeasure = testMeasure;
	}

	public ServiceTestUpdate testSpecification(ServiceTestSpecificationRef testSpecification) {
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

	public ServiceTestUpdate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@Schema(description = "")

	@Valid
	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ServiceTestUpdate baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return baseType;
	}

	public void setAtBaseType(String baseType) {
		this.baseType = baseType;
	}

	public ServiceTestUpdate schemaLocation(String schemaLocation) {
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

	public String getAtSchemaLocation() {
		return schemaLocation;
	}

	public void setAtSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ServiceTestUpdate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class Extensible name
	 * 
	 * @return type
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class Extensible name")

	public String getAtType() {
		return type;
	}

	public void setAtType(String type) {
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
		ServiceTestUpdate serviceTestUpdate = (ServiceTestUpdate) o;
		return Objects.equals(this.description, serviceTestUpdate.description)
				&& Objects.equals(this.endDateTime, serviceTestUpdate.endDateTime)
				&& Objects.equals(this.mode, serviceTestUpdate.mode)
				&& Objects.equals(this.name, serviceTestUpdate.name)
				&& Objects.equals(this.startDateTime, serviceTestUpdate.startDateTime)
				&& Objects.equals(this.state, serviceTestUpdate.state)
				&& Objects.equals(this.characteristic, serviceTestUpdate.characteristic)
				&& Objects.equals(this.relatedParty, serviceTestUpdate.relatedParty)
				&& Objects.equals(this.relatedService, serviceTestUpdate.relatedService)
				&& Objects.equals(this.testMeasure, serviceTestUpdate.testMeasure)
				&& Objects.equals(this.testSpecification, serviceTestUpdate.testSpecification)
				&& Objects.equals(this.validFor, serviceTestUpdate.validFor)
				&& Objects.equals(this.baseType, serviceTestUpdate.baseType)
				&& Objects.equals(this.schemaLocation, serviceTestUpdate.schemaLocation)
				&& Objects.equals(this.type, serviceTestUpdate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, endDateTime, mode, name, startDateTime, state, characteristic, relatedParty,
				relatedService, testMeasure, testSpecification, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceTestUpdate {\n");

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
}
