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

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.Place;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceRelationship;
import io.openslice.tmf.common.model.service.ServiceStateType;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.sim638.api.ServiceApiRouteBuilder;
import io.openslice.tmf.sim638.model.Service;
import io.openslice.tmf.sim638.model.ServiceActionQueueAction;
import io.openslice.tmf.sim638.model.ServiceActionQueueItem;
import io.openslice.tmf.sim638.model.ServiceAttributeValueChangeEvent;
import io.openslice.tmf.sim638.model.ServiceAttributeValueChangeNotification;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceCreateEvent;
import io.openslice.tmf.sim638.model.ServiceCreateNotification;
import io.openslice.tmf.sim638.model.ServiceOrderRef;
import io.openslice.tmf.sim638.model.ServiceStateChangeEvent;
import io.openslice.tmf.sim638.model.ServiceStateChangeNotification;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.repo.ServiceActionQueueRepository;
import io.openslice.tmf.sim638.repo.ServiceRepository;
import io.openslice.tmf.so641.model.ServiceOrder;



@org.springframework.stereotype.Service
public class ServiceRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceRepository serviceRepo;
	
	@Autowired
	ServiceActionQueueRepository serviceActionQueueRepo;

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
	public Service updateService(String id, @Valid ServiceUpdate servUpd ) {
		Service service = this.findByUuid(id);

		logger.info("Will update service: " + service.getName() );
		//logger.info("Will update service details: " + s.toString() );

		if (servUpd.getType()!=null) {
			service.setType(servUpd.getType());			
		}
		
		if (servUpd.getName() != null ) {
			service.setName(servUpd.getName());			
		}

		if (servUpd.getCategory() != null ) {
			service.setCategory( servUpd.getCategory() );			
		}
		if (servUpd.getDescription() != null ) {
			service.setDescription( servUpd.getDescription() );			
		}
		if (servUpd.getStartDate() != null ) {

			service.setStartDate( servUpd.getStartDate());
		}
		if (servUpd.getEndDate() != null ) {
			service.setEndDate( servUpd.getEndDate() );			
		}
		if (servUpd.isHasStarted() != null ) {
			service.hasStarted( servUpd.isHasStarted());
		}
		if (servUpd.isIsServiceEnabled() != null ) {
			service.setIsServiceEnabled( servUpd.isIsServiceEnabled());			
		}
		if (servUpd.isIsStateful() != null ) {
			service.setIsStateful(servUpd.isIsStateful());
		}
		if (servUpd.getServiceDate() != null ) {
			service.setServiceDate( servUpd.getServiceDate());
			
		}
		if (servUpd.getServiceType() != null ) {
			service.setServiceType( servUpd.getServiceType());
			
		}
		if (servUpd.getStartMode() != null ) {
			service.setStartMode( servUpd.getStartMode());
			
		}
		

		boolean stateChanged = false;
		if (servUpd.getState() != null ) {
			stateChanged = service.getState() != servUpd.getState();
			service.setState(servUpd.getState());
			
		}
		if (servUpd.getServiceSpecificationRef() != null ) {

			service.setServiceSpecificationRef( servUpd.getServiceSpecificationRef() );
		}

		/**
		 * the following need to be modified for deleting items from lists.
		 */
		
		if ( servUpd.getNote()!=null ) {
			for (Note n : servUpd.getNote()) {
				if (n.getUuid() == null) {
					service.addNoteItem(n);
				}
			}						
		}
		
		if ( servUpd.getPlace()!=null ) {
			for (Place n : servUpd.getPlace()) {
				if (n.getUuid() == null) {
					service.addPlaceItem(n);
				}
			}						
		}

		if ( servUpd.getRelatedParty()!=null ) {
			for (RelatedParty n : servUpd.getRelatedParty()) {
				if (n.getUuid() == null) {
					service.addRelatedPartyItem(n);
				}
			}						
		}
		
		boolean serviceCharacteristicChanged = false;
		if ( servUpd.getServiceCharacteristic()!=null ) {
			for (Characteristic n : servUpd.getServiceCharacteristic()) {
				
					if ( service.getServiceCharacteristicByName( n.getName() )!= null ) {
						
						Characteristic origChar = service.getServiceCharacteristicByName( n.getName() );
						if ( origChar.getValue() !=null ) {
							if ( !origChar.getValue().getValue().equals(n.getValue().getValue()) ) {
								serviceCharacteristicChanged = true;								
							}
						}
						
						 service.getServiceCharacteristicByName( n.getName() ).setValue( 
								 new Any( n.getValue().getValue(), n.getValue().getAlias()  )
								 );
					}
				
			}						
		}
		
		if ( servUpd.getServiceOrder()!=null ) {
			for (ServiceOrderRef n : servUpd.getServiceOrder()) {
				if (n.getUuid() == null) {
					service.addServiceOrderItem(n);
				}
			}						
		}

		if ( servUpd.getServiceRelationship()!=null ) {
			for (ServiceRelationship n : servUpd.getServiceRelationship()) {
				if (n.getUuid() == null) {
					service.addServiceRelationshipItem(n);
				}
			}						
		}
		if ( servUpd.getSupportingResource()!=null ) {
			for (ResourceRef n : servUpd.getSupportingResource()) {
				if (n.getUuid() == null) {
					service.addSupportingResourceItem(n);
				}
			}						
		}
		if ( servUpd.getSupportingService()!=null ) {
			for (ServiceRef n : servUpd.getSupportingService()) {
				if (n.getUuid() == null) {
					service.addSupportingServiceItem(n);
				}
			}						
		}
				
		service = this.serviceRepo.save( service );
		
		
		
		/**
		 * Save in ServiceActionQueueItem
		 */
		if (stateChanged || serviceCharacteristicChanged) {
			ServiceActionQueueItem saqi = new ServiceActionQueueItem();
			saqi.setServiceRefId( id );
			if (stateChanged) {
				if ( service.getState().equals(  ServiceStateType.INACTIVE) ) {
					saqi.setAction( ServiceActionQueueAction.DEACTIVATE );		
				}else if ( service.getState().equals(  ServiceStateType.TERMINATED) ) {
					saqi.setAction( ServiceActionQueueAction.TERMINATE );		
				}
				
			} else {
				saqi.setAction( ServiceActionQueueAction.MODIFY );			
			}
			
			this.addServiceActionQueueItem(saqi);
		}
		
		
		
		
		/**
		 * notify hub
		 */
		if (stateChanged) {
			raiseServiceStateChangedNotification( service );			
		} else {
			raiseServiceAttributeValueChangedNotification( service );
		}
		
		return service;
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
			Hibernate.initialize(s.getServiceCharacteristic() );
			Hibernate.initialize(s.getServiceOrder() );
			Hibernate.initialize(s.getServiceRelationship() );
			Hibernate.initialize(s.getServiceSpecificationRef() );
			
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
	
	
	/**
	 * @return
	 */
	public List<ServiceActionQueueItem> findAllServiceActionQueueItems() {

		return (List<ServiceActionQueueItem>) this.serviceActionQueueRepo.findAll();
	}
	
	public ServiceActionQueueItem  addServiceActionQueueItem(@Valid ServiceActionQueueItem item) {
		logger.debug("Will add ServiceActionQueueItem ServiceRefId: " + item.getServiceRefId() );
		return this.serviceActionQueueRepo.save( item);
	}

	/**
	 * @param item
	 * @return
	 */
	@Transactional
	public ServiceActionQueueItem  updateServiceActionQueueItem(@Valid ServiceActionQueueItem item) {
		logger.debug("Will update ServiceActionQueueItem ServiceRefId: " + item.getServiceRefId() );
		return this.serviceActionQueueRepo.save( item);
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Void deleteServiceActionQueueItemByUuid(String id) {
		
		Optional<ServiceActionQueueItem> optso = this.serviceActionQueueRepo.findByUuid(id);
		ServiceActionQueueItem so = optso.get();
		if ( so == null ) {
			return null;
		}
		
		this.serviceActionQueueRepo.delete(so);
		return null;
	}
	
}
