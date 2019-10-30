package io.openslice.tmf.so641.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Service reference, for when Service is used by other entities
 */
@ApiModel(description = "Service reference, for when Service is used by other entities")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Entity(name = "ServiceRestrictionServiceRef")
public class ServiceRef extends BaseRootNamedEntity {
	
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("@referredType")
	private String referredType = null;

	public ServiceRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Id of the service
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "Id of the service")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ServiceRef referredType(String referredType) {
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
		ServiceRef serviceRef = (ServiceRef) o;
		return Objects.equals(this.id, serviceRef.id) && Objects.equals(this.href, serviceRef.href)
				&& Objects.equals(this.baseType, serviceRef.baseType)
				&& Objects.equals(this.schemaLocation, serviceRef.schemaLocation)
				&& Objects.equals(this.type, serviceRef.type)
				&& Objects.equals(this.referredType, serviceRef.referredType);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, href, baseType, schemaLocation, type, referredType);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
