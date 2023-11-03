package io.openslice.tmf.rcm634.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

/**
 * Specifies a function as a behavior to transform inputs of any nature into
 * outputs of any nature independently from the way it is provided, for example
 * a Medium to Large Enterprise Firewall.
 */
@Schema(description = "Specifies a function as a behavior to transform inputs of any nature into outputs of any nature independently from the way it is provided, for example a Medium to Large Enterprise Firewall.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-07T15:15:49.915156900+03:00[Europe/Athens]")
@Entity(name = "Resfuncspec")
public class ResourceFunctionSpecification extends LogicalResourceSpecification {

	@JsonProperty("connectionPointSpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ConnectionPointSpecificationRef> connectionPointSpecification =  new HashSet<>();

	@JsonProperty("connectivitySpecification")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceGraphSpecification> connectivitySpecification =  new HashSet<>();

	public ResourceFunctionSpecification() {
		super();
		this.baseType = "LogicalResourceSpecification";
		this.type = "ResourceFunctionSpecification";

	}

	public ResourceFunctionSpecification connectionPointSpecification(
			Set<ConnectionPointSpecificationRef> connectionPointSpecification) {
		this.connectionPointSpecification = connectionPointSpecification;
		return this;
	}

	public ResourceFunctionSpecification addConnectionPointSpecificationItem(
			ConnectionPointSpecificationRef connectionPointSpecificationItem) {
		if (this.connectionPointSpecification == null) {
			this.connectionPointSpecification = new HashSet<>();
		}
		this.connectionPointSpecification.add(connectionPointSpecificationItem);
		return this;
	}

	/**
	 * External connection point specifications. These are the service access points
	 * (SAP) where inputs and outputs of the function are available.
	 * 
	 * @return connectionPointSpecification
	 **/
	@Schema(description = "External connection point specifications. These are the service access points (SAP) where inputs and outputs of the function are available.")
	@Valid
	public Set<ConnectionPointSpecificationRef> getConnectionPointSpecification() {
		return connectionPointSpecification;
	}

	public void setConnectionPointSpecification( Set<ConnectionPointSpecificationRef> connectionPointSpecification) {
		this.connectionPointSpecification = connectionPointSpecification;
	}

	public ResourceFunctionSpecification connectivitySpecification(
			Set<ResourceGraphSpecification> connectivitySpecification) {
		this.connectivitySpecification = connectivitySpecification;
		return this;
	}

	public ResourceFunctionSpecification addConnectivitySpecificationItem(
			ResourceGraphSpecification connectivitySpecificationItem) {
		if (this.connectivitySpecification == null) {
			this.connectivitySpecification = new HashSet<>();
		}
		this.connectivitySpecification.add(connectivitySpecificationItem);
		return this;
	}

	/**
	 * Internal connectivity potential specifications.
	 * 
	 * @return connectivitySpecification
	 **/
	@Schema(description = "Internal connectivity potential specifications.")
	@Valid
	public Set<ResourceGraphSpecification> getConnectivitySpecification() {
		return connectivitySpecification;
	}

	public void setConnectivitySpecification(Set<ResourceGraphSpecification> connectivitySpecification) {
		this.connectivitySpecification = connectivitySpecification;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceFunctionSpecification resourceFunctionSpecification = (ResourceFunctionSpecification) o;
		return Objects.equals(this.uuid, resourceFunctionSpecification.uuid)
				&& Objects.equals(this.href, resourceFunctionSpecification.href)
				&& Objects.equals(this.category, resourceFunctionSpecification.category)
				&& Objects.equals(this.description, resourceFunctionSpecification.description)
				&& Objects.equals(this.isBundle, resourceFunctionSpecification.isBundle)
				&& Objects.equals(this.lastUpdate, resourceFunctionSpecification.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, resourceFunctionSpecification.lifecycleStatus)
				&& Objects.equals(this.name, resourceFunctionSpecification.name)
				&& Objects.equals(this.version, resourceFunctionSpecification.version)
				&& Objects.equals(this.attachment, resourceFunctionSpecification.attachment)
				&& Objects.equals(this.connectionPointSpecification,
						resourceFunctionSpecification.connectionPointSpecification)
				&& Objects.equals(this.connectivitySpecification,
						resourceFunctionSpecification.connectivitySpecification)
				&& Objects.equals(this.featureSpecification, resourceFunctionSpecification.featureSpecification)
				&& Objects.equals(this.relatedParty, resourceFunctionSpecification.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic,
						resourceFunctionSpecification.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, resourceFunctionSpecification.resourceSpecRelationship)
				&& Objects.equals(this.targetResourceSchema, resourceFunctionSpecification.targetResourceSchema)
				&& Objects.equals(this.validFor, resourceFunctionSpecification.validFor)
				&& Objects.equals(this.baseType, resourceFunctionSpecification.baseType)
				&& Objects.equals(this.schemaLocation, resourceFunctionSpecification.schemaLocation)
				&& Objects.equals(this.type, resourceFunctionSpecification.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, href, category, description, isBundle, lastUpdate, lifecycleStatus, name, version,
				attachment, connectionPointSpecification, connectivitySpecification, featureSpecification, relatedParty,
				resourceSpecCharacteristic, resourceSpecRelationship, targetResourceSchema, validFor, baseType,
				schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceFunctionSpecification {\n");

		sb.append("    id: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    connectionPointSpecification: ").append(toIndentedString(connectionPointSpecification))
				.append("\n");
		sb.append("    connectivitySpecification: ").append(toIndentedString(connectivitySpecification)).append("\n");
		sb.append("    featureSpecification: ").append(toIndentedString(featureSpecification)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
		sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
		sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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
