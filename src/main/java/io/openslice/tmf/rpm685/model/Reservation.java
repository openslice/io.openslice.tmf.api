package io.openslice.tmf.rpm685.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.sim638.model.ServiceOrderRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;

/**
 * reservation api resource
 */
@Schema(description = "reservation api resource")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")

@Entity(name = "Reservation")
public class Reservation extends BaseEntity {


	@JsonProperty("id")
	private String id = null;

	@JsonProperty("relatedParty")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reserv_relParuuid", referencedColumnName = "uuid")
	private RelatedParty relatedParty = null;

	@JsonProperty("reservationState")
	private String reservationState = null;

	@JsonProperty("reservationItem")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ReservationItem> reservationItem =  new HashSet<>();


	@Column(name="reqPeriodStartDate")
	private OffsetDateTime requestedPeriodStartDateTime = null;

	@Column(name="reqPeriodEndDate")
	private OffsetDateTime requestedPeriodEndDateTime = null;


	
	
//	@JsonProperty("productOfferingRef")
//	private ProductOfferingRef productOfferingRef = null;

	@JsonProperty("serviceOrderRef")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Reserv_soRefuuid", referencedColumnName = "uuid")
	private ServiceOrderRef serviceOrderRef = null;



	/**
	 * A string. Identifier of an instance of the Reservation.
	 * 
	 * @return id
	 **/
	@Schema(description = "A string. Identifier of an instance of the Reservation.")

	public String getId() {
		id = uuid;
		return uuid;
	}
	
	
	
	

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

	/**
	 * @param serviceOrderRef the serviceOrderRef to set
	 * @return 
	 */
	public Reservation serviceOrderRef(ServiceOrderRef serviceOrderRef) {
		this.serviceOrderRef = serviceOrderRef;
		return this;
	}


	
	/**
	 * End of the time period, using IETC-RFC-3339 format
	 * 
	 * @return endDateTime
	 **/
	@Schema(description = "End of the time period, using IETC-RFC-3339 format")
	@Valid
	@JsonProperty("requestedPeriodEndDateTime")
	public String getRequestedPeriodEndDateTimeString() {
		if ( requestedPeriodEndDateTime != null) {
			return requestedPeriodEndDateTime.toString();			
		}
		return null;
	}
	
	public OffsetDateTime getRequestedPeriodEndDateTime() {
		return requestedPeriodEndDateTime;
	}

	public void setRequestedPeriodEndDateTime(OffsetDateTime endDateTime) {
		this.requestedPeriodEndDateTime = endDateTime;
	}

	public Reservation requestedPeriodStartDateTime(OffsetDateTime startDateTime) {
		this.requestedPeriodStartDateTime = startDateTime;
		return this;
	}


	public void setRequestedPeriodEndDateTime(String endDateTime) {
		this.requestedPeriodEndDateTime = OffsetDateTime.parse( endDateTime );
	}

	


	
	/**
	 * Start of the time period, using IETC-RFC-3339 format. If you define a start,
	 * you must also define an end
	 * 
	 * @return startDateTime
	 **/
	@Schema(description = "Start of the time period, using IETC-RFC-3339 format. If you define a start, you must also define an end")
	@Valid
	@JsonProperty("requestedPeriodStartDateTime")
	public String getRequestedPeriodStartDateTimeString() {
		if ( requestedPeriodStartDateTime != null) {
			return requestedPeriodStartDateTime.toString();			
		}
		return null;			
		
	}
	
	public OffsetDateTime getRequestedPeriodStartDateTime() {
		return requestedPeriodStartDateTime;
	}
	
	
	public void setRequestedPeriodStartDateTime(OffsetDateTime startDateTime) {
		this.requestedPeriodStartDateTime = startDateTime;
	}
	
	public void setRequestedPeriodStartDateTime(String startDateTime) {
		if ( startDateTime!= null ) {
			this.requestedPeriodStartDateTime = OffsetDateTime.parse( startDateTime );
		}
	}
	
	
	

	public Reservation relatedParty(RelatedParty relatedParty) {
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

	public Reservation reservationState(String reservationState) {
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

	public Reservation reservationItem(Set<ReservationItem> reservationItem) {
		this.reservationItem = reservationItem;
		return this;
	}

	public Reservation addReservationItemItem(ReservationItem reservationItemItem) {
		if (this.reservationItem == null) {
			this.reservationItem = new HashSet<>();
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
	public Set<ReservationItem> getReservationItem() {
		return reservationItem;
	}

	public void setReservationItem(Set<ReservationItem> reservationItem) {
		this.reservationItem = reservationItem;
	}

	

//	public Reservation requestedPeriod(TimePeriod requestedPeriod) {
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
//	public TimePeriod getRequestedPeriod() {
//		return requestedPeriod;
//	}
//
//	public void setRequestedPeriod(TimePeriod requestedPeriod) {
//		this.requestedPeriod = requestedPeriod;
//	}

//	public Reservation productOfferingRef(ProductOfferingRef productOfferingRef) {
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
		Reservation reservation = (Reservation) o;
		return Objects.equals(this.getBaseType(), reservation.getBaseType())
				&& Objects.equals(this.getSchemaLocation(), reservation.getSchemaLocation())
				&& Objects.equals(this.getType(), reservation.getType())
				&& Objects.equals(this.description, reservation.description)
				&& Objects.equals(this.href, reservation.href) && Objects.equals(this.id, reservation.id)
				&& Objects.equals(this.relatedParty, reservation.relatedParty)
				&& Objects.equals(this.reservationState, reservation.reservationState)
				&& Objects.equals(this.validFor, reservation.validFor)
				&& Objects.equals(this.reservationItem, reservation.reservationItem);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBaseType(), getSchemaLocation(), getType(), description, href, id, relatedParty,
				reservationState, validFor, reservationItem);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Reservation {\n");

		sb.append("    _atBaseType: ").append(toIndentedString(getBaseType())).append("\n");
		sb.append("    _atSchemaLocation: ").append(toIndentedString(getSchemaLocation())).append("\n");
		sb.append("    _atType: ").append(toIndentedString(getType())).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
