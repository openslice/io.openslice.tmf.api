package io.openslice.tmf.lcm.api;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.tmf.lcm.reposervices.LCMRuleSpecificationRepoService;

/**
 * @author ctranoris
 *
 */
@Configuration
@Component
public class LCMRuleSpecificationApiRouteBuilder  extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog( LCMRuleSpecificationApiRouteBuilder.class.getName());

	@Value("${CATALOG_GET_LCMRULE_BY_ID}")
	private String CATALOG_GET_LCMRULE_BY_ID = "";
	
	@Value("${CATALOG_GET_LCMRULES_BY_SPECID_PHASE}")
	private String CATALOG_GET_LCMRULES_BY_SPECID_PHASE = "";
	
	
	@Autowired	
	LCMRuleSpecificationRepoService lcmRuleSpecificationRepoService;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_GET_LCMRULE_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_LCMRULE_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( lcmRuleSpecificationRepoService, "findByUuidEager")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_LCMRULES_BY_SPECID_PHASE )
		.log(LoggingLevel.INFO, log, CATALOG_GET_LCMRULES_BY_SPECID_PHASE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")	
		.bean( lcmRuleSpecificationRepoService, "findByServiceSpecificationRefIdAndPhase(${header.servicespecid}, ${header.phasename})")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
	}

}
