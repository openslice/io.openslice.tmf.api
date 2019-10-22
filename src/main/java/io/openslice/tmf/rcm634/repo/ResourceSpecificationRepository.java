package io.openslice.tmf.rcm634.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpec;
import io.openslice.tmf.rcm634.model.ResourceSpecification;


@Repository
public interface ResourceSpecificationRepository extends PagingAndSortingRepository<ResourceSpecification, Long> {

	
	Optional<ResourceSpecification> findByUuid(String id);

	@Query("SELECT sc FROM LogicalResourceSpec sc")
	List<LogicalResourceSpec> findAllLogical();
	

	@Query("SELECT sc FROM PhysicalResourceSpec sc")
	List<PhysicalResourceSpec> findAllPhysical();

}
