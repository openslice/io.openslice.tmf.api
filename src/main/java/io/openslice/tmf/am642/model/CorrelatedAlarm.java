package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Indicates the alarms attached to this alarm as correlated alarms from a correlation point of view. An alarm can be correlated to one or more underlying alarms. There might be multiple levels of alarm correlation and an underlying alarm in one relation can be itself a parent alarm for other underlying alarms.
 */
@ApiModel(description = "Indicates the alarms attached to this alarm as correlated alarms from a correlation point of view. An alarm can be correlated to one or more underlying alarms. There might be multiple levels of alarm correlation and an underlying alarm in one relation can be itself a parent alarm for other underlying alarms.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T12:06:56.372977300+02:00[Europe/Athens]")
public class CorrelatedAlarm   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  public CorrelatedAlarm href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Get href
   * @return href
  **/
  @ApiModelProperty(value = "")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CorrelatedAlarm id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CorrelatedAlarm correlatedAlarm = (CorrelatedAlarm) o;
    return Objects.equals(this.href, correlatedAlarm.href) &&
        Objects.equals(this.id, correlatedAlarm.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CorrelatedAlarm {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
