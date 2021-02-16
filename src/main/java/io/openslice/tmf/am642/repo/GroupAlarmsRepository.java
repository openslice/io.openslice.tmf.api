package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.CommentAlarms;
import io.openslice.tmf.am642.model.GroupAlarms;

@Repository
public interface GroupAlarmsRepository  extends PagingAndSortingRepository<GroupAlarms, Long> {

	
	Optional<GroupAlarms> findByUuid(String id);

	
}
