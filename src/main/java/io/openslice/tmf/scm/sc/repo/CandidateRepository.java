package io.openslice.tmf.scm.sc.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.scm.model.ServiceCandidate;


@Repository
public interface CandidateRepository extends PagingAndSortingRepository<ServiceCandidate, Long> {

	
	Optional<ServiceCandidate> findById(String id);

}
