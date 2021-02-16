package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.UnGroupAlarms;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class UnGroupAlarmsStateChangeEventPayload   {
  @JsonProperty("unGroupAlarms")
  private UnGroupAlarms unGroupAlarms = null;

  public UnGroupAlarmsStateChangeEventPayload unGroupAlarms(UnGroupAlarms unGroupAlarms) {
    this.unGroupAlarms = unGroupAlarms;
    return this;
  }

  /**
   * Get unGroupAlarms
   * @return unGroupAlarms
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public UnGroupAlarms getUnGroupAlarms() {
    return unGroupAlarms;
  }

  public void setUnGroupAlarms(UnGroupAlarms unGroupAlarms) {
    this.unGroupAlarms = unGroupAlarms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnGroupAlarmsStateChangeEventPayload unGroupAlarmsStateChangeEventPayload = (UnGroupAlarmsStateChangeEventPayload) o;
    return Objects.equals(this.unGroupAlarms, unGroupAlarmsStateChangeEventPayload.unGroupAlarms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unGroupAlarms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnGroupAlarmsStateChangeEventPayload {\n");
    
    sb.append("    unGroupAlarms: ").append(toIndentedString(unGroupAlarms)).append("\n");
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
