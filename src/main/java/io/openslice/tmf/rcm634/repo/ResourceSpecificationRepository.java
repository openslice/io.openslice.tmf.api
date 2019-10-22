package io.openslice.tmf.rcm634.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rcm634.model.ResourceSpecification;


@Repository
public interface ResourceSpecificationRepository extends PagingAndSortingRepository<ResourceSpecification, Long> {

	
	Optional<ResourceSpecification> findByUuid(String id);

}
