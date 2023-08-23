package io.openslice.tmf.ri639.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Linked resources to the one instantiate, such as [bundled] if the resource is
 * a bundle and you want to describe the bundled resources inside this bundle;
 * [reliesOn] if the resource needs another already owned resource to rely on
 * (e.g. an option on an already owned mobile access resource) [targets] or
 * [isTargeted] (depending on the way of expressing the link) for any other kind
 * of links that may be useful
 */
@Schema(description = "Linked resources to the one instantiate, such as [bundled] if the resource is a bundle and you want to describe the bundled resources inside this bundle; [reliesOn] if the resource needs another already owned resource to rely on (e.g. an option on an already owned mobile access resource) [targets] or [isTargeted] (depending on the way of expressing the link) for any other kind of links that may be useful")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIResourceRel")
public class ResourceRelationship extends BaseRootEntity {
	@JsonProperty("id")
	private String id = null;
	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("resource")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rsrc_rsrcref_uuid", referencedColumnName = "uuid")
	private ResourceRef resource = null;

	/**
	 * unique identifier
	 * 
	 * @return id
	 **/
	@Schema(description = "unique identifier")
	public String getId() {
		id = uuid;
		return uuid;
	}

	public ResourceRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of the resource relationship, such as [bundled] if the resource is a
	 * bundle and you want to describe the bundled resources inside this bundle;
	 * [reliesOn] if the resource needs another already owned resource to rely on
	 * (eg: an option on an already owned mobile access resource) [targets] or
	 * [isTargeted] (depending on the way of expressing the link) for any other kind
	 * of links that may be useful
	 * 
	 * @return relationshipType
	 **/
	@Schema(example = "bundled", required = true, description = "Type of the resource relationship, such as [bundled] if the resource is a bundle and you want to describe the bundled resources inside this bundle; [reliesOn] if the resource needs another already owned resource to rely on (eg: an option on an already owned mobile access resource) [targets] or [isTargeted] (depending on the way of expressing the link) for any other kind of links that may be useful")
	@NotNull

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ResourceRelationship resource( ResourceRef resource) {
		this.resource = resource;
		return this;
	}

	/**
	 * Get resource
	 * 
	 * @return resource
	 **/
	@Schema(description = "")
	@NotNull

	@Valid
	public ResourceRef getResource() {
		return resource;
	}

	public void setResource(ResourceRef resource) {
		this.resource = resource;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceRelationship resourceRelationship = (ResourceRelationship) o;
		return Objects.equals(this.id, resourceRelationship.id) && Objects.equals(this.href, resourceRelationship.href)
				&& Objects.equals(this.relationshipType, resourceRelationship.relationshipType)
				&& Objects.equals(this.resource, resourceRelationship.resource)
				&& Objects.equals(this.baseType, resourceRelationship.baseType)
				&& Objects.equals(this.schemaLocation, resourceRelationship.schemaLocation)
				&& Objects.equals(this.type, resourceRelationship.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, relationshipType, resource, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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
