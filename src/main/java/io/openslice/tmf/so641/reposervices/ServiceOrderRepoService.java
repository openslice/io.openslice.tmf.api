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

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

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
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderItem;
import io.openslice.tmf.so641.model.ServiceOrderRelationship;
import io.openslice.tmf.so641.model.ServiceOrderStateType;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
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


	private SessionFactory  sessionFactory;

	@Autowired
	public ServiceOrderRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public List<ServiceOrder> findAll() {

		return (List<ServiceOrder>) this.serviceOrderRepo.findAll();
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

	public ServiceOrder addServiceOrder(@Valid ServiceOrderCreate serviceOrder) {
		ServiceOrder so = new ServiceOrder();
		so.setOrderDate(OffsetDateTime.now(ZoneOffset.UTC));
		so.setCategory(serviceOrder.getCategory());
		so.setDescription(serviceOrder.getDescription());
		so.setExternalId(serviceOrder.getExternalId());
		so.setNotificationContact(serviceOrder.getNotificationContact());
		so.priority(serviceOrder.getPriority());
		so.requestedCompletionDate(serviceOrder.getRequestedCompletionDate());
		so.requestedStartDate(serviceOrder.getRequestedCompletionDate());
		if (serviceOrder.getNote() != null) {
			so.getNote().addAll(serviceOrder.getNote());
		}
		if (serviceOrder.getOrderItem() != null) {
			so.getOrderItem().addAll(serviceOrder.getOrderItem());
		}

		if (serviceOrder.getRelatedParty() != null) {
			so.getRelatedParty().addAll(serviceOrder.getRelatedParty());
		}
		if (serviceOrder.getOrderRelationship() != null) {
			so.getOrderRelationship().addAll(serviceOrder.getOrderRelationship());

		}
		
//		so = this.serviceOrderRepo.save(so);
//		so = this.fixServiceOrderItemsDependencies(so);

		so = this.serviceOrderRepo.save(so);

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

	public ServiceOrder updateServiceOrder(String id, @Valid ServiceOrderUpdate serviceOrder) {
		ServiceOrder so = this.findByUuid(id);

		if ( serviceOrder.getState()!= null ) {

			so.setState( serviceOrder.getState() );
		}
		if ( serviceOrder.getCategory()!= null ) {
			so.setCategory(serviceOrder.getCategory());

		}

		if ( serviceOrder.getDescription()!= null ) {
			so.setDescription(serviceOrder.getDescription());

		}

		if ( serviceOrder.getNotificationContact()!= null ) {
			so.setNotificationContact(serviceOrder.getNotificationContact());

		}

		if ( serviceOrder.getRequestedCompletionDate()!= null ) {
			so.requestedCompletionDate(serviceOrder.getRequestedCompletionDate());

		}

		if ( serviceOrder.getRequestedCompletionDate()!= null ) {
			so.requestedStartDate(serviceOrder.getRequestedCompletionDate());

		}

		if ( serviceOrder.getExpectedCompletionDate()!= null ) {
			so.setExpectedCompletionDate(serviceOrder.getExpectedCompletionDate());

		}

		if ( serviceOrder.getStartDate()!= null ) {
			so.setStartDate(serviceOrder.getStartDate());

		}

		if (serviceOrder.getNote() != null) {
			for (Note n : serviceOrder.getNote()) {
				if (n.getUuid() == null) {
					so.addNoteItem(n);
				}
			}

		}

		if (serviceOrder.getRelatedParty() != null) {
			for (RelatedParty n : serviceOrder.getRelatedParty()) {
				if (n.getUuid() == null) {
					so.addRelatedPartyItem(n);
				}
			}
		}
		if (serviceOrder.getOrderRelationship() != null) {
			for (ServiceOrderRelationship n : serviceOrder.getOrderRelationship()) {
				if (n.getUuid() == null) {
					so.addOrderRelationshipItem(n);
				}
			}
		}

		so = this.serviceOrderRepo.save(so);

		return so;
	}

	public ServiceOrder findByUuid(String id) {
		Optional<ServiceOrder> optionalCat = this.serviceOrderRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public String getServiceOrderEagerAsString(String id) throws JsonProcessingException {
		ServiceOrder s = this.getServiceORderEager(id);
		ObjectMapper mapper = new ObjectMapper();
		// Registering Hibernate4Module to support lazy objects
		// this will fetch all lazy objects of VxF before marshaling
		mapper.registerModule(new Hibernate5Module());
		String res = mapper.writeValueAsString(s);

		return res;
	}

	private ServiceOrder getServiceORderEager(String id) {
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
			
			tx.commit();
		} finally {
			session.close();
		}
		
		return s;
	}

}
