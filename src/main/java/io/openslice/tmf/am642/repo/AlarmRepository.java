package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.Alarm;

@Repository
public interface AlarmRepository  extends PagingAndSortingRepository<Alarm, Long> {

	
	Optional<Alarm> findByUuid(String id);

	
}
