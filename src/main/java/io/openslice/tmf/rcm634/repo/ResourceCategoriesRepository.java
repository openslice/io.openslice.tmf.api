package io.openslice.tmf.rcm634.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rcm634.model.ResourceCategory;


@Repository
public interface ResourceCategoriesRepository extends PagingAndSortingRepository<ResourceCategory, Long> {

	
	Optional<ResourceCategory> findByUuid(String id);

	Optional<ResourceCategory> findByName(String aName);



}
