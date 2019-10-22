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
 * The root entity for resource catalog management. A resource catalog is a group of resource specifications made available through resource candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers). Skipped properties: id,href
 */
@ApiModel(description = "The root entity for resource catalog management. A resource catalog is a group of resource specifications made available through resource candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers). Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceCatalogCreate extends ResourceCatalogUpdate   {
  

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  
  @JsonProperty("category")
  @Valid
  private List<ResourceCategoryRef> category = null;


  public ResourceCatalogCreate lastUpdate(OffsetDateTime lastUpdate) {
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


  public ResourceCatalogCreate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCatalogCreate addCategoryItem(ResourceCategoryRef categoryItem) {
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
    ResourceCatalogCreate resourceCatalogCreate = (ResourceCatalogCreate) o;
    return Objects.equals(this.name, resourceCatalogCreate.name) &&
        Objects.equals(this.description, resourceCatalogCreate.description) &&
        Objects.equals(this.type, resourceCatalogCreate.type) &&
        Objects.equals(this.schemaLocation, resourceCatalogCreate.schemaLocation) &&
        Objects.equals(this.baseType, resourceCatalogCreate.baseType) &&
        Objects.equals(this.version, resourceCatalogCreate.version) &&
        Objects.equals(this.validFor, resourceCatalogCreate.validFor) &&
        Objects.equals(this.lastUpdate, resourceCatalogCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCatalogCreate.lifecycleStatus) &&
        Objects.equals(this.relatedParty, resourceCatalogCreate.relatedParty) &&
        Objects.equals(this.category, resourceCatalogCreate.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate, lifecycleStatus, relatedParty, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCatalogCreate {\n");
    
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

