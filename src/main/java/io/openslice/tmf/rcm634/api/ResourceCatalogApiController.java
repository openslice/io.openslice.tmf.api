/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.rcm634.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalogUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceCatalogRepoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Controller
@RequestMapping("/resourceCatalogManagement/v4/")
public class ResourceCatalogApiController implements ResourceCatalogApi {


	@Autowired
	ResourceCatalogRepoService catalogRepoService ;
	


	@Override
	public ResponseEntity<ResourceCatalog> createResourceCatalog(
			@Parameter(description = "The Resource Catalog to be created" ,required=true )  @Valid @RequestBody ResourceCatalogCreate resourceCatalog) {
    	try {

    		ResourceCatalog c = catalogRepoService.addCatalog( resourceCatalog );

			return new ResponseEntity<ResourceCatalog>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	

	@Override
    public ResponseEntity<Void> deleteResourceCatalog(@Parameter(description = "Identifier of the ResourceCatalog",required=true) @PathVariable("id") String id) {
    	try {

			return new ResponseEntity<Void>( catalogRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@Override
    public ResponseEntity<List<ResourceCatalog>> listResourceCatalog(@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
       
        try {
			return new ResponseEntity<List<ResourceCatalog>>( catalogRepoService.findAll() , HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourceCatalog>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@Override
	public ResponseEntity<ResourceCatalog> patchResourceCatalog(@Valid ResourceCatalogUpdate body, String id) {
		ResourceCatalog c = catalogRepoService.updateCatalog( id, body );

		return new ResponseEntity<ResourceCatalog>(c, HttpStatus.OK);
	}
	
   

	@Override
    public ResponseEntity<ResourceCatalog> retrieveResourceCatalog(@Parameter(description = "Identifier of the ResourceCatalog",required=true) @PathVariable("id") String id,@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	try {

			return new ResponseEntity<ResourceCatalog>( catalogRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
