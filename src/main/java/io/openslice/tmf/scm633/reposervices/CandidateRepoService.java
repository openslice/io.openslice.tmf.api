package io.openslice.tmf.scm633.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.scm633.model.ServiceCandidate;
import io.openslice.tmf.scm633.model.ServiceCandidateCreate;
import io.openslice.tmf.scm633.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.repo.CandidateRepository;

@Service
public class CandidateRepoService {


	@Autowired
	CandidateRepository candidateRepo;	

	@Autowired
	CategoryRepoService categsRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepo;
	
	public ServiceCandidate addCatalog( ServiceCandidate c) {

		return this.candidateRepo.save( c );
	}

	public ServiceCandidate addServiceCandidate(@Valid ServiceCandidateCreate serviceCand) {	
		

		ServiceCandidate sc = new ServiceCandidate() ;
		if ( serviceCand.getServiceSpecification() != null) {
			Optional<ServiceCandidate> optsc = this.candidateRepo.findByServiceSpecUuid(serviceCand.getServiceSpecification().getId());
			if (optsc.isPresent() ) {
					sc = optsc.get();//add to an existing candidate
			}
		}
		
		sc = updateServiceCandidateDataFromAPI( sc, serviceCand);
		
		return this.candidateRepo.save( sc );
	}

	public List<ServiceCandidate> findAll() {
		return (List<ServiceCandidate>) this.candidateRepo.findAll();
	}

	public ServiceCandidate findById(String id) {
		Optional<ServiceCandidate> optionalCat = this.candidateRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceCandidate> optionalCat = this.candidateRepo.findByUuid( id );
		this.candidateRepo.delete( optionalCat.get());
		return null;
		
	}

	public ServiceCandidate updateCandidate(String id, @Valid ServiceCandidateUpdate serviceCandidate) {
		Optional<ServiceCandidate> scopt = this.candidateRepo.findByUuid(id);
		if ( scopt == null ) {
			return null;
		}
		ServiceCandidate sc = scopt.get();
		
		sc = updateServiceCandidateDataFromAPI( sc, serviceCandidate);
		
		return this.candidateRepo.save( sc );
	}
	
	
	public ServiceCandidate updateServiceCandidateDataFromAPI(ServiceCandidate sc, @Valid ServiceCandidateUpdate serviceCandidateUpd) {	

		ServiceSpecification specObj = this.specRepo.findByUuid( serviceCandidateUpd.getServiceSpecification().getId() );
		
		if ( specObj != null ) {
			sc.setName( specObj.getName() );
			sc.setDescription( specObj.getDescription() );
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( specObj.getLifecycleStatus() ) );
			sc.setVersion( specObj.getVersion() );
		} else {
			sc.setName( serviceCandidateUpd.getName() );
			sc.setDescription( serviceCandidateUpd.getDescription() );	
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
			sc.setVersion( serviceCandidateUpd.getVersion());
		}
		
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		if ( serviceCandidateUpd.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCandidateUpd.getLifecycleStatus() ) );
		}
		TimePeriod tp = new TimePeriod();

		if ( sc.getValidFor() != null ){
			tp.setStartDateTime( sc.getValidFor().getStartDateTime() );
			tp.setEndDateTime( sc.getValidFor().getEndDateTime() );
		}
		sc.setValidFor( tp );
		
		if ( specObj != null){
			sc.setServiceSpecificationObj( specObj );			
		}
		
		//save first to continue
		ServiceCandidate savedCand = this.candidateRepo.save( sc );
		
		for (ServiceCategoryRef sCategD : serviceCandidateUpd.getCategory()) {			
			ServiceCategory catObj = this.categsRepoService.findByIdEager(sCategD.getId());

			if ( catObj!=null){
				catObj.getServiceCandidateObj().add(savedCand); //add candidate ref to category
				catObj = this.categsRepoService.categsRepo.save(catObj); 
				
			}
		}
		
		
		return savedCand;
	}
	
	
}
