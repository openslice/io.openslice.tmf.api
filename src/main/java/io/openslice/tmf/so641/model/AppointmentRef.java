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
 * Refers an appointment, such as a Customer presentation or internal meeting or site visit
 */
@ApiModel(description = "Refers an appointment, such as a Customer presentation or internal meeting or site visit")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")
@Entity(name = "AppointmentRef")
public class AppointmentRef extends BaseRootEntity  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("description")
  private String description = null;


  @JsonProperty("@referredType")
  private String referredType = null;

  /**
   * The identifier of the referred appointment
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The identifier of the referred appointment")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public AppointmentRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explanatory text regarding the appointment made with a party
   * @return description
  **/
  @ApiModelProperty(value = "An explanatory text regarding the appointment made with a party")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  /**
   * The actual type of the target instance when needed for disambiguation
   * @return referredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation")


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
    AppointmentRef appointmentRef = (AppointmentRef) o;
    return Objects.equals(this.id, appointmentRef.id) &&
        Objects.equals(this.href, appointmentRef.href) &&
        Objects.equals(this.description, appointmentRef.description) &&
        Objects.equals(this.baseType, appointmentRef.baseType) &&
        Objects.equals(this.schemaLocation, appointmentRef.schemaLocation) &&
        Objects.equals(this.type, appointmentRef.type) &&
        Objects.equals(this.referredType, appointmentRef.referredType);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, description, baseType, schemaLocation, type, referredType);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppointmentRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

