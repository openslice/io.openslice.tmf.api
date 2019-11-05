package io.openslice.tmf.common.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
@Entity( name = "BaseRootNamedEntity")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Table( indexes = {@Index(name = "IX_NAME", columnList = "name")} )
public class BaseRootNamedEntity  extends BaseRootEntity{

	
	@JsonProperty("name")
	protected String name = null;

	



	public BaseRootNamedEntity name(String name) {
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


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BaseRootNamedEntity Entity = (BaseRootNamedEntity) o;
		return Objects.equals(this.uuid, Entity.uuid) && Objects.equals(this.href, Entity.href)
				&& Objects.equals(this.name, Entity.name)
				&& Objects.equals(this.baseType, Entity.baseType)
				&& Objects.equals(this.schemaLocation, Entity.schemaLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, href, name,

				baseType, schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Entity {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	public void copyFromObj(BaseRootNamedEntity be) {
		this.uuid = be.uuid;
		this.name = be.name;
		this.href = be.href;
		this.baseType = be.baseType;
		this.schemaLocation = be.schemaLocation;
		this.type = be.type;
		
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
