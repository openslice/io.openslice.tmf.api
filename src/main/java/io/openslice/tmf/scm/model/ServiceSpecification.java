package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.AttachmentRef;
import io.openslice.tmf.scm.model.RelatedParty;
import io.openslice.tmf.scm.model.ResourceSpecificationRef;
import io.openslice.tmf.scm.model.ServiceLevelSpecificationRef;
import io.openslice.tmf.scm.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm.model.ServiceSpecRelationship;
import io.openslice.tmf.scm.model.TargetServiceSchema;
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
 * ServiceSpecification is a class that offers characteristics to describe a type of service. Functionally, it acts as a template by which Services may be instantiated. By sharing the same  specification, these services would therefore share the same set of characteristics.
 */
@ApiModel(description = "ServiceSpecification is a class that offers characteristics to describe a type of service. Functionally, it acts as a template by which Services may be instantiated. By sharing the same  specification, these services would therefore share the same set of characteristics.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceSpecification   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

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

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("attachment")
  @Valid
  private List<AttachmentRef> attachment = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("resourceSpecification")
  @Valid
  private List<ResourceSpecificationRef> resourceSpecification = null;

  @JsonProperty("serviceLevelSpecification")
  @Valid
  private List<ServiceLevelSpecificationRef> serviceLevelSpecification = null;

  @JsonProperty("serviceSpecCharacteristic")
  @Valid
  private List<ServiceSpecCharacteristic> serviceSpecCharacteristic = null;

  @JsonProperty("serviceSpecRelationship")
  @Valid
  private List<ServiceSpecRelationship> serviceSpecRelationship = null;

  @JsonProperty("targetServiceSchema")
  private TargetServiceSchema targetServiceSchema = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  public ServiceSpecification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the service specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the service specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceSpecification href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the service specification
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the service specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceSpecification description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the service specification is
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains in detail what the service specification is")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceSpecification isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * isBundle determines whether a ServiceSpecification represents a single ServiceSpecification (false), or a bundle of ServiceSpecification (true).
   * @return isBundle
  **/
  @ApiModelProperty(value = "isBundle determines whether a ServiceSpecification represents a single ServiceSpecification (false), or a bundle of ServiceSpecification (true).")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ServiceSpecification lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update of the service specification
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date and time of the last update of the service specification")

  @Valid

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ServiceSpecification lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the service specification
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Used to indicate the current lifecycle status of the service specification")


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ServiceSpecification name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the service specification
   * @return name
  **/
  @ApiModelProperty(value = "Name of the service specification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceSpecification version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Service specification version
   * @return version
  **/
  @ApiModelProperty(value = "Service specification version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ServiceSpecification attachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ServiceSpecification addAttachmentItem(AttachmentRef attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<AttachmentRef>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * A list of attachments (Attachment [*]). Complements the description of the specification through video, pictures...
   * @return attachment
  **/
  @ApiModelProperty(value = "A list of attachments (Attachment [*]). Complements the description of the specification through video, pictures...")

  @Valid

  public List<AttachmentRef> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
  }

  public ServiceSpecification relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ServiceSpecification addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * A list of related party references (RelatedParty [*]). A related party defines party or party role linked to a specific entity.
   * @return relatedParty
  **/
  @ApiModelProperty(value = "A list of related party references (RelatedParty [*]). A related party defines party or party role linked to a specific entity.")

  @Valid

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ServiceSpecification resourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  public ServiceSpecification addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
    if (this.resourceSpecification == null) {
      this.resourceSpecification = new ArrayList<ResourceSpecificationRef>();
    }
    this.resourceSpecification.add(resourceSpecificationItem);
    return this;
  }

  /**
   * A list of resource specification references (ResourceSpecificationRef [*]). The ResourceSpecification is required for a service specification with type ResourceFacingServiceSpecification (RFSS).
   * @return resourceSpecification
  **/
  @ApiModelProperty(value = "A list of resource specification references (ResourceSpecificationRef [*]). The ResourceSpecification is required for a service specification with type ResourceFacingServiceSpecification (RFSS).")

  @Valid

  public List<ResourceSpecificationRef> getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ServiceSpecification serviceLevelSpecification(List<ServiceLevelSpecificationRef> serviceLevelSpecification) {
    this.serviceLevelSpecification = serviceLevelSpecification;
    return this;
  }

  public ServiceSpecification addServiceLevelSpecificationItem(ServiceLevelSpecificationRef serviceLevelSpecificationItem) {
    if (this.serviceLevelSpecification == null) {
      this.serviceLevelSpecification = new ArrayList<ServiceLevelSpecificationRef>();
    }
    this.serviceLevelSpecification.add(serviceLevelSpecificationItem);
    return this;
  }

  /**
   * A list of service level specifications related to this service specification, and which will need to be satisifiable for corresponding service instances; e.g. Gold, Platinum
   * @return serviceLevelSpecification
  **/
  @ApiModelProperty(value = "A list of service level specifications related to this service specification, and which will need to be satisifiable for corresponding service instances; e.g. Gold, Platinum")

  @Valid

  public List<ServiceLevelSpecificationRef> getServiceLevelSpecification() {
    return serviceLevelSpecification;
  }

  public void setServiceLevelSpecification(List<ServiceLevelSpecificationRef> serviceLevelSpecification) {
    this.serviceLevelSpecification = serviceLevelSpecification;
  }

  public ServiceSpecification serviceSpecCharacteristic(List<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
    this.serviceSpecCharacteristic = serviceSpecCharacteristic;
    return this;
  }

  public ServiceSpecification addServiceSpecCharacteristicItem(ServiceSpecCharacteristic serviceSpecCharacteristicItem) {
    if (this.serviceSpecCharacteristic == null) {
      this.serviceSpecCharacteristic = new ArrayList<ServiceSpecCharacteristic>();
    }
    this.serviceSpecCharacteristic.add(serviceSpecCharacteristicItem);
    return this;
  }

  /**
   * A list of service spec characteristics (ServiceSpecCharacteristic [*]). This class represents the key features of this service specification.
   * @return serviceSpecCharacteristic
  **/
  @ApiModelProperty(value = "A list of service spec characteristics (ServiceSpecCharacteristic [*]). This class represents the key features of this service specification.")

  @Valid

  public List<ServiceSpecCharacteristic> getServiceSpecCharacteristic() {
    return serviceSpecCharacteristic;
  }

  public void setServiceSpecCharacteristic(List<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
    this.serviceSpecCharacteristic = serviceSpecCharacteristic;
  }

  public ServiceSpecification serviceSpecRelationship(List<ServiceSpecRelationship> serviceSpecRelationship) {
    this.serviceSpecRelationship = serviceSpecRelationship;
    return this;
  }

  public ServiceSpecification addServiceSpecRelationshipItem(ServiceSpecRelationship serviceSpecRelationshipItem) {
    if (this.serviceSpecRelationship == null) {
      this.serviceSpecRelationship = new ArrayList<ServiceSpecRelationship>();
    }
    this.serviceSpecRelationship.add(serviceSpecRelationshipItem);
    return this;
  }

  /**
   * A list of service specifications related to this specification, e.g. migration, substitution, dependency or exclusivity relationship
   * @return serviceSpecRelationship
  **/
  @ApiModelProperty(value = "A list of service specifications related to this specification, e.g. migration, substitution, dependency or exclusivity relationship")

  @Valid

  public List<ServiceSpecRelationship> getServiceSpecRelationship() {
    return serviceSpecRelationship;
  }

  public void setServiceSpecRelationship(List<ServiceSpecRelationship> serviceSpecRelationship) {
    this.serviceSpecRelationship = serviceSpecRelationship;
  }

  public ServiceSpecification targetServiceSchema(TargetServiceSchema targetServiceSchema) {
    this.targetServiceSchema = targetServiceSchema;
    return this;
  }

  /**
   * A target service schema reference (TargetServiceSchemaRef). The reference object to the schema and type of target service which is described by service specification.
   * @return targetServiceSchema
  **/
  @ApiModelProperty(value = "A target service schema reference (TargetServiceSchemaRef). The reference object to the schema and type of target service which is described by service specification.")

  @Valid

  public TargetServiceSchema getTargetServiceSchema() {
    return targetServiceSchema;
  }

  public void setTargetServiceSchema(TargetServiceSchema targetServiceSchema) {
    this.targetServiceSchema = targetServiceSchema;
  }

  public ServiceSpecification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the service specification is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the service specification is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceSpecification baseType(String baseType) {
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

  public ServiceSpecification schemaLocation(String schemaLocation) {
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

  public ServiceSpecification type(String type) {
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
    ServiceSpecification serviceSpecification = (ServiceSpecification) o;
    return Objects.equals(this.id, serviceSpecification.id) &&
        Objects.equals(this.href, serviceSpecification.href) &&
        Objects.equals(this.description, serviceSpecification.description) &&
        Objects.equals(this.isBundle, serviceSpecification.isBundle) &&
        Objects.equals(this.lastUpdate, serviceSpecification.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceSpecification.lifecycleStatus) &&
        Objects.equals(this.name, serviceSpecification.name) &&
        Objects.equals(this.version, serviceSpecification.version) &&
        Objects.equals(this.attachment, serviceSpecification.attachment) &&
        Objects.equals(this.relatedParty, serviceSpecification.relatedParty) &&
        Objects.equals(this.resourceSpecification, serviceSpecification.resourceSpecification) &&
        Objects.equals(this.serviceLevelSpecification, serviceSpecification.serviceLevelSpecification) &&
        Objects.equals(this.serviceSpecCharacteristic, serviceSpecification.serviceSpecCharacteristic) &&
        Objects.equals(this.serviceSpecRelationship, serviceSpecification.serviceSpecRelationship) &&
        Objects.equals(this.targetServiceSchema, serviceSpecification.targetServiceSchema) &&
        Objects.equals(this.validFor, serviceSpecification.validFor) &&
        Objects.equals(this.baseType, serviceSpecification.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecification.schemaLocation) &&
        Objects.equals(this.type, serviceSpecification.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, relatedParty, resourceSpecification, serviceLevelSpecification, serviceSpecCharacteristic, serviceSpecRelationship, targetServiceSchema, validFor, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
    sb.append("    serviceLevelSpecification: ").append(toIndentedString(serviceLevelSpecification)).append("\n");
    sb.append("    serviceSpecCharacteristic: ").append(toIndentedString(serviceSpecCharacteristic)).append("\n");
    sb.append("    serviceSpecRelationship: ").append(toIndentedString(serviceSpecRelationship)).append("\n");
    sb.append("    targetServiceSchema: ").append(toIndentedString(targetServiceSchema)).append("\n");
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

