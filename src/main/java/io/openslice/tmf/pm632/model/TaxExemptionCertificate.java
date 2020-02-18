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
package io.openslice.tmf.pm632.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A tax exemption certificate represents a tax exemption granted to a party
 * (individual or organization) by a tax jurisdiction which may be a city,
 * state, country,... An exemption has a certificate identifier (received from
 * the jurisdiction that levied the tax) and a validity period. An exemption is
 * per tax types and determines for each type of tax what portion of the tax is
 * exempted (partial by percentage or complete) via the tax definition.
 */
@ApiModel(description = "A tax exemption certificate represents a tax exemption granted to a party (individual or organization) by a tax jurisdiction which may be a city, state, country,... An exemption has a certificate identifier (received from the jurisdiction that levied the tax) and a validity period. An exemption is per tax types and determines for each type of tax what portion of the tax is exempted (partial by percentage or complete) via the tax definition.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Entity
public class TaxExemptionCertificate extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("attachment")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attachment_refid", referencedColumnName = "uuid")
	private AttachmentRefOrValue attachment = null;

	@JsonProperty("taxDefinition")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<TaxDefinition> taxDefinition = new HashSet<>();

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("@baseType")
	private String baseType = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	@JsonProperty("@type")
	private String type = null;

	public TaxExemptionCertificate id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the certificate of the tax exemption
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the certificate of the tax exemption")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TaxExemptionCertificate attachment(AttachmentRefOrValue attachment) {
		this.attachment = attachment;
		return this;
	}

	/**
	 * Get attachment
	 * 
	 * @return attachment
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public AttachmentRefOrValue getAttachment() {
		return attachment;
	}

	public void setAttachment(AttachmentRefOrValue attachment) {
		this.attachment = attachment;
	}

	public TaxExemptionCertificate taxDefinition(Set<TaxDefinition> taxDefinition) {
		this.taxDefinition = taxDefinition;
		return this;
	}

	public TaxExemptionCertificate addTaxDefinitionItem(TaxDefinition taxDefinitionItem) {
		if (this.taxDefinition == null) {
			this.taxDefinition = new HashSet<>();
		}
		this.taxDefinition.add(taxDefinitionItem);
		return this;
	}

	/**
	 * Get taxDefinition
	 * 
	 * @return taxDefinition
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<TaxDefinition> getTaxDefinition() {
		return taxDefinition;
	}

	public void setTaxDefinition(Set<TaxDefinition> taxDefinition) {
		this.taxDefinition = taxDefinition;
	}

	public TaxExemptionCertificate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * Get validFor
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public TaxExemptionCertificate baseType(String baseType) {
		this.baseType = baseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return baseType
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the super-class")

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public TaxExemptionCertificate schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public TaxExemptionCertificate type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class entity name
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")

	public String getType() {
		return type;
	}

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
		TaxExemptionCertificate taxExemptionCertificate = (TaxExemptionCertificate) o;
		return Objects.equals(this.id, taxExemptionCertificate.id)
				&& Objects.equals(this.attachment, taxExemptionCertificate.attachment)
				&& Objects.equals(this.taxDefinition, taxExemptionCertificate.taxDefinition)
				&& Objects.equals(this.validFor, taxExemptionCertificate.validFor)
				&& Objects.equals(this.baseType, taxExemptionCertificate.baseType)
				&& Objects.equals(this.schemaLocation, taxExemptionCertificate.schemaLocation)
				&& Objects.equals(this.type, taxExemptionCertificate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, attachment, taxDefinition, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TaxExemptionCertificate {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    taxDefinition: ").append(toIndentedString(taxDefinition)).append("\n");
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
