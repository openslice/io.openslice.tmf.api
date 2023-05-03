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
package io.openslice.tmf.sim638.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.sim638.model.Service;



@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {

	
	Optional<Service> findByUuid(String id);

	@Query("SELECT srv FROM Service srv JOIN FETCH srv.relatedParty rp WHERE rp.name = ?1")	
	Iterable<Service> findByRolename(String name);

	@Query("SELECT srv FROM Service srv  WHERE ( srv.state != io.openslice.tmf.common.model.service.ServiceStateType.TERMINATED ) AND srv.endDate < CURRENT_TIMESTAMP")	
	List<Service> findActiveToTerminate();

	@Query("SELECT srv FROM Service srv "
			+ "JOIN FETCH srv.serviceCharacteristic char "
			+ "JOIN FETCH char.value val "
			+ "WHERE char.name = 'DeploymentRequestID' AND "
			+ " val.value = ?1 " )	
	List<Service> findByDeploymentRequestID(String aDeploymentRequestID);
	
	
		@Query("SELECT srv FROM Service srv "
			+ "JOIN FETCH srv.serviceCharacteristic char "
			+ "JOIN FETCH char.value val "
			+ "WHERE (srv.state = io.openslice.tmf.common.model.service.ServiceStateType.ACTIVE OR "
			+ " srv.state = io.openslice.tmf.common.model.service.ServiceStateType.RESERVED OR "
			+ "	srv.state = io.openslice.tmf.common.model.service.ServiceStateType.FEASIBILITYCHECKED) AND "
			+ "char.name = 'externalPartnerServiceId'"
			 )	
	List<Service> findActiveAndReservedServicesOfPartners();

	@Query("SELECT srv FROM Service srv "
			+ "JOIN FETCH srv.serviceOrder sorder "
			+ "WHERE sorder.id = ?1 " )	
	List<Service> findServicesFromOrderID(String orderid);

}
