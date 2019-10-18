package io.openslice.tmf.scm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.scm634.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.
 */
@ApiModel(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class ResourceSpecCharRelationship   {
  @JsonProperty("type")
  private String reltype = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  

  /**
 * @return the reltype
 */
public String getReltype() {
	return reltype;
}

/**
 * @param reltype the reltype to set
 */
public void setReltype(String reltype) {
	this.reltype = reltype;
}

public ResourceSpecCharRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the target characteristic
   * @return name
  **/
  @ApiModelProperty(value = "Name of the target characteristic")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecCharRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the target specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the target specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceSpecCharRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to the target specification
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to the target specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecCharRelationship type(String type) {
    this.type = type;
    return this;
  }

  /**
   * class type of target specification
   * @return type
  **/
  @ApiModelProperty(value = "class type of target specification")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecCharRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the object is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the object is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceSpecCharRelationship resourceSpecCharRelationship = (ResourceSpecCharRelationship) o;
    return Objects.equals(this.type, resourceSpecCharRelationship.type) &&
        Objects.equals(this.name, resourceSpecCharRelationship.name) &&
        Objects.equals(this.id, resourceSpecCharRelationship.id) &&
        Objects.equals(this.href, resourceSpecCharRelationship.href) &&
        Objects.equals(this.type, resourceSpecCharRelationship.type) &&
        Objects.equals(this.validFor, resourceSpecCharRelationship.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, id, href, type, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecCharRelationship {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

