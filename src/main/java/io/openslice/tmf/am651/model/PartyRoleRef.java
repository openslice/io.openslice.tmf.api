package io.openslice.tmf.am651.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Party role reference. A party role represents the part played by a party in a given context.
 */
@ApiModel(description = "Party role reference. A party role represents the part played by a party in a given context.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:51:58.660+03:00")

public class PartyRoleRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("partyId")
  private String partyId = null;

  @JsonProperty("partyName")
  private String partyName = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public PartyRoleRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the product
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the product")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PartyRoleRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the product")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PartyRoleRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the referred party role.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the referred party role.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PartyRoleRef partyId(String partyId) {
    this.partyId = partyId;
    return this;
  }

  /**
   * The identifier of the engaged party that is linked to the PartyRole object.
   * @return partyId
  **/
  @ApiModelProperty(value = "The identifier of the engaged party that is linked to the PartyRole object.")


  public String getPartyId() {
    return partyId;
  }

  public void setPartyId(String partyId) {
    this.partyId = partyId;
  }

  public PartyRoleRef partyName(String partyName) {
    this.partyName = partyName;
    return this;
  }

  /**
   * The name of the engaged party that is linked to the PartyRole object.
   * @return partyName
  **/
  @ApiModelProperty(value = "The name of the engaged party that is linked to the PartyRole object.")


  public String getPartyName() {
    return partyName;
  }

  public void setPartyName(String partyName) {
    this.partyName = partyName;
  }

  public PartyRoleRef referredType(String referredType) {
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
    PartyRoleRef partyRoleRef = (PartyRoleRef) o;
    return Objects.equals(this.href, partyRoleRef.href) &&
        Objects.equals(this.id, partyRoleRef.id) &&
        Objects.equals(this.name, partyRoleRef.name) &&
        Objects.equals(this.partyId, partyRoleRef.partyId) &&
        Objects.equals(this.partyName, partyRoleRef.partyName) &&
        Objects.equals(this.referredType, partyRoleRef.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, partyId, partyName, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyRoleRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    partyName: ").append(toIndentedString(partyName)).append("\n");
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

