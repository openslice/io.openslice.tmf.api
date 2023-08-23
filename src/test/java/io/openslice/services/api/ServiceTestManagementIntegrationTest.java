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
package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import io.openslice.tmf.stm653.model.ServiceTestCreate;
import io.openslice.tmf.stm653.model.ServiceTestSpecificationCreate;
import io.openslice.tmf.stm653.reposervices.ServiceTestRepoService;
import io.openslice.tmf.stm653.reposervices.ServiceTestSpecificationRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class ServiceTestManagementIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(ServiceTestManagementIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;

	@Autowired
	ServiceTestSpecificationRepoService aServiceTestSpecRpoService;	

	@Autowired
	ServiceTestRepoService aServiceTestRpoService;

	@Autowired
	ServiceRepoService serviceRepoService;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(username = "osadmin", roles = { "ADMIN","USER" })
	@Test
	public void testServiceTestSpecCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {

		/**
		 * first add 2 specs
		 */
//		/testServiceTestSpec
		
		

		File sspec = new File( "src/test/resources/testServiceTestSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		ServiceTestSpecificationCreate spec = JsonUtils.toJsonObj( sspectext,  ServiceTestSpecificationCreate.class);  
		
		
		String response = mvc.perform(MockMvcRequestBuilders.post("/serviceTestManagement/v4/serviceTestSpecification")
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( spec ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("A test name")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( aServiceTestSpecRpoService.findAll().size() ).isEqualTo( 1 );
		
		
		sspec = new File( "src/test/resources/testServiceTest.json" );
		in = new FileInputStream( sspec );
		sspectext = IOUtils.toString(in, "UTF-8");
		ServiceTestCreate stest = JsonUtils.toJsonObj( sspectext,  ServiceTestCreate.class);  
		
		
		response = mvc.perform(MockMvcRequestBuilders.post("/serviceTestManagement/v4/serviceTest")
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( stest ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("A test name")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( aServiceTestRpoService.findAll().size() ).isEqualTo( 1 );
		

	}
	

}
