package io.openslice.tmf.so641.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm633.model.ResourceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.so641.model.Characteristic;
import io.openslice.tmf.so641.model.ResourceRef;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderItem;
import io.openslice.tmf.so641.model.ServiceRef;
import io.openslice.tmf.so641.model.ServiceRelationship;
import io.openslice.tmf.so641.repo.ServiceOrderRepository;

@Service
public class ServiceOrderRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceOrderRepository serviceOrderRepo;
	

	@Autowired
	ServiceSpecificationRepoService  serviceSpecRepoService;

	public List<ServiceOrder> findAll() {

		return (List<ServiceOrder>) this.serviceOrderRepo.findAll();
	}

	public ServiceOrder addServiceOrder(@Valid ServiceOrderCreate serviceOrder) {
		ServiceOrder so = new ServiceOrder();
		so.setOrderDate( OffsetDateTime.now(ZoneOffset.UTC) );
		so.setCategory( serviceOrder.getCategory() );
		so.setDescription( serviceOrder.getDescription() );
		so.setExternalId( serviceOrder.getExternalId());
		so.setNotificationContact(serviceOrder.getNotificationContact());
		so.priority(serviceOrder.getPriority());
		so.requestedCompletionDate(serviceOrder.getRequestedCompletionDate());
		so.requestedStartDate(serviceOrder.getRequestedCompletionDate());
		if ( serviceOrder.getNote()!=null ) {
			so.getNote().addAll(serviceOrder.getNote());			
		}
		if ( serviceOrder.getOrderItem()!=null ) {
			so.getOrderItem().addAll( serviceOrder.getOrderItem());
		}

		if ( serviceOrder.getRelatedParty()!=null ) {
			so.getRelatedParty().addAll(serviceOrder.getRelatedParty());
		}
		if ( serviceOrder.getOrderRelationship()!=null ) {
			so.getOrderRelationship().addAll( serviceOrder.getOrderRelationship());		
			
		}
		so = this.serviceOrderRepo.save( so );
		
		so = this.fixServiceOrderItemsDependencies(so);
		
		so = this.serviceOrderRepo.save( so );
		
		return so;
	}

	private ServiceOrder fixServiceOrderItemsDependencies(ServiceOrder so) {
		
		//we need to resolve service relationships for this order item 
		for (ServiceOrderItem soi : so.getOrderItem()) {

			//find the proper service spec
			ServiceSpecification spec = serviceSpecRepoService.findByUuid( soi.getService().getServiceSpecification().getId() );
			soi = addResourceSpecificationRefs(soi, spec);
			soi = addBundleSpecificationRefs(soi, spec);
			
			
			for (ServiceSpecCharacteristic specChar : spec.getServiceSpecCharacteristic()) {
				if ( specChar.isConfigurable() ){
					Characteristic serviceCharacteristicItem = new Characteristic();
					serviceCharacteristicItem.setName( specChar.getName() );
					serviceCharacteristicItem.setValueType( specChar.getValueType());
					for (ServiceSpecCharacteristicValue  specval: specChar.getServiceSpecCharacteristicValue()) {
						if ( specval.isIsDefault() ){
							serviceCharacteristicItem.setValue( specval.getValue() );
							break;							
						}
					}
					soi.getService().addServiceCharacteristicItem(serviceCharacteristicItem );
				}
			}
			
		}
		return so;
	}

	private ServiceOrderItem addBundleSpecificationRefs(ServiceOrderItem soi, ServiceSpecification spec) {
		if ( spec.isIsBundle()){
			for (ServiceSpecRelationship specRel : spec.getServiceSpecRelationship()) {
				ServiceSpecification refServiceSpec = serviceSpecRepoService.findByUuid( specRel.getId() );

				ServiceRef supportingServiceItem = new ServiceRef();
				supportingServiceItem.setId( refServiceSpec.getId() );
				supportingServiceItem.setName( refServiceSpec.getName());
				soi.getService().addSupportingServiceItem(supportingServiceItem );
				ServiceRelationship serviceRelationshipItem = new ServiceRelationship();
				serviceRelationshipItem.setRelationshipType( specRel.getRelationshipType() );
				serviceRelationshipItem.setService(supportingServiceItem);
				soi.getService().addServiceRelationshipItem(serviceRelationshipItem );
				
				soi = addResourceSpecificationRefs(soi, refServiceSpec); //recursive
				soi = addBundleSpecificationRefs(soi, refServiceSpec); //recursive
			}				
		}
		return soi;
	}

	private ServiceOrderItem addResourceSpecificationRefs(ServiceOrderItem soi, ServiceSpecification spec) {
		for (ResourceSpecificationRef resSpecRef : spec.getResourceSpecification()) {
			ResourceRef supportingResourceItem = new ResourceRef();
			supportingResourceItem.setId( resSpecRef.getId());
			supportingResourceItem.setName( resSpecRef.getName());
			
			soi.getService().addSupportingResourceItem(supportingResourceItem );
		}
		return soi;
	}

}
