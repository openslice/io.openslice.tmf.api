package io.openslice.tmf.ri639.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

/**
 * Physical resource is a type of resource that describes the common set of
 * attributes shared by all concrete physical resources (e.g. EQUIPMENT) in the
 * inventory.
 */
@Schema(description = "Physical resource is a type of resource that describes the common set of attributes shared by all concrete physical resources (e.g. EQUIPMENT) in the inventory.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIPhysicalRes")
public class PhysicalResource extends Resource {

	private OffsetDateTime manufactureDate = null;

	@JsonProperty("powerState")
	private String powerState = null;

	@JsonProperty("serialNumber")
	private String serialNumber = null;

	@JsonProperty("versionNumber")
	private String versionNumber = null;

	public PhysicalResource manufactureDate(OffsetDateTime manufactureDate) {
		this.manufactureDate = manufactureDate;
		return this;
	}

	/**
	 * This is a string attribute that defines the date of manufacture of this item
	 * in the fixed format \"dd/mm/yyyy\". This is an optional attribute.
	 * 
	 * @return manufactureDate
	 **/
	@Schema(description = "This is a string attribute that defines the date of manufacture of this item in the fixed format \"dd/mm/yyyy\". This is an optional attribute.")

	@Valid
	public OffsetDateTime getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(OffsetDateTime manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@JsonProperty("manufactureDate")
	public String getManufactureDateStr() {
		if (this.manufactureDate != null) {
			return this.manufactureDate.toString();
		} else {
			return null;
		}
	}

	public void setManufactureDate(String endDate) {
		if (endDate != null) {
			this.manufactureDate = OffsetDateTime.parse(endDate);
		}
	}

	public PhysicalResource powerState(String powerState) {
		this.powerState = powerState;
		return this;
	}

	/**
	 * This defines the current power status of the hardware item. Values include:
	 * 0: Unknown 1: Not Applicable 2: No Power Applied 3: Full Power Applied 4:
	 * Power Save - Normal 5: Power Save - Degraded 6: Power Save - Standby 7: Power
	 * Save - Critical 8: Power Save - Low Power Mode 9: Power Save - Unknown 10:
	 * Power Cycle 11: Power Warning 12: Power Off
	 * 
	 * @return powerState
	 **/
	@Schema(description = "This defines the current power status of the hardware item. Values include:    0:  Unknown   1:  Not Applicable   2:  No Power Applied   3: Full Power Applied   4:  Power Save - Normal   5:  Power Save - Degraded   6:  Power Save - Standby   7:  Power Save - Critical   8:  Power Save - Low Power Mode   9:  Power Save - Unknown  10: Power Cycle  11: Power Warning  12: Power Off")

	public String getPowerState() {
		return powerState;
	}

	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	public PhysicalResource resourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
		return this;
	}

	/**
	 * A field that identifies the specific version of an instance of a resource.
	 * 
	 * @return resourceVersion
	 **/
	@Schema(description = "A field that identifies the specific version of an instance of a resource.")

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	public PhysicalResource serialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	/**
	 * This is a string that represents a manufacturer-allocated number used to
	 * identify different instances of the same hardware item. The ModelNumber and
	 * PartNumber attributes are used to identify different types of hardware items.
	 * This is a REQUIRED attribute.
	 * 
	 * @return serialNumber
	 **/
	@Schema(description = "This is a string that represents a manufacturer-allocated number used to identify different instances of the same hardware item. The ModelNumber and PartNumber attributes are used to identify different types of hardware items. This is a REQUIRED attribute.")

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public PhysicalResource startOperatingDate(OffsetDateTime startOperatingDate) {
		this.startOperatingDate = startOperatingDate;
		return this;
	}

	/**
	 * A date time( DateTime). The date from which the resource is operating
	 * 
	 * @return startOperatingDate
	 **/
	@Schema(description = "A date time( DateTime). The date from which the resource is operating")

