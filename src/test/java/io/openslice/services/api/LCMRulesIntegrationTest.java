package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.lcm.model.ELCMRulePhase;
import io.openslice.tmf.lcm.model.LCMRuleSpecification;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationCreate;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationUpdate;
import io.openslice.tmf.lcm.reposervices.LCMRuleSpecificationRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
//@AutoConfigureTestDatabase //this automatically uses h2
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
//@TestPropertySource(
//		  locations = "classpath:application-testing.yml")
public class LCMRulesIntegrationTest {
	
	private static final transient Log logger = LogFactory.getLog( LCMRulesIntegrationTest.class.getName());


    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private WebApplicationContext context;
    

	@Autowired
	LCMRuleSpecificationRepoService lcmRuleSpecificationRepoService;
    
	@Before
    public void setup() {
        mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(springSecurity())
          .build();
    }
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test

	public void addLCMRule() throws Exception {
		
		
		LCMRuleSpecificationCreate c = new LCMRuleSpecificationCreate();
		c.setName("NewT");
		c.setLcmrulephase( ELCMRulePhase.AFTER_ACTIVATION.getValue() );
		c.setCode("CODE");
		c.setContent("CONTENT");
		c.setServiceSpecs( new ArrayList<>());
		ServiceSpecificationRef specref = new ServiceSpecificationRef();
		specref.setId("0x0x1");
		specref.setName("SPECREF");
		c.getServiceSpecs().add(specref );

		String response = mvc.perform(MockMvcRequestBuilders.post("/lcmrulesmanagement/v1/lcmRuleSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( c ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("NewT")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( lcmRuleSpecificationRepoService.findAll().size() ).isEqualTo( 1 );

		LCMRuleSpecification resp = JsonUtils.toJsonObj(response,  LCMRuleSpecification.class);
		assertThat( resp.getContent() ).isEqualTo( "CONTENT" );
		assertThat( resp.getServiceSpecs().size()  ).isEqualTo( 1 );
		assertThat( resp.getServiceSpecs().stream().findFirst().get().getName()  ).isEqualTo( "SPECREF" );
		
		
		//we will add now a new rule to service
		LCMRuleSpecificationCreate c2 = new LCMRuleSpecificationCreate();
		c2.setName("NewT2");
		c2.setLcmrulephase( ELCMRulePhase.PRE_PROVISION.getValue() );
		c2.setCode("CODE2");
		c2.setContent("CONTENT2");
		c2.setServiceSpecs( new ArrayList<>());
		c2.getServiceSpecs().add(specref );

		String response2 = mvc.perform(MockMvcRequestBuilders.post("/lcmrulesmanagement/v1/lcmRuleSpecification")
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( c2 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("NewT2")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( lcmRuleSpecificationRepoService.findAll().size() ).isEqualTo( 2 );
		LCMRuleSpecification resp2 = JsonUtils.toJsonObj(response2,  LCMRuleSpecification.class);
		assertThat( resp2.getContent() ).isEqualTo( "CONTENT2" );

		assertThat( lcmRuleSpecificationRepoService.findAll().size() ).isEqualTo( 2 );
		for (LCMRuleSpecification iterable_element : lcmRuleSpecificationRepoService.findAll()) {
			logger.info( iterable_element );
			
		}
		List<LCMRuleSpecification> rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefIdAndPhase("0x0x1", ELCMRulePhase.PRE_PROVISION.getValue());
		assertThat( rules.size() ).isEqualTo( 1 );
		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefIdAndPhase("0x0x1", ELCMRulePhase.AFTER_ACTIVATION.getValue());
		assertThat( rules.size() ).isEqualTo( 1 );
		
		//attach same rule on other spec

		LCMRuleSpecificationUpdate cu1 = new LCMRuleSpecificationUpdate();
		cu1.setServiceSpecs( new ArrayList<>());
		cu1.setLcmrulephase( resp.getLcmrulephase() );
		cu1.getServiceSpecs().addAll(resp.getServiceSpecs());
		ServiceSpecificationRef specref2 = new ServiceSpecificationRef();
		specref2.setId("0x0x2");
		specref2.setName("SPECREF2");
		cu1.getServiceSpecs().add(specref2 );
				

		String response3 = mvc.perform(MockMvcRequestBuilders.patch("/lcmrulesmanagement/v1/lcmRuleSpecification/"+resp.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( cu1 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("NewT")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();

		resp = JsonUtils.toJsonObj(response3,  LCMRuleSpecification.class);
		assertThat( lcmRuleSpecificationRepoService.findAll().size() ).isEqualTo( 2 );

		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefIdAndPhase("0x0x1", ELCMRulePhase.AFTER_ACTIVATION.getValue());
		assertThat( rules.size() ).isEqualTo( 1 );
		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefIdAndPhase("0x0x2", ELCMRulePhase.AFTER_ACTIVATION.getValue());
		assertThat( rules.size() ).isEqualTo( 1 );
		
		for (LCMRuleSpecification iterable_element : lcmRuleSpecificationRepoService.findAll()) {
			logger.info( iterable_element );
			
		}
		
//		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefId("0x0x1");
//		assertThat( rules.size() ).isEqualTo( 2 );
//		assertThat( resp.getServiceSpecificationRefs().size() ).isEqualTo( 2 );
//		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefId("0x0x2");
//		assertThat( rules.size() ).isEqualTo( 1 );
		
		
		//delete rule from spec

		LCMRuleSpecificationUpdate cu2 = new LCMRuleSpecificationUpdate();
		cu2.setServiceSpecs( new ArrayList<>());
		cu2.getServiceSpecs().addAll( resp.getServiceSpecs());
		assertThat( cu2.getServiceSpecs().size() ).isEqualTo( 2 );
		cu2.getServiceSpecs().remove(0);				

		String response4 = mvc.perform(MockMvcRequestBuilders.patch("/lcmrulesmanagement/v1/lcmRuleSpecification/"+resp.getId() )
	            .with( SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content( JsonUtils.toJson( cu2 ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("NewT")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();

		resp = JsonUtils.toJsonObj(response4,  LCMRuleSpecification.class);
		assertThat( resp.getServiceSpecs().size() ).isEqualTo( 1 );

		assertThat( lcmRuleSpecificationRepoService.findAll().size() ).isEqualTo( 2 );

//		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefId("0x0x1");
//		assertThat( rules.size() ).isEqualTo( 1 );
//		rules = lcmRuleSpecificationRepoService.findByServiceSpecificationRefId("0x0x2");
//		assertThat( rules.size() ).isEqualTo( 1 );
		
	}
	
}
