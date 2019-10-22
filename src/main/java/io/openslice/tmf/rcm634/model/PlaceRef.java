package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Place reference. Place defines the places where the products are sold or delivered.
 */
@ApiModel(description = "Place reference. Place defines the places where the products are sold or delivered.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class PlaceRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("role")
  private String role = null;

  public PlaceRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the place
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the place")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PlaceRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the place
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the place")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PlaceRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A user-friendly name for the place, such as \"Paris Store\", \"London Store\", \"Main Home\"
   * @return name
  **/
  @ApiModelProperty(value = "A user-friendly name for the place, such as \"Paris Store\", \"London Store\", \"Main Home\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PlaceRef role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the place (for instance: 'home delivery', 'shop retrieval')
   * @return role
  **/
  @ApiModelProperty(value = "Role of the place (for instance: 'home delivery', 'shop retrieval')")


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
    PlaceRef placeRef = (PlaceRef) o;
    return Objects.equals(this.id, placeRef.id) &&
        Objects.equals(this.href, placeRef.href) &&
        Objects.equals(this.name, placeRef.name) &&
        Objects.equals(this.role, placeRef.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

