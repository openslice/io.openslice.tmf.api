package io.openslice.tmf.ri639.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

/**
 * Logic resource is a type of resource that describes the common set of attributes shared by all concrete logical resources (e.g. TPE, MSISDN, IP Addresses) in the inventory.
 */
@Schema(description = "Logic resource is a type of resource that describes the common set of attributes shared by all concrete logical resources (e.g. TPE, MSISDN, IP Addresses) in the inventory.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RILogicalRes")
public class LogicalResource extends Resource  {
 

  @JsonProperty("value")
  private String value = null;


  public LogicalResource value(String value) {
    this.value = value;
    return this;
  }

  /**
   * the value of the logical resource. E.g '0746712345' for  MSISDN's
   * @return value
  **/
  @Schema(description = "the value of the logical resource. E.g '0746712345' for  MSISDN's")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogicalResource logicalResource = (LogicalResource) o;
    return Objects.equals(this.id, logicalResource.id) &&
        Objects.equals(this.href, logicalResource.href) &&
        Objects.equals(this.category, logicalResource.category) &&
        Objects.equals(this.description, logicalResource.description) &&
        Objects.equals(this.endOperatingDate, logicalResource.endOperatingDate) &&
        Objects.equals(this.name, logicalResource.name) &&
        Objects.equals(this.resourceVersion, logicalResource.resourceVersion) &&
        Objects.equals(this.startOperatingDate, logicalResource.startOperatingDate) &&
        Objects.equals(this.value, logicalResource.value) &&
        Objects.equals(this.activationFeature, logicalResource.activationFeature) &&
        Objects.equals(this.administrativeState, logicalResource.administrativeState) &&
        Objects.equals(this.attachment, logicalResource.attachment) &&
        Objects.equals(this.note, logicalResource.note) &&
        Objects.equals(this.operationalState, logicalResource.operationalState) &&
        Objects.equals(this.place, logicalResource.place) &&
        Objects.equals(this.relatedParty, logicalResource.relatedParty) &&
        Objects.equals(this.resourceCharacteristic, logicalResource.resourceCharacteristic) &&
        Objects.equals(this.resourceRelationship, logicalResource.resourceRelationship) &&
        Objects.equals(this.resourceSpecification, logicalResource.resourceSpecification) &&
        Objects.equals(this.resourceStatus, logicalResource.resourceStatus) &&
        Objects.equals(this.usageState, logicalResource.usageState) &&
        Objects.equals(this.baseType, logicalResource.baseType) &&
        Objects.equals(this.schemaLocation, logicalResource.schemaLocation) &&
        Objects.equals(this.type, logicalResource.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, category, description, endOperatingDate, name, resourceVersion, startOperatingDate, value, activationFeature, administrativeState, attachment, note, operationalState, place, relatedParty, resourceCharacteristic, resourceRelationship, resourceSpecification, resourceStatus, usageState, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogicalResource {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endOperatingDate: ").append(toIndentedString(endOperatingDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceVersion: ").append(toIndentedString(resourceVersion)).append("\n");
    sb.append("    startOperatingDate: ").append(toIndentedString(startOperatingDate)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
