package io.openslice.tmf.rpm685.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * An identified part of the reservation. A reservation is decomposed into one
 * or more reservation items.
 */
@Schema(description = "An identified part of the reservation. A reservation is decomposed into one or more reservation items.")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")

@Entity(name = "ReservationItem")
public class ReservationItem extends BaseRootEntity {

	@JsonProperty("quantity")
	private Integer quantity = null;

	@JsonProperty("subReservationState")
	private String subReservationState = null;

	@JsonProperty("resourceCapacity")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservitem_resrcapuuid", referencedColumnName = "uuid")
	private ResourceCapacityDemand resourceCapacity = null;

	@JsonProperty("appliedCapacityAmount")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservitem_appliedcapuuid", referencedColumnName = "uuid")
	private AppliedCapacityAmount appliedCapacityAmount = null;

	public ReservationItem quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Represents the number of reservationItems that make up the reservation.
	 * 
	 * @return quantity
	 **/
	@Schema(description = "Represents the number of reservationItems that make up the reservation.")

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ReservationItem subReservationState(String subReservationState) {
		this.subReservationState = subReservationState;
		return this;
	}

	/**
	 * A string. The life cycle state of the each reservation item.
	 * 
	 * @return subReservationState
	 **/
	@Schema(description = "A string. The life cycle state of the each reservation item.")

	public String getSubReservationState() {
		return subReservationState;
	}

	public void setSubReservationState(String subReservationState) {
		this.subReservationState = subReservationState;
	}

	public ReservationItem resourceCapacity(ResourceCapacityDemand resourceCapacity) {
		this.resourceCapacity = resourceCapacity;
		return this;
	}

	/**
	 * Get resourceCapacity
	 * 
	 * @return resourceCapacity
	 **/
	@Schema(description = "")

	@Valid
	public ResourceCapacityDemand getResourceCapacity() {
		return resourceCapacity;
	}

	public void setResourceCapacity(ResourceCapacityDemand resourceCapacity) {
		this.resourceCapacity = resourceCapacity;
	}

	public ReservationItem appliedCapacityAmount(AppliedCapacityAmount appliedCapacityAmount) {
		this.appliedCapacityAmount = appliedCapacityAmount;
		return this;
	}

	/**
	 * Get appliedCapacityAmount
	 * 
	 * @return appliedCapacityAmount
	 **/
	@Schema(description = "")

	@Valid
	public AppliedCapacityAmount getAppliedCapacityAmount() {
		return appliedCapacityAmount;
	}

	public void setAppliedCapacityAmount(AppliedCapacityAmount appliedCapacityAmount) {
		this.appliedCapacityAmount = appliedCapacityAmount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReservationItem reservationItem = (ReservationItem) o;
		return Objects.equals(this.getBaseType(), reservationItem.getBaseType())
				&& Objects.equals(this.getSchemaLocation(), reservationItem.getSchemaLocation())
				&& Objects.equals(this.getType(), reservationItem.getType())
				&& Objects.equals(this.quantity, reservationItem.quantity)
				&& Objects.equals(this.subReservationState, reservationItem.subReservationState)
				&& Objects.equals(this.resourceCapacity, reservationItem.resourceCapacity)
				&& Objects.equals(this.appliedCapacityAmount, reservationItem.appliedCapacityAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBaseType(), getSchemaLocation(), getType(), quantity, subReservationState, resourceCapacity,
				appliedCapacityAmount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReservationItem {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(getBaseType())).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(getSchemaLocation())).append("\n");
		sb.append("    _atType: ").append(toIndentedString(getType())).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    subReservationState: ").append(toIndentedString(subReservationState)).append("\n");
		sb.append("    resourceCapacity: ").append(toIndentedString(resourceCapacity)).append("\n");
		sb.append("    appliedCapacityAmount: ").append(toIndentedString(appliedCapacityAmount)).append("\n");
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
