package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.AckAlarms;
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
public class AckAlarmsCreateEventPayload   {
  @JsonProperty("ackAlarms")
  private AckAlarms ackAlarms = null;

  public AckAlarmsCreateEventPayload ackAlarms(AckAlarms ackAlarms) {
    this.ackAlarms = ackAlarms;
    return this;
  }

  /**
   * Get ackAlarms
   * @return ackAlarms
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public AckAlarms getAckAlarms() {
    return ackAlarms;
  }

  public void setAckAlarms(AckAlarms ackAlarms) {
    this.ackAlarms = ackAlarms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AckAlarmsCreateEventPayload ackAlarmsCreateEventPayload = (AckAlarmsCreateEventPayload) o;
    return Objects.equals(this.ackAlarms, ackAlarmsCreateEventPayload.ackAlarms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ackAlarms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AckAlarmsCreateEventPayload {\n");
    
    sb.append("    ackAlarms: ").append(toIndentedString(ackAlarms)).append("\n");
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
