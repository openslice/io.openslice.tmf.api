package io.openslice.tmf.sqm657.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.sqm657.model.ServiceLevelObjectiveRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications. Skipped properties: id,href,id,href,validFor
 */
@ApiModel(description = "A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications. Skipped properties: id,href,id,href,validFor")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelSpecificationUpdate   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("objective")
  @Valid
  private List<ServiceLevelObjectiveRef> objective = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public ServiceLevelSpecificationUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A brief introduction of a service level specification.
   * @return description
  **/
  @ApiModelProperty(value = "A brief introduction of a service level specification.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceLevelSpecificationUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of Service Level Specification
   * @return name
  **/
  @ApiModelProperty(value = "The name of Service Level Specification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceLevelSpecificationUpdate objective(List<ServiceLevelObjectiveRef> objective) {
    this.objective = objective;
    return this;
  }

  public ServiceLevelSpecificationUpdate addObjectiveItem(ServiceLevelObjectiveRef objectiveItem) {
    if (this.objective == null) {
      this.objective = new ArrayList<>();
    }
    this.objective.add(objectiveItem);
    return this;
  }

  /**
   * Get objective
   * @return objective
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ServiceLevelObjectiveRef> getObjective() {
    return objective;
  }

  public void setObjective(List<ServiceLevelObjectiveRef> objective) {
    this.objective = objective;
  }

  public ServiceLevelSpecificationUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of the actual resource (for type extension).
   * @return type
  **/
  @ApiModelProperty(value = "The class type of the actual resource (for type extension).")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ServiceLevelSpecificationUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A link to the schema describing a resource (for type extension).
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A link to the schema describing a resource (for type extension).")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ServiceLevelSpecificationUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The base type for use in polymorphic collections
   * @return baseType
  **/
  @ApiModelProperty(value = "The base type for use in polymorphic collections")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceLevelSpecificationUpdate serviceLevelSpecificationUpdate = (ServiceLevelSpecificationUpdate) o;
    return Objects.equals(this.description, serviceLevelSpecificationUpdate.description) &&
        Objects.equals(this.name, serviceLevelSpecificationUpdate.name) &&
        Objects.equals(this.objective, serviceLevelSpecificationUpdate.objective) &&
        Objects.equals(this.type, serviceLevelSpecificationUpdate.type) &&
        Objects.equals(this.schemaLocation, serviceLevelSpecificationUpdate.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelSpecificationUpdate.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, objective, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelSpecificationUpdate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    objective: ").append(toIndentedString(objective)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
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

