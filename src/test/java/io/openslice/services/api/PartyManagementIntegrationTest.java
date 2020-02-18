package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.IndividualCreate;
import io.openslice.tmf.pm632.model.MediumCharacteristic;
import io.openslice.tmf.pm632.reposervices.IndividualRepoService;
import io.openslice.tmf.prm669.model.RelatedParty;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc 
@ActiveProfiles("testing")
public class PartyManagementIntegrationTest {


	private static final transient Log logger = LogFactory.getLog( PartyManagementIntegrationTest.class.getName());
	

    @Autowired
    private MockMvc mvc;

    @Autowired
    IndividualRepoService individualRepoService;

    
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void addIndividual() throws Exception {
		
		IndividualCreate ic = new IndividualCreate();		
		ic.setFamilyName("A Customer");
	
		List<ContactMedium> contactMediums = new ArrayList<>();
		ContactMedium cm = new ContactMedium();
		contactMediums.add(cm);
		cm.setMediumType("email");
		cm.setPreferred(true);
		MediumCharacteristic medChar = new MediumCharacteristic();
		medChar.setEmailAddress( "test@openslice.io" );
		cm.setCharacteristic(medChar);
		ic.setContactMedium(contactMediums );
		
		
				
		String response = mvc.perform(MockMvcRequestBuilders.post("/party/v4/individual")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( ic ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("familyName", is("A Customer")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( individualRepoService.findAll().size() ).isEqualTo( 1 );
		
		
		
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
