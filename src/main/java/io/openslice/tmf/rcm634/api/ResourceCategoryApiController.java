package io.openslice.tmf.rcm634.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.reposervices.ResourceCategoryRepoService;
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
}
