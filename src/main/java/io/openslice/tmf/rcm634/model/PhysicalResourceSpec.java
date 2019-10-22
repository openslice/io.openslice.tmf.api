package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.rcm634.model.Attachment;
import io.openslice.tmf.rcm634.model.Feature;
import io.openslice.tmf.rcm634.model.PlaceRef;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecRelationship;
import io.openslice.tmf.rcm634.model.TargetResourceSchemaRef;
import io.openslice.tmf.rcm634.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource.
 */
@ApiModel(description = "This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class PhysicalResourceSpec extends ResourceSpecification  {
 

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("part")
  private String part = null;

  @JsonProperty("sku")
  private String sku = null;

  @JsonProperty("vendor")
  private String vendor = null;

  @JsonProperty("place")
  private PlaceRef place = null;

  

  public PhysicalResourceSpec id(String id) {
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

  public PhysicalResourceSpec href(String href) {
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

  public PhysicalResourceSpec name(String name) {
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

  public PhysicalResourceSpec description(String description) {
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

  public PhysicalResourceSpec type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Class type of this REST resource
   * @return type
  **/
  @ApiModelProperty(value = "Class type of this REST resource")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public PhysicalResourceSpec schemaLocation(String schemaLocation) {
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

  public PhysicalResourceSpec baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The (immediate) base class type of this REST resource
   * @return baseType
  **/
  @ApiModelProperty(value = "The (immediate) base class type of this REST resource")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public PhysicalResourceSpec version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Resource Specification version
   * @return version
  **/
  @ApiModelProperty(value = "Resource Specification version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  

  public PhysicalResourceSpec lastUpdate(OffsetDateTime lastUpdate) {
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

  public PhysicalResourceSpec lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the resource specification
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status of the resource specification")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }


  /**
   * This is a string that represents a manufacturer-allocated number used to identify the general type and/or category of the hardware item. This, in combination with the Part and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is an optional attribute.
   * @return model
  **/
  @ApiModelProperty(value = "This is a string that represents a manufacturer-allocated number used to identify the general type and/or category of the hardware item. This, in combination with the Part and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is an optional attribute.")


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public PhysicalResourceSpec part(String part) {
    this.part = part;
    return this;
  }

  /**
   * This is a string that defines a manufacturer-allocated part number assigned by the organization that manufactures the hardware item. This, in combination with the Model and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute.
   * @return part
  **/
  @ApiModelProperty(value = "This is a string that defines a manufacturer-allocated part number assigned by the organization that manufactures the hardware item. This, in combination with the Model and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute.")


  public String getPart() {
    return part;
  }

  public void setPart(String part) {
    this.part = part;
  }

  public PhysicalResourceSpec sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * This is a string that defines the manufacturer-allocated Stock Keeping Unit (SKU) number of the hardware item. This is an optional attribute.
   * @return sku
  **/
  @ApiModelProperty(value = "This is a string that defines the manufacturer-allocated Stock Keeping Unit (SKU) number of the hardware item. This is an optional attribute.")


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public PhysicalResourceSpec vendor(String vendor) {
    this.vendor = vendor;
    return this;
  }

  /**
   * This is a string that defines the name of the manufacturer. This, in combination with the Model and the Part, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute for a physical resource.
   * @return vendor
  **/
  @ApiModelProperty(value = "This is a string that defines the name of the manufacturer. This, in combination with the Model and the Part, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute for a physical resource.")


  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public PhysicalResourceSpec place(PlaceRef place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PlaceRef getPlace() {
    return place;
  }

  public void setPlace(PlaceRef place) {
    this.place = place;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalResourceSpec physicalResourceSpec = (PhysicalResourceSpec) o;
    return Objects.equals(this.id, physicalResourceSpec.id) &&
        Objects.equals(this.href, physicalResourceSpec.href) &&
        Objects.equals(this.name, physicalResourceSpec.name) &&
        Objects.equals(this.description, physicalResourceSpec.description) &&
        Objects.equals(this.type, physicalResourceSpec.type) &&
        Objects.equals(this.schemaLocation, physicalResourceSpec.schemaLocation) &&
        Objects.equals(this.baseType, physicalResourceSpec.baseType) &&
        Objects.equals(this.version, physicalResourceSpec.version) &&
        Objects.equals(this.validFor, physicalResourceSpec.validFor) &&
        Objects.equals(this.lastUpdate, physicalResourceSpec.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, physicalResourceSpec.lifecycleStatus) &&
        Objects.equals(this.isBundle, physicalResourceSpec.isBundle) &&
        Objects.equals(this.category, physicalResourceSpec.category) &&
        Objects.equals(this.model, physicalResourceSpec.model) &&
        Objects.equals(this.part, physicalResourceSpec.part) &&
        Objects.equals(this.sku, physicalResourceSpec.sku) &&
        Objects.equals(this.vendor, physicalResourceSpec.vendor) &&
        Objects.equals(this.place, physicalResourceSpec.place) &&
        Objects.equals(this.targetResourceSchema, physicalResourceSpec.targetResourceSchema) &&
        Objects.equals(this.feature, physicalResourceSpec.feature) &&
        Objects.equals(this.attachment, physicalResourceSpec.attachment) &&
        Objects.equals(this.relatedParty, physicalResourceSpec.relatedParty) &&
        Objects.equals(this.resourceSpecCharacteristic, physicalResourceSpec.resourceSpecCharacteristic) &&
        Objects.equals(this.resourceSpecRelationship, physicalResourceSpec.resourceSpecRelationship);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, description, type, schemaLocation, baseType, version, validFor, lastUpdate, lifecycleStatus, isBundle, category, model, part, sku, vendor, place, targetResourceSchema, feature, attachment, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalResourceSpec {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

