package io.openslice.tmf.scm.sc.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceCatalogCreate;
import io.openslice.tmf.scm.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.sc.reposervices.CatalogRepoService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Controller
public class ServiceCatalogApiController implements ServiceCatalogApi {

    private static final Logger log = LoggerFactory.getLogger(ServiceCatalogApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    

	@Autowired
	CatalogRepoService catalogRepoService;

    @org.springframework.beans.factory.annotation.Autowired
    public ServiceCatalogApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ServiceCatalog> createServiceCatalog(
    		@ApiParam(value = "The ServiceCatalog to be created" ,required=true )  @Valid @RequestBody ServiceCatalogCreate serviceCatalog) {
    	try {

    		ServiceCatalog c = catalogRepoService.addCatalog( serviceCatalog );

			return new ResponseEntity<ServiceCatalog>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<Void> deleteServiceCatalog(@ApiParam(value = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id) {
    	try {

			return new ResponseEntity<Void>( catalogRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<List<ServiceCatalog>> listServiceCatalog(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        try {
			return new ResponseEntity<List<ServiceCatalog>>( catalogRepoService.findAll() , HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceCatalog>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    public ResponseEntity<ServiceCatalog> patchServiceCatalog(@ApiParam(value = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id,@ApiParam(value = "The ServiceCatalog to be updated" ,required=true )  @Valid @RequestBody ServiceCatalogUpdate serviceCatalog) {


        return new ResponseEntity<ServiceCatalog>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceCatalog> retrieveServiceCatalog(@ApiParam(value = "Identifier of the ServiceCatalog",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	try {

			return new ResponseEntity<ServiceCatalog>( catalogRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceCatalog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
