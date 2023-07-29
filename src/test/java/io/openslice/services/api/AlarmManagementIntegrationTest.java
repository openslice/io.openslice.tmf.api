/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import org.apache.camel.ProducerTemplate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import io.openslice.tmf.am642.model.AffectedService;
import io.openslice.tmf.am642.model.Alarm;
import io.openslice.tmf.am642.model.AlarmCreate;
import io.openslice.tmf.am642.model.AlarmStateType;
import io.openslice.tmf.am642.model.AlarmType;
import io.openslice.tmf.am642.model.AlarmUpdate;
import io.openslice.tmf.am642.model.Comment;
import io.openslice.tmf.am642.model.PerceivedSeverityType;
import io.openslice.tmf.am642.model.ProbableCauseType;
import io.openslice.tmf.am642.reposervices.AlarmRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class AlarmManagementIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(AlarmManagementIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;

	@Autowired
	AlarmRepoService alarmRepoService;

	@Autowired
	private WebApplicationContext context;


    @Autowired
    private ProducerTemplate template;

	@Value("${ALARMS_ADD_ALARM}")
	private String ALARMS_ADD_ALARM ="";
	
	@Value("${ALARMS_UPDATE_ALARM}")
	private String ALARMS_UPDATE_ALARM ="";
	
	@Value("${ALARMS_GET_ALARM}")
	private String ALARMS_GET_ALARM ="";
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(username = "osadmin", roles = { "ADMIN", "USER" })
	@Test
	public void testAlarmCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {

		AlarmCreate a = new AlarmCreate();
		a.setPerceivedSeverity(PerceivedSeverityType.warning.name());
		a.setState(AlarmStateType.raised.name());
		a.setAckState("unacknowledged");
		a.setAlarmRaisedTime(OffsetDateTime.now(ZoneOffset.UTC).toString());
		a.setSourceSystemId("NFVO");
		a.setAffectedService(new ArrayList<>());
		a.setAlarmDetails("details...");
		a.setAlarmType(AlarmType.qualityOfServiceAlarm.name());
		a.setIsRootCause(true);
		a.setProbableCause(ProbableCauseType.resourceAtOrNearingCapacity.name());
		a.reportingSystemId("OSA");
		
		Comment comment = new Comment();
		comment.setComment("test");
		a.addCommentItem(comment );

		AffectedService as = new AffectedService();
		as.setId("aServiceID");
		as.setType("Service");
		a.getAffectedService().add(as);
		String response = mvc
				.perform(MockMvcRequestBuilders.post("/alarmManagement/v4/alarm")
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content( JsonUtils.toJson(a)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("alarmDetails", is("details..."))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(alarmRepoService.findAll().size()).isEqualTo(1);

		Alarm alarm = JsonUtils.toJsonObj(response, Alarm.class);
		assertThat(alarm.getAckState()).isEqualTo("unacknowledged");
		assertThat(alarm.getSourceSystemId()).isEqualTo("NFVO");
		assertThat(alarm.getPerceivedSeverity()).isEqualTo(PerceivedSeverityType.warning.name());
		assertThat(alarm.getAlarmType()).isEqualTo(AlarmType.qualityOfServiceAlarm.name());
		assertThat(alarm.getAlarmRaisedTime()  ).isNotNull();
		assertThat(alarm.getComment().size() ).isEqualTo(1);

		AlarmUpdate aupd = new AlarmUpdate();
		aupd.setAckState("acknowledged");
		aupd.setAckSystemId("OSA");
		aupd.setPerceivedSeverity(PerceivedSeverityType.warning.name());
		aupd.setState(AlarmStateType.updated.name());
		comment = new Comment();
		comment.setComment("test");
		aupd.addCommentItem(comment );
		
		response = mvc
				.perform(MockMvcRequestBuilders.patch("/alarmManagement/v4/alarm/" + alarm.getId() )
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(JsonUtils.toJson(aupd)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("alarmDetails", is("details..."))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(alarmRepoService.findAll().size()).isEqualTo(1);

		alarm = JsonUtils.toJsonObj(response, Alarm.class);
		assertThat(alarm.getAckState()).isEqualTo("acknowledged");
		assertThat(alarm.getState()).isEqualTo( AlarmStateType.updated.name() );
		assertThat(alarm.getSourceSystemId()).isEqualTo("NFVO");
		assertThat(alarm.getAckSystemId()).isEqualTo("OSA");
		assertThat(alarm.getPerceivedSeverity()).isEqualTo(PerceivedSeverityType.warning.name());
		assertThat(alarm.getAlarmType()).isEqualTo(AlarmType.qualityOfServiceAlarm.name());
		assertThat(alarm.getComment().size() ).isEqualTo(2);

		aupd = new AlarmUpdate();
		aupd.setState(AlarmStateType.cleared.name());
		aupd.setAckSystemId("OSA");
		aupd.setPerceivedSeverity(PerceivedSeverityType.cleared.name());
		response = mvc
				.perform(MockMvcRequestBuilders.patch("/alarmManagement/v4/alarm/" + alarm.getId() )
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(JsonUtils.toJson(aupd)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("alarmDetails", is("details..."))).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(alarmRepoService.findAll().size()).isEqualTo(1);

		alarm = JsonUtils.toJsonObj(response, Alarm.class);
		assertThat(alarm.getAckState()).isEqualTo("acknowledged");
		assertThat(alarm.getSourceSystemId()).isEqualTo("NFVO");
		assertThat(alarm.getAckSystemId()).isEqualTo("OSA");
		assertThat(alarm.getState()).isEqualTo( AlarmStateType.cleared.name() );
		assertThat(alarm.getPerceivedSeverity()).isEqualTo(PerceivedSeverityType.cleared.name());
		assertThat(alarm.getAlarmType()).isEqualTo(AlarmType.qualityOfServiceAlarm.name());

	}
	

	@WithMockUser(username = "osadmin", roles = { "ADMIN", "USER" })
	@Test
	public void testAlarmCreateAndUpdateRoutes() throws IOException  {
		AlarmCreate a = new AlarmCreate();
		a.setPerceivedSeverity(PerceivedSeverityType.warning.name());
		a.setState(AlarmStateType.raised.name());
		a.setAckState("unacknowledged");
		a.setAlarmRaisedTime(OffsetDateTime.now(ZoneOffset.UTC).toString());
		a.setSourceSystemId("NFVO");
		a.setAffectedService(new ArrayList<>());
		a.setAlarmDetails("details...");
		a.setAlarmType(AlarmType.qualityOfServiceAlarm.name());
		a.setIsRootCause(true);
		a.setProbableCause(ProbableCauseType.resourceAtOrNearingCapacity.name());
		a.reportingSystemId("OSA");

		AffectedService as = new AffectedService();
		as.setId("aServiceID");
		as.setType("Service");
		a.getAffectedService().add(as);
		
		String body = JsonUtils.toJsonString(a);
		Object response = template.requestBody( ALARMS_ADD_ALARM, body);

		assertThat( response).isInstanceOf( String.class);
		Alarm alarm = JsonUtils.toJsonObj( (String)response, Alarm.class);
		assertThat(alarm.getAckState()).isEqualTo("unacknowledged");
		assertThat(alarm.getSourceSystemId()).isEqualTo("NFVO");
		assertThat(alarm.getPerceivedSeverity()).isEqualTo(PerceivedSeverityType.warning.name());
		assertThat(alarm.getAlarmType()).isEqualTo(AlarmType.qualityOfServiceAlarm.name());
		
		
		AlarmUpdate aupd = new AlarmUpdate();
		aupd.setAckState("acknowledged");
		aupd.setAckSystemId("OSA");
		aupd.setPerceivedSeverity(PerceivedSeverityType.warning.name());
		aupd.setState(AlarmStateType.updated.name());
		body = JsonUtils.toJsonString(aupd);
		response = template.requestBodyAndHeader( ALARMS_UPDATE_ALARM, body , "alarmid", alarm.getId());

		assertThat(alarmRepoService.findAll().size()).isEqualTo(1);

		alarm = JsonUtils.toJsonObj( (String)response, Alarm.class);;
		assertThat(alarm.getAckState()).isEqualTo("acknowledged");
		assertThat(alarm.getState()).isEqualTo( AlarmStateType.updated.name() );
		assertThat(alarm.getSourceSystemId()).isEqualTo("NFVO");
		assertThat(alarm.getAckSystemId()).isEqualTo("OSA");
		assertThat(alarm.getPerceivedSeverity()).isEqualTo(PerceivedSeverityType.warning.name());
		assertThat(alarm.getAlarmType()).isEqualTo(AlarmType.qualityOfServiceAlarm.name());

		aupd = new AlarmUpdate();
		aupd.setState(AlarmStateType.cleared.name());
		aupd.setAckSystemId("OSA");
		aupd.setPerceivedSeverity(PerceivedSeverityType.cleared.name());
		body = JsonUtils.toJsonString(aupd);
		response = template.requestBodyAndHeader( ALARMS_UPDATE_ALARM, body , "alarmid", alarm.getId());

		assertThat(alarmRepoService.findAll().size()).isEqualTo(1);

		alarm = JsonUtils.toJsonObj( (String)response, Alarm.class);
		assertThat(alarm.getAckState()).isEqualTo("acknowledged");
		assertThat(alarm.getSourceSystemId()).isEqualTo("NFVO");
		assertThat(alarm.getAckSystemId()).isEqualTo("OSA");
		assertThat(alarm.getState()).isEqualTo( AlarmStateType.cleared.name() );
		assertThat(alarm.getPerceivedSeverity()).isEqualTo(PerceivedSeverityType.cleared.name());
		assertThat(alarm.getAlarmType()).isEqualTo(AlarmType.qualityOfServiceAlarm.name());
		
		

		assertThat(alarmRepoService.findAll().size()).isEqualTo(1);
		
	}


}
