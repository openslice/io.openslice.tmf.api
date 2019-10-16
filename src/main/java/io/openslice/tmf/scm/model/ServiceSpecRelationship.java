package io.openslice.tmf.scm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among service specifications.
 */
@ApiModel(description = "A migration, substitution, dependency or exclusivity relationship between/among service specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceSpecRelationship")
public class ServiceSpecRelationship {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;
	
	
	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("name")
	protected String name = null;

	
	@JsonProperty("@baseType")
	protected String baseType = "BaseEntity";


	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;
	

	@JsonProperty("@type")
	protected String type = null;

	@JsonProperty("relationshipType")
	private String relationshipType = null;

	@JsonProperty("role")
	private String role = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	public ServiceSpecRelationship() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ServiceSpecRelationship id(String id) {
		this.id = id;
		return this;
	}

	
	/**
	 * Unique identifier of the target serviceSpecification
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the target serviceSpecification")

	public ServiceSpecRelationship relationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Type of relationship such as migration, substitution, dependency, exclusivity
	 * 
	 * @return relationshipType
	 **/
	@ApiModelProperty(value = "Type of relationship such as migration, substitution, dependency, exclusivity")

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public ServiceSpecRelationship role(String role) {
		this.role = role;
		return this;
	}

	/**
	 * The association role for this service specification
	 * 
	 * @return role
	 **/
	@ApiModelProperty(value = "The association role for this service specification")

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ServiceSpecRelationship validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the serviceSpecRelationship is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the serviceSpecRelationship is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceSpecRelationship serviceSpecRelationship = (ServiceSpecRelationship) o;
		return Objects.equals(this.id, serviceSpecRelationship.id)
				&& Objects.equals(this.name, serviceSpecRelationship.name)
				&& Objects.equals(this.relationshipType, serviceSpecRelationship.relationshipType)
				&& Objects.equals(this.role, serviceSpecRelationship.role)
				&& Objects.equals(this.validFor, serviceSpecRelationship.validFor)
				&& Objects.equals(this.baseType, serviceSpecRelationship.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecRelationship.schemaLocation)
				&& Objects.equals(this.type, serviceSpecRelationship.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,  name, relationshipType, role, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecRelationship {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the baseType
	 */
	public String getBaseType() {
		return baseType;
	}

	/**
	 * @param baseType the baseType to set
	 */
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	/**
	 * @return the schemaLocation
	 */
	public String getSchemaLocation() {
		return schemaLocation;
	}

	/**
	 * @param schemaLocation the schemaLocation to set
	 */
	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
