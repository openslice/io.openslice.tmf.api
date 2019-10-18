package io.openslice.services.api;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.OpenAPISpringBoot;
import io.openslice.tmf.scm.model.Any;
import io.openslice.tmf.scm.model.AttachmentRef;
import io.openslice.tmf.scm.model.EValueType;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceCatalogCreate;
import io.openslice.tmf.scm.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.ServiceSpecCharRelationship;
import io.openslice.tmf.scm.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm.model.ServiceSpecRelationship;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm.sc.reposervices.CandidateRepoService;
import io.openslice.tmf.scm.sc.reposervices.CatalogRepoService;
import io.openslice.tmf.scm.sc.reposervices.CategoryRepoService;
import io.openslice.tmf.scm.sc.reposervices.ServiceSpecificationRepoService;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class InMemoryDBIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( InMemoryDBIntegrationTest.class.getName());
	
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
	
	
	@Test
	public void whenFindByName_thenReturnVxF() {
//	    // given
//
//		VxFMetadata vxf = new VxFMetadata();
//		vxf.setName("aTestVxF");
//		vxfService.updateProductInfo(vxf);
//	 
//	    // when
//	    VxFMetadata found = vxfService.getVxFByName(vxf.getName());
//	 
//	    // then
//	    assertThat(found.getName()).isEqualTo( vxf.getName() );
	}
	
	@Test
	public void _countDefaultProperties() {

		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 1 );
		assertThat( categRepoService.findAll().size() ).isEqualTo( 1 );
		assertThat( candidateRepoService.findAll().size() ).isEqualTo( 1 );
		assertThat( specRepoService.findAll().size() ).isEqualTo( 1 );
		
	}
	
	
	@Test
	public void addCatalogAddCategory() throws Exception {
		File scatalog = new File( "src/test/resources/testServiceCatalog.txt" );
		InputStream in = new FileInputStream( scatalog );
		String resvxf = IOUtils.toString(in, "UTF-8");
		
		ServiceCatalogCreate scc = toJsonObj( resvxf,  ServiceCatalogCreate.class);
		
		String response = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalog")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( scc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Catalog")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 2 );
		
		ServiceCatalog responsesCatalog = toJsonObj(response,  ServiceCatalog.class);
		assertThat( responsesCatalog.getName() ).isEqualTo( "Test Catalog" );
		
		assertThat( responsesCatalog.getCategoryObj().size()).isEqualTo(0);
		
		
		/**
		 * add category
		 */
		
		File scat = new File( "src/test/resources/testServiceCategory.txt" );
		in = new FileInputStream( scat );
		String sc = IOUtils.toString(in, "UTF-8");
		
		ServiceCategoryCreate scategcreate = toJsonObj( sc,  ServiceCategoryCreate.class);
		
		response = mvc.perform(MockMvcRequestBuilders.post("/serviceCategory")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( scategcreate ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Category 2")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		assertThat( categRepoService.findAll().size() ).isEqualTo( 2 );
		
		ServiceCategory responsesCateg = toJsonObj(response,  ServiceCategory.class);
		assertThat( responsesCateg.getName() ).isEqualTo( "Test Category 2" );
		
		
		/**
		 * update catalog with category
		 */
		ServiceCatalogUpdate scu = new ServiceCatalogUpdate();
		scu.setName( responsesCatalog.getName() );
		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId( responsesCateg.getId() );
		
		scu.addCategoryItem(categoryItem);
		 response = mvc.perform(MockMvcRequestBuilders.patch("/serviceCatalog/" + responsesCatalog.getId() )
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( scu ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Catalog")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		
		assertThat( catalogRepoService.findAll().size() ).isEqualTo( 2 );
			
		responsesCatalog = toJsonObj(response, ServiceCatalog.class);
		assertThat(responsesCatalog.getName()).isEqualTo("Test Catalog");


		assertThat( responsesCatalog.getCategoryObj().size()).isEqualTo(1);
		assertThat( responsesCatalog.getCategoryRefs().get(0).getName() ).isEqualTo(  "Test Category 2" );
		
		/**
		 * Service Spec
		 */
		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		
		 response = mvc.perform(MockMvcRequestBuilders.post("/serviceSpecification")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( sspeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( 2 );
		ServiceSpecification responsesSpec = toJsonObj(response,  ServiceSpecification.class);
		assertThat( responsesSpec.getName() ).isEqualTo( "Test Spec" );

		assertThat( responsesSpec.getServiceSpecCharacteristic().size() ).isEqualTo(1);
		assertThat( responsesSpec.getServiceSpecCharacteristic().toArray( new ServiceSpecCharacteristic[0] )[0].getServiceSpecCharacteristicValue().size()  ).isEqualTo(1);
		
	}
	
	
	@Test
	public void testSpecAttributesUpdate() throws Exception {
		logger.info("Test: testSpecAttributesUpdate");
		/**
		 * Service Spec
		 */
		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		
		AttachmentRef attachmentItem = new AttachmentRef();
		attachmentItem.setId( "a-ref-id" );
		attachmentItem.setDescription("an attachment");
		attachmentItem.setUrl("a url");
		sspeccr.addAttachmentItem(attachmentItem);
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/serviceSpecification")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( sspeccr ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec = toJsonObj(responseSpec,  ServiceSpecification.class);
		logger.info("Test: testSpecAttachments response = " + responseSpec);
		assertThat( responsesSpec.getName() ).isEqualTo( "Test Spec" );
		assertThat( responsesSpec.getAttachment().size() ).isEqualTo( 1 );
		
		//make it now as a ServiceSpecificationUpdate, no id, uuid and lastUpdate
		JSONObject obj = toJsonObj(responseSpec, JSONObject.class);
		obj.remove("uuid");
		obj.remove("id");
		obj.remove("lastUpdate");
		responseSpec = toJsonString(obj);
				
		ServiceSpecificationUpdate responsesSpecUpd = toJsonObj(responseSpec,  ServiceSpecificationUpdate.class);
		responsesSpecUpd.setName( "Test Spec a attr" );
		responsesSpecUpd.setVersion("2.x");
		ServiceSpecCharacteristic spechar = new ServiceSpecCharacteristic();
		spechar.setName("A new characteristic");
		ServiceSpecCharacteristicValue sv = new ServiceSpecCharacteristicValue();
		sv.setValue( new Any("1" ,"a first value") );
		sv.setValueType( EValueType.LONGTEXT.getValue());
		spechar.getServiceSpecCharacteristicValue().add( sv );
		responsesSpecUpd.getServiceSpecCharacteristic().add(spechar );
				
		String response2 = mvc.perform(MockMvcRequestBuilders.patch("/serviceSpecification/" + responsesSpec.getId() )
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec a attr")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec2 = toJsonObj(response2,  ServiceSpecification.class);
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
		responsesSpecUpd = toJsonObj(responseSpec,  ServiceSpecificationUpdate.class);
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
		
		response2 = mvc.perform(MockMvcRequestBuilders.patch("/serviceSpecification/" + responsesSpec.getId() )
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Test Spec")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("Test: testSpecAttachments responsesSpec2 patch2= " + response2.toString());

		responsesSpec2 = toJsonObj(response2,  ServiceSpecification.class);

		
		
		assertThat( specRepoService.findAll().size() ).isEqualTo( 2 );
		
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
		


		assertThat( specRepoService.findAll().size() ).isEqualTo( 2 );
		
	}
	
	
	private ServiceSpecification createServiceSpec(String sspectext, ServiceSpecificationCreate sspeccr1) throws Exception{
		
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/serviceSpecification")
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
	
	@Test
	public void testBundledSpec() throws Exception {
		logger.info("Test: testBundledSpec " );

		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		
		ServiceSpecificationCreate sspeccr2 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		ServiceSpecification responsesSpec2 = createServiceSpec(sspectext, sspeccr2);


		ServiceSpecificationCreate sspeccr3 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr3.setName("Spec3");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec1 );
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec2 );
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
		
		/**
		 * try PATCH with service relationships
		 */
		//first add a new service spec and then reference it
		ServiceSpecificationCreate sspeccr4 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr4.setName("Spec4");
		ServiceSpecification responsesSpec4 = createServiceSpec(sspectext, sspeccr3);
		
		String responseSpec3 = toJsonString( responsesSpec3 );
		JSONObject obj = toJsonObj(responseSpec3, JSONObject.class);
		obj.remove("uuid");
		obj.remove("id");
		obj.remove("lastUpdate");
		responseSpec3 = toJsonString(obj);
				
		ServiceSpecificationUpdate responsesSpecUpd = toJsonObj(responseSpec3,  ServiceSpecificationUpdate.class);	
		for (ServiceSpecRelationship r : responsesSpecUpd.getServiceSpecRelationship()) {
			if ( r.getId().equals( responsesSpec1.getId() ) ) {
				responsesSpecUpd.getServiceSpecRelationship().remove(r);
				break;
			}
		}
		responsesSpecUpd.addServiceSpecRelationshipWith(responsesSpec4);
		logger.info("Test: testBundledSpec responsesSpecUpd= " + responsesSpecUpd.toString());
		
		String responsePatch1 = mvc.perform(MockMvcRequestBuilders.patch("/serviceSpecification/" + responsesSpec3.getId() )
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( responsesSpecUpd ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Spec3")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responseSpecPatch1 = toJsonObj( responsePatch1,  ServiceSpecification.class);

		logger.info("Test: testBundledSpec responsePatch1= " + responsePatch1);

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
		


		assertThat( specRepoService.findAll().size() ).isEqualTo( 5 );
		
	}
	

	@Test
	public void testCloneSpec() throws Exception {


		assertThat( specRepoService.findAll().size() ).isEqualTo( 1 );
		
		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/test/resources/testServiceSpec.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");

		
		ServiceSpecificationCreate sspeccr1 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		
		ServiceSpecificationCreate sspeccr2 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		ServiceSpecification responsesSpec2 = createServiceSpec(sspectext, sspeccr2);


		ServiceSpecificationCreate sspeccr3 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		sspeccr3.setName("Spec3");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec1 );
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec2 );
		ServiceSpecification responsesSpec3 = createServiceSpec(sspectext, sspeccr3);
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( 4 );

		String responseSpecCloned = mvc.perform(MockMvcRequestBuilders.post("/serviceSpecification/"+responsesSpec3.getId()+"/clone")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification clonedSpec = toJsonObj( responseSpecCloned,  ServiceSpecification.class);
		logger.info("source = " + responsesSpec3.toString());
		logger.info("clonedSpec = " + clonedSpec.toString());

		assertThat( clonedSpec.getId() ).isNotEqualTo( responsesSpec3.getId() );
		assertThat( clonedSpec.getUuid() ).isNotNull();		
		assertThat( clonedSpec.getUuid() ).isNotEqualTo( responsesSpec3.getUuid() );
		assertThat( clonedSpec.getName() ).isEqualTo( "Copy of " + responsesSpec3.getName() );	
		assertThat( clonedSpec.findSpecCharacteristicByName("Coverage") ).isNotNull();
		assertThat( clonedSpec.findSpecCharacteristicByName("Coverage").getUuid() ).isNotNull();		
		assertThat( clonedSpec.findSpecCharacteristicByName("Coverage").getUuid()  ).isNotEqualTo( responsesSpec3.findSpecCharacteristicByName("Coverage").getUuid() );
		

		assertThat( specRepoService.findAll().size() ).isEqualTo( 5 );
		
	}
	
	
	
	@Test
	public void testSpecRelatedParty() throws Exception {
		//fail("Not yet implemented");
	}

	
	@Test
	public void testGST() throws Exception {
		logger.info("Test: testBundledSpec " );

		/**
		 * first add 2 specs
		 */

		File sspec = new File( "src/main/resources/gst.json" );
		InputStream in = new FileInputStream( sspec );
		String sspectext = IOUtils.toString(in, "UTF-8");
		
		ServiceSpecificationCreate sspeccr1 = toJsonObj( sspectext,  ServiceSpecificationCreate.class);
		String responseSpec1 = mvc.perform(MockMvcRequestBuilders.post("/serviceSpecification")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( sspeccr1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec1 = toJsonObj(responseSpec1,  ServiceSpecification.class);

		logger.info("Test: testBundledSpec responseSpec1 = " + responseSpec1);

		assertThat( responsesSpec1.getVersion()  ).isEqualTo("0.1.0");
		assertThat( responsesSpec1.getServiceSpecCharacteristic().size() ).isEqualTo(67);
		assertThat( responsesSpec1.getServiceSpecRelationship().size() ).isEqualTo(0);
		
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