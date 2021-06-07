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
package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
public class ExportJobStateChangeEventPayload   {
  @JsonProperty("exportJob")
  private ExportJob exportJob = null;

  public ExportJobStateChangeEventPayload exportJob(ExportJob exportJob) {
    this.exportJob = exportJob;
    return this;
  }

  /**
   * Get exportJob
   * @return exportJob
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExportJob getExportJob() {
    return exportJob;
  }

  public void setExportJob(ExportJob exportJob) {
    this.exportJob = exportJob;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExportJobStateChangeEventPayload exportJobStateChangeEventPayload = (ExportJobStateChangeEventPayload) o;
    return Objects.equals(this.exportJob, exportJobStateChangeEventPayload.exportJob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exportJob);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExportJobStateChangeEventPayload {\n");
    
    sb.append("    exportJob: ").append(toIndentedString(exportJob)).append("\n");
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
