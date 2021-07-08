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

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.scm633.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.reposervices.CandidateRepoService;
import io.openslice.tmf.scm633.reposervices.CatalogRepoService;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;

/**
 * @author ctranoris
 *
 */
@Service
public class BootstrapRepository {

	private static final transient Log logger = LogFactory.getLog(BootstrapRepository.class.getName());

	private static final boolean ADDGST = true;

	private static final boolean ADDVINNISBT = false;

	private static final String GST_EXAMPLE_NAME = "A GST(NEST) Service Example";

	private static final String VINNI_EXAMPLE_NAME = "A VINNI Service Example";

	@Autowired
	CatalogRepoService catalogRepoService;

	@Autowired
	CategoryRepoService categRepoService;
	
	@Autowired
	CandidateRepoService candidateRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepoService;

	@Autowired
	ResourceSpecificationRepoService resourceSpecRepoService;
	

	@Autowired
	ObjectMapper objectMapper;
	
	@PostConstruct
	public void initRepo() {
		if (this.catalogRepoService.findAll().size() == 0) {
			ServiceCatalogCreate sc = new ServiceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Catalog");
			sc.setVersion("1.0");
			ServiceCatalog scatalog = this.catalogRepoService.addCatalog(sc);

			ServiceCategoryCreate scatCreate = new ServiceCategoryCreate();
			scatCreate.setName("Generic Services");
			scatCreate.setDescription("Generic Services of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ServiceCategory scategory = this.categRepoService.addCategory(scatCreate);

			scatalog.getCategoryObj().add(scategory);
			scatalog = this.catalogRepoService.updateCatalog(scatalog);
			/**
			 * Add GST
			 */
			if (ADDGST) {
				this.createFirstTimeGSTRepo( scategory );				
			}
			/**
			 * Add VINNI-SB
			 */
			if (ADDVINNISBT) {
				this.createFirstTimeVINNISBTRepo( scategory );
			}
			
			
		} else { //check if we have the latest version of GST
			if (ADDGST) {
				ServiceCategory scategory = this.categRepoService.findByName("Generic Services");
				ServiceSpecification serviceSpecificationObj = this.specRepoService.findByNameAndVersion( GST_EXAMPLE_NAME , "5.0.0");
				
				if ( ( scategory != null ) &&  ( serviceSpecificationObj == null ))
				{
					this.createFirstTimeGSTRepo( scategory );
				}
			}
			if (ADDVINNISBT) {
				ServiceCategory scategory = this.categRepoService.findByName("Generic Services");
				ServiceSpecification serviceSpecificationObj = this.specRepoService.findByNameAndVersion(VINNI_EXAMPLE_NAME, "0.1.0");				
				if ( ( scategory != null ) &&  ( serviceSpecificationObj == null )  )
				{
					this.createFirstTimeVINNISBTRepo( scategory );
				}
			}
			
			
		}
	}


	@Transactional
	private void createFirstTimeGSTRepo(ServiceCategory scategory) {

		ServiceSpecification serviceSpecificationObj = this.specRepoService.cloneGSTServiceSpecification( GST_EXAMPLE_NAME);
		//serviceSpecificationObj = this.specRepoService.updateServiceSpecification( serviceSpecificationObj );
		serviceSpecificationObj = this.specRepoService.findByUuid( serviceSpecificationObj.getId() );
				
		ServiceCandidateUpdate scand = new ServiceCandidateUpdate();
		ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
		serviceSpecificationRef.setId(serviceSpecificationObj.getId());
		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId(scategory.getId());
		scand.addCategoryItem(categoryItem);
		scand.setServiceSpecification(serviceSpecificationRef);
		
		this.candidateRepoService.updateCandidate( 
				serviceSpecificationObj.getServiceCandidateObjId() ,
				scand);
		
	}
	

	@Transactional
	public void createFirstTimeVINNISBTRepo( ServiceCategory scategory ) {

		ServiceSpecification serviceSpecVinniSB = this.specRepoService.cloneVINNIServiceSpecification( VINNI_EXAMPLE_NAME, true, true, true, true, true, true, true, true, true, true);
		
		
		/**
		 * add VINNI-SB Service Spec to Catalog
		 */
	
		
		ServiceCandidateUpdate scand = new ServiceCandidateUpdate();
		ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
		serviceSpecificationRef.setId(serviceSpecVinniSB.getId());
		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId(scategory.getId());
		scand.addCategoryItem(categoryItem);
		scand.setServiceSpecification(serviceSpecificationRef);
		
		this.candidateRepoService.updateCandidate( 
				serviceSpecVinniSB.getServiceCandidateObjId(),
				scand);
	}

}
