package io.openslice.tmf.sac640.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.sac640.model.Monitor;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T12:42:32.118457300+03:00[Europe/Athens]")
public class MonitorStateChangeEvent   {
  @JsonProperty("monitor")
  private Monitor monitor = null;

  public MonitorStateChangeEvent monitor(Monitor monitor) {
    this.monitor = monitor;
    return this;
  }

  /**
   * Get monitor
   * @return monitor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Monitor getMonitor() {
    return monitor;
  }

  public void setMonitor(Monitor monitor) {
    this.monitor = monitor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorStateChangeEvent monitorStateChangeEvent = (MonitorStateChangeEvent) o;
    return Objects.equals(this.monitor, monitorStateChangeEvent.monitor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(monitor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitorStateChangeEvent {\n");
    
    sb.append("    monitor: ").append(toIndentedString(monitor)).append("\n");
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
