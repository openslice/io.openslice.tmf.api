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
package io.openslice.tmf.pm632.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.model.UserRoleType;
import io.openslice.tmf.pm632.model.Organization;
import io.openslice.tmf.pm632.model.OrganizationCreate;
import io.openslice.tmf.pm632.model.OrganizationUpdate;
import io.openslice.tmf.pm632.reposervices.OrganizationRepoService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Controller
@RequestMapping("/party/v4/")
public class OrganizationApiController implements OrganizationApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    @Autowired
	OrganizationRepoService organizationRepoService;

	public ResponseEntity<List<Organization>> listOrganization(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
	
		
		

		try {
//			Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//			SecurityContextHolder.setContext( (SecurityContext) attr );  
//			
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//			log.info("authentication=  " + authentication.toString());
//						
//			log.info("principal ROLE_ADMIN =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ));
//			log.info("principal ROLE_NFV_DEVELOPER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_NFV_DEVELOPER.getValue() ) ));
//			log.info("principal ROLE_EXPERIMENTER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_EXPERIMENTER.getValue() ) ));
//			
//			if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {
//
//				return new ResponseEntity<List<Organization>>(organizationRepoService.findAll(), HttpStatus.OK);				
//			}else {
//				return new ResponseEntity<List<Organization>>(HttpStatus.FORBIDDEN );
//			}
			return new ResponseEntity<List<Organization>>(organizationRepoService.findAll(), HttpStatus.OK);		

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Organization>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	
	  public ResponseEntity<Organization> retrieveOrganization(@ApiParam(value = "Identifier of the Organization",required=true) @PathVariable("id") String id,@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {


			try {
//				Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//				SecurityContextHolder.setContext( (SecurityContext) attr );  
//				
//				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//				log.info("authentication=  " + authentication.toString());
//							
//				log.info("principal ROLE_ADMIN =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ));
//				log.info("principal ROLE_NFV_DEVELOPER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_NFV_DEVELOPER.getValue() ) ));
//				log.info("principal ROLE_EXPERIMENTER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_EXPERIMENTER.getValue() ) ));
//				
//				if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {
//
//					return new ResponseEntity< Organization >(organizationRepoService.findById(id) , HttpStatus.OK);				
//				}else {
//					return new ResponseEntity< Organization >(HttpStatus.FORBIDDEN );
//				}
//				

				return new ResponseEntity< Organization >(organizationRepoService.findById(id) , HttpStatus.OK);		

			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity< Organization >(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
    
	public ResponseEntity<Organization> createOrganization(
			@ApiParam(value = "The Organization to be created", required = true) @Valid @RequestBody OrganizationCreate organization) {

		try {
			Organization c = organizationRepoService.addOrganization(organization);

			return new ResponseEntity<Organization>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<Organization> patchOrganization(@ApiParam(value = "Identifier of the Organization",required=true) @PathVariable("id") String id,@ApiParam(value = "The Organization to be updated" ,required=true )  @Valid @RequestBody OrganizationUpdate organization) {

		try {
			Organization c = organizationRepoService.updateOrganization(id, organization);

			return new ResponseEntity<Organization>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	public ResponseEntity<Void> deleteOrganization(@ApiParam(value = "Identifier of the Organization",required=true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>( organizationRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
