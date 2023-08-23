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
import java.util.ArrayList;

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
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceCatalogRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCategoryRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.ri639.model.Characteristic;
import io.openslice.tmf.ri639.model.LogicalResource;
import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceOperationalStateType;
import io.openslice.tmf.ri639.model.ResourceRelationship;
import io.openslice.tmf.ri639.model.ResourceUpdate;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class ResourceInventoryIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( ResourceInventoryIntegrationTest.class.getName());
	
    @Autowired
    private MockMvc mvc;

	@Autowired
	ResourceCatalogRepoService catalogRepoService;
	

	@Autowired
	ResourceCategoryRepoService categRepoService;

	@Autowired
	ResourceSpecificationRepoService specRepoService;
	

	@Autowired
	ResourceRepoService resourceRepoService;

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

		assertThat( resourceRepoService.findAll().size() ).isEqualTo( 0 );
		
	}

	@WithMockUser(username="osadmin", roles = {"USER","ADMIN"})
	@Test
	public void testResourceCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {
	
		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ResourceSpecification responsesSpec1 = createResourceSpec( sspeccr1);

		//res 2 is an RFS
		ResourceSpecificationCreate sspeccr2 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr2.setName("Spec2");

		sspeccr2.addResourceSpecificationRelationshipWith( responsesSpec1 );		
		LogicalResourceSpecification responsesSpec2 = (LogicalResourceSpecification) createResourceSpec( sspeccr2 );
		/**
		 * add them as bundle
		 */

		ResourceSpecificationCreate sspeccr3 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr3.setName("BundleExampleSpec");
		sspeccr3.isBundle(true);
		sspeccr3.addResourceSpecificationRelationshipWith( responsesSpec1 );
		sspeccr3.addResourceSpecificationRelationshipWith( responsesSpec2 );		
		ResourceSpecification responsesSpec3 = createResourceSpec( sspeccr3);
		
		ResourceCreate aResource = new ResourceCreate();
		aResource.setName("aNew Resource parent");
		aResource.setCategory("Experimentation");
		aResource.setDescription("Experimentation Descr");
		aResource.setStartOperatingDate( OffsetDateTime.now(ZoneOffset.UTC ).toString() );
		aResource.setEndOperatingDate( OffsetDateTime.now(ZoneOffset.UTC ).toString() );
		
		
		
		Note noteItem = new Note();
		noteItem.text("test note");
		aResource.addNoteItem(noteItem);
		
		Characteristic resCharacteristicItem = new Characteristic();
		
		resCharacteristicItem.setName( "ConfigStatus" );
		resCharacteristicItem.setValue( new Any("NONE"));
		aResource.addResourceCharacteristicItem(resCharacteristicItem);
		
		ResourceSpecificationRef aServiceSpecificationRef = new ResourceSpecificationRef();
		aServiceSpecificationRef.setId(responsesSpec3.getId() );
		aServiceSpecificationRef.setName(responsesSpec3.getName());
		
		aResource.setResourceSpecification( aServiceSpecificationRef );
		//create a first resoruce that will be added to the next one as ref
		String responseResource = mvc.perform(MockMvcRequestBuilders.post("/resourceInventoryManagement/v4/resource")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( aResource ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("responseResource = " + responseResource);
		Resource responseRsc = JsonUtils.toJsonObj( responseResource,  LogicalResource.class);
		

		aResource.setName("aNew Resource");
		
		ResourceRelationship rri = new ResourceRelationship();
		rri.setRelationshipType("PARENT");
		ResourceRef rrref = new ResourceRef();
		rrref.setName( responseRsc.getName() );
		rrref.setId( responseRsc.getId() );
		rri.setResource( rrref );
		aResource.addResourceRelationshipItem( rri  );

		logger.info("aService JSON = " + JsonUtils.toJsonString( aResource ));
		
		responseResource = mvc.perform(MockMvcRequestBuilders.post("/resourceInventoryManagement/v4/resource")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( aResource ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("responseResource = " + responseResource);
		 responseRsc = JsonUtils.toJsonObj( responseResource,  LogicalResource.class);
		
		
		logger.info("testService = " + JsonUtils.toJsonString( responseRsc ));
		

		assertThat( responseRsc.getCategory()  ).isEqualTo( "Experimentation" );
		assertThat( responseRsc.getDescription()  ).isEqualTo( "Experimentation Descr" );
		assertThat( responseRsc.getStartOperatingDate() ).isNotNull();
		assertThat( responseRsc.getEndOperatingDate() ).isNotNull();
		assertThat( responseRsc.getResourceCharacteristic().size()  ).isEqualTo( 1 );
		assertThat( responseRsc.getResourceCharacteristicByName( "ConfigStatus" ) ).isNotNull();
		assertThat( responseRsc.getResourceCharacteristicByName( "ConfigStatus" ).getValue().getValue()  ).isEqualTo( "NONE" )  ;
		assertThat( responseRsc.getResourceSpecification().getId()  ).isNotNull();
		assertThat( responseRsc.getResourceSpecification().getName()  ).isNotNull();
		assertThat( responseRsc.getResourceRelationship().size()  ).isEqualTo( 1 );
		

		assertThat( responseRsc.getNote().size()  ).isEqualTo( 2 );
		
		boolean userPartyRoleexists = false;
		for (RelatedParty r : responseRsc.getRelatedParty()) {
			if ( r.getName().equals( "osadmin" ) && r.getRole().equals( UserPartRoleType.REQUESTER.toString() )) {
				userPartyRoleexists = true;
			}
		}
		
		assertThat(userPartyRoleexists  ).isTrue() ;

		assertThat( resourceRepoService.findAll().size() ).isEqualTo( 2 );
		
		
		ResourceUpdate resUpd = new ResourceUpdate();
		resUpd.setEndOperatingDate( OffsetDateTime.now(ZoneOffset.UTC ).toString()  );
		responseRsc.getNote().stream().forEach(n -> resUpd.addNoteItem(n));
		Note en = new Note();
		en.text("test note2");
		en.setDate( OffsetDateTime.now(ZoneOffset.UTC).toString() );
		resUpd.addNoteItem(en);		

		for (Characteristic c : responseRsc.getResourceCharacteristic()) {
			if (c.getName().equals( "ConfigStatus" )) {
				c.setValue( new Any("RUNNING"));
			}
			resUpd.addResourceCharacteristicItem(c);
		}
		resUpd.setOperationalState( ResourceOperationalStateType.ENABLE );
		resCharacteristicItem = new Characteristic();		
		resCharacteristicItem.setName( "DeploymentRequestID" );
		resCharacteristicItem.setValue( new Any("007a008"));
		resUpd.addResourceCharacteristicItem(resCharacteristicItem);
		resUpd.setResourceRelationship( new ArrayList<>());
		
		
		String responseResUpd = mvc.perform(MockMvcRequestBuilders
				.patch("/resourceInventoryManagement/v4/resource/" + responseRsc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( resUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderUpdate = " + responseResUpd);
		Resource responseRes2 = JsonUtils.toJsonObj(responseResUpd,  LogicalResource.class);
		

		assertThat( resourceRepoService.findAll().size() ).isEqualTo( 2 );

		assertThat( responseRes2.getEndOperatingDate() ).isNotNull();
		assertThat( responseRes2.getNote().size()  ).isEqualTo( 3 );
		assertThat( responseRes2.getResourceCharacteristic().size()  ).isEqualTo( 2 );
		assertThat( responseRes2.getResourceCharacteristicByName( "ConfigStatus" ).getValue().getValue()  ).isEqualTo( "RUNNING" )  ;
		assertThat( responseRes2.getResourceCharacteristicByName( "DeploymentRequestID" ).getValue().getValue()  ).isEqualTo( "007a008" )  ;
		assertThat( responseRes2.getResourceSpecification().getId()  ).isNotNull();
		assertThat( responseRes2.getResourceSpecification().getName()  ).isNotNull();
		assertThat( responseRes2.getResourceRelationship().size()  ).isEqualTo( 0 );
		
		

		responseResUpd = mvc.perform(MockMvcRequestBuilders
				.get("/resourceInventoryManagement/v4/resource/" + responseRsc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( resUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderUpdate = " + responseResUpd);
		responseRes2 = JsonUtils.toJsonObj(responseResUpd,  LogicalResource.class);
		

		assertThat( resourceRepoService.findAll().size() ).isEqualTo( 2 );

		assertThat( responseRes2.getEndOperatingDate() ).isNotNull();
		assertThat( responseRes2.getNote().size()  ).isEqualTo( 3 );
		assertThat( responseRes2.getResourceCharacteristic().size()  ).isEqualTo( 2 );
		assertThat( responseRes2.getResourceCharacteristicByName( "ConfigStatus" ).getValue().getValue()  ).isEqualTo( "RUNNING" )  ;
		assertThat( responseRes2.getResourceCharacteristicByName( "DeploymentRequestID" ).getValue().getValue()  ).isEqualTo( "007a008" )  ;
		assertThat( responseRes2.getResourceSpecification().getId()  ).isNotNull();
		assertThat( responseRes2.getResourceSpecification().getName()  ).isNotNull();
		assertThat( responseRes2.getResourceRelationship().size()  ).isEqualTo( 0 );
		

		resUpd.addResourceRelationshipItem( rri  );
		
		responseResUpd = mvc.perform(MockMvcRequestBuilders
				.patch("/resourceInventoryManagement/v4/resource/" + responseRsc.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( resUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderUpdate = " + responseResUpd);
		responseRes2 = JsonUtils.toJsonObj(responseResUpd,  LogicalResource.class);
		

		assertThat( resourceRepoService.findAll().size() ).isEqualTo( 2 );

		assertThat( responseRes2.getEndOperatingDate() ).isNotNull();
		assertThat( responseRes2.getNote().size()  ).isEqualTo( 4 );
		assertThat( responseRes2.getResourceCharacteristic().size()  ).isEqualTo( 2 );
		assertThat( responseRes2.getResourceCharacteristicByName( "ConfigStatus" ).getValue().getValue()  ).isEqualTo( "RUNNING" )  ;
		assertThat( responseRes2.getResourceCharacteristicByName( "DeploymentRequestID" ).getValue().getValue()  ).isEqualTo( "007a008" )  ;
		assertThat( responseRes2.getResourceSpecification().getId()  ).isNotNull();
		assertThat( responseRes2.getResourceSpecification().getName()  ).isNotNull();
		assertThat( responseRes2.getResourceRelationship().size()  ).isEqualTo( 1 );
		
	}
		
	
	private ResourceSpecification createResourceSpec(ResourceSpecificationUpdate sspeccr1) throws Exception{
		
		URI url = new URI("/resourceCatalogManagement/v4/resourceSpecification");
		if (sspeccr1 instanceof PhysicalResourceSpecificationUpdate ) {
			url = new URI("/resourceCatalogManagement/v4/resourceSpecification");
		}
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post( url  )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		ResourceSpecification responsesSpec1;
		if (sspeccr1 instanceof PhysicalResourceSpecificationUpdate ) {
			responsesSpec1 = JsonUtils.toJsonObj(responseSpec,  PhysicalResourceSpecification.class);			
		}else {
			responsesSpec1 = JsonUtils.toJsonObj(responseSpec,  LogicalResourceSpecification.class);			
		}
		
//		logger.info("createResourceSpec = " + responseSpec);
		return responsesSpec1;
	}
	

	
	
	private LogicalResourceSpecification createLogicalResourceSpec() throws Exception{
		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);

		URI url = new URI("/resourceCatalogManagement/v4/logicalResourceSpec");
		
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post( url  )
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		LogicalResourceSpecification responsesSpec1;
		
		responsesSpec1 = JsonUtils.toJsonObj(responseSpec,  LogicalResourceSpecification.class);
		
		logger.info("createResourceSpec = " + responseSpec);
		return responsesSpec1;
	}
	
	
	
	
}
