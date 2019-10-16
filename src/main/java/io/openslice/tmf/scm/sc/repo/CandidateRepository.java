package io.openslice.tmf.scm.sc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.scm.model.ServiceCandidate;


@Repository
public interface CandidateRepository extends PagingAndSortingRepository<ServiceCandidate, Long> {

	
	Optional<ServiceCandidate> findByUuid(String id);

	@Query("SELECT sc FROM ServiceCandidate sc JOIN FETCH sc.serviceSpecificationObj spec WHERE spec.uuid = ?1")
	Optional<ServiceCandidate> findByServiceSpecUuid(String id);

}
