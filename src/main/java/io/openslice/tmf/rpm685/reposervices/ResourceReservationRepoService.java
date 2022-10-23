package io.openslice.tmf.rpm685.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.rpm685.model.ApplicableTimePeriod;
import io.openslice.tmf.rpm685.model.AppliedCapacityAmount;
import io.openslice.tmf.rpm685.model.AvailabilityCheck;
import io.openslice.tmf.rpm685.model.AvailabilityCheckCreate;
import io.openslice.tmf.rpm685.model.Reservation;
import io.openslice.tmf.rpm685.model.ReservationCreate;
import io.openslice.tmf.rpm685.model.ReservationItem;
import io.openslice.tmf.rpm685.model.ReservationMapper;
import io.openslice.tmf.rpm685.model.ReservationStateType;
import io.openslice.tmf.rpm685.model.ReservationUpdate;
import io.openslice.tmf.rpm685.model.ResourceCapacityDemand;
import io.openslice.tmf.rpm685.model.ResourcePoolRef;
import io.openslice.tmf.rpm685.repo.ResourceReservationRepository;

/**
 * @author ctranoris
 *
 */
@org.springframework.stereotype.Service
public class ResourceReservationRepoService {

	private static final transient Log logger = LogFactory.getLog( ResourceReservationRepoService.class.getName());

	@Autowired
	ResourceReservationRepository resourceReservationRepository;

	@Autowired
	ResourcePoolRepoService resourcePoolRepoService;
	

	public Reservation addReservation(@Valid ReservationCreate body) {
		logger.info("Will add Resource Reservation: " + body.getDescription() );
		
		Reservation rp = new Reservation();
		ReservationMapper mapper = Mappers.getMapper( ReservationMapper.class);
		rp = mapper.fromReservationDTO(body);
		
		rp.setReservationState( ReservationStateType.COMPLETED.toString() );
		
		
		for (ReservationItem ri : rp.getReservationItem()) {
			AppliedCapacityAmount apCapAm = new AppliedCapacityAmount();
			apCapAm.setAppliedDemandAmount( ri.getResourceCapacity().getCapacityDemandAmount());
			apCapAm.getResource().addAll( ri.getResourceCapacity().getResourcePool().getResources() );

			ResourceCapacityDemand resCap = new ResourceCapacityDemand();
			ApplicableTimePeriod applicableTimePeriod = new ApplicableTimePeriod();
			applicableTimePeriod.setFromDateTime( rp.getRequestedPeriodStartDateTime().minusSeconds(1)  );
			applicableTimePeriod.setEndDateTime( rp.getRequestedPeriodEndDateTime().plusSeconds(1) );
			resCap.applicableTimePeriod( applicableTimePeriod  );
			apCapAm.setResourceCapacityDemand(resCap);
			ri.appliedCapacityAmount( apCapAm );
		
			@Valid
			AvailabilityCheckCreate acreq = new AvailabilityCheckCreate();
			ResourceCapacityDemand rcd = resCap;
			acreq.setResourceCapacityDemand(rcd);
			rcd.setResourcePool(ri.getResourceCapacity().getResourcePool());
			Set<ResourceRef> resourcesToReserve = new HashSet<>();
			resourcesToReserve.addAll( ri.getResourceCapacity().getResourcePool().getResources() );
			rcd.setResources( resourcesToReserve  );
			

			AvailabilityCheck respAvailabilityCheck = resourcePoolRepoService.availabilityCheck(acreq );
			if ( respAvailabilityCheck.getAvailableResources().size() == 0 ) {
				rp.setReservationState( ReservationStateType.REJECTED.toString() );
				return rp;
			}
		
		}
		
				
		
		rp = this.resourceReservationRepository.save( rp );
		return rp;
	}

	public Reservation findByUuid(String id) {
		Optional<Reservation> optionalCat = this.resourceReservationRepository.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public List<Reservation> findAll() {
		return (List<Reservation>) this.resourceReservationRepository.findAll();
	}

	public Reservation updateReservation(String id, @Valid ReservationUpdate body) {
		Reservation rp = this.findByUuid(id);
		

		ReservationMapper mapper = Mappers.getMapper( ReservationMapper.class);
		rp = mapper.updateReservation(rp, body) ;
		rp = this.resourceReservationRepository.save( rp );
		return rp;
	}

	/**
	 * @param resourceId
	 * @param fromDateTime
	 * @param endDateTime
	 * @return a nre reservation if it is OK with dates otherwise returns one that is rejected
	 */
	public Reservation reserveResource(@NotNull String resourceId, @Valid OffsetDateTime fromDateTime,
			@Valid OffsetDateTime endDateTime) {

		//find any reservations of that resource in the specific period
		//we must not find any reservation that its fromDateTime is between requestedFromDateTime and requested EndDateTime
		//we must not find any reservation that its endDateTime is is between requestedFromDateTime and requested EndDateTime
		//find any reservations that include the fromDateTime


		
		Set<Reservation> result1 = this.resourceReservationRepository.findAll();
		Set<Reservation> result11 = this.resourceReservationRepository.findAll2( resourceId );
//		Set<Reservation> result2 = this.resourceReservationRepository
//				.findResourceReservationsThatIncludeFromDateTime(resourceId, fromDateTime);
//		Set<Reservation> result3 = this.resourceReservationRepository
//				.findResourceReservationsThatIncludeEndDateTime(resourceId,  endDateTime);
//		Set<Reservation> result4 = this.resourceReservationRepository
//				.findResourceReservationsThatIncludeDates(resourceId, fromDateTime, endDateTime);
//		Set<Reservation> result5 = this.resourceReservationRepository
//		.findResourceReservationsThatIncludeDates(resourceId, fromDateTime, endDateTime);
		Set<Reservation> result = this.resourceReservationRepository
		.findResourceReservationsForDates(resourceId, fromDateTime, endDateTime);

		logger.info("reqFrom %s, reqEnd %s".formatted(fromDateTime, endDateTime));
		if ( result1.size() >0 ) {
			@Valid
			ApplicableTimePeriod period = result1.stream().findFirst().get()
					.getReservationItem().stream().findFirst().get()
					.getAppliedCapacityAmount().getResourceCapacityDemand().getApplicableTimePeriod();
			logger.info("reservationFROM %s, reservationEND %s".formatted(
						period.getFromDateTime() , 
						period.getEndDateTime()));			
		}
		
		logger.info("result1 %s".formatted(result1.size()));
		logger.info("result11 %s".formatted(result11.size()));
//		logger.info("result2 %s".formatted(result2.size()));
//		logger.info("result3 %s".formatted(result3.size()));
//		logger.info("result4 %s".formatted(result4.size()));
//		logger.info("result5 %s".formatted(result5.size()));
		logger.info("result %s".formatted(result.size()));
		
		
		//if result is 0 then create a new reservation for that specific dates
		
		Reservation aReservation = new Reservation();
		//if ( result2.size() == 0 && result3.size() == 0 && result4.size() == 0 && result5.size() == 0) {
		if ( result.size() == 0) {
			aReservation.setReservationState( ReservationStateType.COMPLETED.toString());			
		}  else {
			aReservation.setReservationState( ReservationStateType.REJECTED.toString());
		}
		
		
		
		return aReservation;
	}
}
