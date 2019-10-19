package io.openslice.tmf.pm632.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class OrganizationAttributeValueChangeEventPayload   {
  @JsonProperty("organization")
  private Organization organization = null;

  public OrganizationAttributeValueChangeEventPayload organization(Organization organization) {
    this.organization = organization;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return organization
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationAttributeValueChangeEventPayload organizationAttributeValueChangeEventPayload = (OrganizationAttributeValueChangeEventPayload) o;
    return Objects.equals(this.organization, organizationAttributeValueChangeEventPayload.organization);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organization);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationAttributeValueChangeEventPayload {\n");
    
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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

