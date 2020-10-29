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
package io.openslice.services.api;



import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.model.DeploymentDescriptor;
import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.common.model.service.Characteristic;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.common.model.service.ServiceStateType;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.reposervices.CatalogRepoService;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.sim638.model.Service;
import io.openslice.tmf.sim638.model.ServiceActionQueueAction;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.service.ServiceRepoService;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class ServiceInventoryIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( ServiceInventoryIntegrationTest.class.getName());
	
    @Autowired
    private MockMvc mvc;

	@Autowired
	CatalogRepoService catalogRepoService;
	

	@Autowired
	CategoryRepoService categRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepoService;
	

	@Autowired
	ServiceRepoService serviceRepoService;

	  @Autowired
	    private WebApplicationContext context;
	    
		@Before
	    public void setup() {
	        mvc = MockMvcBuilders
	          .webAppContextSetup(context)
	          .apply(springSecurity())
	          .build();
	    }
	
	@Test
	public void _countDefaultProperties() {

		assertThat( serviceRepoService.findAll().size() ).isEqualTo( 0 );
		
	}

	@WithMockUser(username="osadmin", roles = {"USER"})
	@Test
	public void testServiceCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {
	
		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		//service 2 is an RFS
		ServiceSpecificationCreate sspeccr2 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		ResourceSpecificationRef resourceSpecificationItem = new ResourceSpecificationRef();
		resourceSpecificationItem.setId("resourceid");
		resourceSpecificationItem.setName("resourceName");		
		sspeccr2.addResourceSpecificationItem(resourceSpecificationItem);		
		ServiceSpecification responsesSpec2 = createServiceSpec(sspectext, sspeccr2);
		/**
		 * add them as bundle
		 */

		ServiceSpecificationCreate sspeccr3 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr3.setName("BundleExampleSpec");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec1 );
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec2 );		
		ServiceSpecification responsesSpec3 = createServiceSpec(sspectext, sspeccr3);
		
		ServiceCreate aService = new ServiceCreate();
		aService.setCategory("Experimentation");
		aService.setDescription("Experimentation Descr");
		aService.setStartDate( OffsetDateTime.now(ZoneOffset.UTC ).toString() );
		aService.setEndDate( OffsetDateTime.now(ZoneOffset.UTC ).toString() );
		
		Note noteItem = new Note();
		noteItem.text("test note");
		aService.addNoteItem(noteItem);
		
		Characteristic serviceCharacteristicItem = new Characteristic();
		
		serviceCharacteristicItem.setName( "ConfigStatus" );
		serviceCharacteristicItem.setValue( new Any("NONE"));
		aService.addServiceCharacteristicItem(serviceCharacteristicItem);
		
		ServiceSpecificationRef aServiceSpecificationRef = new ServiceSpecificationRef();
		aServiceSpecificationRef.setId(responsesSpec3.getId() );
		aServiceSpecificationRef.setName(responsesSpec3.getName());
		
		aService.setServiceSpecificationRef(aServiceSpecificationRef );

		logger.info("aService JSON = " + toJsonString( aService ));
		
		String responseService = mvc.perform(MockMvcRequestBuilders.post("/serviceInventory/v4/service")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( aService ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderCreate = " + responseService);
		Service responseSrvc = toJsonObj( responseService,  Service.class);
		
		
		logger.info("testService = " + toJsonString( responseSrvc ));
		

		assertThat( responseSrvc.getCategory()  ).isEqualTo( "Experimentation" );
		assertThat( responseSrvc.getDescription()  ).isEqualTo( "Experimentation Descr" );
		assertThat( responseSrvc.getStartDate() ).isNotNull();
		assertThat( responseSrvc.getEndDate() ).isNotNull();
		assertThat( responseSrvc.getServiceCharacteristic().size()  ).isEqualTo( 1 );
		assertThat( responseSrvc.getServiceCharacteristicByName( "ConfigStatus" ).getValue().getValue()  ).isEqualTo( "NONE" )  ;
		

		assertThat( responseSrvc.getNote().size()  ).isEqualTo( 2 );
		
		boolean userPartyRoleexists = false;
		for (RelatedParty r : responseSrvc.getRelatedParty()) {
			if ( r.getName().equals( "osadmin" ) && r.getRole().equals( UserPartRoleType.REQUESTER.toString() )) {
				userPartyRoleexists = true;
			}
		}
		
		assertThat(userPartyRoleexists  ).isTrue() ;

		assertThat( serviceRepoService.findAll().size() ).isEqualTo( 1 );
		
		
		ServiceUpdate servUpd = new ServiceUpdate();
		servUpd.setEndDate( OffsetDateTime.now(ZoneOffset.UTC ).toString()  );
		responseSrvc.getNote().stream().forEach(n -> servUpd.addNoteItem(n));
		Note en = new Note();
		en.text("test note2");
		en.setDate( OffsetDateTime.now(ZoneOffset.UTC).toString() );
		servUpd.addNoteItem(en);		

		for (Characteristic c : responseSrvc.getServiceCharacteristic()) {
			if (c.getName().equals( "ConfigStatus" )) {
				c.setValue( new Any("RUNNING"));
			}
			servUpd.addServiceCharacteristicItem(c);
		}
		servUpd.setState( ServiceStateType.INACTIVE );
		serviceCharacteristicItem = new Characteristic();		
		serviceCharacteristicItem.setName( "DeploymentRequestID" );
		serviceCharacteristicItem.setValue( new Any("007a008"));
		servUpd.addServiceCharacteristicItem(serviceCharacteristicItem);
		
		
		
		String responseSorderUpd = mvc.perform(MockMvcRequestBuilders.patch("/serviceInventory/v4/service/" + responseSrvc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( servUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderUpdate = " + responseSorderUpd);
		Service responseSOUpd = toJsonObj(responseSorderUpd,  Service.class);
		

		assertThat( serviceRepoService.findAll().size() ).isEqualTo( 1 );

		assertThat( responseSOUpd.getEndDate() ).isNotNull();
		assertThat( responseSOUpd.getNote().size()  ).isEqualTo( 4 );
		assertThat( responseSOUpd.getServiceCharacteristic().size()  ).isEqualTo( 2 );
		assertThat( responseSOUpd.getServiceCharacteristicByName( "ConfigStatus" ).getValue().getValue()  ).isEqualTo( "RUNNING" )  ;
		assertThat( responseSOUpd.getServiceCharacteristicByName( "DeploymentRequestID" ).getValue().getValue()  ).isEqualTo( "007a008" )  ;
		
		 
		assertThat( serviceRepoService.findAllServiceActionQueueItems().size() ).isEqualTo( 1 );		
		assertThat( serviceRepoService.findAllServiceActionQueueItems().get(0).getAction() ).isEqualTo(ServiceActionQueueAction.DEACTIVATE   );
		
	}
		
	
	private ServiceSpecification createServiceSpec(String sspectext, ServiceSpecificationCreate sspeccr1) throws Exception{
		
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec1 = toJsonObj(responseSpec,  ServiceSpecification.class);
		logger.info("createServiceSpec = " + responseSpec);
		return responsesSpec1;
	}
	

	
	
	private LogicalResourceSpec createLogicalResourceSpec() throws Exception{
		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		ResourceSpecificationCreate sspeccr1 = toJsonObj( sspectext,  ResourceSpecificationCreate.class);

		URI url = new URI("/resourceCatalogManagement/v2/logicalResourceSpec");
		
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post( url  )
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		LogicalResourceSpec responsesSpec1;
		
		responsesSpec1 = toJsonObj(responseSpec,  LogicalResourceSpec.class);
		
		logger.info("createResourceSpec = " + responseSpec);
		return responsesSpec1;
	}
	
	
	
	 static byte[] toJson(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsBytes(object);
	    }
	 
	 static String toJsonString(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsString(object);
	    }
	 
	 
	 static <T> T toJsonObj(String content, Class<T> valueType)  throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.readValue( content, valueType);
	    }
	 
	 static <T> T toJsonObj(InputStream content, Class<T> valueType)  throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.readValue( content, valueType);
	    }
	
}
