package io.openslice.tmf.so641.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.so641.model.ServiceOrder;


@Repository
public interface ServiceOrderRepository extends PagingAndSortingRepository<ServiceOrder, Long> {

	
	Optional<ServiceOrder> findByUuid(String id);

}
