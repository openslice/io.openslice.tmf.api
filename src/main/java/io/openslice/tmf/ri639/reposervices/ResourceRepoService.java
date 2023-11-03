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
package io.openslice.tmf.ri639.reposervices;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.ri639.api.ResourceApiRouteBuilderEvents;
import io.openslice.tmf.ri639.model.Characteristic;
import io.openslice.tmf.ri639.model.Feature;
import io.openslice.tmf.ri639.model.LogicalResource;
import io.openslice.tmf.ri639.model.PhysicalResource;
import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceCreateEvent;
import io.openslice.tmf.ri639.model.ResourceCreateNotification;
import io.openslice.tmf.ri639.model.ResourceRelationship;
import io.openslice.tmf.ri639.model.ResourceUpdate;
import io.openslice.tmf.ri639.repo.ResourceRepository;
import io.openslice.tmf.sim638.model.Service;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;




@org.springframework.stereotype.Service
public class ResourceRepoService {

	private static final transient Log logger = LogFactory.getLog(ResourceRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ResourceRepository resourceRepo;
	
	@Autowired
	ResourceSpecificationRepoService  resourceSpecRepoService;

	private SessionFactory  sessionFactory;

	@Autowired
	ResourceApiRouteBuilderEvents resourceApiRouteBuilder;
	
	@Autowired
	public ResourceRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public List<Resource> findAll() {

		return (List<Resource>) this.resourceRepo.findAll();
	}
	
	public List findAll(@Valid String fields, Map<String, String> allParams)
			throws UnsupportedEncodingException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			String sql = "SELECT "
					+ "srv.uuid as uuid,"
					+ "srv.startOperatingDate as startOperatingDate,"
					+ "srv.name as name,"
					+ "srv.category as category,"
					+ "srv.resourceStatus as resourceStatus,"
					+ "srv.type as type"
					;
			
			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", srv." + f + " as " + f ;
				}
				
			}			
			//sql += "  FROM RIResource  RILogicalRes RIPhysicalRes srv ";
			sql += "  FROM RIResource srv ";
			
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			
			sql += "  ORDER BY srv.startOperatingDate DESC";
			
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
			
	
			
			
			
			
			return mapaEntity;
		
			
			
			
		} finally {
			tx.commit();
			session.close();
		}

	}
	
	
	public List<Resource> findAll(String name, UserPartRoleType requester) {

		return (List<Resource>) this.resourceRepo.findByRolename(name);
	}
	

	public Resource addResource(@Valid ResourceCreate resource) {
		logger.info("Will add Resource: " + resource.getName() );
		
		Resource s;
		
		if (resource.getAtType()!=null && resource.getAtType().toLowerCase().contains( "physicalresource" ) ) {
			s = new PhysicalResource();			
		} else {
			s = new LogicalResource();
		}
		
		if (resource.getAtType()!=null) {
			s.setType(resource.getAtType());			
		}
		s.setName(resource.getName());
		s.setCategory( resource.getCategory() );
		s.setDescription( resource.getDescription() );
		s.setStartOperatingDate( resource.getStartOperatingDate());
		s.setEndOperatingDate( resource.getEndOperatingDate() );


		s.setUsageState( resource.getUsageState() );
		s.setResourceStatus( resource.getResourceStatus() );
		s.setResourceVersion( resource.getResourceVersion() );
		s.setOperationalState( resource.getOperationalState() );
		s.setAdministrativeState( resource.getAdministrativeState() );
		


		
		ResourceSpecificationRef thespecRef = new ResourceSpecificationRef();
		thespecRef.setId( resource.getResourceSpecification().getId());
		thespecRef.setName( resource.getResourceSpecification().getName());
		//resCreate.setResourceSpecification( thespecRef  );
		s.setResourceSpecification( thespecRef );
		
		
		if ( resource.getPlace() != null) {
			s.setPlace( resource.getPlace() );
		}
		
		if ( resource.getNote() != null) {
			s.getNote().addAll( resource.getNote() );
		}
		
		if ( resource.getRelatedParty()!=null ) {
			s.getRelatedParty().addAll( resource.getRelatedParty());
		}
		
		if ( resource.getResourceCharacteristic () != null) {
			s.getResourceCharacteristic().addAll( resource.getResourceCharacteristic() );
		}

		if ( resource.getResourceRelationship() != null) {
			s.getResourceRelationship().addAll( resource.getResourceRelationship() );
		}
		if ( resource.getAttachment() != null) {
			s.getAttachment().addAll( resource.getAttachment() );
		}
		if ( resource.getActivationFeature() != null) {
			s.getActivationFeature().addAll( resource.getActivationFeature() );
		}
		
		Note noteItem = new Note();
		noteItem.setText("Resource status: " + s.getResourceStatus() );
		noteItem.setAuthor("API");
		noteItem.setDate(OffsetDateTime.now(ZoneOffset.UTC) );
		s.addNoteItem(noteItem);		
		
		s = this.resourceRepo.save( s );

		raiseResourceCreateNotification(s);
		return s;
	}

	

	public Resource findByUuid(String id) {
		Optional<Resource> optionalCat = this.resourceRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	@Transactional
	public Resource updateResource(String id, @Valid ResourceUpdate resourceUpd, boolean propagateToSO ) {
		Resource resource = this.findByUuid(id);
		
		if ( resource == null ) {

			logger.error("Resource cannot be found in registry, UUID: " + id  );
			return null;
		}

		logger.info("Will update Resource: " + resource.getName() );
		//logger.info("Will update service details: " + s.toString() );
		
//		ObjectMapper mapper = new ObjectMapper();
//		String originaServiceAsJson = null;
//		try {
//			originaServiceAsJson = mapper.writeValueAsString( resource );
//		} catch (JsonProcessingException e) {
//			logger.error("cannot umarshall service: " + resource.getName() );
//			e.printStackTrace();
//		}
		

		if ( resourceUpd.getResourceRelationship() != null) {
			//resource.getResourceRelationship().addAll( resourceUpd.getResourceRelationship() );
			// new LinkedHashSet<ReservationItem>( list )
			resource.setResourceRelationship(new LinkedHashSet<ResourceRelationship>( resourceUpd.getResourceRelationship() ) );
		}

				
		if (resourceUpd.getAtType()!=null) {
			resource.setType(resourceUpd.getAtType());			
		}
		
		if (resourceUpd.getName() != null ) {
			resource.setName(resourceUpd.getName());			
		}

		if (resourceUpd.getCategory() != null ) {
			resource.setCategory( resourceUpd.getCategory() );			
		}
		if (resourceUpd.getDescription() != null ) {
			resource.setDescription( resourceUpd.getDescription() );			
		}
		if (resourceUpd.getStartOperatingDate() != null ) {
			resource.setStartOperatingDate( resourceUpd.getStartOperatingDate());
		}
		if (resourceUpd.getEndOperatingDate() != null ) {
			resource.setEndOperatingDate( resourceUpd.getEndOperatingDate() );			
		}

		if (resourceUpd.getUsageState() != null ) {
			resource.setUsageState(resourceUpd.getUsageState());			
		}

		if (resourceUpd.getResourceStatus() != null ) {
			resource.setResourceStatus(resourceUpd.getResourceStatus());			
		}

		if (resourceUpd.getResourceVersion() != null ) {
			resource.setResourceVersion(resourceUpd.getResourceVersion());			
		}
		if (resourceUpd.getOperationalState() != null ) {
			resource.setOperationalState(resourceUpd.getOperationalState());			
		}
		if (resourceUpd.getAdministrativeState() != null ) {
			resource.setAdministrativeState(resourceUpd.getAdministrativeState());			
		}		
			
		
		if (resourceUpd.getResourceSpecification() != null ) {
			resource.setResourceSpecification( resourceUpd.getResourceSpecification() );
		}
		
		if (resourceUpd.getPlace() != null ) {
			resource.setPlace( resourceUpd.getPlace() );
		}


		/**
		 * the following need to be modified for deleting items from lists.
		 */
		
		if ( resourceUpd.getNote()!=null ) {
			for (Note n : resourceUpd.getNote()) {
				if (n.getUuid() == null) {
					resource.addNoteItem(n);
				}
			}						
		}
		
		if ( resourceUpd.getRelatedParty()!=null ) {
			for (RelatedParty n : resourceUpd.getRelatedParty()) {
				if (n.getUuid() == null) {
					resource.addRelatedPartyItem(n);
				}
			}						
		}
		
		boolean resourceCharacteristicChanged = false;
		if ( resourceUpd.getResourceCharacteristic()!=null ) {
			for (Characteristic n : resourceUpd.getResourceCharacteristic()) {
				
					if ( resource.getResourceCharacteristicByName( n.getName() )!= null ) {
						
						Characteristic origChar = resource.getResourceCharacteristicByName( n.getName() );
						if ( ( origChar !=null ) && ( origChar.getValue() !=null ) && ( origChar.getValue().getValue() !=null )) {
							if ( !origChar.getValue().getValue().equals(n.getValue().getValue()) ) {
								resourceCharacteristicChanged = true;								
							}
						}
						
						 resource.getResourceCharacteristicByName( n.getName() ).setValue( 
								 new Any( n.getValue().getValue(), n.getValue().getAlias()  )
								 );
					} else {
						resource.addResourceCharacteristicItem(n);
					}				
			}						
		}		
		
		
		if ( resourceUpd.getActivationFeature()!=null ) {
			for (Feature n : resourceUpd.getActivationFeature()) {				
					if ( n.getId() != null ) {
						//we need to update this ?						
					} else {
						resource.getActivationFeature().add(n);
					}
				
			}						
		}
		
	
		
		return resource;
	}

	public String getResourceEagerAsString(String id) throws JsonProcessingException {
		Resource s = this.getResourceEager(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5JakartaModule());
		String res = mapper.writeValueAsString(s);

		return res;
	}
	
	public Resource getResourceEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Resource s = null;
		try {
			s = (Resource) session.get(Resource.class, id);
			if (s == null) {
				return this.findByUuid(id);// last resort
			}

			Hibernate.initialize(s.getRelatedParty());
			Hibernate.initialize(s.getNote() );
			Hibernate.initialize(s.getResourceCharacteristic() );
			Hibernate.initialize(s.getResourceSpecification() );
			Hibernate.initialize(s.getResourceRelationship() );
			Hibernate.initialize(s.getAttachment() );
			Hibernate.initialize(s.getActivationFeature() );
			Hibernate.initialize(s.getActivationFeature() );
			
			tx.commit();
		} finally {
			session.close();
		}
		
		return s;
	}
	

	@Transactional
	private void raiseResourceCreateNotification(Resource so) {
		ResourceCreateNotification n = new ResourceCreateNotification();
		ResourceCreateEvent event = new ResourceCreateEvent();
		event.getEvent().setResource( so );
		n.setEvent(event );
		resourceApiRouteBuilder.publishEvent(n, so.getId());
		
	}
	@Transactional
	public List<String> findAllActiveResourcesToTerminate(){

		List<String> result = new ArrayList<>();
		List<Resource> resourcs = this.resourceRepo.findActiveToTerminate();
		for (Resource r : resourcs) {
			result.add(  r.getId());
		}
		
		return result;
	}

	/**
	 * @return UUIDs of Services and put them in a List
	 */
	@Transactional
	public List<String> findAllActiveAndReservedResourcesOfPartners(){

		List<String> result = new ArrayList<>();
		List<Resource> srvs = this.resourceRepo.findActiveAndReservedResourcesOfPartners();
		for (Resource r : srvs) {
			result.add(  r.getId());
		}
		
		return result;
	}

	public Void deleteByUuid(String id) {
		Optional<Resource> optionalCat = this.resourceRepo.findByUuid(id);
		Resource s = optionalCat.get();
		if (s == null) {
			return null;
		}

		
		this.resourceRepo.delete( s );
		return null;
	}
	

	@Transactional
	public Resource addOrUpdateResourceByNameCategoryVersion(String aName,String aCategory, String aVersion, ResourceCreate aesourceCreate){
		
		List<Resource> resources = this.resourceRepo.findByNameAndCategoryAndResourceVersion(aName, aCategory, aVersion);
		Resource result = null;
		
		if ( resources.size()>0) {
			//perform update to the first one
			String resID = resources.get(0).getUuid();
			result = this.updateResource(resID, aesourceCreate, false);
			
					
			 
		} else {
			result =  this.addResource(aesourceCreate);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String originaServiceAsJson = mapper.writeValueAsString( result );
			logger.debug(originaServiceAsJson);
		} catch (JsonProcessingException e) {
			logger.error("cannot umarshall service: " + result.getName() );
			e.printStackTrace();
		}	
		
		return result;
	}
	
	

	
}
