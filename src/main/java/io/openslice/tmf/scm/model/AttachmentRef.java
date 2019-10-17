package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Attachment reference. An attachment complements the description of an element
 * (for instance a product) through video, pictures
 */
@ApiModel(description = "Attachment reference. An attachment complements the description of an element (for instance a product) through video, pictures")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "AttachmentRef")
public class AttachmentRef {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;

	@JsonProperty("id")
	protected String id = null;
	
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("url")
	private String url = null;
	

	@JsonProperty("href")
	protected String href = null;

	@JsonProperty("@referredType")
	private String referredType = null;
	
	@JsonProperty("@baseType")
	protected String baseType = "BaseEntity";

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;
	

	@JsonProperty("@type")
	protected String type = null;

	public AttachmentRef() {
	}

	
	public AttachmentRef(AttachmentRef src) {
		description = src.description;
		url = src.url;
		id = src.id;
	}

	public AttachmentRef description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative text describing the content of the attachment
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A narrative text describing the content of the attachment")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AttachmentRef url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * Link to the attachment media/content
	 * 
	 * @return url
	 **/
	@ApiModelProperty(value = "Link to the attachment media/content")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AttachmentRef referredType(String referredType) {
		this.referredType = referredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
	 * @return referredType
	 **/
	@ApiModelProperty(value = "The actual type of the target instance when needed for disambiguation.")

	public String getReferredType() {
		return referredType;
	}

	public void setReferredType(String referredType) {
		this.referredType = referredType;
	}
	
	
	

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the baseType
	 */
	public String getBaseType() {
		return baseType;
	}

	/**
	 * @param baseType the baseType to set
	 */
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	/**
	 * @return the schemaLocation
	 */
	public String getSchemaLocation() {
		return schemaLocation;
	}

	/**
	 * @param schemaLocation the schemaLocation to set
	 */
	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AttachmentRef attachmentRef = (AttachmentRef) o;
		return Objects.equals(this.id, attachmentRef.id) && Objects.equals(this.href, attachmentRef.href)
				&& Objects.equals(this.description, attachmentRef.description)
				&& Objects.equals(this.url, attachmentRef.url) && Objects.equals(this.baseType, attachmentRef.baseType)
				&& Objects.equals(this.schemaLocation, attachmentRef.schemaLocation)
				&& Objects.equals(this.type, attachmentRef.type)
				&& Objects.equals(this.referredType, attachmentRef.referredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, description, url, baseType, schemaLocation, type, referredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AttachmentRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
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
