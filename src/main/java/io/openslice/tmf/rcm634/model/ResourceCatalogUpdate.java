package io.openslice.tmf.rcm634.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The root entity for resource catalog management. A resource catalog is a group of resource specifications made available through resource candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers). Skipped properties: id,href,id,href
 */
@ApiModel(description = "The root entity for resource catalog management. A resource catalog is a group of resource specifications made available through resource candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers). Skipped properties: id,href,id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceCatalogUpdate   {
  @JsonProperty("name")
protected String name = null;

  @JsonProperty("description")
  protected String description = null;

  @JsonProperty("@type")
  protected String type = null;

  @JsonProperty("@schemaLocation")
  protected String schemaLocation = null;

  @JsonProperty("@baseType")
  protected String baseType = null;

  @JsonProperty("version")
  protected String version = null;

  @JsonProperty("validFor")
  protected TimePeriod validFor = null;

  @JsonProperty("lastUpdate")
  protected OffsetDateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  protected String lifecycleStatus = null;

  @JsonProperty("relatedParty")
  @Valid
  protected List<RelatedParty> relatedParty = null;

  @JsonProperty("category")
  @Valid
  protected List<ResourceCategoryRef> category = null;

  public ResourceCatalogUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the catalog
   * @return name
  **/
  @ApiModelProperty(value = "Name of the catalog")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceCatalogUpdate description(String description) {
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

  public ResourceCatalogUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the (class) type of catalog. For resource catalogs, this will be 'ResourceCatalog'.
   * @return type
  **/
  @ApiModelProperty(value = "Indicates the (class) type of catalog. For resource catalogs, this will be 'ResourceCatalog'.")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceCatalogUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing this REST resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing this REST resource")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ResourceCatalogUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Indicates<b> </b>the base (class) type of this REST resource
   * @return baseType
  **/
  @ApiModelProperty(value = "Indicates<b> </b>the base (class) type of this REST resource")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceCatalogUpdate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Catalog version
   * @return version
  **/
  @ApiModelProperty(value = "Catalog version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ResourceCatalogUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the catalog is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the catalog is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ResourceCatalogUpdate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ResourceCatalogUpdate lifecycleStatus(String lifecycleStatus) {
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

  public ResourceCatalogUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceCatalogUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ResourceCatalogUpdate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCatalogUpdate addCategoryItem(ResourceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ResourceCategoryRef> category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceCatalogUpdate resourceCatalogUpdate = (ResourceCatalogUpdate) o;
    return Objects.equals(this.name, resourceCatalogUpdate.name) &&
        Objects.equals(this.description, resourceCatalogUpdate.description) &&
        Objects.equals(this.type, resourceCatalogUpdate.type) &&
        Objects.equals(this.schemaLocation, resourceCatalogUpdate.schemaLocation) &&
        Objects.equals(this.baseType, resourceCatalogUpdate.baseType) &&
        Objects.equals(this.version, resourceCatalogUpdate.version) &&
        Objects.equals(this.validFor, resourceCatalogUpdate.validFor) &&
        Objects.equals(this.lastUpdate, resourceCatalogUpdate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCatalogUpdate.lifecycleStatus) &&
        Objects.equals(this.relatedParty, resourceCatalogUpdate.relatedParty) &&
        Objects.equals(this.category, resourceCatalogUpdate.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate, lifecycleStatus, relatedParty, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCatalogUpdate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

