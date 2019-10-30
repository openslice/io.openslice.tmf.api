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
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
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

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.pcm620.model.Quantity;
import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpec;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecUpdate;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.scm633.model.AttachmentRef;
import io.openslice.tmf.scm633.model.ResourceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecCharRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm633.reposervices.CandidateRepoService;
import io.openslice.tmf.scm633.reposervices.CatalogRepoService;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.so641.model.Note;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderItem;
import io.openslice.tmf.so641.model.ServiceRestriction;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class ServiceOrderIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( ServiceOrderIntegrationTest.class.getName());
	
    @Autowired
    private MockMvc mvc;

	@Autowired
	CatalogRepoService catalogRepoService;
	

	@Autowired
	CategoryRepoService categRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepoService;
	

	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;

	
	
	@Test
	public void _countDefaultProperties() {

		assertThat( serviceOrderRepoService.findAll().size() ).isEqualTo( 0 );
		
	}
	
	@Test
	public void testServiceOrderCreate() throws UnsupportedEncodingException, IOException, Exception {
	
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
		sspeccr3.setName("Spec3Bundled");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec1 );
		sspeccr3.addServiceSpecRelationshipWith( responsesSpec2 );		
		ServiceSpecification responsesSpec3 = createServiceSpec(sspectext, sspeccr3);
		
		ServiceOrderCreate servOrder = new ServiceOrderCreate();
		servOrder.setCategory("Experimentation");
		servOrder.setDescription("Experimentation Descr");
		servOrder.setRequestedStartDate( OffsetDateTime.now(ZoneOffset.UTC ).toString() );
		servOrder.setRequestedCompletionDate( OffsetDateTime.now(ZoneOffset.UTC ).toString() );
		
		Note noteItem = new Note();
		noteItem.text("test note");
		servOrder.addNoteItem(noteItem);
		
		ServiceOrderItem soi = new ServiceOrderItem();
		servOrder.getOrderItem().add(soi);
		
		ServiceRestriction serviceRestriction = new ServiceRestriction();
		ServiceSpecificationRef aServiceSpecificationRef = new ServiceSpecificationRef();
		aServiceSpecificationRef.setId(responsesSpec3.getId() );
		aServiceSpecificationRef.setName(responsesSpec3.getName());
		
		serviceRestriction.setServiceSpecification(aServiceSpecificationRef );
		soi.setService(serviceRestriction );
		
		String responseSorder = mvc.perform(MockMvcRequestBuilders.post("/serviceOrdering/v4/serviceOrder")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( servOrder ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderCreate = " + responseSorder);
		ServiceOrder responseSO = toJsonObj(responseSorder,  ServiceOrder.class);

		assertThat( responseSO.getCategory()  ).isEqualTo( "Experimentation" );
		assertThat( responseSO.getDescription()  ).isEqualTo( "Experimentation Descr" );
		assertThat( responseSO.getRequestedStartDate() ).isNotNull();
		assertThat( responseSO.getRequestedCompletionDate() ).isNotNull();
		
		assertThat( responseSO.getOrderItem().size()  ).isEqualTo( 1 );
		responseSO.getOrderItem().stream().forEach( 
				soiElement -> {
					assertThat( soiElement.getService().getServiceSpecification() ).isNotNull();
					assertThat( soiElement.getService().getServiceSpecification().getName() ).isEqualTo("Spec3Bundled");
					assertThat( soiElement.getService().getSupportingResource().size() ).isEqualTo( 1 );
					assertThat( soiElement.getService().getSupportingService().size() ).isEqualTo( 2 );
					assertThat( soiElement.getService().getServiceRelationship().size() ).isEqualTo( 2 );					
				}				
		);
		assertThat( responseSO.getNote().size()  ).isEqualTo( 1 );
		

		assertThat( serviceOrderRepoService.findAll().size() ).isEqualTo( 1 );
		
	}
		
	
	private ServiceSpecification createServiceSpec(String sspectext, ServiceSpecificationCreate sspeccr1) throws Exception{
		
		String responseSpec = mvc.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
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