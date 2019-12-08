package io.openslice.tmf.so641.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.tmf.so641.model.ServiceOrder;
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

	@Value("${CATALOG_GET_ACKNOWLEDGED_SERVICEORDERS_IDS}")
	private String CATALOG_GET_ACKNOWLEDGED_SERVICEORDERS_IDS = "";

	@Value("${CATALOG_UPD_SERVICEORDER_BY_ID}")
	private String CATALOG_UPD_SERVICEORDER_BY_ID = "";

	
	
	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;
	
	@Override
	public void configure() throws Exception {


		from( CATALOG_GET_SERVICEORDERS )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDERS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceOrderRepoService, "findAllParamsJsonOrderIDs")
		.convertBodyTo( String.class );

//		final Map<String,String> propertiesMap = new HashMap<String,String>();
//        propertiesMap.put("state", "INITIAL"); 
//        logger.info( "propertiesMap.toString() = " + propertiesMap.toString() );
        
		from( CATALOG_GET_INITIAL_SERVICEORDERS_IDS )
		.log(LoggingLevel.INFO, log, CATALOG_GET_INITIAL_SERVICEORDERS_IDS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.setBody( constant( "{\"state\":\"INITIAL\"}" ) )
		.unmarshal().json( JsonLibrary.Jackson, Map.class, true)
		.bean( serviceOrderRepoService, "findAllParamsJsonOrderIDs")
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_ACKNOWLEDGED_SERVICEORDERS_IDS )
		.log(LoggingLevel.INFO, log, CATALOG_GET_ACKNOWLEDGED_SERVICEORDERS_IDS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.setBody( constant( "{\"state\":\"ACKNOWLEDGED\"}" ) )
		.unmarshal().json( JsonLibrary.Jackson, Map.class, true)
		.bean( serviceOrderRepoService, "findAllParamsJsonOrderIDs")
		.convertBodyTo( String.class );
		
		
		
		from( CATALOG_GET_SERVICEORDER_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICEORDER_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceOrderRepoService, "getServiceOrderEagerAsString")
		.convertBodyTo( String.class );
		
		
		from( CATALOG_UPD_SERVICEORDER_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_UPD_SERVICEORDER_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceOrderUpdate.class, true)
		.bean( serviceOrderRepoService, "updateServiceOrder(${header.orderid}, ${body})");
		
	}
	
}
