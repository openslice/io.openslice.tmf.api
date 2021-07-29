package io.openslice.tmf.lcm.reposervices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.lcm.model.LCMRuleSpecification;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationCreate;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationUpdate;
import io.openslice.tmf.lcm.repo.LCMRuleSpecificationRepository;



@Service(value = "lcmRuleSpecificationRepoService")
public class LCMRuleSpecificationRepoService {


	@Autowired
	LCMRuleSpecificationRepository lcmRuleSpecificationRepository;
	

	private SessionFactory sessionFactory;

	@Autowired
	public LCMRuleSpecificationRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	

	@Transactional
	public LCMRuleSpecification addLCMRuleSpecification(@Valid LCMRuleSpecificationCreate ruleSpecificationCreate) {
		
		LCMRuleSpecification as = new LCMRuleSpecification();
		as = updateLCMRuleSpecificationFromAPICall( as, ruleSpecificationCreate);
		as = this.lcmRuleSpecificationRepository.save(as);
		return as;
	}



	public List<LCMRuleSpecification> findAll() {
		return (List<LCMRuleSpecification>) this.lcmRuleSpecificationRepository.findAll();
	}


	public Void deleteById(String id) {
		Optional<LCMRuleSpecification> optionalCat = this.lcmRuleSpecificationRepository.findByUuid(id);
		this.lcmRuleSpecificationRepository.delete(optionalCat.get());
		return null;
	}


	@Transactional
	public LCMRuleSpecification updateLCMRuleSpecification(String id, @Valid LCMRuleSpecificationUpdate body) {

		LCMRuleSpecification s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		LCMRuleSpecification alm = s;
		alm = this.updateLCMRuleSpecificationFromAPICall(alm, body);

		alm = this.lcmRuleSpecificationRepository.save(alm);
		return alm;
	}


	@Transactional
	public LCMRuleSpecification findByUuid(String id) {
		Optional<LCMRuleSpecification> optionalCat = this.lcmRuleSpecificationRepository.findByUuid(id);
		return optionalCat.orElse(null);
	}
	
	public List<LCMRuleSpecification> findAll(String myfields, @Valid Map<String, String> allParams) {
		return findAll();
	}
	
	
	@Transactional 
	public LCMRuleSpecification findById(String id) {
		Optional<LCMRuleSpecification> optionalCat = this.lcmRuleSpecificationRepository.findByUuid(id);
		return optionalCat.orElse(null);
	}

	@Transactional
	public List<LCMRuleSpecification> findByServiceSpecificationRefId(String serviceSpecId) {
		return this.lcmRuleSpecificationRepository.findByServiceSpecificationRef( serviceSpecId );		
	}
	

	private LCMRuleSpecification updateLCMRuleSpecificationFromAPICall(LCMRuleSpecification as,
			@Valid LCMRuleSpecificationUpdate ruleSpecificationUpdate) {

		if ( ruleSpecificationUpdate.getName()  != null) {
			as.setName( ruleSpecificationUpdate.getName() );
		}
		
		if ( ruleSpecificationUpdate.getDescription() != null) {
			as.setDescription( ruleSpecificationUpdate.getDescription() );
		}

		if ( ruleSpecificationUpdate.getLcmrulephase()   != null) {
			as.setLcmrulephase( ruleSpecificationUpdate.getLcmrulephase()  );

		}
		
		if ( ruleSpecificationUpdate.getLifecycleStatus()   != null) {
			as.setLifecycleStatus( ruleSpecificationUpdate.getLifecycleStatus() );
		}		

		if ( ruleSpecificationUpdate.getContent()  != null) {
			as.setContent( ruleSpecificationUpdate.getContent() );
		}
		if ( ruleSpecificationUpdate.getCode()  != null) {
			as.setCode( ruleSpecificationUpdate.getCode() );
		}

		if ( ruleSpecificationUpdate.getServiceSpecs()  != null) {
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceSpecificationRef ar : ruleSpecificationUpdate.getServiceSpecs()) {
				// find by id and reload it here.

				boolean idexists = false;
				for (ServiceSpecificationRef orinalCom : as.getServiceSpecs()) {
					if (ar.getId()!=null && orinalCom.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalCom.getId(), true);
						break;
					}
				}

				if (!idexists) {
					as.getServiceSpecs().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<ServiceSpecificationRef> toRemove = new ArrayList<>();
			for (ServiceSpecificationRef ss : as.getServiceSpecs()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceSpecificationRef ar : toRemove) {
				as.getServiceSpecs().remove(ar);
			}

		}

		return as;
	}




}
