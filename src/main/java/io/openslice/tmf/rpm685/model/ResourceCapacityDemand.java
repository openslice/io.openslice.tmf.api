package io.openslice.tmf.rpm685.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.pcm620.model.PlaceRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * the amount of capacity that is planned to be consumed or has been consumed.
 */
@Schema(description = "the amount of capacity that is planned to be consumed or has been consumed.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Entity(name = "ResCapacityDemand")
public class ResourceCapacityDemand extends BaseRootEntity {

	@JsonProperty("capacityDemandAmount")
	private Integer capacityDemandAmount = null;

	@JsonProperty("resourcePool")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rescapcitydem_resPooluuid", referencedColumnName = "uuid")
	private ResourcePoolRef resourcePool = null;

	@JsonProperty("applicableTimePeriod")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rescapcitydem_applTimePerduuid", referencedColumnName = "uuid")
	private ApplicableTimePeriod applicableTimePeriod = null;

	@JsonProperty("place")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rescapcitydem_placeuuid", referencedColumnName = "uuid")
	private PlaceRef place = null;


	@JsonProperty("resources")
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceRef> resources = new HashSet<>();
	
	
	
	/**
	 * @return the resources
	 */
	public Set<ResourceRef> getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(Set<ResourceRef> resources) {
		this.resources = resources;
	}

	public ResourceCapacityDemand capacityDemandAmount(Integer capacityDemandAmount) {
		this.capacityDemandAmount = capacityDemandAmount;
		return this;
	}

	/**
	 * A value and units that define the CapacityDemand, such as 10000 ea, 10B Mb.
	 * Instance values are mutually exclusive with From and To capacityDemandAmounts
	 * and range interval.
	 * 
	 * @return capacityDemandAmount
	 **/
	@Schema(description = "A value and units that define the CapacityDemand, such as 10000 ea, 10B Mb.  Instance values are mutually exclusive with From and To capacityDemandAmounts and range interval.")

	public Integer getCapacityDemandAmount() {
		return capacityDemandAmount;
	}

	public void setCapacityDemandAmount(Integer capacityDemandAmount) {
		this.capacityDemandAmount = capacityDemandAmount;
	}

	public ResourceCapacityDemand resourcePool(ResourcePoolRef resourcePool) {
		this.resourcePool = resourcePool;
		return this;
	}

	/**
	 * Get resourcePool
	 * 
	 * @return resourcePool
	 **/
	@Schema(description = "")

	@Valid
	public ResourcePoolRef getResourcePool() {
		return resourcePool;
	}

	public void setResourcePool(ResourcePoolRef resourcePool) {
		this.resourcePool = resourcePool;
	}

	public ResourceCapacityDemand applicableTimePeriod(ApplicableTimePeriod applicableTimePeriod) {
		this.applicableTimePeriod = applicableTimePeriod;
		return this;
	}

	/**
	 * Get applicableTimePeriod
	 * 
	 * @return applicableTimePeriod
	 **/
	@Schema(description = "")

	@Valid
	public ApplicableTimePeriod getApplicableTimePeriod() {
		return applicableTimePeriod;
	}

	public void setApplicableTimePeriod(ApplicableTimePeriod applicableTimePeriod) {
		this.applicableTimePeriod = applicableTimePeriod;
	}

	public ResourceCapacityDemand place(PlaceRef place) {
		this.place = place;
		return this;
	}

	/**
	 * Get place
	 * 
	 * @return place
	 **/
	@Schema(description = "")

	@Valid
	public PlaceRef getPlace() {
		return place;
	}

	public void setPlace(PlaceRef place) {
		this.place = place;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceCapacityDemand resourceCapacityDemand = (ResourceCapacityDemand) o;
		return Objects.equals(this.getBaseType(), resourceCapacityDemand.getBaseType())
				&& Objects.equals(this.getSchemaLocation(), resourceCapacityDemand.getSchemaLocation())
				&& Objects.equals(this.getType(), resourceCapacityDemand.getType())
				&& Objects.equals(this.capacityDemandAmount, resourceCapacityDemand.capacityDemandAmount)
				
				&& Objects.equals(this.applicableTimePeriod, resourceCapacityDemand.applicableTimePeriod)
				&& Objects.equals(this.place, resourceCapacityDemand.place);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBaseType(), getSchemaLocation(), getType(), capacityDemandAmount, 
				applicableTimePeriod, place);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceCapacityDemand {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(getBaseType())).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(getSchemaLocation())).append("\n");
		sb.append("    _atType: ").append(toIndentedString(getType())).append("\n");
		sb.append("    capacityDemandAmount: ").append(toIndentedString(capacityDemandAmount)).append("\n");
		
		sb.append("    applicableTimePeriod: ").append(toIndentedString(applicableTimePeriod)).append("\n");
		sb.append("    place: ").append(toIndentedString(place)).append("\n");
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
