/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href,id,href,lastUpdate,@type
 */
@Schema(description = "This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href,id,href,lastUpdate,@type")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class PhysicalResourceSpecificationUpdate extends ResourceSpecificationUpdate  {
 

  @JsonProperty("model")
  protected String model = null;

  @JsonProperty("part")
  protected String part = null;

  @JsonProperty("sku")
  protected String sku = null;

  @JsonProperty("vendor")
  protected String vendor = null;



  /**
   * This is a string that represents a manufacturer-allocated number used to identify the general type and/or category of the hardware item. This, in combination with the Part and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is an optional attribute.
   * @return model
  **/
  @Schema(description = "This is a string that represents a manufacturer-allocated number used to identify the general type and/or category of the hardware item. This, in combination with the Part and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is an optional attribute.")


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public PhysicalResourceSpecificationUpdate part(String part) {
    this.part = part;
    return this;
  }

  /**
   * This is a string that defines a manufacturer-allocated part number assigned by the organization that manufactures the hardware item. This, in combination with the Model and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute.
   * @return part
  **/
  @Schema(description = "This is a string that defines a manufacturer-allocated part number assigned by the organization that manufactures the hardware item. This, in combination with the Model and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute.")


  public String getPart() {
    return part;
  }

  public void setPart(String part) {
    this.part = part;
  }

  public PhysicalResourceSpecificationUpdate sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * This is a string that defines the manufacturer-allocated Stock Keeping Unit (SKU) number of the hardware item. This is an optional attribute.
   * @return sku
  **/
  @Schema(description = "This is a string that defines the manufacturer-allocated Stock Keeping Unit (SKU) number of the hardware item. This is an optional attribute.")


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public PhysicalResourceSpecificationUpdate vendor(String vendor) {
    this.vendor = vendor;
    return this;
  }

  /**
   * This is a string that defines the name of the manufacturer. This, in combination with the Model and the Part, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute for a physical resource.
   * @return vendor
  **/
  @Schema(description = "This is a string that defines the name of the manufacturer. This, in combination with the Model and the Part, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute for a physical resource.")


  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalResourceSpecificationUpdate physicalResourceSpecUpdate = (PhysicalResourceSpecificationUpdate) o;
    return Objects.equals(this.name, physicalResourceSpecUpdate.name) &&
        Objects.equals(this.description, physicalResourceSpecUpdate.description) &&
        Objects.equals(this.schemaLocation, physicalResourceSpecUpdate.schemaLocation) &&
        Objects.equals(this.baseType, physicalResourceSpecUpdate.baseType) &&
        Objects.equals(this.version, physicalResourceSpecUpdate.version) &&
        Objects.equals(this.validFor, physicalResourceSpecUpdate.validFor) &&
        Objects.equals(this.lifecycleStatus, physicalResourceSpecUpdate.lifecycleStatus) &&
        Objects.equals(this.isBundle, physicalResourceSpecUpdate.isBundle) &&
        Objects.equals(this.category, physicalResourceSpecUpdate.category) &&
        Objects.equals(this.model, physicalResourceSpecUpdate.model) &&
        Objects.equals(this.part, physicalResourceSpecUpdate.part) &&
        Objects.equals(this.sku, physicalResourceSpecUpdate.sku) &&
        Objects.equals(this.vendor, physicalResourceSpecUpdate.vendor) &&
        Objects.equals(this.targetResourceSchema, physicalResourceSpecUpdate.targetResourceSchema) &&
        Objects.equals(this.featureSpecification, physicalResourceSpecUpdate.featureSpecification) &&
        Objects.equals(this.attachment, physicalResourceSpecUpdate.attachment) &&
        Objects.equals(this.relatedParty, physicalResourceSpecUpdate.relatedParty) &&
        Objects.equals(this.resourceSpecificationCharacteristic, physicalResourceSpecUpdate.resourceSpecificationCharacteristic) &&
        Objects.equals(this.resourceSpecificationRelationship, physicalResourceSpecUpdate.resourceSpecificationRelationship);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(name, description, _atSchemaLocation, _atBaseType, version, validFor, lifecycleStatus, isBundle, category, model, part, sku, vendor, place, targetResourceSchema, feature, attachment, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalResourceSpecUpdate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    part: ").append(toIndentedString(part)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
    sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
    sb.append("    featureSpecification: ").append(toIndentedString(featureSpecification)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecificationCharacteristic: ").append(toIndentedString(resourceSpecificationCharacteristic)).append("\n");
    sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecificationRelationship)).append("\n");
    sb.append("}");
    return sb.toString();
  }

 
}

