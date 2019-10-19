package io.openslice.tmf.scm633.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.scm633.model.AttachmentRef;
import io.openslice.tmf.scm633.model.RelatedParty;
import io.openslice.tmf.scm633.model.ResourceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceLevelSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.TargetServiceSchema;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ServiceSpecification is a class that offers characteristics to describe a
 * type of service. Functionally, it acts as a template by which Services may be
 * instantiated. By sharing the same specification, these services would
 * therefore share the same set of characteristics. Skipped properties: id,href
 */
@ApiModel(description = "ServiceSpecification is a class that offers characteristics to describe a type of service. Functionally, it acts as a template by which Services may be instantiated. By sharing the same  specification, these services would therefore share the same set of characteristics. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceSpecificationCreate extends ServiceSpecificationUpdate {

	@JsonProperty("lastUpdate")
	private OffsetDateTime lastUpdate = null;

	public ServiceSpecificationCreate lastUpdate(OffsetDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	/**
	 * Date and time of the last update of the service specification
	 * 
	 * @return lastUpdate
	 **/
	@ApiModelProperty(value = "Date and time of the last update of the service specification")

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
		ServiceSpecificationCreate serviceSpecificationCreate = (ServiceSpecificationCreate) o;
		return Objects.equals(this.description, serviceSpecificationCreate.description)
				&& Objects.equals(this.isBundle, serviceSpecificationCreate.isBundle)
				&& Objects.equals(this.lastUpdate, serviceSpecificationCreate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceSpecificationCreate.lifecycleStatus)
				&& Objects.equals(this.name, serviceSpecificationCreate.name)
				&& Objects.equals(this.version, serviceSpecificationCreate.version)
				&& Objects.equals(this.attachment, serviceSpecificationCreate.attachment)
				&& Objects.equals(this.relatedParty, serviceSpecificationCreate.relatedParty)
				&& Objects.equals(this.resourceSpecification, serviceSpecificationCreate.resourceSpecification)
				&& Objects.equals(this.serviceLevelSpecification, serviceSpecificationCreate.serviceLevelSpecification)
				&& Objects.equals(this.serviceSpecCharacteristic, serviceSpecificationCreate.serviceSpecCharacteristic)
				&& Objects.equals(this.serviceSpecRelationship, serviceSpecificationCreate.serviceSpecRelationship)
				&& Objects.equals(this.targetServiceSchema, serviceSpecificationCreate.targetServiceSchema)
				&& Objects.equals(this.validFor, serviceSpecificationCreate.validFor)
				&& Objects.equals(this.baseType, serviceSpecificationCreate.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecificationCreate.schemaLocation)
				&& Objects.equals(this.type, serviceSpecificationCreate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, isBundle, lastUpdate, lifecycleStatus, name, version, attachment, relatedParty,
				resourceSpecification, serviceLevelSpecification, serviceSpecCharacteristic, serviceSpecRelationship,
				targetServiceSchema, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecificationCreate {\n");

		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
		sb.append("    serviceLevelSpecification: ").append(toIndentedString(serviceLevelSpecification)).append("\n");
		sb.append("    serviceSpecCharacteristic: ").append(toIndentedString(serviceSpecCharacteristic)).append("\n");
		sb.append("    serviceSpecRelationship: ").append(toIndentedString(serviceSpecRelationship)).append("\n");
		sb.append("    targetServiceSchema: ").append(toIndentedString(targetServiceSchema)).append("\n");
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

}
