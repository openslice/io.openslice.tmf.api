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
package io.openslice.tmf.rcm634.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCandidateUpdate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.repo.ResourceCandidateRepository;
import io.openslice.tmf.rcm634.repo.ResourceSpecificationRepository;
import io.openslice.tmf.scm633.model.ServiceCandidate;
import jakarta.validation.Valid;

@Service
public class ResourceCandidateRepoService {


	@Autowired
	ResourceCandidateRepository candidateRepo;	

	@Autowired
	ResourceCategoryRepoService categsRepoService;

	@Autowired
	ResourceSpecificationRepository resourceSpecificationRepo;
	
	public ResourceCandidate addCatalog( ResourceCandidate c) {

		return this.candidateRepo.save( c );
	}

	public ResourceCandidate addResourceCandidate(@Valid ResourceCandidateCreate resCand) {	
		

		ResourceCandidate sc = new ResourceCandidate() ;
//		if ( resCand.getResourceSpecification() != null) {
//			Optional<ResourceCandidate> optsc = this.candidateRepo.findByResourceSpecUuid(resCand.getResourceSpecification().getId());
//			if (optsc.isPresent() ) {
//					sc = optsc.get();//add to an existing candidate
//			}
//		}
		
		sc = updateResourceCandidateDataFromAPI( sc, resCand);
		
		return this.candidateRepo.save( sc );
	}

	public List<ResourceCandidate> findAll() {
		return (List<ResourceCandidate>) this.candidateRepo.findAll();
	}

	public ResourceCandidate findById(String id) {
		Optional<ResourceCandidate> optionalCat = this.candidateRepo.findByUuid( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ResourceCandidate> optionalCat = this.candidateRepo.findByUuid( id );
		if ( !optionalCat.isEmpty() ) {
			this.candidateRepo.delete( optionalCat.get());
			
		}
		return null;
		
	}

	@Transactional
	public ResourceCandidate updateCandidate(String id, @Valid ResourceCandidateUpdate serviceCandidate) {
		Optional<ResourceCandidate> scopt = this.candidateRepo.findByUuid(id);
		if ( scopt == null ) {
			return null;
		}
		ResourceCandidate sc = scopt.get();
		
		sc = updateResourceCandidateDataFromAPI( sc, serviceCandidate);
		
		return this.candidateRepo.save( sc );
	}
	

	@Transactional
	public ResourceCandidate updateResourceCandidateDataFromAPI(ResourceCandidate sc, @Valid ResourceCandidateUpdate resourceCandidateUpd) {	

		ResourceSpecification specObj = null;
		
		if ( resourceCandidateUpd.getResourceSpecification()!=null) {
			Optional<ResourceSpecification> optionalCat = this.resourceSpecificationRepo.findByUuid( resourceCandidateUpd.getResourceSpecification().getId() );
			specObj = optionalCat.orElse(null);
		}
		
		if ( specObj != null ) {
			sc.setName( specObj.getName() );
			sc.setDescription( specObj.getDescription() );
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( specObj.getLifecycleStatus() ) );
			sc.setVersion( specObj.getVersion() );
		} else {
			sc.setName( resourceCandidateUpd.getName() );
			sc.setDescription( resourceCandidateUpd.getDescription() );	
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
			sc.setVersion( resourceCandidateUpd.getVersion());
		}
		
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		if ( resourceCandidateUpd.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( resourceCandidateUpd.getLifecycleStatus() ) );
		}
		TimePeriod tp = new TimePeriod();

		if ( sc.getValidFor() != null ){
			tp.setStartDateTime( sc.getValidFor().getStartDateTime() );
			tp.setEndDateTime( sc.getValidFor().getEndDateTime() );
		}
		sc.setValidFor( tp );
		
		if ( specObj != null){
			sc.setResourceSpecificationObj( specObj );			
		}
		
		//save first to continue
		ResourceCandidate savedCand = this.candidateRepo.save( sc );
		

		if ( resourceCandidateUpd.getCategory() !=null ){
			for (ResourceCategoryRef sCategD : resourceCandidateUpd.getCategory()) {			
				ResourceCategory catObj = this.categsRepoService.findByIdEager(sCategD.getId());
	
				if ( catObj!=null){
					catObj.getResourceCandidateObj().add(savedCand); //add candidate ref to category
					catObj = this.categsRepoService.categsRepo.save(catObj); 
					
				}
			}
		}
		
		
		return savedCand;
	}

	public Optional<ServiceCandidate> findByUuid(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
