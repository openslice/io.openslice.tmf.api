package io.openslice.tmf.am642.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Indicates the comments entered on the alarm.
 */
@ApiModel(description = "Indicates the comments entered on the alarm.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T12:06:56.372977300+02:00[Europe/Athens]")
public class Comments   {
  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("time")
  private OffsetDateTime time = null;

  @JsonProperty("systemId")
  private String systemId = null;

  @JsonProperty("comment")
  private String comment = null;

  public Comments userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Indicates the user commenting the alarm.
   * @return userId
  **/
  @ApiModelProperty(value = "Indicates the user commenting the alarm.")
  
    public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Comments time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Indicates the time commenting the alarm
   * @return time
  **/
  @ApiModelProperty(value = "Indicates the time commenting the alarm")
  
    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public Comments systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

  /**
   * Indicates the system identifier on which the client set the comment.
   * @return systemId
  **/
  @ApiModelProperty(value = "Indicates the system identifier on which the client set the comment.")
  
    public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public Comments comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Indicates the text of the comment.
   * @return comment
  **/
  @ApiModelProperty(value = "Indicates the text of the comment.")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comments comments = (Comments) o;
    return Objects.equals(this.userId, comments.userId) &&
        Objects.equals(this.time, comments.time) &&
        Objects.equals(this.systemId, comments.systemId) &&
        Objects.equals(this.comment, comments.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, time, systemId, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comments {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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
