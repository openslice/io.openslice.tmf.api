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
package io.openslice.tmf.ro652.reposervices;

import java.io.UnsupportedEncodingException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCharacteristicValue;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.ri639.model.Characteristic;
import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceRefOrValue;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;
import io.openslice.tmf.ro652.model.ResourceOrder;
import io.openslice.tmf.ro652.model.ResourceOrderCreate;
import io.openslice.tmf.ro652.model.ResourceOrderItem;
import io.openslice.tmf.ro652.model.ResourceOrderStateType;
import io.openslice.tmf.ro652.model.ResourceOrderUpdate;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristicValue;

@Service
public class ResourceOrderRepoService {

	private static final transient Log logger = LogFactory.getLog(ResourceOrderRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ResourceSpecificationRepoService resourceSpecRepoService;

	@Autowired
	ResourceRepoService resourceRepoService;

	
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
		
				return new ArrayList<>();

	}
	
	public List<ResourceOrder> findAll() {
		return new ArrayList<>();
	}
	
	public List<ResourceOrder> findAllParams(Map<String, String> allParams) {

		return new ArrayList<>();

	}
	
	public String findAllParamsJsonOrderIDs(Map<String, String> allParams) throws JsonProcessingException {
		
		return "[]";
	}

	public ResourceOrder addResourceOrder(@Valid ResourceOrderCreate rOrderCreate) {
		ResourceOrder ro = new ResourceOrder();
		ro.orderDate(OffsetDateTime.now(ZoneOffset.UTC))
		 .category(rOrderCreate.getCategory())
		 .description(rOrderCreate.getDescription())
		 .externalId(rOrderCreate.getExternalId())
		 .priority(rOrderCreate.getPriority())
		 .requestedCompletionDate(rOrderCreate.getRequestedCompletionDate())
		 .requestedStartDate(rOrderCreate.getRequestedStartDate() )
		 .startDate( rOrderCreate.getRequestedStartDate() )
		 .expectedCompletionDate( rOrderCreate.getRequestedCompletionDate() );  //this is by default
		if (rOrderCreate.getNote() != null) {
			ro.getNote().addAll(rOrderCreate.getNote());
		}
		if (rOrderCreate.getRelatedParty() != null) {
			ro.getRelatedParty().addAll(rOrderCreate.getRelatedParty());
		}
		

		boolean allAcknowledged = true;
		if (rOrderCreate.getOrderItem() != null) {
			ro.getOrderItem().addAll(rOrderCreate.getOrderItem());
			for (ResourceOrderItem soi : ro.getOrderItem()) {				
				//as of 18/8/2021 in service item we do not copy all service spec characteristics. 
				//The characteristics of the spec, since they are not user configurable will
				//be just exist in the service instance
				//copySpecCharacteristicsToServiceCharacteristic( soi.getService().getServiceSpecification().getId(), soi.getService().getServiceCharacteristic() );
				
				if ( soi.getState()!=null && !soi.getState().equals( ResourceOrderStateType.ACKNOWLEDGED )) {
					allAcknowledged = false;
				}
				
				//at this stage we have no ResOrchestrator.. we will dot this by simple code
				ResourceRefOrValue r = createResource( soi, rOrderCreate.getRelatedParty() );
				soi.resource( r );
				
			}
			
			
			
		}

		

		
//		so = this.serviceOrderRepo.save(so);
//		so = this.fixServiceOrderItemsDependencies(so);
		
		Note noteItem = new Note();
		noteItem.setText("Resource Order " + ResourceOrderStateType.INITIAL);
		noteItem.setAuthor("RO652API-addResourceOrder");
		noteItem.setDate(OffsetDateTime.now(ZoneOffset.UTC) );
		ro.addNoteItem(noteItem);

		return ro;
	}



