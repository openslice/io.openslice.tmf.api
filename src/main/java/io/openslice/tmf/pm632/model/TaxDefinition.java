package io.openslice.tmf.pm632.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reference of a tax definition. A tax is levied by an authorized tax jurisdiction. There are many different types of tax (Federal Tax levied by the US Government, State Tax levied by the State of California,…).
 */
@ApiModel(description = "Reference of a tax definition. A tax is levied by an authorized tax jurisdiction. There are many different types of tax (Federal Tax levied by the US Government, State Tax levied by the State of California,…).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

public class TaxDefinition   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("taxType")
  private String taxType = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  public TaxDefinition id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the tax.
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the tax.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TaxDefinition name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Tax name.
   * @return name
  **/
  @ApiModelProperty(value = "Tax name.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TaxDefinition taxType(String taxType) {
    this.taxType = taxType;
    return this;
  }

  /**
   * Type of  the tax.
   * @return taxType
  **/
  @ApiModelProperty(value = "Type of  the tax.")


  public String getTaxType() {
    return taxType;
  }

  public void setTaxType(String taxType) {
    this.taxType = taxType;
  }

  public TaxDefinition baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public TaxDefinition schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public TaxDefinition type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public TaxDefinition referredType(String referredType) {
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
    TaxDefinition taxDefinition = (TaxDefinition) o;
    return Objects.equals(this.id, taxDefinition.id) &&
        Objects.equals(this.name, taxDefinition.name) &&
        Objects.equals(this.taxType, taxDefinition.taxType) &&
        Objects.equals(this.baseType, taxDefinition.baseType) &&
        Objects.equals(this.schemaLocation, taxDefinition.schemaLocation) &&
        Objects.equals(this.type, taxDefinition.type) &&
        Objects.equals(this.referredType, taxDefinition.referredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, taxType, baseType, schemaLocation, type, referredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxDefinition {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    taxType: ").append(toIndentedString(taxType)).append("\n");
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

