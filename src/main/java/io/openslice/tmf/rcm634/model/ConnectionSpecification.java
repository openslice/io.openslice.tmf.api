package io.openslice.tmf.rcm634.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A specification for an edge in a resource graph.
 */
@Schema(description = "A specification for an edge in a resource graph.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "ConnectionSpec")
public class ConnectionSpecification extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("associationType")
	private String associationType = null;

	@JsonProperty("endpointSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<EndpointSpecificationRef> endpointSpecification = new HashSet<>();

	public ConnectionSpecification id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier for graph edge specification.
	 * 
	 * @return id
	 **/
	@Schema(description = "Unique identifier for graph edge specification.")



	public String getId() {
		id = uuid;
		return uuid;
	}
	public ConnectionSpecification href(String href) {
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

	public ConnectionSpecification associationType(String associationType) {
		this.associationType = associationType;
		return this;
	}

	/**
	 * Association type.
	 * 
	 * @return associationType
	 **/
	@Schema(description = "Association type.")
	@NotNull

	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	public ConnectionSpecification name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Descriptive name for graph edge specification.
	 * 
	 * @return name
	 **/
	@Schema(description = "Descriptive name for graph edge specification.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConnectionSpecification endpointSpecification(Set<EndpointSpecificationRef> endpointSpecification) {
		this.endpointSpecification = endpointSpecification;
		return this;
	}

	public ConnectionSpecification addEndpointSpecificationItem(EndpointSpecificationRef endpointSpecificationItem) {
		this.endpointSpecification.add(endpointSpecificationItem);
		return this;
	}

	/**
	 * Specifications for resource graph vertices connected by this edge.
	 * 
	 * @return endpointSpecification
	 **/
	@Schema(description = "Specifications for resource graph vertices connected by this edge.")
	@NotNull
	@Valid
	@Size(min = 1)
	public Set<EndpointSpecificationRef> getEndpointSpecification() {
		return endpointSpecification;
	}

	public void setEndpointSpecification( Set<EndpointSpecificationRef> endpointSpecification) {
		this.endpointSpecification = endpointSpecification;
	}

	public ConnectionSpecification _atBaseType(String _atBaseType) {
		this.baseType = _atBaseType;
		return this;
	}

	/**
	 * When sub-classing, this defines the super-class
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "When sub-classing, this defines the super-class")

	public String getAtBaseType() {
		return baseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this.baseType = _atBaseType;
	}

	public ConnectionSpecification _atSchemaLocation(String _atSchemaLocation) {
		this.schemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A URI to a JSON-Schema file that defines additional attributes and
	 * relationships
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A URI to a JSON-Schema file that defines additional attributes and relationships")

	public String getAtSchemaLocation() {
		return schemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this.schemaLocation = _atSchemaLocation;
	}

	public ConnectionSpecification _atType(String _atType) {
		this.type = _atType;
		return this;
	}

	/**
	 * When sub-classing, this defines the sub-class Extensible name
	 * 
	 * @return _atType
	 **/
	@Schema(description = "When sub-classing, this defines the sub-class Extensible name")

	public String getAtType() {
		return type;
	}

	public void setAtType(String _atType) {
		this.type = _atType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConnectionSpecification connectionSpecification = (ConnectionSpecification) o;
		return Objects.equals(this.id, connectionSpecification.id)
				&& Objects.equals(this.href, connectionSpecification.href)
				&& Objects.equals(this.associationType, connectionSpecification.associationType)
				&& Objects.equals(this.name, connectionSpecification.name)
				&& Objects.equals(this.endpointSpecification, connectionSpecification.endpointSpecification)
				&& Objects.equals(this.baseType, connectionSpecification.baseType)
				&& Objects.equals(this.schemaLocation, connectionSpecification.schemaLocation)
				&& Objects.equals(this.type, connectionSpecification.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, associationType, name, endpointSpecification, baseType, schemaLocation,
				type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ConnectionSpecification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    associationType: ").append(toIndentedString(associationType)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    endpointSpecification: ").append(toIndentedString(endpointSpecification)).append("\n");
		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(type)).append("\n");
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
