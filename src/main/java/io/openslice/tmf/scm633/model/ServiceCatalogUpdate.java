package io.openslice.tmf.scm633.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.scm633.model.RelatedParty;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The root entity for service catalog management. A service catalog is a group of service specifications made available through service candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers).  A service catalog typically includes name, description and time period that is valid for. It will have a list of ServiceCandidate catalog items. A ServiceCandidate is an entity that makes a ServiceSpecification available to a catalog. A ServiceCandidate and its associated ServiceSpecification may be \&quot;published\&quot; - made visible -in any number of ServiceCatalogs, or in none. Skipped properties: id,href,lastUpdate
 */
@ApiModel(description = "The root entity for service catalog management. A service catalog is a group of service specifications made available through service candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers).  A service catalog typically includes name, description and time period that is valid for. It will have a list of ServiceCandidate catalog items. A ServiceCandidate is an entity that makes a ServiceSpecification available to a catalog. A ServiceCandidate and its associated ServiceSpecification may be \"published\" - made visible -in any number of ServiceCatalogs, or in none. Skipped properties: id,href,lastUpdate")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCatalogUpdate   {
  @JsonProperty("description")
protected String description = null;

  @JsonProperty("lifecycleStatus")
  protected String lifecycleStatus = null;

  @JsonProperty("name")
  protected String name = null;

  @JsonProperty("version")
  protected String version = null;

  @JsonProperty("category")
  @Valid
  protected List<ServiceCategoryRef> category = null;

  @JsonProperty("relatedParty")
  @Valid
  protected List<RelatedParty> relatedParty = null;

  @JsonProperty("validFor")
  protected TimePeriod validFor = null;

  @JsonProperty("@baseType")
  protected String baseType = null;

  @JsonProperty("@schemaLocation")
  protected String schemaLocation = null;

  @JsonProperty("@type")
  protected String type = null;

  public ServiceCatalogUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this catalog
   * @return description
  **/
  @ApiModelProperty(value = "Description of this catalog")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceCatalogUpdate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ServiceCatalogUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the service catalog
   * @return name
  **/
  @ApiModelProperty(value = "Name of the service catalog")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceCatalogUpdate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * ServiceCatalog version
   * @return version
  **/
  @ApiModelProperty(value = "ServiceCatalog version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ServiceCatalogUpdate category(List<ServiceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ServiceCatalogUpdate addCategoryItem(ServiceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ServiceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of service categories associated with this catalog
   * @return category
  **/
  @ApiModelProperty(value = "List of service categories associated with this catalog")

  @Valid

  public List<ServiceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ServiceCategoryRef> category) {
    this.category = category;
  }

  public ServiceCatalogUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ServiceCatalogUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * List of parties or party roles related to this category
   * @return relatedParty
  **/
  @ApiModelProperty(value = "List of parties or party roles related to this category")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ServiceCatalogUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the service catalog is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the service catalog is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceCatalogUpdate baseType(String baseType) {
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

  public ServiceCatalogUpdate schemaLocation(String schemaLocation) {
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

  public ServiceCatalogUpdate type(String type) {
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
    ServiceCatalogUpdate serviceCatalogUpdate = (ServiceCatalogUpdate) o;
    return Objects.equals(this.description, serviceCatalogUpdate.description) &&
        Objects.equals(this.lifecycleStatus, serviceCatalogUpdate.lifecycleStatus) &&
        Objects.equals(this.name, serviceCatalogUpdate.name) &&
        Objects.equals(this.version, serviceCatalogUpdate.version) &&
        Objects.equals(this.category, serviceCatalogUpdate.category) &&
        Objects.equals(this.relatedParty, serviceCatalogUpdate.relatedParty) &&
        Objects.equals(this.validFor, serviceCatalogUpdate.validFor) &&
        Objects.equals(this.baseType, serviceCatalogUpdate.baseType) &&
        Objects.equals(this.schemaLocation, serviceCatalogUpdate.schemaLocation) &&
        Objects.equals(this.type, serviceCatalogUpdate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, lifecycleStatus, name, version, category, relatedParty, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCatalogUpdate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

