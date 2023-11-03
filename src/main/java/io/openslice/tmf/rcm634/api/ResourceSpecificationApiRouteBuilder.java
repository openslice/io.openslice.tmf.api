package io.openslice.tmf.rcm634.api;

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

import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;

@Configuration
//@RefreshScope
@Component
public class ResourceSpecificationApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog( ResourceSpecificationApiRouteBuilder.class.getName());
	
	@Value("${CATALOG_ADD_RESOURCESPEC}")
	private String CATALOG_ADD_RESOURCESPEC = "";
	
	@Value("${CATALOG_UPD_RESOURCESPEC}")
	private String CATALOG_UPD_RESOURCESPEC = "";
	
	@Value("${CATALOG_UPDADD_RESOURCESPEC}")
	private String CATALOG_UPDADD_RESOURCESPEC = "";
	
	@Value("${CATALOG_GET_RESOURCESPEC_BY_ID}")
	private String CATALOG_GET_RESOURCESPEC_BY_ID = "";


	@Value("${CATALOG_GET_RESOURCESPEC_BY_ΝAME_CATEGORY}")
	private String CATALOG_GET_RESOURCESPEC_BY_ΝAME_CATEGORY = "";
	
    @Autowired
    private ProducerTemplate template;

    @Autowired
    ResourceSpecificationRepoService resourceSpecificationRepoService;

	@Override
	public void configure() throws Exception {

		from( CATALOG_ADD_RESOURCESPEC )
		.log(LoggingLevel.INFO, log, CATALOG_ADD_RESOURCESPEC + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal()
		.json( JsonLibrary.Jackson, ResourceSpecificationCreate .class, true)
		.bean( resourceSpecificationRepoService, "addResourceSpecification(${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
				
		from( CATALOG_UPD_RESOURCESPEC )
		.log(LoggingLevel.INFO, log, CATALOG_UPD_RESOURCESPEC + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ResourceSpecificationUpdate.class, true)
		.bean( resourceSpecificationRepoService, "updateResourceSpecification(${header.resourceSpecId},  ${body} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( CATALOG_UPDADD_RESOURCESPEC )
		.log(LoggingLevel.INFO, log, CATALOG_UPDADD_RESOURCESPEC + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ResourceSpecificationCreate.class, true)
		.bean( resourceSpecificationRepoService, "addOrupdateResourceSpecificationByNameCategoryVersion(${header.aname}, ${header.acategory}, ${header.aversion},  ${body} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );

		from( CATALOG_GET_RESOURCESPEC_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_RESOURCESPEC_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( resourceSpecificationRepoService, "findByUuidEager")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_RESOURCESPEC_BY_ΝAME_CATEGORY )
		.log(LoggingLevel.INFO, log, CATALOG_GET_RESOURCESPEC_BY_ΝAME_CATEGORY + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( resourceSpecificationRepoService, "findByNameAndCategoryAndVersionEager(${header.aname}, ${header.acategory}, ${header.aversion} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
	}
	
}
