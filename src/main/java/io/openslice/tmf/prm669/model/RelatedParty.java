package io.openslice.tmf.prm669.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * RelatedParty reference. A related party defines party or party role linked to
 * a specific entity.
 */
@ApiModel(description = "RelatedParty reference. A related party defines party or party role linked to a specific entity.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "RelatedParty")
public class RelatedParty extends BaseRootEntity{
	@JsonProperty("role")
	private String role = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	@JsonProperty("id")
	protected String id = null;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return uuid;
	}
	
	public RelatedParty() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}
	
	public RelatedParty id(String id) {
		this.id = id;
		return this;
	}

	
	public RelatedParty role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * Role of the related party.
	 * 
	 * @return role
	 **/
	@ApiModelProperty(value = "Role of the related party.")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public RelatedParty referredType(String referredType) {
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
		RelatedParty relatedParty = (RelatedParty) o;
		return Objects.equals(this.id, relatedParty.id) && Objects.equals(this.href, relatedParty.href)
				&& Objects.equals(this.name, relatedParty.name) && Objects.equals(this.role, relatedParty.role)
				&& Objects.equals(this.baseType, relatedParty.baseType)
				&& Objects.equals(this.schemaLocation, relatedParty.schemaLocation)
				&& Objects.equals(this.type, relatedParty.type)
				&& Objects.equals(this.referredType, relatedParty.referredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, role, baseType, schemaLocation, type, referredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RelatedParty {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
