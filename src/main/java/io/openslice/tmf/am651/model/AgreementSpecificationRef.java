package io.openslice.tmf.am651.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AgreementSpecification reference. An AgreementSpecification represents a template of an agreement that can be used when establishing partnerships.
 */
@ApiModel(description = "AgreementSpecification reference. An AgreementSpecification represents a template of an agreement that can be used when establishing partnerships.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class AgreementSpecificationRef   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public AgreementSpecificationRef description(String description) {
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

  public AgreementSpecificationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference URL of the agreement specification
   * @return href
  **/
  @ApiModelProperty(value = "Reference URL of the agreement specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AgreementSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the agreement specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the agreement specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AgreementSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the agreement specification
   * @return name
  **/
  @ApiModelProperty(value = "Name of the agreement specification")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AgreementSpecificationRef referredType(String referredType) {
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
    AgreementSpecificationRef agreementSpecificationRef = (AgreementSpecificationRef) o;
    return Objects.equals(this.description, agreementSpecificationRef.description) &&
        Objects.equals(this.href, agreementSpecificationRef.href) &&
        Objects.equals(this.id, agreementSpecificationRef.id) &&
        Objects.equals(this.name, agreementSpecificationRef.name) &&
        Objects.equals(this.referredType, agreementSpecificationRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, name, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementSpecificationRef {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

