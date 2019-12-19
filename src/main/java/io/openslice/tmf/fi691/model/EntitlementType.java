package io.openslice.tmf.fi691.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EntitlementType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

public class EntitlementType   {
  @JsonProperty("function")
  private String function = null;

  @JsonProperty("action")
  private String action = null;

  public EntitlementType function(String function) {
    this.function = function;
    return this;
  }

  /**
   * Get function
   * @return function
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public EntitlementType action(String action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntitlementType entitlementType = (EntitlementType) o;
    return Objects.equals(this.function, entitlementType.function) &&
        Objects.equals(this.action, entitlementType.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(function, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntitlementType {\n");
    
    sb.append("    function: ").append(toIndentedString(function)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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

