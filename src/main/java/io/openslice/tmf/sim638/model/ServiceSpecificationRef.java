package io.openslice.tmf.sim638.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.sim638.model.TargetServiceSchema;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Service specification reference: ServiceSpecification(s) required to realize a ProductSpecification.
 */
@ApiModel(description = "Service specification reference: ServiceSpecification(s) required to realize a ProductSpecification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")

public class ServiceSpecificationRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("targetServiceSchema")
  private TargetServiceSchema targetServiceSchema = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public ServiceSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the service specification
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the service specification")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceSpecificationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the serviceSpecification
   * @return href
  **/
  @ApiModelProperty(required = true, value = "Reference of the serviceSpecification")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the requiredServiceSpecification
   * @return name
  **/
  @ApiModelProperty(value = "Name of the requiredServiceSpecification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceSpecificationRef version(String version) {
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

  public ServiceSpecificationRef targetServiceSchema(TargetServiceSchema targetServiceSchema) {
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

  public ServiceSpecificationRef baseType(String baseType) {
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

  public ServiceSpecificationRef schemaLocation(String schemaLocation) {
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

  public ServiceSpecificationRef type(String type) {
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

  public ServiceSpecificationRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return referredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecificationRef serviceSpecificationRef = (ServiceSpecificationRef) o;
    return Objects.equals(this.id, serviceSpecificationRef.id) &&
        Objects.equals(this.href, serviceSpecificationRef.href) &&
        Objects.equals(this.name, serviceSpecificationRef.name) &&
        Objects.equals(this.version, serviceSpecificationRef.version) &&
        Objects.equals(this.targetServiceSchema, serviceSpecificationRef.targetServiceSchema) &&
        Objects.equals(this.baseType, serviceSpecificationRef.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecificationRef.schemaLocation) &&
        Objects.equals(this.type, serviceSpecificationRef.type) &&
        Objects.equals(this.referredType, serviceSpecificationRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, version, targetServiceSchema, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    targetServiceSchema: ").append(toIndentedString(targetServiceSchema)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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

