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

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.Place;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceRelationship;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.sim638.api.ServiceApiRouteBuilder;
import io.openslice.tmf.sim638.model.Service;
import io.openslice.tmf.sim638.model.ServiceAttributeValueChangeEvent;
import io.openslice.tmf.sim638.model.ServiceAttributeValueChangeNotification;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceCreateEvent;
import io.openslice.tmf.sim638.model.ServiceCreateNotification;
import io.openslice.tmf.sim638.model.ServiceOrderRef;
import io.openslice.tmf.sim638.model.ServiceStateChangeEvent;
import io.openslice.tmf.sim638.model.ServiceStateChangeNotification;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.repo.ServiceRepository;



@org.springframework.stereotype.Service
public class ServiceRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceRepository serviceRepo;
	

	@Autowired
	ServiceSpecificationRepoService  serviceSpecRepoService;

	private SessionFactory  sessionFactory;

	@Autowired
	ServiceApiRouteBuilder serviceApiRouteBuilder;
	
	@Autowired
	public ServiceRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public List<Service> findAll() {

		return (List<Service>) this.serviceRepo.findAll();
	}

	public Service addService(@Valid ServiceCreate service) {
		logger.info("Will add service: " + service.getName() );
		Service s = new Service();
		if (service.getType()!=null) {
			s.setType(service.getType());			
		}
		s.setName(service.getName());
		s.setCategory( service.getCategory() );
		s.setDescription( service.getDescription() );
		s.setStartDate( service.getStartDate());
		s.setEndDate( service.getEndDate() );
		s.hasStarted( service.isHasStarted());
		s.setIsServiceEnabled( service.isIsServiceEnabled());
		s.setIsStateful(service.isIsStateful());
		s.setServiceDate( service.getServiceDate());
		s.setServiceType( service.getServiceType());
		s.setStartMode( service.getStartMode());
		s.setState(service.getState());
		s.setServiceSpecificationRef( service.getServiceSpecificationRef() );
		if ( service.getNote() != null) {
			s.getNote().addAll( service.getNote() );
		}
		if ( service.getPlace() != null) {
			s.getPlace().addAll( service.getPlace() );
		}
		
		if ( service.getRelatedParty()!=null ) {
			s.getRelatedParty().addAll( service.getRelatedParty());
		}
		
		if ( service.getServiceCharacteristic () != null) {
			s.getServiceCharacteristic().addAll( service.getServiceCharacteristic() );
		}

		if ( service.getServiceOrder() != null) {
			s.getServiceOrder().addAll( service.getServiceOrder() );
		}
		if ( service.getServiceRelationship() != null) {
			s.getServiceRelationship().addAll( service.getServiceRelationship() );
		}
		if ( service.getSupportingResource() != null) {
			s.getSupportingResource().addAll( service.getSupportingResource() );
		}
		if ( service.getSupportingService() != null) {
			s.getSupportingService().addAll( service.getSupportingService() );
		}
		
		s = this.serviceRepo.save( s );

		raiseServiceCreateNotification(s);
		return s;
	}

	

	public Service findByUuid(String id) {
		Optional<Service> optionalCat = this.serviceRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	@Transactional
	public Service updateService(String id, @Valid ServiceUpdate service ) {
		Service s = this.findByUuid(id);

		logger.info("Will update service: " + s.getName() );
		//logger.info("Will update service details: " + s.toString() );

		if (service.getType()!=null) {
			s.setType(service.getType());			
		}
		
		if (service.getName() != null ) {
			s.setName(service.getName());			
		}

		if (service.getCategory() != null ) {
			s.setCategory( service.getCategory() );			
		}
		if (service.getDescription() != null ) {
			s.setDescription( service.getDescription() );			
		}
		if (service.getStartDate() != null ) {

			s.setStartDate( service.getStartDate());
		}
		if (service.getEndDate() != null ) {
			s.setEndDate( service.getEndDate() );			
		}
		if (service.isHasStarted() != null ) {
			s.hasStarted( service.isHasStarted());
		}
		if (service.isIsServiceEnabled() != null ) {
			s.setIsServiceEnabled( service.isIsServiceEnabled());			
		}
		if (service.isIsStateful() != null ) {
			s.setIsStateful(service.isIsStateful());
		}
		if (service.getServiceDate() != null ) {
			s.setServiceDate( service.getServiceDate());
			
		}
		if (service.getServiceType() != null ) {
			s.setServiceType( service.getServiceType());
			
		}
		if (service.getStartMode() != null ) {
			s.setStartMode( service.getStartMode());
			
		}
		

		boolean stateChanged = false;
		if (service.getState() != null ) {
			stateChanged = s.getState() != service.getState();
			s.setState(service.getState());
			
		}
		if (service.getServiceSpecificationRef() != null ) {

			s.setServiceSpecificationRef( service.getServiceSpecificationRef() );
		}

		/**
		 * the following need to be modified for deleting items from lists.
		 */
		
		if ( service.getNote()!=null ) {
			for (Note n : service.getNote()) {
				if (n.getUuid() == null) {
					s.addNoteItem(n);
				}
			}						
		}
		
		if ( service.getPlace()!=null ) {
			for (Place n : service.getPlace()) {
				if (n.getUuid() == null) {
					s.addPlaceItem(n);
				}
			}						
		}

		if ( service.getRelatedParty()!=null ) {
			for (RelatedParty n : service.getRelatedParty()) {
				if (n.getUuid() == null) {
					s.addRelatedPartyItem(n);
				}
			}						
		}
		
		if ( service.getServiceCharacteristic()!=null ) {
			for (Characteristic n : service.getServiceCharacteristic()) {
				if (n.getUuid() == null) {
					s.addServiceCharacteristicItem(n);
				}
			}						
		}
		
		if ( service.getServiceOrder()!=null ) {
			for (ServiceOrderRef n : service.getServiceOrder()) {
				if (n.getUuid() == null) {
					s.addServiceOrderItem(n);
				}
			}						
		}

		if ( service.getServiceRelationship()!=null ) {
			for (ServiceRelationship n : service.getServiceRelationship()) {
				if (n.getUuid() == null) {
					s.addServiceRelationshipItem(n);
				}
			}						
		}
		if ( service.getSupportingResource()!=null ) {
			for (ResourceRef n : service.getSupportingResource()) {
				if (n.getUuid() == null) {
					s.addSupportingResourceItem(n);
				}
			}						
		}
		if ( service.getSupportingService()!=null ) {
			for (ServiceRef n : service.getSupportingService()) {
				if (n.getUuid() == null) {
					s.addSupportingServiceItem(n);
				}
			}						
		}
		
		
		s = this.serviceRepo.save( s );
		if (stateChanged) {
			raiseServiceStateChangedNotification( s );			
		} else {
			raiseServiceAttributeValueChangedNotification( s );
		}
		
		return s;
	}

	public String getServiceEagerAsString(String id) throws JsonProcessingException {
		Service s = this.getServiceEager(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		String res = mapper.writeValueAsString(s);

		return res;
	}
	
	public Service getServiceEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Service s = null;
		try {
			s = (Service) session.get(Service.class, id);
			if (s == null) {
				return this.findByUuid(id);// last resort
			}

			Hibernate.initialize(s.getRelatedParty());
			Hibernate.initialize(s.getNote() );
			
			tx.commit();
		} finally {
			session.close();
		}
		
		return s;
	}
	

	@Transactional
	private void raiseServiceCreateNotification(Service so) {
		ServiceCreateNotification n = new ServiceCreateNotification();
		ServiceCreateEvent event = new ServiceCreateEvent();
		event.service( so );
		n.setEvent(event );
		serviceApiRouteBuilder.publishEvent(n, so.getId());
		
	}

	@Transactional
	private void raiseServiceStateChangedNotification(Service so) {
		ServiceStateChangeNotification n = new ServiceStateChangeNotification();
		ServiceStateChangeEvent event = new ServiceStateChangeEvent();
		event.service( so );
		n.setEvent(event );
		serviceApiRouteBuilder.publishEvent(n, so.getId());
		
	}

	@Transactional
	private void raiseServiceAttributeValueChangedNotification(Service so) {
		ServiceAttributeValueChangeNotification n = new ServiceAttributeValueChangeNotification();
		ServiceAttributeValueChangeEvent event = new ServiceAttributeValueChangeEvent();
		event.service( so );
		n.setEvent(event );
		serviceApiRouteBuilder.publishEvent(n, so.getId());
	
	}
}
