package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.cm629.model.CustomerCreate;
import io.openslice.tmf.cm629.service.CustomerRepoService;
import io.openslice.tmf.prm669.model.RelatedParty;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
public class CustomerIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( CustomerIntegrationTest.class.getName());
	

    @Autowired
    private MockMvc mvc;
    

	@Autowired
	CustomerRepoService customerRepoService;
	
    
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void addCustomer() throws Exception {
		
		CustomerCreate cc = new CustomerCreate();
		cc.setName("A Customer");
		RelatedParty engagedParty = new RelatedParty();
		engagedParty.name("An Organization");
		engagedParty.setUuid(UUID.randomUUID().toString());
		cc.setEngagedParty(engagedParty );
		
		String response = mvc.perform(MockMvcRequestBuilders.post("/customerManagement/v4/customer")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( cc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("A Customer")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( customerRepoService.findAll().size() ).isEqualTo( 1 );
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
}
