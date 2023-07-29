/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * An attachment by value or by reference. An attachment complements the
 * description of an element, for example through a document, a video, a
 * picture.
 */
@Schema(description = "An attachment by value or by reference. An attachment complements the description of an element, for example through a document, a video, a picture.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
@Entity(name = "AttachmentRefOrValue")
@Table(name = "AttachmentRefOrValue")
public class AttachmentRefOrValue extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("attachmentType")
	private String attachmentType = null;

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

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	/**
	 * Unique identifier for this particular attachment
	 * 
	 * @return id
	 **/
	@Schema(example = "4aafacbd-11ff-4dc8-b445-305f2215715f", description = "Unique identifier for this particular attachment")

	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AttachmentRefOrValue attachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
		return this;
	}

	/**
	 * Attachment type such as video, picture
	 * 
	 * @return attachmentType
	 **/
	@Schema(example = "video", description = "Attachment type such as video, picture")

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public AttachmentRefOrValue content(String content) {
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

	public AttachmentRefOrValue description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative text describing the content of the attachment
	 * 
	 * @return description
	 **/
	@Schema(example = "Photograph of the Product", description = "A narrative text describing the content of the attachment")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AttachmentRefOrValue mimeType(String mimeType) {
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

	public AttachmentRefOrValue url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * Uniform Resource Locator, is a web page address (a subset of URI)
	 * 
	 * @return url
	 **/
	@Schema(example = "http://host/Content/4aafacbd-11ff-4dc8-b445-305f2215715f", description = "Uniform Resource Locator, is a web page address (a subset of URI)")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AttachmentRefOrValue size(Quantity size) {
		this.size = size;
		return this;
	}

	/**
	 * Get size
	 * 
	 * @return size
	 **/
	@Schema(description = "")

	@Valid
	public Quantity getSize() {
		return size;
	}

	public void setSize(Quantity size) {
		this.size = size;
	}

	public AttachmentRefOrValue validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@Schema(description = "")

	@Valid
	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public AttachmentRefOrValue _atReferredType(String _atReferredType) {
		this._atReferredType = _atReferredType;
		return this;
	}

	/**
	 * The actual type of the target instance when needed for disambiguation.
	 * 
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
		AttachmentRefOrValue attachmentRefOrValue = (AttachmentRefOrValue) o;
		return Objects.equals(this.id, attachmentRefOrValue.id) && Objects.equals(this.href, attachmentRefOrValue.href)
				&& Objects.equals(this.attachmentType, attachmentRefOrValue.attachmentType)
				&& Objects.equals(this.content, attachmentRefOrValue.content)
				&& Objects.equals(this.description, attachmentRefOrValue.description)
				&& Objects.equals(this.mimeType, attachmentRefOrValue.mimeType)
				&& Objects.equals(this.name, attachmentRefOrValue.name)
				&& Objects.equals(this.url, attachmentRefOrValue.url)
				&& Objects.equals(this.size, attachmentRefOrValue.size)
				&& Objects.equals(this.validFor, attachmentRefOrValue.validFor)
				&& Objects.equals(this.baseType, attachmentRefOrValue.baseType)
				&& Objects.equals(this.schemaLocation, attachmentRefOrValue.schemaLocation)
				&& Objects.equals(this.type, attachmentRefOrValue.type)
				&& Objects.equals(this._atReferredType, attachmentRefOrValue._atReferredType);
	}

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, attachmentType, content, description, mimeType, name, url, size, validFor, baseType, schemaLocation, type, _atReferredType);
//  }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AttachmentRefOrValue {\n");

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
