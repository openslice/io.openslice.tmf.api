/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.pm632.reposervices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.pm632.api.OrganizationApiRouteBuilder;
import io.openslice.tmf.pm632.model.Characteristic;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.Organization;
import io.openslice.tmf.pm632.model.OrganizationAttributeValueChangeEvent;
import io.openslice.tmf.pm632.model.OrganizationAttributeValueChangeEventPayload;
import io.openslice.tmf.pm632.model.OrganizationCreate;
import io.openslice.tmf.pm632.model.OrganizationCreateEvent;
import io.openslice.tmf.pm632.model.OrganizationCreateEventPayload;
import io.openslice.tmf.pm632.model.OrganizationUpdate;
import io.openslice.tmf.pm632.repo.OrganizationRepository;
import io.openslice.tmf.prm669.model.RelatedParty;


@Service
@Transactional
public class OrganizationRepoService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	OrganizationApiRouteBuilder organizationApiRouteBuilder;

	private SessionFactory  sessionFactory;
	

	private static final transient Log logger = LogFactory.getLog( OrganizationRepoService.class.getName());
	
	@Autowired
	public OrganizationRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public List<Organization> findAll() {
		return (List<Organization>) this.organizationRepository.findByOrderByName();
	}

	public Organization addOrganization(@Valid OrganizationCreate organization) {
		Organization c = new Organization();
		c = updateOrganizationData(c, organization);
		c = organizationRepository.save(c);
		raiseOrganizationCreate( c );
		return c;
	}
	
	public Organization updateOrganization(String id, @Valid OrganizationUpdate organization) {
		Organization c = this.findByUuid(id);
		if ( c == null) {
			return null;
		}
		c = this.updateOrganizationData(c, organization);
		c = this.organizationRepository.save(c);
		raiseOrganizationChanged(c);
		return c;
	}

	private Organization findByUuid(String id) {
		Optional<Organization> optionalCat = this.organizationRepository.findByUuid(id);
		return optionalCat.orElse(null);
	}

	private Organization updateOrganizationData(Organization c, @Valid OrganizationUpdate orgUpd) {
		
		if ( orgUpd.getName()!=null) {
			c.setName( orgUpd.getName() );
		}
		
		if ( orgUpd.getTradingName() !=null) {
			c.setTradingName( orgUpd.getTradingName() );
		}
		
		
		
		if ( orgUpd.getContactMedium() !=null) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ContactMedium cmUpd : orgUpd.getContactMedium()) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ContactMedium originalCm : c.getContactMedium()) {
					if ( ( originalCm.getUuid()!=null ) && originalCm.getUuid().equals(cmUpd.getUuid() ) ) {
						idexists = true;
						idAddedUpdated.put( originalCm.getUuid(), true);
						originalCm.updateWith( cmUpd );
						break;
					}
				}
				if (!idexists) {
					c.addContactMediumItem( cmUpd );
				}
				
			}
		}
		
		if ( orgUpd.getPartyCharacteristic() !=null) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (Characteristic cmUpd : orgUpd.getPartyCharacteristic()) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (Characteristic originalCm : c.getPartyCharacteristic()) {
					if ( ( originalCm.getUuid()!=null ) && originalCm.getUuid().equals(cmUpd.getUuid() ) ) {
						idexists = true;
						idAddedUpdated.put( originalCm.getUuid(), true);
						originalCm.updateWith( cmUpd );
						break;
					}
				}
				if (!idexists) {
					c.addPartyCharacteristicItem( cmUpd );
				}
				
			}
		}
		
		return c;
	}

	public Organization findById(String id) {
		Optional<Organization> c = this.organizationRepository.findByUuid(id);
		return c.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<Organization> c = this.organizationRepository.findByUuid(id);
		this.organizationRepository.delete( c.get());
		return null;
	}

	
	private void raiseOrganizationCreate(Organization c) {
		
		OrganizationCreateEvent ce = new OrganizationCreateEvent();
		OrganizationCreateEventPayload event = new OrganizationCreateEventPayload();
		event.setOrganization(c);
		ce.setEvent(event);
		organizationApiRouteBuilder.publishEvent( ce, c.getId() );
		
	}
	
	
	private void raiseOrganizationChanged(Organization c) {
		
		OrganizationAttributeValueChangeEvent ce = new OrganizationAttributeValueChangeEvent();
		OrganizationAttributeValueChangeEventPayload event = new OrganizationAttributeValueChangeEventPayload();
		event.setOrganization(c);
		ce.setEvent(event);
		organizationApiRouteBuilder.publishEvent( ce, c.getId() );
		
	}
	
	@Transactional
	public String getPartnerOrganizationsWithAPI() {

		List<Organization> orgz =organizationRepository.findPartnersOfferingEXTERNAL_TMFAPI();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			List<Organization> orgzsend = new ArrayList<>();
			for (Organization o : orgz) {
				logger.info( "o.getUuid()"  + o.getUuid());
				logger.debug( "o.getUuid()"  + o.toString() );
				Organization anorg = session.get(Organization.class, o.getUuid()) ;//this.findByUuid( o.getUuid());		
				if (anorg!=null) {
					orgzsend.add( anorg );					
				} else {

					orgzsend.add( o );
				}
			}
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			return mapper.writeValueAsString( orgzsend );
		
		} catch (JsonProcessingException e) {
			logger.error( "Failed to writeValueAsString getPartnerOrganizationsWithAPI." );
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
	    }
		
		return "[]";
	}
	

	@Transactional
	public String findByUuidJson(String id) {
		Organization o = this.findByUuid(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		try {
			return mapper.writeValueAsString( o );
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
			
		}
		
		return "{}";
	}

}
