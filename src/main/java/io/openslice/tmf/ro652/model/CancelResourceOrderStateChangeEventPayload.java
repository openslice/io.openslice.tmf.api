package io.openslice.tmf.ro652.model;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class CancelResourceOrderStateChangeEventPayload   {
  @JsonProperty("cancelResourceOrder")
  private CancelResourceOrder cancelResourceOrder = null;

  public CancelResourceOrderStateChangeEventPayload cancelResourceOrder(CancelResourceOrder cancelResourceOrder) {
    this.cancelResourceOrder = cancelResourceOrder;
    return this;
  }

  /**
   * Get cancelResourceOrder
   * @return cancelResourceOrder
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CancelResourceOrder getCancelResourceOrder() {
    return cancelResourceOrder;
  }

  public void setCancelResourceOrder(CancelResourceOrder cancelResourceOrder) {
    this.cancelResourceOrder = cancelResourceOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelResourceOrderStateChangeEventPayload cancelResourceOrderStateChangeEventPayload = (CancelResourceOrderStateChangeEventPayload) o;
    return Objects.equals(this.cancelResourceOrder, cancelResourceOrderStateChangeEventPayload.cancelResourceOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancelResourceOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelResourceOrderStateChangeEventPayload {\n");
    
    sb.append("    cancelResourceOrder: ").append(toIndentedString(cancelResourceOrder)).append("\n");
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
