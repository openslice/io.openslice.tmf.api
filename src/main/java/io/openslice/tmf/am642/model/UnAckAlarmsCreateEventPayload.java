/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.am642.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * The event data structure
 */
@Schema(description = "The event data structure")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-15T11:15:47.327930400+02:00[Europe/Athens]")
public class UnAckAlarmsCreateEventPayload   {
  @JsonProperty("unAckAlarms")
  private UnAckAlarms unAckAlarms = null;

  public UnAckAlarmsCreateEventPayload unAckAlarms(UnAckAlarms unAckAlarms) {
    this.unAckAlarms = unAckAlarms;
    return this;
  }

  /**
   * Get unAckAlarms
   * @return unAckAlarms
  **/
  @Schema(description = "")
  
    @Valid
    public UnAckAlarms getUnAckAlarms() {
    return unAckAlarms;
  }

  public void setUnAckAlarms(UnAckAlarms unAckAlarms) {
    this.unAckAlarms = unAckAlarms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnAckAlarmsCreateEventPayload unAckAlarmsCreateEventPayload = (UnAckAlarmsCreateEventPayload) o;
    return Objects.equals(this.unAckAlarms, unAckAlarmsCreateEventPayload.unAckAlarms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unAckAlarms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnAckAlarmsCreateEventPayload {\n");
    
    sb.append("    unAckAlarms: ").append(toIndentedString(unAckAlarms)).append("\n");
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
