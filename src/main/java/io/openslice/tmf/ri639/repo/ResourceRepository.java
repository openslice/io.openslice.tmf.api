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
package io.openslice.tmf.ri639.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.ri639.model.Resource;



@Repository
public interface ResourceRepository extends  CrudRepository<Resource, Long>, PagingAndSortingRepository<Resource, Long> {

	
	Optional<Resource> findByUuid(String id);

	@Query("SELECT srv FROM RIResource srv JOIN FETCH srv.relatedParty rp WHERE rp.name = ?1")	
	Iterable<Resource> findByRolename(String name);


	@Query("SELECT srv FROM RIResource srv  WHERE srv.resourceStatus = io.openslice.tmf.ri639.model.ResourceStatusType.AVAILABLE AND "
			+ "srv.endOperatingDate < CURRENT_TIMESTAMP")
	List<Resource> findActiveToTerminate();

	@Query("SELECT srv FROM RIResource srv "
			+ "JOIN FETCH srv.resourceCharacteristic char "
			+ "JOIN FETCH char.value val "
			+ "WHERE (srv.resourceStatus = io.openslice.tmf.ri639.model.ResourceStatusType.AVAILABLE OR "
			+ " srv.resourceStatus = io.openslice.tmf.ri639.model.ResourceStatusType.RESERVED OR "
			+ "	srv.resourceStatus = io.openslice.tmf.ri639.model.ResourceStatusType.STANDBY) AND "
			+ "char.name = 'externalPartnerServiceId'"
			 )
	
	List<Resource> findActiveAndReservedResourcesOfPartners();
	

	List<Resource> findByNameAndResourceVersion(String aname, String aversion);
	List<Resource> findByNameAndCategoryAndResourceVersion(String aname, String acategory, String aversion);
}
