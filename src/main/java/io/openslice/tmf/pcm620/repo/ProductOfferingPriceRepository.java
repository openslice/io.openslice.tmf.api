package io.openslice.tmf.pcm620.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pcm620.model.ProductOffering;
import io.openslice.tmf.pcm620.model.ProductOfferingPrice;

@Repository
public interface ProductOfferingPriceRepository extends PagingAndSortingRepository<ProductOfferingPrice, Long> {

	Optional<ProductOfferingPrice> findByUuid(String id);

	List<ProductOfferingPrice> findByNameAndVersion(String aname, String aversion);

	List<ProductOfferingPrice> findByOrderByName();

}
