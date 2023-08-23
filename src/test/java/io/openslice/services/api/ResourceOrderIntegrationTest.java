package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
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
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.ri639.model.Characteristic;
import io.openslice.tmf.ri639.model.ResourceRefOrValue;
import io.openslice.tmf.ri639.model.ResourceRelationship;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;
import io.openslice.tmf.ro652.model.ExternalId;
import io.openslice.tmf.ro652.model.ResourceOrder;
import io.openslice.tmf.ro652.model.ResourceOrderCreate;
import io.openslice.tmf.ro652.model.ResourceOrderItem;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)

@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class ResourceOrderIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(ResourceOrderIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	ResourceSpecificationRepoService specRepoService;

	@Autowired
	ResourceRepoService resourceRepoService;

	@WithMockUser(username = "osadmin", roles = { "USER", "ADMIN" })
	@Test

	public void testResourceOrderCreate() throws UnsupportedEncodingException, IOException, Exception {

		File sspec = new File("src/main/resources/resourceSpecifications/OSMTenantResourceSpecification.json");
		InputStream in = new FileInputStream(sspec);
		String sspectext = IOUtils.toString(in, "UTF-8");

		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj(sspectext, ResourceSpecificationCreate.class);
		ResourceSpecification responsesSpec1 = createResourceSpec(sspeccr1);

//		resourceOrderItem id, action
//		relatedParty id, @referredType
//		note text, id
//		orderRelationship id, relationshipType
//		orderItem.resource.resourceCharacteristic name
//		orderItem.orderItemRelationship orderItem
//		orderItem.orderItemRelationship.orderItem itemId
//		appointment id
//		externalReference name
		
		ResourceOrderCreate resorder = new ResourceOrderCreate();
	
	
		resorder
			.name("MANOProviderResource")
			.category("MANOProvider")
			.description("Experimentation Descr")
			.addExternalReferenceItem( new ExternalId() )			
			.requestedStartDate(OffsetDateTime.now(ZoneOffset.UTC).toString())
			.requestedCompletionDate(OffsetDateTime.now(ZoneOffset.UTC).toString());

		
		ResourceOrderItem oItem = new ResourceOrderItem();
		oItem.setId( "xxxx" );
		oItem.setAction("add");
		

		ResourceSpecificationRef resSpecRef = new ResourceSpecificationRef();
		resSpecRef.setId( responsesSpec1.getId() );
		resSpecRef.setName( responsesSpec1.getName() );
		

		Characteristic charitem = new Characteristic();
		charitem
			.name("SupportedManoPlatform" ).value( new Any( "OSMvTEN", "OSMvTEN" ))
			.name("Username" ).value( new Any( "testakis", "testakis" ));
		
		Set<ResourceRelationship> relationships = new HashSet<>();
		ResourceRelationship erel = new ResourceRelationship();
		erel.setRelationshipType("bubndled");
		relationships.add(erel );
		
		ResourceRefOrValue resrc = new ResourceRefOrValue();
		
		
		resrc
			.addResourceCharacteristicItem(charitem)
			.resourceSpecification(resSpecRef)
			.resourceRelationship( relationships );
		oItem.setResourceRefOrValue( resrc  );

		resorder.addOrderItemItem(oItem);

		logger.info("testResourceOrderCreate Req= " + JsonUtils.toJsonString( resorder ));
		// @formatter:off
		String responseSorder = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourceOrderingManagement/v4/resourceOrder")
				.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( resorder )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		// @formatter:on
		logger.info("testResourceOrderCreate = " + responseSorder);
		
		

		ResourceOrder responseRO = JsonUtils.toJsonObj(responseSorder, ResourceOrder.class);

		assertThat( responseRO.getRequestedCompletionDate()).isNotNull();
		assertThat( responseRO.getOrderItem().stream().findFirst().get() ).isNotNull();
		assertThat( responseRO.getOrderItem().stream().findFirst().get().getResource().getId() ).isNotNull();
		assertThat( responseRO.getOrderItem().stream().findFirst().get().getResource().getName() ).isEqualTo( "OSM Tenant" ) ;
	}

	private ResourceSpecification createResourceSpec(ResourceSpecificationUpdate sspeccr1) throws Exception {

		URI url = new URI("/resourceCatalogManagement/v4/resourceSpecification");
		if (sspeccr1 instanceof PhysicalResourceSpecificationUpdate) {
			url = new URI("/resourceCatalogManagement/v4/resourceSpecification");
		}
		String responseSpec = mvc
				.perform(MockMvcRequestBuilders.post(url).with(SecurityMockMvcRequestPostProcessors.csrf())
						.contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(sspeccr1)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		ResourceSpecification responsesSpec1;
		if (sspeccr1 instanceof PhysicalResourceSpecificationUpdate) {
			responsesSpec1 = JsonUtils.toJsonObj(responseSpec, PhysicalResourceSpecification.class);
		} else {
			responsesSpec1 = JsonUtils.toJsonObj(responseSpec, LogicalResourceSpecification.class);
		}

//		logger.info("createResourceSpec = " + responseSpec);
		return responsesSpec1;
	}

}
