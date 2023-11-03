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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.cm629.api.CustomerApiRouteBuilder;
import io.openslice.tmf.cm629.model.Customer;
import io.openslice.tmf.cm629.model.CustomerAttributeValueChangeEvent;
import io.openslice.tmf.cm629.model.CustomerAttributeValueChangeEventPayload;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.model.CustomerCreateEvent;
import io.openslice.tmf.cm629.model.CustomerCreateEventPayload;
import io.openslice.tmf.cm629.model.CustomerUpdate;
import io.openslice.tmf.cm629.repo.CustomerRepository;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.prm669.model.RelatedParty;
import jakarta.validation.Valid;


@Service
@Transactional
public class CustomerRepoService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerApiRouteBuilder customerApiRouteBuilder;
	
	public List<Customer> findAll() {
		return (List<Customer>) this.customerRepository.findByOrderByName();
	}

	public Customer addCustomer(@Valid CustomerCreate customer) {
		Customer c = new Customer();
		c = updateCustomerData(c, customer);
		c = customerRepository.save(c);
		raiseCustomerCreate( c );
		return c;
	}
	
	public Customer updateCustomer(String id, @Valid CustomerUpdate customer) {
		Customer c = this.findByUuid(id);
		if ( c == null) {
			return null;
		}
		c = this.updateCustomerData(c, customer);
		c = this.customerRepository.save(c);
		raiseCustomerChanged(c);
		return c;
	}

	private Customer findByUuid(String id) {
		Optional<Customer> optionalCat = this.customerRepository.findByUuid(id);
		return optionalCat.orElse(null);
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
		
		if ( custUpd.getContactMedium() !=null) {
			//reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();
			
			for (ContactMedium cmUpd : custUpd.getContactMedium()) {
				//find  by id and reload it here.
				boolean idexists = false;
				for (ContactMedium originalCm : c.getContactMedium()) {
					if ( ( originalCm.getUuid()!=null ) && originalCm.getUuid().equals(cmUpd.getUuid() ) ) {
						idexists = true;
						idAddedUpdated.put( originalCm.getUuid(), true);
						originalCm.updateWith( cmUpd );
						break;
					}
				}
				if (!idexists) {
					c.addContactMediumItem( cmUpd );
				}
				
			}
		}
		
		return c;
	}

	public Customer findById(String id) {
		Optional<Customer> c = this.customerRepository.findByUuid(id);
		return c.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<Customer> c = this.customerRepository.findByUuid(id);
		this.customerRepository.delete( c.get());
		return null;
	}

	
	private void raiseCustomerCreate(Customer c) {
		
		CustomerCreateEvent ce = new CustomerCreateEvent();
		CustomerCreateEventPayload event = new CustomerCreateEventPayload();
		event.setCustomer(c);
		ce.setEvent(event);
		customerApiRouteBuilder.publishEvent( ce, c.getId() );
		
	}
	
	
	private void raiseCustomerChanged(Customer c) {
		
		CustomerAttributeValueChangeEvent ce = new CustomerAttributeValueChangeEvent();
		CustomerAttributeValueChangeEventPayload event = new CustomerAttributeValueChangeEventPayload();
		event.setCustomer(c);
		ce.setEvent(event);
		customerApiRouteBuilder.publishEvent( ce, c.getId() );
		
	}

}
