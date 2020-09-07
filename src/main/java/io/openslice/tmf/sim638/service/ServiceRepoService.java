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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.UserPartRoleType;
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
	
	public List findAll(@Valid String fields, Map<String, String> allParams)
			throws UnsupportedEncodingException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ServiceOrder> alist = null;
		try {
//			String sql = "SELECT s FROM ServiceSpecification s";
			String sql = "SELECT "
					+ "srv.uuid as uuid,"
					+ "srv.serviceDate as serviceDate,"
					+ "srv.name as name,"
					+ "srv.startDate as startDate,"
					+ "srv.category as category,"
					+ "srv.category as category,"
					+ "srv.state as state,"
					+ "srv.startMode as startMode,"
					+ "srv.serviceType as serviceType,"
					+ "sor.id as serviceOrderId"
//					+ "rp.uuid as relatedParty_uuid,"
//					+ "rp.name as relatedParty_name"
					;
			
			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", srv." + f + " as " + f ;
				}
				
			}			
			sql += "  FROM Service srv "
					//+ "JOIN srv.relatedParty rp "
					+ "JOIN srv.serviceOrder sor ";
//			if (allParams.size() > 0) {
//				sql += " WHERE rp.role = 'REQUESTER' AND ";
//				for (String pname : allParams.keySet()) {
//					sql += " " + pname + " LIKE ";
//					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
//					sql += "'" + pval + "'";
//				}
//			} else {
//				sql += " WHERE rp.role = 'REQUESTER' ";				
//			}
			
			sql += "  ORDER BY srv.startDate DESC";
			
			List<Object> mapaEntity = session
				    .createQuery(sql )
				    .setResultTransformer( new ResultTransformer() {
						
						@Override
						public Object transformTuple(Object[] tuple, String[] aliases) {
							Map<String, Object> result = new LinkedHashMap<String, Object>(tuple.length);
							        for (int i = 0; i < tuple.length; i++) {
							            String alias = aliases[i];
							            if (alias.equals("uuid")) {
							            	result.put("id", tuple[i]);
							            }
							            if (alias.equals("type")) {
							            	alias = "@type";
							            }
							            if (alias.equals("relatedParty_name")) {
							            	if ( result.get( "relatedParty" ) == null ) {
								                result.put("relatedParty", new ArrayList<Object>() ) ;							            		
							            	}
							            	ArrayList< Object> rpList =  (ArrayList< Object>) result.get( "relatedParty" );
							            	LinkedHashMap<String, Object> rp = new LinkedHashMap<String, Object>();
							            	rp.put("name", tuple[i]);
							            	rp.put("role", "REQUESTER" );
							            	rpList.add(rp);
							            }
							            if (alias.equals("serviceOrderId")) {
							            	if ( result.get( "serviceOrder" ) == null ) {
								                result.put("serviceOrder", new ArrayList<Object>() ) ;							            		
							            	}
							            	ArrayList< Object> rpList =  (ArrayList< Object>) result.get( "serviceOrder" );
							            	LinkedHashMap<String, Object> rp = new LinkedHashMap<String, Object>();
							            	rp.put("id", tuple[i]);							            	
							            	rpList.add(rp);
							            }
							            if (alias != null) {
							                result.put(alias, tuple[i]);
							            }
							        }

							        return result;
						}
						
						@Override
						public List transformList(List collection) {
							return collection;
						}
					} )
				    .list();
			
	
			
//			List<ServiceOrder> mapaEntity = session
//				    .createQuery(sql )
//				    .setResultTransformer( new ResultTransformer() {
//						
//						@Override
//						public ServiceOrder transformTuple(Object[] tuple, String[] aliases) {
//									//Map<String, Object> result = new LinkedHashMap<String, Object>(tuple.length);
//									ServiceOrder so = new ServiceOrder();
//									so.setUuid( (String) tuple[0] );
//									so.setOrderDate(  (OffsetDateTime) tuple[1] );
//									ServiceOrderItem soi = new ServiceOrderItem();
//									so.addOrderItemItem( soi );
//									ServiceRestriction service = new ServiceRestriction();
//									service.setName( (String) tuple[9]  );
//									soi.setService(service );
//									
////							        for (int i = 0; i < tuple.length; i++) {
////							            String alias = aliases[i];
////							            if (alias.equals("type")) {
////							            	alias = "@type";
////							            }
////							            if (alias != null) {
////							                result.put(alias, tuple[i]);
////							            }
////							        }
//
//							        return so;
//						}
//						
//						@Override
//						public List transformList(List collection) {
//							return collection;
//						}
//					} )
//				    .list();
			
//			//this will fetch the whole object fields
//			if ( (( allParams!= null) && ( allParams.size()>0)) ) {
//				List<ServiceSpecification> resultlist = new ArrayList<>();
//				for (ServiceSpecification s : alist) {
//					resultlist.add(  findByUuid( s.getUuid() ));
//				}
//				return resultlist;
//			}
			
			
			
			return mapaEntity;
		
			
			
			
		} finally {
			tx.commit();
			session.close();
		}

	}
	
	
	public List<Service> findAll(String name, UserPartRoleType requester) {
		// TODO Auto-generated method stub
		return (List<Service>) this.serviceRepo.findByRolename(name);
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
	public Service updateService(String id, @Valid ServiceUpdate servUpd, boolean propagateToSO ) {
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
						if ( ( origChar !=null ) && ( origChar.getValue() !=null ) && ( origChar.getValue().getValue() !=null )) {
							if ( !origChar.getValue().getValue().equals(n.getValue().getValue()) ) {
								serviceCharacteristicChanged = true;								
							}
						}
						
						 service.getServiceCharacteristicByName( n.getName() ).setValue( 
								 new Any( n.getValue().getValue(), n.getValue().getAlias()  )
								 );
					} else {
						service.addServiceCharacteristicItem(n);
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
		
		if ( propagateToSO ) {
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
