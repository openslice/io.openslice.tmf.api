package io.openslice.tmf.pcm620.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pcm620.model.Category;

@Repository
public interface ProductCategoriesRepository extends PagingAndSortingRepository<Category, Long> {

	Optional<Category> findByUuid(String id);

	Optional<Category> findByName(String aName);

	List<Category> findByOrderByName();

}
