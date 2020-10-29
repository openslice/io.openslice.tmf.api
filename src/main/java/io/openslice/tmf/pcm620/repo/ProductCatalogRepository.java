package io.openslice.tmf.pcm620.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pcm620.model.Catalog;

@Repository
public interface ProductCatalogRepository  extends PagingAndSortingRepository<Catalog, Long>{

	Optional<Catalog> findByUuid(String id);

	Optional<Catalog> findByName(String aName);

	List<Catalog> findByOrderByName();
}
