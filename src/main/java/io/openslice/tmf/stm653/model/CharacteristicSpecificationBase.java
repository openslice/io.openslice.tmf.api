package io.openslice.tmf.stm653.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class defines a characteristic specification.
 */
@ApiModel(description = "This class defines a characteristic specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class CharacteristicSpecificationBase   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("configurable")
  private Boolean configurable = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("extensible")
  private Boolean extensible = null;

  @JsonProperty("isUnique")
  private Boolean isUnique = null;

  @JsonProperty("maxCardinality")
  private Integer maxCardinality = null;

  @JsonProperty("minCardinality")
  private Integer minCardinality = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("regex")
  private String regex = null;

  @JsonProperty("valueType")
  private String valueType = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@valueSchemaLocation")
  private String _atValueSchemaLocation = null;

  public CharacteristicSpecificationBase id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique ID for the characteristic
   * @return id
  **/
  @ApiModelProperty(value = "Unique ID for the characteristic")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CharacteristicSpecificationBase configurable(Boolean configurable) {
    this.configurable = configurable;
    return this;
  }

  /**
   * If true, the Boolean indicates that the target Characteristic is configurable
   * @return configurable
  **/
  @ApiModelProperty(value = "If true, the Boolean indicates that the target Characteristic is configurable")
  
    public Boolean isConfigurable() {
    return configurable;
  }

  public void setConfigurable(Boolean configurable) {
    this.configurable = configurable;
  }

  public CharacteristicSpecificationBase description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains the CharacteristicSpecification.
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains the CharacteristicSpecification.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CharacteristicSpecificationBase extensible(Boolean extensible) {
    this.extensible = extensible;
    return this;
  }

  /**
   * An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.
   * @return extensible
  **/
  @ApiModelProperty(value = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.")
  
    public Boolean isExtensible() {
    return extensible;
  }

  public void setExtensible(Boolean extensible) {
    this.extensible = extensible;
  }

  public CharacteristicSpecificationBase isUnique(Boolean isUnique) {
    this.isUnique = isUnique;
    return this;
  }

  /**
   * An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"
   * @return isUnique
  **/
  @ApiModelProperty(value = "An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"")
  
    public Boolean isIsUnique() {
    return isUnique;
  }

  public void setIsUnique(Boolean isUnique) {
    this.isUnique = isUnique;
  }

  public CharacteristicSpecificationBase maxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
    return this;
  }

  /**
   * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
   * @return maxCardinality
  **/
  @ApiModelProperty(value = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.")
  
    public Integer getMaxCardinality() {
    return maxCardinality;
  }

  public void setMaxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
  }

  public CharacteristicSpecificationBase minCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
    return this;
  }

  /**
   * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
   * @return minCardinality
  **/
  @ApiModelProperty(value = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.")
  
    public Integer getMinCardinality() {
    return minCardinality;
  }

  public void setMinCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
  }

  public CharacteristicSpecificationBase name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.
   * @return name
  **/
  @ApiModelProperty(value = "A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CharacteristicSpecificationBase regex(String regex) {
    this.regex = regex;
    return this;
  }

  /**
   * A rule or principle represented in regular expression used to derive the value of a characteristic value.
   * @return regex
  **/
  @ApiModelProperty(value = "A rule or principle represented in regular expression used to derive the value of a characteristic value.")
  
    public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public CharacteristicSpecificationBase valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic can take on, such as numeric, text and so forth
   * @return valueType
  **/
  @ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text and so forth")
  
    public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public CharacteristicSpecificationBase validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public CharacteristicSpecificationBase baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return baseType;
  }

  public void setAtBaseType(String baseType) {
    this.baseType = baseType;
  }

  public CharacteristicSpecificationBase schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return schemaLocation;
  }

  public void setAtSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public CharacteristicSpecificationBase type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")
  
    public String getAtType() {
    return type;
  }

  public void setAtType(String type) {
    this.type = type;
  }

  public CharacteristicSpecificationBase _atValueSchemaLocation(String _atValueSchemaLocation) {
    this._atValueSchemaLocation = _atValueSchemaLocation;
    return this;
  }

  /**
   * This (optional) field provides a link to the schema describing the value type.
   * @return _atValueSchemaLocation
  **/
  @ApiModelProperty(value = "This (optional) field provides a link to the schema describing the value type.")
  
    public String getAtValueSchemaLocation() {
    return _atValueSchemaLocation;
  }

  public void setAtValueSchemaLocation(String _atValueSchemaLocation) {
    this._atValueSchemaLocation = _atValueSchemaLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacteristicSpecificationBase characteristicSpecificationBase = (CharacteristicSpecificationBase) o;
    return Objects.equals(this.id, characteristicSpecificationBase.id) &&
        Objects.equals(this.configurable, characteristicSpecificationBase.configurable) &&
        Objects.equals(this.description, characteristicSpecificationBase.description) &&
        Objects.equals(this.extensible, characteristicSpecificationBase.extensible) &&
        Objects.equals(this.isUnique, characteristicSpecificationBase.isUnique) &&
        Objects.equals(this.maxCardinality, characteristicSpecificationBase.maxCardinality) &&
        Objects.equals(this.minCardinality, characteristicSpecificationBase.minCardinality) &&
        Objects.equals(this.name, characteristicSpecificationBase.name) &&
        Objects.equals(this.regex, characteristicSpecificationBase.regex) &&
        Objects.equals(this.valueType, characteristicSpecificationBase.valueType) &&
        Objects.equals(this.validFor, characteristicSpecificationBase.validFor) &&
        Objects.equals(this.baseType, characteristicSpecificationBase.baseType) &&
        Objects.equals(this.schemaLocation, characteristicSpecificationBase.schemaLocation) &&
        Objects.equals(this.type, characteristicSpecificationBase.type) &&
        Objects.equals(this._atValueSchemaLocation, characteristicSpecificationBase._atValueSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, configurable, description, extensible, isUnique, maxCardinality, minCardinality, name, regex, valueType, validFor, baseType, schemaLocation, type, _atValueSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharacteristicSpecificationBase {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
    sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
    sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
    sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    _atValueSchemaLocation: ").append(toIndentedString(_atValueSchemaLocation)).append("\n");
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
