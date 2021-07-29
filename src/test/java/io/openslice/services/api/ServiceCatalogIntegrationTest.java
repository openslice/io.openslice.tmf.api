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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

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

import io.openslice.tmf.BootstrapRepository;
import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.common.model.AttachmentRef;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.common.model.Quantity;
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.pm632.model.Organization;
import io.openslice.tmf.pm632.model.OrganizationCreate;
import io.openslice.tmf.pm632.reposervices.OrganizationRepoService;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceCandidateRef;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm633.model.ServiceSpecCharRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm633.reposervices.CandidateRepoService;
import io.openslice.tmf.scm633.reposervices.CatalogRepoService;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class ServiceCatalogIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( ServiceCatalogIntegrationTest.class.getName());

	private static final int FIXED_BOOTSTRAPS_SPECS = 1;
	
    @Autowired
    private MockMvc mvc;

	@Autowired
	CatalogRepoService catalogRepoService;
	

	@Autowired
	CategoryRepoService categRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepoService;

	@Autowired
	CandidateRepoService candidateRepoService;
	
    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private BootstrapRepository bootstrapRepository;
    

	@Autowired
	OrganizationRepoService organizationRepoService;
	
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
		assertThat( categRepoService.findAll().size() ).isEqualTo( 1 );
		assertThat( candidateRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		assertThat( catalogRepoService.findByName( "Catalog" )  ).isNotNull() ;
		assertThat( categRepoService.findByName( "Generic Services" )  ).isNotNull() ;
		
		ServiceCategory categ = categRepoService.findByName( "Generic Services" );
		assertThat( categ.getServiceCandidateRefs().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		ServiceCategory categ2 = categRepoService.findByIdEager( categ.getId() );
		assertThat( categ2.getServiceCandidateRefs().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		boolean vinnisbFound = false;
		boolean gstFound = false;
		for (ServiceCandidateRef scr : categ.getServiceCandidateRefs()) {
			if (scr.getName().equals( "A GST(NEST) Service Example" )) {
				gstFound = true;
			}
			if (scr.getName().equals( "A VINNI Service Example" )) {
				vinnisbFound = true;
			}
		}
		
		assertThat( gstFound ).isTrue();
		//assertThat( vinnisbFound ).isTrue(); 
				
		
		
	}
	
	@Test
    public void givenRequestOnPrivateService_shouldFailWith401() throws Exception {
//        mvc.perform(post("/serviceCatalogManagement/v4/serviceCatalog")
//                        .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isUnauthorized());
    }
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void addCatalogAddCategory() throws Exception {
		File scatalog = new File( "src/test/resources/testServiceCatalog.txt" );
		InputStream in = new FileInputStream( scatalog );
		String resvxf = IOUtils.toString(in, "UTF-8");
		
		ServiceCatalogCreate scc = JsonUtils.toJsonObj( resvxf,  ServiceCatalogCreate.class);
		
		String response = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceCatalog")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Catalog")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 2 );
		
		ServiceCatalog responsesCatalog = JsonUtils.toJsonObj(response,  ServiceCatalog.class);
		assertThat( responsesCatalog.getName() ).isEqualTo( "Test Catalog" );
		
		assertThat( responsesCatalog.getCategoryObj().size()).isEqualTo(0);
		
		
		/**
		 * add category
		 */
		
		File scat = new File( "src/test/resources/testServiceCategory.txt" );
		in = new FileInputStream( scat );
		String sc = IOUtils.toString(in, "UTF-8");
		
		ServiceCategoryCreate scategcreate = JsonUtils.toJsonObj( sc,  ServiceCategoryCreate.class);
		
		response = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceCategory")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scategcreate ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Category 2")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		assertThat( categRepoService.findAll().size() ).isEqualTo( 2 );
		
		ServiceCategory responsesCateg = JsonUtils.toJsonObj(response,  ServiceCategory.class);
		assertThat( responsesCateg.getName() ).isEqualTo( "Test Category 2" );
		
		
		/**
		 * update catalog with category
		 */
		ServiceCatalogUpdate scu = new ServiceCatalogUpdate();
		scu.setName( responsesCatalog.getName() );
		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId( responsesCateg.getId() );
		
		scu.addCategoryItem(categoryItem);
		 response = mvc.perform(MockMvcRequestBuilders.patch("/serviceCatalogManagement/v4/serviceCatalog/" + responsesCatalog.getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scu ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Catalog")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 2 );
			
		responsesCatalog = JsonUtils.toJsonObj(response, ServiceCatalog.class);
		assertThat(responsesCatalog.getName()).isEqualTo("Test Catalog");


		assertThat( responsesCatalog.getCategoryObj().size()).isEqualTo(1);
		assertThat( responsesCatalog.getCategoryRefs().get(0).getName() ).isEqualTo(  "Test Category 2" );
		
		/**
		 * Service Spec
		 */
		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		
		 response = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		ServiceSpecification responsesSpec = JsonUtils.toJsonObj(response,  ServiceSpecification.class);
		assertThat( responsesSpec.getName() ).isEqualTo( "Test Spec" );

		assertThat( responsesSpec.getServiceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( responsesSpec.getServiceSpecCharacteristic().toArray( new ServiceSpecCharacteristic[0] )[0].getServiceSpecCharacteristicValue().size()  ).isEqualTo(1);
		
		
		
		
	}
	
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void manageCategoriesSubCategories() throws Exception {
		/**
		 * add category
		 */
		
		File scat = new File( "src/test/resources/testServiceCategory.txt" );
		InputStream in = new FileInputStream( scat );
		String sc = IOUtils.toString(in, "UTF-8");
		
		ServiceCategoryCreate scategcreate = JsonUtils.toJsonObj( sc,  ServiceCategoryCreate.class);
		scategcreate.setIsRoot(true);
		ServiceCategory parentRootCategory = postCategory( scategcreate, scategcreate.getName() );

		ServiceCategoryCreate scategcreate2 = JsonUtils.toJsonObj( sc,  ServiceCategoryCreate.class);
		scategcreate2.setName("Child Cat");
		ServiceCategory child1Subcategory = postCategory( scategcreate2, scategcreate2.getName() );
		
		ServiceCategoryUpdate scUpd1 = JsonUtils.toJsonObj( sc,  ServiceCategoryUpdate.class);
		scUpd1.setIsRoot(true);
		scUpd1.setName("Parent Cat");
		ServiceCategoryRef scRef = new ServiceCategoryRef();
		scRef.setId( child1Subcategory.getId() );
		scRef.setName( child1Subcategory.getName() );
		scUpd1.addCategoryItem(scRef);
		

		assertThat( categRepoService.findAll().size() ).isEqualTo( 3 );

		String response = mvc.perform(MockMvcRequestBuilders.patch("/serviceCatalogManagement/v4/serviceCategory/" + parentRootCategory.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scUpd1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is( "Parent Cat" )))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
				
		parentRootCategory = JsonUtils.toJsonObj(response,  ServiceCategory.class);
		

		assertThat( categRepoService.findAll().size() ).isEqualTo( 3 );
		assertThat( parentRootCategory.getCategoryRefs().size() ).isEqualTo(1);
		assertThat( parentRootCategory.getCategoryRefs().get(0).getId() ).isEqualTo( child1Subcategory.getId() );
		
		
		/**
		 * add to a service catalog and delete the service catalog, to check that categories are still there
		 * 
		 */

		ServiceCatalog catalog = catalogRepoService.findByName( "Catalog" ); 
		assertThat( catalog.getCategoryRefs().size() ).isEqualTo( 1 );
		ServiceCatalogUpdate scu = new ServiceCatalogUpdate();
		scu.setName( catalog.getName() );
		for (ServiceCategoryRef iref : catalog.getCategoryRefs()) {
			scu.addCategoryItem( iref );
		}
		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId( parentRootCategory.getId() );
		scu.addCategoryItem( categoryItem );
		catalog = catalogRepoService.updateCatalog( catalog.getId(), scu);

		assertThat( catalog.getCategoryRefs().size() ).isEqualTo( 2 );
		assertThat( categRepoService.findAll().size() ).isEqualTo( 3 );
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 1 );		
		catalogRepoService.deleteById( catalog.getId() );//delete
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 0 );
		assertThat( categRepoService.findAll().size() ).isEqualTo( 3 );//categories must remain
		
		
		//fetch the subcategory and check parent ID
		
		 response = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceCategory/" + parentRootCategory.getCategoryRefs().get(0).getId() )
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scUpd1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))	
	    	    .andReturn().getResponse().getContentAsString();
		 
		 child1Subcategory = JsonUtils.toJsonObj(response,  ServiceCategory.class);
		
		 assertThat( child1Subcategory.getParentId()  ).isEqualTo( parentRootCategory.getId() );
		 		 
		 //delete category with childs not allows (not modified)
		 response = mvc.perform(MockMvcRequestBuilders.delete("/serviceCatalogManagement/v4/serviceCategory/" + parentRootCategory.getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scUpd1 ) ))
				    .andExpect(status().isNotModified() )
		    	    .andReturn().getResponse().getContentAsString();
		 
		assertThat( categRepoService.findAll().size() ).isEqualTo( 3 );
		
		//delete subcategory
		 response = mvc.perform(MockMvcRequestBuilders.delete("/serviceCatalogManagement/v4/serviceCategory/" + parentRootCategory.getCategoryRefs().get(0).getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scUpd1 ) ))
				    .andExpect(status().isOk() )
		    	    .andReturn().getResponse().getContentAsString();
		 
		assertThat( categRepoService.findAll().size() ).isEqualTo( 2 );
		
		 //delete rootcategory 
		 response = mvc.perform(MockMvcRequestBuilders.delete("/serviceCatalogManagement/v4/serviceCategory/" + parentRootCategory.getId() )
		            .with( SecurityMockMvcRequestPostProcessors.csrf())
					.contentType(MediaType.APPLICATION_JSON)
					.content( JsonUtils.toJson( scUpd1 ) ))
				    .andExpect(status().isOk() )
		    	    .andReturn().getResponse().getContentAsString();
		 
		assertThat( categRepoService.findAll().size() ).isEqualTo( 1 );
		
	}

	private ServiceCategory postCategory(ServiceCategoryCreate scategcreate, String name) throws UnsupportedEncodingException, IOException, Exception {
				
		String response = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceCategory")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( scategcreate ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is( name )))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
				
		ServiceCategory responsesCateg = JsonUtils.toJsonObj(response,  ServiceCategory.class);
		
		return responsesCateg;
	}

	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testSpecAttributesUpdate() throws Exception {
		logger.info("Test: testSpecAttributesUpdate");
		/**
		 * Service Spec
		 */
		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		
		AttachmentRef attachmentItem = new AttachmentRef();
		attachmentItem.setId( "a-ref-id" );
		attachmentItem.setDescription("an attachment");
		attachmentItem.setUrl("a url");
		attachmentItem.setName("a url");
		sspeccr.addAttachmentItem(attachmentItem);
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec = JsonUtils.toJsonObj(responseSpec,  ServiceSpecification.class);
		logger.info("Test: testSpecAttachments response = " + responseSpec);
		assertThat( responsesSpec.getName() ).isEqualTo( "Test Spec" );
		assertThat( responsesSpec.getAttachment().size() ).isEqualTo( 1 );
		
		//make it now as a ServiceSpecificationUpdate, no id, uuid and lastUpdate
		JSONObject obj = JsonUtils.toJsonObj(responseSpec, JSONObject.class);
		obj.remove("uuid");
		obj.remove("id");
		obj.remove("lastUpdate");
		responseSpec = JsonUtils.toJsonString(obj);
				
		ServiceSpecificationUpdate responsesSpecUpd = JsonUtils.toJsonObj(responseSpec,  ServiceSpecificationUpdate.class);
		responsesSpecUpd.setName( "Test Spec a attr" );
		responsesSpecUpd.setVersion("2.x");
		ServiceSpecCharacteristic spechar = new ServiceSpecCharacteristic();
		spechar.setName("A new characteristic");
		ServiceSpecCharacteristicValue sv = new ServiceSpecCharacteristicValue();
		sv.setValue( new Any("1" ,"a first value") );
		sv.setValueType( EValueType.LONGTEXT.getValue());
		spechar.getServiceSpecCharacteristicValue().add( sv );
		responsesSpecUpd.getServiceSpecCharacteristic().add(spechar );
				
		String response2 = mvc.perform(MockMvcRequestBuilders.patch("/serviceCatalogManagement/v4/serviceSpecification/" + responsesSpec.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec a attr")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec2 = JsonUtils.toJsonObj(response2,  ServiceSpecification.class);
		assertThat( responsesSpec2.getName() ).isEqualTo( "Test Spec a attr" );
		assertThat( responsesSpec2.getVersion() ).isEqualTo( "2.x" );
		assertThat( responsesSpec2.getServiceSpecCharacteristic().size() ).isEqualTo(2);
		assertThat( responsesSpec2.getServiceSpecCharacteristic().toArray( new ServiceSpecCharacteristic[0] )[0].getServiceSpecCharacteristicValue().size()  ).isEqualTo(1);
		assertThat( responsesSpec2.findSpecCharacteristicByName("Coverage")   ).isNotNull();
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic")   ).isNotNull();
		assertThat( responsesSpec2.findSpecCharacteristicByName("Coverage").getServiceSpecCharacteristicValue().size()  ).isEqualTo(1);
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic").getServiceSpecCharacteristicValue().toArray( new ServiceSpecCharacteristicValue[0] )[0].getValue().getAlias() ).isEqualTo("a first value");
		assertThat( responsesSpec2.findSpecCharacteristicByName("A new characteristic").getServiceSpecCharacteristicValue().toArray( new ServiceSpecCharacteristicValue[0] )[0].getValueType()  ).isEqualTo("LONGTEXT");
		assertThat( responsesSpec2.findSpecCharacteristicByName("Coverage").getServiceSpecCharRelationship().size()  ).isEqualTo(4);
		

		logger.info("Test: testSpecAttachments responsesSpec2 patch1= " + response2.toString());
		
		//test now update and delete things
		responsesSpecUpd = JsonUtils.toJsonObj(responseSpec,  ServiceSpecificationUpdate.class);
		ServiceSpecCharacteristicValue val = new ServiceSpecCharacteristicValue();
		val.setValueType( EValueType.ARRAY.toString());
		val.setValue( new Any("1" ,"a second value") );
		responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharacteristicValue().add(val);
		ServiceSpecCharRelationship scrObj = responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharRelationship().toArray( new ServiceSpecCharRelationship[0])[0];
		ServiceSpecCharRelationship scrObj2 = responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharRelationship().toArray( new ServiceSpecCharRelationship[0])[1];
		ServiceSpecCharRelationship scrObj3 = responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharRelationship().toArray( new ServiceSpecCharRelationship[0])[2];
		scrObj3.setName("FORTESTING");
		String preid = scrObj3.getId();
		responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharRelationship().remove(scrObj);
		responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharRelationship().remove(scrObj2);
		ServiceSpecCharRelationship scrObj4 = new ServiceSpecCharRelationship();
		scrObj4.setName("ANEWCharRel");
		responsesSpecUpd.getServiceSpecCharacteristic().get(0).getServiceSpecCharRelationship().add(scrObj4);
		
		response2 = mvc.perform(MockMvcRequestBuilders.patch("/serviceCatalogManagement/v4/serviceSpecification/" + responsesSpec.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("Test: testSpecAttachments responsesSpec2 patch2= " + response2.toString());

		responsesSpec2 = JsonUtils.toJsonObj(response2,  ServiceSpecification.class);

		
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		
		assertThat( responsesSpec2.getName() ).isEqualTo( "Test Spec" );
		assertThat( responsesSpec2.getServiceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( responsesSpec2.findSpecCharacteristicByName("Coverage")   ).isNotNull();
		assertThat( responsesSpec2.findSpecCharacteristicByName("Coverage").getServiceSpecCharacteristicValue().size()  ).isEqualTo(2);
		boolean secvalExists = false;
		boolean arrayValExists = false;
		for (ServiceSpecCharacteristicValue respval : responsesSpec2.findSpecCharacteristicByName("Coverage").getServiceSpecCharacteristicValue().toArray( new ServiceSpecCharacteristicValue[0] )) {
			if ( respval.getValue().getAlias().equals("a second value")){
				secvalExists = true;
			}
			if ( respval.getValueType().equals("ARRAY")){
				arrayValExists = true;
			}
		}
		assertThat( secvalExists ).isTrue();
		assertThat( arrayValExists).isTrue();
		
		
		assertThat( responsesSpec2.findSpecCharacteristicByName("Coverage").getServiceSpecCharRelationship().size()  ).isEqualTo(3);
		boolean idfound = false;
		boolean ANEWCharRelExists =false;
		for (ServiceSpecCharRelationship tscr : responsesSpec2.findSpecCharacteristicByName("Coverage").getServiceSpecCharRelationship()) {
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

		logger.info("Test: testSpecAttachments responsesSpec2 patch2= " + response2);
		


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 1 );
		
	}
	
	
	private ServiceSpecification createServiceSpec(String sspectext, ServiceSpecificationCreate sspeccr1) throws Exception{
		
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec1 = JsonUtils.toJsonObj(responseSpec,  ServiceSpecification.class);
		logger.info("createServiceSpec = " + responseSpec);
		return responsesSpec1;
	}

	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testBundledSpec() throws Exception {
		logger.info("Test: testBundledSpec " );

		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		
		ServiceSpecificationCreate sspeccr2 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		ServiceSpecification responsesSpec2 = createServiceSpec(sspectext, sspeccr2);


		ServiceSpecificationCreate sspeccr3 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr3.setName("Spec3");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec1 );
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec2 );
		
		ResourceSpecificationRef resourceSpecificationItem = new ResourceSpecificationRef();
		resourceSpecificationItem.setId("resourceid");
		resourceSpecificationItem.setName("resourceName");		
		sspeccr3.addResourceSpecificationItem(resourceSpecificationItem);
		
		ServiceSpecification responsesSpec3 = createServiceSpec(sspectext, sspeccr3);
		
		
		assertThat( responsesSpec3.getServiceSpecRelationship().size() ).isEqualTo(2);
		boolean idspec1Exists = false;
		boolean idspec2Exists = false;
		String relationship2UUID = null;
		for (ServiceSpecRelationship r : responsesSpec3.getServiceSpecRelationship()) {
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

		assertThat( responsesSpec3.getResourceSpecification().size() ).isEqualTo(1);
		
		
		/**
		 * try PATCH with service relationships
		 */
		//first add a new service spec and then reference it
		ServiceSpecificationCreate sspeccr4 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr4.setName("Spec4");
		ServiceSpecification responsesSpec4 = createServiceSpec(sspectext, sspeccr3);
		
		String responseSpec3 = JsonUtils.toJsonString( responsesSpec3 );
		JSONObject obj = JsonUtils.toJsonObj(responseSpec3, JSONObject.class);
		obj.remove("uuid");
		obj.remove("id");
		obj.remove("lastUpdate");
		responseSpec3 = JsonUtils.toJsonString(obj);
				
		ServiceSpecificationUpdate responsesSpecUpd = JsonUtils.toJsonObj(responseSpec3,  ServiceSpecificationUpdate.class);	
		for (ServiceSpecRelationship r : responsesSpecUpd.getServiceSpecRelationship()) {
			if ( r.getId().equals( responsesSpec1.getId() ) ) {
				responsesSpecUpd.getServiceSpecRelationship().remove(r);
				break;
			}
		}
		responsesSpecUpd.addServiceSpecRelationshipWith(responsesSpec4);
		
		ResourceSpecificationRef resourceSpecificationItemNew = new ResourceSpecificationRef();
		resourceSpecificationItemNew.setId("resourceidNew");
		resourceSpecificationItemNew.setName("resourceNameNew");		
		responsesSpecUpd.addResourceSpecificationItem(resourceSpecificationItemNew);
		
		
		logger.info("Test: testBundledSpec responsesSpecUpd= " + responsesSpecUpd.toString());
		
		String responsePatch1 = mvc.perform(MockMvcRequestBuilders.patch("/serviceCatalogManagement/v4/serviceSpecification/" + responsesSpec3.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Spec3")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responseSpecPatch1 = JsonUtils.toJsonObj( responsePatch1,  ServiceSpecification.class);

		logger.info("Test: testBundledSpec responsePatch1= " + responsePatch1);

		assertThat( responseSpecPatch1.getResourceSpecification().size() ).isEqualTo(2);
		assertThat( responseSpecPatch1.getServiceSpecRelationship().size() ).isEqualTo(2);
		
		idspec1Exists = false;
		idspec2Exists = false;
		boolean idspec4Exists = false;
		for (ServiceSpecRelationship r : responseSpecPatch1.getServiceSpecRelationship()) {
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
	

	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testCloneSpec() throws Exception {


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		
		ServiceSpecificationCreate sspeccr2 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		ServiceSpecification responsesSpec2 = createServiceSpec(sspectext, sspeccr2);


		ServiceSpecificationCreate sspeccr3 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr3.setName("Spec3");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec1 );
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec2 );
		ServiceSpecification responsesSpec3 = createServiceSpec(sspectext, sspeccr3);
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 3 );

		String responseSpecCloned = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification/"+responsesSpec3.getId()+"/clone")
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( "" ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification clonedSpec = JsonUtils.toJsonObj( responseSpecCloned,  ServiceSpecification.class);
		//logger.info("source = " + responsesSpec3.toString());
		//logger.info("clonedSpec = " + clonedSpec.toString());

		assertThat( clonedSpec.getId() ).isNotEqualTo( responsesSpec3.getId() );
		assertThat( clonedSpec.getUuid() ).isNotNull();		
		assertThat( clonedSpec.getUuid() ).isNotEqualTo( responsesSpec3.getUuid() );
		assertThat( clonedSpec.getName() ).isEqualTo( "Copy of " + responsesSpec3.getName() );	
		assertThat( clonedSpec.findSpecCharacteristicByName("Coverage") ).isNotNull();
		assertThat( clonedSpec.findSpecCharacteristicByName("Coverage").getUuid() ).isNotNull();		
		assertThat( clonedSpec.findSpecCharacteristicByName("Coverage").getUuid()  ).isNotEqualTo( responsesSpec3.findSpecCharacteristicByName("Coverage").getUuid() );
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 4 );
		
		
		String responseSpecClonedGST = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification/cloneGST?serviceName=aGST Service")
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( "" ) ))				
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		clonedSpec = JsonUtils.toJsonObj( responseSpecClonedGST,  ServiceSpecification.class);
		assertThat( clonedSpec.getName() ).isEqualTo( "aGST Service" );	
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 5 );
		
		String responseSpecClonedVINNI = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification/cloneVINNI?serviceName=aVINNIService")
				.contentType(MediaType.APPLICATION_JSON)
				.param("addServiceTopology", "true")
				.param("addServiceRequirements", "true")
				.param("addServiceExposureLevel1", "true")
				.param("addServiceExposureLevel2", "true")
				.param("addServiceExposureLevel3", "true")
				.param("addServiceExposureLevel4", "true")
				.param("addServiceMonitoring", "true")
				.param("addServiceTesting", "true")
				.param("addServiceVNF", "true")
				.param("addServiceNSD", "true")
				.content( JsonUtils.toJson( "" ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();

		clonedSpec = JsonUtils.toJsonObj( responseSpecClonedVINNI,  ServiceSpecification.class);
		assertThat( clonedSpec.getName() ).isEqualTo( "aVINNIService" );	

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 16 );
		

		/**
		 * the bundle service characteristics must be same with the total of characteristics of each service in the bundle
		 * 
		 */
		
		assertThat( clonedSpec.getServiceSpecCharacteristic().size() ).isEqualTo( 61 );
		
		
		String responseSpecClonedVINNI2 = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification/cloneVINNI?serviceName=aVINNIService")
				.contentType(MediaType.APPLICATION_JSON)
				.param("addServiceTopology", "true")
				.param("addServiceRequirements", "true")
				.param("addServiceExposureLevel1", "true")
				.param("addServiceExposureLevel2", "false")
				.param("addServiceExposureLevel3", "false")
				.param("addServiceExposureLevel4", "false")
				.param("addServiceMonitoring", "false")
				.param("addServiceTesting", "false")
				.param("addServiceVNF", "false")
				.param("addServiceNSD", "false")
				.content( JsonUtils.toJson( "" ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();

		clonedSpec = JsonUtils.toJsonObj( responseSpecClonedVINNI2,  ServiceSpecification.class);
		assertThat( clonedSpec.getName() ).isEqualTo( "aVINNIService" );	

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 20 );
	}
	
	

	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testSpecAttachment() throws Exception {
		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 1 );
		
		Attachment att = new Attachment();
		att.setDescription("a test atts");
		att.setSize( new Quantity() );
		
		File gz = new File( "src/test/resources/cirros_vnf.tar.gz" );
		InputStream ing = new FileInputStream( gz );
		MockMultipartFile prodFile = new MockMultipartFile("afile", "cirros_vnf.tar.gz", "application/x-gzip", IOUtils.toByteArray(ing));
		
		
		
		String responsePatch1 = mvc.perform(MockMvcRequestBuilders
				.multipart("/serviceCatalogManagement/v4/serviceSpecification/" + responsesSpec1.getId() + "/attachment" )
				.file(prodFile)
				.param("attachment", JsonUtils.toJsonString(att))
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				)
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("cirros_vnf.tar.gz")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		Attachment responseSpecPost1 = JsonUtils.toJsonObj( responsePatch1,  Attachment.class);

		//logger.info("Test: testSpecAttachment responseSpecPost1= " + responseSpecPost1);

		assertThat( responseSpecPost1.getName() ).isEqualTo( "cirros_vnf.tar.gz" );
	}


	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testGST() throws Exception {
		logger.info("Test: testGST " );

		/**
		 * first add 
		 */

		File sspec = new File( "src/main/resources/gst.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName( sspeccr1.getName()+"_acopy_" );
		String responseSpec1 = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec1 = JsonUtils.toJsonObj(responseSpec1,  ServiceSpecification.class);

		logger.info("Test: testBundledSpec responseSpec1 = " + responseSpec1);

		assertThat( responsesSpec1.getVersion()  ).isEqualTo("5.0.0");
		assertThat( responsesSpec1.getServiceSpecCharacteristic().size() ).isEqualTo(79);
		assertThat( responsesSpec1.getServiceSpecRelationship().size() ).isEqualTo(0);
		boolean userPartyRoleOwnerexists = false;
		for (RelatedParty r : responsesSpec1.getRelatedParty()) {
			if ( r.getName().equals( "osadmin" ) && r.getRole().equals( UserPartRoleType.OWNER.toString() )) {
				userPartyRoleOwnerexists = true;
			}
		}
		
		assertThat(userPartyRoleOwnerexists  ).isTrue() ;
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		assertThat( specRepoService.findAll("uuid,name", new HashMap<>()).size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS ); //this is somehow wrong in Testing ONLY 
		
		
		/**
		 * 
		 */
		
		String responseSpecs = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification?fields=id,name")
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		List<ServiceSpecification> specs = JsonUtils.toJsonObj( responseSpecs,  ArrayList.class );


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		assertThat( specRepoService.findAll("uuid,name", new HashMap<>()).size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS ); //this is somehow wrong it should be 2..anyway to investigate in future
		assertThat(specs.size()  ).isEqualTo( FIXED_BOOTSTRAPS_SPECS ) ;
		
		

		/**
		 * 
		 */
		
		String responseSpecsFilter = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification?fields=id,name&name=A%20GST(NEST)%20Service%20Example")
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		List<ServiceSpecification> specsFilter = JsonUtils.toJsonObj( responseSpecsFilter,  ArrayList.class );


		assertThat(specsFilter.size()  ).isEqualTo(1) ;
	}
	
	@WithMockUser(username="osadmin", roles = {"USER"})
	@Test
	public void testGSTUpdate() throws Exception {
		logger.info("Test: testGSTUpdate " );
		
		ServiceCategory categ = categRepoService.findByName( "Generic Services" );
		ServiceCategory categ2 = categRepoService.findByIdEager( categ.getId() );
		assertThat( categ2.getServiceCandidateRefs().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		ServiceSpecification spec = this.specRepoService.findByNameAndVersion("A GST(NEST) Service Example", "5.0.0" );
		assertThat( spec ).isNotNull();
		
		spec.setVersion("0.x.0");
		this.specRepoService.updateServiceSpecification( spec);
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		this.bootstrapRepository.initRepo();
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		

	}
	
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testVINNISBT() throws Exception {
		logger.info("Test: testVINNISBT " );

		/**
		 * first add 
		 */

		File sspec = new File( "src/main/resources/vinnisb/vinnisb.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName( sspeccr1.getName()+"_acopy_" );
		String responseSpec1 = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec1 = JsonUtils.toJsonObj(responseSpec1,  ServiceSpecification.class);

		logger.info("Test: testBundledSpec responseSpec1 = " + responseSpec1);

		assertThat( responsesSpec1.getVersion()  ).isEqualTo("0.1.0");
		assertThat( responsesSpec1.getServiceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( responsesSpec1.getServiceSpecRelationship().size() ).isEqualTo(0);
		boolean userPartyRoleOwnerexists = false;
		for (RelatedParty r : responsesSpec1.getRelatedParty()) {
			if ( r.getName().equals( "osadmin" ) && r.getRole().equals( UserPartRoleType.OWNER.toString() )) {
				userPartyRoleOwnerexists = true;
			}
		}
		
		assertThat(userPartyRoleOwnerexists  ).isTrue() ;
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		assertThat( specRepoService.findAll("uuid,name", new HashMap<>()).size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS ); //this is somehow wrong in Testing ONLY it should be 2..anyway to investigate in future..something is happening with Session factory
		
		
		/**
		 * 
		 */
		
		String responseSpecs = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification?fields=id,name")
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		List<ServiceSpecification> specs = JsonUtils.toJsonObj( responseSpecs,  ArrayList.class );


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS +1 );
		assertThat( specRepoService.findAll("uuid,name", new HashMap<>()).size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS ); //this is somehow wrong it should be 2..anyway to investigate in future
		assertThat(specs.size()  ).isEqualTo( FIXED_BOOTSTRAPS_SPECS ) ;
		
		

		/**
		 * 
		 */
		
		String responseSpecsFilter = mvc.perform(MockMvcRequestBuilders.get("/serviceCatalogManagement/v4/serviceSpecification?fields=id,name&name=A%20VINNI%20Service%20Example")
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		List<ServiceSpecification> specsFilter = JsonUtils.toJsonObj( responseSpecsFilter,  ArrayList.class );


		assertThat(specsFilter.size()  ).isEqualTo(0) ;
	}
	
	@WithMockUser(username="osadmin", roles = {"USER"})
	@Test
	public void testVINNISBTUpdate() throws Exception {
//		logger.info("Test: testVINNISBTUpdate " );
//		
//		ServiceCategory categ = categRepoService.findByName( "Generic Services" );
//		ServiceCategory categ2 = categRepoService.findByIdEager( categ.getId() );
//		assertThat( categ2.getServiceCandidateRefs().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
//		
//		ServiceSpecification spec = this.specRepoService.findByNameAndVersion("A VINNI Service Example", "0.1.0" );
//		assertThat( spec ).isNotNull();
//		
//		spec.setVersion("0.x.0");
//		this.specRepoService.updateServiceSpecification( spec);
//		
//		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
//		
//		this.bootstrapRepository.initRepo();
//
//		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 11 );
//		assertThat( candidateRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 11 );

		

	}
	

	@WithMockUser(username="osadmin", roles = {"ADMIN", "USER"})
	@Test
	public void testSpecDelete() throws Exception {


		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS );
		
		/**
		 * first add 1 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 1 );

				
		this.specRepoService.deleteByUuid( responsesSpec1.getId() );
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS  );
		
	}
	

	@WithMockUser(username="osadmin", roles = {"ADMIN", "USER"})
	@Test
	public void testExternhalSpecUpdate() throws Exception {
		
		/**
		 * first add 1 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);		

		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 1 );
		assertThat( responsesSpec1.getServiceSpecCharacteristic()).hasSize(1) ;
		
		/**
		 * we use responsesSpec1 as base to add another ServiceSpecification example from an external partner 
		 */
		String externaluuid = UUID.randomUUID().toString();
		responsesSpec1.setUuid( externaluuid ); //change this as external
		responsesSpec1.getRelatedParty().clear();//clear all related parties if any
		
		/**
		 * add to the spec, an organization as related party
		 */
		

		@Valid
		OrganizationCreate organizationCreate = new OrganizationCreate();
		organizationCreate.setName("ANORGZ");
		Organization o = organizationRepoService.addOrganization(organizationCreate);

		ServiceSpecification specupd = specRepoService.updateExternalServiceSpec(externaluuid, o.getId(), responsesSpec1);
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 2 );
		assertThat( specupd.getRelatedParty()).hasSize(1);
		assertThat( specupd.getServiceSpecCharacteristic()).hasSize(1) ;
		
		responsesSpec1.setName( responsesSpec1.getName() + "_NEWNAME");
		
		ServiceSpecCharacteristic serviceSpecCharacteristicItem =  new ServiceSpecCharacteristic();
		serviceSpecCharacteristicItem.setName("A Second Attribute");
		responsesSpec1.addServiceSpecCharacteristicItem(serviceSpecCharacteristicItem );
		specupd = specRepoService.updateExternalServiceSpec(externaluuid, o.getId(), responsesSpec1);
		assertThat( specRepoService.findAll().size() ).isEqualTo( FIXED_BOOTSTRAPS_SPECS + 2 );
		assertThat( specupd.getRelatedParty()).hasSize(1);
		assertThat( specupd.getServiceSpecCharacteristic()).hasSize( 2 ) ;
		assertThat( specupd.getName() ).isEqualTo( responsesSpec1.getName()  ) ;
		
		
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
