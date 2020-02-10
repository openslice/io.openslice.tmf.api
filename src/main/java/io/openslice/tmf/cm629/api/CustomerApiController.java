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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.cm629.model.Customer;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.service.CustomerRepoService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-19T23:13:44.649+02:00")

@Controller
@RequestMapping("/customerManagement/v4/")
public class CustomerApiController implements CustomerApi {

	@Autowired
	CustomerRepoService customerRepoService;

	public ResponseEntity<Customer> createCustomer(
			@ApiParam(value = "The Customer to be created", required = true) @Valid @RequestBody CustomerCreate customer) {

		try {
			Customer c = customerRepoService.addCustomer(customer);

			return new ResponseEntity<Customer>(c, HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
