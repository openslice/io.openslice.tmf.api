package io.openslice.tmf.stm653.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.stm653.model.ServiceTestSpecification;


@Repository
public interface ServiceTestSpecificationRepository extends PagingAndSortingRepository<ServiceTestSpecification, Long> {

	
	Optional<ServiceTestSpecification> findByUuid(String id);

	Optional<ServiceTestSpecification> findByName(String aName);

	


}

