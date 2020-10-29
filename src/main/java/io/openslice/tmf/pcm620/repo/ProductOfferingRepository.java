package io.openslice.tmf.pcm620.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pcm620.model.ProductOffering;

@Repository
public interface ProductOfferingRepository extends PagingAndSortingRepository<ProductOffering, Long> {

	Optional<ProductOffering> findByUuid(String id);

	List<ProductOffering> findByNameAndVersion(String aname, String aversion);

	List<ProductOffering> findByOrderByName();

}
