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
package io.openslice.tmf.ri639.api;

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
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceCreateNotification;
import io.openslice.tmf.ri639.model.ResourceUpdate;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;

@Configuration
//@RefreshScope
@Component
public class ResourceApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ResourceApiRouteBuilder.class.getName());


	@Value("${CATALOG_ADD_RESOURCE}")
	private String CATALOG_ADD_RESOURCE = "";

	@Value("${CATALOG_UPD_RESOURCE}")
	private String CATALOG_UPD_RESOURCE = "";

	@Value("${CATALOG_GET_RESOURCE_BY_ID}")
	private String CATALOG_GET_RESOURCE_BY_ID = "";	

	
	@Value("${EVENT_RESOURCE_CREATE}")
	private String EVENT_RESOURCE_CREATE = "";
	
	@Value("${EVENT_RESOURCE_STATE_CHANGED}")
	private String EVENT_RESOURCE_STATE_CHANGED = "";
	
	@Value("${EVENT_RESOURCE_DELETE}")
	private String EVENT_RESOURCE_DELETE = "";
	
	@Value("${EVENT_RESOURCE_ATTRIBUTE_VALUE_CHANGED}")
	private String EVENT_RESOURCE_ATTRIBUTE_VALUE_CHANGED = "";


	@Value("${CATALOG_RESOURCES_OF_PARTNERS}")
	private String CATALOG_RESOURCES_OF_PARTNERS = "";
	

	@Autowired
	private ProducerTemplate template;

	@Autowired
	ResourceRepoService resourceRepoService;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_ADD_RESOURCE )
		.log(LoggingLevel.INFO, log, CATALOG_ADD_RESOURCE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ResourceCreate.class, true)
		.bean( resourceRepoService, "addResource(${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_RESOURCE_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_RESOURCE_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( resourceRepoService, "getResourceEagerAsString")
		.convertBodyTo( String.class );
		
		
		
		from( CATALOG_UPD_RESOURCE )
		.log(LoggingLevel.INFO, log, CATALOG_UPD_RESOURCE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ResourceUpdate.class, true)
		.bean( resourceRepoService, "updateResource(${header.serviceid}, ${body}, ${header.propagateToSO} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		
		

		from( CATALOG_RESOURCES_OF_PARTNERS )
		.log(LoggingLevel.INFO, log, CATALOG_RESOURCES_OF_PARTNERS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( resourceRepoService, "findAllActiveAndReservedResourcesOfPartners")
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
			
			if ( n instanceof ResourceCreateNotification) {
				 msgtopic = EVENT_RESOURCE_CREATE;
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
