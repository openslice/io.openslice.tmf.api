package io.openslice.tmf.ri639.api;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.model.UserRoleType;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceUpdate;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Controller
@RequestMapping("/resourceInventoryManagement/v4/")
public class ResourceApiController implements ResourceApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


	@Autowired
	ResourceRepoService resourceRepoService;
	
    @org.springframework.beans.factory.annotation.Autowired
    public ResourceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

  

	@PreAuthorize("hasAnyAuthority('ROLE_USER')" )
    @Override
    public ResponseEntity<Resource> createResource(Principal principal, @Valid ResourceCreate resource) {
		try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				resource.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(principal.getName(), principal.getName(),
						UserPartRoleType.REQUESTER, "", resource.getRelatedParty()));

				Resource c = resourceRepoService.addResource(resource);

				return new ResponseEntity<Resource>(c, HttpStatus.OK);
			} else {

				return new ResponseEntity<Resource>(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_USER')" )
    @Override
    public ResponseEntity<Void> deleteResource(String id) {
		try {

			return new ResponseEntity<Void>( resourceRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_USER')" )
    @Override
    public ResponseEntity<List<Resource>> listResource(Principal principal, @Valid String fields, @Valid Integer offset,
    		@Valid Integer limit,
    		 Map<String, String> allParams) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			

			if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {
				return new ResponseEntity<List<Resource>>( resourceRepoService.findAll( fields, allParams), HttpStatus.OK);
	
			}else {
				return new ResponseEntity<List<Resource>>( resourceRepoService.findAll( principal.getName(), UserPartRoleType.REQUESTER ), HttpStatus.OK);
				
			}
			
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Resource>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_USER')" )
    @Override
    public ResponseEntity<Resource> patchResource(Principal principal, @Valid ResourceUpdate resource, String id) {
		Resource c = resourceRepoService.updateResource(id, resource, true);

		return new ResponseEntity< Resource >(c, HttpStatus.OK);
    }

	@PreAuthorize("hasAnyAuthority('ROLE_USER')" )
    @Override
    public ResponseEntity<Resource> retrieveResource(Principal principal, String id, @Valid String fields) {
		try {

			return new ResponseEntity<Resource>( resourceRepoService.findByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    
}
