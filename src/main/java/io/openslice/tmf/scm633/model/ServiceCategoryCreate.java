package io.openslice.tmf.scm633.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories. Skipped
 * properties: id,href
 */
@ApiModel(description = "The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

public class ServiceCategoryCreate extends ServiceCategoryUpdate {
	

	@JsonProperty("lastUpdate")
	private OffsetDateTime lastUpdate = null;

	

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



	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceCategoryCreate serviceCategoryCreate = (ServiceCategoryCreate) o;
		return Objects.equals(this.description, serviceCategoryCreate.description)
				&& Objects.equals(this.isRoot, serviceCategoryCreate.isRoot)
				&& Objects.equals(this.lastUpdate, serviceCategoryCreate.lastUpdate)
				&& Objects.equals(this.lifecycleStatus, serviceCategoryCreate.lifecycleStatus)
				&& Objects.equals(this.name, serviceCategoryCreate.name)
				&& Objects.equals(this.parentId, serviceCategoryCreate.parentId)
				&& Objects.equals(this.version, serviceCategoryCreate.version)
				&& Objects.equals(this.category, serviceCategoryCreate.category)
				&& Objects.equals(this.serviceCandidate, serviceCategoryCreate.serviceCandidate)
				&& Objects.equals(this.validFor, serviceCategoryCreate.validFor)
				&& Objects.equals(this.baseType, serviceCategoryCreate.baseType)
				&& Objects.equals(this.schemaLocation, serviceCategoryCreate.schemaLocation)
				&& Objects.equals(this.type, serviceCategoryCreate.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, isRoot, lastUpdate, lifecycleStatus, name, parentId, version, category,
				serviceCandidate, validFor, baseType, schemaLocation, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceCategoryCreate {\n");

		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
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