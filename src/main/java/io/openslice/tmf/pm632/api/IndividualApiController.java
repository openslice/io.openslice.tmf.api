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

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.Individual;
import io.openslice.tmf.pm632.model.IndividualCreate;
import io.openslice.tmf.pm632.model.IndividualUpdate;
import io.openslice.tmf.pm632.model.MediumCharacteristic;
import io.openslice.tmf.pm632.reposervices.IndividualRepoService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:38:47.101+03:00")

@Controller
@RequestMapping("/party/v4/")
public class IndividualApiController implements IndividualApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IndividualApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

	@Autowired
	IndividualRepoService individualRepoService;


	@Secured({ "ROLE_ADMIN" })
	public ResponseEntity<List<Individual>> listIndividual(@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
	
		
		

		try {



				return new ResponseEntity<List<Individual>>(individualRepoService.findAll(), HttpStatus.OK);				
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Individual>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	

	@Secured({ "ROLE_USER" })
	  public ResponseEntity<Individual> retrieveIndividual(
				Principal principal,			
				@ApiParam(value = "Identifier of the Individual",required=true) @PathVariable("id") String id,
				@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {


		
			try {

				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				
				if ( id.equals( "myuser" ) ) {
					
					log.debug("principal=  " + principal.toString());
					
					Individual ind = individualRepoService.findByUsername(  principal.getName() );
					
					
					if ( ind != null ) {
						return new ResponseEntity< Individual >( ind , HttpStatus.OK);		
					} else 
					{
						@Valid
						IndividualCreate individualnew  = new IndividualCreate();
						individualnew.setPreferredGivenName(  principal.getName() );
						if ( principal instanceof KeycloakAuthenticationToken) {
							KeycloakAuthenticationToken pr = ( KeycloakAuthenticationToken ) principal;
							
							
							KeycloakPrincipal lp = (KeycloakPrincipal) pr.getPrincipal();
							
							individualnew.setPreferredGivenName(  lp.getKeycloakSecurityContext().getToken().getPreferredUsername() );
							
							individualnew.setFamilyName( lp.getKeycloakSecurityContext().getToken().getGivenName() );
							individualnew.setGivenName( lp.getKeycloakSecurityContext().getToken().getName()  );
							ContactMedium contactMediumItem = new ContactMedium();
							contactMediumItem.setPreferred(true);
							contactMediumItem.setMediumType("main");
							MediumCharacteristic mc = new MediumCharacteristic();
							mc.setEmailAddress( lp.getKeycloakSecurityContext().getToken().getEmail() );							
							contactMediumItem.setCharacteristic(mc );
							individualnew.addContactMediumItem(contactMediumItem );
							
						}
						return new ResponseEntity< Individual > ( individualRepoService.addIndividual(individualnew)   , HttpStatus.OK);
					}
									
					
					
				} else if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {

					return new ResponseEntity< Individual >(individualRepoService.findById(id) , HttpStatus.OK);				
				}else {
					return new ResponseEntity< Individual >(HttpStatus.FORBIDDEN );
				}
				

			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity< Individual >(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
    

	@Secured({ "ROLE_ADMIN" })
	public ResponseEntity<Individual> createIndividual(
			@ApiParam(value = "The Individual to be created", required = true) @Valid @RequestBody IndividualCreate individual) {

		try {
			Individual c = individualRepoService.addIndividual(individual);

			return new ResponseEntity<Individual>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<Individual> patchIndividual(@ApiParam(value = "Identifier of the Individual",required=true) @PathVariable("id") String id,@ApiParam(value = "The Individual to be updated" ,required=true )  @Valid @RequestBody IndividualUpdate individual) {

		try {
			Individual c = individualRepoService.updateIndividual(id, individual);

			return new ResponseEntity<Individual>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	public ResponseEntity<Void> deleteIndividual(@ApiParam(value = "Identifier of the Individual",required=true) @PathVariable("id") String id) {
		try {

			return new ResponseEntity<Void>( individualRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
