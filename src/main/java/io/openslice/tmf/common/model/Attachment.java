/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.common.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.validation.Valid;

/**
 * Complements the description of an element (for instance a product) through
 * video, pictures...
 */
@Schema(description = "Complements the description of an element (for instance a product) through video, pictures...")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity(name = "Attachment")
public class Attachment extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("attachmentType")
	private String attachmentType = null;

	@Lob
	@Column(name = "LCONTENT", columnDefinition = "LONGTEXT")
	@JsonProperty("content")
	private String content = null;

	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("mimeType")
	private String mimeType = null;

	@JsonProperty("url")
	private String url = null;

	@JsonProperty("size")
	private Quantity size = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	/**
	 * Unique identifier for this particular attachment
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier for this particular attachment")

	/**
	 * @return the id
	 */
	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public Attachment attachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
		return this;
	}

	/**
	 * Attachment type such as video, picture
	 * 
	 * @return attachmentType
	 **/
	@Schema(description = "Attachment type such as video, picture")

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public Attachment content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The actual contents of the attachment object, if embedded, encoded as base64
	 * 
	 * @return content
	 **/
	@Schema(description = "The actual contents of the attachment object, if embedded, encoded as base64")

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Attachment description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative text describing the content of the attachment
	 * 
	 * @return description
	 **/
	@Schema(description = "A narrative text describing the content of the attachment")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Attachment mimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	/**
	 * Attachment mime type such as extension file for video, picture and document
	 * 
	 * @return mimeType
	 **/
	@Schema(description = "Attachment mime type such as extension file for video, picture and document")

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Attachment url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * Uniform Resource Locator, is a web page address (a subset of URI)
	 * 
	 * @return url
	 **/
	@Schema(description = "Uniform Resource Locator, is a web page address (a subset of URI)")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Attachment size(Quantity size) {
		this.size = size;
		return this;
	}

	/**
	 * The size of the attachment.
	 * 
	 * @return size
	 **/
	@Schema(description = "The size of the attachment.")

	@Valid

	public Quantity getSize() {
		return size;
	}

	public void setSize(Quantity size) {
		this.size = size;
	}

	public Attachment validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period of time for which the attachment is valid
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The period of time for which the attachment is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Attachment attachment = (Attachment) o;
		return Objects.equals(this.id, attachment.id) && Objects.equals(this.uuid, attachment.uuid)
				&& Objects.equals(this.href, attachment.href)
				&& Objects.equals(this.attachmentType, attachment.attachmentType)
				&& Objects.equals(this.content, attachment.content)
				&& Objects.equals(this.description, attachment.description)
				&& Objects.equals(this.mimeType, attachment.mimeType) && Objects.equals(this.name, attachment.name)
				&& Objects.equals(this.url, attachment.url) && Objects.equals(this.size, attachment.size)
				&& Objects.equals(this.validFor, attachment.validFor)
				&& Objects.equals(this.baseType, attachment.baseType)
				&& Objects.equals(this.schemaLocation, attachment.schemaLocation)
				&& Objects.equals(this.type, attachment.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, id, href, attachmentType, content, description, mimeType, name, url, size, validFor,
				baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Attachment {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    attachmentType: ").append(toIndentedString(attachmentType)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
		sb.append("    size: ").append(toIndentedString(size)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
