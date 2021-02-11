package io.openslice.services.api;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import io.openslice.tmf.stm653.reposervices.ServiceTestRepoService;
import io.openslice.tmf.stm653.reposervices.ServiceTestSpecificationRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class ServiceTestManagementIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(ServiceTestManagementIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;

	@Autowired
	ServiceTestSpecificationRepoService aServiceTestSpecRpoService;
	ServiceTestRepoService aServiceTestRpoService;

	@Autowired
	ServiceRepoService serviceRepoService;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(username = "osadmin", roles = { "USER" })
	@Test
	public void testServiceTestSpecCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {

		/**
		 * first add 2 specs
		 */
		
		serv

	}

}
