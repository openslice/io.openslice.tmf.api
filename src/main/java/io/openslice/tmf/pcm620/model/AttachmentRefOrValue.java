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
package io.openslice.tmf.pcm620.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An attachment by value or by reference. For AttachmentRefOrValue, the
 * attribute type,schemaLocation and referredType are related to the contained
 * entity and not to AttchmentRefOrValue itself
 */
@ApiModel(description = "An attachment by value or by reference. For AttachmentRefOrValue, the attribute type,schemaLocation and referredType are related to the contained entity and not to AttchmentRefOrValue itself")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")
@Entity(name = "ProductAttachmentRefOrValue")
public class AttachmentRefOrValue extends BaseEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("attachmentType")
	private String attachmentType = null;

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("mimeType")
	private String mimeType = null;

	@JsonProperty("url")
	private String url = null;

	@JsonProperty("size")
	private Quantity size = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	/**
	 * Unique identifier for this particular attachment
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier for this particular attachment")

	public String getId() {
		if (uuid != null) {
			id = uuid;
		}
		return id;
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
	@ApiModelProperty(value = "Attachment type such as video, picture")

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
	@ApiModelProperty(value = "The actual contents of the attachment object, if embedded, encoded as base64")

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	@ApiModelProperty(value = "Attachment mime type such as extension file for video, picture and document")

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
	@ApiModelProperty(value = "Uniform Resource Locator, is a web page address (a subset of URI)")

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
	 * The size of the attachment.
	 * 
	 * @return size
	 **/
	@ApiModelProperty(value = "The size of the attachment.")

	@Valid

	public Quantity getSize() {
		return size;
	}

	public void setSize(Quantity size) {
		this.size = size;
	}

	

	public AttachmentRefOrValue referredType(String referredType) {
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
				&& Objects.equals(this.referredType, attachmentRefOrValue.referredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, attachmentType, content, description, mimeType, name, url, size, validFor,
//				baseType, schemaLocation, type, referredType);
//	}

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
