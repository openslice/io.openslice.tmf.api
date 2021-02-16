package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.UnAckAlarms;

@Repository
public interface UnAckAlarmsRepository  extends PagingAndSortingRepository<UnAckAlarms, Long> {

	
	Optional<UnAckAlarms> findByUuid(String id);

	
}
