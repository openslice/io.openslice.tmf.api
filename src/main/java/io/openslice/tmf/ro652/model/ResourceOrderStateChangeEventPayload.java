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
public class ResourceOrderStateChangeEventPayload   {
  @JsonProperty("resourceOrder")
  private ResourceOrder resourceOrder = null;

  public ResourceOrderStateChangeEventPayload resourceOrder(ResourceOrder resourceOrder) {
    this.resourceOrder = resourceOrder;
    return this;
  }

  /**
   * Get resourceOrder
   * @return resourceOrder
  **/
  @Schema(description = "")
  
    @Valid
    public ResourceOrder getResourceOrder() {
    return resourceOrder;
  }

  public void setResourceOrder(ResourceOrder resourceOrder) {
    this.resourceOrder = resourceOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceOrderStateChangeEventPayload resourceOrderStateChangeEventPayload = (ResourceOrderStateChangeEventPayload) o;
    return Objects.equals(this.resourceOrder, resourceOrderStateChangeEventPayload.resourceOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceOrderStateChangeEventPayload {\n");
    
    sb.append("    resourceOrder: ").append(toIndentedString(resourceOrder)).append("\n");
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
