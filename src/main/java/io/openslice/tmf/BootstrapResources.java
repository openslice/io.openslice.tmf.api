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

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCandidateUpdate;
import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.repo.ResourceCatalogRepository;
import io.openslice.tmf.rcm634.reposervices.ResourceCandidateRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCatalogRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCategoryRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;

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
	ObjectMapper objectMapper;

	
	@PostConstruct
	public void initRepo() {
		if (this.resourceCatalogRepoService.findAll().size() == 0) {
			//Create a new ResourceCatalogCreate named Catalog 
			ResourceCatalogCreate sc = new ResourceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Resource Catalog");
			sc.setVersion("1.0");
			//Turns ResourceCatalogCreate to a ResourceCatalog with the same attributes set at the ResourceCatalogCreate
			ResourceCatalog scatalog = this.resourceCatalogRepoService.addCatalog(sc);
			// Create a new ResourceCategoryCreate named Generic Resources 
			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Generic Resources");
			scatCreate.setDescription("Generic Resources of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			// Turns ResourceCategoryCreate to a ResourceCategory with the same attributes set at the ResourceCategoryCreate
			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);
			//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository
			scatalog.getCategoryObj().add(scategory);
			this.resourceCatalogRepository.save(scatalog);
			

						//The bellow lines would add a Logical Resource only for demonstration purposes
/*---------------------------------------------------------------------------------------------------------------	
			
			ResourceSpecification resSpecificationObj = demoResourceSpecification();
			ResourceCandidateCreate scand = new ResourceCandidateCreate();
			scand.setName( resSpecificationObj.getName());
			ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
			resSpecificationRef.setId(resSpecificationObj.getId());
			resSpecificationRef.setName(resSpecificationObj.getName());
			scand.resourceSpecification(resSpecificationRef);

			ResourceCategoryRef categoryItem = new ResourceCategoryRef();
			categoryItem.setId(scategory.getId());
			scand.addCategoryItem(categoryItem);

			this.resourceCandidateRepoService.addResourceCandidate(scand);
---------------------------------------------------------------------------------------------------------------	*/
		}
		
		
/*---------------------------------------------------------------------------------------------------------------		
		List<ResourceSpecification> proExistingResSpecs = resourceSpecRepoService.findAll();
		
		
		boolean ADD_RESOURCE_SPEC = true;
		for(int i=0; i<proExistingResSpecs.size(); i++) {
			if(proExistingResSpecs.get(i).getName().equals("Test Resource Spec")) {
				ADD_RESOURCE_SPEC = false;
			}
		}
		if( ADD_RESOURCE_SPEC ) {
			this.addSpecFromJSON( "Test Resource Spec" , "testResourceSpec.json");
		}
		

		
		ADD_RESOURCE_SPEC = true;
		for(int i=0; i<proExistingResSpecs.size(); i++) {
			if(proExistingResSpecs.get(i).getName().equals("GNodeB Resource Specification")) {
				ADD_RESOURCE_SPEC = false;
			}
		}
		if( ADD_RESOURCE_SPEC ) {
			
			ResourceCatalog scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			
			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Radio Resources");
			scatCreate.setDescription("Radio Resources on this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);

		//	scatalog.getCategoryObj().add(scategory);
			
			ResourceSpecification resourceSpecificationObj = this.addSpecFromJSON( "GNodeB Resource Specification" , "gNodeBResourceSpec.json");
			

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
		
		ADD_RESOURCE_SPEC = true;
		for(int i=0; i<proExistingResSpecs.size(); i++) {
			if(proExistingResSpecs.get(i).getName().equals("MANO Provider Resource Specification")) {
				ADD_RESOURCE_SPEC = false;
			}
		}
		if( ADD_RESOURCE_SPEC ) {
			
			ResourceCatalog scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			
			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Network Resources");
			scatCreate.setDescription("Network Resources on this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);

		//	scatalog.getCategoryObj().add(scategory);
			
			ResourceSpecification resourceSpecificationObj = this.addSpecFromJSON( "MANO Provider Resource Specification" , "MANOProviderResourceSpecification.json");
			

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
---------------------------------------------------------------------------------------------------------------	*/
		
		List<ResourceSpecification> proexistingResSpecs = resourceSpecRepoService.findAll();
		
		boolean MANO_PROVIDER_EXISTS = false;
		boolean VIM_ACCOUNT_EXISTS = false;
		
		//Check if the resources we want to bootstrap already exist
		for(int i=0; i<proexistingResSpecs.size(); i++) {
			if(proexistingResSpecs.get(i).getName().equals("Open Source MANO Project's VIM account Resource Specification")) {
				VIM_ACCOUNT_EXISTS = true;
			}
			else if (proexistingResSpecs.get(i).getName().equals("MANO Provider Resource Specification")) {
				MANO_PROVIDER_EXISTS = true;
			}
		}
		
		if( !MANO_PROVIDER_EXISTS ) {
			//As it is the first resource spec we add we create a category to add it under
			ResourceCatalog scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Network Resources");
			scatCreate.setDescription("Network Resources on this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);
			//Reads a JSON and turns it to a ResourceSpecification					
			ResourceSpecification resourceSpecificationObj = this.addLogicalResourceSpecFromJSON( "MANO Provider Resource Specification" , "MANOProviderResourceSpecification.json");
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
			//As it is not the first resource spec we add, we already have a category to add it under
			ResourceCatalog scatalog = this.resourceCatalogRepoService.findByName("Catalog");
			ResourceCategory scategory = this.resourceCategRepoService.findByName("Network Resources");
			//Reads a JSON and turns it to a ResourceSpecification					
			ResourceSpecification resourceSpecificationObj = this.addLogicalResourceSpecFromJSON( "Open Source MANO Project's VIM account Resource Specification" , "vimAccount.json");
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
	
