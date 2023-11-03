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
package io.openslice.tmf.scm633.api;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller
@RequestMapping("/serviceCatalogManagement/v4/")
public class ServiceCategoryApiController implements ServiceCategoryApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceCategoryApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	CategoryRepoService categoryRepoService;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceCategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<ServiceCategory> createServiceCategory(
			@Parameter(description = "The ServiceCategory to be created", required = true) @Valid @RequestBody ServiceCategoryCreate serviceCategory) {

		try {

			ServiceCategory c = categoryRepoService.addCategory(serviceCategory);

			return new ResponseEntity<ServiceCategory>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<Void> deleteServiceCategory(
			@Parameter(description = "Identifier of the ServiceCategory", required = true) @PathVariable("id") String id) {

		try {
			if ( categoryRepoService.deleteById(id) ) {
				return new ResponseEntity<Void>(HttpStatus.OK);
				
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED );
			}
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<ServiceCategory>> listServiceCategory(
			@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		try {
			return new ResponseEntity<List<ServiceCategory>>(categoryRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceCategory>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
	public ResponseEntity<ServiceCategory> patchServiceCategory(
			@Parameter(description = "Identifier of the ServiceCategory", required = true) @PathVariable("id") String id,
			@Parameter(description = "The ServiceCategory to be updated", required = true) @Valid @RequestBody ServiceCategoryUpdate serviceCategory) {

		ServiceCategory c = categoryRepoService.updateCategory(id, serviceCategory);

		return new ResponseEntity<ServiceCategory>(c, HttpStatus.OK);
	}

	public ResponseEntity<ServiceCategory> retrieveServiceCategory(
			@Parameter(description = "Identifier of the ServiceCategory", required = true) @PathVariable("id") String id,
			@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {

		try {

			return new ResponseEntity<ServiceCategory>(categoryRepoService.findByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
