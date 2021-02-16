package io.openslice.tmf.am642.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.am642.model.CommentAlarms;

@Repository
public interface CommentAlarmsRepository  extends PagingAndSortingRepository<CommentAlarms, Long> {

	
	Optional<CommentAlarms> findByUuid(String id);

	
}
