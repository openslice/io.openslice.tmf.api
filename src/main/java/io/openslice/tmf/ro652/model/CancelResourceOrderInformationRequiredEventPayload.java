package io.openslice.tmf.ro652.model;

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
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
public class CancelResourceOrderInformationRequiredEventPayload   {
  @JsonProperty("cancelResourceOrder")
  private CancelResourceOrder cancelResourceOrder = null;

  public CancelResourceOrderInformationRequiredEventPayload cancelResourceOrder(CancelResourceOrder cancelResourceOrder) {
    this.cancelResourceOrder = cancelResourceOrder;
    return this;
  }

  /**
   * Get cancelResourceOrder
   * @return cancelResourceOrder
  **/
  @Schema(description = "")
  
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
    CancelResourceOrderInformationRequiredEventPayload cancelResourceOrderInformationRequiredEventPayload = (CancelResourceOrderInformationRequiredEventPayload) o;
    return Objects.equals(this.cancelResourceOrder, cancelResourceOrderInformationRequiredEventPayload.cancelResourceOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancelResourceOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelResourceOrderInformationRequiredEventPayload {\n");
    
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
