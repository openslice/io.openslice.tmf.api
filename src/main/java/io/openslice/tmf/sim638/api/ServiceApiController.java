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
package io.openslice.tmf.sim638.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.model.UserRoleType;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.sim638.model.Service;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:12:41.682+03:00")

@Controller("ServiceApiController638")
@RequestMapping("/serviceInventory/v4/")
public class ServiceApiController implements ServiceApi {

	private static final Logger log = LoggerFactory.getLogger(ServiceApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ServiceRepoService serviceRepoService;

	@org.springframework.beans.factory.annotation.Autowired
	public ServiceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<Service> createService(Principal principal, @Valid ServiceCreate service) {
		try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				service.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(principal.getName(), principal.getName(),
						UserPartRoleType.REQUESTER, "", service.getRelatedParty()));

				Service c = serviceRepoService.addService(service);

				return new ResponseEntity<Service>(c, HttpStatus.OK);
			} else {

				return new ResponseEntity<Service>(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Service>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<Void> deleteService(String id) {
		return ServiceApi.super.deleteService(id);
	}

	@Override
	@Secured({ "ROLE_USER" })
	public ResponseEntity<List<Service>> listService(Principal principal, @Valid String fields, @Valid Integer offset,
			@Valid Integer limit) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			

			if ( authentication.getAuthorities().contains( new SimpleGrantedAuthority( UserRoleType.ROLE_ADMIN.getValue()  ) ) ) {
				return new ResponseEntity<List<Service>>(serviceRepoService.findAll(null, new HashMap<>()), HttpStatus.OK);
				//return new ResponseEntity<List<ServiceOrder>>(serviceOrderRepoService.findAll(null, new HashMap<>()), HttpStatus.OK);				
			}else {
				return new ResponseEntity<List<Service>>(serviceRepoService.findAll( principal.getName(), UserPartRoleType.REQUESTER ), HttpStatus.OK);
				//return new ResponseEntity<List<ServiceOrder>>(serviceOrderRepoService.findAll( principal.getName(), UserPartRoleType.REQUESTER), HttpStatus.OK);				
			}
			
			
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Service>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<Service> patchService(Principal principal, String id, @Valid ServiceUpdate service) {
		Service c = serviceRepoService.updateService(id, service, true, null);

		return new ResponseEntity<Service>(c, HttpStatus.OK);
	}

	@Secured({ "ROLE_USER" })
	@Override
	public ResponseEntity<Service> retrieveService(Principal principal, String id, @Valid String fields) {
		try {

			return new ResponseEntity<Service>(serviceRepoService.findByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Service>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
