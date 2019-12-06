package io.openslice.tmf.scm633.api;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.so641.api.ServiceOrderApiRouteBuilder;

@Configuration
//@RefreshScope
@Component
public class ServiceSpecificationApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderApiRouteBuilder.class.getName());

	@Value("${CATALOG_GET_SERVICESPEC_BY_ID}")
	private String CATALOG_GET_SERVICESPEC_BY_ID = "";

	@Autowired
	ServiceSpecificationRepoService serviceSpecificationRepoService;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_GET_SERVICESPEC_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICESPEC_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceSpecificationRepoService, "findByUuid")
		.convertBodyTo( String.class );
		
	}

	
}