	@Valid
	public OffsetDateTime getStartOperatingDate() {
		return startOperatingDate;
	}

	public void setStartOperatingDate(OffsetDateTime startOperatingDate) {
		this.startOperatingDate = startOperatingDate;
	}

	public PhysicalResource versionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
		return this;
	}

	/**
	 * This is a string that identifies the version of this physical resource. This
	 * is an optional attribute.
	 * 
	 * @return versionNumber
	 **/
	@Schema(description = "This is a string that identifies the version of this physical resource. This is an optional attribute.")

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PhysicalResource physicalResource = (PhysicalResource) o;
		return Objects.equals(this.id, physicalResource.id) && Objects.equals(this.href, physicalResource.href)
				&& Objects.equals(this.category, physicalResource.category)
				&& Objects.equals(this.description, physicalResource.description)
				&& Objects.equals(this.endOperatingDate, physicalResource.endOperatingDate)
				&& Objects.equals(this.manufactureDate, physicalResource.manufactureDate)
				&& Objects.equals(this.name, physicalResource.name)
				&& Objects.equals(this.powerState, physicalResource.powerState)
				&& Objects.equals(this.resourceVersion, physicalResource.resourceVersion)
				&& Objects.equals(this.serialNumber, physicalResource.serialNumber)
				&& Objects.equals(this.startOperatingDate, physicalResource.startOperatingDate)
				&& Objects.equals(this.versionNumber, physicalResource.versionNumber)
				&& Objects.equals(this.activationFeature, physicalResource.activationFeature)
				&& Objects.equals(this.administrativeState, physicalResource.administrativeState)
				&& Objects.equals(this.attachment, physicalResource.attachment)
				&& Objects.equals(this.note, physicalResource.note)
				&& Objects.equals(this.operationalState, physicalResource.operationalState)
				&& Objects.equals(this.place, physicalResource.place)
				&& Objects.equals(this.relatedParty, physicalResource.relatedParty)
				&& Objects.equals(this.resourceCharacteristic, physicalResource.resourceCharacteristic)
				&& Objects.equals(this.resourceRelationship, physicalResource.resourceRelationship)
				&& Objects.equals(this.resourceSpecification, physicalResource.resourceSpecification)
				&& Objects.equals(this.resourceStatus, physicalResource.resourceStatus)
				&& Objects.equals(this.usageState, physicalResource.usageState)
				&& Objects.equals(this.baseType, physicalResource.baseType)
				&& Objects.equals(this.schemaLocation, physicalResource.schemaLocation)
				&& Objects.equals(this.type, physicalResource.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, category, description, endOperatingDate, manufactureDate, name, powerState,
				resourceVersion, serialNumber, startOperatingDate, versionNumber, activationFeature,
				administrativeState, attachment, note, operationalState, place, relatedParty, resourceCharacteristic,
				resourceRelationship, resourceSpecification, resourceStatus, usageState, baseType, schemaLocation,
				type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PhysicalResource {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    endOperatingDate: ").append(toIndentedString(endOperatingDate)).append("\n");
		sb.append("    manufactureDate: ").append(toIndentedString(manufactureDate)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    powerState: ").append(toIndentedString(powerState)).append("\n");
		sb.append("    resourceVersion: ").append(toIndentedString(resourceVersion)).append("\n");
		sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
		sb.append("    startOperatingDate: ").append(toIndentedString(startOperatingDate)).append("\n");
		sb.append("    versionNumber: ").append(toIndentedString(versionNumber)).append("\n");
		sb.append("    activationFeature: ").append(toIndentedString(activationFeature)).append("\n");
		sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceCharacteristic: ").append(toIndentedString(resourceCharacteristic)).append("\n");
		sb.append("    resourceRelationship: ").append(toIndentedString(resourceRelationship)).append("\n");
		sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
		sb.append("    resourceStatus: ").append(toIndentedString(resourceStatus)).append("\n");
		sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
