package io.openslice.tmf.scm657.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A set of Service Level Objectives that are contained in the Service Level Specification.
 */
@ApiModel(description = "A set of Service Level Objectives that are contained in the Service Level Specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:14:31.369+03:00")

public class ServiceLevelObjectiveRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public ServiceLevelObjectiveRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The hyperlink to access a service level object.
   * @return href
  **/
  @ApiModelProperty(required = true, value = "The hyperlink to access a service level object.")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ServiceLevelObjectiveRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of a service level object.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The identifier of a service level object.")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceLevelObjectiveRef referredType(String referredType) {
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
    ServiceLevelObjectiveRef serviceLevelObjectiveRef = (ServiceLevelObjectiveRef) o;
    return Objects.equals(this.href, serviceLevelObjectiveRef.href) &&
        Objects.equals(this.id, serviceLevelObjectiveRef.id) &&
        Objects.equals(this.referredType, serviceLevelObjectiveRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelObjectiveRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

