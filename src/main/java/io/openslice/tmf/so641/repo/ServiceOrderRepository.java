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
package io.openslice.tmf.so641.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderStateType;


@Repository
public interface ServiceOrderRepository extends CrudRepository<ServiceOrder, Long>, PagingAndSortingRepository<ServiceOrder, Long> {


	Optional<ServiceOrder> findByUuid(String id);
	Iterable<ServiceOrder> findByState( ServiceOrderStateType state);
	@Query("SELECT sor FROM ServiceOrder sor JOIN FETCH sor.relatedParty rp WHERE rp.name = ?1 AND  rp.role = ?2 ORDER BY sor.orderDate DESC")	
	Iterable<ServiceOrder> findByRolenameAndRoleType(String rolename, UserPartRoleType requester);
	@Query("SELECT sor FROM ServiceOrder sor JOIN FETCH sor.relatedParty rp WHERE rp.name = ?1")	
	Iterable<ServiceOrder> findByRolename(String rolename);
	
	List<ServiceOrder> findByOrderByOrderDateDesc();
	
	@Query("SELECT sor FROM ServiceOrder sor JOIN FETCH sor.relatedParty rp ORDER BY sor.orderDate DESC")	
	List<ServiceOrder> findAllOptimized();



	@Query("SELECT sor FROM ServiceOrder sor JOIN FETCH sor.note an "
			+ "WHERE sor.uuid = ?1 "
			+ "ORDER BY an.date ASC")	
	Optional<ServiceOrder> findNotesOfServOrder(String id);
}
