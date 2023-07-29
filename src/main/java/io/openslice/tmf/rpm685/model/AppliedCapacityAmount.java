package io.openslice.tmf.rpm685.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * The amount of CapcityDemand applied to a CapacityAmount.
 */
@Schema(description = "The amount of CapcityDemand applied to a CapacityAmount.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Entity(name = "ApplCapacityAmnt")
public class AppliedCapacityAmount extends BaseRootEntity {

	@JsonProperty("appliedDemandAmount")
	private Integer appliedDemandAmount = null;

	@JsonProperty("resourceCapacityDemand")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appcapcityamount_resCapctDemnduuid", referencedColumnName = "uuid")
	private ResourceCapacityDemand resourceCapacityDemand = null;

	@JsonProperty("resources")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceRef> resources = new HashSet<>();

	public AppliedCapacityAmount appliedDemandAmount(Integer appliedDemandAmount) {
		this.appliedDemandAmount = appliedDemandAmount;
		return this;
	}

	/**
	 * An amount of demand applied to a CapacityAmount. Note that this is a
	 * composite attribute defined by CapacityAmount.
	 * 
	 * @return appliedDemandAmount
	 **/
	@Schema(description = "An amount of demand applied to a CapacityAmount. Note that this is a composite attribute defined by CapacityAmount.")

	public Integer getAppliedDemandAmount() {
		return appliedDemandAmount;
	}

	public void setAppliedDemandAmount(Integer appliedDemandAmount) {
		this.appliedDemandAmount = appliedDemandAmount;
	}

	public AppliedCapacityAmount resourceCapacityDemand(ResourceCapacityDemand resourceCapacityDemand) {
		this.resourceCapacityDemand = resourceCapacityDemand;
		return this;
	}

	/**
	 * Get resourceCapacityDemand
	 * 
	 * @return resourceCapacityDemand
	 **/
	@Schema(description = "")

	@Valid
	public ResourceCapacityDemand getResourceCapacityDemand() {
		return resourceCapacityDemand;
	}

	public void setResourceCapacityDemand(ResourceCapacityDemand resourceCapacityDemand) {
		this.resourceCapacityDemand = resourceCapacityDemand;
	}

	public AppliedCapacityAmount resource(Set<ResourceRef> resource) {
		this.resources = resource;
		return this;
	}

	public AppliedCapacityAmount addResourceItem(ResourceRef resourceItem) {
		this.resources.add(resourceItem);
		return this;
	}

	/**
	 * Get resource
	 * 
	 * @return resource
	 **/
	@Schema(description = "")
	@Valid
	public Set<ResourceRef> getResource() {
		return resources;
	}

	public void setResource(Set<ResourceRef> resource) {
		this.resources = resource;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AppliedCapacityAmount appliedCapacityAmount = (AppliedCapacityAmount) o;
		return Objects.equals(this.baseType, appliedCapacityAmount.baseType)
				&& Objects.equals(this.getSchemaLocation(), appliedCapacityAmount.getSchemaLocation())
				&& Objects.equals(this.getType(), appliedCapacityAmount.getType())
				&& Objects.equals(this.appliedDemandAmount, appliedCapacityAmount.appliedDemandAmount)
				&& Objects.equals(this.resourceCapacityDemand, appliedCapacityAmount.resourceCapacityDemand)
				&& Objects.equals(this.resources, appliedCapacityAmount.resources);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, baseType(null), getSchemaLocation(), getType());
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AppliedCapacityAmount {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(getSchemaLocation())).append("\n");
		sb.append("    _atType: ").append(toIndentedString(getType())).append("\n");
		sb.append("    appliedDemandAmount: ").append(toIndentedString(appliedDemandAmount)).append("\n");
		sb.append("    resourceCapacityDemand: ").append(toIndentedString(resourceCapacityDemand)).append("\n");
		sb.append("    resource: ").append(toIndentedString(resources)).append("\n");
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
