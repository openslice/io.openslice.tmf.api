package io.openslice.tmf.scm.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * basic entity that defines common attributes of the model
 * @author ctranoris
 *
 */
@Entity(name = "BaseEntity")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public class BaseEntity extends BaseRootEntity{


	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	protected String description = null;

	@JsonProperty("lastUpdate")
	protected OffsetDateTime lastUpdate = null;

	@JsonProperty("lifecycleStatus")
	protected String lifecycleStatus = ELifecycle.IN_STUDY.getValue();


	@JsonProperty("version")
	protected String version = null;

	@JsonProperty("validFor")
	protected TimePeriod validFor = null;


	public BaseEntity() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = "BaseEntity";
	}


	public BaseEntity description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Description of this catalog
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Description of this catalog")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BaseEntity lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}
	

	/**
	 * Date and time of the last update
	 * 
	 * @return lastUpdate
	 **/
	@ApiModelProperty(value = "Date and time of the last update")

	@Valid

	public OffsetDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public void setLastUpdate (String lastUpdate) {
		
		this.lastUpdate = OffsetDateTime.parse( lastUpdate );
	}


	public BaseEntity lifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
		return this;
	}

	/**
	 * Used to indicate the current lifecycle status
	 * 
	 * @return lifecycleStatus
	 **/
	@ApiModelProperty(value = "Used to indicate the current lifecycle status")

	public String getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(String lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}
	
	public void setLifecycleStatusEnum( ELifecycle alifecycleStatus) {
		this.lifecycleStatus = alifecycleStatus.getValue();
	}


	public BaseEntity version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Entity version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "Entity version")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	/**
	 * The period for which the entity is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the entity is valid")

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
		BaseEntity Entity = (BaseEntity) o;
		return Objects.equals(this.uuid, Entity.uuid) && Objects.equals(this.href, Entity.href)
				&& Objects.equals(this.description, Entity.description)
				&& Objects.equals(this.lastUpdate, Entity.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, Entity.lifecycleStatus)
				&& Objects.equals(this.name, Entity.name)
				&& Objects.equals(this.version, Entity.version)
				&& Objects.equals(this.validFor, Entity.validFor)
				&& Objects.equals(this.baseType, Entity.baseType)
				&& Objects.equals(this.schemaLocation, Entity.schemaLocation)
				&& Objects.equals(this.type, Entity.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, href, description, lastUpdate, lifecycleStatus, name, 
				version, 
				validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Entity {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("}");
		return sb.toString();
	}
	

	public void copyFromObj(BaseEntity be) {
		super.copyFromObj(be);
		this.description = be.description;
		this.lastUpdate = be.lastUpdate;
		this.lifecycleStatus = be.lifecycleStatus;
		this.version = be.version;
		if ( this.validFor != null) {
			this.validFor.copyFromObj(be.validFor);			
		}
			
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
