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

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

import io.openslice.model.PortalUser;
import io.openslice.model.UserRoleType;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:09:58.885+03:00")

@Controller
@RequestMapping("/serviceOrdering/v4/")
public class ServiceOrderApiController implements ServiceOrderApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceOrderApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;

	@Autowired
	ServiceOrderApiRouteBuilder serviceOrderApiRouteBuilder;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceOrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	
	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<ServiceOrder> createServiceOrder(
			Principal principal,			
			@ApiParam(value = "The ServiceOrder to be created", required = true) @Valid @RequestBody ServiceOrderCreate serviceOrder 
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

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<Void> deleteServiceOrder(
			Principal principal,			
			@ApiParam(value = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id) {
		
		
		try {
			return new ResponseEntity<Void>( serviceOrderRepoService.deleteByUuid(id), HttpStatus.OK);
		}catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<List<ServiceOrder>> listServiceOrder(
			Principal principal,			
			@ApiParam(value = "Comma-separated properties to be provided in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "Requested index for start of resources to be provided in response") @Valid @RequestParam(value = "offset", required = false) Integer offset,
			@ApiParam(value = "Requested number of resources to be provided in response") @Valid @RequestParam(value = "limit", required = false) Integer limit) {

		try {
//			Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//			SecurityContextHolder.setContext( (SecurityContext) attr );  
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			log.debug("principal=  " + principal.toString());
						
			log.debug("principal ROLE_ADMIN =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ));
			log.debug("principal ROLE_NFV_DEVELOPER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_NFV_DEVELOPER.getValue() ) ));
			log.debug("principal ROLE_EXPERIMENTER =  " + authentication.getAuthorities().contains( new SimpleGrantedAuthority(  UserRoleType.ROLE_EXPERIMENTER.getValue() ) ));
			
			if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {

				return new ResponseEntity<List<ServiceOrder>>(serviceOrderRepoService.findAll(null, new HashMap<>()), HttpStatus.OK);				
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

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<ServiceOrder> patchServiceOrder(
			Principal principal,			
			@ApiParam(value = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The ServiceOrder to be updated", required = true) @Valid @RequestBody ServiceOrderUpdate serviceOrder) {
		ServiceOrder c = serviceOrderRepoService.updateServiceOrder(id, serviceOrder);

		return new ResponseEntity<ServiceOrder>(c, HttpStatus.OK);
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<ServiceOrder> retrieveServiceOrder(
			Principal principal,			
			@ApiParam(value = "Identifier of the ServiceOrder", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Comma-separated properties to provide in response") @Valid @RequestParam(value = "fields", required = false) String fields) {

		try {

			return new ResponseEntity<ServiceOrder>( serviceOrderRepoService.findByUuid( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ServiceOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
