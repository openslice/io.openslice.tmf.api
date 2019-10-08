package io.openslice.tmf.scm.sc.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.scm.model.ELifecycle;
import io.openslice.tmf.scm.model.ServiceCandidate;
import io.openslice.tmf.scm.model.ServiceCandidateCreate;
import io.openslice.tmf.scm.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceCatalogCreate;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CandidateRepository;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;

@Service
public class CandidateRepoService {


	@Autowired
	CandidateRepository candidateRepo;	

	@Autowired
	CategoriesRepository categsRepo;

	@Autowired
	ServiceSpecificationRepoService specRepo;
	
	public ServiceCandidate addCatalog( ServiceCandidate c) {

		return this.candidateRepo.save( c );
	}

	public ServiceCandidate addServiceCandidate(@Valid ServiceCandidateCreate serviceCand) {	
		
		ServiceCandidate sc = new ServiceCandidate() ;
		sc = updateServiceCandidateDataFromAPI( sc, serviceCand);
		
		return this.candidateRepo.save( sc );
	}

	public List<ServiceCandidate> findAll() {
		return (List<ServiceCandidate>) this.candidateRepo.findAll();
	}

	public ServiceCandidate findById(String id) {
		Optional<ServiceCandidate> optionalCat = this.candidateRepo.findById( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceCandidate> optionalCat = this.candidateRepo.findById( id );
		this.candidateRepo.delete( optionalCat.get());
		return null;
		
	}

	public ServiceCandidate updateCandidate(String id, @Valid ServiceCandidateUpdate serviceCandidate) {
		Optional<ServiceCandidate> scopt = this.candidateRepo.findById(id);
		if ( scopt == null ) {
			return null;
		}
		ServiceCandidate sc = scopt.get();
		
		sc = updateServiceCandidateDataFromAPI( sc, serviceCandidate);
		
		return this.candidateRepo.save( sc );
	}
	
	
	public ServiceCandidate updateServiceCandidateDataFromAPI(ServiceCandidate sc, @Valid ServiceCandidateUpdate serviceCand) {	
		
		sc.setName( serviceCand.getName() );
		sc.setDescription( serviceCand.getDescription() );
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		if ( serviceCand.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCand.getLifecycleStatus() ) );
		}
		sc.setVersion( serviceCand.getVersion());
		TimePeriod tp = new TimePeriod();
		tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
		tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );
		sc.setValidFor( tp );
		
		ServiceSpecification specObj = this.specRepo.findById( serviceCand.getServiceSpecification().getId() );
		if ( specObj != null){
			sc.setServiceSpecificationObj( specObj );			
		}
		
		for (ServiceCategoryRef scd : serviceCand.getCategory()) {
			
			Optional<ServiceCategory> catObj = this.categsRepo.findById(scd.getId());
			if ( catObj!=null){
				sc.getCategoryObj().add(catObj.get());				
			}
		}
		
		
		return sc;
	}
	
	
}
