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
package io.openslice.tmf.so641.reposervices;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceRelationship;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.so641.api.ServiceOrderApiRouteBuilder;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderAttributeValueChangeEvent;
import io.openslice.tmf.so641.model.ServiceOrderAttributeValueChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderCreateEvent;
import io.openslice.tmf.so641.model.ServiceOrderCreateNotification;
import io.openslice.tmf.so641.model.ServiceOrderItem;
import io.openslice.tmf.so641.model.ServiceOrderRelationship;
import io.openslice.tmf.so641.model.ServiceOrderStateChangeEvent;
import io.openslice.tmf.so641.model.ServiceOrderStateChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderStateType;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.model.ServiceRestriction;
import io.openslice.tmf.so641.repo.ServiceOrderRepository;

@Service
public class ServiceOrderRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceOrderRepository serviceOrderRepo;

	@Autowired
	ServiceSpecificationRepoService serviceSpecRepoService;

	@Autowired
	ServiceOrderApiRouteBuilder serviceOrderApiRouteBuilder;

	private SessionFactory  sessionFactory;


	@Autowired
	public ServiceOrderRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	/**
	 * 
	 * This findAll is optimized on fields. 
	 * @param fields
	 * @param allParams
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Transactional
	public List findAll(@Valid String fields, Map<String, String> allParams)
			throws UnsupportedEncodingException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ServiceOrder> alist = null;
		try {
//			String sql = "SELECT s FROM ServiceSpecification s";
			String sql = "SELECT "
					+ "sor.uuid as uuid,"
					+ "sor.orderDate as orderDate,"
					+ "sor.requestedStartDate as requestedStartDate,"
					+ "sor.requestedCompletionDate as requestedCompletionDate,"
					+ "sor.state as state,"
					+ "sor.type as type,"
					+ "rp.uuid as relatedParty_uuid,"
					+ "rp.name as relatedParty_name";
			
			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", sor." + f + " as " + f ;
				}
				
			}			
			sql += "  FROM ServiceOrder sor "
					+ "JOIN sor.relatedParty rp ";
			if (allParams.size() > 0) {
				sql += " WHERE rp.role = 'REQUESTER' AND ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}
			} else {
				sql += " WHERE rp.role = 'REQUESTER' ";				
			}
			sql += "  ORDER BY sor.orderDate DESC";
			
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
	
	public List<ServiceOrder> findAll() {

		//return (List<ServiceOrder>) this.serviceOrderRepo.findAll();
		//return (List<ServiceOrder>) this.serviceOrderRepo.findByOrderByOrderDateDesc();
		return (List<ServiceOrder>) this.serviceOrderRepo.findAllOptimized();
	}
	
	public List<ServiceOrder> findAllParams(Map<String, String> allParams) {
		logger.info("findAll with params:" + allParams.toString());		
		if ( ( allParams !=null)  &&  allParams.get("state") !=null) {
			ServiceOrderStateType state = ServiceOrderStateType.fromValue( allParams.get("state") );
			logger.info("find by state:" + state );
			return (List<ServiceOrder>) this.serviceOrderRepo.findByState(state);
		}else {
			return findAll();
		}

	}
	
	public String findAllParamsJsonOrderIDs(Map<String, String> allParams) throws JsonProcessingException {
		List<ServiceOrder> lso = findAllParams(allParams);
		ArrayList<String> oids = new ArrayList<>();
		for (ServiceOrder object : lso) {
			oids.add(object.getId());
		}
		ObjectMapper mapper = new ObjectMapper();
		// Registering Hibernate4Module to support lazy objects
		// this will fetch all lazy objects before marshaling
		mapper.registerModule(new Hibernate5Module());
		String res = mapper.writeValueAsString( oids );

		return res;
	}

	public ServiceOrder addServiceOrder(@Valid ServiceOrderCreate serviceOrderCreate) {
		ServiceOrder so = new ServiceOrder();
		so.setOrderDate(OffsetDateTime.now(ZoneOffset.UTC));
		so.setCategory(serviceOrderCreate.getCategory());
		so.setDescription(serviceOrderCreate.getDescription());
		so.setExternalId(serviceOrderCreate.getExternalId());
		so.setNotificationContact(serviceOrderCreate.getNotificationContact());
		so.priority(serviceOrderCreate.getPriority());
		so.requestedCompletionDate(serviceOrderCreate.getRequestedCompletionDate());
		so.requestedStartDate(serviceOrderCreate.getRequestedStartDate() );
		so.setExpectedCompletionDate( serviceOrderCreate.getRequestedCompletionDate() );  //this is by default
		if (serviceOrderCreate.getNote() != null) {
			so.getNote().addAll(serviceOrderCreate.getNote());
		}
		

		boolean allAcknowledged = true;
		if (serviceOrderCreate.getOrderItem() != null) {
			so.getOrderItem().addAll(serviceOrderCreate.getOrderItem());
			for (ServiceOrderItem soi : so.getOrderItem()) {				
				copySpecCharacteristicsToServiceCharacteristic( soi.getService().getServiceSpecification().getId(), soi.getService().getServiceCharacteristic() );
				if ( ! soi.getState().equals( ServiceOrderStateType.ACKNOWLEDGED )) {
					allAcknowledged = false;
				}
			}
			
			
			
		}

		if (serviceOrderCreate.getRelatedParty() != null) {
			so.getRelatedParty().addAll(serviceOrderCreate.getRelatedParty());
		}
		if (serviceOrderCreate.getOrderRelationship() != null) {
			so.getOrderRelationship().addAll(serviceOrderCreate.getOrderRelationship());

		}
		
//		so = this.serviceOrderRepo.save(so);
//		so = this.fixServiceOrderItemsDependencies(so);

		so = this.serviceOrderRepo.save(so);
		
		if (allAcknowledged) { //in the case were order items are automatically acknowledged
			so.setState( ServiceOrderStateType.ACKNOWLEDGED );
			so.setStartDate(  OffsetDateTime.now(ZoneOffset.UTC) );
			so = this.serviceOrderRepo.save(so);
		}
		
		raiseSOCreateNotification(so);

		return so;
	}

//	private ServiceOrder fixServiceOrderItemsDependencies(ServiceOrder so) {
//
//		// we need to resolve service relationships for this order item
//		for (ServiceOrderItem soi : so.getOrderItem()) {
//
//			// find the proper service spec
//			ServiceSpecification spec = serviceSpecRepoService
//					.findByUuid(soi.getService().getServiceSpecification().getId());
//			soi = addResourceSpecificationRefs(soi, spec);
//			soi = addBundleSpecificationRefs(soi, spec);
//
//			for (ServiceSpecCharacteristic specChar : spec.getServiceSpecCharacteristic()) {
//				if (specChar.isConfigurable()) {
//					Characteristic serviceCharacteristicItem = new Characteristic();
//					serviceCharacteristicItem.setName(specChar.getName());
//					serviceCharacteristicItem.setValueType(specChar.getValueType());
//					for (ServiceSpecCharacteristicValue specval : specChar.getServiceSpecCharacteristicValue()) {
//						if (specval.isIsDefault()) {
//							serviceCharacteristicItem.setValue(specval.getValue());
//							break;
//						}
//					}
//					soi.getService().addServiceCharacteristicItem(serviceCharacteristicItem);
//				}
//			}
//
//		}
//		return so;
//	}
//
//	private ServiceOrderItem addBundleSpecificationRefs(ServiceOrderItem soi, ServiceSpecification spec) {
//		if (spec.isIsBundle()) {
//			for (ServiceSpecRelationship specRel : spec.getServiceSpecRelationship()) {
//				ServiceSpecification refServiceSpec = serviceSpecRepoService.findByUuid(specRel.getId());
//
//				ServiceRef supportingServiceItem = new ServiceRef();
//				supportingServiceItem.setId(refServiceSpec.getId());
//				supportingServiceItem.setName(refServiceSpec.getName());
//				soi.getService().addSupportingServiceItem(supportingServiceItem);
//				ServiceRelationship serviceRelationshipItem = new ServiceRelationship();
//				serviceRelationshipItem.setRelationshipType(specRel.getRelationshipType());
//				serviceRelationshipItem.setService(supportingServiceItem);
//				soi.getService().addServiceRelationshipItem(serviceRelationshipItem);
//
//				soi = addResourceSpecificationRefs(soi, refServiceSpec); // recursive
//				soi = addBundleSpecificationRefs(soi, refServiceSpec); // recursive
//			}
//		}
//		return soi;
//	}
//
//	private ServiceOrderItem addResourceSpecificationRefs(ServiceOrderItem soi, ServiceSpecification spec) {
//		for (ResourceSpecificationRef resSpecRef : spec.getResourceSpecification()) {
//			ResourceRef supportingResourceItem = new ResourceRef();
//			supportingResourceItem.setId(resSpecRef.getId());
//			supportingResourceItem.setName(resSpecRef.getName());
//
//			soi.getService().addSupportingResourceItem(supportingResourceItem);
//		}
//		return soi;
//	}



	/**
	 * 
	 * will copy any remaining service spec characteristics that where not included in the initial order
	 * 
	 * @param sourceSpecID
	 * @param destServiceCharacteristic
	 */
	private void copySpecCharacteristicsToServiceCharacteristic(String sourceSpecID, @Valid Set<Characteristic> destServiceCharacteristic) {
		ServiceSpecification sourceSpec = serviceSpecRepoService.findByUuid(sourceSpecID);
		if ( sourceSpec == null ) {
			return;
		}
		
		for (ServiceSpecCharacteristic sourceCharacteristic : sourceSpec.getServiceSpecCharacteristic()) {
			if (  sourceCharacteristic.getValueType() != null ) {
				boolean charfound = false;
				for (Characteristic destchar : destServiceCharacteristic) {
					if ( destchar.getName().equals(sourceCharacteristic.getName())) {
						charfound = true;
						break;
					}
				}
				
				if (!charfound) {
				
					Characteristic newChar = new Characteristic();
					newChar.setName( sourceCharacteristic.getName() );
					newChar.setValueType( sourceCharacteristic.getValueType() );
					
					if ( sourceCharacteristic.getValueType().equals( EValueType.ARRAY.getValue() ) ||
							sourceCharacteristic.getValueType().equals( EValueType.SET.getValue() ) ) {
						String valString = "";
						for (ServiceSpecCharacteristicValue specchar : sourceCharacteristic.getServiceSpecCharacteristicValue()) {
							if ( ( specchar.isIsDefault()!= null) && specchar.isIsDefault() ) {
								if ( !valString.equals("")) {
									valString = valString + ",";
								}
								valString = valString + "{\"value\":\"" + specchar.getValue().getValue() + "\",\"alias\":\"" + specchar.getValue().getAlias() + "\"}";
							}
							
						}
						
						newChar.setValue( new Any( "[" + valString + "]", "") );
						
						
					} else {
						for (ServiceSpecCharacteristicValue specchar : sourceCharacteristic.getServiceSpecCharacteristicValue()) {
							if ( ( specchar.isIsDefault()!= null) && specchar.isIsDefault() ) {
								newChar.setValue( new Any(
										specchar.getValue().getValue(), 
										specchar.getValue().getAlias()) );
								break;
							}else {
								if (specchar.isIsDefault()== null){

								logger.info("specchar is null value: " + sourceCharacteristic.getName() );
								}
							}

						}						
					}
					
					//sourceCharacteristic.getServiceSpecCharacteristicValue()
					
					if ( newChar.getValue() !=null) {
						destServiceCharacteristic.add(newChar );
					}
					
				}
				
			}
			
			
		}
		
	}

	@Transactional
	public ServiceOrder updateServiceOrder(String id, @Valid ServiceOrderUpdate serviceOrderUpd) {

		logger.info("Will updateServiceOrder:" + id);		
		
		ServiceOrder so = this.findByUuid(id);
		boolean stateChanged = false;

		//logger.info("so:" + so.toString());		
		for (ServiceOrderItem oi : so.getOrderItem() ) {
			logger.debug( "(oi.getId() = "+oi.getId() );		
			
		}
		if ( serviceOrderUpd.getState()!= null ) {

			stateChanged = so.getState() != serviceOrderUpd.getState();
			so.setState( serviceOrderUpd.getState() );
			
			if ( so.getState().equals( ServiceOrderStateType.COMPLETED )) {
				so.setCompletionDate( OffsetDateTime.now(ZoneOffset.UTC));
			}
			
			
		}
		if ( serviceOrderUpd.getCategory()!= null ) {
			so.setCategory(serviceOrderUpd.getCategory());

		}

		if ( serviceOrderUpd.getDescription()!= null ) {
			so.setDescription(serviceOrderUpd.getDescription());

		}

		if ( serviceOrderUpd.getNotificationContact()!= null ) {
			so.setNotificationContact(serviceOrderUpd.getNotificationContact());

		}

		if ( serviceOrderUpd.getRequestedCompletionDate()!= null ) {
			so.requestedCompletionDate(serviceOrderUpd.getRequestedCompletionDate());

		}

		if ( serviceOrderUpd.getRequestedStartDate()!= null ) {
			so.requestedStartDate(serviceOrderUpd.getRequestedStartDate());

		}

		if ( serviceOrderUpd.getExpectedCompletionDate()!= null ) {
			so.setExpectedCompletionDate(serviceOrderUpd.getExpectedCompletionDate());

		}

		if ( serviceOrderUpd.getStartDate()!= null ) {
			so.setStartDate(serviceOrderUpd.getStartDate());

		}
		
		
		if ( serviceOrderUpd.getOrderItem() != null ) {
			for (ServiceOrderItem soiUpd :  serviceOrderUpd.getOrderItem()) {
				ServiceOrderItem soiOrigin = so.findOrderItemById( soiUpd.getId() );
				if (soiOrigin!=null) {
					updateOrderItem(soiOrigin, soiUpd);
				}
			}
		}
		
		
		

		if (serviceOrderUpd.getNote() != null) {
			for (Note n : serviceOrderUpd.getNote()) {
				if (n.getUuid() == null) {
					so.addNoteItem(n);
				}
			}

		}

		if (serviceOrderUpd.getRelatedParty() != null) {
			for (RelatedParty n : serviceOrderUpd.getRelatedParty()) {
				if (n.getUuid() == null) {
					so.addRelatedPartyItem(n);
				}
			}
		}
		if (serviceOrderUpd.getOrderRelationship() != null) {
			for (ServiceOrderRelationship n : serviceOrderUpd.getOrderRelationship()) {
				if (n.getUuid() == null) {
					so.addOrderRelationshipItem(n);
				}
			}
		}

		so = this.serviceOrderRepo.save(so);
		if (stateChanged) {
			raiseSOStateChangedNotification(so);			
		} else {
			raiseSOAttributeValueChangedNotification(so);
		}
		
		return so;
	}




	private void updateOrderItem(ServiceOrderItem soiOrigin, ServiceOrderItem soiUpd) {
		
		if ( soiUpd.getAction()!=null) {
			soiOrigin.setAction( soiUpd.getAction() );
		}
		
		if ( soiUpd.getState()!=null) {
			soiOrigin.setState( soiUpd.getState() );
		}
		
		if ( soiUpd.getService() !=null) {
			if ( soiOrigin.getService() == null) {
				soiOrigin.setService(soiUpd.getService());
			} else {
				soiOrigin.getService().setState( soiUpd.getService().getState() );//this probably will change only
				soiOrigin.getService().setName( soiUpd.getService().getName() );
				
				//we need also to update supportingServices
				for (ServiceRef serviceRef : soiUpd.getService().getSupportingService()) {
					if ( soiOrigin.getService().getSupportingServiceById(serviceRef.getId() ) == null ) {
						soiOrigin.getService().addSupportingServiceItem(serviceRef);
					}
				}
				
				for (ResourceRef resourceRef : soiUpd.getService().getSupportingResource()) {
					if ( soiOrigin.getService().getSupportingResourceById(resourceRef.getId() ) == null ) {
						soiOrigin.getService().addSupportingResourceItem(resourceRef) ;
					}
				}
				
			}
		}
	}

	public ServiceOrder findByUuid(String id) {
		Optional<ServiceOrder> optionalCat = this.serviceOrderRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public String getServiceOrderEagerAsString(String id) throws JsonProcessingException {
		ServiceOrder s = this.getServiceORderEager(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		String res = mapper.writeValueAsString(s);

		return res;
	}

	public ServiceOrder getServiceORderEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ServiceOrder s = null;
		try {
			s = (ServiceOrder) session.get(ServiceOrder.class, id);
			if (s == null) {
				return this.findByUuid(id);// last resort
			}

			Hibernate.initialize(s.getRelatedParty());
			Hibernate.initialize(s.getOrderItem() );
			Hibernate.initialize(s.getNote() );
			for (ServiceOrderItem soi : s.getOrderItem()) {
				Hibernate.initialize( soi.getService().getSupportingService() );
				Hibernate.initialize( soi.getService().getSupportingResource());
				Hibernate.initialize( soi.getService().getServiceCharacteristic() );
				Hibernate.initialize( soi.getService().getRelatedParty() );
			}
			
			tx.commit();
		} finally {
			session.close();
		}
		
		return s;
	}

	@Transactional
	private void raiseSOCreateNotification(ServiceOrder so) {
		ServiceOrderCreateNotification n = new ServiceOrderCreateNotification();
		ServiceOrderCreateEvent event = new ServiceOrderCreateEvent();
		event.serviceOrder( so );
		n.setEvent(event );
		serviceOrderApiRouteBuilder.publishEvent(n, so.getId());
		
	}

	@Transactional
	private void raiseSOStateChangedNotification(ServiceOrder so) {
		ServiceOrderStateChangeNotification n = new ServiceOrderStateChangeNotification();
		ServiceOrderStateChangeEvent event = new ServiceOrderStateChangeEvent();
		//event.serviceOrder( getServiceORderEager( so.getId()) );
		event.serviceOrder( so );
		n.setEvent(event );
		serviceOrderApiRouteBuilder.publishEvent(n, so.getId());
		
	}

	@Transactional
	private void raiseSOAttributeValueChangedNotification(ServiceOrder so) {
		ServiceOrderAttributeValueChangeNotification n = new ServiceOrderAttributeValueChangeNotification();
		ServiceOrderAttributeValueChangeEvent event = new ServiceOrderAttributeValueChangeEvent();
		event.serviceOrder( so );
		n.setEvent(event );
		serviceOrderApiRouteBuilder.publishEvent(n, so.getId());
	
	}

	public List<ServiceOrder> findAll(String rolename, UserPartRoleType requester) {
//		return (List<ServiceOrder>) this.serviceOrderRepo.findByRolenameAndRoleType(rolename, requester);
		return (List<ServiceOrder>) this.serviceOrderRepo.findByRolename(rolename);
	}

	public Void deleteByUuid(String id) {
		
		Optional<ServiceOrder> optso = this.serviceOrderRepo.findByUuid(id);
		ServiceOrder so = optso.get();
		if ( so == null ) {
			return null;
		}
		
		this.serviceOrderRepo.delete(so);
		return null;
	}

}
