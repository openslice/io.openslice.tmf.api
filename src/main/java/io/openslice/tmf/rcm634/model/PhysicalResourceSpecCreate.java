package io.openslice.tmf.rcm634.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href
 */
@ApiModel(description = "This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class PhysicalResourceSpecCreate  extends PhysicalResourceSpecUpdate {
 
  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;


  public PhysicalResourceSpecCreate name(String name) {
    this.name = name;
    return this;
  }


  public PhysicalResourceSpecCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update of this REST resource
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update of this REST resource")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalResourceSpecCreate physicalResourceSpecCreate = (PhysicalResourceSpecCreate) o;
    return Objects.equals(this.name, physicalResourceSpecCreate.name) &&
        Objects.equals(this.description, physicalResourceSpecCreate.description) &&
        Objects.equals(this.type, physicalResourceSpecCreate.type) &&
        Objects.equals(this.schemaLocation, physicalResourceSpecCreate.schemaLocation) &&
        Objects.equals(this.baseType, physicalResourceSpecCreate.baseType) &&
        Objects.equals(this.version, physicalResourceSpecCreate.version) &&
        Objects.equals(this.validFor, physicalResourceSpecCreate.validFor) &&
        Objects.equals(this.lastUpdate, physicalResourceSpecCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, physicalResourceSpecCreate.lifecycleStatus) &&
        Objects.equals(this.isBundle, physicalResourceSpecCreate.isBundle) &&
        Objects.equals(this.category, physicalResourceSpecCreate.category) &&
        Objects.equals(this.model, physicalResourceSpecCreate.model) &&
        Objects.equals(this.part, physicalResourceSpecCreate.part) &&
        Objects.equals(this.sku, physicalResourceSpecCreate.sku) &&
        Objects.equals(this.vendor, physicalResourceSpecCreate.vendor) &&
        Objects.equals(this.place, physicalResourceSpecCreate.place) &&
        Objects.equals(this.targetResourceSchema, physicalResourceSpecCreate.targetResourceSchema) &&
        Objects.equals(this.feature, physicalResourceSpecCreate.feature) &&
        Objects.equals(this.attachment, physicalResourceSpecCreate.attachment) &&
        Objects.equals(this.relatedParty, physicalResourceSpecCreate.relatedParty) &&
        Objects.equals(this.resourceSpecCharacteristic, physicalResourceSpecCreate.resourceSpecCharacteristic) &&
        Objects.equals(this.resourceSpecRelationship, physicalResourceSpecCreate.resourceSpecRelationship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate, lifecycleStatus, isBundle, category, model, part, sku, vendor, place, targetResourceSchema, feature, attachment, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalResourceSpecCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    part: ").append(toIndentedString(part)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
    sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
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

