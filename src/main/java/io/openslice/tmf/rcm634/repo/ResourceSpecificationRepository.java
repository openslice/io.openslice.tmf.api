/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.rcm634.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecification;


@Repository
public interface ResourceSpecificationRepository extends CrudRepository<ResourceSpecification, Long>, PagingAndSortingRepository<ResourceSpecification, Long> {

	
	Optional<ResourceSpecification> findByUuid(String id);

	@Query("SELECT sc FROM LogicalRspec sc")
	List<LogicalResourceSpecification> findAllLogical();
	

	List<ResourceSpecification> findByName(String aname );

	List<ResourceSpecification> findByNameAndVersion(String aname, String aversion);

	List<ResourceSpecification> findByNameAndCategory(String aname, String acategory);
	

	List<ResourceSpecification> findByNameAndCategoryAndVersion(String aname, String acategory, String aversion);

	@Query("SELECT sc FROM PhysicalRspec sc")
	List<PhysicalResourceSpecification> findAllPhysical();

}
