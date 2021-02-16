package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.AckAlarms;

@Repository
public interface AckAlarmsRepository  extends PagingAndSortingRepository<AckAlarms, Long> {

	
	Optional<AckAlarms> findByUuid(String id);

	
}
