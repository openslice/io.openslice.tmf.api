package io.openslice.services.api;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.scm.OpenAPISpringBoot;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceCatalogCreate;
import io.openslice.tmf.scm.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryRef;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.sc.reposervices.CandidateRepoService;
import io.openslice.tmf.scm.sc.reposervices.CatalogRepoService;
import io.openslice.tmf.scm.sc.reposervices.CategoryRepoService;
import io.openslice.tmf.scm.sc.reposervices.ServiceSpecificationRepoService;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
@AutoConfigureTestDatabase
@AutoConfigureMockMvc 
@TestPropertySource(
		  locations = "classpath:application-testing.yml")
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
	 
	 static <T> T toJsonObj(InputStream content, Class<T> valueType)  throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.readValue( content, valueType);
	    }
	
}