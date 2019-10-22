package io.openslice.tmf.am666.model;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

public class SettlementAccountStateChangeEventPayload   {
  @JsonProperty("settlementAccount")
  private SettlementAccount settlementAccount = null;

  public SettlementAccountStateChangeEventPayload settlementAccount(SettlementAccount settlementAccount) {
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
    SettlementAccountStateChangeEventPayload settlementAccountStateChangeEventPayload = (SettlementAccountStateChangeEventPayload) o;
    return Objects.equals(this.settlementAccount, settlementAccountStateChangeEventPayload.settlementAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(settlementAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettlementAccountStateChangeEventPayload {\n");
    
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

