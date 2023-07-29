package io.openslice.tmf.rcm634.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * A specification for a vertex in a resource graph.
 */
@Schema(description = "A specification for a vertex in a resource graph.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "EndpointSpecRef")
public class EndpointSpecificationRef extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("href")
	private String href = null;

	@JsonProperty("isRoot")
	private Boolean isRoot = true;

	@JsonProperty("role")
	private String role = null;

	@JsonProperty("connectionPointSpecification")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private ConnectionPointSpecificationRef connectionPointSpecification = null;

	@JsonProperty("@referredType")
	private String _atReferredType = null;

	public EndpointSpecificationRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@Schema(description = "unique identifier")
	@NotNull

	public String getId() {
		id = uuid;
		return uuid;
	}

	public EndpointSpecificationRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@Schema(description = "Hyperlink reference")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public EndpointSpecificationRef isRoot(Boolean isRoot) {
		this.isRoot = isRoot;
		return this;
	}

	/**
	 * Directionality: true when endpoint is a source, false when a sink. If true
	 * for all endpoints connectivity is bidirectional. Default is true.
	 * 
	 * @return isRoot
	 **/
	@Schema(description = "Directionality: true when endpoint is a source, false when a sink. If true for all endpoints connectivity is bidirectional. Default is true.")

	public Boolean isIsRoot() {
		return isRoot;
	}

	public void setIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}

	public EndpointSpecificationRef name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the related entity.
	 * 
	 * @return name
	 **/
	@Schema(description = "Name of the related entity.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EndpointSpecificationRef role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * Role of the Resource Function.
	 * 
	 * @return role
	 **/
	@Schema(description = "Role of the Resource Function.")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public EndpointSpecificationRef connectionPointSpecification(
			ConnectionPointSpecificationRef connectionPointSpecification) {
		this.connectionPointSpecification = connectionPointSpecification;
		return this;
	}

	/**
	 * Get connectionPointSpecification
	 * 
	 * @return connectionPointSpecification
	 **/
	@Schema(description = "")

	@Valid
	public ConnectionPointSpecificationRef getConnectionPointSpecification() {
		return connectionPointSpecification;
	}

	public void setConnectionPointSpecification(ConnectionPointSpecificationRef connectionPointSpecification) {
		this.connectionPointSpecification = connectionPointSpecification;
	}


	public EndpointSpecificationRef _atReferredType(String _atReferredType) {
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
		EndpointSpecificationRef endpointSpecificationRef = (EndpointSpecificationRef) o;
		return Objects.equals(this.id, endpointSpecificationRef.id)
				&& Objects.equals(this.href, endpointSpecificationRef.href)
				&& Objects.equals(this.isRoot, endpointSpecificationRef.isRoot)
				&& Objects.equals(this.name, endpointSpecificationRef.name)
				&& Objects.equals(this.role, endpointSpecificationRef.role)
				&& Objects.equals(this.connectionPointSpecification,
						endpointSpecificationRef.connectionPointSpecification)
				&& Objects.equals(this.baseType, endpointSpecificationRef.baseType)
				&& Objects.equals(this.schemaLocation, endpointSpecificationRef.schemaLocation)
				&& Objects.equals(this.type, endpointSpecificationRef.type)
				&& Objects.equals(this._atReferredType, endpointSpecificationRef._atReferredType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, isRoot, name, role, connectionPointSpecification, baseType, schemaLocation,
				type, _atReferredType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EndpointSpecificationRef {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    connectionPointSpecification: ").append(toIndentedString(connectionPointSpecification))
				.append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
