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
 * Linked service order to the one containing this attribute
 */
@ApiModel(description = "Linked service order to the one containing this attribute")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Entity(name = "ServiceOrderRelationship")
public class ServiceOrderRelationship  extends BaseRootEntity  {
  @JsonProperty("id")
  private String id = null;


  @JsonProperty("relationshipType")
  private String relationshipType = null;


  @JsonProperty("@referredType")
  private String referredType = null;

  public ServiceOrderRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the related order
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The id of the related order")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceOrderRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * The type of related order, such as: [dependency] if the order needs to be [not started] until another order item is complete (a service order in this case) or [cross-ref] to keep track of the source order (a productOrder)
   * @return relationshipType
  **/
  @ApiModelProperty(value = "The type of related order, such as: [dependency] if the order needs to be [not started] until another order item is complete (a service order in this case) or [cross-ref] to keep track of the source order (a productOrder)")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }


  /**
   * The entity type of the related order
   * @return referredType
  **/
  @ApiModelProperty(value = "The entity type of the related order")


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
    ServiceOrderRelationship serviceOrderRelationship = (ServiceOrderRelationship) o;
    return Objects.equals(this.id, serviceOrderRelationship.id) &&
        Objects.equals(this.href, serviceOrderRelationship.href) &&
        Objects.equals(this.relationshipType, serviceOrderRelationship.relationshipType) &&
        Objects.equals(this.baseType, serviceOrderRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceOrderRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceOrderRelationship.type) &&
        Objects.equals(this.referredType, serviceOrderRelationship.referredType);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, relationshipType, baseType, schemaLocation, type, referredType);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceOrderRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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

