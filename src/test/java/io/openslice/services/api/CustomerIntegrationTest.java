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
package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.cm629.model.Customer;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.model.CustomerUpdate;
import io.openslice.tmf.cm629.service.CustomerRepoService;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.MediumCharacteristic;
import io.openslice.tmf.prm669.model.RelatedParty;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
public class CustomerIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( CustomerIntegrationTest.class.getName());
	

    @Autowired
    private MockMvc mvc;
    

	@Autowired
	CustomerRepoService customerRepoService;
	

//    @Autowired
//    private WebApplicationContext context;
//    
// 
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//          .webAppContextSetup(context).dispatchOptions(true)
//          .apply( SecurityMockMvcConfigurers.springSecurity())
//          .build();
//    }
    
    
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void addCustomer() throws Exception {
		
		CustomerCreate cc = new CustomerCreate();
		cc.setName("A Customer");
		RelatedParty engagedParty = new RelatedParty();
		engagedParty.name("An Organization");
		engagedParty.setUuid(UUID.randomUUID().toString());
		cc.setEngagedParty(engagedParty );
		
		List<ContactMedium> contactMediums = new ArrayList<>();
		ContactMedium cm = new ContactMedium();
		contactMediums.add(cm);
		cm.setMediumType("email");
		cm.setPreferred(true);
		MediumCharacteristic medChar = new MediumCharacteristic();
		medChar.setEmailAddress( "test@openslice.io" );
		cm.setCharacteristic(medChar);
		cc.setContactMedium(contactMediums );
		
		
				
		String response = mvc.perform(MockMvcRequestBuilders.post("/customerManagement/v4/customer")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( cc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("A Customer")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( customerRepoService.findAll().size() ).isEqualTo( 1 );
		
		Customer respc = toJsonObj( response, Customer.class);
		assertThat( respc.getContactMedium().stream().findFirst().get().getMediumType() ).isEqualTo("email");
		assertThat( respc.getContactMedium().stream().findFirst().get().getCharacteristic().getEmailAddress()  ).isEqualTo("test@openslice.io");
		
		
		CustomerUpdate cu = new CustomerUpdate();
		cu.setEngagedParty( respc.getEngagedParty() );
		cm = new ContactMedium();
		cm.setMediumType("phone");
		medChar = new MediumCharacteristic();
		medChar.setPhoneNumber("555000");
		cm.setCharacteristic(medChar);
		contactMediums = new ArrayList<>();
		for (ContactMedium contactMedium : respc.getContactMedium()) {
			contactMediums.add(contactMedium);			
		}
		contactMediums.add(cm);
		cu.setContactMedium(contactMediums);
		
		String responseUpd = mvc.perform(MockMvcRequestBuilders.patch("/customerManagement/v4/customer/" + respc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
	            .contentType(MediaType.APPLICATION_JSON)
				.content( toJson( cu ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("A Customer")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( customerRepoService.findAll().size() ).isEqualTo( 1 );
		
		respc = toJsonObj( responseUpd, Customer.class);

		assertThat( respc.getContactMedium().size()  ).isEqualTo(2);

		String responseGet = mvc.perform(MockMvcRequestBuilders.get("/customerManagement/v4/customer")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( cc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andReturn().getResponse().getContentAsString();
		

		List<Customer> respcs = toJsonObj( responseGet, ArrayList.class);

		assertThat( respcs.size()  ).isEqualTo( 1 );
		
		
		responseGet = mvc.perform(MockMvcRequestBuilders.get("/customerManagement/v4/customer/" + respc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( cc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("A Customer")))								 
	    	    .andReturn().getResponse().getContentAsString();


		respc = toJsonObj( responseGet, Customer.class);
		
		

		String responseDel = mvc.perform(MockMvcRequestBuilders
				.delete("/customerManagement/v4/customer/" + respc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( cu ) ))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( customerRepoService.findAll().size() ).isEqualTo( 0 );
		
	}
	
	 static byte[] toJson(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsBytes(object);
	    }
	 
	static <T> T toJsonObj(String content, Class<T> valueType)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue( content, valueType);
    }
}
