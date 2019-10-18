package io.openslice.tmf.scm657.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.scm657.model.ServiceLevelObjectiveRef;
import io.openslice.tmf.scm657.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications.
 */
@ApiModel(description = "A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelSpecification   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("objective")
  @Valid
  private List<ServiceLevelObjectiveRef> objective = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public ServiceLevelSpecification description(String description) {
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

  public ServiceLevelSpecification href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The hyperlink to access a service level specification.
   * @return href
  **/
  @ApiModelProperty(value = "The hyperlink to access a service level specification.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceLevelSpecification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier to a service level specification.
   * @return id
  **/
  @ApiModelProperty(value = "The identifier to a service level specification.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceLevelSpecification name(String name) {
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

  public ServiceLevelSpecification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * A valid duration of a thing.
   * @return validFor
  **/
  @ApiModelProperty(value = "A valid duration of a thing.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceLevelSpecification objective(List<ServiceLevelObjectiveRef> objective) {
    this.objective = objective;
    return this;
  }

  public ServiceLevelSpecification addObjectiveItem(ServiceLevelObjectiveRef objectiveItem) {
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

  public ServiceLevelSpecification type(String type) {
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

  public ServiceLevelSpecification schemaLocation(String schemaLocation) {
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

  public ServiceLevelSpecification baseType(String baseType) {
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
    ServiceLevelSpecification serviceLevelSpecification = (ServiceLevelSpecification) o;
    return Objects.equals(this.description, serviceLevelSpecification.description) &&
        Objects.equals(this.href, serviceLevelSpecification.href) &&
        Objects.equals(this.id, serviceLevelSpecification.id) &&
        Objects.equals(this.name, serviceLevelSpecification.name) &&
        Objects.equals(this.validFor, serviceLevelSpecification.validFor) &&
        Objects.equals(this.objective, serviceLevelSpecification.objective) &&
        Objects.equals(this.type, serviceLevelSpecification.type) &&
        Objects.equals(this.schemaLocation, serviceLevelSpecification.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelSpecification.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, name, validFor, objective, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelSpecification {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

