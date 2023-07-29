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
package io.openslice.tmf.am642.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.LoggingLevel;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.am642.model.AlarmCreate;
import io.openslice.tmf.am642.model.AlarmUpdate;
import io.openslice.tmf.am642.reposervices.AlarmRepoService;

@Configuration
@Component
public class AlarmApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(AlarmApiRouteBuilder.class.getName());


	@Value("${ALARMS_ADD_ALARM}")
	private String ALARMS_ADD_ALARM ="";
	
	@Value("${ALARMS_UPDATE_ALARM}")
	private String ALARMS_UPDATE_ALARM ="";

	@Value("${ALARMS_GET_ALARM}")
	private String ALARMS_GET_ALARM ="";

	

	@Value("${spring.application.name}")
	private String compname;
	
	@Autowired
    AlarmRepoService alarmRepoService;
	

	@Autowired
	private ProducerTemplate template;


	@Autowired
	private CentralLogger centralLogger;
		
	@Override
	public void configure() throws Exception {
		
		from( ALARMS_ADD_ALARM )
		.log(LoggingLevel.INFO, log, ALARMS_ADD_ALARM + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal()
		.json(JsonLibrary.Jackson, AlarmCreate.class, true)	
		.bean( alarmRepoService, "addAlarm(${body})")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
		from( ALARMS_UPDATE_ALARM )
		.log(LoggingLevel.INFO, log, ALARMS_UPDATE_ALARM + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal()
		.json(JsonLibrary.Jackson, AlarmUpdate.class, true)	
		.bean( alarmRepoService, "updateAlarm(${header.alarmid}, ${body})")
		.bean( alarmRepoService, "findByUuidEager(${header.alarmid})")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
		from( ALARMS_GET_ALARM )
		.log(LoggingLevel.INFO, log, ALARMS_GET_ALARM + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( alarmRepoService, "findByUuidEager(${header.alarmid})")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
	}
	
	
	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}
}
