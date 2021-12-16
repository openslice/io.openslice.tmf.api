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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCandidateUpdate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.repo.ResourceCandidateRepository;

@Service
public class ResourceCandidateRepoService {


	@Autowired
	ResourceCandidateRepository candidateRepo;	

	@Autowired
	ResourceCategoryRepoService categsRepoService;

	@Autowired
	ResourceSpecificationRepoService specRepo;
	
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

	public ResourceCandidate updateCandidate(String id, @Valid ResourceCandidateUpdate serviceCandidate) {
		Optional<ResourceCandidate> scopt = this.candidateRepo.findByUuid(id);
		if ( scopt == null ) {
			return null;
		}
		ResourceCandidate sc = scopt.get();
		
		sc = updateResourceCandidateDataFromAPI( sc, serviceCandidate);
		
		return this.candidateRepo.save( sc );
	}
	
	
	public ResourceCandidate updateResourceCandidateDataFromAPI(ResourceCandidate sc, @Valid ResourceCandidateUpdate serviceCandidateUpd) {	

		ResourceSpecification specObj = null;
		
		if ( serviceCandidateUpd.getResourceSpecification()!=null) {
			specObj = this.specRepo.findByUuid( serviceCandidateUpd.getResourceSpecification().getId() );			
		}
		
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
			sc.setResourceSpecificationObj( specObj );			
		}
		
		//save first to continue
		ResourceCandidate savedCand = this.candidateRepo.save( sc );
		

		if ( serviceCandidateUpd.getCategory() !=null ){
			for (ResourceCategoryRef sCategD : serviceCandidateUpd.getCategory()) {			
				ResourceCategory catObj = this.categsRepoService.findByIdEager(sCategD.getId());
	
				if ( catObj!=null){
					catObj.getResourceCandidateObj().add(savedCand); //add candidate ref to category
					catObj = this.categsRepoService.categsRepo.save(catObj); 
					
				}
			}
		}
		
		
		return savedCand;
	}
	
	
}
