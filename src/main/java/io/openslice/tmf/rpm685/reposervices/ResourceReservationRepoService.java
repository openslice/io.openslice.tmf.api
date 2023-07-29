package io.openslice.tmf.rpm685.reposervices;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import io.openslice.tmf.rpm685.repo.ResourceReservationRepository;
import jakarta.validation.Valid;

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
		
		//re-calculate the reservation
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

	

	public Void deleteByUuid(String id) {
		Reservation s = this.findByUuid(id);
		if (s == null) {
			return null;
		}

		this.resourceReservationRepository.delete( s );
		return null;
	}
}
