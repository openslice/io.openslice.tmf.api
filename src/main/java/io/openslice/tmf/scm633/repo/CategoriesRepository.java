package io.openslice.tmf.scm633.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.scm633.model.ServiceCategory;


@Repository
public interface CategoriesRepository extends PagingAndSortingRepository<ServiceCategory, Long> {

	
	Optional<ServiceCategory> findByUuid(String id);



}
