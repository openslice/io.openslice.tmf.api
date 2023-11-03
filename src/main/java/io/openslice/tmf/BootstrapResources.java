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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.domain.model.kubernetes.KubernetesCRDV1;
import io.openslice.domain.model.kubernetes.KubernetesCRV1;
import io.openslice.domain.model.kubernetes.KubernetesContextDefinition;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
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


	private static final String OSM_TENANT = "osm-tenant.openslice.io"; 
	
	private static final String VIM_ACCOUNT = "vim-account.openslice.io.json";
	
	private static final String GNB_TENANT = "gnodeb.openslice.io";
	
	
	private static final String INFRA_RESOURCES = "Infrastructure Resources";
	
	private static final String NETWORK_RESOURCES = "Network Resources";
	
	
	
	@PostConstruct
	@Transactional
	public void initRepo() {
		
		ResourceCatalog scatalog = this.resourceCatalogRepoService.findByName( "Catalog" );
		if ( scatalog == null) { 
			
			//Create a new ResourceCatalogCreate named Catalog 
			ResourceCatalogCreate sc = new ResourceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Resource Catalog");
			sc.setVersion("1.0");
			//Turns ResourceCatalogCreate to a ResourceCatalog with the same attributes set at the ResourceCatalogCreate
			scatalog = this.resourceCatalogRepoService.addCatalog(sc);				
			
			// Create a new ResourceCategoryCreate named Generic Resources 
			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Generic Resources");
			scatCreate.setDescription("Generic Resources of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);

			ResourceCategory scategory = this.resourceCategRepoService.addCategory(scatCreate);
			//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository
			//scatalog.getCategoryObj().add(scategory);
//			ResourceCategoryRef catref = new ResourceCategoryRef();
//			catref.setId( scategory.getId() );
//			catref.setName( scategory.getName());			
			scatalog.addCategory(scategory);			
		}
		
		ResourceCategory scategoryNetw = this.resourceCategRepoService.findByName(NETWORK_RESOURCES );
		if ( scategoryNetw == null ){
			ResourceCategoryCreate scategoryNetwCreate = new ResourceCategoryCreate();
			scategoryNetwCreate.setName(NETWORK_RESOURCES);
			scategoryNetwCreate.setDescription("Network Resources on this catalog");
			scategoryNetwCreate.setVersion("1.0");
			scategoryNetwCreate.setIsRoot(true);
			// Turns ResourceCategoryCreate to a ResourceCategory with the same attributes set at the ResourceCategoryCreate
			scategoryNetw = this.resourceCategRepoService.addCategory( scategoryNetwCreate );
			//Adds the ResourceCategory to the Primary Resource Catalog and then saves it to the resourceCatalogRepository			
//			ResourceCategoryRef catref = new ResourceCategoryRef();
//			catref.setId( scategoryNetw.getId() );
//			catref.setName( scategoryNetw.getName());
			scatalog.addCategory( scategoryNetw );
		}		

		ResourceCategory scategoryInfra = this.resourceCategRepoService.findByName(INFRA_RESOURCES );
		if ( scategoryInfra == null ){
			ResourceCategoryCreate scategoryInfraCreate = new ResourceCategoryCreate();
			scategoryInfraCreate.setName( INFRA_RESOURCES );
			scategoryInfraCreate.setDescription("Infrastructure Resources on this catalog");
			scategoryInfraCreate.setVersion("1.0");
			scategoryInfraCreate.setIsRoot(true);
			scategoryInfra = this.resourceCategRepoService.addCategory( scategoryInfraCreate );
//			ResourceCategoryRef catref = new ResourceCategoryRef();
//			catref.setId( scategoryInfra.getId() );
//			catref.setName( scategoryInfra.getName());
			scatalog.addCategory( scategoryInfra );
		}
		
		scatalog = this.resourceCatalogRepoService.updateCatalog( scatalog );


		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( VIM_ACCOUNT , "0.2.0");
		if (  ( resourceSpecificationObj == null ))
		{
			this.createBootResourceSpec( scategoryNetw, VIM_ACCOUNT , "vim-account.openslice.io.json" );
		}
		
		resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( OSM_TENANT , "0.2.0");
		if (  ( resourceSpecificationObj == null ))
		{
			this.createBootResourceSpec( scategoryNetw, OSM_TENANT , "osm-tenant.openslice.io.json" );
		}
		resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( GNB_TENANT , "0.2.0");
		if (   ( resourceSpecificationObj == null ))
		{
			this.createBootPhysicalResourceSpec( scategoryNetw,GNB_TENANT,  "gnodeb.openslice.io.json");
		}

	
		
		
		resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( 
				KubernetesContextDefinition.OSL_KUBD_RSPEC_NAME , 
				KubernetesContextDefinition.OSL_KUBD_RSPEC_VERSION);
		
		if ( ( scategoryInfra != null ) &&  ( resourceSpecificationObj == null ))
		{
			ResourceSpecification resourceSpecificationKubernetes =
					this.resourceSpecRepoService.addResourceSpecification( KubernetesContextDefinition.builder().build().toRSpecCreate_InitRepo() );
			//KubernetesContextDefinition.builder().build().fromRSpec(resourceSpecificationKubernetes);//to update any details
			this.addToCategory( scategoryInfra, resourceSpecificationKubernetes );
		}
		
		resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( 
				KubernetesCRDV1.OSL_KUBCRD_RSPEC_NAME , 
				KubernetesCRDV1.OSL_KUBCRD_RSPEC_VERSION);
		
		if ( ( scategoryInfra != null ) &&  ( resourceSpecificationObj == null ))
		{
			ResourceSpecification resourceSpecificationKubernetesCRD =
					this.resourceSpecRepoService.addResourceSpecification( KubernetesCRDV1.builder().build().toRSpecCreate_InitRepo() );
			KubernetesCRDV1.builder().build().fromRSpec(resourceSpecificationKubernetesCRD);//to update any details
			this.addToCategory( scategoryInfra, resourceSpecificationKubernetesCRD );
		}

		
		resourceSpecificationObj = this.resourceSpecRepoService.findByNameAndVersion( 
				KubernetesCRV1.OSL_KUBCRV1_RSPEC_NAME , 
				KubernetesCRV1.OSL_KUBCRV1_RSPEC_VERSION);
		
		if ( ( scategoryInfra != null ) &&  ( resourceSpecificationObj == null ))
		{
			ResourceSpecification rspecKubCRV1 =
					this.resourceSpecRepoService.addResourceSpecification( KubernetesCRV1.builder().build().toRSpecCreate_InitRepo() );
			KubernetesCRV1.builder().build().fromRSpec(rspecKubCRV1);//to update any details
			this.addToCategory( scategoryInfra, rspecKubCRV1 );
		}

		
		
		
	}
	
	
	private void createBootResourceSpec( ResourceCategory scategory, String aname, String afile) {		 
		
		ResourceSpecificationCreate rsc = this.resourceSpecRepoService.readFromLocalLogicalResourceSpec( afile );
		rsc.setName( aname );
		ResourceSpecification resourceSpecificationObj = this.resourceSpecRepoService.addResourceSpecification( rsc );
		
		addToCategory(scategory, resourceSpecificationObj);
		
	}
	
	private void addToCategory(ResourceCategory scategory,  ResourceSpecification resourceSpecificationObj) {	
		
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
	

