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

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.pcm620.model.Catalog;
import io.openslice.tmf.pcm620.model.CatalogCreate;
import io.openslice.tmf.pcm620.model.CatalogUpdate;
import io.openslice.tmf.pcm620.reposervices.ProductCatalogRepoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Controller
@RequestMapping("/productCatalogManagement/v4/")
public class CatalogApiController implements CatalogApi {

	private static final Logger log = LoggerFactory.getLogger(CatalogApiController.class);

	@Autowired
	ProductCatalogRepoService catalogRepoService;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public CatalogApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<Catalog> createCatalog(@Valid CatalogCreate catalog) {
		try {

			Catalog c = catalogRepoService.addCatalog(catalog);

			return new ResponseEntity<Catalog>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Catalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Void> deleteCatalog(String id) {
		try {

			return new ResponseEntity<Void>( catalogRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<Catalog>> listCatalog(@Valid String fields, @Valid Integer offset,
			@Valid Integer limit) {
		try {
			return new ResponseEntity<List<Catalog>>( catalogRepoService.findAll() , HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Catalog>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Catalog> patchCatalog(String id, @Valid CatalogUpdate catalog) {
		Catalog c = catalogRepoService.updateCatalog( id, catalog );

		return new ResponseEntity< Catalog>(c, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Catalog> retrieveCatalog(String id, @Valid String fields) {
		try {

			return new ResponseEntity<Catalog>( catalogRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Catalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
