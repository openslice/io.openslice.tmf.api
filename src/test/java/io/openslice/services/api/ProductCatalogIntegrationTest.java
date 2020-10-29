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
import java.util.UUID;

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

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.pcm620.model.BundledProductOffering;
import io.openslice.tmf.pcm620.model.Catalog;
import io.openslice.tmf.pcm620.model.CatalogCreate;
import io.openslice.tmf.pcm620.model.CatalogUpdate;
import io.openslice.tmf.pcm620.model.Category;
import io.openslice.tmf.pcm620.model.CategoryCreate;
import io.openslice.tmf.pcm620.model.CategoryRef;
import io.openslice.tmf.pcm620.model.ProductOffering;
import io.openslice.tmf.pcm620.model.ProductOfferingCreate;
import io.openslice.tmf.pcm620.model.ProductOfferingPriceCreate;
import io.openslice.tmf.pcm620.model.ProductOfferingPriceRef;
import io.openslice.tmf.pcm620.model.ProductOfferingTerm;
import io.openslice.tmf.pcm620.model.ProductSpecificationCharacteristicValue;
import io.openslice.tmf.pcm620.model.ProductSpecificationCharacteristicValueUse;
import io.openslice.tmf.pcm620.model.ProductSpecificationCreate;
import io.openslice.tmf.pcm620.model.ProductSpecificationRef;
import io.openslice.tmf.pcm620.model.ResourceCandidateRef;
import io.openslice.tmf.pcm620.model.SLARef;
import io.openslice.tmf.pcm620.model.ServiceCandidateRef;
import io.openslice.tmf.pcm620.reposervices.ProductCatalogRepoService;
import io.openslice.tmf.pcm620.reposervices.ProductCategoryRepoService;
import io.openslice.tmf.pcm620.reposervices.ProductOfferingPriceRepoService;
import io.openslice.tmf.pcm620.reposervices.ProductOfferingRepoService;
import io.openslice.tmf.pcm620.reposervices.ProductSpecificationRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class ProductCatalogIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(ProductCatalogIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;

	@Autowired
	ProductCatalogRepoService catalogRepoService;

	@Autowired
	ProductCategoryRepoService categRepoService;

	@Autowired
	ProductOfferingRepoService productOfferingRepoService;
	

	@Autowired
	ProductOfferingPriceRepoService productOfferingPriceRepoService;


	@Autowired
	ProductSpecificationRepoService productSpecificationRepoService;
	
	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(username = "osadmin", roles = { "ADMIN", "USER" })
	@Test
	public void testProductCatalog() throws Exception {
		File scatalog = new File("src/test/resources/testProductCatalog.txt");
		InputStream in = new FileInputStream(scatalog);
		String resvxf = IOUtils.toString(in, "UTF-8");

		CatalogCreate scc = toJsonObj(resvxf, CatalogCreate.class);
		scc.setVersion("1.1");
		String response = mvc
				.perform(MockMvcRequestBuilders.post("/productCatalogManagement/v4/catalog")
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(toJson(scc)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("name", is("Test Product Catalog"))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(catalogRepoService.findAll().size()).isEqualTo(1);

		Catalog responsesCatalog = toJsonObj(response, Catalog.class);
		assertThat(responsesCatalog.getName()).isEqualTo("Test Product Catalog");
		assertThat(responsesCatalog.getVersion()).isEqualTo("1.1");

		assertThat(responsesCatalog.getCategoryObj().size()).isEqualTo(0);

		/**
		 * add category
		 */

		File scat = new File("src/test/resources/testProductCategory.txt");
		in = new FileInputStream(scat);
		String sc = IOUtils.toString(in, "UTF-8");

		CategoryCreate scategcreate = toJsonObj(sc, CategoryCreate.class);
		scategcreate.setVersion("1.2");

		response = mvc
				.perform(MockMvcRequestBuilders.post("/productCatalogManagement/v4/category")
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(toJson(scategcreate)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("name", is("Test Product Category 2"))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(categRepoService.findAll().size()).isEqualTo(1);

		Category responsesCateg = toJsonObj(response, Category.class);
		assertThat(responsesCateg.getName()).isEqualTo("Test Product Category 2");
		assertThat(responsesCateg.getVersion()).isEqualTo("1.2");

		/**
		 * update catalog with category
		 */
		CatalogUpdate scu = new CatalogUpdate();
		scu.setName("A new Name");
		scu.setVersion("1.3");
		CategoryRef categoryItem = new CategoryRef();
		categoryItem.setId(responsesCateg.getId());

		scu.addCategoryItem(categoryItem);
		response = mvc
				.perform(
						MockMvcRequestBuilders.patch("/productCatalogManagement/v4/catalog/" + responsesCatalog.getId())
								.with(SecurityMockMvcRequestPostProcessors.csrf())
								.contentType(MediaType.APPLICATION_JSON).content(toJson(scu)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("name", is("A new Name"))).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();

		assertThat(catalogRepoService.findAll().size()).isEqualTo(1);

		responsesCatalog = toJsonObj(response, Catalog.class);
		assertThat(responsesCatalog.getName()).isEqualTo("A new Name");
		assertThat(responsesCatalog.getVersion()).isEqualTo("1.3");

		assertThat(responsesCatalog.getCategoryObj().size()).isEqualTo(1);
		assertThat(responsesCatalog.getCategoryRefs().get(0).getName()).isEqualTo("Test Product Category 2");

		/**
		 * Prudct Offering
		 */
		File sspec = new File("src/test/resources/testProductOfferingSpec.json");
		in = new FileInputStream(sspec);
		String sspectext = IOUtils.toString(in, "UTF-8");

		ProductOfferingCreate sspeccr = toJsonObj(sspectext, ProductOfferingCreate.class);

		ProductOfferingPriceRef productOfferingPriceItem = new ProductOfferingPriceRef();
		productOfferingPriceItem.setId(UUID.randomUUID().toString());
		productOfferingPriceItem.setName("a productOfferingPriceItem");
		sspeccr.addProductOfferingPriceItem(productOfferingPriceItem);

		ProductSpecificationCharacteristicValueUse prodSpecCharValueUseItem = new ProductSpecificationCharacteristicValueUse();
		prodSpecCharValueUseItem.setName("A test prodSpecCharValueUseItem");
		ProductSpecificationCharacteristicValue productSpecCharacteristicValueItem = new ProductSpecificationCharacteristicValue();
		productSpecCharacteristicValueItem.setUnitOfMeasure("meters");
		prodSpecCharValueUseItem.addProductSpecCharacteristicValueItem(productSpecCharacteristicValueItem);
		sspeccr.addProdSpecCharValueUseItem(prodSpecCharValueUseItem);

		ServiceCandidateRef serviceCandidateRef = new ServiceCandidateRef();
		serviceCandidateRef.setId(UUID.randomUUID().toString());
		serviceCandidateRef.setName("a serviceCandidateRef");
		sspeccr.setServiceCandidate(serviceCandidateRef);

		ResourceCandidateRef aResourceCandidateRef = new ResourceCandidateRef();
		aResourceCandidateRef.setId(UUID.randomUUID().toString());
		aResourceCandidateRef.setName("a ResourceCandidateRef");
		sspeccr.setResourceCandidate(aResourceCandidateRef);

		SLARef aSLARef = new SLARef();
		aSLARef.setId(UUID.randomUUID().toString());
		aSLARef.setName("a SLARef");
		sspeccr.setServiceLevelAgreement(aSLARef);

		ProductOfferingTerm aProductOfferingTerm = new ProductOfferingTerm();
		aProductOfferingTerm.setName("a ProductOfferingTerm");
		sspeccr.addProductOfferingTermItem(aProductOfferingTerm);

		BundledProductOffering aBundledProductOffering = new BundledProductOffering();
		aBundledProductOffering.setId(UUID.randomUUID().toString());
		aBundledProductOffering.setName("a BundledProductOffering");
		sspeccr.addBundledProductOfferingItem(aBundledProductOffering);

		ProductSpecificationRef aProductSpecificationRef = new ProductSpecificationRef();
		aProductSpecificationRef.setId(UUID.randomUUID().toString());
		aProductSpecificationRef.setName("a aProductSpecificationRef");
		sspeccr.setProductSpecification(aProductSpecificationRef);

		// byte[] s = toJson( sspeccr );

		response = mvc
				.perform(MockMvcRequestBuilders.post("/productCatalogManagement/v4/productOffering")
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(toJson(sspeccr)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("name", is("Test Product offering Spec"))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
		assertThat(productOfferingRepoService.findAll().size()).isEqualTo(1);
		ProductOffering responsesSpec = toJsonObj(response, ProductOffering.class);
		assertThat(responsesSpec.getName()).isEqualTo("Test Product offering Spec");
		assertThat(responsesSpec.getProductOfferingPrice().size()).isEqualTo(1);
		assertThat(responsesSpec.getProdSpecCharValueUse().size()).isEqualTo(1);
		assertThat(responsesSpec.getProdSpecCharValueUse().toArray(new ProductSpecificationCharacteristicValueUse[0])[0]
				.getProductSpecCharacteristicValue().size()).isEqualTo(1);

	}
	
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testProductOfferingPrice() throws Exception {
		File testProductOfferingPrice = new File( "src/test/resources/testProductOfferingPrice.txt" );
		InputStream in = new FileInputStream( testProductOfferingPrice );
		String resvxf = IOUtils.toString(in, "UTF-8");
		
		ProductOfferingPriceCreate scc = toJsonObj( resvxf,  ProductOfferingPriceCreate.class);
		scc.setVersion("1.1");
		String response = mvc.perform(MockMvcRequestBuilders.post("/productCatalogManagement/v4/productOfferingPrice")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( scc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Recurring Charge for Business Firewall")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( productOfferingPriceRepoService.findAll().size() ).isEqualTo( 1 );
		
		
	}

	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void testProductSpec() throws Exception {
		File testProductOfferingPrice = new File( "src/test/resources/testProductSpec.json" );
		InputStream in = new FileInputStream( testProductOfferingPrice );
		String resvxf = IOUtils.toString(in, "UTF-8");
		
		ProductSpecificationCreate scc = toJsonObj( resvxf,  ProductSpecificationCreate.class);
		scc.setVersion("1.1");
		String response = mvc.perform(MockMvcRequestBuilders.post("/productCatalogManagement/v4/productSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( scc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("Acme Firepower NGFW")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( productSpecificationRepoService.findAll().size() ).isEqualTo( 1 );
		
		
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

	static <T> T toJsonObj(String content, Class<T> valueType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.readValue(content, valueType);
	}

	static <T> T toJsonObj(InputStream content, Class<T> valueType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.readValue(content, valueType);
	}
}
