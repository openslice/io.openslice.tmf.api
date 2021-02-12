package io.openslice.tmf.po622.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * It&#x27;s a Quote item that has been executed previously.
 */
@ApiModel(description = "It's a Quote item that has been executed previously.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
public class QuoteItemRef   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("quoteHref")
  private String quoteHref = null;

  @JsonProperty("quoteId")
  private String quoteId = null;

  @JsonProperty("quoteName")
  private String quoteName = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  @JsonProperty("@referredType")
  private String _atReferredType = null;

  public QuoteItemRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of an item of a quote
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Id of an item of a quote")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public QuoteItemRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the related entity.")
  
    public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public QuoteItemRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the related entity.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public QuoteItemRef quoteHref(String quoteHref) {
    this.quoteHref = quoteHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return quoteHref
  **/
  @ApiModelProperty(value = "Reference of the related entity.")
  
    public String getQuoteHref() {
    return quoteHref;
  }

  public void setQuoteHref(String quoteHref) {
    this.quoteHref = quoteHref;
  }

  public QuoteItemRef quoteId(String quoteId) {
    this.quoteId = quoteId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return quoteId
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of a related entity.")
      @NotNull

    public String getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }

  public QuoteItemRef quoteName(String quoteName) {
    this.quoteName = quoteName;
    return this;
  }

  /**
   * Name of the related entity.
   * @return quoteName
  **/
  @ApiModelProperty(value = "Name of the related entity.")
  
    public String getQuoteName() {
    return quoteName;
  }

  public void setQuoteName(String quoteName) {
    this.quoteName = quoteName;
  }

  public QuoteItemRef _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public QuoteItemRef _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public QuoteItemRef _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }

  public QuoteItemRef _atReferredType(String _atReferredType) {
    this._atReferredType = _atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return _atReferredType
  **/
  @ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")
  
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
    QuoteItemRef quoteItemRef = (QuoteItemRef) o;
    return Objects.equals(this.id, quoteItemRef.id) &&
        Objects.equals(this.href, quoteItemRef.href) &&
        Objects.equals(this.name, quoteItemRef.name) &&
        Objects.equals(this.quoteHref, quoteItemRef.quoteHref) &&
        Objects.equals(this.quoteId, quoteItemRef.quoteId) &&
        Objects.equals(this.quoteName, quoteItemRef.quoteName) &&
        Objects.equals(this._atBaseType, quoteItemRef._atBaseType) &&
        Objects.equals(this._atSchemaLocation, quoteItemRef._atSchemaLocation) &&
        Objects.equals(this._atType, quoteItemRef._atType) &&
        Objects.equals(this._atReferredType, quoteItemRef._atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, quoteHref, quoteId, quoteName, _atBaseType, _atSchemaLocation, _atType, _atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteItemRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quoteHref: ").append(toIndentedString(quoteHref)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
    sb.append("    quoteName: ").append(toIndentedString(quoteName)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
