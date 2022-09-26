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
import java.net.URI;

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
import org.springframework.mock.web.MockMultipartFile;
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

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.common.model.Quantity;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalogUpdate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceCategoryUpdate;
import io.openslice.tmf.rcm634.model.ResourceSpecCharRelationship;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCharacteristicValue;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRelationship;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceCandidateRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCatalogRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceCategoryRepoService;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class ResourceCatalogIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( ResourceCatalogIntegrationTest.class.getName());

	private static final int FIXED_BOOTSTRAPS_SPECS = 3;
	private static final int FIXED_BOOTSTRAPS_CATEGORIES = 2;
	private static final int FIXED_BOOTSTRAPS_PHYSICAL_SPECS = 1;
	private static final int FIXED_BOOTSTRAPS_LOGICAL_SPECS = 2;
	
    @Autowired
    private MockMvc mvc;

	@Autowired
	ResourceCatalogRepoService catalogRepoService;
	

	@Autowired
	ResourceCategoryRepoService categRepoService;

	@Autowired
	ResourceSpecificationRepoService specRepoService;

	@Autowired
	ResourceCandidateRepoService candidateRepoService;

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

		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 1 );
		assertThat( categRepoService.findAll().size() ).isEqualTo( 2 );
		assertThat( candidateRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		

		assertThat( catalogRepoService.findByName( "Catalog" )  ).isNotNull() ;
		assertThat( categRepoService.findByName( "Network Resources" )  ).isNotNull() ;

		ResourceCategory categ = categRepoService.findByName( "Network Resources" );
		assertThat( categ.getResourceCandidateRefs().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
	}
	

	@WithMockUser(username="osadmin", roles = {"ADMIN", "USER"})
	@Test
	public void addCatalogAddCategory() throws Exception {
		File scatalog = new File( "src/test/resources/testResourceCatalog.txt" );
		InputStream in = new FileInputStream( scatalog );
		String resvxf = IOUtils.toString(in, "UTF-8");
		
		ResourceCatalogCreate scc = JsonUtils.toJsonObj( resvxf,  ResourceCatalogCreate.class);
		
		String response = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceCatalog")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Catalog")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 2 );
		
		ResourceCatalog responsesCatalog = JsonUtils.toJsonObj(response,  ResourceCatalog.class);
		assertThat( responsesCatalog.getName() ).isEqualTo( "Test Catalog" );
		
		assertThat( responsesCatalog.getCategoryObj().size()).isEqualTo(0);
		
		
		/**
		 * add category
		 */
		
		File scat = new File( "src/test/resources/testResourceCategory.txt" );
		in = new FileInputStream( scat );
		String sc = IOUtils.toString(in, "UTF-8");
		
		ResourceCategoryCreate scategcreate = JsonUtils.toJsonObj( sc,  ResourceCategoryCreate.class);
		
		response = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceCategory")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scategcreate ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Category 2")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 1 );
		
		ResourceCategory responsesCateg = JsonUtils.toJsonObj(response,  ResourceCategory.class);
		assertThat( responsesCateg.getName() ).isEqualTo( "Test Category 2" );
		
		response = mvc.perform(MockMvcRequestBuilders.get("/resourceCatalogManagement/v4/resourceCategory/"+responsesCateg.getId())
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scategcreate ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Category 2")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();

		responsesCateg = JsonUtils.toJsonObj(response,  ResourceCategory.class);
		assertThat( responsesCateg.getName() ).isEqualTo( "Test Category 2" );
		
		
		/**
		 * update catalog with category
		 */
		ResourceCatalogUpdate scu = new ResourceCatalogUpdate();
		scu.setName( responsesCatalog.getName() );
		ResourceCategoryRef categoryItem = new ResourceCategoryRef();
		categoryItem.setId( responsesCateg.getId() );
		
		scu.addCategoryItem(categoryItem);
		 response = mvc.perform(MockMvcRequestBuilders.patch("/resourceCatalogManagement/v4/resourceCatalog/" + responsesCatalog.getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scu ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Catalog")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 2 );
			
		responsesCatalog = JsonUtils.toJsonObj(response, ResourceCatalog.class);
		assertThat(responsesCatalog.getName()).isEqualTo("Test Catalog");


		assertThat( responsesCatalog.getCategoryObj().size()).isEqualTo(1);
		assertThat( responsesCatalog.getCategoryRefs().get(0).getName() ).isEqualTo(  "Test Category 2" );
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 1 );
		
		/**
		 * Resource Spec
		 */
		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		LogicalResourceSpecificationCreate sspeccr = JsonUtils.toJsonObj( sspectext,  LogicalResourceSpecificationCreate.class);
		
		 response = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceSpecification")
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Resource Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		LogicalResourceSpecification responsesSpec = JsonUtils.toJsonObj(response,  LogicalResourceSpecification.class);
		assertThat( responsesSpec.getName() ).isEqualTo( "Test Resource Spec" );

		assertThat( responsesSpec.getResourceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( responsesSpec.getResourceSpecCharacteristic().toArray( new ResourceSpecificationCharacteristic[0] )[0].getResourceSpecCharacteristicValue().size()  ).isEqualTo(1);
		
		
		

		ResourceCandidateCreate scand = new ResourceCandidateCreate();
		scand.setName( responsesSpec.getName());
		ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
		resSpecificationRef.setId( responsesSpec.getId());
		resSpecificationRef.setName( responsesSpec .getName());
		scand.resourceSpecification(resSpecificationRef);
		categoryItem = new ResourceCategoryRef();
		categoryItem.setId( responsesCateg.getId());
		categoryItem.setName( responsesCateg.getName() );
		scand.addCategoryItem(categoryItem);
		
		response = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceCandidate")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
			.contentType(MediaType.APPLICATION_JSON)
			.content( JsonUtils.toJson( scand ) ))
		    .andExpect(status().isOk())
		    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		    .andExpect(jsonPath("name", is("Test Resource Spec")))								 
    	    .andExpect(status().isOk())
    	    .andReturn().getResponse().getContentAsString();
	
		
		
		
		PhysicalResourceSpecificationCreate physpeccr = JsonUtils.toJsonObj( sspectext,  PhysicalResourceSpecificationCreate.class);
		physpeccr.setType("PhysicalResourceSpecification");
		physpeccr.setModel("ACME");
		 response = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceSpecification")
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( physpeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Resource Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +2 );
		PhysicalResourceSpecification phyresponsesSpec = JsonUtils.toJsonObj(response,  PhysicalResourceSpecification.class);
		assertThat( phyresponsesSpec.getName() ).isEqualTo( "Test Resource Spec" );
		assertThat( phyresponsesSpec.getModel() ).isEqualTo( "ACME" );

		assertThat( phyresponsesSpec.getResourceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( phyresponsesSpec.getResourceSpecCharacteristic().toArray( new ResourceSpecificationCharacteristic[0] )[0].getResourceSpecCharacteristicValue().size()  ).isEqualTo(1);
		
		
	}
	
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void manageCategoriesSubCategories() throws Exception {
		/**
		 * add category
		 */
		
		File scat = new File( "src/test/resources/testResourceCategory.txt" );
		InputStream in = new FileInputStream( scat );
		String sc = IOUtils.toString(in, "UTF-8");
		
		ResourceCategoryCreate scategcreate = JsonUtils.toJsonObj( sc,  ResourceCategoryCreate.class);
		scategcreate.setIsRoot(true);
		ResourceCategory parentRootCategory = postCategory( scategcreate, scategcreate.getName() );

		ResourceCategoryCreate scategcreate2 = JsonUtils.toJsonObj( sc,  ResourceCategoryCreate.class);
		scategcreate2.setName("Child Cat");
		ResourceCategory child1Subcategory = postCategory( scategcreate2, scategcreate2.getName() );
		
		ResourceCategoryUpdate scUpd1 = JsonUtils.toJsonObj( sc,  ResourceCategoryUpdate.class);
		scUpd1.setIsRoot(true);
		scUpd1.setName("Parent Cat");
		ResourceCategoryRef scRef = new ResourceCategoryRef();
		scRef.setId( child1Subcategory.getId() );
		scRef.setName( child1Subcategory.getName() );
		scUpd1.addCategoryItem(scRef);
		

		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 2 );

		String response = mvc.perform(MockMvcRequestBuilders.patch("/resourceCatalogManagement/v4/resourceCategory/" + parentRootCategory.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scUpd1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is( "Parent Cat" )))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
				
		parentRootCategory = JsonUtils.toJsonObj(response,  ResourceCategory.class);
		

		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 2 );
		assertThat( parentRootCategory.getCategoryRefs().size() ).isEqualTo(1);
		assertThat( parentRootCategory.getCategoryRefs().get(0).getId() ).isEqualTo( child1Subcategory.getId() );
		
		/**
		 * add to a resource catalog and delete the service catalog, to chech that categories are still there
		 * 
		 */

		ResourceCatalog catalog = catalogRepoService.findByName( "Catalog" ); 
		assertThat( catalog.getCategoryRefs().size() ).isEqualTo( 1 );
		ResourceCatalogUpdate scu = new ResourceCatalogUpdate();
		scu.setName( catalog.getName() );
		for (ResourceCategoryRef iref : catalog.getCategoryRefs()) {
			scu.addCategoryItem( iref );
		}
		ResourceCategoryRef categoryItem = new ResourceCategoryRef();
		categoryItem.setId( parentRootCategory.getId() );
		scu.addCategoryItem( categoryItem );
		catalog = catalogRepoService.updateCatalog( catalog.getId(), scu);

		assertThat( catalog.getCategoryRefs().size() ).isEqualTo( 2 );
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 2 );
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 1 );		
		catalogRepoService.deleteById( catalog.getId() );//delete
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 0 );
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 2 );//categories must remain
		//fetch the subcategory and check parent ID
		
		 response = mvc.perform(MockMvcRequestBuilders.get("/resourceCatalogManagement/v4/resourceCategory/" + parentRootCategory.getCategoryRefs().get(0).getId() )
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scUpd1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
	    	    .andReturn().getResponse().getContentAsString();
		 
		 child1Subcategory = JsonUtils.toJsonObj(response,  ResourceCategory.class);
		
		 assertThat( child1Subcategory.getParentId()  ).isEqualTo( parentRootCategory.getId() );
		 		 
		 //delete category with childs not allows (not modified)
		 response = mvc.perform(MockMvcRequestBuilders.delete("/resourceCatalogManagement/v4/resourceCategory/" + parentRootCategory.getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scUpd1 ) ))
				    .andExpect(status().isNotModified() )
		    	    .andReturn().getResponse().getContentAsString();
		 
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 2 );
		
		//delete subcategory
		 response = mvc.perform(MockMvcRequestBuilders.delete("/resourceCatalogManagement/v4/resourceCategory/" + parentRootCategory.getCategoryRefs().get(0).getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scUpd1 ) ))
				    .andExpect(status().isOk() )
		    	    .andReturn().getResponse().getContentAsString();
		 
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES + 1 );
		
		 //delete rootcategory 
		 response = mvc.perform(MockMvcRequestBuilders.delete("/resourceCatalogManagement/v4/resourceCategory/" + parentRootCategory.getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scUpd1 ) ))
				    .andExpect(status().isOk() )
		    	    .andReturn().getResponse().getContentAsString();
		 
		assertThat( categRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_CATEGORIES );
		
	}

	

	private ResourceCategory postCategory(ResourceCategoryCreate scategcreate, String name) throws UnsupportedEncodingException, IOException, Exception {
			
			String response = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceCategory")
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scategcreate ) ))
				    .andExpect(status().isOk())
				    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				    .andExpect(jsonPath("name", is( name )))								 
		    	    .andExpect(status().isOk())
		    	    .andReturn().getResponse().getContentAsString();
					
			ResourceCategory responsesCateg = JsonUtils.toJsonObj(response,  ResourceCategory.class);
			
			return responsesCateg;
		}


	@WithMockUser(username="osadmin", roles = {"ADMIN" , "USER"})
	@Test
	public void testSpecAttributesUpdate() throws Exception {
		logger.info("Test: testSpecAttributesUpdate");
		/**
		 * Resource Spec
		 */
		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		LogicalResourceSpecificationCreate sspeccr = JsonUtils.toJsonObj( sspectext,  LogicalResourceSpecificationCreate.class);
		
		AttachmentRefOrValue attachmentItem = new AttachmentRefOrValue();
		attachmentItem.setId( "a-ref-id" );
		attachmentItem.setDescription("an attachment");
		attachmentItem.setUrl("a url");
		attachmentItem.setName("aname");
		sspeccr.addAttachmentItem(attachmentItem);
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/resourceCatalogManagement/v4/resourceSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Resource Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		LogicalResourceSpecification responsesSpec = JsonUtils.toJsonObj(responseSpec,  LogicalResourceSpecification.class);
		//logger.info("Test: testSpecAttachments response = " + responseSpec);
		assertThat( responsesSpec.getName() ).isEqualTo( "Test Resource Spec" );
		assertThat( responsesSpec.getAttachment().size() ).isEqualTo( 1 );
		
		//make it now as a ResourceSpecificationUpdate, no id, uuid and lastUpdate
		JSONObject obj = JsonUtils.toJsonObj(responseSpec, JSONObject.class);
		obj.remove("uuid");
		obj.remove("id");
		obj.remove("lastUpdate");
		obj.remove("@type");
		responseSpec = JsonUtils.toJsonString(obj);
				
		ResourceSpecificationUpdate responsesSpecUpd = JsonUtils.toJsonObj(responseSpec,  ResourceSpecificationUpdate.class);
		responsesSpecUpd.setName( "Test Spec a attr" );
		responsesSpecUpd.setVersion("2.x");
		ResourceSpecificationCharacteristic spechar = new ResourceSpecificationCharacteristic();
		spechar.setName("A new characteristic");
		ResourceSpecificationCharacteristicValue sv = new ResourceSpecificationCharacteristicValue();
		sv.setValue( new Any("1" ,"a first value") );
		sv.setValueType( EValueType.LONGTEXT.getValue());
		spechar.getResourceSpecCharacteristicValue().add( sv );
		responsesSpecUpd.getResourceSpecificationCharacteristic().add(spechar );
				
		String response2 = mvc.perform(MockMvcRequestBuilders.patch("/resourceCatalogManagement/v4/resourceSpecification/" + responsesSpec.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec a attr")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ResourceSpecification responsesSpec2 = JsonUtils.toJsonObj(response2,  LogicalResourceSpecification.class);
		assertThat( responsesSpec2.getName() ).isEqualTo( "Test Spec a attr" );
		assertThat( responsesSpec2.getVersion() ).isEqualTo( "2.x" );
		assertThat( responsesSpec2.getResourceSpecCharacteristic().size() ).isEqualTo(2);
		assertThat( responsesSpec2.getResourceSpecCharacteristic().toArray( new ResourceSpecificationCharacteristic[0] )[0].getResourceSpecCharacteristicValue().size()  ).isEqualTo(1);
		assertThat( responsesSpec2.findSpecCharacteristicByName("CoverageSpec")   ).isNotNull();
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic")   ).isNotNull();
		assertThat( responsesSpec2.findSpecCharacteristicByName("CoverageSpec").getResourceSpecCharacteristicValue().size()  ).isEqualTo(1);
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic").getResourceSpecCharacteristicValue().toArray( new ResourceSpecificationCharacteristicValue[0] )[0].getValue().getAlias() ).isEqualTo("a first value");
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic").getResourceSpecCharacteristicValue().toArray( new ResourceSpecificationCharacteristicValue[0] )[0].getValueType()  ).isEqualTo("LONGTEXT");
		assertThat( responsesSpec2.findSpecCharacteristicByName("CoverageSpec").getResourceSpecCharRelationship().size()  ).isEqualTo(4);
		

		//logger.info("Test: testSpecAttachments responsesSpec2 patch1= " + response2.toString());
		
		//test now update and delete things
		responsesSpecUpd = JsonUtils.toJsonObj(responseSpec,  ResourceSpecificationUpdate.class);
		ResourceSpecificationCharacteristicValue val = new ResourceSpecificationCharacteristicValue();
		val.setValueType( EValueType.ARRAY.toString());
		val.setValue( new Any("1" ,"a second value") );
		responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharacteristicValue().add(val);
		ResourceSpecCharRelationship scrObj = responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharRelationship().toArray( new ResourceSpecCharRelationship[0])[0];
		ResourceSpecCharRelationship scrObj2 = responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharRelationship().toArray( new ResourceSpecCharRelationship[0])[1];
		ResourceSpecCharRelationship scrObj3 = responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharRelationship().toArray( new ResourceSpecCharRelationship[0])[2];
		scrObj3.setName("FORTESTING");
		String preid = scrObj3.getId();
		responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharRelationship().remove(scrObj);
		responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharRelationship().remove(scrObj2);
		ResourceSpecCharRelationship scrObj4 = new ResourceSpecCharRelationship();
		scrObj4.setName("ANEWCharRel");
		responsesSpecUpd.getResourceSpecificationCharacteristic().get(0).getResourceSpecCharRelationship().add(scrObj4);
		
		response2 = mvc.perform(MockMvcRequestBuilders.patch("/resourceCatalogManagement/v4/resourceSpecification/" + responsesSpec.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Resource Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
//		logger.info("Test: testSpecAttachments responsesSpec2 patch2= " + response2.toString());

		responsesSpec2 = JsonUtils.toJsonObj(response2,  LogicalResourceSpecification.class);

		
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 1 );
		
		assertThat( responsesSpec2.getName() ).isEqualTo( "Test Resource Spec" );
		assertThat( responsesSpec2.getResourceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( responsesSpec2.findSpecCharacteristicByName("CoverageSpec")   ).isNotNull();
		assertThat( responsesSpec2.findSpecCharacteristicByName("CoverageSpec").getResourceSpecCharacteristicValue().size()  ).isEqualTo(2);
		boolean secvalExists = false;
		boolean arrayValExists = false;
		for (ResourceSpecificationCharacteristicValue respval : responsesSpec2.findSpecCharacteristicByName("CoverageSpec").getResourceSpecCharacteristicValue().toArray( new ResourceSpecificationCharacteristicValue[0] )) {
			if ( respval.getValue().getAlias().equals("a second value")){
				secvalExists = true;
			}
			if ( respval.getValueType().equals("ARRAY")){
				arrayValExists = true;
			}
		}
		assertThat( secvalExists ).isTrue();
		assertThat( arrayValExists).isTrue();
		
		
		assertThat( responsesSpec2.findSpecCharacteristicByName("CoverageSpec").getResourceSpecCharRelationship().size()  ).isEqualTo(3);
		boolean idfound = false;
		boolean ANEWCharRelExists =false;
		for (ResourceSpecCharRelationship tscr : responsesSpec2.findSpecCharacteristicByName("CoverageSpec").getResourceSpecCharRelationship()) {
			if ( (tscr.getId()!=null) && ( tscr.getId().equals(preid)) ) {
				idfound = true;
				assertThat( tscr.getName().equals("FORTESTING"));
			}
			
			if ( (tscr!=null) && (tscr.getName().equals( "ANEWCharRel" )) ){
				ANEWCharRelExists = true;
			}
		}
		assertThat( idfound).isTrue();
		assertThat( ANEWCharRelExists).isTrue();
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic")   ).isNull();

//		logger.info("Test: testSpecAttachments responsesSpec2 patch2= " + response2);
		


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1  );
		
	}
	
//	@GetMapping("/customHeader")
//    public ResponseEntity<String> customHeader() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "foo");
//
//        return new ResponseEntity<>("Custom header set", headers, HttpStatus.OK);
//    }

	
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

	@WithMockUser(username="osadmin", roles = {"USER" , "ADMIN"})
	@Test
	public void testBundledSpec() throws Exception {
		logger.info("Test: testBundledSpec " );

		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		LogicalResourceSpecification responsesSpec1 = (LogicalResourceSpecification) createResourceSpec( sspeccr1);

		
		ResourceSpecificationCreate sspeccr2 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		LogicalResourceSpecification responsesSpec2 = (LogicalResourceSpecification) createResourceSpec(sspeccr2);


		ResourceSpecificationCreate sspeccr3 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr3.setName("Spec3");
		sspeccr3.isBundle(true);
		sspeccr3.addResourceSpecificationRelationshipWith( responsesSpec1 );
		sspeccr3.addResourceSpecificationRelationshipWith( responsesSpec2 );
		LogicalResourceSpecification responsesSpec3 = (LogicalResourceSpecification) createResourceSpec(sspeccr3);
		
		
		assertThat( responsesSpec3.getResourceSpecRelationship().size() ).isEqualTo(2);
		boolean idspec1Exists = false;
		boolean idspec2Exists = false;
		String relationship2UUID = null;
		for (ResourceSpecificationRelationship r : responsesSpec3.getResourceSpecRelationship()) {
			if ( r.getId().equals( responsesSpec1.getId() ) ) {
				idspec1Exists= true;
			}
			if ( r.getId().equals( responsesSpec2.getId() ) ) {
				idspec2Exists= true;
				relationship2UUID = r.getUuid();
			}
		}
		assertThat( idspec1Exists ).isTrue();
		assertThat( idspec2Exists ).isTrue();
		
		/**
		 * try PATCH with service relationships
		 */
		//first add a new service spec and then reference it
		ResourceSpecificationCreate sspeccr4 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr4.setName("Spec4");
		ResourceSpecification responsesSpec4 = createResourceSpec( sspeccr3);
		
		String responseSpec3 = JsonUtils.toJsonString( responsesSpec3 );
		JSONObject obj = JsonUtils.toJsonObj(responseSpec3, JSONObject.class);
		obj.remove("uuid");
		obj.remove("id");
		obj.remove("lastUpdate");
		obj.remove("@type");
		responseSpec3 = JsonUtils.toJsonString(obj);
				
		ResourceSpecificationUpdate responsesSpecUpd = JsonUtils.toJsonObj(responseSpec3,  ResourceSpecificationUpdate.class);	
		for (ResourceSpecificationRelationship r : responsesSpecUpd.getResourceSpecificationRelationship()) {
			if ( r.getId().equals( responsesSpec1.getId() ) ) {
				responsesSpecUpd.getResourceSpecificationRelationship().remove(r);
				break;
			}
		}
		responsesSpecUpd.addResourceSpecificationRelationshipWith(responsesSpec4);
//		logger.info("Test: testBundledSpec responsesSpecUpd= " + responsesSpecUpd.toString());
		
		String responsePatch1 = mvc.perform(MockMvcRequestBuilders.patch("/resourceCatalogManagement/v4/resourceSpecification/" + responsesSpec3.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Spec3")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ResourceSpecification responseSpecPatch1 = JsonUtils.toJsonObj( responsePatch1,  LogicalResourceSpecification.class);

//		logger.info("Test: testBundledSpec responsePatch1= " + responsePatch1);

		assertThat( responseSpecPatch1.getResourceSpecRelationship().size() ).isEqualTo(2);
		
		idspec1Exists = false;
		idspec2Exists = false;
		boolean idspec4Exists = false;
		for (ResourceSpecificationRelationship r : responseSpecPatch1.getResourceSpecRelationship()) {
			if ( r.getId().equals( responsesSpec1.getId() ) ) {
				idspec1Exists= true;
			}
			if ( r.getId().equals( responsesSpec2.getId() ) ) {
				idspec2Exists= true;
				assertThat( r.getUuid() ).isEqualTo( relationship2UUID );
				
			}
			if ( r.getId().equals( responsesSpec4.getId() ) ) {
				idspec4Exists= true;
			}
		}
		
		assertThat( idspec1Exists ).isFalse();
		assertThat( idspec2Exists ).isTrue();
		assertThat( idspec4Exists ).isTrue();
		


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 4 );
		
	}
	

	
	

	@WithMockUser(username="osadmin", roles = {"ADMIN" , "USER"})
	@Test
	public void testSpecAttachment() throws Exception {
		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		LogicalResourceSpecification responsesSpec1 = (LogicalResourceSpecification) createResourceSpec( sspeccr1);

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 1 );
		
		Attachment att = new Attachment();
		att.setDescription("a test atts");
		att.setSize( new Quantity() );
		
		File gz = new File( "src/test/resources/cirros_vnf.tar.gz" );
		InputStream ing = new FileInputStream( gz );
		MockMultipartFile prodFile = new MockMultipartFile("afile", "cirros_vnf.tar.gz", "application/x-gzip", IOUtils.toByteArray(ing));
		
		
		
		String responsePatch1 = mvc.perform(MockMvcRequestBuilders
				.multipart("/resourceCatalogManagement/v4/resourceSpecification/" + responsesSpec1.getId() + "/attachment" )
				.file(prodFile)
				.param("attachment", JsonUtils.toJsonString(att))
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				)
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Spec1")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ResourceSpecification responseSpecPost1 = JsonUtils.toJsonObj( responsePatch1,  LogicalResourceSpecification.class);

		//logger.info("Test: testSpecAttachment responseSpecPost1= " + responseSpecPost1);

		assertThat( responseSpecPost1.getAttachment().size() ).isEqualTo( 1 );
	}


	@WithMockUser(username="osadmin", roles = {"USER", "ADMIN"})
	@Test
	public void testLogicalPhysicalResources() throws Exception {
		File sspec = new File( "src/test/resources/testResourceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");


		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ResourceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		LogicalResourceSpecification responsesSpec1 = (LogicalResourceSpecification) createResourceSpec( sspeccr1);
		

		PhysicalResourceSpecificationCreate physspeccr1 = JsonUtils.toJsonObj( sspectext,  PhysicalResourceSpecificationCreate.class);
		physspeccr1.setType("PhysicalResourceSpecification");
		physspeccr1.setName("SpecPhy1");
		physspeccr1.setPart("APART");
		physspeccr1.setModel("ACME");
		PhysicalResourceSpecification phyresponsesSpec1 = (PhysicalResourceSpecification) createResourceSpec( physspeccr1);

		
		//testPhysicalResourceSpec.json
		File physsspec2 = new File( "src/test/resources/testPhysicalResourceSpec.json" );
		in = new FileInputStream( physsspec2 );
		String physsspectext = IOUtils.toString(in, "UTF-8");
		PhysicalResourceSpecificationCreate physspeccr2 = JsonUtils.toJsonObj( physsspectext,  PhysicalResourceSpecificationCreate.class);
		phyresponsesSpec1 = (PhysicalResourceSpecification) createResourceSpec( physspeccr2);
		
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 3 );
		assertThat( specRepoService.findAllPhysical().size() ).isEqualTo( FIXED_BOOTSTRAPS_PHYSICAL_SPECS + 2 );
		assertThat( specRepoService.findAllLogical().size() ).isEqualTo( FIXED_BOOTSTRAPS_LOGICAL_SPECS + 1);
		
	}
	
}
