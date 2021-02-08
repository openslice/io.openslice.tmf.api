package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Another Characteristic that is related to the current Characteristic;
 */
@ApiModel(description = "Another Characteristic that is related to the current Characteristic;")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class CharacteristicRelationship   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("relationshipType")
  private String relationshipType = null;

  public CharacteristicRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the characteristic
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the characteristic")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CharacteristicRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * The type of relationship
   * @return relationshipType
  **/
  @ApiModelProperty(value = "The type of relationship")
  
    public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacteristicRelationship characteristicRelationship = (CharacteristicRelationship) o;
    return Objects.equals(this.id, characteristicRelationship.id) &&
        Objects.equals(this.relationshipType, characteristicRelationship.relationshipType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, relationshipType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharacteristicRelationship {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
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
