package io.openslice.tmf.scm.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * basic root entity that defines common attributes of the model
 * 
 * @author ctranoris
 *
 */
@Entity(name = "BaseRootEntity")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public class BaseRootEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@JsonProperty("id")
	protected String id = null;

	@JsonProperty("href")
	protected String href = null;

	@JsonProperty("name")
	protected String name = null;

	@JsonProperty("@baseType")
	protected String baseType = "BaseEntity";

	@JsonProperty("@schemaLocation")
	protected String schemaLocation = null;
	

	@JsonProperty("@type")
	protected String type = null;

	public BaseRootEntity id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the Entity
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the Entity")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseRootEntity href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Unique reference of the entity
	 * 
	 * @return href
	 **/
	@ApiModelProperty(value = "Unique reference of the entity")

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public BaseRootEntity name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the entity
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Name of the entity")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseRootEntity baseType(String baseType) {
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

	public BaseRootEntity schemaLocation(String schemaLocation) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BaseRootEntity Entity = (BaseRootEntity) o;
		return Objects.equals(this.id, Entity.id) && Objects.equals(this.href, Entity.href)
				&& Objects.equals(this.name, Entity.name)
				&& Objects.equals(this.baseType, Entity.baseType)
				&& Objects.equals(this.schemaLocation, Entity.schemaLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name,

				baseType, schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Entity {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
