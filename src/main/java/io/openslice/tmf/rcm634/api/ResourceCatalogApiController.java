package io.openslice.tmf.rcm634.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalogUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceCatalogRepoService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Controller
@RequestMapping("/resourceCatalogManagement/v2/")
public class ResourceCatalogApiController implements ResourceCatalogApi {


	@Autowired
	ResourceCatalogRepoService catalogRepoService ;
	


	public ResponseEntity<ResourceCatalog> createResourceCatalog(
			@ApiParam(value = "The Resource Catalog to be created" ,required=true )  @Valid @RequestBody ResourceCatalogCreate resourceCatalog) {
    	try {

    		ResourceCatalog c = catalogRepoService.addCatalog( resourceCatalog );

			return new ResponseEntity<ResourceCatalog>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	

    public ResponseEntity<Void> deleteResourceCatalog(@ApiParam(value = "Identifier of the ResourceCatalog",required=true) @PathVariable("id") String id) {
    	try {

			return new ResponseEntity<Void>( catalogRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<List<ResourceCatalog>> listResourceCatalog(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
       
        try {
			return new ResponseEntity<List<ResourceCatalog>>( catalogRepoService.findAll() , HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ResourceCatalog>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<ResourceCatalog> patchResourceCatalog(@ApiParam(value = "Identifier of the ResourceCatalog",required=true) @PathVariable("id") String id,@ApiParam(value = "The ResourceCatalog to be updated" ,required=true )  @Valid @RequestBody ResourceCatalogUpdate serviceCatalog) {

		ResourceCatalog c = catalogRepoService.updateCatalog( id, serviceCatalog );

		return new ResponseEntity<ResourceCatalog>(c, HttpStatus.OK);
    }

    public ResponseEntity<ResourceCatalog> retrieveResourceCatalog(@ApiParam(value = "Identifier of the ResourceCatalog",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	try {

			return new ResponseEntity<ResourceCatalog>( catalogRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
