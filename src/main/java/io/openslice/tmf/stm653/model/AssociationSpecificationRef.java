package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * reference to an AssociationSpecification object
 */
@ApiModel(description = "reference to an AssociationSpecification object")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "STMAssociationSpecificationRef")
@Table(name = "STMAssociationSpecificationRef")
public class AssociationSpecificationRef  extends BaseRootNamedEntity {
  @JsonProperty("id")
  private String id = null;



  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public AssociationSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * unique identifier
   * @return id
  **/
  @ApiModelProperty(required = true, value = "unique identifier")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AssociationSpecificationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AssociationSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the related entity.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

 

  public AssociationSpecificationRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssociationSpecificationRef associationSpecificationRef = (AssociationSpecificationRef) o;
    return Objects.equals(this.id, associationSpecificationRef.id) &&
        Objects.equals(this.href, associationSpecificationRef.href) &&
        Objects.equals(this.name, associationSpecificationRef.name) &&
        Objects.equals(this.baseType, associationSpecificationRef.baseType) &&
        Objects.equals(this.schemaLocation, associationSpecificationRef.schemaLocation) &&
        Objects.equals(this.type, associationSpecificationRef.type) &&
        Objects.equals(this._atReferredType, associationSpecificationRef._atReferredType);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, name, baseType, schemaLocation, type, _atReferredType);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssociationSpecificationRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
