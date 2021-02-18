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
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am642.model.CommentAlarms;
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
public class CommentAlarmsStateChangeEventPayload   {
  @JsonProperty("commentAlarms")
  private CommentAlarms commentAlarms = null;

  public CommentAlarmsStateChangeEventPayload commentAlarms(CommentAlarms commentAlarms) {
    this.commentAlarms = commentAlarms;
    return this;
  }

  /**
   * Get commentAlarms
   * @return commentAlarms
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CommentAlarms getCommentAlarms() {
    return commentAlarms;
  }

  public void setCommentAlarms(CommentAlarms commentAlarms) {
    this.commentAlarms = commentAlarms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentAlarmsStateChangeEventPayload commentAlarmsStateChangeEventPayload = (CommentAlarmsStateChangeEventPayload) o;
    return Objects.equals(this.commentAlarms, commentAlarmsStateChangeEventPayload.commentAlarms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentAlarms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentAlarmsStateChangeEventPayload {\n");
    
    sb.append("    commentAlarms: ").append(toIndentedString(commentAlarms)).append("\n");
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
