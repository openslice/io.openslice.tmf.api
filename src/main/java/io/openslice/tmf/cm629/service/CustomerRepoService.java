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
package io.openslice.tmf.cm629.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.cm629.model.Customer;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.model.CustomerUpdate;
import io.openslice.tmf.cm629.repo.CustomerRepository;
import io.openslice.tmf.prm669.model.RelatedParty;


@Service
@Transactional
public class CustomerRepoService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return (List<Customer>) this.customerRepository.findByOrderByName();
	}

	public Customer addCustomer(@Valid CustomerCreate customer) {
		Customer c = new Customer();
		c = updateCustomerData(c, customer);
		return customerRepository.save(c);
	}

	private Customer updateCustomerData(Customer c, @Valid CustomerUpdate custUpd) {
		
		if ( custUpd.getName()!=null) {
			c.setName( custUpd.getName() );
		}
		
		if ( custUpd.getEngagedParty() !=null) {
			if ( ( c.getEngagedParty() ==null ) || ( c.getEngagedParty().getId() != custUpd.getEngagedParty().getId() ) ) {
				// TODO: we msut load here the proper organization
				c.setEngagedParty( new RelatedParty( custUpd.getEngagedParty() ) ); 				
			}
		}
		
		
		return c;
	}

}
