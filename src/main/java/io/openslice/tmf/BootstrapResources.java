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
			ResourceCatalogCreate sc = new ResourceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Resource Catalog");
			sc.setVersion("1.0");
			ResourceCatalog scatalog = this.resourceCatalogRepoService.addCatalog(sc);

			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Generic Resources");
			scatCreate.setDescription("Generic Resources of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);

			scatalog.getCategoryObj().add(scategory);
			this.resourceCatalogRepository.save(scatalog);

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
		}
		
		
			
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

	}
	
	
	public ResourceSpecification demoResourceSpecification() {
		
		ResourceSpecificationCreate spec = new ResourceSpecificationCreate();
		spec.setName("Example Logical Resource");
		spec.setVersion("1.0.0");		

		return this.resourceSpecRepoService.addLogicalResourceSpecification(spec);
	}
	
	public ResourceSpecification addSpecFromJSON(String resourceSpecName , String fileName) {
		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.cloneTestResourceSpec(resourceSpecName, fileName);
		return this.resourceSpecRepoService.addResourceSpec(resourceSpecificationObj);
	}
	
}
	

