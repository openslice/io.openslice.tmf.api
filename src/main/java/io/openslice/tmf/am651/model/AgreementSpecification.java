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
package io.openslice.tmf.am651.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A template of an agreement that can be used when establishing partnerships.
 */
@ApiModel(description = "A template of an agreement that can be used when establishing partnerships.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementSpecification   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("lastUpdate")
  private OffsetDateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  private String lifecycleStatus = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("serviceCategory")
  private CategoryRef serviceCategory = null;

  @JsonProperty("specCharacteristic")
  @Valid
  private List<AgreementSpecCharacteristic> specCharacteristic = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedPartyRef> relatedParty = null;

  @JsonProperty("attachment")
  @Valid
  private List<AgreementAttachment> attachment = null;

  @JsonProperty("specificationRelationship")
  @Valid
  private List<AgreementSpecificationRelationship> specificationRelationship = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public AgreementSpecification description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the agreement specification is about.
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail what the agreement specification is about.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AgreementSpecification href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the agreement specification
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the agreement specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AgreementSpecification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the agreement specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the agreement specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AgreementSpecification isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * Indicates that this agreement specification is a grouping of other agreement specifications. The list of bundled agreement specifications is provided via the specificationRelationship property.
   * @return isBundle
  **/
  @ApiModelProperty(value = "Indicates that this agreement specification is a grouping of other agreement specifications. The list of bundled agreement specifications is provided via the specificationRelationship property.")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public AgreementSpecification lastUpdate(OffsetDateTime lastUpdate) {
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

  public AgreementSpecification lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Indicates the current lifecycle status
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Indicates the current lifecycle status")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public AgreementSpecification name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the agreement specification
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the agreement specification")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AgreementSpecification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the agreement specification is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the agreement specification is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public AgreementSpecification version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Agreement specification version
   * @return version
  **/
  @ApiModelProperty(value = "Agreement specification version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public AgreementSpecification serviceCategory(CategoryRef serviceCategory) {
    this.serviceCategory = serviceCategory;
    return this;
  }

  /**
   * Get serviceCategory
   * @return serviceCategory
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CategoryRef getServiceCategory() {
    return serviceCategory;
  }

  public void setServiceCategory(CategoryRef serviceCategory) {
    this.serviceCategory = serviceCategory;
  }

  public AgreementSpecification specCharacteristic(List<AgreementSpecCharacteristic> specCharacteristic) {
    this.specCharacteristic = specCharacteristic;
    return this;
  }

  public AgreementSpecification addSpecCharacteristicItem(AgreementSpecCharacteristic specCharacteristicItem) {
    if (this.specCharacteristic == null) {
      this.specCharacteristic = new ArrayList<>();
    }
    this.specCharacteristic.add(specCharacteristicItem);
    return this;
  }

  /**
   * Get specCharacteristic
   * @return specCharacteristic
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementSpecCharacteristic> getSpecCharacteristic() {
    return specCharacteristic;
  }

  public void setSpecCharacteristic(List<AgreementSpecCharacteristic> specCharacteristic) {
    this.specCharacteristic = specCharacteristic;
  }

  public AgreementSpecification relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public AgreementSpecification addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
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

  public List<RelatedPartyRef> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public AgreementSpecification attachment(List<AgreementAttachment> attachment) {
    this.attachment = attachment;
    return this;
  }

  public AgreementSpecification addAttachmentItem(AgreementAttachment attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementAttachment> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AgreementAttachment> attachment) {
    this.attachment = attachment;
  }

  public AgreementSpecification specificationRelationship(List<AgreementSpecificationRelationship> specificationRelationship) {
    this.specificationRelationship = specificationRelationship;
    return this;
  }

  public AgreementSpecification addSpecificationRelationshipItem(AgreementSpecificationRelationship specificationRelationshipItem) {
    if (this.specificationRelationship == null) {
      this.specificationRelationship = new ArrayList<>();
    }
    this.specificationRelationship.add(specificationRelationshipItem);
    return this;
  }

  /**
   * Get specificationRelationship
   * @return specificationRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AgreementSpecificationRelationship> getSpecificationRelationship() {
    return specificationRelationship;
  }

  public void setSpecificationRelationship(List<AgreementSpecificationRelationship> specificationRelationship) {
    this.specificationRelationship = specificationRelationship;
  }

  public AgreementSpecification type(String type) {
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

  public AgreementSpecification schemaLocation(String schemaLocation) {
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

  public AgreementSpecification baseType(String baseType) {
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
    AgreementSpecification agreementSpecification = (AgreementSpecification) o;
    return Objects.equals(this.description, agreementSpecification.description) &&
        Objects.equals(this.href, agreementSpecification.href) &&
        Objects.equals(this.id, agreementSpecification.id) &&
        Objects.equals(this.isBundle, agreementSpecification.isBundle) &&
        Objects.equals(this.lastUpdate, agreementSpecification.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, agreementSpecification.lifecycleStatus) &&
        Objects.equals(this.name, agreementSpecification.name) &&
        Objects.equals(this.validFor, agreementSpecification.validFor) &&
        Objects.equals(this.version, agreementSpecification.version) &&
        Objects.equals(this.serviceCategory, agreementSpecification.serviceCategory) &&
        Objects.equals(this.specCharacteristic, agreementSpecification.specCharacteristic) &&
        Objects.equals(this.relatedParty, agreementSpecification.relatedParty) &&
        Objects.equals(this.attachment, agreementSpecification.attachment) &&
        Objects.equals(this.specificationRelationship, agreementSpecification.specificationRelationship) &&
        Objects.equals(this.type, agreementSpecification.type) &&
        Objects.equals(this.schemaLocation, agreementSpecification.schemaLocation) &&
        Objects.equals(this.baseType, agreementSpecification.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, isBundle, lastUpdate, lifecycleStatus, name, validFor, version, serviceCategory, specCharacteristic, relatedParty, attachment, specificationRelationship, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementSpecification {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory)).append("\n");
    sb.append("    specCharacteristic: ").append(toIndentedString(specCharacteristic)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    specificationRelationship: ").append(toIndentedString(specificationRelationship)).append("\n");
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

