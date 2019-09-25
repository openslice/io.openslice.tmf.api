package io.openslice.tmf.scm.sc.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.scm.model.ServiceCatalog;


@Repository
public interface CatalogRepository extends PagingAndSortingRepository<ServiceCatalog, Long> {

	
	Optional<ServiceCatalog> findById(String id);

}
