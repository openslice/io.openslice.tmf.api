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
package io.openslice.tmf.pm632.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pm632.model.Organization;



@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>, PagingAndSortingRepository<Organization, Long> {


	Optional<Organization> findByUuid(String id);
	
	Iterable<Organization> findByName( String name);
	
	List<Organization> findByOrderByName();

	@Query("SELECT o FROM Organization o JOIN FETCH o.partyCharacteristic char WHERE char.name LIKE 'EXTERNAL_TMFAPI_BASEURL'")
	List<Organization> findPartnersOfferingEXTERNAL_TMFAPI();

}
