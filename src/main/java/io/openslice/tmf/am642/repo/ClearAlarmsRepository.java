package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.ClearAlarms;

@Repository
public interface ClearAlarmsRepository  extends PagingAndSortingRepository<ClearAlarms, Long> {

	
	Optional<ClearAlarms> findByUuid(String id);

	
}
