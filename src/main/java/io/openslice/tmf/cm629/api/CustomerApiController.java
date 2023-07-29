/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.cm629.api;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.model.UserRoleType;
import io.openslice.tmf.cm629.model.Customer;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.model.CustomerUpdate;
import io.openslice.tmf.cm629.service.CustomerRepoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

@Controller
@RequestMapping("/customerManagement/v4/")
public class CustomerApiController implements CustomerApi {



	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	

	@org.springframework.beans.factory.annotation.Autowired
	public CustomerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	
	@Autowired
	CustomerRepoService customerRepoService;

	@PreAuthorize("hasAnyAuthority('ADMIN')" )
	public ResponseEntity<List<Customer>> listCustomer(@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
	
		
		

		try {
			Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			SecurityContextHolder.setContext( (SecurityContext) attr );  
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			log.info("authentication=  " + authentication.toString());
						
			log.info("principal ADMIN =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ));
			log.info("principal NFV_DEVELOPER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_NFV_DEVELOPER.getValue() ) ));
			log.info("principal EXPERIMENTER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_EXPERIMENTER.getValue() ) ));
			
			if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {

				return new ResponseEntity<List<Customer>>(customerRepoService.findAll(), HttpStatus.OK);				
			}else {
				return new ResponseEntity<List<Customer>>(HttpStatus.FORBIDDEN );
			}
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	

	@PreAuthorize("hasAnyAuthority('ADMIN')" )
	  public ResponseEntity<Customer> retrieveCustomer(@Parameter(description = "Identifier of the Customer",required=true) @PathVariable("id") String id,@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {


			try {
				Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
				SecurityContextHolder.setContext( (SecurityContext) attr );  
				
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				log.info("authentication=  " + authentication.toString());
							
				log.info("principal ADMIN =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ));
				log.info("principal NFV_DEVELOPER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_NFV_DEVELOPER.getValue() ) ));
				log.info("principal EXPERIMENTER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_EXPERIMENTER.getValue() ) ));
				
				if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {

					return new ResponseEntity< Customer >(customerRepoService.findById(id) , HttpStatus.OK);				
				}else {
					return new ResponseEntity< Customer >(HttpStatus.FORBIDDEN );
				}
				

			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity< Customer >(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }

	@PreAuthorize("hasAnyAuthority('ADMIN')" )
	public ResponseEntity<Customer> createCustomer(
			@Parameter(description = "The Customer to be created", required = true) @Valid @RequestBody CustomerCreate customer) {

		try {
			Customer c = customerRepoService.addCustomer(customer);

			return new ResponseEntity<Customer>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PreAuthorize("hasAnyAuthority('ADMIN')" )
	public ResponseEntity<Customer> patchCustomer(@Parameter(description = "Identifier of the Customer",required=true) @PathVariable("id") String id,@Parameter(description = "The Customer to be updated" ,required=true )  @Valid @RequestBody CustomerUpdate customer) {

		try {
			Customer c = customerRepoService.updateCustomer(id, customer);

			return new ResponseEntity<Customer>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ADMIN')" )
	public ResponseEntity<Void> deleteCustomer(@Parameter(description = "Identifier of the Customer",required=true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>( customerRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
