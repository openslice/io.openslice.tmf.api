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

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceCategoryRepoService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Controller
@RequestMapping("/resourceCatalogManagement/v4/")
public class ResourceCategoryApiController implements ResourceCategoryApi {

	@Autowired
	ResourceCategoryRepoService categoryRepoService;

	@Override
	public ResponseEntity<ResourceCategory> createResourceCategory(
			@ApiParam(value = "The ServiceCategory to be created", required = true) @Valid @RequestBody ResourceCategoryCreate resCategory) {

		try {

			ResourceCategory c = categoryRepoService.addCategory(resCategory);

			return new ResponseEntity<ResourceCategory>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Void> deleteResourceCategory(
			@ApiParam(value = "Identifier of the Resource Category", required = true) @PathVariable("id") String id) {
		try {
			if (categoryRepoService.deleteById(id)) {
				return new ResponseEntity<Void>(HttpStatus.OK);

			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<ResourceCategory>> listResourceCategory(@Valid String fields, @Valid Integer offset,
			@Valid Integer limit) {
		try {
			return new ResponseEntity<List<ResourceCategory>>(categoryRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourceCategory>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	
	@Override
	public ResponseEntity<ResourceCategory> patchResourceCategory(@Valid ResourceCategoryUpdate resourceCategory, String id) {
		ResourceCategory c = categoryRepoService.updateCategory(id, resourceCategory);

		return new ResponseEntity<ResourceCategory>(c, HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<ResourceCategory> retrieveResourceCategory(String id, @Valid String fields) {
		try {

			return new ResponseEntity<ResourceCategory>( categoryRepoService.findByUuid(id) , HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
