package io.openslice.tmf.stm653.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.stm653.model.Characteristic;
import io.openslice.tmf.stm653.model.ServiceTest;
import io.openslice.tmf.stm653.model.ServiceTestCreate;
import io.openslice.tmf.stm653.model.ServiceTestUpdate;
import io.openslice.tmf.stm653.model.TestMeasure;
import io.openslice.tmf.stm653.repo.ServiceTestRepository;

public class ServiceTestRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceTestRepoService.class.getName());


	@Autowired
	ServiceTestRepository aServiceTestRepo;

	private SessionFactory sessionFactory;
	
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

	
	private ServiceTest updateServiceTestDataFromAPIcall(ServiceTest serviceSpec,
			@Valid ServiceTestUpdate serviceSpecUpd) {

		if (serviceSpecUpd.getName() != null) {
			serviceSpec.setName(serviceSpecUpd.getName());
		}

		if (serviceSpecUpd.getDescription() != null) {
			serviceSpec.setDescription(serviceSpecUpd.getDescription());

		}
		
		
		if (serviceSpecUpd.getTestSpecification() != null ){
			serviceSpec.setTestSpecification( serviceSpecUpd.getTestSpecification() );
		}


		serviceSpec.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));

	

		/**
		 * Update ServiceSpecCharacteristic list We need to compare by name, since IDs
		 * will not exist
		 */
		if (serviceSpecUpd.getCharacteristic() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (Characteristic charUpd : serviceSpecUpd.getCharacteristic()) {

				boolean nameExists = false;
				for (Characteristic originalSpecChar : serviceSpec.getCharacteristic()) {
					if (originalSpecChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put(originalSpecChar.getName(), true);
						originalSpecChar.updateWith(charUpd);
						break;
					}
				}

				if (!nameExists) {
					serviceSpec.getCharacteristic().add(new Characteristic(charUpd));
					idAddedUpdated.put(charUpd.getName(), true);
				}

			}

			List<Characteristic> toRemove = new ArrayList<>();
			for (Characteristic ss : serviceSpec.getCharacteristic()) {
				if (idAddedUpdated.get(ss.getName()) == null) {
					toRemove.add(ss);
				}
			}

			for (Characteristic serviceSpecCharacteristic : toRemove) {
				serviceSpec.getCharacteristic().remove(serviceSpecCharacteristic);
			}

		}

		/**
		 * Update RelatedParty list
		 */
		if (serviceSpecUpd.getRelatedParty() != null) {
			// reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (RelatedParty rp : serviceSpecUpd.getRelatedParty()) {

				boolean idexists = false;
				for (RelatedParty originalRP : serviceSpec.getRelatedParty()) {
					if (originalRP.getId().equals(rp.getId())) {
						idexists = true;
						idAddedUpdated.put(originalRP.getId(), true);
						break;
					}
				}
				if (!idexists) {
					serviceSpec.getRelatedParty().add(rp);
					idAddedUpdated.put(rp.getId(), true);
				}
			}
			List<RelatedParty> toRemove = new ArrayList<>();
			for (RelatedParty ss : serviceSpec.getRelatedParty()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (RelatedParty ar : toRemove) {
				serviceSpec.getRelatedParty().remove(ar);
			}
		}

	

		

		if (serviceSpecUpd.getTestMeasure()  != null) {
			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (TestMeasure ar : serviceSpecUpd.getTestMeasure()) {
				// find ServiceSpecRelationship by id and reload it here.
				// we need the ServiceSpecRelationship model from spec models
				boolean idexists = false;
				for (TestMeasure orinalAtt : serviceSpec.getTestMeasure()  ) {
					if (orinalAtt.getMetricName().equals(ar.getMetricName())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getMetricName(), true);
						break;
					}
				}

				if (!idexists) {
					serviceSpec.getTestMeasure().add(ar);
					idAddedUpdated.put(ar.getMetricName(), true);

				}
			}

			List<TestMeasure> toRemove = new ArrayList<>();
			for (TestMeasure ss : serviceSpec.getTestMeasure()) {
				if (idAddedUpdated.get(ss.getMetricName()) == null) {
					toRemove.add(ss);
				}
			}

			for (TestMeasure ar : toRemove) {
				serviceSpec.getTestMeasure().remove(ar);
			}

		}
		
		

		return serviceSpec;

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

	private List<ServiceTest> findAll() {
		return (List<ServiceTest>) this.aServiceTestRepo.findByOrderByName();
	}

	public ServiceTest updateServiceTest(String id, @Valid ServiceTestUpdate serviceSpecification) {
		ServiceTest s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ServiceTest serviceSpec = s;
		serviceSpec = this.updateServiceTestDataFromAPIcall(serviceSpec, serviceSpecification);

		serviceSpec = this.aServiceTestRepo.save(serviceSpec);	

		
		return this.aServiceTestRepo.save(serviceSpec);
	}

	public ServiceTest findByUuid(String id) {
		Optional<ServiceTest> optionalCat = this.aServiceTestRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}
}
