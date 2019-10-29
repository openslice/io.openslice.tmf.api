package io.openslice.tmf.so641.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Linked service order item to the one containing this attribute
 */
@ApiModel(description = "Linked service order item to the one containing this attribute")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "ServiceOrderItemRelationship")
public class ServiceOrderItemRelationship  extends BaseRootEntity {
	
	
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  public ServiceOrderItemRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a service order item
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of a service order item")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceOrderItemRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * The type of related order item, can be: dependency if the order item needs to be not started until another order item is complete
   * @return relationshipType
  **/
  @ApiModelProperty(required = true, value = "The type of related order item, can be: dependency if the order item needs to be not started until another order item is complete")
  @NotNull


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceOrderItemRelationship serviceOrderItemRelationship = (ServiceOrderItemRelationship) o;
    return Objects.equals(this.id, serviceOrderItemRelationship.id) &&
        Objects.equals(this.relationshipType, serviceOrderItemRelationship.relationshipType) &&
        Objects.equals(this.baseType, serviceOrderItemRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceOrderItemRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceOrderItemRelationship.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, relationshipType, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderItemRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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

