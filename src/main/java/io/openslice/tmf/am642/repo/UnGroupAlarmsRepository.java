package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.UnGroupAlarms;

@Repository
public interface UnGroupAlarmsRepository  extends PagingAndSortingRepository<UnGroupAlarms, Long> {

	
	Optional<UnGroupAlarms> findByUuid(String id);

	
}
