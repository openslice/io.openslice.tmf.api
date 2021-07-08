package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.rcm634.model.ResourceGraphSpecificationRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Describes link between resource graph specifications.
 */
@ApiModel(description = "Describes link between resource graph specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "ResourceGraphSpecRel")
public class ResourceGraphSpecificationRelationship extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("href")
	private String href = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("resourceGraph")
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private ResourceGraphSpecificationRef resourceGraph = null;

	public ResourceGraphSpecificationRelationship id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "unique identifier")


	public String getId() {
		id = uuid;
		return uuid;
	}
	

	public ResourceGraphSpecificationRelationship href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Hyperlink reference
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Hyperlink reference")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ResourceGraphSpecificationRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Semantic of the relationship.
	 * 
	 * @return relationshipType
	 **/
	@ApiModelProperty(value = "Semantic of the relationship.")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ResourceGraphSpecificationRelationship resourceGraph(ResourceGraphSpecificationRef resourceGraph) {
		this.resourceGraph = resourceGraph;
		return this;
	}

	/**
	 * Get resourceGraph
	 * 
	 * @return resourceGraph
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ResourceGraphSpecificationRef getResourceGraph() {
		return resourceGraph;
	}

	public void setResourceGraph(ResourceGraphSpecificationRef resourceGraph) {
		this.resourceGraph = resourceGraph;
	}

	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceGraphSpecificationRelationship resourceGraphSpecificationRelationship = (ResourceGraphSpecificationRelationship) o;
		return Objects.equals(this.id, resourceGraphSpecificationRelationship.id)
				&& Objects.equals(this.href, resourceGraphSpecificationRelationship.href)
				&& Objects.equals(this.relationshipType, resourceGraphSpecificationRelationship.relationshipType)
				&& Objects.equals(this.resourceGraph, resourceGraphSpecificationRelationship.resourceGraph)
				&& Objects.equals(this.baseType, resourceGraphSpecificationRelationship.baseType)
				&& Objects.equals(this.schemaLocation, resourceGraphSpecificationRelationship.schemaLocation)
				&& Objects.equals(this.type, resourceGraphSpecificationRelationship.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, relationshipType, resourceGraph, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceGraphSpecificationRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    resourceGraph: ").append(toIndentedString(resourceGraph)).append("\n");
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
