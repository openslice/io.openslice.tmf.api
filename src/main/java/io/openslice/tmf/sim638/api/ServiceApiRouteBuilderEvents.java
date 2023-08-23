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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.tmf.common.model.Notification;
import io.openslice.tmf.sim638.model.ServiceAttributeValueChangeNotification;
import io.openslice.tmf.sim638.model.ServiceCreateNotification;
import io.openslice.tmf.sim638.model.ServiceDeleteNotification;
import io.openslice.tmf.sim638.model.ServiceStateChangeNotification;

@Configuration
//@RefreshScope
@Component
public class ServiceApiRouteBuilderEvents extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceApiRouteBuilderEvents.class.getName());


	
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

	
	@Override
	public void configure() throws Exception {
	
		
		
		
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
