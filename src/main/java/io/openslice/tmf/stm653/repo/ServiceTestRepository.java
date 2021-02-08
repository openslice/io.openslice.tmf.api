package io.openslice.tmf.stm653.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.stm653.model.ServiceTest;


@Repository
public interface ServiceTestRepository extends PagingAndSortingRepository<ServiceTest, Long> {

	
	Optional<ServiceTest> findByUuid(String id);

	Optional<ServiceTest> findByName(String aName);

	


}

