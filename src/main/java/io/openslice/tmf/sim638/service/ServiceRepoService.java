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
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.model.DeploymentDescriptor;
import io.openslice.model.DeploymentDescriptorVxFInstanceInfo;
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
import io.openslice.tmf.sim638.api.ServiceApiRouteBuilderEvents;
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
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;



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
	ServiceApiRouteBuilderEvents serviceApiRouteBuilder;
	
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
		
		Note noteItem = new Note();
		noteItem.setText("Service " + s.getState() );
		noteItem.setAuthor("API");
		noteItem.setDate(OffsetDateTime.now(ZoneOffset.UTC) );
		s.addNoteItem(noteItem);		
		
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
	public Service updateService(String id, @Valid ServiceUpdate servUpd, boolean propagateToSO, Service updatedFromParentService, Service updatedFromChildService ) {
		//Service service = this.findByUuid(id);
		Service service = this.getServiceEager(id);
		
		
		if ( service == null ) {
			logger.error("Service cannot be found in registry, UUID: " + id  );
			return null;
		}

		logger.info("Will update service: " + service.getName() );
		//logger.info("Will update service details: " + s.toString() );
		
		ObjectMapper mapper = new ObjectMapper();
		String originaServiceAsJson = null;
		try {
			originaServiceAsJson = mapper.writeValueAsString( service );
		} catch (JsonProcessingException e) {
			logger.error("cannot umarshall service: " + service.getName() );
			e.printStackTrace();
		}
		
				
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
		ServiceStateType previousState = service.getState();		
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
		boolean serviceCharacteristicChangedContainsPrimitive = false;
		
		String charChangedForNotes = "";
		List<Characteristic> childCharacteristicsChanged = new ArrayList<>();
		

		//logger.info("==> Will update serviceToString: " + service.toString() );
		
		
		if ( servUpd.getServiceCharacteristic()!=null ) {
			for (Characteristic n : servUpd.getServiceCharacteristic()) {
				
					if ( service.getServiceCharacteristicByName( n.getName() )!= null ) {
						
						Characteristic origChar = service.getServiceCharacteristicByName( n.getName() );
						if ( ( origChar !=null ) && ( origChar.getValue() !=null ) && ( origChar.getValue().getValue() !=null )) {
							if ( !origChar.getValue().getValue().equals(n.getValue().getValue()) ) {									
								if ( n.getName().contains("::") ) {
									childCharacteristicsChanged.add(n); //the characteristic needs later to be propagated to its children
									
								}
								serviceCharacteristicChanged = true; //change only characteristics of this service
								charChangedForNotes += n.getName(); 
								if ( n.getName().toUpperCase().contains(  "PRIMITIVE::" ) ){
									serviceCharacteristicChangedContainsPrimitive = true;
								}
								
							}
						}
						
						 service.getServiceCharacteristicByName( n.getName() ).setValue( 
								 new Any( n.getValue().getValue(), n.getValue().getAlias()  )
								 );
					} else {
						service.addServiceCharacteristicItem(n);
						serviceCharacteristicChanged = true;	
						charChangedForNotes += n.getName() + ", "; 
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
				

		if (stateChanged) {
			Note noteItem = new Note();
			noteItem.setText("Service is " + service.getState() );
			noteItem.setAuthor("API");
			noteItem.setDate(OffsetDateTime.now(ZoneOffset.UTC) );
			service.addNoteItem(noteItem);		
		}
		
		if (serviceCharacteristicChanged) {
			Note noteItem = new Note();
			noteItem.setText("Service Characteristic changed: " + charChangedForNotes );
			noteItem.setAuthor("API");
			noteItem.setDate(OffsetDateTime.now(ZoneOffset.UTC) );
			service.addNoteItem(noteItem);		
		}
		
			
		
		service = this.serviceRepo.save( service );
		
		
		
		/**
		 * Save in ServiceActionQueueItem
		 */
		
			if (propagateToSO && stateChanged) {
				ServiceActionQueueItem saqi = new ServiceActionQueueItem();
				saqi.setServiceRefId( id );
				saqi.setOriginalServiceInJSON( originaServiceAsJson );
				if (stateChanged) {
					if ( service.getState().equals(  ServiceStateType.INACTIVE) ) {
						saqi.setAction( ServiceActionQueueAction.DEACTIVATE );		
					}else if ( service.getState().equals(  ServiceStateType.TERMINATED) ) {
						saqi.setAction( ServiceActionQueueAction.TERMINATE );		
					}
					
				}
				
				if ( saqi.getAction() != ServiceActionQueueAction.NONE  ) {
					this.addServiceActionQueueItem(saqi);					
				}
			}		
		
		
//		//here on any state change of a Service we must send an ActionQueueItem that reflects the state changed with the Action  
		if  ( stateChanged  ) {
			ServiceActionQueueItem saqi = new ServiceActionQueueItem();
			saqi.setServiceRefId( id );
			saqi.setOriginalServiceInJSON( originaServiceAsJson );			
			if ( service.getState().equals(  ServiceStateType.ACTIVE) ) {
				saqi.setAction( ServiceActionQueueAction.EVALUATE_STATE_CHANGE_TOACTIVE  );	
				this.addServiceActionQueueItem(saqi);			
			}else if ( previousState!=null && previousState.equals( ServiceStateType.ACTIVE) ) {
				saqi.setAction( ServiceActionQueueAction.EVALUATE_STATE_CHANGE_TOINACTIVE  );
				this.addServiceActionQueueItem(saqi);
			}
		}		
		
		if ( serviceCharacteristicChanged &&  service.getState().equals(  ServiceStateType.ACTIVE) &&  previousState!=null && previousState.equals( ServiceStateType.ACTIVE) ) {
			ServiceActionQueueItem saqi = new ServiceActionQueueItem();
			saqi.setServiceRefId( id );
			saqi.setOriginalServiceInJSON( originaServiceAsJson );		
			saqi.setAction( ServiceActionQueueAction.EVALUATE_CHARACTERISTIC_CHANGED  );	
			if ( serviceCharacteristicChangedContainsPrimitive ) {
				saqi.setAction( ServiceActionQueueAction.EVALUATE_CHARACTERISTIC_CHANGED_MANODAY2  );					
			}
			
			
			
			this.addServiceActionQueueItem(saqi);
			
			/*
			 * Update any parent service
			 */
			for (ServiceRelationship serviceRelationship : service.getServiceRelationship()) {
				if ( serviceRelationship.getRelationshipType().equals("ChildService") ) {
					if ( serviceRelationship.getService() != null ) {
						if ( updatedFromParentService == null ||
								(updatedFromParentService!=null && !updatedFromParentService.getId().equals(serviceRelationship.getService().getId())) ) { //avoid circular
							propagateCharacteristicsToParentService(service, serviceRelationship.getService().getId());
						}
							
					}
				}
			}			
		}
		
		if ( childCharacteristicsChanged.size()>0 ) {
			if ( service.getSupportingService() != null ) { //propagate to children
				//copy characteristics values from CFS Service  to its supporting services.
				for (ServiceRef sref : service.getSupportingService() ) {
					Service aSupportingService = this.findByUuid( sref.getId() );
					ServiceUpdate supd = new ServiceUpdate();
					boolean foundCharacteristicForChild = false;
					for (Characteristic supportingServiceChar : aSupportingService.getServiceCharacteristic() ) {
						
						for (Characteristic serviceCharacteristic : childCharacteristicsChanged ) {
							if ( serviceCharacteristic.getName().contains( aSupportingService.getName() + "::" + supportingServiceChar.getName() )) { 									
								//supportingServiceChar.setValue( serviceCharacteristic.getValue() );
								Characteristic cNew = new Characteristic();
								cNew.setName(supportingServiceChar.getName());
								cNew.value( new Any( serviceCharacteristic.getValue() ));
								supd.addServiceCharacteristicItem( cNew );
								foundCharacteristicForChild = true;
							}
						}
					}					
					
					if ( foundCharacteristicForChild ) {
						Note n = new Note();
						n.setText("Child Characteristics Changed"  );
						n.setAuthor( "SIM638-API" );
						n.setDate( OffsetDateTime.now(ZoneOffset.UTC).toString() );
						supd.addNoteItem( n );					
						if ( updatedFromChildService == null || 
								(updatedFromChildService!=null && !updatedFromChildService.getId().equals( aSupportingService.getId())) ) { //avoid circular
							this.updateService( aSupportingService.getId(), supd , false, service, null); //update the service							
						} 
					}
				}
				
			}
		}
		
		
		
		/**
		 * notify hub
		 */
		if (stateChanged) {
			raiseServiceStateChangedNotification( service );			
		} else if ( serviceCharacteristicChanged ) {
			raiseServiceAttributeValueChangedNotification( service );
		}
		
		
		Characteristic schart = service.getServiceCharacteristicByName("long_string");

		if ( schart!= null ) {
			String teest = schart.getValue().getValue();
			logger.info("schart size = " + teest.length() );
			
			logger.info("schart " + teest );
			System.out.println("The value is : \n " + teest);
//			try (PrintWriter out = new PrintWriter("C:\\tranoris\\ctranup\\personal\\Invoices\\filename.txt")) {
//			    out.println( teest );
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			logger.info("======================================================================================================");			
		}
		
		return service;
	}

	/**
	 * @param service
	 * @param parentService
	 */
	private void propagateCharacteristicsToParentService(Service childService, String parentServiceId) {
		
		ServiceUpdate servUpd = new ServiceUpdate();
		
		for (Characteristic n : childService.getServiceCharacteristic()) {			
			Characteristic serviceCharacteristicItem = new Characteristic();
			serviceCharacteristicItem.setName( childService.getName() + "::" + n.getName());
			serviceCharacteristicItem.setValue( new Any( n.getValue() ));
			servUpd.addServiceCharacteristicItem(serviceCharacteristicItem);
		}
		
		this.updateService( parentServiceId, servUpd, false, null, childService);
	}

	public String getServiceEagerAsString(String id) throws JsonProcessingException {
		Service s = this.getServiceEager(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5JakartaModule());
		String res = mapper.writeValueAsString(s);


		Characteristic schart = s.getServiceCharacteristicByName("long_string");

		if ( schart!= null ) {
			String teest = schart.getValue().getValue();
			logger.info("schart size = " + teest.length() );
			
			logger.info("schart " + teest );
			logger.info("======================================================================================================");			
		}
		
		return res;
	}
	
	public Service getServiceEager(String id) {
		if ( id == null || id.equals("")) {
			return null;
		}
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
			Hibernate.initialize(s.getSupportingService() );
			Hibernate.initialize(s.getSupportingResource()  );
			Hibernate.initialize(s.getPlace()  );
			
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

		return (List<ServiceActionQueueItem>) this.serviceActionQueueRepo.findByOrderByInsertedDate();
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
		if ( optso.isEmpty() ) {
			return null;
		}
		ServiceActionQueueItem so = optso.get();
		if ( so == null ) {
			return null;
		}
		
		this.serviceActionQueueRepo.delete(so);
		return null;
	}

	

	@Transactional
	public List<String> findAllActiveServicesToTerminate(){

		List<String> result = new ArrayList<>();
		List<Service> srvs = this.serviceRepo.findActiveToTerminate();
		for (Service service : srvs) {
			result.add(  service.getId());
		}
		
		return result;
	}

	/**
	 * @return UUIDs of Services and put them in a List
	 */
	@Transactional
	public List<String> findAllActiveAndReservedServicesOfPartners(){

		List<String> result = new ArrayList<>();
		List<Service> srvs = this.serviceRepo.findActiveAndReservedServicesOfPartners();
		for (Service service : srvs) {
			result.add(  service.getId());
		}
		
		return result;
	}
	
	

	/**
	 * Given a DeploymentRequestID (which is provided by OSM in our case)
	 * we locate the equivalent service
	 * @param aDeploymentRequestID
	 * @return
	 */
	@Transactional
	public List<Service> findDeploymentRequestID( String aDeploymentRequestID){

		return (List<Service>) this.serviceRepo.findByDeploymentRequestID( aDeploymentRequestID );

	}
	
	
	
	
	/**
	 * @param item
	 * @return
	 */
	@Transactional
	public void  nfvCatalogNSResourceChanged(@Valid DeploymentDescriptor dd) {
		String deploymentRequestID = dd.getId() + "";
		logger.info("Will update nfvCatalogNSResourceChanged for deploymentRequestID = " + deploymentRequestID );
		
		var aservices = findDeploymentRequestID( deploymentRequestID );
		for (Service as : aservices) {
			
			Service aService = findByUuid(as.getId()); 
			
			if ( aService.getState().equals( ServiceStateType.ACTIVE )  ) {
				

				ServiceUpdate supd = new ServiceUpdate();
				
				Characteristic cNewLCM = new Characteristic();
				cNewLCM.setName("NSLCM" );
				cNewLCM.value( new Any( dd.getNs_nslcm_details()  ));
				supd.addServiceCharacteristicItem( cNewLCM );
				
				Characteristic cNewNSR = new Characteristic();
				//cNewNSR.setUuid(null);
				cNewNSR.setName("NSR" );
				cNewNSR.value( new Any( dd.getNsr()  ));
				supd.addServiceCharacteristicItem( cNewNSR );
				
				
				
				if ( dd.getDeploymentDescriptorVxFInstanceInfo() !=null ) {
					for ( DeploymentDescriptorVxFInstanceInfo vnfinfo : dd.getDeploymentDescriptorVxFInstanceInfo() ) {							
							Characteristic cNewMember = new Characteristic();
							cNewMember.setName(  "VNFINDEXREF_INFO_" + vnfinfo.getMemberVnfIndexRef() );
							cNewMember.value( new Any( vnfinfo.getVxfInstanceInfo()  + "" ));
							supd.addServiceCharacteristicItem( cNewMember );
					}					
				}
				
				Note n = new Note();
				n.setText("NS Resource LCM Changed"  );
				n.setAuthor( "SIM638-API" );
				n.setDate( OffsetDateTime.now(ZoneOffset.UTC).toString() );
				supd.addNoteItem( n );					
				
				this.updateService( aService.getId(), supd , true, null, null); //update the service			
			}
		}
	}


	@Transactional
	public List<String> getServicesFromOrderID(String orderid){

		List<String> result = new ArrayList<>();
		List<Service> srvs = this.serviceRepo.findServicesFromOrderID( orderid );
		for (Service service : srvs) {
			result.add(  service.getId());
		}
		
		return result;
	}
	
}
