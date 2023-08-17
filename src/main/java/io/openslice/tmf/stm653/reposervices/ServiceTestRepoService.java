/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.stm653.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import io.openslice.tmf.stm653.model.Characteristic;
import io.openslice.tmf.stm653.model.CharacteristicRelationship;
import io.openslice.tmf.stm653.model.ServiceTest;
import io.openslice.tmf.stm653.model.ServiceTestCreate;
import io.openslice.tmf.stm653.model.ServiceTestUpdate;
import io.openslice.tmf.stm653.model.TestMeasure;
import io.openslice.tmf.stm653.repo.ServiceTestRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;

/**
 * @author ctranoris
 *
 */
@Service
public class ServiceTestRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceTestRepoService.class.getName());


	@Autowired
	ServiceTestRepository aServiceTestRepo;

	private SessionFactory sessionFactory;
	

	@Autowired
	ServiceRepoService serviceRepoService;
	
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	public ServiceTestRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public ServiceTest addServiceTest(@Valid ServiceTestCreate serviceTest) {

		ServiceTest serviceSpec = new ServiceTest();
		serviceSpec = this.updateServiceTestDataFromAPIcall(serviceSpec, serviceTest);
		serviceSpec = this.aServiceTestRepo.save(serviceSpec);

		return this.aServiceTestRepo.save(serviceSpec);
	}


	@Transactional
	private ServiceTest updateServiceTestDataFromAPIcall(ServiceTest serviceT,
			@Valid ServiceTestUpdate serviceUpd) {

		if (serviceUpd.getName() != null) {
			serviceT.setName(serviceUpd.getName());
		}

		if (serviceUpd.getDescription() != null) {
			serviceT.setDescription(serviceUpd.getDescription());

		}
		
		
		if (serviceUpd.getTestSpecification() != null ){
			serviceT.setTestSpecification( serviceUpd.getTestSpecification() );
		}


		serviceT.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));

	
		

		List<Characteristic> childCharacteristicsChanged = new ArrayList<>();
		if ( serviceUpd.getCharacteristic()!=null ) {
			for (Characteristic n : serviceUpd.getCharacteristic()) {
				
					if ( serviceT.getCharacteristicByName( n.getName() )!= null ) {
						
						Characteristic origChar = serviceT.getCharacteristicByName( n.getName() );
						if ( ( origChar !=null ) && ( origChar.getValue() !=null ) && ( origChar.getValue().getValue() !=null )) {
							if ( !origChar.getValue().getValue().equals(n.getValue().getValue()) ) {									
								if ( n.getName().contains("::") ) {
									childCharacteristicsChanged.add(n); //the characteristic needs later to be propagated to its children
									
								
								}
								
							}
						}
						
						serviceT.getCharacteristicByName( n.getName() ).setValue( 
								 new Any( n.getValue().getValue(), n.getValue().getAlias()  )
								 );
					} else {
						serviceT.addCharacteristicItem(n);
					}
				
			}						
		}

		/**
		 * Update RelatedParty list
		 */
		if (serviceUpd.getRelatedParty() != null) {
			// reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (RelatedParty rp : serviceUpd.getRelatedParty()) {

				boolean idexists = false;
				for (RelatedParty originalRP : serviceT.getRelatedParty()) {
					if (originalRP.getId().equals(rp.getId())) {
						idexists = true;
						idAddedUpdated.put(originalRP.getId(), true);
						break;
					}
				}
				if (!idexists) {
					serviceT.getRelatedParty().add(rp);
					idAddedUpdated.put(rp.getId(), true);
				}
			}
			List<RelatedParty> toRemove = new ArrayList<>();
			for (RelatedParty ss : serviceT.getRelatedParty()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (RelatedParty ar : toRemove) {
				serviceT.getRelatedParty().remove(ar);
			}
		}

	
		if (serviceUpd.getRelatedService()  != null) {
			serviceT.setRelatedService( (serviceUpd.getRelatedService() ) );
			
		}

		

		if (serviceUpd.getTestMeasure()  != null) {
			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (TestMeasure ar : serviceUpd.getTestMeasure()) {
				// find ServiceSpecRelationship by id and reload it here.
				// we need the ServiceSpecRelationship model from spec models
				boolean idexists = false;
				for (TestMeasure orinalAtt : serviceT.getTestMeasure()  ) {
					if (orinalAtt.getMetricName().equals(ar.getMetricName())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getMetricName(), true);
						break;
					}
				}

				if (!idexists) {
					serviceT.getTestMeasure().add(ar);
					idAddedUpdated.put(ar.getMetricName(), true);

				}
			}

			List<TestMeasure> toRemove = new ArrayList<>();
			for (TestMeasure ss : serviceT.getTestMeasure()) {
				if (idAddedUpdated.get(ss.getMetricName()) == null) {
					toRemove.add(ss);
				}
			}

			for (TestMeasure ar : toRemove) {
				serviceT.getTestMeasure().remove(ar);
			}

		}
		
		return serviceT;

	}
	
	
	/**
	 * update related service characteristics
	 * @param serviceT
	 */
	private void updateRelatedService(ServiceTest serviceT) {

		if (serviceT.getRelatedService()  != null) {
			
			@Valid
			ServiceUpdate servUpd = new ServiceUpdate();
			
			for (Characteristic c : serviceT.getCharacteristic()) {

				io.openslice.tmf.common.model.service.Characteristic newC = new io.openslice.tmf.common.model.service.Characteristic();
				newC.setName( c.getName());
				newC.setValue( new Any( c.getValue()) );				
				servUpd.addServiceCharacteristicItem( newC  );
			}			
			serviceRepoService.updateService( serviceT.getRelatedService().getId() , servUpd, true, null, null);
		}
		
	}

	public Void deleteByUuid(String id) {
		Optional<ServiceTest> optionalCat = this.aServiceTestRepo.findByUuid(id);
		ServiceTest s = optionalCat.get();
		if (s == null) {
			return null;
		}

		this.aServiceTestRepo.delete(s);
		return null;
	}

	public List<ServiceTest> findAll(String myfields, @Valid Map<String, String> allParams) {
		// this can be refactored properly in future (see for example implementation in ServiceSpecificationRepo)
		return findAll();
	}

	public List<ServiceTest> findAll() {
		return (List<ServiceTest>) this.aServiceTestRepo.findByOrderByName();
	}

	@Transactional
	public ServiceTest updateServiceTest(String id, @Valid ServiceTestUpdate serviceSpecification) {
		ServiceTest s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ServiceTest serviceSpec = s;
		serviceSpec = this.updateServiceTestDataFromAPIcall(serviceSpec, serviceSpecification);

		serviceSpec = this.aServiceTestRepo.save(serviceSpec);	
		
		updateRelatedService( serviceSpec );
		
		//serviceSpec = this.getServiceTestEager( serviceSpec.getId() );
		
		return serviceSpec;
	}

	

	public ServiceTest findByUuid(String id) {
		Optional<ServiceTest> optionalCat = this.aServiceTestRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}
	
	public String getServiceTestEagerAsString(String id) throws JsonProcessingException {
		ServiceTest s = this.getServiceTestEager(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5JakartaModule());
		String res = mapper.writeValueAsString(s);

		return res;
	}
	
	public ServiceTest getServiceTestEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ServiceTest s = null;
		try {
			s = (ServiceTest) session.get(ServiceTest.class, id);
			if (s == null) {
				return this.findByUuid(id);// last resort
			}

			Hibernate.initialize(s.getRelatedParty());

			Hibernate.initialize(s.getCharacteristic() );
			Hibernate.initialize(s.getTestSpecification() );
			Hibernate.initialize(s.getTestMeasure()  );
			
			for (Characteristic schar : s.getCharacteristic()) {
				Hibernate.initialize(schar.getCharacteristicRelationship()  );
				for (CharacteristicRelationship cr : schar.getCharacteristicRelationship() ) {
					Hibernate.initialize(cr  );					
				}

			}
			
			tx.commit();
		} finally {
			session.close();
		}
		
		return s;
	}
}
