package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.GroupAlarms;
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
public class GroupAlarmsStateChangeEventPayload   {
  @JsonProperty("groupAlarms")
  private GroupAlarms groupAlarms = null;

  public GroupAlarmsStateChangeEventPayload groupAlarms(GroupAlarms groupAlarms) {
    this.groupAlarms = groupAlarms;
    return this;
  }

  /**
   * Get groupAlarms
   * @return groupAlarms
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public GroupAlarms getGroupAlarms() {
    return groupAlarms;
  }

  public void setGroupAlarms(GroupAlarms groupAlarms) {
    this.groupAlarms = groupAlarms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupAlarmsStateChangeEventPayload groupAlarmsStateChangeEventPayload = (GroupAlarmsStateChangeEventPayload) o;
    return Objects.equals(this.groupAlarms, groupAlarmsStateChangeEventPayload.groupAlarms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupAlarms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupAlarmsStateChangeEventPayload {\n");
    
    sb.append("    groupAlarms: ").append(toIndentedString(groupAlarms)).append("\n");
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
