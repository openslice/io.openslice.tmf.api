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
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

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
import org.springframework.security.web.FilterChainProxy;
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
import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.common.model.service.Note;
import io.openslice.tmf.common.model.service.ServiceRef;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
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
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceOrderRef;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.model.ServiceOrderItem;
import io.openslice.tmf.so641.model.ServiceOrderStateType;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.model.ServiceRestriction;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class ServiceOrderIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderIntegrationTest.class.getName());

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

	@Autowired
	ServiceRepoService serviceRepoService;

	@Autowired
	private WebApplicationContext context;
	

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).
				apply(springSecurity(springSecurityFilterChain)).build();
	}

	@Test
	public void _countDefaultProperties() {

		assertThat(serviceOrderRepoService.findAll().size()).isEqualTo(0);

	}

	@WithMockUser(username="osadmin", roles = {"USER"})
	@Test
	public void testServiceOrderCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {

		/**
		 * first add 2 specs
		 */

		File sspec = new File("src/test/resources/testServiceSpec.json");
		InputStream in = new FileInputStream(sspec);
		String sspectext = IOUtils.toString(in, "UTF-8");

		ServiceSpecificationCreate sspeccr1 = toJsonObj(sspectext, ServiceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ServiceSpecification responsesSpec1 = createServiceSpec(sspectext, sspeccr1);

		// service 2 is an RFS
		ServiceSpecificationCreate sspeccr2 = toJsonObj(sspectext, ServiceSpecificationCreate.class);
		sspeccr2.setName("Spec2");
		ResourceSpecificationRef resourceSpecificationItem = new ResourceSpecificationRef();
		resourceSpecificationItem.setId("resourceid");
		resourceSpecificationItem.setName("resourceName");
		sspeccr2.addResourceSpecificationItem(resourceSpecificationItem);
		ServiceSpecification responsesSpec2 = createServiceSpec(sspectext, sspeccr2);
		/**
		 * add them as bundle
		 */

		ServiceSpecificationCreate sspeccr3 = toJsonObj(sspectext, ServiceSpecificationCreate.class);
		sspeccr3.setName("BundleExampleSpec");
		sspeccr3.isBundle(true);
		sspeccr3.addServiceSpecRelationshipWith(responsesSpec1);
		sspeccr3.addServiceSpecRelationshipWith(responsesSpec2);
		ServiceSpecification responsesSpec3 = createServiceSpec(sspectext, sspeccr3);

		ServiceOrderCreate servOrder = new ServiceOrderCreate();
		servOrder.setCategory("Experimentation");
		servOrder.setDescription("Experimentation Descr");
		servOrder.setRequestedStartDate(OffsetDateTime.now(ZoneOffset.UTC).toString());
		servOrder.setRequestedCompletionDate(OffsetDateTime.now(ZoneOffset.UTC).toString());

		Note noteItem = new Note();
		noteItem.text("test note");
		servOrder.addNoteItem(noteItem);

		ServiceOrderItem soi = new ServiceOrderItem();
		servOrder.getOrderItem().add(soi);
		soi.setState(ServiceOrderStateType.ACKNOWLEDGED);

		ServiceRestriction serviceRestriction = new ServiceRestriction();
		ServiceSpecificationRef aServiceSpecificationRef = new ServiceSpecificationRef();
		aServiceSpecificationRef.setId(responsesSpec3.getId());
		aServiceSpecificationRef.setName(responsesSpec3.getName());

		serviceRestriction.setServiceSpecification(aServiceSpecificationRef);
		soi.setService(serviceRestriction);

		String responseSorder = mvc
				.perform(MockMvcRequestBuilders.post("/serviceOrdering/v4/serviceOrder")
						.contentType(MediaType.APPLICATION_JSON).content(toJson(servOrder)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderCreate = " + responseSorder);
		ServiceOrder responseSO = toJsonObj(responseSorder, ServiceOrder.class);

		logger.info("BundleExampleSpec  = " + toJsonString(responsesSpec3));
		logger.info("responsesSpec1 = " + toJsonString(responsesSpec1));
		logger.info("responsesSpec2 = " + toJsonString(responsesSpec2));
		logger.info("testServiceOrderCreate = " + toJsonString(responseSO));

		assertThat(responseSO.getCategory()).isEqualTo("Experimentation");
		assertThat(responseSO.getDescription()).isEqualTo("Experimentation Descr");
		assertThat(responseSO.getRequestedStartDate()).isNotNull();
		assertThat(responseSO.getRequestedCompletionDate()).isNotNull();

		assertThat(responseSO.getOrderItem().size()).isEqualTo(1);
		responseSO.getOrderItem().stream().forEach(soiElement -> {
			assertThat(soiElement.getState()).isEqualTo(ServiceOrderStateType.ACKNOWLEDGED);
			assertThat(soiElement.getService().getServiceSpecification()).isNotNull();
			assertThat(soiElement.getService().getServiceSpecification().getName()).isEqualTo("BundleExampleSpec");
		});
		assertThat(responseSO.getNote().size()).isEqualTo(1);

		boolean userPartyRoleexists = false;
		for (RelatedParty r : responseSO.getRelatedParty()) {
			if (r.getName().equals("osadmin") && r.getRole().equals(UserPartRoleType.REQUESTER.toString())) {
				userPartyRoleexists = true;
			}
		}

		assertThat(userPartyRoleexists).isTrue();

		assertThat(serviceOrderRepoService.findAll().size()).isEqualTo(1);

		ServiceCreate s = new ServiceCreate();
		s.setDescription("A Service for ");
		s.setServiceDate(OffsetDateTime.now(ZoneOffset.UTC).toString());
		s.hasStarted(false);
		s.setIsServiceEnabled(false);
		s.setName("Servicename");
		s.setStartMode("0");

		Note anoteItem = new Note();
		anoteItem.setText("Service Created by OSOM:AutomationCheck");
		s.addNoteItem(anoteItem);

		ServiceOrderRef serviceOrderref = new ServiceOrderRef();
		serviceOrderref.setId(responseSO.getId());
		serviceOrderref.setServiceOrderItemId((new ArrayList<>(responseSO.getOrderItem())).get(0).getId());
		s.addServiceOrderItem(serviceOrderref);

		Service createdServ = serviceRepoService.addService(s);

		ServiceOrderUpdate servOrderUpd = new ServiceOrderUpdate();
		servOrderUpd.setExpectedCompletionDate(OffsetDateTime.now(ZoneOffset.UTC).toString());
		responseSO.getNote().stream().forEach(n -> servOrderUpd.addNoteItem(n));
		Note en = new Note();
		en.text("test note2");
		servOrderUpd.addNoteItem(en);
		servOrderUpd.addOrderItemItem((new ArrayList<>(responseSO.getOrderItem())).get(0));
		servOrderUpd.getOrderItem().get(0).setState(ServiceOrderStateType.INPROGRESS);
		ServiceRef supportingServiceItem = new ServiceRef();
		supportingServiceItem.setId(createdServ.getId());
		supportingServiceItem.setReferredType(createdServ.getName());
		supportingServiceItem.setName(createdServ.getName());
		servOrderUpd.getOrderItem().get(0).getService().addSupportingServiceItem(supportingServiceItem);

		String responseSorderUpd = mvc
				.perform(MockMvcRequestBuilders.patch("/serviceOrdering/v4/serviceOrder/" + responseSO.getId())
						.contentType(MediaType.APPLICATION_JSON).content(toJson(servOrderUpd)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderUpdate = " + responseSorderUpd);
		ServiceOrder responseSOUpd = toJsonObj(responseSorderUpd, ServiceOrder.class);

		assertThat(serviceOrderRepoService.findAll().size()).isEqualTo(1);

		assertThat(responseSOUpd.getOrderItem().size()).isEqualTo(1);
		responseSOUpd.getOrderItem().stream().forEach(soiElement -> {
			assertThat(soiElement.getState()).isEqualTo(ServiceOrderStateType.INPROGRESS);
			assertThat(soiElement.getService().getServiceSpecification()).isNotNull();
			assertThat(soiElement.getService().getServiceSpecification().getName()).isEqualTo("BundleExampleSpec");
			assertThat(soiElement.getService().getSupportingService().size()).isEqualTo(1);
		});

		assertThat(responseSOUpd.getExpectedCompletionDate()).isNotNull();
		assertThat(responseSOUpd.getNote().size()).isEqualTo(2);

		File sspecSO = new File("src/test/resources/TestServiceOrderDates.json");
		InputStream inSO = new FileInputStream(sspecSO);
		String sspectextSO = IOUtils.toString(inSO, "UTF-8");

		ServiceOrder sspeccr1SO = toJsonObj(sspectextSO, ServiceOrder.class);

		assertThat(sspeccr1SO).isNotNull();
	}

	private ServiceSpecification createServiceSpec(String sspectext, ServiceSpecificationCreate sspeccr1)
			throws Exception {

		String responseSpec = mvc
				.perform(MockMvcRequestBuilders.post("/serviceCatalogManagement/v4/serviceSpecification")
						.contentType(MediaType.APPLICATION_JSON).content(toJson(sspeccr1)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		ServiceSpecification responsesSpec1 = toJsonObj(responseSpec, ServiceSpecification.class);
		logger.info("createServiceSpec = " + responseSpec);
		return responsesSpec1;
	}

	private LogicalResourceSpec createLogicalResourceSpec() throws Exception {
		File sspec = new File("src/test/resources/testResourceSpec.json");
		InputStream in = new FileInputStream(sspec);
		String sspectext = IOUtils.toString(in, "UTF-8");
		ResourceSpecificationCreate sspeccr1 = toJsonObj(sspectext, ResourceSpecificationCreate.class);

		URI url = new URI("/resourceCatalogManagement/v2/logicalResourceSpec");

		String responseSpec = mvc
				.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
						.content(toJson(sspeccr1)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		LogicalResourceSpec responsesSpec1;

		responsesSpec1 = toJsonObj(responseSpec, LogicalResourceSpec.class);

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
