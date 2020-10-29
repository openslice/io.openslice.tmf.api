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
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.pcm620.model.Category;
import io.openslice.tmf.pcm620.model.CategoryCreate;
import io.openslice.tmf.pcm620.model.CategoryUpdate;
import io.openslice.tmf.pcm620.reposervices.ProductCategoryRepoService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")

@Controller
@RequestMapping("/productCatalogManagement/v4/")
public class CategoryApiController implements CategoryApi {


	private static final Logger log = LoggerFactory.getLogger( CategoryApiController.class);

	@Autowired
	ProductCategoryRepoService categoryRepoService;
	
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

	@Override
	public ResponseEntity<Category> createCategory(@Valid CategoryCreate category) {
		try {

			Category c = categoryRepoService.addCategory( category );

			return new ResponseEntity<Category>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Void> deleteCategory(String id) {
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

	@Override
	public ResponseEntity<List<Category>> listCategory(@Valid String fields, @Valid Integer offset,
			@Valid Integer limit) {

		try {
			return new ResponseEntity<List<Category>>(categoryRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Category> patchCategory(String id, @Valid CategoryUpdate category) {
		Category c = categoryRepoService.updateCategory(id, category);

		return new ResponseEntity<Category>(c, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Category> retrieveCategory(String id, @Valid String fields) {
		try {

			return new ResponseEntity<Category>(categoryRepoService.findByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
