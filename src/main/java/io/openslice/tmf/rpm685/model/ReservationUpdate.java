package io.openslice.tmf.rpm685.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.sim638.model.ServiceOrderRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * reservation api resource Skipped properties: id,href
 */
/**
 * @author ctranoris
 *
 */
@Schema(description = "reservation api resource Skipped properties: id,href")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
public class ReservationUpdate {
	@JsonProperty("@baseType")
	private String _atBaseType = null;

	@JsonProperty("@schemaLocation")
	private String _atSchemaLocation = null;

	@JsonProperty("@type")
	private String _atType = null;
	


	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("relatedParty")
	private RelatedParty relatedParty = null;

	@JsonProperty("reservationState")
	private String reservationState = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("reservationItem")
	@Valid
	private List<ReservationItem> reservationItem = null;

//  @JsonProperty("channelRef")
//  private ChannelRef channelRef = null;

//  @JsonProperty("requestedPeriod")
//  private RequestedPeriod requestedPeriod = null;

//  @JsonProperty("productOfferingRef")
//  private ProductOfferingRef productOfferingRef = null;

	private OffsetDateTime requestedPeriodEndDateTime = null;

	private OffsetDateTime requestedPeriodStartDateTime = null;

	@JsonProperty("serviceOrderRef")
	private ServiceOrderRef serviceOrderRef = null;

	/**
	 * @return the serviceOrderRef
	 */
	public ServiceOrderRef getServiceOrderRef() {
		return serviceOrderRef;
	}

	/**
	 * @param serviceOrderRef the serviceOrderRef to set
	 */
	public void setServiceOrderRef(ServiceOrderRef serviceOrderRef) {
		this.serviceOrderRef = serviceOrderRef;
	}

	public ReservationUpdate serviceOrderRef(ServiceOrderRef serviceOrderRef) {
		this.serviceOrderRef = serviceOrderRef;
		return this;
	}

	@JsonProperty("requestedPeriodEndDateTime")
	public String getRequestedPeriodEndDateTimeStr() {
		if (requestedPeriodEndDateTime != null) {
			return requestedPeriodEndDateTime.toString();
		} else {
			return null;
		}
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
	 * @return the requestedPeriodEndDateTime
	 */
	public OffsetDateTime getRequestedPeriodEndDateTime() {
		return requestedPeriodEndDateTime;
	}

	/**
	 * @param requestedPeriodEndDateTime the requestedPeriodEndDateTime to set
	 */
	public void setRequestedPeriodEndDateTime(OffsetDateTime requestedPeriodEndDateTime) {
		this.requestedPeriodEndDateTime = requestedPeriodEndDateTime;
	}
	
	
	public ReservationUpdate requestedPeriodEndDateTime(OffsetDateTime requestedPeriodEndDateTime) {
		this.requestedPeriodEndDateTime = requestedPeriodEndDateTime;
		return this;
	}

	public void setRequestedPeriodEndDateTime(String requestedPeriodEndDateTime) {

		if (requestedPeriodEndDateTime != null) {
			this.requestedPeriodEndDateTime = OffsetDateTime.parse(requestedPeriodEndDateTime);

		}
	}

	/**
	 * @return the requestedPeriodStartDateTime
	 */
	public OffsetDateTime getRequestedPeriodStartDateTime() {
		return requestedPeriodStartDateTime;
	}

	/**
	 * @param requestedPeriodStartDateTime the requestedPeriodStartDateTime to set
	 */
	public void setRequestedPeriodStartDateTime(OffsetDateTime requestedPeriodStartDateTime) {
		this.requestedPeriodStartDateTime = requestedPeriodStartDateTime;
	}
	
	public ReservationUpdate requestedPeriodStartDateTime(OffsetDateTime requestedPeriodStartDateTime) {
		this.requestedPeriodStartDateTime = requestedPeriodStartDateTime;
		return this;
	}

	@JsonProperty("requestedPeriodStartDateTime")
	public String getRequestedPeriodStartDateTimeStr() {
		if (requestedPeriodStartDateTime != null) {
			return requestedPeriodStartDateTime.toString();
		} else {
			return null;
		}
	}

	public void setRequestedPeriodStartDateTime(String requestedPeriodStartDateTime) {

		if (requestedPeriodStartDateTime != null) {
			this.requestedPeriodStartDateTime = OffsetDateTime.parse(requestedPeriodStartDateTime);

		}
	}

	public ReservationUpdate _atBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
		return this;
	}

	/**
	 * Get _atBaseType
	 * 
	 * @return _atBaseType
	 **/
	@Schema(description = "")

	public String getAtBaseType() {
		return _atBaseType;
	}

	public void setAtBaseType(String _atBaseType) {
		this._atBaseType = _atBaseType;
	}

