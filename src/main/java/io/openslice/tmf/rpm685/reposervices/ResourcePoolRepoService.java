package io.openslice.tmf.rpm685.reposervices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.rpm685.model.AvailabilityCheck;
import io.openslice.tmf.rpm685.model.AvailabilityCheckCreate;
import io.openslice.tmf.rpm685.model.ExtractCreate;
import io.openslice.tmf.rpm685.model.PushCreate;
import io.openslice.tmf.rpm685.model.Reservation;
import io.openslice.tmf.rpm685.model.ReservationStateType;
import io.openslice.tmf.rpm685.model.ResourcePool;
import io.openslice.tmf.rpm685.model.ResourcePoolCreate;
import io.openslice.tmf.rpm685.model.ResourcePoolMapper;
import io.openslice.tmf.rpm685.model.ResourcePoolUpdate;
import io.openslice.tmf.rpm685.repo.ResourcePoolRepository;

/**
 * @author ctranoris
 *
 */
@org.springframework.stereotype.Service
public class ResourcePoolRepoService {

	private static final transient Log logger = LogFactory.getLog(ResourcePoolRepoService.class.getName());

	@Autowired
	ResourcePoolRepository resourcePoolRepo;

	@Autowired
	private ResourceReservationRepoService resourceReservationRepoService;

	public ResourcePool addResourcePool(@Valid ResourcePoolCreate body) {
		logger.info("Will add Resource Pool: " + body.getName());

		ResourcePool rp = new ResourcePool();
		ResourcePoolMapper mapper = Mappers.getMapper(ResourcePoolMapper.class);
		rp = mapper.fromResourcePoolDTO(body);

		rp = this.resourcePoolRepo.save(rp);
		return rp;
	}

	@Transactional
	public ResourcePool updateResourcePool(String id, @Valid ResourcePoolUpdate body) {
		ResourcePool rp = this.findByUuid(id);

		ResourcePoolMapper mapper = Mappers.getMapper(ResourcePoolMapper.class);
		rp = mapper.updateResourcePool(rp, body);
		rp = this.resourcePoolRepo.save(rp);
		return rp;
	}

	public ResourcePool findByUuid(String id) {
		Optional<ResourcePool> optionalCat = this.resourcePoolRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public List<ResourcePool> findAll() {
		return (List<ResourcePool>) this.resourcePoolRepo.findAll();
	}

	public AvailabilityCheck availabilityCheck(@Valid AvailabilityCheckCreate acReq) {
		AvailabilityCheck ac = new AvailabilityCheck();
		if ( acReq.getResourceCapacityDemand() == null ) {
			return ac;			
		}
		ResourcePool rp = this.findByUuid( acReq.getResourceCapacityDemand().getResourcePool().getId() );
		if (rp == null) {
			ac.setAvailableResources( new ArrayList<>());
			return ac;
		}
		
		//dummy for now return any form the Set
		ac.setAvailableResources( new ArrayList<>() );
		
		if (  acReq.getResourceCapacityDemand().getResources() != null && acReq.getResourceCapacityDemand().getResources().size()>0) {
			for (ResourceRef rRef : acReq.getResourceCapacityDemand().getResources()) {
				
				Reservation aReservation = resourceReservationRepoService.reserveResource( rRef.getId(), 
						acReq.getResourceCapacityDemand().getApplicableTimePeriod().getFromDateTime(),
						acReq.getResourceCapacityDemand().getApplicableTimePeriod().getEndDateTime()
						);
				if ( aReservation!=null && 
						aReservation.getReservationState().equals( ReservationStateType.COMPLETED.toString() )) {
					ac.getAvailableResources().add( rRef );				
				}
			}			
		} else { //search availability of each resource in the pool
			
			for (ResourceRef rRef : rp.getCapacity().getResources() ) {
				
				Reservation aReservation = resourceReservationRepoService.reserveResource( rRef.getId(), 
						acReq.getResourceCapacityDemand().getApplicableTimePeriod().getFromDateTime(),
						acReq.getResourceCapacityDemand().getApplicableTimePeriod().getEndDateTime()
						);
				if ( aReservation!=null && 
						aReservation.getReservationState().equals( ReservationStateType.COMPLETED.toString() )) {
					ac.getAvailableResources().add( rRef );				
				}
			}
			
		}
		
		
		return ac;
	}

	/**
	 * @param push
	 * @return
	 */
	public ResourcePool push(@Valid PushCreate push) {
		var resourcePool = findByUuid(push.getResourcePool().getId());
		if (resourcePool == null) {
			return null;
		}

		ResourcePoolUpdate ru = new ResourcePoolUpdate();
		ru.setCapacity(resourcePool.getCapacity());
		ru.getCapacity()
				.setCapacityAmount(ru.getCapacity().getCapacityAmount() + push.getCapacity().getCapacityAmount());
		ru.getCapacity().getResources().addAll(resourcePool.getCapacity().getResources());
		ru.getCapacity().getResources().addAll(push.getCapacity().getResources());

		return updateResourcePool(resourcePool.getId(), ru);
	}

	public ResourcePool extract(@Valid ExtractCreate extr) {
		var resourcePool = findByUuid( extr.getResourcePool().getId());
		if (resourcePool == null) {
			return null;
		}

		ResourcePoolUpdate ru = new ResourcePoolUpdate();
		ru.setCapacity( resourcePool.getCapacity() );		
		ru.getCapacity().setCapacityAmount( ru.getCapacity().getCapacityAmount() - extr.getCapacity().getCapacityAmount());
		ru.getCapacity().getResources().addAll( resourcePool.getCapacity().getResources() );
		List<ResourceRef> toremove = new ArrayList<>();
		for (ResourceRef refExt : extr.getCapacity().getResources()) {
			for (ResourceRef refPool : ru.getCapacity().getResources()) {
				if ( refExt.getId().equals(refPool.getId() ) ) {
					toremove.add(refPool);					
				}
				
			}
		}
		
		for (ResourceRef resourceRef : toremove) {
			ru.getCapacity().getResources().remove(resourceRef);
		}
		
		
		return updateResourcePool(resourcePool.getId(), ru);
	}

	public Set<ResourcePool> findResourceRefinPools(@NotNull String resourceRefId) {
		return this.resourcePoolRepo.findByResourceId( resourceRefId ) ;
		
	}

	public Void deleteByUuid(String id) {
		Optional<ResourcePool> optionalCat = this.resourcePoolRepo.findByUuid(id);
		ResourcePool s = optionalCat.get();
		if (s == null) {
			return null;
		}

		this.resourcePoolRepo.delete( s );
		return null;
	}

}
