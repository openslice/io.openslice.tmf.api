package io.openslice.tmf.sim638.api;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.tmf.sim638.model.ServiceCreate;
import io.openslice.tmf.sim638.service.ServiceRepoService;
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

	@Value("${CATALOG_GET_SERVICE}")
	private String CATALOG_GET_SERVICE = "";

	@Autowired
	ServiceOrderRepoService serviceOrderRepoService;
	

	@Autowired
	ServiceRepoService serviceRepoService;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_ADD_SERVICE )
		.log(LoggingLevel.INFO, log, CATALOG_ADD_SERVICE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceCreate.class, true)
		.bean( serviceRepoService, "addService(${body})");
		
	}
}
