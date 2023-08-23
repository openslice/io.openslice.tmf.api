package io.openslice.tmf.rpm685.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Channel reference. The channel defines the channel for selling product offerings.
 */
@Schema(description = "Channel reference. The channel defines the channel for selling product offerings.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class ChannelRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public ChannelRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the channel
   * @return href
  **/
  @Schema(description = "Reference of the channel")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ChannelRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the channel
   * @return id
  **/
  @Schema(description = "Unique identifier of the channel")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChannelRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the channel
   * @return name
  **/
  @Schema(description = "Name of the channel")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ChannelRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @Schema(description = "The actual type of the target instance when needed for disambiguation.")
  
    public String getAtReferredType() {
    return _atReferredType;
  }

  public void setAtReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelRef channelRef = (ChannelRef) o;
    return Objects.equals(this.href, channelRef.href) &&
        Objects.equals(this.id, channelRef.id) &&
        Objects.equals(this.name, channelRef.name) &&
        Objects.equals(this._atReferredType, channelRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    _atReferredType: ").append(toIndentedString(_atReferredType)).append("\n");
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
