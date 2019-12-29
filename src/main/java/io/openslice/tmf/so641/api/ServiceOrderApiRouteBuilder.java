package io.openslice.tmf.so641.api;

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
import io.openslice.tmf.so641.model.ServiceOrderAttributeValueChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderCreateNotification;
import io.openslice.tmf.so641.model.ServiceOrderDeleteEvent;
import io.openslice.tmf.so641.model.ServiceOrderDeleteNotification;
import io.openslice.tmf.so641.model.ServiceOrderStateChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderUpdate;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;

@Configuration
//@RefreshScope
@Component
public class ServiceOrderApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderApiRouteBuilder.class.getName());

	@Value("${CATALOG_GET_SERVICEORDER_BY_ID}")
	private String CATALOG_GET_SERVICEORDER_BY_ID = "";

	@Value("${CATALOG_GET_SERVICEORDERS}")
	private String CATALOG_GET_SERVICEORDERS = "";

	@Value("${CATALOG_GET_INITIAL_SERVICEORDERS_IDS}")
	private String CATALOG_GET_INITIAL_SERVICEORDERS_IDS = "";

	@Value("${CATALOG_GET_SERVICEORDER_IDS_BY_STATE}")
	private String CATALOG_GET_SERVICEORDER_IDS_BY_STATE = "";

	@Value("${CATALOG_UPD_SERVICEORDER_BY_ID}")
	private String CATALOG_UPD_SERVICEORDER_BY_ID = "";
	

	@Value("${EVENT_SERVICE_ORDER_CREATE}")
	private String EVENT_SERVICE_ORDER_CREATE = "";
	
	@Value("${EVENT_SERVICE_ORDER_STATE_CHANGED}")
	private String EVENT_SERVICE_ORDER_STATE_CHANGED = "";
	
	@Value("${EVENT_SERVICE_ORDER_DELETE}")
	private String EVENT_SERVICE_ORDER_DELETE = "";
	
	@Value("${EVENT_SERVICE_ORDER_ATTRIBUTE_VALUE_CHANGED}")
	private String EVENT_SERVICE_ORDER_ATTRIBUTE_VALUE_CHANGED = "";

	@Autowired
	private ProducerTemplate template;

	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;

	@Override
	public void configure() throws Exception {

		from(CATALOG_GET_SERVICEORDERS).log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDERS + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true")
				.bean(serviceOrderRepoService, "findAllParamsJsonOrderIDs").convertBodyTo(String.class);

//		final Map<String,String> propertiesMap = new HashMap<String,String>();
//        propertiesMap.put("state", "INITIAL"); 
//        logger.info( "propertiesMap.toString() = " + propertiesMap.toString() );

		from(CATALOG_GET_INITIAL_SERVICEORDERS_IDS)
				.log(LoggingLevel.INFO, log, CATALOG_GET_INITIAL_SERVICEORDERS_IDS + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").setBody(constant("{\"state\":\"INITIAL\"}")).unmarshal()
				.json(JsonLibrary.Jackson, Map.class, true).bean(serviceOrderRepoService, "findAllParamsJsonOrderIDs")
				.convertBodyTo(String.class);

		from(CATALOG_GET_SERVICEORDER_IDS_BY_STATE)
				.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDER_IDS_BY_STATE + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").setBody(simple("{\"state\":\"${header.orderstate}\"}"))
				.unmarshal().json(JsonLibrary.Jackson, Map.class, true)
				.bean(serviceOrderRepoService, "findAllParamsJsonOrderIDs").convertBodyTo(String.class);

		from(CATALOG_GET_SERVICEORDER_BY_ID)
				.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDER_BY_ID + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true")
				.bean(serviceOrderRepoService, "getServiceOrderEagerAsString").convertBodyTo(String.class);

		from(CATALOG_UPD_SERVICEORDER_BY_ID)
				.log(LoggingLevel.INFO, log, CATALOG_UPD_SERVICEORDER_BY_ID + " message received!")
				.to("log:DEBUG?showBody=true&showHeaders=true").unmarshal()
				.json(JsonLibrary.Jackson, ServiceOrderUpdate.class, true)
				.bean(serviceOrderRepoService, "updateServiceOrder(${header.serviceid}, ${body})");

	}

	/**
	 * @param n
	 */
	public void publishEvent(final Notification n, final String objId) {
		n.setEventType( n.getClass().getName());
		logger.info("will send Event for type " + n.getEventType());
		try {
			String msgtopic="";
			
			if ( n instanceof ServiceOrderCreateNotification) {
				 msgtopic = EVENT_SERVICE_ORDER_CREATE;
			} else if ( n instanceof ServiceOrderStateChangeNotification) {
				 msgtopic = EVENT_SERVICE_ORDER_STATE_CHANGED;				
			} else if ( n instanceof ServiceOrderDeleteNotification) {
				 msgtopic = EVENT_SERVICE_ORDER_DELETE;				
			} else if ( n instanceof ServiceOrderAttributeValueChangeNotification) {
				 msgtopic = EVENT_SERVICE_ORDER_ATTRIBUTE_VALUE_CHANGED;				
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
