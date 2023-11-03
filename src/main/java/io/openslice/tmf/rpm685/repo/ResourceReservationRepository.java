package io.openslice.tmf.rpm685.repo;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.openslice.tmf.rpm685.model.Reservation;
import jakarta.validation.Valid;


/**
 * @author ctranoris
 *
 */
public interface ResourceReservationRepository extends CrudRepository<Reservation, Long>, PagingAndSortingRepository<Reservation, Long> {

	Optional<Reservation> findByUuid(String id);

	
	@Query("SELECT reserv FROM Reservation reserv "
			+ "JOIN FETCH reserv.reservationItem ri "
			+ "JOIN FETCH ri.appliedCapacityAmount apcm "
			+ "JOIN FETCH apcm.resources resrc "
			+ "JOIN FETCH apcm.resourceCapacityDemand resCapacityDem "
			+ "JOIN FETCH resCapacityDem.applicableTimePeriod timePeriod "
			+ "WHERE resrc.id = ?1")
	List<Reservation> findAll2(String id);
	
//	@Query("SELECT reserv FROM Reservation reserv "
//			+ "JOIN FETCH reserv.reservationItem ri "
//			+ "JOIN FETCH ri.appliedCapacityAmount apcm "
//			+ "JOIN FETCH apcm.resources resrc "
//			+ "JOIN FETCH apcm.resourceCapacityDemand resCapacityDem "
//			+ "JOIN FETCH resCapacityDem.applicableTimePeriod timePeriod "
//			+ "WHERE resrc.id = ?1 AND "
//			+ "timePeriod.fromDateTime<=?2 AND "
//			+ "timePeriod.endDateTime>=?2")
//	Set<Reservation> findResourceReservationsThatIncludeFromDateTime(String resourceId,
//			@Valid OffsetDateTime requestedfromDateTime);
//	
//	@Query("SELECT reserv FROM Reservation reserv "
//			+ "JOIN FETCH reserv.reservationItem ri "
//			+ "JOIN FETCH ri.appliedCapacityAmount apcm "
//			+ "JOIN FETCH apcm.resources resrc "
//			+ "JOIN FETCH apcm.resourceCapacityDemand resCapacityDem "
//			+ "JOIN FETCH resCapacityDem.applicableTimePeriod timePeriod "
//			+ "WHERE resrc.id = ?1 AND "
//			+ "timePeriod.fromDateTime<=?2 AND "
//			+ "timePeriod.endDateTime>=?2")
//	Set<Reservation> findResourceReservationsThatIncludeEndDateTime(String resourceId,
//			@Valid OffsetDateTime requestedendDateTime);
//	
//	
//	@Query("SELECT reserv FROM Reservation reserv "
//			+ "JOIN FETCH reserv.reservationItem ri "
//			+ "JOIN FETCH ri.appliedCapacityAmount apcm "
//			+ "JOIN FETCH apcm.resources resrc "
//			+ "JOIN FETCH apcm.resourceCapacityDemand resCapacityDem "
//			+ "JOIN FETCH resCapacityDem.applicableTimePeriod timePeriod "
//			+ "WHERE resrc.id = ?1 AND "
//			+ "timePeriod.fromDateTime>=?2 AND timePeriod.endDateTime>=?2  AND "
//			+ "timePeriod.fromDateTime<=?3 AND timePeriod.endDateTime<=?3  ")
//	Set<Reservation> findResourceReservationsThatIncludeDates(String resourceId,
//			@Valid OffsetDateTime requestedfromDateTime, 
//			@Valid OffsetDateTime requestedendDateTime);
	
	
	
	@Query("SELECT reserv FROM Reservation reserv "
			+ "JOIN FETCH reserv.reservationItem ri "
			+ "JOIN FETCH ri.appliedCapacityAmount apcm "
			+ "JOIN FETCH apcm.resources resrc "
			+ "JOIN FETCH apcm.resourceCapacityDemand resCapacityDem "
			+ "JOIN FETCH resCapacityDem.applicableTimePeriod timePeriod "
			+ "WHERE resrc.id = ?1 AND ("
			+ "(timePeriod.fromDateTime<=?2 AND timePeriod.endDateTime>=?2) OR "
			+ "(timePeriod.fromDateTime<=?3 AND timePeriod.endDateTime>=?3) OR "
			+ "(timePeriod.fromDateTime>=?2 AND timePeriod.endDateTime>=?2  AND "
			+ "timePeriod.fromDateTime<=?3 AND timePeriod.endDateTime<=?3) "
			+ ") ")
	Set<Reservation> findResourceReservationsForDates(String resourceId,
			@Valid OffsetDateTime requestedfromDateTime, 
			@Valid OffsetDateTime requestedendDateTime);
	
	

}
