/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.lcm.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.lcm.model.LCMRuleSpecification;


@Repository(value = "lcmRuleSpecificationRepository")
public interface LCMRuleSpecificationRepository  extends PagingAndSortingRepository<LCMRuleSpecification, Long> {
	
	Optional<LCMRuleSpecification> findByUuid(String id);

	@Query("SELECT sc FROM LCMRuleSpec sc JOIN FETCH sc.serviceSpecs spec WHERE spec.id = ?1 ORDER BY sc.priority")
	List<LCMRuleSpecification> findByServiceSpecificationRef(String id);

	@Query("SELECT sc FROM LCMRuleSpec sc JOIN FETCH sc.serviceSpecs spec WHERE spec.id = ?1 AND sc.lcmrulephase LIKE ?2 ORDER BY sc.priority")
	List<LCMRuleSpecification> findByServiceSpecificationRefAndPhase(String id, String phaseName);
	
}