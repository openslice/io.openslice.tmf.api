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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCandidateUpdate;
import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalogUpdate;
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
import io.openslice.tmf.scm633.model.ServiceSpecification;

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


	private static final String OSM_TENANT = "osm-tenant.openslice.io"; 
	
	private static final String VIM_ACCOUNT = "vim-account.openslice.io.json";
	
	private static final String GNB_TENANT = "gnodeb.openslice.io";
	
	private static final String CIM_TENANT = "containerized-infrastructure.openslice.io";
	
	private static final String INFRA_RESOURCES = "Infrastructure Resources";
	
	private static final String NETWORK_RESOURCES = "Network Resources";
	
	
	
	@PostConstruct
	public void initRepo() {
		
		if (this.resourceCatalogRepoService.findAll().size() == 0) { //this is executed only during the first installation time
			
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

			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);
			//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository
			//scatalog.getCategoryObj().add(scategory);
			ResourceCategoryRef catref = new ResourceCategoryRef();
			catref.setId( scategory.getId() );
			catref.setName( scategory.getName());			
			scatalog.addCategory(scategory);			


			
			ResourceCategoryCreate scategoryInfraCreate = new ResourceCategoryCreate();
			scategoryInfraCreate.setName( INFRA_RESOURCES );
			scategoryInfraCreate.setDescription("Infrastructure Resources on this catalog");
			scategoryInfraCreate.setVersion("1.0");
			scategoryInfraCreate.setIsRoot(true);
			ResourceCategory scategoryinfra = this.resourceCategRepoService.addCategory( scategoryInfraCreate );
			catref = new ResourceCategoryRef();
			catref.setId( scategoryinfra.getId() );
			catref.setName( scategoryinfra.getName());
			scatalog.addCategory( scategoryinfra );

			this.createBootResourceSpec( scategoryinfra, CIM_TENANT, "containerized-infrastructure.openslice.io.json" );
			
			ResourceCategoryCreate scategoryNetwCreate = new ResourceCategoryCreate();
			scategoryNetwCreate.setName(NETWORK_RESOURCES);
			scategoryNetwCreate.setDescription("Network Resources on this catalog");
			scategoryNetwCreate.setVersion("1.0");
			scategoryNetwCreate.setIsRoot(true);
			// Turns ResourceCategoryCreate to a ResourceCategory with the same attributes set at the ResourceCategoryCreate
			ResourceCategory scategoryNetw = this.resourceCategRepoService.addCategory( scategoryNetwCreate );
			//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository			
			catref = new ResourceCategoryRef();
			catref.setId( scategoryNetw.getId() );
			catref.setName( scategoryNetw.getName());

			scatalog.addCategory( scategoryNetw );
			scatalog = this.resourceCatalogRepoService.updateCatalog( scatalog );

			this.createBootResourceSpec( scategoryNetw, OSM_TENANT , "osm-tenant.openslice.io.json" );
			this.createBootResourceSpec( scategoryNetw, VIM_ACCOUNT , "vim-account.openslice.io.json");
			this.createBootPhysicalResourceSpec( scategoryNetw,GNB_TENANT,  "gnodeb.openslice.io.json");
			
			
			
		} else { //check if we have the latest version of each resource spec template
			

			ResourceCategory scategory = this.resourceCategRepoService.findByName(NETWORK_RESOURCES);
			ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( VIM_ACCOUNT , "0.2.0");
			if ( ( scategory != null ) &&  ( resourceSpecificationObj == null ))
			{
				this.createBootResourceSpec( scategory, VIM_ACCOUNT , "vim-account.openslice.io.json" );
			}
			
			resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( OSM_TENANT , "0.2.0");
			if ( ( scategory != null ) &&  ( resourceSpecificationObj == null ))
			{
				this.createBootResourceSpec( scategory, OSM_TENANT , "osm-tenant.openslice.io.json" );
			}
			resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( GNB_TENANT , "0.2.0");
			if ( ( scategory != null ) &&  ( resourceSpecificationObj == null ))
			{
				this.createBootPhysicalResourceSpec( scategory,GNB_TENANT,  "gnodeb.openslice.io.json");
			}

			
			scategory = this.resourceCategRepoService.findByName(INFRA_RESOURCES );
			resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( CIM_TENANT , "0.0.0");
			if ( ( scategory != null ) &&  ( resourceSpecificationObj == null ))
			{
				this.createBootResourceSpec( scategory, CIM_TENANT, "containerized-infrastructure.openslice.io.json" );
			}
		}
		

		
		
	}
	
	
	private void createBootResourceSpec( ResourceCategory scategory, String aname, String afile) {
		//Find the MANO Provider Spec, get its href and use it to create a dependency with the VIM 

		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.cloneLogicalResourceSpec( aname , afile);
		resourceSpecificationObj = resourceSpecificationRepo.save(resourceSpecificationObj);
		
		//Turn the ResourceSpecification to a ResourceCanditate to save it to the ResourceCatalogRepo			
		ResourceCandidateUpdate scand = new ResourceCandidateUpdate();
		scand.setName( resourceSpecificationObj.getName());
		ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
		resSpecificationRef.setId(resourceSpecificationObj.getId());
		resSpecificationRef.setName(resourceSpecificationObj.getName());
		scand.resourceSpecification(resSpecificationRef);
		ResourceCategoryRef categoryItem = new ResourceCategoryRef();
		categoryItem.setId(scategory.getId());
		scand.addCategoryItem(categoryItem);
		
		this.resourceCandidateRepoService.updateCandidate(resourceSpecificationObj.getResourceCandidateObjId() , scand);
	}
	
	private void createBootPhysicalResourceSpec( ResourceCategory scategory, String aname, String afile) {
		//Find the MANO Provider Spec, get its href and use it to create a dependency with the VIM 

		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.clonePhysicalResourceSpec( aname , afile);
		resourceSpecificationObj = resourceSpecificationRepo.save(resourceSpecificationObj);
		
		//Turn the ResourceSpecification to a ResourceCanditate to save it to the ResourceCatalogRepo			
		ResourceCandidateUpdate scand = new ResourceCandidateUpdate();
		scand.setName( resourceSpecificationObj.getName());
		ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
		resSpecificationRef.setId(resourceSpecificationObj.getId());
		resSpecificationRef.setName(resourceSpecificationObj.getName());
		scand.resourceSpecification(resSpecificationRef);
		ResourceCategoryRef categoryItem = new ResourceCategoryRef();
		categoryItem.setId(scategory.getId());
		scand.addCategoryItem(categoryItem);
		
		this.resourceCandidateRepoService.updateCandidate(resourceSpecificationObj.getResourceCandidateObjId() , scand);
	}
	

	
	public ResourceSpecification demoResourceSpecification() {
		
		ResourceSpecificationCreate spec = new ResourceSpecificationCreate();
		spec.setName("Example Logical Resource");
		spec.setVersion("1.0.0");		

		return this.resourceSpecRepoService.addLogicalResourceSpecification(spec);
	}
	
	
	
}
	

