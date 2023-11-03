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

import io.openslice.model.DeploymentDescriptor;
import io.openslice.tmf.sim638.model.ServiceActionQueueItem;
import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.model.ServiceUpdate;
import io.openslice.tmf.sim638.service.ServiceRepoService;

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

	@Value("${CATALOG_GET_SERVICE_BY_ORDERID}")
	private String CATALOG_GET_SERVICE_BY_ORDERID = "";
	
	
	@Value("${CATALOG_SERVICE_QUEUE_ITEMS_GET}")
	private String CATALOG_SERVICE_QUEUE_ITEMS_GET = "";	

	@Value("${CATALOG_SERVICE_QUEUE_ITEM_UPD}")
	private String CATALOG_SERVICE_QUEUE_ITEM_UPD = "";
	
	@Value("${CATALOG_SERVICE_QUEUE_ITEM_DELETE}")
	private String CATALOG_SERVICE_QUEUE_ITEM_DELETE = "";
	
	@Value("${EVENT_SERVICE_CREATE}")
	private String EVENT_SERVICE_CREATE = "";
	

	@Value("${CATALOG_SERVICES_TO_TERMINATE}")
	private String CATALOG_SERVICES_TO_TERMINATE = "";

	@Value("${CATALOG_SERVICES_OF_PARTNERS}")
	private String CATALOG_SERVICES_OF_PARTNERS = "";
	

	@Value("${NFV_CATALOG_NS_LCMCHANGED}")
	private String NFV_CATALOG_NS_LCMCHANGED = "";
	

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
		.bean( serviceRepoService, "updateService(${header.serviceid}, ${body}, ${header.propagateToSO} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		
		from( CATALOG_SERVICE_QUEUE_ITEMS_GET )
		.log(LoggingLevel.INFO, log, CATALOG_SERVICE_QUEUE_ITEMS_GET + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceRepoService, "findAllServiceActionQueueItems")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( CATALOG_SERVICE_QUEUE_ITEM_UPD )
		.log(LoggingLevel.INFO, log, CATALOG_SERVICE_QUEUE_ITEM_UPD + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceActionQueueItem.class, true)
		.bean( serviceRepoService, "updateServiceActionQueueItem(${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( CATALOG_SERVICE_QUEUE_ITEM_DELETE )
		.log(LoggingLevel.INFO, log, CATALOG_SERVICE_QUEUE_ITEM_DELETE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceActionQueueItem.class, true)
		.bean( serviceRepoService, "deleteServiceActionQueueItemByUuid(${header.itemid})");
		
		
		
		from( CATALOG_SERVICES_TO_TERMINATE )
		.log(LoggingLevel.INFO, log, CATALOG_SERVICES_TO_TERMINATE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceRepoService, "findAllActiveServicesToTerminate")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		

		from( CATALOG_SERVICES_OF_PARTNERS )
		.log(LoggingLevel.INFO, log, CATALOG_SERVICES_OF_PARTNERS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceRepoService, "findAllActiveAndReservedServicesOfPartners")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		

		from( CATALOG_GET_SERVICE_BY_ORDERID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICE_BY_ORDERID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceRepoService, "getServicesFromOrderID")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( NFV_CATALOG_NS_LCMCHANGED )
		.log(LoggingLevel.INFO, log, NFV_CATALOG_NS_LCMCHANGED + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, DeploymentDescriptor.class, true)
		.bean( serviceRepoService, "nfvCatalogNSResourceChanged(${body})");
		
		
		
		
	}
	
	
	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}
	
}
