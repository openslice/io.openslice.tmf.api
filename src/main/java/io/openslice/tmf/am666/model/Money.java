package io.openslice.tmf.am666.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A base / value business entity used to represent money
 */
@ApiModel(description = "A base / value business entity used to represent money")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class Money   {
  @JsonProperty("unit")
  private String unit = null;

  @JsonProperty("value")
  private Float value = null;

  public Money unit(String unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Currency (ISO4217 norm uses 3 letters to define the currency)
   * @return unit
  **/
  @ApiModelProperty(value = "Currency (ISO4217 norm uses 3 letters to define the currency)")


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Money value(Float value) {
    this.value = value;
    return this;
  }

  /**
   * A positive floating point number
   * @return value
  **/
  @ApiModelProperty(value = "A positive floating point number")


  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return Objects.equals(this.unit, money.unit) &&
        Objects.equals(this.value, money.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unit, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Money {\n");
    
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

