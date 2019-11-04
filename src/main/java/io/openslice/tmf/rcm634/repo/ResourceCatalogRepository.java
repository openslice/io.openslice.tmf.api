package io.openslice.tmf.rcm634.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rcm634.model.ResourceCatalog;


@Repository
public interface ResourceCatalogRepository extends PagingAndSortingRepository<ResourceCatalog, Long> {

	
	Optional<ResourceCatalog> findByUuid(String id);

	Optional<ResourceCatalog> findByName(String aName);
	


}
