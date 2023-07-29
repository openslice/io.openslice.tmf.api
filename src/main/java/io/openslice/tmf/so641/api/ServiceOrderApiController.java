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
package io.openslice.tmf.so641.api;

import java.net.URI;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.openslice.model.UserRoleType;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Controller
@RequestMapping("/serviceOrdering/v4/")
public class ServiceOrderApiController implements ServiceOrderApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceOrderApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;



	@Value("${kroki.serverurl}")
	private String KROKI_SERVERURL = "";
	
	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;

	@Autowired
	ServiceOrderApiRouteBuilder serviceOrderApiRouteBuilder;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceOrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	
	@PreAuthorize("hasAnyAuthority('USER')" )
	@Override
	public ResponseEntity<ServiceOrder> createServiceOrder(
			Principal principal,			
			@Parameter(description = "The ServiceOrder to be created", required = true) @Valid @RequestBody ServiceOrderCreate serviceOrder 
			) {

		try {
			//Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			//SecurityContextHolder.setContext( (SecurityContext) attr );  
			
			
				log.info("authentication=  " + principal.toString());
				String extInfo = null;
				try {
					

					if ( principal instanceof KeycloakAuthenticationToken) {

						KeycloakAuthenticationToken pr = ( KeycloakAuthenticationToken ) principal;
						
						KeycloakPrincipal lp = (KeycloakPrincipal) pr.getPrincipal();
						extInfo = lp.getKeycloakSecurityContext().getToken().getEmail();	
						log.info("extInfo=  " + extInfo);	

						serviceOrder.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
								principal.getName(), 
								//user.getId()+"", 
								principal.getName(), 
								UserPartRoleType.REQUESTER,
								extInfo,
								serviceOrder.getRelatedParty()));
					} 
					else if ( principal instanceof UsernamePasswordAuthenticationToken ) {
						serviceOrder.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
								principal.getName(), 
								//user.getId()+"", 
								principal.getName(), 
								UserPartRoleType.REQUESTER,
								extInfo,
								serviceOrder.getRelatedParty()));
					}
				
					
				}finally {
					
				}
				

				
				
				
				
				ServiceOrder c = serviceOrderRepoService.addServiceOrder(serviceOrder);

				return new ResponseEntity<ServiceOrder>(c, HttpStatus.OK);				
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasAnyAuthority('USER')" )
	@Override
	public ResponseEntity<Void> deleteServiceOrder(
			Principal principal,			
			@Parameter(description = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id) {
		
		
		try {
			return new ResponseEntity<Void>( serviceOrderRepoService.deleteByUuid(id), HttpStatus.OK);
		}catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PreAuthorize("hasAnyAuthority('USER')" )
	@Override
	public ResponseEntity<List<ServiceOrder>> listServiceOrder(
			Principal principal,			
			@Parameter(description = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@Parameter(description = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Parameter(description = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit,
    		@Parameter(description = "Requested starttime for start of resources to be provided in response") @Valid @RequestParam(value = "starttime", required = false) Date starttime,
    		@Parameter(description = "Requested endtime for start of resources to be provided in response") @Valid @RequestParam(value = "endtime", required = false) Date endtime  ) {

		
		try {
//			Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//			SecurityContextHolder.setContext( (SecurityContext) attr );  
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			log.debug("principal=  " + principal.toString());
						
			log.debug("principal ROLE_ADMIN =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ));
			log.debug("principal ROLE_NFV_DEVELOPER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_NFV_DEVELOPER.getValue() ) ));
			log.debug("principal ROLE_EXPERIMENTER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_EXPERIMENTER.getValue() ) ));
			
			if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {

				return new ResponseEntity<List<ServiceOrder>>(serviceOrderRepoService.findAll( fields, new HashMap<>(), starttime, endtime), HttpStatus.OK);				
			}else {
				return new ResponseEntity<List<ServiceOrder>>(serviceOrderRepoService.findAll(
						principal.getName(),
						UserPartRoleType.REQUESTER), HttpStatus.OK);				
			}
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<ServiceOrder>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PreAuthorize("hasAnyAuthority('USER')" )
	@Override
	public ResponseEntity<ServiceOrder> patchServiceOrder(
			Principal principal,			
			@Parameter(description = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id,
			@Parameter(description = "The ServiceOrder to be updated", required = true) @Valid @RequestBody ServiceOrderUpdate serviceOrder) {
		ServiceOrder c = serviceOrderRepoService.updateServiceOrder(id, serviceOrder);

		return new ResponseEntity<ServiceOrder>(c, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('USER')" )
	@Override
	public ResponseEntity<ServiceOrder> retrieveServiceOrder(
			Principal principal,			
			@Parameter(description = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id,
			@Parameter(description = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {

		try {

			return new ResponseEntity<ServiceOrder>( serviceOrderRepoService.findByUuid( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Void> getImageServiceOrderItemRelationshipGraph(String id, String itemid) {
		String encodedDiagram = serviceOrderRepoService.getImageServiceOrderItemRelationshipGraph(id, itemid);
		
		//consider redirect to kroki..id
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.location(URI.create(KROKI_SERVERURL + "/blockdiag/svg/" + encodedDiagram))
				.build();
		//return null;
	}

	@Override
	public ResponseEntity<Void> getImageServiceOrderNotesGraph(String id) {
			String encodedDiagram = serviceOrderRepoService.getImageServiceOrderNotesGraph(id);
		
		//consider redirect to kroki..id
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.location(URI.create(KROKI_SERVERURL + "/actdiag/svg/" + encodedDiagram))
				.build();
	}
}