	public ReservationUpdate _atSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
		return this;
	}

	/**
	 * A string. Generic attribute containing the link to the schema that defines
	 * the structure of the class type of the current object.
	 * 
	 * @return _atSchemaLocation
	 **/
	@Schema(description = "A string. Generic attribute containing the link to the schema that defines the structure of the class type of the current object.")

	public String getAtSchemaLocation() {
		return _atSchemaLocation;
	}

	public void setAtSchemaLocation(String _atSchemaLocation) {
		this._atSchemaLocation = _atSchemaLocation;
	}

	public ReservationUpdate _atType(String _atType) {
		this._atType = _atType;
		return this;
	}

	/**
	 * A string. Indicates the (class) type of reservation. Ex.
	 * serviceItemReservation, resourceItemReservation
	 * 
	 * @return _atType
	 **/
	@Schema(description = "A string. Indicates the (class) type of reservation. Ex. serviceItemReservation, resourceItemReservation")

	public String getAtType() {
		return _atType;
	}

	public void setAtType(String _atType) {
		this._atType = _atType;
	}

	public ReservationUpdate description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A string. free-text description of the reservation.
	 * 
	 * @return description
	 **/
	@Schema(description = "A string. free-text description of the reservation.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReservationUpdate relatedParty(RelatedParty relatedParty) {
		this.relatedParty = relatedParty;
		return this;
	}

	/**
	 * Get relatedParty
	 * 
	 * @return relatedParty
	 **/
	@Schema(description = "")

	@Valid
	public RelatedParty getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(RelatedParty relatedParty) {
		this.relatedParty = relatedParty;
	}

	public ReservationUpdate reservationState(String reservationState) {
		this.reservationState = reservationState;
		return this;
	}

	/**
	 * A string. The life cycle state of the reservation.
	 * 
	 * @return reservationState
	 **/
	@Schema(description = "A string. The life cycle state of the reservation.")

	public String getReservationState() {
		return reservationState;
	}

	public void setReservationState(String reservationState) {
		this.reservationState = reservationState;
	}

	public ReservationUpdate validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period of time for which the reservation is applicable.
	 * 
	 * @return validFor
	 **/
	@Schema(description = "The period of time for which the reservation is applicable.")

	@Valid
	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ReservationUpdate reservationItem(List<ReservationItem> reservationItem) {
		this.reservationItem = reservationItem;
		return this;
	}

	public ReservationUpdate addReservationItemItem(ReservationItem reservationItemItem) {
		if (this.reservationItem == null) {
			this.reservationItem = new ArrayList<>();
		}
		this.reservationItem.add(reservationItemItem);
		return this;
	}

	/**
	 * Get reservationItem
	 * 
	 * @return reservationItem
	 **/
	@Schema(description = "")
	@Valid
	public List<ReservationItem> getReservationItem() {
		return reservationItem;
	}

	public void setReservationItem(List<ReservationItem> reservationItem) {
		this.reservationItem = reservationItem;
	}

//	public ReservationUpdate channelRef(ChannelRef channelRef) {
//		this.channelRef = channelRef;
//		return this;
//	}
//
//	/**
//	 * Get channelRef
//	 * 
//	 * @return channelRef
//	 **/
//	@Schema(description = "")
//
//	@Valid
//	public ChannelRef getChannelRef() {
//		return channelRef;
//	}
//
//	public void setChannelRef(ChannelRef channelRef) {
//		this.channelRef = channelRef;
//	}
//
//	public ReservationUpdate requestedPeriod(RequestedPeriod requestedPeriod) {
//		this.requestedPeriod = requestedPeriod;
//		return this;
//	}
//
//	/**
//	 * Get requestedPeriod
//	 * 
//	 * @return requestedPeriod
//	 **/
//	@Schema(description = "")
//
//	@Valid
//	public RequestedPeriod getRequestedPeriod() {
//		return requestedPeriod;
//	}
//
//	public void setRequestedPeriod(RequestedPeriod requestedPeriod) {
//		this.requestedPeriod = requestedPeriod;
//	}
//
//	public ReservationUpdate productOfferingRef(ProductOfferingRef productOfferingRef) {
//		this.productOfferingRef = productOfferingRef;
//		return this;
//	}
//
//	/**
//	 * Get productOfferingRef
//	 * 
//	 * @return productOfferingRef
//	 **/
//	@Schema(description = "")
//
//	@Valid
//	public ProductOfferingRef getProductOfferingRef() {
//		return productOfferingRef;
//	}
//
//	public void setProductOfferingRef(ProductOfferingRef productOfferingRef) {
//		this.productOfferingRef = productOfferingRef;
//	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReservationUpdate reservationUpdate = (ReservationUpdate) o;
		return Objects.equals(this._atBaseType, reservationUpdate._atBaseType)
				&& Objects.equals(this._atSchemaLocation, reservationUpdate._atSchemaLocation)
				&& Objects.equals(this._atType, reservationUpdate._atType)
				&& Objects.equals(this.description, reservationUpdate.description)
				&& Objects.equals(this.relatedParty, reservationUpdate.relatedParty)
				&& Objects.equals(this.reservationState, reservationUpdate.reservationState)
				&& Objects.equals(this.validFor, reservationUpdate.validFor)
				&& Objects.equals(this.reservationItem, reservationUpdate.reservationItem);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atBaseType, _atSchemaLocation, _atType, description, relatedParty, reservationState,
				validFor, reservationItem);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReservationUpdate {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
		sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
		sb.append("    reservationState: ").append(toIndentedString(reservationState)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    reservationItem: ").append(toIndentedString(reservationItem)).append("\n");
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
