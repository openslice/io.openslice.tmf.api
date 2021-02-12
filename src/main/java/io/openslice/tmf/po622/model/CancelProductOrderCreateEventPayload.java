package io.openslice.tmf.po622.model;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class CancelProductOrderCreateEventPayload   {
  @JsonProperty("cancelProductOrder")
  private CancelProductOrder cancelProductOrder = null;

  public CancelProductOrderCreateEventPayload cancelProductOrder(CancelProductOrder cancelProductOrder) {
    this.cancelProductOrder = cancelProductOrder;
    return this;
  }

  /**
   * Get cancelProductOrder
   * @return cancelProductOrder
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CancelProductOrder getCancelProductOrder() {
    return cancelProductOrder;
  }

  public void setCancelProductOrder(CancelProductOrder cancelProductOrder) {
    this.cancelProductOrder = cancelProductOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelProductOrderCreateEventPayload cancelProductOrderCreateEventPayload = (CancelProductOrderCreateEventPayload) o;
    return Objects.equals(this.cancelProductOrder, cancelProductOrderCreateEventPayload.cancelProductOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancelProductOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelProductOrderCreateEventPayload {\n");
    
    sb.append("    cancelProductOrder: ").append(toIndentedString(cancelProductOrder)).append("\n");
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
