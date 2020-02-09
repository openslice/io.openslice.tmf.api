/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
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
package io.openslice.tmf.sim638.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.Notification;
import io.openslice.tmf.sim638.model.ServiceAttributeValueChangeNotification;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceCreateNotification;
import io.openslice.tmf.sim638.model.ServiceDeleteNotification;
import io.openslice.tmf.sim638.model.ServiceStateChangeNotification;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import io.openslice.tmf.so641.model.ServiceOrderAttributeValueChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderCreateNotification;
import io.openslice.tmf.so641.model.ServiceOrderDeleteNotification;
import io.openslice.tmf.so641.model.ServiceOrderStateChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;

@Configuration
//@RefreshScope
@Component
public class ServiceApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceApiRouteBuilder.class.getName());


	@Value("${CATALOG_ADD_SERVICE}")
	private String CATALOG_ADD_SERVICE = "";

	@Value("${CATALOG_UPD_SERVICE}")
	private String CATALOG_UPD_SERVICE = "";

	@Value("${CATALOG_GET_SERVICE_BY_ID}")
	private String CATALOG_GET_SERVICE_BY_ID = "";


	@Value("${EVENT_SERVICE_CREATE}")
	private String EVENT_SERVICE_CREATE = "";
	
	@Value("${EVENT_SERVICE_STATE_CHANGED}")
	private String EVENT_SERVICE_STATE_CHANGED = "";
	
	@Value("${EVENT_SERVICE_DELETE}")
	private String EVENT_SERVICE_DELETE = "";
	
	@Value("${EVENT_SERVICE_ATTRIBUTE_VALUE_CHANGED}")
	private String EVENT_SERVICE_ATTRIBUTE_VALUE_CHANGED = "";


	@Autowired
	private ProducerTemplate template;

	@Autowired
	ServiceRepoService serviceRepoService;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_ADD_SERVICE )
		.log(LoggingLevel.INFO, log, CATALOG_ADD_SERVICE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceCreate.class, true)
		.bean( serviceRepoService, "addService(${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_SERVICE_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICE_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceRepoService, "getServiceEagerAsString")
		.convertBodyTo( String.class );
		
		from( CATALOG_UPD_SERVICE )
		.log(LoggingLevel.INFO, log, CATALOG_UPD_SERVICE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceUpdate.class, true)
		.bean( serviceRepoService, "updateService(${header.serviceid}, ${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
	}
	
	
	/**
	 * @param n
	 */
	public void publishEvent(final Notification n, final String objId) {
		n.setEventType( n.getClass().getName());
		logger.info("will send Event for type " + n.getEventType());
		try {
			String msgtopic="";
			
			if ( n instanceof ServiceCreateNotification) {
				 msgtopic = EVENT_SERVICE_CREATE;
			} else if ( n instanceof ServiceStateChangeNotification) {
				 msgtopic = EVENT_SERVICE_STATE_CHANGED;				
			} else if ( n instanceof ServiceDeleteNotification) {
				 msgtopic = EVENT_SERVICE_DELETE;				
			} else if ( n instanceof ServiceAttributeValueChangeNotification) {
				 msgtopic = EVENT_SERVICE_ATTRIBUTE_VALUE_CHANGED;				
			}
			Map<String, Object> map = new HashMap<>();
			map.put("eventid", n.getEventId() );
			map.put("objId", objId );
			
			template.sendBodyAndHeaders(msgtopic, toJsonString(n), map);

		} catch (Exception e) {
			logger.error("Cannot send Event . " + e.getStackTrace() );
		}
	}

	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}
	
}
