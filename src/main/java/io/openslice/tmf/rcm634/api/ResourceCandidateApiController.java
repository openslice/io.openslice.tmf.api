/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.rcm634.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.rcm634.model.ResourceCandidate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCandidateUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceCandidateRepoService;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-29T22:34:44.143740800+03:00[Europe/Athens]")
@Controller
@RequestMapping("/resourceCatalogManagement/v4/")
public class ResourceCandidateApiController implements ResourceCandidateApi {


	@Autowired
	ResourceCandidateRepoService candidateRepoService;
	
	
	@Override
	public ResponseEntity<ResourceCandidate> createResourceCandidate(@Valid ResourceCandidateCreate body) {

		try {

			ResourceCandidate c = candidateRepoService.addResourceCandidate(body);

			return new ResponseEntity<ResourceCandidate>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<Void> deleteResourceCandidate(String id) {
		try {

			return new ResponseEntity<Void>( candidateRepoService.deleteById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<ResourceCandidate>> listResourceCandidate(@Valid String fields, @Valid Integer offset,
			@Valid Integer limit) {

          try {
  			return new ResponseEntity<List<ResourceCandidate>>( candidateRepoService.findAll() , HttpStatus.OK);
  			
  		} catch (Exception e) {
  			log.error("Couldn't serialize response for content type application/json", e);
  			return new ResponseEntity<List<ResourceCandidate>>(HttpStatus.INTERNAL_SERVER_ERROR);
  		}
	}
	
	
	@Override
	public ResponseEntity<ResourceCandidate> patchResourceCandidate(@Valid ResourceCandidateUpdate body, String id) {
		ResourceCandidate c = candidateRepoService.updateCandidate( id, body );

		return new ResponseEntity<ResourceCandidate>(c, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResourceCandidate> retrieveResourceCandidate(String id, @Valid String fields) {
		try {

			return new ResponseEntity<ResourceCandidate>( candidateRepoService.findById( id ), HttpStatus.OK);
		} catch ( Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceCandidate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
