package io.openslice.tmf.stm653.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href
 */
@ApiModel(description = "The service test specification describes the service test in terms of parameters to be configured and  measures to be taken. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestSpecificationCreate extends ServiceTestSpecificationUpdate  {
 

  @JsonProperty("validFor")
  private TimePeriod validFor = null;


  public ServiceTestSpecificationCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestSpecificationCreate serviceTestSpecificationCreate = (ServiceTestSpecificationCreate) o;
    return Objects.equals(this.description, serviceTestSpecificationCreate.description) &&
        Objects.equals(this.isBundle, serviceTestSpecificationCreate.isBundle) &&
        Objects.equals(this.lastUpdate, serviceTestSpecificationCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceTestSpecificationCreate.lifecycleStatus) &&
        Objects.equals(this.name, serviceTestSpecificationCreate.name) &&
        Objects.equals(this.version, serviceTestSpecificationCreate.version) &&
        Objects.equals(this.attachment, serviceTestSpecificationCreate.attachment) &&
        Objects.equals(this.constraint, serviceTestSpecificationCreate.constraint) &&
        Objects.equals(this.entitySpecRelationship, serviceTestSpecificationCreate.entitySpecRelationship) &&
        Objects.equals(this.relatedParty, serviceTestSpecificationCreate.relatedParty) &&
        Objects.equals(this.relatedServiceSpecification, serviceTestSpecificationCreate.relatedServiceSpecification) &&
        Objects.equals(this.serviceTestSpecRelationship, serviceTestSpecificationCreate.serviceTestSpecRelationship) &&
        Objects.equals(this.specCharacteristic, serviceTestSpecificationCreate.specCharacteristic) &&
        Objects.equals(this.targetEntitySchema, serviceTestSpecificationCreate.targetEntitySchema) &&
        Objects.equals(this.testMeasureDefinition, serviceTestSpecificationCreate.testMeasureDefinition) &&
        Objects.equals(this.validFor, serviceTestSpecificationCreate.validFor) &&
        Objects.equals(this._atBaseType, serviceTestSpecificationCreate._atBaseType) &&
        Objects.equals(this._atSchemaLocation, serviceTestSpecificationCreate._atSchemaLocation) &&
        Objects.equals(this._atType, serviceTestSpecificationCreate._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, constraint, entitySpecRelationship, relatedParty, relatedServiceSpecification, serviceTestSpecRelationship, specCharacteristic, targetEntitySchema, testMeasureDefinition, validFor, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestSpecificationCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
    sb.append("    entitySpecRelationship: ").append(toIndentedString(entitySpecRelationship)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    relatedServiceSpecification: ").append(toIndentedString(relatedServiceSpecification)).append("\n");
    sb.append("    serviceTestSpecRelationship: ").append(toIndentedString(serviceTestSpecRelationship)).append("\n");
    sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
    sb.append("    targetEntitySchema: ").append(toIndentedString(targetEntitySchema)).append("\n");
    sb.append("    testMeasureDefinition: ").append(toIndentedString(testMeasureDefinition)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
