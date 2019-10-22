package io.openslice.tmf.rcm634.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rcm634.model.ResourceCandidate;


@Repository
public interface ResourceCandidateRepository extends PagingAndSortingRepository<ResourceCandidate, Long> {

	
	Optional<ResourceCandidate> findByUuid(String id);

	@Query("SELECT sc FROM ResourceCandidate sc JOIN FETCH sc.resourceSpecificationObj spec WHERE spec.uuid = ?1")
	Optional<ResourceCandidate> findByResourceSpecUuid(String id);

}
