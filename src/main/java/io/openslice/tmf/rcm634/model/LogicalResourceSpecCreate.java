package io.openslice.tmf.rcm634.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.rcm634.model.Attachment;
import io.openslice.tmf.rcm634.model.Feature;
import io.openslice.tmf.rcm634.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecRelationship;
import io.openslice.tmf.rcm634.model.TargetResourceSchemaRef;
import io.openslice.tmf.rcm634.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is a base class that is used to define the invariant characteristics and
 * behavior (attributes, methods, constraints, and relationships) of a
 * LogicalResource. Skipped properties: id,href
 */
@ApiModel(description = "This is a base class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a LogicalResource. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class LogicalResourceSpecCreate extends LogicalResourceSpecUpdate {

	@JsonProperty("@type")
	private String type = null;

	@JsonProperty("lastUpdate")
	private OffsetDateTime lastUpdate = null;

	public LogicalResourceSpecCreate name(String name) {
		this.name = name;
		return this;
	}

	public LogicalResourceSpecCreate lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	/**
	 * Date and time of the last update of this REST resource
	 * 
	 * @return lastUpdate
	 **/
	@ApiModelProperty(value = "Date and time of the last update of this REST resource")

	@Valid

	public OffsetDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LogicalResourceSpecCreate logicalResourceSpecCreate = (LogicalResourceSpecCreate) o;
		return Objects.equals(this.name, logicalResourceSpecCreate.name)
				&& Objects.equals(this.description, logicalResourceSpecCreate.description)
				&& Objects.equals(this.type, logicalResourceSpecCreate.type)
				&& Objects.equals(this.schemaLocation, logicalResourceSpecCreate.schemaLocation)
				&& Objects.equals(this.baseType, logicalResourceSpecCreate.baseType)
				&& Objects.equals(this.version, logicalResourceSpecCreate.version)
				&& Objects.equals(this.validFor, logicalResourceSpecCreate.validFor)
				&& Objects.equals(this.lastUpdate, logicalResourceSpecCreate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, logicalResourceSpecCreate.lifecycleStatus)
				&& Objects.equals(this.isBundle, logicalResourceSpecCreate.isBundle)
				&& Objects.equals(this.category, logicalResourceSpecCreate.category)
				&& Objects.equals(this.targetResourceSchema, logicalResourceSpecCreate.targetResourceSchema)
				&& Objects.equals(this.feature, logicalResourceSpecCreate.feature)
				&& Objects.equals(this.attachment, logicalResourceSpecCreate.attachment)
				&& Objects.equals(this.relatedParty, logicalResourceSpecCreate.relatedParty)
				&& Objects.equals(this.resourceSpecCharacteristic, logicalResourceSpecCreate.resourceSpecCharacteristic)
				&& Objects.equals(this.resourceSpecRelationship, logicalResourceSpecCreate.resourceSpecRelationship);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, type, schemaLocation, baseType, version, validFor, lastUpdate,
				lifecycleStatus, isBundle, category, targetResourceSchema, feature, attachment, relatedParty,
				resourceSpecCharacteristic, resourceSpecRelationship);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LogicalResourceSpecCreate {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
		sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
		sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
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
