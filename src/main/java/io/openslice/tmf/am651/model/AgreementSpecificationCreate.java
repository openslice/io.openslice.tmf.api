package io.openslice.tmf.am651.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am651.model.AgreementAttachment;
import io.openslice.tmf.am651.model.AgreementSpecCharacteristic;
import io.openslice.tmf.am651.model.AgreementSpecificationRelationship;
import io.openslice.tmf.am651.model.CategoryRef;
import io.openslice.tmf.am651.model.RelatedPartyRef;
import io.openslice.tmf.am651.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A template of an agreement that can be used when establishing partnerships. Skipped properties: id,href
 */
@ApiModel(description = "A template of an agreement that can be used when establishing partnerships. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementSpecificationCreate   {
  @JsonProperty("description")
  private String description = null;

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
  private List<AgreementAttachment> attachment = new ArrayList<>();

  @JsonProperty("specificationRelationship")
  @Valid
  private List<AgreementSpecificationRelationship> specificationRelationship = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public AgreementSpecificationCreate description(String description) {
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

  public AgreementSpecificationCreate isBundle(Boolean isBundle) {
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

  public AgreementSpecificationCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public AgreementSpecificationCreate lifecycleStatus(String lifecycleStatus) {
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

  public AgreementSpecificationCreate name(String name) {
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

  public AgreementSpecificationCreate validFor(TimePeriod validFor) {
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

  public AgreementSpecificationCreate version(String version) {
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

  public AgreementSpecificationCreate serviceCategory(CategoryRef serviceCategory) {
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

  public AgreementSpecificationCreate specCharacteristic(List<AgreementSpecCharacteristic> specCharacteristic) {
    this.specCharacteristic = specCharacteristic;
    return this;
  }

  public AgreementSpecificationCreate addSpecCharacteristicItem(AgreementSpecCharacteristic specCharacteristicItem) {
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

  public AgreementSpecificationCreate relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public AgreementSpecificationCreate addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
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

  public AgreementSpecificationCreate attachment(List<AgreementAttachment> attachment) {
    this.attachment = attachment;
    return this;
  }

  public AgreementSpecificationCreate addAttachmentItem(AgreementAttachment attachmentItem) {
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<AgreementAttachment> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AgreementAttachment> attachment) {
    this.attachment = attachment;
  }

  public AgreementSpecificationCreate specificationRelationship(List<AgreementSpecificationRelationship> specificationRelationship) {
    this.specificationRelationship = specificationRelationship;
    return this;
  }

  public AgreementSpecificationCreate addSpecificationRelationshipItem(AgreementSpecificationRelationship specificationRelationshipItem) {
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

  public AgreementSpecificationCreate type(String type) {
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

  public AgreementSpecificationCreate schemaLocation(String schemaLocation) {
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

  public AgreementSpecificationCreate baseType(String baseType) {
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
    AgreementSpecificationCreate agreementSpecificationCreate = (AgreementSpecificationCreate) o;
    return Objects.equals(this.description, agreementSpecificationCreate.description) &&
        Objects.equals(this.isBundle, agreementSpecificationCreate.isBundle) &&
        Objects.equals(this.lastUpdate, agreementSpecificationCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, agreementSpecificationCreate.lifecycleStatus) &&
        Objects.equals(this.name, agreementSpecificationCreate.name) &&
        Objects.equals(this.validFor, agreementSpecificationCreate.validFor) &&
        Objects.equals(this.version, agreementSpecificationCreate.version) &&
        Objects.equals(this.serviceCategory, agreementSpecificationCreate.serviceCategory) &&
        Objects.equals(this.specCharacteristic, agreementSpecificationCreate.specCharacteristic) &&
        Objects.equals(this.relatedParty, agreementSpecificationCreate.relatedParty) &&
        Objects.equals(this.attachment, agreementSpecificationCreate.attachment) &&
        Objects.equals(this.specificationRelationship, agreementSpecificationCreate.specificationRelationship) &&
        Objects.equals(this.type, agreementSpecificationCreate.type) &&
        Objects.equals(this.schemaLocation, agreementSpecificationCreate.schemaLocation) &&
        Objects.equals(this.baseType, agreementSpecificationCreate.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, isBundle, lastUpdate, lifecycleStatus, name, validFor, version, serviceCategory, specCharacteristic, relatedParty, attachment, specificationRelationship, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementSpecificationCreate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

