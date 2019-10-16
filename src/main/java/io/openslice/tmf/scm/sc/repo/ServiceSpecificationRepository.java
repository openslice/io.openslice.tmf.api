package io.openslice.tmf.scm.sc.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.scm.model.ServiceSpecification;


@Repository
public interface ServiceSpecificationRepository extends PagingAndSortingRepository<ServiceSpecification, Long> {

	
	Optional<ServiceSpecification> findByUuid(String id);

}
