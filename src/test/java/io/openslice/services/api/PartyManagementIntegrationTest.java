package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.fasterxml.jackson.databind.type.TypeFactory;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.pm632.model.Characteristic;
import io.openslice.tmf.pm632.model.ContactMedium;
import io.openslice.tmf.pm632.model.Individual;
import io.openslice.tmf.pm632.model.IndividualCreate;
import io.openslice.tmf.pm632.model.MediumCharacteristic;
import io.openslice.tmf.pm632.model.Organization;
import io.openslice.tmf.pm632.model.OrganizationCreate;
import io.openslice.tmf.pm632.reposervices.IndividualRepoService;
import io.openslice.tmf.pm632.reposervices.OrganizationRepoService;

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

    @Autowired
    OrganizationRepoService organizationRepoService;

    
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
		

		Individual responseIndv = toJsonObj(response,  Individual.class);
		assertThat( responseIndv.getContactMedium().stream().findFirst().get().getCharacteristic().getEmailAddress()).isEqualTo("test@openslice.io"); 
	}
	
	
	@WithMockUser(username="osadmin", roles = {"ADMIN","USER"})
	@Test
	public void addOrganization() throws Exception {
		
		OrganizationCreate oc = new OrganizationCreate();		
		oc.setName("An Organization");
	
		List<ContactMedium> contactMediums = new ArrayList<>();
		ContactMedium cm = new ContactMedium();
		contactMediums.add(cm);
		cm.setMediumType("email");
		cm.setPreferred(true);
		MediumCharacteristic medChar = new MediumCharacteristic();
		medChar.setEmailAddress( "test@openslice.io" );
		cm.setCharacteristic(medChar);
		oc.setContactMedium(contactMediums );
		Characteristic partyCharacteristicItem = new Characteristic();
		
		
		partyCharacteristicItem.setName("EXTERNAL_TMFAPI");
		Any value = new Any();
		
		Map<String, Object> apiparams = new HashMap<>();
		String[] scopes = {"admin" , "read"};
		

		apiparams.put( "CLIENTREGISTRATIONID", "authOpensliceProvider");
		apiparams.put( "OAUTH2CLIENTID", "osapiWebClientId");
		apiparams.put( "OAUTH2CLIENTSECRET", "secret");
		apiparams.put( "OAUTH2SCOPES", scopes);
		apiparams.put( "OAUTH2TOKENURI", "http://portal.openslice.io/osapi-oauth-server/oauth/token");
		apiparams.put( "USERNAME", "admin");
		apiparams.put( "PASSWORD", "openslice");
		apiparams.put( "BASEURL", "http://portal.openslice.io");

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String strinparams = mapper.writeValueAsString( apiparams );
		value.setValue( strinparams );
		
		partyCharacteristicItem.setValue( value );
		
		
		oc.addPartyCharacteristicItem(partyCharacteristicItem );
		partyCharacteristicItem = new Characteristic();
		partyCharacteristicItem.setName("API2");
		partyCharacteristicItem.setValue( new Any("apiendpoint2"));
		oc.addPartyCharacteristicItem(partyCharacteristicItem );
		
		String response = mvc.perform(MockMvcRequestBuilders.post("/party/v4/organization")
				.contentType(MediaType.APPLICATION_JSON)
				.content( toJson( oc ) ))
			    .andExpect(status().isOk())
			    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			    .andExpect(jsonPath("name", is("An Organization")))								 
	    	    .andExpect(status().isOk())
	    	    .andReturn().getResponse().getContentAsString();
		

		assertThat( organizationRepoService.findAll().size() ).isEqualTo( 1 );
		

		Organization responseOrg = toJsonObj(response,  Organization.class);
		assertThat( responseOrg.getContactMedium().stream().findFirst().get().getCharacteristic().getEmailAddress()).isEqualTo("test@openslice.io"); 
		assertThat( responseOrg.getPartyCharacteristic().size()).isEqualTo(2);
		
		
		String resp = organizationRepoService.getPartnerOrganizationsWithAPI();

		Class<List<Organization>> clazz = (Class) List.class;
		List<Organization> orgz = mapJsonToObjectList( new Organization(), (String)response, Organization.class  ); 
		
		assertThat( orgz.size() ).isEqualTo( 1 );
		assertThat( orgz.get(0).getPartyCharacteristic().size() ).isEqualTo( 2 );
	}
	
	 protected static <T> List<T> mapJsonToObjectList(T typeDef,String json,Class clazz) throws Exception
	   {
	      List<T> list;
	      ObjectMapper mapper = new ObjectMapper();
	      System.out.println(json);
	      TypeFactory t = TypeFactory.defaultInstance();
	      list = mapper.readValue(json, t.constructCollectionType(ArrayList.class,clazz));

//	      System.out.println(list);
//	      System.out.println(list.get(0).getClass());
	      return list;
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