package io.openslice.tmf.so641.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Place reference. Place defines the places where the products are sold or delivered.
 */
@ApiModel(description = "Place reference. Place defines the places where the products are sold or delivered.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "Place")
public class Place extends BaseRootNamedEntity  {
	
  @JsonProperty("id")
  private String id = null;


  @JsonProperty("role")
  private String role = null;


  /**
   * Unique identifier of the place
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the place")


  public String getId() {
    return uuid;
  }

  /**
   * Role of the place, such as: [home delivery], [shop retrieval])
   * @return role
  **/
  @ApiModelProperty(value = "Role of the place, such as: [home delivery], [shop retrieval])")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Place place = (Place) o;
    return Objects.equals(this.id, place.id) &&
        Objects.equals(this.href, place.href) &&
        Objects.equals(this.name, place.name) &&
        Objects.equals(this.role, place.role) &&
        Objects.equals(this.baseType, place.baseType) &&
        Objects.equals(this.schemaLocation, place.schemaLocation) &&
        Objects.equals(this.type, place.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role, baseType, schemaLocation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Place {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

