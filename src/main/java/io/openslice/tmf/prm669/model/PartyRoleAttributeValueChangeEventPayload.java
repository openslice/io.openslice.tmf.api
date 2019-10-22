package io.openslice.tmf.prm669.model;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:20:50.154+03:00")

public class PartyRoleAttributeValueChangeEventPayload   {
  @JsonProperty("partyRole")
  private PartyRole partyRole = null;

  public PartyRoleAttributeValueChangeEventPayload partyRole(PartyRole partyRole) {
    this.partyRole = partyRole;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return partyRole
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public PartyRole getPartyRole() {
    return partyRole;
  }

  public void setPartyRole(PartyRole partyRole) {
    this.partyRole = partyRole;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartyRoleAttributeValueChangeEventPayload partyRoleAttributeValueChangeEventPayload = (PartyRoleAttributeValueChangeEventPayload) o;
    return Objects.equals(this.partyRole, partyRoleAttributeValueChangeEventPayload.partyRole);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyRole);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyRoleAttributeValueChangeEventPayload {\n");
    
    sb.append("    partyRole: ").append(toIndentedString(partyRole)).append("\n");
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

