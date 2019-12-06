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
package io.openslice.tmf.sim638.service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.sim638.repo.ServiceRepository;
import io.openslice.tmf.sim638.model.Service;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceUpdate;



@org.springframework.stereotype.Service
public class ServiceRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceRepository serviceRepo;
	

	@Autowired
	ServiceSpecificationRepoService  serviceSpecRepoService;

	public List<Service> findAll() {

		return (List<Service>) this.serviceRepo.findAll();
	}

	public Service addService(@Valid ServiceCreate service) {
		Service so = new Service();
//		so.setOrderDate( OffsetDateTime.now(ZoneOffset.UTC) );
//		so.setCategory( serviceOrder.getCategory() );
//		so.setDescription( serviceOrder.getDescription() );
//		so.setExternalId( serviceOrder.getExternalId());
//		so.setNotificationContact(serviceOrder.getNotificationContact());
//		so.priority(serviceOrder.getPriority());
//		so.requestedCompletionDate(serviceOrder.getRequestedCompletionDate());
//		so.requestedStartDate(serviceOrder.getRequestedCompletionDate());
//		if ( serviceOrder.getNote()!=null ) {
//			so.getNote().addAll(serviceOrder.getNote());			
//		}
//		if ( serviceOrder.getOrderItem()!=null ) {
//			so.getOrderItem().addAll( serviceOrder.getOrderItem());
//		}
//
//		if ( serviceOrder.getRelatedParty()!=null ) {
//			so.getRelatedParty().addAll(serviceOrder.getRelatedParty());
//		}
//		if ( serviceOrder.getOrderRelationship()!=null ) {
//			so.getOrderRelationship().addAll( serviceOrder.getOrderRelationship());		
//			
//		}
//		so = this.serviceOrderRepo.save( so );
//		
//		so = this.fixServiceOrderItemsDependencies(so);
//		
//		so = this.serviceOrderRepo.save( so );
		
		return so;
	}

	

	public Service findByUuid(String id) {
		Optional<Service> optionalCat = this.serviceRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Service updateService(String id, @Valid ServiceUpdate service ) {
		Service so = this.findByUuid(id);
		
//		//so.getOrderItem().stream().forEach(soi -> System.out.println("soi = " + soi.toString()) );
//		
//		so.setCategory( serviceOrder.getCategory() );
//		so.setDescription( serviceOrder.getDescription() );
//		so.setNotificationContact(serviceOrder.getNotificationContact());
//
//		so.requestedCompletionDate(serviceOrder.getRequestedCompletionDate());
//		so.requestedStartDate(serviceOrder.getRequestedCompletionDate());
//		
//		so.setExpectedCompletionDate( serviceOrder.getExpectedCompletionDate() );
//		so.setStartDate( serviceOrder.getStartDate() );
//		
//		
//		if ( serviceOrder.getNote()!=null ) {
//			for (Note n : serviceOrder.getNote()) {
//				if (n.getUuid() == null) {
//					so.addNoteItem(n);
//				}
//			}
//						
//		}
//		
//		if ( serviceOrder.getRelatedParty()!=null ) {
//			so.getRelatedParty().addAll(serviceOrder.getRelatedParty());
//		}
//		if ( serviceOrder.getOrderRelationship()!=null ) {
//			so.getOrderRelationship().addAll( serviceOrder.getOrderRelationship());		
//			
//		}
//		
//		so = this.serviceOrderRepo.save( so );
		
		return so;
	}

}
