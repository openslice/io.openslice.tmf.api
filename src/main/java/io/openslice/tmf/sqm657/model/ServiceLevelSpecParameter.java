package io.openslice.tmf.sqm657.model;

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
 * Service Level Specification parameters can be one of two types. A Key Quality Indicator (KQI)  provides a measurement of a specific aspect of the performance of a Product (i.e., Product  Specification, Product Offering, or Product) or a Service (i.e., Service Specification or Service).
 */
@ApiModel(description = "Service Level Specification parameters can be one of two types. A Key Quality Indicator (KQI)  provides a measurement of a specific aspect of the performance of a Product (i.e., Product  Specification, Product Offering, or Product) or a Service (i.e., Service Specification or Service).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelSpecParameter   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("serviceParmCategory")
  private String serviceParmCategory = null;

  @JsonProperty("serviceParmPerspective")
  private String serviceParmPerspective = null;

  @JsonProperty("transformationAlgorithmOfKQI")
  private String transformationAlgorithmOfKQI = null;

  @JsonProperty("type")
  private String paramtype = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("relatedEntity")
  @Valid
  private List<EntityRef> relatedEntity = new ArrayList<>();

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  public ServiceLevelSpecParameter name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of parameter.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of parameter.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceLevelSpecParameter serviceParmCategory(String serviceParmCategory) {
    this.serviceParmCategory = serviceParmCategory;
    return this;
  }

  /**
   * A string that specifies whether the Service Level Specification Parameter is technology specific, service specific, or technology/service independent
   * @return serviceParmCategory
  **/
  @ApiModelProperty(value = "A string that specifies whether the Service Level Specification Parameter is technology specific, service specific, or technology/service independent")


  public String getServiceParmCategory() {
    return serviceParmCategory;
  }

  public void setServiceParmCategory(String serviceParmCategory) {
    this.serviceParmCategory = serviceParmCategory;
  }

  public ServiceLevelSpecParameter serviceParmPerspective(String serviceParmPerspective) {
    this.serviceParmPerspective = serviceParmPerspective;
    return this;
  }

  /**
   * A string that specifies whether the Service Level Specification  Parameter represents a single user instance parameter or a parameter that represents an aggregation.
   * @return serviceParmPerspective
  **/
  @ApiModelProperty(value = "A string that specifies whether the Service Level Specification  Parameter represents a single user instance parameter or a parameter that represents an aggregation.")


  public String getServiceParmPerspective() {
    return serviceParmPerspective;
  }

  public void setServiceParmPerspective(String serviceParmPerspective) {
    this.serviceParmPerspective = serviceParmPerspective;
  }

  public ServiceLevelSpecParameter transformationAlgorithmOfKQI(String transformationAlgorithmOfKQI) {
    this.transformationAlgorithmOfKQI = transformationAlgorithmOfKQI;
    return this;
  }

  /**
   * The description of a logical step-by-step procedure used to  calculate the value of a KQI.
   * @return transformationAlgorithmOfKQI
  **/
  @ApiModelProperty(value = "The description of a logical step-by-step procedure used to  calculate the value of a KQI.")


  public String getTransformationAlgorithmOfKQI() {
    return transformationAlgorithmOfKQI;
  }

  public void setTransformationAlgorithmOfKQI(String transformationAlgorithmOfKQI) {
    this.transformationAlgorithmOfKQI = transformationAlgorithmOfKQI;
  }

  public ServiceLevelSpecParameter paramtype(String type) {
    this.paramtype = type;
    return this;
  }

  /**
   * Types of Service Level Specification parameters are KQI or KPI.
   * @return type
  **/
  @ApiModelProperty(value = "Types of Service Level Specification parameters are KQI or KPI.")


  public String getParamtype() {
    return paramtype;
  }

  public void setParamtype(String type) {
    this.paramtype = type;
  }

  public ServiceLevelSpecParameter validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * A valid duration of a thing.
   * @return validFor
  **/
  @ApiModelProperty(value = "A valid duration of a thing.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceLevelSpecParameter relatedEntity(List<EntityRef> relatedEntity) {
    this.relatedEntity = relatedEntity;
    return this;
  }

  public ServiceLevelSpecParameter addRelatedEntityItem(EntityRef relatedEntityItem) {
    this.relatedEntity.add(relatedEntityItem);
    return this;
  }

  /**
   * Get relatedEntity
   * @return relatedEntity
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<EntityRef> getRelatedEntity() {
    return relatedEntity;
  }

  public void setRelatedEntity(List<EntityRef> relatedEntity) {
    this.relatedEntity = relatedEntity;
  }

  public ServiceLevelSpecParameter type(String type) {
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

  public ServiceLevelSpecParameter schemaLocation(String schemaLocation) {
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

  public ServiceLevelSpecParameter baseType(String baseType) {
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
    ServiceLevelSpecParameter serviceLevelSpecParameter = (ServiceLevelSpecParameter) o;
    return Objects.equals(this.name, serviceLevelSpecParameter.name) &&
        Objects.equals(this.serviceParmCategory, serviceLevelSpecParameter.serviceParmCategory) &&
        Objects.equals(this.serviceParmPerspective, serviceLevelSpecParameter.serviceParmPerspective) &&
        Objects.equals(this.transformationAlgorithmOfKQI, serviceLevelSpecParameter.transformationAlgorithmOfKQI) &&
        Objects.equals(this.type, serviceLevelSpecParameter.type) &&
        Objects.equals(this.validFor, serviceLevelSpecParameter.validFor) &&
        Objects.equals(this.relatedEntity, serviceLevelSpecParameter.relatedEntity) &&
        Objects.equals(this.type, serviceLevelSpecParameter.type) &&
        Objects.equals(this.schemaLocation, serviceLevelSpecParameter.schemaLocation) &&
        Objects.equals(this.baseType, serviceLevelSpecParameter.baseType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, serviceParmCategory, serviceParmPerspective, transformationAlgorithmOfKQI, type, validFor, relatedEntity, type, schemaLocation, baseType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelSpecParameter {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceParmCategory: ").append(toIndentedString(serviceParmCategory)).append("\n");
    sb.append("    serviceParmPerspective: ").append(toIndentedString(serviceParmPerspective)).append("\n");
    sb.append("    transformationAlgorithmOfKQI: ").append(toIndentedString(transformationAlgorithmOfKQI)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    relatedEntity: ").append(toIndentedString(relatedEntity)).append("\n");
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

