package io.openslice.tmf.rpm685.repo;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rpm685.model.ResourcePool;
import jakarta.validation.constraints.NotNull;


@Repository
public interface ResourcePoolRepository extends CrudRepository<ResourcePool, Long>, PagingAndSortingRepository<ResourcePool, Long> {


	Optional<ResourcePool> findByUuid(String id);

	Optional<ResourcePool> findByName(String aName);

	@Query("SELECT rp FROM ResourcePool rp "
			+ "JOIN FETCH rp.capacity cap "
			+ "JOIN FETCH cap.resources res "
			+ "WHERE res.id = ?1")	
	Set<ResourcePool> findByResourceId(@NotNull String resourceRefId);
}
