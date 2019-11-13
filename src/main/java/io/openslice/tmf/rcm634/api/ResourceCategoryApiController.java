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
package io.openslice.tmf.rcm634.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;
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
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Controller
@RequestMapping("/resourceCatalogManagement/v2/")
public class ResourceCategoryApiController implements ResourceCategoryApi {

	@Autowired
	ResourceCategoryRepoService categoryRepoService;

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

	public ResponseEntity<List<ResourceCategory>> listResourceCategory(
			@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "For filtering: Name of the category") @Valid @RequestParam(value = "name", required = false) String name,
			@ApiParam(value = "For filtering: The (class) type of this category") @Valid @RequestParam(value = "@type", required = false) String type,
			@ApiParam(value = "For filtering: This field provides a link to the schema describing this REST resource") @Valid @RequestParam(value = "@schemalLocation", required = false) String schemalLocation,
			@ApiParam(value = "For filtering: Immediate base class type of this category") @Valid @RequestParam(value = "@baseType", required = false) String baseType,
			@ApiParam(value = "For filtering: Category version") @Valid @RequestParam(value = "version", required = false) String version,
			@ApiParam(value = "For filtering: An instant of time, starting at the TimePeriod") @Valid @RequestParam(value = "validFor.startDateTime", required = false) OffsetDateTime validForStartDateTime,
			@ApiParam(value = "For filtering: An instant of time, ending at the TimePeriod.") @Valid @RequestParam(value = "validFor.endDateTime", required = false) OffsetDateTime validForEndDateTime,
			@ApiParam(value = "For filtering: Used to indicate the current lifecycle status") @Valid @RequestParam(value = "lifecycleStatus", required = false) String lifecycleStatus,
			@ApiParam(value = "For filtering: Date and time of the last update") @Valid @RequestParam(value = "lastUpdate", required = false) OffsetDateTime lastUpdate,
			@ApiParam(value = "For filtering: Unique identifier of the parent category") @Valid @RequestParam(value = "parentId", required = false) String parentId,
			@ApiParam(value = "For filtering: If true, this Boolean indicates that the category is a root of categories") @Valid @RequestParam(value = "isRoot", required = false) Boolean isRoot,
			@ApiParam(value = "For filtering: Category version") @Valid @RequestParam(value = "category.version", required = false) String categoryVersion,
			@ApiParam(value = "For filtering: Name of the category") @Valid @RequestParam(value = "category.name", required = false) String categoryName,
			@ApiParam(value = "For filtering: the class type of the category") @Valid @RequestParam(value = "category.@type", required = false) String categoryType,
			@ApiParam(value = "For filtering: ResourceCandidate version") @Valid @RequestParam(value = "resourceCandidate.version", required = false) String resourceCandidateVersion,
			@ApiParam(value = "For filtering: Name given to the ResourceCandidate") @Valid @RequestParam(value = "resourceCandidate.name", required = false) String resourceCandidateName,
			@ApiParam(value = "For filtering: The (class) type of the ResourceCandidate") @Valid @RequestParam(value = "resourceCandidate.@type", required = false) String resourceCandidateType,
			@ApiParam(value = "For filtering: Role of the related party.") @Valid @RequestParam(value = "relatedParty.role", required = false) String relatedPartyRole,
			@ApiParam(value = "For filtering: Name of the related party") @Valid @RequestParam(value = "relatedParty.name", required = false) String relatedPartyName) {
		try {
			return new ResponseEntity<List<ResourceCategory>>(categoryRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourceCategory>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<ResourceCategory> patchResourceCategory(
			@ApiParam(value = "Identifier of the Resource Category", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The Resource Category to be updated", required = true) @Valid @RequestBody ResourceCategoryUpdate resourceCategory) {
		ResourceCategory c = categoryRepoService.updateCategory(id, resourceCategory);

		return new ResponseEntity<ResourceCategory>(c, HttpStatus.OK);
	}

	public ResponseEntity< ResourceCategory> retrieveResourceCategory(
			@ApiParam(value = "Identifier of the Resource Category", required = true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<ResourceCategory>( categoryRepoService.findByUuid(id) , HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
