package io.openslice.tmf.am666.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.am666.model.SettlementAccount;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class SettlementAccountAttributeValueChangeEventPayload   {
  @JsonProperty("settlementAccount")
  private SettlementAccount settlementAccount = null;

  public SettlementAccountAttributeValueChangeEventPayload settlementAccount(SettlementAccount settlementAccount) {
    this.settlementAccount = settlementAccount;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return settlementAccount
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public SettlementAccount getSettlementAccount() {
    return settlementAccount;
  }

  public void setSettlementAccount(SettlementAccount settlementAccount) {
    this.settlementAccount = settlementAccount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettlementAccountAttributeValueChangeEventPayload settlementAccountAttributeValueChangeEventPayload = (SettlementAccountAttributeValueChangeEventPayload) o;
    return Objects.equals(this.settlementAccount, settlementAccountAttributeValueChangeEventPayload.settlementAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(settlementAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettlementAccountAttributeValueChangeEventPayload {\n");
    
    sb.append("    settlementAccount: ").append(toIndentedString(settlementAccount)).append("\n");
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

