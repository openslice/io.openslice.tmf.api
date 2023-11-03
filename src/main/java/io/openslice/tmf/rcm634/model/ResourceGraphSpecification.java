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
 * Resource graph specification.
 */
@Schema(description = "Resource graph specification.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "ResourceGraphSpec")
public class ResourceGraphSpecification extends BaseRootNamedEntity {


	@JsonProperty("id")
	protected String id = null;
	
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("connectionSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ConnectionSpecification> connectionSpecification =  new HashSet<>();

	@JsonProperty("graphSpecificationRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceGraphSpecificationRelationship> graphSpecificationRelationship =  new HashSet<>();

	

	public ResourceGraphSpecification description(String description) {
		this.description = description;
		return this;
	}

	public String getId() {
		id = uuid;
		return uuid;
	}
	
	/**
	 * Description of the resource graph specification.
	 * 
	 * @return description
	 **/
	@Schema(description = "Description of the resource graph specification.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public ResourceGraphSpecification connectionSpecification(Set<ConnectionSpecification> connectionSpecification) {
		this.connectionSpecification = connectionSpecification;
		return this;
	}

	public ResourceGraphSpecification addConnectionSpecificationItem(
			ConnectionSpecification connectionSpecificationItem) {
		this.connectionSpecification.add(connectionSpecificationItem);
		return this;
	}

	/**
	 * Resource graph edge specifications.
	 * 
	 * @return connectionSpecification
	 **/
	@Schema(description = "Resource graph edge specifications.")
	@NotNull
	@Valid
	@Size(min = 1)
	public Set<ConnectionSpecification> getConnectionSpecification() {
		return connectionSpecification;
	}

	public void setConnectionSpecification(Set<ConnectionSpecification> connectionSpecification) {
		this.connectionSpecification = connectionSpecification;
	}

	public ResourceGraphSpecification graphSpecificationRelationship(
			Set<ResourceGraphSpecificationRelationship> graphSpecificationRelationship) {
		this.graphSpecificationRelationship = graphSpecificationRelationship;
		return this;
	}

	public ResourceGraphSpecification addGraphSpecificationRelationshipItem(
			ResourceGraphSpecificationRelationship graphSpecificationRelationshipItem) {
		if (this.graphSpecificationRelationship == null) {
			this.graphSpecificationRelationship = new HashSet<>();
		}
		this.graphSpecificationRelationship.add(graphSpecificationRelationshipItem);
		return this;
	}

	/**
	 * Relationships to other resource graph specifications.
	 * 
	 * @return graphSpecificationRelationship
	 **/
	@Schema(description = "Relationships to other resource graph specifications.")
	@Valid
	public Set<ResourceGraphSpecificationRelationship> getGraphSpecificationRelationship() {
		return graphSpecificationRelationship;
	}

	public void setGraphSpecificationRelationship(
			Set<ResourceGraphSpecificationRelationship> graphSpecificationRelationship) {
		this.graphSpecificationRelationship = graphSpecificationRelationship;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceGraphSpecification resourceGraphSpecification = (ResourceGraphSpecification) o;
		return Objects.equals(this.uuid, resourceGraphSpecification.uuid)
				&& Objects.equals(this.href, resourceGraphSpecification.href)
				&& Objects.equals(this.description, resourceGraphSpecification.description)
				&& Objects.equals(this.name, resourceGraphSpecification.name)
				&& Objects.equals(this.connectionSpecification, resourceGraphSpecification.connectionSpecification)
				&& Objects.equals(this.graphSpecificationRelationship,
						resourceGraphSpecification.graphSpecificationRelationship)
				&& Objects.equals(this.baseType, resourceGraphSpecification.baseType)
				&& Objects.equals(this.schemaLocation, resourceGraphSpecification.schemaLocation)
				&& Objects.equals(this.type, resourceGraphSpecification.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, href, description, name, connectionSpecification, graphSpecificationRelationship,
				baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceGraphSpecification {\n");

		sb.append("    id: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    connectionSpecification: ").append(toIndentedString(connectionSpecification)).append("\n");
		sb.append("    graphSpecificationRelationship: ").append(toIndentedString(graphSpecificationRelationship))
				.append("\n");
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
