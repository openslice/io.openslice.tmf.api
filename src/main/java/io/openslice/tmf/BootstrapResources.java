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
package io.openslice.tmf;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRelationship;
import io.openslice.tmf.rcm634.repo.ResourceCatalogRepository;
import io.openslice.tmf.rcm634.repo.ResourceSpecificationRepository;
import io.openslice.tmf.rcm634.reposervices.ResourceCandidateRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCatalogRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCategoryRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;
import jakarta.annotation.PostConstruct;

@Service
public class BootstrapResources {
		
	@Autowired
	ResourceCatalogRepoService resourceCatalogRepoService;
	
	@Autowired
	ResourceCategoryRepoService resourceCategRepoService;
	
	@Autowired
	ResourceCandidateRepoService resourceCandidateRepoService;

	@Autowired
	ResourceSpecificationRepoService resourceSpecRepoService;
	
	@Autowired
	ResourceRepoService resourceRepoService;
	
	@Autowired
	ResourceCatalogRepository resourceCatalogRepository;
	
	@Autowired
	ResourceSpecificationRepository resourceSpecificationRepo;
	
	@Autowired
	ObjectMapper objectMapper;

	
	@PostConstruct
	public void initRepo() {
		
		

		//ResourceCatalogUpdate catUpdate = new ResourceCatalogUpdate();

		ResourceCatalog scatalog = this.resourceCatalogRepoService.findByName("Catalog");
		if ( scatalog == null ){
			//Create a new ResourceCatalogCreate named Catalog 
			ResourceCatalogCreate sc = new ResourceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Resource Catalog");
			sc.setVersion("1.0");
			//Turns ResourceCatalogCreate to a ResourceCatalog with the same attributes set at the ResourceCatalogCreate
			scatalog = this.resourceCatalogRepoService.addCatalog(sc);			
		}
		

		ResourceCategory scategory = this.resourceCategRepoService.findByName("Generic Resources");
		if ( scategory == null ){
			// Create a new ResourceCategoryCreate named Generic Resources 
				ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
				scatCreate.setName("Generic Resources");
				scatCreate.setDescription("Generic Resources of this catalog");
				scatCreate.setVersion("1.0");
				scatCreate.setIsRoot(true);

				scategory = this.resourceCategRepoService.addCategory(scatCreate);
				//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository
				//scatalog.getCategoryObj().add(scategory);
				ResourceCategoryRef catref = new ResourceCategoryRef();
				catref.setId( scategory.getId() );
				catref.setName( scategory.getName());
				//catUpdate.addCategoryItem(catref);
				
				scatalog.addCategory(scategory);
				
		}
		
		ResourceCategory scategoryNetw = this.resourceCategRepoService.findByName("Network Resources");
		if ( scategoryNetw == null ){
			ResourceCategoryCreate scategoryNetwCreate = new ResourceCategoryCreate();
			scategoryNetwCreate.setName("Network Resources");
			scategoryNetwCreate.setDescription("Network Resources on this catalog");
			scategoryNetwCreate.setVersion("1.0");
			scategoryNetwCreate.setIsRoot(true);
			// Turns ResourceCategoryCreate to a ResourceCategory with the same attributes set at the ResourceCategoryCreate
			scategoryNetw = this.resourceCategRepoService.addCategory( scategoryNetwCreate );
			//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository
			
			ResourceCategoryRef catref = new ResourceCategoryRef();
			catref.setId( scategoryNetw.getId() );
			catref.setName( scategoryNetw.getName());
			//catUpdate.addCategoryItem(catref);

			scatalog.addCategory( scategoryNetw );
		}
		

		scatalog = this.resourceCatalogRepoService.updateCatalog( scatalog );
		
		//this.resourceCatalogRepoService.updateCatalog( scatalog.getId() , catUpdate );
		
		
		List<ResourceSpecification> proexistingResSpecs = resourceSpecRepoService.findAll();
		
		boolean MANO_PROVIDER_EXISTS = false;
		boolean VIM_ACCOUNT_EXISTS = false;
		boolean GNB_EXISTS = false;
		String OSM_TENANT = "OSM Tenant";
		String VIM_ACCOUNT = "OSM VIM";
		String GNB_TENANT = "gNodeB";
		
		//Check if the resources we want to bootstrap already exist
		for(int i=0; i<proexistingResSpecs.size(); i++) {
			if ( proexistingResSpecs.get(i).getName() != null ) {
				if(proexistingResSpecs.get(i).getName().equals( VIM_ACCOUNT )) {
					VIM_ACCOUNT_EXISTS = true;
				}
				else if (proexistingResSpecs.get(i).getName().equals( OSM_TENANT )) {
					MANO_PROVIDER_EXISTS = true;
				}
				else if (proexistingResSpecs.get(i).getName().equals( GNB_TENANT )) {
					GNB_EXISTS = true;
				}
				
			}
			
		}
		
		if( !MANO_PROVIDER_EXISTS ) {
			//We already have a category to add it under
			scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			scategory = this.resourceCategRepoService.findByName("Network Resources");

			//Reads a JSON and turns it to a ResourceSpecification					
			ResourceSpecification resourceSpecificationObj = this.addLogicalResourceSpecFromJSON( OSM_TENANT , "OSMTenantResourceSpecification.json");
			//Turn the ResourceSpecification to a ResourceCanditate to save it to the ResourceCatalogRepo			
			ResourceCandidateCreate scand = new ResourceCandidateCreate();
			scand.setName( resourceSpecificationObj.getName());
			ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
			resSpecificationRef.setId(resourceSpecificationObj.getId());
			resSpecificationRef.setName(resourceSpecificationObj.getName());
			scand.resourceSpecification(resSpecificationRef);
			ResourceCategoryRef categoryItem = new ResourceCategoryRef();
			categoryItem.setId(scategory.getId());
			scand.addCategoryItem(categoryItem);
			this.resourceCandidateRepoService.addResourceCandidate(scand);
			this.resourceCatalogRepository.save(scatalog);
		}
		if( !VIM_ACCOUNT_EXISTS ) {
			//Find the MANO Provider Spec, get its href and use it to create a dependency with the VIM 

			List<ResourceCandidate> proexistingResCandidates = resourceCandidateRepoService.findAll();
			ResourceCandidate MANOProvider = new ResourceCandidate();
			for(int i=0; i<proexistingResCandidates.size(); i++) {
				if(proexistingResCandidates.get(i).getName()!= null) {
					if(proexistingResCandidates.get(i).getName().equals( OSM_TENANT )) {
						MANOProvider = proexistingResCandidates.get(i);
					}
				}
			}
			String MANOProviderResourceCandidateId = MANOProvider.getId();
			ResourceSpecificationRelationship vimToManoRelationship= new ResourceSpecificationRelationship();
			vimToManoRelationship.setId(MANOProviderResourceCandidateId);
			vimToManoRelationship.setRelationshipType("dependency");
						
			Set<ResourceSpecificationRelationship> setOfVimToManoRelationships = new HashSet<ResourceSpecificationRelationship>();
			setOfVimToManoRelationships.add(vimToManoRelationship);
	
			//As it is not the first resource spec we add, we already have a category to add it under
			scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			scategory = this.resourceCategRepoService.findByName("Network Resources");
			//Reads a JSON and turns it to a ResourceSpecification					
			ResourceSpecification resourceSpecificationObj = this.addLogicalResourceSpecFromJSON( VIM_ACCOUNT , "vimAccount.json");
			
			
			//Add the relationship that was created above
	
			resourceSpecificationRepo.delete(resourceSpecificationObj);
			resourceSpecificationObj.setResourceSpecRelationship(setOfVimToManoRelationships);
			resourceSpecificationRepo.save(resourceSpecificationObj);

			
			//Turn the ResourceSpecification to a ResourceCanditate to save it to the ResourceCatalogRepo			
			ResourceCandidateCreate scand = new ResourceCandidateCreate();
			scand.setName( resourceSpecificationObj.getName());
			ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
			resSpecificationRef.setId(resourceSpecificationObj.getId());
			resSpecificationRef.setName(resourceSpecificationObj.getName());
			scand.resourceSpecification(resSpecificationRef);
			ResourceCategoryRef categoryItem = new ResourceCategoryRef();
			categoryItem.setId(scategory.getId());
			scand.addCategoryItem(categoryItem);
			this.resourceCandidateRepoService.addResourceCandidate(scand);
			this.resourceCatalogRepository.save(scatalog);
		}	
		if(!GNB_EXISTS) {
			//As it is not the first resource spec we add, we already have a category to add it under
			scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			scategory = this.resourceCategRepoService.findByName("Network Resources");
			//Reads a JSON and turns it to a ResourceSpecification					
			ResourceSpecification resourceSpecificationObj = this.addPhysicalResourceSpecFromJSON( GNB_TENANT , "gNodeBResourceSpec.json");
			//Turn the ResourceSpecification to a ResourceCanditate to save it to the ResourceCatalogRepo			
			ResourceCandidateCreate scand = new ResourceCandidateCreate();
			scand.setName( resourceSpecificationObj.getName());
			ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
			resSpecificationRef.setId(resourceSpecificationObj.getId());
			resSpecificationRef.setName(resourceSpecificationObj.getName());
			resSpecificationRef.setHref(null);
			scand.resourceSpecification(resSpecificationRef);
			ResourceCategoryRef categoryItem = new ResourceCategoryRef();
			categoryItem.setId(scategory.getId());
			scand.addCategoryItem(categoryItem);
			this.resourceCandidateRepoService.addResourceCandidate(scand);
			this.resourceCatalogRepository.save(scatalog);
		}
		
	}
	
	
	public ResourceSpecification demoResourceSpecification() {
		
		ResourceSpecificationCreate spec = new ResourceSpecificationCreate();
		spec.setName("Example Logical Resource");
		spec.setVersion("1.0.0");		

		return this.resourceSpecRepoService.addLogicalResourceSpecification(spec);
	}
	
	public ResourceSpecification addPhysicalResourceSpecFromJSON(String resourceSpecName , String fileName) {
		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.clonePhysicalResourceSpec(resourceSpecName, fileName);
		return this.resourceSpecRepoService.addResourceSpec(resourceSpecificationObj);
	}
	
	public ResourceSpecification addLogicalResourceSpecFromJSON(String resourceSpecName , String fileName) {
		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.cloneLogicalResourceSpec(resourceSpecName, fileName);
		return this.resourceSpecRepoService.addResourceSpec(resourceSpecificationObj);
	}
	
}
	

