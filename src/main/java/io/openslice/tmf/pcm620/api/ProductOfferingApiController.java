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
package io.openslice.tmf.pcm620.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.pcm620.model.ProductOffering;
import io.openslice.tmf.pcm620.model.ProductOfferingCreate;
import io.openslice.tmf.pcm620.model.ProductOfferingUpdate;
import io.openslice.tmf.pcm620.reposervices.ProductOfferingRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Controller
@RequestMapping("/productCatalogManagement/v4/")
public class ProductOfferingApiController implements ProductOfferingApi {

    Logger log = LoggerFactory.getLogger(ProductOfferingApiController.class);
    

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	
	@Autowired
	ProductOfferingRepoService productOfferingRepoService;


	@Value("${spring.application.name}")
	private String compname;
	
	@org.springframework.beans.factory.annotation.Autowired
	public ProductOfferingApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<ProductOffering> createProductOffering(@Valid ProductOfferingCreate productOffering) {
		try {

			ProductOffering c = productOfferingRepoService.addProductOffering(productOffering);

			return new ResponseEntity<ProductOffering>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ProductOffering>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<Void> deleteProductOffering(String id) {
		try {

			return new ResponseEntity<Void>(productOfferingRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<ProductOffering>> listProductOffering(@Valid String fields, @Valid Integer offset,
			@Valid Integer limit,
			 @Valid Map<String, String> allParams) {
		try {
			if (allParams != null) {
				allParams.remove("fields");
				allParams.remove("offset");
				allParams.remove("limit");
			} else {
				allParams = new HashMap<>();
			}
			if ((fields == null) && (allParams.size() == 0)) {

				String myfields = "lastUpdate,lifecycleStatus";
				return new ResponseEntity<List<ProductOffering>>(						
						productOfferingRepoService.findAll( myfields, allParams), HttpStatus.OK);
//				return new ResponseEntity<List<ServiceSpecification>>(serviceSpecificationRepoService.findAll(),
//						HttpStatus.OK);
				
				
			} else {

				
				return new ResponseEntity<List<ProductOffering>>(
						productOfferingRepoService.findAll(fields, allParams), HttpStatus.OK);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ProductOffering>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public ResponseEntity<ProductOffering> patchProductOffering(String id,
			@Valid ProductOfferingUpdate productOffering) {
		ProductOffering c = productOfferingRepoService.updateProductOffering(id, productOffering);

		return new ResponseEntity<ProductOffering>(c, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProductOffering> retrieveProductOffering(String id, @Valid String fields) {
		try {

			Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

			if ( attr!=null) {
				SecurityContextHolder.setContext( (SecurityContext) attr );  
			}
			if ( SecurityContextHolder.getContext().getAuthentication() != null ) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				CentralLogger.log( CLevel.INFO, "User " + authentication.getName() + " retrieve spec id: "+ id , compname );
			} else {
				CentralLogger.log( CLevel.INFO, "Anonymous retrieve spec id: "+ id, compname );				
			}	
			
			return new ResponseEntity<ProductOffering>(productOfferingRepoService.findByUuid(id),
					HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ProductOffering>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    
}
