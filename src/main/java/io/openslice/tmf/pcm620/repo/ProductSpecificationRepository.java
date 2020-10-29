package io.openslice.tmf.pcm620.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pcm620.model.ProductSpecification;

@Repository
public interface ProductSpecificationRepository extends PagingAndSortingRepository<ProductSpecification, Long> {

	Optional<ProductSpecification> findByUuid(String id);

	List<ProductSpecification> findByNameAndVersion(String aname, String aversion);

	List<ProductSpecification> findByOrderByName();

}