	private ResourceRefOrValue createResource(ResourceOrderItem soi, @Valid List<RelatedParty> list) {
		
		@Valid
		ResourceCreate resCreate = new ResourceCreate();
		var specRef = soi.getResource().getResourceSpecification();
		if ( specRef == null ) {
			specRef = soi.getResourceSpecification();
		}
		

		var spec = resourceSpecRepoService.findByUuid( specRef.getId() );
		if ( spec == null) {
			spec = resourceSpecRepoService.findByName( specRef.getName() );
			if ( spec == null) {
				return new ResourceRefOrValue();				
			}
		}
		
		if ( soi.getResource().getName() !=null ) {
			resCreate.setName( soi.getResource().getName() );
		} else {
			resCreate.setName( spec.getName() );
			
		}
		
		
		resCreate.setDescription("A Resource called " +resCreate.getName() + " based on resource spec" + spec.getName());
		resCreate.setCategory( spec.getCategory() ); 
		if ( spec.getType().toLowerCase().contains( "physical" ) ) {
			resCreate.setAtType("PhysicalResource");					
		} else {
			resCreate.setAtType("LogicalResource");			
		}
		
		
		ResourceSpecificationRef thespecRef = new ResourceSpecificationRef();
		thespecRef.setId( spec.getId());
		thespecRef.setName( spec.getName() );
		resCreate.setResourceSpecification( thespecRef  );
		
		
		for (ResourceSpecificationCharacteristic c : spec.getResourceSpecCharacteristic()) {
			for (Characteristic orderCharacteristic : soi.getResource().getResourceCharacteristic()) {
				String specCharacteristicToSearch = c.getName();
				 if ( orderCharacteristic.getName().equals( specCharacteristicToSearch )) { //copy only characteristics that are related from the order		
					 resCreate.addResourceCharacteristicItem(  addResourceCharacteristicItem(c, orderCharacteristic) );
					break;
				}
			}
		}
		
		
		if ( resCreate.getResourceCharacteristic() == null) {
			resCreate.setResourceCharacteristic( new ArrayList<>() );
		}
		
		copyRemainingSpecCharacteristicsToResourceCharacteristic(spec , resCreate.getResourceCharacteristic() );	//copy to resource the rest of the characteristics that do not exists yet from the above search	
		
		
		var newresource		= resourceRepoService.addResource( resCreate  );
		
		var result = new ResourceRefOrValue();
		result.setId( newresource.getId() );
		result.setName(newresource.getName());
		result.getResourceCharacteristic().addAll( newresource.getResourceCharacteristic() );
		result.setResourceSpecification( newresource.getResourceSpecification()  );
		return result;
	}

	private void copyRemainingSpecCharacteristicsToResourceCharacteristic(ResourceSpecification spec,
			@Valid List<Characteristic> destResCharacteristic) {
		for (ResourceSpecificationCharacteristic sourceCharacteristic : spec.getResourceSpecCharacteristic()) {
			if (  sourceCharacteristic.getValueType() != null ) {
				boolean charfound = false;
				for (Characteristic destchar : destResCharacteristic) {
					if ( destchar.getName().equals(sourceCharacteristic.getName())) {
						charfound = true;
						break;
					}
				}
				
				if (!charfound) {
				
					Characteristic newChar = new Characteristic();
					newChar.setName( sourceCharacteristic.getName() );
					newChar.setValueType( sourceCharacteristic.getValueType() );
					
					if (  sourceCharacteristic.getValueType() != null && sourceCharacteristic.getValueType().equals( EValueType.ARRAY.getValue() ) ||
							 sourceCharacteristic.getValueType() != null && sourceCharacteristic.getValueType().equals( EValueType.SET.getValue() ) ) {
						String valString = "";
						for (ResourceSpecificationCharacteristicValue specchar : sourceCharacteristic.getResourceSpecCharacteristicValue()) {
							if ( ( specchar.isIsDefault()!= null) && specchar.isIsDefault() ) {
								if ( !valString.equals("")) {
									valString = valString + ",";
								}
								valString = valString + "{\"value\":\"" + specchar.getValue().getValue() + "\",\"alias\":\"" + specchar.getValue().getAlias() + "\"}";
							}
							
						}
						
						newChar.setValue( new Any( "[" + valString + "]", "") );
						
						
					} else {
						for (ResourceSpecificationCharacteristicValue specchar : sourceCharacteristic.getResourceSpecCharacteristicValue()) {
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
						destResCharacteristic.add(newChar );
					} else {
						newChar.setValue( new Any(
								"", 
								"") );
						destResCharacteristic.add(newChar );
					}
					
				}
				
			}
			
			
		}
		
	}

	private Characteristic addResourceCharacteristicItem(ResourceSpecificationCharacteristic c, Characteristic orderCharacteristic) {
		Characteristic resCharacteristicItem =  new Characteristic();
		resCharacteristicItem.setName( c.getName() );
		resCharacteristicItem.setValueType( c.getValueType() );
					
		Any val = new Any();
		val.setValue( orderCharacteristic.getValue().getValue() );
		val.setAlias( orderCharacteristic.getValue().getAlias() );
		
		resCharacteristicItem.setValue( val );
		
		return resCharacteristicItem;
	}
	

	@Transactional
	public ResourceOrder updateResourceOrder(String id, @Valid ResourceOrderUpdate resourceOrderUpd) {
		return null;
		
	}





	

}
