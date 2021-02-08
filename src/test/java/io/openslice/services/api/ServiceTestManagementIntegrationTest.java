package io.openslice.services.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.stm653.reposervices.ServiceTestRepoService;
import io.openslice.tmf.stm653.reposervices.ServiceTestSpecificationRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK, 
		classes = OpenAPISpringBoot.class
		)
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class ServiceTestManagementIntegrationTest {


	private static final transient Log logger = LogFactory.getLog(ServiceTestManagementIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;
	

	@Autowired
	ServiceTestSpecificationRepoService aServiceTestSpecRpoService;
	ServiceTestRepoService aServiceTestRpoService;
	
	
}
