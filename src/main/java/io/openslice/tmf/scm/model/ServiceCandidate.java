package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.ServiceSpecificationRef;
import io.openslice.tmf.scm.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServiceCandidate is an entity that makes a service specification available to a catalog. A ServiceCandidate and its associated service specification may be published - made visible - in any number of service catalogs, or in none. One service specification can be composed of other service specifications.
 */
@ApiModel(description = "ServiceCandidate is an entity that makes a service specification available to a catalog. A ServiceCandidate and its associated service specification may be published - made visible - in any number of service catalogs, or in none. One service specification can be composed of other service specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCandidate   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  private String lifecycleStatus = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("category")
  @Valid
  private List<ServiceCategoryRef> category = null;

  @JsonProperty("serviceSpecification")
  private ServiceSpecificationRef serviceSpecification = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ServiceCandidate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of this REST resource
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of this REST resource")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceCandidate href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to this REST resource
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to this REST resource")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceCandidate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this REST resource
   * @return description
  **/
  @ApiModelProperty(value = "Description of this REST resource")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceCandidate lastUpdate(OffsetDateTime lastUpdate) {
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

  public ServiceCandidate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the service candidate.
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status of the service candidate.")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ServiceCandidate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name given to this REST resource
   * @return name
  **/
  @ApiModelProperty(value = "Name given to this REST resource")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceCandidate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * the version of service candidate
   * @return version
  **/
  @ApiModelProperty(value = "the version of service candidate")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ServiceCandidate category(List<ServiceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ServiceCandidate addCategoryItem(ServiceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ServiceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of categories for this candidate
   * @return category
  **/
  @ApiModelProperty(value = "List of categories for this candidate")

  @Valid

  public List<ServiceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ServiceCategoryRef> category) {
    this.category = category;
  }

  public ServiceCandidate serviceSpecification(ServiceSpecificationRef serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }

  /**
   * The service specification implied by this candidate
   * @return serviceSpecification
  **/
  @ApiModelProperty(value = "The service specification implied by this candidate")

  @Valid

  public ServiceSpecificationRef getServiceSpecification() {
    return serviceSpecification;
  }

  public void setServiceSpecification(ServiceSpecificationRef serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
  }

  public ServiceCandidate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which this REST resource is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which this REST resource is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceCandidate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ServiceCandidate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ServiceCandidate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
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
    ServiceCandidate serviceCandidate = (ServiceCandidate) o;
    return Objects.equals(this.id, serviceCandidate.id) &&
        Objects.equals(this.href, serviceCandidate.href) &&
        Objects.equals(this.description, serviceCandidate.description) &&
        Objects.equals(this.lastUpdate, serviceCandidate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceCandidate.lifecycleStatus) &&
        Objects.equals(this.name, serviceCandidate.name) &&
        Objects.equals(this.version, serviceCandidate.version) &&
        Objects.equals(this.category, serviceCandidate.category) &&
        Objects.equals(this.serviceSpecification, serviceCandidate.serviceSpecification) &&
        Objects.equals(this.validFor, serviceCandidate.validFor) &&
        Objects.equals(this.baseType, serviceCandidate.baseType) &&
        Objects.equals(this.schemaLocation, serviceCandidate.schemaLocation) &&
        Objects.equals(this.type, serviceCandidate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, lastUpdate, lifecycleStatus, name, version, category, serviceSpecification, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCandidate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
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

